package com.obric.assistant.spi.keyguard;

import android.content.ComponentName;
import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import oga.b;
import oga.g;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J:\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001fH\u0016J\b\u0010 \u001a\u00020\u0013H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006!"}, d2 = {"Lcom/obric/assistant/spi/keyguard/KeyguardService;", "Lcom/obric/assistant/spi/keyguard/IKeyguardService;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/assistant/spi/keyguard/IKeyguardService;", "impl$delegate", "Lkotlin/Lazy;", "registerDismissKeyguardChangedListener", "", "listener", "Lcom/obric/assistant/spi/keyguard/IDismissKeyguardStatusListener;", "unregisterDismissKeyguardChangedListener", "cancelDismissKeyguard", "requestDismissKeyguard", "callback", "Lcom/obric/assistant/spi/keyguard/DismissKeyguardCallback;", "fastFailWhenAppBackground", "", "playTts", "allowBiometricUnlock", "autoPopupWindow", "reportParams", "Landroid/os/Bundle;", "getHelperActivityName", "", "getHelperActivityComponentName", "Landroid/content/ComponentName;", "isKeyguardLocked", "isDismissingKeyguard", "Lkotlinx/coroutines/flow/StateFlow;", "isRequestingDismissKeyguard", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyguardService implements IKeyguardService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KeyguardService f392886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f392887b = null;

    private KeyguardService() {
    }

    static {
        f392886a = new KeyguardService();
        f392887b = LazyKt.lazy(new g());
    }

    public static IKeyguardService a() {
        return (IKeyguardService) f392887b.getValue();
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final void cancelDismissKeyguard() {
        IKeyguardService r100 = a();
        if (r100 == null) goto L6;
        r100.cancelDismissKeyguard();
        return;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final ComponentName getHelperActivityComponentName() {
        IKeyguardService r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHelperActivityComponentName();
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final String getHelperActivityName() {
        IKeyguardService r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHelperActivityName();
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final i1<Boolean> isDismissingKeyguard() {
        IKeyguardService r100 = a();
        if (r100 == null) goto L7;
        i1<Boolean> r101 = r100.isDismissingKeyguard();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return j1.a(Boolean.FALSE);
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final boolean isKeyguardLocked() {
        IKeyguardService r100 = a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isKeyguardLocked();
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final boolean isRequestingDismissKeyguard() {
        IKeyguardService r100 = a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isRequestingDismissKeyguard();
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final void registerDismissKeyguardChangedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        IKeyguardService r101 = a();
        if (r101 == null) goto L6;
        r101.registerDismissKeyguardChangedListener(r100);
        return;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final void unregisterDismissKeyguardChangedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        IKeyguardService r101 = a();
        if (r101 == null) goto L6;
        r101.unregisterDismissKeyguardChangedListener(r100);
        return;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public final void requestDismissKeyguard(oga.a r100, boolean r110, boolean r111, boolean r112, boolean r113, Bundle r114) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IKeyguardService r101 = a();
        if (r101 == null) goto L5;
        r101.requestDismissKeyguard(r100, r110, r111, r112, r113, r114);
        return;
    L5:
        r100.onDismissSucceeded();
    }
}
