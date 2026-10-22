package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends QUIModule {
    public final WindowLynxHolder l;
    public final Fragment m;
    public final ViewGroup n;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.holder.a$a, reason: collision with other inner class name */
    public final class C0029a extends QFragmentPresenter {
        public v f;
        public final /* synthetic */ a g;

        public final void c0() {
            if (this.f == null) goto L6;
            this.g.n.setVisibility(8);
            this.g.l.o();
            return;
        }

        public C0029a(a r1) {
            this.g = r1;
            super(r1.m);
        }

        public final void b0(QModel r4) {
            if ((r4 instanceof v) == true) goto L5;
            r4 = null;
        L5:
            v r5 = (v) r4;
            this.f = r5;
            if (r5 != null) goto L8;
        L15:
            this.g.n.setVisibility(8);
            return;
        L8:
            if (r5.e() == true) goto L15;
            this.g.n.setVisibility(0);
            Iterator r0 = com.bytedance.commerce.base.view.b.a(this.g.n).iterator();
        L12:
            if (r0.hasNext() == false) goto L14;
            ((View) r0.next()).setVisibility(0);
            goto L12
        L14:
            WindowLynxHolder r1 = this.g.l;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r5, "vo");
            r1.q4(r5);
        }
    }

    public static final class b implements Function2<v, ECLynxCardEvent, Unit> {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, Object r3) {
            Intrinsics.checkNotNullParameter((v) r2, "p1");
            Intrinsics.checkNotNullParameter((ECLynxCardEvent) r3, "p2");
            Iterator r4 = com.bytedance.commerce.base.view.b.a(this.a.n).iterator();
        L4:
            if (r4.hasNext() == false) goto L7;
            ((View) r4.next()).setVisibility(8);
            goto L4
        L7:
            return Unit.INSTANCE;
        }
    }

    public final boolean d() {
        return true;
    }

    public final QIPresenter h() {
        return new C0029a(this);
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.n;
    }

    public a(Fragment r4, ViewGroup r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        super(0);
        this.m = r4;
        this.n = r5;
        WindowLynxHolder r1 = new WindowLynxHolder(r4, new b(this), false);
        if (r6 == false) goto L5;
        WindowLayoutType r7 = WindowLayoutType.SINGLECOLUMN;
    L6:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r1.w = r7;
        r5.addView(((RecyclerView.ViewHolder) r1).itemView, -1, -2);
        r5.setPadding(0, com.bytedance.android.shopping.extensions.b.b(9), 0, 0);
        Unit r8 = Unit.INSTANCE;
        this.l = r1;
        return;
    L5:
        r7 = WindowLayoutType.DOUBLECOLUMN;
        goto L6
    }
}
