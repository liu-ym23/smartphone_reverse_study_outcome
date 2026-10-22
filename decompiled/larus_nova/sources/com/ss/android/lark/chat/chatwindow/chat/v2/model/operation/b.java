package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Function1<f5b.b, f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f414421a;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "avatarKey");
        this.f414421a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final f5b.b invoke(f5b.b r100) {
        f5b.b r101 = r100;
        if (r101 == null) goto L5;
        ChatChatter r102 = r101.getMessageSender();
    L6:
        if (r102 == null) goto L8;
        ChatChatter r103 = r101.getMessageSender();
        Intrinsics.checkNotNull(r103);
        r103.setAvatarKey(this.f414421a);
    L8:
        return r101;
    L5:
        r102 = null;
        goto L6
    }
}
