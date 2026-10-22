package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j<T> implements Consumer {
    public static final j<T> a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        tt5.a.h("ImImportFileModel", "pullChatToken done");
    }
}
