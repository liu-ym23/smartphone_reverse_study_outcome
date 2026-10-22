package com.bytedance.ee.bear.bitable.chameleon;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import io.reactivex.functions.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: classes15.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<WikiInfo> f209658a;

    public l(kotlinx.coroutines.j r100) {
        this.f209658a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        WikiInfo r101 = (WikiInfo) r100;
        if (this.f209658a.isActive() == false) goto L6;
        this.f209658a.resumeWith(Result.m9449constructorimpl(r101));
        return;
    }
}
