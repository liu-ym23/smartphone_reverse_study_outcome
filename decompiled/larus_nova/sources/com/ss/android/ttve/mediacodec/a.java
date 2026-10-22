package com.ss.android.ttve.mediacodec;

import android.media.MediaCodecInfo;
import android.text.TextUtils;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, Integer> f449887c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaCodecInfo f449888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f449889b;

    public a() {
        this.f449889b = 0;
    }

    public static a a(MediaCodecInfo r100, String r101) {
        String r102 = r100.getName();
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return null;
    L6:
        Map<String, Integer> r103 = f449887c;
        if (r103 != null) goto L10;
        TreeMap r104 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        f449887c = r104;
        r104.put("OMX.qcom.video.decoder.avc", 100);
        ((TreeMap) f449887c).put("OMX.qcom.video.decoder.hevc", 100);
        ((TreeMap) f449887c).put("OMX.qcom.video.decoder.hevcswvdec", 20);
        ((TreeMap) f449887c).put("OMX.qcom.video.decoder.mpeg4", 100);
        ((TreeMap) f449887c).put("OMX.qcom.video.decoder.mpeg2", 100);
        ((TreeMap) f449887c).put("OMX.qcom.video.decoder.vp8", 100);
        ((TreeMap) f449887c).put("OMX.qcom.video.decoder.vp9", 100);
        ((TreeMap) f449887c).put("OMX.MTK.VIDEO.DECODER.HEVC", 100);
        ((TreeMap) f449887c).put("OMX.MTK.VIDEO.DECODER.AVC", 100);
        ((TreeMap) f449887c).put("OMX.MTK.VIDEO.DECODER.MPEG2", 100);
        ((TreeMap) f449887c).put("OMX.MTK.VIDEO.DECODER.MPEG4", 100);
        ((TreeMap) f449887c).put("OMX.MTK.VIDEO.DECODER.VP9", 100);
        ((TreeMap) f449887c).put("OMX.MTK.VIDEO.DECODER.VPX", 100);
        ((TreeMap) f449887c).put("OMX.Nvidia.h264.decode", 100);
        ((TreeMap) f449887c).put("OMX.Intel.hw_vd.h264", 100);
        ((TreeMap) f449887c).put("OMX.Intel.VideoDecoder.AVC", 99);
        ((TreeMap) f449887c).put("OMX.SEC.avc.dec", 100);
        ((TreeMap) f449887c).put("OMX.SEC.AVC.Decoder", 99);
        ((TreeMap) f449887c).put("OMX.SEC.avcdec", 98);
        ((TreeMap) f449887c).put("OMX.SEC.avc.sw.dec", 20);
        ((TreeMap) f449887c).put("OMX.SEC.hevc.sw.dec", 20);
        ((TreeMap) f449887c).put("OMX.SEC.mpeg4.dec", 100);
        ((TreeMap) f449887c).put("OMX.SEC.mpeg2.dec", 100);
        ((TreeMap) f449887c).put("OMX.SEC.vp8.dec", 100);
        ((TreeMap) f449887c).put("OMX.SEC.vp9.dec", 100);
        ((TreeMap) f449887c).put("OMX.Exynos.avc.dec", 100);
        ((TreeMap) f449887c).put("OMX.Exynos.AVC.Decoder", 99);
        ((TreeMap) f449887c).put("OMX.Exynos.MPEG4.Decoder", 100);
        ((TreeMap) f449887c).put("OMX.Exynos.MPEG2.Decoder", 100);
        ((TreeMap) f449887c).put("OMX.Exynos.VP8.Decoder", 100);
        ((TreeMap) f449887c).put("OMX.Exynos.VP9.Decoder", 100);
        ((TreeMap) f449887c).put("OMX.TI.DUCATI1.VIDEO.DECODER", 100);
        ((TreeMap) f449887c).put("OMX.rk.video_decoder.avc", 100);
        ((TreeMap) f449887c).put("OMX.amlogic.avc.decoder.awesome", 100);
        ((TreeMap) f449887c).put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 100);
        ((TreeMap) f449887c).put("OMX.brcm.video.h264.hw.decoder", 40);
        ((TreeMap) f449887c).put("OMX.k3.video.decoder.avc", 40);
        ((TreeMap) f449887c).put("OMX.IMG.MSVDX.Decoder.AVC", 100);
        ((TreeMap) f449887c).put("OMX.hisi.video.decoder.avc", 100);
        ((TreeMap) f449887c).put("OMX.hisi.video.decoder.hevc", 100);
        ((TreeMap) f449887c).put("OMX.hisi.video.decoder.mpeg4", 100);
        ((TreeMap) f449887c).put("OMX.hisi.video.decoder.mpeg2", 100);
        ((TreeMap) f449887c).put("OMX.hisi.video.decoder.vp8", 100);
        ((TreeMap) f449887c).put("OMX.hisi.video.decoder.vp9", 100);
        ((TreeMap) f449887c).put("OMX.MARVELL.VIDEO.H264DECODER", 20);
        ((TreeMap) f449887c).put("OMX.sprd.soft.h264.decoder", 20);
        r103 = f449887c;
    L10:
        Integer r105 = r103.get(r102);
        if (r105 == null) goto L20;
        int r106 = r105.intValue();
    L17:
        a r107 = new a();
        r107.f449888a = r100;
        r107.f449889b = r106;
        return r107;
    L20:
        if (r100.getCapabilitiesForType(r101) == null) goto L16;
        r106 = 70;
    L16:
        r106 = 60;
        goto L17
    }
}
