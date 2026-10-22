package com.bytedance.android.shopping.sku.params.schema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b \u0010\u0006R\u0013\u0010!\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0011\u0010#\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b'\u0010\u0013R\u0013\u0010(\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b)\u0010\u0013¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuClientParams;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaMapParam;", "()V", "createNewActivity", "", "getCreateNewActivity", "()Ljava/lang/Boolean;", "defaultCount", "", "getDefaultCount", "()Ljava/lang/Long;", "defaultSpecId", "", "", "getDefaultSpecId", "()Ljava/util/List;", "forceHeight", "", "getForceHeight", "()Ljava/lang/Integer;", "forceYataSku", "getForceYataSku", "heightPercent", "getHeightPercent", "maskAlpha", "", "getMaskAlpha", "()Ljava/lang/Float;", "maskBackgroundColor", "getMaskBackgroundColor", "()Ljava/lang/String;", "scrollToInstallment", "getScrollToInstallment", "skuSessionId", "getSkuSessionId", "splitScreenHalfMode", "getSplitScreenHalfMode", "()Z", "standardAddCartToastType", "getStandardAddCartToastType", "termCount", "getTermCount", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuClientParams extends SkuSchemaMapParam {
    public SkuClientParams() {
        super("client_params");
    }

    public final Long getDefaultCount() {
        return getLong("default_count");
    }

    public final Integer getForceHeight() {
        return getInt("force_height");
    }

    public final Integer getForceYataSku() {
        return getInt("force_yata_sku");
    }

    public final Integer getHeightPercent() {
        return getInt("height_percent");
    }

    public final Float getMaskAlpha() {
        return getFloat("mask_alpha");
    }

    public final Integer getStandardAddCartToastType() {
        return getInt("add_cart_toast_type");
    }

    public final Integer getTermCount() {
        return getInt("dou_installment_term");
    }

    public final Boolean getCreateNewActivity() {
        Object r0 = getMap().get("create_new_activity");
        if ((r0 instanceof Boolean) == true) goto L6;
        r0 = null;
    L6:
        return (Boolean) r0;
    }

    public final List<String> getDefaultSpecId() {
        Object r0 = getMap().get("default_spec_id");
        ArrayList r2 = null;
        if ((r0 instanceof List) == true) goto L5;
        r0 = null;
    L5:
        List r1 = (List) r0;
        if (r1 == null) goto L11;
        List r3 = r1;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        r2.add(String.valueOf(r4.next()));
    L11:
        return r2;
    }

    public final String getMaskBackgroundColor() {
        Object r0 = getMap().get("mask_background_color");
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        return (String) r0;
    }

    public final Boolean getScrollToInstallment() {
        Object r0 = getMap().get("scroll_to_installment");
        if ((r0 instanceof Boolean) == true) goto L6;
        r0 = null;
    L6:
        return (Boolean) r0;
    }

    public final String getSkuSessionId() {
        Object r0 = getMap().get("sku_session_id");
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        return (String) r0;
    }

    public final boolean getSplitScreenHalfMode() {
        Object r0 = getMap().get("split_screen_half_mode");
        if ((r0 instanceof Boolean) == true) goto L6;
        r0 = null;
    L6:
        return Intrinsics.areEqual((Boolean) r0, Boolean.TRUE);
    }
}
