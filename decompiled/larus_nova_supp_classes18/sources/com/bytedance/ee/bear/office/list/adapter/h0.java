package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Document r1) {
        Intrinsics.checkNotNullParameter(r1, "document");
        if (r1.M1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean b(Document r2) {
        Intrinsics.checkNotNullParameter(r2, "document");
        if (r2.getType() == sbb.e.f.b) goto L5;
    L9:
        return false;
    L5:
        if (a(r2) == true) goto L8;
        FolderVersion.a r0 = FolderVersion.Companion;
        int r1 = r2.L1;
        boolean r3 = r2.P1;
        r0.getClass();
        if (FolderVersion.a.b(r1, r3) == false) goto L9;
    L8:
        return true;
    }
}
