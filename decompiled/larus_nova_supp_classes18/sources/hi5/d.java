package hi5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.LinkShareItem;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static LinkShareItem a(Context r6, int r7, IFolderPublicPermission r8) {
        boolean r0 = true;
        String r1 = "";
        if (r7 != 1) goto L5;
        String r9 = r6.getString(2131888203);
    L30:
        r1 = r9;
        String r10 = "";
    L32:
        return new LinkShareItem(r7, r1, r0, r10);
    L5:
        if (r7 != 2) goto L7;
        r9 = r6.getString(2131888229);
        goto L30
    L7:
        if (r7 != 3) goto L9;
        r9 = xo5.a.c(r6, 2131888234, "rightName", r6.getString(2131888224));
        goto L30
    L9:
        if (r7 != 4) goto L11;
        r9 = xo5.a.c(r6, 2131888234, "rightName", r6.getString(2131888223));
        goto L30
    L11:
        if (r7 != 5) goto L13;
    L25:
        r9 = r6.getString(2131888222);
        goto L30
    L13:
        if (r7 == 7) goto L25;
        if (r7 != 12) goto L17;
        r1 = r6.getString(2131887298);
        r0 = r8.partnerTenantAccess();
        r10 = r6.getString(2131887264);
        goto L32
    L17:
        if (r7 == 13) goto L23;
        tt5.a.d("LinkShareHelper", "getLinkShareItem(): not recognition type = " + r7);
        if (eu5.c.e() == true) goto L22;
        r10 = "";
        goto L32
    L22:
        throw new IllegalArgumentException("error type = " + r7);
    L23:
        r1 = r6.getString(2131887297);
        r0 = r8.partnerTenantAccess();
        r10 = r6.getString(2131887264);
        goto L32
    }

    public static int d(IDocPublicPermission r2, boolean r3, boolean r4) {
        if ((!r2.isLinkShareClose()) == true) goto L8;
        if (r3 == false) goto L6;
        return 1;
    L6:
        return 2;
    L8:
        if (r4 == false) goto L17;
        if (r3 == false) goto L17;
        if (r2.isLinkShareAnyoneEdit() == false) goto L14;
        return 8;
    L14:
        return 7;
    L17:
        if (r2.isLinkShareAnyoneEdit() == false) goto L21;
        return 6;
    L21:
        if (r2.isLinkShareAnyoneRead() == false) goto L25;
        return 5;
    L25:
        if (r2.isLinkShareInternalEdit() == false) goto L29;
        return 4;
    L29:
        if (r2.isLinkShareInternalRead() == false) goto L33;
        return 3;
    L33:
        if (r2.isLinkSharePartnerTenantRead() == false) goto L37;
        return 12;
    L37:
        if (r2.isLinkSharePartnerTenantEdit() == false) goto L40;
        return 13;
    L40:
        return 0;
    }

    public static int e(IFolderPublicPermission r2, boolean r3, boolean r4) {
        if ((!r2.isLinkShareClose()) == true) goto L8;
        if (r3 == false) goto L6;
        return 1;
    L6:
        return 2;
    L8:
        if (r4 == false) goto L13;
        if (r3 == false) goto L13;
        return 7;
    L13:
        if (r2.isLinkShareAnyoneRead() == false) goto L17;
        return 5;
    L17:
        if (r2.isLinkShareInternalEdit() == false) goto L21;
        return 4;
    L21:
        if (r2.isLinkShareInternalRead() == false) goto L25;
        return 3;
    L25:
        if (r2.isLinkSharePartnerTenantRead() == false) goto L29;
        return 12;
    L29:
        if (r2.isLinkSharePartnerTenantEdit() == false) goto L32;
        return 13;
    L32:
        return 0;
    }

    public static LinkShareItem b(Context r10, IDocPublicPermission r11, int r12, int r13) {
        if (r12 != 12) goto L5;
        String r14 = r10.getString(2131887298);
    L35:
        return new LinkShareItem(r12, r14);
    L5:
        if (r12 != 13) goto L7;
        r14 = r10.getString(2131887297);
        goto L35
    L7:
        switch(r12) {
            case 1: goto L27;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L16;
            case 6: goto L11;
            case 7: goto L16;
            case 8: goto L11;
            default: goto L8;
        };
    L8:
        tt5.a.d("LinkShareHelper", "getLinkShareItem(): not recognition type = " + r12);
        if (eu5.c.e() == true) goto L31;
        r14 = "";
        goto L35
    L31:
        throw new IllegalArgumentException("error type = " + r12);
    L11:
        String r15 = r10.getString(2131888221);
        if (r11.hasLinkPassword() == true) goto L14;
    L21:
        r14 = r15;
        goto L35
    L14:
        if (TextUtils.isEmpty(r11.linkPassword()) == true) goto L21;
        r14 = xo5.a.c(r10, 2131889681, "permType", r10.getString(2131888223));
        goto L35
    L16:
        r15 = r10.getString(2131888222);
        if (r11.hasLinkPassword() == false) goto L21;
        if (TextUtils.isEmpty(r11.linkPassword()) == true) goto L21;
        r14 = xo5.a.c(r10, 2131889681, "permType", r10.getString(2131888224));
        goto L35
    L22:
        r14 = xo5.a.c(r10, 2131888234, "rightName", r10.getString(2131888223));
        goto L35
    L23:
        r14 = xo5.a.c(r10, 2131888234, "rightName", r10.getString(2131888224));
        goto L35
    L24:
        if (r13 != 44) goto L26;
        r14 = xo5.a.c(r10, 2131888811, "fileType", r10.getString(2131889016));
        goto L35
    L26:
        r14 = r10.getString(2131888229);
        goto L35
    L27:
        if (r13 != 44) goto L29;
        r14 = xo5.a.c(r10, 2131888811, "fileType", r10.getString(2131889016));
        goto L35
    L29:
        r14 = r10.getString(2131888203);
        goto L35
    }

    public static LinkShareItem c(Context r1, boolean r2, int r3, int r4) {
        if (r3 != 12) goto L5;
        String r5 = r1.getString(2131888776);
    L24:
        return new LinkShareItem(r3, r5);
    L5:
        if (r3 == 13) goto L21;
        switch(r3) {
            case 1: goto L18;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L11;
            case 6: goto L8;
            case 7: goto L11;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        tt5.a.d("LinkShareHelper", "getLinkShareItem(): not recognition type = " + r3);
        r5 = "";
        goto L24
    L8:
        String r6 = r1.getString(2131888763);
        if (r2 == false) goto L14;
        r5 = r1.getString(2131888759);
    L14:
        r5 = r6;
        goto L24
    L11:
        r6 = r1.getString(2131888765);
        if (r2 == false) goto L14;
        r5 = r1.getString(2131888761);
        goto L24
    L15:
        r5 = r1.getString(2131888769);
        goto L24
    L16:
        r5 = r1.getString(2131888772);
        goto L24
    L18:
        if (r4 != 44) goto L20;
        r5 = xo5.a.c(r1, 2131888811, "fileType", r1.getString(2131889016));
        goto L24
    L20:
        r5 = r1.getString(2131888768);
        goto L24
    L21:
        r5 = r1.getString(2131888774);
        goto L24
    }
}
