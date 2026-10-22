package com.bytedance.android.shopping.vo;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/vo/UserPropertyVO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "shopGuideDisplay", "", "getShopGuideDisplay", "()Z", "setShopGuideDisplay", "(Z)V", "shopGuideIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopGuideIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setShopGuideIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "shopGuideText", "", "getShopGuideText", "()Ljava/lang/String;", "setShopGuideText", "(Ljava/lang/String;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserPropertyVO extends CommerceBaseResponse {
    private boolean shopGuideDisplay;
    private ECUrlModel shopGuideIcon;
    private String shopGuideText;

    public UserPropertyVO() {
        this.shopGuideText = "";
    }

    public final boolean getShopGuideDisplay() {
        return this.shopGuideDisplay;
    }

    public final ECUrlModel getShopGuideIcon() {
        return this.shopGuideIcon;
    }

    public final String getShopGuideText() {
        return this.shopGuideText;
    }

    public final void setShopGuideDisplay(boolean r1) {
        this.shopGuideDisplay = r1;
    }

    public final void setShopGuideIcon(ECUrlModel r1) {
        this.shopGuideIcon = r1;
    }

    public final void setShopGuideText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.shopGuideText = r2;
    }
}
