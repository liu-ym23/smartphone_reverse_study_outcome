package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.utils.d0;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeadGaussItemView extends ImageView implements fa3.d {
    public final Lazy a;
    public final /* synthetic */ fa3.b b;

    private final com.bytedance.android.shopping.anchorv4.voavhs.blur.f getBlurManager() {
        return (com.bytedance.android.shopping.anchorv4.voavhs.blur.f) this.a.getValue();
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.b.add(r2);
        return r2;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.a();
    }

    public HeadGaussItemView(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.b = new fa3.b();
        this.a = LazyKt.lazy(new HeadGaussItemView$blurManager$2(r3));
        setLayoutParams(new ViewGroup.LayoutParams(-1, d0.a()));
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public static Bitmap a(HeadGaussItemView r7, Bitmap r8) {
        return r7.getBlurManager().a(r8, k1.m(r7.getContext()), k1.p(), 1.0f, 16777215, new com.bytedance.android.shopping.anchorv4.voavhs.blur.d(0, 0, 0, r8.getHeight() - k1.p()));
    }

    public static void b(HeadGaussItemView r2, Bitmap r3) {
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        if (r3.isRecycled() == true) goto L13;
        fa3.c.a(Single.just(Bitmap.createBitmap(r3)).observeOn(Schedulers.computation()).map(new a(r2)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r2, null), c.a), r2);
        return;
    L7:
        th = move-exception;
        ECExceptionMonitor.e(th);
        return;
    }
}
