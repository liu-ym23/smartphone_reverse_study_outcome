package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bM\u0010NR\"\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010+\u001a\u00020&8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102RT\u0010B\u001a4\u0012\u0013\u0012\u001105¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0013\u0012\u001109¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020;\u0018\u0001048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0017\u0010H\u001a\u00020C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G¨\u0006O"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/MvLyricViewV2;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/CommonLyricDisplayView;", "Lcom/bytedance/android/live/ktv/common/util/c;", "", "F", "getMiddleBaseShowPaint", "()F", "setMiddleBaseShowPaint", "(F)V", "middleBaseShowPaint", "G", "getMiddleBaseOtherPaint", "setMiddleBaseOtherPaint", "middleBaseOtherPaint", "H", "getMiddleBaseDynamicPaint", "setMiddleBaseDynamicPaint", "middleBaseDynamicPaint", "Landroid/animation/ValueAnimator;", "I", "Landroid/animation/ValueAnimator;", "getAlphaHide", "()Landroid/animation/ValueAnimator;", "setAlphaHide", "(Landroid/animation/ValueAnimator;)V", "alphaHide", "J", "getAlphaShow", "setAlphaShow", "alphaShow", "Landroid/animation/AnimatorSet;", "K", "Landroid/animation/AnimatorSet;", "getAlphaAnimSet", "()Landroid/animation/AnimatorSet;", "setAlphaAnimSet", "(Landroid/animation/AnimatorSet;)V", "alphaAnimSet", "Landroid/graphics/RectF;", "M", "Landroid/graphics/RectF;", "getLastDynamicRectF", "()Landroid/graphics/RectF;", "lastDynamicRectF", "", "N", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isTimeOut", "", "timeStamp", "", "O", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "Lig4/d;", "Q", "Lig4/d;", "getAlignController", "()Lig4/d;", "alignController", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MvLyricViewV2 extends CommonLyricDisplayView implements com.bytedance.android.live.ktv.common.util.c {
    public float F;
    public float G;
    public float H;
    public ValueAnimator I;
    public ValueAnimator J;
    public AnimatorSet K;
    public Paint L;
    public final RectF M;
    public String N;
    public Function2<? super Boolean, ? super Long, Unit> O;
    public final int P;
    public final ig4.d Q;
    public Boolean R;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ MvLyricViewV2 a;
        public final /* synthetic */ int b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAnimating(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAnimating(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            this.a.setAnimating(true);
            if ((this.b % 2) == 0) goto L5;
        L11:
            this.a.setCurShowIndex(this.b);
            if (this.a.getCountDownEnable() == false) goto L14;
            this.a.getDynamicRectF().left = 0.0f;
            this.a.getDynamicRectF().right = 0.0f;
        L14:
            this.a.invalidate();
            return;
        L5:
            if (this.a.getCountDownEnable() == false) goto L11;
            if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.a.getLyricsLineInfos(), this.b)).i == false) goto L11;
            if (this.a.getLyricsLineInfos().size() <= (this.b + 1)) goto L11;
            ArrayList<com.bytedance.component.lyric.model.b> r5 = this.a.getLyricsLineInfos();
            int r1 = this.b + 1;
            com.bytedance.component.lyric.model.b r2 = new com.bytedance.component.lyric.model.b();
            r2.a = 1;
            Unit r0 = Unit.INSTANCE;
            ListProtector.add(r5, r1, r2);
            goto L11
        }

        public a(MvLyricViewV2 r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ MvLyricViewV2 a;

        public b(MvLyricViewV2 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAnimatingHide(false);
            MvLyricViewV2 r3 = this.a;
            if (r3.s == true) goto L6;
            r3.invalidate();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAnimatingHide(true);
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ MvLyricViewV2 a;

        public c(MvLyricViewV2 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAnimating(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAnimating(false);
            this.a.invalidate();
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void b(List<com.bytedance.component.lyric.model.b> r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void release() {
        this.R = null;
        super.release();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void onConfigComplete() {
        LyricsDisplayConfig r0 = getConfig();
        ig4.d r1 = this.Q;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.h = r1;
        this.F = a(getConfig().k.getFontMetrics());
        this.G = a(getConfig().i.getFontMetrics());
        this.H = a(getConfig().l.getFontMetrics());
    }

    public final ig4.d getAlignController() {
        return this.Q;
    }

    public final AnimatorSet getAlphaAnimSet() {
        return this.K;
    }

    public final ValueAnimator getAlphaHide() {
        return this.I;
    }

    public final ValueAnimator getAlphaShow() {
        return this.J;
    }

    public final RectF getLastDynamicRectF() {
        return this.M;
    }

    public final float getMiddleBaseDynamicPaint() {
        return this.H;
    }

    public final float getMiddleBaseOtherPaint() {
        return this.G;
    }

    public final float getMiddleBaseShowPaint() {
        return this.F;
    }

    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.O;
    }

    public String getTypeName() {
        return this.N;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void c(long r3) {
        ig4.d r0 = this.Q;
        r0.g = getCurShowIndex();
        super.c(r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void h(int r7) {
        AnimatorSet r0 = this.K;
        if (r0 != null) goto L5;
    L19:
        this.K = new AnimatorSet();
        int r1 = getConfig().i.getAlpha();
        AnimatorSet r2 = this.K;
        if (r2 == null) goto L22;
        r2.addListener(new a(this, r7));
    L22:
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{r1, 0});
        r3.setDuration(250);
        r3.addUpdateListener(new f(this));
        this.I = r3;
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{0, 255});
        r4.setDuration(250);
        r4.addUpdateListener(new f(this));
        this.J = r4;
        c r5 = new c(this);
        AnimatorSet r6 = this.K;
        if (r6 == null) goto L25;
        r6.addListener(r5);
    L25:
        ValueAnimator r8 = this.I;
        if (r8 == null) goto L28;
        r8.addListener(new b(this));
    L28:
        AnimatorSet r9 = this.K;
        if (r9 == null) goto L31;
        r9.playSequentially(new Animator[]{this.I, this.J});
    L31:
        AnimatorSet r10 = this.K;
        if (r10 == null) goto L34;
        r10.setDuration(500);
    L34:
        AnimatorSet r11 = this.K;
        if (r11 == null) goto L38;
        r11.start();
        return;
    L38:
        return;
    L5:
        if (r0.isRunning() != true) goto L19;
        AnimatorSet r12 = this.K;
        if (r12 == null) goto L9;
        r12.cancel();
    L9:
        AnimatorSet r13 = this.K;
        if (r13 == null) goto L12;
        r13.removeAllListeners();
    L12:
        ValueAnimator r14 = this.J;
        if (r14 == null) goto L15;
        r14.removeAllUpdateListeners();
    L15:
        ValueAnimator r15 = this.I;
        if (r15 == null) goto L18;
        r15.removeAllUpdateListeners();
    L18:
        getConfig().i.setAlpha(255);
        goto L19
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        if (getCurShowIndex() < getLyricsLineInfos().size()) goto L5;
        return;
    L5:
        if (getCurShowIndex() < 0) goto L47;
        Function2<Boolean, Long, Unit> r0 = getOneDrawCallback();
        if (r0 == null) goto L11;
        Unit r1 = (Unit) r0.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
    L11:
        if (this.q == false) goto L13;
    L18:
        getConfig().i.clearShadowLayer();
    L19:
        int r2 = getCurShowIndex();
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r2)).i == true) goto L22;
    L40:
        i(r6, r2, getLyricsLineInfos(), true);
        if (this.q == false) goto L43;
        int r3 = r2 - 1;
    L44:
        i(r6, r3, getLyricsLineInfos(), false);
        return;
    L43:
        r3 = r2 + 1;
        goto L44
    L22:
        if (Intrinsics.areEqual(this.R, Boolean.FALSE) == false) goto L24;
        return;
    L24:
        int r4 = r2 + 1;
        if (r4 >= getLyricsLineInfos().size()) goto L32;
        com.bytedance.component.lyric.model.b r5 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r4);
        if (getCountDownEnable() == false) goto L31;
        int r7 = com.bytedance.component.lyric.model.b.o;
        if (com.bytedance.component.lyric.model.b.a.a(r5) == false) goto L31;
        r4 = r2 + 2;
        com.bytedance.component.lyric.model.b r8 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r4);
    L31:
        Integer r9 = Integer.valueOf(r4);
    L33:
        if (r9 == null) goto L40;
        int r10 = r9.intValue();
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r10)).j == false) goto L40;
        if (Intrinsics.areEqual(this.R, Boolean.TRUE) == false) goto L40;
        i(r6, r10, getLyricsLineInfos(), false);
        return;
    L32:
        r9 = null;
        goto L33
    L13:
        if (getConfig().i.getAlpha() < 10) goto L18;
        Function1 r11 = getConfig().p;
        if (r11 == null) goto L19;
        Unit r12 = (Unit) r11.invoke(getConfig().i);
        goto L19
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void renderLyricsByPlayTime(long r8) {
        setCurrMusicProcess(r8);
        int r0 = e(r8);
        setLastMusicProcess(r8);
        if (getCurShowIndex() == r0) goto L6;
        h(r0);
        return;
    L6:
        if (this.p == true) goto L11;
        if (getDrawOptEnable() == true) goto L11;
        invalidate();
        return;
    L11:
        if ((!Intrinsics.areEqual(getDynamicRectF(), this.M)) == false) goto L13;
        this.M.set(getDynamicRectF());
        invalidate();
        return;
    L13:
        com.bytedance.component.lyric.model.b r9 = (com.bytedance.component.lyric.model.b) KtvUtilsKt.K(getLyricsLineInfos(), getCurShowIndex());
        if (r9 == null) goto L66;
        Boolean r1 = this.R;
        Integer r2 = null;
        if (r9.i == false) goto L59;
        Integer r10 = r9.l;
        boolean r3 = false;
        if (r10 != null) goto L21;
    L31:
        int r11 = getCurShowIndex();
        int r4 = r11 + 1;
        if (r4 >= getLyricsLineInfos().size()) goto L39;
        com.bytedance.component.lyric.model.b r5 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r4);
        if (getCountDownEnable() == false) goto L38;
        int r6 = com.bytedance.component.lyric.model.b.o;
        if (com.bytedance.component.lyric.model.b.a.a(r5) == false) goto L38;
        r4 = r11 + 2;
        r5 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r4);
    L38:
        Pair r12 = new Pair(Integer.valueOf(r4), r5);
    L40:
        if (r12 == null) goto L57;
        com.bytedance.component.lyric.model.b r13 = (com.bytedance.component.lyric.model.b) r12.getSecond();
        if (r13 == null) goto L57;
        if (r13.j == false) goto L57;
        Integer r14 = r13.k;
        if (r14 == null) goto L57;
        if (r14.intValue() <= 0) goto L50;
        r3 = true;
    L50:
        if (r3 == false) goto L52;
        r2 = r14;
    L52:
        if (r2 == null) goto L57;
        if (getCurrMusicProcess() <= r2.intValue()) goto L57;
        r1 = Boolean.TRUE;
    L57:
        if ((!Intrinsics.areEqual(this.R, r1)) == false) goto L64;
        this.R = r1;
        invalidate();
        return;
    L64:
        return;
    L39:
        r12 = null;
        goto L40
    L21:
        if (r10.intValue() <= 0) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == true) goto L27;
        r10 = null;
    L27:
        if (r10 == null) goto L31;
        if (getCurrMusicProcess() <= r10.intValue()) goto L31;
        r1 = Boolean.FALSE;
        goto L31
    L23:
        r7 = false;
        goto L24
    L59:
        this.R = null;
        return;
    }

    public final void setAlphaAnimSet(AnimatorSet r1) {
        this.K = r1;
    }

    public final void setAlphaHide(ValueAnimator r1) {
        this.I = r1;
    }

    public final void setAlphaShow(ValueAnimator r1) {
        this.J = r1;
    }

    public final void setMiddleBaseDynamicPaint(float r1) {
        this.H = r1;
    }

    public final void setMiddleBaseOtherPaint(float r1) {
        this.G = r1;
    }

    public final void setMiddleBaseShowPaint(float r1) {
        this.F = r1;
    }

    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.O = r1;
    }

    public void setTypeName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.N = r2;
    }

    public MvLyricViewV2(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 4, 0);
        this.L = getConfig().k;
        this.M = new RectF();
        this.N = "lyric";
        this.P = h.s();
        this.Q = new ig4.d();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void addLyrics(List<com.bytedance.component.lyric.model.b> r6, long r7) {
        super.addLyrics(r6, r7);
        Iterator<T> r8 = getLyricsLineInfos().iterator();
        int r9 = 0;
        int r10 = 0;
    L3:
        boolean r1 = true;
        if (r8.hasNext() == false) goto L28;
        com.bytedance.component.lyric.model.b r0 = (com.bytedance.component.lyric.model.b) r8.next();
        int r2 = r10 - 1;
        if (r2 <= 5) goto L27;
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r10)).b - ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r2)).c) <= this.P) goto L27;
        com.bytedance.component.lyric.model.b r3 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r2);
        r3.i = true;
        Integer r4 = Integer.valueOf(r3.c);
        if (r4.intValue() <= 0) goto L12;
        boolean r5 = true;
    L13:
        Integer r11 = null;
        if (r5 == true) goto L17;
        r4 = null;
    L17:
        if (r4 == null) goto L19;
        r3.l = Integer.valueOf(r4.intValue() + 1000);
    L19:
        com.bytedance.component.lyric.model.b r12 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r10);
        r12.j = true;
        Integer r13 = Integer.valueOf(r12.b);
        if (r13.intValue() > 0) goto L23;
        r1 = false;
    L23:
        if (r1 == false) goto L25;
        r11 = r13;
    L25:
        if (r11 == null) goto L27;
        r12.k = Integer.valueOf(r11.intValue() - 3000);
        goto L27
    L12:
        r5 = false;
    L27:
        r10 = r10 + 1;
        goto L3
    L28:
        com.bytedance.component.lyric.model.b r14 = (com.bytedance.component.lyric.model.b) CollectionsKt.lastOrNull(getLyricsLineInfos());
        if (r14 == null) goto L38;
        r14.i = true;
        int[] r15 = r14.g;
        if (r15 == null) goto L36;
        int r16 = r15.length;
        int r17 = 0;
    L33:
        if (r9 >= r16) goto L35;
        r17 = r17 + r15[r9];
        r9 = r9 + 1;
        goto L33
    L35:
        r9 = r17;
    L36:
        if (r9 <= 0) goto L38;
        r14.m = Integer.valueOf(r14.b + r9);
        r14.l = Integer.valueOf((r9 + r14.b) + 1000);
    L38:
        invalidate();
    }

    public final void i(Canvas r8, int r9, ArrayList<com.bytedance.component.lyric.model.b> r10, boolean r11) {
        if (r9 >= r10.size()) goto L32;
        if (r9 < 0) goto L35;
        String r12 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r10, r9)).d;
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        if (r11 == false) goto L11;
        float r0 = this.F;
        Paint r1 = getConfig().k;
    L12:
        this.L = r1;
        int r13 = r9 % 2;
        if (r13 != 0) goto L15;
        r1.setTextAlign(Paint.Align.LEFT);
        r8.drawText(r12, 0.0f, (r8.getHeight() / 4.0f) + r0, r1);
    L16:
        if (r11 == true) goto L18;
        return;
    L18:
        if (getConfig().n != 3) goto L34;
        r8.save();
        r8.clipRect(getDynamicRectF());
        if (getConfig().o == false) goto L22;
        this.L.setStrokeWidth(UtilityKotlinExtentionsKt.h(2.0f));
    L23:
        if (r13 != 0) goto L25;
        Paint r14 = this.L;
        r14.setTextAlign(Paint.Align.LEFT);
        r8.drawText(r12, 0.0f, (r8.getHeight() / 4.0f) + r0, r14);
    L26:
        this.L.setStrokeWidth(0.0f);
        if (r13 != 0) goto L29;
        Paint r15 = getConfig().l;
        float r16 = this.H;
        r15.setTextAlign(Paint.Align.LEFT);
        r8.drawText(r12, 0.0f, (r8.getHeight() / 4.0f) + r16, r15);
    L30:
        r8.restore();
        return;
    L29:
        Paint r17 = getConfig().l;
        float r18 = this.H;
        r17.setTextAlign(Paint.Align.RIGHT);
        r8.drawText(r12, r8.getWidth(), ((r8.getHeight() / 4) * 3.0f) + r18, r17);
        goto L30
    L25:
        Paint r19 = this.L;
        r19.setTextAlign(Paint.Align.RIGHT);
        r8.drawText(r12, r8.getWidth(), ((r8.getHeight() / 4) * 3.0f) + r0, r19);
        goto L26
    L22:
        this.L.setStrokeWidth(0.0f);
        goto L23
    L34:
        return;
    L15:
        r1.setTextAlign(Paint.Align.RIGHT);
        r8.drawText(r12, r8.getWidth(), ((r8.getHeight() / 4) * 3.0f) + r0, r1);
        goto L16
    L11:
        r0 = this.G;
        r1 = getConfig().i;
        goto L12
    L35:
        return;
    }
}
