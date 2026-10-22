package com.ss.android.lark.biz.im.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class ExtraConfig implements Serializable {

    @SerializedName("can_apply_visibility")
    private boolean canApplyVisibility;

    public ExtraConfig() {
        this.canApplyVisibility = true;
    }

    public boolean isCanApplyVisibility() {
        return this.canApplyVisibility;
    }
}
