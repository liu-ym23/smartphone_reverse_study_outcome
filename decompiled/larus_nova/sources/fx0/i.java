package fx0;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements Consumer<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f479071a;

    public i(CallContext r100) {
        this.f479071a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Long r100) throws Exception {
        JSONObject r101 = new JSONObject();
        r101.put("current_diamond", ((IRechargeService) jc1.k.f(IRechargeService.class)).rechargeCenter().getAvailableDiamonds());
        this.f479071a.b("h5_diamond_change", r101);
    }
}
