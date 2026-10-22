package el2;

import android.content.Context;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sg2.x;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements x {
    public b() {
    }

    @Override // sg2.x
    public final void a() {
    }

    @Override // sg2.x
    public final void b(Context r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        int r102 = ECSdk.f48106a;
        IEShoppingService r103 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r103 == null) goto L6;
        r103.checkLawHint(r100, 10, null, r101);
        return;
    }
}
