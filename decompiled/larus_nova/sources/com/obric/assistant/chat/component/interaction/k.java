package com.obric.assistant.chat.component.interaction;

import com.larus.bmhome.chat.component.cvs.y;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final class k implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f386876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f386877b;

    public k(y r100, l r101) {
        this.f386876a = r100;
        this.f386877b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        this.f386876a.lQ(this.f386877b);
        return Unit.INSTANCE;
    }
}
