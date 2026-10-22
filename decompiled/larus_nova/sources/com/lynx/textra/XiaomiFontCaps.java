package com.lynx.textra;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
class XiaomiFontCaps implements PlatformFontCaps {
    public static int[] MIUI_WGHT = null;
    public static final int[][] NORAML_RULES = null;
    public static int[] WEIGHT_ARRAY = null;
    public static final int WEIGHT_IDX_BOLD = 8;
    public static final int WEIGHT_IDX_DEMI_BOLD = 6;
    public static final int WEIGHT_IDX_EXTRA_LIGHT = 1;
    public static final int WEIGHT_IDX_HEAVY = 9;
    public static final int WEIGHT_IDX_LIGHT = 2;
    public static final int WEIGHT_IDX_MEDIUM = 5;
    public static final int WEIGHT_IDX_NORMAL = 3;
    public static final int WEIGHT_IDX_REGULAR = 4;
    public static final int WEIGHT_IDX_SEMI_BOLD = 7;
    public static final int WEIGHT_IDX_THIN = 0;
    private final Context mContext;
    public int mFontScale;
    private Map<Integer, Integer> mUserToMIUI;

    @Override // com.lynx.textra.PlatformFontCaps
    public final /* synthetic */ short clamp(int r100) {
        return PlatformFontCaps.CC.$default$clamp(this, r100);
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public String defaultFamilyName() {
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    }

    static {
        NORAML_RULES = new int[][]{new int[]{0, 5}, new int[]{0, 5}, new int[]{1, 6}, new int[]{2, 6}, new int[]{2, 7}, new int[]{3, 8}, new int[]{4, 8}, new int[]{5, 9}, new int[]{6, 9}, new int[]{7, 9}};
        WEIGHT_ARRAY = new int[]{100, 200, 300, TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG, 400, 500, 700, 800, 900, 950};
        MIUI_WGHT = new int[]{150, 200, 250, 305, 330, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 450, 520, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME, 700};
    }

    public XiaomiFontCaps(Context r100) {
        this.mUserToMIUI = new LinkedHashMap();
        this.mFontScale = 50;
        this.mContext = r100;
        String r101 = Settings.Global.getString(r100.getContentResolver(), "key_miui_font_var_weight");
        int r102 = 0;
        if (r101 == null) goto L11;
        String[] r103 = r101.split(",");
        if (r103.length == MIUI_WGHT.length) goto L7;
        return;
    L7:
        int r104 = 0;
    L9:
        if (r104 >= r103.length) goto L11;
        MIUI_WGHT[r104] = CastIntegerProtector.parseInt(r103[r104]);
        r104 = r104 + 1;
    L11:
        int[] r105 = WEIGHT_ARRAY;
        if (r102 >= r105.length) goto L14;
        this.mUserToMIUI.put(Integer.valueOf(r105[r102]), Integer.valueOf(MIUI_WGHT[r102]));
        r102 = r102 + 1;
        goto L11
    L14:
        this.mFontScale = Settings.System.getInt(r100.getContentResolver(), "key_miui_font_weight_scale", 50);
    }

    private int ToUserWeight(int r100) {
        Iterator<Map.Entry<Integer, Integer>> r101 = this.mUserToMIUI.entrySet().iterator();
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
        return clamp(ToUserWeight(getWght(r100)));
    }

    public int getWeightIdx(int r100) {
        if (r100 < WEIGHT_ARRAY[9]) goto L5;
        return 9;
    L5:
        int r101 = 0;
    L6:
        int[] r102 = WEIGHT_ARRAY;
        if (r101 >= r102.length) goto L12;
        if (r100 <= r102[r101]) goto L10;
        r101 = r101 + 1;
        goto L6
    L10:
        return r101;
    L12:
        return 4;
    }

    public int getWght(int r100) {
        int r101 = getWeightIdx(r100);
        int[] r102 = MIUI_WGHT;
        int[] r103 = NORAML_RULES[r101];
        int r104 = r102[r103[0]];
        int r105 = r102[r101];
        int r106 = r102[r103[1]];
        int r107 = this.mFontScale;
        if (r107 >= 50) goto L5;
        float r108 = r107 / 50.0f;
        float r109 = ((1.0f - r108) * r104) + (r108 * r105);
    L7:
        return (int) r109;
    L5:
        float r110 = (r107 - 50.0f) / 50.0f;
        r109 = ((1.0f - r110) * r105) + (r110 * r106);
        goto L7
    }
}
