package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class OfficeSdkHumanFeedController implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iza.b f345404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<b, iza.a> f345405b;

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.h
    public final void c() {
        this.f345404a.c();
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.c
    public final void release() {
        Map<b, iza.a> r100 = this.f345405b;
        monitor-enter(r100);
        List r101 = CollectionsKt.toList(((LinkedHashMap) this.f345405b).values());     // Catch: Throwable -> L12
        ((LinkedHashMap) this.f345405b).clear();     // Catch: Throwable -> L12
        monitor-exit(r100);
        iza.b r102 = this.f345404a;
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.j((iza.a) r103.next());
        goto L8
    L10:
        this.f345404a.k();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public OfficeSdkHumanFeedController(iza.b r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f345404a = r100;
        this.f345405b = new LinkedHashMap();
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.h
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return this.f345404a.d(r100);
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.h
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f345404a.a(r100);
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.c
    public final void g(j r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Map<b, iza.a> r101 = this.f345405b;
        monitor-enter(r101);
        iza.a r102 = this.f345405b.remove(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);
        if (r102 != null) goto L8;
        return;
    L8:
        this.f345404a.j(r102);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.h
    public final void i(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f345404a.i(r100);
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.c
    public final void j(j r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        p r101 = new p(r100);
        Map<b, iza.a> r102 = this.f345405b;
        monitor-enter(r102);
        iza.a r103 = this.f345405b.put(r100, r101);     // Catch: Throwable -> L9
        iza.a r104 = r103;     // Catch: Throwable -> L9
        this.f345404a.e(r101);     // Catch: Throwable -> L9
        iza.a r105 = r103;     // Catch: Throwable -> L9
        monitor-exit(r102);
        if (r105 == null) goto L14;
        this.f345404a.j(r105);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.h
    public final void b(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "id");
        this.f345404a.h(r100, r101);
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.h
    public final boolean d(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "id");
        return this.f345404a.b(r100, r101);
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.c
    public final Object e(int r100, Continuation<? super f> r101) {
        if ((r101 instanceof OfficeSdkHumanFeedController$loadMore$1) == false) goto L7;
        OfficeSdkHumanFeedController$loadMore$1 r102 = (OfficeSdkHumanFeedController$loadMore$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return q.a((iza.d) r104);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        iza.b r107 = this.f345404a;
        r102.label = 1;
        r104 = r107.f(r100, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new OfficeSdkHumanFeedController$loadMore$1(this, r101);
        goto L8
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.datasource.lark.c
    public final Object h(int r100, Continuation<? super f> r101) {
        if ((r101 instanceof OfficeSdkHumanFeedController$refresh$1) == false) goto L7;
        OfficeSdkHumanFeedController$refresh$1 r102 = (OfficeSdkHumanFeedController$refresh$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return q.a((iza.d) r104);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        iza.b r107 = this.f345404a;
        r102.label = 1;
        r104 = r107.g(r100, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new OfficeSdkHumanFeedController$refresh$1(this, r101);
        goto L8
    }
}
