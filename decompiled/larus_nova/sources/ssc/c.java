package ssc;

import android.graphics.drawable.Drawable;
import io.noties.markwon.ext.tasklist.TaskListItem;
import java.util.ArrayList;
import lsc.l;
import lsc.p;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends lsc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f543520a;

    public c(a r100) {
        this.f543520a = r100;
    }

    @Override // lsc.a, lsc.j
    public final void c(p.a r100) {
        r100.a(TaskListItem.class, new b());
    }

    @Override // lsc.a, lsc.j
    public final void h(l.a r100) {
        r100.a(TaskListItem.class, new g(this.f543520a));
    }

    @Override // lsc.a, lsc.j
    public final void k(vvc.e.a r100) {
        d r101 = new d();
        ((ArrayList) r100.f557410c).add(r101);
    }
}
