package km5;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemUtil;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static boolean h() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        return jg5.e.a.a.h();
    }

    public static void a(List<ShareItemModel> r3) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.h() == false) goto L6;
        ShareItemUtil r0 = ShareItemUtil.a;
        ShareType r1 = ShareType.CopyLink;
        ShareState r2 = ShareState.SHOW;
        r0.getClass();
        ArrayList r4 = (ArrayList) r3;
        r4.add(ShareItemUtil.a(r1, r2));
        return;
    }

    public static void b(List<ShareItemModel> r3) {
        ShareItemUtil r0 = ShareItemUtil.a;
        ShareType r1 = ShareType.Lark;
        if (AppInfoUtils.e().booleanValue() == false) goto L5;
        ShareState r2 = ShareState.NOT_SHOW;
    L6:
        r0.getClass();
        ArrayList r4 = (ArrayList) r3;
        r4.add(ShareItemUtil.a(r1, r2));
        return;
    L5:
        r2 = ShareState.SHOW;
        goto L6
    }

    public static void c(a r3, List<ShareItemModel> r4) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        jg5.e r0 = jg5.e.a.a;
        boolean r1 = ui5.b.a();
        IDocPublicPermission r2 = r3.m;
        if (r2 != null) goto L5;
    L11:
        boolean r5 = false;
    L13:
        if (r3.l == false) goto L15;
    L16:
        IDocUserPermission r6 = r3.n;
        if (r6 != null) goto L19;
        return;
    L19:
        if (r6.canManagePermissionMeta() == false) goto L28;
        if (r5 == false) goto L29;
        if (r1 == true) goto L23;
        return;
    L23:
        if (r3.o == true) goto L31;
        ShareItemUtil r7 = ShareItemUtil.a;
        ShareType r8 = ShareType.PasswordLink;
        ShareState r9 = ShareState.SHOW;
        r7.getClass();
        ArrayList r10 = (ArrayList) r4;
        r10.add(ShareItemUtil.a(r8, r9));
        return;
    L31:
        return;
    L29:
        return;
    L28:
        return;
    L15:
        if (r3.d == true) goto L16;
        return;
    L5:
        if (r2.getLinkShareAnyoneReadBlockValue() != 0) goto L7;
    L10:
        r5 = true;
        goto L13
    L7:
        if (r3.m.getLinkShareAnyoneReadBlockValue() == 3) goto L10;
        if (r3.m.getLinkShareAnyoneReadBlockValue() != 5) goto L11;
        goto L10
    }

    public static void d(List<ShareItemModel> r1, boolean r2) {
        if (r2 == false) goto L4;
        ShareState r0 = ShareState.SHOW;
    L5:
        e(r1, r2, r0);
        return;
    L4:
        r0 = ShareState.NOT_SHOW;
        goto L5
    }

    public static ShareState g(boolean r0, boolean r1) {
        if (r0 == false) goto L7;
        if (r1 == false) goto L9;
        return ShareState.SHOW;
    L9:
        return ShareState.NOT_CLICK;
    L7:
        return ShareState.ADMIN_NOT_CLICK;
    }

    public static void e(List<ShareItemModel> r2, boolean r3, ShareState r4) {
        if (r3 == false) goto L4;
        ShareState r5 = ShareState.SHOW;
    L5:
        ShareItemUtil r0 = ShareItemUtil.a;
        ShareType r1 = ShareType.Wechat;
        r0.getClass();
        ArrayList r6 = (ArrayList) r2;
        r6.add(ShareItemUtil.a(r1, r5));
        r6.add(ShareItemUtil.a(ShareType.WechatMoments, r4));
        r6.add(ShareItemUtil.a(ShareType.QQ, r5));
        r6.add(ShareItemUtil.a(ShareType.Weibo, r5));
        return;
    L4:
        r5 = ShareState.NOT_SHOW;
        goto L5
    }

    public static ShareState f(boolean r2, gj5.c r3, boolean r4, boolean r5, boolean r6) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.h() == false) goto L5;
        boolean r0 = r3.a;
        if (r0 == false) goto L9;
    L12:
        if (r6 == true) goto L14;
        if (r2 == false) goto L27;
        if (r5 == true) goto L27;
        if (r0 == false) goto L21;
        if (r4 == false) goto L21;
        return ShareState.SHOW;
    L21:
        if (r0 == true) goto L25;
        return ShareState.ADMIN_NOT_CLICK;
    L25:
        return ShareState.NOT_CLICK;
    L27:
        return ShareState.NOT_SHOW;
    L14:
        return ShareState.NOT_SHOW;
    L9:
        if (r3.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L12;
        return ShareState.CAC_NOT_CLICK;
    L5:
        return ShareState.NOT_SHOW;
    }
}
