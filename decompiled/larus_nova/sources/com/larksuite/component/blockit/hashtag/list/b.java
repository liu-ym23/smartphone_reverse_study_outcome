package com.larksuite.component.blockit.hashtag.list;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.ui.DividerDecoration;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f283039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f283040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f283041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k.a f283042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashTagSwipeAdapter f283043e;

    public interface a {
        void a();

        FragmentActivity b();
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ((CommonTitleBar) this.f283039a.findViewById(R.id.titleBar)).setTitle(R.string.Lark_Pano_WorkTopic);
        ((CommonTitleBar) this.f283039a.findViewById(R.id.titleBar)).setLeftImageResource(R.drawable.ic_svg_titlebar_close);
        FragmentActivity r100 = this.f283040b.b();
        if (r100 == null) goto L5;
        String r101 = UIUtils.getString(r100, R.string.Lark_Pano_IKnown);
        SpannableString r102 = new SpannableString(r101);
        r102.setSpan(new ForegroundColorSpan(r100.getResources().getColor(R.color.lkui_B500)), 0, r101.length(), 33);
        this.f283043e = new HashTagSwipeAdapter(r100, new f(this, r100, r102), true, true);
        ((CommonRecyclerView) this.f283039a.findViewById(R.id.rvAddedHashTag)).setAdapter(this.f283043e);
        ((CommonRecyclerView) this.f283039a.findViewById(R.id.rvAddedHashTag)).setItemAnimator(null);
        ((CommonRecyclerView) this.f283039a.findViewById(R.id.rvAddedHashTag)).setLayoutManager(new LinearLayoutManager(this.f283039a.getContext()));
        ((CommonRecyclerView) this.f283039a.findViewById(R.id.rvAddedHashTag)).setOnScrollListener(new HashTagListView$initView$1$2(this));
        DividerDecoration.a r103 = new DividerDecoration.a(r100);
        float r104 = UIUtils.dp2px(r100, 0.5f);
        Resources r105 = r103.f285824a;
        r103.f285825b = (int) TypedValue.applyDimension(0, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()));
        r103.f285826c = r103.f285824a.getColor(R.color.lkui_N300);
        float r106 = UIUtils.dp2px(r100, 16.0f);
        Resources r107 = r103.f285824a;
        ((CommonRecyclerView) this.f283039a.findViewById(R.id.rvAddedHashTag)).addItemDecoration(new DividerDecoration(r103.f285825b, (int) TypedValue.applyDimension(0, r106, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())), r103.f285826c), 0);
    L5:
        ((TextView) this.f283039a.findViewById(R.id.tvAddHashTag)).setOnClickListener(new g(this));
    }

    @Override // com.larksuite.component.blockit.hashtag.list.k
    public final void O7(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        LKUIToast.show(this.f283039a.getContext(), R.drawable.ic_svg_toast_succeed, r100);
    }

    @Override // com.larksuite.component.blockit.hashtag.list.k
    public final void c1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        LKUIToast.show(this.f283039a.getContext(), r100);
    }

    @Override // com.larksuite.component.blockit.hashtag.list.k
    public final void f7(l r100) {
        Intrinsics.checkNotNullParameter(r100, "initData");
        HashTagSwipeAdapter r101 = this.f283043e;
        if (r101 == null) goto L6;
        r101.A2(r100.f283056a);
    L6:
        if (CollectionUtils.isEmpty(r100.f283056a) == true) goto L8;
        ((TextView) this.f283039a.findViewById(R.id.tvAddedHashTagDesc)).setVisibility(0);
        ((CommonRecyclerView) this.f283039a.findViewById(R.id.rvAddedHashTag)).setVisibility(0);
        ((FrameLayout) this.f283039a.findViewById(R.id.flEmptyContainer)).setVisibility(8);
        return;
    L8:
        ((TextView) this.f283039a.findViewById(R.id.tvAddedHashTagDesc)).setVisibility(0);
        ((CommonRecyclerView) this.f283039a.findViewById(R.id.rvAddedHashTag)).setVisibility(8);
        ((FrameLayout) this.f283039a.findViewById(R.id.flEmptyContainer)).setVisibility(0);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f283042d = (k.a) r100;
    }

    public b(View r100, HashTagListFragment.a r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "mRootView");
        Intrinsics.checkNotNullParameter(r101, "mViewDependency");
        this.f283039a = r100;
        this.f283040b = r101;
        this.f283041c = r102;
    }
}
