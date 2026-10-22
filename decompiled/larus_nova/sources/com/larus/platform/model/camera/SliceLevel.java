package com.larus.platform.model.camera;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.ee.bear.drive.config.fg.DriveVideoPlayConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/camera/SliceLevel;", "", "type", "", "sliceThresholdBytes", "", "sliceSizeBytes", "socketNum", "", "sliceRetryCount", "<init>", "(Ljava/lang/String;JJII)V", "getType", "()Ljava/lang/String;", "getSliceThresholdBytes", "()J", "getSliceSizeBytes", "getSocketNum", "()I", "getSliceRetryCount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SliceLevel {

    @SerializedName("sliceRetryCount")
    private final int sliceRetryCount;

    @SerializedName("sliceSizeBytes")
    private final long sliceSizeBytes;

    @SerializedName("sliceThresholdBytes")
    private final long sliceThresholdBytes;

    @SerializedName("socketNum")
    private final int socketNum;

    @SerializedName("type")
    private final String type;

    public SliceLevel() {
        this(null, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ SliceLevel copy$default(SliceLevel r100, String r101, long r102, long r103, int r110, int r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.sliceThresholdBytes;
    L8:
        long r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.sliceSizeBytes;
    L11:
        long r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.socketNum;
    L14:
        int r114 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.sliceRetryCount;
    L17:
        String r106 = r101;
        return r100.copy(r106, r104, r105, r114, r111);
    }

    public final String component1() {
        return this.type;
    }

    public final long component2() {
        return this.sliceThresholdBytes;
    }

    public final long component3() {
        return this.sliceSizeBytes;
    }

    public final int component4() {
        return this.socketNum;
    }

    public final int component5() {
        return this.sliceRetryCount;
    }

    public final SliceLevel copy(String r110, long r111, long r112, int r113, int r114) {
        return new SliceLevel(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SliceLevel) == true) goto L8;
        return false;
    L8:
        SliceLevel r101 = (SliceLevel) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (this.sliceThresholdBytes == r101.sliceThresholdBytes) goto L15;
        return false;
    L15:
        if (this.sliceSizeBytes == r101.sliceSizeBytes) goto L18;
        return false;
    L18:
        if (this.socketNum == r101.socketNum) goto L21;
        return false;
    L21:
        if (this.sliceRetryCount == r101.sliceRetryCount) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.type;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.sliceThresholdBytes;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.sliceSizeBytes;
        return ((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.socketNum) * 31) + this.sliceRetryCount;
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SliceLevel(type=" + this.type + ", sliceThresholdBytes=" + this.sliceThresholdBytes + ", sliceSizeBytes=" + this.sliceSizeBytes + ", socketNum=" + this.socketNum + ", sliceRetryCount=" + this.sliceRetryCount + ')';
    }

    public final int getSliceRetryCount() {
        return this.sliceRetryCount;
    }

    public final long getSliceSizeBytes() {
        return this.sliceSizeBytes;
    }

    public final long getSliceThresholdBytes() {
        return this.sliceThresholdBytes;
    }

    public final int getSocketNum() {
        return this.socketNum;
    }

    public final String getType() {
        return this.type;
    }

    public SliceLevel(String r100, long r101, long r102, int r103, int r104) {
        this.type = r100;
        this.sliceThresholdBytes = r101;
        this.sliceSizeBytes = r102;
        this.socketNum = r103;
        this.sliceRetryCount = r104;
    }

    public /* synthetic */ SliceLevel(String r100, long r101, long r102, int r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = "normal";
    L6:
        if ((r112 & 2) == 0) goto L8;
        r101 = DriveVideoPlayConfig.DEFAULT_BITRATE;
    L8:
        long r103 = r101;
        if ((r112 & 4) == 0) goto L11;
        r102 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
    L11:
        long r104 = r102;
        if ((r112 & 8) == 0) goto L14;
        int r114 = 4;
    L16:
        if ((r112 & 16) == 0) goto L18;
        int r105 = 3;
    L19:
        this(r100, r103, r104, r114, r105);
        return;
    L18:
        r105 = r111;
        goto L19
    L14:
        r114 = r110;
        goto L16
    }
}
