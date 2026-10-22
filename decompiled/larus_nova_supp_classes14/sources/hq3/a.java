package hq3;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.window.base.product.presenter.element.price.BaseECWindowProductCardPriceInfoElementPresenter;
import com.bytedance.android.ec.window.base.product.presenter.element.price.b;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.utils.k0;
import kotlin.jvm.internal.Intrinsics;
import sq3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends b {

    /* JADX INFO: renamed from: hq3.a$a, reason: collision with other inner class name */
    public static final class C0133a {
    }

    static {
    }

    public a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void i0(WindowV2ProductItemVO r9) {
        Intrinsics.checkNotNullParameter(r9, "item");
        PriceView r0 = Z().b(2131387394).f();
        Intrinsics.checkNotNullParameter(r9, "vo");
        r0.C(new BaseECWindowProductCardPriceInfoElementPresenter.a(this, r9));
        TextView r1 = (TextView) Z().b(2131387400).f();
        View r2 = Z().b(2131376607).f();
        Long r3 = null;
        if ((r9 instanceof h) == true) goto L5;
        r9 = null;
    L5:
        h r10 = (h) r9;
        if (r10 == null) goto L8;
        r3 = r10.V;
    L8:
        if (r3 != null) goto L10;
    L13:
        r1.setVisibility(8);
        r2.setVisibility(8);
        return;
    L10:
        if (r3.longValue() < 100) goto L13;
        Resources r11 = getResources();
        int r4 = k0.a;
        r1.setText(r11.getString(2131913874, new Object[]{k0.a(r3.longValue())}));
        r1.setVisibility(0);
        r2.setVisibility(0);
    }

    public final void h0(com.bytedance.android.ec.core.widget.price.a r3, WindowV2ProductItemVO r4) {
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "item");
        super.h0(r3, r4);
        r3.d = Long.valueOf(r4.j);
        r3.c = com.bytedance.android.shopping.extensions.b.b(18);
        r3.l = com.bytedance.android.shopping.extensions.b.b(1);
        r3.k = true;
        r3.v = r4.i;
        r3.w = false;
        r3.x = 0.6666667f;
        r3.y = com.bytedance.android.shopping.extensions.b.b(2);
    }
}
