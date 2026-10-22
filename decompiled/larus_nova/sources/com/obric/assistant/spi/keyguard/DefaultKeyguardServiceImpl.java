package com.obric.assistant.spi.keyguard;

import android.content.ComponentName;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import oga.b;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J:\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001aH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/spi/keyguard/DefaultKeyguardServiceImpl;", "Lcom/obric/assistant/spi/keyguard/IKeyguardService;", "<init>", "()V", "registerDismissKeyguardChangedListener", "", "listener", "Lcom/obric/assistant/spi/keyguard/IDismissKeyguardStatusListener;", "unregisterDismissKeyguardChangedListener", "requestDismissKeyguard", "callback", "Lcom/obric/assistant/spi/keyguard/DismissKeyguardCallback;", "fastFailWhenAppBackground", "", "playTts", "allowBiometricUnlock", "autoPopupWindow", "reportParams", "Landroid/os/Bundle;", "cancelDismissKeyguard", "getHelperActivityName", "", "getHelperActivityComponentName", "Landroid/content/ComponentName;", "isKeyguardLocked", "isDismissingKeyguard", "Lkotlinx/coroutines/flow/StateFlow;", "isRequestingDismissKeyguard", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultKeyguardServiceImpl implements IKeyguardService {
    public DefaultKeyguardServiceImpl() {
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final void cancelDismissKeyguard() {
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final ComponentName getHelperActivityComponentName() {
        return null;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final String getHelperActivityName() {
        return null;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final boolean isKeyguardLocked() {
        return false;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final boolean isRequestingDismissKeyguard() {
        return false;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final void registerDismissKeyguardChangedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final void unregisterDismissKeyguardChangedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final i1<Boolean> isDismissingKeyguard() {
        return j1.a(Boolean.FALSE);
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final void requestDismissKeyguard(oga.a r100, boolean r101, boolean r102, boolean r103, boolean r104, Bundle r105) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        r100.onDismissSucceeded();
    }
}
