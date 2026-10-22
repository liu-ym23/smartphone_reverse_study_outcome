package ypb;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vpb.d;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568733a = 0;

    static {
    }

    public static boolean b(int r100) {
        if (r100 < 0) goto L6;
        if (r100 > 55295) goto L6;
    L9:
        return true;
    L6:
        if (r100 >= 57344) goto L8;
    L10:
        return false;
    L8:
        if (r100 > 1114111) goto L10;
        goto L9
    }

    public static Bitmap a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
    L9:
        e = move-exception;
        Log.e("IconUtil", e);
        Bitmap r101 = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
        Intrinsics.checkNotNull(r101);
        return r101;
    L4:
        if ((r100 instanceof BitmapDrawable) == true) goto L6;
        Application r102 = LarkContext.getApplication();     // Catch: Exception -> L9
        int r103 = d.f556736h;     // Catch: Exception -> L9
        int r104 = UIUtils.dp2px(r102, 44.0f);     // Catch: Exception -> L9
        int r105 = UIUtils.dp2px(LarkContext.getApplication(), 44.0f);     // Catch: Exception -> L9
        Bitmap r106 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L9
        Canvas r107 = new Canvas(r106);     // Catch: Exception -> L9
        r100.setBounds(0, 0, r104, r105);     // Catch: Exception -> L9
        r100.draw(r107);     // Catch: Exception -> L9
        return r106;
    L6:
        return ((BitmapDrawable) r100).getBitmap();
    }

    @JvmStatic
    public static final Bitmap c(Bitmap r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        Matrix r105 = new Matrix();
        r105.postScale(r101 / r103, r102 / r104);
        return Bitmap.createBitmap(r100, 0, 0, r103, r104, r105, false);
    }
}
