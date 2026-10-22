package com.bytedance.ee.bear.bitable.app.chameleon;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f206902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f206903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<d, Unit> f206904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<d, Unit> f206905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f206906e;

    public b(Object r100, ChameleonBaseAppUIAbility r101, Function1 r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "uiContainer");
        Intrinsics.checkNotNullParameter(r101, "ability");
        Intrinsics.checkNotNullParameter(r102, "registerHostAbility");
        Intrinsics.checkNotNullParameter(r103, "unregisterHostAbility");
        this.f206902a = r100;
        this.f206903b = r101;
        this.f206904c = r102;
        this.f206905d = r103;
    }
}
