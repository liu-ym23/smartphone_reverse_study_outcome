package ie5;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {

    /* JADX INFO: renamed from: ie5.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0246a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[XReadableType.values().length];
            r0[XReadableType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[XReadableType.Number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[XReadableType.Boolean.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[XReadableType.Int.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[XReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[XReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static final ArrayList<Serializable> a(v r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList<Serializable> r0 = new ArrayList();
        int r1 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L18;
        XReadableType r3 = r5.getType(r2);
        switch(C0246a.a[r3.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L10;
            case 6: goto L7;
            default: goto L17;
        };
    L7:
        v r4 = r5.getArray(r2);
        if (r4 == null) goto L17;
        r0.add(a(r4));
        goto L17
    L10:
        XReadableMap r6 = r5.getMap(r2);
        if (r6 == null) goto L17;
        r0.add(b(r6));
        goto L17
    L13:
        r0.add(Integer.valueOf(r5.getInt(r2)));
        goto L17
    L14:
        r0.add(Boolean.valueOf(r5.getBoolean(r2)));
        goto L17
    L15:
        r0.add(Double.valueOf(r5.getDouble(r2)));
        goto L17
    L16:
        r0.add(r5.getString(r2));
    L17:
        r2 = r2 + 1;
        goto L3
    L18:
        return r0;
    }

    public static final HashMap<String, Serializable> b(XReadableMap r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        LinkedHashMap r0 = new LinkedHashMap();
        u r1 = r5.keyIterator();
    L4:
        if (r1.hasNextKey() == false) goto L18;
        String r2 = r1.nextKey();
        XReadableType r3 = r5.getType(r2);
        switch(C0246a.a[r3.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L11;
            case 6: goto L8;
            default: goto L4;
        };
    L8:
        v r4 = r5.getArray(r2);
        if (r4 == null) goto L4;
        r0.put(r2, a(r4));
        goto L4
    L11:
        XReadableMap r6 = r5.getMap(r2);
        if (r6 == null) goto L4;
        r0.put(r2, b(r6));
        goto L4
    L14:
        r0.put(r2, Integer.valueOf(r5.getInt(r2)));
        goto L4
    L15:
        r0.put(r2, Boolean.valueOf(r5.getBoolean(r2)));
        goto L4
    L16:
        r0.put(r2, Double.valueOf(r5.getDouble(r2)));
        goto L4
    L17:
        r0.put(r2, r5.getString(r2));
        goto L4
    L18:
        return r0;
    }
}
