package pa0;

import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.platform.business.model.income.b f528344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.platform.business.model.income.d f528345b;

    @Override // pa0.e
    public final ExchangeInfo a() {
        int r100 = (int) this.f528344a.getCashBalance();
        int r101 = (int) (this.f528344a.getCashBalance() / 10);
        boolean r102 = this.f528345b.firstExchange;
        com.bytedance.android.live.recharge.platform.business.model.a r103 = this.f528344a.getRebateData();
        if (r103 == null) goto L5;
        int r104 = (int) r103.getRebateLimit();
    L6:
        com.bytedance.android.live.recharge.platform.business.model.a r105 = this.f528344a.getRebateData();
        if (r105 == null) goto L9;
        int r106 = (int) r105.getGiftAmount();
    L10:
        com.bytedance.android.live.recharge.platform.business.model.a r107 = this.f528344a.getRebateData();
        if (r107 == null) goto L13;
        int r108 = (int) r107.getLeftAmount();
    L14:
        int r110 = (int) this.f528344a.getMaxCash();
        int r111 = (int) this.f528344a.getMaxGoldCount();
        int r112 = (int) this.f528344a.getGoldBalance();
        com.bytedance.android.live.recharge.platform.business.model.income.d r109 = this.f528345b;
        int r113 = r104;
        int r114 = r106;
        int r115 = r108;
        return new ExchangeInfo(r100, r101, r102, null, r113, r114, r115, r110, r111, r112, r109.hideCombineExchange, r109.hideCashExchange, r109.giftPanelType, false, this.f528344a.getEquivalentCashValue(), JosStatusCodes.RNT_CODE_SERVER_ERROR, null);
    L13:
        r108 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public k(com.bytedance.android.live.recharge.platform.business.model.income.b r100, com.bytedance.android.live.recharge.platform.business.model.income.d r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.f528344a = r100;
        this.f528345b = r101;
    }
}
