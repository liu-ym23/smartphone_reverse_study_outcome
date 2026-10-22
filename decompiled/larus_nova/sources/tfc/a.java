package tfc;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.photoeditor.mosaic.v2.MosaicViewV2;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f545795s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f545796t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f545797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f545798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f545799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PointF f545800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f545801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f545802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f545803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f545804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PointF f545805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f545806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f545807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f545808l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f545809m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f545810n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f545811o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f545812p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f545813q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Matrix f545814r;

    static {
        f545795s = new int[]{0, 1, 1, 1, 0, -1, -1};
        f545796t = new int[]{-1, -1, 0, 1, 1, 1, 0};
    }

    public final void b() {
        PointF r100 = this.f545805i;
        float r101 = r100.x;
        int r102 = this.f545811o;
        float r103 = r100.y;
        int r104 = this.f545812p;
        RectF r105 = new RectF(r101 - r102, r103 - r104, r101 + r102, r103 + r104);
        PointF r106 = this.f545805i;
        float r107 = r106.x;
        float r108 = r106.y;
        float r109 = this.f545802f;
        com.ss.android.photoeditor.util.b.f(r105, r107, r108, r109, r109);
        this.f545797a = new PointF(r105.left, r105.top);
        this.f545798b = new PointF(r105.right, r105.top);
        this.f545799c = new PointF(r105.right, r105.bottom);
        this.f545800d = new PointF(r105.left, r105.bottom);
        PointF r110 = this.f545797a;
        PointF r111 = this.f545805i;
        com.ss.android.photoeditor.util.b.c(r110, r111.x, r111.y, this.f545804h);
        PointF r112 = this.f545798b;
        PointF r113 = this.f545805i;
        com.ss.android.photoeditor.util.b.c(r112, r113.x, r113.y, this.f545804h);
        PointF r114 = this.f545799c;
        PointF r115 = this.f545805i;
        com.ss.android.photoeditor.util.b.c(r114, r115.x, r115.y, this.f545804h);
        PointF r116 = this.f545800d;
        PointF r117 = this.f545805i;
        com.ss.android.photoeditor.util.b.c(r116, r117.x, r117.y, this.f545804h);
    }

    public void update(float r100, float r101, float r102) {
        PointF r103 = this.f545805i;
        r103.x = ((r103.x - r100) * r102) + r100;
        r103.y = ((r103.y - r101) * r102) + r101;
        this.f545802f *= r102;
        b();
    }

    public void update(float r100, float r101, int r102, float r103) {
        PointF r104 = this.f545805i;
        r104.x = r100;
        r104.y = r101;
        this.f545804h = r102;
        this.f545802f = r103;
        this.f545805i = new PointF(r100, r101);
        b();
    }

    public final void a(float r100, float r101, float r102, float r103, float r104) {
        float r105 = Math.min(r100, r102);
        float r106 = Math.min(r101, r103);
        float r107 = Math.max(r100, r102);
        float r108 = Math.max(r101, r103);
        this.f545802f = r104 / this.f545803g;
        this.f545804h = 0;
        this.f545805i = new PointF((r105 + r107) / 2.0f, (r106 + r108) / 2.0f);
        this.f545812p = ((int) (r108 - r106)) / 2;
        this.f545811o = ((int) (r107 - r105)) / 2;
        b();
    }

    public a(MosaicViewV2 r100, float r101, float r102, float r110, float r111, float r112) {
        this.f545802f = 1.0f;
        this.f545804h = 0;
        this.f545813q = false;
        BitmapDrawable r103 = (BitmapDrawable) AppCompatResources.getDrawable(r100.getContext(), R.drawable.photo_editor_mosaic_delete);
        this.f545809m = ContextCompat.getColor(r100.getContext(), R.color.lkui_B500);
        this.f545810n = FakePickerAvatarCreator.LTGRAY;
        this.f545814r = new Matrix();
        this.f545801e = r103.getBitmap();
        this.f545806j = new Paint();
        this.f545807k = new Paint();
        this.f545808l = new Paint();
        this.f545803g = r112;
        a(r101, r102, r110, r111, r112);
    }
}
