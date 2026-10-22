package com.obric.oui.orecyclerview.widget;

import com.obric.oui.orecyclerview.widget.RecyclerView.y;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public abstract class w<T, VH extends RecyclerView.y> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<T> f401966c;

    public class a implements e.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f401967a;

        @Override // com.obric.oui.orecyclerview.widget.e.a
        public final void a() {
            this.f401967a.getClass();
        }

        public a(w r100) {
            this.f401967a = r100;
        }
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public final int a() {
        return this.f401966c.f401806f.size();
    }

    public w(q.e<T> r100) {
        a r101 = new a(this);
        b r102 = new b(this);
        c.a r103 = new c.a(r100);
        if (r103.f401787a != null) goto L14;
        Object r104 = c.a.f401785b;
        monitor-enter(r104);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c.a.f401786c != null) goto L9;
        c.a.f401786c = PThreadExecutorsUtils.newFixedThreadPool(2, new DefaultThreadFactory("AsyncDifferConfig$Builder"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(r104);     // Catch: Throwable -> L11
        r103.f401787a = c.a.f401786c;
    L14:
        e<T> r105 = new e(r102, new c(r103.f401787a, r100));
        this.f401966c = r105;
        ((CopyOnWriteArrayList) r105.f401804d).add(r101);
    }
}
