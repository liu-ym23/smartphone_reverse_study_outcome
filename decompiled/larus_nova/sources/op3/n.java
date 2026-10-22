package op3;

import android.view.View;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n extends a<com.bytedance.android.window.shop.repository.tab.entity.l> {
    public n(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    @Override // op3.a, op3.f
    public final boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r100) {
        if (r100 == null) goto L32;
        WindowV2ProductItemVO r101 = r100.f189623k;
        if (r101 == null) goto L35;
        List<ECRitTag> r102 = r101.g("ecom_window_privilege");
        if (r102 != null) goto L10;
    L11:
        List<PromotionDiscountLabel> r103 = r101.f49476n;
        if (r103 != null) goto L14;
    L15:
        List<ECRitTag> r104 = r101.f();
        if (r104 != null) goto L18;
    L20:
        boolean r105 = false;
    L22:
        if (Intrinsics.areEqual((Boolean) r101.C.a(wn.a.f560420q), Boolean.TRUE) == false) goto L24;
    L27:
        boolean r106 = true;
    L28:
        if (r105 == false) goto L33;
        if (r106 == true) goto L34;
        return true;
    L34:
        return false;
    L33:
        return false;
    L24:
        if (j.b(r101, "product_bottom_recommend_double") == true) goto L27;
        r106 = false;
        goto L28
    L18:
        if ((!r104.isEmpty()) != true) goto L20;
    L19:
        r105 = true;
        goto L22
    L14:
        if ((!r103.isEmpty()) == true) goto L19;
    L10:
        if ((!r102.isEmpty()) == true) goto L19;
    L35:
        return false;
    L32:
        return false;
    }
}
