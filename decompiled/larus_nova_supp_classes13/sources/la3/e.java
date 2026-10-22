package la3;

import cf.t;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final t a;
    public final Function1<String, Unit> b;
    public final Function1<SkuShowAndDismissState, Unit> c;
    public final Function1<SkuProductDetailInfo, Unit> d;

    public e(t r1, Function1 r2, Function1 r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
