package com.obric.assistant.cocreationreview;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationMemoryTraceReportRequest;", "", "uniqId", "", "logId", "extra", "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getUniqId", "()Ljava/lang/String;", "getLogId", "getExtra", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationMemoryTraceReportRequest {

    @SerializedName("extra")
    private final JsonObject extra;

    @SerializedName("log_id")
    private final String logId;

    @SerializedName("uniq_id")
    private final String uniqId;

    public CocreationMemoryTraceReportRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CocreationMemoryTraceReportRequest copy$default(CocreationMemoryTraceReportRequest r100, String r101, String r102, JsonObject r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.uniqId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.logId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.extra;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.uniqId;
    }

    public final String component2() {
        return this.logId;
    }

    public final JsonObject component3() {
        return this.extra;
    }

    public final CocreationMemoryTraceReportRequest copy(String r100, String r101, JsonObject r102) {
        return new CocreationMemoryTraceReportRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CocreationMemoryTraceReportRequest) == true) goto L8;
        return false;
    L8:
        CocreationMemoryTraceReportRequest r101 = (CocreationMemoryTraceReportRequest) r100;
        if (Intrinsics.areEqual(this.uniqId, r101.uniqId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.uniqId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.logId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        JsonObject r107 = this.extra;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CocreationMemoryTraceReportRequest(uniqId=" + this.uniqId + ", logId=" + this.logId + ", extra=" + this.extra + ')';
    }

    public final JsonObject getExtra() {
        return this.extra;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public CocreationMemoryTraceReportRequest(String r100, String r101, JsonObject r102) {
        this.uniqId = r100;
        this.logId = r101;
        this.extra = r102;
    }

    public /* synthetic */ CocreationMemoryTraceReportRequest(String r100, String r101, JsonObject r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
