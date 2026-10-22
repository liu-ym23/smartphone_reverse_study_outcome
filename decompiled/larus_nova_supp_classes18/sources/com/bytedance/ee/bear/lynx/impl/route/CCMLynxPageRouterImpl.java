package com.bytedance.ee.bear.lynx.impl.route;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.lynx.impl.page.CCMLynxPageActivity;
import com.bytedance.ee.bear.lynx.impl.page.CCMLynxPageDialog;
import com.bytedance.mt.protector.impl.UriProtector;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import onc.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CCMLynxPageRouterImpl implements CCMLynxPageRouter {
    public static final Lazy<com.bytedance.ee.bear.lynx.impl.route.a> a = null;

    public static final class a {
    }

    public CCMLynxPageRouterImpl() {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CCMLynxPageRouterImpl$Companion$ccmLynxRouteService$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter
    public final boolean a(Context r4, HashMap r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        de5.a r0 = new de5.a(null, r5, null, 29);
        Map<Integer, String> r6 = d.a;
        return b(r4, "ccm-lynx://lynxview/" + d.c.get(Integer.valueOf(CCMLynxPageRouter.PageType.RETENTION_LABEL)), r0);
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter
    public final boolean b(Context r12, String r13, de5.a r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "templateUrl");
        Intrinsics.checkNotNullParameter(r14, "openParams");
        ((com.bytedance.ee.bear.lynx.api.b) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.b.class, null, null, 6)).init(eu5.b.a);
        Bundle r1 = new Bundle();
        r1.putSerializable("template-data-bundle-key", r14.b);
        r1.putString("share-context-ID", r14.a);
        r1.putSerializable("panel-param", r14.c);
        r1.putParcelable("ori-bundle", r14.d);
        r1.putSerializable("biz-method", r14.e);
        boolean r6 = false;
        if (StringsKt.contains$default(r13, "collaborator-permission-picker", false, 2, null) == false) goto L5;
        r1.putBoolean("add_back_btn_in_forseti", true);
    L5:
        String r15 = UriProtector.parse(r13).getEncodedPath();
        if (r15 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L78;
        String r16 = d.a(r15, true);
        com.bytedance.ee.bear.lynx.impl.route.a r5 = (com.bytedance.ee.bear.lynx.impl.route.a) a.getValue();
        Uri r17 = UriProtector.parse(r16);
        Fragment r8 = r14.f;
        final boolean r18 = r14.g;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r17, "uri");
        Intrinsics.checkNotNullParameter(r1, "bundle");
        if (d.b(r17) == true) goto L32;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r17, "uri");
        if (((z) org.koin.java.a.c(z.class, null, null, 6)).isDebugEnabled(r12) == true) goto L19;
    L29:
        boolean r0 = false;
    L30:
        if (r0 == true) goto L32;
        tt5.a.k("CCMLynxRouteService", "uri is invalid : " + r17);
        return false;
    L19:
        if (r17.isHierarchical() == false) goto L29;
        if (TextUtils.isEmpty(r17.getScheme()) == true) goto L29;
        if (TextUtils.isEmpty(r17.getHost()) == true) goto L29;
        if (Intrinsics.areEqual("https", r17.getScheme()) == false) goto L27;
    L28:
        r0 = true;
        goto L30
    L27:
        if (Intrinsics.areEqual("http", r17.getScheme()) == false) goto L29;
    L32:
        Serializable r2 = r1.getSerializable("panel-param");
        r1.putParcelable("uri", r17);
        if (r2 == null) goto L57;
        if ((r12 instanceof FragmentActivity) == false) goto L57;
        if (ForsetiHelper.p() == true) goto L39;
    L41:
        boolean r19 = false;
    L42:
        if (r19 == true) goto L44;
        int r110 = CCMLynxPageDialog.k;
        CCMLynxPageDialog.a.a((FragmentActivity) r12, r1, r8, r18);
    L71:
        return true;
    L44:
        if (ForsetiHelper.s(r8) == false) goto L53;
        if (r8 != null) goto L73;
    L52:
        r6 = true;
        goto L53
    L73:
        g r111 = f.b(r8);     // Catch: Throwable -> L50
        if (r111 == null) goto L52;
        r111.f(new j(r1), new CCMLynxRouteService$gotoPage$routeByForseti$1(r18));     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        tt5.a.e("CCMLynxRouteService", "gotoPage by forseti error!", th, false);
    L53:
        if (r6 == true) goto L71;
        int r112 = CCMLynxPageDialog.k;
        CCMLynxPageDialog.a.a((FragmentActivity) r12, r1, r8, r18);
        goto L71
    L39:
        if (ForsetiHelper.l("ccm.mobile.enable_lynx_page_panel") == false) goto L41;
        r19 = true;
    L57:
        if (ForsetiHelper.s(r8) == false) goto L66;
        if (r8 != null) goto L75;
    L65:
        r6 = true;
        goto L66
    L75:
        g r3 = f.b(r8);     // Catch: Throwable -> L63
        if (r3 == null) goto L65;
        r3.f(new j(r1), new CCMLynxRouteService$gotoPage$routeByForseti$2(r18));     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        tt5.a.e("CCMLynxRouteService", "gotoPage by forseti error!", th, false);
    L66:
        if (r6 == true) goto L71;
        Intent r113 = new Intent();
        r113.setComponent(new ComponentName(r12, CCMLynxPageActivity.class));
        r113.setData(r17);
        if ((r12 instanceof Activity) == true) goto L70;
        r113.addFlags(268435456);
    L70:
        r113.putExtras(r1);
        r12.startActivity(r113);
        goto L71
    L78:
        return false;
    L8:
        if (r15.length() == 0) goto L11;
        r4 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter
    public final boolean c(Context r3, int r4, de5.a r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "openParams");
        Map<Integer, String> r0 = d.a;
        return b(r3, "ccm-lynx://lynxview/" + d.c.get(Integer.valueOf(r4)), r5);
    }
}
