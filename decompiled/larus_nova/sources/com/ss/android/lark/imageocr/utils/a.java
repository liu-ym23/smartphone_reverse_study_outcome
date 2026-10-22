package com.ss.android.lark.imageocr.utils;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f426573a = 0;

    static {
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "click");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Statistics.sendEvent("public_identity_select_accurate_character_click", new JSONObject().put("click", r100).put(PickerReporterConstants.KEY.TARGET, r101));
    }

    public static void a(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "click");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Statistics.sendEvent("public_identity_select_content_click", new JSONObject().put("click", r100).put("has_select_content", r101).put(PickerReporterConstants.KEY.TARGET, r102));
    }
}
