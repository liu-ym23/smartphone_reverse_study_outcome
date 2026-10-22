package wj2;

import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f559970a = 0;

    public c() {
    }

    static {
    }

    public static /* synthetic */ boolean b(Context r110, float[] r111, float[] r112, Function0 r113, int r210) {
        if ((r210 & 2) == 0) goto L5;
        float[] r100 = null;
    L7:
        if ((r210 & 4) == 0) goto L9;
        float[] r101 = null;
    L11:
        if ((r210 & 2048) == 0) goto L13;
        Function0 r114 = null;
    L15:
        return a(r110, r100, r101, null, null, 0, null, null, null, false, null, r114);
    L13:
        r114 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static boolean a(Context r210, float[] r211, float[] r212, View r213, View r214, long r215, View r310, Float r311, Float r312, boolean r313, AnimatorSet r314, Function0 r315) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r211 == null) goto L15;
        if (r212 == null) goto L15;
        if (r211.length != 2) goto L15;
        if (r212.length != 2) goto L15;
        Lazy r100 = LiveDynamicContext.f147714c;
        com.bytedance.android.livesdk.livecommerce.ability.b r101 = LiveDynamicContext.a.a().a();
        JSONObject r102 = new JSONObject();
        r102.putOpt("source_loc_x", ArraysKt.getOrNull(r211, 0));
        r102.putOpt("source_loc_y", ArraysKt.getOrNull(r211, 1));
        r102.putOpt("destination_loc_x", ArraysKt.getOrNull(r212, 0));
        r102.putOpt("destination_loc_y", ArraysKt.getOrNull(r212, 1));
        r102.put("delay", r215);
        r102.putOpt("anim_layout_width", r311);
        r102.putOpt("anim_layout_height", r312);
        if (r313 == false) goto L12;
        JSONArray r103 = new JSONArray();
        r103.put(0, 1.0d);
        r103.put(1, 0.3d);
        Unit r104 = Unit.INSTANCE;
        r102.put("scale_x", r103);
        JSONArray r105 = new JSONArray();
        r105.put(0, 1.0d);
        r105.put(1, 0.3d);
        r102.put("scale_y", r105);
    L12:
        Unit r106 = Unit.INSTANCE;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(r101, r210, new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", "live_list_show_add_cart_motion", r102), r310, null, new b(r315), 8);
        return true;
    L15:
        if (r213 == null) goto L21;
        if (r214 == null) goto L21;
        int r107 = ECSdk.f48106a;
        IECCommonService r110 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r110 == null) goto L20;
        r110.addCartMotion(r213, r214, r215, null, Boolean.TRUE, r310, r311, r312, r314, r315);
    L20:
        return true;
    L21:
        return false;
    }
}
