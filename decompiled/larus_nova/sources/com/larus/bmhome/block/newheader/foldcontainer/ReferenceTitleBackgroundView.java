package com.larus.bmhome.block.newheader.foldcontainer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\n\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u001b2\u0006\u0010'\u001a\u00020\u0001H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/bmhome/block/newheader/foldcontainer/ReferenceTitleBackgroundView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "titlePaint", "Landroid/graphics/Paint;", "fallbackBackgroundPaint", "titleRect", "Landroid/graphics/RectF;", "titlePath", "Landroid/graphics/Path;", "locationInWindow", "", "hostLocationInWindow", "topCornerRadius", "", "enableTopRoundCorner", "", "showTitleBackground", "backgroundHost", "backgroundSource", "Landroid/graphics/drawable/Drawable;", "backgroundDrawable", "updateTitleBackground", "", "clearTitleBackground", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawOuterBackground", "drawTitleSurface", "findListBackgroundHost", "copyBackgroundDrawableIfNeeded", "host", "refreshPaintColors", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferenceTitleBackgroundView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f296339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f296340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f296341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f296342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f296343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f296344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f296345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f296346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f296347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f296348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f296349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f296350l;

    public ReferenceTitleBackgroundView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReferenceTitleBackgroundView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        this.f296339a.setColor(ContextCompat.getColor(getContext(), c.b(R.attr.larus_base_2_overlay, getContext(), R.color.larus_base_2_overlay)));
        this.f296340b.setColor(ContextCompat.getColor(getContext(), c.b(R.attr.larus_base_1, getContext(), R.color.larus_base_1)));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f296347i == true) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
        return;
    L7:
        if (getHeight() > 0) goto L10;
        return;
    L10:
        if (this.f296346h == false) goto L49;
        boolean r100 = false;
        View r101 = this;
    L12:
        Drawable r102 = null;
        if (r101 == null) goto L29;
        if ((r101 instanceof RecyclerView) == false) goto L17;
        r100 = true;
    L17:
        if (r100 == true) goto L19;
    L25:
        Object r103 = r101.getParent();
        if ((r103 instanceof View) == true) goto L27;
        r101 = null;
        goto L12
    L27:
        r101 = (View) r103;
        goto L12
    L19:
        if (r101.getBackground() == null) goto L25;
        if (r101.getWidth() <= 0) goto L25;
        if (r101.getHeight() <= 0) goto L25;
    L30:
        if (r101 == null) goto L45;
        Drawable r104 = r101.getBackground();
        if (r104 == null) goto L45;
        if (this.f296348j == r101) goto L37;
    L38:
        this.f296348j = r101;
        this.f296349k = r104;
        Drawable.ConstantState r105 = r104.getConstantState();
        if (r105 == null) goto L43;
        Drawable r106 = r105.newDrawable(r101.getResources());
        if (r106 == null) goto L43;
        r102 = r106.mutate();
    L43:
        this.f296350l = r102;
    L44:
        r102 = this.f296350l;
        goto L45
    L37:
        if (this.f296349k == r104) goto L44;
    L45:
        if (r101 == null) goto L48;
        if (r102 == null) goto L48;
        getLocationInWindow(this.f296343e);
        r101.getLocationInWindow(this.f296344f);
        int[] r107 = this.f296344f;
        int r108 = r107[0];
        int[] r109 = this.f296343e;
        int r111 = r108 - r109[0];
        int r112 = r107[1] - r109[1];
        r102.setBounds(r111, r112, r101.getWidth() + r111, r101.getHeight() + r112);
        r102.draw(r110);
    L48:
        r110.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f296340b);
        goto L49
    L29:
        r101 = null;
    L49:
        this.f296341c.set(0.0f, 0.0f, getWidth(), getHeight());
        if (this.f296346h == true) goto L52;
        r110.drawRect(this.f296341c, this.f296339a);
        return;
    L52:
        this.f296342d.reset();
        Path r113 = this.f296342d;
        RectF r114 = this.f296341c;
        float r115 = this.f296345g;
        r113.addRoundRect(r114, new float[]{r115, r115, r115, r115, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        r110.drawPath(this.f296342d, this.f296339a);
    }

    public ReferenceTitleBackgroundView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f296339a = new Paint(1);
        this.f296340b = new Paint(1);
        this.f296341c = new RectF();
        this.f296342d = new Path();
        this.f296343e = new int[2];
        this.f296344f = new int[2];
        this.f296345g = r100.getResources().getDimension(c.b(R.attr.larus_dp_16, r100, R.dimen.larus_dp_16));
        this.f296346h = true;
        this.f296347i = true;
        setWillNotDraw(false);
        a();
    }

    public /* synthetic */ ReferenceTitleBackgroundView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
