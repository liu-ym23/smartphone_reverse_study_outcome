package com.huawei.hms.common.api;

import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;

/* JADX INFO: loaded from: classes23.dex */
public class BooleanResult extends Result {
    private final Status myStatus;
    private final boolean resultValue;

    public final int hashCode() {
        boolean r100 = this.resultValue;
        int r101 = (this.myStatus.hashCode() + 127) * 77;
        return (r100 ? 1 : 0) + r101;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public Status getStatus() {
        return this.myStatus;
    }

    public boolean getValue() {
        return this.resultValue;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BooleanResult) == false) goto L14;
        BooleanResult r101 = (BooleanResult) r100;
        if (this.resultValue == r101.getValue()) goto L10;
    L12:
        return false;
    L10:
        if (this.myStatus.equals(r101.getStatus()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public BooleanResult(Status r100, boolean r101) {
        Preconditions.checkNotNull(r100, "status cannot be null");
        this.myStatus = r100;
        this.resultValue = r101;
    }
}
