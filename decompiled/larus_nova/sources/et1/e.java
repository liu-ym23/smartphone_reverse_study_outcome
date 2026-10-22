package et1;

import am2.x;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.coupon.balancecoupon.CouponBenefitType;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends com.bytedance.android.livesdk.coupon.a<Object> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f473874i = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f473875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f473876h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void g(com.bytedance.android.livesdk.coupon.balancecoupon.model.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final Map<String, Object> b() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("popup_type", 2);
        return r100;
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final boolean d() {
        boolean r100 = this.f473875g;
        if (r100 == false) goto L6;
        this.f473875g = true;
    L6:
        return !r100;
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void j() {
        c r100 = this.f473876h;
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
    public final void f(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        ALogger.e("RefundCouponController", "RefundCouponController obtain error, " + Log.getStackTraceString(r100));
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void h(com.bytedance.android.livesdk.coupon.balancecoupon.model.c r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r100.a() == true) goto L5;
        return;
    L5:
        c r101 = new c(this.f121822c.getContext(), r100, new f(this));
        this.f473876h = r101;
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r101);
    L10:
        u.l().sendLog("tobsdk_livesdk_ecom_full_refund_show", null, new Object[]{Room.class, x.class});
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L9:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
        goto L10
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final Object i(at1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "couponContext");
        Long r101 = (Long) r100.f16210b.get("data_room_id", 0L);
        IMiddlewareLiveService r102 = (IMiddlewareLiveService) k.f(IMiddlewareLiveService.class);
        if (r102 == null) goto L5;
        ILiveOntologyInfoManager r103 = r102.getLiveOntologyRecord();
    L6:
        boolean r104 = false;
        if (r103 == null) goto L9;
        boolean r105 = r103.isFirstRoom(r101.longValue());
    L10:
        if (r105 == true) goto L12;
        return null;
    L12:
        String r106 = LiveConfigSettingKeys.LIVE_MOCK_FULL_REFUND_COUPON_PARAM.getValue();
        if (r106 != null) goto L15;
    L16:
        r104 = true;
    L17:
        if (r104 == false) goto L19;
        String r107 = (String) r100.f16210b.get("data_enter_ecom_live_params", "");
        if (TextUtils.isEmpty(r107) == false) goto L23;
        ALogger.i("UgBalanceCouponController", "could not find ecomParams");
        JSONObject r108 = null;
    L24:
        if (r108 == null) goto L31;
        JSONObject r109 = r108.optJSONObject("full_refund_coupon");
        if (r109 != null) goto L28;
        return null;
    L28:
        if (r109.optInt(com.bytedance.android.ec.core.event.a.KEY_BENEFIT_TYPE) == CouponBenefitType.COUPON_BENEFIT_TYPE_FULL_REFUND_COUPON.getValue()) goto L30;
        return null;
    L30:
        return new Object();
    L31:
        return null;
    L23:
        r108 = new JSONObject(r107);
        goto L24
    L19:
        return new Object();
    L15:
        if (r106.length() != 0) goto L17;
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static final void k(e r100, boolean r101) {
        r100.getClass();
        LinkedHashMap r102 = new LinkedHashMap();
        if (r101 == false) goto L5;
        String r103 = "order";
    L6:
        r102.put(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON, r103);
        u.l().sendLog("tobsdk_livesdk_ecom_full_refund_click", r102, new Object[]{Room.class, x.class});
        return;
    L5:
        r103 = "close";
        goto L6
    }

    public e(at1.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "couponContext");
        super(r100, r101, r102);
    }
}
