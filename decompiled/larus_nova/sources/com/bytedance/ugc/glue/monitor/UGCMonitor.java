package com.bytedance.ugc.glue.monitor;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class UGCMonitor {
    public static final String EVENT_COMMENT = "comment";
    public static final String EVENT_PUBLISH = "ugc_publish";
    public static final int STATUS_CLICK = 1;
    public static final int STATUS_FINISH = 4;
    public static final int STATUS_REQUEST = 2;
    public static final int STATUS_RESPONSE = 3;
    public static final String TYPE_ARTICLE = "article";
    public static final String TYPE_BAOLIAO = "baoliao";
    public static final String TYPE_COMMENT_REPOST = "comment_repost";
    public static final String TYPE_FEED_COMMENTL = "feed_comment";
    public static final String TYPE_FM_AUDIO = "fm_audio";
    public static final String TYPE_PAID_COLUMN = "paid_column";
    public static final String TYPE_PHOTO = "photo";
    public static final String TYPE_POST = "post";
    public static final String TYPE_POST_DETAIL = "post_detail";
    public static final String TYPE_REPOST = "repost";
    public static final String TYPE_SHORT_VIDEO = "short_video";
    public static final String TYPE_VIDEO = "video";
    public static final String TYPE_WENDA = "wenda";
    public static final String TYPE_WENDA_ANSWER = "wenda_answer";
    public static final String TYPE_WENDA_ANSWER2 = "wenda_answer2";
    public static final String TYPE_WENDA_QUESTION = "wenda_question";
    public static final String UGC_DEBUGGER = "ugc_debugger";
    public static final String UGC_TYPE = "ugc_type";

    private UGCMonitor() {
    }

    public static void debug(int r100, Object... r101) {
        monitor(UGC_DEBUGGER, null, r100, r101);
    }

    public static void event(String r100, Bundle r101) {
        UGCMonitorService.event(r100, r101);
    }

    public static void event(String r100, JSONObject r101) {
        UGCMonitorService.event(r100, r101);
    }

    public static void metric(String r100, int r101, JSONObject r102) {
        metric(r100, null, r101, r102);
    }

    public static void monitor(String r100, int r101, JSONObject r102) {
        monitor(r100, null, r101, r102);
    }

    public static void metric(String r100, int r101, Object... r102) {
        metric(r100, null, r101, r102);
    }

    public static void monitor(String r100, int r101, Object... r102) {
        monitor(r100, null, r101, r102);
    }

    public static void metric(String r100, String r101, int r102, JSONObject r103) {
        UGCMonitorService.metric(r100, r101, r102, new Object[]{r103});
    }

    public static void monitor(String r100, String r101, int r102, JSONObject r103) {
        UGCMonitorService.monitor(r100, r101, r102, new Object[]{r103});
    }

    public static void send(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        UGCMonitorService.send(r100, r101, r102, r103);
    }

    public static void metric(String r100, String r101, int r102, Object... r103) {
        UGCMonitorService.metric(r100, r101, r102, r103);
    }

    public static void monitor(String r100, String r101, int r102, Object... r103) {
        UGCMonitorService.monitor(r100, r101, r102, r103);
    }
}
