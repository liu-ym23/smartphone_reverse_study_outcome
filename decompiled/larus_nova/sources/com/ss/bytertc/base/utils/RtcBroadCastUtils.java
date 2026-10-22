package com.ss.bytertc.base.utils;

import android.content.Context;
import android.content.Intent;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.realx.base.RXLogging;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;

/* JADX INFO: loaded from: classes40.dex */
public class RtcBroadCastUtils {
    private static int PLAY_STATE_INIT = 0;
    private static int PLAY_STATE_PAUSE = 2;
    private static int PLAY_STATE_START = 1;
    private static int PLAY_STATE_STOP = 3;
    private static String TAG = "RtcBroadCastUtils";

    public RtcBroadCastUtils() {
    }

    public static void sendBroadcast(int r100) {
        Context r101 = RtcContextUtils.getApplicationContext();
        Intent r102 = new Intent("CrossTalkDetectPlayerStatusChangeNotification");
        r102.putExtra(ILoadStallMonitor.EXTRA_PLAYER_TYPE, "RTC");
        r102.putExtra("player_hash", 0);
        r102.putExtra("biz_tag", "");
        r102.putExtra("play_source_id", "Android");
        if (r100 != 1) goto L6;
        r102.putExtra("play_state", PLAY_STATE_START);
    L8:
        r102.putExtra("play_start_timestamp", System.currentTimeMillis() / 1000);
        r102.putExtra(ITTVideoEngineEventSource.KEY_VOLUME, 1.0f);
        if (r100 != 1) goto L11;
        r102.putExtra("is_mute", false);
    L12:
        r101.sendBroadcast(r102);
        RXLogging.w(TAG, TAG + " :sendBroadcast state after: " + r100);
        return;
    L11:
        r102.putExtra("is_mute", true);
        goto L12
    L6:
        if (r100 != 2) goto L8;
        r102.putExtra("play_state", PLAY_STATE_STOP);
        goto L8
    }
}
