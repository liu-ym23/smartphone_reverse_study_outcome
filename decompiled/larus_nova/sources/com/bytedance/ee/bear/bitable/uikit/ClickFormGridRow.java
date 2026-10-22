package com.bytedance.ee.bear.bitable.uikit;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/ClickFormGridRow;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "index", "", "<init>", "(I)V", "getIndex", "()I", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClickFormGridRow extends Action {
    private final int index;

    public final int getIndex() {
        return this.index;
    }

    public ClickFormGridRow(int r100) {
        super("", "click");
        this.index = r100;
    }
}
