package com.obric.assistant.spi.audio;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.call.mgr.MajorState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\nH\u0016¨\u0006("}, d2 = {"Lcom/obric/assistant/spi/audio/DefaultObricAsrServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricAsrService;", "<init>", "()V", "getBusinessType", "", "getRealtimeBusinessType", "getAsrAudioRecordSource", "audioSource", "addVoiceAuthenSessionToMap", "", "taskid", "", "sessionId", "getVoiceAuthenSessionIdFromTaskId", "enableBackTraceAudioRecorder", "", "canUpdatePersonalContextToAsr", "getPersonalContextInfo", "isPersonalContextCompleted", "setAudioFileUri", RemoteMessageConst.MSGID, "fileUri", "isAiKeyPressing", "isDoraPressing", "onClickTalkStateChange", "value", "getEnablePvadCheck", "setVoicePrintState", "speakerMatch", "getDeviceUuid", "onMajorStateChanged", "prev", "", "current", "getVoicePrintAuthSessionIdOrNull", "isDefaultAssistant", "isAccessibilityServiceEnabled", "onCloseClickTalk", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricAsrServiceImpl implements IObricAsrService {

    public static final class a {
    }

    static {
    }

    public DefaultObricAsrServiceImpl() {
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean a() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean b() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final String c() {
        return "";
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void e(MajorState r100, MajorState r101) {
        Intrinsics.checkNotNullParameter(r100, "prev");
        Intrinsics.checkNotNullParameter(r101, "current");
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final int f() {
        return 1;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final String g() {
        return null;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final int getBusinessType() {
        return 0;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void h(String r100, String r101) {
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final String i(String r100) {
        return null;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean isAiKeyPressing() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean j() {
        return true;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean k() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void l(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "taskid");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean m() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final int n() {
        return 1;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void o() {
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean p() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final boolean q() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final String r() {
        return "";
    }

    @Override // com.obric.assistant.spi.audio.IObricAsrService
    public final void s(boolean r100) {
    }
}
