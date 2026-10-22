package yp5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.creationmenu.SelectIndex;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectPanelDialog;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import td5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static void b(final FragmentActivity r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        tt5.a.h("WikiTitleExecutor", "startAddWiki");
        gq5.d.k("create", "ccm_wiki_create_new_view");
        JSONObject r0 = new JSONObject();
        gq5.d.a(r0, null, null, null, null, null, "wiki_home", null, 95);
        gq5.e.c("ccm_wiki_create_new_view", r0);
        boolean r4 = j.a.a.getNetworkState().a();
        WikiCreateSelectPanelDialog.b r2 = new d(r11);
        int r1 = WikiCreateSelectPanelDialog.m;
        Intrinsics.checkNotNullParameter(r11, "context");
        WikiCreateSelectPanelDialog.a.a(r11, r2, null, r4, null, null);
    }

    public static void a(FragmentActivity r9, int r10) {
        if (r10 >= 0) goto L4;
    L21:
        gq5.c.b("add_page", "navigation_bar", r10, -1, -1);
        WikiSelectorBean r8 = new WikiSelectorBean();
        r8.m = r10;
        r8.o = true;
        SelectorConfig r5 = new SelectorConfig();
        r5.c(SelectorType.WIKI_CREATE_TO);
        r5.d = true;
        r5.b(r9.getString(2131889798));
        r5.g = DocUserPermission.USER_PERM_FULL_ACCESS;
        f r6 = new f();
        r6.a = 1;
        r6.b = Integer.valueOf(r10);
        r6.c = "wiki_home";
        r6.e = Integer.valueOf(DocUserPermission.USER_PERM_FULL_ACCESS);
        ((com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.f.class)).c(r9, r5, r6, null, r8);
        return;
    L4:
        if (r10 >= SelectIndex.values().length) goto L21;
        SelectIndex r0 = SelectIndex.values()[r10];
        if (r0 != SelectIndex.FILE) goto L8;
    L9:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L14;
        BaseEntity r1 = new BaseEntity("", sbb.e.l, BizDomain.FileBizDomainCCM, "");
        PermissionResponse r2 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r1, "UPLOAD"), null);
        r2.getCallback().a(r9, r2);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r2) == false) goto L21;
        return;
    L14:
        gj5.b r3 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r4 = FileBizDomain.FileBizDomainCCM;
        gj5.c r7 = r3.g("CCM_FILE_UPLOAD", r4, 12, "");
        if (r7.a == true) goto L21;
        if (FileAuthResultFrom.COME_FROM_FILE_POLICY != r7.b) goto L19;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_FILE_UPLOAD", r4, 12, "");
        return;
    L19:
        Toast.showText(r9, 2131887246);
        return;
    L8:
        if (r0 != SelectIndex.MEDIA) goto L21;
        goto L9
    }
}
