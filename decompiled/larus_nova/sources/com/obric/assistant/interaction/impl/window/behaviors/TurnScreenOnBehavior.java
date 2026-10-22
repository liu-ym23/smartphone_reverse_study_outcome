package com.obric.assistant.interaction.impl.window.behaviors;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/TurnScreenOnBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowPreShow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TurnScreenOnBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final String TAG = "TurnScreenOnBehavior";

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/TurnScreenOnBehavior$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TurnScreenOnBehavior() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void init() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
        if (com.obric.assistant.common.utils.a0.a() == true) goto L6;
        FLogger.f375446a.i(TAG, "turn screen on");
        com.obric.assistant.common.utils.a0.b();
        return;
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
