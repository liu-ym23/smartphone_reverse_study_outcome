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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import nu5.a;
import zi5.b;
import zi5.c;
import zi5.d;
import zi5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ViewHistoryFragment extends BaseFragment {
    public static final /* synthetic */ int q = 0;
    public int e;
    public String f;
    public RecyclerView g;
    public SmartRefreshLayout h;
    public TextView i;
    public BaseTitleBar j;
    public SpaceEmptyState k;
    public ViewHistoryAdapter l;
    public List<RecordListResult.a> m;
    public int n;
    public LottieAnimationView o;
    public ViewHistoryViewModel p;

    public final void U90() {
        this.k.setVisibility(0);
        this.k.setTitle("");
        this.k.setDesc("");
        this.k.setPrimaryText("");
        this.k.setImageRes(null);
    }

    public final void dismissLoading() {
        this.o.cancelAnimation();
        this.o.setVisibility(8);
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        ViewHistoryViewModel.b r0 = (ViewHistoryViewModel.b) this.p.getmLoadingMoreState().getValue();
        Objects.requireNonNull(r0);
        if (r0.a != 9) goto L6;
        U90();
        this.p.pull();
        return;
    }

    static {
    }

    public ViewHistoryFragment() {
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        this.e = r4.getInt("TYPE", 0);
        this.f = r4.getString("TOKEN", "");
    }

    public final void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        this.g = r4.findViewById(2131383764);
        this.j = (BaseTitleBar) r4.findViewById(2131388775);
        this.h = r4.findViewById(2131383765);
        this.i = (TextView) r4.findViewById(2131374332);
        this.k = (SpaceEmptyState) r4.findViewById(2131383758);
        this.o = r4.findViewById(2131383763);
        a.a((ImageView) r4.findViewById(2131374718), 17, 17);
        this.k.setVisibility(0);
        this.n = 1;
        ViewHistoryViewModel r0 = (ViewHistoryViewModel) ViewModelProviders.of(this).get(ViewHistoryViewModel.class);
        this.p = r0;
        r0.attach(this.f, this.e);
        this.p.pull();
        this.p.getResultMutableLiveData().observe(getViewLifecycleOwner(), new b(this));
        this.p.getmLoadingMoreState().observe(getViewLifecycleOwner(), new c(this));
        this.m = new ArrayList();
        this.h.g(true);
        this.h.F(new LoadMoreFooter(getContext()), -2);
        LinearLayoutManager r1 = new LinearLayoutManager(getContext());
        this.g.setLayoutManager(r1);
        getContext();
        ViewHistoryAdapter r2 = new ViewHistoryAdapter(this.m);
        this.l = r2;
        this.g.setAdapter(r2);
        this.h.i(new d(this));
        this.j.setLeftExtraClickListener(new e());
        final g r3 = f.b(this);
        if (r3 == null) goto L6;
        this.j.setLeftClickListener(new zi5.a(r3));
        r4.setOnClickListener(null);
        r4.setFitsSystemWindows(true);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131568175, r3, false);
    }
}
