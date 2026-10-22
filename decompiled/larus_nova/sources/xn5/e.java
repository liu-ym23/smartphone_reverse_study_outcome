package xn5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.banner.BannerData;
import com.bytedance.ee.bear.templates.banner.BannerDataResult;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements NetService.c<BannerDataResult> {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public static BannerData b(JSONObject r110) {
        int r100 = r110.getIntValue("banner_type");
        String r101 = r110.getString("image_url");
        String r102 = r110.getString("title");
        String r103 = r110.getString("text");
        String r104 = r110.getString("topic_id");
        String r105 = r110.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID);
        int r106 = r110.getIntValue("obj_type");
        String r107 = r110.getString("obj_token");
        JSONArray r108 = r110.getJSONArray("obj_type_list");
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
        return new BannerData(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110.getString("jump_link_url"), r110.getIntValue("banner_id"), r110.getString("collection_id"));
    }

    public final BannerDataResult a(String r100) {
        BannerDataResult r101 = new BannerDataResult(2);
        if (r100 != null) goto L31;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L14;
        tt5.a.d("TemplateBannerParser", "json is null or empty");     // Catch: Throwable -> L8
        return r101;
    L14:
        JSONObject r103 = JSON.parseObject(r100).getJSONObject("data");     // Catch: Throwable -> L8
        if (r103 == null) goto L17;
        JSONArray r104 = r103.getJSONArray(PromotionProductPrivilegesStruct.BANNERS);     // Catch: Throwable -> L8
    L18:
        if (r104 != null) goto L20;
    L27:
        tt5.a.h("TemplateBannerParser", "banner array is empty");     // Catch: Throwable -> L8
        return r101;
    L20:
        if (r104.size() == 0) goto L27;
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L8
        int r106 = r104.size();     // Catch: Throwable -> L8
        int r107 = 0;
    L23:
        if (r107 >= r106) goto L25;
        r105.add(b(r104.getJSONObject(r107)));     // Catch: Throwable -> L8
        r107 = r107 + 1;     // Catch: Throwable -> L8
        goto L23
    L25:
        r101.data = r105;     // Catch: Throwable -> L8
        return r101;
    L17:
        r104 = null;
        goto L18
    L31:
    L8:
        th = move-exception;
        tt5.a.e("TemplateBannerParser", "parse error", th, false);
        return r101;
    L5:
        if (r100.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final /* bridge */ /* synthetic */ Result parse(String r100) {
        return a(r100);
    }
}
