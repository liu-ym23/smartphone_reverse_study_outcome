package com.bytedance.android.shopping.store.utils;

import android.content.Context;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.store.setting.SettingKeys;
import com.bytedance.android.shopping.store.home.api.InterceptBackPressKey;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(ECStoreViewModel r4, Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "closeStoreMethod");
        if (com.bytedance.android.shopping.extensions.k.c(r4.getStayPopupData()) == false) goto L6;
        r4.getStoreParam().setInterceptBackProcessType("leave_red_pack");
    L6:
        if (r4.getStoreParam().getInterceptBackProcessType() != null) goto L33;
        return true;
    L33:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r1 = Result.constructor-impl(com.bytedance.android.shopping.extensions.k.w(SettingKeys.getSTORE_EXIT_INTERCEPTION_CONFIGS()));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r1) == false) goto L15;
        r1 = null;
    L15:
        JSONObject r2 = (JSONObject) r1;
        if (r2 != null) goto L18;
        r2 = new JSONObject();
    L18:
        String r3 = String.valueOf(r4.getStoreParam().getInterceptBackProcessType());
        a0 r7 = (a0) u0.b(r2.optString(r3), a0.class);
        if (r7 != null) goto L22;
        return true;
    L22:
        if (Intrinsics.areEqual(r3, InterceptBackPressKey.MALLPOPUPKEY.getType()) == false) goto L24;
    L30:
        l r8 = new k(r7);
    L32:
        return r8.a(r4, r5);
    L24:
        if (Intrinsics.areEqual(r3, InterceptBackPressKey.MALLKEY.getType()) == true) goto L30;
        if (Intrinsics.areEqual(r3, InterceptBackPressKey.LEAVE_RED_PACK_KEY.getType()) == false) goto L29;
        r8 = new ECStoreLeaveRedpackIntercept(r7, r6);
        goto L32
    L29:
        r8 = new ECStoreCommonIntercept(r7);
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
