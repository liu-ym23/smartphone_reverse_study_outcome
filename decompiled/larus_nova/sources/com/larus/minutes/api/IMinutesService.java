package com.larus.minutes.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.dtf.face.config.IConstValues;
import com.larus.avlink.record.util.LarkRecordMinutesManager;
import com.larus.avlink.record.util.LarkRecordMinutesManager$startRecordByLarkSdk$2;
import com.larus.avlink.record.util.i;
import com.larus.home.impl.sdk.u1;
import com.larus.home.impl.sdk.v1;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import yk9.c;
import yk9.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&JR\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H&JR\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H&J$\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH¦@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000bH&J\u001c\u0010!\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000bH&JX\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020(2\b\b\u0002\u0010,\u001a\u00020-2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/H&J\b\u00101\u001a\u00020\u0003H&J\b\u00102\u001a\u00020\u0003H&J\u0014\u00103\u001a\u00020\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000bH&J\b\u00105\u001a\u000206H&J\u000e\u00107\u001a\b\u0012\u0004\u0012\u0002060/H&J\b\u00108\u001a\u000206H&J\b\u00109\u001a\u000206H&J\b\u0010:\u001a\u000206H&J\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH&J0\u0010<\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020=2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000bH&J\u001e\u0010A\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020-\u0018\u00010B\u0018\u00010/H&J\u001e\u0010C\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010B\u0018\u00010/H&J\n\u0010D\u001a\u0004\u0018\u00010\u000bH&J\n\u0010E\u001a\u0004\u0018\u00010\u000bH&J\b\u0010F\u001a\u00020\u000bH&J*\u0010G\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0018\u00010H\u0018\u00010/H¦@¢\u0006\u0002\u0010\u001fJ\u001a\u0010I\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010J\u001a\u000206H&J\u0018\u0010K\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010L\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010M\u001a\u00020\u0003H&J\b\u0010N\u001a\u00020\u0003H&J\b\u0010O\u001a\u000206H&J\b\u0010P\u001a\u000206H&¨\u0006Q"}, d2 = {"Lcom/larus/minutes/api/IMinutesService;", "", "initSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "destroySdk", "startRecording", "activity", "Landroidx/fragment/app/Fragment;", "conversationId", "", "messageId", "sourceLanguage", "mobParams", "", "extraParams", "callback", "Lcom/larus/minutes/api/IStartRecordCallback;", "startStandaloneAIInterpretation", "startHardwareRecording", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/minutes/api/MinutesHardwareRecordingContext;", "audioSource", "Lcom/larus/minutes/api/IMinutesExternalAudioSource;", "retryHardwareRecording", "recordingId", "doubaoBizInfoJson", "getOfflineRecordingList", "", "Lcom/larus/minutes/api/MinutesOfflineRecordingItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeOfflineRecording", "uploadOfflineRecording", "doubaoBizInfo", "uploadExternalOpusFile", "rawOpusPath", IConstValues.DEVICE_TYPE, "Lcom/larus/minutes/api/MinutesOfflineRecordingDeviceType;", "channels", "", "sampleRate", "bitrateBps", "frameMs", "durationMs", "", "getOfflineRecordingUploadProgressStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/minutes/api/MinutesOfflineRecordingUploadState;", "pauseRecording", "resumeRecording", "stopRecording", "from", "isRecordingOrInterpretationInProgress", "", "getRecordingOrInterpretationInProgressFlow", "isStandaloneAIInterpretationInProgress", "isSoftwareRecording", "isHardwareRecording", "normalizeRecordingId", "openRecordingPage", "Landroid/content/Context;", "openSource", "isGeneralAgent", "chatId", "getAudioRecordingDurationStateFlow", "Lkotlin/Pair;", "getAsrResultStateFlow", "getCurrentRecordingId", "getCurrentRecordingMsgId", "getDeviceId", "getAudioRecordingStatusStateFlow", "Lkotlin/Triple;", "sendClickActionBarEvent", "isStandaloneAIInterpretation", "sendRecordingCardShowEvent", "clearRecordingTraceSession", "initOfficeSdkIfNeeded", "restoreMinutesSDKIfNeeded", "needRestoreMinutesSdk", "isMinutesSdkInited", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMinutesService {
    void A0(String r100, String r101);

    void B0();

    void C0(String r100, String r101);

    void D0(c r100, LarkRecordMinutesManager.b r101, LarkRecordMinutesManager$startRecordByLarkSdk$2 r102);

    StateFlowImpl E0();

    String F0(String r100);

    void G0(String r100, String r101, i r102);

    boolean H0();

    StateFlowImpl I0();

    void J0(String r100);

    void K0(Fragment r100, String r101, String r102, String r103, Map r104, String r105, u1 r106);

    boolean L0();

    boolean M0();

    void N0();

    void O0();

    void P0();

    void Q0(Context r100, String r101, String r102, String r103, String r104);

    void R0(Fragment r100, String r101, String r102, String r103, Map r104, String r105, v1 r106);

    void S0();

    void T0(String r100, MinutesOfflineRecordingDeviceType r101, int r102, int r103, int r104, int r105, long r106, String r107);

    StateFlowImpl U0();

    void V0(OfficeSDKUserApi r100);

    void a(String r100);

    String getDeviceId();

    boolean j();

    String k();

    b1 l();

    boolean m();

    void n(String r100);

    void o(String r100, boolean r101);

    Object x0(Continuation<? super List<d>> r100);

    boolean y0();

    b1 z0();
}
