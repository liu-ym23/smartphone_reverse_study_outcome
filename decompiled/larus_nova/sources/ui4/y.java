package ui4;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f550205a = null;

    static {
        int[] r100 = new int[ImageView.ScaleType.values().length];
        r100[ImageView.ScaleType.MATRIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L23:
        r100[ImageView.ScaleType.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L35:
        r100[ImageView.ScaleType.CENTER_CROP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
    L25:
        r100[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
    L27:
        r100[ImageView.ScaleType.FIT_CENTER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
    L21:
        r100[ImageView.ScaleType.FIT_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
    L29:
        r100[ImageView.ScaleType.FIT_START.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
    L31:
        r100[ImageView.ScaleType.FIT_XY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
    L11:
        f550205a = r100;
    }
}
