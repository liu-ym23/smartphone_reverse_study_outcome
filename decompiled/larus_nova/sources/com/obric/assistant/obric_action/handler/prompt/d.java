package com.obric.assistant.obric_action.handler.prompt;

import com.larus.common_ui.dialog.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<j, Unit> f390498a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.f390498a.invoke(new j("confirmed", 14));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super j, Unit> r100) {
        this.f390498a = r100;
    }
}
