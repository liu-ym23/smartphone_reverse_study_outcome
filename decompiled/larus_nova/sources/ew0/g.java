package ew0;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements dw0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f474529a = null;

    public g() {
    }

    static {
        f474529a = new g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dw0.a
    public final void a(String r100, Map<String, String> r101, Collection<? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "eventProperties");
        Intrinsics.checkNotNullParameter(r102, "eventContext");
        com.bytedance.android.live.recharge.panel.context.c r103 = com.bytedance.android.live.recharge.panel.g.a();
        if (r103 == null) goto L26;
        com.bytedance.android.live.revenue.common.reactive.c r104 = r103.d();
        if (r104 == null) goto L27;
        com.bytedance.android.live.recharge.deal.f r105 = (com.bytedance.android.live.recharge.deal.f) r104.f90981b;
        if (r105 == null) goto L29;
        CharSequence r106 = (CharSequence) ((LinkedHashMap) r101).get("is_discount_package");
        boolean r107 = true;
        if (r106 != null) goto L12;
    L15:
        boolean r108 = true;
    L16:
        if (r108 == true) goto L18;
        return;
    L18:
        if (r105.h() > 0) goto L21;
        r107 = false;
    L21:
        if (r107 == false) goto L23;
        String r109 = "1";
    L24:
        r101.put("is_discount_package", r109);
        return;
    L23:
        r109 = "0";
        goto L24
    L12:
        if (r106.length() == 0) goto L15;
        r108 = false;
        goto L16
    L29:
        return;
    L27:
        return;
    }
}
