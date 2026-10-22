package com.larus.home.impl.sdk;

import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class n implements com.larus.platform.api.x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f346203a = null;

    static {
        f346203a = new n();
    }

    public n() {
    }

    @Override // com.larus.platform.api.x1
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter("ZlinkSdkManager_dealWithClipboard", "scene");
        FLogger.f375446a.i("CommerceMembershipServiceImpl-Obj", "goToMembershipPageFromZlink text: " + r100 + ", scene: ZlinkSdkManager_dealWithClipboard");
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r101 = ICommerceMembershipService.a.a();
        if (r101 == null) goto L6;
        r101.f(r100, "ZlinkSdkManager_dealWithClipboard");
        return;
    }
}
