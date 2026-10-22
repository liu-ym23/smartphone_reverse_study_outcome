package com.bytedance.ee.bear.doc.blockeditpanel.view;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ BlockEditPanelFragment a;

    public b(BlockEditPanelFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        Highlight r8 = (Highlight) r7;
        BlockEditPanelFragment r0 = this.a;
        int r1 = BlockEditPanelFragment.n;
        BlockEditPanelMenusModel r2 = (BlockEditPanelMenusModel) r0.Z90().getMenuItems().getValue();
        BlockEditPanelMenusModel.BlockEditPanel r3 = null;
        if (r2 == null) goto L13;
        List<BlockEditPanelMenusModel.BlockEditPanel> r4 = r2.getPanels();
        if (r4 == null) goto L13;
        BlockEditPanelFragment r5 = this.a;
        Iterator<T> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        T r9 = r6.next();
        String r10 = ((BlockEditPanelMenusModel.BlockEditPanel) r9).getPanelId();
        r5.getClass();
        if (TextUtils.equals(r10, "highlightPanel") == false) goto L8;
        r3 = r9;
    L12:
        r3 = r3;
    L13:
        if (r3 == null) goto L21;
        BlockEditPanelFragment r11 = this.a;
        FrameLayout r12 = r11.e;
        if (r12 == null) goto L22;
        r12.post(new a(r11, r8));
        return;
    L22:
        return;
    }
}
