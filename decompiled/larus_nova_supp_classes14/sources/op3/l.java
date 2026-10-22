package op3;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagListDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l extends a<com.bytedance.android.window.shop.repository.tab.entity.l> {
    public l(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    @Override // op3.a, op3.f
    public final boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r4) {
        if (r4 == null) goto L20;
        WindowV2ProductItemVO r5 = r4.k;
        if (r5 == null) goto L22;
        Set<String> r1 = j.a;
        Map r2 = r5.K;
        if (r2 == null) goto L10;
        ECWindowTagListDTO r3 = (ECWindowTagListDTO) r2.get("ecom_shop_product_recommend");
    L12:
        if (r3 == null) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
    L18:
        return true;
    L17:
        if (j.a(r5) == true) goto L18;
        return false;
    L14:
        r6 = false;
        goto L15
    L10:
        r3 = null;
        goto L12
    L22:
        return false;
    L20:
        return false;
    }
}
