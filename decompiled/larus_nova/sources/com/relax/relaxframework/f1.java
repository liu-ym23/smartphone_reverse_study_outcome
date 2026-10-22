package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f1 extends ModifierCreator {
    public f1(p6 r100) {
        Intrinsics.checkNotNullParameter(r100, "modifier");
        super(r100);
    }

    @Override // com.relax.relaxframework.ModifierCreator
    public final p6 f(CSSModifierProperty r100, RxModifierType r101, c2 r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "valueRouter");
        return new g1(r100, i(), r101, r102);
    }
}
