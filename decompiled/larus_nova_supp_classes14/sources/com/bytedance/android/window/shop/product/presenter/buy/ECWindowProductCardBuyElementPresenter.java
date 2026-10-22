package com.bytedance.android.window.shop.product.presenter.buy;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.repository.vo.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sq3.h;
import yo.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowProductCardBuyElementPresenter extends i<WindowV2ProductItemVO> {
    public static final /* synthetic */ int n = 0;
    public final Lazy l;
    public final Lazy m;

    public static final class a {
    }

    static {
    }

    public final TextView h0() {
        return (TextView) this.l.getValue();
    }

    public ECWindowProductCardBuyElementPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.l = LazyKt.lazy(new ECWindowProductCardBuyElementPresenter$buyProductView$2(this));
        this.m = LazyKt.lazy(new ECWindowProductCardBuyElementPresenter$initOnceHelper$2(this));
    }

    public final void d0(WindowV2ProductItemVO r5) {
        Boolean r1 = null;
        if ((r5 instanceof h) == true) goto L5;
        r5 = null;
    L5:
        h r6 = (h) r5;
        if (r6 == null) goto L20;
        Unit r0 = (Unit) this.m.getValue();
        Long r2 = ((WindowV2ProductItemVO) r6).c;
        if (r2 == null) goto L21;
        long r3 = r2.longValue();
        SourceType.Companion.getClass();
        if (SourceType.a.e(r3) == true) goto L18;
        b r7 = ((WindowV2ProductItemVO) r6).z;
        if (r7 == null) goto L15;
        r1 = r7.a;
    L15:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L18;
        h0().setMinWidth(com.bytedance.android.shopping.extensions.b.b(70));
        TextView r8 = h0();
        ViewGroup.LayoutParams r4 = h0().getLayoutParams();
        r4.width = -2;
        Unit r9 = Unit.INSTANCE;
        r8.setLayoutParams(r4);
        return;
    L18:
        h0().setMinWidth(com.bytedance.android.shopping.extensions.b.b(70));
        TextView r10 = h0();
        ViewGroup.LayoutParams r11 = h0().getLayoutParams();
        r11.width = -2;
        Unit r12 = Unit.INSTANCE;
        r10.setLayoutParams(r11);
        return;
    L21:
        return;
    }
}
