package com.obric.assistant.state.api.v2.core;

import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/ObricMsgInfoSaveDelegate;", "Lcom/obric/assistant/state/api/v2/core/IObricMsgInfoSaveService;", "<init>", "()V", "saveInformationOnReceiveMessage", "", "saveInformationOnSendOrRegenMessage", "saveMsgInfoOnRegen", "msg", "Lcom/larus/im/bean/message/Message;", "saveMsgInfoOnSend", "saveMsgRespondedTime", "isCurrentReplyMessage", "", "saveMsgRespondedTimeForOtherContentType", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMsgInfoSaveDelegate implements IObricMsgInfoSaveService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricMsgInfoSaveDelegate f392967b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricMsgInfoSaveService f392968a;

    static {
        f392967b = new ObricMsgInfoSaveDelegate();
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f392968a.a(r100);
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f392968a.b(r100);
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f392968a.c(r100);
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void d(boolean r100, Message r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f392968a.d(r100, r101);
    }

    private ObricMsgInfoSaveDelegate() {
        IObricMsgInfoSaveService r100 = (IObricMsgInfoSaveService) ServiceManager.get().getService(IObricMsgInfoSaveService.class);
        if (r100 != null) goto L5;
        r100 = new FallbackImpl();
    L5:
        this.f392968a = r100;
    }
}
