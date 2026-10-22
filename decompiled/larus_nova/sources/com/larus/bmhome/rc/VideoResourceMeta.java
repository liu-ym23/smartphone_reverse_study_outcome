package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/rc/VideoResourceMeta;", "", "vid", "", "space", "customVideoMeta", "Lcom/larus/platform/model/upload/LocalVideoResourceMeta;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/upload/LocalVideoResourceMeta;)V", "getVid", "()Ljava/lang/String;", "getSpace", "getCustomVideoMeta", "()Lcom/larus/platform/model/upload/LocalVideoResourceMeta;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoResourceMeta {

    @SerializedName("custom_video_meta")
    private final mr9.e customVideoMeta;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    @SerializedName("space")
    private final String f313551space;

    @SerializedName("vid")
    private final String vid;

    public VideoResourceMeta() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VideoResourceMeta copy$default(VideoResourceMeta r100, String r101, String r102, mr9.e r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.vid;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f313551space;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.customVideoMeta;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.vid;
    }

    public final String component2() {
        return this.f313551space;
    }

    public final mr9.e component3() {
        return this.customVideoMeta;
    }

    public final VideoResourceMeta copy(String r100, String r101, mr9.e r102) {
        return new VideoResourceMeta(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoResourceMeta) == true) goto L8;
        return false;
    L8:
        VideoResourceMeta r101 = (VideoResourceMeta) r100;
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313551space, r101.f313551space) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.customVideoMeta, r101.customVideoMeta) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.vid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f313551space;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        mr9.e r107 = this.customVideoMeta;
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
        return "VideoResourceMeta(vid=" + this.vid + ", space=" + this.f313551space + ", customVideoMeta=" + this.customVideoMeta + ')';
    }

    public final mr9.e getCustomVideoMeta() {
        return this.customVideoMeta;
    }

    public final String getSpace() {
        return this.f313551space;
    }

    public final String getVid() {
        return this.vid;
    }

    public VideoResourceMeta(String r100, String r101, mr9.e r102) {
        this.vid = r100;
        this.f313551space = r101;
        this.customVideoMeta = r102;
    }

    public /* synthetic */ VideoResourceMeta(String r100, String r101, mr9.e r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
