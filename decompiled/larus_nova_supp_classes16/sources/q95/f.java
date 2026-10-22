package q95;

import android.graphics.Bitmap;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            a = r0;
            r0[Bitmap.Config.ALPHA_8.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[Bitmap.Config.ARGB_8888.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        "0123456789abcdef".toCharArray();
    }

    public static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("You must call this method on the main thread");
    L5:
        r0 = false;
        goto L6
    }

    public static int b(Bitmap r1) {
        return r1.getAllocationByteCount();
    L5:
        return r1.getHeight() * r1.getRowBytes();
    }
}
