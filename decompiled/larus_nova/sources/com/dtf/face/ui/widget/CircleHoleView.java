package com.dtf.face.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.dtf.face.log.RecordService;
import com.dtf.face.utils.ClientConfigUtil;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import ws7.j;

/* JADX INFO: loaded from: classes22.dex */
public class CircleHoleView extends ImageView {
    private static final Xfermode SXFERMODE = null;
    private int floodColor;
    public float heightAttr;
    public boolean holeHCenter;
    public boolean holeVCenter;
    public float leftAttr;
    public Context mContext;
    private Bitmap mMaskBitmap;
    private Paint mPaint;
    private WeakReference<Bitmap> mWeakBitmap;
    public float topAttr;
    public float widthAttr;

    public void drawStroke(Canvas r100) {
    }

    @Override // android.view.View
    public void invalidate() {
        this.mWeakBitmap = null;
        Bitmap r100 = this.mMaskBitmap;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        super.invalidate();
    }

    static {
        SXFERMODE = new PorterDuffXfermode(PorterDuff.Mode.XOR);
    }

    private void sharedConstructor() {
        this.mPaint = new Paint(1);
    }

    public Bitmap createMask1() {
        int r100 = getWidth();
        int r101 = getHeight();
        if (ClientConfigUtil.f273690i != (-1)) goto L9;
        boolean r102 = ClientConfigUtil.e("MASK_ARGB_FOUR");
        if (r102 == false) goto L7;
        RecordService.getInstance().recordEvent(2, "maskConfig", new String[]{"Bitmap.Config", "ARGB_4444"});
    L7:
        ClientConfigUtil.f273690i = r102 ? 1 : 0;
    L9:
        if (1 != ClientConfigUtil.f273690i) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        Bitmap.Config r104 = Bitmap.Config.ARGB_4444;
    L15:
        Bitmap r105 = Bitmap.createBitmap(r100, r101, r104);
        Canvas r106 = new Canvas(r105);
        Paint r107 = new Paint(1);
        r107.setAntiAlias(true);
        r107.setColor(-1);
        float r108 = getWidth();
        float r109 = getHeight();
        float r110 = this.leftAttr;
        float r111 = 0.0f;
        if (r110 > (-1.0f)) goto L20;
        r110 = 0.0f;
    L20:
        if (this.holeHCenter == false) goto L24;
        r110 = (r108 / 2.0f) - (this.widthAttr / 2.0f);
        if (r110 >= 0.0f) goto L24;
        r110 = 0.0f;
    L24:
        float r112 = (r109 - r108) / 2.0f;
        float r113 = this.topAttr;
        if (r113 <= (-1.0f)) goto L28;
        r112 = r113;
    L28:
        if (this.holeVCenter == false) goto L33;
        float r114 = (r109 / 2.0f) - (this.heightAttr / 2.0f);
        if (r114 < 0.0f) goto L34;
        r111 = r114;
    L34:
        float r115 = this.widthAttr;
        if (r115 <= (-1.0f)) goto L37;
        float r116 = r115 + r110;
    L38:
        float r117 = r108 + r111;
        float r118 = this.heightAttr;
        if (r118 <= (-1.0f)) goto L41;
        r117 = r111 + r118;
    L41:
        r106.drawOval(new RectF(r110, r111, r116, r117), r107);
        return r105;
    L37:
        r116 = r108;
        goto L38
    L33:
        r111 = r112;
        goto L34
    L14:
        r104 = Bitmap.Config.ARGB_8888;
        goto L15
    L11:
        r103 = false;
        goto L12
    }

    public CircleHoleView(Context r100) {
        super(r100);
        this.leftAttr = -1.0f;
        this.topAttr = -1.0f;
        this.widthAttr = -1.0f;
        this.heightAttr = -1.0f;
        this.holeHCenter = false;
        this.holeVCenter = false;
        this.floodColor = -1;
        sharedConstructor();
    }

