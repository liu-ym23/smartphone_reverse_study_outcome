package oo1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.io.FileUtils;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f524542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f524543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f524544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d.a f524545d;

    public static final class a implements d.a {
        public a() {
        }

        @Override // oo1.d.a
        public final void b(int r100) {
            ALogger.i("QuickInsideRecordManager", "onMediaInfoListener time:" + r100);
            d r101 = f.f524542a;
            d.a r102 = f.f524545d;
            if (r102 == null) goto L6;
            r102.b(r100);
            return;
        }

        @Override // oo1.d.a
        public final void d(int r100) {
            ALogger.i("QuickInsideRecordManager", "onMediaMuxerChangeListener type:" + r100);
            d r101 = f.f524542a;
            d.a r102 = f.f524545d;
            if (r102 == null) goto L6;
            r102.d(r100);
            return;
        }

        @Override // oo1.d.a
        public final void c(String r100, String r101, int r102) {
            d.a r103 = f.f524545d;
            if (r103 == null) goto L5;
            r103.c(r100, r101, r102);
        L5:
            d r104 = f.f524542a;
            if (r104 == null) goto L9;
            r104.a();
            return;
        }
    }

    static {
        f524544c = "";
    }

    public static void a(Bitmap r100) {
        ALogger.i("QuickInsideRecordManager", "pushVideoFrame");
        if (r100 == null) goto L26;
        d r101 = f524542a;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.f524526e != null) goto L9;
        return;
    L9:
        if (e.f524538d.get() == false) goto L11;
        return;
    L11:
        if (e.f524539e.get() == false) goto L13;
        return;
    L13:
        if (r101.f524522a == null) goto L31;
        ALogger.d("MediaEncodeManager", "setBitmapSource");
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        Canvas r104 = r101.f524522a.lockCanvas(null);     // Catch: Exception -> L21
        if (r104 == null) goto L19;
        Rect r105 = new Rect(0, 0, r102, r103);     // Catch: Exception -> L21
        r104.drawBitmap(r100, r105, r105, r101.f524528g);     // Catch: Exception -> L21
        r101.f524522a.unlockCanvasAndPost(r104);     // Catch: Exception -> L21
    L19:
        r100.recycle();     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        ALogger.e("MediaEncodeManager", "setBitmapSource error:" + e.getMessage());
        return;
    L31:
        return;
    }

    public static void b(int r110, int r111, int r112, int r113, int r114) {
        ALogger.i("QuickInsideRecordManager", "startRecord width: " + r110 + "  height:" + r111 + ' ');
        f524542a = new d();
        String r100 = FileUtils.getCacheDirPath(f524543b) + ("/VID_" + System.currentTimeMillis() + ".mp4");
        f524544c = r100;
        d r101 = f524542a;
        if (r101 == null) goto L30;
        a r102 = new a();
        r101.f524523b = new MediaMuxer(r100, 0);     // Catch: IOException -> L7
    L40:
    L24:
        e = move-exception;
        ALogger.e("MediaEncodeManager", "initVideoCodec: 视频类型无效 videoType:video/avc width:" + r110 + " height:" + r111 + "msg:" + e.getMessage());
    L44:
        r101.f524524c = MediaCodec.createEncoderByType("audio/mp4a-latm");     // Catch: IOException -> L28
        MediaFormat r115 = MediaFormat.createAudioFormat("audio/mp4a-latm", r112, r113);     // Catch: IOException -> L28
        r115.setInteger("bitrate", 76000);     // Catch: IOException -> L28
        r115.setInteger("aac-profile", 2);     // Catch: IOException -> L28
        r115.setInteger("max-input-size", 10240);     // Catch: IOException -> L28
        r101.f524524c.configure(r115, null, null, 1);     // Catch: IOException -> L28
        r101.f524525d = new MediaCodec.BufferInfo();     // Catch: IOException -> L28
    L29:
        r101.f524529h = r112;
        r101.f524530i = r113;
        r101.f524531j = r114;
        r101.f524534m = new h(r101.f524526e, r101.f524527f, r101.f524523b, r102);
        r101.f524533l = new oo1.a(r101.f524524c, r101.f524525d, r101.f524523b, r102);
    L28:
        ALogger.e("MediaEncodeManager", "initAudioCodec: 音频类型无效");
        goto L29
    L10:
        if ((r110 % 2) != 1) goto L13;
        r110 = r110 + 1;     // Catch: Exception -> L24
    L13:
        if ((r111 % 2) != 1) goto L15;
        r111 = r111 + 1;     // Catch: Exception -> L24
    L15:
        if (r110 > 0) goto L17;
        r110 = TECameraUtils.CAPTURE_NORMAL;
    L17:
        if (r111 > 0) goto L19;
        r111 = 1080;
    L19:
        r101.f524526e = MediaCodec.createEncoderByType(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE);     // Catch: Exception -> L24
        MediaFormat r103 = MediaFormat.createVideoFormat(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE, r110, r111);     // Catch: Exception -> L24
        r103.setInteger("color-format", 2130708361);     // Catch: Exception -> L24
        r103.setInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE, 24);     // Catch: Exception -> L24
        r103.setInteger("bitrate", r110 * r111);     // Catch: Exception -> L24
        r103.setInteger("i-frame-interval", 1);     // Catch: Exception -> L24
        if (Build.VERSION.SDK_INT < 24) goto L22;
        r103.setInteger("profile", 8);     // Catch: Exception -> L24
        r103.setInteger("level", 512);     // Catch: Exception -> L24
    L22:
        r101.f524526e.configure(r103, null, null, 1);     // Catch: Exception -> L24
        r101.f524527f = new MediaCodec.BufferInfo();     // Catch: Exception -> L24
        r101.f524522a = r101.f524526e.createInputSurface();     // Catch: Exception -> L24
    L7:
        ALogger.e("MediaEncodeManager", "initMediaMuxer: 文件打开失败,path=" + r100);
    L30:
        d r116 = f524542a;
        if (r116 != null) goto L33;
        return;
    L33:
        if (r116.f524522a == null) goto L49;
        e.f524537c.set(false);
        e.f524538d.set(false);
        e.f524539e.set(false);
        ThreadMethodProxy.start(r116.f524534m);     // Catch: Exception -> L38
        ThreadMethodProxy.start(r116.f524533l);     // Catch: Exception -> L38
        return;
    L38:
        h r117 = r116.f524534m;
        r117.getClass();
        e.f524539e.set(true);
        r117.f524554y = true;
        oo1.a r118 = r116.f524533l;
        r118.getClass();
        e.f524538d.set(true);
        r118.f524517y = true;
        return;
    }
}
