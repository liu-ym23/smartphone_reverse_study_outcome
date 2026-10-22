package se5;

import com.bytedance.ies.xbridge.XReadableType;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends com.bytedance.ee.bear.lynx.impl.xbridge.method.view.a {

    /* JADX INFO: renamed from: se5.a$a, reason: collision with other inner class name */
    public static final class C7600a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f541560a = null;

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
            f541560a = r100;
        }
    }

    static {
    }

    public a() {
    }
}
