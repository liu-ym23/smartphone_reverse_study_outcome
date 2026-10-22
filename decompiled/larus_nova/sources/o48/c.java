package o48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {
    public static final u64.b a(n38.e r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.f516997a;
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r100.f516998b;
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        String r105 = r102;
        String r106 = r104;
        return new u64.b(r105, r106, "", "", r100.f517000d);
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }
}
