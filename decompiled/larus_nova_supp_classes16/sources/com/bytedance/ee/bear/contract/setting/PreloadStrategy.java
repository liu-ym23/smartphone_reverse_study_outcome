package com.bytedance.ee.bear.contract.setting;

import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/contract/setting/PreloadStrategy;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isPreload", "", "()Z", "setPreload", "(Z)V", "limit", "", "getLimit", "()I", "setLimit", "(I)V", PanelData.TAB_SORT, "getSort", "setSort", "features-feature-gating-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreloadStrategy implements NonProguard {
    private boolean isPreload;
    private int limit;
    private int sort;

    public PreloadStrategy() {
        this.sort = 1;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final int getSort() {
        return this.sort;
    }

    public final boolean isPreload() {
        return this.isPreload;
    }

    public final void setLimit(int r1) {
        this.limit = r1;
    }

    public final void setPreload(boolean r1) {
        this.isPreload = r1;
    }

    public final void setSort(int r1) {
        this.sort = r1;
    }
}
