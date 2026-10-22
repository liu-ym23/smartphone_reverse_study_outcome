package com.bytedance.ee.bear.doc.blockeditpanel.view;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockEditPanelFragment f217661a;

    public b(BlockEditPanelFragment r100) {
        this.f217661a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Highlight r101 = (Highlight) r100;
        BlockEditPanelFragment r102 = this.f217661a;
        int r103 = BlockEditPanelFragment.f217632n;
        BlockEditPanelMenusModel r104 = r102.Z90().getMenuItems().getValue();
        BlockEditPanelMenusModel.BlockEditPanel r105 = null;
        if (r104 == null) goto L13;
        List<BlockEditPanelMenusModel.BlockEditPanel> r106 = r104.getPanels();
        if (r106 == null) goto L13;
        BlockEditPanelFragment r107 = this.f217661a;
        Iterator<T> r108 = r106.iterator();
    L8:
        if (r108.hasNext() == false) goto L12;
        T r109 = r108.next();
        String r110 = ((BlockEditPanelMenusModel.BlockEditPanel) r109).getPanelId();
        r107.getClass();
        if (TextUtils.equals(r110, "highlightPanel") == false) goto L8;
        r105 = r109;
    L12:
        r105 = r105;
    L13:
        if (r105 == null) goto L21;
        BlockEditPanelFragment r111 = this.f217661a;
        FrameLayout r112 = r111.f217633e;
        if (r112 == null) goto L22;
        r112.post(new a(r111, r101));
        return;
    L22:
        return;
    }
}
