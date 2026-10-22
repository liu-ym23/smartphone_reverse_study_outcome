package com.bytedance.ee.bear.list.folder;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.e0;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.s;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.v0;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.ui.m;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import dd5.h1;
import dd5.i1;
import dd5.k1;
import dd5.r1;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lc5.p;
import lc5.q;
import uc5.c3;
import uc5.d1;
import uc5.d3;
import uc5.e3;
import uc5.f3;
import uc5.g2;
import uc5.g3;
import uc5.h3;
import uc5.i3;
import uc5.j3;
import uc5.q2;
import uc5.r2;
import uc5.s2;
import uc5.v2;
import uc5.w2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class f extends com.bytedance.ee.bear.list.list.b<g2, com.bytedance.ee.bear.list.folder.d, com.bytedance.ee.bear.list.folder.d.a> implements i1, h1, r1, k1, com.bytedance.ee.bear.list.folder.d.a {
    public final com.bytedance.ee.bear.list.office.preload.f A;
    public boolean B;
    public final String y;
    public final String z;

    public class a implements com.bytedance.ee.bear.list.office.preload.f.a {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.office.preload.f.a
        public final void a(ArrayList<Document> r3) {
            f r0 = this.a;
            r0.B = true;
            r0.c9(r3);
        }
    }

    public static class b implements c0.a {
        public final WeakReference<f> a;

        public final void a() {
            tt5.a.h("MyRootFolderPresenter", "onPostExecuteSuccess()...");
            if (this.a.get() != null) goto L5;
            return;
        L5:
            m.a(new e3(this));
        }

        public final void c() {
            tt5.a.h("MyRootFolderPresenter", "onPreExecute()...");
            if (this.a.get() != null) goto L5;
            return;
        L5:
            m.a(new g3(this));
        }

        public b(f r2) {
            this.a = new WeakReference(r2);
        }

        public final void b(boolean r3) {
            tt5.a.h("MyRootFolderPresenter", "onOfflinePostExecute()...success = " + r3);
            if (this.a.get() != null) goto L5;
            return;
        L5:
            m.a(new h3(this));
        }

        public final void d(final int r1, Throwable r2, String r3, int r4) {
            tt5.a.h("MyRootFolderPresenter", "onPostExecuteFail()...");
            if (this.a.get() != null) goto L5;
            return;
        L5:
            m.a(new f3(this, r1));
        }
    }

    public static class c implements s.c {
        public final WeakReference<f> a;

        public c(f r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.list.s.c
        public final void a(DocumentListInfo r4) {
            tt5.a.h("MyRootFolderPresenter", "DeleteOnlineItemCallback onAuthorityFail()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("MyRootFolderPresenter", "DeleteOnlineItemCallback#onAuthorityFail()...presenterRef = null");
            return;
        L6:
            f r0 = this.a.get();
            ((com.bytedance.ee.bear.list.folder.d) r0.getView()).s6(false);
            com.bytedance.ee.bear.list.folder.a.C0014a r1 = new com.bytedance.ee.bear.list.folder.a.C0014a();
            com.bytedance.ee.bear.list.folder.a.b r2 = r1.a;
            r2.a = r4;
            r2.b = new i3();
            r2.c = new j3();
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
        public final void onSuccess(String r5) {
            tt5.a.h("MyRootFolderPresenter", "DeleteOnlineItemCallback onSuccess()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("MyRootFolderPresenter", "DeleteOnlineItemCallback#onSuccess()...presenterRef = null");
            return;
        L6:
            f r0 = this.a.get();
            ((g2) r0.getModel()).c(r5);
            ((com.bytedance.ee.bear.list.folder.d) r0.getView()).s6(false);
            r0.f9();
            Context r6 = r0.a;
            if (AppInfoUtils.f().booleanValue() == false) goto L9;
            String r2 = r0.g9(true, 1);
        L10:
            Toast.showSuccessText(r6, r2, 0);
            r0.h9();
            return;
        L9:
            r2 = r0.a.getResources().getString(2131887742);
            goto L10
        }

        @Override // com.bytedance.ee.bear.list.s.c
        public final void b(String r5, int r6, Throwable r7) {
            tt5.a.h("MyRootFolderPresenter", "DeleteOnlineItemCallback#onFail()...throwable = " + r7);
            if (this.a.get() != null) goto L6;
            tt5.a.h("MyRootFolderPresenter", "DeleteOnlineItemCallback#onFail()...presenterRef = null");
            return;
        L6:
            f r0 = this.a.get();
            ((com.bytedance.ee.bear.list.folder.d) r0.getView()).s6(false);
            if (k0.c(r7) == false) goto L9;
            return;
        L9:
            ErrorResponse r8 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).e(r5, Integer.valueOf(r6), "DELETE_ENTITY", r7);
            if (r8.getHasHandledUiAction() == false) goto L14;
            r8.getCallback().a(r0.a, r8);
            return;
        L14:
            if (ax4.d.b(r7, 4202) == false) goto L17;
            Toast.showFailureText(r0.a, 2131887146);
            return;
        L17:
            if (ax4.d.b(r7, 4) == false) goto L19;
            Context r9 = r0.a;
            Toast.showFailureText(r9, r9.getResources().getString(2131887803), 0);
            return;
        L19:
            Context r10 = r0.a;
            Toast.showFailureText(r10, r10.getResources().getString(2131887737), 0);
        }
    }

    public static class d implements s.a {
        public final WeakReference<f> a;

        public d(f r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.list.s.a
        public final void onFail(Throwable r4) {
            tt5.a.h("MyRootFolderPresenter", "RemoveItemCallback#onFail()...throwable = " + r4);
            if (this.a.get() != null) goto L6;
            tt5.a.h("MyRootFolderPresenter", "RemoveItemCallback#onFail()...presenterRef = null");
            return;
        L6:
            f r0 = this.a.get();
            ((com.bytedance.ee.bear.list.folder.d) r0.getView()).s6(false);
            if (k0.c(r4) == false) goto L10;
            return;
        L10:
            if (ax4.d.b(r4, 4202) == false) goto L12;
            Toast.showFailureText(r0.a, 2131887146);
            return;
        L12:
            Context r5 = r0.a;
            Toast.showFailureText(r5, r5.getResources().getString(2131887810), 0);
        }

        @Override // com.bytedance.ee.bear.list.s.a
        public final void onSuccess(String r5) {
            tt5.a.h("MyRootFolderPresenter", "RemoveItemCallback onSuccess()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("MyRootFolderPresenter", "RemoveItemCallback#onSuccess()...presenterRef = null");
            return;
        L6:
            f r0 = this.a.get();
            ((g2) r0.getModel()).c(r5);
            ((com.bytedance.ee.bear.list.folder.d) r0.getView()).s6(false);
            r0.f9();
            Context r6 = r0.a;
            if (AppInfoUtils.f().booleanValue() == false) goto L9;
            String r2 = r0.g9(false, 1);
        L10:
            Toast.showSuccessText(r6, r2, 0);
            r0.h9();
            return;
        L9:
            r2 = r0.a.getResources().getString(2131887742);
            goto L10
        }
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "MyRootFolderPresenter";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public String J8() {
        if (qc5.a.g(this.x) == false) goto L6;
        return "new_drive";
    L6:
        return WikiSpaceType.PERSONAL;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String K8() {
        return AnalyticConstant.OpenType.PERSONAL_OWN.getType();
    }

    public final void h9() {
        tt5.a.h("MyRootFolderPresenter", "loadMoreIfEmpty()...");
        if (hu5.a.d(((com.bytedance.ee.bear.list.folder.d) getView()).G()) == true) goto L5;
        return;
    L5:
        if (((g2) getModel()).hasMore() == false) goto L9;
        ((g2) getModel()).e3();
        return;
    }

    @Override // dd5.i1
    public final void m4() {
        tt5.a.h("MyRootFolderPresenter", "onMakeCopy()...");
        onRefresh();
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void create() {
        H8();
        if (this.A.a(this.y, this.z, new a(this)) == false) goto L5;
        return;
    L5:
        b9();
    }

    public final void f9() {
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
        return;
    L5:
        if (((com.bytedance.ee.bear.list.folder.d) getView()).x() == false) goto L9;
        ((com.bytedance.ee.bear.list.folder.d) getView()).j();
        return;
    }

    @Override // dd5.r1
    public final void Y3() {
        onRefresh();
    }

    public static void d9(f r2) {
        r2.getClass();
        tt5.a.h("MyRootFolderPresenter", "office_space_preload_visible_refresh tab=" + r2.z + " reason=after_cache_first_draw");
        ((g2) r2.getModel()).r2();
    }

    @Override // dd5.k1
    public final void F3(final OfflineDoc r3) {
        tt5.a.h("MyRootFolderPresenter", "onOfflineDocCreated()...");
        Disposable r4 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new r2(this, r3), new v2());
        this.t.add(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void a9(final Document r11) {
        tt5.a.h("MyRootFolderPresenter", "responseDeleteClick()...");
        boolean r0 = AppInfoUtils.f().booleanValue();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L5;
        int r1 = 60;
    L6:
        String r2 = String.valueOf(r1);
        if (r0 == false) goto L9;
    L13:
        String r3 = "";
    L14:
        if (r0 == false) goto L17;
        String r4 = this.a.getString(2131889453);
        String r5 = this.a.getString(2131889414);
    L26:
        fp5.a r6 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(r4)).titleSize(16)).titleGravity(8388611)).message(r5)).messageTextSize(14)).messageGravity(8388611);
        r6.b(r3);
        r6.e = false;
        UDBaseDialogBuilder.ActionBuilder r7 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093);
        if (r0 == false) goto L29;
        int r8 = 2131889413;
    L30:
        fp5.a r12 = (fp5.a) r6.addActionButton(r7.text(r8).onClickListener(new w2(this, r11)));
        if (r0 == false) goto L33;
        int r9 = 2131888904;
    L34:
        Dialog r13 = ((fp5.a) r12.addActionButton(2131391778, r9, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L42;
        DialogLancet.handleBlockedDialogShow(r13);
    L39:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r13);
        return;
    L42:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L38:
        DialogLancet.beforeDialogShow(r13);
        r13.show();
        DialogLancet.afterDialogShow(r13);
        goto L39
    L33:
        r9 = 2131887716;
        goto L34
    L29:
        r8 = 2131887736;
        goto L30
    L17:
        if (NodeType.isShortcut(r11.M1) == false) goto L20;
        String r10 = xo5.a.c(this.a, 2131887254, "doc_name", r11.a);
        String r14 = xo5.a.c(this.a, 2131889588, "num", r2);
    L19:
        String r15 = r10;
        r5 = r14;
        r4 = r15;
        goto L26
    L20:
        Context r16 = this.a;
        r10 = xo5.a.c(r16, 2131887252, "doc_name", t0.g(r16, r11));
        if (r11.getType() == sbb.e.f.b) goto L23;
    L25:
        r14 = xo5.a.c(this.a, 2131889588, "num", r2);
        goto L19
    L23:
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r11.L1)) == false) goto L25;
        r14 = xo5.a.c(this.a, 2131887253, "num", r2);
        goto L19
    L9:
        if (r11.getType() != sbb.e.f.b) goto L13;
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r11.L1)) == false) goto L13;
        r3 = this.a.getString(2131889585);
        goto L14
    L5:
        r1 = 30;
        goto L6
    }

    public final RouteBean e9(Document r17) {
        e0 r7 = new e0(this.a, r17, J8(), I8(), "none", "home");
        Context r10 = r7.getContext();
        Document r0 = r7.b;
        String r12 = r7.c;
        List r13 = r7.d;
        String r14 = r7.e;
        String r15 = r7.f;
        if (r0.getType() != sbb.e.f.b) goto L6;
        sd5.e r1 = new sd5.c(r10, r12, 1, "");
    L13:
        return r1.a(r0);
    L6:
        if (r0.getType() != sbb.e.l.b) goto L9;
        r1 = new sd5.b(new e0(r10, r0, r12, r13, r14, r15), "");
        goto L13
    L9:
        if (r0.getType() != sbb.e.n.b) goto L11;
        r1 = new sd5.g();
        goto L13
    L11:
        r1 = new sd5.a(r10);
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.folder.d.a
    public final void k(rf5.d r4) {
        g2 r0 = (g2) getModel();
        qc5.a.i(this.x);
        Disposable r5 = r0.b7(r4).delay(5, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new d3(this), new s2());
        this.t.add(r5);
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.f.a
    public final void u8(Document r20) {
        super.u8(r20);
        String r3 = J8();
        String r7 = r20.d;
        int r8 = r20.getType();
        String r9 = r20.F;
        if (r20.getType() != sbb.e.f.b) goto L5;
        boolean r18 = true;
    L6:
        boolean r11 = r18;
        p r12 = new p("ccm_space_personal_page_click", r3, "none", "share", "ccm_permission_share_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r20.L1, r20.P1), false, 0, Boolean.valueOf(O8()), "suspend_create", t0.m(r20));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.b, dd5.l1
    public final void x2(final OfflineDoc r3) {
        super.x2(r3);
        tt5.a.h("MyRootFolderPresenter", "onOfflineDocSynced()...");
        Disposable r4 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new c3(this, r3));
        this.t.add(r4);
    }

    @Override // dd5.h1
    public final void X2(String r1, String r2) {
        ((g2) getModel()).c(r1);
    }

    public final String g9(boolean r5, int r6) {
        Resources r0 = this.a.getResources();
        if (r5 == false) goto L5;
        int r7 = 2131755036;
    L7:
        return r0.getQuantityString(r7, r6, new Object[]{Integer.valueOf(r6)});
    L5:
        r7 = 2131755037;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void h3(Document r27, int r28, boolean r29) {
        tt5.a.h("MyRootFolderPresenter", "onItemClick()...doc = " + r27.toString());
        if (d1.b(this.b) == true) goto L5;
    L9:
        FragmentActivity r2 = this.b.getActivity();
        boolean r4 = Q8();
        RouteBean r5 = e9(r27);
        r5.a(this.b);
        t0.r(new v0(r2, r27, r4, r5, J8(), "none", K8(), r28, r29, 0), this.x);
    L11:
        if (qc5.a.g(this.x) == false) goto L13;
        String r3 = "ccm_space_drive_page_click";
    L14:
        q r1 = new q(r3, J8(), "none", "", r27.d, r27.getType(), r27.F, FolderVersion.isShareFolder(r27.L1, r27.P1), false, 0, t0.m(r27));
        ce5.a r6 = this.x;
        lc5.f.a r7 = lc5.f.a;
        lc5.f.a.K(r1, r6);
        return;
    L13:
        r3 = "ccm_space_personal_page_click";
        goto L14
    L5:
        if (r27.getType() != sbb.e.f.b) goto L9;
        if (d1.c(this.b, r27, J8()) == true) goto L11;
        FragmentActivity r8 = this.b.getActivity();
        boolean r9 = Q8();
        RouteBean r10 = e9(r27);
        r10.a(this.b);
        t0.r(new v0(r8, r27, r9, r10, J8(), "none", K8(), r28, r29, 0), this.x);
        goto L11
    }

    public f(com.bytedance.ee.bear.list.folder.d r1, q2 r2, Context r3, LifeCycleFragment r4, ce5.a r5, String r6, String r7) {
        super(r1, r2, r3, r4, r5);
        this.A = new com.bytedance.ee.bear.list.office.preload.f();
        this.x = r5;
        this.y = r6;
        if (TextUtils.isEmpty(r7) == false) goto L5;
        r7 = "MINE";
    L5:
        this.z = r7;
    }
}
