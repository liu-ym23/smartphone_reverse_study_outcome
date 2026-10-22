package com.bytedance.ee.bear.onboarding.interfaces;

import dagger.internal.Factory;
import wk5.d;

/* JADX INFO: loaded from: classes18.dex */
public final class OnBoardingInterfacesImpl_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBoardingInterfacesImpl_Factory f236167a = null;

        static {
            f236167a = new OnBoardingInterfacesImpl_Factory();
        }
    }

    public OnBoardingInterfacesImpl_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static OnBoardingInterfacesImpl_Factory create() {
        return a.f236167a;
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }
}
