package com.obric.oui.orecyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
public final class e<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f401800h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f401801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<T> f401802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f401803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a<T>> f401804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<T> f401805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<T> f401806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f401807g;

    public interface a<T> {
        void a();
    }

    public static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f401808a;

        public b() {
            this.f401808a = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            this.f401808a.post(r100);
        }
    }

    static {
        f401800h = new b();
    }

    public e(com.obric.oui.orecyclerview.widget.b r100, c r101) {
        this.f401804d = new CopyOnWriteArrayList();
        this.f401806f = Collections.emptyList();
        this.f401801a = r100;
        this.f401802b = r101;
        this.f401803c = f401800h;
    }

    public final void a(List<T> r100, Runnable r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f401804d).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((a) r102.next()).a();
        goto L4
    L6:
        if (r101 == null) goto L10;
        r101.run();
        return;
    }

    public final void b(List r100, com.larus.dora.obric.device_management.device_home.e0 r110) {
        int r101 = this.f401807g + 1;
        this.f401807g = r101;
        List<T> r102 = this.f401805e;
        if (r100 != r102) goto L7;
        if (r110 == null) goto L16;
        r110.run();
        return;
    L16:
        return;
    L7:
        List<T> r103 = this.f401806f;
        if (r100 != null) goto L11;
        int r104 = r102.size();
        this.f401805e = null;
        this.f401806f = Collections.emptyList();
        this.f401801a.onRemoved(0, r104);
        a(r103, r110);
        return;
    L11:
        if (r102 != null) goto L14;
        this.f401805e = r100;
        this.f401806f = Collections.unmodifiableList(r100);
        this.f401801a.onInserted(0, r100.size());
        a(r103, r110);
        return;
    L14:
        this.f401802b.f401783a.execute(new d(this, r102, r100, r101, r110));
    }
}
