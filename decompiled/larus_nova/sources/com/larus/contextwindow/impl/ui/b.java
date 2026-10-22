package com.larus.contextwindow.impl.ui;

import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaRowKind;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaSummaryDto;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f330471a = 0;

    static {
    }

    public static a a(ContextWindowSnapshot r100, com.larus.contextwindow.impl.membership.h r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "contextSnapshot");
        Intrinsics.checkNotNullParameter(r110, "repositoryState");
        MembershipQuotaSummaryDto r101 = r110.f330385a;
        Long r102 = null;
        if (r101 == null) goto L22;
        z29.c r103 = com.larus.contextwindow.impl.membership.c.a(r101);
        if ((!r103.f569815a.isEmpty()) == false) goto L22;
        List<z29.b> r104 = r103.f569815a;
        boolean r112 = r110.f330386b;
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        Iterator<T> r105 = r103.f569815a.iterator();
    L8:
        if (r105.hasNext() == false) goto L15;
        Object r106 = r105.next();
        if (((z29.b) r106).f569803a != MembershipQuotaRowKind.H5) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L8;
    L16:
        z29.b r108 = (z29.b) r106;
        if (r108 == null) goto L20;
        r102 = r108.f569814l;
    L20:
        return new a(r100, r111, new j(r104, r112, r102));
    L12:
        r107 = false;
        goto L13
    L15:
        r106 = null;
    L22:
        return new a(r100, r111, null);
    }
}
