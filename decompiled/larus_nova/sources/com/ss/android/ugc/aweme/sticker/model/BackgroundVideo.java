package com.ss.android.ugc.aweme.sticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.creative.CreativePath;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/aweme/sticker/model/BackgroundVideo;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, "", "audioPath", "maxDuration", "", "isMultiBgVideo", "", "endTime", "uid", "(Ljava/lang/String;Ljava/lang/String;JZJLjava/lang/String;)V", "getAudioPath", "()Ljava/lang/String;", "getEndTime", "()J", "setEndTime", "(J)V", "()Z", "getMaxDuration", "getUid", "getVideoPath", "describeContents", "", "equals", "other", "", "hashCode", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class BackgroundVideo implements Serializable, Parcelable {
    public static final Parcelable.Creator<BackgroundVideo> CREATOR = null;

    @SerializedName("audioPath")
    @CreativePath
    private final String audioPath;

    @SerializedName("endTime")
    private long endTime;

    @SerializedName("isMultiBgVideo")
    private final boolean isMultiBgVideo;

    @SerializedName("maxDuration")
    private final long maxDuration;

    @SerializedName("uid")
    private final String uid;

    @SerializedName(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH)
    @CreativePath
    private final String videoPath;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<BackgroundVideo> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final BackgroundVideo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            String r100 = r110.readString();
            String r101 = r110.readString();
            long r102 = r110.readLong();
            if (r110.readInt() == 0) goto L5;
            boolean r103 = true;
        L7:
            return new BackgroundVideo(r100, r101, r102, r103, r110.readLong(), r110.readString());
        L5:
            r103 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BackgroundVideo[] newArray(int r100) {
            return new BackgroundVideo[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.videoPath);
        r100.writeString(this.audioPath);
        r100.writeLong(this.maxDuration);
        r100.writeInt(this.isMultiBgVideo ? 1 : 0);
        r100.writeLong(this.endTime);
        r100.writeString(this.uid);
    }

    public int hashCode() {
        return this.videoPath.hashCode();
    }

    public final String getAudioPath() {
        return this.audioPath;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getMaxDuration() {
        return this.maxDuration;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getVideoPath() {
        return this.videoPath;
    }

    public final boolean isMultiBgVideo() {
        return this.isMultiBgVideo;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof BackgroundVideo) == false) goto L10;
        BackgroundVideo r101 = (BackgroundVideo) r100;
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

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public BackgroundVideo(String r100, String r101, long r102, boolean r103, long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        Intrinsics.checkNotNullParameter(r101, "audioPath");
        Intrinsics.checkNotNullParameter(r105, "uid");
        this.videoPath = r100;
        this.audioPath = r101;
        this.maxDuration = r102;
        this.isMultiBgVideo = r103;
        this.endTime = r104;
        this.uid = r105;
    }

    public /* synthetic */ BackgroundVideo(String r110, String r111, long r112, boolean r113, long r114, String r115, int r116, DefaultConstructorMarker r210) {
        if ((r116 & 8) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r116 & 16) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r116 & 32) == 0) goto L13;
        String r102 = UUID.randomUUID().toString();
    L14:
        this(r110, r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
