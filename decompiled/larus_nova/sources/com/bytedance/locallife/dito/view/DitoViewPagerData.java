package com.bytedance.locallife.dito.view;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/dito/view/DitoViewPagerData;", "Ljava/io/Serializable;", "config", "Lcom/bytedance/locallife/dito/view/DitoViewPagerConfig;", "pageData", "", "Lcom/bytedance/locallife/dito/view/DitoPagerData;", "(Lcom/bytedance/locallife/dito/view/DitoViewPagerConfig;Ljava/util/List;)V", "getConfig", "()Lcom/bytedance/locallife/dito/view/DitoViewPagerConfig;", "getPageData", "()Ljava/util/List;", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DitoViewPagerData implements Serializable {
    private final DitoViewPagerConfig config;
    private final List<DitoPagerData> pageData;

    public final DitoViewPagerConfig getConfig() {
        return this.config;
    }

    public final List<DitoPagerData> getPageData() {
        return this.pageData;
    }

    public DitoViewPagerData(DitoViewPagerConfig r100, List<DitoPagerData> r101) {
        this.config = r100;
        this.pageData = r101;
    }
}
