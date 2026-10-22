package com.ss.android.lark.todo.impl.features.detail.sections;

import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DescriptionSection f443416a;

    public p(DescriptionSection r100) {
        this.f443416a = r100;
    }

    public final void a() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.f r100 = this.f443416a.e().getDescriptionInit().getValue();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L11;
    L13:
        ((TextView) this.f443416a.f443166b.findViewById(R.id.description_more)).setVisibility(8);
        this.f443416a.f443166b.findViewById(R.id.description_gradient_mask).setVisibility(8);
        return;
    L11:
        if (this.f443416a.f443167c.getHeight() < this.f443416a.f443167c.getMaxHeight()) goto L13;
        ((TextView) this.f443416a.f443166b.findViewById(R.id.description_more)).setVisibility(0);
        this.f443416a.f443166b.findViewById(R.id.description_gradient_mask).setVisibility(0);
        return;
    L5:
        if (r100.f443875a == true) goto L7;
        r101 = true;
        goto L9
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
