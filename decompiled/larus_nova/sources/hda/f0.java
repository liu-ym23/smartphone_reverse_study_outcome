package hda;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class f0 {
    public static final Bitmap b(Context r100, Uri r101, BitmapFactory.Options r102) {
        String r103 = r101.getScheme();
        if (r103 == null) goto L29;
        int r104 = r103.hashCode();
        if (r104 == 0) goto L27;
        if (r104 == 3143036) goto L23;
        if (r104 == 951530617) goto L12;
        return null;
    L12:
        if (r103.equals("content") == false) goto L38;
        InputStream r105 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);
        if (r105 == null) goto L39;
        Bitmap r106 = BitmapFactory.decodeStream(r105, null, r102);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r105, null);
        return r106;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    L39:
        return null;
    L38:
        return null;
    L23:
        if (r103.equals("file") == true) goto L41;
        return null;
    L41:
        return BitmapFactory.decodeFile(r101.getPath(), r102);
    L27:
        if (r103.equals("") == true) goto L29;
        return null;
    L29:
        String r107 = r101.getPath();
        if (r107 != null) goto L33;
        r107 = r101.toString();
    L33:
        return BitmapFactory.decodeFile(r107, r102);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [hda.d0, java.lang.Object] */
    public static final void d(ImageView r100, String r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "uriText");
        if (StringsKt.isBlank(r101) == false) goto L6;
        r100.setImageDrawable(null);
        return;
    L6:
        final Uri r102 = UriProtector.parse(r101);
        int r103 = 0;
        if (r110 == false) goto L10;
        Resources r104 = r100.getResources();
        int r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).widthPixels;
    L22:
        if (r110 == false) goto L25;
        Resources r106 = r100.getResources();
        r103 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).heightPixels;
    L36:
        final i0 r107 = new i0(r101, r110, r105, r103);
        r100.setTag(r107.f484695e);
        Handler r108 = c0.f484641a;
        final Context r109 = r100.getContext().getApplicationContext();
        final ?? r111 = new d0(r102);
        Intrinsics.checkNotNullParameter(r109, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r107, "request");
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r111, "fallback");
        Bitmap r112 = c0.f484644d.get(r107.f484695e);
        if (r112 == null) goto L39;
        r100.setImageBitmap(r112);
        return;
    L39:
        r100.setImageDrawable(null);
        final WeakReference r113 = new WeakReference(r100);
        c0.f484643c.execute(new a0(r107, r109, r113, r111));
        return;
    L25:
        if (r100.getHeight() <= 0) goto L27;
        r103 = r100.getHeight();
        goto L36
    L27:
        Object r114 = r100.getParent();
        if ((r114 instanceof View) == false) goto L30;
        View r115 = (View) r114;
    L31:
        if (r115 == null) goto L33;
        r103 = r115.getHeight();
    L33:
        if (r103 > 0) goto L36;
        Resources r116 = r100.getResources();
        r103 = RangesKt.coerceAtLeast((int) (WindowDisplayMetricsOverride.apply(r116, r116.getDisplayMetrics()).widthPixels * 0.72f), 240);
        goto L36
    L30:
        r115 = null;
        goto L31
    L10:
        if (r100.getWidth() <= 0) goto L12;
        r105 = r100.getWidth();
        goto L22
    L12:
        Object r117 = r100.getParent();
        if ((r117 instanceof View) == false) goto L15;
        View r118 = (View) r117;
    L16:
        if (r118 == null) goto L18;
        r105 = r118.getWidth();
    L19:
        if (r105 > 0) goto L22;
        Resources r119 = r100.getResources();
        r105 = RangesKt.coerceAtLeast(WindowDisplayMetricsOverride.apply(r119, r119.getDisplayMetrics()).widthPixels / 2, 240);
        goto L22
    L18:
        r105 = 0;
        goto L19
    L15:
        r118 = null;
        goto L16
    }

    public static final Bitmap a(Context r100, Uri r101, final int r102, final int r103) {
        if (Build.VERSION.SDK_INT < 28) goto L33;
        String r104 = r101.getScheme();
        if (r104 == null) goto L26;
        int r105 = r104.hashCode();
        if (r105 == 0) goto L24;
        if (r105 == 3143036) goto L17;
        if (r105 == 951530617) goto L14;
    L25:
        ImageDecoder.Source r106 = null;
    L30:
        if (r106 != null) goto L40;
        return null;
    L40:
        return ImageDecoder.decodeBitmap(r106, new e0(r102, r103));
    L14:
        if (r104.equals("content") == false) goto L25;
        r106 = ImageDecoder.createSource(r100.getContentResolver(), r101);
        goto L30
    L17:
        if (r104.equals("file") == false) goto L25;
        String r107 = r101.getPath();
        if (r107 == null) goto L25;
        r106 = ImageDecoder.createSource(new PolarisFileWrapper(r107));
        goto L30
    L24:
        if (r104.equals("") == false) goto L25;
    L26:
        String r108 = r101.getPath();
        if (r108 != null) goto L29;
        r108 = r101.toString();
    L29:
        r106 = ImageDecoder.createSource(new PolarisFileWrapper(r108));
        goto L30
    L33:
        BitmapFactory.Options r109 = new BitmapFactory.Options();
        r109.inJustDecodeBounds = true;
        b(r100, r101, r109);
        if (r109.outWidth > 0) goto L36;
        return null;
    L36:
        if (r109.outHeight <= 0) goto L43;
        BitmapFactory.Options r110 = new BitmapFactory.Options();
        r110.inSampleSize = c(r109.outWidth, r109.outHeight, r102, r103);
        r110.inPreferredConfig = Bitmap.Config.RGB_565;
        return b(r100, r101, r110);
    L43:
        return null;
    }

    public static final int c(int r100, int r101, int r102, int r103) {
        if (r100 <= 0) goto L16;
        if (r101 <= 0) goto L16;
        if (r102 <= 0) goto L16;
        if (r103 <= 0) goto L16;
        int r104 = 1;
    L9:
        int r105 = r104 * 2;
        if ((r100 / r105) < r102) goto L15;
        if ((r101 / r105) < r103) goto L15;
        r104 = r105;
    L15:
        return RangesKt.coerceAtLeast(r104, 1);
    L16:
        return 1;
    }
}
