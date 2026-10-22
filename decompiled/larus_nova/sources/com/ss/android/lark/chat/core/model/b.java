package com.ss.android.lark.chat.core.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y6b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T, S> implements d.a<d<S>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x4b.c<S, T> f414768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile List<T> f414769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile List<T> f414770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f414771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f414772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC4848b<T> f414773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<a<T>> f414774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<e<T>> f414775h;

    public interface a<T> {
        void a(List<T> r100, int r101, int r102);

        void b(List<T> r100, int r101, int r102);

        void c(List r100, int r101);
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.core.model.b$b, reason: collision with other inner class name */
    public interface InterfaceC4848b<T> {
        void onChanged(List<T> r100);
    }

    public final void f() {
        boolean r100 = false;
        this.f414771d = false;
        this.f414769b = this.f414770c;
        this.f414770c = null;
        if (this.f414773f != null) goto L5;
    L7:
        StringBuilder r101 = new StringBuilder("snapshots size=");
        r101.append(this.f414769b.size());
        r101.append(", listener=");
        if (this.f414773f == null) goto L10;
        r100 = true;
    L10:
        r101.append(r100);
        r101.append(", mHasChange=");
        r101.append(this.f414772e);
        PerfLog.end("DataListPipeline_onUpdate", r101.toString());
        return;
    L5:
        if (this.f414772e == false) goto L7;
        this.f414773f.onChanged(b());
        goto L7
    }

    public final void a() {
        if (this.f414771d == false) goto L5;
        return;
    L5:
        if (this.f414770c == null) goto L8;
        return;
    L8:
        throw new IllegalStateException("should call updateBegin at first");
    }

    public final List<T> b() {
        List<T> r100 = this.f414769b;
        Iterator<e<T>> r101 = this.f414775h.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100 = r101.next().a(r100);
        goto L4
    L7:
        return new ArrayList(r100);
    }

    public final void c() {
        if (this.f414773f != null) goto L6;
        return;
    L6:
        if (this.f414771d == false) goto L8;
        this.f414772e = true;
        return;
    L8:
        this.f414773f.onChanged(b());
    }

    public final void e() {
        PerfLog.start("DataListPipeline_onUpdate", "snapshots size = " + this.f414769b.size());
        this.f414770c = new ArrayList(this.f414769b);
        this.f414772e = false;
        this.f414771d = true;
    }

    public final void d(d<S> r100, int r101, int r102) {
        if (r102 > 0) goto L4;
        return;
    L4:
        a();
        this.f414772e = true;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        int r104 = r101 + r103;
        ListProtector.add(this.f414770c, r104, this.f414768a.b(r100.get(r104)));
        r103 = r103 + 1;
        goto L5
    L7:
        List<a<T>> r105 = this.f414774g;
        if (r105 != null) goto L10;
        return;
    L10:
        if (r105.isEmpty() == true) goto L18;
        Iterator<a<T>> r106 = this.f414774g.iterator();
    L13:
        if (r106.hasNext() == false) goto L19;
        r106.next().b(this.f414770c, r101, r102);
        goto L13
    L19:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(d<S> r100, x4b.c<S, T> r101, List<a<T>> r102, InterfaceC4848b<T> r103) {
        this.f414769b = new ArrayList();
        this.f414771d = false;
        this.f414772e = false;
        this.f414775h = new ArrayList();
        this.f414768a = r101;
        this.f414774g = r102;
        this.f414773f = r103;
        r100.acquireReadAccess();
        r100.removeOnListUpdateCallback(this);
        r100.addOnListUpdateCallback(this);
        e();
        d(r100, 0, ((ArrayList) r100).size());
        f();
        r100.releaseReadAccess();
    }
}
