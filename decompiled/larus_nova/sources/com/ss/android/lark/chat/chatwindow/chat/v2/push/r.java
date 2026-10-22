package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class r implements c0.a {

    public static final class a {
        public a() {
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().getPushDependency().j();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().getPushDependency().i();
    }

    public r(y r100) {
        Intrinsics.checkNotNullParameter(r100, "streamProvider");
        new a();
    }
}
