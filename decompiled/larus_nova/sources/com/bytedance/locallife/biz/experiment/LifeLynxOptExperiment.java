package com.bytedance.locallife.biz.experiment;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class LifeLynxOptExperiment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.locallife.biz.plugin.d f256644a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f256645b = null;

    static {
        f256644a = new com.bytedance.locallife.biz.plugin.d(0);
        f256645b = LazyKt.lazy(LifeLynxOptExperiment$curExperimentVal$2.INSTANCE);
    }

    public static com.bytedance.locallife.biz.plugin.d a() {
        return (com.bytedance.locallife.biz.plugin.d) f256645b.getValue();
    }
}
