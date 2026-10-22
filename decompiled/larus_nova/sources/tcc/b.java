package tcc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.widget.span.d0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends ReplacementSpan implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f545494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f545495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IntRange f545496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d0.a f545497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LottieDrawable f545498e;

    public static final class a<T> implements LottieListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f545499a;

        public a(b r100) {
            this.f545499a = r100;
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Object r100) {
            b r101 = this.f545499a;
            UICallbackExecutor.post(new tcc.a(r101, (LottieComposition) r100));
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        d0.a r101 = this.f545497d;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return this.f545498e.getBounds().width() + this.f545494a;
    }

    public b(LottieTask<LottieComposition> r100, int r101, int r102, int r103, int r104, IntRange r105) {
        Intrinsics.checkNotNullParameter(r100, "lottieTask");
        this.f545494a = r103;
        this.f545495b = r104;
        this.f545496c = r105;
        LottieDrawable r106 = new LottieDrawable();
        r106.setVisible(true, false);
        r106.w(-1);
        r106.f24726c.setRepeatMode(1);
        r106.setBounds(0, 0, r101, r102);
        this.f545498e = r106;
        r100.addListener(new a(this));
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        r100.save();
        Paint.FontMetricsInt r109 = r108.getFontMetricsInt();
        int r110 = r109.descent;
        r100.translate(r104, (((r106 + r110) - ((r110 - r109.ascent) / 2)) - (this.f545498e.getBounds().height() / 2)) + this.f545495b);
        LottieDrawable r111 = this.f545498e;
        LottieComposition r112 = r111.f24725b;
        if (r112 == null) goto L9;
        float r113 = r111.getBounds().width();
        float r114 = this.f545498e.getBounds().height();
        if (r113 <= 0.0f) goto L9;
        if (r114 <= 0.0f) goto L9;
        r100.scale(r112.getBounds().width() / r113, r112.getBounds().height() / r114);
    L9:
        this.f545498e.draw(r100);
        r100.restore();
    }
}
