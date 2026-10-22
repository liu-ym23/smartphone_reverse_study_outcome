package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import com.bytedance.ee.bear.contract.NetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f223042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f223043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f223044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f223045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.report.a f223046e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.importfile.im.data.a$a, reason: collision with other inner class name */
    public static final class C3184a {
    }

    static {
    }

    public a(NetService r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r103, "fileId");
        this.f223042a = r100;
        this.f223043b = r101;
        this.f223044c = r102;
        this.f223045d = r103;
        this.f223046e = o75.b.a().Tb();
    }
}
