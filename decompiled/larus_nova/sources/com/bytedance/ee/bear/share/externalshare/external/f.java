package com.bytedance.ee.bear.share.externalshare.external;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T> f237056a = null;

    static {
        f237056a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("FolderShareExternalPresenter", "refreshFolderPermission failed", (Throwable) r100, false);
    }
}
