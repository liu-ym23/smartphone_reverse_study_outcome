package com.bytedance.android.shopping.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/dto/CommerceToutiaoButton;", "Ljava/io/Serializable;", "()V", "h5Url", "", "getH5Url", "()Ljava/lang/String;", "setH5Url", "(Ljava/lang/String;)V", "orderStatus", "", "getOrderStatus", "()I", "setOrderStatus", "(I)V", "skuConfirmText", "", "getSkuConfirmText", "()Ljava/util/List;", "setSkuConfirmText", "(Ljava/util/List;)V", "smallAppUrl", "getSmallAppUrl", "setSmallAppUrl", "textList", "getTextList", "setTextList", "OrderStatus", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommerceToutiaoButton implements Serializable {

    @SerializedName("h5_url")
    private String h5Url;

    @SerializedName("order_status")
    private int orderStatus;

    @SerializedName("sku_confirm_text")
    private List<String> skuConfirmText;

    @SerializedName("small_app_url")
    private String smallAppUrl;

    @SerializedName("text")
    private List<String> textList;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/dto/CommerceToutiaoButton$OrderStatus;", "", "", "status", "I", "getStatus", "()I", "UN_BUY", "UN_PAY", "CAN_EXPERIENCE", "CAN_NOT_EXPERIENCE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum OrderStatus extends Enum<OrderStatus> {
        public static final OrderStatus CAN_EXPERIENCE = null;
        public static final OrderStatus CAN_NOT_EXPERIENCE = null;
        public static final OrderStatus UN_BUY = null;
        public static final OrderStatus UN_PAY = null;
        public static final /* synthetic */ OrderStatus[] a = null;
        private final int status;

        static {
            OrderStatus r2 = new OrderStatus("UN_BUY", 0, 1);
            UN_BUY = r2;
            OrderStatus r3 = new OrderStatus("UN_PAY", 1, 2);
            UN_PAY = r3;
            OrderStatus r4 = new OrderStatus("CAN_EXPERIENCE", 2, 3);
            CAN_EXPERIENCE = r4;
            OrderStatus r5 = new OrderStatus("CAN_NOT_EXPERIENCE", 3, 4);
            CAN_NOT_EXPERIENCE = r5;
            a = new OrderStatus[]{r2, r3, r4, r5};
        }

        public static OrderStatus valueOf(String r1) {
            return (OrderStatus) a.a(OrderStatus.class, r1);
        }

        public static OrderStatus[] values() {
            return (OrderStatus[]) a.clone();
        }

        public final int getStatus() {
            return this.status;
        }

        public OrderStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.status = r3;
        }
    }

    public CommerceToutiaoButton() {
        this.textList = CollectionsKt.emptyList();
        this.orderStatus = OrderStatus.UN_BUY.getStatus();
        this.skuConfirmText = CollectionsKt.emptyList();
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final int getOrderStatus() {
        return this.orderStatus;
    }

    public final List<String> getSkuConfirmText() {
        return this.skuConfirmText;
    }

    public final String getSmallAppUrl() {
        return this.smallAppUrl;
    }

    public final List<String> getTextList() {
        return this.textList;
    }

    public final void setH5Url(String r1) {
        this.h5Url = r1;
    }

    public final void setOrderStatus(int r1) {
        this.orderStatus = r1;
    }

    public final void setSkuConfirmText(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.skuConfirmText = r2;
    }

    public final void setSmallAppUrl(String r1) {
        this.smallAppUrl = r1;
    }

    public final void setTextList(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textList = r2;
    }
}
