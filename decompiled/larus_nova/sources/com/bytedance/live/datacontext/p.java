package com.bytedance.live.datacontext;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class p<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f255088a;

    public p(V r100) {
        this.f255088a = r100;
    }

    public final V a(DataContext r100, KProperty<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return this.f255088a;
    }
}
