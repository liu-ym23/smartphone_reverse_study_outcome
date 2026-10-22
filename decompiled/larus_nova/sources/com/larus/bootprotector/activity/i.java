package com.larus.bootprotector.activity;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i implements v48.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BootProtectorLandingActivity f317627a;

    public i(BootProtectorLandingActivity r100) {
        this.f317627a = r100;
    }

    @Override // v48.e
    public final void onGetId(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
        Intrinsics.checkNotNullParameter(r102, "ssid");
        BootProtectorLandingActivity r103 = this.f317627a;
        int r104 = BootProtectorLandingActivity.f317605b;
        r103.D1();
    }
}
