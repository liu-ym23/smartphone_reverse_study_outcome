package com.facebook.common.webp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.FileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: classes22.dex */
public interface WebpBitmapFactory {

    public interface WebpErrorLogger {
        void onWebpErrorLog(String r100, String r101);
    }

    Bitmap decodeByteArray(byte[] r100, int r101, int r102, BitmapFactory.Options r103);

    Bitmap decodeFile(String r100, BitmapFactory.Options r101);

    Bitmap decodeFileDescriptor(FileDescriptor r100, Rect r101, BitmapFactory.Options r102);

    Bitmap decodeStream(InputStream r100, Rect r101, BitmapFactory.Options r102);

    void setBitmapCreator(BitmapCreator r100);

    void setWebpErrorLogger(WebpErrorLogger r100);
}
