package com.larus.feedback.api;

import androidx.fragment.app.DialogFragment;
import com.larus.feedback.api.model.FlowDislikePanelConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import o99.a;
import p99.d;
import q99.c;
import q99.i;
import q99.m;
import tc9.e;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096@¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J,\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u001c2\u001a\u0010\u001d\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001eH\u0016J\u001a\u0010 \u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006$"}, d2 = {"Lcom/larus/feedback/api/FlowFeedbackServiceDelegate;", "Lcom/larus/feedback/api/IFlowFeedbackService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/larus/feedback/api/IFlowFeedbackService;", "collectRecentMessagesExtra", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindChatPage", "Lcom/larus/feedback/api/manager/BaseIMFeedbackManager;", "host", "Lcom/larus/feedback/api/model/FlowFeedbackHost;", "unbindChatPage", "", "cvsId", "onReceiveInAppNotification", "notify", "Lcom/larus/im/bean/InAppBannerNotify;", "tryQueryAndShowFeedbackNotification", "request", "Lcom/larus/feedback/api/model/FlowFeedbackContentRequest;", "createDislikeDialog", "Landroidx/fragment/app/DialogFragment;", "config", "Lcom/larus/feedback/api/model/FlowDislikePanelConfig;", "reportFeedback", "Lcom/larus/feedback/api/model/FlowFeedbackSubmitRequest;", "callback", "Lkotlin/Function1;", "Lcom/larus/network/bean/HttpDataResult;", "submitMessageFeedback", "Lcom/larus/feedback/api/model/FlowMessageFeedbackRequest;", "listener", "Lcom/larus/feedback/api/listener/IFeedbackListener;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowFeedbackServiceDelegate implements IFlowFeedbackService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowFeedbackServiceDelegate f343027a = null;

    static {
        f343027a = new FlowFeedbackServiceDelegate();
    }

    private FlowFeedbackServiceDelegate() {
    }

    public static IFlowFeedbackService h() {
        IFlowFeedbackService r100 = (IFlowFeedbackService) ServiceManager.get().getService(IFlowFeedbackService.class);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new FlowFeedbackServiceNoop();
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        h().b(r100);
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void c(e r100) {
        h().c(r100);
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final DialogFragment d(FlowDislikePanelConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return h().d(r100);
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final d e(i r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        return h().e(r100);
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final Object f(Continuation<? super String> r100) {
        return h().f(r100);
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void a(c r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "host");
        h().a(r100, r101);
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void g(m r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        h().g(r100, r101);
    }
}
