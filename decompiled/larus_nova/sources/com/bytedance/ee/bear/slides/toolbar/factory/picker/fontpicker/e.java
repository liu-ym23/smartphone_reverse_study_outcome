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
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Drawable f238709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f238710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f238711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FontPickerAdapter.FontViewHolder f238712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f238713e;

    public e(Drawable r100, ImageView r101, float r102, FontPickerAdapter.FontViewHolder r103, boolean r104) {
        this.f238709a = r100;
        this.f238710b = r101;
        this.f238711c = r102;
        this.f238712d = r103;
        this.f238713e = r104;
    }

    public final void a() {
        Bitmap r100 = DrawableKt.toBitmap$default(this.f238709a, 0, 0, null, 7, null);     // Catch: Exception -> L12
        int r101 = this.f238710b.getHeight();     // Catch: Exception -> L12
        float r102 = this.f238711c;     // Catch: Exception -> L12
        if (r102 <= 0.0f) goto L5;
        float r103 = r101 / r102;     // Catch: Exception -> L12
        Matrix r110 = new Matrix();     // Catch: Exception -> L12
        r110.postScale(r103, r103);     // Catch: Exception -> L12
        Bitmap r104 = Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r110, true);     // Catch: Exception -> L12
    L6:
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L12
        FontPickerAdapter.FontViewHolder r105 = this.f238712d;     // Catch: Exception -> L12
        Context r106 = this.f238710b.getContext();     // Catch: Exception -> L12
        if (this.f238713e == false) goto L9;
        int r107 = R.color.text_disable;
    L10:
        int r108 = ContextCompat.getColor(r106, r107);     // Catch: Exception -> L12
        int r109 = FontPickerAdapter.FontViewHolder.f238681g;     // Catch: Exception -> L12
        r105.getClass();     // Catch: Exception -> L12
        Paint r111 = new Paint();     // Catch: Exception -> L12
        r111.setColorFilter(new PorterDuffColorFilter(r108, PorterDuff.Mode.SRC_IN));     // Catch: Exception -> L12
        new Canvas(r104).drawBitmap(r104, 0.0f, 0.0f, r111);     // Catch: Exception -> L12
        this.f238710b.setImageBitmap(r104);     // Catch: Exception -> L12
        return;
    L9:
        r107 = R.color.text_title;
        goto L10
    L5:
        r104 = DrawableKt.toBitmap$default(this.f238709a, 0, 0, null, 7, null);     // Catch: Exception -> L12
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
