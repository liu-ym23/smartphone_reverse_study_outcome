package com.ss.android.lark.todo.impl.features.detail.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 B2\u00020\u0001:\u0001BB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0014J\b\u00102\u001a\u00020\u0007H\u0002J\b\u00103\u001a\u00020\u0007H\u0002J \u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\u0014\u00108\u001a\u00020/2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020<H\u0014J\u001a\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020?2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0012\u0010@\u001a\u00020/2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0012\u0010A\u001a\u00020/2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006C"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/common/LayerAvatarView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mIconBoarderPaint", "Landroid/graphics/Paint;", "mIconPaint", "mIconSize", "", "getMIconSize", "()F", "setMIconSize", "(F)V", "mIconCoverMargin", "getMIconCoverMargin", "setMIconCoverMargin", "mBoarderSize", "getMBoarderSize", "setMBoarderSize", "mDisplayIcons", "", "Landroid/graphics/Bitmap;", "getMDisplayIcons", "()Ljava/util/List;", "setMDisplayIcons", "(Ljava/util/List;)V", "mIconLimit", "getMIconLimit", "()I", "setMIconLimit", "(I)V", "mBgBorderColor", "mPaddingRect", "Landroid/graphics/Rect;", "getMPaddingRect", "()Landroid/graphics/Rect;", "setMPaddingRect", "(Landroid/graphics/Rect;)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "getContentWidth", "getContentHeight", "setViewSize", "mode", "size", "contentSize", "updateData", "data", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawImage", "leftTop", "", "drawImageLeftTop", "drawImageRightTop", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LayerAvatarView extends View {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Rect f443021i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f443022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f443023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f443024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f443025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f443026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Bitmap> f443027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f443028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Rect f443029h;

    public static final class a {
    }

    static {
        f443021i = new Rect(10, 6, 10, 6);
    }

    private final int getContentHeight() {
        Rect r100 = this.f443029h;
        int r101 = (r100.top + 0) + r100.bottom;
        float r102 = 0.0f;
        if (CollectionUtils.isEmpty(this.f443027f) == true) goto L6;
        r102 = Math.max(0.0f, this.f443024c + (this.f443026e * 2));
    L6:
        return r101 + ((int) r102);
    }

    private final int getContentWidth() {
        Rect r100 = this.f443029h;
        int r101 = (r100.left + 0) + r100.right;
        if (CollectionUtils.isEmpty(this.f443027f) == true) goto L8;
        int r102 = this.f443028g;
        if (r102 <= 0) goto L9;
        int r103 = Math.min(r102, this.f443027f.size());
        return r101 + ((int) (((this.f443024c + (this.f443026e * 2)) * r103) - (this.f443025d * (r103 - 1))));
    L9:
        return r101;
    L8:
        return r101;
    }

    public final float getMBoarderSize() {
        return this.f443026e;
    }

    public final List<Bitmap> getMDisplayIcons() {
        return this.f443027f;
    }

    public final float getMIconCoverMargin() {
        return this.f443025d;
    }

    public final int getMIconLimit() {
        return this.f443028g;
    }

    public final float getMIconSize() {
        return this.f443024c;
    }

    public final Rect getMPaddingRect() {
        return this.f443029h;
    }

    public LayerAvatarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, -1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (CollectionUtils.isEmpty(this.f443027f) == true) goto L19;
        if (r110 == null) goto L20;
        float r100 = r110.getHeight() / 2;
        float r101 = this.f443024c;
        float r102 = this.f443026e;
        float r103 = 2;
        float r104 = r100 - ((r101 + r102) / r103);
        float r105 = -(((-this.f443029h.right) - r101) - (r102 * r103));
        int r106 = Math.min(this.f443027f.size(), 3) - 1;
        if (r106 < 0) goto L17;
        int r107 = 0;
    L10:
        int r108 = r110.saveLayer(0.0f, 0.0f, r110.getWidth(), r110.getHeight(), null, 31);
        Bitmap r109 = (Bitmap) ListProtector.get(this.f443027f, r107);
        if (r109 != null) goto L13;
        float r111 = this.f443024c + (this.f443026e * r103);
        float r112 = this.f443025d;
    L14:
        r105 = r105 + (r111 - r112);
        if (r107 == r106) goto L21;
        r107 = r107 + 1;
        goto L10
    L21:
        return;
    L13:
        float r113 = this.f443024c + (this.f443026e * r103);
        RectF r114 = new RectF(r105 - r113, r104, r105, r113 + r104);
        this.f443023b.setXfermode(null);
        r110.drawOval(r114, this.f443023b);
        this.f443023b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r110.drawBitmap(r109, null, r114, this.f443023b);
        this.f443023b.setXfermode(null);
        r110.restoreToCount(r108);
        r110.drawOval(r114, this.f443022a);
        r111 = this.f443024c + (this.f443026e * r103);
        r112 = this.f443025d;
        goto L14
    L17:
        return;
    L20:
        return;
    }

    public final void setMBoarderSize(float r100) {
        this.f443026e = r100;
    }

    public final void setMDisplayIcons(List<Bitmap> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f443027f = r100;
    }

    public final void setMIconCoverMargin(float r100) {
        this.f443025d = r100;
    }

    public final void setMIconLimit(int r100) {
        this.f443028g = r100;
    }

    public final void setMIconSize(float r100) {
        this.f443024c = r100;
    }

    public final void setMPaddingRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f443029h = r100;
    }

    public LayerAvatarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, -1);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getContentWidth();
        int r103 = getContentHeight();
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getMode(r100);
        int r106 = View.MeasureSpec.getSize(r101);
        int r107 = View.MeasureSpec.getMode(r101);
        if (r105 == Integer.MIN_VALUE) goto L6;
        if (r105 == 0) goto L7;
        r102 = r104;
    L7:
        if (r107 == Integer.MIN_VALUE) goto L10;
        if (r107 == 0) goto L11;
        r103 = r106;
    L11:
        setMeasuredDimension(r102, r103);
        return;
    L10:
        r103 = Math.min(r103, r106);
        goto L11
    L6:
        r102 = Math.min(r102, r104);
        goto L7
    }

    public LayerAvatarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f443027f = new ArrayList();
        this.f443028g = 3;
        int r103 = UIHelper.getColor(R.color.bg_body);
        this.f443024c = UIUtils.dp2px(r100, 18.0f);
        this.f443025d = UIUtils.dp2px(r100, 5.0f);
        this.f443026e = UIUtils.dp2px(r100, 1.0f);
        Rect r104 = f443021i;
        this.f443029h = new Rect(UIHelper.dp2px(r104.left), UIHelper.dp2px(r104.top), UIHelper.dp2px(r104.right), UIHelper.dp2px(r104.bottom));
        Paint r105 = new Paint();
        this.f443023b = r105;
        Paint r106 = new Paint();
        this.f443022a = r106;
        r106.setColor(r103);
        r106.setAntiAlias(true);
        r106.setStyle(Paint.Style.STROKE);
        r106.setStrokeWidth(this.f443026e);
        r105.setAntiAlias(true);
    }
}
