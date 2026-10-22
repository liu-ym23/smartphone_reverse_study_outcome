package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import com.bytedance.ee.bear.drive.biz.external.OpenExternalItemV2;
import com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.DownloadItemV2;
import com.bytedance.ee.bear.drive.biz.preview.more.menu.fileInfo.FileInfoItemV2;
import com.bytedance.ee.bear.drive.biz.preview.more.menu.record.RecordItemV2;
import com.bytedance.ee.bear.drive.biz.preview.more.menu.rename.RenameItemV2;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.protocol3.panel.OverrideUIMoreItemFactory;
import com.bytedance.ee.bear.more.protocol3.panel.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveOfficeMoreProvider extends DriveMoreProvider {
    public final DrivePluginHost q;
    public final com.bytedance.ee.bear.more.protocol3.panel.u r;
    public final com.bytedance.ee.bear.more.protocol3.panel.e s;
    public OverrideUIMoreItemFactory t;
    public b0 u;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.menu.DriveMoreProvider
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        com.bytedance.ee.bear.more.protocol3.panel.w r0 = this.r.a();
        if (r0 != null) goto L6;
        tt5.a.h("DriveOfficeMoreProvider", "buildMoreItems, config is null, fallback legacy items");
        return super.b();
    L6:
        OverrideUIMoreItemFactory r3 = this.t;
        if (r3 != null) goto L9;
        Map r4 = MapsKt.emptyMap();
    L45:
        b0 r5 = new b0(this.q, this, this.s, r4);
        this.u = r5;
        StringBuilder r6 = new StringBuilder("buildMoreItems, hostStyle=");
        r6.append(r0.a);
        r6.append(", groupCount=");
        r6.append(r0.b.size());
        r6.append(", overrideCount=");
        OverrideUIMoreItemFactory r7 = this.t;
        if (r7 == null) goto L50;
        Map r8 = r7.e;
        if (r8 == null) goto L50;
        int r9 = r8.size();
    L51:
        r6.append(r9);
        r6.append(", delegateCount=");
        r6.append(r4.size());
        tt5.a.h("DriveOfficeMoreProvider", r6.toString());
        int r10 = com.bytedance.ee.bear.more.protocol3.panel.v.a;     // Catch: Throwable -> L54
        return com.bytedance.ee.bear.more.protocol3.panel.v.d(this, this.s, r5, r0);
    L54:
        th = move-exception;
        tt5.a.e("DriveOfficeMoreProvider", "buildMoreItems failed", th, false);
        return super.b();
    L50:
        r9 = 0;
        goto L51
    L9:
        LinkedHashMap r11 = new LinkedHashMap();
        ItemUIStyle r12 = r0.a;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r3.d = r12;
        ((LinkedHashMap) r3.e).clear();
        List r13 = r0.b;
        ArrayList r14 = new ArrayList();
        Iterator r16 = r13.iterator();
    L11:
        if (r16.hasNext() == false) goto L13;
        CollectionsKt.addAll(r14, ((com.bytedance.ee.bear.more.protocol3.panel.m) r16.next()).b);
        goto L11
    L13:
        Iterator r17 = r14.iterator();
    L15:
        if (r17.hasNext() == false) goto L44;
        com.bytedance.ee.bear.more.protocol3.panel.o r18 = (com.bytedance.ee.bear.more.protocol3.panel.o) r17.next();
        Map r19 = com.bytedance.ee.bear.more.protocol3.panel.s.a;
        String r20 = com.bytedance.ee.bear.more.protocol3.panel.s.a(r18.a);
        com.bytedance.ee.bear.more.protocol3.panel.q r21 = r18.c;
        f0 r22 = r18.b;
        if ((r22 instanceof f0) == false) goto L19;
        f0 r23 = r22;
    L20:
        if (r23 == null) goto L22;
        Function1 r110 = r23.b;
    L23:
        if (r23 == null) goto L25;
        Function1 r111 = r23.c;
    L26:
        if (r23 == null) goto L28;
        Function1 r112 = r23.d;
    L29:
        if (r23 == null) goto L31;
        Function1 r113 = r23.e;
    L32:
        if (r23 == null) goto L34;
        ItemUIStyle r24 = r23.a;
    L35:
        if (r21 == null) goto L37;
        r11.put(r20, r21);
    L37:
        if (r21 != null) goto L43;
        if (r110 != null) goto L43;
        if (r111 != null) goto L43;
        if (r112 != null) goto L43;
        if (r113 != null) goto L43;
        if (r24 == null) goto L15;
    L43:
        r3.e.put(r20, new com.bytedance.ee.bear.more.protocol3.panel.k(r21, r110, r111, r112, r113, r24));
        r3 = r3;
        goto L15
    L34:
        r24 = null;
        goto L35
    L31:
        r113 = null;
        goto L32
    L28:
        r112 = null;
        goto L29
    L25:
        r111 = null;
        goto L26
    L22:
        r110 = null;
        goto L23
    L19:
        r23 = null;
        goto L20
    L44:
        r4 = r11;
        goto L45
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.menu.DriveMoreProvider
    public final void d() {
        StringBuilder r0 = new StringBuilder("create, hasConfig=");
        if (this.r.a() == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h("DriveOfficeMoreProvider", r0.toString());
        super.d();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        tt5.a.e("DriveOfficeMoreProvider", "create failed", th, false);
        throw th;
    L5:
        r1 = false;
        goto L6
    }

    public final void a(sj5.b r10, com.bytedance.ee.bear.more.protocol3.l r11) {
        com.bytedance.ee.bear.more.view3.d r12 = com.bytedance.ee.bear.more.view3.d.a;
        Intrinsics.checkNotNullParameter(r10, "host");
        Intrinsics.checkNotNullParameter(r12, "uiItemFactory");
        com.bytedance.ee.bear.more.protocol3.panel.w r0 = this.r.a();
        if (r0 != null) goto L6;
        tt5.a.h("DriveOfficeMoreProvider", "attachToHost, config is null, use legacy provider");
        super/*com.bytedance.ee.bear.more.protocol3.h*/.a(r10, r12);
        return;
    L6:
        com.bytedance.ee.bear.drive.biz.preview.more.menu.a r13 = new com.bytedance.ee.bear.drive.biz.preview.more.menu.a(this.q);
        com.bytedance.ee.bear.more.protocol3.panel.e r2 = this.s;
        Intrinsics.checkNotNullParameter(r2, "registry");
        r13.d(r2, "shortcut", CommonMoreItemId.SHORT_CUT);
        r2.d("shareV2", new s(r13));
        r2.d("open_ai_chat", new t(r13));
        r2.d("add_main_nav", new u(r13));
        r2.d("multi_task", new v(r13));
        r2.d("moveV2", new w(r13));
        if (r13.c() == false) goto L9;
        r2.d("pin", new x(r13));
        r2.d("star", new y(r13));
        r2.d("WikiExploreStarItem", new z(r13));
        r2.d("WikiShortcutItem", new a0(r13));
        r2.d("add_shortcut", p.a);
    L10:
        r13.d(r2, "manual_cache", CommonMoreItemId.MANUAL_CACHE);
        r2.d("browser_view", new g(r13));
        r2.d(FileInfoItemV2.ID_FILE_STATS, new h(r13));
        r2.d("SecretMoreItem", i.a);
        r13.d(r2, "permission", CommonMoreItemId.PERMISSION);
        r2.d(RenameItemV2.ID_RENAME, new j(r13));
        r13.d(r2, "apply_edit_permission", CommonMoreItemId.APPLY_EDIT_PERMISSION);
        r2.d("drive_detail_import_as", new k(r13));
        r2.d(DownloadItemV2.ID_DOWNLOAD, new l(r13));
        r2.d(OpenExternalItemV2.ID_OPENEXTERNAL, new m(r13));
        r2.d(RecordItemV2.ID_NAME, new n(r13));
        if (r13.c() == false) goto L13;
        r2.d("make_copy", new o(r13));
    L14:
        r13.d(r2, "retention_label", CommonMoreItemId.RETENTION_LABEL);
        r2.d("expired_content", d.a);
        r2.d("freshNess", e.a);
        r13.d(r2, "contact_service", CommonMoreItemId.CONTACT_SERVICE);
        r13.d(r2, "report", CommonMoreItemId.REPORT);
        r2.d("transfer_apply", f.a);
        if (r13.c() == false) goto L17;
        r2.d("delete", new c(r13));
    L18:
        tt5.a.h("DriveBaselineMoreItemFactories", "registerAll done, isWiki=" + r13.c() + ", total=" + CollectionsKt.toSet(((LinkedHashMap) r2.a).keySet()).size());
        OverrideUIMoreItemFactory r14 = new OverrideUIMoreItemFactory(this.s, new DriveOfficeMoreProvider$attachToHost$proxy$1(this));
        ItemUIStyle r3 = r0.a;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r14.d = r3;
        this.t = r14;
        tt5.a.h("DriveOfficeMoreProvider", "attachToHost, use composer provider, hostStyle=" + r0.a + ", groupCount=" + r0.b.size());
        super/*com.bytedance.ee.bear.more.protocol3.h*/.a(r10, r14);
        return;
    L17:
        r13.d(r2, "delete", CommonMoreItemId.DELETE);
        goto L18
    L13:
        r13.d(r2, "make_copy", CommonMoreItemId.MAKE_COPY);
        goto L14
    L9:
        r13.d(r2, "pin", CommonMoreItemId.PIN);
        r13.d(r2, "star", CommonMoreItemId.STAR);
        r13.d(r2, "add_shortcut", CommonMoreItemId.ADD_SHORT_CUT);
        r2.d("WikiExploreStarItem", q.a);
        r2.d("WikiShortcutItem", r.a);
        goto L10
    }

    public DriveOfficeMoreProvider(DrivePluginHost r2, com.bytedance.ee.bear.more.protocol3.extension.a r3, com.bytedance.ee.bear.more.protocol3.panel.u r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "moreInfoBehavior");
        Intrinsics.checkNotNullParameter(r4, "morePanelAbility");
        super(r2, r3);
        this.q = r2;
        this.r = r4;
        this.s = new com.bytedance.ee.bear.more.protocol3.panel.e();
    }
}
