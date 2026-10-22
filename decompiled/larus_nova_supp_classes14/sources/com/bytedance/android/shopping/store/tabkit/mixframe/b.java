package com.bytedance.android.shopping.store.tabkit.mixframe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends QUIModule {
    public final View l;
    public final List<QIPresenter> m;

    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        List<QIPresenter> r1 = this.m;
        if (r1 == null) goto L8;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r0.a((QIPresenter) r2.next());
    L8:
        return r0;
    }

    public b(View r2, List<? extends QIPresenter> r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
