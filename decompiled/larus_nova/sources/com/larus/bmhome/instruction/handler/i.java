package com.larus.bmhome.instruction.handler;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class i implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.bmhome.instruction.p f312095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f312096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f312097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f312098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f312099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f312100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f312101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f312102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f312103i;

    public final com.larus.bmhome.chat.component.cvs.y b() {
        return (com.larus.bmhome.chat.component.cvs.y) this.f312096b.getValue();
    }

    public final ICoreInputAbility c() {
        return (ICoreInputAbility) this.f312102h.getValue();
    }

    public final Fragment d() {
        return s1a.a.c(this.f312095a.f312193a);
    }

    public final t1a.b e() {
        return s1a.d.a(this.f312095a.f312193a);
    }

    public i(com.larus.bmhome.instruction.p r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionCoreAbility");
        this.f312095a = r100;
        this.f312096b = LazyKt.lazy(new a(this));
        this.f312097c = LazyKt.lazy(new b(this));
        this.f312098d = LazyKt.lazy(new c(this));
        this.f312099e = LazyKt.lazy(new d(this));
        this.f312100f = LazyKt.lazy(new e(this));
        this.f312101g = LazyKt.lazy(new f(this));
        this.f312102h = LazyKt.lazy(new g(this));
        this.f312103i = LazyKt.lazy(new h(this));
    }
}
