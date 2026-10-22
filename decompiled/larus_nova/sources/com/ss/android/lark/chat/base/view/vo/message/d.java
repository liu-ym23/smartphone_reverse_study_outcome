package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends v5b.a<SystemContent> {
    public d(SystemContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
    }

    @Override // v5b.a
    public final String c(v5b.c<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        SystemContent r101 = (SystemContent) this.f553338a;
        SystemMessageType r102 = null;
        if (r101 == null) goto L5;
        SystemMessageType r103 = r101.getType();
    L7:
        if (r103 == SystemMessageType.USER_CHECK_OTHERS_TELEPHONE) goto L15;
        SystemContent r104 = (SystemContent) this.f553338a;
        if (r104 == null) goto L12;
        r102 = r104.getType();
    L12:
        if (r102 == SystemMessageType.SystemContent_CHECK_USER_PHONE_NUMBER) goto L15;
        Intrinsics.checkNotNullParameter(r100, "message");
        return r100.g();
    L15:
        String r105 = ((SystemContent) this.f553338a).getContents().get("caller_id");
        if (r105 != null) goto L20;
        return "1";
    L20:
        return r105;
    L5:
        r103 = null;
        goto L7
    }
}
