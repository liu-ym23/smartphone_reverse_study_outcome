package com.bytedance.ee.bear.bitable.card.view;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.card.viewmodel.t;
import com.bytedance.ee.bear.bitable.common.WatermarkUtils;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.loading.BitableLoadingWrapper;
import com.bytedance.ee.bear.bitable.loading.ELoadingType;
import com.bytedance.ee.bear.bitable.utils.g;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.n;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.slideback.SlideFrameLayout;
import com.ss.android.lark.utils.StatusBarUtil;
import cp4.b;
import gp4.c;
import gp4.e;
import gp4.f;
import io.supercharge.shimmerlayout.ShimmerLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;
import sa5.d;
import sa5.m;
import sa5.v;
import sa5.w;

/* JADX INFO: loaded from: classes15.dex */
public class BitableCardFragment extends BaseFragment implements t, com.bytedance.ee.bear.bitable.loading.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f207201t = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitableCardStackLayout f207202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f207203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BitableCardViewModel f207204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gp4.a f207205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BitableAnalytic f207206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DocViewModel f207207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<d> f207208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<w> f207209l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public v f207210m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public gp4.d f207211n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f207212o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f207213p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ShimmerLayout f207214q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f207215r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f207216s;

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final boolean A30() {
        return false;
    }

    @Override // du4.c
    public final void ZX() {
    }

    @Override // com.bytedance.ee.bear.bitable.card.viewmodel.t
    public final void st(b r100, String r101) {
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final void Nr() {
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.old.form.view.accelerate.v1") == false) goto L6;
        aS(BitableLoadingWrapper.LoadingState.SUC);
        return;
    }

    public final boolean U90() {
        BitableCardViewModel r100 = this.f207204g;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isNormalRecordShow() == false) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        int r100 = ((ArrayList) this.f207208k).size() - 1;
    L3:
        if (r100 < 0) goto L9;
        if (((d) ListProtector.get(this.f207208k, r100)).onBackPressed() == true) goto L6;
        r100 = r100 - 1;
        goto L3
    L6:
        tt5.a.h("BitableCardFragment", "onBackPressed intercept");
        return true;
    L9:
        return false;
    }

    public BitableCardFragment() {
        this.f207208k = new ArrayList();
        this.f207209l = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.ee.bear.contract.d r100 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        DocViewModel r101 = this.f207207j;
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        r100.s("bitable_show_card", r102);
        return;
    L5:
        r102 = r101.getToken();
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        V90(true);
        BitableCardViewModel r100 = this.f207204g;
        if (r100 == null) goto L6;
        r100.unregisterTableChangedObserver(this);
        this.f207204g.connectTableDataView(null);
        this.f207204g.clearMembrane();
        this.f207204g.getRecordContext().j(this.f207204g.getShowingTable());
    L6:
        if (U90() == true) goto L8;
        tt5.a.h("BitableCardFragment", "record page reset firstRecordPageDrew");
        this.f207204g.getFirstRecordPageDrew().removeObservers(getViewLifecycleOwner());
        this.f207204g.getFirstRecordPageDrew().setValue(Boolean.FALSE);
        this.f207204g.setIsNormalRecordShow(false);
    L8:
        v r101 = this.f207210m;
        if (r101 == null) goto L12;
        r101.b(this.f207211n);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (isRemoving() == false) goto L22;
        Fragment r100 = getParentFragment();
    L5:
        if (r100 == null) goto L10;
        if ((r100 instanceof n) == true) goto L8;
        r100 = r100.getParentFragment();
        goto L5
    L8:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L14;
        r100 = null;
    L14:
        if (r100 == null) goto L24;
        WindowInsetsUtils.b(r100).c(this.f207215r);
        WindowInsetsUtils.b(r100).b(this.f207216s);
        View r102 = r100.getView();
        if (r102 == null) goto L23;
        r102.requestApplyInsets();
        return;
    L23:
        return;
    L24:
        return;
    L10:
        r101 = false;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (g.b() == false) goto L14;
        View r100 = this.f207212o;
        if (r100 != null) goto L7;
        return;
    L7:
        if ((r100 instanceof FrameLayout) == false) goto L16;
        BitableCardViewModel r101 = this.f207204g;
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.getSrcObjInfo() == null) goto L18;
        mr4.a r102 = this.f207204g.getSrcObjInfo();
        int r103 = WatermarkUtils.f209802a;
        WatermarkUtils.b(r102, (FrameLayout) this.f207212o);
        return;
    L18:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final ELoadingType getLoadingType() {
        return ELoadingType.GLOBAL;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final View getLoadingView() {
        return this.f207214q;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final void TQ(View r100) {
        if (U90() == false) goto L6;
        return;
    L6:
        if ((this.f207212o instanceof FrameLayout) == true) goto L9;
        return;
    L9:
        if (Boolean.TRUE.equals(this.f207204g.getFirstRecordPageDrew().getValue()) == false) goto L13;
        tt5.a.h("BitableCardFragment", "first frame has drew");
        return;
    L13:
        if (this.f207214q != null) goto L15;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f207214q = du4.b.a(this, r100, null);
    L15:
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout) this.f207212o).addView(this.f207214q, r101);
    }

    public final void V90(boolean r100) {
        FragmentActivity r101 = getActivity();
        if (r101 != null) goto L5;
        return;
    L5:
        View r102 = r101.findViewById(R.id.content);
        if ((r102.getParent() instanceof SlideFrameLayout) == false) goto L9;
        ((SlideFrameLayout) r102.getParent()).setSlideable(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.loading.a
    public final void aS(BitableLoadingWrapper.LoadingState r100) {
        if (U90() == false) goto L5;
        return;
    L5:
        ShimmerLayout r101 = this.f207214q;
        if (r101 != null) goto L8;
        return;
    L8:
        View r102 = this.f207212o;
        if ((r102 instanceof FrameLayout) == false) goto L12;
        ((FrameLayout) r102).removeView(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.viewmodel.t
    public final void bU(boolean r100) {
        a r101 = this.f207203f;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f207225e == r100) goto L13;
        r101.f207225e = r100;
        if (r100 == true) goto L12;
        r101.a();
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        MutableLiveData<Boolean> r101 = this.f207204g.getLandscape();
        if (r100.orientation != 2) goto L5;
        boolean r102 = true;
    L6:
        r101.setValue(Boolean.valueOf(r102));
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).k("bitable_show_card");
        BitableCardViewModel r101 = (BitableCardViewModel) q.a(this, BitableCardViewModel.class);
        this.f207204g = r101;
        MutableLiveData<Boolean> r102 = r101.getLandscape();
        if (getResources().getConfiguration().orientation != 2) goto L5;
        boolean r103 = true;
    L6:
        r102.setValue(Boolean.valueOf(r103));
        this.f207207j = (DocViewModel) q.a(this, DocViewModel.class);
        BitableAnalytic r104 = this.f207204g.getBitableAnalytic();
        this.f207206i = r104;
        this.f207205h = new gp4.a(this, this.f207207j, this.f207204g, r104, this.f207208k, this.f207209l);
        this.f207210m = (v) m.a.a(getActivity(), v.class);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // du4.c
    public final void xr(View r100) {
        aS(BitableLoadingWrapper.LoadingState.FAIL);
    }

    @Override // com.bytedance.ee.bear.bitable.card.viewmodel.t
    public final void kY(int r100, b r101) {
        tt5.a.h("BitableCardFragment", "onTableContentUpdated()..., tableIndex = " + r100);
        a r102 = this.f207203f;
        if (r102 == null) goto L17;
        if (r100 < 0) goto L21;
        Stack<M> r103 = r102.f207222b;
        if (r103 != 0) goto L9;
        return;
    L9:
        if (r102.f207221a.size() > r100) goto L11;
        return;
    L11:
        if (r103.size() > r100) goto L13;
        return;
    L13:
        if (r102.f207224d.contains(Integer.valueOf(r100)) == true) goto L15;
        r102.f207224d.add(Integer.valueOf(r100));
    L15:
        r102.a();
        return;
    L21:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [gp4.d, sa5.w] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        this.f207202e = (BitableCardStackLayout) r100.findViewById(com.larus.nova.R.id.stack_layout);
        a r102 = new a(this.f207204g, this.f207205h);
        this.f207203f = r102;
        this.f207202e.setAdapter(r102);
        xN(0, this.f207204g.getTableStack().size(), this.f207204g.getTableStack(), false);
        r100.post(new gp4.b());
        b r103 = this.f207204g.getShowingTable();
        if (r103 == null) goto L5;
        boolean r104 = r103.g();
    L6:
        boolean r105 = true;
        V90(!r104);
        BitableCardViewModel r106 = this.f207204g;
        if (r106 == null) goto L9;
        r106.registerTableChangedObserver(this);
        this.f207204g.connectTableDataView(new c(this));
    L9:
        ?? r107 = new gp4.d(this);
        this.f207211n = r107;
        v r108 = this.f207210m;
        if (r108 == 0) goto L12;
        r108.c(r107);
    L12:
        TQ(this.f207213p);
        if (U90() == true) goto L16;
        this.f207204g.getFirstRecordPageDrew().observe(getViewLifecycleOwner(), new f(this));
    L16:
        BitableCardViewModel r109 = this.f207204g;
        if (r109 == null) goto L19;
        r109.getRecordContext().i(this.f207204g.getShowingTable());
    L19:
        Fragment r110 = getParentFragment();
    L20:
        if (r110 == null) goto L25;
        if ((r110 instanceof n) == true) goto L26;
        r110 = r110.getParentFragment();
    L26:
        if (r105 == true) goto L29;
        r110 = null;
    L29:
        if (r110 == null) goto L35;
        this.f207215r = WindowInsetsUtils.b(r110).e();
        this.f207216s = WindowInsetsUtils.b(r110).a();
        WindowInsetsUtils.b(r110).c(false);
        WindowInsetsUtils.b(r110).b(0);
        return;
    L35:
        return;
    L25:
        r105 = false;
        goto L26
    L5:
        r104 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.f207212o = r100.inflate(com.larus.nova.R.layout.bitable_card_fragment, r101, false);
        Context r103 = requireContext();
        if (U90() == true) goto L10;
        View r104 = r100.inflate(com.larus.nova.R.layout.bitable_record_content_loading_skeleton, null);
        this.f207213p = r104;
        View r105 = r104.findViewById(com.larus.nova.R.id.loading_close);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof LinearLayout.LayoutParams) == false) goto L8;
        int r107 = StatusBarUtil.getStatusBarHeight(r103);
        ((LinearLayout.LayoutParams) r106).topMargin = r107;
    L8:
        r105.setOnClickListener(new e(this, r103));
    L10:
        return this.f207212o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.bitable.card.viewmodel.t
    public final void xN(int r100, int r101, Stack<b> r102, boolean r110) {
        tt5.a.h("BitableCardFragment", "onTableCountChanged()..., oldCount = " + r100 + ", newCount = " + r101);
        a r103 = this.f207203f;
        if (r103 == null) goto L19;
        Intrinsics.checkNotNullParameter(r102, "newData");
        r103.f207222b = r102;
        BitableCardStackLayout.a.InterfaceC2990a r104 = r103.f207223c;
        if (r104 == null) goto L10;
        if (r100 >= r101) goto L8;
        r104.a(r101 - r100);
        goto L10
    L8:
        if (r100 <= r101) goto L10;
        r104.b(r100 - r101);
    L10:
        int r105 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.record.view.twinkle") == false) goto L19;
        if (r101 < 1) goto L15;
        boolean r106 = true;
    L17:
        if ((r110 & r106) == false) goto L19;
        int r107 = r101 - 1;
        kY(r107, (b) r102.get(r107));
        goto L19
    L15:
        r106 = false;
    L19:
        b r108 = this.f207204g.getShowingTable();
        if (r108 == null) goto L23;
        BitableAnalytic r109 = this.f207206i;
        String r111 = r108.f464658b;
        String r112 = r108.f464660d;
        cp4.c r113 = r108.f464664h;
        r109.N(r111, r112, r113.f464684b, r113.f464686d, r108.f464663g.toString());
        return;
    }
}
