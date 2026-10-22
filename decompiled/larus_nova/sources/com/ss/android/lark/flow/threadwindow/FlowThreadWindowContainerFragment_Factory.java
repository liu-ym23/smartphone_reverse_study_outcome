package com.ss.android.lark.flow.threadwindow;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowThreadWindowContainerFragment_Factory implements Factory<FlowThreadWindowContainerFragment> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowThreadWindowContainerFragment_Factory f424111a = null;

        static {
            f424111a = new FlowThreadWindowContainerFragment_Factory();
        }
    }

    public FlowThreadWindowContainerFragment_Factory() {
    }

    public static FlowThreadWindowContainerFragment newInstance() {
        return new FlowThreadWindowContainerFragment();
    }

    @Override // javax.inject.Provider
    public FlowThreadWindowContainerFragment get() {
        return newInstance();
    }

    public static FlowThreadWindowContainerFragment_Factory create() {
        return a.f424111a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
