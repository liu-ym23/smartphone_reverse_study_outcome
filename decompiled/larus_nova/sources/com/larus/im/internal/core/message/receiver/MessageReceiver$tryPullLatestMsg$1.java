package com.larus.im.internal.core.message.receiver;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.bduploader.BDVideoUploaderBase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.receiver.MessageReceiver", f = "MessageReceiver.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4}, l = {431, 432, 440, 444, BDVideoUploaderBase.KeyIsDynamicSliceForceConfig}, m = "tryPullLatestMsg", n = {"from", RemoteMessageConst.MSGID, "cvsId", "onReceiveMsg", "from", RemoteMessageConst.MSGID, "cvsId", "onReceiveMsg", "index", "from", RemoteMessageConst.MSGID, "cvsId", "onReceiveMsg", "from", RemoteMessageConst.MSGID, "onReceiveMsg", "result", RemoteMessageConst.MSGID, "onReceiveMsg", "messages"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
public final class MessageReceiver$tryPullLatestMsg$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageReceiver this$0;

    public MessageReceiver$tryPullLatestMsg$1(MessageReceiver r100, Continuation<? super MessageReceiver$tryPullLatestMsg$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, null, null, this);
    }
}
