package com.ss.android.lark.officesdk.minutes.ui.record.bubble;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f435826a = 0;

    static {
    }

    public c() {
    }

    public static final void c(Ref.BooleanRef r100, Ref.ObjectRef<View.OnAttachStateChangeListener> r101, View r102, String r103) {
        if (r100.element == false) goto L6;
        int r104 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.OVERLAY, "showBubble", "lifecycle listener already removed, reason=".concat(r103), null, 8);
        return;
    L6:
        r100.element = true;
        int r105 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.OVERLAY, "showBubble", "remove lifecycle listener reason=".concat(r103), null, 8);
        View.OnAttachStateChangeListener r106 = r101.element;
        if (r106 == null) goto L9;
        r102.removeOnAttachStateChangeListener(r106);
    L9:
        r101.element = null;
    }

    public static final void a(Ref.BooleanRef r100, Ref.BooleanRef r101, Ref.ObjectRef r102, Ref.BooleanRef r103, Ref.ObjectRef r110, View r111, String r112) {
        if (r100.element == false) goto L5;
        int r104 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.OVERLAY, "showBubble", "hide ignored, already hidden, reason=".concat(r112), null, 8);
        return;
    L5:
        int r105 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.OVERLAY, "showBubble", "hide bubble reason=" + r112 + ", showStarted=" + r101.element, null, 8);
        r100.element = true;
        c(r103, r110, r111, r112);
        qub.a r106 = (qub.a) r102.element;
        if (r106 == null) goto L8;
        r106.hide();
    L8:
        r102.element = null;
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [T, qub.a] */
    public static final boolean d(Ref.BooleanRef r100, Ref.BooleanRef r101, Ref.ObjectRef<qub.a> r102, qub.b r103, Activity r110, rub.a r111, Ref.BooleanRef r112, Ref.ObjectRef<View.OnAttachStateChangeListener> r113, View r114) {
        if (r100.element == false) goto L5;
    L13:
        int r104 = bwb.b.f21271a;
        MmUiLogScene r105 = MmUiLogScene.OVERLAY;
        StringBuilder r115 = new StringBuilder("skip show, hidden=");
        r115.append(r100.element);
        r115.append(", showStarted=");
        r115.append(r101.element);
        r115.append(", isShowing=");
        qub.a r106 = r102.element;
        if (r106 == null) goto L16;
        Boolean r107 = Boolean.valueOf(r106.isShowing());
    L17:
        r115.append(r107);
        bwb.b.b(r105, "showBubble", r115.toString(), null, 8);
        qub.a r108 = r102.element;
        if (r108 != null) goto L20;
        return false;
    L20:
        if (r108.isShowing() != true) goto L24;
        return true;
    L24:
        return false;
    L16:
        r107 = null;
        goto L17
    L5:
        if (r101.element == true) goto L13;
        r101.element = true;
        int r109 = bwb.b.f21271a;
        MmUiLogScene r116 = MmUiLogScene.OVERLAY;
        bwb.b.g(r116, "showBubble", "start provider show, provider=".concat(r103.getClass().getName()), null, 8);
        ?? r117 = r103.L(r110, r111);
        r102.element = r117;
        if (r117 != qub.a.C7394a.f534851a) goto L11;
        bwb.b.d(r116, "showBubble", "provider returned empty handle", null);
        r102.element = null;
        c(r112, r113, r114, "empty");
        return false;
    L11:
        bwb.b.g(r116, "showBubble", "provider show success", null, 8);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, android.view.View$OnAttachStateChangeListener, com.ss.android.lark.officesdk.minutes.ui.record.bubble.a] */
    public static qub.a b(Context r210, final View r211, String r212, MmBubbleDirection r310, boolean r311, boolean r312, long r313, boolean r314, Integer r315, Integer r316, Point r317, Function0 r318, qub.b r410, MmRecordingUILaunchMode r411, Function0 r412, Integer r413, int r414) {
        if ((r414 & 16) == 0) goto L5;
        MmBubbleDirection r100 = MmBubbleDirection.TOP;
    L7:
        if ((r414 & 32) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r414 & 64) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r414 & 128) == 0) goto L17;
        long r103 = 6000;
    L19:
        if ((r414 & 256) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r414 & 512) == 0) goto L25;
        Integer r110 = null;
    L27:
        if ((r414 & 1024) == 0) goto L29;
        Integer r111 = null;
    L31:
        if ((r414 & 2048) == 0) goto L33;
        Point r112 = null;
    L35:
        if ((r414 & 4096) == 0) goto L37;
        Function0 r113 = null;
    L39:
        if ((r414 & 8192) == 0) goto L41;
        qub.b r114 = null;
    L43:
        if ((32768 & r414) == 0) goto L45;
        Function0 r105 = null;
    L47:
        if ((r414 & 65536) == 0) goto L49;
        Integer r115 = null;
    L50:
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "anchorView");
        Intrinsics.checkNotNullParameter(r100, "direction");
        Intrinsics.checkNotNullParameter(r411, "uiLaunchMode");
        int r106 = bwb.b.f21271a;
        bwb.b.b(MmUiLogScene.OVERLAY, "showBubble", "title=" + r212 + ", detail=null, uiLaunchMode=" + r411 + ", anchorAttached=" + r211.isAttachedToWindow(), null, 8);
        Context r107 = r210;
    L52:
        if ((r107 instanceof ContextWrapper) == false) goto L57;
        if ((r107 instanceof Activity) == true) goto L55;
        r107 = ((ContextWrapper) r107).getBaseContext();
        goto L52
    L55:
        Activity r213 = (Activity) r107;
    L58:
        if (r213 != null) goto L60;
        int r108 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.OVERLAY, "showBubble", "activity missing, context=".concat(r210.getClass().getName()), null);
        return qub.a.C7394a.f534851a;
    L60:
        final Ref.ObjectRef r109 = new Ref.ObjectRef();
        final Ref.BooleanRef r116 = new Ref.BooleanRef();
        final Ref.BooleanRef r214 = new Ref.BooleanRef();
        Ref.BooleanRef r215 = new Ref.BooleanRef();
        final Ref.ObjectRef r216 = new Ref.ObjectRef();
        final Function0 r319 = r105;
        rub.a r217 = new rub.a(r211, r212, null, r100, r101, r102, r103, r104, r110, r111, r115, r112, r113, new MmRecordingBubbleFactory$showBubble$config$1(r214, r216, r319, r116, r109, r211), r411);
        if (r114 != null) goto L63;
        e.f436896a.getClass();
        qub.b r117 = e.b(r411).getBubble();
    L64:
        ?? r118 = new a(r214, r215, r216, r117, r213, r217, r116, r109, r211);
        r109.element = r118;
        if (r116.element == true) goto L67;
        r211.addOnAttachStateChangeListener(r118);
        int r119 = bwb.b.f21271a;
        String r120 = "showBubble";
        int r121 = 8;
        String r122 = null;
        bwb.b.b(MmUiLogScene.OVERLAY, r120, "lifecycle listener added", null, 8);
    L69:
        if (r211.isAttachedToWindow() == true) goto L71;
        int r123 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.OVERLAY, r120, "anchor not attached, wait for attach", r122, r121);
    L75:
        return new b(r214, r215, r216, r116, r109, r211);
    L71:
        if (d(r214, r215, r216, r117, r213, r217, r116, r109, r211) == true) goto L75;
        return qub.a.C7394a.f534851a;
    L67:
        r120 = "showBubble";
        r121 = 8;
        r122 = null;
        goto L69
    L63:
        r117 = r114;
        goto L64
    L57:
        r213 = null;
        goto L58
    L49:
        r115 = r413;
        goto L50
    L45:
        r105 = r412;
        goto L47
    L41:
        r114 = r410;
        goto L43
    L37:
        r113 = r318;
        goto L39
    L33:
        r112 = r317;
        goto L35
    L29:
        r111 = r316;
        goto L31
    L25:
        r110 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
