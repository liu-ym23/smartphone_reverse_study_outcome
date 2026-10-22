package com.bytedance.locallife.poi.experiment;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiBigFontExperiment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f262560a = null;

    static {
        f262560a = LazyKt.lazy(LazyThreadSafetyMode.NONE, PoiBigFontExperiment$value$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a() {
        if (((Number) f262560a.getValue()).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
