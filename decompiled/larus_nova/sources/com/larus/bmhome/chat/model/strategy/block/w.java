package com.larus.bmhome.chat.model.strategy.block;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class w implements IIMCallback<Message> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Message, IIMError, Unit> f308056a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(Function2<? super Message, ? super IIMError, Unit> r100) {
        this.f308056a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r100, "error");
        Function2<Message, IIMError, Unit> r101 = this.f308056a;
        if (r101 == null) goto L6;
        r101.invoke(null, r100);
        return;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        Function2<Message, IIMError, Unit> r102 = this.f308056a;
        if (r102 == null) goto L6;
        r102.invoke(r101, null);
        return;
    }
}
