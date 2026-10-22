package com.larus.bot.impl.feature.edit.feature.main;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements c, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f319248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableSharedFlow<e> f319249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a1 f319250c;

    @Override // com.larus.bot.impl.feature.edit.feature.main.d
    public final void g() {
        e.a r100 = e.a.f319251a;
        BuildersKt.launch$default(this.f319248a, null, null, new BotMainEditViewModel$sendUIEvent$1(this, r100, null), 3, null);
    }

    @Override // uu8.b
    public final d1<e> getUiEvent() {
        return this.f319250c;
    }

    public b(CoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f319248a = r100;
        kotlinx.coroutines.flow.e.b(j1.a(new f(0)));
        MutableSharedFlow<e> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f319249b = r101;
        this.f319250c = kotlinx.coroutines.flow.e.a(r101);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.main.d
    public final void b(boolean r100) {
        e.b r101 = new e.b(r100);
        BuildersKt.launch$default(this.f319248a, null, null, new BotMainEditViewModel$sendUIEvent$1(this, r101, null), 3, null);
    }
}
