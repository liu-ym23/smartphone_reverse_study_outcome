package ir4;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f495452a = null;

    static {
        f495452a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("BitableAttachmentUploadUtils", "insertFileModelToDB fail!: " + ((Throwable) r100));
    }
}
