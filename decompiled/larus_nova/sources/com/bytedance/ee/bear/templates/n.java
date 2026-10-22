package com.bytedance.ee.bear.templates;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.data.ThumbnailExtra;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f239126a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f239127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f239128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f239129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final DisplayName f239130d;

        public a(String r100, String r101, String r102, DisplayName r103) {
            Intrinsics.checkNotNullParameter(r100, "avatarUrl");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "enName");
            this.f239127a = r100;
            this.f239128b = r101;
            this.f239129c = r102;
            this.f239130d = r103;
        }
    }

    static {
    }

    public static TemplateV4 a(JSONObject r510, JSONObject r511, Locale r512, boolean r513) {
        Intrinsics.checkNotNullParameter(r510, "jsonObject");
        Intrinsics.checkNotNullParameter(r512, "local");
        String r100 = r510.optString("from_user_id");
        String r101 = null;
        if (r511 == null) goto L5;
        JSONObject r102 = r511.optJSONObject(r100);
    L7:
        if (r102 != null) goto L9;
        a r103 = new a("", "", "", null);
    L10:
        JSONObject r104 = r510.optJSONObject("thumbnail_extra");
        if (r104 != null) goto L13;
        ThumbnailExtra r310 = new ThumbnailExtra(0, null, null, 7, null);
    L14:
        String r105 = r510.optString("id");
        String r106 = r510.optString("name");
        int r110 = r510.optInt("obj_type");
        String r111 = r510.optString("obj_token");
        String r112 = r510.optString("category_id");
        String r113 = r510.optString("description");
        int r114 = r510.optInt("source");
        String r115 = r510.optString("platform");
        String r116 = r510.optString("operational_label_url");
        String r117 = r510.optString("op_label_url_v2", "");
        long r118 = r510.optLong("heat");
        String r210 = r510.optString("author", "");
        Intrinsics.checkNotNull(r100);
        String r107 = r103.f239127a;
        Intrinsics.checkNotNullParameter(r512, "local");
        String r211 = ou5.a.a(r512.getLanguage(), r103.f239130d, r103.f239128b, r103.f239129c);
        int r212 = r510.optInt("bottom_label_type");
        long r213 = r510.optLong("create_time");
        long r214 = r510.optLong("update_time");
        long r215 = r510.optLong("share_time");
        long r216 = r510.optLong("last_used_time");
        String r311 = r510.optString("box_color_background");
        String r312 = r510.optString("frame_color");
        int r313 = r510.optInt("display_type");
        String r314 = r510.optString("cover_token");
        String r315 = r510.optString("cover_download_url");
        int r316 = r510.optInt("template_type", 1);
        JSONObject r108 = r510.optJSONObject("extra");
        if (r108 == null) goto L17;
        String r317 = r108.optString("collection_id");
    L18:
        JSONObject r109 = r510.optJSONObject("extra");
        if (r109 == null) goto L24;
        JSONArray r119 = r109.optJSONArray("template_collection_obj_types");
        if (r119 == null) goto L24;
        r101 = r119.toString();
    L24:
        return new TemplateV4(r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r100, r107, r211, r212, r213, r214, r215, r216, r311, r312, r313, r314, r315, r310, r513, r316, r317, JSON.parseArray(r101, Integer.TYPE), false, null, r510.optInt("effective_status"), r510.optInt("action_preview_and_perceive", 1), r510.optString("icon"), -1073741824, 0, null);
    L17:
        r317 = null;
        goto L18
    L13:
        r310 = new ThumbnailExtra(r104.optInt("type"), r104.optString(DocCallbackImpl.KEY_THUMBNAIL), r104.optString("decrypt_key"));
        goto L14
    L9:
        r103 = new a(r102.optString("avatar_url"), r102.optString("name"), r102.optString("en_name"), DisplayName.parseDisplayName(r102.optJSONObject(IGoogleService.ResponseKey.DISPLAY_NAME)));
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public static ArrayList b(JSONArray r100, JSONObject r101, Locale r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r102, "local");
        if (r100 == null) goto L5;
        ArrayList r103 = new ArrayList();
        int r104 = r100.length();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L14;
        TemplateV4 r106 = a(r100.optJSONObject(r105), r101, r102, r110);
        boolean r107 = true;
        if (r106.getObjType() != sbb.e.f541298i.f541317b) goto L11;
        r107 = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.spacekit.template.bitable.enable", true);
    L11:
        if (r107 == false) goto L13;
        r103.add(r106);
    L13:
        r105 = r105 + 1;
        goto L7
    L14:
        return r103;
    L5:
        return new ArrayList();
    }
}
