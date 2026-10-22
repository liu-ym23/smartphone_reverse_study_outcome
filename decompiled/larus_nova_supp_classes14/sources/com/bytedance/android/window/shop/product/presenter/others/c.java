package com.bytedance.android.window.shop.product.presenter.others;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yo.i;
import zq3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends i<WindowV2ProductItemVO> {
    public final WindowLayoutType l;
    public final int m;

    public static final class a {
    }

    static {
    }

    public final void d0(WindowV2ProductItemVO r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Integer r5 = r4.b();
        List<Float> r0 = g.a;
        int r1 = this.m;
        WindowLayoutType r2 = this.l;
        if (r2 == null) goto L9;
        boolean r3 = true;
        if (r2.isSingleColumn() != true) goto L9;
    L10:
        List<Float> r6 = g.a(r1, r3, r5);
        if (r6.size() == 4) goto L13;
        return;
    L13:
        h0(2131387385, r6);
        h0(2131393294, r6);
        return;
    L9:
        r3 = false;
        goto L10
    }

    public c(Fragment r2, WindowLayoutType r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.l = r3;
        this.m = 101;
    }

    public final void h0(int r6, List<Float> r7) {
        SimpleDraweeView r8 = a0().findViewById(r6);
        if (r8 != null) goto L5;
        return;
    L5:
        GenericDraweeHierarchy r9 = r8.getHierarchy();
        if (r9 != null) goto L8;
        return;
    L8:
        RoundingParams r0 = r9.getRoundingParams();
        if (r0 != null) goto L11;
        r0 = new RoundingParams();
    L11:
        r0.setCornersRadii(ExtensionsKt.b((Number) ListProtector.get(r7, 0)), ExtensionsKt.b((Number) ListProtector.get(r7, 1)), ExtensionsKt.b((Number) ListProtector.get(r7, 2)), ExtensionsKt.b((Number) ListProtector.get(r7, 3)));
        r9.setRoundingParams(r0);
    }
}
