package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r7, "pageName");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L9
        if (r4 == false) goto L6;
        int r8 = 1;
    L7:
        r2.putOpt("is_success", Integer.valueOf(r8));     // Catch: Throwable -> L9
        r2.putOpt("error_type", r5);     // Catch: Throwable -> L9
        r2.putOpt("action", r6);     // Catch: Throwable -> L9
        r2.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, r7);     // Catch: Throwable -> L9
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L9
        AppLogNewUtils.onEventV3("mall_gyl_fetch_by_action", r2);     // Catch: Throwable -> L9
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L6:
        r8 = 0;
    L9:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
