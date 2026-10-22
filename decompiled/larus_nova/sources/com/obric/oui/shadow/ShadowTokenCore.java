package com.obric.oui.shadow;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.s;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVLogger;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class ShadowTokenCore {
    public static final b[] Oui_Shadow_Regular = null;
    static final b[] Oui_Shadow_Regular_V1 = null;
    static final b[] Oui_Shadow_Regular_V2 = null;
    public static final b[] Oui_Shadow_Text_Regular = null;
    public static final b[] Oui_Shadow_Thick = null;
    static final b[] Oui_Shadow_Thick_V1 = null;
    static final b[] Oui_Shadow_Thick_V2 = null;
    public static final b[] Oui_Shadow_Thin = null;
    public static final b[] Oui_Shadow_UltraThick = null;
    public static final b[] Shadow_1 = null;
    public static final b[] Shadow_2 = null;
    public static final b[] Shadow_3 = null;
    public static final b[] Shadow_Text = null;
    public static final b[] Shadow_Thick = null;
    private static final ConcurrentHashMap<String, b[]> tokens = null;

    static {
        Oui_Shadow_Thin = new b[]{new b(0.0f, 2.0f, 10.0f, MediaPlayer.MEDIA_INFO_SOCKET_CONNECTRED, 0.0f, -1)};
        b[] r100 = {new b(0.0f, 8.0f, 20.0f, 335544320, 0.0f, -1), new b(0.0f, 2.0f, 10.0f, AMapEngineUtils.HALF_MAX_P20_WIDTH, 0.0f, -1)};
        Oui_Shadow_Regular_V2 = r100;
        b[] r101 = {new b(0.0f, 6.0f, 20.0f, 218103808, 0.0f, -1), new b(0.0f, 2.0f, 10.0f, AVLogger.LEVEL_LOG_FATAL, 0.0f, -1)};
        Oui_Shadow_Regular_V1 = r101;
        if (OMaterialHelper.f() >= 4) goto L6;
        r100 = r101;
    L6:
        Oui_Shadow_Regular = r100;
        b[] r102 = {new b(0.0f, 12.0f, 24.0f, 603979776, 0.0f, -1)};
        Oui_Shadow_Thick_V2 = r102;
        b[] r103 = {new b(0.0f, 12.0f, 24.0f, 520093696, 0.0f, -1)};
        Oui_Shadow_Thick_V1 = r103;
        if (OMaterialHelper.f() >= 4) goto L10;
        r102 = r103;
    L10:
        Oui_Shadow_Thick = r102;
        Oui_Shadow_UltraThick = new b[]{new b(0.0f, 16.0f, 60.0f, 687865856, 0.0f, -1)};
        Oui_Shadow_Text_Regular = new b[]{new b(0.0f, 1.0f, 2.5f, 167772160, 0.0f, -1), new b(0.0f, 0.0f, 1.0f, 167772160, 0.0f, -1)};
        Shadow_1 = new b[]{new b(0.0f, 2.0f, 10.0f, MediaPlayer.MEDIA_INFO_SOCKET_CONNECTRED, 0.0f, -1)};
        Shadow_2 = new b[]{new b(0.0f, 6.0f, 20.0f, 218103808, 0.0f, -1), new b(0.0f, 2.0f, 10.0f, AVLogger.LEVEL_LOG_FATAL, 0.0f, -1)};
        Shadow_3 = new b[]{new b(0.0f, 12.0f, 24.0f, 520093696, 0.0f, -1)};
        Shadow_Thick = new b[]{new b(0.0f, 16.0f, 60.0f, 687865856, 0.0f, -1)};
        Shadow_Text = new b[]{new b(0.0f, 1.0f, 2.5f, 167772160, 0.0f, -1), new b(0.0f, 0.0f, 1.0f, 167772160, 0.0f, -1)};
        tokens = s.a(ShadowTokenCore.class, b[].class);
    }

    private ShadowTokenCore() {
    }

    public static b[] parse(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return (b[]) s.c(r100, tokens);
    }
}
