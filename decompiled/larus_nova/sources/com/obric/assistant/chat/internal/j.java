package com.obric.assistant.chat.internal;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j implements IIMCallback<Message> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f386957a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    public j(Function0<Unit> r100) {
        this.f386957a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
        Function0<Unit> r101 = this.f386957a;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Function0<Unit> r101 = this.f386957a;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }
}
