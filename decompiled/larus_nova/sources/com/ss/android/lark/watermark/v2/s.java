package com.ss.android.lark.watermark.v2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class s extends BitmapDrawable {
    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.draw(r100);
    }

    public s(Resources r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "resources");
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        super(r100, r101);
        Shader.TileMode r102 = Shader.TileMode.REPEAT;
        setTileModeXY(r102, r102);
        setDither(true);
    }
}
