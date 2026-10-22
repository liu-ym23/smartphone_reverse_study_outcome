package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ImageWriterCompatApi26Impl {
    private static final String TAG = "ImageWriterCompatApi26";
    private static Method sNewInstanceMethod;

    static {
        Class r3 = Integer.TYPE;     // Catch: NoSuchMethodException -> L4
        sNewInstanceMethod = ImageWriter.class.getMethod("newInstance", new Class[]{Surface.class, r3, r3});     // Catch: NoSuchMethodException -> L4
        return;
    }

    private ImageWriterCompatApi26Impl() {
    }

    public static ImageWriter newInstance(Surface r4, int r5, int r6) {
        Throwable r2 = null;
        if (Build.VERSION.SDK_INT < 26) goto L11;
        return (ImageWriter) Preconditions.checkNotNull(sNewInstanceMethod.invoke(null, new Object[]{r4, Integer.valueOf(r5), Integer.valueOf(r6)}));
    L6:
        e = move-exception;
        r2 = e;
    L11:
        throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", r2);
    }
}
