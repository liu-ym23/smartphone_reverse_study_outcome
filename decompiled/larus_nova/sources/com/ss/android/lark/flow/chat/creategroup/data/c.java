package com.ss.android.lark.flow.chat.creategroup.data;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f422057a = null;

    static {
        f422057a = new c();
    }

    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r110) {
        a r101 = (a) r100;
        a r111 = (a) r110;
        int r102 = d.f422058a;
        String r103 = d.c(r101.f422046e);
        String r104 = d.c(r111.f422046e);
        boolean r105 = Intrinsics.areEqual(r103, "#");
        if ((Intrinsics.areEqual(r104, "#") ^ r105) == false) goto L8;
        if (r105 == false) goto L6;
        return 1;
    L6:
        return -1;
    L8:
        if (Intrinsics.areEqual(r103, r104) == false) goto L29;
        String r106 = r101.f422046e;
        String r112 = r111.f422046e;
        int r107 = r106.length();
        int r108 = r112.length();
        int r109 = Math.min(r107, r108);
        int r113 = 0;
    L11:
        if (r113 >= r109) goto L19;
        char r114 = Character.toLowerCase(r106.charAt(r113));
        char r115 = Character.toLowerCase(r112.charAt(r113));
        if (r114 == r115) goto L17;
        int r116 = d.f422058a;
        int r117 = d.b(r114);
        int r118 = d.b(r115);
        if (r117 == r118) goto L17;
        return -(r117 - r118);
    L17:
        r113 = r113 + 1;
        goto L11
    L19:
        if (r107 != r108) goto L22;
        return 0;
    L22:
        return r107 - r108;
    L29:
        return r103.charAt(0) - r104.charAt(0);
    }
}
