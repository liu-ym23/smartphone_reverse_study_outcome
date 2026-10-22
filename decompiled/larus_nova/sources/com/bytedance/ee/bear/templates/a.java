package com.bytedance.ee.bear.templates;

import com.ss.android.lark.appsetting.api.SettingManager;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String a() {
        String r100 = SettingManager.getInstance().getString(NewLarkFormBlankTemplate.class);
        Intrinsics.checkNotNull(r100);
        if (StringsKt.isBlank(r100) == false) goto L15;
        return "";
    L15:
        JSONObject r101 = new JSONObject(r100).optJSONObject("surveyTemplate");     // Catch: Exception -> L12
        if (r101 == null) goto L17;
        String r102 = r101.optString("i18nId");     // Catch: Exception -> L12
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L17:
        return "";
    L12:
        e = move-exception;
        tt5.a.d("NewLarkFormTemplate", "getTemplateToken " + e.getMessage());
        return "";
    }

    public static String b() {
        String r100 = SettingManager.getInstance().getString(NewLarkFormBlankTemplate.class);
        Intrinsics.checkNotNull(r100);
        if (StringsKt.isBlank(r100) == false) goto L21;
        return "";
    L21:
        JSONObject r101 = new JSONObject(r100).optJSONObject("surveyTemplate");     // Catch: Exception -> L18
        yob.e.a().getClass();     // Catch: Exception -> L18
        Locale r102 = com.ss.android.lark.language.service.impl.c.a.f431101a.a();     // Catch: Exception -> L18
        if (r101 == null) goto L9;
        JSONObject r103 = r101.optJSONObject(r102.getLanguage().toLowerCase(Locale.ROOT));     // Catch: Exception -> L18
        if (r103 == null) goto L9;
    L12:
        if (r103 == null) goto L23;
        String r104 = r103.optString("objToken");     // Catch: Exception -> L18
        if (r104 != null) goto L17;
        return "";
    L17:
        return r104;
    L23:
        return "";
    L9:
        if (r101 == null) goto L11;
        r103 = r101.optJSONObject("fallback");     // Catch: Exception -> L18
        goto L12
    L11:
        r103 = null;
    L18:
        e = move-exception;
        tt5.a.d("NewLarkFormTemplate", "getTemplateToken " + e.getMessage());
        return "";
    }
}
