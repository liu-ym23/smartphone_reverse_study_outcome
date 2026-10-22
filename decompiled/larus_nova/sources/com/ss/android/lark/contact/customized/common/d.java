package com.ss.android.lark.contact.customized.common;

import java.util.Comparator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f418967a = null;

    static {
        f418967a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        mtb.d r102 = (mtb.d) r100;
        mtb.d r103 = (mtb.d) r101;
        Lazy r104 = OfficeContactUtils.f418960a;
        String r105 = OfficeContactUtils.c(r102.f515667f);
        String r106 = OfficeContactUtils.c(r103.f515667f);
        boolean r107 = Intrinsics.areEqual(r105, "#");
        if ((Intrinsics.areEqual(r106, "#") ^ r107) == false) goto L8;
        if (r107 == false) goto L6;
        return 1;
    L6:
        return -1;
    L8:
        if (Intrinsics.areEqual(r105, r106) == false) goto L29;
        String r108 = r102.f515667f;
        String r109 = r103.f515667f;
        int r110 = r108.length();
        int r111 = r109.length();
        int r112 = Math.min(r110, r111);
        int r113 = 0;
    L11:
        if (r113 >= r112) goto L19;
        char r114 = Character.toLowerCase(r108.charAt(r113));
        char r115 = Character.toLowerCase(r109.charAt(r113));
        if (r114 == r115) goto L17;
        int r116 = OfficeContactUtils.b(r114);
        int r117 = OfficeContactUtils.b(r115);
        if (r116 == r117) goto L17;
        return -(r116 - r117);
    L17:
        r113 = r113 + 1;
        goto L11
    L19:
        if (r110 != r111) goto L22;
        return 0;
    L22:
        return r110 - r111;
    L29:
        return r105.charAt(0) - r106.charAt(0);
    }
}
