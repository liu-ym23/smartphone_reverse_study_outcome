package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/ToastInfo;", "Ljava/io/Serializable;", "()V", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "trade-search-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ToastInfo implements Serializable {

    @SerializedName("msg")
    private String msg;

    public ToastInfo() {
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String r100) {
        this.msg = r100;
    }
}
