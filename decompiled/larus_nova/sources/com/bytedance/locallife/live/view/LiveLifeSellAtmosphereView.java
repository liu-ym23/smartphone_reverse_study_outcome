package com.bytedance.locallife.live.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.live.experiment.r;
import com.bytedance.locallife.live.model.AtmosphereDataType;
import com.bytedance.locallife.live.model.AtmosphereShowType;
import com.bytedance.locallife.live.msgcenter.MsgCenter;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.s;
import com.bytedance.locallife.live.util.v;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import df6.q;
import df6.u;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import nv6.e0;
import nv6.m0;
import nv6.w;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/live/view/LiveLifeSellAtmosphereView;", "Landroid/widget/FrameLayout;", "", "position", "", "setPosition", "Lnv6/m0;", "uiData", "setAtmosphereUiData", "Lkotlinx/coroutines/CoroutineScope;", "getViewScope", "()Lkotlinx/coroutines/CoroutineScope;", "viewScope", "AtmosphereStyle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public class LiveLifeSellAtmosphereView extends FrameLayout {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f260779w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f260780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SmartImageView f260781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SmartImageView f260782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f260783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SmartImageView f260784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f260785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f260786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SmartImageView f260787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f260788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f260789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f260790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SmartImageView f260791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f260792m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m0 f260793n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m0 f260794o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public m0 f260795p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f260796q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f260797r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CoroutineScope f260798s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Animator f260799t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f260800u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.locallife.live.view.d f260801v;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/live/view/LiveLifeSellAtmosphereView$AtmosphereStyle;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AtmosphereStyle {
        public static final a Companion = null;
        public static final int DEFAULT = 0;
        public static final int IMAGE_TEXT = 2;
        public static final int IMAGE_TEXT_IMAGE = 4;
        public static final int IMAGE_XTEXT = 3;
        public static final int ONLY_IMAGE = 1;
        public static final int TEXT_IMAGE = 5;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f260802a = null;

            static {
                f260802a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f260802a;
        }
    }

    public static final class a {
    }

    public static class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }
    }

    public static final class c implements CoroutineScope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoroutineContext f260803a;

        @Override // kotlinx.coroutines.CoroutineScope
        public final CoroutineContext getCoroutineContext() {
            return this.f260803a;
        }

        public c(CoroutineContext r100) {
            Intrinsics.checkNotNullParameter(r100, "coroutineContext");
            this.f260803a = r100;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> f260804a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            kotlinx.coroutines.i<Boolean> r101 = this.f260804a;
            Boolean r102 = Boolean.FALSE;
            if (r101.isActive() == false) goto L6;
            r101.resumeWith(Result.m9449constructorimpl(r102));
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            kotlinx.coroutines.i<Boolean> r101 = this.f260804a;
            Boolean r102 = Boolean.TRUE;
            if (r101.isActive() == false) goto L6;
            r101.resumeWith(Result.m9449constructorimpl(r102));
            return;
        }

        public d(LiveLifeSellAtmosphereView r100, kotlinx.coroutines.j r101) {
            this.f260804a = r101;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> f260805a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            kotlinx.coroutines.i<Boolean> r101 = this.f260805a;
            Boolean r102 = Boolean.FALSE;
            if (r101.isActive() == false) goto L6;
            r101.resumeWith(Result.m9449constructorimpl(r102));
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            kotlinx.coroutines.i<Boolean> r101 = this.f260805a;
            Boolean r102 = Boolean.TRUE;
            if (r101.isActive() == false) goto L6;
            r101.resumeWith(Result.m9449constructorimpl(r102));
            return;
        }

        public e(LiveLifeSellAtmosphereView r100, kotlinx.coroutines.j r101) {
            this.f260805a = r101;
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> f260806a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            kotlinx.coroutines.i<Boolean> r101 = this.f260806a;
            Boolean r102 = Boolean.FALSE;
            if (r101.isActive() == false) goto L6;
            r101.resumeWith(Result.m9449constructorimpl(r102));
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            kotlinx.coroutines.i<Boolean> r101 = this.f260806a;
            Boolean r102 = Boolean.TRUE;
            if (r101.isActive() == false) goto L6;
            r101.resumeWith(Result.m9449constructorimpl(r102));
            return;
        }

        public f(LiveLifeSellAtmosphereView r100, kotlinx.coroutines.j r101) {
            this.f260806a = r101;
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> f260807a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            kotlinx.coroutines.i<Boolean> r101 = this.f260807a;
            Boolean r102 = Boolean.FALSE;
            if (r101.isActive() == false) goto L6;
            r101.resumeWith(Result.m9449constructorimpl(r102));
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            kotlinx.coroutines.i<Boolean> r101 = this.f260807a;
            Boolean r102 = Boolean.TRUE;
            if (r101.isActive() == false) goto L6;
            r101.resumeWith(Result.m9449constructorimpl(r102));
            return;
        }

        public g(LiveLifeSellAtmosphereView r100, kotlinx.coroutines.j r101) {
            this.f260807a = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.locallife.live.view.LiveLifeSellAtmosphereView$setAtmosphereUiData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.locallife.live.view.LiveLifeSellAtmosphereView$setAtmosphereUiData$1", f = "LiveLifeSellAtmosphereView.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LiveLifeSellAtmosphereView this$0;

        public AnonymousClass1(LiveLifeSellAtmosphereView r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            this.this$0.setVisibility(8);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            LiveLifeSellAtmosphereView r103 = this.this$0;
            ViewGroup r104 = r103.f260780a;
            this.label = 1;
            if (r103.k(r104, this) != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.locallife.live.view.LiveLifeSellAtmosphereView$setAtmosphereUiData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.locallife.live.view.LiveLifeSellAtmosphereView$setAtmosphereUiData$2", f = "LiveLifeSellAtmosphereView.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ m0 $uiData;
        int label;
        final /* synthetic */ LiveLifeSellAtmosphereView this$0;

        public AnonymousClass2(LiveLifeSellAtmosphereView r100, m0 r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$uiData = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$uiData, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            LiveLifeSellAtmosphereView r103 = this.this$0;
            m0 r104 = this.$uiData;
            this.label = 1;
            int r105 = LiveLifeSellAtmosphereView.f260779w;
            if (r103.g(r104, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    public LiveLifeSellAtmosphereView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public LiveLifeSellAtmosphereView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public LiveLifeSellAtmosphereView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    private final CoroutineScope getViewScope() {
        CoroutineScope r100 = this.f260798s;
        if (r100 == null) goto L5;
        return r100;
    L5:
        CoroutineScope r101 = new c(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        CoroutineScope r102 = this.f260798s;
        if (r102 != null) goto L8;
        this.f260798s = r101;
    L8:
        if (r102 == null) goto L12;
        r101 = r102;
    L12:
        if (this.f260797r == false) goto L14;
        CoroutineScopeKt.cancel$default(r101, null, 1, null);
        this.f260798s = null;
    L14:
        return r101;
    }

    public final void h() {
        this.f260781b.setVisibility(0);
        this.f260781b.setAlpha(1.0f);
        this.f260784e.setVisibility(8);
        this.f260785f.setVisibility(8);
        this.f260786g.setVisibility(8);
        this.f260787h.setVisibility(8);
        this.f260788i.setVisibility(8);
        this.f260783d.setVisibility(0);
        this.f260783d.setAlpha(1.0f);
        this.f260782c.setAlpha(0.0f);
    }

    public final void i() {
        if (TextUtils.equals(this.f260800u, "shelf") == false) goto L5;
        this.f260785f.setTextSize(1, 13.0f);
        this.f260789j.setTextSize(1, 7.5f);
        this.f260790k.setTextSize(1, 13.0f);
        return;
    L5:
        this.f260785f.setTextSize(1, 15.0f);
        this.f260789j.setTextSize(1, 8.5f);
        this.f260790k.setTextSize(1, 15.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f260797r = false;
        m0 r100 = this.f260795p;
        if (r100 == null) goto L6;
        this.f260795p = null;
        setAtmosphereUiData(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f260797r = true;
        CoroutineScopeKt.cancel$default(getViewScope(), null, 1, null);
        this.f260798s = null;
        this.f260796q = false;
    }

    public final void n(m0 r100) {
        this.f260793n = r100;
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("origin_data", GsonProtectorUtils.toJson(LiveLifeSaaSUtil.r(), r100));
        r101.put("from", this.f260800u);
        Lazy r102 = MsgCenter.f260620a;
        MsgCenter.f(new com.bytedance.locallife.live.msgcenter.a("live_life_atmosphere_view_animated", r101, null, 4));
    }

    public final void o(nv6.k r100) {
        List<nv6.e> r101 = r100.b();
        boolean r102 = false;
        w r103 = null;
        if (r101 == null) goto L15;
        Iterator<T> r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (((nv6.e) r105).getType() != 4) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L6;
    L14:
        nv6.e r107 = (nv6.e) r105;
    L16:
        List<nv6.d> r108 = r100.a();
        if (r108 == null) goto L19;
        nv6.d r109 = (nv6.d) CollectionsKt.getOrNull(r108, 1);
    L20:
        if (r109 == null) goto L22;
        String r110 = r109.d();
    L23:
        if (r110 != null) goto L25;
    L26:
        r102 = true;
    L27:
        if (r102 == false) goto L29;
        return;
    L29:
        this.f260783d.setAlpha(0.0f);
        this.f260782c.setAlpha(1.0f);
        if (r107 == null) goto L32;
        r103 = r107.c();
    L32:
        if (r103 == null) goto L34;
        q(this.f260791l, this.f260792m, r107.c());
    L34:
        boolean r111 = this.f260801v.c();
        u r112 = q.e(r110);
        r112.b("LiveLifeAtmosphereTransView");
        r112.f468294t = this.f260782c;
        r112.f468287m = Bitmap.Config.ARGB_8888;
        r112.f468278d = r111;
        r112.c();
        return;
    L25:
        if (r110.length() != 0) goto L27;
    L22:
        r110 = null;
        goto L23
    L19:
        r109 = null;
        goto L20
    L10:
        r106 = false;
        goto L11
    L13:
        r105 = null;
        goto L14
    L15:
        r107 = null;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v4 */
    public final void r(e0 r210) {
        List<nv6.e> r100 = r210.b();
        List<nv6.e> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L52;
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L14:
        if (r104.hasNext() == false) goto L22;
        Object r105 = r104.next();
        if (((nv6.e) r105).getType() != 4) goto L18;
        boolean r110 = true;
    L19:
        if (r110 == true) goto L14;
        r103.add(r105);
        goto L14
    L18:
        r110 = false;
        goto L19
    L22:
        if (r103.size() != 1) goto L27;
        if (((nv6.e) ListProtector.get(r103, 0)).getType() != 1) goto L52;
        char r106 = 1;
    L53:
        List<nv6.e> r107 = r210.b();
        if (r107 == null) goto L66;
        Iterator r108 = r107.iterator();
    L57:
        if (r108.hasNext() == false) goto L64;
        Object r111 = r108.next();
        if (((nv6.e) r111).getType() != 4) goto L61;
        boolean r112 = true;
    L62:
        if (r112 == false) goto L57;
    L65:
        nv6.e r113 = (nv6.e) r111;
    L67:
        List<nv6.e> r109 = r210.b();
        if (r109 == null) goto L78;
        ArrayList r114 = new ArrayList();
        Iterator r115 = r109.iterator();
    L71:
        if (r115.hasNext() == false) goto L79;
        Object r116 = r115.next();
        if (((nv6.e) r116).getType() != 4) goto L75;
        boolean r117 = true;
    L76:
        if (r117 == true) goto L71;
        r114.add(r116);
        goto L71
    L75:
        r117 = false;
    L79:
        nv6.d r118 = r210.a();
        if (r118 == null) goto L103;
        float r119 = j0.b(12);
        float[] r120 = {r119, r119, 0.0f, 0.0f, 0.0f, 0.0f, r119, r119};
        List<String> r121 = r118.a();
        if (r121 == null) goto L87;
        List<String> r122 = r121;
        ?? r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
        Iterator r124 = r122.iterator();
    L85:
        if (r124.hasNext() == false) goto L88;
        r123.add(Integer.valueOf(ColorProtector.parseColor((String) r124.next())));
    L88:
        GradientDrawable r125 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, CollectionsKt.toIntArray((Collection) r123));
        r125.setCornerRadii(r120);
        List<String> r126 = r118.b();
        if (r126 == null) goto L94;
        List<String> r127 = r126;
        ?? r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        Iterator r129 = r127.iterator();
    L92:
        if (r129.hasNext() == false) goto L95;
        r128.add(Integer.valueOf(ColorProtector.parseColor((String) r129.next())));
    L95:
        List<Float> r130 = r118.c();
        if (r130 != null) goto L98;
        r130 = CollectionsKt.emptyList();
    L98:
        GradientDrawable r131 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, null);
        if (Build.VERSION.SDK_INT < 29) goto L101;
        r131.setColors(CollectionsKt.toIntArray((Collection) r128), CollectionsKt.toFloatArray(r130));
    L102:
        r131.setCornerRadii(r120);
        LayerDrawable r132 = new LayerDrawable(new GradientDrawable[]{r125, r131});
        Resources r133 = Resources.getSystem();
        int r211 = MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.5d, WindowDisplayMetricsOverride.apply(r133, r133.getDisplayMetrics())));
        r132.setLayerInset(1, r211, r211, r211, r211);
    L104:
        this.f260781b.setBackground(r132);
        if (r113 == null) goto L107;
        w r134 = r113.c();
    L108:
        if (r134 == null) goto L110;
        q(this.f260791l, this.f260792m, r113.c());
    L110:
        if (1 != r106) goto L120;
        this.f260783d.setVisibility(0);
        this.f260784e.setVisibility(0);
        this.f260785f.setVisibility(8);
        this.f260786g.setVisibility(8);
        this.f260787h.setVisibility(8);
        this.f260788i.setVisibility(8);
        if (r114 == null) goto L114;
        nv6.e r135 = (nv6.e) ListProtector.get(r114, 0);
    L115:
        if (r135 == null) goto L117;
        w r136 = r135.c();
    L118:
        if (r136 == null) goto L226;
        p(this.f260784e, r135.c());
        return;
    L226:
        return;
    L117:
        r136 = null;
        goto L118
    L114:
        r135 = null;
        goto L115
    L120:
        if (5 != r106) goto L138;
        this.f260783d.setVisibility(0);
        this.f260784e.setVisibility(8);
        this.f260785f.setVisibility(0);
        this.f260786g.setVisibility(0);
        this.f260787h.setVisibility(0);
        this.f260788i.setVisibility(8);
        if (r114 == null) goto L124;
        nv6.e r137 = (nv6.e) ListProtector.get(r114, 0);
    L125:
        if (r114 == null) goto L127;
        nv6.e r138 = (nv6.e) ListProtector.get(r114, 1);
    L128:
        if (r137 == null) goto L130;
        String r139 = r137.d();
    L131:
        if (r139 == null) goto L133;
        s(this.f260785f, r137.d(), r137.e());
    L133:
        if (r138 == null) goto L135;
        w r140 = r138.c();
    L136:
        if (r140 == null) goto L228;
        p(this.f260787h, r138.c());
        return;
    L228:
        return;
    L135:
        r140 = null;
        goto L136
    L130:
        r139 = null;
        goto L131
    L127:
        r138 = null;
        goto L128
    L124:
        r137 = null;
        goto L125
    L138:
        if (2 != r106) goto L157;
        this.f260783d.setVisibility(0);
        this.f260784e.setVisibility(0);
        this.f260785f.setVisibility(0);
        this.f260786g.setVisibility(0);
        this.f260787h.setVisibility(8);
        this.f260788i.setVisibility(8);
        if (r114 == null) goto L142;
        nv6.e r141 = (nv6.e) ListProtector.get(r114, 0);
    L143:
        if (r114 == null) goto L145;
        nv6.e r142 = (nv6.e) ListProtector.get(r114, 1);
    L146:
        if (r141 == null) goto L148;
        w r143 = r141.c();
    L149:
        if (r143 == null) goto L151;
        p(this.f260784e, r141.c());
    L151:
        if (r142 == null) goto L153;
        String r144 = r142.d();
    L154:
        if (r144 == null) goto L230;
        s(this.f260785f, r142.d(), r142.e());
        return;
    L230:
        return;
    L153:
        r144 = null;
        goto L154
    L148:
        r143 = null;
        goto L149
    L145:
        r142 = null;
        goto L146
    L142:
        r141 = null;
        goto L143
    L157:
        if (3 != r106) goto L181;
        this.f260783d.setVisibility(0);
        this.f260784e.setVisibility(0);
        this.f260785f.setVisibility(8);
        this.f260786g.setVisibility(8);
        this.f260787h.setVisibility(8);
        this.f260788i.setVisibility(0);
        if (r114 == null) goto L161;
        nv6.e r145 = (nv6.e) ListProtector.get(r114, 0);
    L162:
        if (r114 == null) goto L164;
        nv6.e r146 = (nv6.e) ListProtector.get(r114, 1);
    L165:
        if (r145 == null) goto L167;
        w r147 = r145.c();
    L168:
        if (r147 == null) goto L170;
        p(this.f260784e, r145.c());
    L170:
        if (r146 == null) goto L172;
        Long r148 = r146.a();
    L173:
        if (r148 == null) goto L232;
        TextView r149 = this.f260789j;
        Float r150 = r146.f();
        if (r150 == null) goto L177;
        r150.floatValue();
        r149.setTextSize(r150.floatValue());
    L177:
        TextView r151 = this.f260790k;
        long r152 = r146.a().longValue();
        Float r153 = r146.b();
        StringBuilder r154 = new StringBuilder();
        r154.append(r152);
        r154.append(' ');
        r151.setText(r154.toString());
        if (r153 == null) goto L233;
        r153.floatValue();
        r151.setTextSize(r153.floatValue());
        return;
    L233:
        return;
    L232:
        return;
    L172:
        r148 = null;
        goto L173
    L167:
        r147 = null;
        goto L168
    L164:
        r146 = null;
        goto L165
    L161:
        r145 = null;
        goto L162
    L181:
        if (4 != r106) goto L207;
        this.f260783d.setVisibility(0);
        this.f260784e.setVisibility(0);
        this.f260785f.setVisibility(0);
        this.f260786g.setVisibility(0);
        this.f260787h.setVisibility(0);
        this.f260788i.setVisibility(8);
        if (r114 == null) goto L185;
        nv6.e r155 = (nv6.e) ListProtector.get(r114, 0);
    L186:
        if (r114 == null) goto L188;
        nv6.e r156 = (nv6.e) ListProtector.get(r114, 1);
    L189:
        if (r114 == null) goto L191;
        nv6.e r157 = (nv6.e) ListProtector.get(r114, 2);
    L192:
        if (r155 == null) goto L194;
        w r158 = r155.c();
    L195:
        if (r158 == null) goto L197;
        p(this.f260784e, r155.c());
    L197:
        if (r156 == null) goto L199;
        String r159 = r156.d();
    L200:
        if (r159 == null) goto L202;
        s(this.f260785f, r156.d(), r156.e());
    L202:
        if (r157 == null) goto L204;
        w r160 = r157.c();
    L205:
        if (r160 == null) goto L235;
        p(this.f260787h, r157.c());
        return;
    L235:
        return;
    L204:
        r160 = null;
        goto L205
    L199:
        r159 = null;
        goto L200
    L194:
        r158 = null;
        goto L195
    L191:
        r157 = null;
        goto L192
    L188:
        r156 = null;
        goto L189
    L185:
        r155 = null;
        goto L186
    L207:
        this.f260783d.setVisibility(8);
        return;
    L107:
        r134 = null;
        goto L108
    L101:
        r131.setColors(CollectionsKt.toIntArray((Collection) r128));
        goto L102
    L94:
        r128 = CollectionsKt.emptyList();
        goto L95
    L87:
        r123 = CollectionsKt.emptyList();
        goto L88
    L103:
        r132 = null;
        goto L104
    L78:
        r114 = null;
        goto L79
    L61:
        r112 = false;
        goto L62
    L64:
        r111 = null;
        goto L65
    L66:
        r113 = null;
        goto L67
    L27:
        if (r103.size() != 2) goto L44;
        nv6.e r161 = (nv6.e) ListProtector.get(r103, 0);
        nv6.e r162 = (nv6.e) ListProtector.get(r103, 1);
        if (r161.getType() != 2) goto L34;
        if (r162.getType() != 1) goto L34;
        r106 = 5;
    L34:
        if (r161.getType() != 1) goto L39;
        if (r162.getType() != 2) goto L39;
        r106 = 2;
    L39:
        if (r161.getType() != 1) goto L52;
        if (r162.getType() != 3) goto L52;
        r106 = 3;
        goto L53
    L44:
        if (r103.size() != 3) goto L52;
        nv6.e r163 = (nv6.e) ListProtector.get(r103, 0);
        nv6.e r164 = (nv6.e) ListProtector.get(r103, 1);
        nv6.e r165 = (nv6.e) ListProtector.get(r103, 2);
        if (r163.getType() != 1) goto L52;
        if (r164.getType() != 2) goto L52;
        if (r165.getType() != 1) goto L52;
        r106 = 4;
    L52:
        r106 = 0;
        goto L53
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }

    public final void setAtmosphereUiData(m0 r100) {
        Intrinsics.checkNotNullParameter(r100, "uiData");
        if (this.f260797r == false) goto L6;
        this.f260795p = r100;
        this.f260794o = null;
        return;
    L6:
        boolean r101 = s.d(r100.c());
        boolean r102 = s.d(r100.b());
        AtmosphereShowType.a r103 = AtmosphereShowType.Companion;
        String r104 = r100.c();
        String r105 = "";
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r103.getClass();
        AtmosphereShowType r106 = AtmosphereShowType.a.a(r104);
        boolean r107 = false;
        if (r106 != AtmosphereShowType.Show) goto L14;
        if (r100.a() == null) goto L14;
    L15:
        boolean r108 = true;
    L17:
        if (r101 == false) goto L21;
        if (r102 == false) goto L21;
        if (r108 == false) goto L21;
        r107 = true;
    L21:
        if (r107 == true) goto L23;
        return;
    L23:
        String r109 = r100.c();
        if (r109 == null) goto L28;
        r105 = r109;
    L28:
        if (AtmosphereShowType.a.a(r105) != AtmosphereShowType.Hide) goto L35;
        Animator r110 = this.f260799t;
        if (r110 == null) goto L32;
        r110.cancel();
    L32:
        n(r100);
        this.f260794o = null;
        BuildersKt.launch$default(getViewScope(), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L35:
        if (this.f260796q == false) goto L38;
        this.f260794o = r100;
        return;
    L38:
        BuildersKt.launch$default(getViewScope(), null, null, new AnonymousClass2(this, r100, null), 3, null);
        return;
    L14:
        if (r106 == AtmosphereShowType.Hide) goto L15;
        r108 = false;
        goto L17
    }

    public final void setPosition(String r100) {
        Intrinsics.checkNotNullParameter(r100, "position");
        this.f260800u = r100;
    }

    public static void p(SmartImageView r100, w r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        r102.width = (int) j0.b(r101.c());
        r102.height = (int) j0.b(r101.a());
        r100.setLayoutParams(r102);
        u r103 = q.d(r101.b());
        r103.b("LiveLifeAtmosphereView");
        r103.f468294t = r100;
        r103.f468287m = Bitmap.Config.ARGB_8888;
        r103.f468278d = true;
        r103.c();
    }

    public final Object b(nv6.f r100, Continuation r101) {
        if ((r101 instanceof LiveLifeSellAtmosphereView$doChangeAnimation$1) == false) goto L7;
        LiveLifeSellAtmosphereView$doChangeAnimation$1 r102 = (LiveLifeSellAtmosphereView$doChangeAnimation$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        ResultKt.throwOnFailure(r104);
    L31:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r100 = (nv6.f) r102.L$1;
        LiveLifeSellAtmosphereView r107 = (LiveLifeSellAtmosphereView) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L27:
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 3;
        if (r107.c(r100, r102) != r105) goto L31;
        return r105;
    L17:
        r100 = (nv6.f) r102.L$1;
        r107 = (LiveLifeSellAtmosphereView) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L22:
        r107.h();
        r107.i();
        if (r107.f260801v.a() == false) goto L27;
        r102.L$0 = r107;
        r102.L$1 = r100;
        r102.label = 2;
        if (DelayKt.delay(500, r102) != r105) goto L27;
        return r105;
    L18:
        ResultKt.throwOnFailure(r104);
        ViewGroup r108 = this.f260780a;
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.label = 1;
        if (k(r108, r102) != r105) goto L21;
        return r105;
    L21:
        r107 = this;
    L7:
        r102 = new LiveLifeSellAtmosphereView$doChangeAnimation$1(this, r101);
        goto L8
    }

    public final Object c(nv6.f r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof LiveLifeSellAtmosphereView$doEnterAnimation$1) == false) goto L7;
        LiveLifeSellAtmosphereView$doEnterAnimation$1 r100 = (LiveLifeSellAtmosphereView$doEnterAnimation$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r112);
    L73:
        return Unit.INSTANCE;
    L13:
        r110 = (nv6.f) r100.L$1;
        LiveLifeSellAtmosphereView r103 = (LiveLifeSellAtmosphereView) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L51:
        if (r110.a() != AtmosphereDataType.SoldCount.getValue()) goto L53;
    L57:
        View r113 = r103.f260788i;
        TextView r114 = r103.f260789j;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 6;
        kotlinx.coroutines.j r104 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r104.C();
        if (r103.f260801v.d() == true) goto L62;
        Boolean r115 = Boxing.boxBoolean(true);
        if (r104.isActive() == false) goto L67;
        r104.resumeWith(Result.m9449constructorimpl(r115));
    L67:
        Object r116 = r104.B();
        if (r116 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L70;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L70:
        if (r116 != r102) goto L73;
        return r102;
    L62:
        Rect r105 = new Rect();
        Rect r106 = new Rect();
        r113.getGlobalVisibleRect(r105);
        r114.getGlobalVisibleRect(r106);
        int r117 = r106.left - r105.left;
        int r107 = (r106.top - r105.top) + (r106.height() / 2);
        if (r117 <= 0) goto L66;
        if (r107 <= 0) goto L66;
        r113.setPivotX(r117);
        r113.setPivotY(r107);
    L66:
        ObjectAnimator r118 = ObjectAnimator.ofFloat(r113, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.2f, 1.0f});
        ObjectAnimator r119 = ObjectAnimator.ofFloat(r113, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.2f, 1.0f});
        AnimatorSet r108 = new AnimatorSet();
        r108.addListener(new j(r103, r104));
        r108.playTogether(new Animator[]{r118, r119});
        r108.setDuration(320);
        r108.start();
        r103.f260799t = r108;
        goto L67
    L53:
        if (r110.a() == AtmosphereDataType.Stock.getValue()) goto L57;
    L56:
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r112);
    L42:
        ((Boolean) r112).booleanValue();
        goto L56
    L15:
        ResultKt.throwOnFailure(r112);
    L38:
        ((Boolean) r112).booleanValue();
        goto L56
    L16:
        r110 = (nv6.f) r100.L$1;
        LiveLifeSellAtmosphereView r109 = (LiveLifeSellAtmosphereView) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L34:
        if (((Boolean) r112).booleanValue() == false) goto L56;
        nv6.k r120 = r110.b();
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 3;
        r112 = r109.d(r120, r100);
        if (r112 != r102) goto L38;
        return r102;
    L17:
        r110 = (nv6.f) r100.L$1;
        r109 = (LiveLifeSellAtmosphereView) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L29:
        if (((Boolean) r112).booleanValue() == false) goto L56;
        nv6.k r121 = r110.b();
        r100.L$0 = r109;
        r100.L$1 = r110;
        r100.label = 2;
        r112 = r109.e(r121, r100);
        if (r112 != r102) goto L34;
        return r102;
    L18:
        ResultKt.throwOnFailure(r112);
        if (r110.a() == AtmosphereDataType.SoldCount.getValue()) goto L21;
    L43:
        e0 r122 = r110.c();
        if (r122 == null) goto L46;
        r(r122);
    L46:
        ViewGroup r123 = this.f260780a;
        r100.L$0 = this;
        r100.L$1 = r110;
        r100.label = 5;
        if (j(r123, r100) != r102) goto L49;
        return r102;
    L49:
        r103 = this;
        goto L51
    L21:
        if (r110.b() == null) goto L43;
        e0 r124 = r110.c();
        if (r124 == null) goto L39;
        r(r124);
        ViewGroup r125 = this.f260780a;
        r100.L$0 = this;
        r100.L$1 = r110;
        r100.label = 1;
        r112 = j(r125, r100);
        if (r112 != r102) goto L27;
        return r102;
    L27:
        r109 = this;
        goto L29
    L39:
        o(r110.b());
        ViewGroup r126 = this.f260780a;
        r100.label = 4;
        r112 = j(r126, r100);
        if (r112 != r102) goto L42;
        return r102;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new LiveLifeSellAtmosphereView$doEnterAnimation$1(this, r111);
        goto L8
    }

    public final Object d(nv6.k r100, ContinuationImpl r101) {
        boolean r102 = true;
        kotlinx.coroutines.j r103 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r103.C();
        List<nv6.d> r104 = r100.a();
        String r105 = null;
        if (r104 == null) goto L5;
        nv6.d r106 = (nv6.d) CollectionsKt.getOrNull(r104, 1);
    L6:
        if (r106 == null) goto L9;
        r105 = r106.d();
    L9:
        if (r105 != null) goto L11;
    L14:
        if (r102 == false) goto L18;
        Boolean r107 = Boxing.boxBoolean(false);
        if (r103.isActive() == false) goto L19;
        r103.resumeWith(Result.m9449constructorimpl(r107));
    L19:
        Object r108 = r103.B();
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L22:
        return r108;
    L18:
        boolean r109 = this.f260801v.c();
        this.f260782c.setAlpha(1.0f);
        u r110 = q.e(r105);
        r110.b("LiveLifeAtmosphereTransView");
        r110.f468294t = this.f260782c;
        r110.f468287m = Bitmap.Config.ARGB_8888;
        r110.f468278d = r109;
        r110.d(new com.bytedance.locallife.live.view.f(this, r103));
        goto L19
    L11:
        if (r105.length() == 0) goto L14;
        r102 = false;
        goto L14
    L5:
        r106 = null;
        goto L6
    }

    public final Object e(nv6.k r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof LiveLifeSellAtmosphereView$doTransformAnimation$1) == false) goto L7;
        LiveLifeSellAtmosphereView$doTransformAnimation$1 r100 = (LiveLifeSellAtmosphereView$doTransformAnimation$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L59:
        return r112;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        LiveLifeSellAtmosphereView r113 = (LiveLifeSellAtmosphereView) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L44:
        AnimatedDrawable2 r114 = (AnimatedDrawable2) r112;
        if (r114 == null) goto L47;
        View r104 = r113.f260788i;
        View r105 = r113.f260783d;
        r100.L$0 = null;
        r100.label = 2;
        kotlinx.coroutines.j r106 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r106.C();
        Ref.IntRef r107 = new Ref.IntRef();
        Ref.IntRef r108 = new Ref.IntRef();
        AnimationBackend r115 = r114.getAnimationBackend();
        if (r115 == null) goto L51;
        r114.setPrivateFrameScheduler(new v(r115));
    L51:
        r114.setAnimationListener(new h(r107, r108, r113, r106));
        ObjectAnimator r116 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.2f});
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.2f});
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r105, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r118 = new AnimatorSet();
        r118.addListener(new i(r108, r107, r113, r106));
        r118.playTogether(new Animator[]{r116, r109, r117});
        r118.setDuration(440);
        r113.f260799t = r118;
        r118.start();
        r113.f260782c.setAlpha(1.0f);
        if (r114.isRunning() == true) goto L54;
        r114.start();
    L54:
        r112 = r106.B();
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L57;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L57:
        if (r112 != r102) goto L59;
        return r102;
    L47:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r112);
        if (this.f260801v.b() == true) goto L20;
        this.f260783d.setAlpha(0.0f);
        return Boxing.boxBoolean(true);
    L20:
        r100.L$0 = this;
        r100.label = 1;
        kotlinx.coroutines.j r119 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r119.C();
        List<nv6.d> r120 = r110.a();
        if (r120 == null) goto L23;
        nv6.d r121 = (nv6.d) CollectionsKt.getOrNull(r120, 0);
    L24:
        if (r121 == null) goto L26;
        String r122 = r121.d();
    L27:
        if (r122 != null) goto L29;
    L32:
        boolean r123 = true;
    L33:
        if (r123 == true) goto L35;
        u r124 = q.e(r122);
        r124.b("LiveLifeAtmosphereTransView");
        r124.f468294t = this.f260782c;
        r124.f468287m = Bitmap.Config.ARGB_8888;
        r124.f468278d = false;
        r124.d(new com.bytedance.locallife.live.view.g(this, r119));
    L38:
        r112 = r119.B();
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L41:
        if (r112 != r102) goto L43;
        return r102;
    L43:
        r113 = this;
        goto L44
    L35:
        if (r119.isActive() == false) goto L38;
        r119.resumeWith(Result.m9449constructorimpl(null));
        goto L38
    L29:
        if (r122.length() == 0) goto L32;
        r123 = false;
        goto L33
    L26:
        r122 = null;
        goto L27
    L23:
        r121 = null;
    L7:
        r100 = new LiveLifeSellAtmosphereView$doTransformAnimation$1(this, r111);
        goto L8
    }

    public final Object g(m0 r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof LiveLifeSellAtmosphereView$processShowAtmosphereUiData$1) == false) goto L7;
        LiveLifeSellAtmosphereView$processShowAtmosphereUiData$1 r100 = (LiveLifeSellAtmosphereView$processShowAtmosphereUiData$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L19;
        if (r103 == 1) goto L18;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L18;
        if (r103 == 4) goto L18;
        if (r103 != 5) goto L17;
        ResultKt.throwOnFailure(r112);
    L62:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        LiveLifeSellAtmosphereView r113 = (LiveLifeSellAtmosphereView) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L53:
        r113.f260796q = false;
        r100.L$0 = null;
        r100.label = 5;
        m0 r104 = r113.f260794o;
        if (r104 == null) goto L58;
        r113.f260794o = null;
        Object r114 = r113.g(r104, r100);
        if (r114 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L58;
    L59:
        if (r114 != r102) goto L62;
        return r102;
    L58:
        r114 = Unit.INSTANCE;
        goto L59
    L19:
        ResultKt.throwOnFailure(r112);
        m0 r115 = this.f260793n;
        AtmosphereShowType.a r105 = AtmosphereShowType.Companion;
        if (r115 == null) goto L23;
        String r106 = r115.c();
        if (r106 == null) goto L23;
    L24:
        r105.getClass();
        AtmosphereShowType r107 = AtmosphereShowType.a.a(r106);
        nv6.f r108 = r110.a();
        Intrinsics.checkNotNull(r108);
        this.f260796q = true;
        if (r115 != null) goto L27;
    L49:
        setVisibility(0);
        h();
        i();
        n(r110);
        r100.L$0 = this;
        r100.label = 1;
        if (c(r108, r100) != r102) goto L52;
        return r102;
    L52:
        r113 = this;
        goto L53
    L27:
        if (r107 == AtmosphereShowType.Hide) goto L49;
        if (Intrinsics.areEqual(r115.b(), r110.b()) == true) goto L37;
        Animator r116 = this.f260799t;
        if (r116 == null) goto L34;
        r116.cancel();
    L34:
        setVisibility(0);
        h();
        i();
        n(r110);
        r100.L$0 = this;
        r100.label = 2;
        if (c(r108, r100) != r102) goto L52;
        return r102;
    L37:
        nv6.f r117 = r115.a();
        Intrinsics.checkNotNull(r117);
        if (r117.a() == r108.a()) goto L43;
        setVisibility(0);
        n(r110);
        r100.L$0 = this;
        r100.label = 3;
        if (b(r108, r100) != r102) goto L52;
        return r102;
    L43:
        if (r108.a() != AtmosphereDataType.SoldCount.getValue()) goto L45;
    L46:
        setVisibility(0);
        n(r110);
        r100.L$0 = this;
        r100.label = 4;
        if (f(r117, r108, r100) != r102) goto L52;
        return r102;
    L45:
        if (r108.a() != AtmosphereDataType.Stock.getValue()) goto L52;
    L23:
        r106 = "";
    L7:
        r100 = new LiveLifeSellAtmosphereView$processShowAtmosphereUiData$1(this, r111);
        goto L8
    }

    public final Object j(View r100, Continuation<? super Boolean> r101) {
        kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        if (this.f260801v.a() == true) goto L7;
        r100.setAlpha(1.0f);
        Boolean r103 = Boxing.boxBoolean(true);
        if (r102.isActive() == false) goto L8;
        r102.resumeWith(Result.m9449constructorimpl(r103));
    L8:
        Object r104 = r102.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L11:
        return r104;
    L7:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{j0.b(15), 0.0f});
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet r107 = new AnimatorSet();
        r107.addListener(new d(this, r102));
        r107.playTogether(new Animator[]{r105, r106});
        r107.setDuration(280);
        r107.start();
        this.f260799t = r107;
        goto L8
    }

    public final Object k(View r100, Continuation<? super Boolean> r101) {
        kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        if (this.f260801v.a() == true) goto L7;
        r100.setAlpha(0.0f);
        Boolean r103 = Boxing.boxBoolean(true);
        if (r102.isActive() == false) goto L8;
        r102.resumeWith(Result.m9449constructorimpl(r103));
    L8:
        Object r104 = r102.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L11:
        return r104;
    L7:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, -10.0f});
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r107 = new AnimatorSet();
        r107.addListener(new e(this, r102));
        r107.playTogether(new Animator[]{r105, r106});
        r107.setDuration(280);
        r107.start();
        this.f260799t = r107;
        goto L8
    }

    public static final void a(Ref.IntRef r100, Ref.IntRef r101, kotlinx.coroutines.i r102) {
        int r103 = r100.element;
        if (r103 != 1) goto L10;
        if (r101.element != 1) goto L10;
        Boolean r104 = Boolean.TRUE;
        if (r102.isActive() == false) goto L17;
        r102.resumeWith(Result.m9449constructorimpl(r104));
        return;
    L17:
        return;
    L10:
        if (r103 != (-1)) goto L12;
    L13:
        Boolean r105 = Boolean.FALSE;
        if (r102.isActive() == false) goto L20;
        r102.resumeWith(Result.m9449constructorimpl(r105));
        return;
    L20:
        return;
    L12:
        if (r101.element == (-1)) goto L13;
    }

    public static void s(TextView r100, String r101, Float r102) {
        r100.setText(r101 + ' ');
        if (r102 == null) goto L6;
        r102.floatValue();
        r100.setTextSize(r102.floatValue());
        return;
    }

    public final Object f(nv6.f r100, nv6.f r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof LiveLifeSellAtmosphereView$doUpdateAnimation$1) == false) goto L7;
        LiveLifeSellAtmosphereView$doUpdateAnimation$1 r103 = (LiveLifeSellAtmosphereView$doUpdateAnimation$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r107 = true;
        switch(r103.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r105);
    L67:
        return Unit.INSTANCE;
    L13:
        r101 = (nv6.f) r103.L$1;
        LiveLifeSellAtmosphereView r108 = (LiveLifeSellAtmosphereView) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L60:
        e0 r109 = r101.c();
        if (r109 == null) goto L63;
        r108.r(r109);
    L63:
        View r110 = r108.f260788i;
        TextView r111 = r108.f260789j;
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 6;
        if (r108.m(r110, r111, r103) != r106) goto L67;
        return r106;
    L14:
        ResultKt.throwOnFailure(r105);
    L55:
        return Unit.INSTANCE;
    L15:
        r101 = (nv6.f) r103.L$1;
        LiveLifeSellAtmosphereView r112 = (LiveLifeSellAtmosphereView) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L48:
        e0 r113 = r101.c();
        if (r113 == null) goto L51;
        r112.r(r113);
    L51:
        View r114 = r112.f260788i;
        TextView r115 = r112.f260789j;
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 4;
        if (r112.m(r114, r115, r103) != r106) goto L55;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
    L36:
        if (((Boolean) r105).booleanValue() == true) goto L39;
    L38:
        r107 = false;
    L39:
        Boxing.boxBoolean(r107);
    L43:
        return Unit.INSTANCE;
    L17:
        r101 = (nv6.f) r103.L$1;
        LiveLifeSellAtmosphereView r116 = (LiveLifeSellAtmosphereView) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L31:
        if (((Boolean) r105).booleanValue() == false) goto L38;
        nv6.k r117 = r101.b();
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 2;
        r105 = r116.d(r117, r103);
        if (r105 != r106) goto L36;
        return r106;
    L18:
        ResultKt.throwOnFailure(r105);
        if (r101.a() == AtmosphereDataType.SoldCount.getValue()) goto L21;
        View r118 = this.f260788i;
        TextView r119 = this.f260789j;
        r103.L$0 = this;
        r103.L$1 = r101;
        r103.label = 5;
        if (l(r118, r119, r103) != r106) goto L59;
        return r106;
    L59:
        r108 = this;
        goto L60
    L21:
        if (r101.b() != null) goto L23;
        View r120 = this.f260788i;
        TextView r121 = this.f260789j;
        r103.L$0 = this;
        r103.L$1 = r101;
        r103.label = 3;
        if (l(r120, r121, r103) != r106) goto L47;
        return r106;
    L47:
        r112 = this;
        goto L48
    L23:
        if (r100.b() != null) goto L41;
        e0 r122 = r101.c();
        if (r122 == null) goto L40;
        r(r122);
        nv6.k r123 = r101.b();
        r103.L$0 = this;
        r103.L$1 = r101;
        r103.label = 1;
        r105 = e(r123, r103);
        if (r105 != r106) goto L29;
        return r106;
    L29:
        r116 = this;
        goto L31
    L40:
        o(r101.b());
        goto L43
    L41:
        o(r101.b());
        goto L43
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r103 = new LiveLifeSellAtmosphereView$doUpdateAnimation$1(this, r102);
        goto L8
    }

    public final Object l(View r100, View r101, Continuation<? super Boolean> r102) {
        kotlinx.coroutines.j r103 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        if (this.f260801v.d() == true) goto L7;
        Boolean r104 = Boxing.boxBoolean(true);
        if (r103.isActive() == false) goto L12;
        r103.resumeWith(Result.m9449constructorimpl(r104));
    L12:
        Object r105 = r103.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L15:
        return r105;
    L7:
        Rect r106 = new Rect();
        Rect r107 = new Rect();
        r100.getGlobalVisibleRect(r106);
        r101.getGlobalVisibleRect(r107);
        int r108 = r107.left - r106.left;
        int r109 = (r107.top - r106.top) + (r107.height() / 2);
        if (r108 <= 0) goto L11;
        if (r109 <= 0) goto L11;
        r100.setPivotX(r108);
        r100.setPivotY(r109);
    L11:
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.2f});
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.2f});
        AnimatorSet r112 = new AnimatorSet();
        r112.addListener(new f(this, r103));
        r112.playTogether(new Animator[]{r110, r111});
        r112.setDuration(100);
        r112.start();
        this.f260799t = r112;
        goto L12
    }

    public final Object m(View r100, View r101, Continuation<? super Boolean> r102) {
        kotlinx.coroutines.j r103 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        if (this.f260801v.d() == true) goto L7;
        Boolean r104 = Boxing.boxBoolean(true);
        if (r103.isActive() == false) goto L12;
        r103.resumeWith(Result.m9449constructorimpl(r104));
    L12:
        Object r105 = r103.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L15:
        return r105;
    L7:
        Rect r106 = new Rect();
        Rect r107 = new Rect();
        r100.getGlobalVisibleRect(r106);
        r101.getGlobalVisibleRect(r107);
        int r108 = r107.left - r106.left;
        int r109 = (r107.top - r106.top) + (r107.height() / 2);
        if (r108 <= 0) goto L11;
        if (r109 <= 0) goto L11;
        r100.setPivotX(r108);
        r100.setPivotY(r109);
    L11:
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.2f, 1.0f});
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.2f, 1.0f});
        AnimatorSet r112 = new AnimatorSet();
        r112.addListener(new g(this, r103));
        r112.playTogether(new Animator[]{r110, r111});
        r112.setDuration(100);
        r112.start();
        this.f260799t = r112;
        goto L12
    }

    public final void q(SmartImageView r100, View r101, w r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        r103.width = (int) j0.b(r102.c());
        r103.height = (int) j0.b(r102.a());
        r100.setLayoutParams(r103);
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        r104.width = (int) j0.b(r102.c());
        r104.height = (int) j0.b(r102.a());
        r101.setLayoutParams(r104);
        boolean r105 = this.f260801v.e();
        u r106 = q.d(r102.b());
        r106.b("LiveLifeAtmosphereView");
        r106.f468294t = r100;
        r106.f468287m = Bitmap.Config.ARGB_8888;
        r106.f468278d = r105;
        r106.c();
    }

    public LiveLifeSellAtmosphereView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        boolean r104 = false;
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f260800u = BrowserDependency.UrlClickType.CARD;
        if (1 != r.a()) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L15;
        com.bytedance.locallife.live.view.d r106 = new p();
    L22:
        this.f260801v = r106;
        View r107 = LayoutInflater.from(r100).inflate(R.layout.saas_live_life_sell_atmosphere_view, this);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r108 = (ViewGroup) r107;
        this.f260780a = r108;
        this.f260781b = (SmartImageView) r108.findViewById(R.id.iv_atmosphere_bg);
        this.f260782c = (SmartImageView) r108.findViewById(R.id.iv_atmosphere_trans);
        this.f260783d = r108.findViewById(R.id.atmosphere_content_container);
        this.f260784e = (SmartImageView) r108.findViewById(R.id.iv_atmosphere_pre_text);
        this.f260785f = (TextView) r108.findViewById(R.id.tv_atmosphere_text);
        this.f260786g = r108.findViewById(R.id.atmosphere_text_container);
        this.f260787h = (SmartImageView) r108.findViewById(R.id.iv_atmosphere_after_text);
        this.f260788i = r108.findViewById(R.id.atmosphere_x_text_container);
        this.f260789j = (TextView) r108.findViewById(R.id.tv_x_express);
        this.f260790k = (TextView) r108.findViewById(R.id.tv_text_express);
        this.f260791l = (SmartImageView) r108.findViewById(R.id.iv_atmosphere_left_icon);
        this.f260792m = r108.findViewById(R.id.left_icon_placeholder);
        setVisibility(8);
        return;
    L15:
        if (3 != r.a()) goto L17;
    L18:
        r104 = true;
    L19:
        if (r104 == false) goto L21;
        r106 = new k();
        goto L22
    L21:
        r106 = new l();
        goto L22
    L17:
        if (2 != r.a()) goto L19;
    L11:
        r105 = false;
        goto L12
    }
}
