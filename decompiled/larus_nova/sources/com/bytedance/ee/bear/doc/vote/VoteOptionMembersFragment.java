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
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class VoteOptionMembersFragment extends BaseFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f218414s = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f218415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f218416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public VoteOptionMemberAdapter f218417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SmartRefreshLayout f218418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EmptyView f218419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.ee.bear.facade.common.empty.c f218420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public VoteOptionMemberViewModel f218421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f218422l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f218423m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f218424n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f218425o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f218426p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f218427q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f218428r;

    public interface a {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f218415e = null;
        this.f218416f = null;
        this.f218417g = null;
        this.f218418h = null;
        this.f218419i = null;
        this.f218420j = null;
        super.onDestroyView();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        a r100 = this.f218428r;
        if (r100 == null) goto L5;
        OfficeVotePlugin.a(((com.bytedance.ee.bear.doc.vote.a) r100).f218432a);
        return true;
    L5:
        T90(0);
        return true;
    }

    public VoteOptionMembersFragment() {
        this.f218426p = "1";
        this.f218427q = false;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f218415e = (BaseTitleBar) r100.findViewById(R.id.vote_option_title_bar);
        this.f218418h = (SmartRefreshLayout) r100.findViewById(R.id.vote_option_members_refresh_layout);
        this.f218416f = (RecyclerView) r100.findViewById(R.id.vote_option_members_rv);
        this.f218419i = (EmptyView) r100.findViewById(R.id.vote_option_member_ev);
        Bundle r102 = getArguments();
        if (r102 != null) goto L5;
        tt5.a.k("VoteOptionMembersFragment", "initData: arguments is null");
    L6:
        BaseTitleBar r103 = this.f218415e;
        if (r103 == null) goto L9;
        Resources r104 = getResources();
        int r105 = this.f218422l;
        r103.setTitle(r104.getQuantityString(R.plurals.LarkCCM_Docx_Poll_VoteDetails_Header, r105, new Object[]{Integer.valueOf(r105)}));
        this.f218415e.setLeftClickListener(new q(this));
    L9:
        Context r106 = requireContext();
        Context r107 = r106.getApplicationContext();
        this.f218416f.setLayoutManager(new LinearLayoutManager(r106));
        VoteOptionMemberAdapter r108 = new VoteOptionMemberAdapter(r106);
        this.f218417g = r108;
        r108.f218384d = new r();
        this.f218416f.setAdapter(r108);
        this.f218418h.F(new LoadMoreFooter(r106), -2);
        this.f218418h.A = false;
        this.f218419i.setConfig(new VoteOptionMemberEmptyConfig(r107, ((i0) org.koin.java.a.a(i0.class)).a()).f218390c.invoke());
        this.f218420j = new com.bytedance.ee.bear.facade.common.empty.c(r107, getViewLifecycleOwner(), this.f218419i, this.f218418h);
        VoteOptionMemberViewModel r109 = (VoteOptionMemberViewModel) ViewModelProviders.of(this).get(VoteOptionMemberViewModel.class);
        this.f218421k = r109;
        r109.attach(new c(this.f218420j.f226424c, this.f218423m, this.f218424n, this.f218425o, this.f218426p, this.f218427q));
        this.f218421k.items().observe(getViewLifecycleOwner(), new s(this));
        this.f218421k.loadMoreState().observe(getViewLifecycleOwner(), new t(this));
        this.f218421k.count().observe(getViewLifecycleOwner(), new u(this));
        this.f218418h.i(new v(this));
        EmptyView r110 = this.f218419i;
        VoteOptionMemberViewModel r111 = this.f218421k;
        Objects.requireNonNull(r111);
        r110.setOnRetryListener(new n(r111));
        return;
    L5:
        this.f218423m = r102.getString(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID);
        this.f218424n = r102.getString(BitableResourceData.KEY_BLOCK_ID);
        this.f218425o = r102.getString("option_id");
        this.f218422l = r102.getInt("vote_count", 0);
        this.f218426p = r102.getString("offset", "1");
        this.f218427q = r102.getBoolean("isVoteDesc", false);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.activity_vote_option_members, r101, false);
    }
}
