package com.bytedance.android.livesdk.livecommerce.skin;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveLayoutConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements e {
    public Map<String, ECLiveLayoutConfig> a;
    public final c b;
    public List<String> c;

    @Override // com.bytedance.android.livesdk.livecommerce.skin.e
    public final c a() {
        return this.b;
    }

    public a(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutTypes");
        this.c = r2;
        ECLiveSkinUtil.l.getClass();
        this.a = ECLiveSkinUtil.e("list", r2);
        this.b = new c(this.c);
    }

    public final void b(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "layoutTypes");
        ECLiveSkinUtil r1 = ECLiveSkinUtil.l;
        List<String> r2 = this.c;
        r1.getClass();
        if ((!Intrinsics.areEqual(ECLiveSkinUtil.h(r2), ECLiveSkinUtil.h(r4))) == false) goto L8;
        this.c = r4;
        this.a = ECLiveSkinUtil.e("list", r4);
        c r3 = this.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "layoutTypes");
        if ((!Intrinsics.areEqual(ECLiveSkinUtil.h(r3.d), ECLiveSkinUtil.h(r4))) == false) goto L9;
        r3.d = r4;
        r3.a = ECLiveSkinUtil.e("promotion_card", r4);
        return;
    L9:
        return;
    }

    public final void c(boolean r4) {
        c r0 = this.b;
        r0.b = r4;
        if (r4 == false) goto L21;
        List<String> r5 = r0.d;
        if ((r5 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        String r1 = (String) r6.next();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SPLIT_LAYOUT_CONFIG_SIDE_BAR_LAYOUT_TYPE().contains(r1) == false) goto L11;
        boolean r7 = true;
    L16:
        r0.c = r7;
        return;
    L15:
        r7 = false;
        goto L16
    L7:
        if (r5.isEmpty() == false) goto L9;
    }
}
