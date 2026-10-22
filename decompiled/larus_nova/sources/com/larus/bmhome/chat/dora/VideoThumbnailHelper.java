package com.larus.bmhome.chat.dora;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class VideoThumbnailHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f302937a = 0;

    static {
    }

    public VideoThumbnailHelper() {
    }

    public static Object b(Context r100, String r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2(r101, r100, null), r102);
    }

    public static void c(Bitmap r100, PolarisFileWrapper r101, int r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101.getParent(), r101.getName() + DefaultDiskStorage.FileType.TEMP);
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Exception -> L13
        r100.compress(Bitmap.CompressFormat.JPEG, r102, r104);     // Catch: Throwable -> L8
        r104.flush();     // Catch: Throwable -> L8
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        CloseableKt.closeFinally(r104, null);     // Catch: Exception -> L13
        r103.renameTo(r101);     // Catch: Exception -> L13
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        r103.delete();
        e.printStackTrace();
    }

    public static Object a(Context r100, String r101, String r102, Continuation r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2(r102, r101, r100, null), r103);
    }
}
