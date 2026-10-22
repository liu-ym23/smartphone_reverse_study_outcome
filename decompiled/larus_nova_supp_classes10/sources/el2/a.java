package el2;

import android.content.Context;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sg2.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements x {
    public a() {
    }

    @Override // sg2.x
    public final void a() {
        int r0 = ECSdk.a;
        IEShoppingService r1 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r1 == null) goto L6;
        r1.agreeXiaoDianLaw();
        return;
    }

    @Override // sg2.x
    public final void b(Context r7, Function2 r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        int r0 = ECSdk.a;
        IEShoppingService r1 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r1 == null) goto L6;
        r1.checkLawHint(r7, 10, null, r8);
        return;
    }
}
