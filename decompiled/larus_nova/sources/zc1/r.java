package zc1;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.wallet.model.PayChannel;
import com.bytedance.android.live.wallet.utils.monitor.OrderMonitor;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class r {
    public static String a(Map<String, String> r100) {
        if (r100 == null) goto L11;
        String r101 = r100.get("pay_info");
        if (TextUtils.isEmpty(r101) == true) goto L6;
        return e(JSONObjectProtectorUtils.getString(new JSONObject(r101), "paytype"));
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L6:
        return r100.get("tt_cj_pay_payment_method");
    L11:
        return "";
    }

    public static String e(String r100) {
        if (TextUtils.equals(r100, "wx") == false) goto L6;
        return "wxpay";
    L6:
        if (TextUtils.equals(r100, "alipay") == false) goto L9;
        return "alipay";
    L9:
        if (TextUtils.equals(r100, "quickpay") == false) goto L12;
        return BrowserDependency.UrlClickType.CARD;
    L12:
        if (TextUtils.equals(r100, "balance") == false) goto L14;
        return "change";
    L14:
        return "";
    }

    public static void b(long r100, int r101, PayChannel r102, long r103, Throwable r110) {
        long r104 = SystemClock.uptimeMillis() - r100;
        HashMap r105 = new HashMap();
        r105.put("product_id", Long.valueOf(r103));
        r105.put("channel", r102.getValue());
        if (r101 != 0) goto L6;
        int r111 = fd1.a.f476457a;
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter("ttlive_charge_order", "name");
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_charge_order".concat("_all"), r101, r104, r105);
        fd1.a.a(0, r101, r104, r105);
        return;
    L6:
        if ((r110 instanceof ApiException) == false) goto L8;
        int r106 = ((ApiException) r110).getErrorCode();
    L9:
        if (r110 == null) goto L11;
        String r112 = r110.getMessage();
    L12:
        r105.put("error_code", Integer.valueOf(r106));
        r105.put("error_msg", r112);
        int r107 = fd1.a.f476457a;
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter("ttlive_charge_order", "name");
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_charge_order".concat("_all"), r101, r104, r105);
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter("ttlive_charge_order", "name");
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_charge_order".concat("_error"), r101, r104, r105);
        OrderMonitor.a(OrderMonitor.Stage.CREATE_ORDER, String.valueOf(r106), r112, null);
        return;
    L11:
        r112 = "";
        goto L12
    L8:
        r106 = -14;
        goto L9
    }

    public static void c(int r100, String r101, long r102, PayChannel r103, String r104) {
        HashMap r105 = new HashMap();
        r105.put("product_id", Long.valueOf(r102));
        r105.put("order_id", r101);
        r105.put("error_code", r104);
        r105.put("error_msg", "");
        r105.put("channel", r103.getValue());
        if (r100 != 0) goto L5;
        fd1.a.a(10, r100, 0, r105);
        return;
    L5:
        fd1.a.a(10, r100, 0, r105);
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter("ttlive_charge_pay_sequence", "name");
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_charge_pay_sequence".concat("_error"), r100 + 10, 0, r105);
        JSONObject r106 = new JSONObject();
        r106.put("detail_code", r104);     // Catch: JSONException -> L8
    L11:
        if (r103 != PayChannel.WEIXIN) goto L13;
        OrderMonitor.Stage r107 = OrderMonitor.Stage.WECHAT_PAY;
    L14:
        OrderMonitor.a(r107, String.valueOf(r100), "", r106);
        return;
    L13:
        r107 = OrderMonitor.Stage.ALI_PAY;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void d(int r100, int r101, com.bytedance.android.live.wallet.model.i r102, Throwable r103, String r104) {
        HashMap r105 = new HashMap();
        r105.put("times", Integer.valueOf(r101));
        r105.put("order_id", r102.a());
        r105.put("channel_id", null);
        if ((r103 instanceof ApiException) == false) goto L5;
        int r106 = ((ApiException) r103).getErrorCode();
    L6:
        if (r103 == null) goto L8;
        String r107 = r103.getMessage();
    L10:
        if (r100 != 0) goto L12;
        fd1.a.a(20, r100, 0, r105);
        return;
    L12:
        r105.put("error_code", Integer.valueOf(r106));
        r105.put("error_msg", r107);
        r105.put("pay_error_code", r104);
        fd1.a.a(20, r100, 0, r105);
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter("ttlive_charge_pay_sequence", "name");
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_charge_pay_sequence".concat("_error"), r100 + 20, 0, r105);
        OrderMonitor.a(OrderMonitor.Stage.CHECK_ORDER, String.valueOf(r106), r107, new JSONObject());
        return;
    L8:
        r107 = "";
        goto L10
    L5:
        r106 = -11;
        goto L6
    }
}
