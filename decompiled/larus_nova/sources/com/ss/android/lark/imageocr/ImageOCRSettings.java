package com.ss.android.lark.imageocr;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "image_ocr_settings")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/imageocr/ImageOCRSettings;", "", "<init>", "()V", "textConfidence", "", "getTextConfidence", "()F", "imageocr_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageOCRSettings {

    @SerializedName("ocr_text_confidence")
    private final float textConfidence;

    public ImageOCRSettings() {
        this.textConfidence = 0.5f;
    }

    public final float a() {
        return this.textConfidence;
    }
}
