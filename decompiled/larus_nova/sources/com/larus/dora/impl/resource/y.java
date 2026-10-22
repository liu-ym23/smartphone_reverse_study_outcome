package com.larus.dora.impl.resource;

import com.bytedance.keva.Keva;
import com.dtf.face.config.IConstValues;
import com.larus.dora.api.DoraServerDeviceType;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f337927a = 0;

    static {
    }

    public static boolean a(DoraServerDeviceType r100) {
        Intrinsics.checkNotNullParameter(r100, IConstValues.DEVICE_TYPE);
        AccountService r101 = AccountService.f365697a;
        String r102 = r101.getUserId();
        if (r101.isLogin().booleanValue() == false) goto L7;
        boolean r103 = true;
        if ((!StringsKt.isBlank(r102)) == false) goto L7;
    L8:
        if (r103 == true) goto L11;
        r102 = null;
    L11:
        if (r102 != null) goto L14;
        return false;
    L14:
        return Keva.getRepo("dora_resource_mocks_".concat(r102), 0).getBoolean("mock_" + r100.name(), false);
    L7:
        r103 = false;
        goto L8
    }
}
