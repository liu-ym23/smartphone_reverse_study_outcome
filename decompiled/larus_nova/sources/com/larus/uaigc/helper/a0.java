package com.larus.uaigc.helper;

import com.larus.bmhome.resource.access.ResourceInputType;
import com.larus.bmhome.resource.access.ResourceMediaType;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a0 {
    public static final boolean b(com.larus.bmhome.resource.access.h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.larus.bmhome.resource.access.x r101 = com.larus.uaigc.service.f.f373957a;
        if (SetsKt.setOf(new com.larus.bmhome.resource.access.x[]{com.larus.uaigc.service.f.f373957a, com.larus.uaigc.service.f.f373958b, com.larus.uaigc.service.f.f373959c}).contains(r100.f313671a.f313762a) == true) goto L5;
        return false;
    L5:
        if (SetsKt.setOf(new ResourceMediaType[]{ResourceMediaType.IMAGE, ResourceMediaType.VIDEO}).contains(r100.f313671a.f313764c) == true) goto L7;
        return false;
    L7:
        if (SetsKt.setOf(new ResourceInputType[]{ResourceInputType.LOCAL_PATH, ResourceInputType.CONTENT_URI, ResourceInputType.TOS_KEY, ResourceInputType.REMOTE_URL}).contains(r100.f313673c.getType()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean a(com.larus.bmhome.resource.access.h0 r100, String r101, Function1<? super com.larus.bmhome.resource.access.v, Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "extKey");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (r102.invoke(r100.f313671a.f313765d.f313664k).booleanValue() == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100.b().get(r101), "true") == true) goto L8;
        return false;
    }
}
