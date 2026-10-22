package com.bytedance.ee.docsdk.impl.utils;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.dtf.face.api.IDTFacade;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public class LanguageUtil {
    private static final Map<String, String> LANGUAGE_MAP = null;
    private static final Map<String, String> LANGUAGE_TRANSFORM = null;
    private static final String TAG = "LanguageUtil";

    public LanguageUtil() {
    }

    static {
        HashMap r100 = new HashMap();
        LANGUAGE_MAP = r100;
        HashMap r101 = new HashMap();
        LANGUAGE_TRANSFORM = r101;
        r100.put(Locale.ENGLISH.getLanguage(), "en-US");
        r100.put(Locale.JAPANESE.getLanguage(), "ja-JP");
        r100.put(Locale.CHINA.getLanguage(), "zh-CN");
        r100.put("hi", "hi-IN");
        r100.put("ru", "ru-RU");
        r100.put(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_KO, "ko-KR");
        r100.put("th", "th-TH");
        r100.put("vi", "vi-VN");
        r100.put("id", "id-ID");
        r100.put("in", "id-ID");
        r100.put(GXTemplateKey.GAIAX_PT, "pt-BR");
        r100.put("fr", "fr-FR");
        r100.put("de", "de-DE");
        r100.put("it", "it-IT");
        r100.put("es", "es-ES");
        r100.put("hk", IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK);
        r100.put("tw", IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW);
        r100.put("cn", "zh-CN");
        r100.put("ms", "ms-MY");
        r101.put("in", "id");
    }

    public static String convertLan(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        Log.e(TAG, "convertLan(): lan is Null");
        return "";
    L7:
        if (r101.equals("zh") == false) goto L10;
        if (r100 == null) goto L10;
        r101 = r100.toLowerCase();
    L10:
        Map<String, String> r102 = LANGUAGE_MAP;
        String r103 = r102.get(r101);
        if (TextUtils.isEmpty(r103) == false) goto L13;
        r103 = r102.get(Locale.ENGLISH.getLanguage());
    L13:
        Log r104 = Log.INSTANCE;
        Log.i(TAG, "convertLan(): origin = " + r101 + ",result = " + r103);
        return r103;
    }

    public static CharSequence getLanguage(String r100, String r101) {
        Map<String, String> r102 = LANGUAGE_TRANSFORM;
        if (r102.containsKey(r101) == false) goto L6;
        r101 = r102.get(r101);
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        Log.w(TAG, "provideLanguage is empty.");
        return "";
    L10:
        if (r101.equals("zh") == true) goto L12;
    L14:
        Log r103 = Log.INSTANCE;
        Log.i(TAG, "language is " + r101);
        return r101;
    L12:
        if (TextUtils.isEmpty(r100) == true) goto L14;
        r101 = r101 + "-" + r100;
        goto L14
    }
}
