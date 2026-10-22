package com.larus.live.impl.ttlivesdk;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livehostapi.business.IHostSchemaHandler;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.locallife.ILocalLifeService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.e_commerce.api.IECommerceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l implements IHostSchemaHandler {

    public static final class a {
    }

    static {
    }

    public l() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSchemaHandler
    public final String transformBeforeHandleSchema(Context r100, String r101) {
        return r101;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostSchemaHandler
    public final boolean onInterceptSchema(Context r100, String r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        Uri r102 = UriProtector.parse(r101);
        if (r101.length() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L20;
        if (r100 == null) goto L20;
        ILocalLifeService r104 = (ILocalLifeService) ServiceManager.get().getService(ILocalLifeService.class);
        if (r104 == null) goto L16;
        Intrinsics.checkNotNull(r102);
        if (r104.handleSchema(r100, r102) != true) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L20;
        return true;
    L16:
        r105 = false;
    L20:
        if (Intrinsics.areEqual(r102.getScheme(), AppConstants.SCHEME_SS_LOCAL) == true) goto L22;
        return false;
    L22:
        String r106 = r102.getAuthority();
        if (r106 != null) goto L25;
        return false;
    L25:
        switch(r106.hashCode()) {
            case -1001735703: goto L43;
            case 3146030: goto L40;
            case 1224424441: goto L31;
            case 1466376712: goto L28;
            default: goto L49;
        };
    L49:
        return false;
    L28:
        if (r106.equals("webcast_redirect") == false) goto L48;
    L45:
        SmartRouter.buildRoute(r100, r101).d();
        return true;
    L48:
        return false;
    L31:
        if (r106.equals("webview") == false) goto L50;
        if (r100 != null) goto L35;
        return false;
    L35:
        IECommerceService r107 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r107 == null) goto L38;
        r107.c(r100, r102.buildUpon().authority("webcast_webview").build());
    L38:
        return true;
    L50:
        return false;
    L40:
        if (r106.equals(BytedCertConstant.CertKey.FLOW) == true) goto L45;
        return false;
    L43:
        if (r106.equals("lynxview_popup") == true) goto L45;
        return false;
    L8:
        r103 = false;
        goto L9
    }
}
