package n4a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile b f517979a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z4 f517980a = null;

        static {
            f517980a = new z4();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f517981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f517982b;

        public b() {
            this.f517981a = 0;
            this.f517982b = true;
        }
    }

    public final boolean b() {
        if (this.f517979a != null) goto L5;
        this.f517979a = new b();
    L5:
        b r100 = this.f517979a;
        r100.getClass();
        if (Build.VERSION.SDK_INT < 28) goto L8;
        boolean r101 = true;
    L10:
        if (r100.f517982b == false) goto L20;
        int r102 = r100.f517981a;
        if (r102 > 0) goto L14;
        r102 = 28;
    L14:
        if (r102 < 28) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L20;
        boolean r104 = false;
    L21:
        if (r101 == false) goto L24;
        if (r104 == false) goto L24;
        return true;
    L24:
        return false;
    L16:
        r103 = false;
    L20:
        r104 = true;
        goto L21
    L8:
        r101 = false;
        goto L10
    }

    public z4() {
        this.f517979a = new b();
        String r100 = "HttpsDecisionUtil";
        if (TextUtils.isDigitsOnly("HttpsDecisionUtil") == false) goto L5;
        r100 = "SPUtil";
    L5:
        b5.a(r100);
    }

    public final void a(Context r100) {
        if (this.f517979a != null) goto L5;
        this.f517979a = new b();
    L5:
        b r101 = this.f517979a;
        r101.f517982b = y.i(r100, "a3", true);
        b r102 = this.f517979a;
        if (r100 != null) goto L9;
        r102.getClass();
    L11:
        d r103 = d.a(r100);
        monitor-enter(r103);
        if (x4.f517928e != null) goto L18;
        String r104 = i.f517363b;     // Catch: Throwable -> L20
        h r105 = new h();     // Catch: Throwable -> L20
        if (x4.f517928e != null) goto L18;
        x4.f517928e = r105;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r103);
        return;
    L9:
        if (r102.f517981a > 0) goto L11;
        r102.f517981a = r100.getApplicationContext().getApplicationInfo().targetSdkVersion;
        goto L11
    }
}
