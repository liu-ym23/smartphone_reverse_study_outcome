package com.ss.android.ugc.aweme.sticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.creative.CreativePath;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0017Jz\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020\rHÖ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0096\u0002J\b\u0010.\u001a\u00020\rH\u0016J\t\u0010/\u001a\u00020\u0004HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\rHÖ\u0001R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u00065"}, d2 = {"Lcom/ss/android/ugc/aweme/sticker/model/LibraryVideo;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "id", "", QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, "audioPath", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "", "audioDuration", "originalImageCopyPath", "rawFilePath", "materialProvider", "", "materialType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAudioDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAudioPath", "()Ljava/lang/String;", "getId", "getMaterialProvider", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaterialType", "getOriginalImageCopyPath", "getRawFilePath", "getVideoDuration", "getVideoPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ss/android/ugc/aweme/sticker/model/LibraryVideo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class LibraryVideo implements Serializable, Parcelable {
    public static final Parcelable.Creator<LibraryVideo> CREATOR = null;

    @SerializedName(alternate = {"e"}, value = "audio_duration")
    private final Long audioDuration;

    @SerializedName(alternate = {"c"}, value = "audioPath")
    @CreativePath
    private final String audioPath;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName(alternate = {BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY}, value = "id")
    private final String f454278id;

    @SerializedName(alternate = {"h"}, value = "material_provider")
    private final Integer materialProvider;

    @SerializedName(alternate = {ce.f26395j}, value = "material_type")
    private final Integer materialType;

    @SerializedName(alternate = {"f"}, value = "original_image_copy_path")
    @CreativePath
    private final String originalImageCopyPath;

    @SerializedName(alternate = {ce.f26391f}, value = "raw_file_path")
    @CreativePath
    private final String rawFilePath;

    @SerializedName(alternate = {"d"}, value = "video_duration")
    private final Long videoDuration;

    @SerializedName(alternate = {"b"}, value = QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH)
    @CreativePath
    private final String videoPath;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<LibraryVideo> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final LibraryVideo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            Long r103 = Long.valueOf(r110.readLong());
        L7:
            if (r110.readInt() == 0) goto L9;
            Long r104 = Long.valueOf(r110.readLong());
        L10:
            String r105 = r110.readString();
            String r106 = r110.readString();
            if (r110.readInt() == 0) goto L13;
            Integer r111 = Integer.valueOf(r110.readInt());
        L15:
            if (r110.readInt() == 0) goto L17;
            Integer r112 = Integer.valueOf(r110.readInt());
        L19:
            return new LibraryVideo(r100, r101, r102, r103, r104, r105, r106, r111, r112);
        L17:
            r112 = null;
            goto L19
        L13:
            r111 = null;
            goto L15
        L9:
            r104 = null;
            goto L10
        L5:
            r103 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final LibraryVideo[] newArray(int r100) {
            return new LibraryVideo[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public LibraryVideo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ LibraryVideo copy$default(LibraryVideo r110, String r111, String r112, String r113, Long r114, Long r115, String r116, String r117, Integer r118, Integer r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.f454278id;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.videoPath;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.audioPath;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Long r103 = r110.videoDuration;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Long r104 = r110.audioDuration;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.originalImageCopyPath;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.rawFilePath;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r107 = r110.materialProvider;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Integer r108 = r110.materialType;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
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

    public final String component1() {
        return this.f454278id;
    }

    public final String component2() {
        return this.videoPath;
    }

    public final String component3() {
        return this.audioPath;
    }

    public final Long component4() {
        return this.videoDuration;
    }

    public final Long component5() {
        return this.audioDuration;
    }

    public final String component6() {
        return this.originalImageCopyPath;
    }

    public final String component7() {
        return this.rawFilePath;
    }

    public final Integer component8() {
        return this.materialProvider;
    }

    public final Integer component9() {
        return this.materialType;
    }

    public final LibraryVideo copy(String r110, String r111, String r112, Long r113, Long r114, String r115, String r116, Integer r117, Integer r210) {
        return new LibraryVideo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "LibraryVideo(id=" + this.f454278id + ", videoPath=" + this.videoPath + ", audioPath=" + this.audioPath + ", videoDuration=" + this.videoDuration + ", audioDuration=" + this.audioDuration + ", originalImageCopyPath=" + this.originalImageCopyPath + ", rawFilePath=" + this.rawFilePath + ", materialProvider=" + this.materialProvider + ", materialType=" + this.materialType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f454278id);
        r100.writeString(this.videoPath);
        r100.writeString(this.audioPath);
        Long r102 = this.videoDuration;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
    L6:
        Long r103 = this.audioDuration;
        if (r103 == null) goto L9;
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
    L10:
        r100.writeString(this.originalImageCopyPath);
        r100.writeString(this.rawFilePath);
        Integer r104 = this.materialProvider;
        if (r104 == null) goto L13;
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
    L14:
        Integer r105 = this.materialType;
        if (r105 == null) goto L17;
        r100.writeInt(1);
        r100.writeInt(r105.intValue());
        return;
    L17:
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(0);
        goto L14
    L9:
        r100.writeInt(0);
        goto L10
    L5:
        r100.writeInt(0);
        goto L6
    }

    public int hashCode() {
        String r100 = this.videoPath;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final Long getAudioDuration() {
        return this.audioDuration;
    }

    public final String getAudioPath() {
        return this.audioPath;
    }

    public final String getId() {
        return this.f454278id;
    }

    public final Integer getMaterialProvider() {
        return this.materialProvider;
    }

    public final Integer getMaterialType() {
        return this.materialType;
    }

    public final String getOriginalImageCopyPath() {
        return this.originalImageCopyPath;
    }

    public final String getRawFilePath() {
        return this.rawFilePath;
    }

    public final Long getVideoDuration() {
        return this.videoDuration;
    }

    public final String getVideoPath() {
        return this.videoPath;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof LibraryVideo) == false) goto L10;
        LibraryVideo r101 = (LibraryVideo) r100;
        if (Intrinsics.areEqual(this.videoPath, r101.videoPath) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.audioPath, r101.audioPath) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public LibraryVideo(String r100, String r101, String r102, Long r103, Long r104, String r105, String r106, Integer r107, Integer r108) {
        this.f454278id = r100;
        this.videoPath = r101;
        this.audioPath = r102;
        this.videoDuration = r103;
        this.audioDuration = r104;
        this.originalImageCopyPath = r105;
        this.rawFilePath = r106;
        this.materialProvider = r107;
        this.materialType = r108;
    }

    public /* synthetic */ LibraryVideo(String r110, String r111, String r112, Long r113, Long r114, String r115, String r116, Integer r117, Integer r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = "";
    L6:
        Integer r101 = null;
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Long r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Long r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r101 = r118;
    L38:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r101);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
