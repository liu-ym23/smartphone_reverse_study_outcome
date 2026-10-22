package wj2;

import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public c() {
    }

    static {
    }

    public static /* synthetic */ boolean b(Context r16, float[] r17, float[] r18, Function0 r19, int r20) {
        if ((r20 & 2) == 0) goto L5;
        float[] r4 = null;
    L7:
        if ((r20 & 4) == 0) goto L9;
        float[] r5 = null;
    L11:
        if ((r20 & 2048) == 0) goto L13;
        Function0 r15 = null;
    L15:
        return a(r16, r4, r5, null, null, 0, null, null, null, false, null, r15);
    L13:
        r15 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public static boolean a(Context r23, float[] r24, float[] r25, View r26, View r27, long r28, View r30, Float r31, Float r32, boolean r33, AnimatorSet r34, Function0 r35) {
        Intrinsics.checkNotNullParameter(r23, "context");
        if (r24 == null) goto L15;
        if (r25 == null) goto L15;
        if (r24.length != 2) goto L15;
        if (r25.length != 2) goto L15;
        Lazy r3 = LiveDynamicContext.c;
        com.bytedance.android.livesdk.livecommerce.ability.b r4 = LiveDynamicContext.a.a().a();
        JSONObject r5 = new JSONObject();
        r5.putOpt("source_loc_x", ArraysKt.getOrNull(r24, 0));
        r5.putOpt("source_loc_y", ArraysKt.getOrNull(r24, 1));
        r5.putOpt("destination_loc_x", ArraysKt.getOrNull(r25, 0));
        r5.putOpt("destination_loc_y", ArraysKt.getOrNull(r25, 1));
        r5.put("delay", r28);
        r5.putOpt("anim_layout_width", r31);
        r5.putOpt("anim_layout_height", r32);
        if (r33 == false) goto L12;
        JSONArray r0 = new JSONArray();
        r0.put(0, 1.0d);
        r0.put(1, 0.3d);
        Unit r1 = Unit.INSTANCE;
        r5.put("scale_x", r0);
        JSONArray r2 = new JSONArray();
        r2.put(0, 1.0d);
        r2.put(1, 0.3d);
        r5.put("scale_y", r2);
    L12:
        Unit r6 = Unit.INSTANCE;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(r4, r23, new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", "live_list_show_add_cart_motion", r5), r30, null, new b(r35), 8);
        return true;
    L15:
        if (r26 == null) goto L21;
        if (r27 == null) goto L21;
        int r7 = ECSdk.a;
        IECCommonService r11 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r11 == null) goto L20;
        r11.addCartMotion(r26, r27, r28, null, Boolean.TRUE, r30, r31, r32, r34, r35);
    L20:
        return true;
    L21:
        return false;
    }
}
