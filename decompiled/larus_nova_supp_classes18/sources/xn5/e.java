package xn5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.banner.BannerData;
import com.bytedance.ee.bear.templates.banner.BannerDataResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements NetService.c<BannerDataResult> {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public static BannerData b(JSONObject r14) {
        int r1 = r14.getIntValue("banner_type");
        String r2 = r14.getString("image_url");
        String r3 = r14.getString("title");
        String r4 = r14.getString("text");
        String r5 = r14.getString("topic_id");
        String r6 = r14.getString("template_id");
        int r7 = r14.getIntValue("obj_type");
        String r8 = r14.getString(ResourceData.KEY_OBJ_TOKEN);
        JSONArray r9 = r14.getJSONArray("obj_type_list");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
        return new BannerData(r1, r2, r3, r4, r5, r6, r7, r8, r9, r14.getString("jump_link_url"), r14.getIntValue("banner_id"), r14.getString("collection_id"));
    }

    public final BannerDataResult a(String r8) {
        BannerDataResult r0 = new BannerDataResult(2);
        if (r8 != null) goto L31;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        tt5.a.d("TemplateBannerParser", "json is null or empty");     // Catch: Throwable -> L8
        return r0;
    L14:
        JSONObject r9 = JSON.parseObject(r8).getJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Throwable -> L8
        if (r9 == null) goto L17;
        JSONArray r10 = r9.getJSONArray("banners");     // Catch: Throwable -> L8
    L18:
        if (r10 != null) goto L20;
    L27:
        tt5.a.h("TemplateBannerParser", "banner array is empty");     // Catch: Throwable -> L8
        return r0;
    L20:
        if (r10.size() == 0) goto L27;
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L8
        int r5 = r10.size();     // Catch: Throwable -> L8
        int r6 = 0;
    L23:
        if (r6 >= r5) goto L25;
        r4.add(b(r10.getJSONObject(r6)));     // Catch: Throwable -> L8
        r6 = r6 + 1;     // Catch: Throwable -> L8
        goto L23
    L25:
        ((Result) r0).data = r4;     // Catch: Throwable -> L8
        return r0;
    L17:
        r10 = null;
        goto L18
    L31:
    L8:
        th = move-exception;
        tt5.a.e("TemplateBannerParser", "parse error", th, false);
        return r0;
    L5:
        if (r8.length() == 0) goto L10;
        r3 = false;
        goto L11
    }

    public final /* bridge */ /* synthetic */ Result parse(String r1) {
        return a(r1);
    }
}
