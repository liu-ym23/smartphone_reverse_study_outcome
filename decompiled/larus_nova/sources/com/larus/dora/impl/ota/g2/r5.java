package com.larus.dora.impl.ota.g2;

import com.facebook.keyframes.model.KFFeature;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class r5 {
    private final List<q> effects;
    private final b5 state;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r5) == true) goto L8;
        return false;
    L8:
        r5 r101 = (r5) r100;
        if (Intrinsics.areEqual(this.state, r101.state) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.effects, r101.effects) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.state.hashCode() * 31) + this.effects.hashCode();
    }

    public final String toString() {
        return "Transition(state=" + this.state + ", effects=" + this.effects + ')';
    }

    public final List<q> b() {
        return this.effects;
    }

    public final b5 c() {
        return this.state;
    }

    public /* synthetic */ r5(b5 r100) {
        this(r100, CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r5(b5 r100, List<? extends q> r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, KFFeature.EFFECT_JSON_FIELD);
        this.state = r100;
        this.effects = r101;
    }

    public static r5 a(r5 r100, List r101) {
        b5 r102 = r100.state;
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r101, KFFeature.EFFECT_JSON_FIELD);
        return new r5(r102, r101);
    }
}
