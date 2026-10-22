package com.larus.feedback.impl.service;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import wc9.s;

/* JADX INFO: loaded from: classes27.dex */
public final class b implements IIMCallback<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<s> f343122a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return false;
    }

    public b(j r100) {
        this.f343122a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.e("RecentFeedbackMessageCollector", "select conversations failed, code=" + r100.getCode());
        if (this.f343122a.isActive() == false) goto L6;
        this.f343122a.resumeWith(Result.m9449constructorimpl(null));
        return;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(s r100) {
        s r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        if (this.f343122a.isActive() == false) goto L6;
        this.f343122a.resumeWith(Result.m9449constructorimpl(r101));
        return;
    }
}
