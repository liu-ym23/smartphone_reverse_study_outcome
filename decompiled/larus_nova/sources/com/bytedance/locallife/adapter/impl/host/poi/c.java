package com.bytedance.locallife.adapter.impl.host.poi;

import com.bytedance.locallife.biz.perf.PageEnum;
import com.bytedance.locallife.biz.perf.plugin.WholeProcessOptimizationPlugin;
import com.bytedance.locallife.dito.data.o;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import vt6.e;

/* JADX INFO: loaded from: classes20.dex */
public final class c implements e {
    public c() {
    }

    @Override // vt6.e
    public final List b() {
        return CollectionsKt.mutableListOf(new WholeProcessOptimizationPlugin[]{new WholeProcessOptimizationPlugin(PageEnum.GOODS_DETAIL)});
    }

    @Override // vt6.e
    public final Map<String, o> a() {
        return new LinkedHashMap();
    }
}
