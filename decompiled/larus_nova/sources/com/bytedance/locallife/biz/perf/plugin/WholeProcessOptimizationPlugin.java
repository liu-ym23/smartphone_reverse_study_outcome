package com.bytedance.locallife.biz.perf.plugin;

import androidx.lifecycle.Observer;
import com.bytedance.locallife.biz.perf.PageEnum;
import com.bytedance.locallife.dito.data.p;
import com.bytedance.locallife.dito.data.t;
import com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/biz/perf/plugin/WholeProcessOptimizationPlugin;", "Lcom/bytedance/locallife/dito/plugin/AbsDitoLifeCyclePlugin;", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class WholeProcessOptimizationPlugin extends AbsDitoLifeCyclePlugin {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PageEnum f256860d;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WholeProcessOptimizationPlugin f256861a;

        public a(WholeProcessOptimizationPlugin r100) {
            this.f256861a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            p r101 = (p) r100;
            Schedulers.io().scheduleDirect(new com.bytedance.locallife.biz.perf.plugin.a(this.f256861a));
        }
    }

    public WholeProcessOptimizationPlugin(PageEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "pageEnum");
        this.f256860d = r100;
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void j(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        e().k0().observeForever(new a(this));
    }
}
