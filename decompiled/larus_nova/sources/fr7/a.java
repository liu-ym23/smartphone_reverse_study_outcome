package fr7;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import hr7.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f478612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f478613d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, C5945a> f478614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f478615b;

    /* JADX INFO: renamed from: fr7.a$a, reason: collision with other inner class name */
    public static class C5945a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f478616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f478617b;

        public C5945a(c r100) {
            this.f478616a = System.currentTimeMillis();
            this.f478617b = r100;
        }
    }

    public static a a() {
        if (f478613d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f478613d != null) goto L9;
        f478613d = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f478613d;
    }

    public a() {
        this.f478614a = new ConcurrentHashMap();
        SharedPreferences r100 = cr7.a.getContext().getSharedPreferences("sec_config", 0);
        this.f478615b = r100;
        f478612c = r100.getLong("valid_time", 900000);
    }

    public final boolean c(String r100) {
        C5945a r101 = (C5945a) ((ConcurrentHashMap) this.f478614a).get(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if ((System.currentTimeMillis() - r101.f478616a) > f478612c) goto L15;
        return true;
    L15:
        ((ConcurrentHashMap) this.f478614a).remove(r100);     // Catch: Exception -> L10
        ((ConcurrentHashMap) this.f478614a).remove(r100 + HTTP.URL_DEFAULT);     // Catch: Exception -> L10
    L12:
        return false;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public final c b(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L37;
        r101 = r100 + "_" + r101;
    L37:
        boolean r102 = c(r101);     // Catch: Exception -> L33
        if (r101.length() <= 0) goto L8;
        boolean r103 = c(r101.substring(0, r101.length() - 1));     // Catch: Exception -> L33
    L9:
        boolean r104 = c(r101.concat(HTTP.URL_DEFAULT));     // Catch: Exception -> L33
        if (r102 == true) goto L15;
        if (r103 == true) goto L15;
        if (r104 == true) goto L15;
        boolean r105 = false;
    L16:
        if (r105 == false) goto L38;
        C5945a r106 = (C5945a) ((ConcurrentHashMap) this.f478614a).get(r101);     // Catch: Exception -> L33
        if (r106 == null) goto L22;
        return r106.f478617b;
    L22:
        if (r101.length() <= 0) goto L28;
        C5945a r107 = (C5945a) ((ConcurrentHashMap) this.f478614a).get(r101.substring(0, r101.length() - 1));     // Catch: Exception -> L33
        if (r107 == null) goto L28;
        return r107.f478617b;
    L28:
        if (r101.length() <= 0) goto L39;
        C5945a r108 = (C5945a) ((ConcurrentHashMap) this.f478614a).get(r101.concat(HTTP.URL_DEFAULT));     // Catch: Exception -> L33
        if (r108 != null) goto L32;
        return null;
    L32:
        return r108.f478617b;
    L39:
        return null;
    L38:
        return null;
    L15:
        r105 = true;
        goto L16
    L8:
        r103 = false;
    L33:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final void d(String r100, String r101, c r102) {
        Map<String, C5945a> r103 = this.f478614a;     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r101 = r100 + "_" + r101;     // Catch: Exception -> L7
    L5:
        ((ConcurrentHashMap) r103).put(r101, new C5945a(r102));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
