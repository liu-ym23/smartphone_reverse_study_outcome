package com.bytedance.ee.bear.sheet.fab;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginInfoExtractException;
import com.bytedance.ee.bear.fabview.FabView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.inputbar.OfficeSheetEditViewModel;
import com.bytedance.ee.bear.sheet.panel.oppanel.OfficeFabPanelViewModel;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class OfficeFabFragment extends BaseFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f237614t = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f237615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f237616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FabViewModel f237617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData f237618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LiveData<Boolean> f237619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveData<Boolean> f237620j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveData<Boolean> f237621k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MediatorLiveData<Boolean> f237622l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f237623m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f237624n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f237625o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final o f237626p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final p f237627q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public pcb.a f237628r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f237629s;

    public class a implements ew4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeFabFragment f237630a;

        @Override // ew4.a
        public final void b(boolean r100) {
        }

        public a(OfficeFabFragment r100) {
            this.f237630a = r100;
        }

        @Override // ew4.a
        public final void a(int r100) {
            OfficeFabFragment r101 = this.f237630a;
            r101.f237624n = r100;
            com.bytedance.ee.util.ui.j.e(r101.f237626p);
            com.bytedance.ee.util.ui.j.d(r101.f237626p, 100);
        }
    }

    public final View U90() {
        View r100 = null;
        PluginHost r101 = PluginHost.fromFragment(this);     // Catch: PluginInfoExtractException -> L19
        com.bytedance.ee.bear.browser.plugin.t r102 = r101.getUIContainer();
        if (r102 == null) goto L7;
        r100 = r102.findView(R.id.aside_comment_container);
    L7:
        if (r100 == null) goto L9;
        return r100;
    L9:
        if (r101.getActivity() != null) goto L11;
        return r100;
    L11:
        if (r101.getActivity().getWindow() == null) goto L26;
        View r103 = r101.getActivity().getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L18;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L18;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L18:
        return r103.findViewById(R.id.aside_comment_container);
    L26:
        return r100;
    L19:
        e = move-exception;
        tt5.a.e("OfficeFabFragment", "findAsideCommentAnchorContainer: failed to get plugin host", e, false);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W90() {
        boolean r100 = false;
        if (this.f237618h.getValue() != 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Boolean r102 = Boolean.TRUE;
        boolean r103 = r102.equals(this.f237619i.getValue());
        boolean r104 = r102.equals(this.f237620j.getValue());
        boolean r105 = r102.equals(this.f237621k.getValue());
        MediatorLiveData<Boolean> r106 = this.f237622l;
        if (r101 == true) goto L14;
        if (r103 == true) goto L14;
        if (r104 == true) goto L14;
        if (r105 == false) goto L14;
        r100 = true;
    L14:
        r106.setValue(Boolean.valueOf(r100));
        return;
    L5:
        if (((Integer) this.f237618h.getValue()).intValue() <= 0) goto L7;
        r101 = true;
        goto L8
    }

    public final void X90() {
        if (this.f237615e != null) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L22;
        View r100 = U90();
        int r101 = 0;
        if (r100 != null) goto L10;
    L12:
        ViewGroup.LayoutParams r102 = this.f237615e.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
        return;
    L15:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        int r104 = this.f237625o + r101;
        int r105 = r103.getMarginEnd();
        int r106 = r103.rightMargin;
        if (r105 != r104) goto L19;
        if (r106 != r104) goto L19;
        return;
    L19:
        r103.setMargins(r103.leftMargin, r103.topMargin, r104, r103.bottomMargin);
        r103.setMarginEnd(r104);
        this.f237615e.setLayoutParams(r103);
        return;
    L10:
        if (r100.getVisibility() != 0) goto L12;
        r101 = Math.max(r100.getWidth(), 0);
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        com.bytedance.ee.util.ui.j.e(this.f237626p);
        if (CCMOfficeSDKAssembleFG.a() == true) goto L9;
        FabViewModel r100 = this.f237617g;
        if (r100 == null) goto L9;
        if (r100.getSheetFabConfig() == null) goto L9;
        this.f237617g.getSheetFabConfig().j(null);
    L9:
        View r101 = this.f237616f;
        if (r101 == null) goto L12;
        r101.removeOnLayoutChangeListener(this.f237627q);
        this.f237616f = null;
    L12:
        super.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.sheet.fab.o] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.sheet.fab.p] */
    public OfficeFabFragment() {
        this.f237623m = 0;
        this.f237624n = 0;
        this.f237625o = 0;
        this.f237626p = new o(this);
        this.f237627q = new p(this);
        this.f237629s = new a(this);
    }

    static {
    }

    public final FabView V90(FabItem.FabSheetItem r100) {
        tt5.a.b("OfficeFabFragment", "add fab: " + r100.getId());
        Context r101 = getContext();
        Objects.requireNonNull(r101);
        FabView r102 = new FabView(r101);
        FabItemEnum r103 = FabItemEnum.valueOf(r100.getId());
        r102.setType(r103.type);
        r102.setImageRes(r103.imageRes);
        r102.setColorRes(r103.colorRes);
        r102.setImageTintRes(r103.imageTintColorRes);
        r102.setTextRes(r100.getTitle());
        r102.setTag(R.id.tag_id, r100.getId());
        r102.setTag(R.id.tag_title, r100.getTitle());
        r102.setTag(r100.getId());
        r102.setContentDescription(r100.getId());
        r102.setOnClickListener(new v(this, r100));
        r102.b(r102.getContext());
        return r102;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FabViewModel r101 = (FabViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabViewModel.class);
        this.f237617g = r101;
        r101.getTopItems().observe(this, new n(this));
        this.f237628r = pcb.a.AbstractC7181a.b(getActivity());
        this.f237619i = ((OfficeFabPanelViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, OfficeFabPanelViewModel.class)).getActive();
        this.f237620j = ((OfficeSheetEditViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, OfficeSheetEditViewModel.class)).getActive();
        this.f237618h = this.f237617g.getFabHideTime();
        this.f237621k = this.f237617g.getVisibleFromNative();
        MediatorLiveData<Boolean> r102 = new MediatorLiveData();
        this.f237622l = r102;
        r102.addSource(this.f237619i, new q(this));
        this.f237622l.addSource(this.f237620j, new r(this));
        this.f237622l.addSource(this.f237621k, new s(this));
        this.f237622l.addSource(this.f237617g.getFabHideTime(), new t(this));
        this.f237622l.observe(this, new w(this));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.fab_container);
        this.f237615e = r102;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        this.f237625o = ((ViewGroup.MarginLayoutParams) r103).getMarginEnd();
    L5:
        this.f237623m = this.f237615e.getPaddingBottom();
        if (getActivity() == null) goto L16;
        View r104 = U90();
        View r105 = this.f237616f;
        if (r105 == r104) goto L16;
        if (r105 == null) goto L13;
        r105.removeOnLayoutChangeListener(this.f237627q);
        this.f237616f = null;
    L13:
        this.f237616f = r104;
        if (r104 == null) goto L16;
        r104.addOnLayoutChangeListener(this.f237627q);
    L16:
        X90();
        this.f237617g.getFabBottomOffset().observe(getViewLifecycleOwner(), new m(this));
        if (CCMOfficeSDKAssembleFG.a() == false) goto L24;
        FabViewModel r106 = this.f237617g;
        if (r106 != null) goto L21;
        return;
    L21:
        if (r106.getSheetFabConfig() == null) goto L26;
        this.f237617g.getSheetFabConfig().j(this.f237629s);
        this.f237624n = this.f237617g.getSheetFabConfig().s();
        com.bytedance.ee.util.ui.j.e(this.f237626p);
        com.bytedance.ee.util.ui.j.d(this.f237626p, 100);
        return;
    L26:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.sheet_fab_layout, r101, false);
    }
}
