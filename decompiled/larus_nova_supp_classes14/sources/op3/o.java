package op3;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends a<com.bytedance.android.window.shop.repository.tab.entity.l> {
    public o(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    @Override // op3.a, op3.f
    public final boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r2) {
        if (r2 == null) goto L10;
        WindowV2ProductItemVO r3 = r2.k;
        if (r3 == null) goto L10;
        String r4 = r3.d;
        if (r4 == null) goto L10;
        if ((!StringsKt.isBlank(r4)) != true) goto L10;
        return true;
    L10:
        return false;
    }
}
