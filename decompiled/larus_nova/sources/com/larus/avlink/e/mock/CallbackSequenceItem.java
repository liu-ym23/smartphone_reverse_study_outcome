package com.larus.avlink.e.mock;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/avlink/e/mock/CallbackSequenceItem;", "", "index", "", "file", "", "timestamp", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "getIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFile", "()Ljava/lang/String;", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lcom/larus/avlink/e/mock/CallbackSequenceItem;", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CallbackSequenceItem {
    public static final int $stable = 0;

    @SerializedName("file")
    private final String file;

    @SerializedName("index")
    private final Integer index;

    @SerializedName("timestamp")
    private final Long timestamp;

    public CallbackSequenceItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CallbackSequenceItem copy$default(CallbackSequenceItem r100, Integer r101, String r102, Long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.index;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.file;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.timestamp;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.index;
    }

    public final String component2() {
        return this.file;
    }

    public final Long component3() {
        return this.timestamp;
    }

    public final CallbackSequenceItem copy(Integer r100, String r101, Long r102) {
        return new CallbackSequenceItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CallbackSequenceItem) == true) goto L8;
        return false;
    L8:
        CallbackSequenceItem r101 = (CallbackSequenceItem) r100;
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.file, r101.file) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timestamp, r101.timestamp) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.index;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.file;
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
        return "CallbackSequenceItem(index=" + this.index + ", file=" + this.file + ", timestamp=" + this.timestamp + ')';
    }

    public final String getFile() {
        return this.file;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public CallbackSequenceItem(Integer r100, String r101, Long r102) {
        this.index = r100;
        this.file = r101;
        this.timestamp = r102;
    }

    public /* synthetic */ CallbackSequenceItem(Integer r100, String r101, Long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0L;
    L11:
        this(r100, r101, r102);
    }
}
