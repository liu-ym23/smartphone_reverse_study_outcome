package com.ss.android.medialib.qr;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.ss.android.lark.qrcode.ui.h;
import com.ss.android.medialib.model.EnigmaResult;
import com.ss.android.ttve.nativePort.TENativeLibsLoader;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.utils.BitmapLoader;

/* JADX INFO: loaded from: classes38.dex */
public class PicScanner {
    public long handle;
    private a listener;
    private boolean success;

    public interface a {
    }

    private native long nativeCreate();

    private native EnigmaResult nativeGetEnigmaResult(long r100);

    private native void nativeRelease(long r100);

    private native int nativeStart(long r100, Bitmap r101, ScanSettings r102);

    private native void nativeStop(long r100);

    public synchronized void release() {
        monitor-enter(this);
        VELogUtil.i("PicScanner", "release");     // Catch: Throwable -> L11
        long r100 = this.handle;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        VELogUtil.w("PicScanner", "release skip");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        nativeRelease(r100);     // Catch: Throwable -> L11
        this.handle = 0;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public EnigmaResult getEnigmaResult() {
        long r100 = this.handle;
        if (r100 != 0) goto L6;
        return null;
    L6:
        EnigmaResult r101 = nativeGetEnigmaResult(r100);
        if (r101 != null) goto L9;
    L11:
        return r101;
    L9:
        if (r101.getResult() == null) goto L11;
        this.success = true;
        goto L11
    }

    public boolean isValid() {
        if (this.handle == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void stop() {
        long r100 = this.handle;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeStop(r100);
    }

    public PicScanner() {
        this.handle = 0;
        this.success = false;
        this.handle = nativeCreate();
    }

    static {
        TENativeLibsLoader.loadRecorder();
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void onResult(boolean r100) {
        a r101 = this.listener;
        if (r101 == null) goto L27;
        h.a r102 = (h.a) r101;
        r102.getClass();
        if (r100 == true) goto L32;
    L19:
        Object r103 = r102.f439068c;
        monitor-enter(r103);
        r102.f439068c.notifyAll();     // Catch: Throwable -> L24
        monitor-exit(r103);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    L32:
        EnigmaResult r104 = r102.f439066a.getEnigmaResult();     // Catch: Throwable -> L10
        if (r104 == null) goto L19;
        r102.f439067b.setResult(r104.getResult());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        monitor-enter(r102.f439068c);
        r102.f439068c.notifyAll();     // Catch: Throwable -> L16
        throw th;
    L16:
        th = move-exception;
        throw th;
    }

    public void setListener(a r100) {
        this.listener = r100;
    }

    public int start(String r110, ScanSettings r111) {
        if (this.handle != 0) goto L6;
        return -1;
    L6:
        Bitmap r100 = null;
        Bitmap r112 = BitmapLoader.loadBitmap(r110, r111.width, r111.height);     // Catch: Throwable -> L29 OutOfMemoryError -> L35 Exception -> L42
        if (r112 != null) goto L49;
        Bitmap r101 = null;
    L22:
        r100 = r112;
    L23:
        if (r100 == null) goto L28;
        if (r100.isRecycled() == true) goto L28;
        r100.recycle();
    L28:
        return start(r101, r111);
    L49:
        int r102 = r112.getWidth();     // Catch: Throwable -> L17 OutOfMemoryError -> L19 Exception -> L20
        int r103 = r112.getHeight();     // Catch: Throwable -> L17 OutOfMemoryError -> L19 Exception -> L20
        if ((r102 * r103) <= 4000000) goto L12;
        float r104 = (float) (1.0d / Math.sqrt((r102 * r103) / 4000000.0f));     // Catch: Throwable -> L17 OutOfMemoryError -> L19 Exception -> L20
        Matrix r105 = new Matrix();     // Catch: Throwable -> L17 OutOfMemoryError -> L19 Exception -> L20
        r105.postScale(r104, r104);     // Catch: Throwable -> L17 OutOfMemoryError -> L19 Exception -> L20
        r101 = Bitmap.createBitmap(r112, 0, 0, r102, r103, r105, true);     // Catch: Throwable -> L17 OutOfMemoryError -> L19 Exception -> L20
    L14:
        if (r112.isRecycled() == true) goto L22;
        r112.recycle();     // Catch: Throwable -> L17 OutOfMemoryError -> L19 Exception -> L20
    L12:
        r101 = r112.copy(Bitmap.Config.ARGB_8888, true);     // Catch: Throwable -> L17 OutOfMemoryError -> L19 Exception -> L20
    L20:
        r100 = r112;
    L19:
        r100 = r112;
    L17:
        th = th;
        r100 = r112;
    L30:
        if (r100 != null) goto L32;
    L34:
        throw th;
    L32:
        if (r100.isRecycled() == true) goto L34;
        r100.recycle();
        goto L34
    L29:
        th = th;
    L43:
        if (r100 != null) goto L45;
        return -2;
    L45:
        if (r100.isRecycled() == true) goto L56;
        r100.recycle();
        return -2;
    L56:
        return -2;
    L36:
        if (r100 != null) goto L38;
        return -3;
    L38:
        if (r100.isRecycled() == true) goto L54;
        r100.recycle();
        return -3;
    L54:
        return -3;
    }

    public int start(Bitmap r100, ScanSettings r101) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        this.success = false;
        nativeStart(this.handle, r100, r101);
        if (r100.isRecycled() == true) goto L8;
        r100.recycle();
    L8:
        return 0;
    }
}
