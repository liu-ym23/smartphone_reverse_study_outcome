package com.bytedance.ee.bear.list.more.more3;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T> implements Consumer {
    public static final o<T> a = null;

    static {
        a = new o();
    }

    public o() {
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        tt5.a.e("SpaceFolderMoreProvider", "folderUserPermissionFlow err. ", r5, false);
    }
}
