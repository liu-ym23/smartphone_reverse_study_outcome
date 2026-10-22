package com.larus.bmhome.chat.component.bottom.multimodal;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalDowngradeData;", "", "fileDowngrade", "", "videoDowngrade", "uploadRetryTimeout", "uploadRetryCount", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getFileDowngrade", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVideoDowngrade", "getUploadRetryTimeout", "getUploadRetryCount", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalDowngradeData;", "equals", "", "other", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultimodalDowngradeData {

    @SerializedName("file_dg")
    private final Integer fileDowngrade;

    @SerializedName("up_retry_cnt")
    private final Integer uploadRetryCount;

    @SerializedName("up_retry_tmo")
    private final Integer uploadRetryTimeout;

    @SerializedName("video_dg")
    private final Integer videoDowngrade;

    public MultimodalDowngradeData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MultimodalDowngradeData copy$default(MultimodalDowngradeData r100, Integer r101, Integer r102, Integer r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.fileDowngrade;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.videoDowngrade;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.uploadRetryTimeout;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.uploadRetryCount;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.fileDowngrade;
    }

    public final Integer component2() {
        return this.videoDowngrade;
    }

    public final Integer component3() {
        return this.uploadRetryTimeout;
    }

    public final Integer component4() {
        return this.uploadRetryCount;
    }

    public final MultimodalDowngradeData copy(Integer r100, Integer r101, Integer r102, Integer r103) {
        return new MultimodalDowngradeData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MultimodalDowngradeData) == true) goto L8;
        return false;
    L8:
        MultimodalDowngradeData r101 = (MultimodalDowngradeData) r100;
        if (Intrinsics.areEqual(this.fileDowngrade, r101.fileDowngrade) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videoDowngrade, r101.videoDowngrade) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadRetryTimeout, r101.uploadRetryTimeout) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uploadRetryCount, r101.uploadRetryCount) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.fileDowngrade;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.videoDowngrade;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.uploadRetryTimeout;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.uploadRetryCount;
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
        return "MultimodalDowngradeData(fileDowngrade=" + this.fileDowngrade + ", videoDowngrade=" + this.videoDowngrade + ", uploadRetryTimeout=" + this.uploadRetryTimeout + ", uploadRetryCount=" + this.uploadRetryCount + ')';
    }

    public final Integer getFileDowngrade() {
        return this.fileDowngrade;
    }

    public final Integer getUploadRetryCount() {
        return this.uploadRetryCount;
    }

    public final Integer getUploadRetryTimeout() {
        return this.uploadRetryTimeout;
    }

    public final Integer getVideoDowngrade() {
        return this.videoDowngrade;
    }

    public MultimodalDowngradeData(Integer r100, Integer r101, Integer r102, Integer r103) {
        this.fileDowngrade = r100;
        this.videoDowngrade = r101;
        this.uploadRetryTimeout = r102;
        this.uploadRetryCount = r103;
    }

    public /* synthetic */ MultimodalDowngradeData(Integer r100, Integer r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = -1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = -1;
    L14:
        this(r100, r101, r102, r103);
    }
}
