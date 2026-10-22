package com.bytedance.ee.bear.list.more.more3;

import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z<T> f228803a = null;

    static {
        f228803a = new z();
    }

    public z() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        tt5.a.e("V1SpaceFolderMoreProvider", "shortcutUserPermissionFlow err. ", r101, false);
    }
}