    public void changeBackColor(int r100) {
        this.floodColor = r100;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r110) {
        if (isInEditMode() == true) goto L33;
        int r100 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        WeakReference<Bitmap> r101 = this.mWeakBitmap;     // Catch: Throwable -> L29 Exception -> L35
        if (r101 == null) goto L8;
        Bitmap r102 = r101.get();     // Catch: Throwable -> L29 Exception -> L35
    L10:
        if (r102 != null) goto L12;
    L13:
        Drawable r103 = getDrawable();     // Catch: Throwable -> L29 Exception -> L35
        if (r103 != null) goto L36;
    L25:
        if (r102 == null) goto L32;
        this.mPaint.setXfermode(null);     // Catch: Throwable -> L29 Exception -> L35
        r110.drawBitmap(r102, 0.0f, 0.0f, this.mPaint);     // Catch: Throwable -> L29 Exception -> L35
        drawStroke(r110);     // Catch: Throwable -> L29 Exception -> L35
        r110.restoreToCount(r100);
        return;
    L36:
        r102 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L22 Throwable -> L29 Exception -> L35
        Canvas r104 = new Canvas(r102);     // Catch: Throwable -> L29 Exception -> L35
        r103.setBounds(0, 0, getWidth(), getHeight());     // Catch: Throwable -> L29 Exception -> L35
        r103.draw(r104);     // Catch: Throwable -> L29 Exception -> L35
        Bitmap r105 = this.mMaskBitmap;     // Catch: Throwable -> L29 Exception -> L35
        if (r105 != null) goto L19;
    L20:
        this.mMaskBitmap = createMask1();     // Catch: Throwable -> L29 Exception -> L35
    L21:
        this.mPaint.reset();     // Catch: Throwable -> L29 Exception -> L35
        this.mPaint.setFilterBitmap(false);     // Catch: Throwable -> L29 Exception -> L35
        this.mPaint.setXfermode(SXFERMODE);     // Catch: Throwable -> L29 Exception -> L35
        r104.drawColor(this.floodColor);     // Catch: Throwable -> L29 Exception -> L35
        r104.drawBitmap(this.mMaskBitmap, 0.0f, 0.0f, this.mPaint);     // Catch: Throwable -> L29 Exception -> L35
        this.mWeakBitmap = new WeakReference(r102);     // Catch: Throwable -> L29 Exception -> L35
        goto L25
    L19:
        if (r105.isRecycled() == false) goto L21;
    L22:
        System.gc();     // Catch: Throwable -> L29 Exception -> L35
        r110.restoreToCount(r100);
        return;
    L12:
        if (r102.isRecycled() == false) goto L25;
    L8:
        r102 = null;
    L29:
        th = move-exception;
        r110.restoreToCount(r100);
        throw th;
    L32:
        r110.restoreToCount(r100);
        return;
    L33:
        super.onDraw(r110);
    }

    public CircleHoleView setHeightAttr(float r100) {
        this.heightAttr = r100;
        return this;
    }

    public CircleHoleView setTopAttr(float r100) {
        this.topAttr = r100;
        return this;
    }

    public CircleHoleView setWidthAttr(float r100) {
        this.widthAttr = r100;
        return this;
    }

    public CircleHoleView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.leftAttr = -1.0f;
        this.topAttr = -1.0f;
        this.widthAttr = -1.0f;
        this.heightAttr = -1.0f;
        this.holeHCenter = false;
        this.holeVCenter = false;
        this.floodColor = -1;
        initHoleAttrs(r100, r101);
        sharedConstructor();
    }

    public void initHoleAttrs(Context r110, AttributeSet r111) {
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.holeHCenter, R.attr.holeHeight, R.attr.holeLeft, R.attr.holeTop, R.attr.holeVCenter, R.attr.holeWidth, R.attr.useXml});     // Catch: Throwable -> L7
        if (r112 == null) goto L9;
        this.leftAttr = r112.getDimension(2, 0.0f);     // Catch: Throwable -> L7
        this.topAttr = r112.getDimension(3, 0.0f);     // Catch: Throwable -> L7
        this.widthAttr = r112.getDimension(5, 0.0f);     // Catch: Throwable -> L7
        this.heightAttr = r112.getDimension(1, 0.0f);     // Catch: Throwable -> L7
        this.holeHCenter = r112.getBoolean(0, false);     // Catch: Throwable -> L7
        this.holeVCenter = r112.getBoolean(4, false);     // Catch: Throwable -> L7
        r112.recycle();     // Catch: Throwable -> L7
    L9:
        float r113 = this.widthAttr;
        if (r113 != 0.0f) goto L12;
    L13:
        this.leftAttr = 0.0f;
        this.topAttr = j.a(getContext(), 60.0f);
        this.widthAttr = j.a(getContext(), 238.0f);
        this.heightAttr = j.a(getContext(), 238.0f);
        this.holeHCenter = true;
        this.holeVCenter = false;
        return;
    L12:
        if (r113 == (-1.0d)) goto L13;
        return;
    L7:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "FaceUiException", new String[]{"msg", RecordService.getStackTraceString(th)});
        goto L9
    }

    public CircleHoleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.leftAttr = -1.0f;
        this.topAttr = -1.0f;
        this.widthAttr = -1.0f;
        this.heightAttr = -1.0f;
        this.holeHCenter = false;
        this.holeVCenter = false;
        this.floodColor = -1;
        initHoleAttrs(r100, r101);
        sharedConstructor();
    }
}
