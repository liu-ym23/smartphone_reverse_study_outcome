package com.ss.android.lark.feed.molten;

import com.bytedance.lark.view_flow_wrapper.m;
import dagger.internal.Factory;
import eeb.b;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedViewFlowForegroundLifecycleTask_Factory implements Factory<b> {
    private final Provider<Set<m>> disposablesProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.disposablesProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedViewFlowForegroundLifecycleTask_Factory(Provider<Set<m>> r100) {
        this.disposablesProvider = r100;
    }

    public static FeedViewFlowForegroundLifecycleTask_Factory create(Provider<Set<m>> r100) {
        return new FeedViewFlowForegroundLifecycleTask_Factory(r100);
    }

    public static b newInstance(Set<m> r100) {
        return new b(r100);
    }
}
