package se5;

import com.bytedance.ies.xbridge.XReadableType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.bytedance.ee.bear.lynx.impl.xbridge.method.view.a {

    /* JADX INFO: renamed from: se5.a$a, reason: collision with other inner class name */
    public static final class C0304a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[XReadableType.values().length];
            r0[XReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[XReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[XReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[XReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[XReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[XReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    public a() {
    }
}
