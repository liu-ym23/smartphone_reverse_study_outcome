package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\r8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvSingAndListenerLyricViewV2;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvSingAndListenerLyricView;", "", "visibility", "", "setVisibility", "F", "I", "getPenddingLine", "()I", "setPenddingLine", "(I)V", "penddingLine", "Landroid/graphics/RectF;", "H", "Landroid/graphics/RectF;", "getLastDynamicRectF", "()Landroid/graphics/RectF;", "lastDynamicRectF", "", "value", "M", "Z", "getForbidPendingLine", "()Z", "setForbidPendingLine", "(Z)V", "forbidPendingLine", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvSingAndListenerLyricViewV2 extends KtvSingAndListenerLyricView {
    public int F;
    public final int G;
    public final RectF H;
    public boolean I;
    public boolean J;
    public final int K;
    public final List<a> L;
    public boolean M;

    public interface a {
        void a(long r1);
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ KtvSingAndListenerLyricViewV2 a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ Ref.IntRef c;

        public b(KtvSingAndListenerLyricViewV2 r1, Ref.IntRef r2, Ref.IntRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r6) {
            Intrinsics.checkNotNullParameter(r6, "it");
            this.a.setInScroll(true);
            Ref.IntRef r0 = this.b;
            Object r7 = r6.getAnimatedValue();
            if (r7 == null) goto L12;
            r0.element = ((Integer) r7).intValue();
            Ref.IntRef r8 = this.c;
            int r1 = r8.element;
            Ref.IntRef r2 = this.b;
            int r3 = r2.element;
            if (r1 == r3) goto L13;
            KtvSingAndListenerLyricViewV2 r4 = this.a;
            if (r3 <= (r1 + r4.G)) goto L14;
            r8.element = r3;
            r4.setAnimationY(r2.element);
            this.a.invalidate();
            return;
        L14:
            return;
        L13:
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ KtvSingAndListenerLyricViewV2 a;
        public final /* synthetic */ int b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setInScroll(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.a.setAnimationY(0);
            this.a.setAnimating(false);
            this.a.setCurShowIndex(this.b);
            this.a.setInScroll(false);
            this.a.getDynamicRectF().left = 0.0f;
            this.a.invalidate();
        }

        public c(KtvSingAndListenerLyricViewV2 r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final boolean getForbidPendingLine() {
        return this.M;
    }

    public final RectF getLastDynamicRectF() {
        return this.H;
    }

    public final int getPenddingLine() {
        return this.F;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView
    public final void h(int r7) {
        ValueAnimator r0 = getScrollAnimator();
        if (r0 != null) goto L5;
    L16:
        setAnimating(true);
        Ref.IntRef r1 = new Ref.IntRef();
        r1.element = -1;
        Ref.IntRef r3 = new Ref.IntRef();
        r3.element = 0;
        setScrollAnimator(ValueAnimator.ofInt(new int[]{0, getLyricsRect().height()}));
        ValueAnimator r2 = getScrollAnimator();
        if (r2 == null) goto L19;
        r2.setDuration(230);
    L19:
        ValueAnimator r4 = getScrollAnimator();
        if (r4 == null) goto L22;
        r4.addUpdateListener(new b(this, r3, r1));
    L22:
        ValueAnimator r5 = getScrollAnimator();
        if (r5 == null) goto L25;
        r5.addListener(new c(this, r7));
    L25:
        ValueAnimator r8 = getScrollAnimator();
        if (r8 == null) goto L29;
        r8.start();
        return;
    L29:
        return;
    L5:
        if (r0.isRunning() != true) goto L16;
        ValueAnimator r6 = getScrollAnimator();
        if (r6 == null) goto L9;
        r6.cancel();
    L9:
        ValueAnimator r9 = getScrollAnimator();
        if (r9 == null) goto L12;
        r9.removeAllUpdateListeners();
    L12:
        ValueAnimator r10 = getScrollAnimator();
        if (r10 == null) goto L15;
        r10.removeAllListeners();
    L15:
        setAnimationY(0);
        goto L16
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, android.view.View
    public final void onDraw(Canvas r15) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        if (getCurrMusicProcess() >= 0) goto L6;
        return;
    L6:
        if (getCurShowIndex() < getLyricsLineInfos().size()) goto L8;
        com.bytedance.component.lyric.model.b r0 = null;
    L9:
        if (r0 == null) goto L58;
        String r1 = r0.d;
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        getLyricsRect().set(f(r1));
        ig4.c r2 = getConfig().h;
        int r3 = getMeasuredWidth();
        getMeasuredHeight();
        float r4 = r2.c(r3);
        ig4.c r5 = getConfig().h;
        getMeasuredWidth();
        float r6 = r5.d(getMeasuredHeight(), getAnimationY(), getLyricsRect());
        if (getInScroll() == false) goto L16;
        this.F = getConfig().g + 1;
    L17:
        int r11 = 0;
        if (this.M == false) goto L20;
        this.F = 0;
    L20:
        int r12 = this.F;
        int r13 = 1;
    L21:
        if (r13 >= r12) goto L24;
        d(r15, r13, r4, r6, r0.h);
        r13 = r13 + 1;
        goto L21
    L24:
        if (r0.h == false) goto L35;
        ArrayList r7 = getConfig().h.e(r4);
        if (r7 != null) goto L29;
        r7 = CollectionsKt.arrayListOf(new Float[]{Float.valueOf(r4), Float.valueOf(r4), Float.valueOf(r4)});
    L29:
        if (getLyricsLineInfos().size() < 2) goto L49;
        int r8 = RangesKt.coerceAtMost(((int) (((long) ((com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), 1)).b) - getCurrMusicProcess())) / 1000, 3);
    L31:
        if (r11 >= r8) goto L49;
        if (r15 == null) goto L34;
        r15.drawCircle(((Number) ListProtector.get(r7, r11)).floatValue(), o.a(getConfig().b) + r6, getConfig().h.d, getConfig().m);
    L34:
        r11 = r11 + 1;
    L49:
        if (getVisibility() == 0) goto L51;
        return;
    L51:
        if (this.I == true) goto L60;
        this.I = true;
        return;
    L60:
        return;
    L35:
        r15.save();
        if (getConfig().n != 3) goto L39;
        r15.clipRect(0.0f, 0.0f, getDynamicRectF().left, getDynamicRectF().bottom);
    L39:
        if (getConfig().j == null) goto L45;
        Paint r9 = getConfig().k;
        Float r10 = getConfig().j;
        if (r10 == null) goto L43;
        float r14 = r10.floatValue();
    L44:
        r9.setStrokeWidth(r14);
        r15.drawText(r1, r4, r6, getConfig().k);
        getConfig().k.setStrokeWidth(0.0f);
        goto L45
    L43:
        r14 = 0.0f;
    L45:
        r15.drawText(r1, r4, r6, getConfig().l);
        r15.restore();
        if (getConfig().n != 3) goto L49;
        r15.clipRect(getDynamicRectF());
        r15.drawText(r1, r4, r6, getConfig().k);
        goto L49
    L16:
        this.F = getConfig().g;
        goto L17
    L58:
        return;
    L8:
        r0 = (com.bytedance.component.lyric.model.b) ListProtector.get(getLyricsLineInfos(), getCurShowIndex());
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void renderLyricsByPlayTime(long r4) {
        setCurrMusicProcess(r4);
        int r0 = e(r4);
        setLastMusicProcess(r4);
        if (getCurShowIndex() == r0) goto L14;
        if (this.p == true) goto L14;
        if (r0 > 0) goto L8;
    L12:
        h(r0);
    L17:
        if ((!Intrinsics.areEqual(getDynamicRectF(), this.H)) == true) goto L19;
    L21:
        long r5 = getCurrMusicProcess();
        Iterator r1 = ((ArrayList) this.L).iterator();
    L23:
        if (r1.hasNext() == false) goto L25;
        ((a) r1.next()).a(r5);
        goto L23
    L25:
        return;
    L19:
        if (getInScroll() == true) goto L21;
        invalidate();
        this.H.set(getDynamicRectF());
        goto L21
    L8:
        if (r0 >= getCurShowIndex()) goto L12;
        if (Math.abs(r0 - getCurShowIndex()) >= this.K) goto L12;
        String r6 = "findCurrentIndex error:" + r0 + ", current:" + getCurShowIndex() + "---playTime:" + r4;
        ALogger.i(bb0.b.b().concat("-lyric"), r6 + ", invoke class :KtvSingAndListenerLyricViewV2");
    L14:
        if (this.J == false) goto L17;
        invalidate();
        this.J = false;
        goto L17
    }

    public final void setForbidPendingLine(boolean r1) {
        invalidate();
        this.M = r1;
    }

    public final void setPenddingLine(int r1) {
        this.F = r1;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        if (r2 == 0) goto L5;
        return;
    L5:
        if (this.I == false) goto L7;
        return;
    L7:
        if ((!getLyricsLineInfos().isEmpty()) == false) goto L12;
        this.I = true;
        return;
    }

    public KtvSingAndListenerLyricViewV2(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.F = 2;
        this.G = 4;
        this.H = new RectF();
        this.K = ((Number) h.o2.getValue(null, h.a[169(0xa9, float:2.37E-43)])).intValue();
        this.L = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.CommonLyricDisplayView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void addLyrics(List<com.bytedance.component.lyric.model.b> r7, long r8) {
        super.addLyrics(r7, r8);
        ig4.c.b(getConfig().h, getDynamicRectF(), getMeasuredHeight(), getMeasuredWidth(), getMeasuredWidth(), 0.0f);
        this.J = true;
    }
}
