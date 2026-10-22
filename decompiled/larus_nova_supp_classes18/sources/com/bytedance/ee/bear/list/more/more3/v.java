package com.bytedance.ee.bear.list.more.more3;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v<T> implements Consumer {
    public static final v<T> a = null;

    static {
        a = new v();
    }

    public v() {
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        tt5.a.e("V1SpaceFolderMoreProvider", "folderUserPermissionFlow err. ", r5, false);
    }
}
