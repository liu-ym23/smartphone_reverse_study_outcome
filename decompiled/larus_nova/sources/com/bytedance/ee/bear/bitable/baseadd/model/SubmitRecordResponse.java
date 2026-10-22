package com.bytedance.ee.bear.bitable.baseadd.model;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/SubmitRecordResponse;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "recordData", "Lcom/bytedance/ee/bear/bitable/baseadd/model/SubmitRecordData;", "<init>", "(Lcom/bytedance/ee/bear/bitable/baseadd/model/SubmitRecordData;)V", "getRecordData", "()Lcom/bytedance/ee/bear/bitable/baseadd/model/SubmitRecordData;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubmitRecordResponse extends Result<Serializable> {
    private final SubmitRecordData recordData;

    public final SubmitRecordData getRecordData() {
        return this.recordData;
    }

    public SubmitRecordResponse(SubmitRecordData r100) {
        Intrinsics.checkNotNullParameter(r100, "recordData");
        this.recordData = r100;
    }
}
