package com.ss.android.lark.chat.base.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@AppConfig(key = "send_image_msg_config")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/base/model/ImageSendConfig;", "", "baseConfig", "Lcom/ss/android/lark/chat/base/model/FormatConfig;", "pngConfig", "jpegConfig", "gifConfig", "<init>", "(Lcom/ss/android/lark/chat/base/model/FormatConfig;Lcom/ss/android/lark/chat/base/model/FormatConfig;Lcom/ss/android/lark/chat/base/model/FormatConfig;Lcom/ss/android/lark/chat/base/model/FormatConfig;)V", "getBaseConfig", "()Lcom/ss/android/lark/chat/base/model/FormatConfig;", "getPngConfig", "getJpegConfig", "getGifConfig", "getConfigByType", DBDefinition.MIME_TYPE, "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageSendConfig {

    @SerializedName("base_config")
    private final FormatConfig baseConfig;

    @SerializedName("gif_config")
    private final FormatConfig gifConfig;

    @SerializedName("jpg_config")
    private final FormatConfig jpegConfig;

    @SerializedName("png_config")
    private final FormatConfig pngConfig;

    public ImageSendConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ImageSendConfig copy$default(ImageSendConfig r100, FormatConfig r101, FormatConfig r102, FormatConfig r103, FormatConfig r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.baseConfig;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.pngConfig;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.jpegConfig;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.gifConfig;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final FormatConfig component1() {
        return this.baseConfig;
    }

    public final FormatConfig component2() {
        return this.pngConfig;
    }

    public final FormatConfig component3() {
        return this.jpegConfig;
    }

    public final FormatConfig component4() {
        return this.gifConfig;
    }

    public final ImageSendConfig copy(FormatConfig r100, FormatConfig r101, FormatConfig r102, FormatConfig r103) {
        Intrinsics.checkNotNullParameter(r100, "baseConfig");
        Intrinsics.checkNotNullParameter(r101, "pngConfig");
        Intrinsics.checkNotNullParameter(r102, "jpegConfig");
        Intrinsics.checkNotNullParameter(r103, "gifConfig");
        return new ImageSendConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageSendConfig) == true) goto L8;
        return false;
    L8:
        ImageSendConfig r101 = (ImageSendConfig) r100;
        if (Intrinsics.areEqual(this.baseConfig, r101.baseConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pngConfig, r101.pngConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.jpegConfig, r101.jpegConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.gifConfig, r101.gifConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.baseConfig.hashCode() * 31) + this.pngConfig.hashCode()) * 31) + this.jpegConfig.hashCode()) * 31) + this.gifConfig.hashCode();
    }

    public String toString() {
        return "ImageSendConfig(baseConfig=" + this.baseConfig + ", pngConfig=" + this.pngConfig + ", jpegConfig=" + this.jpegConfig + ", gifConfig=" + this.gifConfig + ')';
    }

    public final FormatConfig getBaseConfig() {
        return this.baseConfig;
    }

    public final FormatConfig getGifConfig() {
        return this.gifConfig;
    }

    public final FormatConfig getJpegConfig() {
        return this.jpegConfig;
    }

    public final FormatConfig getPngConfig() {
        return this.pngConfig;
    }

    public final FormatConfig getConfigByType(String r100) {
        if (r100 == null) goto L23;
        int r101 = r100.hashCode();
        if (r101 == (-879267568)) goto L19;
        if (r101 == (-879264467)) goto L15;
        if (r101 != (-879258763)) goto L23;
        if (r100.equals("image/png") == false) goto L23;
        return this.pngConfig;
    L15:
        if (r100.equals("image/jpg") == false) goto L23;
        return this.jpegConfig;
    L19:
        if (r100.equals(MimeType.GIF) == false) goto L23;
        return this.gifConfig;
    L23:
        return this.baseConfig;
    }

    public ImageSendConfig(FormatConfig r100, FormatConfig r101, FormatConfig r102, FormatConfig r103) {
        Intrinsics.checkNotNullParameter(r100, "baseConfig");
        Intrinsics.checkNotNullParameter(r101, "pngConfig");
        Intrinsics.checkNotNullParameter(r102, "jpegConfig");
        Intrinsics.checkNotNullParameter(r103, "gifConfig");
        this.baseConfig = r100;
        this.pngConfig = r101;
        this.jpegConfig = r102;
        this.gifConfig = r103;
    }

    public /* synthetic */ ImageSendConfig(FormatConfig r100, FormatConfig r101, FormatConfig r102, FormatConfig r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = new FormatConfig(0, null, 3, null);
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = new FormatConfig(0, new ResolutionSize(8000, 8000), 1, null);
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = new FormatConfig(0, new ResolutionSize(12000, 12000), 1, null);
    L12:
        if ((r111 & 8) == 0) goto L14;
        r110 = new FormatConfig(0, new ResolutionSize(7000, 7000), 1, null);
    L14:
        this(r100, r101, r102, r110);
    }
}
