package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.animation.ValueAnimator;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.ime.ExtensionImeKt;
import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import com.ss.android.lark.keyboard.ime.ImeWrapper;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.ImeWrapperMotionScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.StatusBarUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class VoiceImeWrapperUseCase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImeWrapper f430479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a f430480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f430481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f430482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImeWrapperMotionScene f430483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f430484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f430485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f430486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f430487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f430488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f430489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f430490l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f430491m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f430492n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f430493o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f430494p;

    public static final class a implements com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceImeWrapperUseCase f430495a;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.g
        public final Pair<String, Integer> a() {
            KeyboardFunctionEditText r100 = this.f430495a.f430480b.a();
            return TuplesKt.to(r100.getEditableText().toString(), Integer.valueOf(r100.getSelectionStart()));
        }

        public a(VoiceImeWrapperUseCase r100) {
            this.f430495a = r100;
        }
    }

    public static final class b {
    }

    public static final class c implements com.ss.android.lark.keyboard.ime.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceImeWrapperUseCase f430496a;

        public c(VoiceImeWrapperUseCase r100) {
            this.f430496a = r100;
        }

        @Override // com.ss.android.lark.keyboard.ime.i
        public final void u(ImeState r100, ImeState r101) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        }

        @Override // com.ss.android.lark.keyboard.ime.i
        public final void B(ImeStateDetail r100, ImeStateDetail r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
            if (r101 != ImeStateDetail.Exit) goto L6;
            this.f430496a.f430480b.a().clearFocus();
        L6:
            if (r100 == ImeStateDetail.Show) goto L8;
            return;
        L8:
            if (r101 != ImeStateDetail.Hide) goto L12;
            VoiceImeWrapperUseCase r103 = this.f430496a;
            ImeWrapperMotionScene.d(r103.f430483e, false, null, r103.a().getImmersiveVoiceMode().f409283b, 7);
            return;
        }
    }

    public static final class d implements com.ss.android.lark.keyboard.ime.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceImeWrapperUseCase f430497a;

        public d(VoiceImeWrapperUseCase r100) {
            this.f430497a = r100;
        }

        @Override // com.ss.android.lark.keyboard.ime.i
        public final void u(ImeState r100, ImeState r110) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r110, RemoteMessageConst.TO);
            ImeState r101 = ImeState.NONE;
            boolean r102 = true;
            if (r110 != r101) goto L14;
            this.f430497a.a().updateIsKeyboardShowing(false);
            VoiceImeWrapperUseCase.f(this.f430497a, 0, false, 7);
            VoiceImeWrapperUseCase r103 = this.f430497a;
            FrameLayout r104 = r103.f430480b.f();
            Intrinsics.checkNotNullParameter(r104, "view");
            if (r104.getVisibility() == 4) goto L8;
            r102 = false;
        L8:
            if (r102 == false) goto L10;
        L13:
            VoiceImeWrapperUseCase r105 = this.f430497a;
            ImeWrapperMotionScene.d(r105.f430483e, false, null, r105.a().getImmersiveVoiceMode().f409283b, 7);
            this.f430497a.f430480b.a().clearFocus();
            return;
        L10:
            if (r103.c() == true) goto L13;
            float r106 = r104.getHeight();
            ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r107.setDuration(96);
            r107.addUpdateListener(new m0(r104, r106));
            Intrinsics.checkNotNull(r107);
            r107.addListener(new n0(r104, r106, r103));
            r107.start();
            List<ValueAnimator> r108 = r103.b();
            Intrinsics.checkNotNull(r107);
            r108.add(r107);
            goto L13
        L14:
            if (r100 != r101) goto L26;
            this.f430497a.a().updateIsKeyboardShowing(true);
            VoiceImeWrapperUseCase r109 = this.f430497a;
            FrameLayout r111 = r109.f430480b.f();
            Intrinsics.checkNotNullParameter(r111, "view");
            if (r111.getVisibility() == 0) goto L19;
            r102 = false;
        L19:
            if (r102 == false) goto L21;
            return;
        L21:
            if (r109.c() == true) goto L28;
            float r112 = r111.getHeight();
            ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r113.setDuration(96);
            r113.addUpdateListener(new p0(r111, r112));
            Intrinsics.checkNotNull(r113);
            r113.addListener(new o0(r111, r109, r111));
            r113.start();
            List<ValueAnimator> r114 = r109.b();
            Intrinsics.checkNotNull(r113);
            r114.add(r113);
            return;
        L28:
            return;
        }

        @Override // com.ss.android.lark.keyboard.ime.i
        public final void B(ImeStateDetail r100, ImeStateDetail r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
            Intrinsics.checkNotNullParameter(ImeWrapper.B, "<this>");
            if (r102 == 2) goto L5;
            return;
        L5:
            if (r101.isEnterOrShow() == false) goto L8;
            this.f430497a.a().updateIsPanelShowing(true);
            return;
        L8:
            if (r101 != ImeStateDetail.Hide) goto L13;
            this.f430497a.a().updateIsPanelShowing(false);
            return;
        }
    }

    public static final class e implements com.ss.android.lark.keyboard.ime.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceImeWrapperUseCase f430498a;

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void J() {
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void K(int r100, int r101, int r102, float r103, float r104) {
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void a(int r100) {
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void g(int r100, int r101, int r102, int r103, float r104) {
        }

        public e(VoiceImeWrapperUseCase r100) {
            this.f430498a = r100;
        }

        @Override // com.ss.android.lark.keyboard.ime.e
        public final void n(int r100, int r101, long r110, Interpolator r111) {
            Intrinsics.checkNotNullParameter(r111, "interpolator");
            boolean r102 = false;
            if (r100 >= r101) goto L8;
            this.f430498a.a().updateIsKeyboardShowing(true);
            int r103 = RangesKt.coerceAtLeast(this.f430498a.f430480b.f().getHeight() - r100, 0);
            VoiceImeWrapperUseCase.f(this.f430498a, r103 + r101, true, 4);
            VoiceImeWrapperUseCase r104 = this.f430498a;
            ImeWrapperMotionScene r105 = r104.f430483e;
            VoiceInputScene r106 = r104.a().getImmersiveVoiceMode().f409283b;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, "scene");
            KeyboardVoiceFGUtils r107 = KeyboardVoiceFGUtils.f429815a;
            if (KeyboardVoiceFGUtils.b() == false) goto L7;
            r105.c(true, null, false, null, r106, true);
            return;
        L7:
            r105.b(true, null);
            return;
        L8:
            if (r100 == r101) goto L10;
        L12:
            VoiceImeWrapperUseCase.f(this.f430498a, 0, false, 7);
            VoiceImeWrapperUseCase r108 = this.f430498a;
            ImeWrapperMotionScene r109 = r108.f430483e;
            Boolean r112 = r108.a().isPanelShowing().getValue();
            if (r112 == null) goto L15;
            r102 = r112.booleanValue();
        L15:
            ImeWrapperMotionScene.d(r109, r102, Long.valueOf(r110), this.f430498a.a().getImmersiveVoiceMode().f409283b, 1);
            return;
        L10:
            if (KeyboardVoiceFGUtils.d() == false) goto L12;
        }
    }

    public static final class f implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceImeWrapperUseCase f430499a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public f(VoiceImeWrapperUseCase r100) {
            this.f430499a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r110) {
            KeyboardFunctionEditText r100 = this.f430499a.f430480b.a();
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 23) goto L17;
            VoiceImeWrapperUseCase r102 = this.f430499a;
            int r103 = r100.getWidth();
            r102.getClass();
            CharSequence r104 = r100.getText();
            CharSequence r105 = r100.getText();
            if (r105 == null) goto L7;
            int r106 = r105.length();
        L8:
            StaticLayout.Builder r107 = StaticLayout.Builder.obtain(r104, 0, r106, r100.getPaint(), r103);
            r107.setAlignment(Layout.Alignment.ALIGN_NORMAL);
            r107.setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR);
            r107.setLineSpacing(r100.getLineSpacingExtra(), r100.getLineSpacingMultiplier());
            r107.setIncludePad(r100.getIncludeFontPadding());
            r107.setBreakStrategy(r100.getBreakStrategy());
            r107.setHyphenationFrequency(r100.getHyphenationFrequency());
            r107.setMaxLines(r100.getMaxLines());
            if (r101 < 26) goto L12;
            r107.setJustificationMode(r100.getJustificationMode());
        L12:
            if (r100.getEllipsize() != null) goto L14;
        L16:
            StaticLayout r108 = r107.build();
        L23:
            if (((r108.getLineCount() * r100.getLineHeight()) + ((r108.getLineCount() - 1) * r100.getLineSpacingExtra())) <= r100.getMaxHeight()) goto L25;
            VoiceImeWrapperUseCase r109 = this.f430499a;
            r109.e(r109.f430480b.f().getHeight(), true, true);
            return;
        L25:
            VoiceImeWrapperUseCase r111 = this.f430499a;
            VoiceImeWrapperUseCase.f(r111, r111.f430480b.f().getHeight(), false, 4);
            return;
        L14:
            if (r100.getKeyListener() == null) goto L16;
            r107.setEllipsize(r100.getEllipsize());
            r107.setEllipsizedWidth(r103);
            goto L16
        L7:
            r106 = 0;
            goto L8
        L17:
            VoiceImeWrapperUseCase r112 = this.f430499a;
            int r113 = r100.getWidth();
            r112.getClass();
            CharSequence r114 = r100.getText();
            CharSequence r115 = r100.getText();
            if (r115 == null) goto L20;
            int r116 = r115.length();
        L21:
            r108 = new StaticLayout(r114, 0, r116, r100.getPaint(), r113, Layout.Alignment.ALIGN_NORMAL, r100.getLineSpacingMultiplier(), r100.getLineSpacingExtra(), r100.getIncludeFontPadding(), r100.getEllipsize(), r113);
            goto L23
        L20:
            r116 = 0;
            goto L21
        }
    }

    static {
    }

    public final ImmersiveVoiceViewModel a() {
        return (ImmersiveVoiceViewModel) this.f430491m.getValue();
    }

    public final List<ValueAnimator> b() {
        return (List) this.f430482d.getValue();
    }

    public final void d() {
        Log.d("VoiceImeWrapperUseCase", "clearAllAnimations");
        Iterator<T> r100 = b().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ValueAnimator) r100.next()).cancel();
        goto L4
    L6:
        b().clear();
        this.f430479a.H(this.f430492n);
        if (KeyboardVoiceFGUtils.d() == false) goto L9;
        ExtensionImeKt.b(this.f430479a, this.f430494p);
        return;
    L9:
        ExtensionImeKt.b(this.f430479a, this.f430493o);
    }

    public final boolean c() {
        List<ValueAnimator> r100 = b();
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((ValueAnimator) r101.next()).isRunning() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    public final void e(int r110, boolean r111, boolean r112) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r100 = this.f430480b;
        int r101 = r100.f430225b.getHeight();
        int r102 = (((((Number) this.f430487i.getValue()).intValue() * 2) + ((Number) this.f430490l.getValue()).intValue()) + StatusBarUtil.getStatusBarHeight(r100.d().getContext())) + y9c.d.a(44);
        Integer r103 = Integer.valueOf(r100.m().getHeight());
        boolean r104 = true;
        int r105 = 0;
        if (r103.intValue() <= 0) goto L5;
        boolean r106 = true;
    L6:
        ViewGroup.MarginLayoutParams r107 = null;
        if (r106 == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L12;
        int r108 = r103.intValue();
    L13:
        Integer r109 = Integer.valueOf(r100.d().getHeight());
        if (r109.intValue() > 0) goto L17;
        r104 = false;
    L17:
        if (r104 == true) goto L20;
        r109 = null;
    L20:
        if (r109 == null) goto L22;
        int r113 = r109.intValue();
    L23:
        int r114 = ((r108 + r100.b().getHeight()) + r113) + r100.r().getHeight();
        ViewGroup.LayoutParams r115 = r100.d().getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
    L27:
        if (r116 == null) goto L29;
        int r117 = r116.topMargin;
    L30:
        ViewGroup.LayoutParams r118 = r100.d().getLayoutParams();
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
    L34:
        if (r119 == null) goto L36;
        int r120 = r119.bottomMargin;
    L37:
        int r121 = r117 + r120;
        ViewGroup.LayoutParams r122 = r100.m().getLayoutParams();
        if ((r122 instanceof ViewGroup.MarginLayoutParams) == false) goto L40;
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
    L41:
        if (r123 == null) goto L43;
        int r124 = r123.bottomMargin;
    L44:
        int r125 = r121 + r124;
        ViewGroup.LayoutParams r126 = r100.m().getLayoutParams();
        if ((r126 instanceof ViewGroup.MarginLayoutParams) == false) goto L47;
        r107 = (ViewGroup.MarginLayoutParams) r126;
    L47:
        if (r107 == null) goto L49;
        r105 = r107.topMargin;
    L49:
        int r127 = r125 + r105;
        if (r110 > 0) goto L52;
    L54:
        int r128 = ((r101 - (((this.f430489k + ((Number) this.f430487i.getValue()).intValue()) + ((Number) this.f430488j.getValue()).intValue()) + (((Number) this.f430486h.getValue()).intValue() * 2))) - r114) - r102;
    L55:
        int r129 = r128 - r127;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r130 = this.f430480b;
        r130.a().setMaxHeight(r129);
        ConstraintSet r131 = new ConstraintSet();
        r131.clone(r130.o());
        if (r111 == false) goto L61;
        int r132 = Math.max(r130.a().getMinHeight(), r129);
        if (r130.a().getHeight() > r132) goto L60;
        if (r112 == true) goto L60;
        return;
    L60:
        r131.constrainHeight(r130.a().getId(), r132);
        r131.applyTo(r130.o());
        return;
    L61:
        r131.constrainHeight(r130.a().getId(), -2);
        r131.applyTo(r130.o());
        return;
    L52:
        if (Intrinsics.areEqual(a().isKeyboardShowing().getValue(), Boolean.TRUE) == false) goto L54;
        r128 = (((r101 - (((((Number) this.f430486h.getValue()).intValue() * 2) + ((Number) this.f430487i.getValue()).intValue()) + ((Number) this.f430488j.getValue()).intValue())) - r114) - r102) - r110;
        goto L55
    L43:
        r124 = 0;
        goto L44
    L40:
        r123 = null;
        goto L41
    L36:
        r120 = 0;
        goto L37
    L33:
        r119 = null;
        goto L34
    L29:
        r117 = 0;
        goto L30
    L26:
        r116 = null;
        goto L27
    L22:
        r113 = r100.d().getLayoutParams().height;
        goto L23
    L12:
        r108 = r100.m().getDrawable().getIntrinsicHeight();
        goto L13
    L5:
        r106 = false;
        goto L6
    }

    public VoiceImeWrapperUseCase(ConstraintLayout r100, ImeWrapper r101, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r102, Fragment r103) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "imeWrapper");
        Intrinsics.checkNotNullParameter(r102, "viewFinder");
        this.f430479a = r101;
        this.f430480b = r102;
        this.f430481c = r103;
        this.f430482d = LazyKt.lazy(VoiceImeWrapperUseCase$runningAnimators$2.INSTANCE);
        this.f430483e = new ImeWrapperMotionScene(r100);
        Lazy r104 = LazyKt.lazy(VoiceImeWrapperUseCase$distBubbleWithSend$2.INSTANCE);
        this.f430484f = r104;
        Lazy r105 = LazyKt.lazy(VoiceImeWrapperUseCase$bottomMarginCancel$2.INSTANCE);
        this.f430485g = r105;
        this.f430486h = LazyKt.lazy(VoiceImeWrapperUseCase$dp8$2.INSTANCE);
        this.f430487i = LazyKt.lazy(VoiceImeWrapperUseCase$dp16$2.INSTANCE);
        this.f430488j = LazyKt.lazy(VoiceImeWrapperUseCase$dp18$2.INSTANCE);
        this.f430489k = ((Number) r105.getValue()).intValue() + ((Number) r104.getValue()).intValue();
        this.f430490l = LazyKt.lazy(new VoiceImeWrapperUseCase$navigationBarHeight$2(this));
        this.f430491m = LazyKt.lazy(new VoiceImeWrapperUseCase$immersiveVoiceViewModel$2(this));
        e r106 = new e(this);
        this.f430492n = r106;
        c r107 = new c(this);
        this.f430493o = r107;
        d r108 = new d(this);
        this.f430494p = r108;
        r101.l(r106);
        if (KeyboardVoiceFGUtils.d() == false) goto L5;
        ExtensionImeKt.a(r101, r108);
    L6:
        r101.setFocusDelegate(new VoiceImeWrapperUseCase$1$1(this));
        r101.setAnimationEnable(true);
        a().injectIGetEditTextAndSelectionDependency(new a(this));
        r102.a().addTextChangedListener(new f(this));
        Context r109 = r100.getContext();
        LifecycleOwner r110 = r103;
        if (r103 != null) goto L10;
        Intrinsics.checkNotNull(r109);
        ComponentCallbacks2 r111 = ContextsKt.findActivity(r109);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        r110 = (LifecycleOwner) r111;
    L10:
        a().getAsrResultFocused().observe(r110, new l0(this));
        return;
    L5:
        ExtensionImeKt.a(r101, r107);
        goto L6
    }

    public static /* synthetic */ void f(VoiceImeWrapperUseCase r100, int r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = false;
    L8:
        r100.e(r101, r102, false);
    }
}
