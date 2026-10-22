package com.bytedance.android.shopping.store.home.api;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/home/api/StoreV3UIParam;", "Ljava/io/Serializable;", "()V", "hideDetailEntry", "", "getHideDetailEntry", "()Ljava/lang/Boolean;", "setHideDetailEntry", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreV3UIParam implements Serializable {
    private Boolean hideDetailEntry;

    public StoreV3UIParam() {
    }

    public final Boolean getHideDetailEntry() {
        return this.hideDetailEntry;
    }

    public final void setHideDetailEntry(Boolean r1) {
        this.hideDetailEntry = r1;
    }
}
