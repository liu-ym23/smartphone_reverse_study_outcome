package re5;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class e extends s66.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f537429c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f537430a = null;

        static {
            int[] r100 = new int[XReadableType.values().length];
            r100[XReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[XReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[XReadableType.String.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[XReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[XReadableType.Array.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[XReadableType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f537430a = r100;
        }
    }

    public e() {
        this.f537429c = "ccm.setStorageItem";
    }

    @Override // s66.d, com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f537429c;
    }

    @Override // s66.d
    public final void e(u66.e r100, s66.d.a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        boolean r103 = false;
        if (((Context) provideContext(Context.class)) != null) goto L6;
        r101.a(0, "Context not provided in host");
        return;
    L6:
        String r104 = r100.f548938a;
        t r105 = null;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("key");
        r104 = null;
    L10:
        t r106 = r100.f548939b;
        if (r106 == null) goto L13;
        r105 = r106;
    L15:
        switch(a.f537430a[r105.getType().ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L23;
        };
    L17:
        r103 = c.f537426a.e(r104, r105.asMap());
        goto L23
    L18:
        r103 = c.f537426a.e(r104, r105.asArray());
        goto L23
    L19:
        r103 = c.f537426a.e(r104, Double.valueOf(r105.asDouble()));
        goto L23
    L20:
        r103 = c.f537426a.e(r104, r105.asString());
        goto L23
    L21:
        r103 = c.f537426a.e(r104, Integer.valueOf(r105.asInt()));
        goto L23
    L22:
        r103 = c.f537426a.e(r104, Boolean.valueOf(r105.asBoolean()));
    L23:
        if (r103 == false) goto L25;
        r101.b(new i66.b(), "");
        return;
    L25:
        r101.a(-3, "Illegal value type");
        return;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("data");
        goto L15
    }
}
