package uc5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m0 extends com.bytedance.ee.bear.list.list.b<e2, f2, f2.a> implements dd5.i1, dd5.h1, dd5.r1, dd5.k1, f2.a {
    public String A;
    public final String B;
    public Document C;
    public final d2 D;
    public final dd5.x0 E;
    public final String y;
    public final int z;

    public static class a implements Runnable {
        public final WeakReference<m0> a;
        public final ce5.a b;

        public final void a() {
            if (this.a.get() != null) goto L6;
            tt5.a.h("FolderDetailPresenter", "DeleteCacheRunnable()...presenterRef.get() = null");
            return;
        L6:
            String r0 = this.a.get().y;
            ((mc5.j) this.b.a(mc5.j.class)).a2(4, r0);
            ((mc5.j) this.b.a(mc5.j.class)).L1(r0);
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

        public a(m0 r2, ce5.a r3) {
            this.a = new WeakReference(r2);
            this.b = r3;
        }
    }

    public static class b implements com.bytedance.ee.bear.contract.c0.a {
        public final WeakReference<m0> a;

        public final void a() {
            tt5.a.h("FolderDetailPresenter", "DeleteDocCallback#onPostExecuteSuccess()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("FolderDetailPresenter", "DeleteDocCallback#onPostExecuteSuccess()...presenterRef = null");
            return;
        L6:
            com.bytedance.ee.util.ui.m.a(new n0(this));
        }

        public final void c() {
            tt5.a.h("FolderDetailPresenter", "DeleteDocCallback#onPreExecute()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("FolderDetailPresenter", "DeleteDocCallback#onPreExecute()...presenterRef = null");
            return;
        L6:
            com.bytedance.ee.util.ui.m.a(new p0(this));
        }

        public b(m0 r2) {
            this.a = new WeakReference(r2);
        }

        public final void b(boolean r3) {
            tt5.a.h("FolderDetailPresenter", "DeleteDocCallback#onOfflinePostExecute()...success = " + r3);
            if (this.a.get() != null) goto L6;
            tt5.a.h("FolderDetailPresenter", "DeleteDocCallback#onOfflinePostExecute()...presenterRef = null");
            return;
        L6:
            com.bytedance.ee.util.ui.m.a(new q0(this));
        }

        public final void d(final int r1, Throwable r2, String r3, int r4) {
            tt5.a.h("FolderDetailPresenter", "DeleteDocCallback#onPostExecuteFail()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("FolderDetailPresenter", "DeleteDocCallback#onPostExecuteFail()...presenterRef = null");
            return;
        L6:
            com.bytedance.ee.util.ui.m.a(new o0(this, r1));
        }
    }

    public static final class c implements Runnable {
        public final WeakReference<m0> a;

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
            tt5.a.h("FolderDetailPresenter", "InputPasswordCallback()...presenterRef.get() = null");     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            tt5.a.h("FolderDetailPresenter", "InputPasswordCallback()...success");     // Catch: Throwable -> L7
            this.a.get().onRefresh();     // Catch: Throwable -> L7
            goto L12
        }

        public c(m0 r2) {
            this.a = new WeakReference(r2);
        }
    }

    public static class d implements com.bytedance.ee.bear.list.s.a {
        public final WeakReference<m0> a;

        public d(m0 r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.list.s.a
        public final void onFail(Throwable r5) {
            tt5.a.h("FolderDetailPresenter", "RemoveItemCallback#onFail()...throwable = " + r5);
            if (this.a.get() != null) goto L6;
            tt5.a.h("FolderDetailPresenter", "RemoveItemCallback#onFail()...presenterRef = null");
            return;
        L6:
            m0 r0 = this.a.get();
            ((f2) r0.getView()).s6(false);
            if (com.bytedance.ee.bear.list.v4.a(r0.a, ax4.d.a(r5)) == false) goto L10;
            return;
        L10:
            if (com.bytedance.ee.bear.contract.k0.c(r5) == false) goto L13;
            return;
        L13:
            if (ax4.d.b(r5, 4202) == false) goto L16;
            Toast.showFailureText(r0.a, 2131887146);
            return;
        L16:
            if (ax4.d.b(r5, 4) == false) goto L18;
            Context r6 = r0.a;
            Toast.showFailureText(r6, r6.getResources().getString(2131887803), 0);
            return;
        L18:
            Context r7 = r0.a;
            Toast.showFailureText(r7, r7.getResources().getString(2131887810), 0);
        }

        @Override // com.bytedance.ee.bear.list.s.a
        public final void onSuccess(String r6) {
            tt5.a.h("FolderDetailPresenter", "RemoveItemCallback onSuccess()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("FolderDetailPresenter", "RemoveItemCallback#onSuccess()...presenterRef = null");
            return;
        L6:
            m0 r0 = this.a.get();
            ((e2) r0.getModel()).c(r6);
            ((f2) r0.getView()).s6(false);
            r0.g9();
            Context r1 = r0.a;
            Toast.showSuccessText(r1, r1.getResources().getString(2131887812), 0);
            if (TextUtils.equals(r0.y, r6) == false) goto L9;
            r0.D.finish();
        L9:
            m0.d9(r0);
        }
    }

    public static class e implements com.bytedance.ee.bear.middleground_permission_export.model.j {
        public final String a;
        public final WeakReference<m0> b;
        public final ce5.a c;

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
        public final void b(Throwable r4) {
            tt5.a.f("FolderDetailPresenter", r4, false);
            if (this.b.get() != null) goto L6;
            tt5.a.h("FolderDetailPresenter", "onFailed()...presenterRef == null");
            return;
        L6:
            m0 r0 = this.b.get();
            if (ax4.d.b(r4, 10040) == false) goto L9;
            Toast.showFailureText(r0.a, 2131887146);
            return;
        L9:
            Context r5 = r0.a;
            Toast.showFailureText(r5, r5.getString(2131887830), 0);
        }

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.j
        public final void c(int r5) {
            tt5.a.h("FolderDetailPresenter", "SetExternalPermissionCallback#onSuccess()...result = " + r5);
            if (this.b.get() != null) goto L6;
            tt5.a.h("FolderDetailPresenter", "SetExternalPermissionCallback#onSuccess()...presenterRef == null");
            return;
        L6:
            final m0 r6 = this.b.get();
            r6.t.add(Flowable.just(this.a).observeOn(fo5.d.b()).subscribe(new r0(this, r6), new s0()));
            Context r7 = r6.a;
            Toast.showSuccessText(r7, r7.getString(2131887831), 0);
        }

        public e(String r1, m0 r2, ce5.a r3) {
            this.a = r1;
            this.b = new WeakReference(r2);
            this.c = r3;
        }
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "FolderDetailPresenter";
    }

    public final void B6() {
        ((com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class)).b(this.a);
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String J8() {
        if (TextUtils.isEmpty(this.y) == false) goto L7;
        return WikiSpaceType.PERSONAL;
    L7:
        if (TextUtils.isEmpty(this.A) == false) goto L10;
        return "personal_subfolder";
    L10:
        return "shared_subfolder";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String K8() {
        if ("favorites".equals(this.B) == false) goto L7;
        return AnalyticConstant.OpenType.FAVORITES.getType();
    L7:
        if (TextUtils.isEmpty(this.y) == true) goto L14;
        if (TextUtils.isEmpty(this.A) == true) goto L14;
        return AnalyticConstant.OpenType.SHARED_SHARED_FOLDER.getType();
    L14:
        return AnalyticConstant.OpenType.PERSONAL_FOLDER.getType();
    }

    public final void f5() {
        ce5.a r0 = this.x;
        if (r0 != null) goto L5;
    L8:
        com.bytedance.ee.bear.list.t0.J(this.C, this.b);
        return;
    L5:
        if (r0.d.isEnable("ccm.platform.appeal_v2") == false) goto L8;
        com.bytedance.ee.bear.route.h r1 = this.x.e;
        com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a r2 = (com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class);
        Document r3 = this.C;
        r1.u5(r2.a(r3.d, r3.getType(), false));
    }

    public final void f9() {
        tt5.a.h("FolderDetailPresenter", "deleteFolderInDB()...");
        fo5.d.b().scheduleDirect(new a(this, this.x), 500, TimeUnit.MILLISECONDS);
    }

    public final void h9() {
        if (this.C.Q1 == true) goto L5;
    L7:
        ((f2) getView()).f0(ForbiddenBannerView.ForbiddenState.COMPLAINT_SUCCESS);
        return;
    L5:
        if (Q8() == false) goto L7;
        Disposable r0 = ((e2) getModel()).p0().subscribe(new i0(this), new j0(this));
        this.t.add(r0);
    }

    @Override // dd5.i1
    public final void m4() {
        tt5.a.h("FolderDetailPresenter", "onMakeCopy()...");
        onRefresh();
    }

    public final void q8() {
        com.bytedance.ee.bear.list.t0.K((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class));
    }

    public final void s2() {
        ce5.a r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d.isEnable("ccm.platform.appeal_v2") == false) goto L9;
        com.bytedance.ee.bear.route.h r1 = this.x.e;
        com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a r2 = (com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.forbidden.a.class);
        Document r3 = this.C;
        r1.u5(r2.a(r3.d, r3.getType(), true));
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void create() {
        super.create();
        Disposable r0 = ((e2) getModel()).O().observeOn(fo5.d.d()).subscribe(new e0(this), new f0());
        this.t.add(r0);
    }

    public final void g9() {
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
        return;
    L5:
        if (((f2) getView()).x() == false) goto L9;
        ((f2) getView()).j();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void onResume() {
        super.onResume();
        Document r0 = this.C;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.Q1 == false) goto L9;
        h9();
        return;
    }

    @Override // dd5.r1
    public final void Y3() {
        onRefresh();
    }

    public static void d9(m0 r2) {
        tt5.a.h("FolderDetailPresenter", "loadMoreIfEmpty()...");
        if (hu5.a.d(((f2) r2.getView()).G()) == true) goto L5;
        return;
    L5:
        if (((e2) r2.getModel()).hasMore() == false) goto L9;
        ((e2) r2.getModel()).e3();
        return;
    }

    @Override // dd5.k1
    public final void F3(final OfflineDoc r3) {
        tt5.a.h("FolderDetailPresenter", "onOfflineDocCreated()...");
        Disposable r4 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new z(this, r3), new d0());
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
    public final void a9(final Document r15) {
        tt5.a.h("FolderDetailPresenter", "responseDeleteClick()...");
        if (com.bytedance.ee.bear.list.t0.b(this.a, r15, "delete_source") == false) goto L5;
        return;
    L5:
        this.E.a = false;
        if (r15.getType() != sbb.e.f.b) goto L12;
        fp5.a r0 = new fp5.a(this.a);
        Context r2 = this.a;
        fp5.a r1 = (fp5.a) ((fp5.a) ((fp5.a) r0.title(xo5.a.c(r2, 2131887962, "folder_name", com.bytedance.ee.bear.list.t0.g(r2, r15)))).titleSize(16)).titleGravity(8388611);
        Context r3 = this.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L10;
        int r9 = 60;
    L11:
        fp5.a r4 = (fp5.a) ((fp5.a) ((fp5.a) r1.message(xo5.a.c(r3, 2131889106, "num", String.valueOf(r9)))).messageTextSize(14)).messageGravity(8388611);
        r4.e = false;
        UDDialog r16 = ((fp5.a) ((fp5.a) r4.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093).text(2131887736).onClickListener(new g0(this, r15)))).addActionButton(2131391778, 2131887716, null)).build();
    L18:
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(r16);
    L22:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r16);
        return;
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L21:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        goto L22
    L10:
        r9 = 30;
        goto L11
    L12:
        fp5.a r5 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(2131887964)).titleSize(16)).titleGravity(8388611)).message(2131887963)).messageTextSize(14)).messageGravity(8388611);
        String r6 = r15.e;
        AccountService.Account r7 = this.r;
        if (r7 != null) goto L15;
        String r8 = "";
    L16:
        r5.e = TextUtils.equals(r6, r8);
        r5.a(this.a.getString(2131887891));
        dd5.x0 r10 = this.E;
        Intrinsics.checkNotNullParameter(r10, "value");
        r5.f = r10;
        r16 = ((fp5.a) ((fp5.a) r5.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093).text(2131887719).onClickListener(new h0(this, r15)))).addActionButton(2131391778, 2131887716, null)).build();
        goto L18
    L15:
        r8 = r7.uid;
        goto L16
    }

    public final void c2(Document r4) {
        tt5.a.h("FolderDetailPresenter", "onDeleteConfirmClick()...");
        if (com.bytedance.ee.bear.list.t0.b(this.a, r4, "delete_source") == false) goto L6;
        return;
    L6:
        if (this.E.a == false) goto L14;
        tt5.a.h("FolderDetailPresenter", "deleteItem()....");
        if (com.bytedance.ee.bear.list.t0.b(this.a, r4, "delete_source") == false) goto L11;
        return;
    L11:
        if (((com.bytedance.ee.bear.document.a4) org.koin.java.a.a(com.bytedance.ee.bear.document.a4.class)).c(r4.d) == false) goto L13;
        final String r5 = r4.d;
        tt5.a.h("FolderDetailPresenter", "deleteOfflineDoc()...");
        this.t.add(Flowable.just("").subscribeOn(fo5.d.b()).map(new k0()).map(new l0(this, r5)).subscribe(new a0(this), new b0(this)));
        return;
    L13:
        tt5.a.h("FolderDetailPresenter", "deleteOnlineDoc()...");
        com.bytedance.ee.bear.list.s.a(r4.d, r4.getType(), r4.L1, new b(this));
        return;
    L14:
        tt5.a.h("FolderDetailPresenter", "removeItem()...");
        if (com.bytedance.ee.bear.list.t0.b(this.a, r4, "delete_source") == true) goto L22;
        ((f2) getView()).s6(true);
        String r6 = r4.c;
        d r0 = new d(this);
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_TOKEN, r6);
        com.bytedance.ee.bear.list.s.c("/api/explorer/remove/", r6, r1, r0);
        return;
    }

    public final RouteBean e9(Document r17) {
        com.bytedance.ee.bear.contract.e0 r8 = new com.bytedance.ee.bear.contract.e0(this.a, r17, J8(), I8(), "none", this.B);
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
        r4 = new sd5.b(new com.bytedance.ee.bear.contract.e0(r10, r3, r12, r13, r14, r15), r2);
        goto L13
    L9:
        if (r3.getType() != sbb.e.n.b) goto L11;
        r4 = new sd5.g();
        goto L13
    L11:
        r4 = new sd5.a(r10);
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.e.a
    public final void p2(Throwable r13) {
        super.p2(r13);
        if (ax4.d.b(r13, 4) == false) goto L22;
        if (m3.a(r13) == false) goto L7;
        ((zt5.a) org.koin.java.a.a(zt5.a.class)).Ud(this.b.getActivity(), this.y, sbb.e.f.b, false, new c(this));
    L20:
        f9();
        ((f2) getView()).j8();
        return;
    L7:
        tt5.a.h("FolderDetailPresenter", "requestFolderPermission()...");
        p1 r14 = com.bytedance.ee.bear.list.t0.A(r13);
        if (this.b.getActivity() == null) goto L20;
        zt5.a r2 = (zt5.a) org.koin.java.a.a(zt5.a.class);
        FragmentActivity r3 = this.b.getActivity();
        String r4 = this.y;
        sbb.e r5 = sbb.e.f;
        if (r14 != null) goto L12;
        String r0 = "";
    L13:
        String r6 = r0;
        String r7 = this.a.getString(2131889844);
        if (r14 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        r2.Q0(r3, r4, r5, r6, r7, r8, J8(), false, -1);
        goto L20
    L16:
        if (r14.b == false) goto L18;
        r8 = true;
        goto L19
    L12:
        r0 = r14.a;
        goto L13
    L22:
        if (ax4.d.b(r13, 7) == false) goto L28;
        Context r15 = this.a;
        Toast.showFailureText(r15, r15.getString(2131887919), 0);
        f9();
        d2 r16 = this.D;
        if (r16 == null) goto L29;
        r16.finish();
        return;
    L29:
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
        lc5.p r15 = new lc5.p("ccm_space_folder_click", r3, "none", "share", "ccm_permission_share_view", r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, com.bytedance.ee.bear.list.t0.m(r20));
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
        tt5.a.h("FolderDetailPresenter", "onOfflineDocSynced()...");
        Disposable r4 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new c0(this, r3));
        this.t.add(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void U8(String r2, boolean r3) {
        Document r0 = this.C;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r0.d, r2) == false) goto L9;
        this.C.L = r3;
        ((f2) getView()).u(this.C);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void V8(String r2, String r3) {
        Document r0 = this.C;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r2, r0.d) == false) goto L9;
        this.C.a = r3;
        ((f2) getView()).u(this.C);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void W8(String r2, boolean r3) {
        Document r0 = this.C;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r0.d, r2) == false) goto L9;
        this.C.z = r3;
        ((f2) getView()).u(this.C);
        return;
    }

    @Override // dd5.h1
    public final void X2(String r3, String r4) {
        tt5.a.h("FolderDetailPresenter", "onListItemMoved()...");
        ((e2) getModel()).c(r3);
        if (TextUtils.equals(this.y, r3) == false) goto L8;
        d2 r5 = this.D;
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
        Document r3 = ((e2) getModel()).getParent();
        this.C = r3;
        if (r3 == null) goto L8;
        this.A = r3.m;
        if (FolderVersion.isNewShareFolder(r3.T) == false) goto L7;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).K8();
        f9();
        this.D.finish();
    L7:
        ((e2) getModel()).e0();
        h9();
    L8:
        ((f2) getView()).u(this.C);
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void h3(Document r27, int r28, boolean r29) {
        tt5.a.h("FolderDetailPresenter", "onItemClick()...doc = " + r27.toString());
        if (r27.p1 == true) goto L6;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(com.bytedance.ee.bear.list.t0.i(r27));
    L13:
        lc5.q r1 = new lc5.q("ccm_space_folder_click", J8(), "none", this.y, r27.d, r27.getType(), r27.F, FolderVersion.isShareFolder(r27.L1, r27.P1), !TextUtils.isEmpty(this.y), this.z, com.bytedance.ee.bear.list.t0.m(r27));
        ce5.a r2 = this.x;
        lc5.f.a r3 = lc5.f.a;
        lc5.f.a.K(r1, r2);
        return;
    L6:
        if (d1.b(this.b) == true) goto L8;
    L12:
        com.bytedance.ee.bear.list.t0.r(new com.bytedance.ee.bear.list.v0(this.b.getActivity(), r27, Q8(), e9(r27), J8(), "none", K8(), r28, r29, this.z + 1), this.x);
        goto L13
    L8:
        if (r27.getType() != sbb.e.f.b) goto L12;
        if (d1.c(this.b, r27, J8()) == true) goto L13;
        com.bytedance.ee.bear.list.t0.r(new com.bytedance.ee.bear.list.v0(this.b.getActivity(), r27, Q8(), e9(r27), J8(), "none", K8(), r28, r29, this.z + 1), this.x);
        goto L13
    }

    @Override // uc5.f2.a
    public final void u0(View r3, int r4, final Document r5, boolean r6) {
        Context r7 = this.a;
        AccountService.Account r8 = this.r;
        final e r9 = new e(r5.d, this, this.x);
        if (com.bytedance.ee.bear.list.t0.w(r5, r8) == false) goto L9;
        String r10 = xo5.a.c(r7, 2131887952, "doc_type", com.bytedance.ee.bear.list.t0.n(r7, r5.getType()));
        Intrinsics.checkNotNullParameter(r7, "context");
        UDDialogBuilder r0 = new UDDialogBuilder(r7);
        r0.autoDismiss(true);
        r0.title(2131888315);
        r0.titleBold(true);
        Intrinsics.checkNotNullParameter(r10, "value");
        r0.message(r10);
        r0.messageGravity(8388611);
        r0.messageTextSize(14);
        r0.addActionButton(2131391777, 2131887800, new com.bytedance.ee.bear.list.k0(r5, r9));
        r0.addActionButton(2131391778, 2131887716, null);
        UDDialog r11 = r0.build();
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r11);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L8:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        return;
    L9:
        Toast.showText(r7, 2131887953);
    }

    public m0(f2 r8, y r9, Context r10, LifeCycleFragment r11, String r12, int r13, String r14, String r15, d2 r16, ce5.a r17) {
        super(r8, r9, r10, r11, r17);
        this.E = new dd5.x0();
        this.y = r12;
        this.z = r13;
        this.A = r14;
        this.D = r16;
        this.B = r15;
        this.x = r17;
    }
}
