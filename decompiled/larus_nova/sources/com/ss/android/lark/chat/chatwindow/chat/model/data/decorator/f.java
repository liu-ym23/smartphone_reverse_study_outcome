package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.i;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements i<MessageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a> f413352a;

    public f(q3b.f r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f413352a = r100;
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r100) {
        MessageInfo r101 = (MessageInfo) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r102 = this.f413352a.invoke();
        if (r102 == null) goto L6;
        r102.b(r101);
        return;
    }
}
