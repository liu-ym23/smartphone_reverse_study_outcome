package com.bytedance.ee.bear.drive.test.item;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m<T> implements Consumer {
    public static final m<T> a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r2) {
        Unit r3 = (Unit) r2;
        tt5.a.h("DriveUploadTestItem", "startUpload success");
    }
}
