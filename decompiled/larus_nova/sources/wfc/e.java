package wfc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.photoeditor.text.TextEditorDrawView;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f559509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f559510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f559511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f559512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f559513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f559514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f559515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f559516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f559517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f559518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextEditorDrawView f559519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f559520l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Matrix f559521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Bitmap f559522n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Region f559523o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Bitmap f559524p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f559525q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Bitmap f559526r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PointF f559527s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PointF f559528t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PointF f559529u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public PointF f559530v;

    public final void b() {
        TextView r100 = new TextView(this.f559516h);
        r100.getPaint().setFakeBoldText(true);
        r100.setTextSize(2, this.f559518j);
        r100.setTextColor(this.f559517i);
        r100.setText(this.f559515g);
        r100.setShadowLayer(c(1.5f), -c(0.0f), c(0.5f), 855638016);
        r100.setPadding(29, 29, 29, 29);
        r100.measure(View.MeasureSpec.makeMeasureSpec((int) this.f559519k.getImageRect().width(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec((int) this.f559519k.getImageRect().height(), Integer.MIN_VALUE));
        r100.layout(0, 0, r100.getMeasuredWidth(), r100.getMeasuredHeight());
        r100.requestLayout();
        Bitmap r101 = this.f559526r;
        if (r101 != null) goto L5;
    L7:
        this.f559526r = Bitmap.createBitmap(r100.getMeasuredWidth(), r100.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        r100.draw(new Canvas(this.f559526r));
        return;
    L5:
        if (r101.isRecycled() == true) goto L7;
        this.f559526r.recycle();
        goto L7
    }

    public final void f() {
        PointF r100 = this.f559510b;
        float r101 = r100.x;
        int r102 = this.f559513e;
        float r103 = r100.y;
        int r104 = this.f559514f;
        RectF r105 = new RectF(r101 - r102, r103 - r104, r101 + r102, r103 + r104);
        PointF r106 = this.f559510b;
        float r107 = r106.x;
        float r108 = r106.y;
        float r109 = this.f559509a;
        com.ss.android.photoeditor.util.b.f(r105, r107, r108, r109, r109);
        this.f559527s = new PointF(r105.left, r105.top);
        this.f559528t = new PointF(r105.right, r105.top);
        this.f559529u = new PointF(r105.right, r105.bottom);
        this.f559530v = new PointF(r105.left, r105.bottom);
        PointF r110 = this.f559527s;
        PointF r111 = this.f559510b;
        com.ss.android.photoeditor.util.b.c(r110, r111.x, r111.y, this.f559511c);
        PointF r112 = this.f559528t;
        PointF r113 = this.f559510b;
        com.ss.android.photoeditor.util.b.c(r112, r113.x, r113.y, this.f559511c);
        PointF r114 = this.f559529u;
        PointF r115 = this.f559510b;
        com.ss.android.photoeditor.util.b.c(r114, r115.x, r115.y, this.f559511c);
        PointF r116 = this.f559530v;
        PointF r117 = this.f559510b;
        com.ss.android.photoeditor.util.b.c(r116, r117.x, r117.y, this.f559511c);
    }

    public static float c(float r100) {
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Resources r102 = Resources.getSystem();
        return (r100 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    }

    public final void d(Canvas r100) {
        Bitmap r101 = this.f559526r;
        this.f559520l.reset();
        Matrix r102 = this.f559520l;
        PointF r103 = this.f559510b;
        r102.postTranslate(r103.x - this.f559513e, r103.y - this.f559514f);
        Matrix r104 = this.f559520l;
        float r105 = this.f559509a;
        PointF r106 = this.f559510b;
        r104.postScale(r105, r105, r106.x, r106.y);
        Matrix r107 = this.f559520l;
        float r108 = this.f559511c;
        PointF r109 = this.f559510b;
        r107.postRotate(r108, r109.x, r109.y);
        r100.drawBitmap(r101, this.f559520l, null);
        if (this.f559525q == false) goto L9;
        r100.save();
        PointF r110 = this.f559510b;
        float r111 = r110.x;
        float r112 = this.f559513e;
        float r113 = this.f559509a;
        float r114 = r112 * r113;
        float r115 = r110.y;
        float r116 = this.f559514f * r113;
        RectF r117 = new RectF(r111 - r114, r115 - r116, r111 + r114, r115 + r116);
        Paint r118 = new Paint();
        r118.setPathEffect(new DashPathEffect(new float[]{14.0f, 14.0f}, 0.0f));
        r118.setAntiAlias(true);
        r118.setColor(-1);
        r118.setStyle(Paint.Style.STROKE);
        r118.setStrokeWidth(com.ss.android.photoeditor.util.d.b(1) * this.f559509a);
        float r119 = this.f559511c;
        PointF r120 = this.f559510b;
        r100.rotate(r119, r120.x, r120.y);
        r100.drawRoundRect(r117, com.ss.android.photoeditor.util.d.b(3) * this.f559509a, com.ss.android.photoeditor.util.d.b(3) * this.f559509a, r118);
        r100.restore();
        Bitmap r121 = this.f559522n;
        PointF r122 = this.f559510b;
        float r123 = r122.x;
        float r124 = this.f559513e;
        float r125 = this.f559509a;
        r100.drawBitmap(r121, e(this.f559524p, r123 + (r124 * r125), r122.y + (this.f559514f * r125)), null);
        Bitmap r126 = this.f559524p;
        if (r126 == null) goto L10;
        PointF r127 = this.f559510b;
        float r128 = r127.x;
        float r129 = this.f559513e;
        float r130 = this.f559509a;
        r100.drawBitmap(r126, e(this.f559522n, r128 - (r129 * r130), r127.y - (this.f559514f * r130)), null);
        return;
    L10:
        return;
    }

    public void update(int r100) {
        if (this.f559517i != r100) goto L5;
        return;
    L5:
        this.f559517i = r100;
        b();
    }

    public void update(String r100) {
        this.f559512d = true;
        update(r100, this.f559517i);
    }

    public final boolean a(float r100, float r101) {
        RectF r102 = new RectF();
        Path r103 = new Path();
        PointF r104 = this.f559527s;
        r103.moveTo(r104.x, r104.y);
        PointF r105 = this.f559528t;
        r103.lineTo(r105.x, r105.y);
        PointF r106 = this.f559529u;
        r103.lineTo(r106.x, r106.y);
        PointF r107 = this.f559530v;
        r103.lineTo(r107.x, r107.y);
        r103.close();
        r103.computeBounds(r102, true);
        Region r108 = new Region();
        this.f559523o = r108;
        r108.setPath(r103, new Region((int) r102.left, (int) r102.top, (int) r102.right, (int) r102.bottom));
        return this.f559523o.contains((int) r100, (int) r101);
    }

    public void update(String r100, int r101) {
        this.f559512d = true;
        this.f559515g = r100;
        this.f559517i = r101;
        b();
        int r102 = this.f559526r.getWidth();
        int r103 = this.f559526r.getHeight();
        this.f559513e = r102 / 2;
        this.f559514f = r103 / 2;
        PointF r104 = this.f559510b;
        this.f559527s = new PointF(r104.x - this.f559513e, r104.y - this.f559514f);
        PointF r105 = this.f559510b;
        this.f559528t = new PointF(r105.x + this.f559513e, r105.y - this.f559514f);
        PointF r106 = this.f559510b;
        this.f559529u = new PointF(r106.x + this.f559513e, r106.y + this.f559514f);
        PointF r107 = this.f559510b;
        this.f559530v = new PointF(r107.x - this.f559513e, r107.y + this.f559514f);
        f();
    }

    public final Matrix e(Bitmap r100, float r101, float r102) {
        float r103 = com.ss.android.photoeditor.util.d.a(this.f559509a * 16.0f) / r100.getWidth();
        float r104 = com.ss.android.photoeditor.util.d.a(this.f559509a * 16.0f) / 2.0f;
        float r105 = com.ss.android.photoeditor.util.d.a(this.f559509a * 16.0f) / 2.0f;
        this.f559521m.reset();
        this.f559521m.postScale(r103, r103);
        this.f559521m.postTranslate(r101 - r104, r102 - r105);
        Matrix r106 = this.f559521m;
        float r107 = this.f559511c;
        PointF r108 = this.f559510b;
        r106.postRotate(r107, r108.x, r108.y);
        return this.f559521m;
    }

    public void update(float r100, float r101, float r102) {
        PointF r103 = this.f559510b;
        r103.x = ((r103.x - r100) * r102) + r100;
        r103.y = ((r103.y - r101) * r102) + r101;
        this.f559509a *= r102;
        f();
    }

    public void update(float r100, float r101, int r102, float r103) {
        PointF r104 = this.f559510b;
        r104.x = r100;
        r104.y = r101;
        this.f559511c = r102;
        this.f559509a = r103;
        this.f559510b = new PointF(r100, r101);
        f();
    }

    public e(TextEditorDrawView r100, int r101, int r102, String r103, float r104, int r105, int r106) {
        this.f559509a = 2.5f;
        this.f559512d = false;
        this.f559518j = 8;
        this.f559525q = false;
        this.f559519k = r100;
        this.f559516h = r100.getContext();
        this.f559515g = r103;
        this.f559517i = r106;
        this.f559509a = r104;
        this.f559511c = r105;
        this.f559520l = new Matrix();
        this.f559521m = new Matrix();
        this.f559510b = new PointF(r101, r102);
        b();
        int r107 = this.f559526r.getWidth();
        int r108 = this.f559526r.getHeight();
        this.f559513e = r107 / 2;
        this.f559514f = r108 / 2;
        Log.d("TextSticker", "halfHeight = " + this.f559514f);
        Log.d("TextSticker", "halfWidth = " + this.f559513e);
        this.f559527s = new PointF((float) (r101 - this.f559513e), (float) (r102 - this.f559514f));
        this.f559528t = new PointF((float) (this.f559513e + r101), (float) (r102 - this.f559514f));
        this.f559529u = new PointF(this.f559513e + r101, this.f559514f + r102);
        this.f559530v = new PointF(r101 - this.f559513e, r102 + this.f559514f);
        this.f559522n = ((BitmapDrawable) r100.getResources().getDrawable(R.drawable.photo_editor_text_editing_change)).getBitmap();
        this.f559524p = ((BitmapDrawable) r100.getResources().getDrawable(R.drawable.photo_editor_text_delete)).getBitmap();
        f();
    }
}
