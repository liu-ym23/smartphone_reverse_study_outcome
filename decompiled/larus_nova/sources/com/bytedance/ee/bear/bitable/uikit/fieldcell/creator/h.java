package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.CheckboxModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.CheckboxItem;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h extends c {
    public h(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void g(List<CheckboxModel> r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L27;
        MutilCellLayout r102 = this.f216159b;
        if (r102 == null) goto L29;
        r102.getLayoutParams().height = -1;
        r102.getLayoutParams().width = -1;
        Boolean r103 = null;
        if (r102.getChildCount() == 1) goto L14;
    L16:
        r102.removeAllViews();
        CheckboxItem r104 = new CheckboxItem(r102.getContext(), null, 6, 0);
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-1, -1);
        r105.topMargin = com.bytedance.ee.util.ui.n.d(4);
        r105.bottomMargin = com.bytedance.ee.util.ui.n.d(4);
        r104.setLayoutParams(r105);
        r102.addView(r104);
    L17:
        if (r100 == null) goto L21;
        CheckboxModel r106 = (CheckboxModel) com.bytedance.ee.bear.bitable.m.j(r100, 0, null);
        if (r106 == null) goto L21;
        r103 = Boolean.valueOf(r106.getChecked());
    L21:
        r104.getClass();
        Boolean r107 = Boolean.TRUE;
        if (Intrinsics.areEqual(r103, r107) == false) goto L24;
        r104.f216198a.setImageTintList(ColorStateList.valueOf(UIHelper.getColor(R.color.ud_G400)));
    L25:
        r104.setActivated(Intrinsics.areEqual(r103, r107));
        return;
    L24:
        r104.f216198a.setImageTintList(ColorStateList.valueOf(UIHelper.getColor(R.color.icon_disabled)));
        goto L25
    L14:
        if ((r102.getChildAt(0) instanceof CheckboxItem) == false) goto L16;
        View r108 = r102.getChildAt(0);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.CheckboxItem");
        r104 = (CheckboxItem) r108;
        goto L17
    L29:
        return;
    L27:
        super.g(r100);
        return;
    L5:
        if (r100.size() != 1) goto L7;
        r101 = true;
        goto L8
    }
}
