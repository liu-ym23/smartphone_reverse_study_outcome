package com.bytedance.ee.bear.bitable;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguardWithoutSerializable;
import com.bytedance.locallife.cube.PrefetchTiming;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/BitableAsyncResponse;", "Lcom/bytedance/ee/util/io/NonProguardWithoutSerializable;", "<init>", "()V", "requestId", "", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", PrefetchTiming.ROUTER, "getRouter", "setRouter", "result", "", "getResult", "()Ljava/lang/Integer;", "setResult", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "errorResult", "getErrorResult", "setErrorResult", "data", "Lcom/alibaba/fastjson/JSONObject;", "getData", "()Lcom/alibaba/fastjson/JSONObject;", "setData", "(Lcom/alibaba/fastjson/JSONObject;)V", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableAsyncResponse implements NonProguardWithoutSerializable {
    public static final a Companion = null;
    public static final int RESULT_FAIL = -1;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_WAITING = -2;
    private JSONObject data;
    private String errorResult;
    private String requestId;
    private Integer result;
    private String router;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BitableAsyncResponse() {
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final String getErrorResult() {
        return this.errorResult;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Integer getResult() {
        return this.result;
    }

    public final String getRouter() {
        return this.router;
    }

    public final void setData(JSONObject r100) {
        this.data = r100;
    }

    public final void setErrorResult(String r100) {
        this.errorResult = r100;
    }

    public final void setRequestId(String r100) {
        this.requestId = r100;
    }

    public final void setResult(Integer r100) {
        this.result = r100;
    }

    public final void setRouter(String r100) {
        this.router = r100;
    }
}
