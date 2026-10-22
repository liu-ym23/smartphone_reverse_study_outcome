package com.bytedance.awemeopen.apps.framework.feed.ui.information.recommend.tag;

import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSONArray f196318a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f196319b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f196320c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f196321d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f196322e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f196323f = null;

    static {
        JSONObject r100 = AoSettings.a("ao_feed_tags_config");
        String r101 = null;
        if (r100 == null) goto L5;
        JSONArray r102 = r100.optJSONArray("host_enter_from");
    L6:
        if (r102 != null) goto L8;
        r102 = new JSONArray();
    L8:
        f196318a = r102;
        JSONObject r103 = AoSettings.a("ao_feed_tags_config");
        if (r103 == null) goto L11;
        int r104 = r103.optInt("max_label_length");
    L12:
        f196319b = r104;
        JSONObject r105 = AoSettings.a("ao_feed_tags_config");
        if (r105 == null) goto L15;
        String r106 = r105.optString("english_char_pattern");
    L16:
        if (r106 != null) goto L18;
        r106 = "[a-zA-Z]";
    L18:
        f196320c = r106;
        JSONObject r107 = AoSettings.a("ao_feed_tags_config");
        if (r107 == null) goto L21;
        String r108 = r107.optString("digit_pattern");
    L22:
        if (r108 != null) goto L24;
        r108 = "\\d";
    L24:
        f196321d = r108;
        JSONObject r109 = AoSettings.a("ao_feed_tags_config");
        if (r109 == null) goto L27;
        String r110 = r109.optString("punctuation_pattern");
    L28:
        if (r110 != null) goto L30;
        r110 = "[!\"#$%&'()*+,-./:;<=>?@\\[\\\\\\]^_`{|}~]";
    L30:
        f196322e = r110;
        JSONObject r111 = AoSettings.a("ao_feed_tags_config");
        if (r111 == null) goto L33;
        r101 = r111.optString("space_pattern");
    L33:
        if (r101 != null) goto L35;
        r101 = "\\s+";
    L35:
        f196323f = r101;
        return;
    L27:
        r110 = null;
        goto L28
    L21:
        r108 = null;
        goto L22
    L15:
        r106 = null;
        goto L16
    L11:
        r104 = 10;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
