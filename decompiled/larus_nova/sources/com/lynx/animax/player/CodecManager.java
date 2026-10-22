package com.lynx.animax.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.view.Surface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public final class CodecManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaCodec f380321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f380322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f380323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f380324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f380325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f380326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f380327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f380328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f380329i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f380330j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f380331k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f380332l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f380333m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public VideoAsset f380334n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Surface f380335o;

    public static final enum ProcessFrameStatus extends Enum<ProcessFrameStatus> {
        public static final ProcessFrameStatus FATAL = null;
        public static final ProcessFrameStatus SUCCESS = null;
        public static final ProcessFrameStatus TRY_AGAIN = null;
        public static final ProcessFrameStatus TRY_AGAIN_IF_NECESSARY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ProcessFrameStatus[] f380336a = null;

        static {
            ProcessFrameStatus r100 = new ProcessFrameStatus("SUCCESS", 0);
            SUCCESS = r100;
            ProcessFrameStatus r101 = new ProcessFrameStatus("TRY_AGAIN_IF_NECESSARY", 1);
            TRY_AGAIN_IF_NECESSARY = r101;
            ProcessFrameStatus r102 = new ProcessFrameStatus("TRY_AGAIN", 2);
            TRY_AGAIN = r102;
            ProcessFrameStatus r103 = new ProcessFrameStatus(SpeechEngineDefines.LOG_LEVEL_FATAL, 3);
            FATAL = r103;
            f380336a = new ProcessFrameStatus[]{r100, r101, r102, r103};
        }

        public static ProcessFrameStatus[] values() {
            return (ProcessFrameStatus[]) f380336a.clone();
        }

        public static ProcessFrameStatus valueOf(String r100) {
            return (ProcessFrameStatus) r27.a.a(ProcessFrameStatus.class, r100);
        }

        public ProcessFrameStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    public final void b() {
        VideoAsset r100 = this.f380334n;
        if (r100 != null) goto L5;
        return;
    L5:
        f r101 = r100.f380339b;
        if (r101 != null) goto L8;
        MediaFormat r102 = null;
    L9:
        AnimaXLog.b("CodecManager", "initDecoder, format: " + r102);
        String r103 = r102.getString("mime");
        if (r103 != null) goto L51;
        return;
    L51:
        int r104 = MediaCodecList.getCodecCount();     // Catch: Exception -> L36
    L13:
        int r105 = this.f380331k;     // Catch: Exception -> L36
        boolean r106 = false;
        if (r105 >= r104) goto L45;
        this.f380331k = r105 + 1;     // Catch: Exception -> L36
        MediaCodecInfo r107 = MediaCodecList.getCodecInfoAt(r105);     // Catch: Exception -> L36
        if (r107.isEncoder() == true) goto L13;
        String[] r108 = r107.getSupportedTypes();     // Catch: Exception -> L36
        if (r108 != null) goto L20;
        int r109 = 0;
    L21:
        int r110 = 0;
    L23:
        if (r110 >= r109) goto L28;
        if (r103.equals(r108[r110]) == true) goto L26;
        r110 = r110 + 1;     // Catch: Exception -> L36
        goto L23
    L26:
        r106 = true;
    L28:
        if (r106 == false) goto L13;
        String r111 = r107.getName();     // Catch: Exception -> L36
        if (r111 == null) goto L13;
        if (f(r111).f531718a == false) goto L13;
        r106 = true;
        goto L45
    L20:
        r109 = r108.length;     // Catch: Exception -> L36
    L45:
        if (r106 == true) goto L49;
        e("initDecoder error");
        return;
    L49:
        if (c() == true) goto L49;
        return;
    L36:
        e = move-exception;
        AnimaXLog.a("CodecManager", "enumerate codec list failed, fallback to decoder by type: " + e.getMessage());
        AnimaXLog.b("CodecManager", "try decoder by type: ".concat(r103));
        if (this.f380334n != null) goto L53;
        q4a.d r112 = new q4a.d("tryInitDecoderByType error: mAsset is null");
    L44:
        r106 = r112.f531718a;
        goto L45
    L53:
        MediaCodec r113 = MediaCodec.createDecoderByType(r103);     // Catch: Exception -> L42
        this.f380321a = r113;     // Catch: Exception -> L42
        r112 = a(r113.getName());
    L42:
        e = move-exception;
        r112 = new q4a.d("createDecoderByType Exception: " + e.getMessage());
        goto L44
    L8:
        r102 = r101.f380361a;
        goto L9
    }

    public final boolean c() {
        boolean r100 = false;
        if (this.f380323c == false) goto L61;
        VideoAsset r101 = this.f380334n;
        if (r101 == null) goto L61;
        if (this.f380328h < this.f380329i) goto L10;
        return false;
    L10:
        int r102 = this.f380326f;
        l r103 = r101.f380341d;
        String r104 = null;
        if (r103 != null) goto L13;
    L12:
        d r105 = null;
    L19:
        ByteBuffer r106 = this.f380334n.a(r105);
        if (r106 != null) goto L62;
        return false;
    L62:
        int r107 = this.f380321a.dequeueInputBuffer(this.f380332l);     // Catch: IllegalStateException -> L25 MediaCodec.CodecException -> L27
    L30:
        if (r107 >= 0) goto L64;
    L40:
        int r110 = -1;
    L42:
        if (r110 >= 0) goto L66;
        return false;
    L66:
        this.f380321a.queueInputBuffer(r110, 0, r105.f380359b - r105.f380358a, r105.f380360c, 0);     // Catch: IllegalStateException -> L47 MediaCodec.CodecException -> L49 MediaCodec.CryptoException -> L51
    L53:
        if (r104 == null) goto L55;
        e(r104);
    L56:
        if (r100 == false) goto L61;
        this.f380328h++;
        if ((-1) != this.f380327g) goto L60;
        this.f380327g = this.f380326f;
    L60:
        this.f380326f = (this.f380326f + 1) % this.f380334n.getFrameCount();
        goto L61
    L55:
        r100 = true;
        goto L56
    L49:
        e = move-exception;
        r104 = "[" + this.f380322b + "]: queueInputBuffer CodecException: " + e.getMessage();
    L51:
        e = move-exception;
        r104 = "[" + this.f380322b + "]: queueInputBuffer CryptoException: " + e.getMessage();
    L47:
        e = move-exception;
        r104 = "[" + this.f380322b + "]: queueInputBuffer IllegalStateException: " + e.getMessage();
        goto L53
    L64:
        ByteBuffer r108 = this.f380321a.getInputBuffer(r107);     // Catch: IllegalStateException -> L34 MediaCodec.CodecException -> L36
    L39:
        if (r108 == null) goto L40;
        r108.put(r106);
        r110 = r107;
        goto L42
    L36:
        e = move-exception;
        e("[" + this.f380322b + "]: getInputBuffer CodecException: " + e.getMessage());
    L38:
        r108 = null;
    L34:
        e = move-exception;
        e("[" + this.f380322b + "]: getInputBuffer IllegalStateException: " + e.getMessage());
        goto L38
    L27:
        e = move-exception;
        e("[" + this.f380322b + "]: dequeueInputBuffer CodecException: " + e.getMessage());
    L29:
        r107 = -1;
    L25:
        e = move-exception;
        e("[" + this.f380322b + "]: dequeueInputBuffer IllegalStateException: " + e.getMessage());
        this.f380323c = false;
        this.f380324d = true;
        goto L29
    L13:
        ArrayList<d> r109 = r103.f380392c;
        if (r102 < 0) goto L12;
        if (r102 >= r109.size()) goto L12;
        r105 = (d) ListProtector.get(r109, r102);
    L61:
        return r100;
    }

    public final void d() {
        if (this.f380321a != null) goto L5;
        return;
    L5:
        AnimaXLog.b("CodecManager", "releaseDecoder");
        this.f380321a.stop();     // Catch: IllegalStateException -> L8 Throwable -> L10
    L12:
        this.f380323c = false;
        this.f380321a.release();
        this.f380321a = null;
        this.f380330j = 0;
        g();
        this.f380325e = -1;
        this.f380328h = 0;
        this.f380326f = 0;
        this.f380327g = -1;
        return;
    L10:
        e = move-exception;
        e.getMessage();
        goto L12
    }

    public final void g() {
        if (this.f380330j >= 0) goto L5;
        this.f380330j = 0;
    L5:
        int r100 = this.f380330j;
        if (r100 <= 1) goto L8;
        this.f380329i = Math.min(20, r100 + 5);
        return;
    L8:
        this.f380329i = Math.min(20, (r100 * 3) + 3);
    }

    public CodecManager(h r100) {
        this.f380324d = false;
        this.f380331k = 0;
        this.f380333m = r100;
    }

    public final q4a.d a(String r100) {
        f r101 = this.f380334n.f380339b;
        if (r101 != null) goto L5;
        MediaFormat r102 = null;
    L37:
        this.f380321a.configure(r102, this.f380335o, null, 0);     // Catch: IllegalStateException -> L9 IllegalArgumentException -> L11 MediaCodec.CryptoException -> L13 MediaCodec.CodecException -> L15
        String r103 = null;
    L17:
        q4a.d r104 = new q4a.d(r103);
        if (r104.f531718a == true) goto L35;
        this.f380321a.release();
        this.f380321a = null;
        return r104;
    L35:
        this.f380321a.start();     // Catch: IllegalStateException -> L23 IllegalArgumentException -> L25 MediaCodec.CodecException -> L27
        String r105 = null;
    L29:
        q4a.d r106 = new q4a.d(r105);
        if (r106.f531718a == true) goto L33;
        this.f380321a.release();
        this.f380321a = null;
        return r106;
    L33:
        this.f380322b = r100;
        this.f380323c = true;
        AnimaXLog.b("CodecManager", "chosen decoder: " + r100);
        return new q4a.d();
    L27:
        e = move-exception;
        r105 = "startDecoder CodecException: " + e.getMessage();
    L25:
        e = e;
    L26:
        r105 = "startDecoder Exception: " + e.getMessage();
    L23:
        e = e;
        goto L26
    L15:
        e = move-exception;
        r103 = "configureCodec CodecException: " + e.getMessage();
    L13:
        e = move-exception;
        r103 = "configureCodec CryptoException: " + e.getMessage();
    L11:
        e = e;
    L12:
        r103 = "configureCodec Exception: " + e.getMessage();
    L9:
        e = e;
        goto L12
    L5:
        r102 = r101.f380361a;
        goto L37
    }

    public final void e(String r100) {
        a r101 = this.f380333m;
        if (r101 == null) goto L6;
        h r102 = (h) r101;
        r102.getClass();
        r102.d(new i(r102, r100));
        return;
    }

    public final q4a.d f(String r100) {
        AnimaXLog.b("CodecManager", "try decoder: " + r100);
        if (this.f380334n == null) goto L5;
        this.f380321a = MediaCodec.createByCodecName(r100);     // Catch: IllegalArgumentException -> L8 IOException -> L10 MediaCodec.CodecException -> L12
        String r101 = null;
    L14:
        q4a.d r102 = new q4a.d(r101);
        if (r102.f531718a == true) goto L18;
        return r102;
    L18:
        return a(r100);
    L12:
        e = move-exception;
        r101 = "createByCodecName CodecException: " + e.getMessage();
    L10:
        e = e;
    L11:
        r101 = "createByCodecName Exception: " + e.getMessage();
    L8:
        e = e;
        goto L11
    L5:
        return new q4a.d("tryInitDecoder error: mAsset is null");
    }
}
