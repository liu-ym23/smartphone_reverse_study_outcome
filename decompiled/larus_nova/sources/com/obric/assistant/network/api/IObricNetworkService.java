package com.obric.assistant.network.api;

import com.bytedance.android.ec.core.event.a;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import com.obric.assistant.settings.v;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import vea.l;
import vea.m;
import vea.n;
import vea.p;
import vea.q;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&JD\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012H&JD\u0010\u0014\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012H&J>\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012H&J\"\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J0\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\fH¦@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u0004\u0018\u00010'H¦@¢\u0006\u0002\u0010%J\u001a\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u001e2\b\b\u0002\u0010\u0019\u001a\u00020\u0013H&J<\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00132\u0010\u0010-\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J&\u0010.\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0013H¦@¢\u0006\u0002\u00101J\b\u00102\u001a\u000203H&J\u0010\u00104\u001a\u0004\u0018\u000105H¦@¢\u0006\u0002\u0010%J\u001e\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u0013H¦@¢\u0006\u0002\u00109J\u001c\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00130\fH¦@¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\tH&J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\tH&J\u0012\u0010A\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010C\u001a\u0004\u0018\u00010DH¦@¢\u0006\u0002\u0010%J\u0016\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH¦@¢\u0006\u0002\u0010GJ\u000e\u0010H\u001a\u00020IH¦@¢\u0006\u0002\u0010%J\u0016\u0010J\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH¦@¢\u0006\u0002\u0010GJ\u0010\u0010K\u001a\u0004\u0018\u00010LH¦@¢\u0006\u0002\u0010%J\u0016\u0010M\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020LH¦@¢\u0006\u0002\u0010NJ6\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0010\u0010-\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&Jz\u0010Q\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010\u00132\b\u0010S\u001a\u0004\u0018\u00010\u00132\u0006\u0010T\u001a\u0002032\b\u0010U\u001a\u0004\u0018\u00010\u00132\b\u0010V\u001a\u0004\u0018\u00010\u00132\b\u0010W\u001a\u0004\u0018\u00010\u00132\b\u0010X\u001a\u0004\u0018\u00010\u00132\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f2\b\u0010Z\u001a\u0004\u0018\u00010\u00132\b\u0010[\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0082\u0001\u0010\\\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010\u00132\b\u0010S\u001a\u0004\u0018\u00010\u00132\u0006\u0010T\u001a\u0002032\b\u0010U\u001a\u0004\u0018\u00010\u00132\b\u0010V\u001a\u0004\u0018\u00010\u00132\b\u0010W\u001a\u0004\u0018\u00010\u00132\b\u0010X\u001a\u0004\u0018\u00010\u00132\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f2\b\u0010Z\u001a\u0004\u0018\u00010\u00132\b\u0010[\u001a\u0004\u0018\u00010\u00132\u0006\u0010]\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J¢\u0001\u0010^\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010\u00132\b\u0010S\u001a\u0004\u0018\u00010\u00132\u0006\u0010T\u001a\u0002032\b\u0010U\u001a\u0004\u0018\u00010\u00132\b\u0010_\u001a\u0004\u0018\u00010\u00132\b\u0010`\u001a\u0004\u0018\u00010\u00132\b\u0010a\u001a\u0004\u0018\u00010\u00132\b\u0010b\u001a\u0004\u0018\u00010\u00132\b\u0010c\u001a\u0004\u0018\u00010\u00132\b\u0010W\u001a\u0004\u0018\u00010\u00132\b\u0010X\u001a\u0004\u0018\u00010\u00132\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f2\b\u0010Z\u001a\u0004\u0018\u00010\u00132\b\u0010[\u001a\u0004\u0018\u00010\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&Jª\u0001\u0010d\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010\u00132\b\u0010S\u001a\u0004\u0018\u00010\u00132\u0006\u0010T\u001a\u0002032\b\u0010U\u001a\u0004\u0018\u00010\u00132\b\u0010_\u001a\u0004\u0018\u00010\u00132\b\u0010`\u001a\u0004\u0018\u00010\u00132\b\u0010a\u001a\u0004\u0018\u00010\u00132\b\u0010b\u001a\u0004\u0018\u00010\u00132\b\u0010c\u001a\u0004\u0018\u00010\u00132\b\u0010W\u001a\u0004\u0018\u00010\u00132\b\u0010X\u001a\u0004\u0018\u00010\u00132\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f2\b\u0010Z\u001a\u0004\u0018\u00010\u00132\b\u0010[\u001a\u0004\u0018\u00010\u00132\u0006\u0010]\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u001a\u0010e\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J(\u0010g\u001a\u00020\u00032\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J,\u0010h\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00132\u0010\u0010-\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J<\u0010i\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&JÌ\u0001\u0010j\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00132\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u00132\u0012\b\u0002\u0010-\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00122\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u001c\u0010x\u001a\u00020\u00032\u0006\u0010y\u001a\u00020z2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J0\u0010{\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00132\u0012\b\u0002\u0010-\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00122\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¨\u0006|"}, d2 = {"Lcom/obric/assistant/network/api/IObricNetworkService;", "", "init", "", "initNetworkRestrict", "config", "Lcom/larus/network/config/BackgroundControlConfig;", "triggerBackgroundNetworkRestrictIfNeeded", "isNetworkAvailable", "", "uploadIntentResultForCompensationByHttp", "intentResult", "", "Lcom/obric/aiagent/assistant/idl/bean/OPushEvent;", "needRetry", "callback", "Lcom/obric/aiagent/assistant/idl/IFlowNetworkResultCallbackIDL;", "performanceExtras", "", "", "uploadIntentResultForAsyncNotifyByHttp", "uploadIntentResultForAsyncNotifyByHttpOptimized", "bodyBytes", "", "uploadNormalRouterByHttp", "scene", "passThrough", "getComplexTaskPanelInfo", "Lcom/obric/assistant/network/api/bean/ObricComplexTaskData;", "uid", "", a.KEY_DID, "updateVersionCode", "infoType", "(JJJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOperationInstructions", "Lcom/obric/assistant/network/api/bean/OperationInstruction;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOmniModelConfig", "Lcom/obric/assistant/network/api/bean/ObricOmniModelConfig;", "notifyStopComplexTaskByHttp", RemoteMessageConst.MSGID, "replyAskUser", "askContent", "userAnswer", "extra", "checkRomVersionCompatible", DBDefinition.APP_VERSION_CODE, "romVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentNetworkStatus", "", "getAutoActionAppBlacklist", "Lcom/obric/assistant/settings/ObricGetAppBlacklistResponse;", "reportODidRelation", "appId", "attCertChain", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreImage", "Lcom/obric/assistant/network/api/bean/ObricRestoreImageResult;", "uriList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPreconnectEnabled", "enabled", "setTTNetBgcpEnabled", "allowedToDisplayPrivateUrl", RuleConditionBean.OPEN_URL_KEY, "getPrivacyConversationContentConfig", "Lcom/obric/assistant/network/api/bean/ObricPrivacyConversationContentConfig;", "setPrivacyConversationContentConfig", "conversationContentModelTrainingEnable", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVoiceWakeupImprovementConfig", "Lcom/obric/assistant/network/api/bean/ObricVoiceWakeupImprovementConfigResult;", "setVoiceWakeupImprovementConfig", "getReferenceMemoryConfig", "Lcom/obric/assistant/network/api/bean/ObricReferenceMemoryConfig;", "setReferenceMemoryConfig", "(Lcom/obric/assistant/network/api/bean/ObricReferenceMemoryConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takeOverChanged", "id", "uploadOmniScreenshotByHttp", DBDefinition.TASK_ID, "toolId", DecodeProducer.EXTRA_IMAGE_COUNT, "imagePath", "mime", "source", "feedbackContent", "feedbackTags", "type", a.KEY_SCORE, "uploadOmniScreenshotByHttpV2", "isFinish", "uploadOmniDataFeedbackByHttp", "imageMime", "viewTreePath", "viewTreeMime", "reactViewTreePath", "reactViewTreeMime", "uploadOmniDataFeedbackByHttpV2", "operateQueue", "data", "clearOmniTasks", "notifyStopOmniTaskByHttp", "inUserAdditionState", "createConditionalTask", "oOmniInstructionType", "createType", "instruction", "originQuery", "shortQuery", "createTime", UserInfo.UPDATE_TIME, "knowledge", "automaticFields", "operateType", "discoveryId", "discoveryQuery", "userSelectModel", "sweepConditionalTask", "request", "Lcom/obric/aiagent/assistant/idl/bean/ObricConditionalTaskSweepRequest;", "deleteConditionalTask", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricNetworkService {
    boolean a(String r100);

    void b(String r100, String r101, Map<String, String> r102, IFlowNetworkResultCallbackIDL r103);

    void c(String r100, String r101, Map<?, ?> r102, IFlowNetworkResultCallbackIDL r103);

    void clearOmniTasks(Map<String, String> r100, IFlowNetworkResultCallbackIDL r101);

    void createConditionalTask(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, String r113, String r114, Map<?, ?> r115, IFlowNetworkResultCallbackIDL r116);

    void d(String r100, String r101, IFlowNetworkResultCallbackIDL r102);

    void deleteConditionalTask(String r100, Map<?, ?> r101, IFlowNetworkResultCallbackIDL r102);

    void e(List<OPushEvent> r100, boolean r101, IFlowNetworkResultCallbackIDL r102, Map<String, ? extends Object> r103);

    void f(boolean r100);

    void g(byte[] r100, boolean r101, IFlowNetworkResultCallbackIDL r102, Map<String, ? extends Object> r103);

    int getCurrentNetworkStatus();

    Object getOmniModelConfig(Continuation<? super ObricOmniModelConfig> r100);

    Object getOperationInstructions(Continuation<? super List<q>> r100);

    void h(String r100, IFlowNetworkResultCallbackIDL r101);

    Object i(Continuation<? super m> r100);

    void init();

    boolean isNetworkAvailable();

    Object j(m r100, Continuation<? super Boolean> r101);

    Object k(String r100, String r101, Continuation<? super Boolean> r102);

    void l(List<OPushEvent> r100, boolean r101, IFlowNetworkResultCallbackIDL r102, Map<String, ? extends Object> r103);

    void m(boolean r100);

    Object n(List<String> r100, Continuation<? super n> r101);

    void o(long r100, String r101, String r102, Map<?, ?> r103, IFlowNetworkResultCallbackIDL r104);

    Object p(Continuation<? super p> r100);

    void q(long r100, String r101);

    Object r(boolean r100, Continuation<? super Boolean> r101);

    Object s(Continuation<? super v> r100);

    void sweepConditionalTask(ObricConditionalTaskSweepRequest r100, IFlowNetworkResultCallbackIDL r101);

    Object t(boolean r100, Continuation<? super Boolean> r101);

    Object u(String r100, String r101, String r102, Continuation<? super Boolean> r103);

    void uploadOmniDataFeedbackByHttp(String r100, String r101, int r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, List<String> r112, String r113, String r114, IFlowNetworkResultCallbackIDL r115);

    void uploadOmniDataFeedbackByHttpV2(String r100, String r101, int r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, List<String> r112, String r113, String r114, boolean r115, IFlowNetworkResultCallbackIDL r116);

    void uploadOmniScreenshotByHttp(String r100, String r101, int r102, String r103, String r104, String r105, String r106, List<String> r107, String r108, String r110, IFlowNetworkResultCallbackIDL r111);

    void uploadOmniScreenshotByHttpV2(String r100, String r101, int r102, String r103, String r104, String r105, String r106, List<String> r107, String r108, String r110, boolean r111, IFlowNetworkResultCallbackIDL r112);

    void v(String r100);

    Object w(Continuation<? super l> r100);
}
