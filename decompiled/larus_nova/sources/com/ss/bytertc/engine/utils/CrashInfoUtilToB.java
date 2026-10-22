package com.ss.bytertc.engine.utils;

import android.content.Context;
import com.apm.lite.MonitorCrash;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.bytertc.base.utils.RtcContextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class CrashInfoUtilToB {
    private static final String TAG = "CrashInfoUtilToB";
    private static final Context context = null;
    private static MonitorCrash sdk = null;
    private static final String token = "d7271e1eac254529abcffc63e36b02c3";

    public CrashInfoUtilToB() {
    }

    static {
        context = RtcContextUtils.getApplicationContext();
    }

    public static void addTagsReport(String r100) {
        LogUtil.d(TAG, "addTagsReport...");
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L8
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L8
    L5:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();     // Catch: Exception -> L8
        sdk.addTags(r103, JSONObjectProtectorUtils.getString(r101, r103));     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        LogUtil.e(TAG, "addTagsReport catch exception.\n" + e.getMessage());
    }

    public static void onEventV3Report(String r100) {
        LogUtil.d(TAG, "onEventV3Report...");
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L17
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L17
        boolean r103 = false;
    L5:
        if (r102.hasNext() == false) goto L12;
        String r104 = r102.next();     // Catch: Exception -> L17
        String r105 = JSONObjectProtectorUtils.getString(r101, r104);     // Catch: Exception -> L17
        sdk.addPageViewTags(r104, r105);     // Catch: Exception -> L17
        if (r104.equals("rtc_room_id") == false) goto L5;
        if (r105.equals("") == true) goto L5;
        r103 = true;
        goto L5
    L12:
        if (r103 == false) goto L14;
        sdk.addPageViewTags("rtc_session_type", "joinRoom");     // Catch: Exception -> L17
    L15:
        sdk.reportPageView(null);     // Catch: Exception -> L17
        return;
    L14:
        sdk.addPageViewTags("rtc_session_type", "createEngine");     // Catch: Exception -> L17
    L17:
        e = move-exception;
        LogUtil.e(TAG, "onEventV3Report catch exception.\n" + e.getMessage());
    }

    public static void initApm(String r100, final String r101) {
        LogUtil.d(TAG, "initApm...");
        sdk = MonitorCrash.initSDK(context, MonitorCrash.Config.sdk("432410").token(token).versionName("1。0").versionCode(1).dynamicParams(new AnonymousClass1(r101)).channel("rtc_sdk").keyWords(new String[]{"bytertc", "com.ss.video.rtc.oner", "com.bytedance.ttgame.module.rtc.RtcService"}).soList(new String[]{"libbyteaudio.so", "libbytertc.so", "libagora.so", "libonerrtc.so", "libvolcenginertc.so", "libulien_audio.so"}).build());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        LogUtil.e(TAG, "initApm catch exception.\n" + e.getMessage());
    }
}
