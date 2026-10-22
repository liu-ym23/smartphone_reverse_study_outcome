package gz4;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.larksuite.framework.utils.x;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static Bitmap a(final Activity r5, final View r6, final int r7, final int r8) {
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r5 != null) goto L8;
    L24:
        tt5.a.d("ScreenshotUtils", "activity is illegal");
        return null;
    L8:
        if (r5.isDestroyed() == true) goto L24;
        if (r5.isFinishing() == true) goto L24;
    L18:
        th = move-exception;
        tt5.a.f("ScreenshotUtils", th, false);
        return null;
    L14:
        if (x.c() == true) goto L16;
    L20:
        Bitmap r9 = (Bitmap) Flowable.create(new a(r6), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.d()).observeOn(fo5.d.b()).blockingSingle();     // Catch: Throwable -> L18
    L27:
        return r9;
    L16:
        if ((!com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.screenshot_type_pixelcopy_enable", false)) == false) goto L20;
        r9 = (Bitmap) Flowable.create(new b(r6, r8, r7, r5), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.d()).observeOn(fo5.d.b()).blockingSingle();     // Catch: Throwable -> L18
        goto L27
    }
}
