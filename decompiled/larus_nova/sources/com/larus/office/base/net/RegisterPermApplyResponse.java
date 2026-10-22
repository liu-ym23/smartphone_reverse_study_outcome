package com.larus.office.base.net;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/office/base/net/RegisterPermApplyResponse;", "Ljava/io/Serializable;", "data", "Lcom/larus/office/base/net/RegisterPermApplyData;", "<init>", "(Lcom/larus/office/base/net/RegisterPermApplyData;)V", "getData", "()Lcom/larus/office/base/net/RegisterPermApplyData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RegisterPermApplyResponse implements Serializable {
    private final RegisterPermApplyData data;

    /* JADX WARN: Multi-variable type inference failed */
    public RegisterPermApplyResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RegisterPermApplyResponse copy$default(RegisterPermApplyResponse r100, RegisterPermApplyData r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        return r100.copy(r101);
    }

    public final RegisterPermApplyData component1() {
        return this.data;
    }

    public final RegisterPermApplyResponse copy(RegisterPermApplyData r100) {
        return new RegisterPermApplyResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RegisterPermApplyResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.data, ((RegisterPermApplyResponse) r100).data) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        RegisterPermApplyData r100 = this.data;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "RegisterPermApplyResponse(data=" + this.data + ')';
    }

    public final RegisterPermApplyData getData() {
        return this.data;
    }

    public RegisterPermApplyResponse(RegisterPermApplyData r100) {
        this.data = r100;
    }

    public /* synthetic */ RegisterPermApplyResponse(RegisterPermApplyData r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
