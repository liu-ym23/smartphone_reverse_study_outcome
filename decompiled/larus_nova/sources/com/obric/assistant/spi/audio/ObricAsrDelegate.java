package com.obric.assistant.spi.audio;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.call.mgr.MajorState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J\t\u0010\u000f\u001a\u00020\rH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0013\u001a\u00020\rH\u0096\u0001J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u0016\u001a\u00020\nH\u0096\u0001J\t\u0010\u0017\u001a\u00020\nH\u0096\u0001J\t\u0010\u0018\u001a\u00020\nH\u0096\u0001J\t\u0010\u0019\u001a\u00020\nH\u0096\u0001J\t\u0010\u001a\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\nH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0096\u0001J\u001d\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0019\u0010%\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\nH\u0096\u0001¨\u0006'"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricAsrDelegate;", "Lcom/obric/assistant/spi/audio/IObricAsrService;", "<init>", "()V", "addVoiceAuthenSessionToMap", "", "taskid", "", "sessionId", "canUpdatePersonalContextToAsr", "", "enableBackTraceAudioRecorder", "getAsrAudioRecordSource", "", "audioSource", "getBusinessType", "getDeviceUuid", "getEnablePvadCheck", "getPersonalContextInfo", "getRealtimeBusinessType", "getVoiceAuthenSessionIdFromTaskId", "getVoicePrintAuthSessionIdOrNull", "isAccessibilityServiceEnabled", "isAiKeyPressing", "isDefaultAssistant", "isDoraPressing", "isPersonalContextCompleted", "onClickTalkStateChange", "value", "onCloseClickTalk", "onMajorStateChanged", "prev", "", "current", "setAudioFileUri", RemoteMessageConst.MSGID, "fileUri", "setVoicePrintState", "speakerMatch", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAsrDelegate implements IObricAsrService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricAsrDelegate f392831b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricAsrService f392832a;

    static {
        f392831b = new ObricAsrDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean a() {
        return this.f392832a.a();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean b() {
        return this.f392832a.b();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final String c() {
        return this.f392832a.c();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f392832a.d(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void e(MajorState r100, MajorState r101) {
        Intrinsics.checkNotNullParameter(r100, "prev");
        Intrinsics.checkNotNullParameter(r101, "current");
        this.f392832a.e(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final int f() {
        return this.f392832a.f();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final String g() {
        return this.f392832a.g();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final int getBusinessType() {
        return this.f392832a.getBusinessType();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void h(String r100, String r101) {
        this.f392832a.h(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final String i(String r100) {
        return this.f392832a.i(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean isAiKeyPressing() {
        return this.f392832a.isAiKeyPressing();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean j() {
        return this.f392832a.j();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean k() {
        return this.f392832a.k();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void l(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "taskid");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        this.f392832a.l(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean m() {
        return this.f392832a.m();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final int n() {
        return this.f392832a.n();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void o() {
        this.f392832a.o();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean p() {
        return this.f392832a.p();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean q() {
        return this.f392832a.q();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final String r() {
        return this.f392832a.r();
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void s(boolean r100) {
        this.f392832a.s(r100);
    }

    private ObricAsrDelegate() {
        IObricAsrService r100 = (IObricAsrService) ServiceManager.get().getService(IObricAsrService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricAsrServiceImpl();
    L5:
        this.f392832a = r100;
    }
}
