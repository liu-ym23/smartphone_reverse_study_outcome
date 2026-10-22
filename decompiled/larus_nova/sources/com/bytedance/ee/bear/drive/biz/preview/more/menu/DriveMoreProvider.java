package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class DriveMoreProvider extends BaseMoreProvider {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f223557p = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DrivePluginHost f223558m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.protocol3.extension.a f223559n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f65.b f223560o;

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new DriveMoreProvider$buildMoreItems$1(this));
    }

    public final jdb.g p() {
        return ((dn4.a) this.f223558m.getUserComponent().a(dn4.a.class)).a();
    }

    private final FragmentActivity getActivity() {
        return f().getHostFragment().getActivity();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public void d() {
        super.d();
        k(this.f223559n);
        if (p().isEnable("ccm.mobile.android_doc_support_open_browser") == false) goto L6;
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(f().getHostFragment(), new c0(this));
        return;
    }

    public static final /* synthetic */ FragmentActivity m(DriveMoreProvider r100) {
        return r100.getActivity();
    }

    public static final by4.d n(DriveMoreProvider r100) {
        return (by4.d) r100.f223558m.getUserComponent().a(by4.d.class);
    }

    public static final boolean o(DriveMoreProvider r100) {
        return r100.f223558m.f224125c.isTypeWiki();
    }

    public DriveMoreProvider(DrivePluginHost r100, com.bytedance.ee.bear.more.protocol3.extension.a r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        Intrinsics.checkNotNullParameter(r101, "moreInfoBehavior");
        this.f223558m = r100;
        this.f223559n = r101;
        this.f223560o = new f65.b();
    }
}
