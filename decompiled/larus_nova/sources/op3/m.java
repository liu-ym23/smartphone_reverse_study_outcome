package op3;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagListDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m extends a<com.bytedance.android.window.shop.repository.tab.entity.l> {
    public m(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    @Override // op3.a, op3.f
    public final boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r100) {
        if (r100 == null) goto L22;
        WindowV2ProductItemVO r101 = r100.f189623k;
        if (r101 == null) goto L26;
        Set<String> r102 = j.f524717a;
        Map<String, ECWindowTagListDTO> r103 = r101.K;
        if (r103 == null) goto L10;
        ECWindowTagListDTO r104 = r103.get("ecom_shop_product_recommend");
    L12:
        if (r104 == null) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L17;
        return false;
    L17:
        if (j.a(r101) == false) goto L19;
        return false;
    L19:
        if (r101.c(new List[]{r101.e(), r101.d()}, true) == null) goto L25;
        return true;
    L25:
        return false;
    L14:
        r105 = false;
        goto L15
    L10:
        r104 = null;
        goto L12
    L26:
        return false;
    L22:
        return false;
    }
}
