package re5;

import android.text.TextUtils;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.storage.StorageValue;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.v;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements p56.d {
    public static final c a = null;

    public /* synthetic */ class a {
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
            r0[XReadableType.Array.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[XReadableType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
        a = new c();
    }

    public c() {
    }

    public final Set<String> c() {
        return SetsKt.emptySet();
    }

    public final boolean a(String r2) {
        if (r2 == null) goto L5;
        ay4.b.c("lynx_storage").remove(r2);
        return true;
    L5:
        return false;
    }

    public final Object d(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        String r5 = ay4.b.c("lynx_storage").getString(r4, "");
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return null;
    L8:
        Intrinsics.checkNotNull(r5);
        Gson r1 = u56.b.a;
        StorageValue r6 = (StorageValue) u56.b.a(r5, StorageValue.class);
        String r2 = r6.getValue();
        XReadableType r7 = XReadableType.valueOf(r6.getType());
        switch(a.a[r7.ordinal()]) {
            case 1: goto L17;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L23;
        };
    L23:
        return null;
    L18:
        return u56.b.a(r2, Map.class);
    L19:
        return u56.b.a(r2, List.class);
    L20:
        return r2;
    L21:
        return Double.valueOf(CastDoubleProtector.parseDouble(r2));
    L22:
        return Integer.valueOf(CastIntegerProtector.parseInt(r2));
    L17:
        return Boolean.valueOf(Boolean.parseBoolean(r2));
    }

    public final String h(Object r4) {
        new LinkedHashMap();
        if ((r4 instanceof Boolean) == false) goto L6;
        Gson r0 = u56.b.a;
        return u56.b.b(new StorageValue("Boolean", String.valueOf(((Boolean) r4).booleanValue())));
    L6:
        if ((r4 instanceof Integer) == false) goto L9;
        Gson r1 = u56.b.a;
        return u56.b.b(new StorageValue("Int", String.valueOf(((Number) r4).intValue())));
    L9:
        if ((r4 instanceof Double) == false) goto L12;
        Gson r2 = u56.b.a;
        return u56.b.b(new StorageValue("Number", String.valueOf(((Number) r4).doubleValue())));
    L12:
        if ((r4 instanceof String) == false) goto L14;
        Gson r3 = u56.b.a;
        return u56.b.b(new StorageValue("String", ((String) r4).toString()));
    L14:
        boolean r5 = r4 instanceof v;
        c r6 = a;
        if (r5 == false) goto L18;
        return r6.h(((v) r4).toList());
    L18:
        if ((r4 instanceof XReadableMap) == false) goto L21;
        return r6.h(((XReadableMap) r4).toMap());
    L21:
        if ((r4 instanceof List) == false) goto L24;
        return u56.b.b(new StorageValue("Array", u56.b.b(r4)));
    L24:
        if ((r4 instanceof Map) == true) goto L35;
        return "";
    L35:
        return u56.b.b(new StorageValue("Map", u56.b.b(r4)));
    }

    public final boolean e(String r3, Object r4) {
        if (r3 == null) goto L6;
        if (r4 == null) goto L8;
        c r0 = a;
        ay4.b.c("lynx_storage").putString(r3, r0.h(r4));
        return true;
    L8:
        return false;
    L6:
        return false;
    }
}
