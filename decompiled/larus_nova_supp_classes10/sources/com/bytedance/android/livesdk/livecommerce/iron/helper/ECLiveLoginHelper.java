package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveLoginHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean c(int r2, boolean r3) {
        if (r2 < 1) goto L13;
        if (r3 == false) goto L11;
        List<Integer> r4 = ECLiveABUtils.INSTANCE.getINSTANT_ROOM_FUNC_MAP().get("live_no_login");
        if (r4 != null) goto L9;
        r4 = CollectionsKt.emptyList();
    L9:
        if (r4.contains(Integer.valueOf(r2)) == false) goto L11;
        return true;
    L11:
        return false;
    L13:
        return r3;
    }

    public static void a(final Context r15, final jf.b r16, final il2.a r17, final Function0 r18) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r18, "nextStep");
        final Function0<Unit> r10 = new ECLiveLoginHelper$checkLoginWithEcomEntranceForm$loginCallback$1(r16, r15, r18);
        final ECLiveLoginHelper$checkLogin$2 r11 = ECLiveLoginHelper$checkLogin$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r18, "nextStep");
        Intrinsics.checkNotNullParameter(r10, "loginCallback");
        Intrinsics.checkNotNullParameter(r11, "errorCallback");
        Activity r12 = com.bytedance.android.ec.core.utils.p.a.getActivity(r15);
        if (r12 == null) goto L13;
        com.bytedance.android.ec.sdk.helper.r r13 = com.bytedance.android.ec.sdk.helper.r.a;
        if (r13.isLogin() == false) goto L9;
        if (r17 == null) goto L8;
        il2.a.C0145a.a(r17, "check_login", MapsKt.mapOf(TuplesKt.to("is_login", "true")), false, null, null, null, 60);
    L8:
        r18.invoke();
        return;
    L9:
        if (r17 == null) goto L11;
        il2.a.C0145a.a(r17, "check_login", MapsKt.mapOf(TuplesKt.to("is_login", "false")), false, null, null, null, 60);
    L11:
        r13.d(r12, "", "", "", new ECLiveLoginHelper$checkLogin$$inlined$let$lambda$1(r17, r18, r10, r11), new ECLiveLoginHelper$checkLogin$$inlined$let$lambda$2(r17, r18, r10, r11));
        return;
    }

    public static void b(Context r1, com.bytedance.android.ec.common.api.jump.model.g r2, il2.a r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "nextStep");
        if (r2 == null) goto L7;
        com.bytedance.android.ec.common.api.jump.model.f r5 = r2.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r5 == null) goto L7;
        jf.b r6 = r5.c;
    L8:
        a(r1, r6, r3, r4);
        return;
    L7:
        r6 = null;
        goto L8
    }
}
