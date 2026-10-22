package com.larus.camera.impl.ui.component.capture.edu;

import com.larus.camera.impl.widget.title.TitleRightIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class a0 implements Function1<TitleRightIconView, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f321899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f321900b;

    public a0(c0 r100, Ref.ObjectRef<Function0<Unit>> r101) {
        this.f321899a = r100;
        this.f321900b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(TitleRightIconView r100) {
        TitleRightIconView r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$updateRightIcon");
        r101.setHint(new z(this.f321899a, this.f321900b));
        return Unit.INSTANCE;
    }
}
