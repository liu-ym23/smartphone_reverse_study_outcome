package fp;

import com.bytedance.android.ec.window.base.monitor.WindowErrorCode;
import com.bytedance.android.ec.window.base.monitor.WindowErrorDomain;
import com.bytedance.android.ec.window.base.shopping.paging.WindowListStatusPositionalLoadInitialCallback;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowListStatusPositionalLoadInitialCallback f478219a;

    public g(WindowListStatusPositionalLoadInitialCallback r100) {
        this.f478219a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        WindowListStatusPositionalLoadInitialCallback r101 = this.f478219a;
        WindowErrorDomain.NATIVE.getCode();
        WindowErrorCode.NATIVE_COMMON.getCode();
        ((Throwable) r100).getMessage();
        r101.f49670b.e(WindowLoadStatus.InitializeError);
    }
}
