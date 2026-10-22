package com.bytedance.applet.task;

import android.os.Bundle;
import com.bytedance.ai.view.popup.AppletPopup;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements com.bytedance.ai.view.popup.m {
    public m() {
    }

    public final void a(AppletPopup r4) {
        Intrinsics.checkNotNullParameter(r4, "popup");
        BaseMediaControlTask r0 = b.b;
        if (r0 == null) goto L12;
        String r1 = r0.a;
        Bundle r5 = r4.getArguments();
        if (r5 == null) goto L7;
        String r6 = r5.getString("appId");
    L9:
        if (Intrinsics.areEqual(r1, r6) == false) goto L13;
        FLogger.a.i("MediaControlTaskManager", "onPopupStopped: appId = " + r0.a);
        r0.g(true);
        return;
    L13:
        return;
    L7:
        r6 = null;
        goto L9
    }

    public final void b(AppletPopup r2) {
        Intrinsics.checkNotNullParameter(r2, "popup");
    }

    public final void c(AppletPopup r2) {
        Intrinsics.checkNotNullParameter(r2, "popup");
    }

    public final void d(AppletPopup r2) {
        Intrinsics.checkNotNullParameter(r2, "popup");
    }

    public final void e(AppletPopup r2) {
        Intrinsics.checkNotNullParameter(r2, "popup");
    }

    public final void f(AppletPopup r4) {
        Intrinsics.checkNotNullParameter(r4, "popup");
        BaseMediaControlTask r0 = b.b;
        if (r0 == null) goto L12;
        String r1 = r0.a;
        Bundle r5 = r4.getArguments();
        if (r5 == null) goto L7;
        String r6 = r5.getString("appId");
    L9:
        if (Intrinsics.areEqual(r1, r6) == false) goto L13;
        FLogger.a.i("MediaControlTaskManager", "onPopupCreated: appId = " + r0.a);
        r0.g(false);
        return;
    L13:
        return;
    L7:
        r6 = null;
        goto L9
    }
}
