package com.bytedance.android.shopping.deepfeed.weights.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.infeed.data.idl.HeaderBannerItemType;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoCoverLayout;", "Landroid/widget/FrameLayout;", "", "isMute", "", "setAudioState", "isPlaying", "setPlayState", "", "duration", "setTotalDuration", "Lfd3/b;", "a", "Lfd3/b;", "getCallback", "()Lfd3/b;", "setCallback", "(Lfd3/b;)V", "callback", "Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "g", "Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "getProgressIndicator", "()Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "progressIndicator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCoverLayout extends FrameLayout {
    public static final int m = 0;
    public static final int n = 0;
    public fd3.b a;
    public final Paint b;
    public final RectF c;
    public float d;
    public int e;
    public final VideoProgressTextLayout f;
    public final ProductCardProgressIndicator g;
    public HeaderBannerItemType h;
    public HeaderBannerItemType i;
    public boolean j;
    public final VideoProgressBar k;
    public boolean l;

    public static final class a implements fd3.a {
        public final /* synthetic */ VideoCoverLayout a;

        @Override // fd3.a
        public final void onDragEnd() {
            VideoCoverLayout r0 = this.a;
            int r1 = VideoCoverLayout.m;
            if (r0.a() == false) goto L5;
            r0.g.setVisibility(0);
            r0.k.setVisibility(4);
        L5:
            fd3.b r2 = r0.a;
            if (r2 == null) goto L9;
            r2.b();
            return;
        }

        @Override // fd3.a
        public final void onDragStart() {
            VideoCoverLayout r0 = this.a;
            int r1 = VideoCoverLayout.m;
            if (r0.a() == false) goto L5;
            r0.g.setVisibility(4);
            r0.k.setVisibility(0);
        L5:
            fd3.b r2 = r0.a;
            if (r2 == null) goto L8;
            r2.c();
        L8:
            float r3 = r0.k.getDragProgress();
            VideoProgressTextLayout r4 = r0.f;
            int r5 = r0.e;
            r4.a.setText(VideoProgressTextLayout.a((int) (r3 * r5)));
            r4.b.setText(VideoProgressTextLayout.a(r5));
        }

        public a(VideoCoverLayout r1) {
            this.a = r1;
        }

        @Override // fd3.a
        public final void a(float r2) {
            fd3.b r0 = this.a.getCallback();
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        @Override // fd3.a
        public final void b(float r4) {
            VideoCoverLayout r0 = this.a;
            int r1 = VideoCoverLayout.m;
            VideoProgressTextLayout r2 = r0.f;
            int r3 = r0.e;
            r2.a.setText(VideoProgressTextLayout.a((int) (r4 * r3)));
            r2.b.setText(VideoProgressTextLayout.a(r3));
        }

        @Override // fd3.a
        public final void c(float r2) {
            VideoCoverLayout r0 = this.a;
            r0.d = r2;
            r0.f.setAlpha(r2);
            this.a.invalidate();
        }
    }

    public static final class b {
    }

    public VideoCoverLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoCoverLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setAudioState(boolean r1) {
    }

    public final void setPlayState(boolean r1) {
    }

    static {
        m = com.bytedance.android.shopping.extensions.b.a(60);
        n = com.bytedance.android.shopping.extensions.b.a(110);
    }

    public final boolean a() {
        if (this.h != HeaderBannerItemType.VideoAndImage) goto L5;
        return true;
    L5:
        return false;
    }

    public final fd3.b getCallback() {
        return this.a;
    }

    public final ProductCardProgressIndicator getProgressIndicator() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        int r0 = n;
        int r1 = m;
        float r2 = ((r0 - r1) * this.d) + r1;
        int r3 = c.a;
        float r4 = r2 + c.d(12);
        if (this.c.height() == r4) goto L5;
    L8:
        float r5 = getHeight() + c.d(12);
        this.c.set(0.0f, r5 - r4, getWidth(), r5);
        Paint r6 = this.b;
        RectF r7 = this.c;
        r6.setShader(new LinearGradient(0.0f, r7.top, 0.0f, r7.bottom, 0, 520093696, Shader.TileMode.CLAMP));
    L9:
        r11.drawRect(this.c, this.b);
        super.dispatchDraw(r11);
        return;
    L5:
        if (this.c.width() != getWidth()) goto L8;
        if (this.c.bottom == getBottom()) goto L9;
        goto L8
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        if (this.j == false) goto L12;
        if (a() == false) goto L12;
        if (this.i != HeaderBannerItemType.CoverVideo) goto L12;
        if (this.k.a(r4) == false) goto L12;
        return true;
    L12:
        if (this.k.getVisibility() != 0) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == false) goto L20;
        if (this.k.a(r4) == false) goto L20;
        return true;
    L20:
        return super.onTouchEvent(r4);
    L14:
        r0 = false;
        goto L15
    }

    public final void setCallback(fd3.b r1) {
        this.a = r1;
    }

    public final void setTotalDuration(long r3) {
        this.e = (int) (r3 / ((long) 1000));
    }

    public final void b(float r2, boolean r3) {
        if (a() == true) goto L5;
        VideoProgressBar r4 = this.k;
        r4.getClass();
        r4.c = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r2, 1.0f), 0.0f);
        r4.invalidate();
        return;
    L5:
        if (r3 == false) goto L7;
        this.g.setFillCurrent(false);
    L7:
        this.g.b(0, r2);
    }

    public final void c(HeaderBannerItemType r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        this.h = r3;
        if (r3 != HeaderBannerItemType.VideoAndImage) goto L6;
        this.g.setup(r4);
        this.g.b(0, 0.0f);
    L6:
        if (this.h != HeaderBannerItemType.CoverVideo) goto L8;
        this.k.setVisibility(0);
        this.g.setVisibility(4);
        return;
    L8:
        this.k.setVisibility(4);
        this.g.setVisibility(0);
    }

    public VideoCoverLayout(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        Paint r11 = new Paint(1);
        r11.setStyle(Paint.Style.FILL);
        Unit r12 = Unit.INSTANCE;
        this.b = r11;
        this.c = new RectF();
        VideoProgressTextLayout r13 = new VideoProgressTextLayout(r8, null, 6, 0);
        r13.setAlpha(0.0f);
        this.f = r13;
        ProductCardProgressIndicator r3 = new ProductCardProgressIndicator(r8, null, 6, 0);
        this.g = r3;
        HeaderBannerItemType r0 = HeaderBannerItemType.CoverVideo;
        this.h = r0;
        this.i = r0;
        VideoProgressBar r1 = new VideoProgressBar(r8, null, 4, 0);
        a r14 = new a(this);
        Intrinsics.checkNotNullParameter(r14, "callback");
        r1.j = r14;
        r1.k = false;
        r1.l = null;
        this.k = r1;
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, -2);
        r15.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r15.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r15.gravity = 80;
        addView(r1, r15);
        int r6 = c.a;
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-2, c.d(2));
        r16.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r16.rightMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r16.gravity = 80;
        addView(r3, r16);
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-2, -2);
        r17.gravity = 81;
        r17.bottomMargin = c.d(70);
        addView(r13, r17);
        setClipChildren(false);
        ExtensionsKt.gone(r1);
        r1.c(0.0f);
        ExtensionsKt.gone(r13);
        setPlayState(false);
    }

    public /* synthetic */ VideoCoverLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
