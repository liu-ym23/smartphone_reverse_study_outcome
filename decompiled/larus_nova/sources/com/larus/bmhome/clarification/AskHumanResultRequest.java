package com.larus.bmhome.clarification;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/clarification/AskHumanResultRequest;", "", "askHumanResult", "Lcom/larus/bmhome/clarification/AskHumanResult;", "<init>", "(Lcom/larus/bmhome/clarification/AskHumanResult;)V", "getAskHumanResult", "()Lcom/larus/bmhome/clarification/AskHumanResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AskHumanResultRequest {

    @SerializedName("ask_human_result")
    private final AskHumanResult askHumanResult;

    /* JADX WARN: Multi-variable type inference failed */
    public AskHumanResultRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AskHumanResultRequest copy$default(AskHumanResultRequest r100, AskHumanResult r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.askHumanResult;
    L6:
        return r100.copy(r101);
    }

    public final AskHumanResult component1() {
        return this.askHumanResult;
    }

    public final AskHumanResultRequest copy(AskHumanResult r100) {
        return new AskHumanResultRequest(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AskHumanResultRequest) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.askHumanResult, ((AskHumanResultRequest) r100).askHumanResult) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        AskHumanResult r100 = this.askHumanResult;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "AskHumanResultRequest(askHumanResult=" + this.askHumanResult + ')';
    }

    public final AskHumanResult getAskHumanResult() {
        return this.askHumanResult;
    }

    public AskHumanResultRequest(AskHumanResult r100) {
        this.askHumanResult = r100;
    }

    public /* synthetic */ AskHumanResultRequest(AskHumanResult r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
