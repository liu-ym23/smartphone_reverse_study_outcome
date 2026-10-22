package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b0 implements com.bytedance.ee.bear.more.protocol3.panel.x {
    public final DrivePluginHost a;
    public final com.bytedance.ee.bear.more.protocol3.h b;
    public final com.bytedance.ee.bear.more.protocol3.panel.t c;
    public final Map<String, com.bytedance.ee.bear.more.protocol3.panel.q> d;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.ee.bear.more.protocol3.panel.z f6() {
        return null;
    }

    public final void a() {
        tt5.a.h("DriveMorePanelContext", "closePanel");
        this.b.c();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("DriveMorePanelContext", "closePanel failed", th, false);
        throw th;
    }

    public final void d6() {
        tt5.a.h("DriveMorePanelContext", "refreshPanel");
        this.b.g();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("DriveMorePanelContext", "refreshPanel failed", th, false);
        throw th;
    }

    public final Fragment getHostFragment() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(this.b.f().getHostFragment());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        Fragment r2 = (Fragment) r1;
        if (r2 != null) goto L16;
        r2 = this.a.getHostFragment();
        if (r2 != null) goto L16;
        throw new IllegalStateException("DriveMorePanelContext.hostFragment is null".toString());
    L16:
        return r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public Activity getActivity() {
        return com.bytedance.ee.bear.more.protocol3.panel.x.a.getActivity(this);
    }

    public final com.bytedance.ee.bear.more.protocol3.panel.q e6(String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        String r5 = com.bytedance.ee.bear.more.protocol3.panel.s.a(r4);
        com.bytedance.ee.bear.more.protocol3.panel.q r0 = this.c.a(r5);
        StringBuilder r1 = new StringBuilder("getDelegate, itemId=");
        r1.append(r5);
        r1.append(", isDefault=true, hit=");
        if (r0 == null) goto L5;
        boolean r6 = true;
    L6:
        r1.append(r6);
        tt5.a.h("DriveMorePanelContext", r1.toString());
        return r0;
    L5:
        r6 = false;
        goto L6
    }

    public b0(DrivePluginHost r2, com.bytedance.ee.bear.more.protocol3.h r3, com.bytedance.ee.bear.more.protocol3.panel.e r4, Map r5) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "providerHost");
        Intrinsics.checkNotNullParameter(r4, "registry");
        Intrinsics.checkNotNullParameter(r5, "hostDelegates");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
