package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.core.utils.k1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/LargeImageView;", "Landroid/view/View;", "Ljava/io/InputStream;", "stream", "", "setInputStream", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/m;", "largeImageMoveListener", "setLargeImageMoveListener", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/o;", "i", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/o;", "getMDetector", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/o;", "setMDetector", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/o;)V", "mDetector", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LargeImageView extends View {
    public BitmapRegionDecoder a;
    public int b;
    public int c;
    public volatile Rect d;
    public final Matrix e;
    public float f;
    public final BitmapFactory.Options g;
    public m h;
    public o i;

    public static final class a implements p {
        public final /* synthetic */ LargeImageView a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.p
        public final void b(o r2) {
            Intrinsics.checkNotNullParameter(r2, "detector");
        }

        public a(LargeImageView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.p
        public final void a(o r8) {
            Intrinsics.checkNotNullParameter(r8, "detector");
            PointF r9 = r8.e;
            int r0 = (int) r9.x;
            int r10 = (int) r9.y;
            LargeImageView r1 = this.a;
            if (r1.c <= r1.getWidth()) goto L19;
            this.a.d.offset(-r0, 0);
            LargeImageView r2 = this.a;
            if (r2.d.right <= r2.c) goto L12;
            r2.d.right = r2.c;
            Rect r3 = r2.d;
            if (r2.f == 0.0f) goto L9;
            int r4 = r2.c;
            int r5 = (int) (r2.getWidth() / r2.f);
        L10:
            r3.left = r4 - r5;
            goto L12
        L9:
            r4 = r2.c;
            r5 = r2.getWidth();
        L12:
            if (r2.d.left >= 0) goto L18;
            r2.d.left = 0;
            Rect r6 = r2.d;
            if (r2.f == 0.0f) goto L16;
            int r7 = (int) (r2.getWidth() / r2.f);
        L17:
            r6.right = r7;
            goto L18
        L16:
            r7 = r2.getWidth();
        L18:
            this.a.invalidate();
        L19:
            LargeImageView r11 = this.a;
            if (r11.b <= r11.getHeight()) goto L36;
            this.a.d.offset(0, -r10);
            LargeImageView r12 = this.a;
            if (r12.d.bottom <= r12.b) goto L29;
            r12.d.bottom = r12.b;
            Rect r13 = r12.d;
            if (r12.f == 0.0f) goto L26;
            int r14 = r12.b;
            int r15 = (int) (r12.getHeight() / r12.f);
        L27:
            r13.top = r14 - r15;
            goto L29
        L26:
            r14 = r12.b;
            r15 = r12.getHeight();
        L29:
            if (r12.d.top >= 0) goto L35;
            r12.d.top = 0;
            Rect r16 = r12.d;
            if (r12.f == 0.0f) goto L33;
            int r17 = (int) (r12.getHeight() / r12.f);
        L34:
            r16.bottom = r17;
            goto L35
        L33:
            r17 = r12.getHeight();
        L35:
            this.a.invalidate();
        L36:
            m r18 = this.a.h;
            if (r18 == null) goto L40;
            r18.b();
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.p
        public final void c(o r2) {
            Intrinsics.checkNotNullParameter(r2, "detector");
            m r3 = this.a.h;
            if (r3 == null) goto L6;
            r3.a();
            return;
        }
    }

    public LargeImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LargeImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final o getMDetector() {
        return this.i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        BitmapRegionDecoder r0 = this.a;
        if (r0 == null) goto L5;
        Bitmap r1 = r0.decodeRegion(this.d, this.g);
    L6:
        if (r1 == null) goto L9;
        r5.drawBitmap(r1, this.e, null);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setInputStream(InputStream r7) {
        Intrinsics.checkNotNullParameter(r7, "stream");
        ByteArrayInputStream r0 = null;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L28 Exception -> L36
        byte[] r2 = new byte[1024];     // Catch: Throwable -> L28 Exception -> L36
    L4:
        int r3 = r7.read(r2);     // Catch: Throwable -> L28 Exception -> L36
        if (r3 == (-1)) goto L7;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L28 Exception -> L36
        goto L4
    L7:
        r1.flush();     // Catch: Throwable -> L28 Exception -> L36
        ByteArrayInputStream r4 = new ByteArrayInputStream(r1.toByteArray());     // Catch: Throwable -> L28 Exception -> L36
        ByteArrayInputStream r5 = new ByteArrayInputStream(r1.toByteArray());     // Catch: Throwable -> L23 Exception -> L26
        this.a = BitmapRegionDecoder.newInstance(r4, false);     // Catch: Throwable -> L21 Exception -> L44
        BitmapFactory.Options r6 = new BitmapFactory.Options();     // Catch: Throwable -> L21 Exception -> L44
        r6.inJustDecodeBounds = true;     // Catch: Throwable -> L21 Exception -> L44
        BitmapFactory.decodeStream(r5, null, r6);     // Catch: Throwable -> L21 Exception -> L44
        int r8 = r6.outWidth;     // Catch: Throwable -> L21 Exception -> L44
        this.c = r8;     // Catch: Throwable -> L21 Exception -> L44
        this.b = r6.outHeight;     // Catch: Throwable -> L21 Exception -> L44
        if (r8 == 0) goto L12;
        float r9 = k1.m(getContext()) / this.c;     // Catch: Throwable -> L21 Exception -> L44
    L13:
        this.f = r9;     // Catch: Throwable -> L21 Exception -> L44
        this.e.postScale(r9, r9);     // Catch: Throwable -> L21 Exception -> L44
        float r10 = this.b * this.f;     // Catch: Throwable -> L21 Exception -> L44
        float r11 = k1.j(getContext());     // Catch: Throwable -> L21 Exception -> L44
        if (r10 >= r11) goto L16;
        this.e.postTranslate(0.0f, (r11 - r10) / 2);     // Catch: Throwable -> L21 Exception -> L44
    L16:
        requestLayout();     // Catch: Throwable -> L21 Exception -> L44
        invalidate();     // Catch: Throwable -> L21 Exception -> L44
        r4.close();     // Catch: Exception -> L42
    L18:
        r5.close();     // Catch: Exception -> L42
    L19:
        r7.close();     // Catch: Exception -> L42
        return;
        goto L27
    L12:
        r9 = 1.0f;
    L21:
        th = th;
    L25:
        r0 = r4;
    L30:
        if (r0 != null) goto L45;
    L32:
        if (r5 == null) goto L34;
        r5.close();     // Catch: Exception -> L43
    L34:
        r7.close();     // Catch: Exception -> L43
    L35:
        throw th;
    L45:
        r0.close();     // Catch: Exception -> L43
    L27:
        r0 = r4;
    L37:
        if (r0 == null) goto L39;
        r0.close();     // Catch: Exception -> L42
    L39:
        if (r5 == null) goto L19;
    L26:
        r5 = null;
    L23:
        th = th;
        r5 = null;
        goto L25
    L36:
        r5 = null;
    L28:
        th = th;
        r5 = null;
    }

    public final void setLargeImageMoveListener(m r2) {
        Intrinsics.checkNotNullParameter(r2, "largeImageMoveListener");
        this.h = r2;
    }

    public final void setMDetector(o r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        int r7 = getMeasuredWidth();
        int r8 = getMeasuredHeight();
        this.d.left = 0;
        this.d.top = 0;
        Rect r0 = this.d;
        if (this.f == 0.0f) goto L5;
        int r1 = this.d.left;
        r7 = (int) (r7 / this.f);
    L6:
        r0.right = r1 + r7;
        Rect r9 = this.d;
        if (this.f == 0.0f) goto L9;
        int r2 = this.d.top;
        r8 = (int) (r8 / this.f);
    L10:
        r9.bottom = r2 + r8;
        return;
    L9:
        r2 = this.d.top;
        goto L10
    L5:
        r1 = this.d.left;
        goto L6
    }

    public LargeImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = new Rect();
        this.e = new Matrix();
        this.f = 1.0f;
        BitmapFactory.Options r5 = new BitmapFactory.Options();
        r5.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Unit r6 = Unit.INSTANCE;
        this.g = r5;
        setClickable(true);
        this.i = new o(new a(this));
    }

    public /* synthetic */ LargeImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
