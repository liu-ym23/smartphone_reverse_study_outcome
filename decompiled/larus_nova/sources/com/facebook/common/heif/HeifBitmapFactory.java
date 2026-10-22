package com.facebook.common.heif;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.facebook.common.webp.BitmapCreator;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface HeifBitmapFactory {
    Bitmap decodeByNativePtr(long r100, int r101, Rect r102, BitmapFactory.Options r103, HeifDecodeData r104);

    Bitmap decodeByNativePtrCombineSr(long r100, int r101, Rect r102, BitmapFactory.Options r103, HeifDecodeData r104, HeicSROptions r105, Map<String, String> r106);

    Bitmap decodeByteArray(byte[] r100, int r101, int r102, BitmapFactory.Options r103);

    Bitmap decodeStream(InputStream r100, Rect r101, BitmapFactory.Options r102);

    Bitmap decodeStream(InputStream r100, Rect r101, BitmapFactory.Options r102, HeifDecodeData r103);

    Bitmap decodeThumb(InputStream r100, Rect r101, BitmapFactory.Options r102);

    Bitmap decodeThumb(InputStream r100, Rect r101, BitmapFactory.Options r102, HeifDecodeData r103);

    Bitmap decodeThumbByNativePtr(long r100, int r101, int r102, int r103, Rect r104, BitmapFactory.Options r105, HeifDecodeData r106);

    void setBitmapCreator(BitmapCreator r100);
}
