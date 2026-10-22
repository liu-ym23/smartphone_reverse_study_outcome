package op3;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends a<com.bytedance.android.window.shop.repository.tab.entity.l> {
    public final String b;

    public k(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter("product_bottom_recommend_double", "dynamicKey");
        super(r3);
        this.b = "product_bottom_recommend_double";
    }

    @Override // op3.a, op3.f
    public final boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r2) {
        if (r2 == null) goto L7;
        WindowV2ProductItemVO r3 = r2.k;
        if (r3 == null) goto L7;
        return j.b(r3, this.b);
    L7:
        return false;
    }
}
