package com.bytedance.salamander.anniex;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d {
    public static final f8<Integer, Integer, Integer> a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "version");
        ArrayList<String> r100 = com.bytedance.rts.foundation.r.f(r110, ".", -1);
        if (com.bytedance.rts.foundation.j.d(r100) == 3) goto L28;
        return new f8(-1, -1, -1);
    L28:
        IntCompanionObject r101 = IntCompanionObject.INSTANCE;     // Catch: Throwable -> L21
        Integer r102 = com.bytedance.rts.foundation.k.a(r101, (String) ListProtector.get(r100, 0), null);     // Catch: Throwable -> L21
        if (r102 == null) goto L10;
        int r103 = r102.intValue();     // Catch: Throwable -> L21
    L11:
        Integer r104 = Integer.valueOf(r103);     // Catch: Throwable -> L21
        Integer r105 = com.bytedance.rts.foundation.k.a(r101, (String) ListProtector.get(r100, 1), null);     // Catch: Throwable -> L21
        if (r105 == null) goto L14;
        int r106 = r105.intValue();     // Catch: Throwable -> L21
    L15:
        Integer r107 = Integer.valueOf(r106);     // Catch: Throwable -> L21
        Integer r108 = com.bytedance.rts.foundation.k.a(r101, (String) ListProtector.get(r100, 2), null);     // Catch: Throwable -> L21
        if (r108 == null) goto L18;
        int r109 = r108.intValue();     // Catch: Throwable -> L21
    L19:
        return new f8(r104, r107, Integer.valueOf(r109));
    L18:
        r109 = 0;
        goto L19
    L14:
        r106 = 0;
        goto L15
    L10:
        r103 = 0;
    L21:
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.b("RTS: parse version failed", r110);
        return new f8(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r100, 0))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r100, 1))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r100, 2))));
    L24:
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.b("RTS: parse version failed in android", r110);
        return new f8(-1, -1, -1);
    }
}
