package com.larus.camera.impl.ui.component.capture.edu;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class s implements Function1<TextView, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f321935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> f321936b;

    public s(c0 r100, Ref.ObjectRef<Function0<Unit>> r101) {
        this.f321935a = r100;
        this.f321936b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(TextView r100) {
        TextView r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$setHint");
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, View.ALPHA, new float[]{1.0f, 0.0f});
        c0 r103 = this.f321935a;
        Ref.ObjectRef<Function0<Unit>> r104 = this.f321936b;
        r102.setStartDelay(500);
        r102.setDuration(300);
        Intrinsics.checkNotNull(r102);
        r102.addListener(new r(r104));
        r102.addListener(new q(r104));
        com.larus.camera.impl.utils.h r105 = r103.f321902n;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "animator");
        r105.f322774a.add(r102);
        r102.start();
        return Unit.INSTANCE;
    }
}
