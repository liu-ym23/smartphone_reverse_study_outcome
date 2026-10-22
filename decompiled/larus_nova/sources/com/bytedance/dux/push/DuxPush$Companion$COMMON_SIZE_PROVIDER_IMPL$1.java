package com.bytedance.dux.push;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import em4.g;
import hm4.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lhm4/d;", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE, "(Landroid/content/Context;Lhm4/d;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class DuxPush$Companion$COMMON_SIZE_PROVIDER_IMPL$1 extends Lambda implements Function2<Context, d, Integer> {
    public static final DuxPush$Companion$COMMON_SIZE_PROVIDER_IMPL$1 INSTANCE = null;

    static {
        INSTANCE = new DuxPush$Companion$COMMON_SIZE_PROVIDER_IMPL$1();
    }

    public DuxPush$Companion$COMMON_SIZE_PROVIDER_IMPL$1() {
        super(2);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_dux_push_DuxPush$Companion$COMMON_SIZE_PROVIDER_IMPL$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "<anonymous parameter 1>");
        return Integer.valueOf(Math.min(g.e(r100), MathKt.roundToInt(TypedValue.applyDimension(1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, INVOKEVIRTUAL_com_bytedance_dux_push_DuxPush$Companion$COMMON_SIZE_PROVIDER_IMPL$1_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem())))));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Context r100, d r101) {
        return invoke2(r100, r101);
    }
}
