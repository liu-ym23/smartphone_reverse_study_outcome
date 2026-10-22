package com.obric.assistant.state.api.v2.core;

import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/FallbackImpl;", "Lcom/obric/assistant/state/api/v2/core/IObricMsgInfoSaveService;", "<init>", "()V", "saveInformationOnSendOrRegenMessage", "", "saveInformationOnReceiveMessage", "saveMsgInfoOnRegen", "msg", "Lcom/larus/im/bean/message/Message;", "saveMsgInfoOnSend", "saveMsgRespondedTimeForOtherContentType", "saveMsgRespondedTime", "isCurrentReplyMessage", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FallbackImpl implements IObricMsgInfoSaveService {
    public FallbackImpl() {
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void c(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService
    public final void d(boolean r100, Message r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
    }
}
