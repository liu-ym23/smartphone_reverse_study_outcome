package com.bytedance.android.shopping.store.home.frame.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class AbsShopGroupPresenter<T> extends QFragmentPresenter {
    public final ArrayList<a<T>> f;
    public final ArrayList<Integer> g;
    public boolean h;
    public final Lazy i;
    public final Lazy j;

    public abstract f e0();

    public final ECStoreViewModel h0() {
        return (ECStoreViewModel) this.i.getValue();
    }

    public abstract g i0();

    public final void c0() {
        Iterator<a<T>> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().unbind();
        goto L4
    }

    public AbsShopGroupPresenter(final Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.i = LazyKt.lazy(new AbsShopGroupPresenter$viewModel$2(this, r2));
        this.j = LazyKt.lazy(new AbsShopGroupPresenter$containerAdapter$2(this));
    }

    public void b0(QModel r6) {
        int r0 = this.f.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L16;
        a r2 = (a) ListProtector.get(this.f, r1);
        f r3 = e0();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.g = r3;
        g r4 = i0();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.f = r4;
        e r5 = (e) this.j.getValue();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r2.h = r5;
        ECStoreParam r7 = h0().getStoreParam();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r2.i = r7;
        Integer r8 = (Integer) ListProtector.get(this.g, r1);
        if (r8 != null) goto L8;
    L10:
        View r9 = a0().findViewById(((Number) ListProtector.get(this.g, r1)).intValue());
        if (r9 == null) goto L15;
        r2.J(r6, r9, Y().d());
    L13:
        r1 = r1 + 1;
        goto L3
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L8:
        if (r8.intValue() != 0) goto L10;
        r2.J(r6, a0(), Y().d());
        goto L13
    }

    public final void d0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "presenter");
        Intrinsics.checkNotNullParameter(r2, "presenter");
        this.f.add(r2);
        this.g.add(0);
    }
}
