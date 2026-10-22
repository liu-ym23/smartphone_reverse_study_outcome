package com.bytedance.ee.bear.bitable.card.view.table;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014J\u0012\u0010$\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u000e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/table/EmptyCoverView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "mTopCircleColor", "getMTopCircleColor", "()I", "setMTopCircleColor", "(I)V", "leftAlpha", "", "getLeftAlpha", "()F", "setLeftAlpha", "(F)V", "rightAlpha", "getRightAlpha", "setRightAlpha", "coverColor", "", "", "[[I", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawCircle", "setTopCircleColor", "color", "setTopCircleColorByIndex", "index", "getBackgroundByIndex", "Landroid/graphics/drawable/Drawable;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class EmptyCoverView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f208846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f208847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f208848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f208849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[][] f208850e;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), y9c.d.a(20));
        }
    }

    public static final class b {
    }

    static {
    }

    public EmptyCoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public EmptyCoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float getLeftAlpha() {
        return this.f208848c;
    }

    public final int getMTopCircleColor() {
        return this.f208847b;
    }

    public final Paint getPaint() {
        return this.f208846a;
    }

    public final float getRightAlpha() {
        return this.f208849d;
    }

    public void a(Canvas r100) {
        this.f208846a.setColor(this.f208847b);
        this.f208846a.setStyle(Paint.Style.FILL);
        if (r100 == null) goto L5;
        r100.drawCircle(y9c.d.a(18) + y9c.d.a(11), y9c.d.a(14) + y9c.d.a(11), y9c.d.a(11), this.f208846a);
    L5:
        this.f208846a.setColor(-1);
        float r101 = 255;
        this.f208846a.setAlpha((int) (this.f208848c * r101));
        if (r100 == null) goto L8;
        r100.drawCircle((-y9c.d.a(59)) + y9c.d.a(69), y9c.d.a(55) + y9c.d.a(69), y9c.d.a(69), this.f208846a);
    L8:
        this.f208846a.setAlpha((int) (this.f208849d * r101));
        if (r100 == null) goto L12;
        float r102 = y9c.d.a(11);
        Context r103 = getContext();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        float r104 = r102 + j08.b.a(r103, 98.45f);
        Context r105 = getContext();
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        float r106 = j08.b.a(r105, 19.8f);
        Context r107 = getContext();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        float r108 = r106 + j08.b.a(r107, 98.45f);
        Context r109 = getContext();
        Intrinsics.checkNotNullParameter(r109, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.drawCircle(r104, r108, j08.b.a(r109, 98.45f), this.f208846a);
        return;
    }

    public final Drawable b(int r100) {
        int[][] r101 = this.f208850e;
        int[] r102 = r101[r100 % r101.length];
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r102[0], r102[1]});
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        a(r100);
    }

    public final void setLeftAlpha(float r100) {
        this.f208848c = r100;
    }

    public final void setMTopCircleColor(int r100) {
        this.f208847b = r100;
    }

    public final void setRightAlpha(float r100) {
        this.f208849d = r100;
    }

    public final void setTopCircleColor(int r100) {
        this.f208847b = r100;
        if (h18.f.a(getContext()) == false) goto L5;
        float r101 = 0.02f;
    L6:
        this.f208848c = r101;
        if (h18.f.a(getContext()) == false) goto L9;
        float r102 = 0.04f;
    L10:
        this.f208849d = r102;
        invalidate();
        return;
    L9:
        r102 = 0.5f;
        goto L10
    L5:
        r101 = 0.3f;
        goto L6
    }

    public final void setTopCircleColorByIndex(int r100) {
        int[][] r101 = this.f208850e;
        setTopCircleColor(r101[r100 % r101.length][2]);
    }

    public EmptyCoverView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f208846a = new Paint();
        this.f208850e = new int[][]{new int[]{UIHelper.getColor(R.color.bitable_item_view_cover_bg_blue_begin), UIHelper.getColor(R.color.bitable_item_view_cover_bg_blue_end), UIHelper.getColor(R.color.bitable_item_view_cover_circle_blue)}, new int[]{UIHelper.getColor(R.color.bitable_item_view_cover_bg_green_begin), UIHelper.getColor(R.color.bitable_item_view_cover_bg_green_end), UIHelper.getColor(R.color.bitable_item_view_cover_circle_green)}, new int[]{UIHelper.getColor(R.color.bitable_item_view_cover_bg_orange_begin), UIHelper.getColor(R.color.bitable_item_view_cover_bg_orange_end), UIHelper.getColor(R.color.bitable_item_view_cover_circle_orange)}};
        setOutlineProvider(new a());
        setClipToOutline(true);
    }

    public /* synthetic */ EmptyCoverView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
