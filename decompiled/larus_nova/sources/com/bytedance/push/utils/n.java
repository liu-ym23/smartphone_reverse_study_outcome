package com.bytedance.push.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class n {
    public static Map<String, String> a(Context r110) {
        HashMap r100 = new HashMap();
        DisplayMetrics r101 = new DisplayMetrics();
        WindowManager r102 = (WindowManager) r110.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r102 == null) goto L5;
        r102.getDefaultDisplay().getMetrics(r101);
    L5:
        r100.put("density", String.valueOf(r101.density));
        r100.put("screen_dpi", String.valueOf(r101.densityDpi));
        r100.put("window_w", String.valueOf(r101.widthPixels));
        r100.put("window_h", String.valueOf(r101.heightPixels));
        r100.put("scaled_density", String.valueOf(r101.scaledDensity));
        Object r103 = b.d(m.a("android.app.WindowConfiguration"), "getBounds", new Class[0]).invoke(b.c(m.a("android.content.res.Configuration"), "windowConfiguration").get(r110.getResources().getConfiguration()), new Object[0]);     // Catch: Throwable -> L10
        if ((r103 instanceof Rect) == false) goto L12;
        Rect r104 = (Rect) r103;     // Catch: Throwable -> L10
    L14:
        if (r104 == null) goto L16;
        r100.put("real_window_w", String.valueOf(r104.right - r104.left));
        r100.put("real_window_h", String.valueOf(r104.bottom - r104.top));
    L17:
        int r105 = r110.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r105 <= 0) goto L20;
        int r106 = r110.getResources().getDimensionPixelSize(r105);
    L21:
        r100.put("status_bar_height_px", String.valueOf(r106));
        r100.put("rom_version", j.f267081c);
        float r107 = -1.0f;
        r100.put("sys_permission_enable", j.e("persist.sys.permission.enable"));     // Catch: Throwable -> L36
        Resources r108 = r110.createPackageContext("com.android.settings", 2).getResources();     // Catch: Throwable -> L36
        r100.put("font_scale", String.valueOf(r108.getConfiguration().fontScale));     // Catch: Throwable -> L36
        r100.put("sys_font_size", String.valueOf(r108.getConfiguration().fontScale * r101.scaledDensity));     // Catch: Throwable -> L36
        Paint r111 = new Paint();     // Catch: Throwable -> L36
        Paint.FontMetrics r112 = r111.getFontMetrics();     // Catch: Throwable -> L36
        r111.getTextBounds("抖", 0, 1, new Rect());     // Catch: Throwable -> L36
        r100.put("font_height", String.valueOf((int) (r112.bottom - r112.top)));     // Catch: Throwable -> L36
        r100.put("sys_font_size_by_new_obj", String.valueOf(new TextView(r110).getTextSize()));     // Catch: Throwable -> L36
        float r109 = r108.getDimension(r108.getIdentifier("miuix_appcompat_title_text_size", "dimen", "com.android.settings"));     // Catch: Throwable -> L25
    L26:
        r100.put("action_bar_title_size", String.valueOf(r109));     // Catch: Throwable -> L36
        float r113 = r108.getDimension(r108.getIdentifier("miuix_appcompat_action_bar_default_height", "dimen", "com.android.settings"));     // Catch: Throwable -> L29
    L30:
        r100.put("action_bar_height", String.valueOf(r113));     // Catch: Throwable -> L36
        if (ToolUtils.getTargetApplicationInfo(r110, "com.android.cts.verifier") == null) goto L33;
        String r114 = "true";
    L34:
        r100.put("is_install_cts", r114);     // Catch: Throwable -> L36
    L50:
        Resources r115 = r110.createPackageContext("android", 2).getResources();     // Catch: Throwable -> L42
        r107 = r115.getDimension(r115.getIdentifier("text_size_title_material_toolbar", "dimen", "android"));     // Catch: Throwable -> L45
    L40:
        r100.put("tool_bar_title_size", String.valueOf(r107));     // Catch: Throwable -> L42
    L44:
        return r100;
    L42:
        th = move-exception;
        f.e("UiAdaptationUtils", "exception when build androidContext:" + th.getLocalizedMessage());
        goto L44
    L33:
        r114 = "false";
    L29:
        r113 = -1.0f;
    L25:
        r109 = -1.0f;
    L36:
        th = move-exception;
        f.e("UiAdaptationUtils", "exception when build androidSettingsContext:" + th.getLocalizedMessage());
        goto L50
    L20:
        r106 = 0;
        goto L21
    L16:
        r100.put("real_window_w", String.valueOf(-1));
        r100.put("real_window_h", String.valueOf(-1));
    L12:
        r104 = null;
    L10:
        th = move-exception;
        f.e("SystemUtils", "[getRealRect]:" + th.getLocalizedMessage());
        goto L12
    }
}
