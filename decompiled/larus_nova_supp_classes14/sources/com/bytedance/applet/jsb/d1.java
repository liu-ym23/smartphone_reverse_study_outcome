package com.bytedance.applet.jsb;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.ivy.ivykit.api.bridge.core.model.IvyReadableType;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d1 {
    public static final Lazy<d1> a = null;
    public static final Gson b = null;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IvyReadableType.values().length];
            r0[IvyReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[IvyReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[IvyReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[IvyReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[IvyReadableType.Array.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[IvyReadableType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public d1() {
    }

    static {
        a = LazyKt.lazy(new c1());
        b = new Gson();
    }

    public static Keva a(String r2) {
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return Keva.getRepo(r2.concat("-xbridge-storage"), 0);
    L10:
        return Keva.getRepo("xbridge-storage", 0);
    L5:
        r0 = false;
        goto L6
    }

    public static Object b(String r3) {
        Gson r0 = b;
        f1 r4 = (f1) GsonProtectorUtils.fromJson(r0, r3, f1.class);
        String r1 = r4.getType();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r5 = r4.a();
        if (r5 == null) goto L9;
        r2 = r5;
    L9:
        IvyReadableType r6 = IvyReadableType.valueOf(r1);
        switch(b.a[r6.ordinal()]) {
            case 1: goto L17;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L18;
            case 5: goto L21;
            case 6: goto L20;
            default: goto L11;
        };
    L11:
        return null;
    L18:
        return r2;
    L20:
        return GsonProtectorUtils.fromJson(r0, r2, Map.class);
    L21:
        return GsonProtectorUtils.fromJson(r0, r2, List.class);
    L22:
        return Double.valueOf(CastDoubleProtector.parseDouble(r2));
    L23:
        return Integer.valueOf(CastIntegerProtector.parseInt(r2));
    L17:
        return Boolean.valueOf(Boolean.parseBoolean(r2));
    }
}
