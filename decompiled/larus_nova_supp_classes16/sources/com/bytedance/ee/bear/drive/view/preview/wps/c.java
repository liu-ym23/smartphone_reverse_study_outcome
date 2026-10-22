package com.bytedance.ee.bear.drive.view.preview.wps;

import com.bytedance.ee.bear.rn.RnPushProtocol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final String a;
    public final WpsViewModel b;
    public RnPushProtocol c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        final String r0 = this.a;
        RnPushProtocol r1 = (RnPushProtocol) org.koin.java.a.b(RnPushProtocol.class, RnPushProtocol.VersionQualifier.Default, new DriveWpsMemoryOverPush$initReliableMemoryOver$1(r0));
        this.c = r1;
        if (r1 == null) goto L6;
        r1.b(new d(this));
        return;
    }

    public c(String r2, WpsViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fileId");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }
}
