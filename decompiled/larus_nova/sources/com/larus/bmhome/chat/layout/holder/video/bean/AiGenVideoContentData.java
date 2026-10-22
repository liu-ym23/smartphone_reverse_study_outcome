package com.larus.bmhome.chat.layout.holder.video.bean;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.im.bean.message.CreationTaskType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001=B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018Jª\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b'\u0010\u0018¨\u0006>"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/video/bean/AiGenVideoContentData;", "Ljava/io/Serializable;", "vid", "", "loadingWidth", "", "loadingHeight", "videoStatus", "videoCover", "Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverItem;", "videoModel", "localUrl", "downloadUrl", "downloadFilehash", "duration", "", "videoType", "mobileSupport", "taskType", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getVid", "()Ljava/lang/String;", "getLoadingWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLoadingHeight", "getVideoStatus", "getVideoCover", "()Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverItem;", "getVideoModel", "getLocalUrl", "getDownloadUrl", "getDownloadFilehash", "getDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVideoType", "getMobileSupport", "getTaskType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/layout/holder/video/bean/AiGenVideoContentData;", "equals", "", "other", "", "hashCode", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiGenVideoContentData implements Serializable {
    public static final a Companion = null;

    @SerializedName("download_filehash")
    private final String downloadFilehash;

    @SerializedName("download_url")
    private final String downloadUrl;

    @SerializedName("duration")
    private final Double duration;

    @SerializedName("loading_height")
    private final Integer loadingHeight;

    @SerializedName("loading_width")
    private final Integer loadingWidth;

    @SerializedName("local_url")
    private final String localUrl;

    @SerializedName("mobile_supported")
    private final String mobileSupport;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private final Integer taskType;

    @SerializedName("vid")
    private final String vid;

    @SerializedName("cover")
    private final CoverItem videoCover;

    @SerializedName("video_model")
    private final String videoModel;

    @SerializedName("video_status")
    private final String videoStatus;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_VIDEO_TYPE)
    private final String videoType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AiGenVideoContentData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public static /* synthetic */ AiGenVideoContentData copy$default(AiGenVideoContentData r110, String r111, Integer r112, Integer r113, String r114, CoverItem r115, String r210, String r211, String r212, String r213, Double r214, String r215, String r216, Integer r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.vid;
    L7:
        if ((r218 & 2) == 0) goto L9;
        Integer r101 = r110.loadingWidth;
    L11:
        if ((r218 & 4) == 0) goto L13;
        Integer r102 = r110.loadingHeight;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.videoStatus;
    L19:
        if ((r218 & 16) == 0) goto L21;
        CoverItem r104 = r110.videoCover;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r105 = r110.videoModel;
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r106 = r110.localUrl;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.downloadUrl;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.downloadFilehash;
    L39:
        if ((r218 & 512) == 0) goto L41;
        Double r117 = r110.duration;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r118 = r110.videoType;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        String r119 = r110.mobileSupport;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        Integer r108 = r110.taskType;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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
        return this.vid;
    }

    public final Double component10() {
        return this.duration;
    }

    public final String component11() {
        return this.videoType;
    }

    public final String component12() {
        return this.mobileSupport;
    }

    public final Integer component13() {
        return this.taskType;
    }

    public final Integer component2() {
        return this.loadingWidth;
    }

    public final Integer component3() {
        return this.loadingHeight;
    }

    public final String component4() {
        return this.videoStatus;
    }

    public final CoverItem component5() {
        return this.videoCover;
    }

    public final String component6() {
        return this.videoModel;
    }

    public final String component7() {
        return this.localUrl;
    }

    public final String component8() {
        return this.downloadUrl;
    }

    public final String component9() {
        return this.downloadFilehash;
    }

    public final AiGenVideoContentData copy(String r110, Integer r111, Integer r112, String r113, CoverItem r210, String r211, String r212, String r213, String r214, Double r215, String r216, String r217, @CreationTaskType Integer r218) {
        return new AiGenVideoContentData(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AiGenVideoContentData) == true) goto L8;
        return false;
    L8:
        AiGenVideoContentData r101 = (AiGenVideoContentData) r100;
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.loadingWidth, r101.loadingWidth) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.loadingHeight, r101.loadingHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoStatus, r101.videoStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.videoCover, r101.videoCover) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.videoModel, r101.videoModel) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.localUrl, r101.localUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.downloadUrl, r101.downloadUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.downloadFilehash, r101.downloadFilehash) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.videoType, r101.videoType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.mobileSupport, r101.mobileSupport) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.taskType, r101.taskType) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        String r100 = this.vid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.loadingWidth;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.loadingHeight;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.videoStatus;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        CoverItem r113 = this.videoCover;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.videoModel;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.localUrl;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.downloadUrl;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.downloadFilehash;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Double r128 = this.duration;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.videoType;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.mobileSupport;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.taskType;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "AiGenVideoContentData(vid=" + this.vid + ", loadingWidth=" + this.loadingWidth + ", loadingHeight=" + this.loadingHeight + ", videoStatus=" + this.videoStatus + ", videoCover=" + this.videoCover + ", videoModel=" + this.videoModel + ", localUrl=" + this.localUrl + ", downloadUrl=" + this.downloadUrl + ", downloadFilehash=" + this.downloadFilehash + ", duration=" + this.duration + ", videoType=" + this.videoType + ", mobileSupport=" + this.mobileSupport + ", taskType=" + this.taskType + ')';
    }

    public final String getDownloadFilehash() {
        return this.downloadFilehash;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final Double getDuration() {
        return this.duration;
    }

    public final Integer getLoadingHeight() {
        return this.loadingHeight;
    }

    public final Integer getLoadingWidth() {
        return this.loadingWidth;
    }

    public final String getLocalUrl() {
        return this.localUrl;
    }

    public final String getMobileSupport() {
        return this.mobileSupport;
    }

    public final Integer getTaskType() {
        return this.taskType;
    }

    public final String getVid() {
        return this.vid;
    }

    public final CoverItem getVideoCover() {
        return this.videoCover;
    }

    public final String getVideoModel() {
        return this.videoModel;
    }

    public final String getVideoStatus() {
        return this.videoStatus;
    }

    public final String getVideoType() {
        return this.videoType;
    }

    public AiGenVideoContentData(String r100, Integer r101, Integer r102, String r103, CoverItem r104, String r105, String r106, String r107, String r108, Double r110, String r111, String r112, @CreationTaskType Integer r113) {
        this.vid = r100;
        this.loadingWidth = r101;
        this.loadingHeight = r102;
        this.videoStatus = r103;
        this.videoCover = r104;
        this.videoModel = r105;
        this.localUrl = r106;
        this.downloadUrl = r107;
        this.downloadFilehash = r108;
        this.duration = r110;
        this.videoType = r111;
        this.mobileSupport = r112;
        this.taskType = r113;
    }

    public /* synthetic */ AiGenVideoContentData(String r110, Integer r111, Integer r112, String r113, CoverItem r114, String r210, String r211, String r212, String r213, Double r214, String r215, String r216, Integer r217, int r218, DefaultConstructorMarker r219) {
        String r100 = "";
        if ((r218 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r218 & 2) == 0) goto L9;
        Integer r102 = 512;
    L11:
        if ((r218 & 4) == 0) goto L13;
        Integer r103 = 512;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r218 & 16) == 0) goto L21;
        CoverItem r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r115 = "";
    L39:
        if ((r218 & 512) == 0) goto L41;
        Double r116 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r117 = "mp4";
    L47:
        if ((r218 & 2048) != 0) goto L51;
        r100 = r216;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        Integer r109 = 0;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r100, r109);
        return;
    L53:
        r109 = r217;
        goto L54
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
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
        r101 = r110;
        goto L7
    }
}
