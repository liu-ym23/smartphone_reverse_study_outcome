package com.bytedance.ee.bear.bitable.card.view.form;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.performance.BitableCardMonitorTrace;
import com.bytedance.ee.bear.bitable.card.view.record.BaseCellAdapter;
import com.bytedance.ee.bear.bitable.card.view.record.CellListUtils;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.fab.FabVisibilityController;
import com.bytedance.ee.util.ui.j;
import com.larus.nova.R;
import gq4.t;
import hp4.u;
import jq4.k;
import jq4.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class FormView extends FrameLayout implements l, Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f208411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseCellAdapter f208412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FabVisibilityController f208413c;

    public interface a {
    }

    public class b extends RecyclerView.OnScrollListener implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f208414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FabVisibilityController f208415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f208416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f208417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f208418e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ruc.d f208419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ FormView f208420g;

        @Override // jq4.k
        public final void d(View r100, final u r101) {
            j.c(new gq4.u(this, r101));
        }

        @Override // jq4.k
        public final void f(View r100, u r101) {
            this.f208418e = false;
            this.f208415b.showFab();
        }

        public b(FormView r100, Context r101, FabVisibilityController r102) {
            this.f208420g = r100;
            this.f208417d = true;
            this.f208415b = r102;
            this.f208414a = r101;
            this.f208416c = ViewConfiguration.get(r101).getScaledTouchSlop();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView r100, int r101, int r102) {
            if (r102 != 0) goto L4;
            return;
        L4:
            boolean r103 = r100.canScrollVertically(-1);
            if (Math.abs(r102) > this.f208416c) goto L7;
            if (r103 == false) goto L7;
        L12:
            ruc.d r104 = this.f208419f;
            if (r104 == null) goto L17;
            if (r103 == true) goto L17;
            r104.f539335b.getView().setOnTouchListener(null);
            r104.f539335b.getView().setOverScrollMode(0);
            this.f208417d = true;
        L20:
            if (this.f208420g.f208412b.f208626g != null) goto L23;
            tt5.a.b("FormViewScrollListener", "no cell is in edit mode");
            rcb.c.c(this.f208414a);
            return;
        L23:
            return;
        L17:
            if (this.f208417d == false) goto L20;
            this.f208419f = new ruc.d(new suc.b(this.f208420g.f208411a));
            this.f208417d = false;
        L7:
            if (r102 < 0) goto L9;
        L11:
            this.f208415b.hideFab();
            goto L12
        L9:
            if (this.f208418e == true) goto L11;
            this.f208415b.showFab();
            goto L12
        }
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.n
    public final void a() {
    }

    @Override // jq4.l
    public final void b(EFieldUIType r100, String r101) {
    }

    @Override // jq4.l
    public final void c() {
    }

    @Override // jq4.l
    public final void d(String r100) {
    }

    @Override // jq4.l
    public final void e(l.a r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.n
    public final void f() {
    }

    @Override // android.view.View, com.bytedance.ee.bear.bitable.card.view.table.n
    public View getRootView() {
        return this;
    }

    public View getTitleBar() {
        return null;
    }

    @Override // jq4.l
    public final void h(boolean r100) {
    }

    @Override // jq4.l
    public final void i() {
    }

    @Override // jq4.l
    public final void k(boolean r100, ETableType r101, boolean r102) {
    }

    @Override // jq4.l
    public final void m(l.a r100) {
    }

    @Override // jq4.l
    public void setAddRecordTitleBarVisibility(Boolean r100) {
    }

    @Override // jq4.l
    public void setFiltered(boolean r100) {
    }

    @Override // jq4.l
    public void setHeaderColor(int r100) {
    }

    @Override // jq4.l
    public void setTableTitle(String r100) {
    }

    @Override // jq4.l
    public void setTitle(dp4.a r100) {
    }

    @Override // jq4.l
    public void setTitle(String r100) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f208412b.O2();
    }

    @Override // jq4.l
    public final void g(int r100) {
        this.f208411a.scrollToPosition(r100);
    }

    @Override // jq4.l
    public final void j(cp4.a r100) {
        this.f208412b.P2(r100);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Boolean r100) {
        this.f208412b.notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f208412b.L2(r100);
    }

    public FormView(Context r100, BitableCardViewModel r101, gp4.h r102) {
        super(r100);
        FabVisibilityController r103 = (FabVisibilityController) q.a(r102.getFragment(), FabVisibilityController.class);
        this.f208413c = r103;
        b r104 = new b(this, r100, r103);
        LayoutInflater.from(r100).inflate(R.layout.bitable_form_layout, this);
        RecyclerView r105 = (RecyclerView) findViewById(R.id.form_content_recycler);
        this.f208411a = r105;
        CellListUtils.a(r100, r105);
        this.f208411a.addItemDecoration(new FormItemDecoration());
        FormCellAdapter r106 = new FormCellAdapter(r101, r102, this.f208411a, r104);
        r106.setHasStableIds(true);
        r106.f208387q = new t(this);
        this.f208411a.setAdapter(r106);
        this.f208412b = r106;
        this.f208411a.addOnScrollListener(r104);
        r101.getIsSubmitResult().observe(r102.getFragment(), this);
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.view_forms_fps") == false) goto L6;
        BitableCardMonitorTrace r107 = r101.getMonitorTrace();
        RecyclerView r108 = this.f208411a;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "recyclerView");
        ((com.bytedance.ee.bear.bitable.statistic.c) r107.f207167l.getValue()).f(r108);
        return;
    }

    public FormView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
