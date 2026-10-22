package com.larus.bmhome.chat.api;

import com.larus.im.bean.message.MessageTrackContext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J3\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u000bH\u0096\u0001J)\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bH\u0096\u0001¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/api/AppreciableTraceDelegate;", "Lcom/larus/bmhome/chat/api/IAppreciableTraceService;", "<init>", "()V", "createMessageTrackContext", "Lcom/larus/im/bean/message/MessageTrackContext;", "businessSendStartTimestamp", "", "scene", "", "agentMode", "", "(JLjava/lang/String;Ljava/lang/Integer;)Lcom/larus/im/bean/message/MessageTrackContext;", "onMessageShowOnScreen", "", "msg", "Lcom/larus/im/bean/message/Message;", "onSendFailedBeforeACK", "localSendMsgId", "contentType", "errorType", "status", "onStartSendMsg", "cvsId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppreciableTraceDelegate implements IAppreciableTraceService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AppreciableTraceDelegate f297132b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAppreciableTraceService f297133a;

    static {
        f297132b = new AppreciableTraceDelegate();
    }

    @Override // com.larus.bmhome.chat.api.IAppreciableTraceService
    public final MessageTrackContext a(long r100, Integer r101) {
        Intrinsics.checkNotNullParameter("share_send", "scene");
        return this.f297133a.a(r100, r101);
    }

    @Override // com.larus.bmhome.chat.api.IAppreciableTraceService
    public final void b(String r100, String r101, int r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f297133a.b(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.bmhome.chat.api.IAppreciableTraceService
    public final void c(String r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r101, "cvsId");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f297133a.c(r100, r101, r102, r103);
    }

    private AppreciableTraceDelegate() {
        IAppreciableTraceService r100 = (IAppreciableTraceService) ServiceManager.get().getService(IAppreciableTraceService.class);
        if (r100 != null) goto L5;
        r100 = new AppreciableTraceServiceNoop();
    L5:
        this.f297133a = r100;
    }
}
