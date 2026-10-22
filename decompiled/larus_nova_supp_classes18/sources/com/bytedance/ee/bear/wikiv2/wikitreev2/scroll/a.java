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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int f = 0;
    public final boolean a;
    public WikiHorizontalScrollView b;
    public RecyclerView c;
    public WikiTreeView d;
    public final b e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a$a, reason: collision with other inner class name */
    public static final class C0214a {
        public static WikItemLeafView a(View r1) {
            Intrinsics.checkNotNullParameter(r1, "view");
            if (r1.getParent() != null) goto L5;
            return null;
        L5:
            if ((r1.getParent() instanceof WikItemLeafView) == false) goto L7;
            ViewParent r2 = r1.getParent();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView");
            return (WikItemLeafView) r2;
        L7:
            Object r3 = r1.getParent();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.View");
            return a((View) r3);
        }

        public static HorizontalScrollView b(View r1) {
            Intrinsics.checkNotNullParameter(r1, "view");
            if (r1.getParent() != null) goto L5;
        L10:
            return null;
        L5:
            if ((r1.getParent() instanceof WikiHorizontalScrollView) == false) goto L8;
            ViewParent r2 = r1.getParent();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiHorizontalScrollView");
            return (WikiHorizontalScrollView) r2;
        L8:
            if ((r1.getParent() instanceof View) == false) goto L10;
            Object r3 = r1.getParent();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.View");
            return b((View) r3);
        }

        public static WikiTreeCtrlView c(View r1) {
            Intrinsics.checkNotNullParameter(r1, "view");
            if (r1.getParent() != null) goto L5;
        L10:
            return null;
        L5:
            if ((r1.getParent() instanceof WikiTreeCtrlView) == false) goto L8;
            ViewParent r2 = r1.getParent();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView");
            return (WikiTreeCtrlView) r2;
        L8:
            if ((r1.getParent() instanceof View) == false) goto L10;
            Object r3 = r1.getParent();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.View");
            return c((View) r3);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r0 = this.a.c;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            RecyclerView.Adapter r1 = r0.getAdapter();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.notifyDataSetChanged();     // Catch: Throwable -> L8
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

    public a(boolean r1) {
        this.a = r1;
        this.e = new b(this);
    }

    public final int a(Context r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "view");
        int r0 = n.v();
        WikiTreeCtrlView r4 = C0214a.c(r3);
        if (r4 == null) goto L6;
        r0 = r4.getMeasuredWidth();
    L6:
        if (this.a == true) goto L8;
        int r5 = r2.getResources().getDimensionPixelSize(2131169542);
    L10:
        return r0 - (r5 * 2);
    L8:
        r5 = r2.getResources().getDimensionPixelSize(2131168174);
        goto L10
    }
}
