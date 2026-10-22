package com.bytedance.ee.bear.wikiv2.create;

import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.creationmenu.SelectIndex;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.widgets.menuconfig.OfficeSpaceMenuConfigSorter;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final List<com.bytedance.ee.bear.creationmenu.g> b() {
        List r11 = null;
        if (yp5.c.a() == false) goto L34;
        ArrayList r0 = new ArrayList();
        SelectCreationMenuConfig r12 = g.a();
        if (r12.p == false) goto L8;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r12.i, true, SelectIndex.DOCX, kac.a.b(2131254436), 2131887745));
    L8:
        if (r12.c == false) goto L10;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r12.b, true, SelectIndex.SHEET, c(), 2131887733));
    L10:
        a(r0);
        if (r12.q == true) goto L16;
        if (r12.l == false) goto L16;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r12.e, true, SelectIndex.MINDNOTE, kac.a.b(2131254561), 2131887774));
    L16:
        if (r12.o == false) goto L19;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r12.h, true, SelectIndex.BITABLE, kac.a.b(2131254400), 2131887715));
    L19:
        if (r12.q == false) goto L23;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r12.j, true, SelectIndex.SURVEY, kac.a.b(2131254460), 2131886600));
        if (r12.l == false) goto L23;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r12.e, true, SelectIndex.MINDNOTE, kac.a.b(2131254561), 2131887774));
    L23:
        PermissionResponse r3 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity("", sbb.e.l, BizDomain.FileBizDomainCCM, ""), "UPLOAD"), null);
        gj5.c r4 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_FILE_UPLOAD", FileBizDomain.FileBizDomainCCM, 12, "");
        if (r3 == null) goto L26;
        boolean r5 = r3.getAllow();
    L28:
        if (r12.k == false) goto L59;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r12.f, r5, SelectIndex.MEDIA, kac.a.b(2131254464), 2131887224));
        boolean r6 = r12.g;
        SelectIndex r7 = SelectIndex.FILE;
        if (en4.a.l() == false) goto L32;
        int r1 = 2131254725;
    L33:
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r6, r5, r7, kac.a.b(r1), 2131887223));
        goto L59
    L32:
        r1 = 2131256095;
    L59:
        if (en4.a.l() == true) goto L61;
        return r0;
    L61:
        int r2 = h.a;
        Intrinsics.checkNotNullParameter(r0, "defaultItems");
        int r8 = com.bytedance.ee.bear.widgets.menuconfig.b.a;
        com.bytedance.ee.bear.widgets.menuconfig.c r9 = com.bytedance.ee.bear.widgets.menuconfig.c.a;
        com.bytedance.ee.bear.widgets.menuconfig.d r10 = com.bytedance.ee.bear.widgets.menuconfig.c.b;
        if (r10 == null) goto L66;
        com.bytedance.ee.bear.widgets.menuconfig.e r13 = r10.a("home_more");
        if (r13 == null) goto L66;
        if ((!r13.b) == false) goto L70;
        List r14 = CollectionsKt.emptyList();
    L75:
        if (r14 != null) goto L78;
    L120:
        if (r11 != null) goto L123;
        return r0;
    L123:
        return r11;
    L78:
        if (r14.isEmpty() == false) goto L80;
        r11 = CollectionsKt.emptyList();
        goto L120
    L80:
        LinkedHashMap r15 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r16 = r0.iterator();
    L82:
        if (r16.hasNext() == false) goto L84;
        Object r17 = r16.next();
        r15.put(((com.bytedance.ee.bear.creationmenu.g) r17).c, r17);
        goto L82
    L84:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r14.iterator();
    L86:
        if (r19.hasNext() == false) goto L119;
        String r20 = (String) r19.next();
        switch(r20.hashCode()) {
            case -1354836579: goto L113;
            case -1181593692: goto L109;
            case 1064581370: goto L105;
            case 1369536373: goto L99;
            case 1369547953: goto L95;
            case 1878111324: goto L91;
            default: goto L116;
        };
    L116:
        com.bytedance.ee.bear.creationmenu.g r21 = null;
    L117:
        if (r21 == null) goto L86;
        r18.add(r21);
        goto L86
    L91:
        if (r20.equals("create_sheet") == false) goto L131;
        r21 = (com.bytedance.ee.bear.creationmenu.g) r15.get(SelectIndex.SHEET);
        goto L117
    L131:
        r21 = null;
        goto L117
    L95:
        if (r20.equals("create_ppt") == false) goto L132;
        r21 = (com.bytedance.ee.bear.creationmenu.g) r15.get(SelectIndex.SLIDES);
        goto L117
    L132:
        r21 = null;
        goto L117
    L99:
        if (r20.equals("create_doc") == false) goto L133;
        r21 = (com.bytedance.ee.bear.creationmenu.g) r15.get(SelectIndex.DOCX);
        if (r21 != null) goto L117;
        r21 = (com.bytedance.ee.bear.creationmenu.g) r15.get(SelectIndex.DOC);
        goto L117
    L133:
        r21 = null;
        goto L117
    L105:
        if (r20.equals("upload_file") == false) goto L134;
        r21 = (com.bytedance.ee.bear.creationmenu.g) r15.get(SelectIndex.FILE);
        goto L117
    L134:
        r21 = null;
        goto L117
    L109:
        if (r20.equals("create_bitable") == false) goto L135;
        r21 = (com.bytedance.ee.bear.creationmenu.g) r15.get(SelectIndex.BITABLE);
        goto L117
    L135:
        r21 = null;
        goto L117
    L113:
        if (r20.equals("upload_image") == false) goto L136;
        r21 = (com.bytedance.ee.bear.creationmenu.g) r15.get(SelectIndex.MEDIA);
        goto L117
    L136:
        r21 = null;
        goto L117
    L119:
        r11 = r18;
        goto L120
    L70:
        List r22 = OfficeSpaceMenuConfigSorter.a(r13);
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r24 = r22.iterator();
    L72:
        if (r24.hasNext() == false) goto L74;
        r23.add(((com.bytedance.ee.bear.widgets.menuconfig.g) r24.next()).a);
        goto L72
    L74:
        r14 = r23;
    L66:
        r14 = null;
        goto L75
    L26:
        r5 = r4.a;
        goto L28
    L34:
        r0 = new ArrayList();
        SelectCreationMenuConfig r110 = g.a();
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r110.a, true, SelectIndex.DOC, kac.a.b(2131254431), 2131887745));
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r110.b, true, SelectIndex.SHEET, c(), 2131887733));
        a(r0);
        if (r110.q == true) goto L40;
        if (r110.l == false) goto L40;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r110.e, true, SelectIndex.MINDNOTE, kac.a.b(2131254561), 2131887774));
    L40:
        if (r110.o == false) goto L43;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r110.h, true, SelectIndex.BITABLE, kac.a.b(2131254400), 2131887715));
    L43:
        if (r110.q == false) goto L47;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r110.j, true, SelectIndex.SURVEY, kac.a.b(2131254460), 2131886600));
        if (r110.l == false) goto L47;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r110.e, true, SelectIndex.MINDNOTE, kac.a.b(2131254561), 2131887774));
    L47:
        PermissionResponse r25 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity("", sbb.e.l, BizDomain.FileBizDomainCCM, ""), "UPLOAD"), null);
        gj5.c r26 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_FILE_UPLOAD", FileBizDomain.FileBizDomainCCM, 12, "");
        if (r25 == null) goto L50;
        boolean r27 = r25.getAllow();
    L52:
        if (r110.k == false) goto L59;
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r110.f, r27, SelectIndex.MEDIA, kac.a.b(2131254464), 2131887224));
        boolean r28 = r110.g;
        SelectIndex r29 = SelectIndex.FILE;
        if (en4.a.l() == false) goto L56;
        int r30 = 2131254725;
    L57:
        r0.add(new com.bytedance.ee.bear.creationmenu.g(r28, r27, r29, kac.a.b(r30), 2131887223));
        goto L59
    L56:
        r30 = 2131256271;
        goto L57
    L50:
        r27 = r26.a;
        goto L52
    }

    public static final int c() {
        if (en4.a.l() == false) goto L5;
        int r0 = 2131256252;
    L7:
        return kac.a.b(r0);
    L5:
        r0 = 2131254696;
        goto L7
    }

    public static final void a(List<com.bytedance.ee.bear.creationmenu.g> r7) {
        ArrayList r8 = (ArrayList) r7;
        r8.add(new com.bytedance.ee.bear.creationmenu.g(true, true, SelectIndex.SLIDES, kac.a.b(2131256261), 2131889516));
    }
}
