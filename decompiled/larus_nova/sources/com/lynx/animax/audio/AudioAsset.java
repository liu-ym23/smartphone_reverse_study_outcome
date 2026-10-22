package com.lynx.animax.audio;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.lynx.animax.util.AnimaXLog;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import p4a.a;
import p4a.b;
import p4a.c;

/* JADX INFO: loaded from: classes32.dex */
public class AudioAsset {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f380246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f380247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f380248c;

    public AudioAsset() {
    }

    public static AudioAsset create() {
        return new AudioAsset();
    }

    public final boolean a() {
        c r100 = this.f380247b;
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (r100.f527719b <= 0) goto L11;
        if (r100.f527720c <= 0) goto L11;
        if (r100.f527721d <= 0) goto L11;
        return true;
    }

    public boolean loadLocal(String r210) {
        if (r210 != null) goto L5;
    L143:
        AnimaXLog.a("AudioAsset", "audio file path is empty");
        return false;
    L5:
        if (r210.isEmpty() == true) goto L143;
        ByteBuffer r100 = null;
        if (r210.isEmpty() == true) goto L33;
        c r101 = new c();
        MediaExtractor r102 = new MediaExtractor();
        if (b.a(r102, r210) == true) goto L13;
        AnimaXLog.a("AudioAssetExtractor", "load fail, MediaExtractor setDataSource error");
        r102.release();
        goto L33
    L13:
        int r103 = r102.getTrackCount();
        int r110 = 0;
    L14:
        if (r110 >= r103) goto L31;
        MediaFormat r111 = r102.getTrackFormat(r110);
        String r104 = r111.getString("mime");     // Catch: ClassCastException -> L18
    L20:
        if (r104 == null) goto L29;
        if (r104.startsWith("audio/") == false) goto L29;
        r101.f527723f = r110;
        r101.f527718a = r111;
        r101.f527719b = r111.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);     // Catch: ClassCastException -> L26
        r101.f527720c = r111.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);     // Catch: ClassCastException -> L26
        r101.f527721d = r111.getLong("durationUs");     // Catch: ClassCastException -> L26
    L28:
        AnimaXLog.b("AudioAssetExtractor", "audio track format: " + r111);
    L26:
        e = move-exception;
        AnimaXLog.a("AudioAssetExtractor", "Failed to get meta info from format: " + e.getMessage());
    L29:
        r110 = r110 + 1;
    L18:
        e = move-exception;
        AnimaXLog.a("AudioAssetExtractor", "format doesn't has mime property: " + e.getMessage());
        r104 = null;
    L31:
        if (r101.f527723f >= 0) goto L34;
        AnimaXLog.a("AudioAssetExtractor", "load fail, there is no audio track");
        r102.release();
        goto L33
    L34:
        r102.release();
    L35:
        this.f380247b = r101;
        if (a() == true) goto L39;
        this.f380247b = null;
        return false;
    L39:
        this.f380246a = r210;
        if (a() == true) goto L43;
        return false;
    L43:
        if (this.f380248c != null) goto L140;
        c r105 = this.f380247b;
        String r106 = this.f380246a;
        int r107 = r105.f527723f;
        if (r106 != null) goto L47;
    L138:
        this.f380248c = r100;
        goto L140
    L47:
        if (r106.isEmpty() == true) goto L138;
        if (r107 < 0) goto L138;
        MediaExtractor r108 = new MediaExtractor();
        if (b.a(r108, r106) == true) goto L53;
        AnimaXLog.a("AudioAssetExtractor", "load fail, MediaExtractor setDataSource error");
        r108.release();
        goto L138
    L53:
        r108.selectTrack(r107);
        a r109 = new a(r105);
        if (r109.f527713b == null) goto L56;
        boolean r112 = true;
    L57:
        if (r112 == true) goto L59;
        AnimaXLog.a("AudioAssetExtractor", "Failed to init decoder.");
        r108.release();
        goto L138
    L59:
        ByteArrayOutputStream r113 = new ByteArrayOutputStream();
        MediaCodec r114 = r109.f527713b;     // Catch: Throwable -> L115 Exception -> L117
        if (r114 == null) goto L64;
        r109.f527714c = false;     // Catch: Throwable -> L115 Exception -> L117
        r114.start();     // Catch: Throwable -> L115 Exception -> L117
    L64:
        ByteBuffer r115 = ByteBuffer.allocate(8192);     // Catch: Throwable -> L115 Exception -> L117
        boolean r116 = true;
        int r117 = 0;
    L66:
        if (r109.f527714c == true) goto L112;
        if (r116 == false) goto L95;
        MediaCodec r118 = r109.f527713b;     // Catch: Throwable -> L115 Exception -> L117
        if (r118 == null) goto L73;
        int r119 = r118.dequeueInputBuffer(1000);     // Catch: Throwable -> L115 Exception -> L117
        r109.f527715d = r119;     // Catch: Throwable -> L115 Exception -> L117
        if (r119 < 0) goto L73;
        ByteBuffer r120 = r109.f527713b.getInputBuffer(r119);     // Catch: Throwable -> L115 Exception -> L117
    L75:
        if (r120 == null) goto L95;
        int r121 = 1;
    L78:
        if (r121 > 20) goto L86;
        r108.readSampleData(r115, 0);     // Catch: Throwable -> L115 Exception -> L117
        if ((r120.position() + r115.limit()) > r120.capacity()) goto L86;
        r120.put(r115);     // Catch: Throwable -> L115 Exception -> L117
        if (r108.advance() == false) goto L84;
        r121 = r121 + 1;     // Catch: Throwable -> L115 Exception -> L117
        goto L78
    L84:
        r116 = false;
    L86:
        r120.flip();     // Catch: Throwable -> L115 Exception -> L117
        if (r116 == false) goto L89;
        int r122 = 0;
    L90:
        int r123 = r120.limit();     // Catch: Throwable -> L115 Exception -> L117
        MediaCodec r124 = r109.f527713b;     // Catch: Throwable -> L115 Exception -> L117
        if (r124 == null) goto L94;
        r124.queueInputBuffer(r109.f527715d, 0, r123, 0, r122);     // Catch: Throwable -> L115 Exception -> L117
    L94:
        boolean r125 = true;
    L96:
        ByteBuffer r126 = r109.a();     // Catch: Throwable -> L115 Exception -> L117
        if (r126 == null) goto L98;
        if (r126.hasArray() == false) goto L106;
        byte[] r127 = r126.array();     // Catch: Throwable -> L115 Exception -> L117
        int r128 = r126.arrayOffset();     // Catch: Throwable -> L115 Exception -> L117
        MediaCodec.BufferInfo r129 = r109.f527717f;     // Catch: Throwable -> L115 Exception -> L117
        r113.write(r127, r128 + r129.offset, r129.size);     // Catch: Throwable -> L115 Exception -> L117
    L107:
        MediaCodec r130 = r109.f527713b;     // Catch: Throwable -> L115 Exception -> L117
        if (r130 == null) goto L66;
        r130.releaseOutputBuffer(r109.f527716e, false);     // Catch: Throwable -> L115 Exception -> L117
        goto L66
    L106:
        byte[] r131 = new byte[r109.f527717f.size];     // Catch: Throwable -> L115 Exception -> L117
        r126.get(r131);     // Catch: Throwable -> L115 Exception -> L117
        r113.write(r131);     // Catch: Throwable -> L115 Exception -> L117
        goto L107
    L98:
        if (r125 == true) goto L101;
        r117 = r117 + 1;     // Catch: Throwable -> L115 Exception -> L117
    L101:
        if (r117 <= 100) goto L66;
    L89:
        r122 = 4;
    L73:
        r120 = null;
    L95:
        r125 = false;
    L112:
        if (r109.f527714c == true) goto L119;
        AnimaXLog.a("AudioAssetExtractor", "Failed to decode audio asset: the decoder is in infinite loop.");     // Catch: Throwable -> L115 Exception -> L117
    L119:
        MediaCodec r132 = r109.f527713b;
        if (r132 == null) goto L123;
        r132.stop();
    L123:
        MediaCodec r133 = r109.f527713b;
        if (r133 == null) goto L127;
        r133.release();
    L127:
        r108.release();
        r100 = ByteBuffer.wrap(r113.toByteArray());
    L115:
        th = move-exception;
        MediaCodec r134 = r109.f527713b;
        if (r134 == null) goto L132;
        r134.stop();
    L132:
        MediaCodec r135 = r109.f527713b;
        if (r135 == null) goto L136;
        r135.release();
    L136:
        r108.release();
        throw th;
    L117:
        e = move-exception;
        AnimaXLog.a("AudioAssetExtractor", "Failed to decode audio asset: " + e.getMessage());     // Catch: Throwable -> L115
        goto L119
    L56:
        r112 = false;
    L140:
        if (this.f380248c == null) goto L168;
        return true;
    L168:
        return false;
    L33:
        r101 = null;
        goto L35
    }
}
