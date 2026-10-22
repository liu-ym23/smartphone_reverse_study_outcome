package com.ss.android.lark.biz.im.api.extension.message;

import com.ss.android.lark.chat.chatwindow.chat.model.preload.audio.AudioResourceLoadTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class g implements IMessageResourcePreloadTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f410209a;

    @Override // com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask
    public final void b() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask
    public boolean f() {
        return !(this instanceof AudioResourceLoadTask);
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask
    public final void isEnabled() {
    }

    public g(f r100) {
        Intrinsics.checkNotNullParameter(r100, "loadTaskContext");
        this.f410209a = r100;
    }
}
