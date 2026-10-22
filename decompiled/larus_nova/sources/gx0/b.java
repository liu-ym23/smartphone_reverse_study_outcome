package gx0;

import am2.x;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.utils.f;
import com.bytedance.android.livesdk.revenue.log.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483086a = 0;

    static {
    }

    public static void a(boolean r100) {
        HashMap r101 = new HashMap();
        r101.put("request_page", "gift_entrance");
        r101.put("charge_reason", "exchange_diamond");
        r101.put("available_exchange_diamond", String.valueOf(((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getExchangeDiamond()));
        if (r100 == false) goto L5;
        String r102 = "1";
    L6:
        r101.put("is_click_success", r102);
        HashMap<Class<?>, d<?>> r103 = f.f90457a;
        f.d("livesdk_exchange_entrance_click", r101, new Class[]{IRoom.class, x.class});
        return;
    L5:
        r102 = "0";
        goto L6
    }
}
