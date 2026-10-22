package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235774a = 0;

    static {
    }

    public static boolean a(Document r100) {
        Intrinsics.checkNotNullParameter(r100, "document");
        if (r100.M1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean b(Document r100) {
        Intrinsics.checkNotNullParameter(r100, "document");
        if (r100.getType() == sbb.e.f541295f.f541317b) goto L5;
    L9:
        return false;
    L5:
        if (a(r100) == true) goto L8;
        FolderVersion.a r101 = FolderVersion.Companion;
        int r102 = r100.L1;
        boolean r103 = r100.P1;
        r101.getClass();
        if (FolderVersion.a.b(r102, r103) == false) goto L9;
    L8:
        return true;
    }
}
