package el2;

import android.content.Context;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.shopping.api.IEShoppingService;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sg2.x;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements x {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // sg2.x
    public final void a() {
        int r100 = ECSdk.f48106a;
        IEShoppingService r101 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r101 == null) goto L6;
        r101.agreeXiaoDianLaw();
        return;
    }

    @Override // sg2.x
    public final void b(Context r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, l0.d());
        r102.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "live_list_card");
        int r103 = ECSdk.f48106a;
        IEShoppingService r104 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r104 == null) goto L6;
        r104.checkLawHint(r100, 10, r102, r101);
        return;
    }
}
