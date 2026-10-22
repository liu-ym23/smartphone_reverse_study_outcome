package com.larus.security.azeroth;

import com.larus.im.bean.message.Message;
import com.larus.im.depend.IAzerothService;
import com.larus.security.api.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/security/azeroth/AzerothServiceImpl;", "Lcom/larus/im/depend/IAzerothService;", "<init>", "()V", "generateAndUploadFornaxToken", "", "curMsg", "Lcom/larus/im/bean/message/Message;", "source", "", "dislikeDetailType", "detailContent", "", "(Lcom/larus/im/bean/message/Message;ILjava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AzerothServiceImpl implements IAzerothService {
    public AzerothServiceImpl() {
    }

    @Override // com.larus.im.depend.IAzerothService
    public final Object a(Message r100, Integer r101, String r102, Continuation r103) {
        Object r104 = g.a(r100, 1, r101, r102, r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }
}
