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
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginInfoExtractException;
import com.bytedance.ee.bear.fabview.FabView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.cellcontent.SheetCellContentViewModel;
import com.bytedance.ee.bear.sheet.inputbar.SheetEditViewModel;
import com.bytedance.ee.bear.sheet.panel.oppanel.FabPanelViewModel;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class FabFragment extends BaseFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f237594u = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f237595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f237596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FabViewModel f237597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData f237598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LiveData<Boolean> f237599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveData<Boolean> f237600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveData<Boolean> f237601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MediatorLiveData<Boolean> f237602l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f237603m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f237604n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f237605o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f237606p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f237607q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f237608r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public pcb.a f237609s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f237610t;

    public class a implements ew4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FabFragment f237611a;

        public a(FabFragment r100) {
            this.f237611a = r100;
        }

        @Override // ew4.a
        public final void a(int r100) {
            FabFragment r101 = this.f237611a;
            r101.f237606p = r100 + UIUtils.dp2px(r101.requireContext(), 8.0f);
            com.bytedance.ee.util.ui.j.e(r101.f237607q);
            com.bytedance.ee.util.ui.j.d(r101.f237607q, 100);
        }

        @Override // ew4.a
        public final void b(boolean r100) {
            this.f237611a.f237603m = !r100;
            tt5.a.h("FabFragment", "onAIChatListFoldStatusChanged, isFold = " + r100);
            this.f237611a.W90();
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
        tt5.a.e("FabFragment", "findAsideCommentAnchorContainer: failed to get plugin host", e, false);
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f237603m = false;
        com.bytedance.ee.util.ui.j.e(this.f237607q);
        FabViewModel r100 = this.f237597g;
        if (r100 != null) goto L5;
    L7:
        View r101 = this.f237596f;
        if (r101 == null) goto L10;
        r101.removeOnLayoutChangeListener(this.f237608r);
        this.f237596f = null;
    L10:
        super.onDestroyView();
        return;
    L5:
        if (r100.getSheetFabConfig() == null) goto L7;
        this.f237597g.getSheetFabConfig().j(null);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W90() {
        boolean r100 = false;
        if (this.f237598h.getValue() != 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Boolean r102 = Boolean.TRUE;
        boolean r103 = r102.equals(this.f237599i.getValue());
        boolean r104 = r102.equals(this.f237600j.getValue());
        boolean r105 = r102.equals(this.f237601k.getValue());
        if (this.f237603m == false) goto L11;
        tt5.a.h("FabFragment", "notifyFabVisibleChanged hide fab by AI chat list expanded");
    L11:
        MediatorLiveData<Boolean> r106 = this.f237602l;
        if (r101 == true) goto L19;
        if (r103 == true) goto L19;
        if (r104 == true) goto L19;
        if (r105 == true) goto L19;
        if (this.f237603m == true) goto L19;
        r100 = true;
    L19:
        r106.setValue(Boolean.valueOf(r100));
        return;
    L5:
        if (((Integer) this.f237598h.getValue()).intValue() <= 0) goto L7;
        r101 = true;
        goto L8
    }

    public final void X90() {
        if (this.f237595e != null) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L22;
        View r100 = U90();
        int r101 = 0;
        if (r100 != null) goto L10;
    L12:
        ViewGroup.LayoutParams r102 = this.f237595e.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
        return;
    L15:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        int r104 = this.f237604n + r101;
        int r105 = r103.getMarginEnd();
        int r106 = r103.rightMargin;
        if (r105 != r104) goto L19;
        if (r106 != r104) goto L19;
        return;
    L19:
        r103.setMargins(r103.leftMargin, r103.topMargin, r104, r103.bottomMargin);
        r103.setMarginEnd(r104);
        this.f237595e.setLayoutParams(r103);
        return;
    L10:
        if (r100.getVisibility() != 0) goto L12;
        r101 = Math.max(r100.getWidth(), 0);
        goto L12
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.sheet.fab.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.sheet.fab.c] */
    public FabFragment() {
        this.f237604n = 0;
        this.f237605o = 0;
        this.f237606p = 0;
        this.f237607q = new b(this);
        this.f237608r = new c(this);
        this.f237610t = new a(this);
    }

    static {
    }

    public final FabView V90(FabItem.FabSheetItem r100) {
        tt5.a.b("FabFragment", "add fab: " + r100.getId());
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
        r102.setOnClickListener(new j(this, r100));
        r102.b(r102.getContext());
        return r102;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FabViewModel r101 = (FabViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabViewModel.class);
        this.f237597g = r101;
        r101.getTopItems().observe(this, new com.bytedance.ee.bear.sheet.fab.a(this));
        this.f237609s = pcb.a.AbstractC7181a.b(getActivity());
        this.f237599i = ((SheetCellContentViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, SheetCellContentViewModel.class)).getActive();
        this.f237600j = ((FabPanelViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabPanelViewModel.class)).getActive();
        this.f237601k = ((SheetEditViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, SheetEditViewModel.class)).getActive();
        this.f237598h = this.f237597g.getFabHideTime();
        MediatorLiveData<Boolean> r102 = new MediatorLiveData();
        this.f237602l = r102;
        r102.addSource(this.f237599i, new e(this));
        this.f237602l.addSource(this.f237600j, new f(this));
        this.f237602l.addSource(this.f237601k, new g(this));
        this.f237602l.addSource(this.f237597g.getFabHideTime(), new h(this));
        this.f237602l.observe(this, new k(this));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.fab_container);
        this.f237595e = r102;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        this.f237604n = ((ViewGroup.MarginLayoutParams) r103).getMarginEnd();
    L5:
        this.f237605o = this.f237595e.getPaddingBottom();
        FabViewModel r104 = this.f237597g;
        if (r104 != null) goto L8;
    L10:
        this.f237597g.getFabBottomOffset().observe(getViewLifecycleOwner(), new d(this));
        if (getActivity() == null) goto L21;
        View r105 = U90();
        View r106 = this.f237596f;
        if (r106 == r105) goto L21;
        if (r106 == null) goto L18;
        r106.removeOnLayoutChangeListener(this.f237608r);
        this.f237596f = null;
    L18:
        this.f237596f = r105;
        if (r105 == null) goto L21;
        r105.addOnLayoutChangeListener(this.f237608r);
    L21:
        X90();
        return;
    L8:
        if (r104.getSheetFabConfig() == null) goto L10;
        this.f237597g.getSheetFabConfig().j(this.f237610t);
        this.f237606p = this.f237597g.getSheetFabConfig().s() + UIUtils.dp2px(requireContext(), 8.0f);
        com.bytedance.ee.util.ui.j.e(this.f237607q);
        com.bytedance.ee.util.ui.j.d(this.f237607q, 100);
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.sheet_fab_layout, r101, false);
    }
}
