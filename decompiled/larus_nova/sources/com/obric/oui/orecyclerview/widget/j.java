package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f401833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f401834b;

    public final void a() {
        Iterator r100 = this.f401833a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        RecyclerView.y r101 = (RecyclerView.y) r100.next();
        p r102 = this.f401834b;
        r102.getClass();
        View r103 = r101.f401728a;
        ViewPropertyAnimator r104 = r103.animate();
        r102.f401872o.add(r101);
        r104.alpha(1.0f).setDuration(r102.f401645c).setInterpolator(p.f401864t).setListener(new l(r102, r101, r103, r104)).start();
        goto L4
    L6:
        this.f401833a.clear();
        this.f401834b.f401869l.remove(this.f401833a);
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

    public j(p r100, ArrayList r101) {
        this.f401834b = r100;
        this.f401833a = r101;
    }
}
