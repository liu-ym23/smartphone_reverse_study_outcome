package com.obric.assistant.network.impl;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.larus.network.FlowHttpConnection;
import com.larus.network.HttpConst;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskCreateRequest;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.obric.assistant.network.api.bean.ObricAdditionTaskRequest;
import com.obric.assistant.network.api.bean.ObricClearTaskRequest;
import com.obric.assistant.network.api.bean.ObricConditionalTaskDeleteRequest;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import com.obric.assistant.network.api.bean.ObricOmniUploadImageRequest;
import com.obric.assistant.network.api.bean.ObricOperateQueueRequest;
import com.obric.assistant.network.api.bean.ObricRestoreImageRequest;
import com.obric.assistant.network.api.bean.ObricRestoreImageResponse;
import com.obric.assistant.network.api.bean.ObricStopTaskRequest;
import com.obric.assistant.network.api.bean.ObricUserTakeOverRequest;
import com.obric.assistant.settings.u;
import com.obric.assistant.settings.v;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import vea.r;
import vea.s;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 F2\u00020\u0001:\u0001FJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0015H§@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0019H§@¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0003H§@¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0003H§@¢\u0006\u0002\u0010\u001dJ\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020!H§@¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020$H§@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00032\b\b\u0001\u0010\u0004\u001a\u00020(H§@¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00032\b\b\u0001\u0010\u0004\u001a\u00020,H§@¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020/H§@¢\u0006\u0002\u00100J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u000202H§@¢\u0006\u0002\u00103J\u001e\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u000205H§@¢\u0006\u0002\u00106J\u001e\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u000208H§@¢\u0006\u0002\u00109J\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020;H§@¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020>H§@¢\u0006\u0002\u0010?J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020AH§@¢\u0006\u0002\u0010BJ\u001e\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020DH§@¢\u0006\u0002\u0010E¨\u0006G"}, d2 = {"Lcom/obric/assistant/network/impl/ObricProtocolApi;", "", "uploadIntentResult", "Lcom/larus/network/bean/BizResponse;", "request", "Lcom/obric/assistant/network/api/bean/ObricIntentUplinkRequest;", "(Lcom/obric/assistant/network/api/bean/ObricIntentUplinkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadIntentResultForCompensation", "uploadIntentResultForAsyncNotify", "uploadIntentResultForAsyncNotifyOptimized", ContainerPosition.BODY, "Lcom/bytedance/retrofit2/mime/TypedOutput;", "(Lcom/bytedance/retrofit2/mime/TypedOutput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreImage", "Lcom/obric/assistant/network/api/bean/ObricRestoreImageResponse;", "Lcom/obric/assistant/network/api/bean/ObricRestoreImageRequest;", "(Lcom/obric/assistant/network/api/bean/ObricRestoreImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadNormalRouter", "Lcom/obric/assistant/network/api/bean/ObricNormalUplinkRequest;", "(Lcom/obric/assistant/network/api/bean/ObricNormalUplinkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadOmniScreenshot", "Lcom/obric/assistant/network/api/bean/ObricOmniUploadImageRequest;", "(Lcom/obric/assistant/network/api/bean/ObricOmniUploadImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComplexTaskPanelInfo", "Lcom/obric/assistant/network/api/bean/ObricComplexTaskData;", "Lcom/obric/assistant/network/api/bean/ObricComplexTaskPanelInfoRequest;", "(Lcom/obric/assistant/network/api/bean/ObricComplexTaskPanelInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOperationInstructions", "Lcom/obric/assistant/network/api/bean/OperationInstructionResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOmniModelConfig", "Lcom/obric/assistant/network/api/bean/ObricOmniModelConfig;", "notifyStopComplexTask", "Lcom/obric/assistant/network/api/bean/ObricStopTaskRequest;", "(Lcom/obric/assistant/network/api/bean/ObricStopTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replyAskUser", "Lcom/obric/assistant/network/api/bean/ObricAskUserAnswerUplinkRequest;", "(Lcom/obric/assistant/network/api/bean/ObricAskUserAnswerUplinkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkRomVersionCompatible", "Lcom/obric/assistant/network/api/bean/ObricCheckRomCompatibleResponse;", "Lcom/obric/assistant/network/api/bean/ObricCheckRomCompatibleRequest;", "(Lcom/obric/assistant/network/api/bean/ObricCheckRomCompatibleRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppBlackList", "Lcom/obric/assistant/settings/ObricGetAppBlacklistResponse;", "Lcom/obric/assistant/settings/ObricGetAppBlacklistRequest;", "(Lcom/obric/assistant/settings/ObricGetAppBlacklistRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportODidRelation", "Lcom/obric/assistant/network/api/bean/ReportODidRequest;", "(Lcom/obric/assistant/network/api/bean/ReportODidRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "additionTask", "Lcom/obric/assistant/network/api/bean/ObricAdditionTaskRequest;", "(Lcom/obric/assistant/network/api/bean/ObricAdditionTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "operateQueue", "Lcom/obric/assistant/network/api/bean/ObricOperateQueueRequest;", "(Lcom/obric/assistant/network/api/bean/ObricOperateQueueRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "userTakeOver", "Lcom/obric/assistant/network/api/bean/ObricUserTakeOverRequest;", "(Lcom/obric/assistant/network/api/bean/ObricUserTakeOverRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAllOmniTasks", "Lcom/obric/assistant/network/api/bean/ObricClearTaskRequest;", "(Lcom/obric/assistant/network/api/bean/ObricClearTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConditionalTask", "Lcom/obric/aiagent/assistant/idl/bean/ObricConditionalTaskCreateRequest;", "(Lcom/obric/aiagent/assistant/idl/bean/ObricConditionalTaskCreateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sweepConditionalTask", "Lcom/obric/aiagent/assistant/idl/bean/ObricConditionalTaskSweepRequest;", "(Lcom/obric/aiagent/assistant/idl/bean/ObricConditionalTaskSweepRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteConditionalTask", "Lcom/obric/assistant/network/api/bean/ObricConditionalTaskDeleteRequest;", "(Lcom/obric/assistant/network/api/bean/ObricConditionalTaskDeleteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ObricProtocolApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f390332a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f390333a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f390334b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f390335c = null;

        public a() {
        }

        static {
            f390333a = new a();
            int r100 = iaa.a.f488962a;
            if (t9a.b.a().e() == false) goto L5;
            String r101 = "ofa.bytedance.net";
        L6:
            f390334b = r101;
            HttpConst.f359979a.getClass();
            f390335c = "https://".concat(r101);
            return;
        L5:
            r101 = "ofa.obriccloud.com";
            goto L6
        }

        public static Object a(Function2 r100, Continuation r110) {
            FlowHttpConnection r101 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.i(ServiceType.OBRIC, ObricProtocolApi.class, r100, null, null, f390335c, r110, 112);
        }

        public static Object b(m r100, Function2 r110, Continuation r111) {
            FlowHttpConnection r101 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.i(ServiceType.OBRIC, ObricProtocolApi.class, r110, null, r100, f390335c, r111, 48);
        }
    }

    static {
        f390332a = a.f390333a;
    }

    @POST("/assistant/multi_agent/addition_task")
    Object additionTask(@Body ObricAdditionTaskRequest r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/normal/check_assistant_version")
    Object checkRomVersionCompatible(@Body vea.c r100, Continuation<? super BizResponse<vea.d>> r101);

    @POST("/assistant/multi_agent/clear_task")
    Object clearAllOmniTasks(@Body ObricClearTaskRequest r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/multi_agent/create_conditional_task")
    Object createConditionalTask(@Body ObricConditionalTaskCreateRequest r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/multi_agent/delete_conditional_task")
    Object deleteConditionalTask(@Body ObricConditionalTaskDeleteRequest r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/auto_action/api/task/app_blacklist")
    Object getAppBlackList(@Body u r100, Continuation<? super BizResponse<v>> r101);

    @POST("/assistant/multi_agent/get_info")
    Object getComplexTaskPanelInfo(@Body vea.g r100, Continuation<? super BizResponse<vea.e>> r101);

    @GET("/assistant/multi_agent/omni_model_config")
    Object getOmniModelConfig(Continuation<? super BizResponse<ObricOmniModelConfig>> r100);

    @GET("/assistant/multi_agent/operation_instruction")
    Object getOperationInstructions(Continuation<? super BizResponse<r>> r100);

    @POST("/assistant/multi_agent/stop_task")
    Object notifyStopComplexTask(@Body ObricStopTaskRequest r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/multi_agent/operate_queue")
    Object operateQueue(@Body ObricOperateQueueRequest r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/multi_agent/ask_user")
    Object replyAskUser(@Body vea.b r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/alice/user/report_odevice_did_relation")
    Object reportODidRelation(@Body s r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/func_call/restore_image")
    Object restoreImage(@Body ObricRestoreImageRequest r100, Continuation<? super BizResponse<ObricRestoreImageResponse>> r101);

    @POST("/assistant/multi_agent/sweep_conditional_task")
    Object sweepConditionalTask(@Body ObricConditionalTaskSweepRequest r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/func_call/backup")
    Object uploadIntentResult(@Body vea.i r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/func_call/notify")
    Object uploadIntentResultForAsyncNotify(@Body vea.i r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/func_call/notify")
    Object uploadIntentResultForAsyncNotifyOptimized(@Body TypedOutput r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/func_call/callback")
    Object uploadIntentResultForCompensation(@Body vea.i r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/normal/router")
    Object uploadNormalRouter(@Body vea.j r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/normal/upload_screen_shot_feedback")
    Object uploadOmniScreenshot(@Body ObricOmniUploadImageRequest r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/assistant/multi_agent/take_over")
    Object userTakeOver(@Body ObricUserTakeOverRequest r100, Continuation<? super BizResponse<Object>> r101);
}
