package com.bytedance.ee.bear.drive.test.item;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes16.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T> f224688a = null;

    static {
        f224688a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        tt5.a.h("DriveUploadTestItem", "startUpload success");
    }
}
