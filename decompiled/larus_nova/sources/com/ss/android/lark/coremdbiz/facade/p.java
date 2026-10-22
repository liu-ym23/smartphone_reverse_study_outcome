package com.ss.android.lark.coremdbiz.facade;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class p {
    static {
    }

    @JvmStatic
    public static final boolean a() {
        return !FeatureGatingModule.getFeatureGatingService().isEnable("im.thread.loading_opt.reverse", false);
    }
}
