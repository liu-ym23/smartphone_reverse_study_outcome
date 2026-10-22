package com.bytedance.ee.bear.bitable.baseadd.model;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/SubmitRecordStatus;", "Lcom/bytedance/ee/util/io/NonProguard;", "status", "", "recordShareToken", "", "<init>", "(ILjava/lang/String;)V", "getStatus", "()I", "getRecordShareToken", "()Ljava/lang/String;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubmitRecordStatus implements NonProguard {
    private final String recordShareToken;
    private final int status;

    public final String getRecordShareToken() {
        return this.recordShareToken;
    }

    public final int getStatus() {
        return this.status;
    }

    public SubmitRecordStatus(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "recordShareToken");
        this.status = r100;
        this.recordShareToken = r101;
    }
}
