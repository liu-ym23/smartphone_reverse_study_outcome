package com.bytedance.gamecenter.base.order;

import android.content.SharedPreferences;
import com.bytedance.gamecenter.base.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f245040a = 0;

    static {
    }

    public static List a(String r100) {
        if (r100 == null) goto L5;
        List r101 = StringsKt.split$default(r100, new String[]{"_"}, false, 0, 6, null);
        if (r101 == null) goto L5;
    L6:
        r101.toString();
        boolean r102 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameRecordSpUtils", "tag");
        if (r101.size() != 3) goto L9;
        return r101;
    L9:
        return null;
    L5:
        r101 = new ArrayList();
        goto L6
    }

    public static void b(JSONObject r100, boolean r101) {
        SharedPreferences r102 = h.a().getSharedPreferences("sp_game_res_click_start", 0);
        if (r100 == null) goto L5;
        String r103 = r100.optString("md5");
    L6:
        if (r103 == null) goto L9;
        r102.edit().putBoolean(r103, r101).apply();
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static void c(JSONObject r100, boolean r101) {
        SharedPreferences r102 = h.a().getSharedPreferences("sp_game_res_download_failed_flag", 0);
        if (r100 == null) goto L5;
        String r103 = r100.optString("md5");
    L6:
        if (r103 == null) goto L9;
        r102.edit().putBoolean(r103, r101).apply();
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static void d(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "downloadInfo");
        h.a().getSharedPreferences("sp_game_res_download_info", 0).edit().putString(r100, r101.toString()).apply();
    }
}
