package com.larus.bmhome.chat.component.bottom;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class o1<D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1a.b f300290a;

    public o1(ComponentFeature r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        this.f300290a = s1a.d.a(r100);
    }

    public static Lazy a(final o1 r100, final Class r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        final t1a.a r102 = null;
        return LazyKt.lazy(new m1(r100, r101, r102));
    }
}
