package com.larus.voicecall.impl.plugins;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes32.dex */
@Deprecated(message = "logic trans")
public final class CallEventDispatcher implements com.larus.voicecall.impl.scene.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.larus.voicecall.impl.scene.a> f378414a;

    @Override // com.larus.voicecall.impl.scene.a
    public final void b() {
        a(new f());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void c() {
        a(new e());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void d() {
        a(new l());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void g() {
        a(new b());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void k() {
        a(new g());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void m() {
        a(new h());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void onInterrupt() {
        a(new i());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void onRelease() {
        a(new k());
    }

    public CallEventDispatcher() {
        this.f378414a = new CopyOnWriteArrayList();
    }

    public final void a(Function1<? super com.larus.voicecall.impl.scene.a, Unit> r100) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CallEventDispatcher$dispatch$1(this, r100, null), 3, null);
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void j(final a78.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        a(new j(r100));
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void e(final String r100, final String r101) {
        a(new c(r100, r101));
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void f(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionId");
        Intrinsics.checkNotNullParameter(r101, "queryRound");
        a(new d(r100, r101));
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void i(final Integer r100, final boolean r101) {
        a(new m(r100, r101));
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void l(final boolean r100, final String r101, final String r102, final String r103) {
        Intrinsics.checkNotNullParameter(r103, "asrTaskId");
        a(new a(r100, r101, r102, r103));
    }
}
