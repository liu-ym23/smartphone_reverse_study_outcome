package com.obric.assistant.relative;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/relative/RelativeResult;", "", "status", "", "extra", "Lcom/obric/assistant/relative/Extra;", "<init>", "(Ljava/lang/String;Lcom/obric/assistant/relative/Extra;)V", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "getExtra", "()Lcom/obric/assistant/relative/Extra;", "setExtra", "(Lcom/obric/assistant/relative/Extra;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RelativeResult {

    @SerializedName("extra")
    private Extra extra;

    @SerializedName("status")
    private String status;

    /* JADX WARN: Multi-variable type inference failed */
    public RelativeResult() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RelativeResult copy$default(RelativeResult r100, String r101, Extra r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.status;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extra;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.status;
    }

    public final Extra component2() {
        return this.extra;
    }

    public final RelativeResult copy(String r100, Extra r101) {
        return new RelativeResult(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RelativeResult) == true) goto L8;
        return false;
    L8:
        RelativeResult r101 = (RelativeResult) r100;
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.status;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Extra r104 = this.extra;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RelativeResult(status=" + this.status + ", extra=" + this.extra + ')';
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setExtra(Extra r100) {
        this.extra = r100;
    }

    public final void setStatus(String r100) {
        this.status = r100;
    }

    public RelativeResult(String r100, Extra r101) {
        this.status = r100;
        this.extra = r101;
    }

    public /* synthetic */ RelativeResult(String r100, Extra r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
