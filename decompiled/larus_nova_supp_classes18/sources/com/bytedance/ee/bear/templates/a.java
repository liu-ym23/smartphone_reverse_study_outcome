package com.bytedance.ee.bear.templates;

import com.ss.android.lark.appsetting.api.SettingManager;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String a() {
        String r0 = SettingManager.getInstance().getString(NewLarkFormBlankTemplate.class);
        Intrinsics.checkNotNull(r0);
        if (StringsKt.isBlank(r0) == false) goto L15;
        return "";
    L15:
        JSONObject r1 = new JSONObject(r0).optJSONObject("surveyTemplate");     // Catch: Exception -> L12
        if (r1 == null) goto L17;
        String r2 = r1.optString("i18nId");     // Catch: Exception -> L12
        if (r2 != null) goto L11;
        return "";
    L11:
        return r2;
    L17:
        return "";
    L12:
        e = move-exception;
        tt5.a.d("NewLarkFormTemplate", "getTemplateToken " + e.getMessage());
        return "";
    }

    public static String b() {
        String r0 = SettingManager.getInstance().getString(NewLarkFormBlankTemplate.class);
        Intrinsics.checkNotNull(r0);
        if (StringsKt.isBlank(r0) == false) goto L21;
        return "";
    L21:
        JSONObject r1 = new JSONObject(r0).optJSONObject("surveyTemplate");     // Catch: Exception -> L18
        yob.e.a().getClass();     // Catch: Exception -> L18
        Locale r2 = com.ss.android.lark.language.service.impl.c.a.a.a();     // Catch: Exception -> L18
        if (r1 == null) goto L9;
        JSONObject r3 = r1.optJSONObject(r2.getLanguage().toLowerCase(Locale.ROOT));     // Catch: Exception -> L18
        if (r3 == null) goto L9;
    L12:
        if (r3 == null) goto L23;
        String r4 = r3.optString("objToken");     // Catch: Exception -> L18
        if (r4 != null) goto L17;
        return "";
    L17:
        return r4;
    L23:
        return "";
    L9:
        if (r1 == null) goto L11;
        r3 = r1.optJSONObject("fallback");     // Catch: Exception -> L18
        goto L12
    L11:
        r3 = null;
    L18:
        e = move-exception;
        tt5.a.d("NewLarkFormTemplate", "getTemplateToken " + e.getMessage());
        return "";
    }
}
