package com.larus.avlink.e.mock;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0003JL\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/avlink/e/mock/CameraCallbackRecord;", "", "sequence", "", "timestamp", "", "callbackType", "", "params", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/util/Map;)V", "getSequence", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCallbackType", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/avlink/e/mock/CameraCallbackRecord;", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraCallbackRecord {
    public static final int $stable = 8;

    @SerializedName("callbackType")
    private final String callbackType;

    @SerializedName("params")
    private final Map<String, Object> params;

    @SerializedName("sequence")
    private final Integer sequence;

    @SerializedName("timestamp")
    private final Long timestamp;

    public CameraCallbackRecord() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraCallbackRecord copy$default(CameraCallbackRecord r100, Integer r101, Long r102, String r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.sequence;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.timestamp;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.callbackType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.params;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.sequence;
    }

    public final Long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.callbackType;
    }

    public final Map<String, Object> component4() {
        return this.params;
    }

    public final CameraCallbackRecord copy(Integer r100, Long r101, String r102, Map<String, ? extends Object> r103) {
        return new CameraCallbackRecord(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraCallbackRecord) == true) goto L8;
        return false;
    L8:
        CameraCallbackRecord r101 = (CameraCallbackRecord) r100;
        if (Intrinsics.areEqual(this.sequence, r101.sequence) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timestamp, r101.timestamp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callbackType, r101.callbackType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.sequence;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.timestamp;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.callbackType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.params;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CameraCallbackRecord(sequence=" + this.sequence + ", timestamp=" + this.timestamp + ", callbackType=" + this.callbackType + ", params=" + this.params + ')';
    }

    public final String getCallbackType() {
        return this.callbackType;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final Integer getSequence() {
        return this.sequence;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public CameraCallbackRecord(Integer r100, Long r101, String r102, Map<String, ? extends Object> r103) {
        this.sequence = r100;
        this.timestamp = r101;
        this.callbackType = r102;
        this.params = r103;
    }

    public /* synthetic */ CameraCallbackRecord(Integer r100, Long r101, String r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0L;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = MapsKt.emptyMap();
    L14:
        this(r100, r101, r102, r103);
    }
}
