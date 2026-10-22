package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ e a;

    public b(e r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        e r0 = this.a;
        CommonMeta r1 = (CommonMeta) r4.getFirst();
        boolean r5 = ((Boolean) r4.getSecond()).booleanValue();
        r0.getClass();
        if (r1 == null) goto L5;
        String r2 = r1.getLastEcomSceneId();
    L6:
        boolean r6 = com.bytedance.android.shopping.anchorv4.helper.e.d(r2);
        if (r5 == false) goto L10;
        if (r6 == true) goto L10;
        boolean r7 = true;
    L11:
        BottomSheetBehavior<View> r8 = r0.a;
        if (r8 == null) goto L14;
        r8.setSkipCollapsed(r7);
    L14:
        r0.b = r7;
        return;
    L10:
        r7 = false;
        goto L11
    L5:
        r2 = null;
        goto L6
    }
}
