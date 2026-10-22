package sja;

import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: sja.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C7622a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f542310a = null;

        static {
            int[] r100 = new int[ScaleType.values().length];
            f542310a = r100;
            r100[ScaleType.ScaleAspectFitCenter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            f542310a[ScaleType.ScaleAspectFill.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            f542310a[ScaleType.TopFill.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            f542310a[ScaleType.BottomFill.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            f542310a[ScaleType.LeftFill.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            f542310a[ScaleType.RightFill.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            f542310a[ScaleType.TopFit.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            f542310a[ScaleType.BottomFit.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            f542310a[ScaleType.LeftFit.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            f542310a[ScaleType.RightFit.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static float[] a(float r100, float r101, float r102, float r103) {
        float r104 = (r100 / 2.0f) + 0.5f;
        float r105 = r103 + 0.0f;
        float r106 = 1.0f - (r102 / 2.0f);
        float r107 = 1.0f - r101;
        return new float[]{-1.0f, -1.0f, 0.0f, r104, r105, 1.0f, -1.0f, 0.0f, r106, r105, -1.0f, 1.0f, 0.0f, r104, r107, 1.0f, 1.0f, 0.0f, r106, r107};
    }

    public static float[] b(float r100, float r101, float r102, float r103) {
        float r104 = (r100 * 2.0f) - 1.0f;
        float r105 = (r103 * 2.0f) - 1.0f;
        float r106 = 1.0f - (r102 * 2.0f);
        float r107 = 1.0f - (r101 * 2.0f);
        return new float[]{r104, r105, 0.0f, 0.5f, 0.0f, r106, r105, 0.0f, 1.0f, 0.0f, r104, r107, 0.0f, 0.5f, 1.0f, r106, r107, 0.0f, 1.0f, 1.0f};
    }
}
