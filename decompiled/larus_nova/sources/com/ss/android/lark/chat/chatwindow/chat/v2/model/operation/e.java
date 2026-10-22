package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements Function1<f5b.b, f5b.b> {
    public e() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final f5b.b invoke(f5b.b r100) {
        f5b.b r101 = r100;
        if (r101 == null) goto L11;
        Message r102 = r101.getMessage();
        Message.Type r103 = r102.getType();
        if (r103 != Message.Type.FILE) goto L7;
    L8:
        r102.setSendStatus(SendStatus.FAIL);
        if (r103 != Message.Type.MEDIA) goto L11;
        MediaContent r104 = (MediaContent) r102.getContent();
        r104.setProgress(0);
        r104.setFileState(FileState.PAUSE);
        goto L11
    L7:
        if (r103 == Message.Type.MEDIA) goto L8;
    L11:
        return r101;
    }
}
