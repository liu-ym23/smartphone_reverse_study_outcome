package r35;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.route.parcelable.WikiRouteBean;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements com.bytedance.ee.bear.route.d {
    public j() {
    }

    public final boolean b(Context r5, BearUrl r6, RouteBean r7) {
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm_record_notes_redirect_to_doubao") == true) goto L5;
    L39:
        return false;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("vc_record_notes_view_three_in_one") == true) goto L39;
        String r0 = r6.b;
        Set<String> r2 = a25.a.a;
        if (TextUtils.isEmpty(r0) == false) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L15;
        String r3 = r6.b;
    L29:
        if (TextUtils.isEmpty(r3) == false) goto L31;
        return false;
    L31:
        if (r5 != null) goto L34;
        r5 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity();
    L34:
        if (r5 != null) goto L37;
        tt5.a.d("MinutesThreeInOneRouteInterceptor", "onIntercept context missing, token=" + du5.b.g(r3));
        return false;
    L37:
        a25.a.a(r5, r3, r7);
        tt5.a.h("MinutesThreeInOneRouteInterceptor", "onIntercept, routeToken: " + du5.b.g(r6.b) + ", targetObjToken=" + du5.b.g(r3));
        return true;
    L15:
        String r4 = r6.b;
        if (TextUtils.isEmpty(r4) == false) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == true) goto L23;
    L27:
        r3 = null;
        goto L29
    L23:
        if ((r7 instanceof WikiRouteBean) == false) goto L27;
        WikiRouteBean r9 = (WikiRouteBean) r7;
        if (TextUtils.isEmpty(r9.v) == true) goto L27;
        r3 = r9.v;
        goto L29
    L18:
        if (a25.a.b.contains(r4) == false) goto L20;
        r8 = true;
        goto L21
    L10:
        if (a25.a.a.contains(r0) == false) goto L12;
        r1 = true;
        goto L13
    }
}
