package com.bytedance.locallife.dito.common.view;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/dito/common/view/c;", "", "", "viewHeight", "I", "getViewHeight", "()I", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("view_height")
    private final int viewHeight;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (this.viewHeight == ((c) r100).viewHeight) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.viewHeight;
    }

    public final String toString() {
        return "DitoSpaceViewData(viewHeight=" + this.viewHeight + ')';
    }

    public c() {
        this.viewHeight = 0;
    }
}
