package t66;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import kotlin.jvm.internal.Intrinsics;
import u66.e;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends s66.d {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f544671a = null;

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
            f544671a = r100;
        }
    }

    public d() {
    }

    @Override // s66.d
    public final void e(e r100, s66.d.a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Context r103 = (Context) provideContext(Context.class);
        boolean r104 = false;
        if (r103 != null) goto L6;
        r101.a(0, "Context not provided in host");
        return;
    L6:
        String r105 = r100.f548938a;
        t r106 = null;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("key");
        r105 = null;
    L10:
        t r107 = r100.f548939b;
        if (r107 == null) goto L13;
        r106 = r107;
    L14:
        String r108 = r100.f548940c;
        switch(a.f544671a[r106.getType().ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L23;
        };
    L17:
        r104 = f(r103, r108, r105, r106.asMap());
        goto L23
    L18:
        r104 = f(r103, r108, r105, r106.asArray());
        goto L23
    L19:
        r104 = f(r103, r108, r105, Double.valueOf(r106.asDouble()));
        goto L23
    L20:
        r104 = f(r103, r108, r105, r106.asString());
        goto L23
    L21:
        r104 = f(r103, r108, r105, Integer.valueOf(r106.asInt()));
        goto L23
    L22:
        r104 = f(r103, r108, r105, Boolean.valueOf(r106.asBoolean()));
    L23:
        if (r104 == false) goto L25;
        r101.b(new i66.b(), "");
        return;
    L25:
        r101.a(-3, "Illegal value type");
        return;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("data");
        goto L14
    }

    public static boolean f(Context r100, String r101, String r102, Object r103) {
        p56.d r104 = com.bytedance.ies.xbridge.storage.utils.a.a(r100);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r101 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L14;
        if ((r104 instanceof p56.a) == false) goto L14;
        Intrinsics.checkNotNull(r101);
        return ((p56.a) r104).f(r101, r102, r103);
    L14:
        return r104.e(r102, r103);
    L5:
        if (r101.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
