package com.bytedance.android.livesdk.ktvimpl.base.lyrics.gl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.c;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvHwDrawBaseSurfaceView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ig4.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vd2.e;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u001b\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016RT\u0010%\u001a4\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/gl/MvLyricSurfaceView;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvHwDrawBaseSurfaceView;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/a;", "Lcom/bytedance/android/live/ktv/common/util/c;", "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "getDisplayConfig", "Ljava/util/ArrayList;", "Lcom/bytedance/component/lyric/model/b;", "Lkotlin/collections/ArrayList;", "getCurrentLyrics", "Landroid/graphics/Paint$Align;", "getTextAlign", "", "getCurrentIndex", "visible", "", "setLyricVisible", "", "maxWith", "setLyricOneLineMaxWidth", "align", "setLyricAlignStyle", "", "hide", "setHideFirstLineLyric", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isTimeOut", "", "timeStamp", "J", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "", "K", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvLyricSurfaceView extends KtvHwDrawBaseSurfaceView implements com.bytedance.android.livesdk.ktvimpl.base.lyrics.a, c {
    public static final /* synthetic */ int L = 0;
    public float A;
    public float B;
    public volatile long C;
    public ValueAnimator D;
    public ValueAnimator E;
    public AnimatorSet F;
    public volatile boolean G;
    public final RectF H;
    public final d I;
    public Function2<? super Boolean, ? super Long, Unit> J;
    public String K;
    public Paint.Align i;
    public boolean j;
    public KtvRoomLyricsStateMachineConfig.d k;
    public final boolean l;
    public final boolean m;
    public final int n;
    public final LyricsDisplayConfig o;
    public final ArrayList<com.bytedance.component.lyric.model.b> p;
    public List<com.bytedance.component.lyric.model.b> q;
    public final Map<String, Float> r;
    public int s;
    public List<com.bytedance.component.lyric.model.b> t;
    public Paint u;
    public final Rect v;
    public final Rect w;
    public int x;
    public volatile int y;
    public float z;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ MvLyricSurfaceView a;

        public b(MvLyricSurfaceView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Paint r0 = this.a.o.i;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            r0.setAlpha(((Integer) r3).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final View asView() {
        return this;
    }

    public final String name() {
        return "MvLyricSurfaceView";
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void updateDynamicPaintColor() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final boolean isFinishDrawLastLine() {
        int r0 = this.y;
        ArrayList r1 = new ArrayList(this.p);
        if (r0 > 0) goto L5;
        return false;
    L5:
        if (r0 == (r1.size() - 1)) goto L7;
        return false;
    L7:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).g == null) goto L18;
        int[] r3 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).g;
        Intrinsics.checkNotNull(r3);
        int r5 = r3.length;
        int r6 = 0;
        int r7 = 0;
    L9:
        if (r6 >= r5) goto L12;
        r7 = r7 + r3[r6];
        r6 = r6 + 1;
        goto L9
    L12:
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0)).b + r7) > this.C) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void onConfigComplete() {
        LyricsDisplayConfig r0 = this.o;
        d r1 = this.I;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.h = r1;
        Paint.FontMetrics r2 = this.o.k.getFontMetrics();
        float r3 = r2.descent;
        float r4 = 2;
        this.z = ((r3 - r2.ascent) / r4) - r3;
        Paint.FontMetrics r5 = this.o.i.getFontMetrics();
        float r6 = r5.descent;
        this.A = ((r6 - r5.ascent) / r4) - r6;
        Paint.FontMetrics r7 = this.o.l.getFontMetrics();
        float r8 = r7.descent;
        this.B = ((r8 - r7.ascent) / r4) - r8;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void release() {
        ALogger.i(bb0.b.b().concat("-lyric-MvLyricSurfaceView"), "release, invoke class :MvLyricSurfaceView");
        this.x = 0;
        this.C = 0;
        this.y = 0;
        this.p.clear();
        this.k = null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void resetCurrMusicProcess() {
        this.C = 0;
        this.y = 0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public int getCurrentIndex() {
        return this.y;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public ArrayList<com.bytedance.component.lyric.model.b> getCurrentLyrics() {
        return this.p;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public LyricsDisplayConfig getDisplayConfig() {
        return this.o;
    }

    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.J;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public Paint.Align getTextAlign() {
        return Paint.Align.LEFT;
    }

    public String getTypeName() {
        return this.K;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvHwDrawBaseSurfaceView
    public final void e(Canvas r10) {
        if (this.y < this.p.size()) goto L5;
        return;
    L5:
        if (this.y >= 0) goto L7;
        return;
    L7:
        if (this.j == true) goto L10;
    L21:
        boolean r0 = false;
    L22:
        if (r0 == false) goto L25;
        return;
    L25:
        if (this.G == false) goto L27;
    L32:
        this.o.i.clearShadowLayer();
    L34:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, this.y)).i == true) goto L36;
    L58:
        if (r10 == null) goto L61;
        g(r10, this.y, this.p, true);
    L61:
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, this.y)).i == true) goto L63;
        if (r10 != null) goto L69;
        return;
    L69:
        if (this.G == false) goto L71;
        int r1 = this.y - 1;
    L72:
        g(r10, r1, this.p, false);
        return;
    L71:
        r1 = this.y + 1;
        goto L72
    L63:
        if (this.C < (((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, this.y)).c + 1000)) goto L79;
        this.o.i.setAlpha(255);
        if (r10 == null) goto L80;
        g(r10, this.y + 1, this.p, false);
        return;
    L80:
        return;
    L79:
        return;
    L36:
        if (this.p.size() > 0) goto L38;
    L43:
        int r2 = ((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, this.y)).c;
    L45:
        if ((this.C - ((long) r2)) <= 1000) goto L58;
        int r3 = this.y + 1;
        if (r3 >= this.p.size()) goto L74;
        com.bytedance.component.lyric.model.b r4 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.p, r3);
        if (this.l == false) goto L54;
        int r5 = com.bytedance.component.lyric.model.b.o;
        if (com.bytedance.component.lyric.model.b.a.a(r4) == false) goto L54;
        r3 = this.y + 2;
        r4 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.p, r3);
    L54:
        if (r4.b >= (this.C + ((long) 3000))) goto L75;
        if (r10 == null) goto L76;
        g(r10, r3, this.p, false);
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L38:
        if (this.y < (this.p.size() - 1)) goto L43;
        Integer r6 = ((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, this.y)).m;
        if (r6 == null) goto L42;
        r2 = r6.intValue();
        goto L45
    L42:
        r2 = ((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, this.y)).c;
        goto L45
    L27:
        if (this.o.i.getAlpha() < 10) goto L32;
        LyricsDisplayConfig r7 = this.o;
        Function1 r8 = r7.p;
        if (r8 == null) goto L34;
        Unit r9 = (Unit) r8.invoke(r7.i);
        goto L34
    L10:
        if (KtvSettingHelper.w() == false) goto L21;
        if ((this.k instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L15;
        this.C = 1;
    L15:
        if (this.y != 0) goto L21;
        if (this.C != 0) goto L21;
        if ((this.k instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L21;
        r0 = true;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(long r13) {
        this.I.g = this.y;
        int r0 = this.y;
        ArrayList r1 = new ArrayList(this.p);
        if (r0 >= r1.size()) goto L26;
        if (r0 < 0) goto L27;
        com.bytedance.component.lyric.model.b r2 = (com.bytedance.component.lyric.model.b) ListProtector.get(r1, r0);
        float r6 = n(r2.d);
        long r14 = r13 - ((long) r2.b);
        StringBuilder r3 = new StringBuilder();
        int[] r4 = r2.g;
        if (r4 == null) goto L21;
        int r5 = r4.length;
        long r7 = 0;
        int r8 = 0;
    L9:
        if (r8 >= r5) goto L21;
        long r9 = r4[r8];
        r7 = r7 + r9;
        String[] r10 = r2.f;
        if (r10 == null) goto L14;
        String r11 = r10[r8];
        if (r11 == null) goto L14;
    L16:
        if (r14 < r7) goto L17;
        r3.append(r11);
        r8 = r8 + 1;
        goto L9
    L17:
        if (r8 <= 0) goto L19;
        r14 = r14 - (r7 - r9);
    L19:
        float r12 = (n(r11) / r4[r8]) * r14;
    L22:
        ig4.c.b(this.o.h, this.H, getMeasuredHeight(), getMeasuredWidth(), r6, r12 + n(r3.toString()));
        return;
    L14:
        r11 = "";
    L21:
        r12 = 0.0f;
        goto L22
    L27:
        return;
    }

    public final int l(long r9) {
        int r0 = this.p.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L42;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, r2)).a != 1) goto L10;
        if (this.l == false) goto L10;
    L32:
        r2 = r2 + 1;
    L10:
        if (r9 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, 0)).b) goto L43;
        if (r9 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, r2)).b) goto L25;
        if (r2 <= 0) goto L25;
        if (this.o.n != 3) goto L18;
        f(r9);
    L18:
        int r3 = r2 - 1;
        if (this.l == false) goto L33;
        int r10 = com.bytedance.component.lyric.model.b.o;
        if (com.bytedance.component.lyric.model.b.a.a((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, r3)) == false) goto L33;
        r3 = r3 - 1;
    L33:
        return r3;
    L25:
        if (r2 != (this.p.size() - 1)) goto L32;
        if (r9 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.p, r2)).b) goto L32;
        if (this.o.n != 3) goto L41;
        f(r9);
    L41:
        return this.p.size() - 1;
    L43:
        return 0;
    L42:
        return 0;
    }

    public final float n(String r4) {
        if (r4 != null) goto L4;
    L9:
        return 0.0f;
    L4:
        if (((LinkedHashMap) this.r).get(r4) == null) goto L6;
        Float r5 = (Float) ((LinkedHashMap) this.r).get(r4);
    L7:
        if (r5 == null) goto L9;
        return r5.floatValue();
    L6:
        float r0 = this.o.k.measureText(r4);
        this.r.put(r4, Float.valueOf(r0));
        r5 = Float.valueOf(r0);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void renderLyricsByPlayTime(long r7) {
        if (this.p.isEmpty() == false) goto L7;
        String r8 = "renderLyricsByPlayTime  ;; lyricsLineInfos is empty ;; " + this.C + " ;; " + r7;
        ALogger.i(bb0.b.b().concat("-lyric-MvLyricSurfaceView"), r8 + ", invoke class :MvLyricSurfaceView");
        return;
    L7:
        if (this.C <= r7) goto L10;
        String r9 = "renderLyricsByPlayTime ;;  currMusicProcess > playTime ;; " + this.C + " ;; " + r7;
        ALogger.i(bb0.b.b().concat("-lyric-MvLyricSurfaceView"), r9 + ", invoke class :MvLyricSurfaceView");
        return;
    L10:
        this.C = r7;
        int r10 = l(r7);
        if (KtvSettingHelper.w() == false) goto L16;
        if (this.y < r10) goto L17;
    L18:
        boolean r11 = false;
    L19:
        if (r11 == false) goto L56;
        AnimatorSet r12 = this.F;
        if (r12 != null) goto L23;
    L37:
        this.F = new AnimatorSet();
        int r13 = this.o.i.getAlpha();
        AnimatorSet r3 = this.F;
        if (r3 == null) goto L40;
        r3.addListener(new vd2.c(this, r10));
    L40:
        this.D = m(r13, 0);
        this.E = m(0, 255);
        e r14 = new e(this);
        AnimatorSet r15 = this.F;
        if (r15 == null) goto L43;
        r15.addListener(r14);
    L43:
        ValueAnimator r16 = this.D;
        if (r16 == null) goto L46;
        r16.addListener(new vd2.d(this));
    L46:
        AnimatorSet r17 = this.F;
        if (r17 == null) goto L49;
        r17.playSequentially(new Animator[]{this.D, this.E});
    L49:
        AnimatorSet r18 = this.F;
        if (r18 == null) goto L52;
        r18.setDuration(500);
    L52:
        AnimatorSet r19 = this.F;
        if (r19 == null) goto L57;
        r19.start();
        return;
    L57:
        return;
    L23:
        if (r12.isRunning() != true) goto L37;
        AnimatorSet r20 = this.F;
        if (r20 == null) goto L27;
        r20.cancel();
    L27:
        AnimatorSet r21 = this.F;
        if (r21 == null) goto L30;
        r21.removeAllListeners();
    L30:
        ValueAnimator r22 = this.E;
        if (r22 == null) goto L33;
        r22.removeAllUpdateListeners();
    L33:
        ValueAnimator r23 = this.D;
        if (r23 == null) goto L36;
        r23.removeAllUpdateListeners();
    L36:
        this.o.i.setAlpha(255);
        goto L37
    L56:
        return;
    L17:
        r11 = true;
        goto L19
    L16:
        if (this.y == r10) goto L18;
        goto L17
    }

    public void setHideFirstLineLyric(boolean r1) {
        this.j = r1;
    }

    public void setLyricAlignStyle(Paint.Align r2) {
        Intrinsics.checkNotNullParameter(r2, "align");
        this.i = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void setLyricOneLineMaxWidth(float r2) {
        if (r2 <= 0) goto L6;
        this.o.f(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void setLyricVisible(int r2) {
        setBusinessVisible(r2);
        if (getVisibility() == r2) goto L6;
        setVisibility(r2);
        return;
    }

    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.J = r1;
    }

    public void setTypeName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.K = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void updateCurrentState(KtvRoomLyricsStateMachineConfig.d r1) {
        this.k = r1;
    }

    public MvLyricSurfaceView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.i = Paint.Align.LEFT;
        this.j = true;
        this.l = h.m();
        this.m = h.v();
        this.n = h.s();
        LyricsDisplayConfig r4 = new LyricsDisplayConfig();
        this.o = r4;
        this.p = new ArrayList();
        this.r = new LinkedHashMap();
        this.u = r4.k;
        this.v = new Rect();
        this.w = new Rect();
        this.H = new RectF();
        this.I = new d();
        this.K = "lyric";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void addLyrics(List<com.bytedance.component.lyric.model.b> r7, long r8) {
        this.q = r7;
        int r1 = 0;
        if (this.o.d <= 0) goto L5;
    L9:
        StringBuilder r0 = new StringBuilder("addLyrics ");
        if (r7 == null) goto L12;
        Integer r2 = Integer.valueOf(r7.size());
    L13:
        r0.append(r2);
        String r3 = r0.toString();
        ALogger.i(bb0.b.b().concat("-lyric-mv_lyric_glImpl"), r3 + ", invoke class :MvLyricSurfaceView");
        this.p.clear();
        this.s = 0;
        this.v.setEmpty();
        this.H.setEmpty();
        this.w.setEmpty();
        ((LinkedHashMap) this.r).clear();
        this.y = 0;
        if (r7 == null) goto L22;
        Iterator<com.bytedance.component.lyric.model.b> r4 = r7.iterator();
    L17:
        if (r4.hasNext() == false) goto L22;
        com.bytedance.component.lyric.model.b r5 = r4.next();
        if (TextUtils.isEmpty(r5.d) == true) goto L17;
        adjustAddLyricsLine(r5, false);
    L22:
        if (this.C <= 0) goto L24;
        r8 = this.C;
    L24:
        this.y = l(r8);
        if (getMeasuredWidth() > 0) goto L27;
    L28:
        measure(0, 0);
    L30:
        if (r7 == null) goto L40;
        Iterator<T> r9 = r7.iterator();
        int r6 = 0;
    L33:
        if (r9.hasNext() == false) goto L40;
        com.bytedance.component.lyric.model.b r10 = (com.bytedance.component.lyric.model.b) r9.next();
        int r11 = r6 - 1;
        if (r11 <= 5) goto L39;
        if ((((com.bytedance.component.lyric.model.b) ListProtector.get(r7, r6)).b - ((com.bytedance.component.lyric.model.b) ListProtector.get(r7, r11)).c) <= this.n) goto L39;
        ((com.bytedance.component.lyric.model.b) ListProtector.get(r7, r11)).i = true;
        ((com.bytedance.component.lyric.model.b) ListProtector.get(r7, r6)).j = true;
    L39:
        r6 = r6 + 1;
    L40:
        if (r7 == null) goto L62;
        com.bytedance.component.lyric.model.b r12 = (com.bytedance.component.lyric.model.b) CollectionsKt.lastOrNull(r7);
        if (r12 == null) goto L63;
        r12.i = true;
        int[] r13 = r12.g;
        if (r13 == null) goto L49;
        int r14 = r13.length;
        int r15 = 0;
    L46:
        if (r1 >= r14) goto L48;
        r15 = r15 + r13[r1];
        r1 = r1 + 1;
        goto L46
    L48:
        r1 = r15;
    L49:
        if (r1 <= 0) goto L64;
        r12.m = Integer.valueOf(r1 + r12.b);
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L27:
        if (getMeasuredHeight() > 0) goto L30;
    L12:
        r2 = null;
        goto L13
    L5:
        if (getWidth() <= 0) goto L7;
        this.o.f(getWidth());
        goto L9
    L7:
        ALogger.i(bb0.b.b().concat("-lyric-mv_lyric_glImpl"), "addLyrics oneLineMaxWidth <= 0 return, invoke class :MvLyricSurfaceView");
        this.t = r7;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void adjustAddLyricsLine(com.bytedance.component.lyric.model.b r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "lyricsLineInfo");
        float r2 = this.o.d;
        ALogger.i("MvLyricSurfaceView", "adjustAddLyricsLine " + r19.d + " ;; width == " + r2);
        String r3 = r19.d;
        Paint r4 = this.o.k;
        if (r20 == false) goto L5;
        int r6 = this.p.size();
    L6:
        this.s = r6;
        if (r4.measureText(r3) > r2) goto L12;
        int r5 = this.x + 1;
        this.x = r5;
        if (this.s >= r5) goto L99;
        this.p.add(r19);
        return;
    L99:
        return;
    L12:
        int r7 = this.o.n;
        if (r7 != 2) goto L30;
        com.bytedance.component.lyric.model.b r8 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r9 = new com.bytedance.component.lyric.model.b();
        StringBuilder r10 = new StringBuilder();
        StringBuilder r11 = new StringBuilder();
        StringBuilder r12 = new StringBuilder();
        String r13 = r19.d;
        if (r13 == null) goto L82;
        int r14 = r13.length();
        int r15 = 0;
    L17:
        if (r15 >= r14) goto L23;
        char r16 = r13.charAt(r15);
        r10.append(r16);
        if (r4.measureText(r10.toString()) <= r2) goto L21;
        r12.append(r16);
    L22:
        r15 = r15 + 1;
        goto L17
    L21:
        r11.append(r16);
        goto L22
    L23:
        r8.b = r19.b;
        r8.d = r11.toString();
        int r17 = this.x + 1;
        this.x = r17;
        if (this.s >= r17) goto L26;
        this.p.add(r8);
    L26:
        r9.b = r19.b + 4000;
        r9.d = r12.toString();
        int r1 = this.x + 1;
        this.x = r1;
        if (this.s >= r1) goto L100;
        this.p.add(r9);
        return;
    L100:
        return;
    L82:
        return;
    L30:
        if (r7 != 3) goto L102;
        com.bytedance.component.lyric.model.b r18 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r21 = new com.bytedance.component.lyric.model.b();
        StringBuilder r22 = new StringBuilder();
        String[] r23 = r19.f;
        if (r23 == null) goto L103;
        ArrayList r24 = new ArrayList();
        ArrayList r110 = new ArrayList();
        ArrayList r111 = new ArrayList();
        StringBuilder r112 = new StringBuilder();
        StringBuilder r113 = new StringBuilder();
        ArrayList r114 = new ArrayList();
        int r115 = r19.b;
        int r25 = r23.length;
        int r26 = 0;
    L34:
        if (r26 >= r25) goto L48;
        int r116 = r25;
        String r27 = r23[r26];
        r22.append(r27);
        String[] r117 = r23;
        if (r4.measureText(r22.toString()) <= r2) goto L42;
        r111.add(r27);
        r113.append(r27);
        int[] r28 = r19.g;
        if (r28 == null) goto L47;
        if (r26 >= r28.length) goto L47;
        r114.add(Integer.valueOf(r28[r26]));
    L47:
        r26 = r26 + 1;
        r25 = r116;
        r23 = r117;
        goto L34
    L42:
        r24.add(r27);
        r112.append(r27);
        int[] r29 = r19.g;
        if (r29 == null) goto L47;
        if (r26 >= r29.length) goto L47;
        r110.add(Integer.valueOf(r29[r26]));
        r115 = r115 + r29[r26];
        goto L47
    L48:
        r18.b = r19.b;
        Object[] r30 = r24.toArray(new String[0]);
        if (r30 == null) goto L81;
        r18.f = (String[]) r30;
        r18.g = new int[r110.size()];
        int r31 = r110.size();
        int r32 = 0;
    L51:
        if (r32 >= r31) goto L57;
        int[] r33 = r18.g;
        if (r33 == null) goto L55;
        r33[r32] = ((Number) ListProtector.get(r110, r32)).intValue();
    L55:
        r32 = r32 + 1;
        goto L51
    L57:
        if (this.m == false) goto L63;
        String r34 = r112.toString();
        if (r34 == null) goto L62;
        r18.d = StringsKt.trim(r34).toString();
    L64:
        int r35 = this.x + 1;
        this.x = r35;
        if (this.s >= r35) goto L67;
        this.p.add(r18);
    L67:
        r21.b = r115;
        Object[] r36 = r111.toArray(new String[0]);
        if (r36 == null) goto L79;
        r21.f = (String[]) r36;
        r21.g = new int[r114.size()];
        int r37 = r114.size();
        int r38 = 0;
    L70:
        if (r38 >= r37) goto L75;
        int[] r39 = r21.g;
        if (r39 == null) goto L74;
        r39[r38] = ((Number) ListProtector.get(r114, r38)).intValue();
    L74:
        r38 = r38 + 1;
        goto L70
    L75:
        r21.d = r113.toString();
        int r40 = this.x + 1;
        this.x = r40;
        if (this.s >= r40) goto L104;
        this.p.add(r21);
        return;
    L104:
        return;
    L79:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L63:
        r18.d = r112.toString();
        goto L64
    L81:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L103:
        return;
    L102:
        return;
    L5:
        r6 = 0;
        goto L6
    }

    public final ValueAnimator m(int r5, int r6) {
        if (KtvSettingHelper.z() == false) goto L5;
        LiveDegradeFpsAnimator r7 = LiveDegradeFpsAnimator.ofInt(new int[]{r5, r6}).setFpsConfig(KtvSettingHelper.k());
    L6:
        r7.setDuration(250);
        r7.addUpdateListener(new b(this));
        return r7;
    L5:
        r7 = ValueAnimator.ofInt(new int[]{r5, r6});
        goto L6
    }

    public final void g(Canvas r4, int r5, ArrayList<com.bytedance.component.lyric.model.b> r6, boolean r7) {
        if (r5 >= r6.size()) goto L32;
        if (r5 < 0) goto L35;
        String r8 = ((com.bytedance.component.lyric.model.b) ListProtector.get(r6, r5)).d;
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        if (r7 == false) goto L11;
        float r0 = this.z;
        Paint r1 = this.o.k;
    L12:
        this.u = r1;
        h(r4, r5, r8, r0);
        if (r7 == true) goto L15;
        return;
    L15:
        if (this.o.n != 3) goto L34;
        r4.save();
        r4.clipRect(this.H);
        if (this.o.o == false) goto L19;
        this.u.setStrokeWidth(UtilityKotlinExtentionsKt.h(2.0f));
    L20:
        h(r4, r5, r8, r0);
        this.u.setStrokeWidth(0.0f);
        Paint.Align r9 = this.i;
        Paint.Align r2 = Paint.Align.RIGHT;
        if (r9 != r2) goto L27;
        if ((r5 % 2) != 0) goto L25;
        Paint r10 = this.o.l;
        float r11 = this.B;
        r10.setTextAlign(r2);
        r4.drawText(r8, r4.getWidth(), (r4.getHeight() / 4.0f) + r11, r10);
    L30:
        r4.restore();
        return;
    L25:
        i(r4, this.o.l, r8, this.B);
        goto L30
    L27:
        if ((r5 % 2) != 0) goto L29;
        Paint r12 = this.o.l;
        float r13 = this.B;
        r12.setTextAlign(Paint.Align.LEFT);
        r4.drawText(r8, 0.0f, (r4.getHeight() / 4.0f) + r13, r12);
        goto L30
    L29:
        i(r4, this.o.l, r8, this.B);
        goto L30
    L19:
        this.u.setStrokeWidth(0.0f);
        goto L20
    L34:
        return;
    L11:
        r0 = this.A;
        r1 = this.o.i;
        goto L12
    L35:
        return;
    }

    public final void h(Canvas r4, int r5, String r6, float r7) {
        Paint.Align r0 = this.i;
        Paint.Align r1 = Paint.Align.RIGHT;
        if (r0 != r1) goto L9;
        if ((r5 % 2) != 0) goto L7;
        Paint r8 = this.u;
        r8.setTextAlign(r1);
        r4.drawText(r6, r4.getWidth(), (r4.getHeight() / 4.0f) + r7, r8);
        return;
    L7:
        i(r4, this.u, r6, r7);
        return;
    L9:
        if ((r5 % 2) != 0) goto L11;
        Paint r9 = this.u;
        r9.setTextAlign(Paint.Align.LEFT);
        r4.drawText(r6, 0.0f, (r4.getHeight() / 4.0f) + r7, r9);
        return;
    L11:
        i(r4, this.u, r6, r7);
    }

    public final void i(Canvas r4, Paint r5, String r6, float r7) {
        r5.setTextAlign(Paint.Align.RIGHT);
        r4.drawText(r6, r4.getWidth(), ((r4.getHeight() / 4) * 3.0f) + r7, r5);
    }

    public final void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r1, "holder");
        Function2<Boolean, Long, Unit> r5 = getOneDrawCallback();
        if (r5 == null) goto L6;
        Unit r6 = (Unit) r5.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        return;
    }
}
