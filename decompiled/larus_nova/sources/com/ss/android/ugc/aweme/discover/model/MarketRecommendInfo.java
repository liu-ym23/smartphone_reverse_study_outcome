package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR \u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/MarketRecommendInfo;", "Ljava/io/Serializable;", "()V", "cover", "", "getCover", "()Ljava/lang/String;", "setCover", "(Ljava/lang/String;)V", "deliveryFee", "getDeliveryFee", "setDeliveryFee", "distance", "getDistance", "setDistance", "jumpType", "", "getJumpType", "()Ljava/lang/Integer;", "setJumpType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "name", "getName", "setName", "schema", "getSchema", "setSchema", "tokenType", "getTokenType", "setTokenType", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketRecommendInfo implements Serializable {

    @SerializedName("img")
    private String cover;

    @SerializedName("delivery_fee")
    private String deliveryFee;

    @SerializedName("distance")
    private String distance;

    @SerializedName("jump_type")
    private Integer jumpType;

    @SerializedName("name")
    private String name;

    @SerializedName("schema")
    private String schema;

    @SerializedName("token_type")
    private String tokenType;

    public MarketRecommendInfo() {
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getDeliveryFee() {
        return this.deliveryFee;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final Integer getJumpType() {
        return this.jumpType;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public final void setCover(String r100) {
        this.cover = r100;
    }

    public final void setDeliveryFee(String r100) {
        this.deliveryFee = r100;
    }

    public final void setDistance(String r100) {
        this.distance = r100;
    }

    public final void setJumpType(Integer r100) {
        this.jumpType = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setTokenType(String r100) {
        this.tokenType = r100;
    }
}
