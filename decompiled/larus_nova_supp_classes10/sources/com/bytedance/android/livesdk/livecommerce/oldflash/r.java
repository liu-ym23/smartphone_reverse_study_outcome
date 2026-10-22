package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import com.bytedance.android.ui.ec.widget.loading.ECLoadingDialog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static LiveFlashNewFragment a(final Context r18, String r19, String r20, String r21, Function2 r22, FlashController.b r23, FlashController r24, Bundle r25, final Long r26) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "roomAnchorId");
        Intrinsics.checkNotNullParameter(r20, "roomAnchorSecId");
        Intrinsics.checkNotNullParameter(r21, "roomId");
        Intrinsics.checkNotNullParameter(r22, "getScreenshotSquare");
        Intrinsics.checkNotNullParameter(r23, "flashState");
        Intrinsics.checkNotNullParameter(r24, "flashController");
        final ECLoadingDialog r10 = com.bytedance.android.livesdk.livecommerce.utils.k.m(r18, "");
        int r11 = LiveFlashNewFragment.w;
        String r12 = r23.d;
        String r13 = r23.e;
        if (r25 == null) goto L5;
        String r14 = r25.getString("target_id");
    L7:
        if (r25 == null) goto L9;
        long r9 = r25.getLong("click_time", System.currentTimeMillis());
    L10:
        String r15 = r23.c;
        Map<String, ? extends List<String>> r4 = r23.g;
        if (r25 == null) goto L13;
        String r0 = r25.getString("target_name");
    L14:
        boolean r7 = r23.a;
        int r5 = r23.b;
        Intrinsics.checkNotNullParameter(r24, "flashController");
        Bundle r8 = new Bundle();
        r8.putString("args_broadcast_id", r19);
        r8.putString("args_broadcast_sec_id", r20);
        r8.putString("args_room_id", r21);
        r8.putString("args_target_id", r14);
        r8.putString("args_category_id", r13);
        r8.putString("args_category_name", r12);
        r8.putLong("click_time", r9);
        HashMap r1 = new HashMap();
        if (r4 == null) goto L17;
        r1.putAll(r4);
    L17:
        Unit r2 = Unit.INSTANCE;
        r8.putSerializable("args_properties", r1);
        r8.putString("args_shop_id", r15);
        r8.putString("args_target_name", r0);
        r8.putBoolean("args_need_barcode", r7);
        r8.putInt("args_barcode_state", r5);
        final LiveFlashNewFragment r3 = new LiveFlashNewFragment();
        r3.setArguments(r8);
        r3.v = r24;
        r22.invoke(r18, new LiveFlashFragmentUtils$obtainFragment$1(r10, r3, r18, r26));
        return r3;
    L13:
        r0 = "";
        goto L14
    L9:
        r9 = System.currentTimeMillis();
        goto L10
    L5:
        r14 = "";
        goto L7
    }
}
