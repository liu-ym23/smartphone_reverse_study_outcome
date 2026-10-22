package com.ss.android.lark.imageqrcode.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.ttvecamera.TECameraUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
public final class ImageQRCodeSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f426669a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f426670b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/imageqrcode/utils/ImageQRCodeSettings$ImageQRCodeConfig;", "", "superRatio", "", "superSizeSmallSide", "superSizeBigSide", "<init>", "(III)V", "getSuperRatio", "()I", "setSuperRatio", "(I)V", "getSuperSizeSmallSide", "setSuperSizeSmallSide", "getSuperSizeBigSide", "setSuperSizeBigSide", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ImageQRCodeConfig {

        @SerializedName("super_ratio")
        private int superRatio;

        @SerializedName("super_size_big_side")
        private int superSizeBigSide;

        @SerializedName("super_size_small_side")
        private int superSizeSmallSide;

        public ImageQRCodeConfig() {
            this(0, 0, 0, 7, null);
        }

        public final int getSuperRatio() {
            return this.superRatio;
        }

        public final int getSuperSizeBigSide() {
            return this.superSizeBigSide;
        }

        public final int getSuperSizeSmallSide() {
            return this.superSizeSmallSide;
        }

        public final void setSuperRatio(int r100) {
            this.superRatio = r100;
        }

        public final void setSuperSizeBigSide(int r100) {
            this.superSizeBigSide = r100;
        }

        public final void setSuperSizeSmallSide(int r100) {
            this.superSizeSmallSide = r100;
        }

        public ImageQRCodeConfig(int r100, int r101, int r102) {
            this.superRatio = r100;
            this.superSizeSmallSide = r101;
            this.superSizeBigSide = r102;
        }

        public /* synthetic */ ImageQRCodeConfig(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 3;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 1440;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = TECameraUtils.CAPTURE_HQ_2X;
        L11:
            this(r100, r101, r102);
        }
    }

    @AppConfig(key = "image_qr_code_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/imageqrcode/utils/ImageQRCodeSettings$ImageQRCodeSetting;", "", "<init>", "()V", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ImageQRCodeSetting {
        public ImageQRCodeSetting() {
        }
    }

    static {
        f426669a = LazyKt.lazy(ImageQRCodeSettings$remoteSetting$2.INSTANCE);
        f426670b = LazyKt.lazy(ImageQRCodeSettings$config$2.INSTANCE);
    }
}
