package com.larus.camera.impl.ui.component.capture.edu;

import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class g0 implements Function1<TextView, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f321915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f321916b;

    public g0(c0 r100, Ref.ObjectRef<Function0<Unit>> r101) {
        this.f321915a = r100;
        this.f321916b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(TextView r100) {
        TextView r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$setHint");
        this.f321915a.v(r101, new f0(this.f321916b));
        return Unit.INSTANCE;
    }
}
