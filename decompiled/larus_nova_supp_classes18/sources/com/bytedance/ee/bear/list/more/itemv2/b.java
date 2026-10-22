package com.bytedance.ee.bear.list.more.itemv2;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.h;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.protocol3.checker.AdminChecker;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.more.protocol3.checker.UserPermissionChecker;
import com.bytedance.ee.bear.more.protocol3.f;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.j;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends g {
    public long c;
    public final long d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.more.itemv2.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0023b implements View.OnClickListener {
        public final /* synthetic */ b a;

        public ViewOnClickListenerC0023b(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r22) {
            b r1 = this.a;
            oj5.c r2 = r1.c();
            if (r2 == null) goto L22;
            ImportFileEntity r3 = new ImportFileEntity(r2.getToken(), r2.getTitle());
            ((h) org.koin.java.a.c(h.class, null, null, 6)).m0(r3);
            oj5.c r4 = r1.c();
            if (r4 == null) goto L20;
            int r5 = r1.k();
            if (r5 != 102) goto L11;
            String r6 = DocumentType.SHEET_NAME;
        L15:
            String r15 = r6;
            com.bytedance.ee.bear.more.b r7 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
            Bundle r8 = r1.getHost().getHostFragment().getArguments();
            String r9 = r4.getToken();
            int r10 = r4.getType();
            String r11 = r4.b();
            if (r4.getType() != sbb.e.n.b) goto L18;
            boolean r16 = true;
        L19:
            r7.c(new i(r8, r9, r10, false, r11, "convert_to_online", "ccm_docs_page_view", "", r15, r16, false, r4.H(), r4.isOwner(), r4.L()));
            goto L20
        L18:
            r16 = false;
            goto L19
        L11:
            if (r5 == 103) goto L13;
            r6 = DocumentType.DOC_NAME;
            goto L15
        L13:
            r6 = DocumentType.MINDNOTE_NAME;
        L20:
            r1.getHost().a();
            return;
        }
    }

    public static final class c extends t {
        public final /* synthetic */ b c;

        public c(b r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r8) {
            oj5.c r9 = this.c.c();
            if (r9 != null) goto L5;
            return;
        L5:
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L8;
            PermissionResponse r10 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).f(r9, "CREATE_COPY");
            ph5.e r0 = r10.getCallback();
            Application r1 = eu5.b.a;
            Intrinsics.checkNotNull(r10);
            r0.a(r1, r10);
            return;
        L8:
            gj5.b r2 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
            FileBizDomain r3 = FileBizDomain.FileBizDomainCCM;
            gj5.c r4 = r2.g("CCM_CREATE_COPY", r3, r9.getType(), r9.getToken());
            if (r4.a == false) goto L11;
            return;
        L11:
            FileAuthResultFrom r5 = r4.b;
            if (r5 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L15;
            Toast.showFailureText(eu5.b.a, 2131887246);
            return;
        L15:
            if (r5 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L20;
            ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CREATE_COPY", r3, r9.getType(), r9.getToken());
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            long r0 = ((Number) r4).longValue();
            tt5.a.h("ImportAsItem", "pullFileSize ok: " + r0);
            b r5 = this.a;
            r5.c = r0;
            r5.j();
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            tt5.a.e("ImportAsItem", "pullFileSize err", (Throwable) r4, false);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final k a() {
        oj5.a r0 = (oj5.a) d(oj5.a.class);
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = k();
        if (r1 != 102) goto L9;
        int r2 = 2131887762;
    L13:
        f.t r3 = new f.t(r2);
        ViewOnClickListenerC0023b r6 = new ViewOnClickListenerC0023b(this);
        j[] r4 = new j[3];
        boolean r7 = true;
        r4[0] = new com.bytedance.ee.bear.more.protocol3.checker.b(new sbb.e[]{sbb.e.l});
        if (k() == 0) goto L16;
        boolean r8 = true;
    L17:
        r4[1] = new BizChecker(r8);
        k();
        r4[2] = new com.bytedance.ee.bear.more.protocol3.checker.a("import_as");
        List r5 = CollectionsKt.listOf(r4);
        j[] r9 = new j[5];
        AdminChecker r10 = new AdminChecker(AdminChecker.AdminPermissionType.CreateCopy);
        r10.d = new c(this);
        String r11 = "";
        Intrinsics.checkNotNullParameter("", "disableReason");
        r10.b = "";
        r9[0] = r10;
        if (r0.p == true) goto L20;
    L23:
        boolean r12 = true;
    L24:
        r9[1] = new BizChecker(r12);
        UserPermissionChecker r13 = new UserPermissionChecker(UserPermissionChecker.UserPermissionType.CanSecretCopy);
        r13.c = 2131889702;
        r9[2] = r13;
        UserPermissionChecker r14 = new UserPermissionChecker(UserPermissionChecker.UserPermissionType.CanCreateCopy);
        r14.c = 2131887763;
        r9[3] = r14;
        if (this.c == Long.MAX_VALUE) goto L28;
        r11 = xo5.a.c(eu5.b.a, 2131889340, SheetInputData.InputData.FormatType.NUMBER, ((Integer) com.bytedance.ee.bear.appsetting.c.a.a.d("drive_convert_file_size_limit", 20)).toString());
    L28:
        Intrinsics.checkNotNull(r11);
        if (this.c < this.d) goto L32;
        r7 = false;
    L32:
        r9[4] = new BizChecker(r11, r7);
        return g.i(this, r3, null, r5, CollectionsKt.listOf(r9), r6, 2);
    L20:
        if (r0.q == false) goto L23;
        r12 = false;
        goto L24
    L16:
        r8 = false;
        goto L17
    L9:
        if (r1 == 103) goto L11;
        r2 = 2131887760;
        goto L13
    L11:
        r2 = 2131887761;
        goto L13
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public final void create() {
        oj5.a r0 = (oj5.a) d(oj5.a.class);
        if (r0 != null) goto L6;
        return;
    L6:
        if (k() == 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L16;
        com.bytedance.ee.bear.more.protocol3.h r3 = null;
        Disposable r2 = ((h) org.koin.java.a.c(h.class, null, null, 6)).P5(r0.c, r0.u).subscribe(new d(this), e.a);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        com.bytedance.ee.bear.more.protocol3.h r4 = this.a;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
    L14:
        r3.h.add(r2);
        return;
    L13:
        r3 = r4;
        goto L14
    L16:
        return;
    L8:
        r1 = false;
        goto L9
    }

    public final int k() {
        String r1 = null;
        pw4.f r0 = (pw4.f) org.koin.java.a.c(pw4.f.class, null, null, 6);
        oj5.c r2 = c();
        if (r2 == null) goto L6;
        r1 = r2.getTitle();
    L6:
        return r0.getImportType(r1);
    }

    public b() {
        this.c = Long.MAX_VALUE;
        this.d = (((Number) com.bytedance.ee.bear.appsetting.c.a.a.d("drive_convert_file_size_limit", 20)).longValue() * 1024) * 1024;
    }
}
