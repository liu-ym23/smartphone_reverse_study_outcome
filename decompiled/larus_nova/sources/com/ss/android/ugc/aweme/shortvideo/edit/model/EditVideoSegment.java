package com.ss.android.ugc.aweme.shortvideo.edit.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.aweme.creative.CreativePath;
import com.ss.android.ugc.aweme.creative.CreativeSuppressCheck;
import com.ss.android.ugc.aweme.creative.PublicPath;
import com.ss.android.ugc.aweme.draft.DraftTransMark;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B!\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ4\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\b\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020$H\u0016R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u0006*"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/edit/model/EditVideoSegment;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, "", "audioPath", "videoFileInfo", "Lcom/ss/android/ugc/aweme/shortvideo/edit/model/VideoFileInfo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/shortvideo/edit/model/VideoFileInfo;)V", "getAudioPath", "()Ljava/lang/String;", "setAudioPath", "(Ljava/lang/String;)V", "isImage", "", "()Z", "setImage", "(Z)V", "muxPath", "getMuxPath", "setMuxPath", "videoCutInfo", "Lcom/ss/android/ugc/aweme/shortvideo/edit/model/VideoCutInfo;", "getVideoCutInfo", "()Lcom/ss/android/ugc/aweme/shortvideo/edit/model/VideoCutInfo;", "setVideoCutInfo", "(Lcom/ss/android/ugc/aweme/shortvideo/edit/model/VideoCutInfo;)V", "getVideoFileInfo", "()Lcom/ss/android/ugc/aweme/shortvideo/edit/model/VideoFileInfo;", "getVideoPath", "setVideoPath", "copy", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "lib-api_release"}, k = 1, mv = {1, 4, 1})
@CreativeSuppressCheck
public class EditVideoSegment implements Parcelable, Serializable {
    public static final Parcelable.Creator<EditVideoSegment> CREATOR = null;
    public static final Companion Companion = null;

    @CreativePath
    @DraftTransMark
    private String audioPath;
    private transient boolean isImage;
    private transient String muxPath;
    private VideoCutInfo videoCutInfo;
    private final VideoFileInfo videoFileInfo;

    @CreativePath(blockCreative = true)
    @DraftTransMark
    @PublicPath
    private String videoPath;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/edit/model/EditVideoSegment$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/shortvideo/edit/model/EditVideoSegment;", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    public final EditVideoSegment copy() {
        return copy$default(this, null, null, null, null, 15, null);
    }

    public final EditVideoSegment copy(String r100) {
        return copy$default(this, r100, null, null, null, 14, null);
    }

    public final EditVideoSegment copy(String r100, String r101) {
        return copy$default(this, r100, r101, null, null, 12, null);
    }

    public final EditVideoSegment copy(String r100, String r101, VideoFileInfo r110) {
        return copy$default(this, r100, r101, r110, null, 8, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        Companion = new Companion(0);
        CREATOR = new EditVideoSegment$Companion$CREATOR$1();
    }

    public final String getAudioPath() {
        return this.audioPath;
    }

    public final String getMuxPath() {
        return this.muxPath;
    }

    public final VideoCutInfo getVideoCutInfo() {
        return this.videoCutInfo;
    }

    public final VideoFileInfo getVideoFileInfo() {
        return this.videoFileInfo;
    }

    public final String getVideoPath() {
        return this.videoPath;
    }

    public final boolean isImage() {
        return this.isImage;
    }

    public EditVideoSegment(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        String r101 = r100.readString();
        if (r101 == null) goto L15;
        String r102 = r100.readString();
        VideoFileInfo r103 = (VideoFileInfo) r100.readParcelable(VideoFileInfo.class.getClassLoader());
        if (r103 == null) goto L13;
        this(r101, r102, r103);
        this.videoCutInfo = (VideoCutInfo) r100.readParcelable(VideoCutInfo.class.getClassLoader());
        boolean r104 = true;
        if (r100.readInt() == 1) goto L10;
        r104 = false;
    L10:
        this.isImage = r104;
        return;
    L13:
        throw new IllegalArgumentException("create EditVideoSegment instance with invalid VideoFileInfo");
    L15:
        throw new IllegalArgumentException("create EditVideoSegment instance with invalid videoPath");
    }

    public final void setAudioPath(String r100) {
        this.audioPath = r100;
    }

    public final void setImage(boolean r100) {
        this.isImage = r100;
    }

    public final void setMuxPath(String r100) {
        this.muxPath = r100;
    }

    public final void setVideoCutInfo(VideoCutInfo r100) {
        this.videoCutInfo = r100;
    }

    public final void setVideoPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoPath = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.videoPath);
        r100.writeString(this.audioPath);
        r100.writeParcelable(this.videoFileInfo, r101);
        r100.writeParcelable(this.videoCutInfo, r101);
        r100.writeInt(this.isImage ? 1 : 0);
    }

    public EditVideoSegment(String r100, String r101, VideoFileInfo r102) {
        Intrinsics.checkNotNullParameter(r100, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        Intrinsics.checkNotNullParameter(r102, "videoFileInfo");
        this.videoPath = r100;
        this.audioPath = r101;
        this.videoFileInfo = r102;
    }

    public final EditVideoSegment copy(String r100, String r101, VideoFileInfo r102, VideoCutInfo r103) {
        Intrinsics.checkNotNullParameter(r100, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        Intrinsics.checkNotNullParameter(r102, "videoFileInfo");
        EditVideoSegment r104 = new EditVideoSegment(r100, r101, r102);
        r104.videoCutInfo = r103;
        return r104;
    }

    public /* synthetic */ EditVideoSegment(String r100, String r101, VideoFileInfo r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, r102);
    }

    public static /* synthetic */ EditVideoSegment copy$default(EditVideoSegment r110, String r111, String r112, VideoFileInfo r210, VideoCutInfo r211, int r212, Object r213) {
        if (r213 != null) goto L26;
        if ((r212 & 1) == 0) goto L7;
        String r100 = r110.videoPath;
    L9:
        if ((r212 & 2) == 0) goto L11;
        String r101 = r110.audioPath;
    L13:
        if ((r212 & 4) == 0) goto L15;
        VideoFileInfo r102 = VideoFileInfo.copy$default(r110.videoFileInfo, 0, 0, 0, 0, 0, 0, 0, 0, 0.0f, 511, null);
    L17:
        if ((r212 & 8) == 0) goto L22;
        VideoCutInfo r103 = r110.videoCutInfo;
        if (r103 == null) goto L21;
        VideoCutInfo r104 = VideoCutInfo.copy$default(r103, 0, 0, 0.0f, 0, 15, null);
    L24:
        return r110.copy(r100, r101, r102, r104);
    L21:
        r104 = null;
        goto L24
    L22:
        r104 = r211;
        goto L24
    L15:
        r102 = r210;
        goto L17
    L11:
        r101 = r112;
        goto L13
    L7:
        r100 = r111;
        goto L9
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }
}
