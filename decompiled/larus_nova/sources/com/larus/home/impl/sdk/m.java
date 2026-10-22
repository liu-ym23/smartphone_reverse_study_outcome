package com.larus.home.impl.sdk;

import com.larus.commercecredit.api.ICommerceCreditService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements com.larus.platform.api.w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f346200a = null;

    static {
        f346200a = new m();
    }

    public m() {
    }

    @Override // com.larus.platform.api.w1
    public final void b() {
        Intrinsics.checkNotNullParameter("ZLink_Initialized", "scene");
        ICommerceCreditService.f325667a.getClass();
        ICommerceCreditService r100 = ICommerceCreditService.a.a();
        if (r100 == null) goto L6;
        r100.e("ZLink_Initialized");
        return;
    }

    @Override // com.larus.platform.api.w1
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter("ZlinkSdkManager_dealWithClipboard", "scene");
        ICommerceCreditService.f325667a.getClass();
        ICommerceCreditService r101 = ICommerceCreditService.a.a();
        if (r101 == null) goto L6;
        r101.f(r100, "ZlinkSdkManager_dealWithClipboard");
        return;
    }
}
