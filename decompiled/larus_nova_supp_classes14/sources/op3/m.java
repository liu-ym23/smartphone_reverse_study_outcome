package op3;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagListDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends a<com.bytedance.android.window.shop.repository.tab.entity.l> {
    public m(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    @Override // op3.a, op3.f
    public final boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r5) {
        if (r5 == null) goto L22;
        WindowV2ProductItemVO r6 = r5.k;
        if (r6 == null) goto L26;
        Set<String> r1 = j.a;
        Map r2 = r6.K;
        if (r2 == null) goto L10;
        ECWindowTagListDTO r3 = (ECWindowTagListDTO) r2.get("ecom_shop_product_recommend");
    L12:
        if (r3 == null) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        return false;
    L17:
        if (j.a(r6) == false) goto L19;
        return false;
    L19:
        if (r6.c(new List[]{r6.e(), r6.d()}, true) == null) goto L25;
        return true;
    L25:
        return false;
    L14:
        r4 = false;
        goto L15
    L10:
        r3 = null;
        goto L12
    L26:
        return false;
    L22:
        return false;
    }
}
