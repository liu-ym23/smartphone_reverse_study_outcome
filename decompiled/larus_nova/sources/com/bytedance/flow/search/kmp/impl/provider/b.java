package com.bytedance.flow.search.kmp.impl.provider;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements IIMCallback<List<? extends Message>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Continuation<Message> f243638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f243639b;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f243638a.resumeWith(Result.m9449constructorimpl(null));
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(List<? extends Message> r100) {
        List<? extends Message> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        Continuation<Message> r102 = this.f243638a;
        String r103 = this.f243639b;
        Iterator<T> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        Message r106 = (Message) r105;
        if (Intrinsics.areEqual(r106.getLocalMessageId(), r103) == false) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == false) goto L4;
    L15:
        r102.resumeWith(Result.m9449constructorimpl(r105));
        return;
    L8:
        if (Intrinsics.areEqual(r106.getMessageId(), r103) == true) goto L11;
        r107 = false;
        goto L12
    L14:
        r105 = null;
        goto L15
    }

    public b(SafeContinuation r100, String r101) {
        this.f243638a = r100;
        this.f243639b = r101;
    }
}
