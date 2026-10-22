package m4;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f511824a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            r100[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f511824a = r100;
        }
    }

    public static final JsonArray a(ReadableArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JsonArray r101 = new JsonArray();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L19;
        ReadableType r104 = r100.getType(r103);
        if (r104 != null) goto L7;
        int r105 = -1;
    L8:
        switch(r105) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L18;
        };
    L10:
        r101.add(a(r100.getArray(r103)));
        goto L18
    L11:
        r101.add(b(r100.getMap(r103)));
        goto L18
    L12:
        r101.add(r100.getString(r103));
        goto L18
    L13:
        r101.add(Double.valueOf(r100.getDouble(r103)));
        goto L18
    L14:
        r101.add(Long.valueOf(r100.getLong(r103)));
        goto L18
    L15:
        r101.add(Integer.valueOf(r100.getInt(r103)));
        goto L18
    L16:
        r101.add(Boolean.valueOf(r100.getBoolean(r103)));
        goto L18
    L17:
        r101.add(JsonNull.INSTANCE);
    L18:
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = a.f511824a[r104.ordinal()];
        goto L8
    L19:
        return r101;
    }

    public static final JsonObject b(final ReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final JsonObject r101 = new JsonObject();
        Function1 r102 = new e(r100, r101);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "block");
        ReadableMapKeySetIterator r103 = r100.keySetIterator();
    L4:
        if (r103.hasNextKey() == false) goto L14;
        String r104 = r103.nextKey();
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L4;
        r102.invoke(r104);
        goto L4
    L8:
        if (StringsKt.isBlank(r104) == true) goto L11;
        r105 = false;
        goto L12
    L14:
        return r101;
    }
}
