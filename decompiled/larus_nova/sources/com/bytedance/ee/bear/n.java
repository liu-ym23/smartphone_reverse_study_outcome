package com.bytedance.ee.bear;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ee.bear.container.ContainerFragment;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.wikiv2.route.WikiRouteTable;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yq5.z;

/* JADX INFO: loaded from: classes15.dex */
@OfficeSDKUserScope
public final class n implements gk5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ik5.a f235092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.office.export.space.a f235093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.init.a f235094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.init.b f235095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t45.c f235096e;

    public static final class a {
    }

    static {
    }

    @Override // gk5.e
    public final com.bytedance.ee.drive.preview.d Y2() {
        return (com.bytedance.ee.drive.preview.d) org.koin.java.a.c(com.bytedance.ee.drive.preview.f.class, null, null, 6);
    }

    @Override // gk5.e
    public final String Za() {
        String r100 = this.f235096e.getMainDomain();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // gk5.e
    public final tz4.d ea() {
        return new tz4.d();
    }

    @Override // gk5.e
    public final com.bytedance.ee.permission.a i0() {
        return ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).i0();
    }

    @Override // gk5.e
    public final com.bytedance.ee.bear.drive.sdk.service.g p9() {
        return ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0();
    }

    @Override // gk5.e
    public final com.bytedance.ee.bear.share.export.j y5() {
        return (com.bytedance.ee.bear.share.export.j) LarkContext.spiByDwarf(cj5.c.class);
    }

    @Override // gk5.e
    public final ik5.a c0() {
        return this.f235092a;
    }

    @Override // gk5.e
    public final com.bytedance.ee.bear.office.export.space.a e7() {
        return this.f235093b;
    }

    public static boolean c(BearUrl r100) {
        if (Intrinsics.areEqual(r100.f222563d.get("from"), "template_preview") == false) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100.f222563d.get("view_doc_history"), "1") == false) goto L8;
        return false;
    L8:
        List<String> r101 = sbb.e.f541293d;
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains(r100.f222560a) == false) goto L11;
    L12:
        return true;
    L11:
        if (Intrinsics.areEqual(r100.f222560a, "file") == true) goto L12;
        return false;
    }

    @Override // gk5.e
    public final BearUrl Z(String r100) {
        return this.f235096e.Z(r100);
    }

    public static String b(String r100, String r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        tt5.a.k("IOfficeCCMService", "concatUrlFragment, sourceUrl is null or empty.");
        return r100;
    L13:
        if (r101 != null) goto L15;
    L18:
        boolean r104 = true;
    L19:
        if (r104 == false) goto L23;
        tt5.a.h("IOfficeCCMService", "concatUrlFragment, uriFragment is null or empty.");
        return r100;
    L23:
        if (StringsKt.contains$default(r100, r101, false, 2, null) == false) goto L52;
        tt5.a.h("IOfficeCCMService", "concatUrlFragment, sourceUrl already contains fragment.");
        return r100;
    L52:
        Uri r105 = UriProtector.parse(r100);     // Catch: Exception -> L28
    L30:
        if (r105 != null) goto L33;
        tt5.a.k("IOfficeCCMService", "concatUrlFragment, parse uri failed.");
        return r100;
    L33:
        String r106 = r105.getFragment();
        if (r106 != null) goto L36;
    L39:
        if (r102 == true) goto L43;
        tt5.a.k("IOfficeCCMService", "concatUrlFragment, sourceUrl already contains other fragment: " + du5.b.h(r100));
        return r100;
    L43:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.wiki.android.url_fragment_disabled") == false) goto L47;
        tt5.a.k("IOfficeCCMService", "concatUrlFragment, wiki url fragment disabled by FG.");
        return r100;
    L47:
        if (StringsKt.startsWith$default(r101, "#", false, 2, null) == true) goto L50;
        r101 = "#" + r101;
    L50:
        String r107 = r100 + r101;
        tt5.a.h("IOfficeCCMService", "concatUrlFragment, resultUrl: " + du5.b.h(r107));
        return r107;
    L36:
        if (r106.length() == 0) goto L39;
        r102 = false;
    L28:
        e = move-exception;
        tt5.a.e("IOfficeCCMService", "concatUrlFragment, parse sourceUrl error:", e, false);
        r105 = null;
        goto L30
    L15:
        if (r101.length() == 0) goto L18;
        r104 = false;
        goto L19
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public final String a(String r100, Integer r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L26;
        return r100;
    L26:
        String r104 = this.f235096e.T6(r100, r101);     // Catch: Exception -> L23
        if (r104 == null) goto L17;
        if (r104.length() == 0) goto L17;
        r102 = false;
    L17:
        if (r102 == false) goto L20;
        r104 = null;
    L20:
        if (r104 != null) goto L28;
        return r100;
    L28:
        return r104;
    L23:
        e = move-exception;
        tt5.a.e("IOfficeCCMService", "concatUrlForDoubao error.", e, false);
        return r100;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // gk5.e
    public final String f6(String r100, Integer r110) {
        boolean r101 = true;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L45;
        tt5.a.k("IOfficeCCMService", "concatUrl, url is null or empty.");
        return r100;
    L45:
        BearUrl r103 = Z(r100);     // Catch: Exception -> L42
        String r104 = r103.f222561b;     // Catch: Exception -> L42
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L20;
        tt5.a.h("IOfficeCCMService", "concatUrl, token is null or empty.");     // Catch: Exception -> L42
        return a(r100, r110);
    L20:
        z r106 = WikiRouteTable.a(r104);     // Catch: Exception -> L42
        if (r106 != null) goto L23;
    L25:
        r101 = false;
    L26:
        if (r101 == true) goto L29;
        tt5.a.h("IOfficeCCMService", "concatUrl, routeEntry is null or invalid.");     // Catch: Exception -> L42
        return a(r100, r110);
    L29:
        String r107 = r103.f222560a;     // Catch: Exception -> L42
        sbb.e r108 = sbb.e.f541303n;     // Catch: Exception -> L42
        if (Intrinsics.areEqual(r107, r108.getType()) == false) goto L35;
        if (r106.f568855e == false) goto L35;
        tt5.a.h("IOfficeCCMService", "concatUrl, wiki has moved to space.");     // Catch: Exception -> L42
        String r109 = r103.f222564e;     // Catch: Exception -> L42
        Map<String, String> r111 = r103.f222563d;     // Catch: Exception -> L42
        String r112 = s45.p.a().Fd(r109, sbb.e.f(r106.f568854d), r106.f568853c, r111);     // Catch: Exception -> L42
    L46:
        return a(b(r112, r103.f222575p), r110);
    L35:
        if (c(r103) == true) goto L37;
    L39:
        r112 = r100;
        goto L46
    L37:
        if (r106.f568855e == true) goto L39;
        tt5.a.h("IOfficeCCMService", "concatUrl, doc has moved to wiki.");     // Catch: Exception -> L42
        String r113 = r103.f222564e;     // Catch: Exception -> L42
        Map<String, String> r114 = r103.f222563d;     // Catch: Exception -> L42
        r112 = s45.p.a().Fd(r113, r108.getType(), r106.f568852b, r114);     // Catch: Exception -> L42
        goto L46
    L23:
        if (r106.a() != true) goto L25;
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
    L42:
        e = move-exception;
        tt5.a.e("IOfficeCCMService", "concatUrl error.", e, false);
        return a(r100, r110);
    L5:
        r102 = false;
        goto L7
    }

    @Override // gk5.e
    public final ContainerFragment I1(String r100, Long r110, com.larus.office.container.impl.applet.h r111, com.larus.office.container.impl.applet.i r112) {
        Intrinsics.checkNotNullParameter(r100, "url");
        int r101 = com.bytedance.ee.bear.document.render.node.perf.e.f221379h;
        com.bytedance.ee.bear.document.render.node.perf.e.a.a(r110);
        tt5.a.h("IOfficeCCMService", "==openDocs== openDocumentFragment, url: " + du5.b.h(r100) + ", markdown.size: null");
        com.bytedance.ee.bear.contract.d r102 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        long r103 = System.currentTimeMillis();
        r102.h("start_open");
        r102.j("start_open", ILoadStallMonitor.START_TIME, String.valueOf(r103));
        r102.j("start_open", "click_timestamp", r110);
        Bundle r113 = new Bundle();
        r113.putString("url", r100);
        r113.putLong("open_file_start_time", r103);
        r113.putString("offline_create_markdown", null);
        PassportcConvention.f(r113, LarkContext.getApplication());
        ContainerFragment r104 = new ContainerFragment();
        r104.f216730s = r112;
        final String r114 = UUID.randomUUID().toString();
        r113.putString("plugin_host_callback_key", r114);
        hk5.b.b(r114, r111);
        r104.getLifecycle().addObserver(new OfficeCCMUserServiceImpl$openWikiFragment$2(r114));
        r104.setArguments(r113);
        return r104;
    }

    @Inject
    public n(ik5.a r100, com.bytedance.ee.bear.office.export.space.a r101, com.bytedance.ee.bear.init.a r102, com.bytedance.ee.bear.init.b r103, t45.c r104) {
        Intrinsics.checkNotNullParameter(r100, "docsSdk");
        Intrinsics.checkNotNullParameter(r101, "officeSpaceSdk");
        Intrinsics.checkNotNullParameter(r102, "officeCCMGlobalInit");
        Intrinsics.checkNotNullParameter(r103, "officeCCMUserInit");
        Intrinsics.checkNotNullParameter(r104, "iSpaceKitUrlHelper");
        this.f235092a = r100;
        this.f235093b = r101;
        this.f235094c = r102;
        this.f235095d = r103;
        this.f235096e = r104;
    }
}
