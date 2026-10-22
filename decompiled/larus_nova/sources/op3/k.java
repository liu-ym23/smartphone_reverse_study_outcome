package op3;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k extends a<com.bytedance.android.window.shop.repository.tab.entity.l> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f524718b;

    public k(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter("product_bottom_recommend_double", "dynamicKey");
        super(r100);
        this.f524718b = "product_bottom_recommend_double";
    }

    @Override // op3.a, op3.f
    public final boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r100) {
        if (r100 == null) goto L7;
        WindowV2ProductItemVO r101 = r100.f189623k;
        if (r101 == null) goto L7;
        return j.b(r101, this.f524718b);
    L7:
        return false;
    }
}
