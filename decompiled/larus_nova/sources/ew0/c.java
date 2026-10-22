package ew0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements dw0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f474526a = null;

    public c() {
    }

    static {
        f474526a = new c();
    }

    @Override // dw0.a
    public final void a(String r100, Map<String, String> r101, Collection<? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "eventProperties");
        Intrinsics.checkNotNullParameter(r102, "eventContext");
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if ((r105 instanceof com.bytedance.android.live.recharge.deal.f) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        Iterator r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L23;
        com.bytedance.android.live.recharge.deal.f r107 = (com.bytedance.android.live.recharge.deal.f) r106.next();
        r101.put("money", String.valueOf(r107.i()));
        r101.put("money_paid", String.valueOf(r107.g()));
        r101.put("given_scores", String.valueOf(r107.h()));
        Intrinsics.checkNotNullParameter(r107, "$this$getDescription");
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r108 = r107.c().getPanelExtraInfo().get(Long.valueOf(r107.g()));
        if (r108 == null) goto L15;
        String r109 = r108.getDiamondDesc();
        if (r109 == null) goto L15;
    L16:
        String r110 = r107.d();
        if (r109.length() != 0) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == false) goto L22;
        r109 = r110;
    L22:
        r101.put("deal_badge", r109);
        goto L10
    L19:
        r111 = false;
    L15:
        r109 = "";
        goto L16
    }
}
