package com.bytedance.locallife.live.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/bytedance/locallife/live/model/GroupPurchaseFlashSale;", "Ljava/io/Serializable;", "()V", "endTime", "", "getEndTime", "()Ljava/lang/String;", "setEndTime", "(Ljava/lang/String;)V", "flashSaleId", "getFlashSaleId", "setFlashSaleId", "flashSalePrice", "", "getFlashSalePrice", "()J", "setFlashSalePrice", "(J)V", "initQuantity", "getInitQuantity", "setInitQuantity", "leftQuantity", "getLeftQuantity", "setLeftQuantity", "needWarmUp", "", "getNeedWarmUp", "()Z", "setNeedWarmUp", "(Z)V", "quantityPercentage", "", "getQuantityPercentage", "()F", "setQuantityPercentage", "(F)V", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "warnUpSeconds", "", "getWarnUpSeconds", "()I", "setWarnUpSeconds", "(I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GroupPurchaseFlashSale implements Serializable {

    @SerializedName("end_time")
    private String endTime;

    @SerializedName("flash_sale_id")
    private String flashSaleId;

    @SerializedName("flash_sale_price")
    private long flashSalePrice;

    @SerializedName("init_quantity")
    private long initQuantity;

    @SerializedName("left_quantity")
    private long leftQuantity;

    @SerializedName("need_warm_up")
    private boolean needWarmUp;

    @SerializedName("quantity_percentage")
    private float quantityPercentage;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private String startTime;

    @SerializedName("warn_up_seconds")
    private int warnUpSeconds;

    public GroupPurchaseFlashSale() {
        this.endTime = "0";
        this.startTime = "0";
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getFlashSaleId() {
        return this.flashSaleId;
    }

    public final long getFlashSalePrice() {
        return this.flashSalePrice;
    }

    public final long getInitQuantity() {
        return this.initQuantity;
    }

    public final long getLeftQuantity() {
        return this.leftQuantity;
    }

    public final boolean getNeedWarmUp() {
        return this.needWarmUp;
    }

    public final float getQuantityPercentage() {
        return this.quantityPercentage;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final int getWarnUpSeconds() {
        return this.warnUpSeconds;
    }

    public final void setEndTime(String r100) {
        this.endTime = r100;
    }

    public final void setFlashSaleId(String r100) {
        this.flashSaleId = r100;
    }

    public final void setFlashSalePrice(long r100) {
        this.flashSalePrice = r100;
    }

    public final void setInitQuantity(long r100) {
        this.initQuantity = r100;
    }

    public final void setLeftQuantity(long r100) {
        this.leftQuantity = r100;
    }

    public final void setNeedWarmUp(boolean r100) {
        this.needWarmUp = r100;
    }

    public final void setQuantityPercentage(float r100) {
        this.quantityPercentage = r100;
    }

    public final void setStartTime(String r100) {
        this.startTime = r100;
    }

    public final void setWarnUpSeconds(int r100) {
        this.warnUpSeconds = r100;
    }
}
