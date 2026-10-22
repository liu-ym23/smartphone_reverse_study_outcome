package vf3;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final AtomicBoolean a;
    public final CartViewModel b;
    public final AndroidYaTaInstance c;
    public final String d;
    public final PageFinder e;

    public b(CartViewModel r2, AndroidYaTaInstance r3, String r4, PageFinder r5) {
        Intrinsics.checkNotNullParameter(r2, "cartVM");
        Intrinsics.checkNotNullParameter(r3, "yataInstance");
        Intrinsics.checkNotNullParameter(r4, "prefetchSessionId");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = new AtomicBoolean(false);
    }
}
