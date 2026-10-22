package com.bytedance.flow.search.kmp.impl.middleware;

import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f243590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<FlowSearchData> f243591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<FlowSearchData> f243592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f243593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f243594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f243595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f243596g;

    public final void a() {
        monitor-enter(this);
        this.f243590a = null;     // Catch: Throwable -> L7
        this.f243591b = CollectionsKt.emptyList();     // Catch: Throwable -> L7
        this.f243592c = CollectionsKt.emptyList();     // Catch: Throwable -> L7
        this.f243593d = false;     // Catch: Throwable -> L7
        this.f243594e = false;     // Catch: Throwable -> L7
        this.f243595f = false;     // Catch: Throwable -> L7
        this.f243596g = false;     // Catch: Throwable -> L7
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public f() {
        this.f243591b = CollectionsKt.emptyList();
        this.f243592c = CollectionsKt.emptyList();
    }

    public final e b(FlowQuery r100) {
        Intrinsics.checkNotNullParameter(r100, "query");
        monitor-enter(this);
        g r101 = this.f243590a;     // Catch: Throwable -> L16
        int r102 = g.f243597d;     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(r101, g.a.a(r100)) == true) goto L7;
    L13:
        e r103 = null;
    L14:
        monitor-exit(this);
        return r103;
    L7:
        if (this.f243593d == false) goto L13;
        if (this.f243594e == false) goto L13;
        r103 = new e(this.f243591b, this.f243592c, this.f243595f, this.f243596g);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final void c(FlowQuery r100, List<FlowSearchData> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r101, "data");
        monitor-enter(this);
        g r103 = this.f243590a;     // Catch: Throwable -> L19
        int r104 = g.f243597d;     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(r103, g.a.a(r100)) == false) goto L16;
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L19
        Iterator<T> r106 = r101.iterator();     // Catch: Throwable -> L19
    L7:
        boolean r107 = true;
        if (r106.hasNext() == false) goto L15;
        Object r108 = r106.next();     // Catch: Throwable -> L19
        if (((FlowSearchData) r108).f243280b == 1) goto L13;
        r107 = false;
    L13:
        if (r107 == false) goto L7;
        r105.add(r108);     // Catch: Throwable -> L19
        goto L7
    L15:
        this.f243591b = CollectionsKt.take(r105, 3);     // Catch: Throwable -> L19
        this.f243593d = true;     // Catch: Throwable -> L19
        this.f243595f = r102;     // Catch: Throwable -> L19
    L16:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void d(FlowQuery r100, List<FlowSearchData> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r101, "data");
        monitor-enter(this);
        g r103 = this.f243590a;     // Catch: Throwable -> L10
        int r104 = g.f243597d;     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(r103, g.a.a(r100)) == false) goto L7;
        this.f243592c = h.a(r101);     // Catch: Throwable -> L10
        this.f243594e = true;     // Catch: Throwable -> L10
        this.f243596g = r102;     // Catch: Throwable -> L10
    L7:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
