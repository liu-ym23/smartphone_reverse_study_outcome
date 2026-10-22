package x02;

import com.bytedance.android.livesdk.gift.platform.business.sendGift.sendStrategy.ExchangeDiamondPluginCustomResultCode;
import com.bytedance.android.livesdk.gift.platform.core.model.x;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExchangeDiamondPluginCustomResultCode f562042a;

    public d(ExchangeDiamondPluginCustomResultCode r100) {
        Intrinsics.checkNotNullParameter(r100, "customCode");
        this.f562042a = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.x
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "originObject");
        r100.put("exchange_result_code", this.f562042a.getValue());
    }
}
