package com.larus.apm.impl;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.jvm.internal.Intrinsics;
import q48.r;
import v48.e;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NpthImpl f286978a;

    public a(NpthImpl r100) {
        this.f286978a = r100;
    }

    @Override // v48.e
    public final void onGetId(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
        Intrinsics.checkNotNullParameter(r102, "ssid");
        FLogger r103 = FLogger.f375446a;
        int r104 = NpthImpl.f286962c;
        r103.i("NpthImpl", "addGetAppLogIdListener onGetId");
        NpthImpl r105 = this.f286978a;
        r105.getClass();
        r103.i("NpthImpl", "trySaveDeviceIdToKeva start delay 2s");
        t0.b(new r(r105), 2000);
    }
}
