package com.bytedance.ee.bear.bitable.homepage.recommend;

import com.bytedance.ee.bear.contract.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendResponse;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendData;", "<init>", "()V", "loadType", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/RecommendLoadType;", "getLoadType", "()Lcom/bytedance/ee/bear/bitable/homepage/recommend/RecommendLoadType;", "setLoadType", "(Lcom/bytedance/ee/bear/bitable/homepage/recommend/RecommendLoadType;)V", "fromCache", "", "getFromCache", "()Z", "setFromCache", "(Z)V", "requestId", "", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "isSuccess", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRecommendResponse extends Result<BitableRecommendData> {
    private boolean fromCache;
    private RecommendLoadType loadType;
    private String requestId;

    public final boolean isSuccess() {
        if (this.code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public BitableRecommendResponse() {
        this.loadType = RecommendLoadType.UNKNOWN;
        this.requestId = "";
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final RecommendLoadType getLoadType() {
        return this.loadType;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setFromCache(boolean r100) {
        this.fromCache = r100;
    }

    public final void setLoadType(RecommendLoadType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadType = r100;
    }

    public final void setRequestId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestId = r100;
    }
}
