package com.ss.android.lark.message.card.utils;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.setting.MessageCardTimeFormatConfig;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class CardTimeFormatUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f431926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f431927b = null;

    static {
        f431926a = LazyKt.lazy(CardTimeFormatUtils$defaultFormat$2.INSTANCE);
        f431927b = LazyKt.lazy(CardTimeFormatUtils$messageCardTimeFormatConfig$2.INSTANCE);
    }

    public static MessageCardTimeFormatConfig b() {
        return (MessageCardTimeFormatConfig) f431927b.getValue();
    }

    public static String a(String r100, Locale r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "formatType");
        boolean r102 = true;
        String r103 = "";
        if (com.ss.android.lark.message.card.b.a().is12HourClock() == false) goto L74;
        if (r110 == false) goto L74;
        String r111 = r100 + "_12";
        MessageCardTimeFormatConfig r104 = b();     // Catch: JSONException -> L18
        if (r104 == null) goto L17;
        JSONObject r105 = r104.localeLanguageFormat;     // Catch: JSONException -> L18
        if (r105 == null) goto L17;
        if (r101 == null) goto L12;
        String r106 = r101.toLanguageTag();     // Catch: JSONException -> L18
    L13:
        JSONObject r107 = r105.optJSONObject(r106);     // Catch: JSONException -> L18
        if (r107 == null) goto L17;
        String r112 = JSONObjectProtectorUtils.getString(r107, r111);     // Catch: JSONException -> L18
    L20:
        if (r112 != null) goto L22;
    L25:
        boolean r108 = true;
    L26:
        if (r108 == true) goto L76;
        return r112;
    L76:
        MessageCardTimeFormatConfig r113 = b();     // Catch: JSONException -> L40
        if (r113 == null) goto L39;
        JSONObject r114 = r113.localeLanguageFormat;     // Catch: JSONException -> L40
        if (r114 == null) goto L39;
        if (r101 == null) goto L34;
        String r109 = r101.toLanguageTag();     // Catch: JSONException -> L40
    L35:
        JSONObject r115 = r114.optJSONObject(r109);     // Catch: JSONException -> L40
        if (r115 == null) goto L39;
        r103 = JSONObjectProtectorUtils.getString(r115, r100);     // Catch: JSONException -> L40
    L42:
        if (r103 != null) goto L44;
    L47:
        if (r102 == true) goto L71;
        return r103;
    L71:
        return (String) ((Map) f431926a.getValue()).get(r100);
    L44:
        if (r103.length() == 0) goto L47;
        r102 = false;
        goto L47
    L34:
        r109 = null;
    L39:
        r103 = null;
    L40:
        e = move-exception;
        Log.e("TimeFormatUtil", "getLocaleFormatTypeFormat is exception", e);
        goto L42
    L22:
        if (r112.length() == 0) goto L25;
        r108 = false;
        goto L26
    L12:
        r106 = null;
    L17:
        r112 = null;
    L18:
        e = move-exception;
        Log.e("TimeFormatUtil", "getLocaleFormatTypeFormat is exception", e);
        r112 = "";
    L74:
        MessageCardTimeFormatConfig r116 = b();     // Catch: JSONException -> L61
        if (r116 == null) goto L60;
        JSONObject r117 = r116.localeLanguageFormat;     // Catch: JSONException -> L61
        if (r117 == null) goto L60;
        if (r101 == null) goto L55;
        String r118 = r101.toLanguageTag();     // Catch: JSONException -> L61
    L56:
        JSONObject r119 = r117.optJSONObject(r118);     // Catch: JSONException -> L61
        if (r119 == null) goto L60;
        r103 = JSONObjectProtectorUtils.getString(r119, r100);     // Catch: JSONException -> L61
    L63:
        if (r103 != null) goto L65;
    L68:
        if (r102 == true) goto L71;
        return r103;
    L65:
        if (r103.length() == 0) goto L68;
        r102 = false;
        goto L68
    L55:
        r118 = null;
    L60:
        r103 = null;
    L61:
        e = move-exception;
        Log.e("TimeFormatUtil", "getLocaleFormatTypeFormat is exception", e);
        goto L63
    }

    public static String c(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "formatType");
        Intrinsics.checkNotNullParameter(r101, "translateLanguage");
        boolean r103 = true;
        String r104 = null;
        String r105 = "";
        if (com.ss.android.lark.message.card.b.a().is12HourClock() == false) goto L65;
        if (r102 == false) goto L65;
        String r106 = r100 + "_12";
        MessageCardTimeFormatConfig r107 = b();     // Catch: JSONException -> L15
        if (r107 == null) goto L14;
        JSONObject r108 = r107.translateFormat;     // Catch: JSONException -> L15
        if (r108 == null) goto L14;
        JSONObject r109 = r108.optJSONObject(r101);     // Catch: JSONException -> L15
        if (r109 == null) goto L14;
        String r110 = JSONObjectProtectorUtils.getString(r109, r106);     // Catch: JSONException -> L15
    L17:
        if (r110 != null) goto L19;
    L22:
        boolean r111 = true;
    L23:
        if (r111 == true) goto L61;
        return r110;
    L61:
        MessageCardTimeFormatConfig r112 = b();     // Catch: JSONException -> L33
        if (r112 == null) goto L32;
        JSONObject r113 = r112.translateFormat;     // Catch: JSONException -> L33
        if (r113 == null) goto L32;
        JSONObject r114 = r113.optJSONObject(r101);     // Catch: JSONException -> L33
        if (r114 == null) goto L32;
        r104 = JSONObjectProtectorUtils.getString(r114, r100);     // Catch: JSONException -> L33
    L32:
        r105 = r104;
    L35:
        if (r105 != null) goto L37;
    L40:
        if (r103 == true) goto L60;
        return r105;
    L60:
        return (String) ((Map) f431926a.getValue()).get(r100);
    L37:
        if (r105.length() == 0) goto L40;
        r103 = false;
    L33:
        e = move-exception;
        Log.e("TimeFormatUtil", "getTranslateFormatTypeFormat is exception", e);
        goto L35
    L19:
        if (r110.length() == 0) goto L22;
        r111 = false;
    L14:
        r110 = null;
    L15:
        e = move-exception;
        Log.e("TimeFormatUtil", "getTranslateFormatTypeFormat is exception", e);
        r110 = "";
    L65:
        MessageCardTimeFormatConfig r115 = b();     // Catch: JSONException -> L50
        if (r115 == null) goto L49;
        JSONObject r116 = r115.translateFormat;     // Catch: JSONException -> L50
        if (r116 == null) goto L49;
        JSONObject r117 = r116.optJSONObject(r101);     // Catch: JSONException -> L50
        if (r117 == null) goto L49;
        r104 = JSONObjectProtectorUtils.getString(r117, r100);     // Catch: JSONException -> L50
    L49:
        r105 = r104;
    L52:
        if (r105 != null) goto L54;
    L57:
        if (r103 == true) goto L60;
        return r105;
    L54:
        if (r105.length() == 0) goto L57;
        r103 = false;
    L50:
        e = move-exception;
        Log.e("TimeFormatUtil", "getTranslateFormatTypeFormat is exception", e);
        goto L52
    }
}
