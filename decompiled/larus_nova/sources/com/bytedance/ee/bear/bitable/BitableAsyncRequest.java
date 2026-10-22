package com.bytedance.ee.bear.bitable;

import com.bytedance.ee.util.io.NonProguardWithoutSerializable;
import com.bytedance.locallife.cube.PrefetchTiming;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/BitableAsyncRequest;", "Lcom/bytedance/ee/util/io/NonProguardWithoutSerializable;", "<init>", "()V", "biz", "", "getBiz", "()Ljava/lang/String;", "setBiz", "(Ljava/lang/String;)V", "requestId", "getRequestId", "setRequestId", PrefetchTiming.ROUTER, "getRouter", "setRouter", "tableId", "getTableId", "setTableId", "baseId", "getBaseId", "setBaseId", "data", "", "", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableAsyncRequest implements NonProguardWithoutSerializable {
    public static final String ASYNC_REQUEST_CARD = "javascript:window.lark.biz.bitable.asyncJsRequest";
    public static final a Companion = null;
    private String baseId;
    private String biz;
    private Map<String, ? extends Object> data;
    private String requestId;
    private String router;
    private String tableId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BitableAsyncRequest() {
        this.router = "null";
        this.tableId = "";
        this.data = new HashMap();
        StringCompanionObject r100 = StringCompanionObject.INSTANCE;
        this.requestId = String.format(Locale.US, "%d-%s", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis()), this.router}, 2));
    }

    public final String getBaseId() {
        return this.baseId;
    }

    public final String getBiz() {
        return this.biz;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getRouter() {
        return this.router;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final void setBaseId(String r100) {
        this.baseId = r100;
    }

    public final void setBiz(String r100) {
        this.biz = r100;
    }

    public final void setData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.data = r100;
    }

    public final void setRequestId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestId = r100;
    }

    public final void setRouter(String r100) {
        this.router = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }
}
