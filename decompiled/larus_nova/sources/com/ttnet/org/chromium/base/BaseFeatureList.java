package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
@MainDex
public final class BaseFeatureList {

    public interface Natives {
        boolean isEnabled(String r100);
    }

    private BaseFeatureList() {
    }

    public static boolean isEnabled(String r100) {
        return BaseFeatureListJni.get().isEnabled(r100);
    }
}
