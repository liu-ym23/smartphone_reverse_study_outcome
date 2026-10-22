package com.ss.bytertc.engine;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class TranscodingDataManager {
    private static Context mContext;

    public TranscodingDataManager() {
    }

    public static native void nativeEndProcessRoomRegionTranscodingData(String r100);

    public static native void nativeProcessRoomRegionTranscodingData(int r100, String r101, String r102, byte[] r103, int r104, int r105);

    public static native void nativeStartProcessRoomRegionTranscodingData(String r100);

    public static void SetContext(Context r100) {
        mContext = r100;
    }

    public static byte[] getCompressImageBuf(ByteBuffer r100, int r101, int r102) {
        Bitmap r103 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        r103.copyPixelsFromBuffer(r100);
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
        r103.compress(Bitmap.CompressFormat.JPEG, 70, r104);
        return r104.toByteArray();
    }
}
