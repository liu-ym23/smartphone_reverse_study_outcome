package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import com.bytedance.ee.bear.contract.NetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final NetService a;
    public final String b;
    public final String c;
    public final String d;
    public final com.bytedance.ee.bear.drive.report.a e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.importfile.im.data.a$a, reason: collision with other inner class name */
    public static final class C0128a {
    }

    static {
    }

    public a(NetService r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r5, "fileId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = o75.b.a().Tb();
    }
}
