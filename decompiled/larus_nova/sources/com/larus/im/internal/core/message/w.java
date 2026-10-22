package com.larus.im.internal.core.message;

import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.im.internal.database.entity.ParticipantEntity;
import com.larus.im.internal.protocol.bean.MentionInfoTag;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class w {
    public static final Object a(String r100, Integer r101, String r102, Continuation r110) {
        if ((r110 instanceof SendMessageProcessorKt$getBotId$1) == false) goto L7;
        SendMessageProcessorKt$getBotId$1 r103 = (SendMessageProcessorKt$getBotId$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L22:
        Iterator r107 = ((Iterable) r111).iterator();
    L24:
        if (r107.hasNext() == false) goto L34;
        Object r108 = r107.next();
        Integer r109 = ((ParticipantEntity) r108).getType();
        if (r109 != null) goto L29;
    L31:
        boolean r112 = false;
    L32:
        if (r112 == false) goto L24;
    L35:
        ParticipantEntity r113 = (ParticipantEntity) r108;
        if (r113 == null) goto L73;
        return r113.getParticipantId();
    L73:
        return null;
    L29:
        if (r109.intValue() != 2) goto L31;
        r112 = true;
        goto L32
    L34:
        r108 = null;
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (r101 != null) goto L18;
    L39:
        if (r101 == null) goto L73;
        if (r101.intValue() != 2) goto L73;
        TextContent r114 = (TextContent) zd9.i.a(r102, TextContent.Companion.serializer());
        if (r114 == null) goto L73;
        List<TextTagInfo> r115 = r114.textTags;
        if (r115 == null) goto L73;
        Iterator<T> r116 = r115.iterator();
    L49:
        if (r116.hasNext() == false) goto L73;
        TextTagInfo r117 = (TextTagInfo) r116.next();
        if (r117.type != TagEnum.TagEnum_AT.value) goto L49;
        MentionInfoTag r118 = (MentionInfoTag) zd9.i.a(r117.tagInfo, MentionInfoTag.Companion.serializer());
        if (r118 != null) goto L55;
    L57:
        boolean r119 = false;
    L58:
        if (r119 == false) goto L49;
        return r118.userId;
    L55:
        if (r118.userType != 2) goto L57;
        r119 = true;
        goto L58
    L18:
        if (r101.intValue() != 3) goto L39;
        be9.e r120 = ae9.h.a();
        r103.label = 1;
        r111 = r120.c(r100, r103);
        if (r111 != r105) goto L22;
        return r105;
    L7:
        r103 = new SendMessageProcessorKt$getBotId$1(r110);
        goto L8
    }
}
