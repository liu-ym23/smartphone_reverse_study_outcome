package com.larus.home.impl.main.side_bar.view;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes29.dex */
public final class l2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f345763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k2 f345764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f345765c;

    public l2(RecyclerView r100, k2 r101, RecyclerView r102) {
        this.f345763a = r100;
        this.f345764b = r101;
        this.f345765c = r102;
    }

    public final void a() {
        k2 r100 = this.f345764b;
        r100.f345758g = false;
        if (r100.f345759h == true) goto L20;
        RecyclerView.Adapter r101 = r100.f345753b.invoke();
        if (r101 == null) goto L23;
        eb9.n r102 = this.f345764b.f345756e;
        if (r102 != null) goto L11;
        return;
    L11:
        if (this.f345765c.getAdapter() != r101) goto L21;
        k2 r103 = this.f345764b;
        r103.getClass();
        int r104 = com.larus.home.impl.main.side_bar.feed.arch.g.a(r101, 0, new j2(r103, r102));
        if (r104 == (-1)) goto L22;
        RecyclerView.LayoutManager r105 = this.f345765c.getLayoutManager();
        if ((r105 instanceof LinearLayoutManager) == false) goto L17;
        this.f345764b.a(this.f345765c, (LinearLayoutManager) r105, r104);
    L18:
        this.f345764b.f345757f = false;
        return;
    L17:
        this.f345765c.scrollToPosition(r104);
        goto L18
    L22:
        return;
    L21:
        return;
    L23:
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
