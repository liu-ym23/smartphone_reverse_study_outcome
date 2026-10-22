package com.bytedance.android.shopping.feed.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR \u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/AdPackCell;", "Ljava/io/Serializable;", "()V", "dataType", "", "getDataType", "()Ljava/lang/Integer;", "setDataType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "id", "", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "rawData", "", "getRawData", "()Ljava/lang/String;", "setRawData", "(Ljava/lang/String;)V", "ritType", "getRitType", "setRitType", "sendExtra", "getSendExtra", "setSendExtra", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdPackCell implements Serializable {

    @SerializedName("data_type")
    private Integer dataType;

    @SerializedName("id")
    private Long id;

    @SerializedName("raw_data")
    private String rawData;

    @SerializedName("rit_type")
    private Long ritType;

    @SerializedName("mario_send_extra")
    private String sendExtra;

    public AdPackCell() {
    }

    public final Integer getDataType() {
        return this.dataType;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final Long getRitType() {
        return this.ritType;
    }

    public final String getSendExtra() {
        return this.sendExtra;
    }

    public final void setDataType(Integer r1) {
        this.dataType = r1;
    }

    public final void setId(Long r1) {
        this.id = r1;
    }

    public final void setRawData(String r1) {
        this.rawData = r1;
    }

    public final void setRitType(Long r1) {
        this.ritType = r1;
    }

    public final void setSendExtra(String r1) {
        this.sendExtra = r1;
    }
}
