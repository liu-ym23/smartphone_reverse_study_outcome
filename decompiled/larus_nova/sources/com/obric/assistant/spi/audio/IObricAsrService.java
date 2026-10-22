package com.obric.assistant.spi.audio;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.call.mgr.MajorState;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0014\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\u000eH&J\u001c\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH&J\b\u0010\u0015\u001a\u00020\u000eH&J\b\u0010\u0016\u001a\u00020\u000eH&J\b\u0010\u0017\u001a\u00020\u000eH&J\b\u0010\u0018\u001a\u00020\u000eH&J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000eH&J\b\u0010\u001b\u001a\u00020\u000eH&J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u000eH&J\b\u0010\u001e\u001a\u00020\nH&J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001H&J\n\u0010\"\u001a\u0004\u0018\u00010\nH&J\b\u0010#\u001a\u00020\bH&¨\u0006$"}, d2 = {"Lcom/obric/assistant/spi/audio/IObricAsrService;", "", "getBusinessType", "", "getRealtimeBusinessType", "getAsrAudioRecordSource", "audioSource", "addVoiceAuthenSessionToMap", "", "taskid", "", "sessionId", "getVoiceAuthenSessionIdFromTaskId", "enableBackTraceAudioRecorder", "", "canUpdatePersonalContextToAsr", "getPersonalContextInfo", "isPersonalContextCompleted", "setAudioFileUri", RemoteMessageConst.MSGID, "fileUri", "isAiKeyPressing", "isDefaultAssistant", "isAccessibilityServiceEnabled", "isDoraPressing", "onClickTalkStateChange", "value", "getEnablePvadCheck", "setVoicePrintState", "speakerMatch", "getDeviceUuid", "onMajorStateChanged", "prev", "current", "getVoicePrintAuthSessionIdOrNull", "onCloseClickTalk", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAsrService {
    boolean a();

    boolean b();

    String c();

    void d(String r100, boolean r101);

    void e(MajorState r100, MajorState r101);

    int f();

    String g();

    int getBusinessType();

    void h(String r100, String r101);

    String i(String r100);

    boolean isAiKeyPressing();

    boolean j();

    boolean k();

    void l(String r100, String r101);

    boolean m();

    int n();

    void o();

    boolean p();

    boolean q();

    String r();

    void s(boolean r100);
}
