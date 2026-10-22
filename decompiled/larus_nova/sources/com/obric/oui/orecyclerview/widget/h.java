package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f401823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f401824b;

    public final void a() {
        Iterator r100 = this.f401823a.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        p.b r101 = (p.b) r100.next();
        p r102 = this.f401824b;
        RecyclerView.y r103 = r101.f401882a;
        int r104 = r101.f401883b;
        int r105 = r101.f401884c;
        int r106 = r101.f401885d;
        int r107 = r101.f401886e;
        r102.getClass();
        View r108 = r103.f401728a;
        int r109 = r106 - r104;
        int r110 = r107 - r105;
        if (r109 == 0) goto L8;
        r108.animate().translationX(0.0f);
    L8:
        if (r110 == 0) goto L10;
        r108.animate().translationY(0.0f);
    L10:
        ViewPropertyAnimator r111 = r108.animate();
        r102.f401873p.add(r103);
        r111.setDuration(r102.f401647e).setListener(new m(r102, r103, r109, r108, r110, r111)).start();
        goto L4
    L11:
        this.f401823a.clear();
        this.f401824b.f401870m.remove(this.f401823a);
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

    public h(p r100, ArrayList r101) {
        this.f401824b = r100;
        this.f401823a = r101;
    }
}
