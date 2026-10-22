package com.larus.photopicker.v2.impl;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
public final class u0 implements Function0<ViewModelProvider.Factory> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f364600a;

    public u0(Fragment r100) {
        this.f364600a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return this.f364600a.getDefaultViewModelProviderFactory();
    }
}
