package mi5;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.l0;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public h() {
    }

    public static void a(ShareParams r15, String r16, Context r17, Fragment r18, Long r19) {
        Intrinsics.checkNotNullParameter(r16, "ownerTenantId");
        Intrinsics.checkNotNullParameter(r17, "context");
        HashMap r5 = new HashMap();
        AccountService.Account r2 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        String r12 = "";
        if (r2 == null) goto L6;
        String r3 = r2.tenantId;
        if (r3 == null) goto L6;
    L7:
        if (r15 == null) goto L12;
        String r6 = r15.getToken();
        if (r6 == null) goto L12;
        String r13 = r6;
    L13:
        if (r15 == null) goto L15;
        int r7 = r15.getType();
    L16:
        int r14 = r7;
        r5.put(ResourceData.KEY_TOKEN, r13);
        r5.put("objType", Integer.valueOf(r14));
        if (r19 == null) goto L19;
        r5.put("objSubType", Long.valueOf(r19.longValue()));
    L19:
        if (r15 == null) goto L22;
        String r8 = r15.getRealToken();
        if (r8 == null) goto L22;
    L23:
        r5.put("realToken", r8);
        if (r15 == null) goto L26;
        int r9 = r15.getRealType();
    L27:
        r5.put("realType", Integer.valueOf(r9));
        r5.put("isSpaceV2", Boolean.TRUE);
        boolean r10 = false;
        if (r15 == null) goto L30;
        boolean r11 = r15.isWiki();
    L31:
        r5.put("isWikiV2", Boolean.valueOf(r11));
        r5.put("closeInsteadOfBack", Boolean.FALSE);
        if (ui5.c.b(((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2()) == false) goto L34;
    L35:
        r10 = true;
    L36:
        r5.put("isUserToC", Boolean.valueOf(r10));
        if (com.bytedance.ee.bear.middleground.permission.b.m() == false) goto L43;
        if (r15 == null) goto L41;
        String r20 = r15.getUrl();
        if (r20 == null) goto L41;
    L42:
        r5.put(ResourceData.KEY_URL, r20);
        r5.put("isOversea", Boolean.valueOf(!((b0) org.koin.java.a.c(b0.class, null, null, 6)).isChinaMainlandGeo()));
        r5.put("customPasswordEnable", Boolean.valueOf(com.bytedance.ee.bear.middleground.permission.b.b()));
        r5.put("appDisplayName", r17.getApplicationInfo().loadLabel(r17.getPackageManager()).toString());
        r5.put("isIpad", Boolean.valueOf(ku5.c.k(r17)));
    L41:
        r20 = "";
    L43:
        r5.put("tenantID", r3);
        r5.put("ownerTenantID", r16);
        r5.put("adminCanShareExternal", Boolean.valueOf(((com.bytedance.ee.bear.middleground_permission_export.model.b) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.b.class, null, null, 6)).a(r14, r13)));
        r5.put("hasLeader", Boolean.valueOf(ay4.b.d("account", 6).getBoolean("key_has_leader", true)));
        r5.put("dlpDialogUrl", fj5.a.a());
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        r5.put("leaderPermUrl", jg5.e.a.a.c());
        ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).c(r17, CCMLynxPageRouter.PageType.SHARE_PUBLIC_PERM_SET, new de5.a(l0.a().toString(), r5, null, null, null, r18, false, 92));
        if (r15 == null) goto L49;
        String r0 = r15.getModule();
        if (r0 == null) goto L49;
        r12 = r0;
    L49:
        PermissionAnalytic.q("click_file_perm_set_within", r13, r14, r12);
        com.bytedance.ee.bear.middleground.permission.c.V("set", "ccm_permission_set_view");
        return;
    L34:
        if (((k) org.koin.java.a.c(k.class, null, null, 6)).c() == false) goto L36;
    L30:
        r11 = false;
        goto L31
    L26:
        r9 = -1;
    L22:
        r8 = "";
        goto L23
    L15:
        r7 = sbb.e.g.b;
    L12:
        r13 = "";
    L6:
        r3 = "";
        goto L7
    }
}
