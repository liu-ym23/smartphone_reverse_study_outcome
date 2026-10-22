package s1;

import android.content.Context;
import com.apm.lite.CrashType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile f f540109e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f540110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<CrashType, d> f540111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f540112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f540113d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f540114a = null;

        static {
            int[] r100 = new int[CrashType.values().length];
            f540114a = r100;
            r100[CrashType.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f540114a[CrashType.LAUNCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f540114a[CrashType.NATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f540114a[CrashType.ANR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f540114a[CrashType.DART.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f540114a[CrashType.ENSURE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public f(Context r100) {
        this.f540111b = new HashMap();
        this.f540110a = r100;
        this.f540112c = c.c();     // Catch: Throwable -> L5
        this.f540113d = new e();     // Catch: Throwable -> L5
        return;
    L5:
        com.apm.lite.c.a();
    }

    public final d a(CrashType r100) {
        d r101 = (d) ((HashMap) this.f540111b).get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        switch(a.f540114a[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L14;
        };
    L8:
        r101 = new h(this.f540110a, this.f540112c, this.f540113d);
        goto L14
    L9:
        r101 = new g(this.f540110a, this.f540112c, this.f540113d);
        goto L14
    L10:
        r101 = new s1.a(this.f540110a, this.f540112c, this.f540113d);
        goto L14
    L11:
        r101 = new k(this.f540110a, this.f540112c, this.f540113d);
        goto L14
    L12:
        r101 = new j(this.f540110a, this.f540112c, this.f540113d);
        goto L14
    L13:
        r101 = new i(this.f540110a, this.f540112c, this.f540113d);
    L14:
        if (r101 == null) goto L16;
        ((HashMap) this.f540111b).put(r100, r101);
    L16:
        return r101;
    }

    public static f b() {
        if (f540109e != null) goto L10;
        Context r100 = com.apm.lite.e.f29909a;
        if (r100 == null) goto L8;
        f540109e = new f(r100);
        goto L10
    L8:
        throw new IllegalArgumentException("NpthBus not init");
    L10:
        return f540109e;
    }
}
