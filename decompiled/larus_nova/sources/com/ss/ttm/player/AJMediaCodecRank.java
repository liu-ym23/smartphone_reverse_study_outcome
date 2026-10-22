package com.ss.ttm.player;

import android.media.MediaCodecInfo;
import android.text.TextUtils;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes40.dex */
public class AJMediaCodecRank {
    public static final int RANK_ACCEPTABLE = 70;
    public static final int RANK_CODEC2_ACCEPTABLE = 150;
    public static final int RANK_CODEC2_TESTED = 200;
    public static final int RANK_IMPL_AMBIGUOUS = 40;
    public static final int RANK_LOWLATENCY_ACCEPTABLE = 150;
    public static final int RANK_NO_CAPS = 60;
    public static final int RANK_SOFTWARE = 20;
    public static final int RANK_TESTED = 100;
    private static final String TAG = "AJMediaCodecRank";
    private static Map<String, Integer> mTestHWCodecs;
    public String mCodecType;
    public MediaCodecInfo mMediaCodecInfo;
    public int mRank;

    private static Map<String, Integer> getTestHWcodecs() {
        Map<String, Integer> r100 = mTestHWCodecs;
        if (r100 == null) goto L5;
        return r100;
    L5:
        TreeMap r101 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        mTestHWCodecs = r101;
        r101.put("OMX.qcom.video.decoder.avc", 100);
        mTestHWCodecs.put("OMX.qcom.video.decoder.hevc", 100);
        mTestHWCodecs.put("OMX.qcom.video.decoder.hevcswvdec", 20);
        mTestHWCodecs.put("OMX.MTK.VIDEO.DECODER.HEVC", 100);
        mTestHWCodecs.put("OMX.MTK.VIDEO.DECODER.AVC", 100);
        mTestHWCodecs.put("OMX.Nvidia.h264.decode", 100);
        mTestHWCodecs.put("OMX.Intel.hw_vd.h264", 100);
        mTestHWCodecs.put("OMX.Intel.VideoDecoder.AVC", 99);
        mTestHWCodecs.put("OMX.SEC.avc.dec", 100);
        mTestHWCodecs.put("OMX.SEC.AVC.Decoder", 99);
        mTestHWCodecs.put("OMX.SEC.avcdec", 98);
        mTestHWCodecs.put("OMX.SEC.avc.sw.dec", 20);
        mTestHWCodecs.put("OMX.SEC.hevc.sw.dec", 20);
        mTestHWCodecs.put("OMX.Exynos.avc.dec", 100);
        mTestHWCodecs.put("OMX.Exynos.AVC.Decoder", 99);
        mTestHWCodecs.put("OMX.TI.DUCATI1.VIDEO.DECODER", 100);
        mTestHWCodecs.put("OMX.rk.video_decoder.avc", 100);
        mTestHWCodecs.put("OMX.amlogic.avc.decoder.awesome", 100);
        mTestHWCodecs.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 100);
        mTestHWCodecs.put("OMX.brcm.video.h264.hw.decoder", 40);
        mTestHWCodecs.put("OMX.k3.video.decoder.avc", 40);
        mTestHWCodecs.put("OMX.IMG.MSVDX.Decoder.AVC", 100);
        mTestHWCodecs.put("OMX.hisi.video.decoder.avc", 100);
        mTestHWCodecs.put("OMX.hisi.video.decoder.hevc", 100);
        mTestHWCodecs.put("OMX.MARVELL.VIDEO.H264DECODER", 20);
        mTestHWCodecs.put("OMX.sprd.soft.h264.decoder", 20);
        mTestHWCodecs.put("OMX.google.aac.decoder", 100);
        mTestHWCodecs.put("OMX.google.h264.decoder", 70);
        mTestHWCodecs.put("OMX.google.hevc.decoder", 70);
        mTestHWCodecs.put("c2.android.h264.decoder", 70);
        mTestHWCodecs.put("c2.android.hevc.decoder", 70);
        return mTestHWCodecs;
    }

    public AJMediaCodecRank() {
        this.mRank = 0;
    }

    public static AJMediaCodecRank setupRank(MediaCodecInfo r100, String r101, int r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r103 = r100.getName();
        if (TextUtils.isEmpty(r103) == false) goto L8;
        return null;
    L8:
        Integer r104 = getTestHWcodecs().get(r103);
        if (r104 == null) goto L27;
        int r105 = r104.intValue();
    L24:
        AJMediaCodecRank r106 = new AJMediaCodecRank();
        r106.mMediaCodecInfo = r100;
        r106.mCodecType = r101;
        r106.mRank = r105;
        return r106;
    L27:
        if (r100.getCapabilitiesForType(r101) == null) goto L23;
        boolean r107 = false;
        if (TTPlayerConfiger.getValue(48, 0) == 1) goto L17;
        if (r102 == 1) goto L17;
    L18:
        if (r107 != true) goto L22;
        if (r103.startsWith("c2.") == false) goto L22;
        r105 = 150;
    L22:
        r105 = 70;
    L17:
        r107 = true;
    L23:
        r105 = 60;
        goto L24
    }
}
