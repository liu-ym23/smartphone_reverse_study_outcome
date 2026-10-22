package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseSubToolbarV2Fragment<T extends ToolbarV2> extends BaseFragment implements ocb.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f226215u = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f226216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f226217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f226218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f226219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BaseSubToolbarAdapter f226220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayoutManager f226221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f226222k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f226223l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f226224m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ItemV2 f226225n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f226226o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f226227p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f226228q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f226229r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public an4.a f226230s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public an4.b f226231t;

    public class a implements RecyclerViewScrollBottomListener.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseSubToolbarV2Fragment f226232a;

        public a(BaseSubToolbarV2Fragment r100) {
            this.f226232a = r100;
        }

        public final void a(int r100) {
            tt5.a.b("BaseSubToolbarV2Fragment", "onScrollToPosition: " + r100);
            if (r100 != 2) goto L5;
            BaseSubToolbarV2Fragment r101 = this.f226232a;
            int r102 = BaseSubToolbarV2Fragment.f226215u;
            r101.ha0(true);
            return;
        L5:
            BaseSubToolbarV2Fragment r103 = this.f226232a;
            int r104 = BaseSubToolbarV2Fragment.f226215u;
            r103.ha0(false);
        }
    }

    public abstract BaseToolbarV2PanelViewModel<T> Z90();

    public abstract BaseSubToolbarAdapter ca0();

    public void fa0(ItemV2[] r100) {
    }

    @Override // ocb.a
    public void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
    }

    static {
        f226215u = com.bytedance.ee.util.ui.n.d(9);
        com.bytedance.ee.util.ui.n.d(48);
    }

    public final BaseSubToolbarAdapter X90() {
        BaseSubToolbarAdapter r100 = this.f226220i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        BaseSubToolbarAdapter r101 = ca0();
        this.f226220i = r101;
        r101.f226207c = this.f226230s;
        r101.f226208d = this.f226231t;
        return r101;
    }

    public BaseSubToolbarV2Fragment() {
        this.f226222k = f226215u;
        this.f226226o = -1;
        this.f226227p = false;
    }

    public final int Y90() {
        T r100 = Z90().getToolbar().getValue();
        ItemV2.Children r101 = V90(r100);
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return 0;
    L6:
        return !r101.isHorizontal() ? 1 : 0;
    L7:
        return 0;
    }

    public void aa0() {
        BaseSubToolbarAdapter r100 = X90();
        this.f226220i = r100;
        this.f226217f.setAdapter(r100);
        LinearLayoutManager r101 = new LinearLayoutManager(getContext(), Y90(), false);
        this.f226221j = r101;
        this.f226217f.setLayoutManager(r101);
        BaseSubToolbarAdapter r102 = this.f226220i;
        r102.f226206b = new d(this);
        RecyclerViewScrollBottomListener r103 = new RecyclerViewScrollBottomListener();
        r103.f226266c = new a(this);
        this.f226217f.addOnScrollListener(r103);
    }

    public final void ba0() {
        if (getView() != null) goto L5;
        return;
    L5:
        int r100 = getView().getWidth();
        if (this.f226229r == false) goto L10;
        if (r100 != 0) goto L10;
        tt5.a.h("BaseSubToolbarV2Fragment", "fragmentWidth is zero!");
        getView().post(new e(this));
        return;
    L10:
        int r101 = this.f226217f.getMeasuredWidth();
        tt5.a.b("BaseSubToolbarV2Fragment", "width=> " + r101);
        if (r101 != 0) goto L13;
        return;
    L13:
        if (this.f226223l == r101) goto L15;
    L17:
        this.f226217f.post(new f(this));
        int r102 = 0;
        this.f226224m = false;
        this.f226223l = r101;
        if (this.f226229r == true) goto L21;
        r100 = com.bytedance.ee.util.ui.n.v();
    L21:
        int r103 = this.f226223l;
        int r104 = f226215u;
        int r105 = r104 * 2;
        int r106 = r100 - r105;
        if (r103 < r106) goto L52;
        this.f226228q = true;
        ItemV2[] r107 = X90().f226205a;
        int r108 = -1;
        if (r107 == null) goto L34;
        int r110 = 0;
    L28:
        if (r110 >= r107.length) goto L34;
        if (r107[r110].isSelected() == false) goto L32;
        r108 = r110;
    L32:
        r110 = r110 + 1;
    L34:
        if (r108 != (X90().f226205a.length - 1)) goto L36;
        boolean r109 = true;
    L37:
        ha0(r109);
        tt5.a.b("BaseSubToolbarV2Fragment", "suggestionWidth " + r106);
        if (r106 > 0) goto L40;
        return;
    L40:
        if (r106 < this.f226223l) goto L42;
        return;
    L42:
        if (this.f226229r == true) goto L48;
        ViewGroup.LayoutParams r111 = this.f226217f.getLayoutParams();
        if (r111 == null) goto L46;
        r111.width = r106;
        this.f226217f.requestLayout();
        this.f226223l = r111.width;
    L46:
        tt5.a.h("BaseSubToolbarV2Fragment", "width:" + this.f226223l + ", set suggestionWidth: " + r106);
    L48:
        if (this.f226229r == false) goto L52;
        View r112 = this.f226216e;
        r112.setPadding(0, r112.getPaddingTop(), this.f226216e.getPaddingRight(), this.f226216e.getPaddingBottom());
        return;
    L36:
        r109 = false;
    L52:
        if (this.f226229r == false) goto L54;
        this.f226228q = false;
        ha0(true);
    L54:
        int r113 = this.f226222k;
        int r114 = this.f226223l;
        int r115 = r114 / 2;
        int r116 = r113 - r115;
        int r117 = r115 + r113;
        if (r116 >= r104) goto L57;
    L59:
        if (r116 >= r104) goto L62;
    L67:
        tt5.a.h("BaseSubToolbarV2Fragment", "width:" + this.f226223l + ", posX:" + this.f226222k + ", paddingStart:" + r102);
        View r118 = this.f226216e;
        r118.setPadding(r102, r118.getPaddingTop(), this.f226216e.getPaddingRight(), this.f226216e.getPaddingBottom());
        return;
    L62:
        if (r117 <= (r100 - r104)) goto L67;
        if (this.f226229r == false) goto L66;
        r102 = (r100 - r114) - r105;
        goto L67
    L66:
        r102 = r100 - r114;
        goto L67
    L57:
        if (r117 > (r100 - r104)) goto L59;
        r102 = r116 - r104;
        goto L67
    L15:
        if (this.f226224m == true) goto L17;
    }

    public final boolean da0() {
        ItemV2 r100 = Z90().getExpandedSubToolbar().getValue();
        if (this.f226225n == null) goto L9;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.id() != this.f226225n.id()) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        pcb.a.AbstractC7181a.b(getActivity()).a(this);
    }

    public final void U90(Rect r100) {
        if (da0() == true) goto L5;
        return;
    L5:
        this.f226217f.measure(0, 0);
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.f226217f.getVisibility() == 0) goto L12;
        this.f226217f.setVisibility(0);
    L12:
        int r101 = r100.centerX();
        tt5.a.h("BaseSubToolbarV2Fragment", "new x:" + r101 + ", old x:" + this.f226222k);
        if (r101 == this.f226222k) goto L15;
    L16:
        this.f226227p = false;
        this.f226222k = r101;
        this.f226224m = true;
        ba0();
        return;
    L15:
        if (this.f226227p == true) goto L16;
    }

    public final ItemV2.Children V90(ToolbarV2 r100) {
        if (r100 != null) goto L4;
    L18:
        tt5.a.k("BaseSubToolbarV2Fragment", "toolbar data is null!");
        return null;
    L4:
        if (r100.getItems() == null) goto L18;
        if (r100.getItems().length <= 0) goto L18;
        ItemV2[] r101 = r100.getItems();
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L26;
        ItemV2 r104 = r101[r103];
        ItemV2 r105 = this.f226225n;
        if (r105 == null) goto L17;
        if (r105.getId().equals(r104.getId()) == false) goto L17;
        if (r104.getChildren() == null) goto L17;
        return r104.getChildren();
    L17:
        r103 = r103 + 1;
        goto L8
    L26:
        return null;
    }

    public final ItemV2[] W90(ToolbarV2 r100) {
        ItemV2.Children r101 = V90(r100);
        if (r101 != null) goto L5;
    L10:
        tt5.a.k("BaseSubToolbarV2Fragment", "children is null");
        return null;
    L5:
        if (r101.getItems() == null) goto L10;
        if (r101.getItems().length <= 0) goto L10;
        return r101.getItems();
    }

    public void ea0(ItemV2 r100) {
        ga0(r100, r100.getValue());
    }

    public final void ha0(boolean r100) {
        tt5.a.b("BaseSubToolbarV2Fragment", "setMaskVisibility, isScrollToBottom: " + r100 + ", isOverScreenWidth: " + this.f226228q);
        if (Y90() != 0) goto L11;
        if (this.f226228q == false) goto L11;
        if (r100 == false) goto L9;
        this.f226218g.setVisibility(0);
        this.f226219h.setVisibility(8);
        return;
    L9:
        this.f226218g.setVisibility(8);
        this.f226219h.setVisibility(0);
        return;
    L11:
        if (this.f226229r == false) goto L16;
        this.f226218g.setVisibility(8);
        this.f226219h.setVisibility(8);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        this.f226225n = (ItemV2) r101.getSerializable(ItemV2.class.getName());
    L5:
        pcb.a.AbstractC7181a.b(getActivity()).c(this);
        this.f226229r = ForsetiHelper.s(this);
    }

    public <V> void ga0(ItemV2 r100, V r101) {
        tt5.a.h("BaseSubToolbarV2Fragment", "processOnItemClick " + r100);
        Z90().processSubToolbarItemClick(r100.id(), r101, 2);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        aa0();
        final BaseToolbarV2PanelViewModel<T> r102 = Z90();
        r102.getSubToolbarV2Rect().observe(this, new b(this));
        r102.getToolbar().observe(this, new c(this, r102));
        U90(r102.getSubToolbarV2Rect().getValue());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.core_doc_sub_toolbar_layout, r101, false);
        this.f226217f = (RecyclerView) r103.findViewById(R.id.sub_toolbar_menu_list);
        View r104 = r103.findViewById(R.id.menu_parent);
        this.f226216e = r104;
        this.f226218g = r104.findViewById(R.id.mask_left);
        this.f226219h = this.f226216e.findViewById(R.id.mask_right);
        return r103;
    }
}
