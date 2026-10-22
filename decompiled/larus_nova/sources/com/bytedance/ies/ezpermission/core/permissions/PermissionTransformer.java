package com.bytedance.ies.ezpermission.core.permissions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l46.b;
import m46.c;
import m46.d;
import m46.e;

/* JADX INFO: loaded from: classes19.dex */
public final class PermissionTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<c> f248580a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b> f248581b = null;

    static {
        ArrayList r100 = new ArrayList();
        r100.add(new m46.b());
        r100.add(new d());
        r100.add(new e());
        r100.add(new m46.a());
        CollectionsKt.removeAll(r100, PermissionTransformer$specialPermissions$1$1.INSTANCE);
        f248580a = r100;
        ArrayList r101 = new ArrayList();
        r101.add(new l46.a());
        f248581b = r101;
    }

    public static b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        Iterator r101 = ((ArrayList) f248580a).iterator();
    L3:
        Object r102 = null;
        if (r101.hasNext() == false) goto L8;
        Object r103 = r101.next();
        if (Intrinsics.areEqual(((c) r103).f507349a, r100) == false) goto L3;
    L9:
        b r104 = (c) r103;
        if (r104 != null) goto L19;
        Iterator r105 = ((ArrayList) f248581b).iterator();
    L14:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((b) r106).f507349a, r100) == false) goto L14;
        r102 = r106;
    L18:
        r104 = (b) r102;
    L19:
        if (r104 == null) goto L22;
        return r104;
    L22:
        return new b(r100);
    L8:
        r103 = null;
        goto L9
    }
}
