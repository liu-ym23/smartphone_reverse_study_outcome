package com.ss.android.lark.flow.chat.page.starter;

import dagger.internal.Factory;
import tgb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowThreadWindowStarter_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowThreadWindowStarter_Factory f422901a = null;

        static {
            f422901a = new FlowThreadWindowStarter_Factory();
        }
    }

    public FlowThreadWindowStarter_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static FlowThreadWindowStarter_Factory create() {
        return a.f422901a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
