package com.bytedance.ee.bear.list.homepage.banner;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.homepage.banner.BannerAdapter;
import com.bytedance.ee.bear.list.homepage.banner.g.a;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.ss.android.lark.utils.ContextsKt;
import dd5.w0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class c<A extends BannerAdapter, VD extends g.a> implements g<VD> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f228286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f228287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f228288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BannerMoreView f228289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f228290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public A f228291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g.a f228292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f228293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f228294i;

    public static final class a implements BaseQuickAdapter.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c<A, VD> f228295a;

        public a(c<A, VD> r100) {
            this.f228295a = r100;
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public final void onItemClick(BaseQuickAdapter r100, View r101, int r102) {
            c<A, VD> r103 = this.f228295a;
            g.a r104 = r103.f228292g;
            if (r104 == null) goto L6;
            r104.y1(r103.k().getItem(r102), r102);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c<A, VD> f228296a;

        public b(c<A, VD> r100) {
            this.f228296a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c<A, VD> r101 = this.f228296a;
            r101.getClass();
            long r102 = SystemClock.uptimeMillis();
            if ((r102 - r101.f228294i) >= r101.f228293h) goto L5;
            boolean r103 = false;
        L6:
            if (r103 == false) goto L11;
            g.a r104 = this.f228296a.f228292g;
            if (r104 == null) goto L12;
            r104.t6();
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r101.f228294i = r102;
            r103 = true;
            goto L6
        }
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f228292g = null;
    }

    public abstract String p();

    public final int h() {
        int r100 = w0.f468013a;
        int r101 = w0.a(ContextsKt.findActivity(this.f228286a));
        if ((o().getLayoutManager() instanceof GridLayoutManager) == false) goto L8;
        RecyclerView.LayoutManager r102 = o().getLayoutManager();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        int r103 = ((GridLayoutManager) r102).getSpanCount();
        if (r103 > 0) goto L7;
        return r101;
    L7:
        return r103;
    L8:
        return r101;
    }

    public final A k() {
        A r100 = this.f228291f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        return null;
    }

    public final RecyclerView o() {
        RecyclerView r100 = this.f228290e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRvList");
        return null;
    }

    public void s() {
        RecyclerView r100 = (RecyclerView) this.f228287b.findViewById(R.id.list_banner_rv_list);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f228290e = r100;
        this.f228288c = (TextView) this.f228287b.findViewById(R.id.list_banner_tv_title);
        BannerMoreView r101 = (BannerMoreView) this.f228287b.findViewById(R.id.list_banner_more);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f228289d = r101;
        TextView r102 = this.f228288c;
        BannerMoreView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r102 = null;
    L5:
        r102.setText(p());
        int r104 = w0.f468013a;
        int r105 = w0.a(ContextsKt.findActivity(this.f228286a));
        o().addItemDecoration(new BannerListItemDecoration(r105));
        GridLayoutManager r106 = new GridLayoutManager(this.f228286a, r105, 1, false);
        A r107 = (A) new BannerAdapter();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f228291f = r107;
        k().setOnItemClickListener(new a(this));
        o().setLayoutManager(r106);
        o().setItemAnimator(null);
        o().setAdapter(k());
        BannerMoreView r108 = this.f228289d;
        if (r108 == null) goto L8;
        r103 = r108;
    L9:
        r103.setOnClickListener(new b(this));
        return;
    L8:
        Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
        goto L9
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        s();
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.g
    public final void j4(boolean r100) {
        BannerMoreView r101 = this.f228289d;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
        r101 = null;
    L6:
        if (r100 == false) goto L8;
        int r102 = 0;
    L9:
        r101.setVisibility(r102);
        return;
    L8:
        r102 = 8;
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.g
    public final void l6(boolean r100) {
        View r101 = this.f228287b;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        g.a r101 = (g.a) r100;
        Intrinsics.checkNotNullParameter(r101, "viewDelegate");
        this.f228292g = r101;
    }

    public c(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mRootView");
        this.f228286a = r100;
        this.f228287b = r101;
        this.f228293h = 800;
    }
}
