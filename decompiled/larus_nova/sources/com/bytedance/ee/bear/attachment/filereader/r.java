package com.bytedance.ee.bear.attachment.filereader;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.a f206413a;

    public r(FileReaderActivity.c r100) {
        this.f206413a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("FileReaderActivity", "   4downloadFileFromNut  fail : ", (Throwable) r100, false);
        com.bytedance.ee.util.ui.m.a(new q(this.f206413a));
    }
}
