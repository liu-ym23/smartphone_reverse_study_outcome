package com.bytedance.ee.bear.document.editionmanager.panel;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.editionmanager.EditionViewModel;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import cu5.c;
import d15.b;
import d15.d;
import d15.e;
import d15.f;
import d15.g;
import d15.h;

/* JADX INFO: loaded from: classes16.dex */
public class EditionListFragment extends BaseDialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f219656o = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EditionViewModel f219657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SmartRefreshLayout f219658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f219659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f219660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f219661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f219662m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EditionPanelDragView f219663n;

    public EditionListFragment() {
    }

    public final void ba0(boolean r100) {
        RelativeLayout.LayoutParams r101 = (RelativeLayout.LayoutParams) this.f219663n.getLayoutParams();
        if (r100 == false) goto L5;
        r101.width = (int) (((double) c.d()) * 0.7d);
        r101.height = (int) (((double) c.c()) * 0.9d);
    L6:
        this.f219663n.setLayoutParams(r101);
        return;
    L5:
        r101.width = -1;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (r100.orientation != 2) goto L5;
        boolean r101 = true;
    L6:
        ba0(r101);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f219657h = (EditionViewModel) q.a(this, EditionViewModel.class);
        r100.setOnClickListener(new b(this));
        SmartRefreshLayout r102 = (SmartRefreshLayout) r100.findViewById(R.id.edition_list_refresh);
        this.f219658i = r102;
        boolean r103 = false;
        r102.A = false;
        boolean r104 = true;
        r102.g(true);
        this.f219658i.i(new f(this));
        this.f219658i.F(new EditionListMoreFooter(this.f219658i.getContext()), -2);
        this.f219659j = (LinearLayout) r100.findViewById(R.id.loading_ll);
        this.f219660k = (LinearLayout) r100.findViewById(R.id.loading_fail_ll);
        this.f219661l = (LinearLayout) r100.findViewById(R.id.loading_empty_ll);
        RecyclerView r105 = (RecyclerView) r100.findViewById(R.id.panel_edition_list);
        r105.setNestedScrollingEnabled(false);
        r105.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f219662m = new a(getActivity());
        String r106 = "";
        if (this.f219657h.getCurrEditionId() == null) goto L5;
        String r107 = this.f219657h.getCurrEditionId();
    L6:
        a r108 = this.f219662m;
        r108.f219672b = r107;
        r108.f219671a = new d(this);
        r105.setAdapter(r108);
        this.f219663n = (EditionPanelDragView) r100.findViewById(R.id.edition_drag_view);
        if (c.e(getActivity()) == true) goto L9;
    L11:
        r104 = false;
    L12:
        ba0(r104);
        if (this.f219657h.getCurrEditionId() == null) goto L16;
        r106 = this.f219657h.getCurrEditionId();
    L16:
        if (TextUtils.isEmpty(r106) == false) goto L18;
        this.f219663n.setTitle(getString(R.string.LarkCCM_Docx_VersionMgmt_View_SavedVs_Mob));
    L19:
        this.f219663n.setOnActionListener(new g(this));
        this.f219663n.setOnHeightChangeListener(new e(this));
        this.f219657h.setViewDelegate(new h(this));
        Bundle r109 = getArguments();
        if (r109 == null) goto L23;
        r103 = r109.getBoolean("isInForseti", false);
    L23:
        if (getActivity() != null) goto L25;
        return;
    L25:
        if (getActivity().getResources().getConfiguration().orientation == 2) goto L27;
        return;
    L27:
        if (getDialog() == null) goto L33;
        if (r103 == true) goto L34;
        getDialog().getWindow().addFlags(1024);
        return;
    L34:
        return;
    L33:
        return;
    L18:
        this.f219663n.setTitle(getString(R.string.LarkCCM_Docx_VersionMgmt_View_SwitchV_Mob));
        goto L19
    L9:
        if ((!ku5.c.k(getActivity())) == false) goto L11;
    L5:
        r107 = "";
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.docx_edition_list_fragment, r101, false);
    }
}
