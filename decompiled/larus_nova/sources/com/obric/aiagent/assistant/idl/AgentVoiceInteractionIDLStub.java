package com.obric.aiagent.assistant.idl;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0011\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n \t*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J)\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u000b2\u000e\u0010\u0015\u001a\n \t*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u000bH\u0096\u0001J)\u0010\u0018\u001a\u00020\u000b2\u000e\u0010\r\u001a\n \t*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\u0019\u001a\n \t*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010\u001a\u001a\u00020\u000b2\u000e\u0010\u001b\u001a\n \t*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096\u0001¨\u0006 "}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentVoiceInteractionIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentVoiceInteractionIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentVoiceInteractionIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getUserRecentData", "Lcom/obric/aiagent/assistant/idl/bean/PersonalContextInfo;", "kotlin.jvm.PlatformType", "onAsrEnd", "", "onAsrStart", "localMsgId", "", "onHandleAssist", "structure", "Landroid/app/assist/AssistStructure;", "content", "Landroid/app/assist/AssistContent;", "onHandleScreenshot", IHostShare.ShareType.SCREENSHOT, "Landroid/graphics/Bitmap;", "onHide", "onQueryAudioFile", "fileUri", SendEventContainerMethodParamModel.EventKinds.onShow, "args", "Landroid/os/Bundle;", "onStartChatWindow", "state", "", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentVoiceInteractionIDLStub extends IAgentVoiceInteractionIDL.Stub {
    private final /* synthetic */ IAgentVoiceInteractionIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public PersonalContextInfo getUserRecentData() {
        return this.$$delegate_0.getUserRecentData();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onAsrEnd() {
        this.$$delegate_0.onAsrEnd();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onAsrStart(String r100) {
        this.$$delegate_0.onAsrStart(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHandleAssist(AssistStructure r100, AssistContent r101) {
        this.$$delegate_0.onHandleAssist(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHandleScreenshot(Bitmap r100) {
        this.$$delegate_0.onHandleScreenshot(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHide() {
        this.$$delegate_0.onHide();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onQueryAudioFile(String r100, String r101) {
        this.$$delegate_0.onQueryAudioFile(r100, r101);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onShow(Bundle r100) {
        this.$$delegate_0.onShow(r100);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onStartChatWindow(int r100) {
        this.$$delegate_0.onStartChatWindow(r100);
    }

    public AgentVoiceInteractionIDLStub() {
        IAgentVoiceInteractionIDL r100 = (IAgentVoiceInteractionIDLSPI) ServiceManager.get().getService(IAgentVoiceInteractionIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IAgentVoiceInteractionIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
