package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.template.TemplateTypeSwitchItemV2;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableAppMoreProvider extends BaseMoreProvider {
    public static final /* synthetic */ int q = 0;
    public final DocumentPluginHost m;
    public final wj5.a n;
    public final c25.b o;
    public boolean p;

    public static final class a {
    }

    public static final class b implements com.bytedance.ee.bear.more.protocol3.b {
        public final com.bytedance.ee.bear.more.protocol3.b a;
        public final Function0<Boolean> b;

        public final com.bytedance.ee.bear.more.protocol3.k buildUI() {
            if (((Boolean) this.b.invoke()).booleanValue() == true) goto L7;
            return null;
        L7:
            return this.a.buildUI();
        }

        public final void create() {
            this.a.create();
        }

        public final void release() {
            this.a.release();
        }

        public final void init(com.bytedance.ee.bear.more.protocol3.h r2) {
            Intrinsics.checkNotNullParameter(r2, "hostProvider");
            this.a.init(r2);
        }

        public b(TemplateTypeSwitchItemV2 r2, Function0 r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "visible");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new BitableAppMoreProvider$buildMoreItems$1(this));
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
        com.bytedance.ee.bear.contract.j.a.a.a().observe(f().getHostFragment(), new c(this));
    L6:
        if (p() == false) goto L9;
        ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).d(this.m).subscribe(new com.bytedance.ee.bear.document.more.a(this), com.bytedance.ee.bear.document.more.b.a);
    L9:
        if (((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).k() == false) goto L22;
        DocumentInfo r0 = this.m.a().getDocumentInfoData();
        if (r0 == null) goto L15;
        String r1 = r0.getObjToken();
        if (r1 == null) goto L15;
    L16:
        Intrinsics.checkNotNull(r1);
        if (StringsKt.isBlank(r1) == false) goto L19;
        tt5.a.k("BitableAppMoreProvider", "bindTenantInfo, docToken is blank");
        return;
    L19:
        ((er5.b) org.koin.java.a.c(er5.b.class, null, null, 6)).d(r1, new BitableAppMoreProvider$bindTenantInfo$1(this));
        return;
    L15:
        r1 = this.m.a().getBearUrl().b;
        goto L16
    }

    public static final /* synthetic */ FragmentActivity m(BitableAppMoreProvider r0) {
        return r0.getActivity();
    }

    public static final by4.d n(BitableAppMoreProvider r1) {
        return (by4.d) r1.m.getUserComponent().a(by4.d.class);
    }

    public BitableAppMoreProvider(DocumentPluginHost r2, wj5.a r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "moreInfoBehavior");
        this.m = r2;
        this.n = r3;
        this.o = new c25.b();
    }
}
