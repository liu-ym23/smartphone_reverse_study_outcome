package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000e\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/GSBottomBackGroundView;", "Landroid/widget/FrameLayout;", "", "topBias", "", "setTopBias", "Landroid/graphics/Paint;", "d", "Lkotlin/Lazy;", "getPaint", "()Landroid/graphics/Paint;", "paint", "f", "getStrokePaint", "strokePaint", "Landroid/graphics/Path;", ce.f26391f, "getPath", "()Landroid/graphics/Path;", "path", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GSBottomBackGroundView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GSBackGroundViewGradientContext f450186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GSBackGroundViewOutLineContext f450187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f450188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f450189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearGradient f450190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f450191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f450192g;

    public GSBottomBackGroundView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GSBottomBackGroundView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Paint getPaint() {
        return (Paint) this.f450189d.getValue();
    }

    private final Path getPath() {
        return (Path) this.f450192g.getValue();
    }

    private final Paint getStrokePaint() {
        return (Paint) this.f450191f.getValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.drawPath(getPath(), getStrokePaint());
        r100.drawPath(getPath(), getPaint());
    }

    public final void setTopBias(int r110) {
        this.f450188c = r110;
        getPath().reset();
        Path r100 = getPath();
        float r101 = getStrokePaint().getStrokeWidth();
        float r102 = getStrokePaint().getStrokeWidth() + r110;
        float r103 = getWidth() - getStrokePaint().getStrokeWidth();
        float r104 = getHeight() - getStrokePaint().getStrokeWidth();
        float r105 = this.f450187b.f450185c;
        r100.addRoundRect(r101, r102, r103, r104, r105, r105, Path.Direction.CW);
        invalidate();
    }

    public GSBottomBackGroundView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f450186a = new GSBackGroundViewGradientContext(0);
        this.f450187b = new GSBackGroundViewOutLineContext(0);
        setWillNotDraw(false);
        setOutlineProvider(new AnonymousClass1(this));
        setClipToOutline(true);
        this.f450189d = LazyKt.lazy(GSBottomBackGroundView$paint$2.INSTANCE);
        this.f450191f = LazyKt.lazy(GSBottomBackGroundView$strokePaint$2.INSTANCE);
        this.f450192g = LazyKt.lazy(GSBottomBackGroundView$path$2.INSTANCE);
    }

    public /* synthetic */ GSBottomBackGroundView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(final int r100, final int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        Function1<GSBackGroundViewGradientContext, GSBackGroundViewGradientContext> r113 = new C122781(r100, r110);
        Intrinsics.checkNotNullParameter(r113, "change");
        this.f450186a = r113.invoke(this.f450186a);
        float r101 = getWidth() * this.f450186a.f450177c;
        float r102 = getHeight() * this.f450186a.f450178d;
        float r103 = getWidth() * this.f450186a.f450179e;
        float r104 = getHeight() * this.f450186a.f450180f;
        GSBackGroundViewGradientContext r114 = this.f450186a;
        this.f450190e = new LinearGradient(r101, r102, r103, r104, new int[]{r114.f450175a, r114.f450176b}, null, Shader.TileMode.CLAMP);
        float r115 = this.f450186a.f450177c;
        getWidth();
        float r116 = this.f450186a.f450178d;
        getHeight();
        getPaint().setShader(this.f450190e);
        invalidate();
        AnonymousClass2 r117 = AnonymousClass2.INSTANCE;
        Intrinsics.checkNotNullParameter(r117, "change");
        this.f450187b = r117.invoke(this.f450187b);
        Paint r105 = getStrokePaint();
        r105.setColor(this.f450187b.f450183a);
        r105.setStrokeWidth(this.f450187b.f450184b);
        getPath();
        getPath().reset();
        Path r106 = getPath();
        float r107 = getStrokePaint().getStrokeWidth();
        float r108 = this.f450188c + getStrokePaint().getStrokeWidth();
        float r109 = getWidth() - getStrokePaint().getStrokeWidth();
        float r118 = getHeight() - getStrokePaint().getStrokeWidth();
        float r119 = this.f450187b.f450185c;
        r106.addRoundRect(r107, r108, r109, r118, r119, r119, Path.Direction.CW);
        invalidate();
    }
}
