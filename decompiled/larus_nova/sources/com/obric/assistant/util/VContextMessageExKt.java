package com.obric.assistant.util;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class VContextMessageExKt {
    public static final Object a(t1a.b r100, String r101, Continuation<? super Message> r102) {
        if ((r102 instanceof VContextMessageExKt$queryMessage$1) == false) goto L7;
        VContextMessageExKt$queryMessage$1 r103 = (VContextMessageExKt$queryMessage$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L51:
        FLogger.f375446a.i("VContextMessageEx", "queryMessage: found msgInRepo " + ((Message) r105));
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        FLogger.f375446a.i("VContextMessageEx", "queryMessage: msgId " + r101);
        if (r101 != null) goto L17;
    L20:
        boolean r108 = true;
    L21:
        Message r109 = null;
        if (r108 == false) goto L24;
        return null;
    L24:
        u7 r110 = (u7) r100.getAbility(u7.class);
        if (r110 == null) goto L27;
        MessageAdapter r111 = r110.MF();
    L29:
        if ((r111 instanceof com.larus.bmhome.chat.adapter.i) == true) goto L32;
        r111 = null;
    L32:
        if (r111 == null) goto L45;
        List<xc8.b> r112 = r111.getMessageList();
        if (r112 == null) goto L45;
        Iterator<T> r113 = r112.iterator();
    L37:
        if (r113.hasNext() == false) goto L41;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((ic8.v) r114).a().getMessageId(), r101) == false) goto L37;
    L42:
        ic8.v r115 = (ic8.v) r114;
        if (r115 == null) goto L45;
        r109 = r115.a();
        goto L45
    L41:
        r114 = null;
    L45:
        if (r109 == null) goto L48;
        FLogger.f375446a.i("VContextMessageEx", "queryMessage: found msgInList " + r109);
        return r109;
    L48:
        IChatRepoService r116 = zh8.a.f572196a;
        r103.label = 1;
        r105 = r116.E1(r101, r103);
        if (r105 != r106) goto L51;
        return r106;
    L27:
        r111 = null;
        goto L29
    L17:
        if (r101.length() == 0) goto L20;
        r108 = false;
    L7:
        r103 = new VContextMessageExKt$queryMessage$1(r102);
        goto L8
    }
}
