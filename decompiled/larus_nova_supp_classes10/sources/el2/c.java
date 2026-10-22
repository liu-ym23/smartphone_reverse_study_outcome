package el2;

import android.content.Context;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.shopping.api.IEShoppingService;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sg2.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements x {

    public static final class a {
    }

    static {
    }

    public c() {
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
    public final void b(Context r8, Function2 r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("carrier_source", l0.d());
        r5.put("ecom_entrance_form", "live_list_card");
        int r0 = ECSdk.a;
        IEShoppingService r1 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r1 == null) goto L6;
        r1.checkLawHint(r8, 10, r5, r9);
        return;
    }
}
