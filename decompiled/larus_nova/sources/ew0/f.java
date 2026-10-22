package ew0;

import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.j;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements dw0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f474528a = null;

    public f() {
    }

    static {
        f474528a = new f();
    }

    @Override // dw0.a
    public final void a(String r100, Map<String, String> r101, Collection<? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "eventProperties");
        Intrinsics.checkNotNullParameter(r102, "eventContext");
        com.bytedance.android.live.recharge.panel.context.c r103 = com.bytedance.android.live.recharge.panel.g.a();
        if (r103 == null) goto L7;
        com.bytedance.android.live.revenue.common.reactive.e<i> r104 = r103.g();
        if (r104 == null) goto L7;
        i r105 = r104.getValue();
    L8:
        boolean r106 = j.b(r105);
        if (r106 == true) goto L11;
    L13:
        boolean r107 = false;
    L14:
        String r108 = "1";
        if (r106 == false) goto L17;
        String r109 = "1";
    L18:
        r101.put("is_fast_pay", r109);
        if (r107 == true) goto L22;
        r108 = "0";
    L22:
        r101.put("open_fast_pay_opt", r108);
        return;
    L17:
        r109 = "0";
        goto L18
    L11:
        if (com.bytedance.android.live.recharge.util.g.a().a() == false) goto L13;
        r107 = true;
    L7:
        r105 = null;
        goto L8
    }
}
