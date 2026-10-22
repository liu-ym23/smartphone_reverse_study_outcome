package com.bytedance.locallife.live.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006$"}, d2 = {"Lcom/bytedance/locallife/live/model/GroupPurchaseMinusSale;", "Ljava/io/Serializable;", "()V", "actualAmount", "", "getActualAmount", "()Ljava/lang/String;", "setActualAmount", "(Ljava/lang/String;)V", "leftQuantity", "getLeftQuantity", "setLeftQuantity", "minusActivityId", "getMinusActivityId", "setMinusActivityId", "minusSalePrice", "", "getMinusSalePrice", "()J", "setMinusSalePrice", "(J)V", "minusSaleRule", "getMinusSaleRule", "setMinusSaleRule", "minusSaleTag", "getMinusSaleTag", "setMinusSaleTag", "saleId", "getSaleId", "setSaleId", "saleTag", "getSaleTag", "setSaleTag", DBDefinition.TASK_ID, "getTaskId", "setTaskId", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GroupPurchaseMinusSale implements Serializable {

    @SerializedName("actual_amount_tag")
    private String actualAmount;

    @SerializedName("left_quantity_tag")
    private String leftQuantity;

    @SerializedName("minus_activity_id")
    private String minusActivityId;

    @SerializedName("minus_sale_price")
    private long minusSalePrice;

    @SerializedName("minus_rule")
    private String minusSaleRule;

    @SerializedName("minus_type")
    private String minusSaleTag;

    @SerializedName("minus_sale_id")
    private String saleId;

    @SerializedName("minus_sale_ticket_tag")
    private String saleTag;

    @SerializedName("alliance_task_id")
    private String taskId;

    public GroupPurchaseMinusSale() {
        this.saleId = "";
        this.leftQuantity = "";
        this.saleTag = "";
        this.actualAmount = "";
        this.minusSaleTag = "";
        this.minusSaleRule = "";
        this.taskId = "";
        this.minusActivityId = "";
    }

    public final String getActualAmount() {
        return this.actualAmount;
    }

    public final String getLeftQuantity() {
        return this.leftQuantity;
    }

    public final String getMinusActivityId() {
        return this.minusActivityId;
    }

    public final long getMinusSalePrice() {
        return this.minusSalePrice;
    }

    public final String getMinusSaleRule() {
        return this.minusSaleRule;
    }

    public final String getMinusSaleTag() {
        return this.minusSaleTag;
    }

    public final String getSaleId() {
        return this.saleId;
    }

    public final String getSaleTag() {
        return this.saleTag;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setActualAmount(String r100) {
        this.actualAmount = r100;
    }

    public final void setLeftQuantity(String r100) {
        this.leftQuantity = r100;
    }

    public final void setMinusActivityId(String r100) {
        this.minusActivityId = r100;
    }

    public final void setMinusSalePrice(long r100) {
        this.minusSalePrice = r100;
    }

    public final void setMinusSaleRule(String r100) {
        this.minusSaleRule = r100;
    }

    public final void setMinusSaleTag(String r100) {
        this.minusSaleTag = r100;
    }

    public final void setSaleId(String r100) {
        this.saleId = r100;
    }

    public final void setSaleTag(String r100) {
        this.saleTag = r100;
    }

    public final void setTaskId(String r100) {
        this.taskId = r100;
    }
}
