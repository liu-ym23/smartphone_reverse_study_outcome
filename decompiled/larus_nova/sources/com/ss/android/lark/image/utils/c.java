package com.ss.android.lark.image.utils;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f426450a = 0;

    static {
    }

    public static void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "inlineInfo");
        Log.i("ImageMonitor", "reportInlineEvent, inlineInfo=" + r100);
        r100.getClass();
        JSONObject r101 = new JSONObject();
        r101.put("resultCode", r100.f426451a);
        r101.put("errorMsg", r100.f426452b);
        r101.put("latency", r100.f426453c);
        r101.put("size", r100.f426454d);
        r101.put("width", r100.f426455e);
        r101.put("height", r100.f426456f);
        Statistics.sendEvent("inline_preview_decode_dev", r101);
    }
}
