package com.larus.bmhome.view.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z0;
import com.ss.android.lark.utils.statistics.PerfLog;
import gt8.d;
import gt8.e;
import gt8.l;
import gt8.o;
import gt8.z;
import ht8.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 E2\u00020\u0001:\u0002EFB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\u0014\u0010'\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\tJ\b\u0010)\u001a\u0004\u0018\u00010*J\b\u0010+\u001a\u00020\"H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\tH\u0016J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0014J\b\u00104\u001a\u00020\rH\u0002J\u0018\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0006\u0010:\u001a\u00020\"J\u000e\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u0018J\u000e\u0010=\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020 J(\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u0002092\u0006\u0010B\u001a\u0002092\u0006\u0010C\u001a\u0002092\u0006\u0010D\u001a\u000209H\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/larus/bmhome/view/crop/ImageCropView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOriginBmp", "Landroid/graphics/Bitmap;", "mPhotoClipRect", "Lcom/larus/bmhome/view/crop/helper/ImageClipRect;", "clipImitationRect", "Landroid/graphics/RectF;", "mActionHelper", "Lcom/larus/bmhome/view/crop/helper/ActionHelper;", "mDrawHelper", "Lcom/larus/bmhome/view/crop/helper/DrawHelper;", "screenShowRegion", "mStartClipRect", "mImageRect", "mMatrixValues", "", "mIsInited", "", "mImageShowLocationHelper", "Lcom/larus/bmhome/view/crop/helper/ImageShowLocationHelper;", "mIsAnimating", "ifFixClipRatio", "customClipRatio", "", "clipRegionChangedListener", "Lcom/larus/bmhome/view/crop/ImageCropView$ClipRegionChangedListener;", "prepare", "", "runAfterPrepare", "Ljava/lang/Runnable;", "ensureOriginBmpSize", "initScreenShowRect", "getResultBitmapFromEditResult", "source", "getCropEditOperation", "Lcom/larus/bmhome/view/crop/CropEditOperation;", IPerformanceManager.MODULE_RESTART, "setImageBitmap", "bm", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "initImageRect", "getMatrixValue", "matrix", "Landroid/graphics/Matrix;", "whichValue", "", "rotate", "setIfFixClipRatio", "isFixClipRatio", "setCustomClipRatio", "setClipRegionChangedListener", "listener", "setFrame", "l", "t", "r", "b", "Companion", "ClipRegionChangedListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageCropView extends AppCompatImageView {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f316880p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f316881q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f316882r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f316883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f316884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f316885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f316886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f316887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f316888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f316889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f316890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f316891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f316892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z f316893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f316894l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f316895m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f316896n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f316897o;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b {
    }

    static {
        f316880p = c7.b(90);
        f316881q = c7.b(3);
        f316882r = c7.b(3);
    }

    public final ft8.a getCropEditOperation() {
        Bitmap r100 = this.f316883a;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isRecycled() == false) goto L7;
        return null;
    L7:
        RectF r101 = new RectF(this.f316885c);
        z r102 = this.f316893k;
        if (r102 == null) goto L20;
        RectF r103 = new RectF(r102.a());
        z r104 = this.f316893k;
        if (r104 == null) goto L12;
        int r105 = r104.f482677b;
    L14:
        if (((Math.abs(r105) / 90) % 2) != 1) goto L16;
        float r106 = r100.getHeight();
        float r107 = r103.width();
    L17:
        float r108 = r106 / r107;
        ht8.a.d(r101, r108);
        ht8.a.d(r103, r108);
        return new ft8.a(r101, r103, r105, r100.getWidth(), r100.getHeight());
    L16:
        r106 = r100.getWidth();
        r107 = r103.width();
        goto L17
    L12:
        r105 = 0;
        goto L14
    L20:
        return null;
    }

    public final RectF l() {
        RectF r100 = new RectF();
        float r101 = getDrawable().getIntrinsicWidth();
        float r102 = getDrawable().getIntrinsicHeight();
        float r103 = getWidth();
        float r104 = getHeight();
        FLogger.f375446a.d("PhotoClipView", "imageRect imageWidth:viewWidth " + r101 + ':' + r103);
        Matrix r105 = getImageMatrix();
        Intrinsics.checkNotNull(r105);
        r105.getValues(this.f316891i);
        float[] r106 = this.f316891i;
        float r107 = r106[0];
        r105.getValues(r106);
        int r108 = (int) (r102 * this.f316891i[4]);
        float r109 = (int) (r101 * r107);
        if (Math.abs(r109 - r103) >= 3.0f) goto L5;
        float r110 = r108;
        float r111 = (r104 - r110) / 2;
        r100.set(0.0f, (int) r111, (int) r103, (int) (r111 + r110));
    L6:
        float r112 = r100.centerX();
        float r113 = r100.centerY();
        float r114 = RangesKt.coerceAtMost((r100.height() - (f316882r * 2)) / r100.height(), (r100.width() - (f316881q * 2)) / r100.width());
        r100.left = ((r100.left - r112) * r114) + r112;
        r100.right = ((r100.right - r112) * r114) + r112;
        r100.top = ((r100.top - r113) * r114) + r113;
        r100.bottom = ((r100.bottom - r113) * r114) + r113;
        return r100;
    L5:
        float r115 = (r103 - r109) / 2;
        r100.set((int) r115, 0.0f, (int) (r115 + r109), (int) r104);
        goto L6
    }

    public final void m() {
        if (this.f316887e != null) goto L5;
        return;
    L5:
        Bitmap r100 = this.f316883a;
        if (r100 == null) goto L9;
        Bitmap r101 = Bitmap.createBitmap(r100);
        Bitmap r102 = r101.copy(z0.b(r101.getConfig()), true);
        new Canvas(r102).drawBitmap(r100, 0.0f, 0.0f, null);
        Intrinsics.checkNotNull(r102);
        setImageBitmap(r102);
        l r103 = this.f316887e;
        Intrinsics.checkNotNull(r103);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r103.f482623a = r102;
        int r104 = c.f487148a;
        Runnable r105 = new ft8.b(this);
        Intrinsics.checkNotNullParameter(this, "anchor");
        Intrinsics.checkNotNullParameter(r105, "task");
        getViewTreeObserver().addOnPreDrawListener(new ht8.b(this, r105));
        invalidate();
        return;
    }

    public final Bitmap j(Bitmap r210) {
        if (r210 != null) goto L5;
        Bitmap r100 = this.f316883a;
    L7:
        if (r100 != null) goto L9;
    L53:
        return null;
    L9:
        if (r100.isRecycled() == false) goto L11;
        return null;
    L11:
        RectF r101 = new RectF(this.f316885c);
        z r102 = this.f316893k;
        if (r102 == null) goto L53;
        RectF r103 = new RectF(r102.a());
        z r104 = this.f316893k;
        if (r104 == null) goto L16;
        int r105 = r104.f482677b;
    L18:
        if (((Math.abs(r105) / 90) % 2) != 1) goto L20;
        float r106 = r100.getHeight();
        float r110 = r103.width();
    L21:
        float r107 = r106 / r110;
        ht8.a.d(r101, r107);
        ht8.a.d(r103, r107);
        if (((Math.abs(r105) / 90) % 2) != 1) goto L24;
        float r108 = r101.height();
    L25:
        int r109 = (int) r108;
        if (((Math.abs(r105) / 90) % 2) != 1) goto L28;
        float r111 = r101.width();
    L29:
        Bitmap r112 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r109, 1), RangesKt.coerceAtLeast((int) r111, 1), Bitmap.Config.ARGB_8888);
        Canvas r113 = new Canvas(r112);
        Matrix r114 = new Matrix();
        int r115 = (Math.abs(r105) / 90) % 4;
        if (r115 == 0) goto L38;
        if (r115 == 1) goto L37;
        if (r115 == 2) goto L36;
        if (r115 == 3) goto L35;
        Number r116 = 0;
    L39:
        int r117 = (Math.abs(r105) / 90) % 4;
        if (r117 == 0) goto L48;
        if (r117 == 1) goto L47;
        if (r117 == 2) goto L46;
        if (r117 == 3) goto L45;
        Number r118 = 0;
    L49:
        r114.postTranslate(r116.floatValue(), r118.floatValue());
        r113.drawBitmap(r100, r114, null);
        if (r105 == 0) goto L54;
        r114.reset();
        r114.postRotate(r105);
        Bitmap r119 = Bitmap.createBitmap(r112, 0, 0, r112.getWidth(), r112.getHeight(), r114, true);
        r114.reset();
        return r119;
    L54:
        return r112;
    L45:
        r118 = Float.valueOf(r101.right - r103.right);
        goto L49
    L46:
        r118 = Float.valueOf(r101.bottom - r103.bottom);
        goto L49
    L47:
        r118 = Float.valueOf(r103.left - r101.left);
        goto L49
    L48:
        r118 = Float.valueOf(r103.top - r101.top);
        goto L49
    L35:
        r116 = Float.valueOf(r103.top - r101.top);
        goto L39
    L36:
        r116 = Float.valueOf(r101.right - r103.right);
        goto L39
    L37:
        r116 = Float.valueOf(r101.bottom - r103.bottom);
        goto L39
    L38:
        r116 = Float.valueOf(r103.left - r101.left);
        goto L39
    L28:
        r111 = r101.height();
        goto L29
    L24:
        r108 = r101.width();
        goto L25
    L20:
        r106 = r100.getWidth();
        r110 = r103.width();
        goto L21
    L16:
        r105 = 0;
        goto L18
    L5:
        r100 = r210;
        goto L7
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);     // Catch: Exception -> L15
        if (this.f316892j == true) goto L6;
        return;
    L6:
        l r101 = this.f316887e;     // Catch: Exception -> L15
        if (r101 == null) goto L11;
        r100.drawColor(-16777216);     // Catch: Exception -> L15
        if (r101.f482623a.isRecycled() == true) goto L11;
        r100.drawBitmap(r101.f482623a, r101.a(), null);     // Catch: Exception -> L15
    L11:
        o r102 = this.f316884b;     // Catch: Exception -> L15
        if (r102 == null) goto L20;
        r102.c(r100);     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("PhotoClipView", "onDraw error: " + e);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f316892j == true) goto L5;
    L58:
        return true;
    L5:
        if (this.f316894l == true) goto L58;
        d r101 = this.f316886d;
        if (r101 == null) goto L58;
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101.f482606k == false) goto L58;
        d.b r102 = r101.f482605j;
        boolean r103 = false;
        d.b r104 = null;
        if (r102 != null) goto L26;
        if (r100.getPointerCount() != 1) goto L20;
        if (r101.f482601f.a(r100) == false) goto L18;
        r104 = r101.f482612q;
    L22:
        r101.f482605j = r104;
        if (r104 == null) goto L53;
        r104.a(r100);
    L53:
        if (r100.getAction() != 3) goto L55;
    L57:
        r101.f482609n = r103;
        goto L58
    L55:
        if (r100.getAction() == 1) goto L57;
        r103 = true;
        goto L57
    L18:
        r104 = r101.f482611p;
        goto L22
    L20:
        if (r100.getPointerCount() != 2) goto L22;
        r104 = r101.f482610o;
        goto L22
    L26:
        if (r102.getType() != 1) goto L28;
        boolean r105 = true;
    L29:
        if (r105 == true) goto L31;
    L38:
        d.b r106 = r101.f482605j;
        if (r106 == null) goto L42;
        r106.a(r100);
    L42:
        if (r100.getAction() != 1) goto L53;
        d.b r107 = r101.f482605j;
        if (r107 != null) goto L46;
    L48:
        boolean r108 = false;
    L49:
        if (r108 == false) goto L51;
        r101.f482599d.a();
    L51:
        r101.f482605j = null;
        goto L53
    L46:
        if (r107.getType() != 2) goto L48;
        r108 = true;
        goto L49
    L31:
        if (r100.getPointerCount() != 2) goto L38;
        MotionEvent r109 = MotionEvent.obtain(r100);
        r109.setAction(3);
        d.b r110 = r101.f482605j;
        if (r110 == null) goto L35;
        Intrinsics.checkNotNull(r109);
        r110.a(r109);
    L35:
        r109.recycle();
        e r111 = r101.f482610o;
        r101.f482605j = r111;
        if (r111 == null) goto L42;
        r111.a(r100);
        goto L42
    L28:
        r105 = false;
        goto L29
    }

    public final void setClipRegionChangedListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f316897o = r100;
    }

    public final void setCustomClipRatio(float r100) {
        this.f316896n = r100;
    }

    public final void setIfFixClipRatio(boolean r100) {
        this.f316895m = r100;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, "bm");
        super.setImageBitmap(r100);
        this.f316883a = r100;
        int r101 = c.f487148a;
        com.larus.bmhome.view.crop.a r102 = new com.larus.bmhome.view.crop.a(this, null);
        Intrinsics.checkNotNullParameter(this, "anchor");
        Intrinsics.checkNotNullParameter(r102, "task");
        getViewTreeObserver().addOnPreDrawListener(new ht8.b(this, r102));
        invalidate();
    }

    public ImageCropView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f316885c = new RectF();
        this.f316888f = new RectF();
        this.f316889g = new RectF();
        this.f316890h = new RectF();
        this.f316891i = new float[9];
        this.f316896n = -1.0f;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int r100, int r101, int r102, int r103) {
        boolean r104 = super.setFrame(r100, r101, r102, r103);
        if (r104 == true) goto L9;
    L8:
        return r104;
    L9:
        m();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        FLogger.f375446a.e("PhotoClipView", "restart error: " + e);
        goto L8
    }
}
