package gx7;

import com.ivy.ivykit.api.bridge.core.model.IvyReadableType;
import cx7.c;
import cx7.d;
import dx7.e;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f483122a = null;

        static {
            int[] r100 = new int[IvyReadableType.values().length];
            r100[IvyReadableType.Array.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[IvyReadableType.Map.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[IvyReadableType.String.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[IvyReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[IvyReadableType.Int.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[IvyReadableType.Boolean.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f483122a = r100;
        }
    }

    static {
    }

    public static JSONArray a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        JSONArray r101 = new JSONArray();
        Iterator<T> r102 = r100.toList().iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L22;
        r102.next();
        int r104 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        IvyReadableType r105 = r100.getType(r103);
        switch(a.f483122a[r105.ordinal()]) {
            case 1: goto L18;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L21;
        };
    L11:
        r101.put(r100.getBoolean(r103));
        goto L21
    L12:
        r101.put(r100.getInt(r103));
        goto L21
    L13:
        r101.put(r100.getDouble(r103));
        goto L21
    L14:
        r101.put(r100.getString(r103));
        goto L21
    L15:
        dx7.b r106 = r100.getMap(r103);
        if (r106 == null) goto L21;
        r101.put(b(r106));
        goto L21
    L18:
        e r107 = r100.getArray(r103);
        if (r107 == null) goto L21;
        r101.put(a(r107));
    L21:
        r103 = r104;
        goto L4
    L22:
        return r101;
    }

    public static JSONObject b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        JSONObject r101 = new JSONObject();
        dx7.d r102 = r100.keyIterator();
    L4:
        if (r102.a() == false) goto L18;
        String r103 = r102.b();
        IvyReadableType r104 = r100.getType(r103);
        switch(a.f483122a[r104.ordinal()]) {
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L4;
        };
    L8:
        r101.put(r103, r100.getBoolean(r103));
        goto L4
    L9:
        r101.put(r103, r100.getInt(r103));
        goto L4
    L10:
        r101.put(r103, r100.getDouble(r103));
        goto L4
    L11:
        r101.put(r103, r100.getString(r103));
        goto L4
    L12:
        dx7.b r105 = r100.getMap(r103);
        if (r105 == null) goto L4;
        r101.put(r103, b(r105));
        goto L4
    L15:
        e r106 = r100.getArray(r103);
        if (r106 == null) goto L4;
        r101.put(r103, a(r106));
        goto L4
    L18:
        return r101;
    }
}
