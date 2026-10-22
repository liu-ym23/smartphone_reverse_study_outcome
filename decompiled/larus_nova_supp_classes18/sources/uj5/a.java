package uj5;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.l0;
import java.util.HashMap;
import jg5.e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ku5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: uj5.a$a, reason: collision with other inner class name */
    public static final class C0316a {
        @JvmStatic
        public static void a(Context r16, b r17, h0 r18, Fragment r19, boolean r20) {
            Intrinsics.checkNotNullParameter(r16, "context");
            Intrinsics.checkNotNullParameter(r17, "settingParams");
            Intrinsics.checkNotNullParameter(r18, "accountService");
            AccountService.Account r2 = r18.G2();
            if (r2 == null) goto L5;
            String r5 = r2.tenantId;
        L6:
            String r6 = "";
            if (r5 == null) goto L9;
            String r3 = r2.tenantId;
        L10:
            HashMap r9 = new HashMap();
            r9.put(ResourceData.KEY_TOKEN, r17.a);
            r9.put("objType", Integer.valueOf(r17.b));
            r9.put("isSpaceV2", Boolean.valueOf(r17.c));
            r9.put("isWikiV2", Boolean.valueOf(r17.d));
            r9.put("closeInsteadOfBack", Boolean.FALSE);
            AccountService.Account r4 = r18.G2();
            if (r4 != null) goto L13;
        L18:
            boolean r7 = true;
        L19:
            r9.put("isUserToC", Boolean.valueOf(r7));
            if (com.bytedance.ee.bear.middleground.permission.b.m() == false) goto L22;
            r9.put(ResourceData.KEY_URL, r17.n);
            r9.put("isOversea", Boolean.valueOf(!((b0) org.koin.java.a.c(b0.class, null, null, 6)).isChinaMainlandGeo()));
            r9.put("customPasswordEnable", Boolean.valueOf(com.bytedance.ee.bear.middleground.permission.b.b()));
            r9.put("appDisplayName", r16.getApplicationInfo().loadLabel(r16.getPackageManager()).toString());
            r9.put("isIpad", Boolean.valueOf(c.k(r16)));
        L22:
            if (r3 == null) goto L25;
            r6 = r3;
        L25:
            r9.put("tenantID", r6);
            r9.put("ownerTenantID", r17.e);
            r9.put("hasLeader", Boolean.valueOf(r17.m));
            String r8 = r17.a;
            r9.put("adminCanShareExternal", Boolean.valueOf(((com.bytedance.ee.bear.middleground_permission_export.model.b) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.b.class, null, null, 6)).a(r17.b, r8)));
            r9.put("dlpDialogUrl", fj5.a.a());
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            r9.put("leaderPermUrl", e.a.a.c());
            r9.put("file_id", du5.b.g(r17.a));
            r9.put("file_type", sbb.e.f(r17.b));
            if (r17.f == false) goto L28;
            String r10 = ThumbGlideUrl.SOURCE_VC;
        L29:
            r9.put("app_form", r10);
            r9.put("sub_file_type", r17.g);
            r9.put("module", r17.h);
            r9.put("sub_module", r17.i);
            r9.put("user_permission", r17.j);
            r9.put("file_permission", r17.k);
            r9.put("is_owner", Boolean.valueOf(r17.l));
            ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).c(r16, CCMLynxPageRouter.PageType.SHARE_PUBLIC_PERM_SET, new de5.a(l0.a().toString(), r9, null, null, null, r19, r20, 28));
            return;
        L28:
            r10 = "none";
            goto L29
        L13:
            if (r4.isConsumer() == true) goto L18;
            if (((k) org.koin.java.a.c(k.class, null, null, 6)).c() == true) goto L18;
            r7 = false;
            goto L19
        L9:
            r3 = "";
            goto L10
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }
}
