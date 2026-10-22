package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<T> f223056a = null;

    static {
        f223056a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        tt5.a.h("ImImportFileModel", "pullChatToken done");
    }
}
