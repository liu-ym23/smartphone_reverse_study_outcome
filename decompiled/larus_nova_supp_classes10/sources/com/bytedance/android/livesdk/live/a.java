package com.bytedance.android.livesdk.live;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.m0;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(String r2) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        if (r2 == null) goto L6;
        JSONObject r3 = new JSONObject(r2);     // Catch: Throwable -> L12
    L7:
        if (r3 == null) goto L9;
        String r4 = r3.toString();     // Catch: Throwable -> L12
    L10:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r5) == true) goto L19;
        r0 = r5;
    L19:
        return (String) r0;
    L9:
        r4 = null;
        goto L10
    L6:
        r3 = null;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static boolean c(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static String b(Long r9, List r10, int r11, Bundle r12, Integer r13, Long r14, int r15) {
        Object r1 = null;
        if ((r15 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r11 = -1;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r12 = null;
    L12:
        if ((r15 & 16) == 0) goto L15;
        r13 = null;
    L15:
        if ((r15 & 32) == 0) goto L65;
        r14 = null;
    L65:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L57
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L57
        boolean r3 = true;
        if (r9 != null) goto L21;
    L29:
        if (r10 != null) goto L31;
    L39:
        if (r11 <= 0) goto L41;
        r2.put("hide_bucket_count", r11);     // Catch: Throwable -> L57
    L41:
        if (r12 == null) goto L51;
        Bundle r16 = m0.a(r12);     // Catch: Throwable -> L57
        if (r16 == null) goto L51;
        String r17 = r16.getString("filter_info");     // Catch: Throwable -> L57
        if (r17 == null) goto L51;
        if (TextUtils.isEmpty(r17) == true) goto L51;
        r2.put("filter_info", new JSONObject(r17));     // Catch: Exception -> L50 Throwable -> L57
    L51:
        if (r13 == null) goto L53;
        r2.put("hot_update_type", r13.intValue());     // Catch: Throwable -> L57
    L53:
        if (r14 == null) goto L55;
        r2.put("gid", r14.longValue());     // Catch: Throwable -> L57
    L55:
        Object r18 = Result.constructor-impl(r2.toString());     // Catch: Throwable -> L57
    L60:
        if (Result.isFailure-impl(r18) == true) goto L64;
        r1 = r18;
    L64:
        return (String) r1;
    L31:
        if (r10.size() > 0) goto L34;
        r3 = false;
    L34:
        if (r3 == true) goto L37;
        r10 = null;
    L37:
        if (r10 == null) goto L39;
        r2.put("hide_bucket_gids", new JSONArray(r10));     // Catch: Throwable -> L57
        goto L39
    L21:
        if (r9.longValue() <= 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == true) goto L27;
        r9 = null;
    L27:
        if (r9 == null) goto L29;
        r2.put("livehead_video_gid", r9.longValue());     // Catch: Throwable -> L57
        goto L29
    L23:
        r4 = false;
    L57:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L60
    }
}
