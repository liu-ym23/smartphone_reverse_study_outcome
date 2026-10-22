package com.larus.dora.dorag.res;

import com.byted.cast.common.api.CodecType;
import com.byted.cast.common.sink.CastInfo;
import com.byted.cast.common.sink.IMirrorListener;
import com.byted.cast.common.sink.Statistics;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.im.service.audio.vlm.EncodedVideoCodecType;
import com.larus.im.service.audio.vlm.EncodedVideoFrameType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class k implements IMirrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraByteCastManager f331854a;

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onAudioOutput(String r100, CodecType.ACODEC_ID r101, byte[] r102, int r103, int r104, int r105, int r106, long r107) {
    }

    public k(DoraByteCastManager r100) {
        this.f331854a = r100;
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onInviteResult(boolean r100) {
        FLogger.f375446a.i(this.f331854a.f331811a, "mirror onInviteResult: success: " + r100);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onStatistics(Statistics r100) {
        FLogger.f375446a.i(this.f331854a.f331811a, "mirror onStatistics. stat: " + r100);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onCast(int r100, CastInfo r101) {
        FLogger r102 = FLogger.f375446a;
        String r103 = this.f331854a.f331811a;
        StringBuilder r104 = new StringBuilder("mirror onCast: clientId: ");
        r104.append(r100);
        r104.append(", castInfo: ");
        r104.append(r101);
        r104.append(", extra: ");
        Integer r105 = null;
        if (r101 == null) goto L5;
        String r106 = r101.extra;
    L6:
        r104.append(r106);
        r102.i(r103, r104.toString());
        if (r101 == null) goto L9;
        r105 = Integer.valueOf(r101.infoType);
    L9:
        if (r105 != null) goto L12;
    L17:
        if (r105 != null) goto L20;
    L22:
        if (r105 != null) goto L25;
    L70:
        if (r105 != null) goto L73;
        return;
    L73:
        if (r105.intValue() != 102) goto L88;
        ((ConcurrentHashMap) this.f331854a.f331817g).remove(String.valueOf(r100));
        return;
    L88:
        return;
    L25:
        if (r105.intValue() != 109) goto L70;
        DoraByteCastManager r107 = this.f331854a;
        r107.getClass();
        if (r101.infoType != 109) goto L49;
        String r108 = r101.extra;
        if (r108 != null) goto L32;
    L35:
        boolean r109 = true;
    L36:
        if (r109 == true) goto L49;
        JSONObject r110 = new JSONObject(r108);     // Catch: Exception -> L47
        String r111 = r110.optString("msg");     // Catch: Exception -> L47
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L47
        if (r111.length() <= 0) goto L41;
        boolean r112 = true;
    L42:
        if (r112 == false) goto L44;
        r110 = new JSONObject(r111);     // Catch: Exception -> L47
    L44:
        int r113 = r110.optInt("videoChan", -1);     // Catch: Exception -> L47
        int r114 = r110.optInt("videoPort", 0);     // Catch: Exception -> L47
        if (r113 != 2) goto L49;
    L50:
        if (r114 > 0) goto L53;
        FLogger.f375446a.i(this.f331854a.f331811a, "mirror onCast: skip register channel 2, invalid videoPort: " + r114);
        return;
    L53:
        b49.c r115 = new b49.c(2, r114, InetAddress.getByName("127.0.0.1"));
        DoraByteCastManager r116 = this.f331854a;
        List<b49.c> r117 = r116.A;
        if (r117 != null) goto L56;
        r117 = CollectionsKt.emptyList();
    L56:
        ArrayList r118 = new ArrayList();
        Iterator<T> r119 = r117.iterator();
    L58:
        if (r119.hasNext() == false) goto L65;
        Object r120 = r119.next();
        if (((b49.c) r120).f17649a != r115.f17649a) goto L62;
        boolean r121 = true;
    L63:
        if (r121 == true) goto L58;
        r118.add(r120);
        goto L58
    L62:
        r121 = false;
        goto L63
    L65:
        r116.A = CollectionsKt.plus(r118, r115);
        IDoraService r122 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r122 == null) goto L85;
        AbilityService r123 = r122.o0();
        if (r123 == null) goto L86;
        r123.o(CollectionsKt.listOf(r115));
        return;
    L86:
        return;
    L85:
        return;
    L41:
        r112 = false;
    L47:
        e = move-exception;
        FLogger.f375446a.e(r107.f331811a, "parseVideoPort error, extra: " + r108, e);
        goto L49
    L32:
        if (r108.length() == 0) goto L35;
        r109 = false;
    L49:
        r114 = 0;
        goto L50
    L20:
        if (r105.intValue() != 101) goto L22;
        DoraByteCastManager r124 = this.f331854a;
        r124.f331826p = r101;
        r102.i(r124.f331811a, "mirror onCast: TYPE_CAST, act : " + AppHost.f326268a.a().getCurrentActivity());
        return;
    L12:
        if (r105.intValue() != 100) goto L17;
        DoraByteCastManager r125 = this.f331854a;
        String r126 = r101.clientID;
        if (r126 != null) goto L16;
        r126 = "";
    L16:
        r125.f331816f = r126;
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onVolume(String r100, int r101) {
        FLogger.f375446a.i(this.f331854a.f331811a, "mirror onVolume. clientId: " + r100 + ", desiredVolume: " + r101);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onError(String r100, int r101, String r102) {
        FLogger.f375446a.e(this.f331854a.f331811a, "mirror onError. clientId: " + r100 + ", errCode: " + r101 + ", errMsg: " + r102);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onNotifyLatency(String r100, Long r101, HashMap<String, Long> r102) {
        FLogger.f375446a.i(this.f331854a.f331811a, "mirror onNotifyLatency. clientId: " + r100 + ", frameIndex: " + r101 + ", latencyMap: " + r102);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onSinkLatencyStat(int r100, String r101, String r102) {
        FLogger.f375446a.i(this.f331854a.f331811a, "mirror onSinkLatencyStat: id: " + r100 + ", ip: " + r101 + ", stat: " + r102);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onSinkStuckStat(int r100, String r101, String r102) {
        FLogger.f375446a.i(this.f331854a.f331811a, "mirror onSinkStuckStat: id: " + r100 + ", ip: " + r101 + ", stat: " + r102);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onVideoOutput(String r210, CodecType.VCODEC_ID r211, byte[] r212, int r213, int r214, long r215, int r310) {
        long r100 = r215 / 1000;
        boolean r101 = Intrinsics.areEqual(r210, "127.0.0.1");
        FLogger r110 = FLogger.f375446a;
        r110.i(this.f331854a.f331811a, "mirror onVideoOutput. clientId: " + r210 + ", vcodecId: " + r211 + " width: " + r213 + ", height:" + r214 + ", timestampMs: " + r100 + ", timestampUs: " + r215 + ", nalType: " + r310 + ", has_ocr=" + r101);
        if (r212 == null) goto L70;
        if (r210 == null) goto L70;
        if (r310 != 1) goto L9;
        this.f331854a.getClass();
        this.f331854a.getClass();
        if (r211 != null) goto L40;
        int r102 = -1;
    L42:
        if (r102 != 1) goto L44;
        EncodedVideoCodecType r103 = EncodedVideoCodecType.H265;
    L45:
        EncodedVideoCodecType r111 = r103;
        EncodedVideoFrameType r112 = EncodedVideoFrameType.DELTA;
        JSONObject r104 = new JSONObject();
        DoraByteCastManager r113 = this.f331854a;
        r104.put("gen_utc_timestamp", r100);
        r104.put("trans_type", r113.f331824n);
        r104.put("has_ocr", r101);
        Unit r105 = Unit.INSTANCE;
        DoraByteCastManager.j(this.f331854a, r210, new tf9.a(r212, null, r215, r213, r214, 90, r111, r112, r104.toString().getBytes(Charsets.UTF_8), 514));
    L46:
        DoraByteCastManager r106 = this.f331854a;
        if (r106.f331836z == false) goto L78;
    L67:
        e = move-exception;
        FLogger.f375446a.e(r106.f331811a, "[dumpVideo] error=" + e.getMessage());
        return;
    L49:
        if (r106.f331835y != null) goto L62;
        String r107 = new SimpleDateFormat("yyyy_MMdd_HH_mm_ss").format(new Date());     // Catch: IOException -> L67
        StringBuilder r108 = new StringBuilder();     // Catch: IOException -> L67
        File r109 = AppHost.f326268a.getApplication().getExternalFilesDir(null);     // Catch: IOException -> L67
        if (r109 == null) goto L54;
        String r114 = r109.getAbsolutePath();     // Catch: IOException -> L67
        if (r114 == null) goto L54;
    L55:
        r108.append(r114);     // Catch: IOException -> L67
        String r115 = File.separator;     // Catch: IOException -> L67
        r108.append(r115);     // Catch: IOException -> L67
        r108.append("bytecast");     // Catch: IOException -> L67
        r108.append(r115);     // Catch: IOException -> L67
        r108.append("video");     // Catch: IOException -> L67
        r108.append(r115);     // Catch: IOException -> L67
        r108.append(r107);     // Catch: IOException -> L67
        r108.append("_VIDEO.bitstream");     // Catch: IOException -> L67
        PolarisFileWrapper r116 = new PolarisFileWrapper(r108.toString());     // Catch: IOException -> L67
        File r117 = r116.getParentFile();     // Catch: IOException -> L67
        if (r117 == null) goto L59;
        r117.mkdirs();     // Catch: IOException -> L67
    L59:
        if (r116.exists() == true) goto L61;
        r116.createNewFile();     // Catch: IOException -> L67
    L61:
        r106.f331835y = new PolarisFileOutputStreamWrapper(r116, true);     // Catch: IOException -> L67
    L54:
        r114 = "";
    L62:
        PolarisFileOutputStreamWrapper r118 = r106.f331835y;     // Catch: IOException -> L67
        if (r118 == null) goto L65;
        r118.write(r212);     // Catch: IOException -> L67
    L65:
        r110.i(r106.f331811a, "[dumpVideo] dump VIDEO success");     // Catch: IOException -> L67
        return;
    L78:
        return;
    L44:
        r103 = EncodedVideoCodecType.H264;
        goto L45
    L40:
        r102 = DoraByteCastManager.b.f331837a[r211.ordinal()];
        goto L42
    L9:
        if (r310 != 5) goto L11;
        byte[] r119 = (byte[]) ((ConcurrentHashMap) this.f331854a.f331817g).get(r210);
        if (r119 != null) goto L22;
        r119 = new byte[0];
    L22:
        if (r119.length != 0) goto L24;
        boolean r120 = true;
    L25:
        if (r120 == false) goto L28;
        r110.w(this.f331854a.f331811a, "key video frame has no codec config, clientId=" + r210 + ", codec=" + r211 + ", timestampUs=" + r215 + ", dataSize=" + r212.length);
    L28:
        this.f331854a.getClass();
        this.f331854a.getClass();
        if (r211 != null) goto L31;
        int r121 = -1;
    L33:
        if (r121 != 1) goto L35;
        EncodedVideoCodecType r122 = EncodedVideoCodecType.H265;
    L36:
        EncodedVideoCodecType r123 = r122;
        EncodedVideoFrameType r124 = EncodedVideoFrameType.KEY;
        JSONObject r125 = new JSONObject();
        DoraByteCastManager r126 = this.f331854a;
        r125.put("gen_utc_timestamp", r100);
        r125.put("trans_type", r126.f331824n);
        r125.put("has_ocr", r101);
        Unit r127 = Unit.INSTANCE;
        DoraByteCastManager.j(this.f331854a, r210, new tf9.a(r212, r119, r215, r213, r214, 90, r123, r124, r125.toString().getBytes(Charsets.UTF_8), 512));
        goto L46
    L35:
        r122 = EncodedVideoCodecType.H264;
        goto L36
    L31:
        r121 = DoraByteCastManager.b.f331837a[r211.ordinal()];
        goto L33
    L24:
        r120 = false;
        goto L25
    L11:
        if (r310 == 7) goto L13;
        r110.w(this.f331854a.f331811a, "drop video output: unsupported nalType=" + r310 + ", clientId=" + r210 + ", codec=" + r211 + ", timestampUs=" + r215 + ", dataSize=" + r212.length);
        goto L46
    L13:
        ((ConcurrentHashMap) this.f331854a.f331817g).put(r210, r212);
        DoraByteCastManager r128 = this.f331854a;
        t39.g r129 = r128.f331812b;
        if (r129 != null) goto L16;
        r110.w(r128.f331811a, "drop video codec callback: callback not registered, clientId=" + r210 + ", codec=" + r211 + ", codecConfigSize=" + r212.length);
        goto L46
    L16:
        r110.i(r128.f331811a, "cache video codec info, clientId=" + r210 + ", codec=" + r211 + ", codecConfigSize=" + r212.length);
        r129.c();
    L70:
        String r130 = this.f331854a.f331811a;
        StringBuilder r131 = new StringBuilder("drop video output: invalid input, clientId=");
        r131.append(r210);
        r131.append(", hasData=");
        if (r212 == null) goto L73;
        boolean r132 = true;
    L74:
        r131.append(r132);
        r131.append(", width=");
        r131.append(r213);
        r131.append(", height=");
        r131.append(r214);
        r131.append(", timestampUs=");
        r131.append(r215);
        r131.append(", nalType=");
        r131.append(r310);
        r110.w(r130, r131.toString());
        return;
    L73:
        r132 = false;
        goto L74
    }
}
