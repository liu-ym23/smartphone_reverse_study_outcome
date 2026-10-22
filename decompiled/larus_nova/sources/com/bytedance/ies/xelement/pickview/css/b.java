package com.bytedance.ies.xelement.pickview.css;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f250308a = 0;

    static {
    }

    public static void a(List r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Intrinsics.checkNotNullParameter(r101, LynxResourceModule.FONT_TYPE);
        String r102 = b(r100, "height");
        if (r102 == null) goto L5;
        r101.a(r102);
    L5:
        String r103 = b(r100, "foreground");
        if (r103 == null) goto L9;
        r101.b(r103);
        return;
    }

    public static String b(List r100, String r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((Pair) r103).getFirst(), r101) == false) goto L4;
    L9:
        Pair r104 = (Pair) r103;
        if (r104 != null) goto L12;
        return null;
    L12:
        return (String) r104.getSecond();
    L8:
        r103 = null;
        goto L9
    }
}
