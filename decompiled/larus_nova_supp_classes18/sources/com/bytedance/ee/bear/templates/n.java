package com.bytedance.ee.bear.templates;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.data.ThumbnailExtra;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final DisplayName d;

        public a(String r2, String r3, String r4, DisplayName r5) {
            Intrinsics.checkNotNullParameter(r2, "avatarUrl");
            Intrinsics.checkNotNullParameter(r3, "name");
            Intrinsics.checkNotNullParameter(r4, "enName");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public static TemplateV4 a(JSONObject r50, JSONObject r51, Locale r52, boolean r53) {
        Intrinsics.checkNotNullParameter(r50, "jsonObject");
        Intrinsics.checkNotNullParameter(r52, "local");
        String r4 = r50.optString("from_user_id");
        String r5 = null;
        if (r51 == null) goto L5;
        JSONObject r1 = r51.optJSONObject(r4);
    L7:
        if (r1 != null) goto L9;
        a r2 = new a("", "", "", null);
    L10:
        JSONObject r8 = r50.optJSONObject("thumbnail_extra");
        if (r8 != null) goto L13;
        ThumbnailExtra r36 = new ThumbnailExtra(0, null, null, 7, null);
    L14:
        String r9 = r50.optString(ResourceData.KEY_ID);
        String r10 = r50.optString("name");
        int r11 = r50.optInt("obj_type");
        String r12 = r50.optString(ResourceData.KEY_OBJ_TOKEN);
        String r13 = r50.optString("category_id");
        String r14 = r50.optString("description");
        int r15 = r50.optInt("source");
        String r16 = r50.optString("platform");
        String r17 = r50.optString("operational_label_url");
        String r18 = r50.optString("op_label_url_v2", "");
        long r19 = r50.optLong("heat");
        String r20 = r50.optString("author", "");
        Intrinsics.checkNotNull(r4);
        String r7 = r2.a;
        Intrinsics.checkNotNullParameter(r52, "local");
        String r21 = ou5.a.a(r52.getLanguage(), r2.d, r2.b, r2.c);
        int r22 = r50.optInt("bottom_label_type");
        long r23 = r50.optLong("create_time");
        long r25 = r50.optLong("update_time");
        long r27 = r50.optLong("share_time");
        long r29 = r50.optLong("last_used_time");
        String r31 = r50.optString("box_color_background");
        String r32 = r50.optString("frame_color");
        int r33 = r50.optInt("display_type");
        String r34 = r50.optString("cover_token");
        String r35 = r50.optString("cover_download_url");
        int r38 = r50.optInt("template_type", 1);
        JSONObject r3 = r50.optJSONObject("extra");
        if (r3 == null) goto L17;
        String r39 = r3.optString("collection_id");
    L18:
        JSONObject r6 = r50.optJSONObject("extra");
        if (r6 == null) goto L24;
        JSONArray r24 = r6.optJSONArray("template_collection_obj_types");
        if (r24 == null) goto L24;
        r5 = r24.toString();
    L24:
        return new TemplateV4(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r4, r7, r21, r22, r23, r25, r27, r29, r31, r32, r33, r34, r35, r36, r53, r38, r39, JSON.parseArray(r5, Integer.TYPE), false, null, r50.optInt("effective_status"), r50.optInt("action_preview_and_perceive", 1), r50.optString("icon"), -1073741824, 0, null);
    L17:
        r39 = null;
        goto L18
    L13:
        r36 = new ThumbnailExtra(r8.optInt(ResourceData.KEY_TYPE), r8.optString("thumbnail"), r8.optString("decrypt_key"));
        goto L14
    L9:
        r2 = new a(r1.optString("avatar_url"), r1.optString("name"), r1.optString("en_name"), DisplayName.parseDisplayName(r1.optJSONObject("display_name")));
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public static ArrayList b(JSONArray r7, JSONObject r8, Locale r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "local");
        if (r7 == null) goto L5;
        ArrayList r0 = new ArrayList();
        int r1 = r7.length();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L14;
        TemplateV4 r3 = a(r7.optJSONObject(r2), r8, r9, r10);
        boolean r6 = true;
        if (r3.getObjType() != sbb.e.i.b) goto L11;
        r6 = com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.spacekit.template.bitable.enable", true);
    L11:
        if (r6 == false) goto L13;
        r0.add(r3);
    L13:
        r2 = r2 + 1;
        goto L7
    L14:
        return r0;
    L5:
        return new ArrayList();
    }
}
