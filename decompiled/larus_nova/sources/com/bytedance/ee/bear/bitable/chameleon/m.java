package com.bytedance.ee.bear.bitable.chameleon;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import io.reactivex.functions.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: classes15.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<WikiInfo> f209659a;

    public m(kotlinx.coroutines.j r100) {
        this.f209659a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.l("BitableWikiChecker", "load WikiInfo failed", (Throwable) r100);
        if (this.f209659a.isActive() == false) goto L6;
        this.f209659a.resumeWith(Result.m9449constructorimpl(null));
        return;
    }
}
