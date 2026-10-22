package com.ss.ttvideoengine.selector.strategy;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.strategrycenter.StrategyHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class GearStrategySC {
    public static final int GEAR_STRATEGY_SELECT_TYPE_PLAY = 1;
    public static final int GEAR_STRATEGY_SELECT_TYPE_PRELOAD = 2;
    public static final String TAG = "TTVideoEngine.GearStrategySC";

    public GearStrategySC() {
    }

    private static IVideoInfo findLowestBitrate(IVideoModel r100) {
        List<VideoInfo> r101 = r100.getVideoInfoList();
        VideoInfo r102 = null;
        if (r101 != null) goto L6;
        TTVideoEngineLog.e(TAG, "[GearStrategy] videoModel videoInfoList is null!!");
        return null;
    L6:
        Iterator<VideoInfo> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        VideoInfo r104 = r103.next();
        if (r104 == null) goto L8;
        if (r104.getMediatype() != VideoRef.TYPE_VIDEO) goto L8;
        if (r102 == null) goto L17;
        if (r102.getValueInt(3) < r104.getValueInt(3)) goto L8;
    L17:
        r102 = r104;
        goto L8
    L18:
        return r102;
    }

    private static IVideoInfo parseSelectResult(IVideoModel r100, Map<String, String> r101) {
        int r102 = 0;
        r102 = CastIntegerProtector.parseInt(String.valueOf(r101.get(GearStrategy.GEAR_STRATEGY_KEY_VIDEO_BITRATE)));     // Catch: Throwable -> L5
        CastIntegerProtector.parseInt(String.valueOf(r101.get(GearStrategy.GEAR_STRATEGY_KEY_AUDIO_BITRATE)));     // Catch: Throwable -> L5
        CastIntegerProtector.parseInt(String.valueOf(r101.get(GearStrategy.GEAR_STRATEGY_KEY_VIDEO_BITRATE_BEFORE_CACHE)));     // Catch: Throwable -> L5
    L7:
        List<VideoInfo> r103 = r100.getVideoInfoList();
        VideoInfo r104 = null;
        if (r103 != null) goto L11;
        TTVideoEngineLog.e(TAG, "[GearStrategy] videoModel videoInfoList is null!!");
        return null;
    L11:
        Iterator<VideoInfo> r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L33;
        VideoInfo r106 = r105.next();
        if (r106 == null) goto L13;
        if (r106.getValueInt(3) == r102) goto L22;
        if (r104 != null) goto L13;
        r104 = r106;
        goto L13
    L22:
        return r106;
    L33:
        return r104;
    L5:
        th = move-exception;
        TTVideoEngineLog.i(TAG, "[GearStrategy]GearStrategy parse result failed" + th.toString());
        goto L7
    }

    public static IVideoInfo selectBitrate(IVideoModel r100, int r101, Map<String, Object> r102, Map<String, String> r103) {
        if (r100 != null) goto L6;
        TTVideoEngineLog.w(TAG, "[GearStrategy] select bitrate but videomodel is null!!");
        return null;
    L6:
        TTVideoEngineLog.i(TAG, "[GearStrategy]GearStrategy.selectBitrate select start type: " + r101 + ", videoId:" + r100.getVideoRefStr(2));
        Map<String, String> r104 = StrategyHelper.helper().selectResolutionStringMapV2(r100, r101, r102);
        if (r104 == null) goto L14;
        TTVideoEngineLog.d(TAG, "[GearStrategy]GearStrategy select result: " + r104);
        if (r103 == null) goto L12;
        r103.putAll(r104);
    L12:
        return parseSelectResult(r100, r104);
    L14:
        return findLowestBitrate(r100);
    }
}
