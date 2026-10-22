package com.ss.android.lark.platform.dispatcher;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements com.ss.android.lark.platform.dispatcher.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f438645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<f> f438646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<h> f438647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<i> f438648d;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            ((f) r100).getPriority();
            ((f) r101).getPriority();
            return ComparisonsKt.compareValues(0, 0);
        }
    }

    public final boolean f() {
        List r100 = CollectionsKt.sortedWith(this.f438646b, new a());
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((f) r101.next()).onBackPressed() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    public b() {
        this.f438645a = new CopyOnWriteArrayList();
        this.f438646b = new CopyOnWriteArrayList();
        this.f438647c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.f438648d = new CopyOnWriteArrayList();
    }

    @Override // com.ss.android.lark.platform.dispatcher.c
    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f438645a.addIfAbsent(r100);
    }

    @Override // com.ss.android.lark.platform.dispatcher.g
    public final void b(com.ss.android.lark.chat.component.c r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f438647c.addIfAbsent(r100);
    }

    @Override // com.ss.android.lark.platform.dispatcher.g
    public final void c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f438647c.remove(r100);
    }

    @Override // com.ss.android.lark.platform.dispatcher.c
    public final void d(d r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f438645a.remove(r100);
    }

    @Override // com.ss.android.lark.platform.dispatcher.e
    public final void e(com.ss.android.lark.chat.component.b r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f438646b.addIfAbsent(r100);
    }
}
