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

/* JADX INFO: loaded from: classes18.dex */
public final class c implements p56.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f537426a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f537427a = null;

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
            r100[XReadableType.Array.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[XReadableType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f537427a = r100;
        }
    }

    static {
        f537426a = new c();
    }

    public c() {
    }

    @Override // p56.d
    public final Set<String> c() {
        return SetsKt.emptySet();
    }

    @Override // p56.d
    public final boolean a(String r100) {
        if (r100 == null) goto L5;
        ay4.b.c("lynx_storage").remove(r100);
        return true;
    L5:
        return false;
    }

    @Override // p56.d
    public final Object d(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = ay4.b.c("lynx_storage").getString(r100, "");
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return null;
    L8:
        Intrinsics.checkNotNull(r101);
        Gson r102 = u56.b.f548842a;
        StorageValue r103 = (StorageValue) u56.b.a(r101, StorageValue.class);
        String r104 = r103.getValue();
        XReadableType r105 = XReadableType.valueOf(r103.getType());
        switch(a.f537427a[r105.ordinal()]) {
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
        return u56.b.a(r104, Map.class);
    L19:
        return u56.b.a(r104, List.class);
    L20:
        return r104;
    L21:
        return Double.valueOf(CastDoubleProtector.parseDouble(r104));
    L22:
        return Integer.valueOf(CastIntegerProtector.parseInt(r104));
    L17:
        return Boolean.valueOf(Boolean.parseBoolean(r104));
    }

    public final String h(Object r100) {
        new LinkedHashMap();
        if ((r100 instanceof Boolean) == false) goto L6;
        Gson r101 = u56.b.f548842a;
        return u56.b.b(new StorageValue("Boolean", String.valueOf(((Boolean) r100).booleanValue())));
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        Gson r102 = u56.b.f548842a;
        return u56.b.b(new StorageValue("Int", String.valueOf(((Number) r100).intValue())));
    L9:
        if ((r100 instanceof Double) == false) goto L12;
        Gson r103 = u56.b.f548842a;
        return u56.b.b(new StorageValue("Number", String.valueOf(((Number) r100).doubleValue())));
    L12:
        if ((r100 instanceof String) == false) goto L14;
        Gson r104 = u56.b.f548842a;
        return u56.b.b(new StorageValue("String", ((String) r100).toString()));
    L14:
        boolean r105 = r100 instanceof v;
        c r106 = f537426a;
        if (r105 == false) goto L18;
        return r106.h(((v) r100).toList());
    L18:
        if ((r100 instanceof XReadableMap) == false) goto L21;
        return r106.h(((XReadableMap) r100).toMap());
    L21:
        if ((r100 instanceof List) == false) goto L24;
        return u56.b.b(new StorageValue("Array", u56.b.b(r100)));
    L24:
        if ((r100 instanceof Map) == true) goto L35;
        return "";
    L35:
        return u56.b.b(new StorageValue("Map", u56.b.b(r100)));
    }

    @Override // p56.d
    public final boolean e(String r100, Object r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L8;
        c r102 = f537426a;
        ay4.b.c("lynx_storage").putString(r100, r102.h(r101));
        return true;
    L8:
        return false;
    L6:
        return false;
    }
}
