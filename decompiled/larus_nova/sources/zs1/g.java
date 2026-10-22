package zs1;

import am2.x;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.c5;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class g extends com.bytedance.android.livesdk.coupon.a<com.bytedance.android.livesdk.coupon.balancecoupon.model.a> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f573466j = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f573467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f573468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f573469i;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.coupon.a
    public final Map<String, Object> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r101 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.f121821b;
        String r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.b());
    L6:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_BENEFIT_TYPE, r103);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r104 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.f121821b;
        if (r104 == null) goto L11;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e r105 = r104.e();
        if (r105 == null) goto L11;
        String r106 = r105.a();
    L12:
        r100.put("domain", r106);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r107 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.f121821b;
        if (r107 == null) goto L17;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e r108 = r107.e();
        if (r108 == null) goto L17;
        String r109 = r108.b();
    L18:
        r100.put("scene", r109);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r110 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.f121821b;
        if (r110 == null) goto L23;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e r111 = r110.e();
        if (r111 == null) goto L23;
        Long r112 = Long.valueOf(r111.d());
    L24:
        r100.put("token_type", r112);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r113 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.f121821b;
        if (r113 == null) goto L29;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e r114 = r113.e();
        if (r114 == null) goto L29;
        String r115 = r114.c();
    L30:
        r100.put("token", r115);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r116 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.f121821b;
        if (r116 == null) goto L33;
        String r117 = r116.a();
    L34:
        r100.put("activity_id", r117);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r118 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.f121821b;
        if (r118 == null) goto L37;
        String r119 = r118.c();
    L38:
        r100.put("category", r119);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r120 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.f121821b;
        if (r120 == null) goto L43;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r121 = r120.d();
        if (r121 == null) goto L43;
        r102 = r121.c();
    L43:
        r100.put("prize_type", r102);
        return r100;
    L37:
        r119 = null;
        goto L38
    L33:
        r117 = null;
    L29:
        r115 = null;
    L23:
        r112 = null;
    L17:
        r109 = null;
    L11:
        r106 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final Map<String, Object> b() {
        if (this.f121822c.f16211c == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        int r101 = 3;
    L9:
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("popup_type", Integer.valueOf(r101));
        return r102;
    L8:
        r101 = 2;
        goto L9
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final boolean d() {
        boolean r100 = !this.f573468h;
        if (r100 == false) goto L6;
        this.f573468h = true;
    L6:
        return !r100;
    }

    public final void l() {
        e r100 = this.f573467g;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
        return;
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void j() {
        l();
        this.f573468h = false;
        this.f121820a.dispose();
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void f(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        this.f573468h = false;
        m(false, "", "");
        if (c5.a(r100) == 59151) goto L5;
        f2.b(R.string.ttlive_balance_coupon_exchange_error, 0);
    L5:
        n(false);
        ALogger.e("UgBalanceCouponController", "exchange coupon code:" + c5.a(r100) + " error: " + r100.getMessage());
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void g(com.bytedance.android.livesdk.coupon.balancecoupon.model.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        boolean r101 = false;
        this.f573468h = false;
        if ((!StringsKt.isBlank(r100.d())) == false) goto L5;
        f2.c(r100.d(), 0);
    L5:
        l();
        if (r100.c() != 1) goto L8;
        r101 = true;
    L8:
        String r102 = r100.b();
        if (r101 == true) goto L13;
        String r103 = r100.d();
        if (r103 == null) goto L13;
    L14:
        m(r101, r102, r103);
        n(true);
        return;
    L13:
        r103 = "";
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.coupon.a
    public final void h(com.bytedance.android.livesdk.coupon.balancecoupon.model.c r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r100.a() == true) goto L5;
        return;
    L5:
        this.f573469i = r100.d();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r101 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.f121821b;
        if (r101 == null) goto L18;
        e r102 = new e(this.f121822c.getContext(), r101, new i(this));
        this.f573467g = r102;
        Intrinsics.checkNotNull(r102);
        r102.setOnDismissListener(new h(this));
        e r103 = this.f573467g;
        Intrinsics.checkNotNull(r103);
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r103);
    L13:
        u.l().sendLog("tobsdk_livesdk_balance_to_coupon_popup_show", null, new Object[]{Room.class, x.class});
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L12:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        goto L13
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final com.bytedance.android.livesdk.coupon.balancecoupon.model.a i(at1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "couponContext");
        Long r101 = (Long) r100.f16210b.get("data_room_id", 0L);
        boolean r102 = false;
        if (r100.f16211c != null) goto L14;
        IMiddlewareLiveService r103 = (IMiddlewareLiveService) k.f(IMiddlewareLiveService.class);
        if (r103 == null) goto L7;
        ILiveOntologyInfoManager r104 = r103.getLiveOntologyRecord();
    L8:
        if (r104 == null) goto L10;
        boolean r105 = r104.isFirstRoom(r101.longValue());
    L11:
        if (r105 == true) goto L14;
        return null;
    L10:
        r105 = false;
        goto L11
    L7:
        r104 = null;
    L14:
        if (LiveConfigSettingKeys.LIVE_MOCK_BALANCE_COUPON_PARAM.getValue().booleanValue() == false) goto L16;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r106 = new com.bytedance.android.livesdk.coupon.balancecoupon.model.a();
        r106.g();
        r106.f();
        r106.h();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e r107 = new com.bytedance.android.livesdk.coupon.balancecoupon.model.a.e();
        r107.e();
        r107.f();
        r107.h();
        r107.g();
        r106.j(r107);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r108 = new com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.b r109 = new com.bytedance.android.livesdk.coupon.balancecoupon.model.a.b();
        r109.b();
        r108.d(r109);
        r108.f();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r110 = new com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d();
        r110.i();
        r110.h();
        r110.j();
        r110.k();
        r110.g();
        r110.l();
        r108.e(r110);
        r106.i(r108);
        return r106;
    L16:
        JSONObject r111 = r100.f16211c;
        if (r111 != null) goto L22;
        String r112 = (String) r100.f16210b.get("data_enter_ecom_live_params", "");
        if (TextUtils.isEmpty(r112) == false) goto L21;
        ALogger.i("UgBalanceCouponController", "could not find ecomParams");
        JSONObject r113 = null;
    L24:
        if (r113 != null) goto L51;
        String r114 = null;
    L32:
        if (r114 != null) goto L34;
    L35:
        r102 = true;
    L37:
        if ((!r102) == true) goto L40;
        r113 = null;
    L40:
        if (r113 == null) goto L42;
        JSONObject r115 = r113.optJSONObject("balance_coupon");     // Catch: JsonParseException -> L26 JsonSyntaxException -> L28
    L43:
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r116 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) GsonProtectorUtils.fromJson(LiveGsonHelper.get(), String.valueOf(r115), com.bytedance.android.livesdk.coupon.balancecoupon.model.a.class);     // Catch: JsonParseException -> L26 JsonSyntaxException -> L28
        if (f.a(r116) == true) goto L54;
        ALogger.i("UgBalanceCouponController", "invalid coupon type, balanceCoupon:" + r115);     // Catch: JsonParseException -> L26 JsonSyntaxException -> L28
    L28:
        e = move-exception;
        ALogger.e("UgBalanceCouponController", "JsonSyntaxException, " + Log.getStackTraceString(e));
        return null;
    L26:
        e = move-exception;
        ALogger.e("UgBalanceCouponController", "JsonSyntaxException, " + Log.getStackTraceString(e));
        return null;
    L57:
        return null;
    L54:
        return r116;
    L42:
        r115 = null;
        goto L43
    L34:
        if (r114.length() != 0) goto L37;
    L51:
        r114 = r113.toString();     // Catch: JsonParseException -> L26 JsonSyntaxException -> L28
        goto L32
    L21:
        r113 = new JSONObject(r112);
        goto L24
    L22:
        r113 = r111.optJSONObject(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS);
        goto L24
    }

    public final void n(boolean r100) {
        if (this.f121822c.f16211c == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        IBrowserService r102 = (IBrowserService) k.f(IBrowserService.class);
        if (r102 == null) goto L16;
        JSONObject r103 = new JSONObject();
        if (r100 == false) goto L12;
        String r104 = "1";
    L13:
        r103.put("is_success", r104);
        Unit r105 = Unit.INSTANCE;
        r102.enqueueEvent("exchange_coupon_result", r103);
        return;
    L12:
        r104 = "0";
        goto L13
    L16:
        return;
    L15:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static final void k(g r100, String r101) {
        r100.getClass();
        HashMap r102 = new HashMap();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r101);
        u.l().sendLog("tobsdk_livesdk_balance_to_coupon_popup_click", r102, new Object[]{Room.class, x.class});
    }

    public g(at1.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "couponContext");
        super(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(boolean r100, String r101, String r102) {
        HashMap r103 = new HashMap();
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a r104 = (com.bytedance.android.livesdk.coupon.balancecoupon.model.a) this.f121821b;
        String r105 = "success";
        if (r100 == false) goto L5;
        String r106 = "success";
    L6:
        r103.put("result", r106);
        r103.put("coupon_meta_id", r101);
        if (r100 == true) goto L10;
        r105 = "fail + ".concat(r102);
    L10:
        r103.put("coupon_status", r105);
        r103.put(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, "platform_coupon");
        Long r107 = null;
        if (r104 == null) goto L17;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r108 = r104.d();
        if (r108 == null) goto L17;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.b r109 = r108.a();
        if (r109 == null) goto L17;
        Long r110 = Long.valueOf(r109.a());
    L18:
        r103.put("amount", String.valueOf(r110));
        if (r104 == null) goto L25;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r111 = r104.d();
        if (r111 == null) goto L25;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r112 = r111.b();
        if (r112 == null) goto L25;
        r107 = Long.valueOf(r112.d());
    L25:
        r103.put("coupon_amount", String.valueOf(r107));
        u.l().sendLog("tobsdk_livesdk_balance_to_coupon_result", r103, new Object[]{Room.class, x.class});
        return;
    L17:
        r110 = null;
        goto L18
    L5:
        r106 = "fail";
        goto L6
    }
}
