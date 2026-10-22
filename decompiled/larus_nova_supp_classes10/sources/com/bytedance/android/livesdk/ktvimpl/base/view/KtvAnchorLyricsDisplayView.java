package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0006¢\u0006\u0004\b;\u0010<J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000e\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR*\u0010+\u001a\u00020#2\u0006\u0010$\u001a\u00020#8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010/\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u0017\u00105\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAnchorLyricsDisplayView;", "Landroid/view/View;", "Landroid/graphics/Paint$Align;", "align", "", "setLyricTextAlign", "", "getAddedLyricsLineByLine", "c", "I", "getCurToAddLineIndex", "()I", "setCurToAddLineIndex", "(I)V", "curToAddLineIndex", "", "d", "Z", "getHasAddedFullLyrics", "()Z", "setHasAddedFullLyrics", "(Z)V", "hasAddedFullLyrics", "Ljava/util/ArrayList;", "Lcom/bytedance/component/lyric/model/b;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "getLyricsLineInfos", "()Ljava/util/ArrayList;", "lyricsLineInfos", "n", "getCurShowIndex", "setCurShowIndex", "curShowIndex", "", "value", "u", "F", "getOneLineMaxWidth", "()F", "setOneLineMaxWidth", "(F)V", "oneLineMaxWidth", "x", "getForbidPendingLine", "setForbidPendingLine", "forbidPendingLine", "Lub0/b;", "J", "Lub0/b;", "getConfig", "()Lub0/b;", "config", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class KtvAnchorLyricsDisplayView extends View {
    public float A;
    public final Map<String, Float> B;
    public final Map<String, Rect> C;
    public final Map<String, Rect> D;
    public float E;
    public float F;
    public ig4.c G;
    public final boolean H;
    public boolean I;
    public final ub0.b J;
    public final Map<String, Function1<Long, Unit>> a;
    public long b;
    public int c;
    public boolean d;
    public final ArrayList<com.bytedance.component.lyric.model.b> e;
    public final Paint f;
    public final Paint g;
    public final Paint h;
    public final RectF i;
    public final Paint j;
    public final Paint k;
    public final float l;
    public int m;
    public int n;
    public final Rect o;
    public final Rect p;
    public int q;
    public ValueAnimator r;
    public boolean s;
    public float t;
    public float u;
    public Paint.Align v;
    public int w;
    public boolean x;
    public boolean y;
    public ValueAnimator z;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ KtvAnchorLyricsDisplayView a;
        public final /* synthetic */ Function1 b;

        public a(KtvAnchorLyricsDisplayView r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            KtvAnchorLyricsDisplayView r0 = this.a;
            if ((r4.getAnimatedValue() instanceof Float) == false) goto L9;
            Object r5 = r4.getAnimatedValue();
            if (r5 == null) goto L8;
            float r6 = ((Float) r5).floatValue();
        L10:
            r0.A = r6;
            KtvAnchorLyricsDisplayView r7 = this.a;
            r7.f.setTextSize(t6.a(r7.getContext(), this.a.getConfig().a * this.a.A));
            KtvAnchorLyricsDisplayView r8 = this.a;
            r8.g.setTextSize(t6.a(r8.getContext(), this.a.getConfig().a * this.a.A));
            this.a.invalidate();
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        L9:
            r6 = 1.0f;
            goto L10
        }
    }

    public KtvAnchorLyricsDisplayView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvAnchorLyricsDisplayView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public int getAddedLyricsLineByLine() {
        return 0;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        ((LinkedHashMap) this.a).clear();
        super.onDetachedFromWindow();
    }

    public final ub0.b getConfig() {
        return this.J;
    }

    public final int getCurShowIndex() {
        return this.n;
    }

    public final int getCurToAddLineIndex() {
        return this.c;
    }

    public final boolean getForbidPendingLine() {
        return this.x;
    }

    public final boolean getHasAddedFullLyrics() {
        return this.d;
    }

    public final ArrayList<com.bytedance.component.lyric.model.b> getLyricsLineInfos() {
        return this.e;
    }

    public final float getOneLineMaxWidth() {
        return this.u;
    }

    public final void a(Function1 r3) {
        Intrinsics.checkNotNullParameter("KtvComponentFeedView", "key");
        Intrinsics.checkNotNullParameter(r3, "onProgress");
        this.a.put("KtvComponentFeedView", r3);
    }

    public final void b(long r14) {
        if (this.n < this.e.size()) goto L5;
        return;
    L5:
        com.bytedance.component.lyric.model.b r0 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.e, this.n);
        float r6 = d(r0.d);
        long r15 = r14 - ((long) r0.b);
        long r1 = 0;
        if (r15 >= 0) goto L8;
        r15 = 0;
    L8:
        StringBuilder r3 = new StringBuilder();
        int[] r4 = r0.g;
        float r5 = 0.0f;
        if (r4 == null) goto L23;
        int r7 = r4.length;
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L23;
        int r9 = r4[r8];
        r1 = r1 + ((long) r9);
        String[] r10 = r0.f;
        if (r10 == null) goto L16;
        String r11 = r10[r8];
        if (r11 == null) goto L16;
    L18:
        if (r15 < r1) goto L19;
        r3.append(r11);
        r8 = r8 + 1;
        goto L11
    L19:
        if (r8 <= 0) goto L21;
        r15 = r15 - (r1 - ((long) r9));
    L21:
        r5 = (d(r11) / r4[r8]) * r15;
    L16:
        r11 = "";
    L23:
        float r12 = r5 + d(r3.toString());
        ig4.c r2 = this.G;
        if (r2 == null) goto L29;
        r2.a(this.i, getMeasuredHeight(), getMeasuredWidth(), r6, r12, this.y);
        return;
    }

    public final void c(final Function1<? super ub0.b, Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "configFun");
        ub0.b r0 = this.J;
        r9.invoke(r0);
        ((LinkedHashMap) this.B).clear();
        ((LinkedHashMap) this.C).clear();
        ((LinkedHashMap) this.D).clear();
        this.f.setTextSize(KtvUtilsKt.d(r0.a));
        this.f.setStyle(Paint.Style.FILL_AND_STROKE);
        this.g.setTextSize(KtvUtilsKt.d(r0.a));
        this.h.setTextSize(KtvUtilsKt.d(r0.a));
        this.j.setTextSize(KtvUtilsKt.d(r0.b));
        this.t = r0.c;
        this.F = r0.d;
        setOneLineMaxWidth(t6.a(getContext(), r0.e));
        this.w = r0.g;
        setLyricTextAlign(r0.f);
        Integer r1 = r0.k;
        if (r1 == null) goto L5;
        this.f.setColor(r1.intValue());
    L5:
        Integer r2 = r0.l;
        if (r2 == null) goto L8;
        this.g.setColor(r2.intValue());
    L8:
        Integer r3 = r0.m;
        if (r3 == null) goto L12;
        this.j.setColor(r3.intValue());
    L12:
        if (r0.h == false) goto L15;
        this.f.setFakeBoldText(true);
        this.g.setFakeBoldText(true);
        this.h.setFakeBoldText(true);
        this.j.setFakeBoldText(true);
    L15:
        if (r0.i == false) goto L18;
        this.f.setShadowLayer(2.0f, 0.0f, 1.0f, s1.h(2131107705));
        this.h.setShadowLayer(2.0f, 0.0f, 1.0f, s1.h(2131107705));
        this.j.setShadowLayer(2.0f, 0.0f, 1.0f, s1.h(2131107705));
    L18:
        if (r0.j == false) goto L20;
        this.f.setLetterSpacing(0.05f);
        this.g.setLetterSpacing(0.05f);
        this.j.setLetterSpacing(0.05f);
    L20:
        this.y = r0.n;
        int r4 = r0.o;
        if (r4 == (-1)) goto L38;
        if (r4 == 0) goto L34;
        if (r4 == 1) goto L33;
        if (r4 != 2) goto L26;
        this.E = 1.286f;
    L39:
        ValueAnimator r5 = this.z;
        if (r5 != null) goto L42;
    L47:
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{this.A, this.E});
        this.z = r6;
        if (r6 == null) goto L50;
        r6.addUpdateListener(new a(this, r9));
    L50:
        ValueAnimator r7 = this.z;
        if (r7 == null) goto L54;
        r7.setDuration(300);
    L54:
        if (getVisibility() != 0) goto L56;
        UtilityKotlinExtentionsKt.s(0, false, false, new KtvAnchorLyricsDisplayView$config$$inlined$apply$lambda$2(this, r9), 7);
    L56:
        invalidate();
        return;
    L42:
        if (r5.isRunning() == true) goto L45;
        r5 = null;
    L45:
        if (r5 == null) goto L47;
        r5.removeAllUpdateListeners();
        r5.removeAllListeners();
        r5.cancel();
        goto L47
    L26:
        if (r4 != 3) goto L28;
        this.E = 1.33f;
        goto L39
    L28:
        if (r4 != 4) goto L39;
        this.E = 1.0f;
        goto L39
    L33:
        this.E = 1.2f;
        goto L39
    L34:
        Integer r8 = r0.k;
        if (r8 == null) goto L37;
        this.g.setColor(r8.intValue());
    L37:
        this.E = 1.0f;
        goto L39
    L38:
        this.E = 1.2f;
        goto L39
    }

    public final float d(String r4) {
        if (KtvSettingHelper.o() == false) goto L13;
        if (r4 != null) goto L6;
    L11:
        return 0.0f;
    L6:
        if (((LinkedHashMap) this.B).get(r4) == null) goto L8;
        Float r5 = (Float) ((LinkedHashMap) this.B).get(r4);
    L9:
        if (r5 == null) goto L11;
        return r5.floatValue();
    L8:
        float r0 = this.f.measureText(r4);
        this.B.put(r4, Float.valueOf(r0));
        r5 = Float.valueOf(r0);
        goto L9
    L13:
        return this.f.measureText(r4);
    }

    public final void e(long r9) {
        this.b = r9;
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function1) ((Map.Entry) r0.next()).getValue()).invoke(Long.valueOf(this.b));
        goto L4
    L6:
        int r1 = this.e.size();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L30;
        if (r9 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.e, 0)).b) goto L12;
        if (r9 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.e, r2)).b) goto L22;
        if (r2 <= 0) goto L22;
        if (this.m != 3) goto L20;
        b(r9);
    L20:
        int r3 = r2 - 1;
    L32:
        if (this.n != r3) goto L34;
    L61:
        invalidate();
        return;
    L34:
        if (this.s == true) goto L61;
        ValueAnimator r10 = this.r;
        if (r10 != null) goto L38;
    L49:
        this.s = true;
        Ref.IntRef r11 = new Ref.IntRef();
        r11.element = -1;
        Ref.IntRef r4 = new Ref.IntRef();
        r4.element = 0;
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{0, this.o.height()});
        this.r = r12;
        if (r12 == null) goto L52;
        r12.setDuration(300);
    L52:
        ValueAnimator r13 = this.r;
        if (r13 == null) goto L55;
        r13.addUpdateListener(new b((KtvAudienceLyricsDisplayView) this, r4, r11));
    L55:
        ValueAnimator r14 = this.r;
        if (r14 == null) goto L58;
        r14.addListener(new c((KtvAudienceLyricsDisplayView) this, r3));
    L58:
        this.I = false;
        ValueAnimator r15 = this.r;
        if (r15 == null) goto L61;
        r15.start();
        goto L61
    L38:
        if (r10.isRunning() != true) goto L49;
        ValueAnimator r16 = this.r;
        if (r16 == null) goto L42;
        r16.cancel();
    L42:
        ValueAnimator r17 = this.r;
        if (r17 == null) goto L45;
        r17.removeAllUpdateListeners();
    L45:
        ValueAnimator r18 = this.r;
        if (r18 == null) goto L48;
        r18.removeAllListeners();
    L48:
        this.q = 0;
    L22:
        if (r2 != (this.e.size() - 1)) goto L29;
        if (r9 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.e, r2)).b) goto L29;
        if (this.m != 3) goto L28;
        b(r9);
    L28:
        r3 = this.e.size() - 1;
    L29:
        r2 = r2 + 1;
        goto L8
    L12:
        if (this.m != 3) goto L30;
        b(r9);
    L30:
        r3 = 0;
        goto L32
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        super.onDraw(r18);
        int r8 = r18.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null);
        if (this.n < this.e.size()) goto L5;
        com.bytedance.component.lyric.model.b r9 = null;
    L6:
        if (r9 == null) goto L109;
        String r1 = r9.d;
        String r2 = "";
        if (r1 != null) goto L10;
        String r10 = "";
    L12:
        if (KtvSettingHelper.o() == false) goto L20;
        Rect r3 = this.o;
        if (((LinkedHashMap) this.C).get(r10) == null) goto L16;
        Rect r5 = (Rect) ((LinkedHashMap) this.C).get(r10);
    L17:
        if (r5 != null) goto L19;
        r5 = new Rect();
    L19:
        r3.set(r5);
    L21:
        ig4.c r4 = this.G;
        if (r4 == null) goto L24;
        int r6 = getMeasuredWidth();
        getMeasuredHeight();
        float r12 = r4.c(r6);
    L25:
        ig4.c r7 = this.G;
        if (r7 == null) goto L28;
        getMeasuredWidth();
        float r13 = r7.d(getMeasuredHeight(), this.q, this.o);
    L30:
        if (r9.h == false) goto L47;
        ig4.c r11 = this.G;
        if (r11 == null) goto L35;
        ArrayList r14 = r11.e(r12);
        if (r14 == null) goto L35;
    L37:
        if (this.e.size() < 2) goto L45;
        int r15 = RangesKt.coerceAtMost(((int) (((long) ((com.bytedance.component.lyric.model.b) ListProtector.get(this.e, 1)).b) - this.b)) / 1000, 3);
        int r16 = 0;
    L39:
        if (r16 >= r15) goto L45;
        float r17 = ((Number) ListProtector.get(r14, r16)).floatValue();
        float r19 = o.a(this.F) + r13;
        ig4.c r110 = this.G;
        if (r110 == null) goto L43;
        float r111 = r110.d;
    L44:
        r18.drawCircle(r17, r19, r111, this.h);
        r16 = r16 + 1;
        goto L39
    L43:
        r111 = 10.0f;
    L45:
        boolean r20 = true;
    L58:
        if (this.I == false) goto L60;
        int r21 = this.w + 1;
    L62:
        if (this.x == true) goto L90;
        int r22 = 1;
    L64:
        if (r22 >= r21) goto L90;
        if ((this.n + r22) < this.e.size()) goto L68;
        com.bytedance.component.lyric.model.b r23 = null;
    L69:
        if (r23 == null) goto L87;
        String r24 = r23.d;
        if (r24 != null) goto L74;
        r24 = r2;
    L74:
        if (KtvSettingHelper.o() == false) goto L82;
        Rect r25 = this.p;
        if (((LinkedHashMap) this.D).get(r24) == null) goto L78;
        Rect r112 = (Rect) ((LinkedHashMap) this.D).get(r24);
    L79:
        if (r112 != null) goto L81;
        r112 = new Rect();
    L81:
        r25.set(r112);
    L83:
        if (r20 == false) goto L85;
        float r26 = this.F;
    L86:
        r18.drawText(r24, r12, (((this.p.height() * r22) + r13) + (o.a(this.t) * r22)) + o.a(r26), this.j);
    L88:
        r22 = r22 + 1;
        r2 = r2;
        goto L64
    L85:
        r26 = 0.0f;
        goto L86
    L78:
        r112 = new Rect();
        this.j.getTextBounds(r24, 0, r24.length(), r112);
        this.D.put(r24, r112);
        goto L79
    L82:
        r2 = r2;
        this.j.getTextBounds(r24, 0, r24.length(), this.p);
        goto L83
    L87:
        r2 = r2;
        goto L88
    L68:
        r23 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.e, this.n + r22);
    L90:
        if (this.J.p == false) goto L92;
        r18.drawRect(0.0f, getMeasuredHeight() - this.l, getMeasuredWidth(), getMeasuredHeight(), this.k);
    L92:
        r18.restoreToCount(r8);
        if (this.m == 3) goto L95;
        return;
    L95:
        if (r9.h == false) goto L97;
        return;
    L97:
        if (this.J.o == 0) goto L112;
        r18.clipRect(this.i);
        if (this.y == false) goto L101;
        r18.drawText(r10, r12, r13, this.f);
        return;
    L101:
        this.f.setStrokeWidth(UtilityKotlinExtentionsKt.h(2.0f));
        r18.drawText(r10, r12, r13, this.f);
        this.f.setStrokeWidth(0.0f);
        r18.drawText(r10, r12, r13, this.g);
        return;
    L112:
        return;
    L60:
        r21 = this.w;
    L35:
        r14 = CollectionsKt.arrayListOf(new Float[]{Float.valueOf(r12), Float.valueOf(r12), Float.valueOf(r12)});
        goto L37
    L47:
        if (this.y == false) goto L52;
        if (this.J.o == 0) goto L52;
        r18.drawText(r10, r12, r13, this.g);
    L56:
        r20 = false;
    L52:
        if (this.m != 3) goto L54;
        Paint r27 = this.f;
    L55:
        r18.drawText(r10, r12, r13, r27);
        goto L56
    L54:
        r27 = this.g;
        goto L55
    L28:
        r13 = 0.0f;
        goto L30
    L24:
        r12 = 0.0f;
        goto L25
    L16:
        r5 = new Rect();
        this.f.getTextBounds(r10, 0, r10.length(), r5);
        this.C.put(r10, r5);
        goto L17
    L20:
        this.f.getTextBounds(r10, 0, r10.length(), this.o);
        goto L21
    L10:
        r10 = r1;
        goto L12
    L109:
        return;
    L5:
        r9 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.e, this.n);
        goto L6
    }

    public final void setCurShowIndex(int r1) {
        this.n = r1;
    }

    public final void setCurToAddLineIndex(int r1) {
        this.c = r1;
    }

    public final void setForbidPendingLine(boolean r1) {
        invalidate();
        this.x = r1;
    }

    public final void setHasAddedFullLyrics(boolean r1) {
        this.d = r1;
    }

    public final void setLyricTextAlign(Paint.Align r2) {
        Intrinsics.checkNotNullParameter(r2, "align");
        this.v = r2;
        int r0 = ig4.c.f;
        this.G = ig4.c.a.a(r2, this.J.g);
        Paint.Align r3 = this.v;
        this.v = r3;
        this.f.setTextAlign(r3);
        this.g.setTextAlign(this.v);
        this.h.setTextAlign(this.v);
        this.j.setTextAlign(this.v);
    }

    public final void setOneLineMaxWidth(float r1) {
        this.u = r1;
    }

    public KtvAnchorLyricsDisplayView(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        this.a = new LinkedHashMap();
        this.e = new ArrayList();
        Paint r15 = new Paint();
        this.f = r15;
        Paint r16 = new Paint();
        this.g = r16;
        Paint r0 = new Paint();
        this.h = r0;
        this.i = new RectF();
        Paint r1 = new Paint();
        this.j = r1;
        Paint r2 = new Paint();
        this.k = r2;
        this.l = KtvUtilsKt.d(20.0f);
        this.m = 2;
        this.o = new Rect();
        this.p = new Rect();
        this.t = 9.0f;
        this.v = Paint.Align.CENTER;
        this.w = 3;
        this.A = 1.0f;
        LinkedHashMap r5 = new LinkedHashMap();
        this.B = r5;
        LinkedHashMap r6 = new LinkedHashMap();
        this.C = r6;
        LinkedHashMap r7 = new LinkedHashMap();
        this.D = r7;
        this.E = 1.0f;
        this.H = h.v();
        this.J = new ub0.b();
        r15.setTextSize(KtvUtilsKt.d(20.0f));
        Resources r4 = r12.getResources();
        int r9 = -1;
        if (r4 == null) goto L5;
        int r8 = r4.getColor(2131107704);
    L6:
        r15.setColor(r8);
        r15.setDither(true);
        r15.setAntiAlias(true);
        r15.setTextAlign(Paint.Align.CENTER);
        r16.setTextSize(KtvUtilsKt.d(20.0f));
        r16.setColor(s1.h(2131107706));
        r16.setDither(true);
        r16.setAntiAlias(true);
        r16.setTextAlign(Paint.Align.CENTER);
        r0.setTextSize(KtvUtilsKt.d(20.0f));
        r0.setColor(s1.h(2131107706));
        r0.setDither(true);
        r0.setAntiAlias(true);
        r0.setTextAlign(Paint.Align.CENTER);
        r1.setTextSize(KtvUtilsKt.d(16.0f));
        Resources r17 = r12.getResources();
        if (r17 == null) goto L9;
        r9 = r17.getColor(2131107704);
    L9:
        r1.setColor(r9);
        r1.setDither(true);
        r1.setAntiAlias(true);
        r1.setTextAlign(Paint.Align.CENTER);
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        r5.clear();
        r6.clear();
        r7.clear();
        return;
    L5:
        r8 = -1;
        goto L6
    }

    public /* synthetic */ KtvAnchorLyricsDisplayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r11, int r12, int r13, int r14) {
        super.onSizeChanged(r11, r12, r13, r14);
        this.k.setShader(new LinearGradient(0.0f, getMeasuredHeight() - this.l, 0.0f, getMeasuredHeight(), 0, -1, Shader.TileMode.CLAMP));
        setOneLineMaxWidth(r11);
        ALogger.i("KtvLyricsView", "onSizeChanged(on size changed):" + r11 + ',' + r12 + ',' + r13 + ',' + r14 + ".properties:" + getWidth() + ',' + getHeight() + ',' + getMeasuredWidth() + ',' + getMeasuredHeight());
    }
}
