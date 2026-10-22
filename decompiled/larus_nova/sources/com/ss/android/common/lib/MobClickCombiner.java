package com.ss.android.common.lib;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.common.applog.AppLog;
import com.ss.android.message.log.PushLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class MobClickCombiner {
    private static a sAgent;

    public interface a {
    }

    public MobClickCombiner() {
    }

    public static void setAgent(a r100) {
    }

    public static void setAgentChannel(String r100) {
    }

    public static void setCustomVersion(String r100) {
    }

    public static void setVersionInfo(String r100, int r101) {
    }

    public static synchronized void init(Context r100) {
        monitor-enter(MobClickCombiner.class);
        monitor-exit(MobClickCombiner.class);
    }

    public static void onPause(Context r100) {
        AppLog.f408004g0.onPause(r100);
    }

    public static void onPauseWithoutAgent(Context r100) {
        AppLog.f408004g0.onPause(r100);
    }

    public static void onResume(Context r100) {
        AppLog.f408004g0.onResume(r100);
    }

    public static void onResumeWithoutAgent(Context r100) {
        AppLog.f408004g0.onResume(r100);
    }

    public static void onEvent(Context r110, String r111) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
        return;
    L5:
        if (r110 == null) goto L8;
        AppLog.a(r110, PushLog.CATEGORY, r111, null, 0, 0, null);
        return;
    }

    public static void onEventWithoutAgent(Context r110, String r111) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
        return;
    L5:
        if (r110 == null) goto L8;
        AppLog.a(r110, PushLog.CATEGORY, r111, null, 0, 0, null);
        return;
    }

    public static void onEvent(Context r110, String r111, String r112) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
        return;
    L5:
        if (r110 == null) goto L8;
        AppLog.a(r110, PushLog.CATEGORY, r111, r112, 0, 0, null);
        return;
    }

    public static void onEventWithoutAgent(Context r110, String r111, String r112) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
        return;
    L5:
        if (r110 == null) goto L8;
        AppLog.a(r110, PushLog.CATEGORY, r111, r112, 0, 0, null);
        return;
    }

    public static void onEventCount(Context r110, String r111, String r112, int r113) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
        return;
    L5:
        if (r110 == null) goto L8;
        AppLog.a(r110, PushLog.CATEGORY, r111, r112, r113, 0, null);
        return;
    }

    public static void onEvent(Context r100, String r110, String r111, long r112, long r113) {
        onEvent(r100, PushLog.CATEGORY, r110, r111, r112, r113, null);
    }

    public static void onEventWithoutAgent(Context r100, String r110, String r111, long r112, long r113) {
        onEventWithoutAgent(r100, PushLog.CATEGORY, r110, r111, r112, r113, null);
    }

    public static void onEvent(Context r100, String r110, String r111, long r112, long r113, JSONObject r114) {
        onEvent(r100, PushLog.CATEGORY, r110, r111, r112, r113, r114);
    }

    public static void onEventWithoutAgent(Context r100, String r110, String r111, long r112, long r113, JSONObject r114) {
        onEventWithoutAgent(r100, PushLog.CATEGORY, r110, r111, r112, r113, r114);
    }

    public static void onEvent(Context r100, String r110, String r111, String r112, long r113, long r114) {
        onEvent(r100, r110, r111, r112, r113, r114, null);
    }

    public static void onEventWithoutAgent(Context r100, String r110, String r111, String r112, long r113, long r114) {
        onEventWithoutAgent(r100, r110, r111, r112, r113, r114, null);
    }

    public static void onEvent(Context r110, String r111, String r112, String r113, long r114, long r115, JSONObject r116) {
        if (TextUtils.isEmpty(r112) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r111) == false) goto L8;
        String r100 = PushLog.CATEGORY;
    L9:
        if (r110 == null) goto L12;
        AppLog.E(r110, r100, r112, r113, r114, r115, r116);
        PushLog.CATEGORY.equals(r100);
        return;
    L12:
        return;
    L8:
        r100 = r111;
        goto L9
    }

    public static void onEventWithoutAgent(Context r110, String r111, String r112, String r113, long r114, long r115, JSONObject r116) {
        if (TextUtils.isEmpty(r112) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r111) == false) goto L8;
        String r100 = PushLog.CATEGORY;
    L9:
        if (r110 == null) goto L12;
        AppLog.E(r110, r100, r112, r113, r114, r115, r116);
        return;
    L12:
        return;
    L8:
        r100 = r111;
        goto L9
    }
}
