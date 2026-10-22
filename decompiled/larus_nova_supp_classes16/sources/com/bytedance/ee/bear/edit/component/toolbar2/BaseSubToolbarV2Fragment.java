package com.bytedance.ee.bear.edit.component.toolbar2;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseSubToolbarV2Fragment<T extends ToolbarV2> extends BaseFragment implements ocb.a {
    public static final int s = 0;
    public View e;
    public RecyclerView f;
    public View g;
    public View h;
    public BaseSubToolbarAdapter i;
    public LinearLayoutManager j;
    public int k;
    public int l;
    public boolean m;
    public ItemV2 n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;

    public class a implements RecyclerViewScrollBottomListener.a {
        public final /* synthetic */ BaseSubToolbarV2Fragment a;

        public a(BaseSubToolbarV2Fragment r1) {
            this.a = r1;
        }

        public final void a(int r3) {
            tt5.a.b("BaseSubToolbarV2Fragment", "onScrollToPosition: " + r3);
            if (r3 != 2) goto L5;
            BaseSubToolbarV2Fragment r4 = this.a;
            int r0 = BaseSubToolbarV2Fragment.s;
            r4.ha0(true);
            return;
        L5:
            BaseSubToolbarV2Fragment r5 = this.a;
            int r1 = BaseSubToolbarV2Fragment.s;
            r5.ha0(false);
        }
    }

    public abstract BaseToolbarV2PanelViewModel<T> Z90();

    public abstract BaseSubToolbarAdapter ca0();

    public void fa0(ItemV2[] r1) {
    }

    public void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
    }

    static {
        s = com.bytedance.ee.util.ui.n.d(9);
        com.bytedance.ee.util.ui.n.d(48);
    }

    public final BaseSubToolbarAdapter X90() {
        BaseSubToolbarAdapter r0 = this.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        BaseSubToolbarAdapter r1 = ca0();
        this.i = r1;
        return r1;
    }

    public BaseSubToolbarV2Fragment() {
        this.k = s;
        this.o = -1;
        this.p = false;
    }

    public final int Y90() {
        ToolbarV2 r0 = (ToolbarV2) Z90().getToolbar().getValue();
        ItemV2.Children r1 = V90(r0);
        if (r0 == null) goto L7;
        if (r1 != null) goto L6;
        return 0;
    L6:
        return !r1.isHorizontal() ? 1 : 0;
    L7:
        return 0;
    }

    public void aa0() {
        BaseSubToolbarAdapter r0 = X90();
        this.i = r0;
        this.f.setAdapter(r0);
        LinearLayoutManager r1 = new LinearLayoutManager(getContext(), Y90(), false);
        this.j = r1;
        this.f.setLayoutManager(r1);
        BaseSubToolbarAdapter r2 = this.i;
        r2.b = new f(this);
        RecyclerViewScrollBottomListener r3 = new RecyclerViewScrollBottomListener();
        r3.c = new a(this);
        this.f.addOnScrollListener(r3);
    }

    public final void ba0() {
        if (getView() != null) goto L5;
        return;
    L5:
        int r0 = getView().getWidth();
        if (this.r == false) goto L10;
        if (r0 != 0) goto L10;
        tt5.a.h("BaseSubToolbarV2Fragment", "fragmentWidth is zero!");
        getView().post(new g(this));
        return;
    L10:
        int r1 = this.f.getMeasuredWidth();
        tt5.a.b("BaseSubToolbarV2Fragment", "width=> " + r1);
        if (r1 != 0) goto L13;
        return;
    L13:
        if (this.l == r1) goto L15;
    L17:
        this.f.post(new h(this));
        int r3 = 0;
        this.m = false;
        this.l = r1;
        if (this.r == true) goto L21;
        r0 = com.bytedance.ee.util.ui.n.v();
    L21:
        int r2 = this.l;
        int r4 = s;
        int r5 = r4 * 2;
        int r6 = r0 - r5;
        if (r2 < r6) goto L52;
        this.q = true;
        ItemV2[] r7 = X90().a;
        int r9 = -1;
        if (r7 == null) goto L34;
        int r10 = 0;
    L28:
        if (r10 >= r7.length) goto L34;
        if (r7[r10].isSelected() == false) goto L32;
        r9 = r10;
    L32:
        r10 = r10 + 1;
    L34:
        if (r9 != (X90().a.length - 1)) goto L36;
        boolean r8 = true;
    L37:
        ha0(r8);
        tt5.a.b("BaseSubToolbarV2Fragment", "suggestionWidth " + r6);
        if (r6 > 0) goto L40;
        return;
    L40:
        if (r6 < this.l) goto L42;
        return;
    L42:
        if (this.r == true) goto L48;
        ViewGroup.LayoutParams r11 = this.f.getLayoutParams();
        if (r11 == null) goto L46;
        r11.width = r6;
        this.f.requestLayout();
        this.l = r11.width;
    L46:
        tt5.a.h("BaseSubToolbarV2Fragment", "width:" + this.l + ", set suggestionWidth: " + r6);
    L48:
        if (this.r == false) goto L52;
        View r12 = this.e;
        r12.setPadding(0, r12.getPaddingTop(), this.e.getPaddingRight(), this.e.getPaddingBottom());
        return;
    L36:
        r8 = false;
    L52:
        if (this.r == false) goto L54;
        this.q = false;
        ha0(true);
    L54:
        int r13 = this.k;
        int r14 = this.l;
        int r16 = r14 / 2;
        int r17 = r13 - r16;
        int r18 = r16 + r13;
        if (r17 >= r4) goto L57;
    L59:
        if (r17 >= r4) goto L62;
    L67:
        tt5.a.h("BaseSubToolbarV2Fragment", "width:" + this.l + ", posX:" + this.k + ", paddingStart:" + r3);
        View r19 = this.e;
        r19.setPadding(r3, r19.getPaddingTop(), this.e.getPaddingRight(), this.e.getPaddingBottom());
        return;
    L62:
        if (r18 <= (r0 - r4)) goto L67;
        if (this.r == false) goto L66;
        r3 = (r0 - r14) - r5;
        goto L67
    L66:
        r3 = r0 - r14;
        goto L67
    L57:
        if (r18 > (r0 - r4)) goto L59;
        r3 = r17 - r4;
        goto L67
    L15:
        if (this.m == true) goto L17;
    }

    public final boolean da0() {
        ItemV2 r0 = (ItemV2) Z90().getExpandedSubToolbar().getValue();
        if (this.n == null) goto L9;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.id() != this.n.id()) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        pcb.a.a.b(getActivity()).a(this);
    }

    public final void U90(Rect r4) {
        if (da0() == true) goto L5;
        return;
    L5:
        this.f.measure(0, 0);
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.f.getVisibility() == 0) goto L12;
        this.f.setVisibility(0);
    L12:
        int r5 = r4.centerX();
        tt5.a.h("BaseSubToolbarV2Fragment", "new x:" + r5 + ", old x:" + this.k);
        if (r5 == this.k) goto L15;
    L16:
        this.p = false;
        this.k = r5;
        this.m = true;
        ba0();
        return;
    L15:
        if (this.p == true) goto L16;
    }

    public final ItemV2.Children V90(ToolbarV2 r6) {
        if (r6 != null) goto L4;
    L18:
        tt5.a.k("BaseSubToolbarV2Fragment", "toolbar data is null!");
        return null;
    L4:
        if (r6.getItems() == null) goto L18;
        if (r6.getItems().length <= 0) goto L18;
        ItemV2[] r7 = r6.getItems();
        int r0 = r7.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L26;
        ItemV2 r2 = r7[r1];
        ItemV2 r3 = this.n;
        if (r3 == null) goto L17;
        if (r3.getId().equals(r2.getId()) == false) goto L17;
        if (r2.getChildren() == null) goto L17;
        return r2.getChildren();
    L17:
        r1 = r1 + 1;
        goto L8
    L26:
        return null;
    }

    public final ItemV2[] W90(ToolbarV2 r2) {
        ItemV2.Children r3 = V90(r2);
        if (r3 != null) goto L5;
    L10:
        tt5.a.k("BaseSubToolbarV2Fragment", "children is null");
        return null;
    L5:
        if (r3.getItems() == null) goto L10;
        if (r3.getItems().length <= 0) goto L10;
        return r3.getItems();
    }

    public void ea0(ItemV2 r2) {
        ga0(r2, r2.getValue());
    }

    public final void ha0(boolean r3) {
        tt5.a.b("BaseSubToolbarV2Fragment", "setMaskVisibility, isScrollToBottom: " + r3 + ", isOverScreenWidth: " + this.q);
        if (Y90() != 0) goto L11;
        if (this.q == false) goto L11;
        if (r3 == false) goto L9;
        this.g.setVisibility(0);
        this.h.setVisibility(8);
        return;
    L9:
        this.g.setVisibility(8);
        this.h.setVisibility(0);
        return;
    L11:
        if (this.r == false) goto L16;
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        this.n = (ItemV2) r3.getSerializable(ItemV2.class.getName());
    L5:
        pcb.a.a.b(getActivity()).c(this);
        this.r = ForsetiHelper.s(this);
    }

    public <V> void ga0(ItemV2 r3, V r4) {
        tt5.a.h("BaseSubToolbarV2Fragment", "processOnItemClick " + r3);
        Z90().processSubToolbarItemClick(r3.id(), r4);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        aa0();
        final BaseToolbarV2PanelViewModel<T> r4 = Z90();
        r4.getSubToolbarV2Rect().observe(this, new d(this));
        r4.getToolbar().observe(this, new e(this, r4));
        U90((Rect) r4.getSubToolbarV2Rect().getValue());
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131560105, r3, false);
        this.f = r5.findViewById(2131387566);
        View r6 = r5.findViewById(2131379922);
        this.e = r6;
        this.g = r6.findViewById(2131379667);
        this.h = this.e.findViewById(2131379670);
        return r5;
    }
}
