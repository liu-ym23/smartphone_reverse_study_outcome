package com.ss.android.ugc.aweme.shortvideo.edit.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.aweme.creative.CreativeSuppressCheck;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B[\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u000eHÆ\u0003Jc\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0004HÖ\u0001J\t\u00100\u001a\u00020\u001cHÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011¨\u00067"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/edit/model/VideoFileInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "width", "", "height", "duration", "", "fps", "bitrate", "codecType", "keyFrameCount", "gop", "fpsFloat", "", "(IIJIIIIIF)V", "getBitrate", "()I", "getCodecType", "getDuration", "()J", "getFps", "getFpsFloat", "()F", "getGop", "getHeight", "getKeyFrameCount", "resolution", "", "getResolution", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "lib-api_release"}, k = 1, mv = {1, 4, 1})
@CreativeSuppressCheck
public final class VideoFileInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<VideoFileInfo> CREATOR = null;
    public static final Companion Companion = null;
    public static final float FPS_FLOAT_POSTPONE = -100.0f;
    public static final int FPS_POSTPONE = -100;
    public static final int INVALID_CODEC = -1;
    public static final int INVALID_GOP = -1;
    private final int bitrate;
    private final int codecType;
    private final long duration;
    private final int fps;
    private final float fpsFloat;
    private final int gop;
    private final int height;
    private final int keyFrameCount;
    private final int width;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/edit/model/VideoFileInfo$Companion;", "", "()V", "FPS_FLOAT_POSTPONE", "", "FPS_POSTPONE", "", "INVALID_CODEC", "INVALID_GOP", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<VideoFileInfo> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoFileInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            return new VideoFileInfo(r110.readInt(), r110.readInt(), r110.readLong(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final VideoFileInfo[] newArray(int r100) {
            return new VideoFileInfo[r100];
        }
    }

    static {
        Companion = new Companion(0);
        CREATOR = new Creator();
    }

    public VideoFileInfo(int r110, int r111, long r112) {
        this(r110, r111, r112, 0, 0, 0, 0, 0, 0.0f, 504, null);
    }

    public VideoFileInfo(int r110, int r111, long r112, int r113) {
        this(r110, r111, r112, r113, 0, 0, 0, 0, 0.0f, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, null);
    }

    public VideoFileInfo(int r110, int r111, long r112, int r113, int r114) {
        this(r110, r111, r112, r113, r114, 0, 0, 0, 0.0f, 480, null);
    }

    public VideoFileInfo(int r110, int r111, long r112, int r113, int r114, int r210) {
        this(r110, r111, r112, r113, r114, r210, 0, 0, 0.0f, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);
    }

    public VideoFileInfo(int r110, int r111, long r112, int r113, int r114, int r210, int r211) {
        this(r110, r111, r112, r113, r114, r210, r211, 0, 0.0f, 384, null);
    }

    public VideoFileInfo(int r110, int r111, long r112, int r113, int r114, int r210, int r211, int r212) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, 0.0f, 256, null);
    }

    public static /* synthetic */ VideoFileInfo copy$default(VideoFileInfo r110, int r111, int r112, long r113, int r114, int r115, int r116, int r117, int r210, float r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = r110.width;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.height;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.duration;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.fps;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r104 = r110.bitrate;
    L23:
        if ((r212 & 32) == 0) goto L25;
        int r105 = r110.codecType;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r106 = r110.keyFrameCount;
    L31:
        if ((r212 & 128) == 0) goto L33;
        int r118 = r110.gop;
    L35:
        if ((r212 & 256) == 0) goto L37;
        float r107 = r110.fpsFloat;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r118, r107);
    L37:
        r107 = r211;
        goto L39
    L33:
        r118 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final long component3() {
        return this.duration;
    }

    public final int component4() {
        return this.fps;
    }

    public final int component5() {
        return this.bitrate;
    }

    public final int component6() {
        return this.codecType;
    }

    public final int component7() {
        return this.keyFrameCount;
    }

    public final int component8() {
        return this.gop;
    }

    public final float component9() {
        return this.fpsFloat;
    }

    public final VideoFileInfo copy(int r110, int r111, long r112, int r113, int r114, int r115, int r210, int r211, float r212) {
        return new VideoFileInfo(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof VideoFileInfo) == false) goto L24;
        VideoFileInfo r101 = (VideoFileInfo) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height == r101.height) goto L10;
        return false;
    L10:
        if (this.duration == r101.duration) goto L12;
        return false;
    L12:
        if (this.fps == r101.fps) goto L14;
        return false;
    L14:
        if (this.bitrate == r101.bitrate) goto L16;
        return false;
    L16:
        if (this.codecType == r101.codecType) goto L18;
        return false;
    L18:
        if (this.keyFrameCount == r101.keyFrameCount) goto L20;
        return false;
    L20:
        if (this.gop == r101.gop) goto L22;
        return false;
    L22:
        if (Float.compare(this.fpsFloat, r101.fpsFloat) == 0) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r100 = ((this.width * 31) + this.height) * 31;
        long r101 = this.duration;
        return ((((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.fps) * 31) + this.bitrate) * 31) + this.codecType) * 31) + this.keyFrameCount) * 31) + this.gop) * 31) + Float.floatToIntBits(this.fpsFloat);
    }

    public String toString() {
        return "VideoFileInfo(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", fps=" + this.fps + ", bitrate=" + this.bitrate + ", codecType=" + this.codecType + ", keyFrameCount=" + this.keyFrameCount + ", gop=" + this.gop + ", fpsFloat=" + this.fpsFloat + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeLong(this.duration);
        r100.writeInt(this.fps);
        r100.writeInt(this.bitrate);
        r100.writeInt(this.codecType);
        r100.writeInt(this.keyFrameCount);
        r100.writeInt(this.gop);
        r100.writeFloat(this.fpsFloat);
    }

    public final String getResolution() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.width);
        r100.append('*');
        r100.append(this.height);
        return r100.toString();
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getCodecType() {
        return this.codecType;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getFps() {
        return this.fps;
    }

    public final float getFpsFloat() {
        return this.fpsFloat;
    }

    public final int getGop() {
        return this.gop;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getKeyFrameCount() {
        return this.keyFrameCount;
    }

    public final int getWidth() {
        return this.width;
    }

    public VideoFileInfo(int r100, int r101, long r102, int r103, int r104, int r105, int r106, int r107, float r110) {
        this.width = r100;
        this.height = r101;
        this.duration = r102;
        this.fps = r103;
        this.bitrate = r104;
        this.codecType = r105;
        this.keyFrameCount = r106;
        this.gop = r107;
        this.fpsFloat = r110;
    }

    public /* synthetic */ VideoFileInfo(int r110, int r111, long r112, int r113, int r114, int r210, int r211, int r212, float r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 8) == 0) goto L5;
        int r100 = -100;
    L7:
        if ((r214 & 16) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r214 & 32) == 0) goto L13;
        int r102 = -1;
    L15:
        if ((r214 & 64) == 0) goto L17;
        int r115 = -1;
    L19:
        if ((r214 & 128) == 0) goto L21;
        int r116 = -1;
    L23:
        if ((r214 & 256) == 0) goto L25;
        float r117 = r100;
    L26:
        this(r110, r111, r112, r100, r101, r102, r115, r116, r117);
        return;
    L25:
        r117 = r213;
        goto L26
    L21:
        r116 = r212;
        goto L23
    L17:
        r115 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
