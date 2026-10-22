package com.ss.ugc.effectplatform.task;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends BaseTask {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f457732g;

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        this.f457732g.invoke();
    }

    public /* synthetic */ b(Function0 r100) {
        this(com.ss.ugc.effectplatform.util.q.a(), r100);
    }

    public b(String r100, Function0<Unit> r101) {
        super(r100, null);
        this.f457732g = r101;
    }
}
