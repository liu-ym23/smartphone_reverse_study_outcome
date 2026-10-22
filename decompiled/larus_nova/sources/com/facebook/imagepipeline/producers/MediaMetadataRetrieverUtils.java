package com.facebook.imagepipeline.producers;

import android.media.MediaMetadataRetriever;
import com.facebook.common.logging.FLog;

/* JADX INFO: loaded from: classes23.dex */
public class MediaMetadataRetrieverUtils {
    public static final String TAG = "MediaMetadataRetrieverUtils";
    private static final ThreadLocal<MediaMetadataRetriever> threadLocalRetriever = null;

    public MediaMetadataRetrieverUtils() {
    }

    static {
        threadLocalRetriever = new AnonymousClass1();
    }

    public static MediaMetadataRetriever getRetriever() {
        ThreadLocal<MediaMetadataRetriever> r100 = threadLocalRetriever;
        MediaMetadataRetriever r101 = r100.get();
        if (r101 != null) goto L6;
        MediaMetadataRetriever r102 = new MediaMetadataRetriever();
        r100.set(r102);
        return r102;
    L6:
        return r101;
    }

    public static void releaseRetriever() {
        ThreadLocal<MediaMetadataRetriever> r100 = threadLocalRetriever;
        MediaMetadataRetriever r101 = r100.get();
        if (r101 == null) goto L6;
        release(r101);
        r100.remove();
        return;
    }

    public static void release(MediaMetadataRetriever r100) {
        if (r100 == null) goto L10;
        r100.release();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        FLog.e(TAG, "release error", th);
        return;
    }
}
