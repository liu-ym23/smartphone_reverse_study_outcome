package s88;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f540993a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f540994b = 0;

    public a() {
    }

    static {
        f540993a = new a();
        f540994b = -1;
    }

    public static Bitmap a(Bitmap r110) {
        if (r110 != null) goto L5;
    L33:
        return null;
    L5:
        if (r110.isRecycled() == true) goto L33;
        if (r110.getWidth() <= 0) goto L33;
        if (r110.getHeight() <= 0) goto L33;
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        float r102 = r100;
        float r103 = r101;
        float r104 = r102 / r103;
        if (r104 <= 0.75f) goto L15;
        int r105 = RangesKt.coerceAtLeast((int) Math.ceil(r102 / 0.75f), r101);
        int r106 = r100;
    L19:
        if (r106 != r100) goto L22;
        if (r105 != r101) goto L22;
        return r110;
    L22:
        float r107 = (r106 - r100) / 2.0f;
        float r108 = (r105 - r101) / 2.0f;
        FLogger.f375446a.i("DigitalAvatarPreGenImageProcessor", "padToPortraitRatio: origin=" + r100 + Permission.EXECUTE + r101 + ", target=" + r106 + Permission.EXECUTE + r105 + ", left=" + r107 + ", top=" + r108);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L25
        Bitmap r111 = Bitmap.createBitmap(r106, r105, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L25
        Canvas r112 = new Canvas(r111);     // Catch: Throwable -> L25
        r112.drawColor(f540994b);     // Catch: Throwable -> L25
        r112.drawBitmap(r110, r107, r108, null);     // Catch: Throwable -> L25
        Object r113 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L25
    L27:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 != null) goto L30;
        Object r115 = r113;
    L32:
        return (Bitmap) r115;
    L30:
        FLogger.f375446a.e("DigitalAvatarPreGenImageProcessor", "padToPortraitRatio failed: " + r114.getMessage());
        r115 = r110;
    L25:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L15:
        if (r104 >= 0.75f) goto L17;
        r106 = RangesKt.coerceAtLeast((int) Math.ceil(r103 * 0.75f), r100);
    L18:
        r105 = r101;
        goto L19
    L17:
        r106 = r100;
        goto L18
    }
}
