package com.bytedance.ee.bear.list.more.more3;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s<T> implements Consumer {
    public static final s<T> a = null;

    static {
        a = new s();
    }

    public s() {
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        tt5.a.e("SpaceFolderMoreProvider", "shortcutUserPermissionFlow err. ", r5, false);
    }
}
