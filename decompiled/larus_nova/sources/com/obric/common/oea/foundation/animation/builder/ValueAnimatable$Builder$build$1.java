package com.obric.common.oea.foundation.animation.builder;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ValueAnimatable$Builder$build$1 extends MutablePropertyReference0Impl {
    public ValueAnimatable$Builder$build$1(d.a r100) {
        super(r100, d.a.class, "valueAnimationCommand", "getValueAnimationCommand()Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        dja.a<?> r100 = ((d.a) this.receiver).f396381c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("valueAnimationCommand");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        dja.a<?> r101 = (dja.a) r100;
        ((d.a) this.receiver).f396381c = r101;
    }
}
