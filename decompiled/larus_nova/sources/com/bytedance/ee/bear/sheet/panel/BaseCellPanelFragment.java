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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BaseCellPanelFragment<T extends SheetItem> extends BaseFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f238117g = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f238118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T[] f238119f;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f238120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SheetItem f238121d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseCellPanelFragment f238122e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f238120c.setSelected(true);
            this.f238122e.ca0(this.f238121d.getId(), this.f238121d.getValue());
        }

        public a(BaseCellPanelFragment r100, View r101, SheetItem r102) {
            this.f238122e = r100;
            this.f238120c = r101;
            this.f238121d = r102;
        }
    }

    public boolean W90(String r100) {
        return false;
    }

    public abstract String Y90();

    public abstract BaseCellPanelViewModel<T> Z90();

    public abstract void da0();

    public final void V90() {
        T[] r100 = Z90().getSubItems(Y90()).getValue();
        if (r100 == null) goto L7;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        T r103 = r100[r102];
        Z90().clearBadges(r103.getId());
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public BaseCellPanelFragment() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void U90(T r100) {
        View r101 = X90(r100.getId());
        if (r101 == 0) goto L29;
        int r102 = 0;
        r101.setVisibility(0);
        if ((r101 instanceof com.bytedance.ee.bear.sheet.panel.panelcell.a) == false) goto L7;
        com.bytedance.ee.bear.sheet.panel.panelcell.a r103 = (com.bytedance.ee.bear.sheet.panel.panelcell.a) r101;
        r103.update(r100);
        r103.a(Z90().showBadges(r100.getId()));
        r103.setClickListener(new b(this));
        r101.setSelected(r100.isSelected());
        return;
    L7:
        r101.setSelected(r100.isSelected());
        ea0(r101, r100.isEnable());
        if (TextUtils.isEmpty(r100.getTitle()) == true) goto L19;
        if ((r101 instanceof TextView) == false) goto L14;
        ((TextView) r101).setText(r100.getTitle());
        goto L19
    L14:
        if ((r101 instanceof ViewGroup) == false) goto L19;
        View r104 = r101.findViewWithTag("title");
        if ((r104 instanceof TextView) == false) goto L19;
        ((TextView) r104).setText(r100.getTitle());
    L19:
        if ((r101 instanceof ViewGroup) == false) goto L27;
        View r105 = r101.findViewWithTag("badge_point");
        if (r105 == null) goto L27;
        if (Z90().showBadges(r100.getId()) == true) goto L26;
        r102 = 8;
    L26:
        r105.setVisibility(r102);
    L27:
        r101.setOnClickListener(new a(this, r101, r100));
        return;
    }

    public final View X90(String r100) {
        if (getView() != null) goto L5;
        return null;
    L5:
        return getView().findViewWithTag(r100);
    }

    public final boolean aa0(String r100) {
        T[] r101 = this.f238119f;
        if (r101 == null) goto L11;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L11;
        T r104 = r101[r103];
        if (TextUtils.equals(r100, r104.f238123id) == true) goto L9;
        r103 = r103 + 1;
        goto L5
    L9:
        return r104.isAdminLimit();
    L11:
        return false;
    }

    public final boolean ba0(String r100) {
        T[] r101 = this.f238119f;
        if (r101 == null) goto L11;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L11;
        T r104 = r101[r103];
        if (TextUtils.equals(r100, r104.f238123id) == true) goto L9;
        r103 = r103 + 1;
        goto L5
    L9:
        return r104.isEnable();
    L11:
        return false;
    }

    public final void fa0(CharSequence r100) {
        TextView r101 = this.f238118e;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public void ga0(T[] r100) {
        T[] r101 = this.f238119f;
        int r102 = 0;
        if (r101 == null) goto L12;
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L12;
        T r105 = r101[r104];
        if (r105 == null) goto L11;
        View r106 = X90(r105.getId());
        if (r106 == null) goto L11;
        r106.setVisibility(8);
    L11:
        r104 = r104 + 1;
    L12:
        int r107 = r100.length;
    L13:
        if (r102 >= r107) goto L18;
        T r108 = r100[r102];
        if (r108 == null) goto L17;
        U90(r108);
    L17:
        r102 = r102 + 1;
        goto L13
    }

    public static void ea0(View r100, boolean r101) {
        r100.setEnabled(r101);
        if ((r100 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        ea0(r102.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }

    public void ca0(String r100, String r101) {
        Z90().clickItem(r100, r101);
        if (ba0(r100) == true) goto L5;
        return;
    L5:
        if (W90(r100) == false) goto L9;
        V90();
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        if (getView() != null) goto L5;
    L11:
        Z90().getSubItems(Y90()).observe(this, new com.bytedance.ee.bear.sheet.panel.a(this));
        return;
    L5:
        if (getView().getRootView() == null) goto L11;
        SheetDragView r102 = (SheetDragView) getView().getRootView().findViewById(R.id.fab_dragview);
        View r103 = getView().findViewById(R.id.title_bar_layout);
        if (r102 == null) goto L11;
        if (r103 == null) goto L11;
        TextView r104 = (TextView) r103.findViewById(R.id.title);
        this.f238118e = r104;
        r104.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.f238118e.getPaint().setStrokeWidth(1.0f);
        r102.setSlideView(r103);
        r103.findViewById(R.id.back_icon).setOnClickListener(new c(this));
        goto L11
    }
}
