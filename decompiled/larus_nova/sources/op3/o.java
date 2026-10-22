package op3;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class o extends a<com.bytedance.android.window.shop.repository.tab.entity.l> {
    public o(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    @Override // op3.a, op3.f
    public final boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r100) {
        if (r100 == null) goto L10;
        WindowV2ProductItemVO r101 = r100.f189623k;
        if (r101 == null) goto L10;
        String r102 = r101.f49466d;
        if (r102 == null) goto L10;
        if ((!StringsKt.isBlank(r102)) != true) goto L10;
        return true;
    L10:
        return false;
    }
}
