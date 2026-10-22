package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements Runnable {
    public final /* synthetic */ Drawable a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ float c;
    public final /* synthetic */ FontPickerAdapter.FontViewHolder d;
    public final /* synthetic */ boolean e;

    public e(Drawable r1, ImageView r2, float r3, FontPickerAdapter.FontViewHolder r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        Bitmap r6 = DrawableKt.toBitmap$default(this.a, 0, 0, null, 7, null);     // Catch: Exception -> L12
        int r0 = this.b.getHeight();     // Catch: Exception -> L12
        float r1 = this.c;     // Catch: Exception -> L12
        if (r1 <= 0.0f) goto L5;
        float r2 = r0 / r1;     // Catch: Exception -> L12
        Matrix r11 = new Matrix();     // Catch: Exception -> L12
        r11.postScale(r2, r2);     // Catch: Exception -> L12
        Bitmap r3 = Bitmap.createBitmap(r6, 0, 0, r6.getWidth(), r6.getHeight(), r11, true);     // Catch: Exception -> L12
    L6:
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L12
        FontPickerAdapter.FontViewHolder r4 = this.d;     // Catch: Exception -> L12
        Context r5 = this.b.getContext();     // Catch: Exception -> L12
        if (this.e == false) goto L9;
        int r7 = 2131106610;
    L10:
        int r8 = ContextCompat.getColor(r5, r7);     // Catch: Exception -> L12
        int r9 = FontPickerAdapter.FontViewHolder.g;     // Catch: Exception -> L12
        r4.getClass();     // Catch: Exception -> L12
        Paint r10 = new Paint();     // Catch: Exception -> L12
        r10.setColorFilter(new PorterDuffColorFilter(r8, PorterDuff.Mode.SRC_IN));     // Catch: Exception -> L12
        new Canvas(r3).drawBitmap(r3, 0.0f, 0.0f, r10);     // Catch: Exception -> L12
        this.b.setImageBitmap(r3);     // Catch: Exception -> L12
        return;
    L9:
        r7 = 2131106622;
        goto L10
    L5:
        r3 = DrawableKt.toBitmap$default(this.a, 0, 0, null, 7, null);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
