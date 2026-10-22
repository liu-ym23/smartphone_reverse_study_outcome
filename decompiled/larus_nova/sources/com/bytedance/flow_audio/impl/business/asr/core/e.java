package com.bytedance.flow_audio.impl.business.asr.core;

import com.facebook.keyframes.model.KFFeature;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f243927a;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f243927a, ((e) r100).f243927a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f243927a.hashCode();
    }

    public final String toString() {
        return "FlowAsrEventDecision(effects=" + this.f243927a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(List<? extends a> r100) {
        Intrinsics.checkNotNullParameter(r100, KFFeature.EFFECT_JSON_FIELD);
        this.f243927a = r100;
    }

    public /* synthetic */ e(int r100) {
        this(CollectionsKt.emptyList());
    }
}
