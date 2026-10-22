package com.bytedance.applet.debug.view;

import android.app.Activity;
import android.content.Context;
import com.bytedance.applet.debug.AppletDebugManager;
import com.larus.common.apphost.AppHost;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v {
    public static Context a;
    public static x b;
    public static final AtomicBoolean c = null;

    static {
        c = new AtomicBoolean(false);
    }

    public static void b(boolean r1) {
        if (c.get() == false) goto L8;
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 == null) goto L9;
        a(r1, r0);
        return;
    L9:
        return;
    }

    public static void a(boolean r1, final Activity r2) {
        if (AppletDebugManager.a == false) goto L6;
        if (r1 == false) goto L6;
        final boolean r3 = true;
    L7:
        if (r2 == null) goto L10;
        r2.runOnUiThread(new r(r3, r2));
        return;
    L10:
        return;
    L6:
        r3 = false;
        goto L7
    }
}
