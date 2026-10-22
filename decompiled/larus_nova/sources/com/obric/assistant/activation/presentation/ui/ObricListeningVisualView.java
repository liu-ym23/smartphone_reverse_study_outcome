package com.obric.assistant.activation.presentation.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kba.c;
import kba.e;
import kba.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricListeningVisualView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f385560i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f385561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f385562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f385563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f385564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObricListeningVisualMode f385565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f385566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f385567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f385568h;

    public static final class a {
        @JvmStatic
        public static int a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Resources r101 = r100.getResources();
            return (int) ((WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * 250.0f) + 0.5f);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f385569a = null;

        static {
            int[] r100 = new int[ObricListeningVisualMode.values().length];
            r100[ObricListeningVisualMode.HIDDEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ObricListeningVisualMode.CLICK_TALK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ObricListeningVisualMode.PRESS_TALK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ObricListeningVisualMode.LOADING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f385569a = r100;
        }
    }

    static {
    }

    public /* synthetic */ ObricListeningVisualView() {
        throw null;
    }

    private final c getFakeAmplitudePlayer() {
        return (c) this.f385568h.getValue();
    }

    public final void b() {
        if (this.f385567g == false) goto L6;
        return;
    L6:
        if (this.f385561a == false) goto L10;
        c r100 = getFakeAmplitudePlayer();
        if (r100 == null) goto L10;
        r100.f502293e = true;
        r100.a("real_amplitude_confirmed");
    L10:
        this.f385567g = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        e(ObricListeningViewState.f385269d);
        super.onDetachedFromWindow();
    }

    public ObricListeningVisualView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, false);
    }

    public static boolean d(ObricListeningVisualMode r100) {
        if (r100 != ObricListeningVisualMode.CLICK_TALK) goto L5;
    L8:
        return true;
    L5:
        if (r100 == ObricListeningVisualMode.PRESS_TALK) goto L8;
        return false;
    }

    public final void a(float r100) {
        if (this.f385566f == true) goto L5;
        return;
    L5:
        Float r101 = Float.valueOf(r100);
        float r102 = r101.floatValue();
        boolean r103 = false;
        if (Float.isInfinite(r102) == false) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == true) goto L14;
        r101 = null;
    L14:
        float r105 = 0.0f;
        if (r101 == null) goto L17;
        r105 = RangesKt.coerceIn(r101.floatValue(), 0.0f, 1.0f);
    L17:
        this.f385562b.setAmplitude(r105);
        ObricListeningVisualMode r106 = this.f385565e;
        if (r106 != null) goto L20;
    L22:
        if (r103 == false) goto L25;
        this.f385563c.setAmplitude(r105);
        return;
    L25:
        return;
    L20:
        if (d(r106) != true) goto L22;
        r103 = true;
        goto L22
    L8:
        if (Float.isNaN(r102) == true) goto L10;
        r104 = true;
        goto L11
    }

    public final int c(float r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void e(ObricListeningViewState r110) {
        Intrinsics.checkNotNullParameter(r110, "state");
        if (this.f385567g == true) goto L7;
        c r100 = getFakeAmplitudePlayer();
        if (r100 == null) goto L7;
        r100.f502292d = r110.b();
        r100.b("view_rendered");
    L7:
        boolean r101 = false;
        if (r110.b() == true) goto L11;
        this.f385566f = false;
        e r111 = this.f385562b;
        r111.f502306e = false;
        r111.f502307f = 0.0f;
        r111.f502308g = 0.0f;
        r111.f502309h = 0.0f;
        r111.f502310i = 0.0f;
        r111.f502311j = 0.0f;
        r111.f502312k = 0;
        r111.f502313l = 0;
        r111.f502314m = 0;
        r111.f502315n = 0;
        r111.invalidate();
        this.f385563c.e();
        this.f385564d.setVisibility(4);
        this.f385563c.setVisibility(4);
        this.f385565e = null;
        setVisibility(4);
        return;
    L11:
        setVisibility(0);
        ObricListeningVisualMode r102 = r110.f385270a;
        ObricListeningVisualMode r103 = this.f385565e;
        if (r102 == r103) goto L39;
        if (r103 != null) goto L16;
    L18:
        boolean r104 = false;
    L19:
        this.f385565e = r102;
        boolean r105 = d(r102);
        int r106 = b.f385569a[r102.ordinal()];
        if (r106 != 1) goto L22;
        this.f385564d.setVisibility(4);
        this.f385563c.setVisibility(4);
    L33:
        if (this.f385566f == false) goto L39;
        if (r105 == false) goto L37;
        this.f385563c.b(!r104);
        goto L39
    L37:
        this.f385563c.e();
        goto L39
    L22:
        if (r106 != 2) goto L24;
        this.f385564d.setText(R.string.obric_click_to_speak_note);
        this.f385564d.setVisibility(0);
        this.f385563c.setVisibility(0);
        goto L33
    L24:
        if (r106 == 3) goto L29;
        if (r106 != 4) goto L28;
        this.f385564d.setVisibility(4);
        this.f385563c.setVisibility(4);
        goto L33
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        this.f385564d.setText(R.string.obric_hold_to_speak_note);
        this.f385564d.setVisibility(0);
        this.f385563c.setVisibility(0);
        goto L33
    L16:
        if (d(r103) != true) goto L18;
        r104 = true;
    L39:
        if (this.f385566f == true) goto L52;
        this.f385566f = true;
        e r107 = this.f385562b;
        if (r107.f502306e == true) goto L45;
        r107.f502306e = true;
        r107.f502307f = 0.0f;
        r107.f502308g = 0.0f;
        r107.f502309h = 0.0f;
        r107.f502310i = 0.0f;
        r107.f502311j = 0.0f;
        r107.f502312k = 0;
        r107.f502313l = 0;
        r107.f502314m = 0;
        r107.f502315n = 0;
        r107.postInvalidateOnAnimation();
    L45:
        ObricListeningVisualMode r108 = this.f385565e;
        if (r108 != null) goto L48;
    L50:
        if (r101 == false) goto L52;
        this.f385563c.b(true);
        goto L52
    L48:
        if (d(r108) != true) goto L50;
        r101 = true;
    L52:
        a(r110.f385272c);
    }

    public ObricListeningVisualView(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f385561a = r101;
        e r102 = new e(r100);
        this.f385562b = r102;
        o r103 = new o(r100);
        this.f385563c = r103;
        TextView r104 = new TextView(r100);
        r104.setGravity(17);
        r104.setTextColor(-1291845633);
        r104.setTextSize(1, 14.0f);
        r104.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 500, false));
        r104.setVisibility(4);
        this.f385564d = r104;
        this.f385568h = LazyKt.lazy(LazyThreadSafetyMode.NONE, new com.obric.assistant.activation.presentation.ui.a(this));
        setVisibility(4);
        setImportantForAccessibility(2);
        setClipChildren(false);
        setClipToPadding(false);
        addView(r102, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(c(210.0f), c(24.0f), 81);
        r105.bottomMargin = c(48.0f);
        Unit r106 = Unit.INSTANCE;
        addView(r103, r105);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2, 81);
        r107.bottomMargin = c(91.0f);
        addView(r104, r107);
    }
}
