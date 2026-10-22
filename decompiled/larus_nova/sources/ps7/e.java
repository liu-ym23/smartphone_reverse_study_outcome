package ps7;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.log.RecordService;
import com.dtf.face.photinus.VideoFormatConfig;
import com.dtf.face.utils.ClientConfigUtil;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f530457a = true;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaCodec f530458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaMuxer f530459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public PolarisFileWrapper f530460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f530461d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f530462e;

        public a() {
        }
    }

    public static Uri c(Context r100) {
        if (r100 != null) goto L6;
        return Uri.EMPTY;
    L6:
        return Uri.withAppendedPath(Uri.fromFile(r100.getCacheDir()), "Phontinus");
    }

    public static void a(boolean r100, MediaCodec.BufferInfo r101, a r102) {
        if (r100 == true) goto L44;
    L4:
        ByteBuffer[] r103 = r102.f530458a.getOutputBuffers();
    L5:
        int r104 = r102.f530458a.dequeueOutputBuffer(r101, 10000);
        if (r104 == (-1)) goto L7;
        if (r104 == (-3)) goto L11;
        if (r104 == (-2)) goto L15;
        if (r104 < 0) goto L5;
        ByteBuffer r105 = r103[r104];
        if (r105 == null) goto L40;
        if ((r101.flags & 2) == 0) goto L27;
        r101.size = 0;
    L27:
        if (r101.size != 0) goto L29;
    L36:
        r102.f530458a.releaseOutputBuffer(r104, false);
        if ((r101.flags & 4) == 0) goto L5;
        return;
    L29:
        if (r102.f530461d == false) goto L35;
        r105.position(r101.offset);
        r105.limit(r101.offset + r101.size);
        r102.f530459b.writeSampleData(r102.f530462e, r105, r101);     // Catch: Exception -> L33
        goto L36
    L35:
        throw new Exception("muxer hasn't started");
    L40:
        throw new Exception("encoderOutputBuffer " + r104 + " was null");
    L15:
        if (r102.f530461d == true) goto L18;
        r102.f530462e = r102.f530459b.addTrack(r102.f530458a.getOutputFormat());
        r102.f530459b.start();
        r102.f530461d = true;
        goto L5
    L18:
        throw new Exception("format changed twice");
    L11:
        r103 = r102.f530458a.getOutputBuffers();
        goto L5
    L7:
        if (r100 == true) goto L5;
        return;
    L44:
        r102.f530458a.signalEndOfInputStream();     // Catch: Exception -> L41
        goto L4
    }

    public static void b(int r110, byte[] r111, a r112) {
        ByteBuffer[] r100 = r112.f530458a.getInputBuffers();
        MediaCodec.BufferInfo r101 = new MediaCodec.BufferInfo();
        int r102 = r112.f530458a.dequeueInputBuffer(10000);
        if (r102 < 0) goto L18;
        long r103 = ((r110 * 1000000) / 30) + 132;
        if (r111 != null) goto L7;
        r112.f530458a.queueInputBuffer(r102, 0, 0, r103, 4);
        a(true, r101, r112);
        return;
    L7:
        ByteBuffer r104 = r100[r102];
        r104.clear();
        r104.put(r111);
        if (r104.position() == r104.capacity()) goto L16;
        String r105 = "position=" + r104.position() + "   capacity=" + r104.capacity() + "limit=" + r104.limit();
        if (ClientConfigUtil.needVideoExDegrade() == true) goto L15;
        if (f530457a == false) goto L16;
        f530457a = false;
        RecordService.getInstance().recordEvent(2, "videoException", new String[]{"msg", r105});
        goto L16
    L15:
        throw new Exception(r105);
    L16:
        r112.f530458a.queueInputBuffer(r102, 0, r111.length, r103, 0);
        a(false, r101, r112);
        return;
    }

    public static a d(Context r110, int r111, int r112, String r113, VideoFormatConfig r114, int r115) {
        int r100 = MediaCodecList.getCodecCount();
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L20;
        MediaCodecInfo r102 = MediaCodecList.getCodecInfoAt(r101);
        if (r102.isEncoder() == false) goto L19;
        String r103 = r102.getName();
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        String[] r116 = r102.getSupportedTypes();
        int r117 = r116.length;
        int r118 = 0;
    L12:
        if (r118 >= r117) goto L19;
        if (r116[r118].equalsIgnoreCase(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE) == false) goto L18;
        if (r103.contains("google") == false) goto L18;
    L21:
        if (r102 != null) goto L32;
        int r104 = MediaCodecList.getCodecCount();
        int r105 = 0;
    L24:
        if (r105 >= r104) goto L59;
        r102 = MediaCodecList.getCodecInfoAt(r105);
        if (r102.isEncoder() == false) goto L57;
        String[] r106 = r102.getSupportedTypes();
        int r119 = r106.length;
        int r120 = 0;
    L29:
        if (r120 >= r119) goto L57;
        if (r106[r120].equalsIgnoreCase(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE) == true) goto L32;
        r120 = r120 + 1;
    L57:
        r105 = r105 + 1;
        goto L24
    L59:
        throw new Exception("not support mimeType");
    L32:
        a r107 = new a();
        Uri r108 = c(r110);
        PolarisFileWrapper r109 = new PolarisFileWrapper(r108.getPath());
        if (r109.exists() == true) goto L35;
        r109.mkdir();
    L35:
        PolarisFileWrapper r121 = new PolarisFileWrapper(Uri.withAppendedPath(r108, r113 + ".mp4").getPath());
        r107.f530460c = r121;
        if (r121.exists() == false) goto L39;
        r107.f530460c.delete();
    L39:
        if (r115 != 90) goto L41;
    L44:
        MediaFormat r122 = MediaFormat.createVideoFormat(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE, r112, r111);
    L45:
        r122.setInteger("color-format", 21);
        r122.setInteger("bitrate", r114.getBitRate());
        r122.setInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE, r114.getFrameRate());
        r122.setInteger("i-frame-interval", 10);
        MediaCodec r123 = MediaCodec.createByCodecName(r102.getName());     // Catch: IOException -> L53
        r107.f530458a = r123;     // Catch: IOException -> L53
        r123.configure(r122, null, null, 1);
        r107.f530458a.start();
        r107.f530459b = new MediaMuxer(r107.f530460c.getAbsolutePath(), 0);     // Catch: IOException -> L50
        return r107;
    L50:
        e = move-exception;
        throw new Exception("create muxer error, msg = " + e.getMessage());
    L53:
        e = move-exception;
        throw new Exception("create codec by name error, msg = " + e.getMessage());
    L41:
        if (r115 == 270) goto L44;
        r122 = MediaFormat.createVideoFormat(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE, r111, r112);
    L18:
        r118 = r118 + 1;
    L19:
        r101 = r101 + 1;
        goto L4
    L20:
        r102 = null;
        goto L21
    }
}
