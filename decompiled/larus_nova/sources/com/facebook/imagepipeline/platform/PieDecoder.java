package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.InputStream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class PieDecoder extends OreoDecoder {
    private static final String TAG = "PieDecoder";

    @Nullable
    private final WebpBitmapFactory mWebpBitmapFactory;

    public PieDecoder(BitmapPool r100, int r101, Pools.SynchronizedPool r102) {
        super(r100, r101, r102);
        this.mWebpBitmapFactory = WebpSupportStatus.loadWebpBitmapFactoryIfExists();
    }

    @Override // com.facebook.imagepipeline.platform.OreoDecoder, com.facebook.imagepipeline.platform.DefaultDecoder
    public int getBitmapSize(int r100, int r101, BitmapFactory.Options r102) {
        return super.getBitmapSize(r100, r101, r102);
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public Bitmap decodeBitmap(InputStream r100, BitmapFactory.Options r101, int r102, int r103, Bitmap r104) {
        int r105 = Build.VERSION.SDK_INT;
        if (r105 == 28) goto L7;
        if (r105 == 29) goto L7;
    L9:
        boolean r106 = false;
    L11:
        if (r106 == false) goto L15;
        if (r104 == null) goto L14;
        r104.reconfigure(r102, r103, r101.inPreferredConfig);
    L14:
        Bitmap r107 = this.mWebpBitmapFactory.decodeStream(r100, null, r101);
    L16:
        if (r107 == null) goto L18;
        return r107;
    L18:
        return BitmapFactory.decodeStream(r100, null, r101);
    L15:
        r107 = null;
    L7:
        if (this.mWebpBitmapFactory == null) goto L9;
        r106 = true;
        goto L11
    }
}
