package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements Function1<f5b.b, f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f414440a;

    public n(int r100) {
        this.f414440a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final f5b.b invoke(f5b.b r100) {
        f5b.b r101 = r100;
        if (r101 != null) goto L5;
    L16:
        return r101;
    L5:
        if (r101.getMessage().getMessageType() != MessageType.IMAGE) goto L16;
        ImageContent r102 = (ImageContent) r101.getMessage().getMessageContent();
        int r103 = this.f414440a;
        if (r103 >= 0) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L16;
        if (r103 <= r102.getProgress()) goto L16;
        r102.setProgress(this.f414440a);
        goto L16
    L9:
        if (r103 >= 101) goto L11;
        r104 = true;
        goto L12
    }
}
