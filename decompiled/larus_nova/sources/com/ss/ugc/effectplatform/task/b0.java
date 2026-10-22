package com.ss.ugc.effectplatform.task;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
public final class b0 extends BaseTask {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f457733g;

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        this.f457733g.invoke();
    }

    public b0(String r100, Function0<Unit> r101) {
        super(r100, null);
        this.f457733g = r101;
    }
}
