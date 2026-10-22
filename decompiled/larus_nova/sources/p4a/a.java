package p4a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import com.lynx.animax.util.AnimaXLog;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f527712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaCodec f527713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f527714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f527715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f527716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MediaCodec.BufferInfo f527717f;

    public final ByteBuffer a() {
        MediaCodec r100 = this.f527713b;
        ByteBuffer r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = r100.dequeueOutputBuffer(this.f527717f, 1000);
        if (r102 < 0) goto L9;
        r101 = this.f527713b.getOutputBuffer(r102);
        this.f527716e = r102;
    L16:
        if ((this.f527717f.flags & 4) == 0) goto L18;
        this.f527714c = true;
    L18:
        return r101;
    L9:
        if (r102 != (-2)) goto L16;
        if (Build.VERSION.SDK_INT < 24) goto L16;
        MediaFormat r103 = this.f527713b.getOutputFormat();
        AnimaXLog.b("AudioAssetDecoder", "decoded audio format: " + r103);
        if (r103.containsKey("pcm-encoding") == false) goto L16;
        this.f527712a.f527722e = r103.getInteger("pcm-encoding");
        goto L16
    }

    public a(c r100) {
        this.f527714c = false;
        this.f527715d = -1;
        this.f527716e = -1;
        this.f527717f = new MediaCodec.BufferInfo();
        this.f527712a = r100;
        MediaFormat r101 = r100.f527718a;
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = r101.getString("mime");
        if (r102 != null) goto L13;
        return;
    L13:
        MediaCodec r103 = MediaCodec.createDecoderByType(r102);     // Catch: Exception -> L10
        this.f527713b = r103;     // Catch: Exception -> L10
        r103.configure(r101, null, null, 0);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        AnimaXLog.a("AudioAssetDecoder", "Failed to init audio asset decoder: " + e.getMessage());
    }
}
