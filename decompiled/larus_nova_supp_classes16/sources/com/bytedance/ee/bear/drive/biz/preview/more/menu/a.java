package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final DrivePluginHost a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.menu.a$a, reason: collision with other inner class name */
    public static final class C0147a {
    }

    static {
    }

    private final FragmentActivity getActivity() {
        Fragment r0 = this.a.getHostFragment();
        if (r0 == null) goto L5;
        FragmentActivity r1 = r0.getActivity();
    L7:
        if ((r1 instanceof FragmentActivity) == true) goto L9;
        return null;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean c() {
        return this.a.c.isTypeWiki();
    }

    public a(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.a = r2;
    }

    public static final /* synthetic */ FragmentActivity b(a r0) {
        return r0.getActivity();
    }

    public static final com.bytedance.ee.bear.more.protocol3.b a(a r4, CommonMoreItemId r5) {
        FragmentActivity r0 = r4.getActivity();
        if (r0 != null) goto L6;
        tt5.a.k("DriveBaselineMoreItemFactories", "common item noop, id=" + r5 + ", activity is null");
        return d0.c;
    L6:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).q(r0, r5, ((dn4.a) r4.a.getUserComponent().a(dn4.a.class)).a(), (by4.d) r4.a.getUserComponent().a(by4.d.class));
    }

    public final void d(com.bytedance.ee.bear.more.protocol3.panel.e r2, String r3, CommonMoreItemId r4) {
        r2.d(r3, new b(this, r4));
    }
}
