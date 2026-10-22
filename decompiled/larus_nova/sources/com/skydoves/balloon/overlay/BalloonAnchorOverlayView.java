package com.skydoves.balloon.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.internals.ViewPropertyKt;
import com.skydoves.balloon.internals.b;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kqa.a;
import kqa.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\u0002¢\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002R/\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR;\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028G@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028G@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R+\u0010#\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u001d8G@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R/\u0010*\u001a\u0004\u0018\u00010$2\b\u0010\u0004\u001a\u0004\u0018\u00010$8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R+\u00101\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020+8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00069"}, d2 = {"Lcom/skydoves/balloon/overlay/BalloonAnchorOverlayView;", "Landroid/view/View;", "", "getStatusBarHeight", "<set-?>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/skydoves/balloon/internals/b;", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "anchorView", "", "b", "getAnchorViewList", "()Ljava/util/List;", "setAnchorViewList", "(Ljava/util/List;)V", "anchorViewList", "c", "getOverlayColor", "()I", "setOverlayColor", "(I)V", "overlayColor", "d", "getOverlayPaddingColor", "setOverlayPaddingColor", "overlayPaddingColor", "", "e", "getOverlayPadding", "()F", "setOverlayPadding", "(F)V", "overlayPadding", "Landroid/graphics/Point;", "f", "getOverlayPosition", "()Landroid/graphics/Point;", "setOverlayPosition", "(Landroid/graphics/Point;)V", "overlayPosition", "Lkqa/d;", ce.f26391f, "getBalloonOverlayShape", "()Lkqa/d;", "setBalloonOverlayShape", "(Lkqa/d;)V", "balloonOverlayShape", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final class BalloonAnchorOverlayView extends View {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f406175l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f406176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f406177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f406178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f406179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f406180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f406181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f406182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f406183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f406184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f406185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f406186k;

    static {
        f406175l = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "anchorView", "getAnchorView()Landroid/view/View;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "anchorViewList", "getAnchorViewList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayColor", "getOverlayColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayPaddingColor", "getOverlayPaddingColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayPadding", "getOverlayPadding()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayPosition", "getOverlayPosition()Landroid/graphics/Point;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "balloonOverlayShape", "getBalloonOverlayShape()Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", 0))};
    }

    public BalloonAnchorOverlayView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BalloonAnchorOverlayView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getStatusBarHeight() {
        Rect r100 = new Rect();
        Context r101 = getContext();
        if ((r101 instanceof Activity) == false) goto L10;
        View r102 = ((Activity) r101).getWindow().getDecorView();
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == c.f346341a) goto L9;
        c.a(r103, "getDecorView");
    L9:
        r102.getWindowVisibleDisplayFrame(r100);
        return r100.top;
    L10:
        return 0;
    }

    public final View getAnchorView() {
        return (View) this.f406176a.getValue(this, f406175l[0]);
    }

    public final List<View> getAnchorViewList() {
        return (List) this.f406177b.getValue(this, f406175l[1]);
    }

    public final d getBalloonOverlayShape() {
        return (d) this.f406182g.getValue(this, f406175l[6]);
    }

    public final int getOverlayColor() {
        return ((Number) this.f406178c.getValue(this, f406175l[2])).intValue();
    }

    public final float getOverlayPadding() {
        return ((Number) this.f406180e.getValue(this, f406175l[4])).floatValue();
    }

    public final int getOverlayPaddingColor() {
        return ((Number) this.f406179d.getValue(this, f406175l[3])).intValue();
    }

    public final Point getOverlayPosition() {
        return (Point) this.f406181f.getValue(this, f406175l[5]);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r110) {
        boolean r100 = true;
        if (this.f406186k == true) goto L13;
        Bitmap r101 = this.f406183h;
        if (r101 == null) goto L13;
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L13;
    L51:
        Bitmap r103 = this.f406183h;
        if (r103 != null) goto L54;
        return;
    L54:
        if (r103.isRecycled() == true) goto L60;
        if (r110 == null) goto L61;
        r110.drawBitmap(r103, 0.0f, 0.0f, null);
        return;
    L61:
        return;
    L60:
        return;
    L8:
        if (r101.isRecycled() != true) goto L10;
        r102 = true;
    L13:
        if (getWidth() == 0) goto L51;
        if (getHeight() == 0) goto L51;
        View r104 = getAnchorView();
        if (r104 != null) goto L19;
    L21:
        boolean r105 = false;
    L22:
        if (r105 == true) goto L51;
        View r106 = getAnchorView();
        if (r106 != null) goto L26;
    L28:
        boolean r107 = false;
    L29:
        if (r107 == true) goto L51;
        Bitmap r108 = this.f406183h;
        if (r108 != null) goto L34;
    L36:
        Bitmap r109 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f406183h = r109;
        Canvas r111 = new Canvas(r109);
        Paint r112 = this.f406184i;
        r112.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        r112.setColor(getOverlayColor());
        r111.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f406184i);
        Paint r113 = this.f406184i;
        r113.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        r113.setColor(0);
        Paint r114 = this.f406185j;
        r114.setColor(getOverlayPaddingColor());
        r114.setStyle(Paint.Style.STROKE);
        r114.setStrokeWidth(getOverlayPadding());
        List<View> r115 = getAnchorViewList();
        if (r115 != null) goto L39;
    L42:
        if (r100 == false) goto L44;
        a(getAnchorView(), r111);
    L50:
        this.f406186k = false;
        goto L51
    L44:
        List<View> r116 = getAnchorViewList();
        if (r116 == null) goto L50;
        Iterator<T> r117 = r116.iterator();
    L48:
        if (r117.hasNext() == false) goto L50;
        a((View) r117.next(), r111);
        goto L48
    L39:
        if (r115.isEmpty() == true) goto L42;
        r100 = false;
        goto L42
    L34:
        if (r108.isRecycled() == true) goto L36;
        r108.recycle();
        goto L36
    L26:
        if (r106.getHeight() != 0) goto L28;
        r107 = true;
        goto L29
    L19:
        if (r104.getWidth() != 0) goto L21;
        r105 = true;
        goto L22
    }

    public final void setAnchorView(View r100) {
        this.f406176a.setValue(this, f406175l[0], r100);
    }

    public final void setAnchorViewList(List<? extends View> r100) {
        this.f406177b.setValue(this, f406175l[1], r100);
    }

    public final void setBalloonOverlayShape(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f406182g.setValue(this, f406175l[6], r100);
    }

    public final void setOverlayColor(int r100) {
        this.f406178c.setValue(this, f406175l[2], Integer.valueOf(r100));
    }

    public final void setOverlayPadding(float r100) {
        this.f406180e.setValue(this, f406175l[4], Float.valueOf(r100));
    }

    public final void setOverlayPaddingColor(int r100) {
        this.f406179d.setValue(this, f406175l[3], Integer.valueOf(r100));
    }

    public final void setOverlayPosition(Point r100) {
        this.f406181f.setValue(this, f406175l[5], r100);
    }

    public final void a(View r100, Canvas r101) {
        if (r100 == null) goto L18;
        Rect r102 = new Rect();
        r100.getGlobalVisibleRect(r102);
        Point r103 = getOverlayPosition();
        if (r103 == null) goto L6;
        RectF r104 = new RectF(r103.x - getOverlayPadding(), (r103.y - getOverlayPadding()) + getStatusBarHeight(), (r103.x + r100.getWidth()) + getOverlayPadding(), ((r103.y + r100.getHeight()) + getOverlayPadding()) + getStatusBarHeight());
    L7:
        float r105 = getOverlayPadding() / 2;
        RectF r106 = new RectF(r104);
        r106.inset(r105, r105);
        d r107 = getBalloonOverlayShape();
        if ((r107 instanceof kqa.b) == false) goto L11;
        r101.drawOval(r104, this.f406184i);
        r101.drawOval(r106, this.f406185j);
        return;
    L11:
        if ((r107 instanceof a) == false) goto L14;
        ((a) r107).getClass();
        return;
    L14:
        if ((r107 instanceof kqa.c) == false) goto L17;
        ((kqa.c) r107).getClass();
        return;
    L17:
        throw new NoWhenBranchMatchedException();
    L6:
        r104 = new RectF(r102.left - getOverlayPadding(), r102.top - getOverlayPadding(), r102.right + getOverlayPadding(), r102.bottom + getOverlayPadding());
        goto L7
    }

    public BalloonAnchorOverlayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f406176a = ViewPropertyKt.a(this, null);
        this.f406177b = ViewPropertyKt.a(this, null);
        this.f406178c = ViewPropertyKt.a(this, 0);
        this.f406179d = ViewPropertyKt.a(this, 0);
        this.f406180e = ViewPropertyKt.a(this, Float.valueOf(0.0f));
        this.f406181f = ViewPropertyKt.a(this, null);
        this.f406182g = ViewPropertyKt.a(this, kqa.b.f505660a);
        Paint r103 = new Paint(1);
        this.f406184i = r103;
        Paint r104 = new Paint(1);
        this.f406185j = r104;
        r103.setAntiAlias(true);
        r103.setFilterBitmap(true);
        r103.setDither(true);
        r104.setAntiAlias(true);
        r104.setFilterBitmap(true);
        r104.setDither(true);
    }

    public /* synthetic */ BalloonAnchorOverlayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.f406186k = true;
    }
}
