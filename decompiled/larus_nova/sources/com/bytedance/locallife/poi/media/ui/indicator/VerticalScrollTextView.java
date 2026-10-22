package com.bytedance.locallife.poi.media.ui.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/indicator/VerticalScrollTextView;", "Landroid/view/View;", "", "value", "h", "Ljava/lang/String;", "setMNewText", "(Ljava/lang/String;)V", "mNewText", RXScreenCaptureService.KEY_INDEX, "setMOldText", "mOldText", "", ce.f26395j, FaceService.girlLabel, "setMPositionOffset", "(F)V", "mPositionOffset", "", ce.f26396k, "I", "setMOuterMoveHeight", "(I)V", "mOuterMoveHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class VerticalScrollTextView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f262870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f262871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f262872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f262873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f262874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f262875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f262876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f262877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f262878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f262879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f262880k;

    public static final class a {
    }

    static {
    }

    public VerticalScrollTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VerticalScrollTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int a() {
        float r100 = Math.max(this.f262875f.height() * 3, this.f262876g.height() * 3);
        this.f262871b = r100;
        return (int) ((r100 + getPaddingTop()) + getPaddingBottom());
    }

    public final int b() {
        return (Math.max(this.f262875f.width() + this.f262870a, this.f262876g.width() + this.f262870a) + getPaddingLeft()) + getPaddingRight();
    }

    private final void setMNewText(String r100) {
        if (Intrinsics.areEqual(this.f262877h, r100) == false) goto L5;
        return;
    L5:
        this.f262877h = r100;
        this.f262872c.getTextBounds(r100, 0, r100.length(), this.f262875f);
    }

    private final void setMOldText(String r100) {
        if (Intrinsics.areEqual(this.f262878i, r100) == false) goto L5;
        return;
    L5:
        this.f262878i = r100;
        this.f262872c.getTextBounds(r100, 0, r100.length(), this.f262876g);
    }

    private final void setMOuterMoveHeight(int r100) {
        if (this.f262880k != r100) goto L5;
        return;
    L5:
        this.f262880k = r100;
    }

    private final void setMPositionOffset(float r100) {
        if (this.f262879j != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        this.f262879j = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f262875f.width();
        this.f262875f.height();
        this.f262876g.width();
        this.f262876g.height();
        getMeasuredWidth();
        getWidth();
        getMeasuredHeight();
        getHeight();
        float r101 = 255;
        this.f262872c.setAlpha((int) (this.f262879j * r101));
        r100.drawText(this.f262877h, (getMeasuredWidth() / 2.0f) - (this.f262875f.width() / 2.0f), ((this.f262880k * (1.0f - this.f262879j)) + (getMeasuredHeight() / 2.0f)) + (this.f262875f.height() / 2.0f), this.f262872c);
        this.f262872c.setAlpha((int) (r101 * (1 - this.f262879j)));
        r100.drawText(this.f262878i, (getMeasuredWidth() / 2.0f) - (this.f262876g.width() / 2.0f), ((this.f262880k * (-this.f262879j)) + (getMeasuredHeight() / 2.0f)) + (this.f262876g.height() / 2.0f), this.f262872c);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f262875f.width();
        this.f262875f.height();
        this.f262876g.width();
        this.f262876g.height();
        this.f262873d = b();
        this.f262874e = a();
        setMeasuredDimension(View.resolveSize(this.f262873d, r100), View.resolveSize(this.f262874e, r101));
    }

    public VerticalScrollTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f262870a = (int) UIUtils.dip2Px(r100, 1.0f);
        this.f262871b = UIUtils.sp2px(r100, 3 * 14.0f);
        Paint r103 = new Paint(5);
        r103.setColor(-1);
        r103.setTextSize(UIUtils.sp2px(r100, 14.0f));
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        int r105 = PoiVerticalPagerIndicator.f262856l;     // Catch: Throwable -> L5
        r103.setTypeface(PoiVerticalPagerIndicator.a.a(r100));     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        this.f262872c = r103;
        this.f262875f = new Rect();
        this.f262876g = new Rect();
        this.f262877h = "";
        this.f262878i = "";
        this.f262880k = (int) this.f262871b;
        if (r101 == null) goto L13;
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.poiTextColor, R.attr.poiTextSize});
        int r107 = r106.getColor(0, -1);
        float r108 = r106.getDimension(1, UIUtils.sp2px(r100, 14.0f));
        r106.recycle();
        r103.setColor(r107);
        r103.setTextSize(r108);
        setMOuterMoveHeight((int) r108);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void c(String r100, String r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "position");
        Intrinsics.checkNotNullParameter(r101, "nextPosition");
        setMOldText(r100);
        setMNewText(r101);
        setMPositionOffset(r102);
        boolean r103 = true;
        if (this.f262873d == b()) goto L5;
        boolean r104 = true;
    L7:
        if (this.f262874e != a()) goto L10;
        r103 = false;
    L10:
        if (r104 == true) goto L12;
        if (r103 == true) goto L12;
    L13:
        invalidate();
        return;
    L12:
        requestLayout();
        goto L13
    L5:
        r104 = false;
        goto L7
    }

    public /* synthetic */ VerticalScrollTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
