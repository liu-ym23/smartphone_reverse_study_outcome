package com.bytedance.android.shopping.card_list.eventcenter.event;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CollectPassThroughData;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CardListObjectContainer a;

    public e(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Map r4 = r3.q();
        if (r4 == null) goto L5;
        Object r5 = r4.get("click_type");
    L7:
        if ((r5 instanceof String) == true) goto L9;
        r5 = null;
    L9:
        String r6 = (String) r5;
        CardPassThroughData r1 = this.a.e.a;
        if (r1 == null) goto L12;
        CollectPassThroughData r2 = r1.getCollectSchemaData();
    L13:
        if (r2 == null) goto L20;
        Fragment r7 = this.a.d;
        if (r7 == null) goto L37;
        FragmentActivity r8 = r7.getActivity();
        if (r8 == null) goto L37;
        r8.finish();
    L37:
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L20:
        if (Intrinsics.areEqual(r6, "back") == false) goto L23;
        this.a.a();
        goto L37
    L23:
        if (Intrinsics.areEqual(r6, "close_all") == false) goto L36;
        int r10 = com.bytedance.android.shopping.card_list.utils.h.a;
        CardPassThroughData r11 = this.a.e.a;
        if (r11 == null) goto L27;
        String r12 = r11.getSplitActivityScene();
    L29:
        if (com.bytedance.android.shopping.card_list.utils.h.a(r12) == false) goto L37;
        nj.d r13 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r13 == null) goto L37;
        Fragment r14 = this.a.d;
        if (r14 == null) goto L35;
        r14.requireActivity();
    L35:
        r13.n();
        goto L37
    L27:
        r12 = null;
        goto L29
    L36:
        this.a.a();
        goto L37
    L12:
        r2 = null;
        goto L13
    L5:
        r5 = null;
        goto L7
    }
}
