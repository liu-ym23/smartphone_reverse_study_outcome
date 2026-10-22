package op3;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n extends a<com.bytedance.android.window.shop.repository.tab.entity.l> {
    public n(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    @Override // op3.a, op3.f
    public final boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r6) {
        if (r6 == null) goto L32;
        WindowV2ProductItemVO r7 = r6.k;
        if (r7 == null) goto L35;
        List r1 = r7.g("ecom_window_privilege");
        if (r1 != null) goto L10;
    L11:
        List r2 = r7.n;
        if (r2 != null) goto L14;
    L15:
        List r3 = r7.f();
        if (r3 != null) goto L18;
    L20:
        boolean r4 = false;
    L22:
        if (Intrinsics.areEqual((Boolean) r7.C.a(wn.a.q), Boolean.TRUE) == false) goto L24;
    L27:
        boolean r8 = true;
    L28:
        if (r4 == false) goto L33;
        if (r8 == true) goto L34;
        return true;
    L34:
        return false;
    L33:
        return false;
    L24:
        if (j.b(r7, "product_bottom_recommend_double") == true) goto L27;
        r8 = false;
        goto L28
    L18:
        if ((!r3.isEmpty()) != true) goto L20;
    L19:
        r4 = true;
        goto L22
    L14:
        if ((!r2.isEmpty()) == true) goto L19;
    L10:
        if ((!r1.isEmpty()) == true) goto L19;
    L35:
        return false;
    L32:
        return false;
    }
}
