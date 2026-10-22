package com.larus.home.impl.main.side_bar.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r {
    public static final boolean a(p r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.o() == false) goto L5;
    L10:
        return true;
    L5:
        if (r100.getType() == ComponentTypeEnum.CONVERSATION_NEW_CONVERSATION_CHAT.getType()) goto L10;
        if (r100.getType() == ComponentTypeEnum.CONVERSATION_NEW_CONVERSATION_OFFICE.getType()) goto L10;
        return false;
    }
}
