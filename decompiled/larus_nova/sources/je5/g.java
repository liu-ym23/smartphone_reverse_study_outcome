package je5;

import com.bytedance.ies.xbridge.XReadableType;

/* JADX INFO: loaded from: classes18.dex */
public class g extends c66.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498828b;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f498829a = null;

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
            f498829a = r100;
        }
    }

    static {
    }

    public g() {
        this.f498828b = "ccm.teaSendEvent";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f498828b;
    }
}
