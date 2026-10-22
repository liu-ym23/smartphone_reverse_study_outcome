package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.base.view.VideoViewHolderRootView;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.LongPressSpeedPresenterConfig;
import com.bytedance.awemeopen.apps.framework.feed.pinch.vm.FeedSpeedControlViewModel;
import com.bytedance.awemeopen.apps.framework.feed.ui.view.LongPressSpeedGuideView;
import com.bytedance.awemeopen.apps.framework.feed.ui.view.LongPressSpeedView;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class FeedLongPressFastSpeedPresenter extends g04.a<jz3.a> implements r0.a {
    public final d A;
    public long B;
    public float C;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public final LongPressSpeedPresenterConfig f;
    public LongPressSpeedView g;
    public LongPressSpeedGuideView h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public boolean q;
    public boolean r;
    public r14.c s;
    public jz3.a t;
    public boolean u;
    public FeedSpeedControlViewModel v;
    public final Lazy w;
    public final Lazy x;
    public final b y;
    public final c z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r1) {
    }

    @Override // g04.a
    public final void h() {
        this.i = 1.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = -1.0f;
        this.q = false;
        this.r = false;
        c04.i.a(this.y);
        c04.i.a(this.z);
        n();
    }

    @Override // g04.a
    public final void i() {
        if (this.r == false) goto L16;
        View r0 = this.a;
        if ((r0 instanceof VideoViewHolderRootView) == false) goto L8;
        VideoViewHolderRootView r1 = (VideoViewHolderRootView) r0;
    L9:
        if (r1 == null) goto L17;
        LongPressSpeedGuideView r2 = this.h;
        if (r2 == null) goto L15;
        r2.setVisibility(8);
        r1.removeView(r2);
        return;
    L15:
        return;
    L17:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void m() {
        if (this.u == false) goto L5;
        return;
    L5:
        this.u = true;
        r14.c r1 = this.s;
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L21;
        r14.c r3 = this.s;
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == true) goto L21;
        boolean r5 = false;
    L22:
        Object r6 = this.e.c.getEnterPinchMode().getValue();
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r6, r7) == true) goto L51;
        View r8 = this.a;
        if ((r8 instanceof VideoViewHolderRootView) == false) goto L27;
        VideoViewHolderRootView r9 = (VideoViewHolderRootView) r8;
    L28:
        if (r9 == null) goto L51;
        LongPressSpeedView r10 = this.g;
        if (r10 == null) goto L34;
        r10.setVisibility(8);
    L34:
        LongPressSpeedView r11 = (LongPressSpeedView) r9.findViewWithTag("familiar_long_press_speed_view");
        this.g = r11;
        if (r11 != null) goto L37;
        LongPressSpeedView r12 = new LongPressSpeedView(getContext(), null, 6, 0);
        this.g = r12;
        r12.setTag("familiar_long_press_speed_view");
    L37:
        LongPressSpeedView r13 = this.g;
        if (r13 == null) goto L40;
        ViewParent r14 = r13.getParent();
    L41:
        if (r14 != null) goto L47;
        ViewGroup.LayoutParams r15 = new ViewGroup.LayoutParams(-1, -1);
        LongPressSpeedView r16 = this.g;
        if (r16 == null) goto L46;
        r16.setLayoutParams(r15);
    L46:
        r9.addView(this.g);
    L47:
        LongPressSpeedView r17 = this.g;
        if (r17 == null) goto L51;
        r17.setVisibility(0);
        goto L51
    L40:
        r14 = null;
        goto L41
    L27:
        r9 = null;
    L51:
        if (r5 == false) goto L59;
        LongPressSpeedView r18 = this.g;
        if (r18 == null) goto L55;
        r18.e(this.s);
    L55:
        LongPressSpeedView r19 = this.g;
        if (r19 == null) goto L117;
        r19.performHapticFeedback(0, 1);
        return;
    L117:
        return;
    L59:
        Context r20 = getContext();
        if ((r20 instanceof Activity) == false) goto L62;
        Activity r21 = (Activity) r20;
    L63:
        if (r21 == null) goto L67;
        RtlViewPager r22 = (RtlViewPager) r21.findViewById(2131363039);
        if (r22 == null) goto L67;
        r22.setScrollable(false);
    L67:
        System.currentTimeMillis();
        if (this.r == false) goto L78;
        AosEventReporter r23 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r24 = this.e;
        jz3.a r25 = this.t;
        if (r25 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r25 = null;
    L72:
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r25, "data");
        String r26 = r24.c.sceneId();
        d14.a r27 = b14.a.a;
        t24.a r28 = b14.a.a(t24.a.class);
        User r29 = r25.a.f();
        if (r29 == null) goto L76;
        String r30 = r29.u();
        if (r30 == null) goto L76;
    L77:
        r28.C1(r26, r30);
        this.r = false;
    L76:
        r30 = "";
    L78:
        c04.d.b.edit().putBoolean("trigger_long_press_fast_speed", true).apply();
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r31 = this.e.c;
        if (r31.playerIsPlaying() == true) goto L81;
        r31.playPlayer();
    L81:
        VideoFeedPlayerPresenter r32 = (VideoFeedPlayerPresenter) this.w.getValue();
        if (r32 == null) goto L84;
        float r33 = r32.p();
    L85:
        this.i = r33;
        VideoFeedPlayerPresenter r34 = (VideoFeedPlayerPresenter) this.w.getValue();
        if (r34 == null) goto L88;
        int r35 = VideoFeedPlayerPresenter.M;
        r34.x(2.0f, false);
    L88:
        LongPressSpeedView r36 = this.g;
        if (r36 == null) goto L91;
        r36.e(this.s);
    L91:
        LongPressSpeedView r37 = this.g;
        if (r37 == null) goto L94;
        r37.performHapticFeedback(0, 1);
    L94:
        FeedSpeedControlViewModel r38 = this.v;
        if (r38 == null) goto L101;
        r14.c r39 = this.s;
        if (r39 == null) goto L99;
        String r40 = r39.c();
    L100:
        r38.setFastSpeedMode(r40, true);
        goto L101
    L99:
        r40 = null;
    L101:
        AosEventReporter r0 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r41 = this.e;
        jz3.a r42 = this.t;
        if (r42 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        jz3.a r43 = null;
    L105:
        r0.getClass();
        AosEventReporter.k(r41, r43, "slide_long_press", 2.0f, true, "", "");
        if (Intrinsics.areEqual(this.e.c.getEnterPinchMode().getValue(), r7) == true) goto L111;
        Function0<Unit> r44 = this.f.b;
        if (r44 == null) goto L110;
        r44.invoke();
    L110:
        this.e.c.getEnterCleanMode().setValue(r7);
    L115:
        this.C = 2.0f;
        this.B = System.currentTimeMillis();
        return;
    L111:
        LongPressSpeedView r45 = this.g;
        if (r45 == null) goto L115;
        r45.setVisibility(8);
        goto L115
    L104:
        r43 = r42;
        goto L105
    L84:
        r33 = 1.0f;
        goto L85
    L62:
        r21 = null;
        goto L63
    L15:
        if (r3.i() != 2) goto L17;
        r4 = true;
    L21:
        r5 = true;
        goto L22
    L8:
        if (r1.i() != 68) goto L10;
        r2 = true;
        goto L11
    }

    public final void n() {
        if (this.u == true) goto L5;
        return;
    L5:
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L8;
        Activity r1 = (Activity) r0;
    L9:
        boolean r2 = true;
        if (r1 == null) goto L14;
        RtlViewPager r3 = (RtlViewPager) r1.findViewById(2131363039);
        if (r3 == null) goto L14;
        r3.setScrollable(true);
    L14:
        this.u = false;
        LongPressSpeedView r4 = this.g;
        if (r4 == null) goto L18;
        r4.setVisibility(8);
    L18:
        LongPressSpeedView r5 = this.g;
        if (r5 == null) goto L21;
        r5.l = false;
        r5.d();
    L21:
        float r6 = this.i;
        if (r6 > 0.0f) goto L24;
    L26:
        r6 = 1.0f;
    L27:
        VideoFeedPlayerPresenter r7 = (VideoFeedPlayerPresenter) this.w.getValue();
        if (r7 == null) goto L30;
        int r8 = VideoFeedPlayerPresenter.M;
        r7.x(r6, false);
    L30:
        FeedSpeedControlViewModel r9 = this.v;
        if (r9 == null) goto L38;
        r14.c r10 = this.s;
        if (r10 == null) goto L35;
        String r11 = r10.c();
    L36:
        r9.setFastSpeedMode(r11, false);
        goto L38
    L35:
        r11 = null;
    L38:
        if (Intrinsics.areEqual(this.e.c.getEnterPinchMode().getValue(), Boolean.TRUE) == true) goto L44;
        Function0<Unit> r12 = this.f.c;
        if (r12 == null) goto L42;
        r12.invoke();
    L42:
        this.e.c.getEnterCleanMode().setValue(Boolean.FALSE);
    L44:
        if (this.C == (-1.0f)) goto L47;
        r2 = false;
    L47:
        if (r2 == true) goto L55;
        long r13 = System.currentTimeMillis() - this.B;
        AosEventReporter r14 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r15 = this.e;
        jz3.a r16 = this.t;
        if (r16 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        jz3.a r17 = null;
    L53:
        float r18 = this.C;
        r14.getClass();
        AosEventReporter.Q(r15, r17, "slide_long_press", r18, r13);
        return;
    L52:
        r17 = r16;
        goto L53
    L55:
        return;
    L24:
        if (r6 > 2.0f) goto L26;
    L8:
        r1 = null;
        goto L9
    }

    public final void q() {
        if (((Boolean) this.x.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.q == false) goto L8;
        return;
    L8:
        boolean r0 = true;
        this.q = true;
        SharedPreferences r1 = c04.d.b;
        boolean r2 = r1.getBoolean("long_press_has_show_guide", false);
        boolean r3 = r1.getBoolean("trigger_long_press_fast_speed", false);
        if (r2 == true) goto L12;
        if (r3 == true) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        return;
    L16:
        if (this.e.c.playerIsPlaying() == true) goto L18;
        return;
    L18:
        jz3.a r5 = this.t;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r5 = null;
    L22:
        if (r5.h == false) goto L24;
        return;
    L24:
        Activity r6 = this.e.getActivity();
        if (r6 != null) goto L27;
    L29:
        r0 = false;
    L30:
        if (r0 == true) goto L35;
        c r7 = this.z;
        c04.i.b();
        Handler r8 = c04.i.b;
        if (r8 == null) goto L36;
        r8.postDelayed(r7, 60000);
        return;
    L36:
        return;
    L35:
        return;
    L27:
        if (r6.getRequestedOrientation() != 0) goto L29;
    L12:
        r4 = false;
        goto L13
    }

    @Override // g04.a
    public final void f(jz3.a r4) {
        jz3.a r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "data");
        this.t = r5;
        this.s = r5.a;
        Context r6 = getContext();
        if (r6 == null) goto L5;
        this.p = ViewConfiguration.get(r6).getScaledTouchSlop();
    L5:
        View r7 = this.a;
        LifecycleOwner r1 = null;
        if ((r7 instanceof VideoViewHolderRootView) == false) goto L8;
        VideoViewHolderRootView r8 = (VideoViewHolderRootView) r7;
    L9:
        if (r8 == null) goto L12;
        r8.setLongPressFastSpeedListener(this.A);
    L12:
        FeedSpeedControlViewModel.a r9 = FeedSpeedControlViewModel.Companion;
        Activity r0 = this.e.e.getActivity();
        if ((r0 instanceof LifecycleOwner) == false) goto L15;
        r1 = (LifecycleOwner) r0;
    L15:
        if (r1 != null) goto L17;
        r1 = this.e.e.d;
    L17:
        r9.getClass();
        this.v = FeedSpeedControlViewModel.a.a(r1, "");
        return;
    L8:
        r8 = null;
        goto L9
    }

    public final boolean o(int r3) {
        View r0 = this.a;
        if (r0 == null) goto L5;
        View r4 = r0.findViewById(r3);
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        Rect r1 = new Rect();
        r4.getGlobalVisibleRect(r1);
        return r1.contains((int) this.l, (int) this.m);
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.b] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.c] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.d] */
    public FeedLongPressFastSpeedPresenter(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2, LongPressSpeedPresenterConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r3, "config");
        super(r2.a);
        this.e = r2;
        this.f = r3;
        this.i = 1.0f;
        this.p = -1.0f;
        this.w = LazyKt.lazy(new FeedLongPressFastSpeedPresenter$videoFeedPlayerPresenter$2(this));
        this.x = LazyKt.lazy(FeedLongPressFastSpeedPresenter$isEnableLongPress$2.INSTANCE);
        this.y = new b(this);
        this.z = new c(this);
        this.A = new d(this);
        this.C = -1.0f;
    }

    public final boolean p(float r8, float r9) {
        int r0 = c04.g.a;
        r14.c r1 = this.s;
        JSONObject r2 = AoSettings.a("ao_feed_long_press_config");
        if (r2 == null) goto L5;
        boolean r3 = r2.optBoolean("enable_side_long_press", true);
    L7:
        if (r3 == false) goto L22;
        if (r1 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L22;
        if (r1 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == true) goto L22;
        boolean r6 = true;
    L24:
        if (r6 == false) goto L54;
        int r7 = c04.c.a;
        Context r10 = getContext();
        if (r10 != null) goto L29;
    L49:
        boolean r11 = false;
    L50:
        if (r11 == false) goto L54;
        if (((Boolean) this.f.a.invoke()).booleanValue() == false) goto L54;
        return true;
    L29:
        if (r10.getResources().getConfiguration().orientation != 2) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == false) goto L38;
        int r13 = Math.min(com.bytedance.awemeopen.apps.framework.utils.d0.c(r10), com.bytedance.awemeopen.apps.framework.utils.d0.d(r10));
        float r14 = 60;
        Resources r15 = Resources.getSystem();
        int r16 = MathKt.roundToInt(TypedValue.applyDimension(1, r14, WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics())));
        Resources r17 = Resources.getSystem();
        int r18 = r13 - MathKt.roundToInt(TypedValue.applyDimension(1, r14, WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics())));
        if (r9 <= r16) goto L49;
        if (r9 >= r18) goto L49;
    L48:
        r11 = true;
        goto L50
    L38:
        int r19 = com.bytedance.awemeopen.apps.framework.utils.d0.d(r10);
        float r20 = r19;
        float r21 = 0.12f * r20;
        float r22 = r20 * 0.88f;
        float r23 = (com.bytedance.awemeopen.apps.framework.utils.d0.c(r10) - com.bytedance.awemeopen.apps.framework.utils.d0.b(r10)) - com.bytedance.awemeopen.apps.framework.utils.n0.a(r10, 58.0f);
        if (r21 <= 0.0f) goto L49;
        if (r23 <= 0.0f) goto L49;
        if (r23 <= r9) goto L49;
        if (r8 < r21) goto L48;
        if (r8 <= r22) goto L49;
    L31:
        r12 = false;
    L54:
        return false;
    L18:
        if (r1.Y() != true) goto L20;
        r5 = true;
        goto L21
    L11:
        if (r1.i() != 108) goto L13;
        r4 = true;
    L22:
        r6 = false;
        goto L24
    L5:
        r3 = true;
        goto L7
    }
}
