package com.ss.ttvideoengine.log;

import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.alibaba.fastjson.parser.JSONLexer;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class LoggerUtils {
    public static final String KEY_BASE_AUDIO_LENGTH = "bal";
    public static final String KEY_BASE_VIDEO_LENGTH = "bvl";
    public static final String KEY_DECODER_AUDIO_LENGTH = "dal";
    public static final String KEY_DECODER_VIDEO_LENGTH = "dvl";
    public static final String KEY_FORMAT_AUDIO_LENGTH = "fal";
    public static final String KEY_FORMAT_AUDIO_ONLY_LENGTH = "falim";
    public static final String KEY_FORMAT_VIDEO_LENGTH = "fvl";
    public static final String KEY_FORMAT_VIDEO_ONLY_LENGTH = "fvlim";
    public static final int PLAYER_BUFFER_STATE_SIZE = 6;
    private static final int[] caesar_key = null;

    static {
        caesar_key = new int[]{1, 5, -1, 6, -3};
    }

    public LoggerUtils() {
    }

    public static float encryptFloatV1(float r100) {
        if (r100 != Float.MIN_VALUE) goto L5;
        return r100;
    L5:
        if (r100 != Float.NaN) goto L8;
        return r100;
    L8:
        return -r100;
    }

    public static long encryptIntergerV1(long r100) {
        if (r100 != SieveCacheKt.NodeMetaAndPreviousMask) goto L5;
        return r100;
    L5:
        long r101 = r100 >>> 4;
        return (r100 << 60) | r101;
    }

    public static String encryptStringV1(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        String r101 = "";
        int r102 = 0;
    L7:
        if (r102 >= r100.length()) goto L37;
        char r103 = r100.charAt(r102);
        int r104 = caesar_key[r102 % 5];
        if (r103 < 'a') goto L19;
        if (r103 > 'z') goto L19;
        r103 = (char) (r103 + r104);
        if (r103 >= 'a') goto L15;
        r103 = (char) (r103 + JSONLexer.EOI);
    L15:
        if (r103 <= 'z') goto L36;
    L16:
        int r105 = r103 - 26;
    L17:
        r103 = (char) r105;
    L36:
        r101 = r101 + r103;
        r102 = r102 + 1;
    L19:
        if (r103 < 'A') goto L28;
        if (r103 > 'Z') goto L28;
        r103 = (char) (r103 + r104);
        if (r103 >= 'A') goto L25;
        r103 = (char) (r103 + JSONLexer.EOI);
    L25:
        if (r103 <= 'Z') goto L36;
    L28:
        if (r103 < '0') goto L36;
        if (r103 > '9') goto L36;
        r103 = (char) (r103 + r104);
        if (r103 >= '0') goto L34;
        r103 = (char) (r103 + '\n');
    L34:
        if (r103 <= '9') goto L36;
        r105 = r103 - '\n';
        goto L17
    L37:
        return r101;
    }

    public static Map<String, Long> parsePlayerBufferString(String r100) {
        HashMap r101 = new HashMap();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        String[] r102 = r100.split(";|:");
        if (r102 != null) goto L8;
    L18:
        return r101;
    L8:
        if (r102.length == 0) goto L18;
        int r103 = 0;
    L12:
        if (r103 >= (r102.length - 1)) goto L18;
        r101.put(r102[r103], Long.valueOf(CastLongProtector.parseLong(r102[r103 + 1])));     // Catch: Exception -> L15
    L17:
        r103 = r103 + 2;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static Map<String, Long> parsePlayerStringToMap(String r100, String r101) {
        HashMap r102 = new HashMap();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r102;
    L5:
        String[] r103 = r100.split(r101);
        if (r103 != null) goto L8;
    L18:
        return r102;
    L8:
        if (r103.length == 0) goto L18;
        int r104 = 0;
    L12:
        if (r104 >= (r103.length - 1)) goto L18;
        r102.put(r103[r104], Long.valueOf(CastLongProtector.parseLong(r103[r104 + 1])));     // Catch: Exception -> L15
    L17:
        r104 = r104 + 2;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static void putToMap(Map r100, String r101, float r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 != Float.MIN_VALUE) goto L7;
        return;
    L7:
        if (r102 == Float.NaN) goto L11;
        r100.put(r101, Float.valueOf(r102));
        return;
    }

    public static void putToMap(Map r100, String r101, long r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 == SieveCacheKt.NodeMetaAndPreviousMask) goto L8;
        r100.put(r101, Long.valueOf(r102));
        return;
    }

    public static void putToMap(Map r100, String r101, int r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102 == Integer.MIN_VALUE) goto L8;
        r100.put(r101, Integer.valueOf(r102));
        return;
    }

    public static void putToMap(Map r100, String r101, ArrayList r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.isEmpty() == true) goto L10;
        r100.put(r101, r102);
        return;
    }

    public static void putToMap(Map r100, String r101, Map r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.isEmpty() == true) goto L10;
        r100.put(r101, r102);
        return;
    }

    public static void putToMap(Map r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r100.put(r101, r102);
        return;
    }

    public static void putToMap(Map r100, String r101, JSONObject r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102 == null) goto L7;
        r100.put(r101, r102);
        return;
    }
}
