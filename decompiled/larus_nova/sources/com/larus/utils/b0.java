package com.larus.utils;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.dtf.face.api.IDTFacade;
import com.larus.platform.api.f2;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f375362a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f375363b = null;

    static {
        AppLocaleUtils.f375332a.getClass();
        f375362a = AppLocaleUtils.c().getLanguage();
        f375363b = SetsKt.setOf(new String[]{RTLUtil.ARABIA_LANG, "de", "en", "en-GB", "es", "es-ES", "fil", "fr", "id", "it", IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_JA, IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_KO, "ms-MY", GXTemplateKey.GAIAX_PT, "ru", "th-TH", "tr", "uz", "vi", "zh", "zh-Hant"});
    }

    public static String d() {
        if (f2.f365106a.h() == false) goto L7;
        return "zh";
    L7:
        return b(a(f375362a.toLowerCase(Locale.ROOT)));
    }

    public static String a(String r100) {
        String r101 = r100.toLowerCase(Locale.ROOT);
        int r102 = r101.hashCode();
        if (r102 == 3365) goto L18;
        if (r102 == 3374) goto L14;
        if (r102 == 3391) goto L10;
        return r101;
    L10:
        if (r101.equals("ji") == false) goto L25;
        return "yi";
    L25:
        return r101;
    L14:
        if (r101.equals("iw") == false) goto L26;
        return "he";
    L26:
        return r101;
    L18:
        if (r101.equals("in") == false) goto L27;
        return "id";
    L27:
        return r101;
    }

    public static String b(String r100) {
        if (Intrinsics.areEqual(r100, "th") == false) goto L6;
        return "th-TH";
    L6:
        if (Intrinsics.areEqual(r100, "ms") == false) goto L8;
        return "ms-MY";
    L8:
        boolean r101 = false;
        if (f2.f365106a.h() == true) goto L32;
        Locale r102 = Locale.getDefault();
        String r103 = r102.getLanguage();
        String r104 = r102.getScript();
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        String r105 = r102.getCountry();
        if (r104.length() != 0) goto L17;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L28;
        if (r103.equals("zh") == false) goto L32;
        if (r105.equals("TW") == false) goto L25;
    L31:
        r101 = true;
        goto L32
    L25:
        if (r105.equals("HK") == false) goto L32;
    L28:
        if (r103.equals("zh") == false) goto L32;
        if (r104.equals("Hant") == false) goto L32;
    L17:
        r106 = false;
    L32:
        if (r101 == false) goto L37;
        return "zh-Hant";
    L37:
        return r100;
    }

    public static String c(Locale r100) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        String r101 = a(r100.getLanguage());
        String r102 = r100.getCountry().toUpperCase(Locale.ROOT);
        String r103 = r100.getScript();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        int r104 = r101.hashCode();
        if (r104 == 3241) goto L52;
        if (r104 == 3246) goto L45;
        if (r104 == 3494) goto L41;
        if (r104 == 3700) goto L37;
        if (r104 == 3704) goto L33;
        if (r104 != 3886) goto L54;
        if (r101.equals("zh") == false) goto L54;
        if (Intrinsics.areEqual(r103, "Hant") == false) goto L24;
    L31:
        return "zh-Hant";
    L24:
        if (Intrinsics.areEqual(r102, "TW") == true) goto L31;
        if (Intrinsics.areEqual(r102, "HK") == true) goto L31;
        if (Intrinsics.areEqual(r102, "MO") == true) goto L31;
        return "zh";
    L54:
        if (f375363b.contains(r101) == false) goto L60;
        return r101;
    L60:
        return "en";
    L33:
        if (r101.equals("tl") == false) goto L54;
        return "fil";
    L37:
        if (r101.equals("th") == false) goto L54;
        return "th-TH";
    L41:
        if (r101.equals("ms") == false) goto L54;
        return "ms-MY";
    L45:
        if (r101.equals("es") == false) goto L54;
        if (Intrinsics.areEqual(r102, "ES") == false) goto L67;
        return "es-ES";
    L67:
        return "es";
    L52:
        if (r101.equals("en") == false) goto L54;
        if (Intrinsics.areEqual(r102, "GB") == false) goto L60;
        return "en-GB";
    }

    public static String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "language");
        if (f2.f365106a.h() == false) goto L7;
        return "zh";
    L7:
        return b(a(r100));
    }

    public static String f(Locale r100) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        String r101 = a(r100.getLanguage());
        String r102 = r100.toLanguageTag();
        Intrinsics.checkNotNull(r102);
        int r103 = StringsKt.indexOf$default(r102, '-', 0, false, 6, null);
        if (r103 >= 0) goto L5;
        return r101;
    L5:
        return r101 + r102.substring(r103);
    }
}
