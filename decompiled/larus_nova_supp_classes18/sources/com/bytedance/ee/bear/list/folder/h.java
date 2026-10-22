package com.bytedance.ee.bear.list.folder;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.e0;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.s;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.v0;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.DocReportPubParam;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.ui.m;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import dd5.h1;
import dd5.i1;
import dd5.k1;
import dd5.r1;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lc5.p;
import lc5.q;
import mc5.j;
import uc5.d1;
import uc5.d2;
import uc5.f4;
import uc5.g4;
import uc5.h2;
import uc5.j4;
import uc5.k4;
import uc5.l4;
import uc5.m4;
import uc5.n4;
import uc5.o4;
import uc5.p4;
import uc5.q4;
import uc5.r4;
import uc5.s4;
import uc5.t4;
import uc5.u4;
import uc5.v4;
import uc5.w4;
import uc5.y3;
import uc5.z3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends com.bytedance.ee.bear.list.list.b<h2, e, e.a> implements i1, h1, r1, k1, e.a {
    public final String A;
    public Document B;
    public ShareFolderUserPermission C;
    public boolean D;
    public final d2 E;
    public final String y;
    public final int z;

    public static final class a implements Runnable {
        public final WeakReference<h> a;
        public final ce5.a b;

        public final void a() {
            if (this.a.get() != null) goto L6;
            tt5.a.h("SubFolderPresenter", "DeleteCacheRunnable()...presenterRef.get() = null");
            return;
        L6:
            String r0 = this.a.get().y;
            ((j) this.b.a(j.class)).a2(4, r0);
            ((j) this.b.a(j.class)).L1(r0);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(h r2, ce5.a r3) {
            this.a = new WeakReference(r2);
            this.b = r3;
        }
    }

    public static class b implements c0.a {
        public final WeakReference<h> a;

        public final void c() {
        }

        public final void a() {
            tt5.a.h("SubFolderPresenter", "DeleteDocCallback#onPostExecuteSuccess()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("SubFolderPresenter", "DeleteDocCallback#onPostExecuteSuccess()...presenterRef = null");
            return;
        L6:
            m.a(new s4(this));
        }

        public b(h r2) {
            this.a = new WeakReference(r2);
        }

        public final void b(boolean r3) {
            tt5.a.h("SubFolderPresenter", "DeleteDocCallback#onOfflinePostExecute()...success = " + r3);
            if (this.a.get() != null) goto L6;
            tt5.a.h("SubFolderPresenter", "DeleteDocCallback#onOfflinePostExecute()...presenterRef = null");
            return;
        L6:
            m.a(new u4(this));
        }

        public final void d(final int r1, Throwable r2, String r3, int r4) {
            tt5.a.h("SubFolderPresenter", "DeleteDocCallback#onPostExecuteFail()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("SubFolderPresenter", "DeleteDocCallback#onPostExecuteFail()...presenterRef = null");
            return;
        L6:
            m.a(new t4(this, r1));
        }
    }

    public static class c implements s.c {
        public final WeakReference<h> a;

        public c(h r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.list.s.c
        public final void a(DocumentListInfo r4) {
            tt5.a.h("SubFolderPresenter", "DeleteOnlineItemCallback onAuthorityFail()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("SubFolderPresenter", "DeleteOnlineItemCallback#onAuthorityFail()...presenterRef = null");
            return;
        L6:
            h r0 = this.a.get();
            ((e) r0.getView()).s6(false);
            com.bytedance.ee.bear.list.folder.a.C0014a r1 = new com.bytedance.ee.bear.list.folder.a.C0014a();
            com.bytedance.ee.bear.list.folder.a.b r2 = r1.a;
            r2.a = r4;
            r2.b = new v4();
            r2.c = new w4();
            com.bytedance.ee.bear.list.folder.a r5 = r1.a(r0.a, r0.r);
            if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L13;
            DialogLancet.handleBlockedDialogShow(r5);
            return;
        L13:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            DialogLancet.beforeDialogShow(r5);
            r5.show();
            DialogLancet.afterDialogShow(r5);
        }

        @Override // com.bytedance.ee.bear.list.s.c
        public final void onSuccess(String r6) {
            tt5.a.h("SubFolderPresenter", "DeleteOnlineItemCallback onSuccess()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("SubFolderPresenter", "DeleteOnlineItemCallback#onSuccess()...presenterRef = null");
            return;
        L6:
            h r0 = this.a.get();
            ((h2) r0.getModel()).c(r6);
            ((e) r0.getView()).s6(false);
            r0.f9();
            Context r1 = r0.a;
            if (AppInfoUtils.f().booleanValue() == false) goto L9;
            String r3 = r0.h9(1);
        L10:
            Toast.showSuccessText(r1, r3, 0);
            if (TextUtils.equals(r0.y, r6) == false) goto L13;
            r0.E.finish();
        L13:
            r0.i9();
            return;
        L9:
            r3 = r0.a.getResources().getString(2131887742);
            goto L10
        }

        @Override // com.bytedance.ee.bear.list.s.c
        public final void b(String r7, int r8, Throwable r9) {
            tt5.a.h("SubFolderPresenter", "DeleteOnlineItemCallback#onFail()...throwable = " + r9.getMessage());
            if (this.a.get() != null) goto L6;
            tt5.a.h("SubFolderPresenter", "DeleteOnlineItemCallback#onFail()...presenterRef = null");
            return;
        L6:
            h r0 = this.a.get();
            ((e) r0.getView()).s6(false);
            if (com.bytedance.ee.bear.list.v4.a(r0.a, ax4.d.a(r9)) == false) goto L10;
            return;
        L10:
            if (k0.c(r9) == false) goto L13;
            return;
        L13:
            if ((r9 instanceof NetService.ServerErrorException) == false) goto L15;
            String r1 = ((NetService.ServerErrorException) r9).getData();
        L16:
            ErrorResponse r3 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).e(r7, Integer.valueOf(r8), "DELETE_ENTITY", r9);
            if (r3.getHasHandledUiAction() == false) goto L21;
            r3.getCallback().a(r0.a, r3);
            return;
        L21:
            if (ax4.d.b(r9, 4202) == false) goto L24;
            Toast.showFailureText(r0.a, 2131887146);
            return;
        L24:
            if (ax4.d.b(r9, 4) == false) goto L27;
            Context r10 = r0.a;
            Toast.showFailureText(r10, r10.getResources().getString(2131887803), 0);
            return;
        L27:
            if (ax4.d.b(r9, 233525003) == false) goto L29;
            com.bytedance.ee.bear.list.applydelete.a.a(r0.b.getChildFragmentManager(), r1, r7, r8);
            return;
        L29:
            Context r11 = r0.a;
            Toast.showFailureText(r11, r11.getResources().getString(2131887737), 0);
            return;
        L15:
            r1 = "";
            goto L16
        }
    }

    public static final class d implements Runnable {
        public final WeakReference<h> a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (this.a.get() != null) goto L5;
            tt5.a.h("SubFolderPresenter", "InputPasswordCallback()...presenterRef.get() = null");     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            tt5.a.h("SubFolderPresenter", "InputPasswordCallback()...success");     // Catch: Throwable -> L7
            this.a.get().onRefresh();     // Catch: Throwable -> L7
            goto L12
        }

        public d(h r2) {
            this.a = new WeakReference(r2);
        }
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "SubFolderPresenter";
    }

    public final void B6() {
        ((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class)).b(this.a);
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String J8() {
        if (this.D == false) goto L6;
        return "personal_subfolder";
    L6:
        return "shared_subfolder";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String K8() {
        if ("favorites".equals(this.A) == false) goto L7;
        return AnalyticConstant.OpenType.FAVORITES.getType();
    L7:
        if (this.D == false) goto L11;
        return AnalyticConstant.OpenType.PERSONAL_FOLDER.getType();
    L11:
        return AnalyticConstant.OpenType.SHARED_SHARED_FOLDER.getType();
    }

    public final void e9() {
        tt5.a.h("SubFolderPresenter", "deleteFolderInDB()...");
        fo5.d.b().scheduleDirect(new a(this, this.x), 500, TimeUnit.MILLISECONDS);
    }

    public final void f5() {
        ce5.a r0 = this.x;
        if (r0 != null) goto L5;
    L8:
        t0.J(this.B, this.b);
        return;
    L5:
        if (r0.d.isEnable("ccm.platform.appeal_v2") == false) goto L8;
        com.bytedance.ee.bear.route.h r1 = this.x.e;
        com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a r2 = (com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class);
        Document r3 = this.B;
        r1.u5(r2.a(r3.d, r3.getType(), false));
    }

    public final void g9() {
        if (this.B.Q1 == false) goto L5;
        Disposable r0 = ((h2) getModel()).p0().subscribe(new p4(this), new q4(this));
        this.t.add(r0);
        return;
    L5:
        ((e) getView()).f0(ForbiddenBannerView.ForbiddenState.COMPLAINT_SUCCESS);
    }

    public final void i9() {
        tt5.a.h("SubFolderPresenter", "loadMoreIfEmpty()...");
        if (hu5.a.d(((e) getView()).G()) == true) goto L5;
        return;
    L5:
        if (((h2) getModel()).hasMore() == false) goto L9;
        ((h2) getModel()).e3();
        return;
    }

    @Override // dd5.i1
    public final void m4() {
        tt5.a.h("SubFolderPresenter", "onMakeCopy()...");
        onRefresh();
    }

    public final void q8() {
        t0.K((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class));
    }

    public final void s2() {
        ce5.a r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d.isEnable("ccm.platform.appeal_v2") == false) goto L9;
        com.bytedance.ee.bear.route.h r1 = this.x.e;
        com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a r2 = (com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class);
        Document r3 = this.B;
        r1.u5(r2.a(r3.d, r3.getType(), true));
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void create() {
        super.create();
        Disposable r0 = ((h2) getModel()).O().observeOn(fo5.d.d()).subscribe(new l4(this), new m4());
        this.t.add(r0);
    }

    public final void f9() {
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
        return;
    L5:
        if (((e) getView()).x() == false) goto L9;
        ((e) getView()).j();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void onResume() {
        super.onResume();
        Document r0 = this.B;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.Q1 == false) goto L9;
        g9();
        return;
    }

    @Override // dd5.r1
    public final void Y3() {
        onRefresh();
    }

    @Override // dd5.k1
    public final void F3(final OfflineDoc r3) {
        tt5.a.h("SubFolderPresenter", "onOfflineDocCreated()...");
        Disposable r4 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new z3(this, r3), new j4());
        this.t.add(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void T8(ConnectionService.NetworkState r2) {
        ConnectionService.NetworkState r0 = this.p;
        if (r0 != null) goto L5;
    L6:
        if (r2 != null) goto L8;
    L10:
        super.T8(r2);
        return;
    L8:
        if (r2.a() == false) goto L10;
        onRefresh();
        goto L10
    L5:
        if (r0.a() == true) goto L10;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void a9(final Document r11) {
        tt5.a.h("SubFolderPresenter", "responseDeleteClick()...");
        boolean r0 = AppInfoUtils.f().booleanValue();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L5;
        int r1 = 60;
    L6:
        String r2 = String.valueOf(r1);
        String r3 = "";
        if (r0 == false) goto L10;
        String r4 = this.a.getString(2131889453);
        String r5 = this.a.getString(2131889414);
        String r6 = "";
    L26:
        if (r0 == true) goto L29;
        r3 = r6;
    L29:
        fp5.a r7 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(r4)).titleSize(16)).titleGravity(8388611)).message(r5)).messageGravity(8388611);
        r7.b(r3);
        r7.e = false;
        UDBaseDialogBuilder.ActionBuilder r8 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093);
        if (r0 == false) goto L32;
        int r9 = 2131889413;
    L33:
        fp5.a r12 = (fp5.a) r7.addActionButton(r8.text(r9).onClickListener(new k4(this, r11)));
        if (r0 == false) goto L36;
        int r10 = 2131888904;
    L37:
        Dialog r13 = ((fp5.a) r12.addActionButton(2131391778, r10, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(r13);
    L42:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r13);
        return;
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L41:
        DialogLancet.beforeDialogShow(r13);
        r13.show();
        DialogLancet.afterDialogShow(r13);
        goto L42
    L36:
        r10 = 2131887716;
        goto L37
    L32:
        r9 = 2131887736;
        goto L33
    L10:
        if (NodeType.isShortcut(r11.M1) == false) goto L12;
        String r14 = xo5.a.c(this.a, 2131887254, "doc_name", r11.a);
        String r15 = xo5.a.c(this.a, 2131889588, "num", r2);
    L24:
        r6 = "";
    L25:
        String r16 = r14;
        r5 = r15;
        r4 = r16;
        goto L26
    L12:
        Context r17 = this.a;
        r14 = xo5.a.c(r17, 2131887252, "doc_name", t0.g(r17, r11));
        int r18 = r11.getType();
        sbb.e r19 = sbb.e.f;
        if (r18 != r19.b) goto L15;
        r15 = xo5.a.c(this.a, 2131887253, "num", r2);
    L17:
        if (r11.getType() != r19.b) goto L20;
        r6 = this.a.getString(2131889585);
        goto L25
    L20:
        if (t0.w(r11, this.r) == true) goto L24;
        if (((a4) org.koin.java.a.a(a4.class)).c(r11.d) == true) goto L24;
        r6 = this.a.getString(2131889583);
        goto L25
    L15:
        r15 = xo5.a.c(this.a, 2131889588, "num", r2);
        goto L17
    L5:
        r1 = 30;
        goto L6
    }

    public final RouteBean d9(Document r17) {
        e0 r8 = new e0(this.a, r17, J8(), I8(), "none", this.A);
        int r1 = this.z + 1;
        String r2 = this.y;
        Context r10 = r8.getContext();
        Document r3 = r8.b;
        String r12 = r8.c;
        List r13 = r8.d;
        String r14 = r8.e;
        String r15 = r8.f;
        if (r3.getType() != sbb.e.f.b) goto L6;
        sd5.e r4 = new sd5.c(r10, r12, r1, r2);
    L13:
        return r4.a(r3);
    L6:
        if (r3.getType() != sbb.e.l.b) goto L9;
        r4 = new sd5.b(new e0(r10, r3, r12, r13, r14, r15), r2);
        goto L13
    L9:
        if (r3.getType() != sbb.e.n.b) goto L11;
        r4 = new sd5.g();
        goto L13
    L11:
        r4 = new sd5.a(r10);
        goto L13
    }

    public final String h9(int r5) {
        return this.a.getResources().getQuantityString(2131755036, r5, new Object[]{Integer.valueOf(r5)});
    }

    @Override // com.bytedance.ee.bear.list.folder.e.a
    public final void k(rf5.d r4) {
        Disposable r5 = ((h2) getModel()).b7(r4).delay(5, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new f4(this), new g4());
        this.t.add(r5);
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.e.a
    public final void p2(Throwable r12) {
        super.p2(r12);
        if (ax4.d.b(r12, 4) == false) goto L6;
        Disposable r13 = ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().f(this.y, FolderVersion.getFolderVersionV2(), false).subscribe(new n4(this), new o4(this));
        this.t.add(r13);
        e9();
        ((e) getView()).j8();
        return;
    L6:
        if (ax4.d.b(r12, 7) == false) goto L9;
        e9();
        ((e) getView()).Z0();
        return;
    L9:
        if (ax4.d.b(r12, 900099021) == false) goto L16;
        e9();
        DocReportPubParam r0 = new DocReportPubParam(this.y, 0, "none", J8(), "none", "0", "0", "0");
        String r6 = sh5.a.a(r12);
        if (this.b.getActivity() == null) goto L17;
        ((hm5.a) org.koin.java.a.a(hm5.a.class)).Sb(this.b.getActivity().getSupportFragmentManager(), this.a, -1, r6, r0);
        return;
    L17:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.f.a
    public final void u8(Document r20) {
        super.u8(r20);
        String r3 = J8();
        String r7 = r20.d;
        int r8 = r20.getType();
        String r9 = r20.F;
        String r10 = this.y;
        if (r20.getType() != sbb.e.f.b) goto L5;
        boolean r11 = true;
    L6:
        boolean r12 = FolderVersion.isShareFolder(r20.L1, r20.P1);
        boolean r13 = TextUtils.isEmpty(this.y);
        int r14 = this.z;
        Boolean r16 = Boolean.valueOf(O8());
        if (O8() == false) goto L9;
        String r17 = "middle";
    L10:
        p r15 = new p("ccm_space_folder_click", r3, "none", "share", "ccm_permission_share_view", r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, t0.m(r20));
        lc5.f.a.I(r15);
        return;
    L9:
        r17 = "suspend_create";
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.b, dd5.l1
    public final void x2(final OfflineDoc r3) {
        super.x2(r3);
        tt5.a.h("SubFolderPresenter", "onOfflineDocSynced()...");
        Disposable r4 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new r4(this, r3));
        this.t.add(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void U8(String r2, boolean r3) {
        Document r0 = this.B;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r0.d, r2) == false) goto L9;
        this.B.L = r3;
        ((e) getView()).u(this.B);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void V8(String r2, String r3) {
        Document r0 = this.B;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r2, r0.d) == false) goto L9;
        this.B.a = r3;
        ((e) getView()).u(this.B);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void W8(String r2, boolean r3) {
        Document r0 = this.B;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r0.d, r2) == false) goto L9;
        this.B.z = r3;
        ((e) getView()).u(this.B);
        return;
    }

    @Override // dd5.h1
    public final void X2(String r3, String r4) {
        tt5.a.h("SubFolderPresenter", "onListItemMoved()...");
        ((h2) getModel()).c(r3);
        if (TextUtils.equals(this.y, r3) == false) goto L8;
        d2 r5 = this.E;
        if (r5 == null) goto L11;
        r5.finish();
        return;
    L11:
        return;
    L8:
        if (TextUtils.equals(this.y, r4) == false) goto L13;
        onRefresh();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.e.a
    public final void s8(int r1, boolean r2) {
        super.s8(r1, r2);
        Document r3 = ((h2) getModel()).getParent();
        this.B = r3;
        if (r3 == null) goto L5;
        this.D = !r3.P1;
        ((h2) getModel()).e0();
        g9();
    L5:
        ((e) getView()).u(this.B);
        this.C = ((h2) getModel()).H1();
        ((e) getView()).F7(this.C);
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void h3(Document r27, int r28, boolean r29) {
        tt5.a.h("SubFolderPresenter", "onItemClick()...doc = " + r27.toString());
        if (d1.b(this.b) == true) goto L5;
    L9:
        FragmentActivity r2 = this.b.getActivity();
        boolean r4 = Q8();
        RouteBean r5 = d9(r27);
        r5.a(this.b);
        t0.r(new v0(r2, r27, r4, r5, J8(), "none", K8(), r28, r29, this.z + 1), this.x);
    L10:
        q r1 = new q("ccm_space_folder_click", J8(), "none", this.y, r27.d, r27.getType(), r27.F, FolderVersion.isShareFolder(r27.L1, r27.P1), !TextUtils.isEmpty(this.y), this.z, t0.m(r27));
        ce5.a r3 = this.x;
        lc5.f.a r6 = lc5.f.a;
        lc5.f.a.K(r1, r3);
        return;
    L5:
        if (r27.getType() != sbb.e.f.b) goto L9;
        if (d1.c(this.b, r27, J8()) == true) goto L10;
        FragmentActivity r7 = this.b.getActivity();
        boolean r8 = Q8();
        RouteBean r9 = d9(r27);
        r9.a(this.b);
        t0.r(new v0(r7, r27, r8, r9, J8(), "none", K8(), r28, r29, this.z + 1), this.x);
        goto L10
    }

    public h(e r8, y3 r9, Context r10, LifeCycleFragment r11, String r12, boolean r13, int r14, String r15, d2 r16, ce5.a r17) {
        super(r8, r9, r10, r11, r17);
        this.y = r12;
        this.D = r13;
        this.z = r14;
        this.E = r16;
        this.A = r15;
        this.x = r17;
    }
}
