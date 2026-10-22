package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000e¨\u0006*"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/SeckillInfo;", "Ljava/io/Serializable;", "()V", "beginTime", "", "getBeginTime", "()J", "setBeginTime", "(J)V", "cardTitle", "", "getCardTitle", "()Ljava/lang/String;", "setCardTitle", "(Ljava/lang/String;)V", "currentTime", "getCurrentTime", "setCurrentTime", "endTime", "getEndTime", "setEndTime", "leftStock", "getLeftStock", "setLeftStock", "preBeginTime", "getPreBeginTime", "setPreBeginTime", "skuMaxPrice", "", "getSkuMaxPrice", "()I", "setSkuMaxPrice", "(I)V", "skuMinPrice", "getSkuMinPrice", "setSkuMinPrice", "stock", "getStock", "setStock", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SeckillInfo implements Serializable {

    @SerializedName("begin_time")
    private long beginTime;

    @SerializedName("card_title")
    private String cardTitle;

    @SerializedName("current_time")
    private long currentTime;

    @SerializedName("end_time")
    private long endTime;

    @SerializedName("left_stock")
    private long leftStock;

    @SerializedName("pre_begin_time")
    private long preBeginTime;

    @SerializedName("sku_max_price")
    private int skuMaxPrice;

    @SerializedName("sku_min_price")
    private int skuMinPrice;

    @SerializedName("stock")
    private long stock;

    @SerializedName("title")
    private String title;

    public SeckillInfo() {
        this.title = "";
        this.cardTitle = "";
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final String getCardTitle() {
        return this.cardTitle;
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getLeftStock() {
        return this.leftStock;
    }

    public final long getPreBeginTime() {
        return this.preBeginTime;
    }

    public final int getSkuMaxPrice() {
        return this.skuMaxPrice;
    }

    public final int getSkuMinPrice() {
        return this.skuMinPrice;
    }

    public final long getStock() {
        return this.stock;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setBeginTime(long r100) {
        this.beginTime = r100;
    }

    public final void setCardTitle(String r100) {
        this.cardTitle = r100;
    }

    public final void setCurrentTime(long r100) {
        this.currentTime = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setLeftStock(long r100) {
        this.leftStock = r100;
    }

    public final void setPreBeginTime(long r100) {
        this.preBeginTime = r100;
    }

    public final void setSkuMaxPrice(int r100) {
        this.skuMaxPrice = r100;
    }

    public final void setSkuMinPrice(int r100) {
        this.skuMinPrice = r100;
    }

    public final void setStock(long r100) {
        this.stock = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
