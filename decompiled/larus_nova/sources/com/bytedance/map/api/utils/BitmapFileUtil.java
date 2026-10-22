package com.bytedance.map.api.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.monitor.MapMonitor;
import com.bytedance.map.api.thread.ThreadManager;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes21.dex */
public class BitmapFileUtil {
    private static final String TAG = "BitmapFileUtil";
    private static final ConcurrentHashMap<String, ReadWriteLock> sPathLocks = null;

    public interface WriteCallback {
        void onWriteResult(boolean r100);
    }

    public BitmapFileUtil() {
    }

    public static /* synthetic */ ReadWriteLock a(String r100) {
        return lambda$lockFor$0(r100);
    }

    static {
        sPathLocks = new ConcurrentHashMap();
    }

    private static boolean hasImageExtension(String r100) {
        String r101 = r100.toLowerCase();
        if (r101.endsWith(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == false) goto L5;
    L12:
        return true;
    L5:
        if (r101.endsWith(".jpg") == true) goto L12;
        if (r101.endsWith(".jpeg") == true) goto L12;
        if (r101.endsWith(".webp") == true) goto L12;
        return false;
    }

    private static /* synthetic */ ReadWriteLock lambda$lockFor$0(String r100) {
        return new ReentrantReadWriteLock();
    }

    private static ReadWriteLock lockFor(File r100, String r101) {
        String r102 = new PolarisFileWrapper(r100, r101).getAbsolutePath();
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        ConcurrentHashMap<String, ReadWriteLock> r103 = sPathLocks;
        ReadWriteLock r104 = r103.get(r102);
        if (r104 == null) goto L9;
        return r104;
    L9:
        ReentrantReadWriteLock r105 = new ReentrantReadWriteLock();
        ReadWriteLock r106 = r103.putIfAbsent(r102, r105);
        if (r106 != null) goto L12;
        return r105;
    L12:
        return r106;
    L5:
        return sPathLocks.computeIfAbsent(r102, new a());
    }

    public static Bitmap readBitmap(Context r100, String r101, String r102) {
        return readBitmapInternal(r100, r101, r102);
    }

    private static Bitmap readBitmapInternal(Context r100, String r101, String r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100.getFilesDir(), r101);
        ReadWriteLock r104 = lockFor(r103, r102);
        r104.readLock().lock();
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103, r102);     // Catch: Throwable -> L34
        if (r105.exists() == false) goto L6;
    L42:
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r105);     // Catch: IOException -> L31 Throwable -> L34
        BitmapFactory.Options r107 = new BitmapFactory.Options();     // Catch: Throwable -> L23
        r107.inPreferredConfig = Bitmap.Config.RGB_565;     // Catch: Throwable -> L23
        r107.inDither = true;     // Catch: Throwable -> L23
        Bitmap r108 = BitmapFactory.decodeStream(r106, null, r107);     // Catch: Throwable -> L23
        r106.close();     // Catch: IOException -> L31 Throwable -> L34
        r104.readLock().unlock();
        return r108;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: IOException -> L31 Throwable -> L34
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L31 Throwable -> L34
    L31:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);     // Catch: Throwable -> L34
        MapLogger.e(TAG, "readBitmapInternal error:" + e.getMessage());     // Catch: Throwable -> L34
    L16:
        r104.readLock().unlock();
        return null;
    L6:
        if (hasImageExtension(r102) == true) goto L16;
        String[] r109 = {".jpg", ".jpeg", RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, ".webp"};     // Catch: Throwable -> L34
        int r110 = 0;
    L9:
        if (r110 >= 4) goto L15;
        String r111 = r109[r110];     // Catch: Throwable -> L34
        PolarisFileWrapper r112 = new PolarisFileWrapper(r103, r102 + r111);     // Catch: Throwable -> L34
        if (r112.exists() == true) goto L12;
        r110 = r110 + 1;     // Catch: Throwable -> L34
        goto L9
    L12:
        r104.readLock().unlock();     // Catch: Throwable -> L34
        r104 = lockFor(r103, r102 + r111);     // Catch: Throwable -> L34
        r104.readLock().lock();     // Catch: Throwable -> L34
        r105 = r112;
    L15:
        if (r105.exists() == true) goto L42;
    L34:
        th = move-exception;
        r104.readLock().unlock();
        throw th;
    }

    public static /* synthetic */ boolean access$000(Context r100, Bitmap r101, Bitmap.CompressFormat r102, int r103, String r104, String r105) {
        return writeBitmapInternal(r100, r101, r102, r103, r104, r105);
    }

    private static boolean writeBitmapInternal(Context r100, Bitmap r101, Bitmap.CompressFormat r102, int r103, String r104, String r105) {
        if (r101.isRecycled() == false) goto L5;
        return false;
    L5:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r100.getFilesDir(), r104);
        if (r106.exists() == false) goto L8;
    L10:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106, r105);
        ReadWriteLock r108 = lockFor(r106, r105);
        r108.writeLock().lock();
        PolarisFileOutputStreamWrapper r109 = new PolarisFileOutputStreamWrapper(r107);     // Catch: Throwable -> L24 IOException -> L26
        boolean r110 = r101.compress(r102, r103, r109);     // Catch: Throwable -> L16
        r109.flush();     // Catch: Throwable -> L16
        r109.close();     // Catch: Throwable -> L24 IOException -> L26
        r108.writeLock().unlock();
        return r110;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r109.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: Throwable -> L24 IOException -> L26
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L24 IOException -> L26
    L24:
        th = move-exception;
        r108.writeLock().unlock();
        throw th;
    L26:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);     // Catch: Throwable -> L24
        MapLogger.e(TAG, "writeBitmapInternal error:" + e.getMessage());     // Catch: Throwable -> L24
        r108.writeLock().unlock();
        return false;
    L8:
        if (r106.mkdirs() == true) goto L10;
        return false;
    }

    public static void writeBitmapAsync(final Context r110, final Bitmap r111, final Bitmap.CompressFormat r112, final int r113, final String r114, final String r115, final WriteCallback r116) {
        ThreadManager.getInstance().getDiskThread().execute(new AnonymousClass1(r110, r111, r112, r113, r114, r115, r116));
    }
}
