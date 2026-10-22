package com.bytedance.dux.push;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import hm4.b;
import hm4.d;
import im4.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lhm4/d;", "breakPointUpdate", "", AbsMethodDelegate.TAG_INVOKE, "(Landroid/content/Context;Lhm4/d;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class DuxPush$Companion$PAD_SIZE_PROVIDER_IMPL$1 extends Lambda implements Function2<Context, d, Integer> {
    public static final DuxPush$Companion$PAD_SIZE_PROVIDER_IMPL$1 INSTANCE = null;

    static {
        INSTANCE = new DuxPush$Companion$PAD_SIZE_PROVIDER_IMPL$1();
    }

    public DuxPush$Companion$PAD_SIZE_PROVIDER_IMPL$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "breakPointUpdate");
        int r102 = a.f490534a;
        Intrinsics.checkNotNullParameter(r101, "breakPointUpdate");
        b r103 = r101.f485934b;
        jm4.a.f499636a.getClass();
        if (Intrinsics.areEqual(r103, jm4.a.C6460a.f499638b) == false) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L15;
        int r107 = MathKt.roundToInt(TypedValue.applyDimension(1, r101.f485936d.f485914a, a.a(Resources.getSystem())));
    L28:
        return Integer.valueOf(r107);
    L15:
        if (Intrinsics.areEqual(r103, b.f485921f) == false) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L21;
        r107 = MathKt.roundToInt(TypedValue.applyDimension(1, 460, a.a(Resources.getSystem())));
        goto L28
    L21:
        if (Intrinsics.areEqual(r103, b.f485923h) == false) goto L23;
        boolean r109 = true;
    L24:
        if (r109 == false) goto L26;
        r107 = MathKt.roundToInt(TypedValue.applyDimension(1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, a.a(Resources.getSystem())));
        goto L28
    L26:
        r107 = MathKt.roundToInt(TypedValue.applyDimension(1, 662, a.a(Resources.getSystem())));
        goto L28
    L23:
        r109 = Intrinsics.areEqual(r103, b.f485924i);
        goto L24
    L17:
        r108 = Intrinsics.areEqual(r103, b.f485922g);
        goto L18
    L11:
        r106 = Intrinsics.areEqual(r103, b.f485920e);
        goto L12
    L8:
        r105 = Intrinsics.areEqual(r103, b.f485919d);
        goto L9
    L5:
        r104 = Intrinsics.areEqual(r103, b.f485918c);
        goto L6
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Context r100, d r101) {
        return invoke2(r100, r101);
    }
}
