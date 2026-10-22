package r35;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.route.parcelable.WikiRouteBean;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.Set;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements com.bytedance.ee.bear.route.d {
    public j() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm_record_notes_redirect_to_doubao") == true) goto L5;
    L39:
        return false;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("vc_record_notes_view_three_in_one") == true) goto L39;
        String r103 = r101.f222561b;
        Set<String> r104 = a25.a.f1412a;
        if (TextUtils.isEmpty(r103) == false) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L15;
        String r106 = r101.f222561b;
    L29:
        if (TextUtils.isEmpty(r106) == false) goto L31;
        return false;
    L31:
        if (r100 != null) goto L34;
        r100 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity();
    L34:
        if (r100 != null) goto L37;
        tt5.a.d("MinutesThreeInOneRouteInterceptor", "onIntercept context missing, token=" + du5.b.g(r106));
        return false;
    L37:
        a25.a.a(r100, r106, r102);
        tt5.a.h("MinutesThreeInOneRouteInterceptor", "onIntercept, routeToken: " + du5.b.g(r101.f222561b) + ", targetObjToken=" + du5.b.g(r106));
        return true;
    L15:
        String r107 = r101.f222561b;
        if (TextUtils.isEmpty(r107) == false) goto L18;
    L20:
        boolean r108 = false;
    L21:
        if (r108 == true) goto L23;
    L27:
        r106 = null;
        goto L29
    L23:
        if ((r102 instanceof WikiRouteBean) == false) goto L27;
        WikiRouteBean r109 = (WikiRouteBean) r102;
        if (TextUtils.isEmpty(r109.f217154v) == true) goto L27;
        r106 = r109.f217154v;
        goto L29
    L18:
        if (a25.a.f1413b.contains(r107) == false) goto L20;
        r108 = true;
        goto L21
    L10:
        if (a25.a.f1412a.contains(r103) == false) goto L12;
        r105 = true;
        goto L13
    }
}
