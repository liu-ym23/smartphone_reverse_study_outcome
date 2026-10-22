package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.c0;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class o implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<String, Integer, Long, Unit> f424247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f424248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w4b.c0 f424249c;

    public static final class a {
        public a() {
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        this.f424249c.e();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        this.f424249c.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(String r100, Function3<? super String, ? super Integer, ? super Long, Unit> r101, Function1<? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "onMediaUploadProgress");
        Intrinsics.checkNotNullParameter(r102, "onMediaUploadFailed");
        this.f424247a = r101;
        this.f424248b = r102;
        this.f424249c = ChatCoreModule.a().getPushDependency();
        new a();
    }
}
