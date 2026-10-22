package com.ss.android.lark.keyboard.ime;

import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a> f429378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<a> f429379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<a> f429380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<a> f429381d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f429382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f429383b;

        public /* synthetic */ a() {
            throw null;
        }

        public a(boolean r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "action");
            this.f429382a = r100;
            this.f429383b = r101;
        }
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void clear() {
        this.f429378a.clear();
        this.f429379b.clear();
        this.f429380c.clear();
        this.f429381d.clear();
    }

    public d() {
        this.f429378a = new LinkedList();
        this.f429379b = new LinkedList();
        this.f429380c = new LinkedList();
        this.f429381d = new LinkedList();
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f429380c.add(new a(false, r100));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f429378a.add(new a(true, r100));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void c(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f429379b.add(new a(false, r100));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void d(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f429381d.add(new a(false, r100));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void e(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f429381d.add(new a(true, r100));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void f(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f429378a.add(new a(false, r100));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void g(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f429379b.add(new a(true, r100));
    }
}
