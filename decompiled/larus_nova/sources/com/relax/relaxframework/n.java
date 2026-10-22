package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class n extends p6 {
    public n e() {
        return this;
    }

    public n f(int r100) {
        return this;
    }

    public n g(ModifierValue_AnimationFillMode r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return this;
    }

    public n h(int r100) {
        return this;
    }

    public n i(ModifierValue_AnimationIterationCount r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return this;
    }

    public n j(ArrayList<t1> r100) {
        Intrinsics.checkNotNullParameter(r100, "keyframes");
        return this;
    }

    public n k(h8 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return this;
    }

    public n(CSSModifierProperty r100, p6 r101, RxModifierType r102, c2 r103, o1 r104) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r102, "type");
        super(r100, r101, r102, r103, r104);
    }
}
