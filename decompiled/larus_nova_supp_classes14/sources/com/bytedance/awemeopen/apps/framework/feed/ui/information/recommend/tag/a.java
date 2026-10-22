package com.bytedance.awemeopen.apps.framework.feed.ui.information.recommend.tag;

import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final JSONArray a = null;
    public static final int b = 0;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;

    static {
        JSONObject r1 = AoSettings.a("ao_feed_tags_config");
        String r2 = null;
        if (r1 == null) goto L5;
        JSONArray r3 = r1.optJSONArray("host_enter_from");
    L6:
        if (r3 != null) goto L8;
        r3 = new JSONArray();
    L8:
        a = r3;
        JSONObject r4 = AoSettings.a("ao_feed_tags_config");
        if (r4 == null) goto L11;
        int r5 = r4.optInt("max_label_length");
    L12:
        b = r5;
        JSONObject r6 = AoSettings.a("ao_feed_tags_config");
        if (r6 == null) goto L15;
        String r7 = r6.optString("english_char_pattern");
    L16:
        if (r7 != null) goto L18;
        r7 = "[a-zA-Z]";
    L18:
        c = r7;
        JSONObject r8 = AoSettings.a("ao_feed_tags_config");
        if (r8 == null) goto L21;
        String r9 = r8.optString("digit_pattern");
    L22:
        if (r9 != null) goto L24;
        r9 = "\\d";
    L24:
        d = r9;
        JSONObject r10 = AoSettings.a("ao_feed_tags_config");
        if (r10 == null) goto L27;
        String r11 = r10.optString("punctuation_pattern");
    L28:
        if (r11 != null) goto L30;
        r11 = "[!\"#$%&'()*+,-./:;<=>?@\\[\\\\\\]^_`{|}~]";
    L30:
        e = r11;
        JSONObject r0 = AoSettings.a("ao_feed_tags_config");
        if (r0 == null) goto L33;
        r2 = r0.optString("space_pattern");
    L33:
        if (r2 != null) goto L35;
        r2 = "\\s+";
    L35:
        f = r2;
        return;
    L27:
        r11 = null;
        goto L28
    L21:
        r9 = null;
        goto L22
    L15:
        r7 = null;
        goto L16
    L11:
        r5 = 10;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
