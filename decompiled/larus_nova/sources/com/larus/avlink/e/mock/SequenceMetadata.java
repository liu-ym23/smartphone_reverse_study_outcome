package com.larus.avlink.e.mock;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JR\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/avlink/e/mock/SequenceMetadata;", "", "mode", "", "dataSetId", "imageUUID", "recordTime", "", "callbackSequence", "", "Lcom/larus/avlink/e/mock/CallbackSequenceItem;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDataSetId", "getImageUUID", "getRecordTime", "()Ljava/lang/String;", "getCallbackSequence", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/larus/avlink/e/mock/SequenceMetadata;", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SequenceMetadata {
    public static final int $stable = 8;

    @SerializedName("callbackSequence")
    private final List<CallbackSequenceItem> callbackSequence;

    @SerializedName("dataSetId")
    private final Integer dataSetId;

    @SerializedName("imageUUID")
    private final Integer imageUUID;

    @SerializedName("mode")
    private final Integer mode;

    @SerializedName("recordTime")
    private final String recordTime;

    public SequenceMetadata() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SequenceMetadata copy$default(SequenceMetadata r100, Integer r101, Integer r102, Integer r103, String r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.mode;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.dataSetId;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.imageUUID;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.recordTime;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.callbackSequence;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.mode;
    }

    public final Integer component2() {
        return this.dataSetId;
    }

    public final Integer component3() {
        return this.imageUUID;
    }

    public final String component4() {
        return this.recordTime;
    }

    public final List<CallbackSequenceItem> component5() {
        return this.callbackSequence;
    }

    public final SequenceMetadata copy(Integer r100, Integer r101, Integer r110, String r111, List<CallbackSequenceItem> r112) {
        return new SequenceMetadata(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SequenceMetadata) == true) goto L8;
        return false;
    L8:
        SequenceMetadata r101 = (SequenceMetadata) r100;
        if (Intrinsics.areEqual(this.mode, r101.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dataSetId, r101.dataSetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageUUID, r101.imageUUID) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recordTime, r101.recordTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.callbackSequence, r101.callbackSequence) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.mode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.dataSetId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.imageUUID;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.recordTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<CallbackSequenceItem> r113 = this.callbackSequence;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "SequenceMetadata(mode=" + this.mode + ", dataSetId=" + this.dataSetId + ", imageUUID=" + this.imageUUID + ", recordTime=" + this.recordTime + ", callbackSequence=" + this.callbackSequence + ')';
    }

    public final List<CallbackSequenceItem> getCallbackSequence() {
        return this.callbackSequence;
    }

    public final Integer getDataSetId() {
        return this.dataSetId;
    }

    public final Integer getImageUUID() {
        return this.imageUUID;
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final String getRecordTime() {
        return this.recordTime;
    }

    public SequenceMetadata(Integer r100, Integer r101, Integer r102, String r103, List<CallbackSequenceItem> r104) {
        this.mode = r100;
        this.dataSetId = r101;
        this.imageUUID = r102;
        this.recordTime = r103;
        this.callbackSequence = r104;
    }

    public /* synthetic */ SequenceMetadata(Integer r100, Integer r101, Integer r102, String r103, List r104, int r105, DefaultConstructorMarker r110) {
        Integer r106 = 0;
        if ((r105 & 1) == 0) goto L5;
        Integer r111 = r106;
    L7:
        if ((r105 & 2) == 0) goto L9;
        Integer r107 = r106;
    L11:
        if ((r105 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r105 & 8) == 0) goto L17;
        String r108 = null;
    L19:
        if ((r105 & 16) == 0) goto L21;
        List r109 = null;
    L22:
        this(r111, r107, r106, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
