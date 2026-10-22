package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageUniversalPinExtra;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements Function1<f5b.b, f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, MessageUniversalPinExtra> f414441a;

    public o(Map<Long, MessageUniversalPinExtra> r100) {
        Intrinsics.checkNotNullParameter(r100, "extraInfoMap");
        this.f414441a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final f5b.b invoke(f5b.b r100) {
        f5b.b r101 = r100;
        String r102 = null;
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof MessageInfo) == false) goto L25;
        f5b.b r103 = ((MessageInfo) r101).clone();
        if ((r103 instanceof MessageInfo) == false) goto L11;
        MessageInfo r104 = (MessageInfo) r103;
    L12:
        if (r104 == null) goto L26;
        Message r105 = r101.getMessage();
        if (r105 == null) goto L17;
        r102 = r105.getId();
    L17:
        if (r102 == null) goto L23;
        Long r106 = StringsKt.toLongOrNull(r102);
        if (r106 == null) goto L24;
        r104.setUniversalPinExtra(this.f414441a.get(Long.valueOf(r106.longValue())));
        return r104;
    L24:
        return r101;
    L23:
        return r101;
    L26:
        return r101;
    L11:
        r104 = null;
        goto L12
    L25:
        return r101;
    }
}
