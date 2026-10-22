package gi8;

import com.larus.bmhome.chat.banner.i;
import com.larus.bmhome.chat.banner.m;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f481475a = 0;

    static {
    }

    public static void a(i r100, boolean r110) {
        Integer r101 = r100.d();
        if (r101 == null) goto L79;
        boolean r102 = false;
        if (r101.intValue() <= 0) goto L7;
        boolean r103 = true;
    L8:
        String r104 = null;
        if (r103 == true) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L80;
        int r105 = r101.intValue();
        if (r105 == 1) goto L22;
        if (r105 == 2) goto L19;
        if (r110 == false) goto L18;
        String r111 = "action_banner_click";
    L25:
        String r106 = r100.i();
        if (r106 != null) goto L28;
    L29:
        r102 = true;
    L30:
        if (r102 == false) goto L77;
        JSONObject r107 = new JSONObject();
    L44:
        if (r105 == 1) goto L74;
        if (r105 == 2) goto L47;
        r107.put("banner_type", r105);
    L75:
        o.f365780a.reportEvent(r111, r107);
        return;
    L47:
        r107.put("enter_method", "model_selector_quota_entry");
        r107.put("current_page", "chat");
        r107.put("trigger_scene", "fixed_entry");
        r107.put("feature_key", "");
        r107.put("subs_type", "doubao_personal");
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r108 = ICommerceMembershipService.a.a();
        if (r108 == null) goto L56;
        String r109 = r108.A(r100.e());
        if (r109 != null) goto L53;
        r109 = r100.e();
    L53:
        uz8.c r112 = r108.z(r109);
        if (r112 == null) goto L56;
        String r113 = r112.f552214f;
    L57:
        if (r113 != null) goto L59;
    L64:
        m r114 = r100.g();
        if (r114 == null) goto L73;
        String r115 = r114.c();
        if (r115 == null) goto L73;
        if ((!StringsKt.isBlank(r115)) == false) goto L71;
        r104 = r115;
    L71:
        if (r104 == null) goto L73;
        r107.put("button_name", r104);
    L73:
        Unit r116 = Unit.INSTANCE;
        goto L75
    L59:
        if ((!StringsKt.isBlank(r113)) == true) goto L62;
        r113 = null;
    L62:
        if (r113 == null) goto L64;
        r107.put("subs_purchase_id", r113);
    L56:
        r113 = null;
        goto L57
    L74:
        r107.put("current_page", "chat");
        goto L75
    L77:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L34
        Object r118 = Result.m9449constructorimpl(new JSONObject(r106));     // Catch: Throwable -> L34
    L36:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L39;
        FLogger.f375446a.w("BannerNestedMenuTracker", "parse tracking failed, error=" + r119.getMessage());
    L39:
        JSONObject r120 = new JSONObject();
        if (Result.m9455isFailureimpl(r118) == false) goto L42;
        r118 = r120;
    L42:
        r107 = (JSONObject) r118;
    L34:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L28:
        if (StringsKt.isBlank(r106) == false) goto L30;
    L18:
        r111 = "action_banner_show";
        goto L25
    L19:
        if (r110 == false) goto L21;
        r111 = "click_subs_guidance";
        goto L25
    L21:
        r111 = "show_subs_guidance";
        goto L25
    L22:
        if (r110 == false) goto L24;
        r111 = "click_subs_quota_entry";
        goto L25
    L24:
        r111 = "show_subs_quota_entry";
        goto L25
    L80:
        return;
    L7:
        r103 = false;
        goto L8
    }
}
