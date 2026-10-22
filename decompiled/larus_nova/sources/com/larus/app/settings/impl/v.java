package com.larus.app.settings.impl;

import android.content.Context;
import android.content.res.Resources;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class v {
    public static final int a(int r100, Context r101) {
        Resources r102 = r101.getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static final boolean c(List r100, int r101) {
        if (r100 == null) goto L28;
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        Object r103 = r102.next();
        com.larus.uaigc.api.v r104 = (com.larus.uaigc.api.v) r103;
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L6;
    L16:
        com.larus.uaigc.api.v r106 = (com.larus.uaigc.api.v) r103;
        if (r106 != null) goto L20;
        return false;
    L20:
        if (r106.b() != 1) goto L29;
        return true;
    L29:
        return false;
    L10:
        if (r104.a() != r101) goto L12;
        r105 = true;
        goto L13
    L15:
        r103 = null;
        goto L16
    L28:
        return false;
    }

    public static final String d(Context r100, boolean r101) {
        if (r101 == false) goto L8;
        int r102 = c0.f287014a;
        if (r100 == null) goto L12;
        String r103 = r100.getString(R.string.larus_AIwatermarking_popupwindow_pop_on_cn);
        if (r103 == null) goto L12;
        return r103;
    L12:
        return "";
    L8:
        int r104 = c0.f287014a;
        if (r100 == null) goto L12;
        String r105 = r100.getString(R.string.larus_AIwatermarking_popupwindow_pop_off_cn);
        if (r105 == null) goto L12;
        return r105;
    }

    public static final void b(String r100, String r101, String r102) {
        by7.a r103 = new by7.a("popup_click");
        if (Intrinsics.areEqual(r100, "document") == false) goto L5;
        String r104 = "ai_watermark_office_doc";
    L6:
        r103.d("popup_type", r104);
        r103.d("click_from", r101);
        r103.d("to_status", r102);
        r103.d("current_page", "ai_watermark_setting_page");
        r103.d("enter_method", "setting");
        r103.b();
        return;
    L5:
        r104 = "ai_watermark_image_video";
        goto L6
    }
}
