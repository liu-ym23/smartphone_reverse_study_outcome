package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.livesdk.ktvimpl.base.util.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010a\u001a\u00020`\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u0012\b\b\u0002\u0010d\u001a\u00020\u0002¢\u0006\u0004\be\u0010fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010%\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0004X\u0084\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00108\u001a\u0002038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u0010>\u001a\u0002098\u0004X\u0084\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010 \u001a\u0004\b@\u0010\"\"\u0004\bA\u0010$R\"\u0010F\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bC\u0010 \u001a\u0004\bD\u0010\"\"\u0004\bE\u0010$R$\u0010N\u001a\u0004\u0018\u00010G8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010P\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bO\u0010\r\u001a\u0004\bP\u0010\u000f\"\u0004\bQ\u0010\u0011R\"\u0010S\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bR\u0010\r\u001a\u0004\bS\u0010\u000f\"\u0004\bT\u0010\u0011R\"\u0010X\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bU\u0010\r\u001a\u0004\bV\u0010\u000f\"\u0004\bW\u0010\u0011R\u001a\u0010[\u001a\u00020\u000b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bY\u0010\r\u001a\u0004\bZ\u0010\u000fR\"\u0010_\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010 \u001a\u0004\b]\u0010\"\"\u0004\b^\u0010$¨\u0006g"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/CommonLyricDisplayView;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/BaseLyricView;", "", "getlyricsLineCount", "Ljava/util/ArrayList;", "Lcom/bytedance/component/lyric/model/b;", "Lkotlin/collections/ArrayList;", "getCurrentLyrics", "Landroid/graphics/Paint$Align;", "getTextAlign", "getCurrentIndex", "", "c", "Z", "getInScroll", "()Z", "setInScroll", "(Z)V", "inScroll", "", "d", "J", "getCurrMusicProcess", "()J", "setCurrMusicProcess", "(J)V", "currMusicProcess", "e", "getLastMusicProcess", "setLastMusicProcess", "lastMusicProcess", "f", "I", "getCurToAddLineIndex", "()I", "setCurToAddLineIndex", "(I)V", "curToAddLineIndex", "", "g", "F", "getCurLinePorgress", "()F", "setCurLinePorgress", "(F)V", "curLinePorgress", "h", "Ljava/util/ArrayList;", "getLyricsLineInfos", "()Ljava/util/ArrayList;", "lyricsLineInfos", "Landroid/graphics/RectF;", "i", "Landroid/graphics/RectF;", "getDynamicRectF", "()Landroid/graphics/RectF;", "dynamicRectF", "Landroid/graphics/Rect;", "k", "Landroid/graphics/Rect;", "getLyricsRect", "()Landroid/graphics/Rect;", "lyricsRect", "m", "getCurShowIndex", "setCurShowIndex", "curShowIndex", "n", "getAnimationY", "setAnimationY", "animationY", "Landroid/animation/ValueAnimator;", "o", "Landroid/animation/ValueAnimator;", "getScrollAnimator", "()Landroid/animation/ValueAnimator;", "setScrollAnimator", "(Landroid/animation/ValueAnimator;)V", "scrollAnimator", "p", "isAnimating", "setAnimating", "q", "isAnimatingHide", "setAnimatingHide", "s", "getDrawOptEnable", "setDrawOptEnable", "drawOptEnable", "y", "getCountDownEnable", "countDownEnable", "z", "getAddedLines", "setAddedLines", "addedLines", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class CommonLyricDisplayView extends BaseLyricView {
    public List<com.bytedance.component.lyric.model.b> A;
    public float B;
    public List<com.bytedance.component.lyric.model.b> C;
    public long D;
    public boolean E;
    public boolean c;
    public long d;
    public long e;
    public int f;
    public float g;
    public final ArrayList<com.bytedance.component.lyric.model.b> h;
    public final RectF i;
    public Float j;
    public final Rect k;
    public final Rect l;
    public int m;
    public int n;
    public ValueAnimator o;
    public boolean p;
    public boolean q;
    public final boolean r;
    public boolean s;
    public ValueAnimator t;
    public final float u;
    public final Map<String, Float> v;
    public final Map<String, Rect> w;
    public final Map<String, Rect> x;
    public final boolean y;
    public int z;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ CommonLyricDisplayView a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ Ref.IntRef c;

        public a(CommonLyricDisplayView r1, Ref.IntRef r2, Ref.IntRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            this.a.setInScroll(true);
            Ref.IntRef r0 = this.b;
            Object r5 = r4.getAnimatedValue();
            if (r5 == null) goto L10;
            r0.element = ((Integer) r5).intValue();
            Ref.IntRef r6 = this.c;
            int r1 = r6.element;
            Ref.IntRef r2 = this.b;
            int r3 = r2.element;
            if (r1 != r3) goto L7;
            return;
        L7:
            r6.element = r3;
            this.a.setAnimationY(r2.element);
            this.a.invalidate();
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ CommonLyricDisplayView a;
        public final /* synthetic */ int b;

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

        public b(CommonLyricDisplayView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public CommonLyricDisplayView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonLyricDisplayView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final View asView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void release() {
        this.f = 0;
        this.d = 0;
        this.m = 0;
        this.h.clear();
        this.C = null;
        this.i.setEmpty();
        invalidate();
        this.j = null;
        ALogger.i(bb0.b.b().concat("-lyric"), "release, invoke class :CommonLyricDisplayView");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void updateDynamicPaintColor() {
    }

    public final int getlyricsLineCount() {
        return this.h.size();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final boolean isFinishDrawLastLine() {
        int r0 = this.m;
        if (r0 > 0) goto L5;
        return false;
    L5:
        if (r0 == (this.h.size() - 1)) goto L7;
        return false;
    L7:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.h, this.m)).g == null) goto L18;
        int[] r1 = ((com.bytedance.component.lyric.model.b) ListProtector.get(this.h, this.m)).g;
        Intrinsics.checkNotNull(r1);
        int r2 = r1.length;
        int r4 = 0;
        int r5 = 0;
    L9:
        if (r4 >= r2) goto L12;
        r5 = r5 + r1[r4];
        r4 = r4 + 1;
        goto L9
    L12:
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(this.h, this.m)).b + r5) > this.d) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void onConfigComplete() {
        ValueAnimator r0 = this.t;
        if (r0 != null) goto L5;
    L10:
        this.t = ValueAnimator.ofFloat(new float[]{this.u, getConfig().c});
        return;
    L5:
        if (r0.isRunning() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.removeAllUpdateListeners();
        r0.removeAllListeners();
        r0.cancel();
        goto L10
    }

    public final int getAddedLines() {
        return this.z;
    }

    public final int getAnimationY() {
        return this.n;
    }

    public final boolean getCountDownEnable() {
        return this.y;
    }

    public final float getCurLinePorgress() {
        return this.g;
    }

    public final int getCurShowIndex() {
        return this.m;
    }

    public final int getCurToAddLineIndex() {
        return this.f;
    }

    public final long getCurrMusicProcess() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.BaseLyricView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public int getCurrentIndex() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.BaseLyricView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public ArrayList<com.bytedance.component.lyric.model.b> getCurrentLyrics() {
        return this.h;
    }

    public final boolean getDrawOptEnable() {
        return this.s;
    }

    public final RectF getDynamicRectF() {
        return this.i;
    }

    public final boolean getInScroll() {
        return this.c;
    }

    public final long getLastMusicProcess() {
        return this.e;
    }

    public final ArrayList<com.bytedance.component.lyric.model.b> getLyricsLineInfos() {
        return this.h;
    }

    public final Rect getLyricsRect() {
        return this.k;
    }

    public final ValueAnimator getScrollAnimator() {
        return this.o;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.BaseLyricView, com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public Paint.Align getTextAlign() {
        return Paint.Align.CENTER;
    }

    private final float g(String r4) {
        if (r4 != null) goto L4;
    L9:
        return 0.0f;
    L4:
        if (((LinkedHashMap) this.v).get(r4) == null) goto L6;
        Float r5 = (Float) ((LinkedHashMap) this.v).get(r4);
    L7:
        if (r5 == null) goto L9;
        return r5.floatValue();
    L6:
        float r0 = getConfig().k.measureText(r4);
        this.v.put(r4, Float.valueOf(r0));
        r5 = Float.valueOf(r0);
        goto L7
    }

    public void b(List<com.bytedance.component.lyric.model.b> r5) {
        if (this.E == true) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.size() > 0) goto L9;
        return;
    L9:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r5, 0)).b <= 3000) goto L16;
        this.f = 1;
        if (this.z >= 1) goto L17;
        com.bytedance.component.lyric.model.b r3 = new com.bytedance.component.lyric.model.b();
        r3.h = true;
        r3.b = ((com.bytedance.component.lyric.model.b) ListProtector.get(r5, 0)).b - 3000;
        r3.d = "...";
        r3.f = new String[]{".", ".", "."};
        r3.g = new int[]{1000, 1000, 1000};
        this.h.add(r3);
        return;
    L17:
        return;
    }

    public void c(long r13) {
        if (this.m < this.h.size()) goto L5;
        return;
    L5:
        com.bytedance.component.lyric.model.b r0 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.h, this.m);
        float r6 = g(r0.d);
        long r14 = r13 - ((long) r0.b);
        StringBuilder r1 = new StringBuilder();
        Integer r2 = r0.n;
        int r3 = 0;
        if (r2 != null) goto L8;
    L23:
        int[] r4 = r0.g;
        if (r4 == null) goto L38;
        int r5 = r4.length;
        long r7 = 0;
    L26:
        if (r3 >= r5) goto L38;
        long r9 = r4[r3];
        r7 = r7 + r9;
        String[] r8 = r0.f;
        if (r8 == null) goto L31;
        String r10 = r8[r3];
        if (r10 == null) goto L31;
    L33:
        if (r14 < r7) goto L34;
        r1.append(r10);
        r3 = r3 + 1;
        goto L26
    L34:
        if (r3 <= 0) goto L36;
        r14 = r14 - (r7 - r9);
    L36:
        float r11 = (g(r10) / r4[r3]) * r14;
    L39:
        ig4.c.b(getConfig().h, this.i, getMeasuredHeight(), getMeasuredWidth(), r6, r11 + g(r1.toString()));
        return;
    L31:
        r10 = "";
    L38:
        r11 = 0.0f;
        goto L39
    L8:
        if (r2.intValue() <= 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L23;
        float r15 = r14 / r2.intValue();
        this.g = r15;
        if (r15 <= 1.0f) goto L19;
        this.g = 1.0f;
    L19:
        if (Intrinsics.areEqual(this.j, this.g) == false) goto L21;
        return;
    L21:
        this.j = Float.valueOf(this.g);
        ig4.c.b(getConfig().h, this.i, getMeasuredHeight(), getMeasuredWidth(), r6, r6 * this.g);
        return;
    L10:
        r12 = false;
        goto L11
    }

    public final int e(long r9) {
        int r0 = this.h.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L42;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.h, r2)).a != 1) goto L10;
        if (this.y == false) goto L10;
    L32:
        r2 = r2 + 1;
    L10:
        if (r9 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.h, 0)).b) goto L43;
        if (r9 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.h, r2)).b) goto L25;
        if (r2 <= 0) goto L25;
        if (getConfig().n != 3) goto L18;
        c(r9);
    L18:
        int r3 = r2 - 1;
        if (this.y == false) goto L33;
        int r10 = com.bytedance.component.lyric.model.b.o;
        if (com.bytedance.component.lyric.model.b.a.a((com.bytedance.component.lyric.model.b) ListProtector.get(this.h, r3)) == false) goto L33;
        r3 = r3 - 1;
    L33:
        return r3;
    L25:
        if (r2 != (this.h.size() - 1)) goto L32;
        if (r9 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.h, r2)).b) goto L32;
        if (getConfig().n != 3) goto L41;
        c(r9);
    L41:
        return this.h.size() - 1;
    L43:
        return 0;
    L42:
        return 0;
    }

    public final Rect f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "text");
        if (((LinkedHashMap) this.w).get(r5) == null) goto L5;
        Rect r6 = (Rect) ((LinkedHashMap) this.w).get(r5);
    L6:
        if (r6 == null) goto L8;
        return r6;
    L8:
        return new Rect();
    L5:
        Rect r0 = new Rect();
        getConfig().k.getTextBounds(r5, 0, r5.length(), r0);
        this.w.put(r5, r0);
        r6 = r0;
        goto L6
    }

    public void h(int r7) {
        String r0 = "currMusicProcess:" + this.d + ",nextShowIndex:" + r7 + ',' + ((com.bytedance.component.lyric.model.b) ListProtector.get(this.h, r7));
        ALogger.i(bb0.b.b().concat("-lyric"), r0 + ", invoke class :CommonLyricDisplayView");
        ValueAnimator r1 = this.o;
        if (r1 != null) goto L5;
    L16:
        this.p = true;
        Ref.IntRef r2 = new Ref.IntRef();
        r2.element = -1;
        Ref.IntRef r3 = new Ref.IntRef();
        r3.element = 0;
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{0, this.k.height()});
        this.o = r4;
        if (r4 == null) goto L19;
        r4.setDuration(230);
    L19:
        ValueAnimator r5 = this.o;
        if (r5 == null) goto L22;
        r5.addUpdateListener(new a(this, r3, r2));
    L22:
        ValueAnimator r6 = this.o;
        if (r6 == null) goto L25;
        r6.addListener(new b(this, r7));
    L25:
        ValueAnimator r8 = this.o;
        if (r8 == null) goto L29;
        r8.start();
        return;
    L29:
        return;
    L5:
        if (r1.isRunning() != true) goto L16;
        ValueAnimator r9 = this.o;
        if (r9 == null) goto L9;
        r9.cancel();
    L9:
        ValueAnimator r10 = this.o;
        if (r10 == null) goto L12;
        r10.removeAllUpdateListeners();
    L12:
        ValueAnimator r11 = this.o;
        if (r11 == null) goto L15;
        r11.removeAllListeners();
    L15:
        this.n = 0;
        goto L16
    }

    @Override // android.view.View
    public void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        int r8 = r18.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null);
        if (this.m < this.h.size()) goto L5;
        com.bytedance.component.lyric.model.b r0 = null;
    L6:
        com.bytedance.component.lyric.model.b r9 = r0;
        if (r9 == null) goto L34;
        String r1 = r9.d;
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        String r10 = r1;
        this.k.set(f(r10));
        ig4.c r2 = getConfig().h;
        int r3 = getMeasuredWidth();
        getMeasuredHeight();
        float r11 = r2.c(r3);
        ig4.c r4 = getConfig().h;
        getMeasuredWidth();
        float r12 = r4.d(getMeasuredHeight(), this.n, this.k);
        int r5 = 0;
        if (r9.h == false) goto L22;
        ArrayList r6 = getConfig().h.e(r11);
        if (r6 != null) goto L17;
        r6 = CollectionsKt.arrayListOf(new Float[]{Float.valueOf(r11), Float.valueOf(r11), Float.valueOf(r11)});
    L17:
        if (this.h.size() < 2) goto L21;
        int r7 = RangesKt.coerceAtMost(((int) (((long) ((com.bytedance.component.lyric.model.b) ListProtector.get(this.h, 1)).b) - this.d)) / 1000, 3);
    L19:
        if (r5 >= r7) goto L21;
        r18.drawCircle(((Number) ListProtector.get(r6, r5)).floatValue(), o.a(getConfig().b) + r12, getConfig().h.d, getConfig().m);
        r5 = r5 + 1;
    L21:
        boolean r14 = true;
    L23:
        int r15 = getConfig().g + 1;
        int r13 = 1;
    L24:
        if (r13 >= r15) goto L26;
        d(r18, r13, r11, r12, r14);
        r13 = r13 + 1;
        goto L24
    L26:
        r18.restoreToCount(r8);
        if (getConfig().n == 3) goto L29;
        return;
    L29:
        if (r9.h == true) goto L36;
        r18.clipRect(this.i);
        r18.drawText(r10, r11, r12, getConfig().k);
        return;
    L36:
        return;
    L22:
        r18.drawText(r10, r11, r12, getConfig().l);
        r14 = false;
        goto L23
    L34:
        return;
    L5:
        r0 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.h, this.m);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void renderLyricsByPlayTime(long r2) {
        this.d = r2;
        int r0 = e(r2);
        this.e = r2;
        if (this.m != r0) goto L5;
    L7:
        invalidate();
        return;
    L5:
        if (this.p == true) goto L7;
        h(r0);
        goto L7
    }

    public final void setAddedLines(int r1) {
        this.z = r1;
    }

    public final void setAnimating(boolean r1) {
        this.p = r1;
    }

    public final void setAnimatingHide(boolean r1) {
        this.q = r1;
    }

    public final void setAnimationY(int r1) {
        this.n = r1;
    }

    public final void setCurLinePorgress(float r1) {
        this.g = r1;
    }

    public final void setCurShowIndex(int r1) {
        this.m = r1;
    }

    public final void setCurToAddLineIndex(int r1) {
        this.f = r1;
    }

    public final void setCurrMusicProcess(long r1) {
        this.d = r1;
    }

    public final void setDrawOptEnable(boolean r1) {
        this.s = r1;
    }

    public final void setInScroll(boolean r1) {
        this.c = r1;
    }

    public final void setLastMusicProcess(long r1) {
        this.e = r1;
    }

    public final void setScrollAnimator(ValueAnimator r1) {
        this.o = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void addLyrics(List<com.bytedance.component.lyric.model.b> r5, long r6) {
        List<com.bytedance.component.lyric.model.b> r0 = r5;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        this.C = r5;
        if (getConfig().d <= 0) goto L14;
    L18:
        this.D = r6;
        ALogger.i("mv_lyric", "addLyrics " + r5.size());
        this.h.clear();
        this.z = 0;
        this.k.setEmpty();
        this.i.setEmpty();
        this.l.setEmpty();
        ((LinkedHashMap) this.v).clear();
        ((LinkedHashMap) this.w).clear();
        ((LinkedHashMap) this.x).clear();
        this.m = 0;
        this.p = false;
        b(r5);
        Iterator<com.bytedance.component.lyric.model.b> r7 = r5.iterator();
    L20:
        if (r7.hasNext() == false) goto L24;
        com.bytedance.component.lyric.model.b r2 = r7.next();
        if (TextUtils.isEmpty(r2.d) == true) goto L20;
        adjustAddLyricsLine(r2, false);
        goto L20
    L24:
        long r3 = this.d;
        if (r3 <= 0) goto L27;
        r6 = r3;
    L27:
        this.m = e(r6);
        return;
    L14:
        if (getWidth() <= 0) goto L16;
        getConfig().f(getWidth());
        goto L18
    L16:
        this.A = r5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void adjustAddLyricsLine(com.bytedance.component.lyric.model.b r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "lyricsLineInfo");
        float r2 = getConfig().d;
        String r3 = r19.d;
        Paint r4 = getConfig().k;
        if (r20 == false) goto L5;
        int r6 = this.h.size();
    L6:
        this.z = r6;
        this.B = r2;
        if (r4.measureText(r3) > r2) goto L16;
        int r5 = this.f + 1;
        this.f = r5;
        if (this.z < r5) goto L11;
        return;
    L11:
        if (this.s == false) goto L13;
        kg4.a.a(r19);
    L13:
        this.h.add(r19);
        return;
    L16:
        if (getConfig().n != 2) goto L33;
        com.bytedance.component.lyric.model.b r7 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r8 = new com.bytedance.component.lyric.model.b();
        StringBuilder r9 = new StringBuilder();
        StringBuilder r10 = new StringBuilder();
        StringBuilder r11 = new StringBuilder();
        String r12 = r19.d;
        if (r12 == null) goto L88;
        int r13 = r12.length();
        int r14 = 0;
    L20:
        if (r14 >= r13) goto L26;
        char r15 = r12.charAt(r14);
        r9.append(r15);
        if (r4.measureText(r9.toString()) <= r2) goto L24;
        r11.append(r15);
    L25:
        r14 = r14 + 1;
        goto L20
    L24:
        r10.append(r15);
        goto L25
    L26:
        r7.b = r19.b;
        r7.d = r10.toString();
        int r16 = this.f + 1;
        this.f = r16;
        if (this.z >= r16) goto L29;
        this.h.add(r7);
    L29:
        r8.b = r19.b + 4000;
        r8.d = r11.toString();
        int r1 = this.f + 1;
        this.f = r1;
        if (this.z >= r1) goto L106;
        this.h.add(r8);
        return;
    L106:
        return;
    L88:
        return;
    L33:
        if (getConfig().n != 3) goto L108;
        com.bytedance.component.lyric.model.b r17 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r18 = new com.bytedance.component.lyric.model.b();
        StringBuilder r21 = new StringBuilder();
        String[] r22 = r19.f;
        if (r22 == null) goto L109;
        ArrayList r23 = new ArrayList();
        ArrayList r110 = new ArrayList();
        ArrayList r111 = new ArrayList();
        StringBuilder r112 = new StringBuilder();
        StringBuilder r113 = new StringBuilder();
        ArrayList r114 = new ArrayList();
        int r115 = r19.b;
        int r24 = r22.length;
        int r25 = 0;
    L37:
        if (r25 >= r24) goto L51;
        int r116 = r24;
        String r26 = r22[r25];
        r21.append(r26);
        String[] r117 = r22;
        if (r4.measureText(r21.toString()) <= r2) goto L45;
        r111.add(r26);
        r113.append(r26);
        int[] r27 = r19.g;
        if (r27 == null) goto L50;
        if (r25 >= r27.length) goto L50;
        r114.add(Integer.valueOf(r27[r25]));
    L50:
        r25 = r25 + 1;
        r24 = r116;
        r22 = r117;
        goto L37
    L45:
        r23.add(r26);
        r112.append(r26);
        int[] r28 = r19.g;
        if (r28 == null) goto L50;
        if (r25 >= r28.length) goto L50;
        r110.add(Integer.valueOf(r28[r25]));
        r115 = r115 + r28[r25];
        goto L50
    L51:
        r17.b = r19.b;
        Object[] r29 = r23.toArray(new String[0]);
        if (r29 == null) goto L87;
        r17.f = (String[]) r29;
        r17.g = new int[r110.size()];
        int r30 = r110.size();
        int r31 = 0;
    L54:
        if (r31 >= r30) goto L60;
        int[] r32 = r17.g;
        if (r32 == null) goto L58;
        r32[r31] = ((Number) ListProtector.get(r110, r31)).intValue();
    L58:
        r31 = r31 + 1;
        goto L54
    L60:
        if (this.r == false) goto L66;
        String r33 = r112.toString();
        if (r33 == null) goto L65;
        r17.d = StringsKt.trim(r33).toString();
    L67:
        int r34 = this.f + 1;
        this.f = r34;
        if (this.z >= r34) goto L70;
        this.h.add(r17);
    L70:
        r18.b = r115;
        Object[] r35 = r111.toArray(new String[0]);
        if (r35 == null) goto L85;
        r18.f = (String[]) r35;
        r18.g = new int[r114.size()];
        int r36 = r114.size();
        int r37 = 0;
    L73:
        if (r37 >= r36) goto L78;
        int[] r38 = r18.g;
        if (r38 == null) goto L77;
        r38[r37] = ((Number) ListProtector.get(r114, r37)).intValue();
    L77:
        r37 = r37 + 1;
        goto L73
    L78:
        r18.d = r113.toString();
        int r39 = this.f + 1;
        this.f = r39;
        if (this.z >= r39) goto L82;
        this.h.add(r18);
    L82:
        if (this.s == false) goto L110;
        kg4.a.a(r18);
        kg4.a.a(r17);
        return;
    L110:
        return;
    L85:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L65:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L66:
        r17.d = r112.toString();
        goto L67
    L87:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L109:
        return;
    L108:
        return;
    L5:
        r6 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        p.a r4 = p.g;
        Function1<p, Unit> r0 = new AnonymousClass1(this, r3);
        r4.getClass();
        p.a.a(r0);
    }

    public CommonLyricDisplayView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, 4, 0);
        this.h = new ArrayList();
        this.i = new RectF();
        this.k = new Rect();
        this.l = new Rect();
        KtvUtilsKt.d(20.0f);
        this.r = h.v();
        this.s = h.a0();
        this.u = 1.0f;
        this.v = new LinkedHashMap();
        this.w = new LinkedHashMap();
        this.x = new LinkedHashMap();
        this.y = h.m();
        this.E = true;
    }

    public /* synthetic */ CommonLyricDisplayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.BaseLyricView, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        int r5 = 0;
        if (r1 != r3) goto L5;
    L7:
        boolean r6 = false;
    L8:
        getConfig().f(r1);
        if (r6 == false) goto L17;
        List<com.bytedance.component.lyric.model.b> r7 = this.C;
        if (r7 == null) goto L18;
        if (r7 == null) goto L14;
        r5 = r7.size();
    L14:
        if (r5 <= 0) goto L19;
        addLyrics(this.C, this.D);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (((int) this.B) == r1) goto L7;
        r6 = true;
        goto L8
    }

    public final void d(Canvas r7, int r8, float r9, float r10, boolean r11) {
        if ((this.m + r8) < this.h.size()) goto L5;
        com.bytedance.component.lyric.model.b r0 = null;
    L6:
        if (r0 == null) goto L23;
        String r1 = r0.d;
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        Rect r2 = this.l;
        if (((LinkedHashMap) this.x).get(r1) == null) goto L13;
        Rect r3 = (Rect) ((LinkedHashMap) this.x).get(r1);
    L14:
        if (r3 != null) goto L16;
        r3 = new Rect();
    L16:
        r2.set(r3);
        if (r11 == false) goto L19;
        float r12 = getConfig().b;
    L20:
        if (r7 == null) goto L24;
        r7.drawText(r1, r9, ((r10 + (this.l.height() * r8)) + (o.a(getConfig().a) * r8)) + o.a(r12), getConfig().i);
        return;
    L24:
        return;
    L19:
        r12 = 0.0f;
        goto L20
    L13:
        r3 = new Rect();
        getConfig().i.getTextBounds(r1, 0, r1.length(), r3);
        this.x.put(r1, r3);
        goto L14
    L23:
        return;
    L5:
        r0 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.h, this.m + r8);
        goto L6
    }
}
