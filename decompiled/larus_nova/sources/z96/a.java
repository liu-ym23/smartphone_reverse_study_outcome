package z96;

import androidx.collection.SieveCacheKt;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: z96.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C8432a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f571018a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            r100[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f571018a = r100;
        }
    }

    public a() {
    }

    public static Object a(JsonReader r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "reader");
        JsonToken r101 = r100.peek();
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        switch(r102) {
            case 1: goto L27;
            case 2: goto L22;
            case 3: goto L37;
            case 4: goto L11;
            case 5: goto L36;
            case 6: goto L9;
            default: goto L39;
        };
    L9:
        r100.nextNull();
        return null;
    L11:
        String r103 = r100.nextString();
        if (StringsKt.contains$default(r103, ".", false, 2, null) == false) goto L20;
        if (StringsKt.endsWith$default(r103, ".0", false, 2, null) == false) goto L18;
        return b(r103);
    L18:
        return Double.valueOf(CastDoubleProtector.parseDouble(r103));
    L20:
        return b(r103);
    L22:
        LinkedTreeMap r104 = new LinkedTreeMap();
        r100.beginObject();
    L24:
        if (r100.hasNext() == false) goto L26;
        r104.put(r100.nextName(), a(r100));
        goto L24
    L26:
        r100.endObject();
        return r104;
    L27:
        ArrayList r105 = new ArrayList();
        r100.beginArray();
    L29:
        if (r100.hasNext() == false) goto L31;
        r105.add(a(r100));
        goto L29
    L31:
        r100.endArray();
        return r105;
    L39:
        return null;
    L36:
        return Boolean.valueOf(r100.nextBoolean());
    L37:
        return r100.nextString();
    L5:
        r102 = C8432a.f571018a[r101.ordinal()];
        goto L7
    }

    public static Object b(String r100) {
        Long r101 = StringsKt.toLongOrNull(r100);
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L7:
        if (r102 > SieveCacheKt.NodeLinkMask) goto L13;
        if (r102 < SieveCacheKt.NodeMetaAndPreviousMask) goto L13;
        return Integer.valueOf((int) r102);
    L13:
        return Long.valueOf(r102);
    L5:
        r102 = (long) CastDoubleProtector.parseDouble(r100);
        goto L7
    }
}
