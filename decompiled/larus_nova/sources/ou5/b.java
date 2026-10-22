package ou5;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.dtf.face.api.IDTFacade;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f526742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f526743b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f526744c = false;

    static {
        f526742a = new HashMap();
        f526743b = new HashMap();
        boolean r100 = false;
    L8:
        th = move-exception;
        tt5.a.l("LanguageUtil", "isDolaHost failed", th);
    L10:
        f526744c = r100;
        Map<String, String> r101 = f526742a;
        r101.put(Locale.ENGLISH.getLanguage(), "en-US");
        r101.put(Locale.JAPANESE.getLanguage(), "ja-JP");
        r101.put(Locale.CHINA.getLanguage(), "zh-CN");
        r101.put("hi", "hi-IN");
        r101.put("ru", "ru-RU");
        r101.put(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_KO, "ko-KR");
        r101.put("th", "th-TH");
        r101.put("vi", "vi-VN");
        r101.put("id", "id-ID");
        r101.put("in", "id-ID");
        r101.put(GXTemplateKey.GAIAX_PT, "pt-BR");
        r101.put("fr", "fr-FR");
        r101.put("de", "de-DE");
        r101.put("it", "it-IT");
        r101.put("es", "es-ES");
        r101.put("hk", IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK);
        r101.put("tw", IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW);
        r101.put("cn", "zh-CN");
        r101.put("ms", "ms-MY");
        f526743b.put("in", "id");
        if (r100 == false) goto L13;
        r101.put(RTLUtil.ARABIA_LANG, "ar-AR");
        r101.put("en-GB", "en-GB");
        r101.put("es-419", "es-419");
        r101.put("fil", "fil-PH");
        r101.put("tr", "tr-TR");
        r101.put("uz", "uz-UZ");
        return;
    L13:
        r101.remove(RTLUtil.ARABIA_LANG);
        r101.remove("en-GB");
        r101.remove("es-419");
        r101.remove("fil");
        r101.remove("tr");
        r101.remove("uz");
        return;
    L4:
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L10;
        if (LarkAppContext.inst().buildConfig().isUsPackage() == false) goto L10;
        r100 = true;
        goto L10
    }

    public static String a(String r100, String r101) {
        boolean r102 = f526744c;
        if (TextUtils.isEmpty(r101) == false) goto L6;
        tt5.a.d("LanguageUtil", "convertLan(): lan is Null");
        return "";
    L6:
        if (r101.equals("zh") == false) goto L9;
        if (r100 == null) goto L9;
        r101 = r100.toLowerCase();
    L11:
        HashMap r103 = (HashMap) f526742a;
        String r104 = (String) r103.get(r101);
        if (TextUtils.isEmpty(r104) == false) goto L14;
        String r105 = (String) r103.get(Locale.ENGLISH.getLanguage());
    L15:
        tt5.a.h("LanguageUtil", "convertLan(): origin = " + r101 + ",result = " + r105);
        return r105;
    L14:
        r105 = r104;
    L9:
        if (r102 == false) goto L11;
        r101 = b(r100, r101);
        goto L11
    }

    public static String b(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        String r102 = r101 + "-" + r100.toUpperCase(Locale.ROOT);
        if (((HashMap) f526742a).containsKey(r102) == true) goto L8;
        return r101;
    L8:
        return r102;
    }

    public static CharSequence c(String r100, String r101) {
        boolean r102 = f526744c;
        HashMap r103 = (HashMap) f526743b;
        if (r103.containsKey(r101) == false) goto L6;
        r101 = (String) r103.get(r101);
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        tt5.a.k("LanguageUtil", "provideLanguage is empty.");
        return "";
    L9:
        if (r101.equals("zh") == true) goto L11;
    L13:
        if (r102 == false) goto L15;
        r101 = b(r100, r101);
    L15:
        tt5.a.h("LanguageUtil", "language is " + r101);
        return r101;
    L11:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        r101 = r101 + "-" + r100;
        goto L15
    }
}
