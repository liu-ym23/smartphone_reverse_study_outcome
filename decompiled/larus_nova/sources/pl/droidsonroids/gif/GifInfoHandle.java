package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.system.Os;
import android.view.Surface;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes41.dex */
final class GifInfoHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f529688a;

    private static native void bindSurface(long r100, Surface r101, long[] r102);

    public static native int createTempNativeFileDescriptor() throws GifIOException;

    public static native int extractNativeFileDescriptor(FileDescriptor r100, boolean r101) throws GifIOException;

    private static native void free(long r100);

    private static native long getAllocationByteCount(long r100);

    private static native String getComment(long r100);

    private static native int getCurrentFrameIndex(long r100);

    private static native int getCurrentLoop(long r100);

    private static native int getCurrentPosition(long r100);

    private static native int getDuration(long r100);

    private static native int getFrameDuration(long r100, int r101);

    private static native int getHeight(long r100);

    private static native int getLoopCount(long r100);

    private static native long getMetadataByteCount(long r100);

    private static native int getNativeErrorCode(long r100);

    private static native int getNumberOfFrames(long r100);

    private static native long[] getSavedState(long r100);

    private static native long getSourceLength(long r100);

    private static native int getWidth(long r100);

    private static native void glTexImage2D(long r100, int r101, int r102);

    private static native void glTexSubImage2D(long r100, int r101, int r102);

    private static native void initTexImageDescriptor(long r100);

    private static native boolean isAnimationCompleted(long r100);

    private static native boolean isOpaque(long r100);

    public static native long openByteArray(byte[] r100) throws GifIOException;

    public static native long openDirectByteBuffer(ByteBuffer r100) throws GifIOException;

    public static native long openFile(String r100) throws GifIOException;

    public static native long openNativeFileDescriptor(int r100, long r101) throws GifIOException;

    public static native long openStream(InputStream r100) throws GifIOException;

    private static native void postUnbindSurface(long r100);

    private static native long renderFrame(long r100, Bitmap r101);

    private static native boolean reset(long r100);

    private static native long restoreRemainder(long r100);

    private static native int restoreSavedState(long r100, long[] r101, Bitmap r102);

    private static native void saveRemainder(long r100);

    private static native void seekToFrame(long r100, int r101, Bitmap r102);

    private static native void seekToFrameGL(long r100, int r101);

    private static native void seekToTime(long r100, int r101, Bitmap r102);

    private static native void setLoopCount(long r100, char r101);

    private static native void setOptions(long r100, char r101, boolean r102);

    private static native void setSpeedFactor(long r100, float r101);

    private static native void startDecoderThread(long r100);

    private static native void stopDecoderThread(long r100);

    public final synchronized long b() {
        monitor-enter(this);
        long r100 = getAllocationByteCount(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int c() {
        monitor-enter(this);
        int r100 = getCurrentFrameIndex(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int d() {
        monitor-enter(this);
        int r100 = getCurrentLoop(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int e() {
        monitor-enter(this);
        int r100 = getCurrentPosition(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int f() {
        monitor-enter(this);
        int r100 = getDuration(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int g() {
        monitor-enter(this);
        int r100 = getHeight(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int h() {
        monitor-enter(this);
        int r100 = getLoopCount(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized long i() {
        monitor-enter(this);
        long r100 = getMetadataByteCount(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int j() {
        monitor-enter(this);
        int r100 = getNativeErrorCode(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int k() {
        monitor-enter(this);
        int r100 = getNumberOfFrames(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized long[] l() {
        monitor-enter(this);
        long[] r100 = getSavedState(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int m() {
        monitor-enter(this);
        int r100 = getWidth(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean n() {
        monitor-enter(this);
        boolean r100 = isOpaque(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean o() {
        monitor-enter(this);
        if (this.f529688a != 0) goto L7;
        boolean r100 = true;
    L8:
        monitor-exit(this);
        return r100;
    L7:
        r100 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void r() {
        monitor-enter(this);
        postUnbindSurface(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void s() {
        monitor-enter(this);
        free(this.f529688a);     // Catch: Throwable -> L6
        this.f529688a = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean u() {
        monitor-enter(this);
        boolean r100 = reset(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized long v() {
        monitor-enter(this);
        long r100 = restoreRemainder(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void x() {
        monitor-enter(this);
        saveRemainder(this.f529688a);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void finalize() throws Throwable {
        s();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    static {
        l.c();
    }

    public GifInfoHandle() {
    }

    public GifInfoHandle(AssetFileDescriptor r100) throws IOException {
        this.f529688a = p(r100.getFileDescriptor(), r100.getStartOffset(), false);     // Catch: Throwable -> L6
        r100.close();     // Catch: IOException -> L9
        return;
    L17:
        return;
    L6:
        th = move-exception;
        r100.close();     // Catch: IOException -> L10
    L8:
        throw th;
    }

    public final void B(float r100) {
        if (r100 <= 0.0f) goto L17;
        if (Float.isNaN(r100) == true) goto L17;
        if (r100 >= 4.656613E-10f) goto L9;
        r100 = 4.656613E-10f;
    L9:
        monitor-enter(this);
        setSpeedFactor(this.f529688a, r100);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalArgumentException("Speed factor is not positive");
    }

    public final synchronized long t(Bitmap r100) {
        monitor-enter(this);
        long r101 = renderFrame(this.f529688a, r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final void z(int r100) {
        if (r100 < 0) goto L13;
        if (r100 > 65535) goto L13;
        monitor-enter(this);
        setLoopCount(this.f529688a, (char) r100);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalArgumentException("Loop count of range <0, 65535>");
    }

    public GifInfoHandle(InputStream r100) throws GifIOException {
        if (r100.markSupported() == false) goto L7;
        this.f529688a = openStream(r100);
        return;
    L7:
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    public GifInfoHandle(FileDescriptor r100) throws GifIOException {
        this.f529688a = p(r100, 0, true);
    }

    public GifInfoHandle(String r100) throws GifIOException {
        this.f529688a = openFile(r100);
    }

    public GifInfoHandle(ByteBuffer r100) throws GifIOException {
        this.f529688a = openDirectByteBuffer(r100);
    }

    public GifInfoHandle(byte[] r100) throws GifIOException {
        this.f529688a = openByteArray(r100);
    }

    public static GifInfoHandle q(ContentResolver r100, Uri r101) throws IOException {
        if ("file".equals(r101.getScheme()) == true) goto L5;
        AssetFileDescriptor r102 = ContentResolverWrapper.openAssetFileDescriptor(r100, r101, "r");
        if (r102 == null) goto L11;
        return new GifInfoHandle(r102);
    L11:
        throw new IOException("Could not open AssetFileDescriptor for " + r101);
    L5:
        return new GifInfoHandle(r101.getPath());
    }

    public final void A(char r100, boolean r101) {
        setOptions(this.f529688a, r100, r101);
    }

    public final void a(Surface r100, long[] r101) {
        bindSurface(this.f529688a, r100, r101);
    }

    public final synchronized int w(long[] r100, Bitmap r101) {
        monitor-enter(this);
        int r102 = restoreSavedState(this.f529688a, r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void y(int r100, Bitmap r101) {
        monitor-enter(this);
        seekToTime(this.f529688a, r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static long p(FileDescriptor r100, long r101, boolean r102) throws GifIOException {
        if (Build.VERSION.SDK_INT > 27) goto L18;
        int r103 = extractNativeFileDescriptor(r100, r102);
    L17:
        return openNativeFileDescriptor(r103, r101);
    L18:
        r103 = createTempNativeFileDescriptor();     // Catch: Throwable -> L9
        Os.dup2(r100, r103);     // Catch: Throwable -> L9
        if (r102 == false) goto L17;
        Os.close(r100);     // Catch: Exception -> L7
        goto L17
    L9:
        th = move-exception;
        if (r102 == false) goto L12;
        Os.close(r100);     // Catch: Exception -> L7
    L12:
        throw th;     // Catch: Exception -> L7
    L7:
        e = move-exception;
        throw new GifIOException(GifError.OPEN_FAILED.errorCode, e.getMessage());
    }
}
