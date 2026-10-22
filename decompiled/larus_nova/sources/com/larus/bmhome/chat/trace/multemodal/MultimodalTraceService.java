package com.larus.bmhome.chat.trace.multemodal;

import com.larus.bmhome.chat.api.IMultimodalTraceService;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalCommonParamManager;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.bmhome.chat.trace.multimodal.a;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.utils.c;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J8\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/trace/multemodal/MultimodalTraceService;", "Lcom/larus/bmhome/chat/api/IMultimodalTraceService;", "<init>", "()V", "onProcessStart", "", "fileIdentifier", "", "localSendMsgId", "cvsId", "scene", "onLoadVideoSuccess", "msgID", "videoParam", "enterMethod", "onLoadVideoFail", "errorMsg", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultimodalTraceService implements IMultimodalTraceService {
    public MultimodalTraceService() {
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        int r102 = MultimodalSendCostTrace.f310239a;
        MultimodalSendCostTrace.c(r100, null, r101, null, AttachmentAreaType.NO_ATTACHMENT);
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void c(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        int r104 = MultimodalSendCostTrace.f310239a;
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        MultimodalSendCostTrace.LoadVideoStepRecord r105 = new MultimodalSendCostTrace.LoadVideoStepRecord(r101, r102, r103);
        MultimodalCommonParamManager.CommonParam r106 = MultimodalCommonParamManager.a(r100);
        if (r106 == null) goto L5;
        r106.setProcessSuccessTime(Long.valueOf(r105.getStepTime()));
    L5:
        r105.report(r100);
        MultimodalCommonParamManager.b(r100);
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void a(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        int r105 = a.f310241a;
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        MultimodalCommonParamManager.CommonParam r106 = MultimodalCommonParamManager.a(r100);
        JSONObject r107 = new JSONObject();
        r107.put("error_msg", r102);
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r101);
        r107.put("video_param", r103);
        r107.put("enter_method", r104);
        JSONObject r108 = com.larus.bmhome.chat.trace.appreciable.a.b(r106, r107);
        FLogger.f375446a.d("MultimodalSendFailTrace", "onSendFailed, event=message_video_load_error, param=" + r108);
        o.f365780a.reportEvent("message_video_load_error", r108);
        c.a("message_image_load_error", r108, true);
        MultimodalCommonParamManager.b(r100);
    }
}
