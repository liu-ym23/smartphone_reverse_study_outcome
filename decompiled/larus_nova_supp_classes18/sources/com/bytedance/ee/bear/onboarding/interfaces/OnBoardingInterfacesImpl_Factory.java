package com.bytedance.ee.bear.onboarding.interfaces;

import dagger.internal.Factory;
import wk5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OnBoardingInterfacesImpl_Factory implements Factory<d> {

    public static final class a {
        public static final OnBoardingInterfacesImpl_Factory a = null;

        static {
            a = new OnBoardingInterfacesImpl_Factory();
        }
    }

    public OnBoardingInterfacesImpl_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m463get();
    }

    public static OnBoardingInterfacesImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public d m463get() {
        return newInstance();
    }
}
