package com.bytedance.android.shopping.store.tabkit.bridge;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/Result;", "Ljava/io/Serializable;", "", "success", "Z", "getSuccess", "()Z", "setSuccess", "(Z)V", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Result implements Serializable {
    public static final a Companion = null;
    public static final String ERROR_MSG_TARGET_NOT_FOUND = "target tab not found";

    @SerializedName("error_msg")
    private String errorMsg;

    @SerializedName("success")
    private boolean success;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Result() {
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public final void setSuccess(boolean r1) {
        this.success = r1;
    }
}
