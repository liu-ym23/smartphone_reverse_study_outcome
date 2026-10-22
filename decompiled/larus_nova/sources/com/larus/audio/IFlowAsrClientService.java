package com.larus.audio;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.asr.s2;
import com.larus.asr.t2;
import com.larus.asr.u2;
import com.larus.audio.audiov3.audio.record.AsrClientStatus;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\bg\u0018\u0000 I2\u00020\u0001:\u0001IJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J8\u0010\u0013\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\rH&J\\\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b28\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u009a\u0001\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2:\b\u0002\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001d2:\b\u0002\u0010$\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020%\u0018\u00010\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H&J\u001c\u0010&\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010'\u001a\u00020(2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010)\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010*\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0,H&J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0,H&J\u0012\u0010.\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010/\u001a\u0002002\u0006\u0010\f\u001a\u00020\rH&J6\u00101\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010\u00012\b\u00104\u001a\u0004\u0018\u00010\u00012\b\u00105\u001a\u0004\u0018\u00010\u0001H&J\u0010\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000208H&J\u0018\u00109\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001bH&J\u001a\u0010:\u001a\u0004\u0018\u00010%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001bH&J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020%H&J\u0018\u0010=\u001a\u00020!2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001bH&JK\u0010>\u001a\u00020?2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010@\u001a\u00020A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00072%\b\u0002\u0010C\u001a\u001f\u0012\u0013\u0012\u00110E¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u0005\u0018\u00010DH&Jl\u0010>\u001a\u00020?2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u00072#\u0010C\u001a\u001f\u0012\u0013\u0012\u00110E¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u0005\u0018\u00010D2#\u0010G\u001a\u001f\u0012\u0013\u0012\u00110(¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\u0005\u0018\u00010DH\u0016¨\u0006J"}, d2 = {"Lcom/larus/audio/IFlowAsrClientService;", "", "getRecordStatus", "Lcom/larus/audio/audiov3/audio/record/AsrClientStatus;", "addAsrAudioDataListener", "", "listener", "Lcom/larus/audio/audiov3/asr/AsrAudioDataListener;", "releaseAudioRecordFinal", "addAsrStateListener", "Lcom/larus/audio/audiov3/asr/AsrStateListener;", "configTracer", DBDefinition.TASK_ID, "", "tracer", "Lcom/larus/audio/report/IAsrTracer;", "setAsrRetryStrategy", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/larus/audio/audiov3/asr/strategy/AsrRetryStrategy;", "configAsrSenseReporter", "asrMode", "language", RXScreenCaptureService.KEY_INDEX, "", "botId", "startAsr", "asrData", "Lcom/larus/audio/audiov3/config/task/sami/asr/AsrConfig;", "dataSourceProvider", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "asrConfig", "Lcom/larus/audio/audiov3/task/asr/IAsrDataSource;", "asrListener", "Lcom/larus/audio/audiov3/task/asr/IAsrListener;", "taskProvider", "Lcom/larus/audio/audiov3/task/asr/IAsrTask;", "handleResend", "stopAsr", "", "cancelAsr", "releaseAsrTask", "getTaskIds", "", "getRunningTaskIds", "getAsrConfig", "getRecordAudioDuration", "", "updateScreenshotForAsr", PerfLog.PARAM_KEY_CONTEXT_ID, "id", "type", "param", "registerAsrTaskFactory", "factory", "Lcom/larus/audio/audiov3/task/asr/IAsrTaskFactory;", "createAsrTask", "createManagedAsrTask", "releaseManagedAsrTask", "task", "createDefaultAsrDataSource", "createAudioRecord", "Lcom/bytedance/flow_audio/api/foundation/record/IAudioRecord;", "config", "Lcom/bytedance/flow_audio/api/config/session/FlowAudioSessionConfig;", "audioDataListener", "firstAudioDataListener", "Lkotlin/Function1;", "", "data", "audioFileSaveResultListener", "success", "Companion", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowAsrClientService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f288298a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f288299a = null;

        static {
            f288299a = new a();
        }

        public a() {
        }

        public static IFlowAsrClientService a() {
            return (IFlowAsrClientService) ServiceManager.get().getService(IFlowAsrClientService.class);
        }
    }

    static {
        f288298a = a.f288299a;
    }

    void a(String r100, y58.a r101, Function2 r102, Function2 r103, com.larus.audio.asr.i r104);

    void b(String r100, y58.a r101);

    h68.e c(String r100, y58.a r101);

    void d(n58.a r100);

    h68.e e(String r100, y58.a r101);

    void f(String r100);

    y58.a g(String r100);

    void h(o58.b r100);

    void i(String r100, com.larus.audio.report.h r101);

    void j(String r100);

    com.larus.audio.asr.r0 k(String r100, y58.a r101);

    com.larus.audio.asr.r l(String r100, qw5.a r101, s2 r102, t2 r103, u2 r104);

    void m();

    List<String> n();

    List<String> o();

    long p(String r100);

    void q(String r100, String r101, Object r102, Object r103, Object r104);

    boolean r(String r100);

    void s(String r100, String r101, String r102, int r103, String r104);

    AsrClientStatus t();

    void u(com.larus.audio.asr.w r100);

    void v(h68.e r100);
}
