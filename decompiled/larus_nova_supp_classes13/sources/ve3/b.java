package ve3;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.ligo.context.LigoViewManager;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import w83.d;
import w83.g;
import w83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements g {
    public b() {
    }

    @Override // w83.g
    public final d b(gj2.a r2) {
        return new com.bytedance.android.shopping.ligo.context.b(r2);
    }

    @Override // w83.g
    public final i a(LifecycleOwner r9, Map r10, d r11, Function0 r12, Function0 r13) {
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        if ((r10 instanceof Map) == true) goto L6;
        r10 = null;
    L6:
        return new LigoViewManager(r9, r10, r11, r12, r13, new a());
    }
}
