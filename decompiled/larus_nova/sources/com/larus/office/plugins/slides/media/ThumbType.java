package com.larus.office.plugins.slides.media;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006'"}, d2 = {"Lcom/larus/office/plugins/slides/media/ThumbType;", "", "contentType", "", "fileName", "duration", "", "fileSize", "", "height", "width", "src", ST.UUID_DEVICE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "getFileName", "setFileName", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFileSize", "()Ljava/lang/Long;", "setFileSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getHeight", "setHeight", "getWidth", "setWidth", "getSrc", "setSrc", "getUuid", "setUuid", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbType {

    @SerializedName("contentType")
    private String contentType;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("fileName")
    private String fileName;

    @SerializedName("fileSize")
    private Long fileSize;

    @SerializedName("height")
    private Integer height;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    @SerializedName("src")
    private String f363267src;

    @SerializedName(ST.UUID_DEVICE)
    private String uuid;

    @SerializedName("width")
    private Integer width;

    public ThumbType() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getSrc() {
        return this.f363267src;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setContentType(String r100) {
        this.contentType = r100;
    }

    public final void setDuration(Integer r100) {
        this.duration = r100;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setFileSize(Long r100) {
        this.fileSize = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setSrc(String r100) {
        this.f363267src = r100;
    }

    public final void setUuid(String r100) {
        this.uuid = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }

    public ThumbType(String r100, String r101, Integer r102, Long r103, Integer r104, Integer r105, String r106, String r107) {
        this.contentType = r100;
        this.fileName = r101;
        this.duration = r102;
        this.fileSize = r103;
        this.height = r104;
        this.width = r105;
        this.f363267src = r106;
        this.uuid = r107;
    }

    public /* synthetic */ ThumbType(String r110, String r111, Integer r112, Long r113, Integer r114, Integer r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Integer r103 = 0;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Long r104 = 0L;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Integer r105 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Integer r106 = 0;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
