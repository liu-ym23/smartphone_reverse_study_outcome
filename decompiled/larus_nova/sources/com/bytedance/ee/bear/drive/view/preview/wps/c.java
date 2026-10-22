package com.bytedance.ee.bear.drive.view.preview.wps;

import com.bytedance.ee.bear.rn.RnPushProtocol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f225671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WpsViewModel f225672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RnPushProtocol f225673c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        final String r100 = this.f225671a;
        RnPushProtocol r101 = (RnPushProtocol) org.koin.java.a.b(RnPushProtocol.class, RnPushProtocol.VersionQualifier.Default, new DriveWpsMemoryOverPush$initReliableMemoryOver$1(r100));
        this.f225673c = r101;
        if (r101 == null) goto L6;
        r101.b(new d(this));
        return;
    }

    public c(String r100, WpsViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "fileId");
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        this.f225671a = r100;
        this.f225672b = r101;
    }
}
