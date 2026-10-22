package com.ss.android.lark.integrator.im.impl;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(hib.c.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/integrator/im/impl/ForwardV2MessageDependencyImpl;", "Lcom/ss/android/lark/forwardv2/dependency/IForwardMessageDependency;", "<init>", "()V", "sendMessage", "", "messageParams", "Lcom/ss/android/lark/chat/entity/message/MessageParams;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardV2MessageDependencyImpl implements hib.c {
    public ForwardV2MessageDependencyImpl() {
    }

    @Override // hib.c
    public void sendMessage(MessageParams<?, ?> r100, IGetDataCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "messageParams");
        ImSdkService.f().sendMessage(r100, r101);
    }
}
