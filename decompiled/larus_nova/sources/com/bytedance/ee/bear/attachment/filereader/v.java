package com.bytedance.ee.bear.attachment.filereader;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.a f206419a;

    public v(FileReaderActivity.c r100) {
        this.f206419a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("FileReaderActivity", " downloadFileFromTos fail ", (Throwable) r100, false);
        com.bytedance.ee.util.ui.m.a(new u(this.f206419a));
    }
}
