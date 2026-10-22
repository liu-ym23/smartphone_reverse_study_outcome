package com.obric.assistant.spi.interact;

import androidx.fragment.app.FragmentManager;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0012H\u0096\u0001J\u001d\u0010\u001d\u001a\u00020\u00122\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u001fH\u0096\u0001J\t\u0010 \u001a\u00020\u0012H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0014H\u0096\u0001J\t\u0010'\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0005H\u0096\u0001¨\u0006*"}, d2 = {"Lcom/obric/assistant/spi/interact/ObricInteractDelegate;", "Lcom/obric/assistant/spi/interact/IObricInteractService;", "<init>", "()V", "getRelaunchEvent", "", "()Ljava/lang/Boolean;", "getWakeupSource", "isAiKeyLongPress", "isAiKeyPressing", "isAiKeyShortPress", "isContLockScreenQueryReply", "msg", "Lcom/larus/im/bean/message/Message;", "isNeedAutoUploadScreenshotWhenQuery", "isNeedUpdatePageState", "isShowAuthResult", "notifyAiKeyEvent", "", "aiKeyPressEvent", "", "notifyChangeWindowEvent", "isFull", "notifyRelaunchEvent", "isFromRelaunch", "notifyWakeupEvent", "isWakeup", "playDeactivate", "playWarning", "registerOnWindowChangeEventCallback", "callback", "Lkotlin/Function1;", "resetIsAiKeyLongPress", "setAlreadyShowAuthResult", "isAlreadyShowAuthResult", "shouldRecoverMainFragmentAfterRestore", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "containerId", "unregisterOnWindowChangeEventCallback", "updateMuteStatus", ITTVideoEngineEventSource.KEY_MUTE, "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractDelegate implements IObricInteractService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricInteractDelegate f392884b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricInteractService f392885a;

    static {
        f392884b = new ObricInteractDelegate();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean getRelaunchEvent() {
        return this.f392885a.getRelaunchEvent();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean getWakeupSource() {
        return this.f392885a.getWakeupSource();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isAiKeyLongPress() {
        return this.f392885a.isAiKeyLongPress();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isAiKeyPressing() {
        return this.f392885a.isAiKeyPressing();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isAiKeyShortPress() {
        return this.f392885a.isAiKeyShortPress();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final boolean isContLockScreenQueryReply(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        return this.f392885a.isContLockScreenQueryReply(r100);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final Boolean isNeedUpdatePageState() {
        return this.f392885a.isNeedUpdatePageState();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyAiKeyEvent(int r100) {
        this.f392885a.notifyAiKeyEvent(r100);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyChangeWindowEvent(boolean r100) {
        this.f392885a.notifyChangeWindowEvent(r100);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyRelaunchEvent(boolean r100) {
        this.f392885a.notifyRelaunchEvent(r100);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void notifyWakeupEvent(boolean r100) {
        this.f392885a.notifyWakeupEvent(r100);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void resetIsAiKeyLongPress() {
        this.f392885a.resetIsAiKeyLongPress();
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void setAlreadyShowAuthResult(boolean r100) {
        this.f392885a.setAlreadyShowAuthResult(false);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final boolean shouldRecoverMainFragmentAfterRestore(FragmentManager r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        return this.f392885a.shouldRecoverMainFragmentAfterRestore(r100, R.id.fragment_container);
    }

    @Override // com.obric.assistant.spi.interact.IObricInteractService
    public final void updateMuteStatus(boolean r100) {
        this.f392885a.updateMuteStatus(r100);
    }

    private ObricInteractDelegate() {
        IObricInteractService r100 = (IObricInteractService) ServiceManager.get().getService(IObricInteractService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultInteractServiceImpl();
    L5:
        this.f392885a = r100;
    }
}
