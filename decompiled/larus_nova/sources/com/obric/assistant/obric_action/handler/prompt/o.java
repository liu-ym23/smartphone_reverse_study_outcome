package com.obric.assistant.obric_action.handler.prompt;

import com.larus.common_ui.dialog.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
public final class o implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<j, Unit> f390511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PromptOptionsDialogActionHandler f390512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PromptOptionsDialogActionHandler.b f390513c;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.f390511a.invoke(PromptOptionsDialogActionHandler.e(this.f390512b, this.f390513c));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function1<? super j, Unit> r100, PromptOptionsDialogActionHandler r101, PromptOptionsDialogActionHandler.b r102) {
        this.f390511a = r100;
        this.f390512b = r101;
        this.f390513c = r102;
    }
}
