package com.larus.camera.impl.ui.component.capture.edu;

import com.larus.camera.impl.widget.title.TitleRightIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class h0 implements Function1<TitleRightIconView, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f321918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f321919b;

    public h0(c0 r100, Ref.ObjectRef<Function0<Unit>> r101) {
        this.f321918a = r100;
        this.f321919b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(TitleRightIconView r100) {
        TitleRightIconView r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$updateRightIcon");
        r101.setIcon(new d0(this.f321918a));
        r101.setHint(new g0(this.f321918a, this.f321919b));
        return Unit.INSTANCE;
    }
}
