package com.bytedance.applet.jsb;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.api.l1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w0 extends bx7.c {
    public static final a b = null;

    public static final class a implements com.larus.platform.api.j0 {
        public a() {
        }
    }

    public static final class b {
    }

    public final String getName() {
        return "applet.startNavigation";
    }

    static {
        b = new a();
    }

    public w0() {
    }

    public static Pair f(String r11) {
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Pair r3 = null;
        if (r0 == false) goto L21;
        return null;
    L21:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        List r12 = StringsKt.split$default(StringsKt.trim(r11, new char[]{'[', ']'}), new char[]{','}, false, 0, 6, null);     // Catch: Throwable -> L18
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));     // Catch: Throwable -> L18
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L18
    L11:
        if (r13.hasNext() == false) goto L14;
        r2.add(Double.valueOf(CastDoubleProtector.parseDouble((String) r13.next())));     // Catch: Throwable -> L18
        goto L11
    L14:
        if (r2.size() <= 1) goto L16;
        r3 = TuplesKt.to(ListProtector.get(r2, 1), ListProtector.get(r2, 0));     // Catch: Throwable -> L18
    L16:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        return r3;
    L18:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L5:
        r0 = false;
        goto L6
    }

    public final void a(dx7.b r9, ux7.d.d r10, IvyBridgePlatformType r11) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "type");
        String r1 = r9.getString("fromName");
        Pair r2 = f(r9.getString("fromLngLat"));
        String r3 = r9.getString("toName");
        Pair r12 = f(r9.getString("toLngLat"));
        if (r12 != null) goto L5;
        r12 = TuplesKt.to(Double.valueOf(0.0d), Double.valueOf(0.0d));
    L5:
        Pair r4 = r12;
        int r6 = r9.getInt("policy");
        String r13 = r9.getString("method");
        String r14 = "walking";
        if (Intrinsics.areEqual(r13, "walking") == true) goto L10;
        r14 = "riding";
        if (Intrinsics.areEqual(r13, "riding") == true) goto L10;
        String r5 = "driving";
    L12:
        l1 r0 = com.larus.platform.service.b.a();
        if (r0 == null) goto L16;
        r0.d(r1, r2, r3, r4, r5, r6, b);
        return;
    L16:
        return;
    L10:
        r5 = r14;
        goto L12
    }
}
