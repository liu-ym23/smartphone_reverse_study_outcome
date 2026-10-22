package ir4;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f495446a = null;

    static {
        f495446a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("BitableAttachmentUploadUtils", "deleteFileModelFromDB fail!: " + ((Throwable) r100));
    }
}
