package com.ss.android.lark.utils.rxjava;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes38.dex */
public abstract class ReportErrorConsumer implements Consumer<Throwable> {
    public ReportErrorConsumer() {
    }

    public abstract void error(Throwable r100) throws Exception;

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Throwable r100) throws Exception {
        e.a(r100);
        error(r100);
    }

    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Throwable r100) throws Exception {
        accept2(r100);
    }
}
