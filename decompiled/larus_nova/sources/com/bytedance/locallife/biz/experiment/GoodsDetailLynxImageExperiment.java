package com.bytedance.locallife.biz.experiment;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class GoodsDetailLynxImageExperiment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f256643a = null;

    static {
        f256643a = LazyKt.lazy(GoodsDetailLynxImageExperiment$experimentValue$2.INSTANCE);
    }

    public static int a() {
        return ((Number) f256643a.getValue()).intValue();
    }
}
