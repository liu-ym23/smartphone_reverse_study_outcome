package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.CheckboxModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.CheckboxItem;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends c {
    public h(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<CheckboxModel> r8) {
        if (r8 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L27;
        MutilCellLayout r3 = this.b;
        if (r3 == null) goto L29;
        r3.getLayoutParams().height = -1;
        r3.getLayoutParams().width = -1;
        Boolean r5 = null;
        if (r3.getChildCount() == 1) goto L14;
    L16:
        r3.removeAllViews();
        CheckboxItem r0 = new CheckboxItem(r3.getContext(), null, 6, 0);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, -1);
        r4.topMargin = com.bytedance.ee.util.ui.n.d(4);
        r4.bottomMargin = com.bytedance.ee.util.ui.n.d(4);
        r0.setLayoutParams(r4);
        r3.addView(r0);
    L17:
        if (r8 == null) goto L21;
        CheckboxModel r9 = (CheckboxModel) com.bytedance.ee.bear.bitable.m.j(r8, 0, null);
        if (r9 == null) goto L21;
        r5 = Boolean.valueOf(r9.getChecked());
    L21:
        r0.getClass();
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r10) == false) goto L24;
        r0.a.setImageTintList(ColorStateList.valueOf(UIHelper.getColor(2131108653)));
    L25:
        r0.setActivated(Intrinsics.areEqual(r5, r10));
        return;
    L24:
        r0.a.setImageTintList(ColorStateList.valueOf(UIHelper.getColor(2131102417)));
        goto L25
    L14:
        if ((r3.getChildAt(0) instanceof CheckboxItem) == false) goto L16;
        View r1 = r3.getChildAt(0);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.CheckboxItem");
        r0 = (CheckboxItem) r1;
        goto L17
    L29:
        return;
    L27:
        super.g(r8);
        return;
    L5:
        if (r8.size() != 1) goto L7;
        r2 = true;
        goto L8
    }
}
