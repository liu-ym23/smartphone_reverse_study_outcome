package android.ss.com.vboost;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface IImageThumbFetch {
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 3;
    public static final int TYPE_MICROTHUMBNAIL = 2;
    public static final int TYPE_MICROTHUMBNAIL_SCALE = 1;

    public interface Fetcher {
        Bitmap getThumbnail(int r1, long r2, int r4, int r5, BitmapFactory.Options r6);
    }

    Fetcher createFetcher();
}
