package q95;

import android.graphics.Bitmap;
import android.os.Looper;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f532111a = 0;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f532112a = null;

        static {
            int[] r100 = new int[Bitmap.Config.values().length];
            f532112a = r100;
            r100[Bitmap.Config.ALPHA_8.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f532112a[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f532112a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f532112a[Bitmap.Config.ARGB_8888.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        "0123456789abcdef".toCharArray();
    }

    public static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("You must call this method on the main thread");
    L5:
        r100 = false;
        goto L6
    }

    public static int b(Bitmap r100) {
        return r100.getAllocationByteCount();
    L5:
        return r100.getHeight() * r100.getRowBytes();
    }
}
