package com.bytedance.ee.bear.middleground.record.viewhistory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import faceverify.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import nu5.a;
import zi5.b;
import zi5.c;
import zi5.d;
import zi5.e;

/* JADX INFO: loaded from: classes18.dex */
public class ViewHistoryFragment extends BaseFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f234360q = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f234361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f234362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f234363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SmartRefreshLayout f234364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f234365i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BaseTitleBar f234366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SpaceEmptyState f234367k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewHistoryAdapter f234368l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<RecordListResult.a> f234369m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f234370n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LottieAnimationView f234371o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewHistoryViewModel f234372p;

    public final void U90() {
        this.f234367k.setVisibility(0);
        this.f234367k.setTitle("");
        this.f234367k.setDesc("");
        this.f234367k.setPrimaryText("");
        this.f234367k.setImageRes(null);
    }

    public final void dismissLoading() {
        this.f234371o.cancelAnimation();
        this.f234371o.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ViewHistoryViewModel.b r100 = this.f234372p.getmLoadingMoreState().getValue();
        Objects.requireNonNull(r100);
        if (r100.f234374a != 9) goto L6;
        U90();
        this.f234372p.pull();
        return;
    }

    static {
    }

    public ViewHistoryFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        this.f234361e = r101.getInt("TYPE", 0);
        this.f234362f = r101.getString(q.KEY_TOKEN, "");
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f234363g = (RecyclerView) r100.findViewById(R.id.read_record_recycler_view);
        this.f234366j = (BaseTitleBar) r100.findViewById(R.id.titleBar);
        this.f234364h = (SmartRefreshLayout) r100.findViewById(R.id.read_record_refresh_layout);
        this.f234365i = (TextView) r100.findViewById(R.id.hidden);
        this.f234367k = (SpaceEmptyState) r100.findViewById(R.id.read_record_found_empty_state);
        this.f234371o = (LottieAnimationView) r100.findViewById(R.id.read_record_loading);
        a.a((ImageView) r100.findViewById(R.id.icon), 17, 17);
        this.f234367k.setVisibility(0);
        this.f234370n = 1;
        ViewHistoryViewModel r102 = (ViewHistoryViewModel) ViewModelProviders.of(this).get(ViewHistoryViewModel.class);
        this.f234372p = r102;
        r102.attach(this.f234362f, this.f234361e);
        this.f234372p.pull();
        this.f234372p.getResultMutableLiveData().observe(getViewLifecycleOwner(), new b(this));
        this.f234372p.getmLoadingMoreState().observe(getViewLifecycleOwner(), new c(this));
        this.f234369m = new ArrayList();
        this.f234364h.g(true);
        this.f234364h.F(new LoadMoreFooter(getContext()), -2);
        LinearLayoutManager r103 = new LinearLayoutManager(getContext());
        this.f234363g.setLayoutManager(r103);
        getContext();
        ViewHistoryAdapter r104 = new ViewHistoryAdapter(this.f234369m);
        this.f234368l = r104;
        this.f234363g.setAdapter(r104);
        this.f234364h.i(new d(this));
        this.f234366j.setLeftExtraClickListener(new e());
        final g r105 = f.b(this);
        if (r105 == null) goto L6;
        this.f234366j.setLeftClickListener(new zi5.a(r105));
        r100.setOnClickListener(null);
        r100.setFitsSystemWindows(true);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.view_history_main_fragment, r101, false);
    }
}
