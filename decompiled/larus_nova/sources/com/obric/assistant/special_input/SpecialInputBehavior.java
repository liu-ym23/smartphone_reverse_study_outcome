package com.obric.assistant.special_input;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.window.IBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/assistant/special_input/SpecialInputBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowShow", "onWindowHide", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpecialInputBehavior implements IBehavior {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    public SpecialInputBehavior() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void init() {
        FLogger.f375446a.i("SpecialInputBehavior", "init");
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowHide() {
        FLogger.f375446a.i("SpecialInputBehavior", "onWindowHide");
        IAssistantChatWindow r100 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r100 == null) goto L10;
        t1a.b r101 = r100.provideWindowVContext();
        if (r101 == null) goto L11;
        laa.d r102 = (laa.d) r101.o(Reflection.getOrCreateKotlinClass(laa.d.class));
        if (r102 == null) goto L12;
        r102.tV();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowShow() {
        FLogger.f375446a.i("SpecialInputBehavior", "onWindowShow");
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onScreenRotationChanged(int r100, int r101) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r100, r101);
    }
}
