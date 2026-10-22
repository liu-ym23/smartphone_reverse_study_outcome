package x09;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements q97.a {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("Router matchInterceptRules -> ");
        if (r100 == null) goto L7;
        Uri r103 = r100.f267530d;
        if (r103 == null) goto L7;
        String r104 = r103.getAuthority();
    L8:
        r102.append(r104);
        r101.d("FlowCommonVenueRouterInterceptor", r102.toString());
        int r105 = k0.f375428a;
        if (r100 == null) goto L11;
        Uri r106 = r100.f267530d;
    L12:
        String r107 = k0.a(String.valueOf(r106));
        if (r107 != null) goto L15;
        return false;
    L15:
        if (StringsKt.contains$default(r107, "//flow/common_venue/main", false, 2, null) != true) goto L19;
        return true;
    L19:
        return false;
    L11:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r110, com.bytedance.router.c r111) {
        if (r110 == null) goto L34;
        if (r111 == null) goto L34;
        if (AppHost.f326268a.isOversea() == false) goto L10;
        return false;
    L10:
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L12;
        i3.f365750a.d(TriggerLoginScene.TRIGGER_LOGIN_ENTER_COMMON_MAIN_VENUE, r111.f267529c);
    L33:
        return true;
    L12:
        ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).b(true);
        String r100 = UriProtector.getQueryParameter(r111.f267530d, DyVerifyEventConstants.EventParam.BIZ_SCENE);
        if (r100 == null) goto L15;
        Integer r101 = StringsKt.toIntOrNull(r100);
    L16:
        i r102 = SmartRouter.buildRoute(r110, "//flow/common_venue/common_venue_page");
        r102.f(r111.f267528b);
        String r103 = r111.f267530d.toString();
        r102.f267554c.putExtra("enter_schema", r103);
        String r104 = UriProtector.getQueryParameter(r111.f267530d, "enter_method");
        String r105 = "";
        if (r104 != null) goto L19;
        r104 = "";
    L19:
        r102.f267554c.putExtra("enter_method", r104);
        String r106 = UriProtector.getQueryParameter(r111.f267530d, "template_url");
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        r102.f267554c.putExtra("lynx_template_url", r106);
        r102.f267554c.putExtra("linear_bg", "0_ffffff_1_ffffff");
        long r107 = System.currentTimeMillis();
        r102.f267554c.putExtra("schema_handle_time", r107);
        String r112 = UriProtector.getQueryParameter(r111.f267530d, "enter_url");
        if (r112 == null) goto L26;
        r105 = r112;
    L26:
        r102.f267554c.putExtra("enter_url", r105);
        r102.f267555d = R.anim.larus_router_slide_in_bottom;
        r102.f267556e = R.anim.larus_router_no_anim;
        if (r101 == null) goto L30;
        r102.h(DyVerifyEventConstants.EventParam.BIZ_SCENE, r101.intValue());
    L30:
        if ((r110 instanceof Activity) == false) goto L32;
        r102.e(10);
        goto L33
    L32:
        r102.d();
        goto L33
    L15:
        r101 = null;
    L34:
        return false;
    }
}
