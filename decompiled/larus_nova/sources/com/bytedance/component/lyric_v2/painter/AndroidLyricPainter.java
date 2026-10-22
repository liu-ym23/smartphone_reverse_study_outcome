package com.bytedance.component.lyric_v2.painter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.component.lyric_v2.model.LyricAlignType;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ng4.i;
import ng4.l;
import ng4.n;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/component/lyric_v2/painter/AndroidLyricPainter;", "Landroid/view/View;", "Lng4/i;", "Lng4/n;", "listener", "", "setSizeChangeListener", "Lmg4/b;", "getFontMetrics", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-lyric_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AndroidLyricPainter extends View implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f203060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f203061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f203062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ng4.c f203063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f203064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public mg4.d f203065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f203066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final mg4.h f203067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f203068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public qg4.b f203069j;

    public AndroidLyricPainter(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AndroidLyricPainter(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // ng4.i
    public final void reset() {
        this.f203063d = null;
        this.f203062c = null;
        this.f203064e = 0;
        d r100 = this.f203066g;
        ValueAnimator r101 = r100.f203077b;
        if (r101 == null) goto L5;
        r101.removeAllUpdateListeners();
    L5:
        ValueAnimator r102 = r100.f203077b;
        if (r102 == null) goto L8;
        r102.removeAllListeners();
    L8:
        r100.f203077b = null;
        r100.f203078c = 0.0f;
        r100.f203079d = 0.0f;
        r100.f203076a = false;
        this.f203065f = null;
        e r103 = this.f203068i;
        ((LinkedHashMap) r103.f203080a).clear();
        ((LinkedHashMap) r103.f203081b).clear();
        ((LinkedHashMap) r103.f203082c).clear();
        ((LinkedHashMap) r103.f203083d).clear();
        invalidate();
    }

    @Override // ng4.i
    public mg4.b getFontMetrics() {
        Paint.FontMetrics r100 = this.f203068i.a(this.f203061b.f203087a);
        Intrinsics.checkNotNullParameter(r100, "$this$toCustomFontMetrics");
        return new mg4.b(r100.top, r100.ascent, r100.descent, r100.bottom, r100.leading);
    }

    @Override // ng4.i
    public final void b(pg4.c r110) {
        Intrinsics.checkNotNullParameter(r110, "config");
        LyricAlignType r100 = r110.f529194z;
        if (r100 != LyricAlignType.MV) goto L5;
        qg4.b r101 = new qg4.c();
    L6:
        this.f203069j = r101;
        float r102 = r110.f529193y;
        int r103 = r110.f529192x;
        mg4.d r104 = this.f203065f;
        if (r104 == null) goto L16;
        Intrinsics.checkNotNull(r104);
        if (r104.f513728b != r102) goto L16;
        mg4.d r105 = this.f203065f;
        Intrinsics.checkNotNull(r105);
        if (r105.f513727a != r103) goto L16;
        mg4.d r106 = this.f203065f;
        Intrinsics.checkNotNull(r106);
        if (r106.f513729c != r100) goto L16;
        boolean r107 = false;
    L18:
        if (r107 == false) goto L32;
        int r108 = mg4.f.f513732a;
        Intrinsics.checkNotNullParameter(r100, "alignType");
        int r109 = mg4.e.f513731a[r100.ordinal()];
        if (r109 == 1) goto L30;
        if (r109 == 2) goto L29;
        if (r109 != 3) goto L24;
        mg4.d r111 = new mg4.a();
    L31:
        r111.f513727a = r103;
        r111.f513728b = r102;
        r111.f513729c = r100;
        this.f203065f = r111;
        goto L32
    L24:
        if (r109 != 4) goto L27;
        r111 = new mg4.g();
        goto L31
    L27:
        throw new NoWhenBranchMatchedException();
    L29:
        r111 = new mg4.i();
        goto L31
    L30:
        r111 = new mg4.c();
    L32:
        g r112 = this.f203061b;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r100, "alignType");
        int r113 = f.f203086a[r100.ordinal()];
        if (r113 == 1) goto L39;
        if (r113 == 2) goto L38;
        if (r113 == 3) goto L37;
        Paint.Align r114 = Paint.Align.LEFT;
        Pair r115 = new Pair(r114, r114);
    L40:
        Paint.Align r116 = (Paint.Align) r115.component1();
        Paint.Align r117 = (Paint.Align) r115.component2();
        g.a(r112.f203087a, r110, r116, false);
        g.a(r112.f203088b, r110, r116, true);
        Paint r118 = r112.f203089c;
        if (r118.getColor() == ColorProtector.parseColor(r110.f529188t)) goto L43;
    L52:
        r118.setColor(ColorProtector.parseColor(r110.f529188t));
        r118.setTextSize(r110.f529187s);
        r118.setFakeBoldText(r110.f529189u);
        r118.setLetterSpacing(r110.f529190v);
        r118.setStrokeWidth(r110.f529191w);
        r118.setTextAlign(r117);
        return;
    L43:
        if (r118.getTextSize() != r110.f529187s) goto L52;
        if (r118.isFakeBoldText() != r110.f529189u) goto L52;
        if (r118.getLetterSpacing() != r110.f529190v) goto L52;
        if (r118.getStrokeWidth() != r110.f529191w) goto L52;
        if (r118.getTextAlign() != r117) goto L52;
        return;
    L37:
        Paint.Align r119 = Paint.Align.CENTER;
        r115 = new Pair(r119, r119);
        goto L40
    L38:
        Paint.Align r120 = Paint.Align.RIGHT;
        r115 = new Pair(r120, r120);
        goto L40
    L39:
        r115 = new Pair(Paint.Align.LEFT, Paint.Align.RIGHT);
    L16:
        r107 = true;
        goto L18
    L5:
        r101 = new qg4.d();
        goto L6
    }

    @Override // ng4.i
    public final float c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return this.f203061b.f203087a.measureText(r100);
    }

    public final void d(ng4.c r110) {
        Intrinsics.checkNotNullParameter(r110, "node");
        l r100 = this.f203062c;
        if (r100 == null) goto L15;
        pg4.c r101 = r100.f519077i;
        if (r101 == null) goto L16;
        e r102 = this.f203068i;
        Paint r103 = this.f203061b.f203087a;
        List<pg4.d> r104 = r100.f519071c;
        if (r104 == null) goto L12;
        pg4.d r105 = (pg4.d) CollectionsKt.getOrNull(r104, this.f203064e + 1);
        if (r105 == null) goto L12;
        String r106 = r105.f529201g;
        if (r106 == null) goto L12;
    L13:
        this.f203069j.a(r102.b(r103, r106).width(), r101, this.f203065f, this.f203064e, r110, this.f203067h, getHeight(), getWidth());
        return;
    L12:
        r106 = "";
        goto L13
    L16:
        return;
    }

    @Override // android.view.View
    public final void onDraw(final Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        final l r100 = this.f203062c;
        if (r100 != null) goto L5;
        return;
    L5:
        final ng4.c r101 = this.f203063d;
        if (r101 != null) goto L8;
        return;
    L8:
        pg4.d r102 = r101.f519066e;
        if (r102 != null) goto L11;
        return;
    L11:
        final String r103 = r102.f529201g;
        if (r103 != null) goto L14;
        return;
    L14:
        final pg4.c r104 = r100.f519077i;
        b(r104);
        mg4.d r105 = this.f203065f;
        if (r105 != null) goto L17;
        return;
    L17:
        Rect r110 = this.f203068i.b(this.f203061b.f203087a, r103);
        e r106 = this.f203068i;
        Paint r107 = this.f203061b.f203089c;
        pg4.d r108 = (pg4.d) CollectionsKt.getOrNull(r100.f519071c, this.f203064e + 1);
        if (r108 == null) goto L21;
        String r109 = r108.f529201g;
        if (r109 == null) goto L21;
    L22:
        Rect r111 = r106.b(r107, r109);
        Paint.FontMetrics r112 = this.f203068i.a(this.f203061b.f203087a);
        Paint.FontMetrics r113 = this.f203068i.a(this.f203061b.f203089c);
        qg4.b r114 = this.f203069j;
        int r115 = this.f203064e;
        int r116 = getWidth();
        int r117 = getHeight();
        d r118 = this.f203066g;
        if (r118.f203076a == false) goto L25;
        float r211 = r118.f203078c;
    L26:
        final qg4.a r119 = r114.b(r115, r104, r110, r111, r112, r113, r116, r117, r105, r211);
        float r120 = r119.f532864b;
        Paint.FontMetrics r121 = this.f203068i.a(this.f203061b.f203087a);
        mg4.h r122 = this.f203067h;
        r122.f513734b = r121.ascent + r120;
        r122.f513736d = (r120 + r121.descent) + r121.leading;
        this.f203069j.d(r210, this.f203066g, new AnonymousClass1(this, r210, r119, r104, r100, r101, r103));
        return;
    L25:
        r211 = 0.0f;
    L21:
        r109 = "";
        goto L22
    }

    @Override // ng4.i
    public void setSizeChangeListener(n r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f203060a = r100;
    }

    public AndroidLyricPainter(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f203061b = new g();
        this.f203066g = new d();
        this.f203067h = new mg4.h(0.0f, 0.0f, 0.0f, 0.0f);
        this.f203068i = new e();
        this.f203069j = new qg4.d();
    }

    @Override // ng4.i
    public final void a(l r100, ng4.c r101, pg4.c r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "node");
        Intrinsics.checkNotNullParameter(r102, "config");
        if ((!Intrinsics.areEqual(this.f203062c, r100)) == false) goto L5;
        reset();
    L5:
        this.f203062c = r100;
        this.f203063d = r101;
        int r103 = this.f203064e;
        d(r101);
        if (this.f203066g.f203076a == true) goto L11;
        int r104 = r101.f519064c;
        if (r103 == r104) goto L11;
        if (r104 <= 0) goto L11;
        this.f203064e = r104;
        e r105 = this.f203068i;
        Paint r106 = this.f203061b.f203087a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "paint");
        Paint.FontMetrics r107 = r105.a(r106);
        this.f203069j.e(this.f203066g, (r107.descent - r107.ascent) + r102.f529193y, AndroidLyricPainter$draw$1.INSTANCE);
        return;
    L11:
        invalidate();
    }

    public /* synthetic */ AndroidLyricPainter(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L12;
        if (r101 <= 0) goto L13;
        ug4.b.a(new Object[]{"onSizeChanged: 视图尺寸变化", Integer.valueOf(r100), Integer.valueOf(r101)});
        n r104 = this.f203060a;
        if (r104 == null) goto L8;
        r104.a(r100);
    L8:
        ng4.c r105 = this.f203063d;
        if (r105 == null) goto L14;
        d(r105);
        return;
    L14:
        return;
    L13:
        return;
    }
}
