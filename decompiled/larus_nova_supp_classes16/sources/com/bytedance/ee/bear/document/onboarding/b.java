package com.bytedance.ee.bear.document.onboarding;

import com.bytedance.ee.bear.document.DocumentPluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b implements tk5.d<c> {
    public OnBoardingData a;
    public DocumentPluginHost b;

    public abstract boolean c(c r1, OnBoardingData r2);

    public /* synthetic */ String getDependency() {
        return null;
    }

    public b() {
    }

    public b(OnBoardingData r1) {
        this.a = r1;
    }

    public final boolean b(vk5.c r2) {
        return c((c) r2, this.a);
    }
}
