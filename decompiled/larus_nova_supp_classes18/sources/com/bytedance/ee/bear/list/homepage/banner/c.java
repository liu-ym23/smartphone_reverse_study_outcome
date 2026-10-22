package com.bytedance.ee.bear.list.homepage.banner;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.BannerAdapter;
import com.bytedance.ee.bear.list.homepage.banner.g.a;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.utils.ContextsKt;
import dd5.w0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class c<A extends BannerAdapter, VD extends g.a> implements g<VD> {
    public final Context a;
    public final View b;
    public TextView c;
    public BannerMoreView d;
    public RecyclerView e;
    public A f;
    public g.a g;
    public final long h;
    public long i;

    public static final class a implements BaseQuickAdapter.OnItemClickListener {
        public final /* synthetic */ c<A, VD> a;

        public a(c<A, VD> r1) {
            this.a = r1;
        }

        public final void onItemClick(BaseQuickAdapter r1, View r2, int r3) {
            c<A, VD> r4 = this.a;
            g.a r5 = r4.g;
            if (r5 == null) goto L6;
            r5.y1((Document) r4.k().getItem(r3), r3);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ c<A, VD> a;

        public b(c<A, VD> r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            c<A, VD> r9 = this.a;
            r9.getClass();
            long r0 = SystemClock.uptimeMillis();
            if ((r0 - r9.i) >= r9.h) goto L5;
            boolean r10 = false;
        L6:
            if (r10 == false) goto L11;
            g.a r11 = this.a.g;
            if (r11 == null) goto L12;
            r11.t6();
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r9.i = r0;
            r10 = true;
            goto L6
        }
    }

    public final void destroy() {
        this.g = null;
    }

    public abstract String p();

    public final int h() {
        int r0 = w0.a;
        int r1 = w0.a(ContextsKt.findActivity(this.a));
        if ((o().getLayoutManager() instanceof GridLayoutManager) == false) goto L8;
        GridLayoutManager r2 = o().getLayoutManager();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        int r3 = r2.getSpanCount();
        if (r3 > 0) goto L7;
        return r1;
    L7:
        return r3;
    L8:
        return r1;
    }

    public final A k() {
        A r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        return null;
    }

    public final RecyclerView o() {
        RecyclerView r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRvList");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public void s() {
        RecyclerView r0 = this.b.findViewById(2131378071);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.e = r0;
        this.c = (TextView) this.b.findViewById(2131378073);
        BannerMoreView r1 = (BannerMoreView) this.b.findViewById(2131378070);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.d = r1;
        TextView r2 = this.c;
        ?? r3 = 0;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r2 = null;
    L5:
        r2.setText(p());
        int r4 = w0.a;
        int r5 = w0.a(ContextsKt.findActivity(this.a));
        o().addItemDecoration(new BannerListItemDecoration(r5));
        GridLayoutManager r6 = new GridLayoutManager(this.a, r5, 1, false);
        A r7 = (A) new BannerAdapter();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        this.f = r7;
        k().setOnItemClickListener(new a(this));
        o().setLayoutManager(r6);
        o().setItemAnimator(null);
        o().setAdapter(k());
        BannerMoreView r8 = this.d;
        if (r8 == null) goto L8;
        r3 = r8;
    L9:
        r3.setOnClickListener(new b(this));
        return;
    L8:
        Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
        goto L9
    }

    public final void create() {
        s();
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.g
    public final void j4(boolean r2) {
        AppCompatTextView r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
        r0 = null;
    L6:
        if (r2 == false) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.g
    public final void l6(boolean r2) {
        View r0 = this.b;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setViewDelegate(IView.IViewDelegate r2) {
        g.a r3 = (g.a) r2;
        Intrinsics.checkNotNullParameter(r3, "viewDelegate");
        this.g = r3;
    }

    public c(Context r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mRootView");
        this.a = r2;
        this.b = r3;
        this.h = 800;
    }
}
