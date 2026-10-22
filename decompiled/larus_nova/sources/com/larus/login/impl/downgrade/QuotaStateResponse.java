package com.larus.login.impl.downgrade;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/login/impl/downgrade/QuotaStateResponse;", "", "quotaState", "", "<init>", "(Ljava/lang/Integer;)V", "getQuotaState", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/larus/login/impl/downgrade/QuotaStateResponse;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuotaStateResponse {

    @SerializedName("status")
    private final Integer quotaState;

    /* JADX WARN: Multi-variable type inference failed */
    public QuotaStateResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ QuotaStateResponse copy$default(QuotaStateResponse r100, Integer r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.quotaState;
    L6:
        return r100.copy(r101);
    }

    public final Integer component1() {
        return this.quotaState;
    }

    public final QuotaStateResponse copy(Integer r100) {
        return new QuotaStateResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QuotaStateResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.quotaState, ((QuotaStateResponse) r100).quotaState) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.quotaState;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "QuotaStateResponse(quotaState=" + this.quotaState + ')';
    }

    public final Integer getQuotaState() {
        return this.quotaState;
    }

    public QuotaStateResponse(Integer r100) {
        this.quotaState = r100;
    }

    public /* synthetic */ QuotaStateResponse(Integer r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
