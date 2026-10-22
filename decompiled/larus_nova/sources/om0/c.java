package om0;

import com.bytedance.crash.d;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f524232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f524233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f524234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f524235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f524236e = null;

    public c() {
    }

    static {
        f524236e = new c();
    }

    public static boolean a() {
        if (f524235d == true) goto L6;
        d.d(new RuntimeException("LiveMiddleLayerSDK host failed"), "LiveMiddleLayerSDK  host failed");
    L6:
        return f524235d;
    }

    public static boolean b() {
        if (f524233b == true) goto L6;
        d.d(new RuntimeException("LiveMiddleLayerSDK live failed"), "LiveMiddleLayerSDK live failed");
    L6:
        return f524233b;
    }

    @JvmStatic
    public static final pm0.a c() {
        if (a() == false) goto L9;
        a r100 = f524234c;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L8:
        return r100.f524222a;
    L9:
        return null;
    }

    @JvmStatic
    public static final qm0.a d() {
        if (a() == false) goto L9;
        a r100 = f524234c;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L8:
        return r100.f524223b;
    L9:
        return null;
    }

    @JvmStatic
    public static final rm0.a e() {
        if (a() == false) goto L9;
        a r100 = f524234c;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L8:
        return r100.f524227f;
    L9:
        return null;
    }

    @JvmStatic
    public static final pm0.b f() {
        if (b() == false) goto L9;
        b r100 = f524232a;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMiddleLayer");
    L8:
        return r100.f524228a;
    L9:
        return null;
    }

    @JvmStatic
    public static final qm0.b g() {
        if (b() == false) goto L9;
        b r100 = f524232a;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMiddleLayer");
    L8:
        return r100.f524229b;
    L9:
        return null;
    }

    @JvmStatic
    public static final wm0.a h() {
        if (b() == false) goto L9;
        b r100 = f524232a;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMiddleLayer");
    L8:
        return r100.f524230c;
    L9:
        return null;
    }

    @JvmStatic
    public static final um0.a i() {
        if (b() == false) goto L9;
        b r100 = f524232a;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMiddleLayer");
    L8:
        return r100.f524231d;
    L9:
        return null;
    }

    @JvmStatic
    public static final wm0.b j() {
        if (a() == false) goto L9;
        a r100 = f524234c;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L8:
        return r100.f524224c;
    L9:
        return null;
    }

    @JvmStatic
    public static final vm0.a k() {
        if (a() == false) goto L9;
        a r100 = f524234c;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mHostMiddleLayer");
    L8:
        return r100.f524225d;
    L9:
        return null;
    }
}
