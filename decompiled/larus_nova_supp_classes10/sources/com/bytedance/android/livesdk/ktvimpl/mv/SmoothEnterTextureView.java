package com.bytedance.android.livesdk.ktvimpl.mv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011R2\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/SmoothEnterTextureView;", "Landroid/view/TextureView;", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "", "a", "Lkotlin/jvm/functions/Function1;", "getBgInfock", "()Lkotlin/jvm/functions/Function1;", "setBgInfock", "(Lkotlin/jvm/functions/Function1;)V", "bgInfock", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SmoothEnterTextureView extends TextureView {
    public Function1<? super Drawable, Unit> a;
    public final Handler b;
    public final a c;

    public static final class a implements Runnable {
        public final /* synthetic */ SmoothEnterTextureView a;

        public a(SmoothEnterTextureView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<Drawable, Unit> r0 = this.a.getBgInfock();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            Unit r1 = (Unit) r0.invoke(null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.postDelayed(this.c, 300);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        Bitmap r0 = getBitmap();     // Catch: Throwable -> L8
        if (r0 == null) goto L10;
        BitmapDrawable r1 = new BitmapDrawable(getContext().getResources(), r0);     // Catch: Throwable -> L8
        this.b.removeCallbacks(this.c);     // Catch: Throwable -> L8
        Function1<? super Drawable, Unit> r2 = this.a;     // Catch: Throwable -> L8
        if (r2 == null) goto L10;
        Unit r3 = (Unit) r2.invoke(r1);     // Catch: Throwable -> L8
    L10:
        super.onDetachedFromWindow();
        return;
    L8:
        th = move-exception;
        ALogger.i("SmoothEnterTextureView", "getBitMap error" + th.getMessage());
        goto L10
    }

    public final Function1<Drawable, Unit> getBgInfock() {
        return this.a;
    }

    public final void setBgInfock(Function1<? super Drawable, Unit> r1) {
        this.a = r1;
    }

    public SmoothEnterTextureView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = new Handler(Looper.getMainLooper());
        this.c = new a(this);
    }
}
