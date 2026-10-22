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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import cu5.c;
import d15.b;
import d15.d;
import d15.e;
import d15.f;
import d15.g;
import d15.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditionListFragment extends BaseDialogFragment {
    public static final /* synthetic */ int o = 0;
    public EditionViewModel h;
    public SmartRefreshLayout i;
    public LinearLayout j;
    public LinearLayout k;
    public LinearLayout l;
    public a m;
    public EditionPanelDragView n;

    public EditionListFragment() {
    }

    public final void ba0(boolean r6) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        if (r6 == false) goto L5;
        r0.width = (int) (((double) c.d()) * 0.7d);
        r0.height = (int) (((double) c.c()) * 0.9d);
    L6:
        this.n.setLayoutParams(r0);
        return;
    L5:
        r0.width = -1;
        goto L6
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        if (r2.orientation != 2) goto L5;
        boolean r3 = true;
    L6:
        ba0(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r6, Bundle r7) {
        super.onViewCreated(r6, r7);
        this.h = (EditionViewModel) q.a(this, EditionViewModel.class);
        r6.setOnClickListener(new b(this));
        SmartRefreshLayout r8 = r6.findViewById(2131371478);
        this.i = r8;
        boolean r0 = false;
        r8.A = false;
        boolean r1 = true;
        r8.g(true);
        this.i.i(new f(this));
        this.i.F(new EditionListMoreFooter(this.i.getContext()), -2);
        this.j = (LinearLayout) r6.findViewById(2131379047);
        this.k = (LinearLayout) r6.findViewById(2131379025);
        this.l = (LinearLayout) r6.findViewById(2131379020);
        RecyclerView r9 = r6.findViewById(2131381870);
        r9.setNestedScrollingEnabled(false);
        r9.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.m = new a(getActivity());
        String r3 = "";
        if (this.h.getCurrEditionId() == null) goto L5;
        String r2 = this.h.getCurrEditionId();
    L6:
        a r4 = this.m;
        r4.b = r2;
        r4.a = new d(this);
        r9.setAdapter(r4);
        this.n = (EditionPanelDragView) r6.findViewById(2131371477);
        if (c.e(getActivity()) == true) goto L9;
    L11:
        r1 = false;
    L12:
        ba0(r1);
        if (this.h.getCurrEditionId() == null) goto L16;
        r3 = this.h.getCurrEditionId();
    L16:
        if (TextUtils.isEmpty(r3) == false) goto L18;
        this.n.setTitle(getString(2131889378));
    L19:
        this.n.setOnActionListener(new g(this));
        this.n.setOnHeightChangeListener(new e(this));
        this.h.setViewDelegate(new h(this));
        Bundle r10 = getArguments();
        if (r10 == null) goto L23;
        r0 = r10.getBoolean("isInForseti", false);
    L23:
        if (getActivity() != null) goto L25;
        return;
    L25:
        if (getActivity().getResources().getConfiguration().orientation == 2) goto L27;
        return;
    L27:
        if (getDialog() == null) goto L33;
        if (r0 == true) goto L34;
        getDialog().getWindow().addFlags(1024);
        return;
    L34:
        return;
    L33:
        return;
    L18:
        this.n.setTitle(getString(2131889380));
        goto L19
    L9:
        if ((!ku5.c.k(getActivity())) == false) goto L11;
    L5:
        r2 = "";
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131560131, r3, false);
    }
}
