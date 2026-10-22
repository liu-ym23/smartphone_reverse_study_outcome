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

/* JADX INFO: loaded from: classes18.dex */
public final class b {
    public static boolean h() {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        return jg5.e.a.f499003a.h();
    }

    public static void a(List<ShareItemModel> r100) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.f499003a.h() == false) goto L6;
        ShareItemUtil r101 = ShareItemUtil.f216536a;
        ShareType r102 = ShareType.CopyLink;
        ShareState r103 = ShareState.SHOW;
        r101.getClass();
        ArrayList r104 = (ArrayList) r100;
        r104.add(ShareItemUtil.a(r102, r103));
        return;
    }

    public static void b(List<ShareItemModel> r100) {
        ShareItemUtil r101 = ShareItemUtil.f216536a;
        ShareType r102 = ShareType.Lark;
        if (AppInfoUtils.e().booleanValue() == false) goto L5;
        ShareState r103 = ShareState.NOT_SHOW;
    L6:
        r101.getClass();
        ArrayList r104 = (ArrayList) r100;
        r104.add(ShareItemUtil.a(r102, r103));
        return;
    L5:
        r103 = ShareState.SHOW;
        goto L6
    }

    public static void c(a r100, List<ShareItemModel> r101) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        jg5.e r102 = jg5.e.a.f499003a;
        boolean r103 = ui5.b.a();
        IDocPublicPermission r104 = r100.f504077m;
        if (r104 != null) goto L5;
    L11:
        boolean r105 = false;
    L13:
        if (r100.f504076l == false) goto L15;
    L16:
        IDocUserPermission r106 = r100.f504078n;
        if (r106 != null) goto L19;
        return;
    L19:
        if (r106.canManagePermissionMeta() == false) goto L28;
        if (r105 == false) goto L29;
        if (r103 == true) goto L23;
        return;
    L23:
        if (r100.f504079o == true) goto L31;
        ShareItemUtil r107 = ShareItemUtil.f216536a;
        ShareType r108 = ShareType.PasswordLink;
        ShareState r109 = ShareState.SHOW;
        r107.getClass();
        ArrayList r110 = (ArrayList) r101;
        r110.add(ShareItemUtil.a(r108, r109));
        return;
    L31:
        return;
    L29:
        return;
    L28:
        return;
    L15:
        if (r100.f504068d == true) goto L16;
        return;
    L5:
        if (r104.getLinkShareAnyoneReadBlockValue() != 0) goto L7;
    L10:
        r105 = true;
        goto L13
    L7:
        if (r100.f504077m.getLinkShareAnyoneReadBlockValue() == 3) goto L10;
        if (r100.f504077m.getLinkShareAnyoneReadBlockValue() != 5) goto L11;
        goto L10
    }

    public static void d(List<ShareItemModel> r100, boolean r101) {
        if (r101 == false) goto L4;
        ShareState r102 = ShareState.SHOW;
    L5:
        e(r100, r101, r102);
        return;
    L4:
        r102 = ShareState.NOT_SHOW;
        goto L5
    }

    public static ShareState g(boolean r100, boolean r101) {
        if (r100 == false) goto L7;
        if (r101 == false) goto L9;
        return ShareState.SHOW;
    L9:
        return ShareState.NOT_CLICK;
    L7:
        return ShareState.ADMIN_NOT_CLICK;
    }

    public static void e(List<ShareItemModel> r100, boolean r101, ShareState r102) {
        if (r101 == false) goto L4;
        ShareState r103 = ShareState.SHOW;
    L5:
        ShareItemUtil r104 = ShareItemUtil.f216536a;
        ShareType r105 = ShareType.Wechat;
        r104.getClass();
        ArrayList r106 = (ArrayList) r100;
        r106.add(ShareItemUtil.a(r105, r103));
        r106.add(ShareItemUtil.a(ShareType.WechatMoments, r102));
        r106.add(ShareItemUtil.a(ShareType.QQ, r103));
        r106.add(ShareItemUtil.a(ShareType.Weibo, r103));
        return;
    L4:
        r103 = ShareState.NOT_SHOW;
        goto L5
    }

    public static ShareState f(boolean r100, gj5.c r101, boolean r102, boolean r103, boolean r104) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.f499003a.h() == false) goto L5;
        boolean r105 = r101.f481503a;
        if (r105 == false) goto L9;
    L12:
        if (r104 == true) goto L14;
        if (r100 == false) goto L27;
        if (r103 == true) goto L27;
        if (r105 == false) goto L21;
        if (r102 == false) goto L21;
        return ShareState.SHOW;
    L21:
        if (r105 == true) goto L25;
        return ShareState.ADMIN_NOT_CLICK;
    L25:
        return ShareState.NOT_CLICK;
    L27:
        return ShareState.NOT_SHOW;
    L14:
        return ShareState.NOT_SHOW;
    L9:
        if (r101.f481504b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L12;
        return ShareState.CAC_NOT_CLICK;
    L5:
        return ShareState.NOT_SHOW;
    }
}
