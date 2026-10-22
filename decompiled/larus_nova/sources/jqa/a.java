package jqa;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static final /* synthetic */ void b(Drawable r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
        DrawableCompat.setTintList(DrawableCompat.wrap(r100), ColorStateList.valueOf(r102));
        return;
    }

    public static final /* synthetic */ Drawable a(Drawable r100, Context r101, Integer r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102 == null) goto L7;
        if (r103 == null) goto L8;
        Bitmap r104 = Bitmap.createBitmap(r102.intValue(), r103.intValue(), Bitmap.Config.ARGB_8888);
        Canvas r105 = new Canvas(r104);
        r100.setBounds(0, 0, r102.intValue(), r103.intValue());
        r100.draw(r105);
        return new BitmapDrawable(r101.getResources(), r104);
    L8:
        return r100;
    L7:
        return r100;
    }
}
