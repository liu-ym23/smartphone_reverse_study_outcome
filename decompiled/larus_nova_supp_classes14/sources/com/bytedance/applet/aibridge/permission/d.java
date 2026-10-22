package com.bytedance.applet.aibridge.permission;

import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements g1.c {
    public final /* synthetic */ AbsRequestPermissionMethodIDL.b a;
    public final /* synthetic */ RequestPermissionMethod b;
    public final /* synthetic */ boolean c;

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
        if (this.c == false) goto L5;
        int r0 = uv3.c.a;
        boolean r1 = uv3.c.a(AppHost.a.getApplication());
    L6:
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + this.a.getPermission() + " return from setting page, result: " + r1);
        RequestPermissionMethod r2 = this.b;
        AbsRequestPermissionMethodIDL.b r3 = this.a;
        int r4 = RequestPermissionMethod.b;
        r2.getClass();
        RequestPermissionMethod.c(r3, r1);
        return;
    L5:
        int r5 = uv3.c.a;
        r1 = uv3.c.b(AppHost.a.getApplication());
        goto L6
    }

    public final void onGoSettingsDialogDismiss(boolean r3) {
        if (r3 == true) goto L5;
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + this.a.getPermission() + " onGoSettingsDialogRefused");
        RequestPermissionMethod r4 = this.b;
        AbsRequestPermissionMethodIDL.b r0 = this.a;
        int r1 = RequestPermissionMethod.b;
        r4.getClass();
        RequestPermissionMethod.c(r0, false);
        return;
    }

    public d(AbsRequestPermissionMethodIDL.b r1, RequestPermissionMethod r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "grantedList");
        Intrinsics.checkNotNullParameter(r4, "deniedList");
        if (r5 == false) goto L5;
        return;
    L5:
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + this.a.getPermission() + " onResult: " + r2);
        RequestPermissionMethod r6 = this.b;
        AbsRequestPermissionMethodIDL.b r7 = this.a;
        int r8 = RequestPermissionMethod.b;
        r6.getClass();
        RequestPermissionMethod.c(r7, r2);
    }
}
