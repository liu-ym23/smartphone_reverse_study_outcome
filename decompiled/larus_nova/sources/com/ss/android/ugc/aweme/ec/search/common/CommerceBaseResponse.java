package com.ss.android.ugc.aweme.ec.search.common;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/aweme/ec/search/common/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "base", "", "getBase", "()Ljava/lang/Object;", "ecNetRequestEnd", "", "getEcNetRequestEnd", "()Ljava/lang/Long;", "setEcNetRequestEnd", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "statusCode", "", "getStatusCode", "()I", "setStatusCode", "(I)V", a.KEY_STATUS_MSG, "getStatusMsg", "setStatusMsg", "ttNetExtraInfo", "getTtNetExtraInfo", "setTtNetExtraInfo", "(Ljava/lang/Object;)V", "Companion", "trade-search-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public class CommerceBaseResponse implements Serializable {
    public static final int CODE_SUCCESS = 0;
    public static final Companion Companion = null;

    @SerializedName("base")
    private final Object base;
    private Long ecNetRequestEnd;

    @SerializedName("message")
    private String message;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("status_msg")
    private String statusMsg;
    private Object ttNetExtraInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/ec/search/common/CommerceBaseResponse$Companion;", "", "()V", "CODE_SUCCESS", "", "trade-search-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public CommerceBaseResponse() {
        this.message = "";
        this.statusMsg = "";
    }

    public final Object getBase() {
        return this.base;
    }

    public final Long getEcNetRequestEnd() {
        return this.ecNetRequestEnd;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final Object getTtNetExtraInfo() {
        return this.ttNetExtraInfo;
    }

    public final void setEcNetRequestEnd(Long r100) {
        this.ecNetRequestEnd = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public final void setStatusMsg(String r100) {
        this.statusMsg = r100;
    }

    public final void setTtNetExtraInfo(Object r100) {
        this.ttNetExtraInfo = r100;
    }
}
