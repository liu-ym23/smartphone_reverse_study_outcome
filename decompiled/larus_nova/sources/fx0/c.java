package fx0;

import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceBusinessScene;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceGiftSource;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceKey;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceScene;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements zv0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f479055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f479056b;

    @Override // zv0.e
    public final void b() {
        b r100 = this.f479055a.f479057a;
        b.c r101 = new b.c(2, null);
        int r102 = b.f479053b;
        r100.finishWithResult(r101);
    }

    @Override // zv0.e
    public final void a(Throwable r100) {
        b r101 = this.f479055a.f479057a;
        b.c r102 = new b.c(3, r100);
        int r103 = b.f479053b;
        r101.finishWithResult(r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zv0.e
    public final void c(zv0.d r100) {
        d r101 = this.f479055a;
        b r102 = r101.f479057a;
        ExchangeTraceGiftSource r103 = (ExchangeTraceGiftSource) r101.f479059c.element;
        long r104 = this.f479056b;
        int r105 = b.f479053b;
        r102.getClass();
        Map<String, String> r106 = com.bytedance.android.live.recharge.exchange.trace.a.f89971a;
        ExchangeTraceKey r107 = ExchangeTraceKey.KEY_IS_COMBINE_EXCHANGE;
        if (com.bytedance.android.live.recharge.utils.e.d() == false) goto L5;
        String r108 = "1";
    L6:
        com.bytedance.android.live.recharge.exchange.trace.a.b(r107, r108);
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_GIFT_SOURCE, r103.getValue());
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_GIFT_SHOW_FROM, "IncomeExchangeDialog JSB");
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_DIAMOND_COUNT, String.valueOf(r104));
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_BUSINESS_SCENE, String.valueOf(ExchangeTraceBusinessScene.EXCHANGE_BUSINESS_SCENE_DIAMOND.getValue()));
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_EXCHANGE_SCENE, String.valueOf(ExchangeTraceScene.EXCHANGE_SCENE_EXCHANGE_DIALOG.getValue()));
        com.bytedance.android.live.recharge.exchange.trace.a.a();
        this.f479055a.f479057a.finishWithResult(new b.c(1, null));
        return;
    L5:
        r108 = "0";
        goto L6
    }

    public c(d r100, long r101) {
        this.f479055a = r100;
        this.f479056b = r101;
    }
}
