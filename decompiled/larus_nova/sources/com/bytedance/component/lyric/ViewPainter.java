package com.bytedance.component.lyric;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.col.s.ce;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import jg4.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010E\u001a\u00020D\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F¢\u0006\u0004\bH\u0010IJ@\u0010\u000b\u001a\u00020\t26\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003H\u0016R\"\u0010\u000f\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010=\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u000e\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u001a\u0010C\u001a\u00020>8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006J"}, d2 = {"Lcom/bytedance/component/lyric/ViewPainter;", "Landroid/view/View;", "Ljg4/f;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "cb", "setSizeChangeListener", "", "d", "Z", "isAnimating", "()Z", "setAnimating", "(Z)V", "Landroid/animation/ValueAnimator;", "e", "Landroid/animation/ValueAnimator;", "getScrollAnimator", "()Landroid/animation/ValueAnimator;", "setScrollAnimator", "(Landroid/animation/ValueAnimator;)V", "scrollAnimator", "f", "I", "getAnimationY", "()I", "setAnimationY", "(I)V", "animationY", "Landroid/graphics/RectF;", ce.f26391f, "Landroid/graphics/RectF;", "getDynamicRectF", "()Landroid/graphics/RectF;", "setDynamicRectF", "(Landroid/graphics/RectF;)V", "dynamicRectF", "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", ce.f26396k, "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "getDisplayConfig", "()Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "setDisplayConfig", "(Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;)V", "displayConfig", "Ljg4/j;", "l", "Ljg4/j;", "getLyricRequest", "()Ljg4/j;", "setLyricRequest", "(Ljg4/j;)V", "lyricRequest", "m", "getInScroll", "setInScroll", "inScroll", "Landroid/graphics/Rect;", OfficeSDKRequestTag.KEY_NEW_USER, "Landroid/graphics/Rect;", "getLyricsRect", "()Landroid/graphics/Rect;", "lyricsRect", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lib-lyric_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ViewPainter extends View implements jg4.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.component.lyric.model.b f202974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jg4.a f202975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f202976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f202977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f202978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f202979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f202980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f202981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f202982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f202983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LyricsDisplayConfig f202984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public j f202985l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f202986m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f202987n;

    @Override // jg4.f
    public final void reset() {
        this.f202974a = null;
        this.f202975b = null;
        this.f202977d = false;
        ValueAnimator r100 = this.f202978e;
        if (r100 != null) goto L5;
    L9:
        this.f202976c = -1;
        this.f202979f = 0;
        this.f202980g = new RectF();
        invalidate();
        return;
    L5:
        if (r100.isRunning() != true) goto L9;
        ValueAnimator r101 = this.f202978e;
        if (r101 == null) goto L9;
        r101.cancel();
        goto L9
    }

    public final int getAnimationY() {
        return this.f202979f;
    }

    public final LyricsDisplayConfig getDisplayConfig() {
        return this.f202984k;
    }

    public final RectF getDynamicRectF() {
        return this.f202980g;
    }

    public final boolean getInScroll() {
        return this.f202986m;
    }

    public final j getLyricRequest() {
        return this.f202985l;
    }

    public final Rect getLyricsRect() {
        return this.f202987n;
    }

    public final ValueAnimator getScrollAnimator() {
        return this.f202978e;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        com.bytedance.component.lyric.model.b r100 = this.f202974a;
        if (r100 == null) goto L69;
        LyricsDisplayConfig r101 = this.f202984k;
        Typeface r102 = r101.f203025t;
        r101.f203016k.setTypeface(r102);
        this.f202984k.f203017l.setTypeface(r102);
        this.f202984k.f203014i.setTypeface(r102);
        LyricsDisplayConfig r103 = this.f202984k;
        Float r104 = r103.f203023r;
        if (r104 == null) goto L7;
        r103.f203016k.setTextSize(r104.floatValue());
        this.f202984k.f203017l.setTextSize(r104.floatValue());
    L7:
        LyricsDisplayConfig r105 = this.f202984k;
        Float r106 = r105.f203024s;
        if (r106 == null) goto L10;
        r105.f203014i.setTextSize(r106.floatValue());
    L10:
        String r107 = r100.f203031d;
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        Rect r108 = this.f202987n;
        Paint r109 = this.f202984k.f203016k;
        j r111 = this.f202985l;
        if (r111 == null) goto L16;
        Map<String, Rect> r112 = r111.f498993i;
    L17:
        r108.set(b(r109, r112, r107));
        ig4.c r113 = this.f202984k.f203013h;
        int r114 = getMeasuredWidth();
        getMeasuredHeight();
        float r115 = r113.c(r114);
        int r116 = 1;
        if (this.f202986m == false) goto L20;
        this.f202981h = this.f202984k.f203012g + 1;
    L22:
        if (this.f202981h <= 1) goto L24;
        int r117 = getMeasuredHeight() / (this.f202981h + 1);
    L25:
        ig4.c r118 = this.f202984k.f203013h;
        getMeasuredWidth();
        float r119 = r118.d(r117, this.f202979f, this.f202987n);
        if (this.f202984k.f203012g >= 0) goto L28;
        this.f202981h = 0;
    L28:
        int r120 = this.f202981h;
    L29:
        float r121 = 0.0f;
        if (r116 >= r120) goto L44;
        boolean r122 = r100.f203035h;
        j r123 = this.f202985l;
        if (r123 == null) goto L43;
        com.bytedance.component.lyric.model.b r124 = (com.bytedance.component.lyric.model.b) kg4.a.c(r123.f498989e, this.f202976c + r116);
        if (r124 == null) goto L37;
        String r125 = r124.f203031d;
        if (r125 == null) goto L37;
    L38:
        this.f202982i.set(b(this.f202984k.f203014i, r123.f498992h, r125));
        if (r122 == false) goto L41;
        r121 = this.f202984k.f203007b;
    L41:
        if (r110 == null) goto L43;
        float r126 = (this.f202982i.height() * r116) + r119;
        LyricsDisplayConfig r127 = this.f202984k;
        float r128 = r127.f203006a;
        float r129 = kg4.a.f503371a;
        r110.drawText(r125, r115, (r126 + (((int) ((r128 * r129) + 0.5f)) * r116)) + ((int) ((r121 * r129) + 0.5f)), r127.f203014i);
    L37:
        r125 = "";
    L43:
        r116 = r116 + 1;
        goto L29
    L44:
        r110.save();
        jg4.a r130 = this.f202975b;
        if (r130 != null) goto L47;
    L49:
        LyricsDisplayConfig r131 = this.f202984k;
        Float r132 = r131.f203015j;
        if (r132 != null) goto L52;
    L56:
        LyricsDisplayConfig r133 = this.f202984k;
        Shader r134 = r133.f203022q;
        if (r134 == null) goto L59;
        r133.f203017l.setShader(r134);
    L59:
        r110.drawText(r107, r115, r119, this.f202984k.f203017l);
        r110.restore();
        jg4.a r135 = this.f202975b;
        if (r135 != null) goto L62;
        return;
    L62:
        if (r135.f498984g != 3) goto L71;
        r110.clipRect(this.f202980g);
        r110.drawText(r107, r115, r119, this.f202984k.f203016k);
        return;
    L71:
        return;
    L52:
        if (r131.f203020o == false) goto L54;
        r131.f203016k.setStrokeWidth(r132.floatValue());
    L55:
        r110.drawText(r107, r115, r119, this.f202984k.f203016k);
        this.f202984k.f203016k.setStrokeWidth(0.0f);
        goto L56
    L54:
        r131.f203016k.setStrokeWidth(0.0f);
        goto L55
    L47:
        if (r130.f498984g != 3) goto L49;
        RectF r136 = this.f202980g;
        r110.clipRect(0.0f, 0.0f, r136.left, r136.bottom);
        goto L49
    L24:
        r117 = getMeasuredHeight();
        goto L25
    L20:
        this.f202981h = this.f202984k.f203012g;
        goto L22
    L16:
        r112 = null;
        goto L17
    }

    public final void setAnimating(boolean r100) {
        this.f202977d = r100;
    }

    public final void setAnimationY(int r100) {
        this.f202979f = r100;
    }

    public final void setDisplayConfig(LyricsDisplayConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f202984k = r100;
    }

    public final void setDynamicRectF(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f202980g = r100;
    }

    public final void setInScroll(boolean r100) {
        this.f202986m = r100;
    }

    public final void setLyricRequest(j r100) {
        this.f202985l = r100;
    }

    public final void setScrollAnimator(ValueAnimator r100) {
        this.f202978e = r100;
    }

    @Override // jg4.f
    public void setSizeChangeListener(Function2<? super Integer, ? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.f202983j = r100;
    }

    public ViewPainter(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f202976c = -1;
        this.f202980g = new RectF();
        this.f202981h = 2;
        this.f202982i = new Rect();
        this.f202984k = new LyricsDisplayConfig();
        this.f202987n = new Rect();
    }

    public static Rect b(Paint r100, Map r101, String r102) {
        if (r101 != null) goto L4;
    L6:
        Rect r103 = new Rect();
        r100.getTextBounds(r102, 0, r102.length(), r103);
        if (r101 == null) goto L9;
        r101.put(r102, r103);
    L9:
        Rect r104 = r103;
    L10:
        if (r104 == null) goto L12;
        return r104;
    L12:
        return new Rect();
    L4:
        if (r101.get(r102) == null) goto L6;
        r104 = (Rect) r101.get(r102);
        goto L10
    }

    @Override // jg4.f
    public final void a(j r110, jg4.a r111, LyricsDisplayConfig r112) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "node");
        Intrinsics.checkNotNullParameter(r112, "displayConfig");
        if ((!Intrinsics.areEqual(r110, this.f202985l)) == false) goto L5;
        reset();
    L5:
        this.f202985l = r110;
        this.f202984k = r112;
        this.f202975b = r111;
        ig4.c.b(r112.f203013h, this.f202980g, getMeasuredHeight(), getMeasuredWidth(), r111.f498978a, r111.f498979b);
        if (r111.f498981d >= 0) goto L9;
        return;
    L9:
        if (this.f202977d == false) goto L11;
    L38:
        invalidate();
        return;
    L11:
        if (this.f202976c == r111.f498980c) goto L38;
        Intrinsics.checkNotNullParameter(r111, "node");
        int r113 = r111.f498980c;
        ValueAnimator r114 = this.f202978e;
        if (r114 != null) goto L15;
    L26:
        this.f202977d = true;
        Ref.IntRef r115 = new Ref.IntRef();
        r115.element = -1;
        Ref.IntRef r100 = new Ref.IntRef();
        r100.element = 0;
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, this.f202987n.height()});
        this.f202978e = r101;
        if (r101 == null) goto L29;
        r101.setDuration(230);
    L29:
        ValueAnimator r102 = this.f202978e;
        if (r102 == null) goto L32;
        r102.addUpdateListener(new e(this, r100, r115));
    L32:
        ValueAnimator r116 = this.f202978e;
        if (r116 == null) goto L35;
        r116.addListener(new f(this, r113, r111));
    L35:
        ValueAnimator r117 = this.f202978e;
        if (r117 == null) goto L40;
        r117.start();
        return;
    L40:
        return;
    L15:
        if (r114.isRunning() != true) goto L26;
        ValueAnimator r118 = this.f202978e;
        if (r118 == null) goto L19;
        r118.cancel();
    L19:
        ValueAnimator r119 = this.f202978e;
        if (r119 == null) goto L22;
        r119.removeAllUpdateListeners();
    L22:
        ValueAnimator r120 = this.f202978e;
        if (r120 == null) goto L25;
        r120.removeAllListeners();
    L25:
        this.f202979f = 0;
        goto L26
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r110) {
        Function2<? super Integer, ? super Integer, Unit> r103 = this.f202983j;
        if (r103 == null) goto L5;
        Unit r104 = r103.invoke(Integer.valueOf(r100), Integer.valueOf(r101));
    L5:
        jg4.a r105 = this.f202975b;
        if (r105 == null) goto L9;
        ig4.c.b(this.f202984k.f203013h, this.f202980g, r100, r101, r105.f498978a, r105.f498979b);
        return;
    }
}
