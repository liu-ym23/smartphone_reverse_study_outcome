package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/larus/bmhome/rc/FlowResourceMeta;", "", "fileMeta", "Lcom/larus/bmhome/rc/FileResourceMeta;", "imageMeta", "Lcom/larus/bmhome/rc/ImageResourceMeta;", "audioMeta", "Lcom/larus/bmhome/rc/AudioResourceMeta;", "videoMeta", "Lcom/larus/bmhome/rc/VideoResourceMeta;", "fingerprintMeta", "Lcom/larus/bmhome/rc/ResourceFingerprintMeta;", "targetMeta", "Lcom/larus/bmhome/rc/ResourceTargetMeta;", "<init>", "(Lcom/larus/bmhome/rc/FileResourceMeta;Lcom/larus/bmhome/rc/ImageResourceMeta;Lcom/larus/bmhome/rc/AudioResourceMeta;Lcom/larus/bmhome/rc/VideoResourceMeta;Lcom/larus/bmhome/rc/ResourceFingerprintMeta;Lcom/larus/bmhome/rc/ResourceTargetMeta;)V", "getFileMeta", "()Lcom/larus/bmhome/rc/FileResourceMeta;", "getImageMeta", "()Lcom/larus/bmhome/rc/ImageResourceMeta;", "getAudioMeta", "()Lcom/larus/bmhome/rc/AudioResourceMeta;", "getVideoMeta", "()Lcom/larus/bmhome/rc/VideoResourceMeta;", "getFingerprintMeta", "()Lcom/larus/bmhome/rc/ResourceFingerprintMeta;", "getTargetMeta", "()Lcom/larus/bmhome/rc/ResourceTargetMeta;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowResourceMeta {

    @SerializedName("audio_meta")
    private final AudioResourceMeta audioMeta;

    @SerializedName("file_meta")
    private final FileResourceMeta fileMeta;

    @SerializedName("fingerprint_meta")
    private final ResourceFingerprintMeta fingerprintMeta;

    @SerializedName("image_meta")
    private final ImageResourceMeta imageMeta;

    @SerializedName("target_meta")
    private final ResourceTargetMeta targetMeta;

    @SerializedName("video_meta")
    private final VideoResourceMeta videoMeta;

    public FlowResourceMeta() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FlowResourceMeta copy$default(FlowResourceMeta r100, FileResourceMeta r101, ImageResourceMeta r102, AudioResourceMeta r103, VideoResourceMeta r104, ResourceFingerprintMeta r105, ResourceTargetMeta r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.fileMeta;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.imageMeta;
    L8:
        ImageResourceMeta r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.audioMeta;
    L11:
        AudioResourceMeta r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.videoMeta;
    L14:
        VideoResourceMeta r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.fingerprintMeta;
    L17:
        ResourceFingerprintMeta r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.targetMeta;
    L20:
        FileResourceMeta r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final FileResourceMeta component1() {
        return this.fileMeta;
    }

    public final ImageResourceMeta component2() {
        return this.imageMeta;
    }

    public final AudioResourceMeta component3() {
        return this.audioMeta;
    }

    public final VideoResourceMeta component4() {
        return this.videoMeta;
    }

    public final ResourceFingerprintMeta component5() {
        return this.fingerprintMeta;
    }

    public final ResourceTargetMeta component6() {
        return this.targetMeta;
    }

    public final FlowResourceMeta copy(FileResourceMeta r100, ImageResourceMeta r110, AudioResourceMeta r111, VideoResourceMeta r112, ResourceFingerprintMeta r113, ResourceTargetMeta r114) {
        return new FlowResourceMeta(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowResourceMeta) == true) goto L8;
        return false;
    L8:
        FlowResourceMeta r101 = (FlowResourceMeta) r100;
        if (Intrinsics.areEqual(this.fileMeta, r101.fileMeta) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageMeta, r101.imageMeta) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.audioMeta, r101.audioMeta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoMeta, r101.videoMeta) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fingerprintMeta, r101.fingerprintMeta) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.targetMeta, r101.targetMeta) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        FileResourceMeta r100 = this.fileMeta;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ImageResourceMeta r104 = this.imageMeta;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        AudioResourceMeta r107 = this.audioMeta;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        VideoResourceMeta r110 = this.videoMeta;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ResourceFingerprintMeta r113 = this.fingerprintMeta;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        ResourceTargetMeta r116 = this.targetMeta;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "FlowResourceMeta(fileMeta=" + this.fileMeta + ", imageMeta=" + this.imageMeta + ", audioMeta=" + this.audioMeta + ", videoMeta=" + this.videoMeta + ", fingerprintMeta=" + this.fingerprintMeta + ", targetMeta=" + this.targetMeta + ')';
    }

    public final AudioResourceMeta getAudioMeta() {
        return this.audioMeta;
    }

    public final FileResourceMeta getFileMeta() {
        return this.fileMeta;
    }

    public final ResourceFingerprintMeta getFingerprintMeta() {
        return this.fingerprintMeta;
    }

    public final ImageResourceMeta getImageMeta() {
        return this.imageMeta;
    }

    public final ResourceTargetMeta getTargetMeta() {
        return this.targetMeta;
    }

    public final VideoResourceMeta getVideoMeta() {
        return this.videoMeta;
    }

    public FlowResourceMeta(FileResourceMeta r100, ImageResourceMeta r101, AudioResourceMeta r102, VideoResourceMeta r103, ResourceFingerprintMeta r104, ResourceTargetMeta r105) {
        this.fileMeta = r100;
        this.imageMeta = r101;
        this.audioMeta = r102;
        this.videoMeta = r103;
        this.fingerprintMeta = r104;
        this.targetMeta = r105;
    }

    public /* synthetic */ FlowResourceMeta(FileResourceMeta r100, ImageResourceMeta r101, AudioResourceMeta r102, VideoResourceMeta r103, ResourceFingerprintMeta r110, ResourceTargetMeta r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        FileResourceMeta r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        ImageResourceMeta r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        AudioResourceMeta r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        VideoResourceMeta r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        ResourceFingerprintMeta r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        ResourceTargetMeta r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
