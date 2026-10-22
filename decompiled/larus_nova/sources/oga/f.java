package oga;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f523229a;

    @Override // oga.a
    public final void onDismissFailed() {
    }

    @Override // oga.a
    public final void onDismissSucceeded() {
        this.f523229a.invoke();
    }

    public f(Function0<Unit> r100) {
        this.f523229a = r100;
    }
}
