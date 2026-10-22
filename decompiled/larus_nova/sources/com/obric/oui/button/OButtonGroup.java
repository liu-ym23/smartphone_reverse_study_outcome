package com.obric.oui.button;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.common.style.q;
import com.obric.oui.layout.OUIFrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0006%&'()*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u001f\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u001e\u001a\u00020\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u000f\u0010#\u001a\u00020\u0002H\u0000¢\u0006\u0004\b!\u0010\"J\b\u0010$\u001a\u00020\u0002H\u0014¨\u0006+"}, d2 = {"Lcom/obric/oui/button/OButtonGroup;", "Lcom/obric/oui/button/OShadowFrame;", "", "alpha", "", "setGroupAlpha", "", "Landroid/view/View;", "children", "settleChildrenVisualState", "scale", "setGroupScaleForAnimation", "radius", "setGroupBlur", "setGroupBlurForAnimation", "Lkotlin/Function0;", "listener", "setGroupAlphaAnimationUpdateListener$OUI_standardRelease", "(Lkotlin/jvm/functions/Function0;)V", "setGroupAlphaAnimationUpdateListener", "setAnimationUpdateListener$OUI_standardRelease", "setAnimationUpdateListener", "", "minWidth", "setWidthMin", "", "blocked", "setTouchEventBlocked$OUI_standardRelease", "(Z)V", "setTouchEventBlocked", "getItemCount", "enabled", "setEnabled", "getRawGroupAlphaForTitleBarTransition$OUI_standardRelease", "()F", "getRawGroupAlphaForTitleBarTransition", "getCurrentPressScaleForAnimation", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "ContentAnimationState", "GroupAnimationState", "d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OButtonGroup extends OShadowFrame {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f399069k0 = 0;
    public LinearLayout D;
    public final int E;
    public final int F;
    public final int G;
    public View H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final List<fja.d> f399070J;
    public final List<fja.d> K;
    public ContentAnimationState L;
    public float M;
    public List<? extends Object> N;
    public Function0<Unit> O;
    public Function0<Unit> P;
    public final List<Function0<Unit>> Q;
    public final List<Function0<Unit>> R;
    public float S;
    public float T;
    public float U;
    public boolean V;
    public GroupAnimationState W;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$ContentAnimationState;", "", "IDLE", "OUT", "IN", "SETTLING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum ContentAnimationState extends Enum<ContentAnimationState> {
        public static final ContentAnimationState IDLE = null;
        public static final ContentAnimationState IN = null;
        public static final ContentAnimationState OUT = null;
        public static final ContentAnimationState SETTLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContentAnimationState[] f399071a = null;

        public static ContentAnimationState valueOf(String r100) {
            return (ContentAnimationState) r27.a.a(ContentAnimationState.class, r100);
        }

        public static ContentAnimationState[] values() {
            return (ContentAnimationState[]) f399071a.clone();
        }

        static {
            ContentAnimationState r100 = new ContentAnimationState("IDLE", 0);
            IDLE = r100;
            ContentAnimationState r101 = new ContentAnimationState("OUT", 1);
            OUT = r101;
            ContentAnimationState r102 = new ContentAnimationState("IN", 2);
            IN = r102;
            ContentAnimationState r103 = new ContentAnimationState("SETTLING", 3);
            SETTLING = r103;
            f399071a = new ContentAnimationState[]{r100, r101, r102, r103};
        }

        public ContentAnimationState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$GroupAnimationState;", "", "IDLE", "APPEARING", "DISAPPEARING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum GroupAnimationState extends Enum<GroupAnimationState> {
        public static final GroupAnimationState APPEARING = null;
        public static final GroupAnimationState DISAPPEARING = null;
        public static final GroupAnimationState IDLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupAnimationState[] f399072a = null;

        public static GroupAnimationState valueOf(String r100) {
            return (GroupAnimationState) r27.a.a(GroupAnimationState.class, r100);
        }

        public static GroupAnimationState[] values() {
            return (GroupAnimationState[]) f399072a.clone();
        }

        static {
            GroupAnimationState r100 = new GroupAnimationState("IDLE", 0);
            IDLE = r100;
            GroupAnimationState r101 = new GroupAnimationState("APPEARING", 1);
            APPEARING = r101;
            GroupAnimationState r102 = new GroupAnimationState("DISAPPEARING", 2);
            DISAPPEARING = r102;
            f399072a = new GroupAnimationState[]{r100, r101, r102};
        }

        public GroupAnimationState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f399073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Function1<Function0<Unit>, Unit>> f399074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f399075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f399076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f399077e;

        public a(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "onFinished");
            this.f399073a = r100;
            this.f399074b = new ArrayList();
        }

        public final void a(Function1<? super Function0<Unit>, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "starter");
            ((ArrayList) this.f399074b).add(r100);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f399078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f399079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f399080c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f399081d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f399082e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f399083f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<d> f399084g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f399078a == r101.f399078a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f399079b), Float.valueOf(r101.f399079b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f399080c), Float.valueOf(r101.f399080c)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.f399081d), Float.valueOf(r101.f399081d)) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(Float.valueOf(this.f399082e), Float.valueOf(r101.f399082e)) == true) goto L24;
            return false;
        L24:
            if (this.f399083f == r101.f399083f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f399084g, r101.f399084g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.f399078a * 31) + Float.floatToIntBits(this.f399079b)) * 31) + Float.floatToIntBits(this.f399080c)) * 31) + Float.floatToIntBits(this.f399081d)) * 31) + Float.floatToIntBits(this.f399082e)) * 31) + this.f399083f) * 31) + this.f399084g.hashCode();
        }

        public final String toString() {
            return "AnimationState(visibility=" + this.f399078a + ", alpha=" + this.f399079b + ", scaleX=" + this.f399080c + ", scaleY=" + this.f399081d + ", groupBlur=" + this.f399082e + ", groupWidth=" + this.f399083f + ", items=" + this.f399084g + ')';
        }

        public b(int r100, float r101, float r102, float r103, float r104, int r105, List<d> r106) {
            Intrinsics.checkNotNullParameter(r106, "items");
            this.f399078a = r100;
            this.f399079b = r101;
            this.f399080c = r102;
            this.f399081d = r103;
            this.f399082e = r104;
            this.f399083f = r105;
            this.f399084g = r106;
        }
    }

    public static final class c {

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f399085a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f399086b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final b f399087c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final b f399088d = null;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final b f399089e = null;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final b f399090f = null;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final b f399091g = null;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final b f399092h = null;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final b f399093i = null;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final b f399094j = null;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public static final b f399095k = null;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public static final b f399096l = null;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final b f399097m = null;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final b f399098n = null;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public static final b f399099o = null;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public static final b f399100p = null;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public static final b f399101q = null;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public static final b f399102r = null;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public static final b f399103s = null;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public static final b f399104t = null;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            public static final b f399105u = null;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public static final b f399106v = null;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public static final b f399107w = null;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public static final b f399108x = null;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public static final b f399109y = null;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public static final b f399110z = null;

            static {
                Token$Bounce r100 = Token$Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4;
                Token$Duration r101 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2;
                f399085a = new b(r100, r101);
                Token$Duration r102 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
                f399086b = new b(r100, r102);
                Token$Bounce r103 = Token$Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_1;
                f399087c = new b(r103, r101);
                f399088d = new b(r103, r102);
                Token$Bounce r104 = Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH;
                f399089e = new b(r104, r101);
                f399090f = new b(r104, r102);
                Token$Duration r105 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_1;
                f399091g = new b(r100, r105);
                Token$Duration r106 = Token$Duration.OUI_ANIMATION_DURATION_SHORT_2;
                f399092h = new b(r104, r106);
                f399093i = new b(r104, r101);
                f399094j = new b(r104, r102);
                f399095k = new b(r103, r101);
                f399096l = new b(r103, r102);
                f399097m = new b(r104, r101);
                f399098n = new b(r104, r102);
                f399099o = new b(r104, r101);
                f399100p = new b(r104, r101);
                f399101q = new b(r104, r106);
                f399102r = new b(r100, r101);
                Token$Bounce r107 = Token$Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_2;
                f399103s = new b(r107, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_4);
                f399104t = new b(r107, Token$Duration.OUI_ANIMATION_DURATION_LONG_1);
                f399105u = new b(r104, r106);
                f399106v = new b(r104, r106);
                f399107w = new b(r104, r106);
                f399108x = new b(r104, r101);
                f399109y = new b(r100, r105);
                f399110z = new b(r104, r101);
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Token$Bounce f399111a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Token$Duration f399112b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (this.f399111a == r101.f399111a) goto L12;
                return false;
            L12:
                if (this.f399112b == r101.f399112b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f399111a.hashCode() * 31) + this.f399112b.hashCode();
            }

            public final String toString() {
                return "SpringTokenConfig(bounce=" + this.f399111a + ", duration=" + this.f399112b + ')';
            }

            public final com.obric.common.oea.foundation.animation.spec.spring.b a() {
                return gja.b.a(this.f399111a, this.f399112b, Token$Delay.OUI_ANIMATION_DELAY_NONE);
            }

            public b(Token$Bounce r100, Token$Duration r101) {
                Intrinsics.checkNotNullParameter(r100, "bounce");
                Intrinsics.checkNotNullParameter(r101, "duration");
                this.f399111a = r100;
                this.f399112b = r101;
            }
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f399113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f399114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f399115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f399116d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f399117e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f399113a, r101.f399113a) == true) goto L12;
            return false;
        L12:
            if (this.f399114b == r101.f399114b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f399115c), Float.valueOf(r101.f399115c)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.f399116d), Float.valueOf(r101.f399116d)) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(Float.valueOf(this.f399117e), Float.valueOf(r101.f399117e)) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Object r100 = this.f399113a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (((((((r101 * 31) + this.f399114b) * 31) + Float.floatToIntBits(this.f399115c)) * 31) + Float.floatToIntBits(this.f399116d)) * 31) + Float.floatToIntBits(this.f399117e);
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "ItemAnimationState(key=" + this.f399113a + ", visibility=" + this.f399114b + ", alpha=" + this.f399115c + ", scaleX=" + this.f399116d + ", scaleY=" + this.f399117e + ')';
        }

        public d(Object r100, int r101, float r102, float r103, float r104) {
            this.f399113a = r100;
            this.f399114b = r101;
            this.f399115c = r102;
            this.f399116d = r103;
            this.f399117e = r104;
        }
    }

    static {
    }

    public OButtonGroup(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public OButtonGroup(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public OButtonGroup(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final void I() {
        Iterator r100 = ((ArrayList) this.K).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        fja.d r101 = (fja.d) r100.next();
        int r102 = fja.d.f477533d;
        r101.a(false);
        goto L4
    L6:
        ((ArrayList) this.K).clear();
        this.L = ContentAnimationState.IDLE;
    }

    public final void J() {
        Iterator r100 = ((ArrayList) this.f399070J).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        fja.d r101 = (fja.d) r100.next();
        int r102 = fja.d.f477533d;
        r101.a(false);
        goto L4
    L6:
        ((ArrayList) this.f399070J).clear();
        this.W = GroupAnimationState.IDLE;
    }

    public final List<View> N() {
        LinearLayout r100 = this.D;
        if (r100 == null) goto L5;
        ArrayList r101 = new ArrayList(r100.getChildCount());
        int r102 = r100.getChildCount();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L9;
        int r104 = r103 + 1;
        r101.add(r100.getChildAt(r103));
        r103 = r104;
        goto L7
    L9:
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean Q() {
        if (this.W == GroupAnimationState.IDLE) goto L5;
    L8:
        return true;
    L5:
        if (this.L != ContentAnimationState.IDLE) goto L8;
        return false;
    }

    public final void X() {
        F(1.0f, 1.0f, 0.0f);
        P(-2);
        LinearLayout r100 = this.D;
        if (r100 == null) goto L12;
        int r101 = r100.getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L16;
        int r103 = r102 + 1;
        View r104 = r100.getChildAt(r102);
        if (r104.isEnabled() == false) goto L10;
        r104.setAlpha(1.0f);
    L11:
        r104.setScaleX(1.0f);
        r104.setScaleY(1.0f);
        r102 = r103;
        goto L6
    L10:
        r104.setEnabled(false);
        goto L11
    L16:
        return;
    }

    public final void Z() {
        KeyEvent.Callback r100 = this.H;
        if (r100 != null) goto L5;
    L13:
        this.H = null;
        this.I = false;
        return;
    L5:
        if (this.I == false) goto L13;
        if ((r100 instanceof com.obric.oui.common.style.a) == false) goto L9;
        com.obric.oui.common.style.a r101 = (com.obric.oui.common.style.a) r100;
    L10:
        if (r101 == null) goto L13;
        r101.setChangeAlphaWhenPress(true);
        goto L13
    L9:
        r101 = null;
        goto L10
    }

    public final b a0() {
        LinearLayout r100 = this.D;
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L7;
        int r102 = r100.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        int r104 = r103 + 1;
        View r105 = r100.getChildAt(r103);
        r101.add(new d(r105.getTag(), r105.getVisibility(), r105.getAlpha(), r105.getScaleX(), r105.getScaleY()));
        r103 = r104;
    L7:
        int r106 = getVisibility();
        float r107 = getContentView().getAlpha();
        float r108 = this.T;
        float r109 = this.M;
        ViewGroup.LayoutParams r110 = getLayoutParams();
        if (r110 != null) goto L10;
        int r111 = -2;
    L12:
        return new b(r106, r107, r108, r108, r109, r111, r101);
    L10:
        r111 = r110.width;
        goto L12
    }

    public final int getItemCount() {
        LinearLayout r100 = this.D;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getChildCount();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i0() {
        LinearLayout r100 = this.D;
        if (r100 != null) goto L5;
        return;
    L5:
        boolean r101 = true;
        if (r100.getChildCount() != 1) goto L24;
        View r102 = r100.getChildAt(0);
        if (this.H == r102) goto L11;
        Z();
        this.H = r102;
    L11:
        if ((r102 instanceof com.obric.oui.common.style.a) == false) goto L13;
        com.obric.oui.common.style.a r103 = (com.obric.oui.common.style.a) r102;
    L14:
        if (r103 == null) goto L17;
        r103.setChangeAlphaWhenPress(false);
        this.I = true;
    L17:
        OUIFrameLayout r104 = getContentView();
        if (isEnabled() == true) goto L20;
    L22:
        r101 = false;
    L23:
        r104.setChangeAlphaWhenPress(r101);
        return;
    L20:
        if (r102.isEnabled() == false) goto L22;
    L13:
        r103 = null;
        goto L14
    L24:
        getContentView().setChangeAlphaWhenPress(false);
        Z();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final boolean r() {
        if (this.W == GroupAnimationState.IDLE) goto L5;
        return false;
    L5:
        if (this.S >= 1.0f) goto L7;
        return false;
    L7:
        if (getItemCount() != 1) goto L21;
        LinearLayout r100 = this.D;
        if (r100 != null) goto L11;
        View r101 = null;
    L12:
        if (r101 != null) goto L15;
    L17:
        boolean r102 = false;
    L18:
        if (r102 == true) goto L21;
        boolean r103 = false;
    L22:
        if (r103 == false) goto L27;
        return true;
    L27:
        return false;
    L15:
        if (r101.isEnabled() != true) goto L17;
        r102 = true;
        goto L18
    L11:
        r101 = r100.getChildAt(0);
    L21:
        r103 = true;
        goto L22
    }

    public final void K() {
        if (getItemCount() != 0) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
    }

    public final void O() {
        if (Q() == false) goto L5;
        return;
    L5:
        if (((ArrayList) this.R).isEmpty() == true) goto L13;
        List r100 = CollectionsKt.toList(this.R);
        ((ArrayList) this.R).clear();
        Iterator r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L14;
        ((Function0) r101.next()).invoke();
        goto L9
    L14:
        return;
    }

    public final boolean R() {
        if (getItemCount() == 0) goto L5;
        LinearLayout r100 = this.D;
        if (r100 != null) goto L13;
        return true;
    L13:
        if (getVisibility() == 0) goto L15;
    L44:
        return false;
    L15:
        if (V() == true) goto L44;
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 != null) goto L20;
        int r102 = -2;
    L21:
        if (r102 == (-2)) goto L23;
        return false;
    L23:
        int r103 = r100.getChildCount();
        int r104 = 0;
    L24:
        if (r104 >= r103) goto L43;
        int r105 = r104 + 1;
        View r106 = r100.getChildAt(r104);
        if (Math.abs(r106.getAlpha() - L(r106)) >= 0.001f) goto L28;
        boolean r107 = true;
    L29:
        if (r107 == false) goto L42;
        if (r106.getScaleX() != 1.0f) goto L33;
        boolean r108 = true;
    L34:
        if (r108 == false) goto L42;
        if (r106.getScaleY() != 1.0f) goto L38;
        boolean r109 = true;
    L39:
        if (r109 == false) goto L42;
        r104 = r105;
        goto L24
    L38:
        r109 = false;
        goto L39
    L33:
        r108 = false;
    L42:
        return false;
    L28:
        r107 = false;
        goto L29
    L43:
        return true;
    L20:
        r102 = r101.width;
        goto L21
    L5:
        if (getVisibility() != 0) goto L49;
        return false;
    L49:
        return true;
    }

    public final boolean V() {
        if (getContentView().getAlpha() >= 1.0f) goto L5;
        return true;
    L5:
        if (getScaleX() != 1.0f) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L10;
        return true;
    L10:
        if (getScaleY() != 1.0f) goto L12;
        boolean r101 = true;
    L13:
        if (r101 == true) goto L15;
        return true;
    L15:
        if (this.M > 0.0f) goto L22;
        return false;
    L22:
        return true;
    L12:
        r101 = false;
        goto L13
    L7:
        r100 = false;
        goto L8
    }

    @Override // com.obric.oui.button.OShadowFrame
    public float getCurrentPressScaleForAnimation() {
        return this.U;
    }

    public final float getRawGroupAlphaForTitleBarTransition$OUI_standardRelease() {
        return this.S;
    }

    public static float L(View r100) {
        if (r100.isEnabled() == false) goto L6;
        return 1.0f;
    L6:
        if ((r100 instanceof com.obric.oui.common.style.a) == true) goto L8;
        return 1.0f;
    L8:
        float r101 = r100.getAlpha();
        r100.setAlpha(1.0f);
        r100.setEnabled(false);
        float r102 = r100.getAlpha();
        r100.setAlpha(r101);
        return r102;
    }

    public static boolean M(View r100) {
        if ((r100 instanceof TextView) == false) goto L6;
        return true;
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L13;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        int r104 = r103 + 1;
        if (M(r101.getChildAt(r103)) == true) goto L11;
        r103 = r104;
        goto L8
    L11:
        return true;
    L13:
        return false;
    }

    public static List T(List r100) {
        List r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        View r104 = (View) r103.next();
        Object r105 = r104.getTag();
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        r102.add(r104);
        goto L4
    L10:
        return r102;
    }

    private final void setGroupAlpha(float r100) {
        this.S = r100;
        getContentView().setAlpha(r100);
        setContentShadowAlphaProgress(r100);
    }

    private final void setGroupBlur(float r100) {
        setContentSelfBlur(r100);
    }

    private final void setGroupBlurForAnimation(float r100) {
        this.M = r100;
        setGroupBlur(r100);
    }

    private final void setGroupScaleForAnimation(float r100) {
        this.T = r100;
        float r101 = r100 * this.U;
        setScaleX(r101);
        setScaleY(r101);
    }

    private final void settleChildrenVisualState(List<? extends View> r100) {
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        View r102 = (View) r101.next();
        if (r102.isEnabled() == false) goto L8;
        r102.setAlpha(1.0f);
    L9:
        r102.setScaleX(1.0f);
        r102.setScaleY(1.0f);
        goto L4
    L8:
        r102.setEnabled(false);
        goto L9
    }

    public static final void u(OButtonGroup r100) {
        if ((!((ArrayList) r100.Q).isEmpty()) == false) goto L8;
        List r101 = CollectionsKt.toList(r100.Q);
        ((ArrayList) r100.Q).clear();
        Iterator r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((Function0) r102.next()).invoke();
        goto L6
    L10:
        return;
    }

    public final void C(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (Q() == true) goto L6;
        r100.invoke();
        return;
    L6:
        ((ArrayList) this.R).add(r100);
    }

    public final void H(boolean r100) {
        J();
        I();
        ((ArrayList) this.Q).clear();
        ((ArrayList) this.R).clear();
        if (r100 == false) goto L6;
        this.N = null;
        return;
    }

    public final void P(int r100) {
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.width = r100;
        setLayoutParams(r101);
    }

    public final int U(List<? extends View> r100) {
        if (r100.isEmpty() == false) goto L5;
        return 0;
    L5:
        int r101 = getContentContainer().getPaddingLeft() + getContentContainer().getPaddingRight();
        Iterator<T> r102 = r100.iterator();
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r102.hasNext() == false) goto L21;
        Object r105 = r102.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        View r107 = (View) r105;
        int r108 = r107.getMinimumHeight();
        if (r108 > 0) goto L14;
    L16:
        r107.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r103 = r103 + r107.getMeasuredWidth();
        if (r104 <= 0) goto L19;
        r103 = r103 + this.E;
    L19:
        r104 = r106;
        goto L7
    L14:
        if (r107.getMinimumWidth() >= r108) goto L16;
        r107.setMinimumWidth(r108);
        goto L16
    L21:
        return Math.max(r103 + r101, this.F);
    }

    public final void W(List<? extends View> r100) {
        LinearLayout r101 = this.D;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeAllViews();
        Iterator<T> r102 = r100.iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L32;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        View r106 = (View) r104;
        ViewParent r107 = r106.getParent();
        ViewGroup.MarginLayoutParams r108 = null;
        if ((r107 instanceof ViewGroup) == false) goto L14;
        ViewGroup r109 = (ViewGroup) r107;
    L15:
        if (r109 == null) goto L18;
        r109.removeView(r106);
    L18:
        int r110 = r106.getMinimumHeight();
        if (r110 > 0) goto L21;
    L23:
        ViewGroup.LayoutParams r111 = r106.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        r108 = (ViewGroup.MarginLayoutParams) r111;
    L26:
        if (r108 != null) goto L28;
        r108 = new ViewGroup.MarginLayoutParams(-2, -2);
    L28:
        if (r103 != 0) goto L30;
        int r112 = 0;
    L31:
        r108.setMarginStart(r112);
        r101.addView(r106, r108);
        r103 = r105;
        goto L7
    L30:
        r112 = this.E;
        goto L31
    L21:
        if (r106.getMinimumWidth() >= r110) goto L23;
        r106.setMinimumWidth(r110);
        goto L23
    L14:
        r109 = null;
        goto L15
    L32:
        i0();
        K();
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = true;
        if (this.V == false) goto L6;
        return true;
    L6:
        if (getItemCount() != 1) goto L8;
        boolean r102 = true;
    L9:
        boolean r103 = super.dispatchTouchEvent(r100);
        if (r102 == false) goto L37;
        boolean r104 = r();
        int r105 = r100.getActionMasked();
        if (r105 == 0) goto L36;
        if (r105 != 1) goto L15;
    L35:
        getContentView().setPressed(false);
        goto L37
    L15:
        if (r105 == 2) goto L20;
        if (r105 == 3) goto L35;
    L20:
        if (r100.getX() >= 0.0f) goto L22;
    L28:
        boolean r106 = false;
    L29:
        OUIFrameLayout r107 = getContentView();
        if (r104 == false) goto L33;
        if (r106 == false) goto L33;
    L34:
        r107.setPressed(r101);
    L33:
        r101 = false;
        goto L34
    L22:
        if (r100.getX() >= getWidth()) goto L28;
        if (r100.getY() < 0.0f) goto L28;
        if (r100.getY() >= getHeight()) goto L28;
        r106 = true;
        goto L29
    L36:
        getContentView().setPressed(r104);
    L37:
        return r103;
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void e(float r100) {
        this.U = r100;
        float r101 = this.T * r100;
        setScaleX(r101);
        setScaleY(r101);
    }

    public final void setAnimationUpdateListener$OUI_standardRelease(Function0<Unit> r100) {
        this.O = r100;
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r100) {
        if (Q() == false) goto L5;
        b r101 = a0();
    L6:
        super.setEnabled(r100);
        LinearLayout r102 = this.D;
        if (r102 == null) goto L13;
        r102.setEnabled(r100);
        Iterator<View> r103 = ViewGroupKt.getChildren(r102).iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        r103.next().setEnabled(r100);
    L13:
        i0();
        if (r101 == null) goto L30;
        setVisibility(r101.f399078a);
        F(r101.f399079b, r101.f399080c, r101.f399082e);
        P(r101.f399083f);
        LinearLayout r104 = this.D;
        if (r104 == null) goto L35;
        Iterator<T> r105 = r101.f399084g.iterator();
        int r106 = 0;
    L21:
        if (r105.hasNext() == false) goto L36;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        d r109 = (d) r107;
        View r110 = r104.getChildAt(r106);
        if (r110 == null) goto L29;
        r110.setVisibility(r109.f399114b);
        r110.setAlpha(r109.f399115c);
        r110.setScaleX(r109.f399116d);
        r110.setScaleY(r109.f399117e);
    L29:
        r106 = r108;
        goto L21
    L36:
        return;
    L35:
        return;
    L30:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setGroupAlphaAnimationUpdateListener$OUI_standardRelease(Function0<Unit> r100) {
        this.P = r100;
    }

    public final void setTouchEventBlocked$OUI_standardRelease(boolean r100) {
        this.V = r100;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public void setWidthMin(int r100) {
        getLayoutHelper().setWidthMin(r100);
    }

    public static void b0(Function0 r100, Function1 r101) {
        a r102 = new a(r100);
        r101.invoke(r102);
        if (((ArrayList) r102.f399074b).isEmpty() == true) goto L5;
        r102.f399075c = ((ArrayList) r102.f399074b).size();
        r102.f399076d = true;
        Iterator r103 = ((ArrayList) r102.f399074b).iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        ((Function1) r103.next()).invoke(new OButtonGroup$AnimationBatch$start$1$1(r102));
        goto L10
    L15:
        return;
    L5:
        if (r102.f399077e == true) goto L14;
        r102.f399077e = true;
        r102.f399073a.invoke();
        return;
    }

    public static final /* synthetic */ void w(OButtonGroup r100, float r101) {
        r100.setGroupBlurForAnimation(r101);
    }

    public static final /* synthetic */ void x(OButtonGroup r100, float r101) {
        r100.setGroupScaleForAnimation(r101);
    }

    public static final /* synthetic */ void y(OButtonGroup r100, List r101) {
        r100.settleChildrenVisualState(r101);
    }

    public final void D(View r100, ViewGroup.MarginLayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "layoutParams");
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "layoutParams");
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "layoutParams");
        r100.setLayoutParams(r101);
        List<? extends View> r102 = CollectionsKt.toMutableList(N());
        ListProtector.add(r102, r102.size(), r100);
        h0(r102, false);
    }

    public final void E(final boolean r100, final Function0<Unit> r101) {
        boolean r102 = false;
        getContentView().setPressed(false);
        f();
        if (getContentView().getAlpha() > 0.0f) goto L5;
        o();
    L5:
        setVisibility(0);
        if (r100 == false) goto L11;
        c.b r103 = c.a.f399085a;
        F(0.0f, 1.1f, 7);
        Iterator<T> r104 = N().iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        View r105 = (View) r104.next();
        r105.setAlpha(0.0f);
        c.b r106 = c.a.f399085a;
        r105.setScaleX(1.5f);
        r105.setScaleY(1.5f);
    L11:
        LinearLayout r107 = this.D;
        if (r107 != null) goto L14;
        return;
    L14:
        Integer r108 = Integer.valueOf(r107.getWidth());
        if (r108.intValue() <= 0) goto L17;
        r102 = true;
    L17:
        if (r102 == true) goto L20;
        r108 = null;
    L20:
        if (r108 != null) goto L22;
        final int r109 = r107.getMeasuredWidth();
    L23:
        if (r100 == false) goto L25;
        final List<View> r110 = N();
    L26:
        this.W = GroupAnimationState.APPEARING;
        ((ArrayList) this.f399070J).clear();
        b0(new OButtonGroup$animateGroupAppear$1(this, r100, r110, r101), new OButtonGroup$animateGroupAppear$2(r110, this, r109));
        return;
    L25:
        r110 = CollectionsKt.emptyList();
        goto L26
    L22:
        r109 = r108.intValue();
        goto L23
    }

    public final void Y(b r100, Function1<? super d, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "itemFactory");
        H(true);
        List<d> r102 = r100.f399084g;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L3:
        View r105 = null;
        if (r104.hasNext() == false) goto L11;
        d r106 = (d) r104.next();
        View r107 = r101.invoke(r106);
        if (r107 == null) goto L9;
        r107.setVisibility(r106.f399114b);
        r107.setAlpha(r106.f399115c);
        r107.setScaleX(r106.f399116d);
        r107.setScaleY(r106.f399117e);
        r105 = r107;
    L9:
        if (r105 == null) goto L3;
        r103.add(r105);
        goto L3
    L11:
        W(r103);
        this.N = null;
        P(r100.f399083f);
        setVisibility(r100.f399078a);
        F(r100.f399079b, r100.f399080c, r100.f399082e);
        i0();
    }

    public final void h0(final List<? extends View> r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "views");
        LinearLayout r100 = this.D;
        if (r100 != null) goto L7;
        wma.b.b("OButtonGroup", "itemContainer is null");
        return;
    L7:
        if (r110.size() <= this.G) goto L9;
        wma.b.h("OButtonGroup", "views size exceeds capacity: " + this.G + ", truncated");
        r110 = CollectionsKt.take(r110, this.G);
    L9:
        int r101 = r100.getChildCount();
        int r102 = r110.size();
        List<? extends Object> r103 = T(r110);
        List r104 = T(N());
        if (Intrinsics.areEqual(r103, r104) == false) goto L15;
        if (R() == false) goto L15;
        return;
    L15:
        if (Q() == true) goto L17;
    L19:
        final boolean r105 = true;
        Integer r106 = null;
        if (r111 == true) goto L23;
        H(true);
        W(r110);
        X();
        K();
        this.N = null;
        return;
    L23:
        this.N = r103;
        if (Intrinsics.areEqual(r103, r104) == true) goto L26;
    L77:
        if (r102 != 0) goto L94;
        GroupAnimationState r112 = this.W;
        GroupAnimationState r113 = GroupAnimationState.DISAPPEARING;
        if (r112 == r113) goto L121;
        I();
        J();
        final Function0<Unit> r114 = new OButtonGroup$transitionToEmpty$1(this);
        LinearLayout r107 = this.D;
        if (r107 == null) goto L122;
        Integer r108 = Integer.valueOf(r107.getWidth());
        if (r108.intValue() <= 0) goto L87;
        boolean r109 = true;
    L88:
        if (r109 == false) goto L90;
        r106 = r108;
    L90:
        if (r106 != null) goto L92;
        final int r115 = r107.getMeasuredWidth();
    L93:
        final List<View> r116 = N();
        getContentView().setPressed(false);
        f();
        this.W = r113;
        ((ArrayList) this.f399070J).clear();
        b0(new OButtonGroup$animateGroupDisappear$1(this, r114, r105), new OButtonGroup$animateGroupDisappear$2(r116, this, r115));
        return;
    L92:
        r115 = r106.intValue();
        goto L93
    L87:
        r109 = false;
        goto L88
    L122:
        return;
    L121:
        return;
    L94:
        if (r101 != 0) goto L97;
        H(false);
        W(r110);
        E(true, new OButtonGroup$transitionFromEmpty$1(this));
        return;
    L97:
        if (this.W == GroupAnimationState.IDLE) goto L99;
        J();
    L99:
        I();
        final boolean r117 = V();
        final List<View> r118 = N();
        Integer r119 = Integer.valueOf(getWidth());
        if (r119.intValue() > 0) goto L103;
        r105 = false;
    L103:
        if (r105 == false) goto L105;
        r106 = r119;
    L105:
        if (r106 != null) goto L107;
        int r120 = getMeasuredWidth();
    L108:
        final int r121 = U(r110);
        P(r120);
        this.L = ContentAnimationState.OUT;
        ((ArrayList) this.K).clear();
        final Ref.BooleanRef r122 = new Ref.BooleanRef();
        final Ref.BooleanRef r123 = new Ref.BooleanRef();
        g0(r120, r121, new OButtonGroup$animateContentChange$1(r122, this, r110, r123));
        if (r117 == false) goto L111;
        setVisibility(0);
    L111:
        final boolean r124 = !r117;
        b0(new OButtonGroup$animateContentChange$2(this, r110, r123, r122), new OButtonGroup$animateContentChange$3(r117, r124, r118, this, r121));
        return;
    L107:
        r120 = r106.intValue();
        goto L108
    L26:
        if (R() == true) goto L77;
        final List<View> r125 = N();
        if (r125.isEmpty() == false) goto L30;
        X();
        K();
        return;
    L30:
        H(false);
        if (V() == false) goto L33;
    L34:
        E(false, null);
    L35:
        LinearLayout r126 = this.D;
        if (r126 == null) goto L64;
        ViewGroup.LayoutParams r127 = getLayoutParams();
        if (r127 != null) goto L41;
        int r128 = -2;
    L42:
        if (r128 != (-2)) goto L63;
        int r129 = r126.getChildCount();
        int r130 = 0;
    L45:
        if (r130 >= r129) goto L64;
        int r131 = r130 + 1;
        View r132 = r126.getChildAt(r130);
        if (Math.abs(r132.getAlpha() - L(r132)) >= 0.001f) goto L49;
        boolean r133 = true;
    L50:
        if (r133 == false) goto L63;
        if (r132.getScaleX() != 1.0f) goto L54;
        boolean r134 = true;
    L55:
        if (r134 == false) goto L63;
        if (r132.getScaleY() != 1.0f) goto L59;
        boolean r135 = true;
    L60:
        if (r135 == false) goto L63;
        r130 = r131;
        goto L45
    L59:
        r135 = false;
        goto L60
    L54:
        r134 = false;
        goto L55
    L49:
        r133 = false;
    L63:
        boolean r136 = true;
    L65:
        if (r136 == false) goto L118;
        Integer r137 = Integer.valueOf(getWidth());
        if (r137.intValue() > 0) goto L70;
        r105 = false;
    L70:
        if (r105 == false) goto L72;
        r106 = r137;
    L72:
        if (r106 != null) goto L74;
        final int r138 = getMeasuredWidth();
    L75:
        final int r139 = U(r125);
        P(r138);
        this.L = ContentAnimationState.SETTLING;
        ((ArrayList) this.K).clear();
        b0(new OButtonGroup$animateContentSettle$1(this, r125), new OButtonGroup$animateContentSettle$2(r125, this, r138, r139));
        return;
    L74:
        r138 = r106.intValue();
        goto L75
    L118:
        return;
    L41:
        r128 = r127.width;
    L64:
        r136 = false;
        goto L65
    L33:
        if (getVisibility() == 0) goto L35;
    L17:
        if (Intrinsics.areEqual(r103, this.N) == false) goto L19;
    }

    public final void F(float r100, float r101, float r102) {
        setGroupAlpha(r100);
        this.T = r101;
        float r103 = r101 * this.U;
        setScaleX(r103);
        setScaleY(r103);
        setGroupBlurForAnimation(r102);
    }

    public final Function1<Float, Unit> G(final float r110, float r111, final Function1<? super Float, Unit> r112) {
        final float r100 = RangesKt.coerceIn(r111, 0.0f, 1.0f);
        if (r100 != 1.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        final boolean r102 = false;
    L12:
        if (r100 != 0.0f) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
    L19:
        final boolean r104 = false;
    L20:
        final Ref.BooleanRef r105 = new Ref.BooleanRef();
        return new OButtonGroup$boundedAlphaUpdater$1(r105, r100, r102, r104, this, r110, r112);
    L17:
        if (r110 <= r100) goto L19;
        r104 = true;
        goto L20
    L14:
        r103 = false;
        goto L15
    L8:
        if (r110 >= r100) goto L10;
        r102 = true;
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public final void g0(int r100, final int r110, final Function0<Unit> r111) {
        List<fja.d> r101 = this.K;
        float r102 = r100;
        float r103 = r110;
        c.b r104 = c.a.f399085a;
        if (r110 >= 150) goto L5;
        c.b r105 = c.a.f399103s;
    L6:
        ((ArrayList) r101).add(c0(r102, r103, r105.a(), 10.0f, new OButtonGroup$startWidthChangeAnimation$1(this), new OButtonGroup$startWidthChangeAnimation$2(this, r110, r111)));
        return;
    L5:
        r105 = c.a.f399104t;
        goto L6
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void k(Context r100, OUIFrameLayout r101, TypedArray r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "contentView");
        r101.removeAllViews();
        setChangeAlphaWhenPress(false);
        getContentView().setDuplicateParentStateEnabled(false);
        LinearLayout r103 = new LinearLayout(r100);
        r103.setOrientation(0);
        r103.setGravity(17);
        this.D = r103;
        r101.addView(r103);
        setWidthMin(this.F);
        getContentView().setWidthMin(this.F);
        i0();
        K();
        if (getEnableMaterial() == false) goto L6;
        l(r100, r102);
        return;
    }

    public OButtonGroup(Context r100, AttributeSet r101, int r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r111 & 4) == 0) goto L8;
        int r102 = 0;
    L9:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r103 = r101;
        super(r100, r103, r102, 8, 0);
        this.G = 5;
        this.f399070J = new ArrayList();
        this.K = new ArrayList();
        this.L = ContentAnimationState.IDLE;
        this.Q = new ArrayList();
        this.R = new ArrayList();
        this.S = 1.0f;
        this.T = 1.0f;
        this.U = 1.0f;
        this.W = GroupAnimationState.IDLE;
        setClipChildren(false);
        setClipToPadding(false);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_height, com.larus.nova.R.attr.oui_OButtonGroupCapacity, com.larus.nova.R.attr.oui_widgetEnableMaterial, com.larus.nova.R.attr.oui_widgetInnerItemMargin, com.larus.nova.R.attr.oui_widgetMaterial, com.larus.nova.R.attr.oui_widgetMaterialDisabled, com.larus.nova.R.attr.oui_widgetMinWidth, com.larus.nova.R.attr.oui_widgetPaddingB, com.larus.nova.R.attr.oui_widgetPaddingL, com.larus.nova.R.attr.oui_widgetPaddingR, com.larus.nova.R.attr.oui_widgetPaddingT}, 0, 0);
        this.F = r104.getDimensionPixelSize(6, 0);
        this.E = r104.getDimensionPixelSize(3, 0);
        this.G = r104.getDimensionPixelSize(1, 5);
        r104.recycle();
        return;
    L8:
        r102 = r110;
        goto L9
    }

    public static final void B(final OButtonGroup r100, com.obric.common.oea.foundation.animation.spec.spring.b r101, Function0 r110, List r111) {
        final List<q> r102 = r100.i();
        final float r103 = 1.0f;
        final List<q> r104 = r100.n(1.0f);
        final Function1<Float, Unit> r105 = r100.G(0.0f, 1.0f, new OButtonGroup$startGroupShadowAnimation$updateFraction$1(r100, r103, r102, r104));
        ArrayList r112 = (ArrayList) r111;
        r112.add(r100.c0(0.0f, 1.0f, r101, 0.390625f, new OButtonGroup$startGroupShadowAnimation$1(r105), r110));
    }

    public static final void v(OButtonGroup r100, List r101, boolean r102, boolean r103) {
        r100.getClass();
        if (r102 == false) goto L8;
        if (r103 == false) goto L9;
        ((ArrayList) r100.K).clear();
        r100.L = ContentAnimationState.IDLE;
        r100.settleChildrenVisualState(r101);
        r100.P(-2);
        r100.setGroupScaleForAnimation(1.0f);
        r100.setGroupBlurForAnimation(0.0f);
        r100.N = null;
        r100.O();
        return;
    L9:
        return;
    }

    public final void d0(final float r100, com.obric.common.oea.foundation.animation.spec.spring.b r110, Function0 r111, List r112) {
        final float r101 = getContentView().getAlpha();
        final List<q> r102 = i();
        final List<q> r103 = n(r100);
        final Function1<Float, Unit> r104 = G(r101, r100, new OButtonGroup$startGroupAlphaAnimation$updateAlpha$1(this, r100, r101, r102, r103));
        r112.add(c0(r101, r100, r110, 0.390625f, new OButtonGroup$startGroupAlphaAnimation$1(this, r104), r111));
    }

    public final void e0(float r100, com.obric.common.oea.foundation.animation.spec.spring.b r101, Function0 r110, List r111) {
        r111.add(c0(this.M, r100, r101, 10.0f, new OButtonGroup$startGroupBlurAnimation$1(this), r110));
    }

    public final void f0(float r100, com.obric.common.oea.foundation.animation.spec.spring.b r101, final Function0 r110, List r111) {
        r111.add(c0(this.T, r100, r101, 0.390625f, new OButtonGroup$startGroupScaleAnimation$1(this), new OButtonGroup$startGroupScaleAnimation$2(r110)));
    }

    public static final void A(OButtonGroup r100, final View r101, float r102, com.obric.common.oea.foundation.animation.spec.spring.b r110, final Function0 r111, List r112) {
        r100.getClass();
        ArrayList r113 = (ArrayList) r112;
        r113.add(r100.c0(r101.getScaleX(), r102, r110, 0.390625f, new OButtonGroup$startChildScaleAnimation$1(r101), new OButtonGroup$startChildScaleAnimation$2(r111)));
    }

    public static final void z(OButtonGroup r100, final View r101, float r110, com.obric.common.oea.foundation.animation.spec.spring.b r111, Function0 r112, List r113) {
        r100.getClass();
        final Function1<Float, Unit> r102 = r100.G(r101.getAlpha(), r110, new OButtonGroup$startChildAlphaAnimation$updateAlpha$1(r101));
        ArrayList r114 = (ArrayList) r113;
        r114.add(r100.c0(r101.getAlpha(), r110, r111, 0.390625f, new OButtonGroup$startChildAlphaAnimation$1(r102), r112));
    }

    public final fja.d c0(float r100, float r101, com.obric.common.oea.foundation.animation.spec.spring.b r102, float r103, final Function1 r104, final Function0 r105) {
        com.obric.common.oea.foundation.animation.builder.d.a r106 = new com.obric.common.oea.foundation.animation.builder.d.a();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.f396390b = r103;
        r106.b(r100, r101, r102, null);
        Function3<String, Object, Object, Unit> r107 = new OButtonGroup$startFloatAnimation$1(r104, this);
        Intrinsics.checkNotNullParameter(r107, "callback");
        r106.f396382d = r107;
        Function2<Boolean, Throwable, Unit> r108 = new OButtonGroup$startFloatAnimation$2(r105);
        Intrinsics.checkNotNullParameter(r108, "callback");
        r106.f396383e = r108;
        return r106.a().a();
    }
}
