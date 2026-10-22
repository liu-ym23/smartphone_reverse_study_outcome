package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/toolarea/CartBadgeStorageStruct;", "", "lastClickTime", "", "uniqKey", "", "(Ljava/lang/Long;Ljava/lang/String;)V", "getLastClickTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUniqKey", "()Ljava/lang/String;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartBadgeStorageStruct {
    private final Long lastClickTime;
    private final String uniqKey;

    public final Long getLastClickTime() {
        return this.lastClickTime;
    }

    public final String getUniqKey() {
        return this.uniqKey;
    }

    public CartBadgeStorageStruct(Long r1, String r2) {
        this.lastClickTime = r1;
        this.uniqKey = r2;
    }
}
