package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements Function1<f5b.b, f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f414424a;

    public f(int r100) {
        this.f414424a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final f5b.b invoke(f5b.b r100) {
        f5b.b r101 = r100;
        if (r101 == null) goto L7;
        Message r102 = r101.getMessage();
        if (r102.getType() != Message.Type.IMAGE) goto L7;
        ((ImageContent) r102.getContent()).setProgress(this.f414424a);
    L7:
        return r101;
    }
}
