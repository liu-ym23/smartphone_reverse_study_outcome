package com.ss.android.lark.image.uploader.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "image_upload_component_config")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/image/uploader/config/ImageUploadConfig;", "", "<init>", "()V", "fileSizeConfig", "Lcom/ss/android/lark/image/uploader/config/FileSizeConfig;", "getFileSizeConfig", "()Lcom/ss/android/lark/image/uploader/config/FileSizeConfig;", "fileTypeConfig", "Lcom/ss/android/lark/image/uploader/config/FileTypeConfig;", "getFileTypeConfig", "()Lcom/ss/android/lark/image/uploader/config/FileTypeConfig;", "compressConfig", "Lcom/ss/android/lark/image/uploader/config/FileCompressConfig;", "getCompressConfig", "()Lcom/ss/android/lark/image/uploader/config/FileCompressConfig;", "transcodeConfig", "Lcom/ss/android/lark/image/uploader/config/TranscodeConfig;", "getTranscodeConfig", "()Lcom/ss/android/lark/image/uploader/config/TranscodeConfig;", "exifConfig", "Lcom/ss/android/lark/image/uploader/config/ExifConfig;", "getExifConfig", "()Lcom/ss/android/lark/image/uploader/config/ExifConfig;", "uploadAvatarConfig", "Lcom/ss/android/lark/image/uploader/config/UploadAvatarConfig;", "getUploadAvatarConfig", "()Lcom/ss/android/lark/image/uploader/config/UploadAvatarConfig;", "image-uploader_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageUploadConfig {

    @SerializedName("file_compress_config")
    private final b compressConfig;

    @SerializedName("remove_exif_config")
    private final a exifConfig;

    @SerializedName("file_size_check_config")
    private final c fileSizeConfig;

    @SerializedName("file_type_check_config")
    private final d fileTypeConfig;

    @SerializedName("client_transcode_config")
    private final g transcodeConfig;

    @SerializedName("avatar_config")
    private final h uploadAvatarConfig;

    public ImageUploadConfig() {
        this.fileSizeConfig = new c();
        this.fileTypeConfig = new d();
        this.compressConfig = new b();
        this.transcodeConfig = new g();
        this.exifConfig = new a();
        this.uploadAvatarConfig = new h();
    }

    public final b getCompressConfig() {
        return this.compressConfig;
    }

    public final a getExifConfig() {
        return this.exifConfig;
    }

    public final c getFileSizeConfig() {
        return this.fileSizeConfig;
    }

    public final d getFileTypeConfig() {
        return this.fileTypeConfig;
    }

    public final g getTranscodeConfig() {
        return this.transcodeConfig;
    }

    public final h getUploadAvatarConfig() {
        return this.uploadAvatarConfig;
    }
}
