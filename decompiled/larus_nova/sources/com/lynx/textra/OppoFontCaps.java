package com.lynx.textra;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import androidx.core.provider.FontsContractCompat;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import f06.b;
import f06.c;
import f06.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes32.dex */
class OppoFontCaps implements PlatformFontCaps {
    private static int FONT_VARIATION_STEP = 10;
    private final Map<Integer, Integer> FONT_WEIGHT_CAST_WGHT;
    private final Context mContext;

    @Override // com.lynx.textra.PlatformFontCaps
    public final /* synthetic */ short clamp(int r100) {
        return PlatformFontCaps.CC.$default$clamp(this, r100);
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public String defaultFamilyName() {
        String r100 = com_lynx_textra_OppoFontCaps_android_provider_Settings$System_getString(this.mContext.getContentResolver(), "current_typeface_name");
        if (Objects.equals(r100, "OPPO Sans") == false) goto L7;
        return "sys-sans-en";
    L7:
        if (Objects.equals(r100, "One Sans") == false) goto L10;
        return "op-sans-en";
    L10:
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    }

    public OppoFontCaps(Context r110) {
        this.mContext = r110;
        LinkedHashMap r111 = new LinkedHashMap();
        this.FONT_WEIGHT_CAST_WGHT = r111;
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 35) goto L6;
        r111.put(100, 100);
        r111.put(200, 200);
        r111.put(300, 300);
        r111.put(400, 400);
        r111.put(500, 500);
        r111.put(600, 600);
        r111.put(700, 700);
        r111.put(800, 800);
        r111.put(900, 900);
        r111.put(1000, 1000);
        return;
    L6:
        if (r100 < 34) goto L8;
        r111.put(100, 100);
        r111.put(200, 200);
        r111.put(300, 300);
        r111.put(400, 550);
        r111.put(500, 700);
        r111.put(600, 900);
        r111.put(700, 1000);
        r111.put(800, 1000);
        r111.put(900, 1000);
        r111.put(1000, 1000);
        return;
    L8:
        r111.put(100, 200);
        r111.put(200, 250);
        r111.put(300, Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG));
        r111.put(400, 550);
        r111.put(500, 700);
        r111.put(600, 700);
        r111.put(700, 700);
        r111.put(800, 850);
        r111.put(900, 1000);
        r111.put(1000, 1000);
    }

    private int ToUserWeight(int r100) {
        Iterator<Map.Entry<Integer, Integer>> r101 = this.FONT_WEIGHT_CAST_WGHT.entrySet().iterator();
        Integer r102 = null;
        Integer r103 = null;
    L4:
        if (r101.hasNext() == false) goto L21;
        Map.Entry<Integer, Integer> r104 = r101.next();
        int r105 = r104.getValue().intValue();
        if (r100 == r105) goto L8;
        if (r103 != null) goto L13;
        if (r100 >= r105) goto L13;
        return r104.getKey().intValue();
    L13:
        if (r103 == null) goto L19;
        if (r100 <= r103.intValue()) goto L19;
        if (r100 >= r105) goto L19;
        return r102.intValue() + ((int) ((((r100 - r103.intValue()) * 1.0f) / (r105 - r103.intValue())) * (r104.getKey().intValue() - r102.intValue())));
    L19:
        r103 = Integer.valueOf(r105);
        r102 = r104.getKey();
        goto L4
    L8:
        return r104.getKey().intValue();
    L21:
        return r102.intValue();
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public short adjust(short r100) {
        int r101 = Settings.System.getInt(this.mContext.getContentResolver(), FontsContractCompat.Columns.VARIATION_SETTINGS, 550);
        if (((61440 & r101) >> 12) != 1) goto L10;
        int r102 = r101 & UnixStat.PERM_MASK;
        int r103 = FONT_VARIATION_STEP;
        int r104 = (r102 / r103) * r103;
        Integer r105 = this.FONT_WEIGHT_CAST_WGHT.get(Integer.valueOf(r100));
        int r106 = r100;
        if (r105 == null) goto L9;
        r106 = r105.intValue();
    L9:
        return (short) ToUserWeight(clamp(r104 + (r106 - 550)));
    L10:
        return r100;
    }

    private static String com_lynx_textra_OppoFontCaps_android_provider_Settings$System_getString(ContentResolver r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r110, r111};
        b r112 = new b();
        d r113 = r100.b(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.System.getString(r110, r111);
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, r114, r112, true);
        return r114;
    }
}
