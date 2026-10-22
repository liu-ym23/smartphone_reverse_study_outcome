package com.obric.assistant.voice.presentation;

import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.w0;
import com.obric.assistant.interaction.api.window.IBehavior;
import kotlin.Metadata;
import sha.b;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/voice/presentation/ListeningPresentationWindowBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowPreHide", "onWindowPreDismiss", "onWindowHide", "onWindowDismiss", "finishChildPresentation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListeningPresentationWindowBehavior implements IBehavior {
    public ListeningPresentationWindowBehavior() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void init() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowDismiss() {
        int r100 = b.f542084a;
        ObricListeningMainProcessManager.f385330a.getClass();
        ObricListeningMainProcessManager.k(new w0());
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowHide() {
        int r100 = b.f542084a;
        ObricListeningMainProcessManager.f385330a.getClass();
        ObricListeningMainProcessManager.k(new w0());
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowPreDismiss() {
        int r100 = b.f542084a;
        ObricListeningMainProcessManager.f385330a.getClass();
        ObricListeningMainProcessManager.k(new w0());
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onWindowPreHide() {
        int r100 = b.f542084a;
        ObricListeningMainProcessManager.f385330a.getClass();
        ObricListeningMainProcessManager.k(new w0());
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
    public final void onWindowShow() {
        IBehavior.DefaultImpls.onWindowShow(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public final void onScreenRotationChanged(int r100, int r101) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r100, r101);
    }
}
