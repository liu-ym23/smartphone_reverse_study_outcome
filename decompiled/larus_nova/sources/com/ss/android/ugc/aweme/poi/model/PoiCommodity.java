package com.ss.android.ugc.aweme.poi.model;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes40.dex */
public class PoiCommodity implements Serializable {

    @SerializedName("book_url")
    public String book_url;

    @SerializedName("queue_status")
    public int queueStatus;

    @SerializedName("queue_url")
    public String queue_url;

    public PoiCommodity() {
    }

    @AllowImpl
    public boolean isAvailable() {
        int r100 = this.queueStatus;
        if (r100 >= 2) goto L5;
    L8:
        return true;
    L5:
        if (r100 > 4) goto L8;
        return false;
    }
}
