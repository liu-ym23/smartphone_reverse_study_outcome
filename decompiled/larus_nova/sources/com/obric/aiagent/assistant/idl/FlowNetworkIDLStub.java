package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016JG\u0010\u0007\u001a\u00020\b2,\u0010\t\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b \r*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f¨\u0006\u00010\n¨\u0006\u00012\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J§\u0002\u0010\u0010\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0013\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0015\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0016\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0017\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0019\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u001a\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u001b\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u001d\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u001e\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u001f\u001a\n \r*\u0004\u0018\u00010\u00120\u00122,\u0010\t\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b \r*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f¨\u0006\u00010\n¨\u0006\u00012\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001JW\u0010 \u001a\u00020\b2\u000e\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00120\u00122,\u0010\t\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b \r*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f¨\u0006\u00010\n¨\u0006\u00012\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\t\u0010!\u001a\u00020\"H\u0096\u0001J\u0011\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0096\u0001J!\u0010&\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\u000e\u0010'\u001a\n \r*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001JW\u0010(\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00120\u00122,\u0010)\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b \r*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f¨\u0006\u00010\n¨\u0006\u00012\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J)\u0010*\u001a\u00020\b2\u000e\u0010+\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001JM\u0010,\u001a\u00020\b2*\u0010-\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010/0/ \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010/0/\u0018\u0001000.2\u0006\u00101\u001a\u0002022\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001JM\u00103\u001a\u00020\b2*\u0010-\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010/0/ \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010/0/\u0018\u0001000.2\u0006\u00101\u001a\u0002022\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J9\u00104\u001a\u00020\b2\u000e\u0010'\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u00105\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001Jw\u00106\u001a\u00020\b2\u000e\u0010$\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u00107\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u00108\u001a\n \r*\u0004\u0018\u00010\u00120\u00122,\u0010\t\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b \r*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f¨\u0006\u00010\n¨\u0006\u00012\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J)\u00109\u001a\u00020\b2\u000e\u0010:\u001a\n \r*\u0004\u0018\u00010;0;2\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u008d\u0002\u0010<\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010=\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u0006\u0010>\u001a\u00020\"2\u000e\u0010?\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010@\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010A\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010B\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010C\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010D\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010E\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010F\u001a\n \r*\u0004\u0018\u00010\u00120\u00122*\u0010G\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00120\u0012 \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00120\u0012\u0018\u0001000.2\u000e\u0010H\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010I\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u0095\u0002\u0010J\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010=\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u0006\u0010>\u001a\u00020\"2\u000e\u0010?\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010@\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010A\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010B\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010C\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010D\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010E\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010F\u001a\n \r*\u0004\u0018\u00010\u00120\u00122*\u0010G\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00120\u0012 \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00120\u0012\u0018\u0001000.2\u000e\u0010H\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010I\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u0006\u0010K\u001a\u0002022\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001JÍ\u0001\u0010L\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010=\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u0006\u0010>\u001a\u00020\"2\u000e\u0010?\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010M\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010E\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010F\u001a\n \r*\u0004\u0018\u00010\u00120\u00122*\u0010G\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00120\u0012 \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00120\u0012\u0018\u0001000.2\u000e\u0010H\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010I\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001JÕ\u0001\u0010N\u001a\u00020\b2\u000e\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010=\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u0006\u0010>\u001a\u00020\"2\u000e\u0010?\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010M\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010E\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010F\u001a\n \r*\u0004\u0018\u00010\u00120\u00122*\u0010G\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00120\u0012 \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00120\u0012\u0018\u0001000.2\u000e\u0010H\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010I\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u0006\u0010K\u001a\u0002022\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u007f\u0010O\u001a\u00020\b2\u000e\u0010P\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010Q\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u000e\u0010'\u001a\n \r*\u0004\u0018\u00010\u00120\u00122\u0006\u0010R\u001a\u00020%2,\u0010)\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b \r*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f¨\u0006\u00010\n¨\u0006\u00012\u000e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001¨\u0006S"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowNetworkIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowNetworkIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowNetworkIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "clearOmniTasks", "", "extra", "", "", "", "kotlin.jvm.PlatformType", "callback", "Lcom/obric/aiagent/assistant/idl/IFlowNetworkResultCallbackIDL;", "createConditionalTask", DBDefinition.TASK_ID, "", "oOmniInstructionType", "createType", "instruction", "originQuery", "shortQuery", "createTime", UserInfo.UPDATE_TIME, "knowledge", "automaticFields", "operateType", "discoveryId", "discoveryQuery", "modelChoice", "deleteConditionalTask", "getCurrentNetworkStatus", "", "notifyStopComplexTaskByHttp", RemoteMessageConst.MSGID, "", "notifyStopComplexTaskByHttpWithScene", "scene", "notifyStopOmniTaskByHttp", "ext", "notifyUserOperateQueue", "data", "sendIntentResultForAsyncNotifyByHttp", "intentResultList", "", "Lcom/obric/aiagent/assistant/idl/bean/OPushEvent;", "", "isNeedRetry", "", "sendIntentResultForCompensationByHttp", "sendNormalRouterByHttp", "passThrough", "sendReplyAskUserByHttp", "askContent", "userAnswer", "sweepConditionalTask", "request", "Lcom/obric/aiagent/assistant/idl/bean/ObricConditionalTaskSweepRequest;", "uploadOmniDataFeedbackByHttp", "toolId", DecodeProducer.EXTRA_IMAGE_COUNT, "imagePath", "imageMime", "viewTreePath", "viewTreeMime", "reactViewTreePath", "reactViewTreeMime", "source", "feedbackContent", "feedbackTags", "type", com.bytedance.android.ec.core.event.a.KEY_SCORE, "uploadOmniDataFeedbackByHttpV2", "isFinish", "uploadOmniScreenshotByHttp", "mime", "uploadOmniScreenshotByHttpV2", "uploadUserTakeOverByHttp", "id", "content", "timeout", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowNetworkIDLStub extends IFlowNetworkIDL.Stub {
    private final /* synthetic */ IFlowNetworkIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void clearOmniTasks(Map r100, IFlowNetworkResultCallbackIDL r101) {
        this.$$delegate_0.clearOmniTasks(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void createConditionalTask(String r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, Map r312, IFlowNetworkResultCallbackIDL r313) {
        this.$$delegate_0.createConditionalTask(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void deleteConditionalTask(String r100, Map r101, IFlowNetworkResultCallbackIDL r102) {
        this.$$delegate_0.deleteConditionalTask(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public int getCurrentNetworkStatus() {
        return this.$$delegate_0.getCurrentNetworkStatus();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopComplexTaskByHttp(long r100) {
        this.$$delegate_0.notifyStopComplexTaskByHttp(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopComplexTaskByHttpWithScene(long r100, String r101) {
        this.$$delegate_0.notifyStopComplexTaskByHttpWithScene(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyStopOmniTaskByHttp(String r100, Map r101, IFlowNetworkResultCallbackIDL r102) {
        this.$$delegate_0.notifyStopOmniTaskByHttp(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void notifyUserOperateQueue(String r100, IFlowNetworkResultCallbackIDL r101) {
        this.$$delegate_0.notifyUserOperateQueue(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r100, boolean r101, IFlowNetworkResultCallbackIDL r102) {
        this.$$delegate_0.sendIntentResultForAsyncNotifyByHttp(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendIntentResultForCompensationByHttp(List<OPushEvent> r100, boolean r101, IFlowNetworkResultCallbackIDL r102) {
        this.$$delegate_0.sendIntentResultForCompensationByHttp(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendNormalRouterByHttp(String r100, String r101, IFlowNetworkResultCallbackIDL r102) {
        this.$$delegate_0.sendNormalRouterByHttp(r100, r101, r102);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sendReplyAskUserByHttp(String r100, String r101, String r102, Map r110, IFlowNetworkResultCallbackIDL r111) {
        this.$$delegate_0.sendReplyAskUserByHttp(r100, r101, r102, r110, r111);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void sweepConditionalTask(ObricConditionalTaskSweepRequest r100, IFlowNetworkResultCallbackIDL r101) {
        this.$$delegate_0.sweepConditionalTask(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniDataFeedbackByHttp(String r110, String r111, int r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, List<String> r219, String r310, String r311, IFlowNetworkResultCallbackIDL r312) {
        this.$$delegate_0.uploadOmniDataFeedbackByHttp(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniDataFeedbackByHttpV2(String r110, String r111, int r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, List<String> r219, String r310, String r311, boolean r312, IFlowNetworkResultCallbackIDL r313) {
        this.$$delegate_0.uploadOmniDataFeedbackByHttpV2(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniScreenshotByHttp(String r110, String r111, int r112, String r113, String r114, String r115, String r210, List<String> r211, String r212, String r213, IFlowNetworkResultCallbackIDL r214) {
        this.$$delegate_0.uploadOmniScreenshotByHttp(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadOmniScreenshotByHttpV2(String r110, String r111, int r112, String r113, String r114, String r210, String r211, List<String> r212, String r213, String r214, boolean r215, IFlowNetworkResultCallbackIDL r216) {
        this.$$delegate_0.uploadOmniScreenshotByHttpV2(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
    public void uploadUserTakeOverByHttp(String r100, String r110, String r111, long r112, Map r113, IFlowNetworkResultCallbackIDL r114) {
        this.$$delegate_0.uploadUserTakeOverByHttp(r100, r110, r111, r112, r113, r114);
    }

    public FlowNetworkIDLStub() {
        IFlowNetworkIDL r100 = (IFlowNetworkIDLSPI) ServiceManager.get().getService(IFlowNetworkIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFlowNetworkIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
