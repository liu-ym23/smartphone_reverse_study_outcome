package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveMoreProvider extends BaseMoreProvider {
    public static final /* synthetic */ int p = 0;
    public final DrivePluginHost m;
    public final com.bytedance.ee.bear.more.protocol3.extension.a n;
    public final f65.b o;

    public com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new DriveMoreProvider$buildMoreItems$1(this));
    }

    public final jdb.g p() {
        return ((dn4.a) this.m.getUserComponent().a(dn4.a.class)).a();
    }

    private final FragmentActivity getActivity() {
        return f().getHostFragment().getActivity();
    }

    public void d() {
        super/*com.bytedance.ee.bear.more.protocol3.extension.v*/.d();
        k(this.n);
        if (p().isEnable("ccm.mobile.android_doc_support_open_browser") == false) goto L6;
        com.bytedance.ee.bear.contract.j.a.a.a().observe(f().getHostFragment(), new c0(this));
        return;
    }

    public static final /* synthetic */ FragmentActivity m(DriveMoreProvider r0) {
        return r0.getActivity();
    }

    public static final by4.d n(DriveMoreProvider r1) {
        return (by4.d) r1.m.getUserComponent().a(by4.d.class);
    }

    public static final boolean o(DriveMoreProvider r0) {
        return r0.m.c.isTypeWiki();
    }

    public DriveMoreProvider(DrivePluginHost r2, com.bytedance.ee.bear.more.protocol3.extension.a r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "moreInfoBehavior");
        this.m = r2;
        this.n = r3;
        this.o = new f65.b();
    }
}
