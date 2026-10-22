package com.huawei.hms.support.api.client;

import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ResultConvert<R extends Result, S extends Result> {

    public class FailPendingResult extends EmptyPendingResult {
        final /* synthetic */ ResultConvert this$0;

        public FailPendingResult(ResultConvert r100, Status r101) {
            this.this$0 = r100;
            setResult(r101);
        }
    }

    public abstract PendingResult onSuccess(Result r100);

    public ResultConvert() {
    }

    public final PendingResult newFailedPendingResult(Status r100) {
        Preconditions.checkNotNull(r100, "The input status cannot be null");
        Preconditions.checkArgument(!r100.isSuccess(), "The input status must be call with success status");
        return new FailPendingResult(this, r100);
    }

    public Status onFailed(Status r100) {
        Preconditions.checkNotNull(r100, "The input status cannot be null");
        if (r100.getStatusCode() == 0) goto L6;
        return r100;
    L6:
        return Status.CoreException;
    }
}
