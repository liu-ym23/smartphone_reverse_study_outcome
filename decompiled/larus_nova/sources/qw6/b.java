package qw6;

import com.bytedance.locallife.pdp.settings.l0;
import com.ss.android.ugc.aweme.poi.bean.PoiBizCode;
import com.ss.android.ugc.aweme.trade.goods.entity.PoiTradeSettingEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends gw6.a {
    public b() {
        super(PoiBizCode.FOOD);
    }

    @Override // gw6.a
    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeTag");
        PoiTradeSettingEntity r101 = l0.f261737a;
        if (r101 == null) goto L6;
        List<String> r102 = r101.a0();
        if (r102 == null) goto L6;
    L8:
        return !r102.contains(r100);
    L6:
        r102 = l0.f261744h;
        goto L8
    }
}
