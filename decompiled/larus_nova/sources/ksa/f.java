package ksa;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes34.dex */
public final class f extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f505985p = 15;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f505986q = 21;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f505987r = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f505988m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f505989n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final byte[] f505990o;

    static {
        f505987r = new int[]{21, 19};
    }

    @Override // ksa.c
    public final void f() throws IOException {
        this.f505962g = -1;
        this.f505960e = false;
        this.f505961f = false;
        int r100 = MediaCodecList.getCodecCount();
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L38;
        MediaCodecInfo r102 = MediaCodecList.getCodecInfoAt(r101);
        if (r102.isEncoder() == false) goto L37;
        String[] r110 = r102.getSupportedTypes();
        int r111 = 0;
    L10:
        if (r111 >= r110.length) goto L37;
        if (r110[r111].equalsIgnoreCase(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE) == false) goto L36;
        ThreadMethodProxy.setPriority(ThreadMethodProxy.currentThread(), 10);     // Catch: Throwable -> L33
        MediaCodecInfo.CodecCapabilities r112 = r102.getCapabilitiesForType(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE);     // Catch: Throwable -> L33
        ThreadMethodProxy.setPriority(ThreadMethodProxy.currentThread(), 5);
        int r113 = 0;
    L16:
        int[] r114 = r112.colorFormats;
        if (r113 >= r114.length) goto L28;
        int r115 = r114[r113];
        int r116 = 0;
    L19:
        if (r116 >= 2) goto L24;
        if (f505987r[r116] == r115) goto L22;
        r116 = r116 + 1;
        goto L19
    L22:
        boolean r103 = true;
    L25:
        if (r103 == true) goto L29;
        r113 = r113 + 1;
    L29:
        if (r115 != 0) goto L31;
        CertLog.e("MediaRecorder", "couldn't find a good color format for " + r102.getName() + " / video/avc");
    L31:
        if (r115 <= 0) goto L36;
        f505986q = r115;
    L39:
        if (r102 != null) goto L42;
        CertLog.e("MediaRecorder", "Unable to find an appropriate codec for video/avc");
        return;
    L42:
        MediaFormat r104 = MediaFormat.createVideoFormat(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE, this.f505988m, this.f505989n);
        r104.setInteger("color-format", f505986q);
        Object r105 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.VIDEO_RECORD_PARAMS_BITRATE_FACTOR);
        if ((r105 instanceof Number) == false) goto L45;
        float r106 = ((Number) r105).floatValue();
    L46:
        int r107 = (int) (((f505985p * this.f505988m) * this.f505989n) * r106);
        CertLog.i("MediaRecorder", String.format("bitrate=%5.2f[Mbps]", new Object[]{Float.valueOf((r107 / 1024.0f) / 1024.0f)}));
        r104.setInteger("bitrate", r107);
        r104.setInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE, f505985p);
        Object r108 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.VIDEO_RECORD_PARAMS_FRAME_INTERVAL);
        if ((r108 instanceof Integer) == false) goto L49;
        r104.setInteger("i-frame-interval", ((Integer) r108).intValue());
    L50:
        r104.setInteger("bitrate-mode", 2);
        MediaCodec r109 = MediaCodec.createEncoderByType(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE);
        this.f505963h = r109;
        r109.configure(r104, null, null, 1);
        this.f505963h.start();
        c.a r117 = this.f505966k;
        if (r117 == null) goto L71;
        ((e.a) r117).a(this);     // Catch: Exception -> L54
        return;
    L54:
        e = move-exception;
        CertLog.e("MediaRecorder", "prepare:", e);
        return;
    L71:
        return;
    L49:
        r104.setInteger("i-frame-interval", 15);
        goto L50
    L45:
        r106 = 0.06f;
        goto L46
    L24:
        r103 = false;
        goto L25
    L28:
        r115 = 0;
    L33:
        th = move-exception;
        ThreadMethodProxy.setPriority(ThreadMethodProxy.currentThread(), 5);
        throw th;
    L36:
        r111 = r111 + 1;
    L37:
        r101 = r101 + 1;
        goto L4
    L38:
        r102 = null;
        goto L39
    }

    @Override // ksa.c
    public final void g() {
        super.g();
    }

    @Override // ksa.c
    public final void c(ByteBuffer r110, int r111, long r210) {
        if (r110 != null) goto L6;
        super.c(r110, r111, r210);
        return;
    L6:
        byte[] r100 = r110.array();
        int r101 = f505986q;
        int r102 = 16;
        byte r103 = UByte.MAX_VALUE;
        if (r101 != 19) goto L9;
        byte[] r104 = this.f505990o;
        int r105 = this.f505988m;
        int r106 = this.f505989n;
        int r107 = r105 * r106;
        int r108 = (r107 / 4) + r107;
        int r109 = 0;
        int r112 = 0;
        int r113 = 0;
    L38:
        if (r109 >= r106) goto L68;
        int r114 = 0;
    L40:
        if (r114 >= r105) goto L67;
        int r115 = r112 * 4;
        int r116 = r100[r115 + 0] & r103;
        int r117 = r100[r115 + 1] & r103;
        int r118 = r100[r115 + 2] & r103;
        int r119 = (((((r116 * 66) + (r117 * 129)) + (r118 * 25)) + 128) >> 8) + r102;
        int r120 = r113 + 1;
        if (r119 >= r102) goto L45;
    L48:
        r104[r113] = (byte) r102;
        if ((r109 % 2) != 0) goto L66;
        if ((r112 % 2) != 0) goto L66;
        int r121 = (((((r116 * (-38)) - (r117 * 74)) + (r118 * 112)) + 128) >> 8) + 128;
        int r122 = (((((r116 * 112) - (r117 * 94)) - (r118 * 18)) + 128) >> 8) + 128;
        int r123 = r108 + 1;
        if (r122 >= 0) goto L56;
        r122 = 0;
    L58:
        r104[r108] = (byte) r122;
        int r124 = r107 + 1;
        if (r121 >= 0) goto L62;
        r121 = 0;
    L64:
        r104[r107] = (byte) r121;
        r107 = r124;
        r108 = r123;
        goto L66
    L62:
        if (r121 <= 255) goto L64;
        r121 = 255;
        goto L64
    L56:
        if (r122 <= 255) goto L58;
        r122 = 255;
    L66:
        r112 = r112 + 1;
        r114 = r114 + 1;
        r113 = r120;
        r102 = 16;
        r103 = UByte.MAX_VALUE;
        goto L40
    L45:
        if (r119 <= 255) goto L47;
        r102 = 255;
        goto L48
    L47:
        r102 = r119;
        goto L48
    L67:
        r109 = r109 + 1;
        r102 = 16;
        r103 = UByte.MAX_VALUE;
    L68:
        super.c(ByteBuffer.wrap(this.f505990o), this.f505990o.length, r210);
        return;
    L9:
        if (r101 != 21) goto L68;
        byte[] r125 = this.f505990o;
        int r126 = this.f505988m;
        int r127 = this.f505989n;
        int r128 = r126 * r127;
        int r129 = 0;
        int r130 = 0;
        int r131 = 0;
    L12:
        if (r129 >= r127) goto L68;
        int r132 = 0;
    L14:
        if (r132 >= r126) goto L36;
        int r133 = r131 * 4;
        int r134 = r100[r133 + 0] & UByte.MAX_VALUE;
        int r135 = r100[r133 + 1] & UByte.MAX_VALUE;
        int r136 = r100[r133 + 2] & UByte.MAX_VALUE;
        int r137 = (((((r134 * 66) + (r135 * 129)) + (r136 * 25)) + 128) >> 8) + 16;
        int r138 = r130 + 1;
        if (r137 >= 16) goto L18;
        r137 = 16;
    L20:
        r125[r130] = (byte) r137;
        if ((r129 % 2) != 0) goto L35;
        if ((r131 % 2) != 0) goto L35;
        int r139 = (((((r134 * (-38)) - (r135 * 74)) + (r136 * 112)) + 128) >> 8) + 128;
        int r140 = (((((r134 * 112) - (r135 * 94)) - (r136 * 18)) + 128) >> 8) + 128;
        int r141 = r128 + 1;
        if (r139 >= 0) goto L27;
        r139 = 0;
    L29:
        r125[r128] = (byte) r139;
        r128 = r141 + 1;
        if (r140 >= 0) goto L32;
        r140 = 0;
    L34:
        r125[r141] = (byte) r140;
        goto L35
    L32:
        if (r140 <= 255) goto L34;
        r140 = 255;
        goto L34
    L27:
        if (r139 <= 255) goto L29;
        r139 = 255;
    L35:
        r131 = r131 + 1;
        r132 = r132 + 1;
        r130 = r138;
        goto L14
    L18:
        if (r137 <= 255) goto L20;
        r137 = 255;
        goto L20
    L36:
        r129 = r129 + 1;
        goto L12
    }

    public f(d r100, e.a r101, int r102, int r103, int r104) {
        super(r100, r101);
        CertLog.i("MediaRecorder", "MediaVideoEncoder: ");
        this.f505988m = r102;
        this.f505989n = r103;
        this.f505990o = new byte[((r102 * r103) * 3) / 2];
        f505985p = r104;
    }
}
