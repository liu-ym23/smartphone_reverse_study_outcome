package com.bytedance.ee.bear.bitable.noweb.pluginmounter;

import androidx.lifecycle.LifecycleObserver;
import com.bytedance.ee.bear.bitable.baseadd.pluginhost.BaseAddPluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yv4.e;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/noweb/pluginmounter/NoWebPluginMounter;", "Landroidx/lifecycle/LifecycleObserver;", "pluginHost", "Lcom/bytedance/ee/bear/bitable/noweb/pluginhost/NoWebPluginHost;", "<init>", "(Lcom/bytedance/ee/bear/bitable/noweb/pluginhost/NoWebPluginHost;)V", "pluginMounter", "Lcom/bytedance/ee/bear/browser/plugin/lazy/LazyPluginMounter;", "getLazyPluginMounter", "Lcom/bytedance/ee/bear/browser/plugin/lazy/PluginMounter;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoWebPluginMounter implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f214787a;

    public NoWebPluginMounter(BaseAddPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.f214787a = new e(r100);
    }
}
