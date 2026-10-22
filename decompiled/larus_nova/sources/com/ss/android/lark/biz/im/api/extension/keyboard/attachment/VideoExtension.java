package com.ss.android.lark.biz.im.api.extension.keyboard.attachment;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010-\u001a\u00020\u0003H\u0016J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u00105\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\fHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006>"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/VideoExtension;", "Ljava/io/Serializable;", "vid", "", "path", "cover", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/Image;", SubInfo.KEY_FORMAT, "downloadUrl", "duration", "", "height", "", "width", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "getPath", "setPath", "getCover", "()Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/Image;", "setCover", "(Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/Image;)V", "getFormat", "setFormat", "getDownloadUrl", "setDownloadUrl", "getDuration", "()Ljava/lang/Float;", "setDuration", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getWidth", "setWidth", "getSource", "setSource", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/VideoExtension;", "equals", "", "other", "", "hashCode", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoExtension implements Serializable {

    @SerializedName("cover_image")
    private Image cover;

    @SerializedName("download_url")
    private String downloadUrl;

    @SerializedName("duration")
    private Float duration;

    @SerializedName(a.KEY_VIDEO_TYPE)
    private String format;

    @SerializedName("height")
    private Integer height;

    @SerializedName("path")
    private String path;

    @SerializedName("source")
    private String source;

    @SerializedName("vid")
    private String vid;

    @SerializedName("width")
    private Integer width;

    public VideoExtension() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ VideoExtension copy$default(VideoExtension r110, String r111, String r112, Image r113, String r114, String r115, Float r116, Integer r117, Integer r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.vid;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.path;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Image r102 = r110.cover;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.format;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.downloadUrl;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Float r105 = r110.duration;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Integer r106 = r110.height;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r107 = r110.width;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.source;
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
        return this.vid;
    }

    public final String component2() {
        return this.path;
    }

    public final Image component3() {
        return this.cover;
    }

    public final String component4() {
        return this.format;
    }

    public final String component5() {
        return this.downloadUrl;
    }

    public final Float component6() {
        return this.duration;
    }

    public final Integer component7() {
        return this.height;
    }

    public final Integer component8() {
        return this.width;
    }

    public final String component9() {
        return this.source;
    }

    public final VideoExtension copy(String r110, String r111, Image r112, String r113, String r114, Float r115, Integer r116, Integer r117, String r210) {
        return new VideoExtension(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoExtension) == true) goto L8;
        return false;
    L8:
        VideoExtension r101 = (VideoExtension) r100;
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.format, r101.format) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.downloadUrl, r101.downloadUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.vid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.path;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Image r107 = this.cover;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.format;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.downloadUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.duration;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.height;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.width;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.source;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
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
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final Image getCover() {
        return this.cover;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final Float getDuration() {
        return this.duration;
    }

    public final String getFormat() {
        return this.format;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getVid() {
        return this.vid;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setCover(Image r100) {
        this.cover = r100;
    }

    public final void setDownloadUrl(String r100) {
        this.downloadUrl = r100;
    }

    public final void setDuration(Float r100) {
        this.duration = r100;
    }

    public final void setFormat(String r100) {
        this.format = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setPath(String r100) {
        this.path = r100;
    }

    public final void setSource(String r100) {
        this.source = r100;
    }

    public final void setVid(String r100) {
        this.vid = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }

    public VideoExtension(String r100, String r101, Image r102, String r103, String r104, Float r105, Integer r106, Integer r107, String r108) {
        this.vid = r100;
        this.path = r101;
        this.cover = r102;
        this.format = r103;
        this.downloadUrl = r104;
        this.duration = r105;
        this.height = r106;
        this.width = r107;
        this.source = r108;
    }

    public /* synthetic */ VideoExtension(String r110, String r111, Image r112, String r113, String r114, Float r115, Integer r116, Integer r117, String r118, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Image r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r210 & 32) == 0) goto L25;
        Float r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
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
        r101 = r110;
        goto L7
    }
}
