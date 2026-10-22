package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/PermCostInfo;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "rowPermitted", "", "fieldPermitted", "<init>", "(ZZ)V", "getRowPermitted", "()Z", "getFieldPermitted", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermCostInfo extends Result<Serializable> {
    private final boolean fieldPermitted;
    private final boolean rowPermitted;

    public final boolean getFieldPermitted() {
        return this.fieldPermitted;
    }

    public final boolean getRowPermitted() {
        return this.rowPermitted;
    }

    public PermCostInfo(boolean r1, boolean r2) {
        this.rowPermitted = r1;
        this.fieldPermitted = r2;
    }
}
