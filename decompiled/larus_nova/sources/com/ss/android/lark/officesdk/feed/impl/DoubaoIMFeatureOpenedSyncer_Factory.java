package com.ss.android.lark.officesdk.feed.impl;

import android.app.Application;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class DoubaoIMFeatureOpenedSyncer_Factory implements Factory<a> {
    private final Provider<Application> applicationProvider;
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.rustClientProvider.get(), this.applicationProvider.get(), this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DoubaoIMFeatureOpenedSyncer_Factory(Provider<l> r100, Provider<Application> r101, Provider<m> r102) {
        this.rustClientProvider = r100;
        this.applicationProvider = r101;
        this.passportProvider = r102;
    }

    public static DoubaoIMFeatureOpenedSyncer_Factory create(Provider<l> r100, Provider<Application> r101, Provider<m> r102) {
        return new DoubaoIMFeatureOpenedSyncer_Factory(r100, r101, r102);
    }

    public static a newInstance(l r100, Application r101, m r102) {
        return new a(r100, r101, r102);
    }
}
