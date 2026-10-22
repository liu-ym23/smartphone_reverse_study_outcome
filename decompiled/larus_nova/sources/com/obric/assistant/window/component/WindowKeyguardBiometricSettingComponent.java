package com.obric.assistant.window.component;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.keyguard.BiometricState;
import com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting;
import com.obric.assistant.interaction.api.keyguard.RequestSource;
import com.obric.assistant.spi.window.WindowOpenSource;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/window/component/WindowKeyguardBiometricSettingComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "<init>", "()V", "keyguardBiometricSetting", "Lcom/obric/assistant/interaction/api/keyguard/IKeyguardBiometricSetting;", "getKeyguardBiometricSetting", "()Lcom/obric/assistant/interaction/api/keyguard/IKeyguardBiometricSetting;", "keyguardBiometricSetting$delegate", "Lkotlin/Lazy;", WidgetCostModule.TYPE_ON_CREATE, "", LiveCommonConstants.REASON_ON_DEDTROY, "onWindowOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "onWindowStashed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowKeyguardBiometricSettingComponent extends ComponentFeature implements wga.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f394762i = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f394763h;

    public static final class a {
    }

    static {
    }

    @Override // wga.b
    public final void onScreenRotationChanged(int r100, int r101) {
    }

    @Override // wga.b
    public final void onWindowDismissed() {
    }

    @Override // wga.b
    public final void onWindowPreDismissed() {
    }

    @Override // wga.b
    public final void onWindowPreOpenClear() {
    }

    @Override // wga.b
    public final void onWindowPreStashed() {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        FLogger.f375446a.i("WindowKeyguardBiometricSettingComponent", WidgetCostModule.TYPE_ON_CREATE);
        IAssistantChatWindow r100 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r100 == null) goto L6;
        r100.addWindowLifecycleListener(this);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        FLogger.f375446a.i("WindowKeyguardBiometricSettingComponent", LiveCommonConstants.REASON_ON_DEDTROY);
        IAssistantChatWindow r100 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r100 == null) goto L6;
        r100.removeWindowLifecycleListener(this);
        return;
    }

    @Override // wga.b
    public final void onWindowStashed() {
        FLogger.f375446a.i("WindowKeyguardBiometricSettingComponent", "onWindowStashed");
        IKeyguardBiometricSetting r100 = (IKeyguardBiometricSetting) this.f394763h.getValue();
        if (r100 == null) goto L6;
        r100.cancelRequestBiometricState(RequestSource.WINDOW);
        return;
    }

    public WindowKeyguardBiometricSettingComponent() {
        this.f394763h = LazyKt.lazy(new m0());
    }

    @Override // wga.b
    public final void onWindowOpened(WindowOpenSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        FLogger.f375446a.i("WindowKeyguardBiometricSettingComponent", "onWindowOpened, source = " + r100);
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L8;
        IKeyguardBiometricSetting r101 = (IKeyguardBiometricSetting) this.f394763h.getValue();
        if (r101 == null) goto L9;
        r101.requestBiometricState(RequestSource.WINDOW, BiometricState.DISABLED);
        return;
    L9:
        return;
    }

    @Override // wga.b
    public final void onWindowPreOpened(WindowOpenSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }
}
