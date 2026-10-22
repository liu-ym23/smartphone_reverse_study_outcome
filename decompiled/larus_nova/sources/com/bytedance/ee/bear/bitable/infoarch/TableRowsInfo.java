package com.bytedance.ee.bear.bitable.infoarch;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/TableRowsInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isApproach", "", "()Ljava/lang/Boolean;", "setApproach", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isExceededLimit", "setExceededLimit", "isReachMaxLimit", "setReachMaxLimit", "usedPercent", "", "getUsedPercent", "()Ljava/lang/Integer;", "setUsedPercent", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "count", "getCount", "setCount", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "getLimit", "setLimit", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TableRowsInfo implements NonProguard {
    private Integer count;
    private Boolean isApproach;
    private Boolean isExceededLimit;
    private Boolean isReachMaxLimit;
    private Integer limit;
    private String url;
    private Integer usedPercent;

    public TableRowsInfo() {
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Integer getLimit() {
        return this.limit;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getUsedPercent() {
        return this.usedPercent;
    }

    public final Boolean isApproach() {
        return this.isApproach;
    }

    public final Boolean isExceededLimit() {
        return this.isExceededLimit;
    }

    public final Boolean isReachMaxLimit() {
        return this.isReachMaxLimit;
    }

    public final void setApproach(Boolean r100) {
        this.isApproach = r100;
    }

    public final void setCount(Integer r100) {
        this.count = r100;
    }

    public final void setExceededLimit(Boolean r100) {
        this.isExceededLimit = r100;
    }

    public final void setLimit(Integer r100) {
        this.limit = r100;
    }

    public final void setReachMaxLimit(Boolean r100) {
        this.isReachMaxLimit = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setUsedPercent(Integer r100) {
        this.usedPercent = r100;
    }
}
