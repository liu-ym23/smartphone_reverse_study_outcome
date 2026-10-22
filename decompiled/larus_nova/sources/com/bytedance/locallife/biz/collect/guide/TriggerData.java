package com.bytedance.locallife.biz.collect.guide;

import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/biz/collect/guide/TriggerData;", "", "traceSessionId", "", "style", "", "anchorViewId", "(Ljava/lang/String;ILjava/lang/String;)V", "getAnchorViewId", "()Ljava/lang/String;", "getStyle", "()I", "getTraceSessionId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TriggerData {

    @SerializedName("anchor_view_id")
    private final String anchorViewId;

    @SerializedName("style")
    private final int style;

    @SerializedName(LiveLocalLifeRoomInfo.TRACE_SESSION_ID)
    private final String traceSessionId;

    public TriggerData() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ TriggerData copy$default(TriggerData r100, String r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.traceSessionId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.style;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.anchorViewId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.traceSessionId;
    }

    public final int component2() {
        return this.style;
    }

    public final String component3() {
        return this.anchorViewId;
    }

    public final TriggerData copy(String r100, int r101, String r102) {
        return new TriggerData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TriggerData) == true) goto L8;
        return false;
    L8:
        TriggerData r101 = (TriggerData) r100;
        if (Intrinsics.areEqual(this.traceSessionId, r101.traceSessionId) == true) goto L12;
        return false;
    L12:
        if (this.style == r101.style) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.anchorViewId, r101.anchorViewId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.traceSessionId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.style) * 31;
        String r104 = this.anchorViewId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TriggerData(traceSessionId=" + this.traceSessionId + ", style=" + this.style + ", anchorViewId=" + this.anchorViewId + ')';
    }

    public final String getAnchorViewId() {
        return this.anchorViewId;
    }

    public final int getStyle() {
        return this.style;
    }

    public final String getTraceSessionId() {
        return this.traceSessionId;
    }

    public TriggerData(String r100, int r101, String r102) {
        this.traceSessionId = r100;
        this.style = r101;
        this.anchorViewId = r102;
    }

    public /* synthetic */ TriggerData(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
