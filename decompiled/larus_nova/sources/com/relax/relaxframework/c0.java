package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class c0 extends p6 {
    public c0 e(int r100) {
        return this;
    }

    public c0 f(ModifierValue_AnimationProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return this;
    }

    public c0(CSSModifierProperty r100, p6 r101, RxModifierType r102, c2 r103, o1 r104) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r102, "type");
        super(r100, r101, r102, r103, r104);
    }
}
