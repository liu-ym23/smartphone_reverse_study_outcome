package com.bytedance.applet.aibridge.permission;

import com.bytedance.applet.utils.t;
import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements g1.c {
    public final /* synthetic */ AbsRequestPermissionMethodIDL.b a;
    public final /* synthetic */ RequestPermissionMethod b;

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
        boolean r0 = t.a();
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + this.a.getPermission() + " return from setting page, result: " + r0);
        RequestPermissionMethod r1 = this.b;
        String r2 = this.a.getRequestId();
        String r3 = this.a.getPermission();
        int r4 = RequestPermissionMethod.b;
        r1.getClass();
        RequestPermissionMethod.e(r2, r3, r0);
    }

    public final void onGoSettingsDialogDismiss(boolean r4) {
        if (r4 == true) goto L5;
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + this.a.getPermission() + " onGoSettingsDialogRefused");
        RequestPermissionMethod r5 = this.b;
        String r0 = this.a.getRequestId();
        String r1 = this.a.getPermission();
        int r2 = RequestPermissionMethod.b;
        r5.getClass();
        RequestPermissionMethod.e(r0, r1, false);
        return;
    }

    public e(AbsRequestPermissionMethodIDL.b r1, RequestPermissionMethod r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "grantedList");
        Intrinsics.checkNotNullParameter(r4, "deniedList");
        if (r5 == false) goto L5;
        return;
    L5:
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + this.a.getPermission() + " onResult: " + r2);
        RequestPermissionMethod r6 = this.b;
        String r7 = this.a.getRequestId();
        String r8 = this.a.getPermission();
        int r0 = RequestPermissionMethod.b;
        r6.getClass();
        RequestPermissionMethod.e(r7, r8, r2);
    }
}
