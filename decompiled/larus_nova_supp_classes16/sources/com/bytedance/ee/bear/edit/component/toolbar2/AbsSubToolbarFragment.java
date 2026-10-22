package com.bytedance.ee.bear.edit.component.toolbar2;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsSubToolbarFragment extends BaseSubToolbarV2Fragment<DocToolbarV2> {
    public static final /* synthetic */ int t = 0;

    public void ja0(String r1) {
    }

    public void ka0(String r1) {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment
    public final BaseSubToolbarAdapter ca0() {
        DocSubToolbarAdapter r1 = new DocSubToolbarAdapter(W90((DocToolbarV2) Z90().getToolbar().getValue()));
        r1.c = new a(this);
        return r1;
    }

    public AbsSubToolbarFragment() {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment
    public final <V> void ga0(final ItemV2 r6, V r7) {
        if (ToolbarPrimaryItemId.TextTransformSecondaryItemId.oldHighlight.equals(r6.id()) == false) goto L9;
        SelectColorViewModel r0 = (SelectColorViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, SelectColorViewModel.class);
        String r2 = getString(2131887697);
        if (TextUtils.equals(r6.getValue(), "#clear") == false) goto L7;
        String r3 = "#ffffff";
    L8:
        SelectColorViewModel.b r1 = new SelectColorViewModel.b(r2, r3, r6.getList());
        ja0(r6.getValue());
        r0.selectColorCompat(this, r1, new b(this, r6));
        goto L9
    L7:
        r3 = r6.getValue();
    L9:
        super.ga0(r6, r7);
    }

    public static void ia0(AbsSubToolbarFragment r3, ItemV2 r4, String r5) {
        r3.getClass();
        String r0 = "#ffffff";
        if (TextUtils.equals("#ffffff", r5) == false) goto L6;
        r5 = "#clear";
    L6:
        if (r3.getContext() == null) goto L12;
        SelectColorViewModel r1 = (SelectColorViewModel) com.bytedance.ee.bear.browser.plugin.q.a(r3, SelectColorViewModel.class);
        if (TextUtils.equals(r5, "#clear") == true) goto L11;
        r0 = r5;
    L11:
        r1.updateSelectedColor(r0);
    L12:
        super.ga0(r4, r5);
        r3.ka0(r5);
    }
}
