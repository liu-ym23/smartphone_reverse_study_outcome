package com.bytedance.ee.bear.bitable.homepage.tabchoose;

import com.bytedance.ee.bear.bitable.homepage.recommend.report.LoadFrom;
import com.bytedance.ee.bear.contract.Result;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/tabchoose/BitableTabChooseResponse;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/bitable/homepage/tabchoose/BitableTabData;", "<init>", "()V", "fromCache", "", "getFromCache", "()Z", "setFromCache", "(Z)V", "loadFrom", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/LoadFrom;", "getLoadFrom", "()Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/LoadFrom;", "setLoadFrom", "(Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/LoadFrom;)V", "isSuccess", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTabChooseResponse extends Result<BitableTabData> {
    private boolean fromCache;
    private LoadFrom loadFrom;

    public final boolean isSuccess() {
        if (this.code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public BitableTabChooseResponse() {
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final LoadFrom getLoadFrom() {
        return this.loadFrom;
    }

    public final void setFromCache(boolean r100) {
        this.fromCache = r100;
    }

    public final void setLoadFrom(LoadFrom r100) {
        this.loadFrom = r100;
    }
}
