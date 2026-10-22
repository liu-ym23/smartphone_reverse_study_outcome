package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.protocol3.checker.AdminChecker;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n1 extends com.bytedance.ee.bear.more.protocol3.g {
    public final /* synthetic */ WikiTreeMoreProvider c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ n1 a;
        public final /* synthetic */ WikiTreeMoreProvider b;

        public a(n1 r1, WikiTreeMoreProvider r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.getHost().a();
            WikiTreeMoreProvider r3 = this.b;
            WikiDialogs.b r0 = r3.r;
            if (r0 == null) goto L6;
            r0.b(r3.o);
            return;
        }
    }

    public static final class b extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ WikiTreeMoreProvider c;

        public b(WikiTreeMoreProvider r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r7) {
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L6;
            PermissionResponse r8 = WikiTreeMoreProvider.m(this.c, "CREATE_COPY");
            r8.getCallback().a(eu5.b.a, r8);
            PermissionResponse.Companion.getClass();
            PermissionResponse.a.d(r8);
            return;
        L6:
            gj5.b r9 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
            FileBizDomain r2 = FileBizDomain.FileBizDomainCCM;
            TreeNode r3 = this.c.m;
            gj5.c r10 = r9.g("CCM_CREATE_COPY", r2, r3.obj_type, r3.obj_token);
            if (r10.a == false) goto L9;
            return;
        L9:
            FileAuthResultFrom r11 = r10.b;
            if (r11 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L13;
            Toast.showFailureText(eu5.b.a, 2131887246);
            return;
        L13:
            if (r11 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L17;
            gj5.b r12 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
            TreeNode r0 = this.c.m;
            r12.c("CCM_CREATE_COPY", r2, r0.obj_type, r0.obj_token);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        com.bytedance.ee.bear.more.protocol3.f.u r1 = com.bytedance.ee.bear.more.protocol3.f.u.c;
        WikiTreeMoreProvider r0 = this.c;
        a r5 = new a(this, r0);
        List r3 = CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.j[]{new BizChecker(!r0.m.getOriginIsDeleted()), new com.bytedance.ee.bear.more.protocol3.checker.a(r1.a)});
        AdminChecker r2 = new AdminChecker(AdminChecker.AdminPermissionType.CreateCopy);
        r2.d = new b(this.c);
        Intrinsics.checkNotNullParameter("", "disableReason");
        r2.b = "";
        WikiTreeMoreProvider r6 = this.c;
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r1, null, r3, CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.j[]{new com.bytedance.ee.bear.more.protocol3.checker.d(), r2, new WikiTreeMoreProvider.b(r6.n.getOriginCanClone(r6.m.isShortcut()))}), r5, 2);
    }

    public n1(WikiTreeMoreProvider r1) {
        this.c = r1;
    }
}
