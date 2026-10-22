package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.template.TemplateTypeSwitchItemV2;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class BitableAppMoreProvider extends BaseMoreProvider {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f220285q = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DocumentPluginHost f220286m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final wj5.a f220287n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c25.b f220288o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f220289p;

    public static final class a {
    }

    public static final class b implements com.bytedance.ee.bear.more.protocol3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ee.bear.more.protocol3.b f220290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Boolean> f220291b;

        @Override // com.bytedance.ee.bear.more.protocol3.b
        public final com.bytedance.ee.bear.more.protocol3.k buildUI() {
            if (this.f220291b.invoke().booleanValue() == true) goto L7;
            return null;
        L7:
            return this.f220290a.buildUI();
        }

        @Override // com.bytedance.ee.bear.more.protocol3.b
        public final void create() {
            this.f220290a.create();
        }

        @Override // com.bytedance.ee.bear.more.protocol3.b
        public final void release() {
            this.f220290a.release();
        }

        @Override // com.bytedance.ee.bear.more.protocol3.b
        public final void init(com.bytedance.ee.bear.more.protocol3.h r100) {
            Intrinsics.checkNotNullParameter(r100, "hostProvider");
            this.f220290a.init(r100);
        }

        public b(TemplateTypeSwitchItemV2 r100, Function0 r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "visible");
            this.f220290a = r100;
            this.f220291b = r101;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new BitableAppMoreProvider$buildMoreItems$1(this));
    }

    public final jdb.g o() {
        return ((dn4.a) this.f220286m.getUserComponent().a(dn4.a.class)).a();
    }

    public final boolean p() {
        return this.f220286m.a().isType(sbb.e.f541303n);
    }

    private final FragmentActivity getActivity() {
        return f().getHostFragment().getActivity();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public final void d() {
        super.d();
        k(this.f220287n);
        if (o().isEnable("ccm.mobile.android_doc_support_open_browser") == false) goto L6;
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(f().getHostFragment(), new c(this));
    L6:
        if (p() == false) goto L9;
        ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).d(this.f220286m).subscribe(new com.bytedance.ee.bear.document.more.a(this), com.bytedance.ee.bear.document.more.b.f220315a);
    L9:
        if (((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).k() == false) goto L22;
        DocumentInfo r100 = this.f220286m.a().getDocumentInfoData();
        if (r100 == null) goto L15;
        String r101 = r100.getObjToken();
        if (r101 == null) goto L15;
    L16:
        Intrinsics.checkNotNull(r101);
        if (StringsKt.isBlank(r101) == false) goto L19;
        tt5.a.k("BitableAppMoreProvider", "bindTenantInfo, docToken is blank");
        return;
    L19:
        ((er5.b) org.koin.java.a.c(er5.b.class, null, null, 6)).d(r101, new BitableAppMoreProvider$bindTenantInfo$1(this));
        return;
    L15:
        r101 = this.f220286m.a().getBearUrl().f222561b;
        goto L16
    }

    public static final /* synthetic */ FragmentActivity m(BitableAppMoreProvider r100) {
        return r100.getActivity();
    }

    public static final by4.d n(BitableAppMoreProvider r100) {
        return (by4.d) r100.f220286m.getUserComponent().a(by4.d.class);
    }

    public BitableAppMoreProvider(DocumentPluginHost r100, wj5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        Intrinsics.checkNotNullParameter(r101, "moreInfoBehavior");
        this.f220286m = r100;
        this.f220287n = r101;
        this.f220288o = new c25.b();
    }
}
