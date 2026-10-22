package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f237093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShareFolderInfo f237094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShareParams f237095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f237096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Disposable, Unit> f237097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f237098f;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if (com.bytedance.ee.bear.middleground.permission.b.m() == true) goto L5;
    L7:
        boolean r100 = false;
    L9:
        if (r100 == true) goto L12;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...feature disabled");
        return false;
    L12:
        ShareFolderInfo r101 = this.f237094b;
        if (r101 != null) goto L16;
        return false;
    L16:
        if (r101.e() == true) goto L19;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...folder not supported");
        return false;
    L19:
        IFolderPublicPermission r102 = r101.f234260i.f234426b;
        if (r102.isLinkShareAnyoneRead() == false) goto L24;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...already anyone read");
        return true;
    L24:
        if (r102.adminCanCross() == true) goto L27;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...admin cannot cross");
        Toast.showFailureText(this.f237093a, R.string.CreationMobile_ECM_AdminDisableToast);
        return false;
    L27:
        int r103 = r102.getLinkShareAnyoneReadBlockValue();
        if (r103 == 0) goto L37;
        if (r103 != 1) goto L31;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...blocked by container");
        Toast.showFailureText(this.f237093a, R.string.CreationMobile_ECM_Permission_SpaceAdmin_tooltips);
    L38:
        return false;
    L31:
        if (r103 == 3) goto L37;
        if (r103 == 5) goto L35;
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...blocked by admin");
        Toast.showFailureText(this.f237093a, R.string.CreationMobile_ECM_AdminDisableToast);
        goto L38
    L35:
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...blocked by sec level");
        Toast.showFailureText(this.f237093a, R.string.CreationMobile_SecureLabel_PermSettings_RestrictedSelect);
    L37:
        tt5.a.h("OpenFolderPasswordLinkHandler", "[perm-password-support] canOpenPasswordLink()...show safe tips, block=" + r102.getLinkShareAnyoneReadBlockValue());
        cj5.c r104 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        Context r105 = this.f237093a;
        int r106 = r101.getType();
        String r107 = r101.f234254c;
        String r108 = this.f237095c.getSubType();
        boolean r109 = this.f237095c.isWiki();
        i r110 = new i(this, r101);
        j r111 = j.f237101a;
        Integer r112 = Integer.valueOf(SceneType.PASSWORD_SHARE.getValue());
        int r113 = n.f237111a;
        r104.le(r105, r106, r107, r108, r109, true, "from_share", r110, r111, r112, n.d(this.f237093a, 0));
        goto L38
    L5:
        if (ui5.b.b() == false) goto L7;
        r100 = true;
        goto L9
    }

    public final void b(ShareFolderInfo r100) {
        IFolderPublicPermission r101 = r100.f234260i.f234426b;
        boolean r102 = false;
        if (r101.hasLinkPassword() == true) goto L5;
    L10:
        StringBuilder r103 = new StringBuilder("[perm-password-support] openPasswordLinkPage()...hasLinkPassword=");
        r103.append(r102);
        r103.append(" openPasswordShare=");
        boolean r104 = !r102;
        r103.append(r104);
        tt5.a.h("OpenFolderPasswordLinkHandler", r103.toString());
        cj5.c.b r105 = new cj5.c.b();
        r105.f23970a = this.f237096d;
        r105.f23971b = r100.f234254c;
        r105.f23972c = r100.getType();
        r105.f23973d = this.f237095c.getRealToken();
        r105.f23974e = this.f237095c.getRealType();
        r105.f23975f = this.f237095c.isWiki();
        r105.f23976g = r100.b();
        r105.f23977h = true;
        r105.f23978i = r104;
        r105.f23979j = true;
        r105.f23981l = r100.f234260i.f234426b.getOwnerTenantName();
        cj5.c r106 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        Context r107 = this.f237093a;
        HashMap<String, Serializable> r108 = new HashMap();
        r108.put("file_id", du5.b.g(r100.f234254c));
        r108.put("file_type", sbb.e.f(r100.getType()));
        r108.put("app_form", "none");
        r108.put("sub_file_type", Integer.valueOf(r100.getType()));
        r108.put(EventConstant.Key.MODULE, this.f237095c.getModule());
        r108.put("user_permission_folder", r100.f234260i.f234425a.getReportJson());
        r108.put("folder_permission", r100.f234260i.f234426b.reportJson());
        if (r100.isOwner() == false) goto L13;
        String r109 = "true";
    L14:
        r108.put("is_owner", r109);
        r106.rb(r107, r105, r108, null);
        return;
    L13:
        r109 = "false";
        goto L14
    L5:
        if (r101.linkPassword().length() <= 0) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == false) goto L10;
        r102 = true;
        goto L10
    L7:
        r110 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Context r100, ShareFolderInfo r101, ShareParams r102, String r103, Function1<? super Disposable, Unit> r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "url");
        this.f237093a = r100;
        this.f237094b = r101;
        this.f237095c = r102;
        this.f237096d = r103;
        this.f237097e = r104;
        this.f237098f = r105;
    }
}
