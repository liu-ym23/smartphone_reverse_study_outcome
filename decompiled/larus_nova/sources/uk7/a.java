package uk7;

import com.bytedance.ug.sdk.luckydog.api.network.CommonResp;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class a<T> {

    @SerializedName("act_common")
    public CommonResp common;

    @SerializedName("data")
    public T data;

    @SerializedName("debug")
    public String debug;

    @SerializedName("err_no")
    public int errNo;

    @SerializedName("err_tips")
    public String errTips;

    public a() {
    }
}
