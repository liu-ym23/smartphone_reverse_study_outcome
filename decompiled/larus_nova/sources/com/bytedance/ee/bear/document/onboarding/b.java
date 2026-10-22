package com.bytedance.ee.bear.document.onboarding;

import com.bytedance.ee.bear.document.DocumentPluginHost;

/* JADX INFO: loaded from: classes16.dex */
public abstract class b implements tk5.d<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnBoardingData f220703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DocumentPluginHost f220704b;

    public abstract boolean c(c r100, OnBoardingData r101);

    @Override // tk5.d
    public /* synthetic */ String getDependency() {
        return null;
    }

    public b() {
    }

    public b(OnBoardingData r100) {
        this.f220703a = r100;
    }

    @Override // tk5.d
    public final boolean b(vk5.c r100) {
        return c((c) r100, this.f220703a);
    }
}
