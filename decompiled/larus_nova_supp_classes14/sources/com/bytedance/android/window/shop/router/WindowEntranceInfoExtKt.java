package com.bytedance.android.window.shop.router;

import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowEntranceInfoExtKt {
    public static final Set<WindowEntranceInfoScene> a = null;

    static {
        a = SetsKt.setOf(new WindowEntranceInfoScene[]{WindowEntranceInfoScene.ENTER_REPLAY, WindowEntranceInfoScene.ENTER_PRODUCT_DETAIL});
    }

    public static final JSONObject a(JSONObject r1, WindowEntranceInfoScene r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$doPostEntranceInfoCheck");
        Intrinsics.checkNotNullParameter(r2, "scene");
        gl.a r4 = b(r1, r2, r3);
        if (r4 != null) goto L5;
        return r1;
    L5:
        JSONObject r5 = z1.g(r4.h());
        if (r5 != null) goto L9;
        return r1;
    L9:
        return r5;
    }

    public static final gl.a b(JSONObject r6, WindowEntranceInfoScene r7, String r8) {
        Lazy r0 = ECSettingKeys.a;
        int r1 = p.a;
        Object r2 = Boolean.TRUE;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
        Object r5 = jj4.a.a("window_use_entrance_info_sdk", Boolean.class, r2, false);     // Catch: Throwable -> L7
        if (r5 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        if (((Boolean) r5).booleanValue() == true) goto L16;
        return null;
    L16:
        int r9 = ECSdk.a;
        IEntranceInfoService r10 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r10 == null) goto L19;
        gl.a r11 = r10.initEntranceInfo(r7.getEntranceInfoScene(), r8);
    L20:
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<String> r13 = r6.keys();
    L22:
        if (r13.hasNext() == false) goto L24;
        String r14 = r13.next();
        r12.put(r14, r6.get(r14));
        goto L22
    L24:
        if (r11 == null) goto L27;
        r11.f(r12, WindowEntranceInfoExtKt$doPostEntranceInfoProcess$2.INSTANCE);
    L27:
        if (ECAppInfoService.e.i() == false) goto L36;
        int r15 = ECSdk.a;
        IECAPTService r16 = (IECAPTService) ECSdk.a(IECAPTService.class);
        if (r16 == null) goto L36;
        String r17 = r7.getEntranceInfoScene().b;
        String r18 = r6.toString();
        if (r11 == null) goto L33;
        String r19 = r11.h();
    L34:
        r16.diff(r17, r18, r19);
        goto L36
    L33:
        r19 = null;
    L36:
        if (a.contains(r7) == false) goto L42;
        String r20 = r7.getEntranceInfoScene().b;
        String r21 = r7.getEntranceInfoScene().a;
        if (r11 == null) goto L40;
        String r22 = r11.h();
    L41:
        new c(r20, r21, r8, r22).post(null, null);
        goto L42
    L40:
        r22 = null;
    L42:
        return r11;
    L19:
        r11 = null;
    L7:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Object r24 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r24) == true) goto L12;
        r2 = r24;
    L12:
        r5 = r2;
        goto L14
    }
}
