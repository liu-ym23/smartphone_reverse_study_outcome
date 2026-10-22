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
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FabFragment extends BaseFragment {
    public static final /* synthetic */ int u = 0;
    public LinearLayout e;
    public View f;
    public FabViewModel g;
    public MutableLiveData h;
    public LiveData<Boolean> i;
    public LiveData<Boolean> j;
    public LiveData<Boolean> k;
    public MediatorLiveData<Boolean> l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public final b q;
    public final c r;
    public pcb.a s;
    public final a t;

    public class a implements ew4.a {
        public final /* synthetic */ FabFragment a;

        public a(FabFragment r1) {
            this.a = r1;
        }

        public final void a(int r4) {
            FabFragment r0 = this.a;
            r0.p = r4 + UIUtils.dp2px(r0.requireContext(), 8.0f);
            com.bytedance.ee.util.ui.j.e(r0.q);
            com.bytedance.ee.util.ui.j.d(r0.q, 100);
        }

        public final void b(boolean r3) {
            this.a.m = !r3;
            tt5.a.h("FabFragment", "onAIChatListFoldStatusChanged, isFold = " + r3);
            this.a.W90();
        }
    }

    public final View U90() {
        View r0 = null;
        PluginHost r1 = PluginHost.fromFragment(this);     // Catch: PluginInfoExtractException -> L19
        com.bytedance.ee.bear.browser.plugin.t r2 = r1.getUIContainer();
        if (r2 == null) goto L7;
        r0 = r2.findView(2131363249);
    L7:
        if (r0 == null) goto L9;
        return r0;
    L9:
        if (r1.getActivity() != null) goto L11;
        return r0;
    L11:
        if (r1.getActivity().getWindow() == null) goto L26;
        View r3 = r1.getActivity().getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L18:
        return r3.findViewById(2131363249);
    L26:
        return r0;
    L19:
        e = move-exception;
        tt5.a.e("FabFragment", "findAsideCommentAnchorContainer: failed to get plugin host", e, false);
        return null;
    }

    public final void onDestroyView() {
        this.m = false;
        com.bytedance.ee.util.ui.j.e(this.q);
        FabViewModel r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        View r1 = this.f;
        if (r1 == null) goto L10;
        r1.removeOnLayoutChangeListener(this.r);
        this.f = null;
    L10:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        return;
    L5:
        if (r0.getSheetFabConfig() == null) goto L7;
        this.g.getSheetFabConfig().j(null);
        goto L7
    }

    public final void W90() {
        boolean r1 = false;
        if (this.h.getValue() != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Boolean r3 = Boolean.TRUE;
        boolean r4 = r3.equals(this.i.getValue());
        boolean r5 = r3.equals(this.j.getValue());
        boolean r6 = r3.equals(this.k.getValue());
        if (this.m == false) goto L11;
        tt5.a.h("FabFragment", "notifyFabVisibleChanged hide fab by AI chat list expanded");
    L11:
        MediatorLiveData<Boolean> r7 = this.l;
        if (r0 == true) goto L19;
        if (r4 == true) goto L19;
        if (r5 == true) goto L19;
        if (r6 == true) goto L19;
        if (this.m == true) goto L19;
        r1 = true;
    L19:
        r7.setValue(Boolean.valueOf(r1));
        return;
    L5:
        if (((Integer) this.h.getValue()).intValue() <= 0) goto L7;
        r0 = true;
        goto L8
    }

    public final void X90() {
        if (this.e != null) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L22;
        View r0 = U90();
        int r1 = 0;
        if (r0 != null) goto L10;
    L12:
        ViewGroup.LayoutParams r2 = this.e.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
        return;
    L15:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        int r4 = this.n + r1;
        int r5 = r3.getMarginEnd();
        int r6 = r3.rightMargin;
        if (r5 != r4) goto L19;
        if (r6 != r4) goto L19;
        return;
    L19:
        r3.setMargins(r3.leftMargin, r3.topMargin, r4, r3.bottomMargin);
        r3.setMarginEnd(r4);
        this.e.setLayoutParams(r3);
        return;
    L10:
        if (r0.getVisibility() != 0) goto L12;
        r1 = Math.max(r0.getWidth(), 0);
        goto L12
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.sheet.fab.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.sheet.fab.c] */
    public FabFragment() {
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = new b(this);
        this.r = new c(this);
        this.t = new a(this);
    }

    static {
    }

    public final FabView V90(FabItem.FabSheetItem r4) {
        tt5.a.b("FabFragment", "add fab: " + r4.getId());
        Context r1 = getContext();
        Objects.requireNonNull(r1);
        FabView r0 = new FabView(r1);
        FabItemEnum r2 = FabItemEnum.valueOf(r4.getId());
        r0.setType(r2.type);
        r0.setImageRes(r2.imageRes);
        r0.setColorRes(r2.colorRes);
        r0.setImageTintRes(r2.imageTintColorRes);
        r0.setTextRes(r4.getTitle());
        r0.setTag(2131388099, r4.getId());
        r0.setTag(2131388141, r4.getTitle());
        r0.setTag(r4.getId());
        r0.setContentDescription(r4.getId());
        r0.setOnClickListener(new j(this, r4));
        r0.b(r0.getContext());
        return r0;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FabViewModel r4 = (FabViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabViewModel.class);
        this.g = r4;
        r4.getTopItems().observe(this, new com.bytedance.ee.bear.sheet.fab.a(this));
        this.s = pcb.a.a.b(getActivity());
        this.i = com.bytedance.ee.bear.browser.plugin.q.a(this, SheetCellContentViewModel.class).getActive();
        this.j = com.bytedance.ee.bear.browser.plugin.q.a(this, FabPanelViewModel.class).getActive();
        this.k = com.bytedance.ee.bear.browser.plugin.q.a(this, SheetEditViewModel.class).getActive();
        this.h = this.g.getFabHideTime();
        MediatorLiveData<Boolean> r5 = new MediatorLiveData();
        this.l = r5;
        r5.addSource(this.i, new e(this));
        this.l.addSource(this.j, new f(this));
        this.l.addSource(this.k, new g(this));
        this.l.addSource(this.g.getFabHideTime(), new h(this));
        this.l.observe(this, new k(this));
    }

    public final void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        LinearLayout r5 = (LinearLayout) r3.findViewById(2131372038);
        this.e = r5;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        this.n = ((ViewGroup.MarginLayoutParams) r6).getMarginEnd();
    L5:
        this.o = this.e.getPaddingBottom();
        FabViewModel r7 = this.g;
        if (r7 != null) goto L8;
    L10:
        this.g.getFabBottomOffset().observe(getViewLifecycleOwner(), new d(this));
        if (getActivity() == null) goto L21;
        View r8 = U90();
        View r9 = this.f;
        if (r9 == r8) goto L21;
        if (r9 == null) goto L18;
        r9.removeOnLayoutChangeListener(this.r);
        this.f = null;
    L18:
        this.f = r8;
        if (r8 == null) goto L21;
        r8.addOnLayoutChangeListener(this.r);
    L21:
        X90();
        return;
    L8:
        if (r7.getSheetFabConfig() == null) goto L10;
        this.g.getSheetFabConfig().j(this.t);
        this.p = this.g.getSheetFabConfig().s() + UIUtils.dp2px(requireContext(), 8.0f);
        com.bytedance.ee.util.ui.j.e(this.q);
        com.bytedance.ee.util.ui.j.d(this.q, 100);
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564549, r3, false);
    }
}
