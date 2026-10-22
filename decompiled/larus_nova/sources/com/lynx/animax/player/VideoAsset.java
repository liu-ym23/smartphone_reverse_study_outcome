package com.lynx.animax.player;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.animax.util.AnimaXLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public class VideoAsset {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f380337e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f380338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f380339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f380340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f380341d;

    public VideoAsset() {
    }

    static {
        f380337e = new String[]{"csd-0", "csd-1", "csd-2"};
    }

    public static VideoAsset create() {
        return new VideoAsset();
    }

    public final boolean b() {
        boolean r100 = true;
        if (this.f380341d != null) goto L62;
        AnimaXLog.b("VideoAsset", "prepareFrameBuffer");
        f r101 = this.f380339b;
        if (r101 == null) goto L62;
        String r102 = this.f380338a;
        int r103 = r101.f380366f;
        if (r102 != null) goto L10;
    L46:
        l r104 = null;
    L47:
        this.f380341d = r104;
        if (r104 == null) goto L62;
        if (r104 == null) goto L56;
        ArrayList<Integer> r105 = r104.f380391b;
        if (r105.isEmpty() == true) goto L56;
        if (((Integer) ListProtector.get(r105, 0)).intValue() != 0) goto L56;
        boolean r106 = true;
    L57:
        if (r106 == false) goto L62;
        ArrayList<d> r107 = this.f380341d.f380392c;
        if (this.f380339b.f380365e == r107.size()) goto L62;
        AnimaXLog.a("VideoAsset", "prepareFrameBuffer: frameCount change from " + this.f380339b.f380365e + " to " + r107.size());
        this.f380339b.f380365e = r107.size();
    L56:
        r106 = false;
        goto L57
    L10:
        if (r102.isEmpty() == true) goto L46;
        if (r103 < 0) goto L46;
        r104 = new l();
        MediaExtractor r108 = new MediaExtractor();
        if (e.a(r108, r102) == true) goto L16;
        AnimaXLog.a("VideoAssetExtractor", "load fail, MediaExtractor setDataSource error");
        boolean r109 = false;
    L43:
        r108.release();
        if (r109 == false) goto L46;
    L16:
        r108.selectTrack(r103);
        int r110 = (int) new PolarisFileWrapper(r102).length();
        if (r110 > 0) goto L19;
        AnimaXLog.a("VideoAssetExtractor", "doExtractVideoRawData fail, videoSize = " + r110);
    L42:
        r109 = true;
        goto L43
    L19:
        ByteBuffer r111 = ByteBuffer.allocate(r110);
        ArrayList<Integer> r112 = r104.f380391b;
        ArrayList<d> r113 = r104.f380392c;
        int r114 = 0;
    L73:
        int r115 = r108.readSampleData(r111, r114);     // Catch: IllegalArgumentException -> L22
    L27:
        if (r115 <= 0) goto L36;
        if ((r108.getSampleFlags() & 1) <= 0) goto L31;
        boolean r116 = true;
    L32:
        if (r116 == false) goto L34;
        r112.add(Integer.valueOf(r113.size()));
    L34:
        int r117 = r115 + r114;
        r113.add(new d(r114, r117, r108.getSampleTime()));
        r108.advance();
        r114 = r117;
        goto L73
    L31:
        r116 = false;
        goto L32
    L36:
        if (r115 != (-1)) goto L38;
        boolean r118 = true;
    L39:
        if (r118 == false) goto L41;
        AnimaXLog.b("VideoAssetExtractor", "video size: " + r114 + " bytes, frame count: " + r113.size() + ", key frame count: " + r112.size());
        r104.f380390a = r111;
        goto L42
    L41:
        AnimaXLog.a("VideoAssetExtractor", "doExtractVideoRawData fail");
        r112.clear();
        r113.clear();
        goto L42
    L38:
        r118 = false;
    L22:
        e = move-exception;
        String r119 = e.getMessage();
        if (r119 != null) goto L26;
        r119 = "current buffer may not have enough space to read";
    L26:
        AnimaXLog.a("VideoAssetExtractor", "readSampleData IllegalArgumentException: ".concat(r119));
        r115 = 0;
    L62:
        l r120 = this.f380341d;
        if (r120 == null) goto L78;
        ArrayList<Integer> r121 = r120.f380391b;
        if (r121.isEmpty() == false) goto L68;
    L70:
        r100 = false;
    L72:
        return r100;
    L68:
        if (((Integer) ListProtector.get(r121, 0)).intValue() != 0) goto L70;
    L78:
        return false;
    }

    public int getFrameCount() {
        f r100 = this.f380339b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f380365e;
    }

    public float getFrameRate() {
        f r100 = this.f380339b;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.f380364d;
    }

    public int getHeight() {
        f r100 = this.f380339b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f380363c;
    }

    public ByteBuffer getVideoParameterSets() {
        MediaFormat r100 = this.f380339b.f380361a;
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        String[] r102 = f380337e;
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r104 >= r103) goto L17;
        String r106 = r102[r104];
        if (r100.containsKey(r106) == false) goto L17;
        ByteBuffer r107 = r100.getByteBuffer(r106);
        if (r107 == null) goto L15;
        if (r107.remaining() <= 0) goto L15;
        r101.add(r107);
        r105 = r105 + r107.remaining();
    L15:
        r104 = r104 + 1;
    L17:
        if (r101.isEmpty() == false) goto L19;
        return null;
    L19:
        ByteBuffer r108 = ByteBuffer.allocate(r105);
        Iterator r109 = r101.iterator();
    L21:
        if (r109.hasNext() == false) goto L23;
        r108.put(((ByteBuffer) r109.next()).duplicate());
        goto L21
    L23:
        r108.flip();
        return r108;
    }

    public int getWidth() {
        f r100 = this.f380339b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f380362b;
    }

    public boolean isHEVCFormat() {
        f r100 = this.f380339b;
        String r101 = null;
        if (r100 == null) goto L9;
        MediaFormat r102 = r100.f380361a;
        if (r102 == null) goto L9;
        r101 = r102.getString("mime");
    L9:
        if (r101 != null) goto L11;
    L13:
        return false;
    L11:
        if (r101.equalsIgnoreCase("video/hevc") == false) goto L13;
        return true;
    }

    public final ByteBuffer a(d r100) {
        if (r100 == null) goto L12;
        l r101 = this.f380341d;
        if (r101 == null) goto L12;
        ByteBuffer r102 = r101.f380390a;
        if (r102 != null) goto L10;
        return null;
    L10:
        r102.position(0);
        r102.limit(r100.f380359b);
        r102.position(r100.f380358a);
        return r102;
    L12:
        return null;
    }

    public ByteBuffer getFrameData(int r100) {
        l r101 = this.f380341d;
        d r102 = null;
        if (r101 == null) goto L12;
        ArrayList<d> r103 = r101.f380392c;
        if (r100 < 0) goto L12;
        if (r100 >= r103.size()) goto L12;
        r102 = (d) ListProtector.get(r103, r100);
    L12:
        return a(r102);
    }

    public int getPrevKeyFrame(int r100) {
        ArrayList<Integer> r101 = this.f380341d.f380391b;
        int r102 = Collections.binarySearch(r101, Integer.valueOf(r100));
        if (r102 >= 0) goto L6;
        r102 = (-r102) - 2;
    L6:
        return ((Integer) ListProtector.get(r101, r102)).intValue();
    }

    public boolean isSupportDecodeBySystem(boolean r100) {
        f r101 = this.f380339b;
        String r102 = null;
        if (r101 == null) goto L9;
        MediaFormat r103 = r101.f380361a;
        if (r103 == null) goto L9;
        r102 = r103.getString("mime");
    L9:
        if (r102 != null) goto L11;
    L23:
        return false;
    L11:
        monitor-enter(b.class);
    L20:
        th = move-exception;
        throw th;
    L13:
        if (b.f380352c != null) goto L15;
        b.f380352c = new b();     // Catch: Throwable -> L20
    L15:
        b r104 = b.f380352c;     // Catch: Throwable -> L20
        monitor-exit(b.class);
        if (r104.a(r102, r100) == false) goto L23;
        return true;
    }

    public boolean loadLocal(String r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L87:
        AnimaXLog.a("VideoAsset", "video file path is empty");
        this.f380340c = false;
        return false;
    L5:
        if (r110.isEmpty() == true) goto L87;
        if (r110.isEmpty() == true) goto L69;
        f r101 = new f();
        MediaExtractor r102 = new MediaExtractor();
        if (e.a(r102, r110) == true) goto L13;
        AnimaXLog.a("VideoAssetExtractor", "load fail, MediaExtractor setDataSource error");
    L28:
        boolean r103 = false;
    L66:
        r102.release();
        if (r103 == false) goto L69;
    L70:
        this.f380339b = r101;
        if (r101 != null) goto L73;
    L81:
        this.f380340c = r100;
        if (r100 == false) goto L84;
        this.f380338a = r110;
        b();
    L86:
        return this.f380340c;
    L84:
        this.f380339b = null;
        goto L86
    L73:
        if (r101.f380362b <= 0) goto L81;
        if (r101.f380363c <= 0) goto L81;
        if (r101.f380365e <= 0) goto L81;
        if (r101.f380364d <= 0.0f) goto L81;
        r100 = true;
        goto L81
    L13:
        int r104 = r102.getTrackCount();
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L26;
        MediaFormat r106 = r102.getTrackFormat(r105);
        String r111 = r106.getString("mime");     // Catch: ClassCastException -> L18
    L20:
        if (r111 == null) goto L24;
        if (r111.startsWith("video/") == false) goto L24;
        r101.f380366f = r105;
        r101.f380361a = r106;
    L24:
        r105 = r105 + 1;
    L18:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has mine property: " + e.getMessage());
        r111 = null;
    L26:
        if (r101.f380366f >= 0) goto L91;
        AnimaXLog.a("VideoAssetExtractor", "load fail, there is no video track");
        goto L28
    L91:
        r101.f380362b = r101.f380361a.getInteger("width");     // Catch: Throwable -> L32 NullPointerException -> L34
    L97:
        r101.f380363c = r101.f380361a.getInteger("height");     // Catch: Throwable -> L39 NullPointerException -> L41
    L43:
        MediaFormat r107 = r101.f380361a;
        r101.f380364d = r107.getInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE);     // Catch: ClassCastException -> L46 Throwable -> L48
    L51:
        if (0.0f != r101.f380364d) goto L95;
        r101.f380364d = r107.getFloat(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE);     // Catch: Throwable -> L55 NullPointerException -> L57
    L55:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has float frame-rate property: " + e.getMessage());
    L95:
        long r108 = r101.f380361a.getLong("durationUs");     // Catch: Throwable -> L61 NullPointerException -> L63
    L65:
        r101.f380365e = Math.round((r101.f380364d * r108) / 1000000.0f);
        AnimaXLog.b("VideoAssetExtractor", "frame count: " + r101.f380365e);
        r103 = true;
    L61:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has long durationUs property: " + e.getMessage());
        r108 = 0;
    L48:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has int frame-rate property: " + e.getMessage());
        r101.f380364d = 0.0f;
    L39:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has height property: " + e.getMessage());
        r101.f380363c = 0;
    L32:
        e = move-exception;
        AnimaXLog.a("VideoAssetExtractor", "format doesn't has width property: " + e.getMessage());
        r101.f380362b = 0;
    L69:
        r101 = null;
        goto L70
    }
}
