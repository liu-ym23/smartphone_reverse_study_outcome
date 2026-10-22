package com.larksuite.component.card.utils;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.larksuite.framework.utils.DeviceUtils;

/* JADX INFO: loaded from: classes24.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283983a = 0;

    static {
    }

    public static boolean a(Context r100) {
        boolean r101 = true;
        if (r100 != null) goto L7;
        AppBrandLogger.w("KeyboardScreenUtil", new Object[]{"context can't be null"});
        return false;
    L7:
        if ((r100.getResources().getConfiguration().screenLayout & 15) < 3) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        r102 = DeviceUtils.isPad();
    L12:
        if (r102 == true) goto L29;
        boolean r103 = com.ss.android.lark.base.embedded.b.g();
        if (Settings.Global.getInt(r100.getContentResolver(), "device_posture", 0) != 3) goto L16;
        boolean r104 = true;
    L18:
        if (com.ss.android.lark.base.embedded.b.e() == true) goto L20;
    L23:
        if (r103 == false) goto L26;
        if (r104 == false) goto L26;
    L28:
        return r101;
    L26:
        r101 = false;
        goto L28
    L20:
        if (Settings.Global.getInt(r100.getContentResolver(), "oplus_system_device_state", 0) != 3) goto L22;
        r104 = true;
        goto L23
    L22:
        r104 = false;
        goto L23
    L16:
        r104 = false;
        goto L18
    L29:
        return r102;
    L9:
        r102 = false;
        goto L10
    }
}
