package l9a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f508115a = 0;

    /* JADX INFO: renamed from: l9a.a$a, reason: collision with other inner class name */
    public static final class C6664a extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f508116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f508117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f508118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f508119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Paint f508120e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Paint f508121f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Paint f508122g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Rect f508123h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Bitmap f508124i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Bitmap f508125j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f508126k;

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.TRANSLUCENT", imports = {}))
        public final int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            return this.f508116a.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            return this.f508116a.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r210) {
            Intrinsics.checkNotNullParameter(r210, "canvas");
            Rect r100 = getBounds();
            if (r100.isEmpty() == false) goto L5;
            return;
        L5:
            this.f508122g.setAlpha(this.f508126k);
            int r101 = r100.width();
            int r102 = r100.height();
            Bitmap r103 = this.f508125j;
            if (r103 != null) goto L8;
        L12:
            int r104 = RangesKt.coerceAtLeast(r101, 1);
            int r105 = RangesKt.coerceAtLeast(r102, 1);
            Bitmap r106 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);
            Canvas r110 = new Canvas(r106);
            if (this.f508119d == false) goto L16;
            int r211 = this.f508117b;
            int r212 = r211;
        L20:
            float r111 = r105;
            this.f508120e.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r111, r211, r212, Shader.TileMode.CLAMP));
            this.f508120e.setAlpha(255);
            r110.drawRect(0.0f, 0.0f, r104, r111, this.f508120e);
            Bitmap r107 = this.f508124i;
            if (r107 != null) goto L23;
        L27:
            r107 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r104, 1), RangesKt.coerceAtLeast(r105, 1), Bitmap.Config.ARGB_8888);
            Canvas r108 = new Canvas(r107);
            this.f508116a.setBounds(0, 0, r107.getWidth(), r107.getHeight());
            this.f508116a.setAlpha(255);
            this.f508116a.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
            this.f508116a.draw(r108);
            this.f508124i = r107;
        L28:
            r110.drawBitmap(r107, 0.0f, 0.0f, this.f508121f);
            this.f508125j = r106;
            r103 = r106;
        L29:
            r210.drawBitmap(r103, null, r100, this.f508122g);
            return;
        L23:
            if (r107.getWidth() != r104) goto L27;
            if (r107.getHeight() != r105) goto L27;
        L16:
            if (this.f508118c == false) goto L18;
            int r109 = this.f508117b;
            int r112 = a.f508115a;
            int r113 = RangesKt.coerceIn(Math.round(Color.alpha(-16777216) * 0.16f), 0, 255);
            int r114 = Color.argb(Color.alpha(r109), RangesKt.coerceAtLeast((Color.red(r109) + ((Color.red(-16777216) * r113) / 255)) - r113, 0), RangesKt.coerceAtLeast((Color.green(r109) + ((Color.green(-16777216) * r113) / 255)) - r113, 0), RangesKt.coerceAtLeast((Color.blue(r109) + ((Color.blue(-16777216) * r113) / 255)) - r113, 0));
        L19:
            r212 = r114;
            r211 = r109;
            goto L20
        L18:
            int r115 = a.f508115a;
            int r116 = this.f508117b;
            int r117 = RangesKt.coerceIn(Math.round(Color.alpha(-1) * 0.16f), 0, 255);
            r109 = Color.argb(Color.alpha(r116), RangesKt.coerceAtMost(Color.red(r116) + ((Color.red(-1) * r117) / 255), 255), RangesKt.coerceAtMost(Color.green(r116) + ((Color.green(-1) * r117) / 255), 255), RangesKt.coerceAtMost(Color.blue(r116) + ((Color.blue(-1) * r117) / 255), 255));
            r114 = this.f508117b;
            goto L19
        L8:
            if (r103.getWidth() != r101) goto L12;
            if (r103.getHeight() != r102) goto L12;
            goto L12
        }

        @Override // android.graphics.drawable.Drawable
        public final void onBoundsChange(Rect r100) {
            Intrinsics.checkNotNullParameter(r100, "bounds");
            super.onBoundsChange(r100);
            if (this.f508123h.width() == r100.width()) goto L5;
        L6:
            this.f508124i = null;
            this.f508125j = null;
        L7:
            this.f508123h.set(r100);
            return;
        L5:
            if (this.f508123h.height() == r100.height()) goto L7;
            goto L6
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r100) {
            if (this.f508126k != r100) goto L5;
            return;
        L5:
            this.f508126k = r100;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r100) {
            this.f508122g.setColorFilter(r100);
            invalidateSelf();
        }

        public C6664a(Drawable r100, int r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f508116a = r100;
            this.f508117b = r101;
            this.f508118c = r102;
            this.f508119d = r103;
            this.f508120e = new Paint(1);
            Paint r104 = new Paint(1);
            this.f508121f = r104;
            this.f508122g = new Paint(3);
            this.f508123h = new Rect();
            this.f508126k = 255;
            r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
    }

    static {
    }
}
