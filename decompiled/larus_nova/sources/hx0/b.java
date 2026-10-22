package hx0;

import android.text.TextUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends a<gx0.a> {
    public b() {
    }

    @Override // hx0.a
    public final void c(Map r100, gx0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r100, "map");
        a(r100);
        if (TextUtils.isEmpty(r101.f483083a) == true) goto L6;
        String r102 = r101.f483083a;
        Intrinsics.checkNotNullParameter("exchange_reason", "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        this.f487466a.put("exchange_reason", r102);
    L6:
        if (TextUtils.isEmpty(r101.f483084b) == true) goto L9;
        String r103 = r101.f483084b;
        Intrinsics.checkNotNullParameter("event_module", "key");
        Intrinsics.checkNotNullParameter(r103, "value");
        this.f487466a.put("event_module", r103);
    L9:
        if (TextUtils.isEmpty(r101.f483085c) == true) goto L12;
        String r104 = r101.f483085c;
        Intrinsics.checkNotNullParameter("popup_type", "key");
        Intrinsics.checkNotNullParameter(r104, "value");
        this.f487466a.put("popup_type", r104);
        return;
    }
}
