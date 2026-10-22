package com.ss.android.lark.chat.cot.detail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f414993a = 0;

    static {
    }

    public static List a(List r100, j r110) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r110, "expandStore");
        List r101 = r100;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L16;
        if (((k) r102.next()).f414983b != CotDetailBlockType.GROUP) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L9;
        boolean r104 = false;
    L17:
        if (r104 == false) goto L19;
        return r100;
    L19:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r101.iterator();
    L21:
        if (r106.hasNext() == false) goto L47;
        k r107 = (k) r106.next();
        u r108 = r107.c();
        s r109 = null;
        if (r108 == null) goto L25;
        String r111 = r108.f415010c;
    L26:
        CotDetailBlockType r112 = r107.f414983b;
        CotDetailBlockType r113 = CotDetailBlockType.GROUP;
        if (r112 != r113) goto L41;
        boolean r114 = r110.b(r107.f414982a);
        b r115 = r107.f414988g;
        if ((r115 instanceof s) == false) goto L31;
        s r116 = (s) r115;
    L33:
        if (r107.f414983b != r113) goto L35;
        boolean r117 = true;
    L36:
        if (r117 == false) goto L38;
        r109 = r116;
    L38:
        if (r109 != null) goto L40;
        r109 = new s(0, 3);
    L40:
        r107 = k.a(r107, new s(r109.f415004a, r114));
    L45:
        if (r107 == null) goto L21;
        r105.add(r107);
        goto L21
    L35:
        r117 = false;
        goto L36
    L31:
        r116 = null;
        goto L33
    L41:
        if (r111 == null) goto L45;
        if (r110.b(r111) == true) goto L45;
        r107 = null;
        goto L45
    L25:
        r111 = null;
        goto L26
    L47:
        return r105;
    L13:
        r103 = false;
    L16:
        r104 = true;
        goto L17
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }
}
