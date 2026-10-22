package com.bytedance.frameworks.baselib.network.http.cookie;

import android.text.TextUtils;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.keva.Keva;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class CookieMetricManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f244681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f244682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f244683c;

    /* JADX INFO: loaded from: classes19.dex */
    public static final enum RmType extends Enum<RmType> {
        public static final RmType All = null;
        public static final RmType Expired = null;
        public static final RmType Session = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RmType[] f244684a = null;

        static {
            RmType r100 = new RmType(CancelRetainContactInfoFunctions.All, 0);
            All = r100;
            RmType r101 = new RmType("Session", 1);
            Session = r101;
            RmType r102 = new RmType("Expired", 2);
            Expired = r102;
            f244684a = new RmType[]{r100, r101, r102};
        }

        public static RmType[] values() {
            return (RmType[]) f244684a.clone();
        }

        public static RmType valueOf(String r100) {
            return (RmType) r27.a.a(RmType.class, r100);
        }

        public RmType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CookieMetricManager f244685a = null;

        static {
            f244685a = new CookieMetricManager();
        }
    }

    public final JSONObject a() {
        JSONObject r100 = null;
        if ((!ix5.b.f496366e) == false) goto L6;
        return null;
    L6:
        if (this.f244682b.compareAndSet(true, false) == false) goto L49;
        Map<String, ?> r101 = this.f244681a.getAll();     // Catch: Throwable -> L45
        if (r101 != null) goto L10;
    L47:
        this.f244683c = r100;
        goto L49
    L10:
        if (r101.isEmpty() == true) goto L47;
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L45
        Iterator<Map.Entry<String, ?>> r103 = r101.entrySet().iterator();     // Catch: Throwable -> L45
    L14:
        if (r103.hasNext() == false) goto L42;
        Map.Entry<String, ?> r104 = r103.next();     // Catch: Throwable -> L45
        String r105 = r104.getKey();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r105) == true) goto L14;
        boolean r106 = r105.startsWith(";remove");     // Catch: Throwable -> L45
        if (r106 == false) goto L21;
    L50:
        String r107 = (String) r104.getValue();     // Catch: Throwable -> L31
    L34:
        if (TextUtils.isEmpty(r107) == true) goto L14;
        if (r106 == false) goto L38;
        r105 = r105.substring(1);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L45
    L38:
        r102.put(r105, new JSONObject(r107));     // Catch: Throwable -> L40
    L31:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L45
        r107 = null;
        goto L34
    L21:
        if (TextUtils.isEmpty(r105) == false) goto L23;
    L25:
        boolean r108 = false;
    L26:
        if (r108 == true) goto L50;
        this.f244681a.erase(r105);     // Catch: Throwable -> L45
        goto L14
    L23:
        if (((CopyOnWriteArraySet) ix5.b.f496368g).contains(r105) == false) goto L25;
        r108 = true;
        goto L26
    L42:
        if (r102.length() <= 0) goto L47;
        r100 = r102;
    L45:
        th = move-exception;
        th.printStackTrace();
    L49:
        return this.f244683c;
    }

    public CookieMetricManager() {
        this.f244682b = new AtomicBoolean(true);
        this.f244683c = null;
        this.f244681a = Keva.getRepo("ttnetCookieDetailRepo", 1);
    }

    public final void b(URI r110, f r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        if ((!ix5.b.f496366e) == true) goto L51;
        String r100 = r111.f244706e;
        if (TextUtils.isEmpty(r100) == false) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == false) goto L53;
        String r102 = e.c(r110);
        String r112 = r110.getPath();
        if (TextUtils.isEmpty(r111.f244709h) == false) goto L46;
        String r103 = null;
    L20:
        String r104 = r111.f244702a;
        String r105 = r111.f244707f;
        boolean r106 = r111.f244708g;
        long r107 = r111.f244704c;
        if (r107 <= 0) goto L24;
        r107 = r107 - System.currentTimeMillis();
    L24:
        long r108 = r111.f244704c;
        StringBuilder r113 = new StringBuilder("{\"r_host\":\"");
        if (r102 != null) goto L27;
        r102 = "-";
    L27:
        r113.append(r102);
        r113.append("\",\"r_path\":\"");
        if (r112 != null) goto L30;
        r112 = "-";
    L30:
        r113.append(r112);
        r113.append("\",\"v_md5\":\"");
        if (r103 != null) goto L33;
        r103 = "-";
    L33:
        r113.append(r103);
        r113.append("\",\"domain\":\"");
        if (r104 != null) goto L36;
        r104 = "-";
    L36:
        r113.append(r104);
        r113.append("\",\"path\":\"");
        if (r105 != null) goto L39;
        r105 = "-";
    L39:
        r113.append(r105);
        r113.append("\",\"sec\":");
        r113.append(r106);
        r113.append(",\"age\":");
        r113.append(r107);
        r113.append(",\"exp_t\":");
        r113.append(r108);
        r113.append(com.alipay.sdk.m.u.i.f25855d);
        String r114 = r113.toString();
        if (TextUtils.isEmpty(r114) == true) goto L52;
        this.f244681a.storeString(r111.f244706e, r114);     // Catch: Throwable -> L43
        this.f244682b.set(true);     // Catch: Throwable -> L43
        return;
    L43:
        th = move-exception;
        th.printStackTrace();
        return;
    L52:
        return;
    L46:
        r103 = ByteString.encodeUtf8(r111.f244709h).md5().hex();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        String r109 = String.valueOf(r111.f244709h.length());
        th.printStackTrace();
        r103 = r109;
        goto L20
    L53:
        return;
    L8:
        if (((CopyOnWriteArraySet) ix5.b.f496368g).contains(r100) == false) goto L10;
        r101 = true;
        goto L11
    }
}
