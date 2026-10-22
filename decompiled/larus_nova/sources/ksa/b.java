package ksa;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.sva.sdk.controller.RecordingsMgr;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.ICertCompliance;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f505953n = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f505954m;

    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ b f505955v;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11, types: [int] */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13, types: [int] */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4, types: [int[]] */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r7v8, types: [int] */
        public final void l() {
            Process.setThreadPriority(-19);
            int r100 = 0;
            int r101 = AudioRecord.getMinBufferSize(44100, 16, 2);     // Catch: Exception -> L67
            if (15360 >= r101) goto L6;
            int r102 = (((r101 / 1024) + 1) * 1024) * 2;     // Catch: Exception -> L67
        L7:
            ?? r103 = b.f505953n;     // Catch: Exception -> L67
            AudioRecord r104 = null;
            int r110 = 0;
        L8:
            if (r110 < 5) goto L100;
        L96:
            if (r104 != null) goto L95;
            CertLog.e("MediaRecorder", "failed to initialize AudioRecord");     // Catch: Exception -> L67
            ?? r105 = 0;
        L70:
            if (r105 != 0) goto L87;
            ByteBuffer r106 = ByteBuffer.allocateDirect(1024);
        L73:
            if (this.f505955v.f505957b == false) goto L114;
            if (r100 >= 5) goto L115;
            r106.position(1024);
            r106.flip();
            b r107 = this.f505955v;     // Catch: Exception -> L89
            r107.c(r106, 1024, r107.e());     // Catch: Exception -> L89
            this.f505955v.d();     // Catch: Exception -> L89
            monitor-enter(this);
            wait(50);     // Catch: Throwable -> L81 InterruptedException -> L88
        L81:
            th = move-exception;
            throw th;
        L83:
            monitor-exit(this);     // Catch: Throwable -> L81
            r100 = r100 + 1;     // Catch: Throwable -> L81
        L113:
            return;
        L115:
            return;
        L114:
            return;
        L87:
            return;
        L95:
        L52:
            th = th;
            r103 = 0;
        L99:
            ICertCompliance r108 = CertManager.getInstance().getCertCompliance();     // Catch: Exception -> L60
            if (r108 == null) goto L57;
            r108.releaseRecord(r104);     // Catch: Exception -> L60
        L62:
            throw th;     // Catch: Exception -> L63
        L57:
            throw new NullPointerException("cert compliance is null");     // Catch: Exception -> L60
        L60:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L63
            goto L62
        L20:
            if (this.f505955v.f505957b == false) goto L43;
            ByteBuffer r109 = ByteBuffer.allocateDirect(1024);     // Catch: Throwable -> L52
            ICertCompliance r111 = CertManager.getInstance().getCertCompliance();     // Catch: Throwable -> L52
            if (r111 == null) goto L42;
            r111.startRecord(r104);     // Catch: Throwable -> L52
            r103 = 0;
        L92:
        L39:
            th = th;
        L36:
            th = move-exception;
            r111.stopRecord(r104);     // Catch: Throwable -> L39
            throw th;     // Catch: Throwable -> L39
        L26:
            if (this.f505955v.f505957b == false) goto L34;
            if (this.f505955v.f505959d == true) goto L34;
            if (this.f505955v.f505960e == true) goto L34;
            r109.clear();     // Catch: Throwable -> L36
            int r112 = r104.read(r109, 1024);     // Catch: Throwable -> L36
            if (r112 <= 0) goto L92;
            r109.position(r112);     // Catch: Throwable -> L36
            r109.flip();     // Catch: Throwable -> L36
            b r113 = this.f505955v;     // Catch: Throwable -> L36
            r113.c(r109, r112, r113.e());     // Catch: Throwable -> L36
            this.f505955v.d();     // Catch: Throwable -> L36
            r103 = r103 + 1;     // Catch: Throwable -> L36
        L34:
            this.f505955v.d();     // Catch: Throwable -> L36
            r111.stopRecord(r104);     // Catch: Throwable -> L39
            r103 = r103;
        L97:
            ICertCompliance r114 = CertManager.getInstance().getCertCompliance();     // Catch: Exception -> L49
            if (r114 == null) goto L48;
            r114.releaseRecord(r104);     // Catch: Exception -> L49
            r105 = r103;
            goto L70
        L48:
            throw new NullPointerException("cert compliance is null");     // Catch: Exception -> L49
        L49:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L63
            r105 = r103;
            goto L70
        L42:
            throw new NullPointerException("cert compliance is null");     // Catch: Throwable -> L52
        L43:
            r103 = 0;
        L63:
            e = e;
        L69:
            CertLog.e("MediaRecorder", "AudioThread#run", e);
            r105 = r103;
            goto L70
        L100:
            AudioRecord r115 = new AudioRecord(r103[r110], 44100, 16, 2, r102);     // Catch: Exception -> L14
            if (r115.getState() == 1) goto L13;
            r115 = null;
        L13:
            r104 = r115;
        L15:
            if (r104 != null) goto L96;
            r110 = r110 + 1;
        L14:
            r104 = null;
            goto L15
        L6:
            r102 = 15360;
        L67:
            e = e;
            r103 = 0;
            goto L69
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100) {
            this.f505955v = r100;
            super("MediaAudioEncoder$AudioThread");
        }
    }

    static {
        f505953n = new int[]{1, 0, 5, 7, 6};
    }

    @Override // ksa.c
    public final void f() throws IOException {
        this.f505962g = -1;
        this.f505960e = false;
        this.f505961f = false;
        int r100 = MediaCodecList.getCodecCount();
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L16;
        MediaCodecInfo r102 = MediaCodecList.getCodecInfoAt(r101);
        if (r102.isEncoder() == false) goto L15;
        String[] r103 = r102.getSupportedTypes();
        int r104 = 0;
    L10:
        if (r104 >= r103.length) goto L15;
        if (r103[r104].equalsIgnoreCase("audio/mp4a-latm") == true) goto L18;
        r104 = r104 + 1;
    L18:
        if (r102 != null) goto L21;
        CertLog.e("MediaRecorder", "Unable to find an appropriate codec for audio/mp4a-latm");
        return;
    L21:
        MediaFormat r105 = MediaFormat.createAudioFormat("audio/mp4a-latm", 44100, 1);
        r105.setInteger("aac-profile", 2);
        r105.setInteger("channel-mask", 16);
        r105.setInteger("bitrate", RecordingsMgr.SAMPLE_SIZE_SENCOND);
        r105.setInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT, 1);
        r105.setInteger("bitrate-mode", 2);
        MediaCodec r106 = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.f505963h = r106;
        r106.configure(r105, null, null, 1);
        this.f505963h.start();
        c.a r107 = this.f505966k;
        if (r107 == null) goto L34;
        ((e.a) r107).a(this);     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        CertLog.e("MediaRecorder", "prepare:", e);
        return;
    L34:
        return;
    L15:
        r101 = r101 + 1;
        goto L4
    L16:
        r102 = null;
        goto L18
    }

    @Override // ksa.c
    public final void g() {
        this.f505954m = null;
        super.g();
    }

    @Override // ksa.c
    public final void h() {
        super.h();
        if (this.f505954m != null) goto L6;
        a r100 = new a(this);
        this.f505954m = r100;
        ThreadMethodProxy.start(r100);
        return;
    }

    public b(d r100, e.a r101) {
        super(r100, r101);
        this.f505954m = null;
    }
}
