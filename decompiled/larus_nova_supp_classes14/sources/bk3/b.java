package bk3;

import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadRangeCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ ListStatusPositionalLoadRangeCallback a;

    public b(ListStatusPositionalLoadRangeCallback r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        this.a.a();
    }
}
