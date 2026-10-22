package com.obric.assistant.feedback.impl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IFlowFeedbackIDLSPI;
import com.obric.aiagent.assistant.idl.bean.FeedbackBean;
import com.obric.assistant.feedback.IObricFeedbackService;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/feedback/impl/FlowFeedbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowFeedbackIDLSPI;", "<init>", "()V", "onFeedback", "", "data", "Lcom/obric/aiagent/assistant/idl/bean/FeedbackBean;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowFeedbackIDLStub implements IFlowFeedbackIDLSPI {
    public FlowFeedbackIDLStub() {
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFeedbackIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFeedbackIDL
    public void onFeedback(FeedbackBean r210) {
        IObricFeedbackService.f389211a.getClass();
        IObricFeedbackService r100 = IObricFeedbackService.a.a();
        if (r100 == null) goto L23;
        ArrayList<String> r101 = null;
        if (r210 == null) goto L7;
        String r102 = r210.getDescription();
    L9:
        if (r210 == null) goto L11;
        r101 = r210.getFilePath();
    L11:
        ArrayList<String> r110 = r101;
        if (r210 == null) goto L14;
        boolean r111 = r210.getLaunchReportAppWhenNoPermission();
    L15:
        if (r210 == null) goto L17;
        boolean r112 = r210.getNeedReportVoc();
    L18:
        if (r210 == null) goto L20;
        boolean r211 = r210.getNeedShowToast();
    L21:
        r100.a(new IObricFeedbackService.c(null, r102, null, null, null, null, null, null, null, null, false, r110, r111, r112, r211, null, false, null, 493552));
        return;
    L20:
        r211 = false;
        goto L21
    L17:
        r112 = false;
        goto L18
    L14:
        r111 = false;
        goto L15
    L7:
        r102 = null;
        goto L9
    }
}
