package com.ss.ttm.player;

import android.util.Pair;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes40.dex */
public final class MediaCodecUtil {
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL = null;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE = null;
    private static final Pattern PROFILE_PATTERN = null;
    private static final String TAG = "MediaCodecUtil";

    public MediaCodecUtil() {
    }

    static {
        PROFILE_PATTERN = PatternProtector.compile("^\\D?(\\d+)$");
        HashMap r100 = new HashMap();
        DOLBY_VISION_STRING_TO_LEVEL = r100;
        r100.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1);
        r100.put("02", 2);
        r100.put("03", 4);
        r100.put("04", 8);
        r100.put("05", 16);
        r100.put("06", 32);
        r100.put("07", 64);
        r100.put("08", 128);
        r100.put("09", 256);
        HashMap r101 = new HashMap();
        DOLBY_VISION_STRING_TO_PROFILE = r101;
        r101.put(CustomAlbumViewModel.DEFAULT_TAB_ID, 1);
        r101.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 2);
        r101.put("02", 4);
        r101.put("03", 8);
        r101.put("04", 16);
        r101.put("05", 32);
        r101.put("06", 64);
        r101.put("07", 128);
        r101.put("08", 256);
        r101.put("09", 512);
    }

    public static String getDolbyCodecs(int r100, int r101) {
        if (r100 != 4) goto L5;
    L17:
        String r102 = "dvhe";
    L19:
        return r102 + ".0" + r100 + ".0" + r101;
    L5:
        if (r100 == 5) goto L17;
        if (r100 == 7) goto L17;
        if (r100 != 8) goto L13;
        r102 = "hev1";
        goto L19
    L13:
        if (r100 != 9) goto L15;
        r102 = "avc3";
        goto L19
    L15:
        return null;
    }

    public static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String r100, String[] r101) {
        if (r101 == null) goto L25;
        if (r101.length < 3) goto L25;
        Matcher r102 = PROFILE_PATTERN.matcher(r101[1]);     // Catch: Exception -> L21
        if (r102.matches() == false) goto L10;
        String r103 = r102.group(1);     // Catch: Exception -> L21
        Integer r104 = DOLBY_VISION_STRING_TO_PROFILE.get(r103);     // Catch: Exception -> L21
        if (r104 == null) goto L14;
        String r105 = r101[2];     // Catch: Exception -> L21
        Integer r106 = DOLBY_VISION_STRING_TO_LEVEL.get(r105);     // Catch: Exception -> L21
        if (r106 != null) goto L20;
        return null;
    L20:
        return new Pair(r104, r106);
    L14:
        return null;
    L10:
        return null;
    L21:
        e = move-exception;
        e.printStackTrace();
        return null;
    L25:
        return null;
    }
}
