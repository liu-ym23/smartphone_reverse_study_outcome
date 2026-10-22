package bk3;

import com.bytedance.android.ec.store.monitor.ErrorCode;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadInitialCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ ListStatusPositionalLoadInitialCallback a;

    public d(ListStatusPositionalLoadInitialCallback r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ListStatusPositionalLoadInitialCallback r0 = this.a;
        ErrorDomain.NATIVE.getCode();
        ErrorCode.NATIVE_COMMON.getCode();
        ((Throwable) r3).getMessage();
        r0.a();
    }
}
