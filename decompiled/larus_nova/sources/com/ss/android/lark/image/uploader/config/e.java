package com.ss.android.lark.image.uploader.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/image/uploader/config/FormatConfig;", "", "<init>", "()V", "limitFileSize", "", "getLimitFileSize", "()J", "limitResolution", "Lcom/ss/android/lark/image/uploader/config/Resolution;", "getLimitResolution", "()Lcom/ss/android/lark/image/uploader/config/Resolution;", "originalModeFormat", "Lcom/ss/android/lark/image/uploader/config/OriginalModeFormat;", "getOriginalModeFormat", "()Lcom/ss/android/lark/image/uploader/config/OriginalModeFormat;", "image-uploader_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("limit_file_size")
    private final long limitFileSize;

    @SerializedName("limit_image_size")
    private final f limitResolution;

    @SerializedName("original_mode_format")
    private final OriginalModeFormat originalModeFormat;

    public e() {
        this.limitFileSize = 26214400;
        this.limitResolution = new f();
        this.originalModeFormat = OriginalModeFormat.IMAGE;
    }

    public final long a() {
        return this.limitFileSize;
    }

    public final f b() {
        return this.limitResolution;
    }

    public final OriginalModeFormat c() {
        return this.originalModeFormat;
    }
}
