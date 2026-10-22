package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f241670f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f241671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WikiHorizontalScrollView f241672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f241673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WikiTreeView f241674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f241675e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a$a, reason: collision with other inner class name */
    public static final class C3461a {
        public static WikItemLeafView a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (r100.getParent() != null) goto L5;
            return null;
        L5:
            if ((r100.getParent() instanceof WikItemLeafView) == false) goto L7;
            ViewParent r101 = r100.getParent();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView");
            return (WikItemLeafView) r101;
        L7:
            Object r102 = r100.getParent();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.View");
            return a((View) r102);
        }

        public static HorizontalScrollView b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (r100.getParent() != null) goto L5;
        L10:
            return null;
        L5:
            if ((r100.getParent() instanceof WikiHorizontalScrollView) == false) goto L8;
            ViewParent r101 = r100.getParent();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiHorizontalScrollView");
            return (WikiHorizontalScrollView) r101;
        L8:
            if ((r100.getParent() instanceof View) == false) goto L10;
            Object r102 = r100.getParent();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.View");
            return b((View) r102);
        }

        public static WikiTreeCtrlView c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (r100.getParent() != null) goto L5;
        L10:
            return null;
        L5:
            if ((r100.getParent() instanceof WikiTreeCtrlView) == false) goto L8;
            ViewParent r101 = r100.getParent();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView");
            return (WikiTreeCtrlView) r101;
        L8:
            if ((r100.getParent() instanceof View) == false) goto L10;
            Object r102 = r100.getParent();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.View");
            return c((View) r102);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f241676a;

        public b(a r100) {
            this.f241676a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r100 = this.f241676a.f241673c;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            RecyclerView.Adapter r101 = r100.getAdapter();     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.notifyDataSetChanged();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    public a(boolean r100) {
        this.f241671a = r100;
        this.f241675e = new b(this);
    }

    public final int a(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "view");
        int r102 = n.v();
        WikiTreeCtrlView r103 = C3461a.c(r101);
        if (r103 == null) goto L6;
        r102 = r103.getMeasuredWidth();
    L6:
        if (this.f241671a == true) goto L8;
        int r104 = r100.getResources().getDimensionPixelSize(R.dimen.wiki_tree_padding);
    L10:
        return r102 - (r104 * 2);
    L8:
        r104 = r100.getResources().getDimensionPixelSize(R.dimen.sidebar_tree_padding);
        goto L10
    }
}
