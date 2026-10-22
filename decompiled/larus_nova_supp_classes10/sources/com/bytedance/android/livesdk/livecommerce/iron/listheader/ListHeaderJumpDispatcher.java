package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.LoginUtil;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.IronListHeaderEntryView;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ListHeaderJumpDispatcher {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(final Context r1, final Map r2, final String r3, final com.bytedance.android.btm.api.model.d r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "params");
        Map r0 = LoginUtil.a;
        LoginUtil.e(r1, "list_card_clickshopstore", new ListHeaderJumpDispatcher$dispatchWindowDetail$1(r3, r2, r1, r4));
    }

    public static void a(Context r12, i r13, ECPromotionEntry r14, IronListHeaderEntryView r15, Map r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r12, "context");
        if (r14 != null) goto L5;
        return;
    L5:
        String r10 = "list_card_click" + r14.getTrackName();
        if (r16 == null) goto L9;
        String r0 = (String) r16.get("btm_page_id");
        if (r0 == null) goto L9;
    L10:
        PageFinder r4 = PageFinder.via(r0);
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = BtmUtilsKt.e("a1.b0715.c9204.d838700", r4);
        Map r1 = LoginUtil.a;
        LoginUtil.e(r12, r10, new ListHeaderJumpDispatcher$dispatchEntryJump$1(r12, r17, r3, r4, r14, r13, r15, r16));
        return;
    L9:
        r0 = "";
        goto L10
    }

    public static void b(Context r6, Map r7, View r8, String r9, List r10, com.bytedance.android.btm.api.model.d r11) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "view");
        Map r12 = LoginUtil.a;
        LoginUtil.e(r6, "list_card_clickshopstore", new ListHeaderJumpDispatcher$dispatchShopInfoDetail$1(r9, r7, r6, r11, r10));
    }
}
