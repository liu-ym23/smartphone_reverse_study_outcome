package com.ss.android.lark.guidemgr.component.task;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class LoadOnBoardingTask_Factory implements Factory<wjb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LoadOnBoardingTask_Factory f425820a = null;

        static {
            f425820a = new LoadOnBoardingTask_Factory();
        }
    }

    public LoadOnBoardingTask_Factory() {
    }

    public static wjb.a newInstance() {
        return new wjb.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static LoadOnBoardingTask_Factory create() {
        return a.f425820a;
    }

    @Override // javax.inject.Provider
    public wjb.a get() {
        return newInstance();
    }
}
