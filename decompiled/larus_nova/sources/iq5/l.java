package iq5;

import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.selector.d f495369a;

    public l(com.bytedance.ee.bear.wikiv2.selector.d r100) {
        this.f495369a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        tt5.a.d("FolderSelectPresenter", "loadData()...error = " + r101);
        this.f495369a.f241152c.E(r101);
    }
}
