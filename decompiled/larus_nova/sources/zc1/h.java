package zc1;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.wallet.model.PayChannel;
import com.bytedance.android.livesdkapi.depend.model.wallet.DetailChargeDeal;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.wallet.e.b f571245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f571246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DetailChargeDeal f571247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<Activity> f571248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PayChannel f571249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f571250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f571251g;

    public final HashMap<String, String> e() {
        HashMap<String, String> r100 = new HashMap();
        r100.put("money", String.valueOf(this.f571247c.getTotalDiamond()));
        r100.put("charge_scene", this.f571247c.getChargeScene());
        r100.put("request_page", this.f571247c.getRequestPage());
        r100.put("charge_reason", this.f571247c.getChargeReason());
        r100.put("charge_style", this.f571247c.getChargeStyle());
        r100.put("diamond_id", String.valueOf(this.f571247c.getDiamondId()));
        String r101 = "0";
        r100.put("open_fast_pay_opt", "0");
        DetailChargeDeal r102 = this.f571247c;
        if (r102.getShowFastPay() == true) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L11;
        String r104 = "1";
    L12:
        r100.put("is_fast_pay", r104);
        if (this.f571247c.getOpenCombinePay() == false) goto L20;
        if (this.f571247c.getSelectCombinePay() == false) goto L17;
        String r105 = "1";
    L18:
        r100.put("if_deduction", r105);
        r100.put("deduction_amt", String.valueOf(this.f571247c.getCombineAmount() / 10));
        goto L20
    L17:
        r105 = "0";
    L20:
        if (this.f571247c.isFirstCharge() == false) goto L22;
        String r106 = "1";
    L23:
        r100.put("is_first_recharge", r106);
        if (TextUtils.isEmpty(this.f571246b) == true) goto L29;
        r100.put("order_id", this.f571246b);
        if (this.f571251g == false) goto L28;
        r101 = "1";
    L28:
        r100.put("is_preorder", r101);
    L29:
        HashMap<String, String> r107 = this.f571247c.getExtra();
        if (r107 == null) goto L41;
        Iterator<String> r108 = r107.keySet().iterator();
    L33:
        if (r108.hasNext() == false) goto L41;
        String r109 = r108.next();
        if (r109 == null) goto L33;
        String r110 = r109.toString();
        if (TextUtils.isEmpty(r107.get(r110)) == true) goto L33;
        r100.put(r110, r107.get(r110));
    L41:
        if (TextUtils.isEmpty(r100.get("event_module")) == false) goto L47;
        if (this.f571247c.getCustomPrice() == 0) goto L45;
        r100.put("event_module", "customized");
        goto L47
    L45:
        r100.put("event_module", "official");
    L47:
        if (this.f571247c.getCustomPrice() == 0) goto L49;
        r100.put("money_paid", String.valueOf(this.f571247c.getCustomPrice()));
    L50:
        return r100;
    L49:
        r100.put("money_paid", String.valueOf(this.f571247c.getPrice()));
        goto L50
    L22:
        r106 = "0";
        goto L23
    L11:
        r104 = "0";
        goto L12
    L5:
        if (r102.getRechargeDialogHeight() <= 0) goto L7;
        r103 = true;
        goto L9
    }

    public final void c(HashMap<String, String> r100) {
        Activity r101 = this.f571248d.get();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getResources() != null) goto L7;
        return;
    L7:
        if (r101.getResources().getConfiguration() != null) goto L9;
        return;
    L9:
        if (r101.getResources().getConfiguration().orientation != 1) goto L11;
        String r102 = "0";
    L12:
        r100.put("room_orientation", r102);
        return;
    L11:
        r102 = "1";
        goto L12
    }

    public final HashMap<String, Object> d(String r100) {
        HashMap<String, Object> r101 = new HashMap();
        Iterator<Map.Entry<String, String>> r102 = e().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, String> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L6:
        r101.put("recharge_style", "use_walletpay");
        r101.put("status_msg", r100);
        return r101;
    }

    public static void b(h r100, Throwable r101) {
        r100.getClass();
        com.bytedance.android.live.wallet.e.c r102 = new com.bytedance.android.live.wallet.e.c();
        if ((r101 instanceof ApiServerException) == false) goto L5;
        r102.f102671b = ((ApiServerException) r101).getPrompt();
    L5:
        r102.f102670a = 3;
        r100.f571245a.a(r102);
    }

    public h(b r100, DetailChargeDeal r101, Activity r102) {
        this.f571249e = PayChannel.UNKNOWN;
        this.f571250f = false;
        this.f571251g = false;
        if (r101.getExtra() != null) goto L5;
    L7:
        this.f571245a = r100;
        this.f571248d = new WeakReference(r102);
        this.f571247c = r101;
        return;
    L5:
        if ("1".equals(r101.getExtra().get("is_vs")) == false) goto L7;
        this.f571250f = true;
        goto L7
    }
}
