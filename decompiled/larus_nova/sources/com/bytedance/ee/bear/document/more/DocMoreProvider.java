package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DocMoreProvider extends BaseMoreProvider {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f220295p = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DocumentPluginHost f220296m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.protocol3.extension.a f220297n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c25.b f220298o;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new DocMoreProvider$buildMoreItems$1(this));
    }

    public final jdb.g o() {
        return ((dn4.a) this.f220296m.getUserComponent().a(dn4.a.class)).a();
    }

    public final boolean p() {
        return this.f220296m.a().isType(sbb.e.f541303n);
    }

    private final FragmentActivity getActivity() {
        return f().getHostFragment().getActivity();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public final void d() {
        super.d();
        k(this.f220297n);
        if (o().isEnable("ccm.mobile.android_doc_support_open_browser") == false) goto L6;
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(f().getHostFragment(), new g(this));
    L6:
        if (p() == false) goto L9;
        ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).d(this.f220296m).subscribe(new e(this), f.f220327a);
        return;
    }

    public static final /* synthetic */ FragmentActivity m(DocMoreProvider r100) {
        return r100.getActivity();
    }

    public static final by4.d n(DocMoreProvider r100) {
        return (by4.d) r100.f220296m.getUserComponent().a(by4.d.class);
    }

    public DocMoreProvider(DocumentPluginHost r100, com.bytedance.ee.bear.more.protocol3.extension.a r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        Intrinsics.checkNotNullParameter(r101, "moreInfoBehavior");
        this.f220296m = r100;
        this.f220297n = r101;
        this.f220298o = new c25.b();
    }
}
