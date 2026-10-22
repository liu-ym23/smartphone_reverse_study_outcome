package com.bytedance.android.window.shop.product.presenter.playable;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.widget.WindowRoundedLinearLayout;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yo.i;
import zq3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends i<WindowV2ProductItemVO> {
    public final WindowLayoutType l;
    public final int m;

    public static final class a {
    }

    static {
    }

    public final void d0(WindowV2ProductItemVO r6) {
        WindowRoundedLinearLayout r0 = a0().findViewById(2131387381);
        if (r0 != null) goto L5;
        return;
    L5:
        List<Float> r1 = g.a;
        int r2 = this.m;
        WindowLayoutType r3 = this.l;
        if (r3 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r6 == null) goto L13;
        Integer r7 = r6.b();
    L14:
        List r8 = g.a(r2, r4, r7);
        if (r8.size() >= 4) goto L17;
        return;
    L17:
        r0.a(ExtensionsKt.b((Number) ListProtector.get(r8, 0)), ExtensionsKt.b((Number) ListProtector.get(r8, 1)), ExtensionsKt.b((Number) ListProtector.get(r8, 2)), ExtensionsKt.b((Number) ListProtector.get(r8, 3)));
        return;
    L13:
        r7 = null;
        goto L14
    L8:
        if (r3.isSingleColumn() != true) goto L10;
        r4 = true;
        goto L11
    }

    public b(Fragment r2, WindowLayoutType r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.l = r3;
        this.m = 210;
    }
}
