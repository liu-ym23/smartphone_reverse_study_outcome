package pw0;

import com.bytedance.android.live.recharge.jsbridge.RevenueRequestDiamondCouponInfoResultModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f530823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f530824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f530825c;

    public d(f r100, Integer r101, Long r102) {
        this.f530823a = r100;
        this.f530824b = r101;
        this.f530825c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f r101 = this.f530823a;
        RevenueRequestDiamondCouponInfoResultModel r102 = new RevenueRequestDiamondCouponInfoResultModel();
        r102.a(RevenueRequestDiamondCouponInfoResultModel.Code.Success);
        RevenueRequestDiamondCouponInfoResultModel.b r103 = new RevenueRequestDiamondCouponInfoResultModel.b();
        r103.b(this.f530824b);
        r103.c(this.f530825c);
        List r104 = (List) r100;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L9;
        com.bytedance.android.live.recharge.platform.business.model.diamond.d r107 = (com.bytedance.android.live.recharge.platform.business.model.diamond.d) r106.next();
        RevenueRequestDiamondCouponInfoResultModel.a r108 = new RevenueRequestDiamondCouponInfoResultModel.a();
        String r109 = r107.getCouponId();
        if (r109 != null) goto L8;
        r109 = "";
    L8:
        r108.a(r109);
        r108.e(r107.getExpiredTime());
        r108.h(r107.getTitle());
        r108.g(r107.getSubTitle());
        r108.b(r107.getDiscountAmount());
        r108.c(r107.getConditionTitle());
        r108.d(Boolean.valueOf(!r107.isDisable()));
        r108.f(Boolean.valueOf(r107.isSelected()));
        r105.add(r108);
        goto L4
    L9:
        r103.a(r105);
        Unit r110 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
    }
}
