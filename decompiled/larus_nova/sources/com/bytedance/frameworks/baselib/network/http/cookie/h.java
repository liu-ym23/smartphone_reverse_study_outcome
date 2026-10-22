package com.bytedance.frameworks.baselib.network.http.cookie;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.http.impl.SerializableHttpCookie;
import com.bytedance.keva.Keva;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f244715f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f244716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.a f244717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<a, Set<f>> f244718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReadWriteLock f244719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f244720e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f244721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f244722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f244723c;

        public final int hashCode() {
            String r100 = this.f244721a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 * 31) + 17;
            String r104 = this.f244722b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return (r103 + (r101 * 31)) + ((this.f244723c ? 1 : 0) * 31);
        L5:
            r102 = r100.toLowerCase(Locale.US).hashCode();
            goto L6
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L25:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L25;
            a r101 = (a) r100;
            if (this.f244723c == r101.f244723c) goto L13;
            return false;
        L13:
            String r102 = this.f244721a;
            String r103 = null;
            if (r102 == null) goto L16;
            String r104 = r102.toLowerCase(Locale.US);
        L17:
            String r105 = r101.f244721a;
            if (r105 == null) goto L21;
            r103 = r105.toLowerCase(Locale.US);
        L21:
            if (Objects.equals(r104, r103) == true) goto L24;
            return false;
        L24:
            return Objects.equals(this.f244722b, r101.f244722b);
        L16:
            r104 = null;
            goto L17
        }

        public a(String r100, String r101, boolean r102) {
            this.f244721a = r100;
            this.f244722b = r101;
            this.f244723c = r102;
        }
    }

    public final void c() {
        Map<String, ?> r100 = this.f244716a.getAll();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L85;
        Iterator<Map.Entry<String, ?>> r101 = r100.entrySet().iterator();
        boolean r102 = false;
    L9:
        if (r101.hasNext() == false) goto L60;
        Map.Entry<String, ?> r103 = r101.next();
        if (r103 == null) goto L9;
        Object r104 = r103.getValue();
        if (r104 == null) goto L9;
        String r105 = r103.getKey();
        if (TextUtils.isEmpty(r105) == true) goto L18;
        String[] r106 = r105.split("\\|", -1);     // Catch: Throwable -> L57
        if (r106.length != 4) goto L21;
        SerializableHttpCookie r107 = null;
        if (r106[0].isEmpty() == false) goto L25;
        String r108 = null;
    L27:
        if (r106[1].isEmpty() == false) goto L29;
        String r110 = null;
    L31:
        if (r106[2].isEmpty() == false) goto L33;
        String r111 = null;
    L35:
        if (r106[3].isEmpty() == false) goto L37;
    L39:
        boolean r109 = false;
    L41:
        if (TextUtils.isEmpty(r108) == true) goto L55;
        if (TextUtils.isEmpty(r111) == true) goto L55;
        r107 = SerializableHttpCookie.decode(r108, r110, r111, r109, (byte[]) r104);     // Catch: Throwable -> L47
    L49:
        if (r107 == null) goto L50;
        a r112 = new a(r108, r110, r109);     // Catch: Throwable -> L57
        Set<f> r113 = this.f244718c.get(r112);     // Catch: Throwable -> L57
        if (r113 != null) goto L54;
        r113 = new HashSet();     // Catch: Throwable -> L57
        this.f244718c.put(r112, r113);     // Catch: Throwable -> L57
    L54:
        r113.add(r107.getHttpCookie());     // Catch: Throwable -> L57
        goto L9
    L50:
        this.f244716a.erase(r105);     // Catch: Throwable -> L57
        goto L18
    L47:
        th = move-exception;
        Logger.e("PersistentCookieStore", "decode cookie error, name=" + r111, th);     // Catch: Throwable -> L57
    L55:
        this.f244716a.erase(r105);     // Catch: Throwable -> L57
        goto L18
    L37:
        if ("1".equalsIgnoreCase(r106[3]) == false) goto L39;
        r109 = true;
        goto L41
    L33:
        r111 = r106[2];     // Catch: Throwable -> L57
        goto L35
    L29:
        r110 = r106[1];     // Catch: Throwable -> L57
        goto L31
    L25:
        r108 = r106[0];     // Catch: Throwable -> L57
        goto L27
    L21:
        this.f244716a.erase(r105);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        Logger.e("PersistentCookieStore", "load cookie error, kevaStoreKey=" + r105, th);
    L18:
        r102 = true;
        goto L9
    L60:
        if (this.f244718c.isEmpty() == true) goto L83;
        if (r102 == true) goto L84;
        this.f244720e = true;
        return;
    L84:
        return;
    L83:
        return;
    }

    public h() {
        this.f244717b = d.f244698a;
        this.f244718c = new LinkedHashMap();
        this.f244719d = new ReentrantReadWriteLock();
        this.f244720e = false;
        this.f244716a = Keva.getRepo("ttnetKevaCookieStorage", 1);
        c();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.e("PersistentCookieStore", "loadAllFromKeva error", th);
    }

    public static String b(f r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.f244702a);
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r101.append(r100.f244707f);
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r101.append(r100.f244706e);
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        if (r100.f244703b == false) goto L5;
        String r102 = "1";
    L6:
        r101.append(r102);
        return r101.toString();
    L5:
        r102 = "0";
        goto L6
    }

    public final boolean e(f r100) {
        long r101 = r100.f244704c;
        if (r101 < 0) goto L5;
    L8:
        a r102 = new a(r100.f244702a, r100.f244707f, r100.f244703b);
        ((ReentrantReadWriteLock) this.f244719d).writeLock().lock();
        String r103 = b(r100);     // Catch: Throwable -> L24
        if (r100.c() == false) goto L12;
        this.f244716a.erase(r103);     // Catch: Throwable -> L24
    L15:
        Set<f> r104 = (Set) ((LinkedHashMap) this.f244718c).get(r102);     // Catch: Throwable -> L24
        if (r104 != null) goto L18;
        r104 = new HashSet();     // Catch: Throwable -> L24
        this.f244718c.put(r102, r104);     // Catch: Throwable -> L24
    L20:
        if (r100.c() == true) goto L22;
        r104.add(r100);     // Catch: Throwable -> L24
    L22:
        ((ReentrantReadWriteLock) this.f244719d).writeLock().unlock();
        return true;
    L18:
        r104.remove(r100);     // Catch: Throwable -> L24
        goto L20
    L12:
        byte[] r105 = new SerializableHttpCookie(r100).encode();     // Catch: Throwable -> L24
        if (r105 == null) goto L15;
        this.f244716a.storeBytes(r103, r105);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f244719d).writeLock().unlock();
        throw th;
    L5:
        if (r101 == (-1)) goto L8;
        return false;
    }

    public final String a(URI r110, g r111) {
        if (r110 != null) goto L5;
        return null;
    L5:
        String r100 = e.c(r110);
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        ArrayList r101 = new ArrayList();
        ((ReentrantReadWriteLock) this.f244719d).readLock().lock();
        Iterator r102 = ((LinkedHashMap) this.f244718c).entrySet().iterator();     // Catch: Throwable -> L114
        HashSet r103 = null;
    L10:
        boolean r104 = true;
        if (r102.hasNext() == false) goto L68;
        Map.Entry r105 = (Map.Entry) r102.next();     // Catch: Throwable -> L114
        a r106 = (a) r105.getKey();     // Catch: Throwable -> L114
        Set r107 = (Set) r105.getValue();     // Catch: Throwable -> L114
        if (r107 == null) goto L10;
        if (r107.isEmpty() == true) goto L10;
        if (e.b(r100, r106.f244721a, r106.f244723c) == false) goto L10;
        String r108 = r106.f244722b;     // Catch: Throwable -> L114
        String r112 = r110.getPath();     // Catch: Throwable -> L114
        if (TextUtils.isEmpty(r108) == false) goto L24;
        r108 = HTTP.URL_DEFAULT;
    L24:
        if (TextUtils.isEmpty(r112) == false) goto L27;
        r112 = HTTP.URL_DEFAULT;
    L27:
        if (r108.equals(r112) == false) goto L30;
    L38:
        boolean r109 = true;
    L40:
        if (r109 == false) goto L10;
        Iterator r113 = r107.iterator();     // Catch: Throwable -> L114
    L44:
        if (r113.hasNext() == false) goto L10;
        f r114 = (f) r113.next();     // Catch: Throwable -> L114
        if (r114 == null) goto L44;
        if (r114.c() == true) goto L50;
        if (r114.f244708g == true) goto L56;
    L59:
        boolean r115 = true;
    L60:
        if (r115 == false) goto L44;
        r101.add(r114.toString());     // Catch: Throwable -> L114
        if (r111 == null) goto L44;
        Map r116 = r111.f244714a;     // Catch: Throwable -> L114
        Set r117 = (Set) r116.get(r114.toString());     // Catch: Throwable -> L114
        if (r117 != null) goto L66;
        r117 = new HashSet();     // Catch: Throwable -> L114
        r116.put(r114.toString(), r117);     // Catch: Throwable -> L114
    L66:
        r117.add((f) r114.clone());     // Catch: Throwable -> L114
        goto L44
    L56:
        if ("https".equalsIgnoreCase(r110.getScheme()) == true) goto L59;
        r115 = false;
        goto L60
    L50:
        if (r103 != null) goto L52;
        r103 = new HashSet();     // Catch: Throwable -> L114
    L52:
        r103.add(r106);     // Catch: Throwable -> L114
        goto L44
    L30:
        if (r112.startsWith(r108) == true) goto L32;
    L39:
        r109 = false;
        goto L40
    L32:
        if (r108.endsWith(HTTP.URL_DEFAULT) == true) goto L38;
        if (r112.length() <= r108.length()) goto L39;
        if (r112.charAt(r108.length()) != '/') goto L39;
    L68:
        ((ReentrantReadWriteLock) this.f244719d).readLock().unlock();
        if (CollectionUtils.isEmpty(r103) == true) goto L103;
        ((ReentrantReadWriteLock) this.f244719d).writeLock().lock();
        Iterator r118 = r103.iterator();     // Catch: Throwable -> L99
        HashSet r119 = null;
    L72:
        if (r118.hasNext() == false) goto L98;
        Set r120 = (Set) ((LinkedHashMap) this.f244718c).get((a) r118.next());     // Catch: Throwable -> L99
        if (CollectionUtils.isEmpty(r120) == true) goto L72;
        Iterator r121 = r120.iterator();     // Catch: Throwable -> L99
    L79:
        if (r121.hasNext() == false) goto L88;
        f r122 = (f) r121.next();     // Catch: Throwable -> L99
        if (r122 == null) goto L79;
        if (r122.c() == false) goto L79;
        if (r119 != null) goto L86;
        r119 = new HashSet();     // Catch: Throwable -> L99
    L86:
        r119.add(r122);     // Catch: Throwable -> L99
        goto L79
    L88:
        if (CollectionUtils.isEmpty(r119) == true) goto L72;
        if (CollectionUtils.isEmpty(r119) == true) goto L96;
        Iterator r123 = r119.iterator();     // Catch: Throwable -> L99
    L94:
        if (r123.hasNext() == false) goto L96;
        this.f244716a.erase(b((f) r123.next()));     // Catch: Throwable -> L99
    L96:
        r120.removeAll(r119);     // Catch: Throwable -> L99
        r119.clear();     // Catch: Throwable -> L99
        goto L72
    L98:
        ((ReentrantReadWriteLock) this.f244719d).writeLock().unlock();
    L99:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f244719d).writeLock().unlock();
        throw th;
    L103:
        if (r101.isEmpty() == true) goto L169;
        StringBuilder r124 = new StringBuilder();
        Iterator r125 = r101.iterator();
    L107:
        if (r125.hasNext() == false) goto L113;
        String r126 = (String) r125.next();
        if (r104 == true) goto L110;
        r124.append("; ");
        r124.append(r126);
        goto L107
    L110:
        r124.append(r126);
        r104 = false;
        goto L107
    L113:
        return r124.toString();
    L169:
        return null;
    L114:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f244719d).readLock().unlock();
        throw th;
    }

    public final boolean d(URI r100, String r101) {
        if (r100 != null) goto L5;
    L45:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L45;
        f r102 = f.d(r100, r101);     // Catch: Throwable -> L9
    L11:
        if (r102 != null) goto L14;
        return false;
    L14:
        if (r102.f244703b == true) goto L48;
        this.f244717b.getClass();
        String r103 = r102.f244702a;
        String r104 = e.c(r100);
        if (TextUtils.isEmpty(r103) == false) goto L18;
    L36:
        boolean r105 = false;
    L37:
        if (r105 == true) goto L48;
        return false;
    L18:
        if (TextUtils.isEmpty(r104) == true) goto L36;
        Locale r106 = Locale.US;
        String r107 = r104.toLowerCase(r106);
        String r108 = r103.toLowerCase(r106);
        r105 = true;
        if (r108.startsWith(".") == false) goto L24;
        r108 = r108.substring(1);
    L24:
        if (r107.equals(r108) == true) goto L37;
        int r109 = r108.indexOf(46);
        if (r109 == (-1)) goto L32;
        if (r109 == 0) goto L32;
        if (r109 >= (r108.length() - 1)) goto L32;
    L33:
        if (r105 == false) goto L36;
        r105 = r107.endsWith(".".concat(r108));
    L32:
        r105 = false;
    L48:
        CookieMetricManager.a.f244685a.b(r100, r102);     // Catch: Throwable -> L41
    L44:
        return e(r102);
    L41:
        th = move-exception;
        th.printStackTrace();
    L9:
        th = move-exception;
        Logger.e("PersistentCookieStore", "parse cookie error, setCookieLine=" + r101 + ", uri=" + r100, th);
        r102 = null;
        goto L11
    }
}
