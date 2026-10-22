package com.bytedance.android.shopping.feed.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/AdData;", "Ljava/io/Serializable;", "()V", "adPackCell", "", "getAdPackCell", "()Ljava/lang/String;", "setAdPackCell", "(Ljava/lang/String;)V", "cid", "getCid", "setCid", "id", "getId", "setId", "logExtra", "getLogExtra", "setLogExtra", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdData implements Serializable {

    @SerializedName("AdPackCell")
    private String adPackCell;

    @SerializedName("cid")
    private String cid;

    @SerializedName("id")
    private String id;

    @SerializedName("log_extra")
    private String logExtra;

    public AdData() {
    }

    public final String getAdPackCell() {
        return this.adPackCell;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final void setAdPackCell(String r1) {
        this.adPackCell = r1;
    }

    public final void setCid(String r1) {
        this.cid = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setLogExtra(String r1) {
        this.logExtra = r1;
    }
}
