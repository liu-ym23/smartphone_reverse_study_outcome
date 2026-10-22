package so8;

import ib8.a0;
import ib8.y;
import ib8.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<j, Unit> f542781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<j, Unit> f542782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f542783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<j, Unit> f542784d;

    public s(y r100, z r101, a0 r102, ib8.p r103) {
        Intrinsics.checkNotNullParameter(r100, "onZoomInAnimationStart");
        Intrinsics.checkNotNullParameter(r101, "onZoomOutAnimationEnd");
        Intrinsics.checkNotNullParameter(r102, "onZoomInUpdate");
        Intrinsics.checkNotNullParameter(r103, "onZoomInRefresh");
        this.f542781a = r100;
        this.f542782b = r101;
        this.f542783c = r102;
        this.f542784d = r103;
    }
}
