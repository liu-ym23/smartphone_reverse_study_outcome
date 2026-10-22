package com.larus.doc.sdk.impl.generalbiz.state.media;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003BI\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u000fJ\u0006\u0010)\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001a\u0010&\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013¨\u0006*"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectedMediaItemV1;", "", "<init>", "()V", "contentType", "", ST.UUID_DEVICE, "mediaFile", "width", "", "height", "duration", "", "fileSize", "fileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJJLjava/lang/String;)V", "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "getUuid", "setUuid", "getMediaFile", "setMediaFile", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "getDuration", "()J", "setDuration", "(J)V", "getFileSize", "setFileSize", "getFileName", "setFileName", "src", "getSrc", "setSrc", "encodeFilePath", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectedMediaItemV1 {
    private String contentType;
    private long duration;
    private String fileName;
    private long fileSize;
    private int height;
    private String mediaFile;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    private String f331611src;
    private String uuid;
    private int width;

    public final String encodeFilePath() {
        String r100 = this.mediaFile;
        return "docsource://" + this.uuid + r100.substring(StringsKt.lastIndexOf$default(r100, ".", 0, false, 6, null));
    }

    public SelectedMediaItemV1() {
        this.contentType = "";
        this.uuid = "";
        this.mediaFile = "";
        this.fileName = "";
        this.f331611src = "";
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getMediaFile() {
        return this.mediaFile;
    }

    public final String getSrc() {
        return this.f331611src;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setContentType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contentType = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setFileName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileName = r100;
    }

    public final void setFileSize(long r100) {
        this.fileSize = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setMediaFile(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mediaFile = r100;
    }

    public final void setSrc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f331611src = r100;
    }

    public final void setUuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uuid = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public SelectedMediaItemV1(String r100, String r101, String r102, int r103, int r104, long r105, long r106, String r110) {
        Intrinsics.checkNotNullParameter(r100, "contentType");
        Intrinsics.checkNotNullParameter(r101, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r102, "mediaFile");
        Intrinsics.checkNotNullParameter(r110, "fileName");
        this.f331611src = "";
        this.contentType = r100;
        this.uuid = r101;
        this.mediaFile = r102;
        this.width = r103;
        this.height = r104;
        this.duration = r105;
        this.fileSize = r106;
        this.fileName = r110;
    }
}
