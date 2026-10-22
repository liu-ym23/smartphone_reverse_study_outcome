package ga1;

import android.os.Parcelable;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.WebHybridParamVo;
import com.bytedance.android.livesdkapi.app.AppConstants;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public c() {
    }

    public final Parcelable a(ia1.b r110, boolean r111) {
        ja1.a r100 = r110.f488846d;
        if (r100 != null) goto L5;
        r100 = new ja1.a(r110.f488844b, r110.f488843a, r110.f488845c);
    L5:
        String r101 = "";
        String r112 = (String) r100.a(AppConstants.BUNDLE_REFERER, "");
        int r102 = ((Number) r100.a(AppConstants.BUNDLE_SALE_SHOW_STATUS, -1)).intValue();
        Boolean r103 = Boolean.FALSE;
        boolean r104 = ((Boolean) r100.a(AppConstants.BUNDLE_NO_HW_ACCELERATION, r103)).booleanValue();
        boolean r105 = ((Boolean) r100.a(AppConstants.BUNDLE_ENABLE_APP_CACHE, r103)).booleanValue();
        boolean r106 = ((Boolean) r100.a(AppConstants.BUNDLE_USE_WEBVIEW_TITLE, r103)).booleanValue();
        String r107 = (String) r100.a(AppConstants.BUNDLE_WAP_HEADERS, "");
        boolean r113 = ((Boolean) r100.a(AppConstants.BUNDLE_LOAD_NO_CACHE, r103)).booleanValue();
        boolean r114 = ((Boolean) r100.a(AppConstants.BUNDLE_LIVE_WEBVIEW_OFFLINEENABLE, Boolean.TRUE)).booleanValue();
        if (r111 == false) goto L9;
        BaseHybridParamVo r108 = null;
    L10:
        WebHybridParamVo r109 = new WebHybridParamVo(r102, r104, r105, r106, r107, r113, r114, r112, r108, false);
        String r115 = "H5ParamsParse->getFullScreenVo: " + r109;
        if (r115 == null) goto L14;
        r101 = r115;
    L14:
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", r101);
        return r109;
    L9:
        r108 = com.bytedance.android.live.schema.helper.a.a(r110.f488843a, r110.f488844b, r110.f488845c, r100);
        goto L10
    }
}
