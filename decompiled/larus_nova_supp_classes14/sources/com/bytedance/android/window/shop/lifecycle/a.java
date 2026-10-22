package com.bytedance.android.window.shop.lifecycle;

import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(ECWindowViewModel r5, k r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        String r0 = null;
        if (r6 == null) goto L5;
        Map r1 = null;
        r6.getClass();
    L6:
        Pair[] r2 = new Pair[5];
        if (r5.getShopParam().isCroppedStyle() == false) goto L9;
        String r3 = "split";
    L10:
        r2[0] = TuplesKt.to("modal", r3);
        if (r6 == null) goto L15;
        Long r4 = r6.a;
        if (r4 == null) goto L15;
        String r9 = String.valueOf(r4.longValue());
    L16:
        r2[1] = TuplesKt.to("cardCreateTime", r9);
        if (r6 == null) goto L21;
        Long r10 = r6.b;
        if (r10 == null) goto L21;
        r0 = String.valueOf(r10.longValue());
    L21:
        r2[2] = TuplesKt.to("draw_end", r0);
        r2[3] = TuplesKt.to("item_type", r7);
        if (r8 == false) goto L24;
        String r11 = CommentScene.COMMENTSCENE_NO_AWEME;
    L25:
        r2[4] = TuplesKt.to("is_preload", r11);
        r5.doEventAction("ec_perf_duration_window_lynx_card_setup", r1, r2);
        return;
    L24:
        r11 = "0";
    L15:
        r9 = null;
        goto L16
    L9:
        r3 = "full";
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static void b(ECWindowViewModel r5, k r6, String r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        String r0 = null;
        if (r6 == null) goto L5;
        Object r1 = null;
        r6.getClass();
    L7:
        if ((!Intrinsics.areEqual(r1, r7)) == false) goto L9;
        return;
    L9:
        if (r6 == null) goto L11;
        Map r10 = null;
        r6.getClass();
    L12:
        Pair[] r2 = new Pair[5];
        if (r5.getShopParam().isCroppedStyle() == false) goto L15;
        String r3 = "split";
    L16:
        r2[0] = TuplesKt.to("modal", r3);
        if (r6 == null) goto L21;
        Long r4 = r6.a;
        if (r4 == null) goto L21;
        String r11 = String.valueOf(r4.longValue());
    L22:
        r2[1] = TuplesKt.to("cardCreateTime", r11);
        if (r6 == null) goto L27;
        Long r12 = r6.b;
        if (r12 == null) goto L27;
        r0 = String.valueOf(r12.longValue());
    L27:
        r2[2] = TuplesKt.to("draw_end", r0);
        r2[3] = TuplesKt.to("item_type", r8);
        if (r9 == false) goto L30;
        String r13 = CommentScene.COMMENTSCENE_NO_AWEME;
    L31:
        r2[4] = TuplesKt.to("is_preload", r13);
        r5.doEventAction("ec_perf_duration_window_lynx_card_update", r10, r2);
        return;
    L30:
        r13 = "0";
    L21:
        r11 = null;
        goto L22
    L15:
        r3 = "full";
        goto L16
    L11:
        r10 = null;
        goto L12
    L5:
        r1 = null;
        goto L7
    }
}
