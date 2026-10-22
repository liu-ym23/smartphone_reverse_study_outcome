package com.larksuite.component.card.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.log.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@AppConfig(key = "messagecard_time_format_i18n_config", parse = "parseConfig")
public class LynxMsgCardTimeFormatConfig {
    public static final String LOCALE_LANGUAGE_FORMAT_KEY = "locale_language_format_pc";
    public static final String TAG = "TimeFormatConfig";
    public static final String TRANSLATE_LANGUAGE_FORMAT_KEY = "translate_format_pc";

    @SerializedName(LOCALE_LANGUAGE_FORMAT_KEY)
    public JSONObject localeLanguageFormat;

    @SerializedName(TRANSLATE_LANGUAGE_FORMAT_KEY)
    public JSONObject translateFormat;

    public LynxMsgCardTimeFormatConfig() {
    }

    public void parseConfig(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L4
        this.localeLanguageFormat = r101.optJSONObject(LOCALE_LANGUAGE_FORMAT_KEY);     // Catch: JSONException -> L4
        this.translateFormat = r101.optJSONObject(TRANSLATE_LANGUAGE_FORMAT_KEY);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Log.e("TimeFormatConfig", "parseConfig exception", e);
    }
}
