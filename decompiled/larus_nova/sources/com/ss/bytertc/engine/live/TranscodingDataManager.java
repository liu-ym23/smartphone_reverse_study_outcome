package com.ss.bytertc.engine.live;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class TranscodingDataManager {
    private static Context mContext;

    public TranscodingDataManager() {
    }

    public static void SetContext(Context r100) {
        mContext = r100;
    }

    public static byte[] getCompressImageBuf(ByteBuffer r100, int r101, int r102, int r103) {
        Bitmap r104 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        r100.rewind();
        r104.copyPixelsFromBuffer(r100);
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();
        r104.compress(Bitmap.CompressFormat.JPEG, r103, r105);
        return r105.toByteArray();
    }
}
