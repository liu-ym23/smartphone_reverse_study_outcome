package xi9;

import com.bytedance.ies.xbridge.XReadableType;

/* JADX INFO: loaded from: classes30.dex */
public final class b extends xi9.a {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f563973a = null;

        static {
            int[] r100 = new int[XReadableType.values().length];
            r100[XReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[XReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[XReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[XReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[XReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[XReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f563973a = r100;
        }
    }

    public b() {
    }
}
