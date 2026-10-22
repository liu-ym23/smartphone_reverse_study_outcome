package com.bytedance.ee.bear.document.template;

import com.bytedance.ee.bear.contract.route.parcelable.d;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final Set<Integer> a = null;

    static {
        a = SetsKt.setOf(new Integer[]{Integer.valueOf(e.g.b), Integer.valueOf(e.h.b), Integer.valueOf(e.k.b), 8, Integer.valueOf(e.o.b)});
    }

    public static boolean a(c r8) {
        if (r8.isOwner() == false) goto L5;
        return true;
    L5:
        IDocUserPermission r0 = r8.c().a;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L10;
        int r1 = f35.b.a;
        String r2 = r8.getToken();
        int r3 = r8.getType();
        String r4 = r8.a();
        DocPermission r9 = r8.c();
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r4, "creatorTenantId");
        Intrinsics.checkNotNullParameter(r9, "docPermission");
        Intrinsics.checkNotNullParameter("MANAGE_CONTAINER_PERMISSION_META", "operation");
        BaseEntity r6 = new BaseEntity(r2, e.d(r3), BizDomain.FileBizDomainCCM, r4);
        PermissionRequest r5 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).d(r6, "MANAGE_CONTAINER_PERMISSION_META");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(r5, new UserPermissionEntity(r9.a, null)).getAllow();
    L10:
        if (r0.canEdit() == true) goto L12;
    L14:
        return false;
    L12:
        if (r0.canManageContainerPermissionMeta() == false) goto L14;
        return true;
    }

    public static boolean c(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.wiki_root_custom_homepage") == true) goto L5;
        return false;
    L5:
        d r3 = (d) r2.getHostAbilityOrNull(d.class);
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.isWikiHomePage() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean b(DocumentPluginHost r7, c r8) {
        Intrinsics.checkNotNullParameter(r7, "pluginHost");
        Set<Integer> r9 = a;
        if (r8 == null) goto L5;
        Integer r0 = Integer.valueOf(r8.getType());
    L6:
        boolean r10 = CollectionsKt.contains(r9, r0);
        if (r8 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        com.bytedance.ee.bear.appsetting.c r3 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r4 = r3.i("spacekit.mobile.template_docx_save_to_custom", false);
        boolean r5 = r3.i("ccm.workspace.phoenix", false);
        if (r8 != null) goto L15;
    L17:
        boolean r11 = false;
    L18:
        if (r11 == false) goto L21;
        if (r5 == false) goto L21;
        boolean r12 = true;
    L22:
        tt5.a.h("TemplateUtils", "isDocx = " + r2 + " docxFg = " + r4 + " isPhoenix = " + r12 + " phoenixFg = " + r5);
        if (r10 == false) goto L28;
        if (r2 == false) goto L26;
        if (r4 == false) goto L28;
    L26:
        if (r12 == true) goto L28;
        return true;
    L28:
        return false;
    L21:
        r12 = false;
        goto L22
    L15:
        if (r8.o() != true) goto L17;
        r11 = true;
        goto L18
    L9:
        if (r8.getType() != e.o.b) goto L11;
        r2 = true;
        goto L12
    L5:
        r0 = null;
        goto L6
    }

    public static void d(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "objToken");
        String r5 = p.a().ua(e.d(r3).getType(), r4, "");
        RouteBean r6 = new RouteBean();
        r6.c = 1;
        ((h) org.koin.java.a.c(h.class, null, null, 6)).m9(r5, r6);
    }
}
