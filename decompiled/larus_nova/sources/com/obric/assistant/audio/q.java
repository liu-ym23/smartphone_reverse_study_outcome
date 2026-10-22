package com.obric.assistant.audio;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes32.dex */
public final class q implements IIMCallback<Message> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Message> f385652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f385653b;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return false;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.i("ObricTtsControlServiceImpl", "queryMessageFromDb failed: code=" + r100.getCode() + ", tips=" + r100.getTips());
        this.f385653b.countDown();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.larus.im.bean.message.Message, java.lang.Object] */
    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f385652a.element = r101;
        this.f385653b.countDown();
    }

    public q(Ref.ObjectRef<Message> r100, CountDownLatch r101) {
        this.f385652a = r100;
        this.f385653b = r101;
    }
}
