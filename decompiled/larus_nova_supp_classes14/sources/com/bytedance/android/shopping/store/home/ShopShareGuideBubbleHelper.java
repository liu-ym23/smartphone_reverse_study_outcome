package com.bytedance.android.shopping.store.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopShareGuideBubbleHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r15, LifecycleOwner r16, View r17, ViewGroup r18, com.bytedance.android.shopping.store.home.entity.j r19, final Function0 r20) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r17, "anchorView");
        Intrinsics.checkNotNullParameter(r19, "shareInfo");
        Intrinsics.checkNotNullParameter(r20, "onBubbleShown");
        Long r2 = r19.d;
        if (r2 == null) goto L5;
        long r5 = r2.longValue();
    L6:
        Long r3 = r19.c;
        if (r3 == null) goto L9;
        long r7 = r3.longValue();
    L10:
        String r0 = r19.b;
        if (r0 != null) goto L13;
        r0 = "";
    L13:
        String r10 = r0;
        com.bytedance.android.ec.sdk.helper.q r1 = com.bytedance.android.ec.sdk.helper.q.a;
        final long r11 = com.bytedance.android.ec.sdk.helper.q.f("sp_key_share_guide_bubble_show_count");
        if (r11 < r5) goto L16;
        return;
    L16:
        if (r10.length() <= 0) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L23;
        long r6 = r7;
        com.bytedance.android.shopping.store.home.view.n r13 = new com.bytedance.android.shopping.store.home.view.n(r15, r16, r17, r18, r10, r6, new ShopShareGuideBubbleHelper$tryShowShareGuideBubbleNow$shareGuidBubbleView$1(r11, r20));
        ECBubbleControllerManager.b.a(r16).a(com.bytedance.android.ec.store.common.bubble.a.b, r13);
        return;
    L23:
        return;
    L18:
        r4 = false;
        goto L19
    L9:
        r7 = 3000;
        goto L10
    L5:
        r5 = 3;
        goto L6
    }
}
