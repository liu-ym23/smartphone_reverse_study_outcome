package com.ss.ttvideoengine;

import android.text.TextUtils;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
class TTVideoEngineHelper {
    private static final String TAG = "TTVideoEngine";

    public TTVideoEngineHelper() {
    }

    public static boolean isMayUseP2P(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        TTVideoEngineLog.d(TAG, "url null, may not use p2p");
        return false;
    L7:
        if (r100.contains("http://127.0.0.1") == true) goto L13;
        if (r100.contains(DataLoaderHelper.MDL_PREFIX) == true) goto L13;
        TTVideoEngineLog.d(TAG, "url not 127 or mdl protocol, may not use p2p");
        return false;
    L13:
        if (r100.contains(TTVideoEngineInterface.PLAY_API_KEY_CDNTYPE) == true) goto L16;
        TTVideoEngineLog.d(TAG, "url not contain cdntype, may not use p2p");
        return false;
    L16:
        TTVideoEngineLog.d(TAG, "url  may use p2p");
        return true;
    }

    public static Map<Integer, String> paramsFromVideoInfo(IVideoInfo r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100.getValueStr(32)) == true) goto L9;
        HashMap r101 = new HashMap();
        r101.put(32, r100.getValueStr(32));
        return r101;
    L9:
        return null;
    }

    public static IVideoInfo infoFromBitrate(IVideoModel r100, long r101) {
        List<VideoInfo> r102 = r100.getVideoInfoList();
        if (r101 <= 0) goto L18;
        if (r102 == null) goto L18;
        Iterator<VideoInfo> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L18;
        VideoInfo r104 = r103.next();
        if (r104 == null) goto L7;
        if (r104.getMediatype() == VideoRef.TYPE_AUDIO) goto L7;
        if (r104.getResolution() == null) goto L7;
        if (r104.getValueInt(3) != r101) goto L7;
        return r104;
    L18:
        return null;
    }
}
