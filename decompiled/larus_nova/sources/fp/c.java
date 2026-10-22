package fp;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.window.base.shopping.paging.WindowListStatusPositionalLoadRangeCallback;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowListStatusPositionalLoadRangeCallback f478212a;

    public c(WindowListStatusPositionalLoadRangeCallback r100) {
        this.f478212a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (ECAppInfoService.f48114e.i() == false) goto L5;
        r101.printStackTrace();
    L5:
        this.f478212a.f49672b.e(WindowLoadStatus.LoadMoreError);
    }
}
