package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public final Context a;
    public final ShareFolderInfo b;
    public final ShareParams c;
    public final String d;
    public final Function1<Disposable, Unit> e;
    public final Function0<Unit> f;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if (com.bytedance.ee.bear.middleground.permission.b.m() == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L12;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...feature disabled");
        return false;
    L12:
        ShareFolderInfo r1 = this.b;
        if (r1 != null) goto L16;
        return false;
    L16:
        if (r1.e() == true) goto L19;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...folder not supported");
        return false;
    L19:
        IFolderPublicPermission r4 = r1.i.b;
        if (r4.isLinkShareAnyoneRead() == false) goto L24;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...already anyone read");
        return true;
    L24:
        if (r4.adminCanCross() == true) goto L27;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...admin cannot cross");
        Toast.showFailureText(this.a, 2131887246);
        return false;
    L27:
        int r5 = r4.getLinkShareAnyoneReadBlockValue();
        if (r5 == 0) goto L37;
        if (r5 != 1) goto L31;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...blocked by container");
        Toast.showFailureText(this.a, 2131887282);
    L38:
        return false;
    L31:
        if (r5 == 3) goto L37;
        if (r5 == 5) goto L35;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...blocked by admin");
        Toast.showFailureText(this.a, 2131887246);
        goto L38
    L35:
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...blocked by sec level");
        Toast.showFailureText(this.a, 2131887387);
    L37:
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...show safe tips, block=" + r4.getLinkShareAnyoneReadBlockValue());
        cj5.c r3 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        Context r6 = this.a;
        int r7 = r1.getType();
        String r8 = r1.c;
        String r9 = this.c.getSubType();
        boolean r10 = this.c.isWiki();
        i r11 = new i(this, r1);
        j r12 = j.a;
        Integer r13 = Integer.valueOf(SceneType.PASSWORD_SHARE.getValue());
        int r2 = n.a;
        r3.le(r6, r7, r8, r9, r10, true, "from_share", r11, r12, r13, n.d(this.a, 0));
        goto L38
    L5:
        if (ui5.b.b() == false) goto L7;
        r0 = true;
        goto L9
    }

    public final void b(ShareFolderInfo r8) {
        IFolderPublicPermission r0 = r8.i.b;
        boolean r2 = false;
        if (r0.hasLinkPassword() == true) goto L5;
    L10:
        StringBuilder r1 = new StringBuilder("[perm-password-support] openPasswordLinkPage()...hasLinkPassword=");
        r1.append(r2);
        r1.append(" openPasswordShare=");
        boolean r3 = !r2;
        r1.append(r3);
        tt5.a.h("OpenFolderPasswordLinkHandler", r1.toString());
        cj5.c.b r4 = new cj5.c.b();
        r4.a = this.d;
        r4.b = r8.c;
        r4.c = r8.getType();
        r4.d = this.c.getRealToken();
        r4.e = this.c.getRealType();
        r4.f = this.c.isWiki();
        r4.g = r8.b();
        r4.h = true;
        r4.i = r3;
        r4.j = true;
        r4.l = r8.i.b.getOwnerTenantName();
        cj5.c r5 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        Context r6 = this.a;
        HashMap<String, Serializable> r7 = new HashMap();
        r7.put("file_id", du5.b.g(r8.c));
        r7.put("file_type", sbb.e.f(r8.getType()));
        r7.put("app_form", "none");
        r7.put("sub_file_type", Integer.valueOf(r8.getType()));
        r7.put("module", this.c.getModule());
        r7.put("user_permission_folder", r8.i.a.getReportJson());
        r7.put("folder_permission", r8.i.b.reportJson());
        if (r8.isOwner() == false) goto L13;
        String r9 = "true";
    L14:
        r7.put("is_owner", r9);
        r5.rb(r6, r4, r7, null);
        return;
    L13:
        r9 = "false";
        goto L14
    L5:
        if (r0.linkPassword().length() <= 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L10;
        r2 = true;
        goto L10
    L7:
        r10 = false;
        goto L8
    }

    public h(Context r2, ShareFolderInfo r3, ShareParams r4, String r5, Function1<? super Disposable, Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_URL);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
