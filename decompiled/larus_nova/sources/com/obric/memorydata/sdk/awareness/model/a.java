package com.obric.memorydata.sdk.awareness.model;

import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f397137a = null;

    static {
        f397137a = new Gson();
    }

    public static final LocationInfo.AoiInfo a(LocationInfo.AoiInfo r100) {
        String r101 = r100.a();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = r100.b();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        String r104 = r100.c();
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        Intrinsics.checkNotNullParameter(r101, "aoiId");
        Intrinsics.checkNotNullParameter(r103, "aoiName");
        Intrinsics.checkNotNullParameter(r102, "aoiType");
        return new LocationInfo.AoiInfo(r101, r103, r102);
    }
}
