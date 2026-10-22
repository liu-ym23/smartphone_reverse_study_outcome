package com.bytedance.android.livesdk.livecommerce.params;

import android.content.Context;
import com.bytedance.android.ec.core.utils.LoginUtil;
import com.bytedance.android.livesdk.livecommerce.event.i;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final WeakHashMap<Context, Unit> a = null;

    public a() {
    }

    static {
        a = new WeakHashMap();
    }

    public static final void a(String r2, String r3, List r4) {
        i r0 = new i();
        Intrinsics.checkNotNullParameter(r2, "reason");
        r0.f("failure_reason", r2);
        String r5 = String.valueOf(r4);
        r0.f("action_params_type", r3);
        r0.f("paramsTypes", r5);
        r0.k();
    }

    public static void b(final Context r12, final String r13, final String r14, final String r15, final String r16, final boolean r17, List r18, List r19, Map r20, Map r21, int r22) {
        if ((r22 & 64) == 0) goto L5;
        final List r7 = null;
    L7:
        if ((r22 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L9;
        final List r3 = null;
    L11:
        if ((r22 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L13;
        final Map r1 = null;
    L15:
        if ((r22 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L17;
        final Map r5 = null;
    L18:
        Intrinsics.checkNotNullParameter(r12, "context");
        if (Intrinsics.areEqual(r16, "xtab_mall") == false) goto L25;
        if (r5 != null) goto L22;
        r5 = MapsKt.emptyMap();
    L22:
        if (r1 != null) goto L24;
        r1 = MapsKt.emptyMap();
    L24:
        Map r0 = LoginUtil.a;
        LoginUtil.f(r12, new LiveJumpWithParamsHelper$openSchemaAppendLiveEntrance$1(r15, r5, r1, r12));
        return;
    L25:
        Map r2 = LoginUtil.a;
        LoginUtil.f(r12, new LiveJumpWithParamsHelper$openSchemaWithParams$1(r13, r14, r3, r15, r5, r16, r7, r12, r17));
        return;
    L17:
        r5 = r21;
        goto L18
    L13:
        r1 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r7 = r18;
        goto L7
    }
}
