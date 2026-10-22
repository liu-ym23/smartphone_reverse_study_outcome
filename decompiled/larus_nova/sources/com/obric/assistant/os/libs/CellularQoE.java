package com.obric.assistant.os.libs;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/os/libs/CellularQoE;", "", "slotId", "", "errBitMap", "", "timestamp", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "getSlotId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrBitMap", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimestamp", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lcom/obric/assistant/os/libs/CellularQoE;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CellularQoE {

    @SerializedName("errBitMap")
    private final Long errBitMap;

    @SerializedName("slotId")
    private final Integer slotId;

    @SerializedName("timestamp")
    private final Long timestamp;

    public CellularQoE() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CellularQoE copy$default(CellularQoE r100, Integer r101, Long r102, Long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.slotId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.errBitMap;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.timestamp;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.slotId;
    }

    public final Long component2() {
        return this.errBitMap;
    }

    public final Long component3() {
        return this.timestamp;
    }

    public final CellularQoE copy(Integer r100, Long r101, Long r102) {
        return new CellularQoE(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CellularQoE) == true) goto L8;
        return false;
    L8:
        CellularQoE r101 = (CellularQoE) r100;
        if (Intrinsics.areEqual(this.slotId, r101.slotId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errBitMap, r101.errBitMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timestamp, r101.timestamp) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.slotId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.errBitMap;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.timestamp;
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
        return "CellularQoE(slotId=" + this.slotId + ", errBitMap=" + this.errBitMap + ", timestamp=" + this.timestamp + ')';
    }

    public final Long getErrBitMap() {
        return this.errBitMap;
    }

    public final Integer getSlotId() {
        return this.slotId;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public CellularQoE(Integer r100, Long r101, Long r102) {
        this.slotId = r100;
        this.errBitMap = r101;
        this.timestamp = r102;
    }

    public /* synthetic */ CellularQoE(Integer r100, Long r101, Long r102, int r103, DefaultConstructorMarker r104) {
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
