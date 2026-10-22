package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatPinExtraPushHandler implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageListPinExtraLoader f414546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Function1<? super f5b.b, ? extends f5b.b>, Unit> f414547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f414548c;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        MessageListPinExtraLoader r100 = this.f414546a;
        if (r100 == null) goto L9;
        MessageListPinExtraLoader.b r101 = (MessageListPinExtraLoader.b) this.f414548c.getValue();
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (r100.f413355b == false) goto L10;
        ((CopyOnWriteArrayList) r100.f413358e.getValue()).add(r101);
        return;
    L10:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        MessageListPinExtraLoader r100 = this.f414546a;
        if (r100 == null) goto L9;
        MessageListPinExtraLoader.b r101 = (MessageListPinExtraLoader.b) this.f414548c.getValue();
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (r100.f413355b == false) goto L10;
        ((CopyOnWriteArrayList) r100.f413358e.getValue()).remove(r101);
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatPinExtraPushHandler(MessageListPinExtraLoader r100, Function1<? super Function1<? super f5b.b, ? extends f5b.b>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "updateExecutor");
        this.f414546a = r100;
        this.f414547b = r101;
        this.f414548c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ChatPinExtraPushHandler$observer$2(this));
    }
}
