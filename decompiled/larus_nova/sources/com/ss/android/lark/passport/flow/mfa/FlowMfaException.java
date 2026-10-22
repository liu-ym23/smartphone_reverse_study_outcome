package com.ss.android.lark.passport.flow.mfa;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "error", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaError;", "<init>", "(Lcom/ss/android/lark/passport/flow/mfa/FlowMfaError;)V", "getError", "()Lcom/ss/android/lark/passport/flow/mfa/FlowMfaError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowMfaException extends RuntimeException {
    private final FlowMfaError error;

    public static /* synthetic */ FlowMfaException copy$default(FlowMfaException r100, FlowMfaError r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.error;
    L6:
        return r100.copy(r101);
    }

    public final FlowMfaError component1() {
        return this.error;
    }

    public final FlowMfaException copy(FlowMfaError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        return new FlowMfaException(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowMfaException) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.error, ((FlowMfaException) r100).error) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.error.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "FlowMfaException(error=" + this.error + ')';
    }

    public final FlowMfaError getError() {
        return this.error;
    }

    public FlowMfaException(FlowMfaError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        super(r100.getMessage(), r100.getCause());
        this.error = r100;
    }
}
