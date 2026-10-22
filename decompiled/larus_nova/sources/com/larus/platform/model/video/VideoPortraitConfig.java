package com.larus.platform.model.video;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/video/VideoPortraitConfig;", "", "enableVideoModel2", "", "enableEditVideo", "enableAvatarCreation", "enableVideoAvatar", "<init>", "(ZZZZ)V", "getEnableVideoModel2", "()Z", "getEnableEditVideo", "getEnableAvatarCreation", "getEnableVideoAvatar", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoPortraitConfig {

    @SerializedName("enable_avatar_creation")
    private final boolean enableAvatarCreation;

    @SerializedName("enable_edit_video")
    private final boolean enableEditVideo;

    @SerializedName("enable_video_avatar")
    private final boolean enableVideoAvatar;

    @SerializedName("enable_model_2_0")
    private final boolean enableVideoModel2;

    public VideoPortraitConfig() {
        this(false, false, false, false, 15, null);
    }

    public static /* synthetic */ VideoPortraitConfig copy$default(VideoPortraitConfig r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.enableVideoModel2;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.enableEditVideo;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.enableAvatarCreation;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.enableVideoAvatar;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.enableVideoModel2;
    }

    public final boolean component2() {
        return this.enableEditVideo;
    }

    public final boolean component3() {
        return this.enableAvatarCreation;
    }

    public final boolean component4() {
        return this.enableVideoAvatar;
    }

    public final VideoPortraitConfig copy(boolean r100, boolean r101, boolean r102, boolean r103) {
        return new VideoPortraitConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoPortraitConfig) == true) goto L8;
        return false;
    L8:
        VideoPortraitConfig r101 = (VideoPortraitConfig) r100;
        if (this.enableVideoModel2 == r101.enableVideoModel2) goto L12;
        return false;
    L12:
        if (this.enableEditVideo == r101.enableEditVideo) goto L15;
        return false;
    L15:
        if (this.enableAvatarCreation == r101.enableAvatarCreation) goto L18;
        return false;
    L18:
        if (this.enableVideoAvatar == r101.enableVideoAvatar) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableVideoModel2 == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableEditVideo == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableAvatarCreation == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enableVideoAvatar == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "VideoPortraitConfig(enableVideoModel2=" + this.enableVideoModel2 + ", enableEditVideo=" + this.enableEditVideo + ", enableAvatarCreation=" + this.enableAvatarCreation + ", enableVideoAvatar=" + this.enableVideoAvatar + ')';
    }

    public final boolean getEnableAvatarCreation() {
        return this.enableAvatarCreation;
    }

    public final boolean getEnableEditVideo() {
        return this.enableEditVideo;
    }

    public final boolean getEnableVideoAvatar() {
        return this.enableVideoAvatar;
    }

    public final boolean getEnableVideoModel2() {
        return this.enableVideoModel2;
    }

    public VideoPortraitConfig(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.enableVideoModel2 = r100;
        this.enableEditVideo = r101;
        this.enableAvatarCreation = r102;
        this.enableVideoAvatar = r103;
    }

    public /* synthetic */ VideoPortraitConfig(boolean r100, boolean r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
