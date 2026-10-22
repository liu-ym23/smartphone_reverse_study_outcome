package fba;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy<Boolean> f476293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy<Boolean> f476294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy<Boolean> f476295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy<Boolean> f476296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy<Boolean> f476297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy<Integer> f476298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy<Boolean> f476299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy<Boolean> f476300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy<Boolean> f476301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy<Boolean> f476302j;

    public static void a(StringBuilder r100, String r101, Lazy r102) {
        if (r102.isInitialized() == true) goto L6;
        return;
    L6:
        if (r100.length() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r100.append(' ');
    L11:
        r100.append(r101);
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        r100.append(r102.getValue());
        return;
    L8:
        r103 = false;
        goto L9
    }

    public b(o r100, p r101, d r102, e r103, f r104, g r105, h r106, i r107, j r110, k r111) {
        Intrinsics.checkNotNullParameter(r100, "isScreenInteractiveProvider");
        Intrinsics.checkNotNullParameter(r101, "aiKeyEnabledWhenScreenOffProvider");
        Intrinsics.checkNotNullParameter(r102, "isLandscapeProvider");
        Intrinsics.checkNotNullParameter(r103, "isKeyguardLockedProvider");
        Intrinsics.checkNotNullParameter(r104, "isDeviceLockedProvider");
        Intrinsics.checkNotNullParameter(r105, "audioModeProvider");
        Intrinsics.checkNotNullParameter(r106, "hasRecordAudioPermissionProvider");
        Intrinsics.checkNotNullParameter(r107, "isMicInUseByOtherPackageProvider");
        Intrinsics.checkNotNullParameter(r110, "isNetworkAvailableProvider");
        Intrinsics.checkNotNullParameter(r111, "canDrawOverlaysProvider");
        LazyThreadSafetyMode r108 = LazyThreadSafetyMode.NONE;
        this.f476293a = LazyKt.lazy(r108, r100);
        this.f476294b = LazyKt.lazy(r108, r101);
        this.f476295c = LazyKt.lazy(r108, r102);
        this.f476296d = LazyKt.lazy(r108, r103);
        this.f476297e = LazyKt.lazy(r108, r104);
        this.f476298f = LazyKt.lazy(r108, r105);
        this.f476299g = LazyKt.lazy(r108, r106);
        this.f476300h = LazyKt.lazy(r108, r107);
        this.f476301i = LazyKt.lazy(r108, r110);
        this.f476302j = LazyKt.lazy(r108, r111);
    }
}
