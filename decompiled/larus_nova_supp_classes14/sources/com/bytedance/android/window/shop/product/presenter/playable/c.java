package com.bytedance.android.window.shop.product.presenter.playable;

import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.product.presenter.element.title.ECWindowProductCardTitleElementDefaultPresenter;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.widget.WindowBreakWordTextView;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import kotlin.jvm.internal.Intrinsics;
import yo.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends ECWindowProductCardTitleElementDefaultPresenter {

    public static final class a {
    }

    static {
    }

    public c(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void i0(WindowV2ProductItemVO r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        WindowBreakWordTextView r5 = a0().findViewById(2131387407);
        if (r5 != null) goto L5;
        return;
    L5:
        fo.a<WindowLayoutType> r0 = WindowConstDef.a;
        if (WindowConstDef.a() == false) goto L8;
        f.e(r5, 500);
    L9:
        int r2 = 1;
        if (((i) this).f.c() != WindowLayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L16;
        r2 = 2;
    L16:
        r5.setMaxLines(r2);
        return;
    L12:
        r1 = false;
        goto L13
    L8:
        r5.setTypeface(Typeface.DEFAULT_BOLD);
        goto L9
    }
}
