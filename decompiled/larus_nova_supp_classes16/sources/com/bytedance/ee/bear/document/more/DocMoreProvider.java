package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocMoreProvider extends BaseMoreProvider {
    public static final /* synthetic */ int p = 0;
    public final DocumentPluginHost m;
    public final com.bytedance.ee.bear.more.protocol3.extension.a n;
    public final c25.b o;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new DocMoreProvider$buildMoreItems$1(this));
    }

    public final jdb.g o() {
        return ((dn4.a) this.m.getUserComponent().a(dn4.a.class)).a();
    }

    public final boolean p() {
        return this.m.a().isType(sbb.e.n);
    }

    private final FragmentActivity getActivity() {
        return f().getHostFragment().getActivity();
    }

    public final void d() {
        super/*com.bytedance.ee.bear.more.protocol3.extension.v*/.d();
        k(this.n);
        if (o().isEnable("ccm.mobile.android_doc_support_open_browser") == false) goto L6;
        com.bytedance.ee.bear.contract.j.a.a.a().observe(f().getHostFragment(), new g(this));
    L6:
        if (p() == false) goto L9;
        ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).d(this.m).subscribe(new e(this), f.a);
        return;
    }

    public static final /* synthetic */ FragmentActivity m(DocMoreProvider r0) {
        return r0.getActivity();
    }

    public static final by4.d n(DocMoreProvider r1) {
        return (by4.d) r1.m.getUserComponent().a(by4.d.class);
    }

    public DocMoreProvider(DocumentPluginHost r2, com.bytedance.ee.bear.more.protocol3.extension.a r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "moreInfoBehavior");
        this.m = r2;
        this.n = r3;
        this.o = new c25.b();
    }
}
