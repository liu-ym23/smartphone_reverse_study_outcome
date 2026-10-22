package com.bytedance.ee.bear.sheet.panel;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseCellPanelFragment<T extends SheetItem> extends BaseFragment {
    public static final /* synthetic */ int g = 0;
    public TextView e;
    public T[] f;

    public class a extends t {
        public final /* synthetic */ View c;
        public final /* synthetic */ SheetItem d;
        public final /* synthetic */ BaseCellPanelFragment e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            this.c.setSelected(true);
            this.e.ca0(this.d.getId(), this.d.getValue());
        }

        public a(BaseCellPanelFragment r1, View r2, SheetItem r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public boolean W90(String r1) {
        return false;
    }

    public abstract String Y90();

    public abstract BaseCellPanelViewModel<T> Z90();

    public abstract void da0();

    public final void V90() {
        SheetItem[] r0 = (SheetItem[]) Z90().getSubItems(Y90()).getValue();
        if (r0 == null) goto L7;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        SheetItem r3 = r0[r2];
        Z90().clearBadges(r3.getId());
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    public BaseCellPanelFragment() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void U90(T r6) {
        View r0 = X90(r6.getId());
        if (r0 == 0) goto L29;
        int r1 = 0;
        r0.setVisibility(0);
        if ((r0 instanceof com.bytedance.ee.bear.sheet.panel.panelcell.a) == false) goto L7;
        com.bytedance.ee.bear.sheet.panel.panelcell.a r2 = (com.bytedance.ee.bear.sheet.panel.panelcell.a) r0;
        r2.update(r6);
        r2.a(Z90().showBadges(r6.getId()));
        r2.setClickListener(new b(this));
        r0.setSelected(r6.isSelected());
        return;
    L7:
        r0.setSelected(r6.isSelected());
        ea0(r0, r6.isEnable());
        if (TextUtils.isEmpty(r6.getTitle()) == true) goto L19;
        if ((r0 instanceof TextView) == false) goto L14;
        ((TextView) r0).setText(r6.getTitle());
        goto L19
    L14:
        if ((r0 instanceof ViewGroup) == false) goto L19;
        View r3 = r0.findViewWithTag("title");
        if ((r3 instanceof TextView) == false) goto L19;
        ((TextView) r3).setText(r6.getTitle());
    L19:
        if ((r0 instanceof ViewGroup) == false) goto L27;
        View r4 = r0.findViewWithTag("badge_point");
        if (r4 == null) goto L27;
        if (Z90().showBadges(r6.getId()) == true) goto L26;
        r1 = 8;
    L26:
        r4.setVisibility(r1);
    L27:
        r0.setOnClickListener(new a(this, r0, r6));
        return;
    }

    public final View X90(String r2) {
        if (getView() != null) goto L5;
        return null;
    L5:
        return getView().findViewWithTag(r2);
    }

    public final boolean aa0(String r7) {
        T[] r0 = this.f;
        if (r0 == null) goto L11;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        T r4 = r0[r3];
        if (TextUtils.equals(r7, r4.id) == true) goto L9;
        r3 = r3 + 1;
        goto L5
    L9:
        return r4.isAdminLimit();
    L11:
        return false;
    }

    public final boolean ba0(String r7) {
        T[] r0 = this.f;
        if (r0 == null) goto L11;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        T r4 = r0[r3];
        if (TextUtils.equals(r7, r4.id) == true) goto L9;
        r3 = r3 + 1;
        goto L5
    L9:
        return r4.isEnable();
    L11:
        return false;
    }

    public final void fa0(CharSequence r2) {
        TextView r0 = this.e;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public void ga0(T[] r7) {
        T[] r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L12;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L12;
        T r4 = r0[r3];
        if (r4 == null) goto L11;
        View r5 = X90(r4.getId());
        if (r5 == null) goto L11;
        r5.setVisibility(8);
    L11:
        r3 = r3 + 1;
    L12:
        int r6 = r7.length;
    L13:
        if (r1 >= r6) goto L18;
        T r8 = r7[r1];
        if (r8 == null) goto L17;
        U90(r8);
    L17:
        r1 = r1 + 1;
        goto L13
    }

    public static void ea0(View r3, boolean r4) {
        r3.setEnabled(r4);
        if ((r3 instanceof ViewGroup) == false) goto L7;
        ViewGroup r5 = (ViewGroup) r3;
        int r0 = r5.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        ea0(r5.getChildAt(r1), r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public void ca0(String r2, String r3) {
        Z90().clickItem(r2, r3);
        if (ba0(r2) == true) goto L5;
        return;
    L5:
        if (W90(r2) == false) goto L9;
        V90();
        return;
    }

    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        if (getView() != null) goto L5;
    L11:
        Z90().getSubItems(Y90()).observe(this, new com.bytedance.ee.bear.sheet.panel.a(this));
        return;
    L5:
        if (getView().getRootView() == null) goto L11;
        SheetDragView r5 = (SheetDragView) getView().getRootView().findViewById(2131372039);
        View r6 = getView().findViewById(2131388817);
        if (r5 == null) goto L11;
        if (r6 == null) goto L11;
        TextView r0 = (TextView) r6.findViewById(2131388772);
        this.e = r0;
        r0.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.e.getPaint().setStrokeWidth(1.0f);
        r5.setSlideView(r6);
        r6.findViewById(2131363779).setOnClickListener(new c(this));
        goto L11
    }
}
