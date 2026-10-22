package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;

/* JADX INFO: loaded from: classes23.dex */
public final class PendingResultsCreator {

    public static class DiscardedPendingResult<R extends Result> extends EmptyPendingResult {
        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public boolean isCanceled() {
            return true;
        }

        public DiscardedPendingResult() {
        }

        public DiscardedPendingResult(R r100) {
            setResult(r100);
        }
    }

    public static class InstantPendingResult<R extends Result> extends EmptyPendingResult {
        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public void cancel() {
            throw new IllegalStateException("cancel() is not available.");
        }

        public InstantPendingResult(R r100) {
            setResult(r100);
        }

        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public void setResultCallback(ResultCallback r100) {
            r100.onResult(getResult());
        }
    }

    public PendingResultsCreator() {
    }

    public static PendingResult<Status> discardedPendingResult() {
        return new DiscardedPendingResult();
    }

    public static <R extends Result> PendingResult<R> discardedPendingResult(R r100) {
        return new DiscardedPendingResult(r100);
    }

    public static <R extends Result> OptionalPendingResult<R> instantPendingResult(R r100) {
        return new OptionalPendingResultImpl(new InstantPendingResult(r100));
    }

    public static PendingResult<Status> instantPendingResult(Status r100) {
        return new InstantPendingResult(r100);
    }
}
