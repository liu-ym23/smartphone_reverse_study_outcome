package com.obric.assistant.obric_action.handler.prompt;

import com.larus.common_ui.dialog.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
public final class c implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<j, Unit> f390497a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.f390497a.invoke(new j("dismissed", 14));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super j, Unit> r100) {
        this.f390497a = r100;
    }
}
