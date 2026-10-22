package com.larus.platform.model.showcase;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/platform/model/showcase/CaseActionRequest;", "", "caseId", "", "action", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "getCaseId", "()Ljava/lang/Long;", "setCaseId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAction", "()Ljava/lang/Integer;", "setAction", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;)Lcom/larus/platform/model/showcase/CaseActionRequest;", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaseActionRequest {

    @SerializedName("action")
    private Integer action;

    @SerializedName("case_id")
    private Long caseId;

    /* JADX WARN: Multi-variable type inference failed */
    public CaseActionRequest() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CaseActionRequest copy$default(CaseActionRequest r100, Long r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.caseId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.action;
    L9:
        return r100.copy(r101, r102);
    }

    public final Long component1() {
        return this.caseId;
    }

    public final Integer component2() {
        return this.action;
    }

    public final CaseActionRequest copy(Long r100, Integer r101) {
        return new CaseActionRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CaseActionRequest) == true) goto L8;
        return false;
    L8:
        CaseActionRequest r101 = (CaseActionRequest) r100;
        if (Intrinsics.areEqual(this.caseId, r101.caseId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r100 = this.caseId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.action;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CaseActionRequest(caseId=" + this.caseId + ", action=" + this.action + ')';
    }

    public final Integer getAction() {
        return this.action;
    }

    public final Long getCaseId() {
        return this.caseId;
    }

    public final void setAction(Integer r100) {
        this.action = r100;
    }

    public final void setCaseId(Long r100) {
        this.caseId = r100;
    }

    public CaseActionRequest(Long r100, Integer r101) {
        this.caseId = r100;
        this.action = r101;
    }

    public /* synthetic */ CaseActionRequest(Long r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0L;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 1;
    L8:
        this(r100, r101);
    }
}
