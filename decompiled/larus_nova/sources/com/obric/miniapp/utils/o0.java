package com.obric.miniapp.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class o0 extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398515b;

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f398515b;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f398514a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f398515b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f398514a;
    }

    public o0(Resources r100, Bitmap r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "resources");
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        super(r100, r101);
        this.f398514a = r102;
        this.f398515b = r103;
    }
}
