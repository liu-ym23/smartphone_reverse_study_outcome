package com.obric.assistant.interaction.impl.window.behaviors;

import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.window.IBehavior;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/RemoveTopChatActivityBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowPreShow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoveTopChatActivityBehavior implements IBehavior {
    public RemoveTopChatActivityBehavior() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void init() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreShow() {
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L5;
        return;
    L5:
        LockedTopChatActivityCleaner.INSTANCE.removeIfNeeded("windowPreShow", true);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowHide() {
        IBehavior.DefaultImpls.onWindowHide(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowShow() {
        IBehavior.DefaultImpls.onWindowShow(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onScreenRotationChanged(int r100, int r101) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r100, r101);
    }
}
