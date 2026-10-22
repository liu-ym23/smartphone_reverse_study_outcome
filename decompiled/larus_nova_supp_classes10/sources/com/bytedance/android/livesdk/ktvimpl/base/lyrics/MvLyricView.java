package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bL\u0010MR\"\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0019\u001a\u00020\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018RT\u0010(\u001a4\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010-\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010,R\u0017\u00103\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R$\u0010;\u001a\u0004\u0018\u0001048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010?\u001a\u0004\u0018\u0001048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b<\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R$\u0010G\u001a\u0004\u0018\u00010@8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/MvLyricView;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/CommonLyricDisplayView;", "Lcom/bytedance/android/live/ktv/common/util/c;", "", "F", "getMiddleBaseShowPaint", "()F", "setMiddleBaseShowPaint", "(F)V", "middleBaseShowPaint", "G", "getMiddleBaseOtherPaint", "setMiddleBaseOtherPaint", "middleBaseOtherPaint", "H", "getMiddleBaseDynamicPaint", "setMiddleBaseDynamicPaint", "middleBaseDynamicPaint", "", "I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isTimeOut", "", "timeStamp", "", "J", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "", "K", "getInterlude_gap", "()I", "interlude_gap", "Lig4/d;", "M", "Lig4/d;", "getAlignController", "()Lig4/d;", "alignController", "Landroid/animation/ValueAnimator;", "N", "Landroid/animation/ValueAnimator;", "getAlphaHide", "()Landroid/animation/ValueAnimator;", "setAlphaHide", "(Landroid/animation/ValueAnimator;)V", "alphaHide", "O", "getAlphaShow", "setAlphaShow", "alphaShow", "Landroid/animation/AnimatorSet;", "P", "Landroid/animation/AnimatorSet;", "getAlphaAnimSet", "()Landroid/animation/AnimatorSet;", "setAlphaAnimSet", "(Landroid/animation/AnimatorSet;)V", "alphaAnimSet", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MvLyricView extends CommonLyricDisplayView implements com.bytedance.android.live.ktv.common.util.c {
    public float F;
    public float G;
    public float H;
    public String I;
    public Function2<? super Boolean, ? super Long, Unit> J;
    public final int K;
    public Paint L;
    public final ig4.d M;
    public ValueAnimator N;
    public ValueAnimator O;
    public AnimatorSet P;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ MvLyricView a;
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

        public a(MvLyricView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ MvLyricView a;

        public b(MvLyricView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAnimatingHide(false);
            this.a.invalidate();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAnimatingHide(true);
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ MvLyricView a;

        public c(MvLyricView r1) {
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
    public final void onConfigComplete() {
        LyricsDisplayConfig r0 = getConfig();
        ig4.d r1 = this.M;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.h = r1;
        this.F = a(getConfig().k.getFontMetrics());
        this.G = a(getConfig().i.getFontMetrics());
        this.H = a(getConfig().l.getFontMetrics());
    }

    public final ig4.d getAlignController() {
        return this.M;
    }

    public final AnimatorSet getAlphaAnimSet() {
        return this.P;
    }

    public final ValueAnimator getAlphaHide() {
        return this.N;
    }

    public final ValueAnimator getAlphaShow() {
        return this.O;
    }

    public final int getInterlude_gap() {
        return this.K;
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
        return this.J;
    }

    public String getTypeName() {
        return this.I;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void c(long r3) {
        ig4.d r0 = this.M;
        r0.g = getCurShowIndex();
        super.c(r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void h(int r7) {
        AnimatorSet r0 = this.P;
        if (r0 != null) goto L5;
    L19:
        this.P = new AnimatorSet();
        int r1 = getConfig().i.getAlpha();
        AnimatorSet r2 = this.P;
        if (r2 == null) goto L22;
        r2.addListener(new a(this, r7));
    L22:
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{r1, 0});
        r3.setDuration(250);
        r3.addUpdateListener(new e(this));
        this.N = r3;
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{0, 255});
        r4.setDuration(250);
        r4.addUpdateListener(new e(this));
        this.O = r4;
        c r5 = new c(this);
        AnimatorSet r6 = this.P;
        if (r6 == null) goto L25;
        r6.addListener(r5);
    L25:
        ValueAnimator r8 = this.N;
        if (r8 == null) goto L28;
        r8.addListener(new b(this));
    L28:
        AnimatorSet r9 = this.P;
        if (r9 == null) goto L31;
        r9.playSequentially(new Animator[]{this.N, this.O});
    L31:
        AnimatorSet r10 = this.P;
        if (r10 == null) goto L34;
        r10.setDuration(500);
    L34:
        AnimatorSet r11 = this.P;
        if (r11 == null) goto L38;
        r11.start();
        return;
    L38:
        return;
    L5:
        if (r0.isRunning() != true) goto L19;
        AnimatorSet r12 = this.P;
        if (r12 == null) goto L9;
        r12.cancel();
    L9:
        AnimatorSet r13 = this.P;
        if (r13 == null) goto L12;
        r13.removeAllListeners();
    L12:
        ValueAnimator r14 = this.O;
        if (r14 == null) goto L15;
        r14.removeAllUpdateListeners();
    L15:
        ValueAnimator r15 = this.N;
        if (r15 == null) goto L18;
        r15.removeAllUpdateListeners();
    L18:
        getConfig().i.setAlpha(255);
        goto L19
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (getCurShowIndex() < getLyricsLineInfos().size()) goto L5;
        return;
    L5:
        if (getCurShowIndex() < 0) goto L59;
        Function2<Boolean, Long, Unit> r0 = getOneDrawCallback();
        if (r0 == null) goto L11;
        Unit r1 = (Unit) r0.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
    L11:
        if (this.q == false) goto L13;
    L18:
        getConfig().i.clearShadowLayer();
    L20:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).i == true) goto L22;
    L43:
        i(r10, getCurShowIndex(), getLyricsLineInfos(), true);
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).i == false) goto L49;
        if (getCurrMusicProcess() < (((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).c + 1000)) goto L57;
        getConfig().i.setAlpha(255);
        i(r10, getCurShowIndex() + 1, getLyricsLineInfos(), false);
        return;
    L57:
        return;
    L49:
        if (this.q == false) goto L51;
        int r2 = getCurShowIndex() - 1;
    L52:
        i(r10, r2, getLyricsLineInfos(), false);
        return;
    L51:
        r2 = getCurShowIndex() + 1;
        goto L52
    L22:
        if (getLyricsLineInfos().size() > 0) goto L24;
    L29:
        int r3 = ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).c;
    L31:
        if ((getCurrMusicProcess() - ((long) r3)) <= 1000) goto L43;
        int r4 = getCurShowIndex() + 1;
        if (r4 >= getLyricsLineInfos().size()) goto L54;
        com.bytedance.component.lyric.model.b r5 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r4);
        if (getCountDownEnable() == false) goto L40;
        int r6 = com.bytedance.component.lyric.model.b.o;
        if (com.bytedance.component.lyric.model.b.a.a(r5) == false) goto L40;
        r4 = getCurShowIndex() + 2;
        r5 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r4);
    L40:
        if (r5.b >= (getCurrMusicProcess() + ((long) 3000))) goto L55;
        i(r10, r4, getLyricsLineInfos(), false);
        return;
    L55:
        return;
    L54:
        return;
    L24:
        if (getCurShowIndex() < (getLyricsLineInfos().size() - 1)) goto L29;
        Integer r7 = ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).m;
        if (r7 == null) goto L28;
        r3 = r7.intValue();
        goto L31
    L28:
        r3 = ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex())).c;
        goto L31
    L13:
        if (getConfig().i.getAlpha() < 10) goto L18;
        Function1 r8 = getConfig().p;
        if (r8 == null) goto L20;
        Unit r9 = (Unit) r8.invoke(getConfig().i);
        goto L20
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void renderLyricsByPlayTime(long r2) {
        setCurrMusicProcess(r2);
        int r0 = e(r2);
        setLastMusicProcess(r2);
        if (getCurShowIndex() == r0) goto L6;
        h(r0);
        return;
    L6:
        if (this.p == true) goto L10;
        invalidate();
        return;
    }

    public final void setAlphaAnimSet(AnimatorSet r1) {
        this.P = r1;
    }

    public final void setAlphaHide(ValueAnimator r1) {
        this.N = r1;
    }

    public final void setAlphaShow(ValueAnimator r1) {
        this.O = r1;
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
        this.J = r1;
    }

    public void setTypeName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.I = r2;
    }

    public MvLyricView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 4, 0);
        this.I = "lyric";
        this.K = h.s();
        this.L = getConfig().k;
        this.M = new ig4.d();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void addLyrics(List<com.bytedance.component.lyric.model.b> r5, long r6) {
        super.addLyrics(r5, r6);
        Iterator<T> r7 = getLyricsLineInfos().iterator();
        int r8 = 0;
        int r9 = 0;
    L4:
        if (r7.hasNext() == false) goto L11;
        com.bytedance.component.lyric.model.b r0 = (com.bytedance.component.lyric.model.b) r7.next();
        int r1 = r9 - 1;
        if (r1 <= 5) goto L10;
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r9)).b - ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r1)).c) <= this.K) goto L10;
        ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r1)).i = true;
        ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), r9)).j = true;
    L10:
        r9 = r9 + 1;
        goto L4
    L11:
        com.bytedance.component.lyric.model.b r10 = (com.bytedance.component.lyric.model.b) CollectionsKt.lastOrNull(getLyricsLineInfos());
        if (r10 == null) goto L27;
        r10.i = true;
        int[] r11 = r10.g;
        if (r11 == null) goto L19;
        int r2 = r11.length;
        int r3 = 0;
    L16:
        if (r8 >= r2) goto L18;
        r3 = r3 + r11[r8];
        r8 = r8 + 1;
        goto L16
    L18:
        r8 = r3;
    L19:
        if (r8 <= 0) goto L28;
        r10.m = Integer.valueOf(r8 + r10.b);
        return;
    L28:
        return;
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
