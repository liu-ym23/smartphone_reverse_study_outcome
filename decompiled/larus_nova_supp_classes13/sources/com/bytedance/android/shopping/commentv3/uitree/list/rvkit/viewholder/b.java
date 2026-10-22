package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import android.view.ViewGroup;
import com.bytedance.android.shopping.commentv3.view.FilterCardSliceView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ FilterCardViewHolder a;

    public b(FilterCardViewHolder r1) {
        this.a = r1;
    }

    public final void a() {
        int r0 = ((FilterCardSliceView) this.a.a).getHeight();
        if (r0 > 0) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = ((FilterCardSliceView) this.a.a).getLayoutParams();
        if (r1 == null) goto L8;
        r1.height = r0;
        ((FilterCardSliceView) this.a.a).setLayoutParams(r1);
    L8:
        Function1<? super Integer, Unit> r2 = this.a.n;
        if (r2 == null) goto L12;
        Unit r3 = (Unit) r2.invoke(Integer.valueOf(r0));
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
