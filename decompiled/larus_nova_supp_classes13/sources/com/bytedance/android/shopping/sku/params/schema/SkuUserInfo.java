package com.bytedance.android.shopping.sku.params.schema;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuUserInfo;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaMapParam;", "()V", "userAddrId", "", "getUserAddrId", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuUserInfo extends SkuSchemaMapParam {
    public SkuUserInfo() {
        super("user_info");
    }

    public final String getUserAddrId() {
        Object r0 = getMap().get("user_addr_id");
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        return (String) r0;
    }
}
