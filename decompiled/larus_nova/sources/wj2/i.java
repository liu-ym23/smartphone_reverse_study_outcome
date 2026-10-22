package wj2;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f559979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f559980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f559981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f559982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f559983e;

    public i(Function0<Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onScrollStart");
        Intrinsics.checkNotNullParameter(r101, "onScrollEnd");
        this.f559982d = r100;
        this.f559983e = r101;
        this.f559979a = -1;
        this.f559981c = -1;
    }
}
