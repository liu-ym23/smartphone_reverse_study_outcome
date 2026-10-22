package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f401830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f401831b;

    public final void a() {
        Iterator r100 = this.f401830a.iterator();
    L4:
        if (r100.hasNext() == false) goto L17;
        p.a r101 = (p.a) r100.next();
        p r102 = this.f401831b;
        r102.getClass();
        RecyclerView.y r103 = r101.f401876a;
        View r104 = null;
        if (r103 != null) goto L8;
        View r105 = null;
    L9:
        RecyclerView.y r106 = r101.f401877b;
        if (r106 == null) goto L13;
        r104 = r106.f401728a;
    L13:
        if (r105 == null) goto L15;
        ViewPropertyAnimator r107 = r105.animate().setDuration(r102.f401648f);
        r102.f401875r.add(r101.f401876a);
        r107.translationX(r101.f401880e - r101.f401878c);
        r107.translationY(r101.f401881f - r101.f401879d);
        r107.alpha(0.0f).setListener(new n(r102, r101, r107, r105)).start();
    L15:
        if (r104 == null) goto L4;
        ViewPropertyAnimator r108 = r104.animate();
        r102.f401875r.add(r101.f401877b);
        r108.translationX(0.0f).translationY(0.0f).setDuration(r102.f401648f).alpha(1.0f).setListener(new o(r102, r101, r108, r104)).start();
        goto L4
    L8:
        r105 = r103.f401728a;
        goto L9
    L17:
        this.f401830a.clear();
        this.f401831b.f401871n.remove(this.f401830a);
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

    public i(p r100, ArrayList r101) {
        this.f401831b = r100;
        this.f401830a = r101;
    }
}
