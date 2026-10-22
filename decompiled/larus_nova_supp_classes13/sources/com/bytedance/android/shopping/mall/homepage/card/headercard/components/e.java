package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.ToolListAdapter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements com.bytedance.android.ec.hybrid.card.event.e {
    public final /* synthetic */ LegouToolAreaComponent a;

    public e(LegouToolAreaComponent r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.ec.hybrid.card.event.d r4) {
        Intrinsics.checkNotNullParameter(r4, "jsEvent");
        Map r5 = r4.b;
        Object r0 = null;
        if (r5 == null) goto L5;
        Object r6 = r5.get("show");
    L7:
        if ((r6 instanceof Boolean) == false) goto L10;
        r0 = r6;
    L10:
        Boolean r1 = (Boolean) r0;
        if (r1 == null) goto L16;
        ToolListAdapter r7 = this.a.f;
        boolean r2 = !r1.booleanValue();
        r7.getClass();
        Intrinsics.checkNotNullParameter("2", "cid");
        RecyclerView r3 = r7.d;
        if (r3 == null) goto L17;
        r3.post(new com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.d(r7, r2));
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
