package d71;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends e<v61.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f467217c;

    public final void a() {
        Disposable r100 = this.f467217c;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        r100.dispose();
        return;
    }

    public b(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindow");
        super(r100);
    }
}
