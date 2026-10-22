package com.bytedance.ee.bear.doc.vote;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.empty.Config;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VoteOptionMembersFragment extends BaseFragment {
    public static final /* synthetic */ int s = 0;
    public BaseTitleBar e;
    public RecyclerView f;
    public VoteOptionMemberAdapter g;
    public SmartRefreshLayout h;
    public EmptyView i;
    public com.bytedance.ee.bear.facade.common.empty.c j;
    public VoteOptionMemberViewModel k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;
    public boolean q;
    public a r;

    public interface a {
    }

    public final void onDestroyView() {
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        super.onDestroyView();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        a r0 = this.r;
        if (r0 == null) goto L5;
        OfficeVotePlugin.a(((com.bytedance.ee.bear.doc.vote.a) r0).a);
        return true;
    L5:
        T90(0);
        return true;
    }

    public VoteOptionMembersFragment() {
        this.p = DiagramData$RESULT.SUCCESS;
        this.q = false;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r8, Bundle r9) {
        super.onViewCreated(r8, r9);
        this.e = r8.findViewById(2131392806);
        this.h = r8.findViewById(2131392803);
        this.f = r8.findViewById(2131392804);
        this.i = (EmptyView) r8.findViewById(2131392802);
        Bundle r10 = getArguments();
        if (r10 != null) goto L5;
        tt5.a.k("VoteOptionMembersFragment", "initData: arguments is null");
    L6:
        BaseTitleBar r11 = this.e;
        if (r11 == null) goto L9;
        Resources r0 = getResources();
        int r1 = this.l;
        r11.setTitle(r0.getQuantityString(2131755034, r1, new Object[]{Integer.valueOf(r1)}));
        this.e.setLeftClickListener(new q(this));
    L9:
        Context r12 = requireContext();
        Context r2 = r12.getApplicationContext();
        this.f.setLayoutManager(new LinearLayoutManager(r12));
        VoteOptionMemberAdapter r3 = new VoteOptionMemberAdapter(r12);
        this.g = r3;
        r3.d = new r();
        this.f.setAdapter(r3);
        this.h.F(new LoadMoreFooter(r12), -2);
        this.h.A = false;
        this.i.setConfig((Config) new VoteOptionMemberEmptyConfig(r2, ((i0) org.koin.java.a.a(i0.class)).a()).c.invoke());
        this.j = new com.bytedance.ee.bear.facade.common.empty.c(r2, getViewLifecycleOwner(), this.i, this.h);
        VoteOptionMemberViewModel r13 = (VoteOptionMemberViewModel) ViewModelProviders.of(this).get(VoteOptionMemberViewModel.class);
        this.k = r13;
        r13.attach(new c(this.j.c, this.m, this.n, this.o, this.p, this.q));
        this.k.items().observe(getViewLifecycleOwner(), new s(this));
        this.k.loadMoreState().observe(getViewLifecycleOwner(), new t(this));
        this.k.count().observe(getViewLifecycleOwner(), new u(this));
        this.h.i(new v(this));
        EmptyView r14 = this.i;
        VoteOptionMemberViewModel r16 = this.k;
        Objects.requireNonNull(r16);
        r14.setOnRetryListener(new n(r16));
        return;
    L5:
        this.m = r10.getString("page_id");
        this.n = r10.getString("block_id");
        this.o = r10.getString("option_id");
        this.l = r10.getInt("vote_count", 0);
        this.p = r10.getString("offset", DiagramData$RESULT.SUCCESS);
        this.q = r10.getBoolean("isVoteDesc", false);
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131558527, r3, false);
    }
}
