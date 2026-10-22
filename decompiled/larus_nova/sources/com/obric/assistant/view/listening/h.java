package com.obric.assistant.view.listening;

import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h implements xaa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f394326a;

    public h(f r100) {
        this.f394326a = r100;
    }

    @Override // xaa.b
    public final void a(final ObricListeningPresentationState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        final f r101 = this.f394326a;
        r101.f394314b.invoke(new g(r101, r100));
    }
}
