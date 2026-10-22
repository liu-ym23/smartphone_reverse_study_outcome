package com.ss.android.lark.chat.message.menu.v2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.v2.adapter.GridSpaceItemDecoration;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.MessageActionAdapter;
import com.ss.android.lark.chat.message.menu.v2.emoji.BuiltInEmojiPanelView;
import com.ss.android.lark.chat.message.menu.v2.emoji.BuiltInTopEmojiView;
import com.ss.android.lark.chat.utils.a1;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageActionPanel implements j0 {
    public static final /* synthetic */ int W = 0;
    public MessageActionAdapter A;
    public RecyclerView B;
    public View C;
    public View D;
    public RecyclerView E;
    public MessageActionAdapter F;
    public View G;
    public TextView H;
    public DragPanelLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public UDShadowLayout f415560J;
    public UDShadowLayout K;
    public MessageActionAdapter L;
    public RecyclerView M;
    public View N;
    public final Map<PanelType, com.ss.android.lark.chat.message.menu.v2.a> O;
    public m0 P;
    public boolean Q;
    public Function0<Unit> R;
    public boolean S;
    public n0 T;
    public f U;
    public final Lazy V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f415561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zya.g f415562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends zya.e> f415563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o0 f415564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f415565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f415566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f415567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f415568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f415569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f415570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f415571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f415572l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f415573m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f415574n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f415575o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f415576p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f415577q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f415578r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f415579s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public MessageActionPanelContainerLayout f415580t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f415581u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f415582v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f415583w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public DragPanelLayout f415584x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public UDShadowLayout f415585y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public FrameLayout f415586z;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageActionPanel f415587a;

        public b(MessageActionPanel r100) {
            this.f415587a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            UDShadowLayout r101 = this.f415587a.K;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
            r101 = null;
        L5:
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
            r101.setAlpha(((Float) r102).floatValue());
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageActionPanel f415588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f415589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f415590c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            MessageActionPanel r101 = this.f415588a;
            r101.Q = false;
            r101.R.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f415589b == true) goto L8;
            UDShadowLayout r101 = this.f415588a.K;
            if (r101 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
            r101 = null;
        L7:
            r101.setVisibility(8);
        L8:
            this.f415590c.invoke();
            MessageActionPanel r102 = this.f415588a;
            r102.Q = false;
            r102.R.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            MessageActionPanel r101 = this.f415588a;
            r101.Q = true;
            if (this.f415589b == false) goto L9;
            UDShadowLayout r102 = r101.K;
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
            r102 = null;
        L7:
            r102.setVisibility(0);
            return;
        }

        public c(MessageActionPanel r100, boolean r101, Function0<Unit> r102) {
            this.f415588a = r100;
            this.f415589b = r101;
            this.f415590c = r102;
        }
    }

    static {
    }

    public final void j() {
        if (this.S == true) goto L6;
        Log.w("MessageActionPanel", "dismissImmediately: wrong state, isAddedAndroidContent=false, method return");
        return;
    L6:
        k(new MessageActionPanel$dismissImmediately$1(this));
    }

    public final int l() {
        return ((Number) this.f415570j.getValue()).intValue();
    }

    public final int m() {
        return ((Number) this.f415566f.getValue()).intValue();
    }

    public final boolean n() {
        if (this.P.f415763d != PanelActionType.PARTIAL_ACTION) goto L5;
        return true;
    L5:
        return false;
    }

    public final Activity getContext() {
        return this.f415561a;
    }

    public static final void g(MessageActionPanel r100) {
        int r101 = View.MeasureSpec.makeMeasureSpec(r100.m(), 1073741824);
        int r102 = View.MeasureSpec.makeMeasureSpec((int) r100.f415569i, Integer.MIN_VALUE);
        DragPanelLayout r103 = r100.f415584x;
        UDShadowLayout r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanel");
        r103 = null;
    L5:
        r103.measure(r101, r102);
        DragPanelLayout r105 = r100.f415584x;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanel");
        r105 = null;
    L8:
        int r106 = r105.getMeasuredHeight();
        com.ss.android.lark.chat.message.menu.v2.a r107 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) r100.O).get(PanelType.ACTION);
        if (r107 == null) goto L11;
        r107.f415669c = Math.min(r106, r100.f415568h);
    L11:
        DragPanelLayout r108 = r100.f415584x;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanel");
        r108 = null;
    L14:
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L23;
        r109.height = (int) r100.f415569i;
        r108.setLayoutParams(r109);
        UDShadowLayout r110 = r100.f415585y;
        if (r110 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanelShadow");
    L20:
        q(r104);
        return;
    L19:
        r104 = r110;
        goto L20
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static void q(View r100) {
        r100.measure(0, 0);
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L7;
        r101.height = r100.getMeasuredHeight();
        r100.setLayoutParams(r101);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void a(final PanelType r110) {
        Intrinsics.checkNotNullParameter(r110, RemoteMessageConst.TO);
        Log.i("MessageActionPanel", "switch panel, from =" + this.P.getType().name() + ", to = " + r110.name());
        if (this.P.getType() != r110) goto L5;
        return;
    L5:
        final float r100 = this.P.f415761b;
        if (r110 != PanelType.ACTION) goto L20;
        com.ss.android.lark.chat.message.menu.v2.a r101 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(r110);
        if (r101 == null) goto L18;
        DragPanelLayout r102 = r101.f415667a;
        if (r102 == null) goto L18;
        com.ss.android.lark.chat.message.menu.v2.a r103 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(this.P.getType());
        if (r103 == null) goto L16;
        DragPanelLayout r104 = r103.f415667a;
        if (r104 == null) goto L16;
        boolean r105 = r104.getInterceptChildMove();
    L17:
        r102.setInterceptChildMove(r105);
    L16:
        r105 = true;
    L18:
        final float r111 = r100;
    L36:
        com.ss.android.lark.chat.message.menu.v2.a r106 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(this.P.getType());
        if (r106 == null) goto L53;
        UDShadowLayout r112 = r106.f415668b;
        if (r112 == null) goto L56;
        com.ss.android.lark.chat.message.menu.v2.a r107 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(r110);
        if (r107 == null) goto L54;
        UDShadowLayout r113 = r107.f415668b;
        if (r113 == null) goto L57;
        this.P = m0.a(this.P, r110, r111, false, null, 12);
        Function0<Unit> r108 = new MessageActionPanel$switchPanel$1(this, r110, r100, r111);
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{1000.0f});
        r114.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        r114.setDuration(200);
        r114.addUpdateListener(new j(r112, r113));
        r114.addListener(new k(this, r113, r100, r108, r111, r112));
        r114.start();
        f r109 = this.U;
        if (r109 == null) goto L49;
        r109.d(r100, r111, 200);
    L49:
        n0 r115 = this.T;
        if (r115 == null) goto L55;
        r115.a(this.P.getType(), r110);
        return;
    L55:
        return;
    L57:
        return;
    L54:
        return;
    L56:
        return;
    L53:
        return;
    L20:
        if (r110 == PanelType.EMOJI) goto L22;
    L29:
        com.ss.android.lark.chat.message.menu.v2.a r116 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(r110);
        if (r116 == null) goto L34;
        DragPanelLayout r117 = r116.f415667a;
        if (r117 == null) goto L34;
        r117.setInterceptChildMove(false);
    L34:
        float r118 = this.f415569i;
    L35:
        r111 = r118;
        goto L36
    L22:
        if (r100 > this.f415568h) goto L29;
        com.ss.android.lark.chat.message.menu.v2.a r119 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(r110);
        if (r119 == null) goto L28;
        DragPanelLayout r120 = r119.f415667a;
        if (r120 == null) goto L28;
        r120.setInterceptChildMove(true);
    L28:
        r118 = this.f415568h;
        goto L35
    }

    public final void i(boolean r100) {
        View r101 = this.D;
        View r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsContainer");
        r101 = null;
    L5:
        int r103 = 0;
        if (r100 == false) goto L8;
        int r104 = 0;
    L9:
        r101.setVisibility(r104);
        View r105 = this.C;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("firstLevelActionsContainer");
    L14:
        if ((!r100) == true) goto L17;
        r103 = 8;
    L17:
        r102.setVisibility(r103);
        return;
    L12:
        r102 = r105;
        goto L14
    L8:
        r104 = 8;
        goto L9
    }

    public final void k(final Function0<Unit> r100) {
        if (this.Q == false) goto L5;
        this.R = new MessageActionPanel$doActionAfterAnimation$1(r100, this);
        return;
    L5:
        r100.invoke();
    }

    public final void s(int r100) {
        ViewGroup r101 = this.f415562b.a();
        Integer r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.getHeight());
    L6:
        MessageActionPanelContainerLayout r104 = this.f415580t;
        if (r104 == null) goto L10;
        r102 = Integer.valueOf(r104.getHeight());
    L10:
        if (Intrinsics.areEqual(r103, r102) == false) goto L12;
        return;
    L12:
        Activity r105 = this.f415561a;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        WindowInsetsUtils.c(r105).b(r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void f(MessageActionPanel r100, a1 r101) {
        UDShadowLayout r102 = r100.K;
        UDShadowLayout r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r102 = null;
    L5:
        int r104 = r102.getMeasuredWidth();
        UDShadowLayout r105 = r100.K;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r105 = null;
    L8:
        int r106 = r105.getMeasuredHeight();
        if (r101.f416648e == false) goto L11;
        int r107 = r101.f416649f + ((r101.f416646c + r101.f416647d) / 2);
        int r108 = r104 / 2;
    L12:
        int r109 = r107 - r108;
        if (r109 >= 0) goto L16;
        r109 = r100.l();
    L18:
        int r110 = (r106 - ((Number) r100.f415575o.getValue()).intValue()) - ((Number) r100.f415576p.getValue()).intValue();
        int r111 = r100.f415567g - ((Number) r100.f415571k.getValue()).intValue();
        int r112 = r101.f416645b;
        if ((r112 + r110) >= r111) goto L22;
        int r113 = (r112 + ((Number) r100.f415573m.getValue()).intValue()) - ((Number) r100.f415575o.getValue()).intValue();
    L26:
        UDShadowLayout r114 = r100.K;
        if (r114 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r114 = null;
    L29:
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L44;
        ViewGroup r116 = r100.f415562b.a();
        if (r116 == null) goto L34;
        Integer r117 = Integer.valueOf(r116.getHeight());
    L35:
        MessageActionPanelContainerLayout r118 = r100.f415580t;
        if (r118 == null) goto L38;
        Integer r119 = Integer.valueOf(r118.getHeight());
    L40:
        if (Intrinsics.areEqual(r117, r119) == false) goto L42;
        int r120 = 0;
    L43:
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r115;
        r121.topMargin = r113 - r120;
        r121.setMarginStart(r109);
        goto L44
    L42:
        r120 = DeviceUtils.getStatusHeight(r100.f415561a);
        goto L43
    L38:
        r119 = null;
        goto L40
    L34:
        r117 = null;
    L44:
        UDShadowLayout r122 = r100.K;
        if (r122 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
    L48:
        r103.setLayoutParams(r115);
        return;
    L47:
        r103 = r122;
        goto L48
    L22:
        if ((r101.f416644a - r110) <= ((Number) r100.f415572l.getValue()).intValue()) goto L24;
        int r123 = (r101.f416644a - r106) + ((Number) r100.f415576p.getValue()).intValue();
        int r124 = ((Number) r100.f415574n.getValue()).intValue();
    L25:
        r113 = r123 - r124;
        goto L26
    L24:
        r123 = ((Math.min(r101.f416645b, r111) - r106) + ((Number) r100.f415576p.getValue()).intValue()) - ((Number) r100.f415574n.getValue()).intValue();
        r124 = ((Number) r100.f415573m.getValue()).intValue();
        goto L25
    L16:
        if (r109 <= ((r100.m() - r104) - r100.l())) goto L18;
        r109 = (r100.m() - r104) - r100.l();
        goto L18
    L11:
        r107 = r100.m() / 2;
        r108 = r104 / 2;
        goto L12
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void c(zya.b r100, List<zya.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "parentAction");
        Intrinsics.checkNotNullParameter(r101, "childActions");
        TextView r102 = this.H;
        View r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelTitle");
        r102 = null;
    L5:
        r102.setText(r100.f573990e);
        MessageActionAdapter r104 = this.F;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsAdapter");
        r104 = null;
    L8:
        r104.resetAll(r101);
        i(true);
        View r105 = this.D;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsContainer");
        r105 = null;
    L11:
        q(r105);
        View r106 = this.C;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("firstLevelActionsContainer");
        r106 = null;
    L14:
        View r107 = this.D;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsContainer");
    L18:
        o(r106, r103);
        return;
    L17:
        r103 = r107;
        goto L18
    }

    public final void o(View r100, View r101) {
        float r102 = this.P.f415761b;
        int r103 = r100.getMeasuredHeight();
        int r104 = r101.getMeasuredHeight();
        com.ss.android.lark.chat.message.menu.v2.a r105 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(this.P.getType());
        if (r105 == null) goto L11;
        DragPanelLayout r106 = r105.f415667a;
        if (r106 == null) goto L11;
        if (r104 <= r102) goto L9;
        boolean r107 = true;
    L10:
        r106.setInterceptChildMove(r107);
        goto L11
    L9:
        r107 = false;
    L11:
        float r108 = r104;
        if (r108 <= r102) goto L26;
        float r109 = this.f415569i;
        if (r108 <= r109) goto L16;
        r104 = (int) r109;
    L16:
        if (r104 <= r103) goto L27;
        com.ss.android.lark.chat.message.menu.v2.a r110 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) this.O).get(this.P.getType());
        if (r110 == null) goto L28;
        DragPanelLayout r111 = r110.f415667a;
        if (r111 == null) goto L29;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L25;
        r112.height = r104;
        r111.setLayoutParams(r112);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    public final void u(boolean r100, Function0<Unit> r101) {
        UDShadowLayout r102 = this.K;
        UDShadowLayout r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r102 = null;
    L5:
        Animation r104 = r102.getAnimation();
        if (r104 == null) goto L9;
        r104.cancel();
    L9:
        if (r100 == false) goto L11;
        float r105 = 0.0f;
    L12:
        if (r100 == false) goto L14;
        float r106 = 1.0f;
    L15:
        UDShadowLayout r107 = this.K;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
    L19:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r103, "alpha", new float[]{r105, r106});
        r108.setInterpolator(PathInterpolatorCompat.create(0.66f, 0.0f, 0.34f, 1.0f));
        r108.setDuration(200);
        r108.addUpdateListener(new b(this));
        r108.addListener(new c(this, r100, r101));
        r108.start();
        return;
    L18:
        r103 = r107;
        goto L19
    L14:
        r106 = 0.0f;
        goto L15
    L11:
        r105 = 1.0f;
        goto L12
    }

    public static final void h(MessageActionPanel r100, float r101, com.ss.android.lark.chat.message.menu.v2.a r102) {
        r100.getClass();
        float r103 = r102.f415667a.getHeight();
        float r104 = r102.f415669c;
        float r105 = Math.max(0.0f, (r101 - r104) / (r103 - r104)) * 0.7f;
        int r106 = ((Number) r100.f415583w.getValue()).intValue();
        r100.s(ColorUtils.compositeColors(Color.argb((int) (Color.alpha(r106) * r105), Color.red(r106), Color.green(r106), Color.blue(r106)), ((Number) r100.f415582v.getValue()).intValue()));
        MessageActionPanelContainerLayout r107 = r100.f415580t;
        ColorDrawable r108 = null;
        if (r107 == null) goto L5;
        Drawable r109 = r107.getBackground();
    L7:
        if ((r109 instanceof ColorDrawable) == false) goto L9;
        r108 = (ColorDrawable) r109;
    L9:
        if (r108 == null) goto L13;
        r108.setAlpha((int) (r105 * 256));
        r108.invalidateSelf();
        return;
    L13:
        return;
    L5:
        r109 = null;
        goto L7
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void d(boolean r100, MessageActionType r101, boolean r102) {
        k(new MessageActionPanel$dismiss$1(this));
    }

    public final void r(List<? extends zya.e> r110, RecyclerView r111, final MessageActionAdapter r112) {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r110.iterator();
    L3:
        boolean r102 = true;
        if (r101.hasNext() == false) goto L11;
        Object r103 = r101.next();
        if (((zya.e) r103).a() == 5) goto L9;
        r102 = false;
    L9:
        if (r102 == false) goto L3;
        r100.add(r103);
        goto L3
    L11:
        final int r104 = r100.size();
        if (r104 > 1) goto L15;
        r111.setLayoutManager(new LinearLayoutManager(this.f415561a));
        r112.resetAll(r110);
        return;
    L15:
        GridLayoutManager r105 = new GridLayoutManager(this.f415561a, r104);
        r105.setSpanSizeLookup(new MessageActionPanel$setActionListToRv$1(r112, r104));
        r111.setLayoutManager(r105);
        r111.addItemDecoration(new GridSpaceItemDecoration(r104, this.f415577q, r104));
        int r113 = (((m() - (l() * 2)) - ((r104 - 1) * this.f415577q)) / r104) - (this.f415578r * 2);
        int r106 = a0.f415670a;
        Activity r107 = this.f415561a;
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "data");
        float r108 = UIUtils.sp2px(r107, 12.0f);
        int r109 = UIUtils.getColor(r107, R.color.text_title);
        Iterator r114 = r100.iterator();
    L17:
        if (r114.hasNext() == false) goto L27;
        zya.e r115 = (zya.e) r114.next();
        if ((r115 instanceof zya.b) == false) goto L17;
        TextLayoutBuilder r116 = new TextLayoutBuilder();
        zya.b r117 = (zya.b) r115;
        r116.h(r117.f573990e);
        r116.f(r113);
        r116.j((int) r108);
        r116.i(r109);
        r116.f446131g = true;
        Layout r118 = r116.a();
        if (r118 == null) goto L23;
        int r119 = r118.getLineCount();
    L24:
        if (r119 > 2) goto L25;
        r117.f573997l = new zya.c(12.0f, 16.0f);
        goto L17
    L25:
        r117.f573997l = new zya.c(10.0f, 14.0f);
        goto L17
    L23:
        r119 = 0;
        goto L24
    L27:
        r112.resetAll(r110);
    }

    public static void p(MessageActionPanel r100, View r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        r101.measure(r102, 0);
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        if (r104 == null) goto L14;
        r104.width = r101.getMeasuredWidth();
        r101.setLayoutParams(r104);
        ViewGroup.LayoutParams r105 = r101.getLayoutParams();
        if (r105 == null) goto L12;
        r105.height = r101.getMeasuredHeight();
        r101.setLayoutParams(r105);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public MessageActionPanel(Activity r100, i r101, List r110, o0 r111, boolean r112, d r113) {
        this.f415561a = r100;
        this.f415562b = r101;
        this.f415563c = r110;
        this.f415564d = r111;
        this.f415565e = r113;
        this.f415566f = LazyKt.lazy(new MessageActionPanel$rootWidth$2(this));
        this.f415570j = LazyKt.lazy(MessageActionPanel$normalMargin$2.INSTANCE);
        this.f415571k = LazyKt.lazy(MessageActionPanel$partialSelectMaxBottomOffset$2.INSTANCE);
        this.f415572l = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MessageActionPanel$partialSelectMaxTopOffset$2(this));
        this.f415573m = LazyKt.lazy(MessageActionPanel$partialSelectBottomOffset$2.INSTANCE);
        this.f415574n = LazyKt.lazy(MessageActionPanel$partialSelectTopOffset$2.INSTANCE);
        this.f415575o = LazyKt.lazy(MessageActionPanel$partialSelectTopShadowSize$2.INSTANCE);
        this.f415576p = LazyKt.lazy(MessageActionPanel$partialSelectBottomShadowSize$2.INSTANCE);
        this.f415577q = UIHelper.dp2px(6.0f);
        this.f415578r = UIHelper.dp2px(2.0f);
        this.f415579s = LazyKt.lazy(new MessageActionPanel$partialLabelPaint$2(this));
        Lazy r102 = LazyKt.lazy(new MessageActionPanel$triggerLongClickParentView$2(this));
        this.f415581u = r102;
        this.f415582v = LazyKt.lazy(new MessageActionPanel$statusBarColor$2(this));
        Lazy r114 = LazyKt.lazy(new MessageActionPanel$maskColor$2(this));
        this.f415583w = r114;
        LinkedHashMap r115 = new LinkedHashMap();
        this.O = r115;
        PanelType r103 = PanelType.ACTION;
        this.P = new m0(r103, 0.0f, false, PanelActionType.ALL_ACTION);
        this.R = MessageActionPanel$actionAfterAnimator$1.INSTANCE;
        Lazy r104 = LazyKt.lazy(new MessageActionPanel$panelDragLayoutChangeListener$2(this));
        this.V = r104;
        View r105 = LayoutInflater.from(r100).inflate(R.layout.layout_message_action_panel, null);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.ss.android.lark.chat.message.menu.v2.MessageActionPanelContainerLayout");
        MessageActionPanelContainerLayout r106 = (MessageActionPanelContainerLayout) r105;
        r106.setParentOtherChildView((View) r102.getValue());
        r106.setPanelDependency(new m(this));
        ColorDrawable r107 = new ColorDrawable(((Number) r114.getValue()).intValue());
        r107.setAlpha(0);
        r106.setBackground(r107);
        this.C = r106.findViewById(R.id.first_level_container);
        this.f415584x = (DragPanelLayout) r106.findViewById(R.id.action_panel_container);
        this.f415585y = (UDShadowLayout) r106.findViewById(R.id.action_panel_shadow);
        this.B = (RecyclerView) r106.findViewById(R.id.message_action_rv);
        DragPanelLayout r108 = this.f415584x;
        if (r108 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanel");
        r108 = null;
    L5:
        r108.setListener((MessageActionPanel$panelDragLayoutChangeListener$2.AnonymousClass1) r104.getValue());
        DragPanelLayout r109 = this.f415584x;
        if (r109 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanel");
        r109 = null;
    L8:
        UDShadowLayout r116 = this.f415585y;
        if (r116 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanelShadow");
        r116 = null;
    L11:
        r115.put(r103, new com.ss.android.lark.chat.message.menu.v2.a(r109, r116));
        this.N = r106.findViewById(R.id.animation_mask);
        if (this.f415563c.isEmpty() == false) goto L17;
        RecyclerView r117 = this.B;
        if (r117 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("allActionRv");
        r117 = null;
    L16:
        r117.setVisibility(8);
    L33:
        this.f415586z = (FrameLayout) r106.findViewById(R.id.action_panel_top_container);
        if (r113 == null) goto L37;
        r113.b(this);
    L37:
        if (r112 == true) goto L42;
        FrameLayout r118 = this.f415586z;
        if (r118 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanelTopContainer");
        r118 = null;
    L41:
        r118.setVisibility(8);
    L49:
        this.D = r106.findViewById(R.id.second_level_container);
        this.E = (RecyclerView) r106.findViewById(R.id.second_level_actions_rv);
        this.G = r106.findViewById(R.id.back_parent_iv);
        this.H = (TextView) r106.findViewById(R.id.parent_action_name);
        MessageActionAdapter r119 = new MessageActionAdapter();
        r119.z2(this);
        this.F = r119;
        RecyclerView r120 = this.E;
        if (r120 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsRv");
        r120 = null;
    L52:
        r120.setLayoutManager(new LinearLayoutManager(r100));
        RecyclerView r121 = this.E;
        if (r121 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsRv");
        r121 = null;
    L55:
        MessageActionAdapter r122 = this.F;
        if (r122 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("secondLevelActionsAdapter");
        r122 = null;
    L58:
        r121.setAdapter(r122);
        View r123 = this.G;
        if (r123 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("backToFirstLevelIv");
        r123 = null;
    L61:
        r123.setOnClickListener(new o(this));
        this.I = (DragPanelLayout) r106.findViewById(R.id.emoji_panel_container);
        this.f415560J = (UDShadowLayout) r106.findViewById(R.id.emoji_panel_shadow);
        PanelType r124 = PanelType.EMOJI;
        DragPanelLayout r125 = this.I;
        if (r125 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("emojiPanel");
        r125 = null;
    L64:
        UDShadowLayout r126 = this.f415560J;
        if (r126 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("emojiPanelShadow");
        r126 = null;
    L67:
        r115.put(r124, new com.ss.android.lark.chat.message.menu.v2.a(r125, r126));
        DragPanelLayout r127 = this.I;
        if (r127 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("emojiPanel");
        r127 = null;
    L70:
        r127.setListener((MessageActionPanel$panelDragLayoutChangeListener$2.AnonymousClass1) r104.getValue());
        FrameLayout r128 = (FrameLayout) r106.findViewById(R.id.all_emoji_container);
        BuiltInEmojiPanelView r129 = new BuiltInEmojiPanelView(r100);
        r129.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r129.setOnEmojiSelectListener(new n(this));
        r128.addView(r129);
        this.K = (UDShadowLayout) r106.findViewById(R.id.partial_select_container);
        this.M = (RecyclerView) r106.findViewById(R.id.partial_message_action_rv);
        UDShadowLayout r130 = this.K;
        if (r130 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("partialSelectContainer");
        r130 = null;
    L73:
        RecyclerView r131 = this.M;
        if (r131 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("partialActionRv");
        r131 = null;
    L76:
        Intrinsics.checkNotNullParameter(r130, "containerView");
        Intrinsics.checkNotNullParameter(r131, "actualTouchView");
        r106.f415607l.put(r130, r131);
        MessageActionAdapter r132 = new MessageActionAdapter();
        r132.z2(this);
        this.L = r132;
        RecyclerView r133 = this.M;
        if (r133 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("partialActionRv");
        r133 = null;
    L79:
        MessageActionAdapter r134 = this.L;
        if (r134 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("partialActionAdapter");
        r134 = null;
    L82:
        r133.setAdapter(r134);
        RecyclerView r135 = this.M;
        if (r135 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("partialActionRv");
        r135 = null;
    L85:
        r135.setLayoutManager(new LinearLayoutManager(r100));
        RecyclerView r136 = this.M;
        if (r136 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("partialActionRv");
        r136 = null;
    L88:
        r136.setItemAnimator(null);
        this.f415580t = r106;
        return;
    L42:
        FrameLayout r137 = this.f415586z;
        if (r137 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanelTopContainer");
        r137 = null;
    L45:
        r137.setVisibility(0);
        BuiltInTopEmojiView r138 = new BuiltInTopEmojiView(r100);
        l r139 = new l(this);
        Intrinsics.checkNotNullParameter(this, "control");
        Intrinsics.checkNotNullParameter(r139, "reactionClickListener");
        r138.f415741j = this;
        r138.f415742k = r139;
        ViewGroup.LayoutParams r140 = new ViewGroup.LayoutParams(-1, -2);
        FrameLayout r141 = this.f415586z;
        if (r141 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("actionPanelTopContainer");
        r141 = null;
    L48:
        r141.addView(r138, r140);
        goto L49
    L17:
        RecyclerView r142 = this.B;
        if (r142 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("allActionRv");
        r142 = null;
    L20:
        r142.setVisibility(0);
        MessageActionAdapter r143 = new MessageActionAdapter();
        r143.z2(this);
        this.A = r143;
        RecyclerView r144 = this.B;
        if (r144 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("allActionRv");
        r144 = null;
    L23:
        MessageActionAdapter r145 = this.A;
        if (r145 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("allActionAdapter");
        r145 = null;
    L26:
        r144.setAdapter(r145);
        List<? extends zya.e> r146 = this.f415563c;
        RecyclerView r147 = this.B;
        if (r147 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("allActionRv");
        r147 = null;
    L29:
        MessageActionAdapter r148 = this.A;
        if (r148 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("allActionAdapter");
        r148 = null;
    L32:
        r(r146, r147, r148);
        goto L33
    }

    public static void t(MessageActionPanel r110, PanelType r111, boolean r112, float r113, float r114, long r115, Function0 r210, Function0 r211, Function2 r212, int r213) {
        if ((r213 & 32) == 0) goto L5;
        Function0 r100 = MessageActionPanel$startPanelAnim$1.INSTANCE;
    L7:
        if ((r213 & 64) == 0) goto L9;
        Function0 r101 = MessageActionPanel$startPanelAnim$2.INSTANCE;
    L11:
        if ((r213 & 128) == 0) goto L13;
        Function2 r102 = MessageActionPanel$startPanelAnim$3.INSTANCE;
    L14:
        com.ss.android.lark.chat.message.menu.v2.a r103 = (com.ss.android.lark.chat.message.menu.v2.a) ((LinkedHashMap) r110.O).get(r111);
        if (r103 != null) goto L17;
        Log.e("MessageActionPanel", "start panel anim error: get panel null, panelType = " + r111.name());
        return;
    L17:
        ViewGroup.LayoutParams r104 = r103.f415667a.getLayoutParams();
        if (r104 == null) goto L20;
        Number r105 = Integer.valueOf(r104.height);
    L21:
        float r106 = r105.floatValue();
        ViewGroup.LayoutParams r107 = r103.f415668b.getLayoutParams();
        if (r107 == null) goto L24;
        Number r108 = Integer.valueOf(r107.height);
    L25:
        float r109 = r108.floatValue();
        if (r106 >= r113) goto L28;
        float r116 = 0.0f;
    L30:
        if (r106 >= r114) goto L32;
        float r117 = r106;
    L34:
        if (r116 != 0.0f) goto L36;
        boolean r118 = true;
    L37:
        if (r118 == false) goto L39;
        float r119 = r109;
    L41:
        if (r117 != 0.0f) goto L43;
        boolean r120 = true;
    L44:
        if (r120 == true) goto L47;
        r109 = r106 - r117;
    L47:
        ValueAnimator r121 = ValueAnimator.ofFloat(new float[]{1000.0f});
        r121.setInterpolator(new AccelerateDecelerateInterpolator());
        r121.setDuration(r115);
        r121.addUpdateListener(new r(r103, r119, r109 - r119, r113, r114 - r113, r102));
        r121.addListener(new s(r110, r103, r112, r100, r101));
        r121.start();
        return;
    L43:
        r120 = false;
        goto L44
    L39:
        r119 = r106 - r116;
        goto L41
    L36:
        r118 = false;
        goto L37
    L32:
        r117 = r114;
        goto L34
    L28:
        r116 = r113;
        goto L30
    L24:
        r108 = Float.valueOf(r110.f415569i);
        goto L25
    L20:
        r105 = Float.valueOf(r110.f415569i);
        goto L21
    L13:
        r102 = r212;
        goto L14
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
