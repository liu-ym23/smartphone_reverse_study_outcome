package com.bytedance.android.shopping.sku.params.schema;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuProductContext;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaMapParam;", "()V", "authorId", "", "getAuthorId", "()Ljava/lang/String;", "isGroupBuy", "", "()Ljava/lang/Boolean;", "itemId", "getItemId", "marketingChannel", "getMarketingChannel", "orderUrl", "getOrderUrl", "roomId", "getRoomId", "secAuthorId", "getSecAuthorId", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuProductContext extends SkuSchemaMapParam {
    public SkuProductContext() {
        super("product_context");
    }

    public final String getAuthorId() {
        Object r0 = getMap().get("author_id");
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        return (String) r0;
    }

    public final String getItemId() {
        Object r0 = getMap().get(PdpOpenThirdParam.KEY_ITEM_ID);
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        return (String) r0;
    }

    public final String getMarketingChannel() {
        Object r0 = getMap().get("marketing_channel");
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        return (String) r0;
    }

    public final String getOrderUrl() {
        Object r0 = getMap().get(PdpOpenThirdParam.KEY_ORDER_URL);
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        return (String) r0;
    }

    public final String getRoomId() {
        Object r0 = getMap().get("room_id");
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        return (String) r0;
    }

    public final String getSecAuthorId() {
        Object r0 = getMap().get(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID);
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        return (String) r0;
    }

    public final Boolean isGroupBuy() {
        Object r0 = getMap().get("is_group_buy");
        if ((r0 instanceof Boolean) == true) goto L6;
        r0 = null;
    L6:
        return (Boolean) r0;
    }
}
