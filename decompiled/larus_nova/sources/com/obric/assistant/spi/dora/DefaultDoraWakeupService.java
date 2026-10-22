package com.obric.assistant.spi.dora;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016¨\u0006!"}, d2 = {"Lcom/obric/assistant/spi/dora/DefaultDoraWakeupService;", "Lcom/obric/assistant/spi/dora/IDoraWakeupService;", "<init>", "()V", "handleDoraWakeup", "", "type", "Lcom/obric/assistant/spi/dora/IDoraWakeupService$WakeupType;", "vuiId", "", "needUpdate", "", "onQueryStop", "onSingleClick", "cancel", "setStopVUIWhenTtsEnd", "stop", "isInRadioPressing", "isInDoraVoiceWakeup", "setObricContTalkActive", "isActive", "isObricContTalkActive", "stopVUI", "stopVUIWhenTimeout", "setUseDefaultDora", "useDefault", "getUseDefaultDora", "doraSupportFeatureOTA3P5", "notifyDoraWakeupForEnroll", "notifyDoraGWakeupState", "isInWakeup", "isInDoraGWakeup", "isDoraProxyWakeup", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultDoraWakeupService implements IDoraWakeupService {
    public DefaultDoraWakeupService() {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void a() {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean b() {
        return false;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean c() {
        return false;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void cancel() {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void d(boolean r100) {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean e() {
        return false;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean f() {
        return true;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean g() {
        return false;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void h() {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void i(boolean r100) {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void j(boolean r100) {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void k(int r100) {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void l(boolean r100) {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void m() {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean n() {
        return false;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final boolean o() {
        return false;
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void p() {
    }

    @Override // com.obric.assistant.spi.dora.IDoraWakeupService
    public final void q(IDoraWakeupService.WakeupType r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
    }
}
