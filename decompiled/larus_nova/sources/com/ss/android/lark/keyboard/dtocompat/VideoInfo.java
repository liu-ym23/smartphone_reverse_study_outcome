package com.ss.android.lark.keyboard.dtocompat;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000fR\u001a\u0010 \u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000fR\u001a\u0010#\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000f¨\u0006&"}, d2 = {"Lcom/ss/android/lark/keyboard/dtocompat/VideoInfo;", "Ljava/io/Serializable;", "path", "", "compressPath", DBDefinition.MIME_TYPE, "size", "", "duration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getPath", "()Ljava/lang/String;", "getCompressPath", "setCompressPath", "(Ljava/lang/String;)V", "getMimeType", "getSize", "()J", "getDuration", "key", "getKey", "setKey", "originImage", "Lcom/ss/android/lark/widget/richtext/Image;", "getOriginImage", "()Lcom/ss/android/lark/widget/richtext/Image;", "setOriginImage", "(Lcom/ss/android/lark/widget/richtext/Image;)V", "url", "getUrl", "setUrl", "mediaUploadId", "getMediaUploadId", "setMediaUploadId", "imageUploadId", "getImageUploadId", "setImageUploadId", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoInfo implements Serializable {
    private String compressPath;
    private final long duration;
    private String imageUploadId;
    private String key;
    private String mediaUploadId;
    private final String mimeType;
    private com.ss.android.lark.widget.richtext.Image originImage;
    private final String path;
    private final long size;
    private String url;

    public final String getCompressPath() {
        return this.compressPath;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getImageUploadId() {
        return this.imageUploadId;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMediaUploadId() {
        return this.mediaUploadId;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final com.ss.android.lark.widget.richtext.Image getOriginImage() {
        return this.originImage;
    }

    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCompressPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.compressPath = r100;
    }

    public final void setImageUploadId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.imageUploadId = r100;
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public final void setMediaUploadId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mediaUploadId = r100;
    }

    public final void setOriginImage(com.ss.android.lark.widget.richtext.Image r100) {
        this.originImage = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public VideoInfo(String r100, String r101, String r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "compressPath");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.MIME_TYPE);
        this.path = r100;
        this.compressPath = r101;
        this.mimeType = r102;
        this.size = r103;
        this.duration = r104;
        this.key = "";
        this.url = "";
        this.mediaUploadId = "";
        this.imageUploadId = "";
    }
}
