package com.bytedance.ee.bear.list.recent;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import dd5.h1;
import dd5.i1;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j0 extends com.bytedance.ee.bear.list.list.b<com.bytedance.ee.bear.list.recent.c, d, d.a> implements i1, d.a, h1, a1.a {
    public final boolean A;
    public SortAndFilterViewModel B;
    public Disposable C;
    public boolean D;
    public final String E;
    public final String F;
    public final long G;
    public final String H;
    public final String I;
    public final com.bytedance.ee.bear.list.office.preload.f J;
    public boolean K;
    public String L;
    public boolean M;
    public final dd5.x0 y;
    public final i z;

    public class a implements com.bytedance.ee.bear.list.office.preload.f.a {
        public final /* synthetic */ j0 a;

        public a(j0 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.office.preload.f.a
        public final void a(ArrayList<Document> r3) {
            j0 r0 = this.a;
            r0.K = true;
            r0.c9(r3);
            this.a.l9("preload_db");
        }
    }

    public static class b implements com.bytedance.ee.bear.contract.c0.a {
        public final WeakReference<j0> a;

        public final void a() {
            tt5.a.h("RecentDocumentPresenter", "onPostExecuteSuccess()...");
            WeakReference<j0> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L10;
            com.bytedance.ee.util.ui.m.a(new k0(this));
            return;
        }

        public final void c() {
            tt5.a.h("RecentDocumentPresenter", "onPreExecute()...");
            WeakReference<j0> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L10;
            com.bytedance.ee.util.ui.m.a(new n0(this));
            return;
        }

        public b(j0 r2) {
            this.a = new WeakReference(r2);
        }

        public final void b(boolean r3) {
            tt5.a.h("RecentDocumentPresenter", "onOfflinePostExecute()...success = " + r3);
            WeakReference<j0> r4 = this.a;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.get() == null) goto L10;
            com.bytedance.ee.util.ui.m.a(new m0(this));
            return;
        }

        public final void d(final int r8, final Throwable r9, final String r10, final int r11) {
            tt5.a.h("RecentDocumentPresenter", "onPostExecuteFail()...");
            WeakReference<j0> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L10;
            com.bytedance.ee.util.ui.m.a(new l0(this, r9, r10, r11, r8));
            return;
        }
    }

    public static class c implements com.bytedance.ee.bear.list.s.a {
        public final WeakReference<j0> a;

        public c(j0 r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.list.s.a
        public final void onFail(Throwable r4) {
            if (this.a.get() != null) goto L5;
            return;
        L5:
            j0 r0 = this.a.get();
            ((d) r0.getView()).s6(false);
            if (com.bytedance.ee.bear.contract.k0.c(r4) == false) goto L9;
            return;
        L9:
            if (ax4.d.b(r4, 4202) == false) goto L11;
            Toast.showFailureText(r0.a, 2131887146);
            return;
        L11:
            Context r5 = r0.a;
            Toast.showFailureText(r5, r5.getResources().getString(2131887810), 0);
        }

        @Override // com.bytedance.ee.bear.list.s.a
        public final void onSuccess(String r5) {
            if (this.a.get() != null) goto L5;
            return;
        L5:
            j0 r0 = this.a.get();
            ((com.bytedance.ee.bear.list.recent.c) r0.getModel()).c(r5);
            ((d) r0.getView()).s6(false);
            ((d) r0.getView()).j();
            Context r6 = r0.a;
            if (AppInfoUtils.f().booleanValue() == false) goto L8;
            String r2 = r0.h9(false, 1);
        L9:
            Toast.showSuccessText(r6, r2, 0);
            r0.i9();
            return;
        L8:
            r2 = r0.a.getResources().getString(2131887812);
            goto L9
        }
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String J8() {
        return "home";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String L8() {
        return "recent";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "RecentDocumentPresenter";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final boolean P8() {
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String K8() {
        return AnalyticConstant.OpenType.HOME_CREATE_RECENT.getType();
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void destroy() {
        Disposable r0 = this.C;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        super.destroy();
    }

    public final void j9() {
        if (this.b.getActivity() != null) goto L7;
        tt5.a.d("RecentDocumentPresenter", "observeSortAndFilter()...activity is null");
        return;
    L7:
        if (this.B != null) goto L9;
        this.B = (SortAndFilterViewModel) new ViewModelProvider(this.b.getActivity()).get(SortAndFilterViewModel.class);
    L9:
        this.B.getSortStrategyLiveData().observe(this.b, new c0(this));
    }

    public final boolean k9() {
        if (this.K == false) goto L5;
        com.bytedance.ee.bear.list.office.preload.f r0 = this.J;
        if (r0.a == true) goto L11;
        return false;
    L11:
        if (r0.b == true) goto L16;
        r0.b = true;
        tt5.a.h("OfficeSpacePreloadStarter", "office_space_preload_visible_refresh reason=after_cache_first_draw");
        d9(this);
        return true;
    L16:
        return false;
    L5:
        if (this.A == false) goto L7;
        this.L = "NO_REQUEST";
        tt5.a.h("RecentDocumentPresenter", "office_space_preload_miss enter_trace_id=" + this.E + " request_key_hash=" + this.H + " consume_enter_method=" + this.F + " miss_reason=NO_REQUEST inflight_on_click=false");
    L7:
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void create() {
        H8();
        if (this.J.a(this.H, this.I, new a(this)) == false) goto L6;
        j9();
        tt5.a.h("RecentDocumentPresenter", "create()...");
        return;
    L6:
        b9();
        pd5.e.b(this.a).getClass();
        if (hu5.a.f(null) == true) goto L10;
        j9();
        tt5.a.h("RecentDocumentPresenter", "create()...");
        return;
    L10:
        tt5.a.h("RecentDocumentPresenter", "show preload list");
        lc5.x.c().f = true;
        d r1 = (d) getView();
        throw null;
    }

    public final void i9() {
        if (hu5.a.d(((d) getView()).G()) == true) goto L5;
        return;
    L5:
        if (((com.bytedance.ee.bear.list.recent.c) getModel()).hasMore() == false) goto L9;
        ((com.bytedance.ee.bear.list.recent.c) getModel()).e3();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void onResume() {
        super.onResume();
        if (this.D == false) goto L6;
        this.D = false;
        onRefresh();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b, dd5.q1
    public final void r() {
        super.r();
        BearExecutors.f().execute(new i0(this));
        tt5.a.h("RecentDocumentPresenter", "onTenantChanged()...");
    }

    @Override // dd5.i1
    public final void m4() {
        onRefresh();
    }

    public static void d9(j0 r2) {
        r2.getClass();
        tt5.a.h("RecentDocumentPresenter", "office_space_preload_visible_refresh tab=" + r2.I + " enter_trace_id=" + r2.E + " reason=after_cache_first_draw");
        ((com.bytedance.ee.bear.list.recent.c) r2.getModel()).r2();
    }

    @Override // com.bytedance.ee.bear.list.recent.a1.a
    public final void S6(Document r4) {
        if (com.bytedance.ee.bear.list.t0.b(this.a, r4, "delete_source") == false) goto L6;
        return;
    L6:
        if (r4.getType() != sbb.e.n.b) goto L8;
        a1.a(this.a, r4, this.x, this.t);
        return;
    L8:
        f9(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void S8(ArrayList<Document> r2) {
        super.S8(r2);
        ((com.bytedance.ee.bear.list.recent.c) getModel()).c4(r2);
        if (hu5.a.f(r2) == false) goto L5;
    L6:
        l9(SegmentStyle.FONT_STYLE_NORMAL);
        return;
    L5:
        if (this.i == true) goto L6;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void a9(final Document r11) {
        String r0 = r11.e;
        AccountService.Account r1 = this.r;
        if (r1 != null) goto L5;
        String r2 = "";
    L6:
        boolean r3 = TextUtils.equals(r0, r2);
        boolean r4 = this.x.d.isCurrentEnable("ccm.workspace.recent_delete_enable");
        if (r4 == false) goto L12;
        if (r3 == false) goto L12;
        if (com.bytedance.ee.bear.list.t0.b(this.a, r11, "delete_source") == false) goto L12;
        return;
    L12:
        boolean r5 = com.bytedance.ee.bear.list.t0.u(r11, this.x);
        if (r5 == true) goto L18;
        if (r4 == false) goto L18;
        if (r3 == false) goto L18;
        a1.b(this.a, r11, this.x, this, "home", "ccm_space_home_page_view", ((d) getView()).G1());
        return;
    L18:
        boolean r6 = false;
        this.y.a = false;
        if (r11.b() == true) goto L27;
        if (r5 == true) goto L27;
        if (r3 == false) goto L27;
        if (r11.getType() == sbb.e.n.b) goto L27;
        if (DocVersion.isDocV2(r11.L1) == true) goto L27;
        r6 = true;
    L27:
        fp5.a r7 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(2131887966)).titleSize(16)).titleGravity(8388611)).message(2131887965)).messageTextSize(14)).messageGravity(8388611);
        r7.e = r6;
        r7.a(this.a.getString(2131887891));
        dd5.x0 r8 = this.y;
        Intrinsics.checkNotNullParameter(r8, "value");
        r7.f = r8;
        UDBaseDialogBuilder.ActionBuilder r9 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093);
        if (AppInfoUtils.f().booleanValue() == false) goto L30;
        int r10 = 2131889446;
    L31:
        fp5.a r12 = (fp5.a) r7.addActionButton(r9.text(r10).onClickListener(new d0(this, r11)));
        if (AppInfoUtils.f().booleanValue() == false) goto L34;
        int r13 = 2131888904;
    L35:
        Dialog r14 = ((fp5.a) r12.addActionButton(2131391778, r13, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L43;
        DialogLancet.handleBlockedDialogShow(r14);
    L40:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r14);
        return;
    L43:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L39:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        goto L40
    L34:
        r13 = 2131887716;
        goto L35
    L30:
        r10 = 2131888026;
        goto L31
    L5:
        r2 = r1.uid;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.recent.a1.a
    public final void c2(Document r4) {
        if (this.y.a == true) goto L5;
        ((d) getView()).s6(true);
        if (AppInfoUtils.f().booleanValue() == false) goto L14;
        Context r0 = this.a;
        Toast.showLoading(r0, r0.getString(2131889447));
    L14:
        com.bytedance.ee.bear.list.s.b(r4.d, r4.getType(), new c(this));
        return;
    L5:
        if (com.bytedance.ee.bear.list.t0.b(this.a, r4, "delete_source") == false) goto L8;
        return;
    L8:
        if (((a4) org.koin.java.a.a(a4.class)).c(r4.d) == false) goto L10;
        final String r5 = r4.d;
        this.t.add(Flowable.just("").subscribeOn(fo5.d.b()).map(new w()).map(new a0(this, r5)).subscribe(new com.bytedance.ee.bear.bitable.homepage.list.a0(), new b0(this)));
        return;
    L10:
        f9(r4);
    }

    public final void f9(Document r4) {
        Context r0 = this.a;
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        String r1 = this.a.getString(2131889422);
    L6:
        Toast.showLoading(r0, r1);
        com.bytedance.ee.bear.list.s.a(r4.d, r4.getType(), r4.L1, new b(this));
        return;
    L5:
        r1 = this.a.getResources().getString(2131888339);
        goto L6
    }

    public final int g9(ArrayList<Document> r7) {
        if (this.A == false) goto L5;
        return 2;
    L5:
        String r0 = this.x.b.b;
        Iterator<Document> r8 = r7.iterator();
        boolean r2 = false;
        boolean r3 = false;
    L7:
        if (r8.hasNext() == false) goto L16;
        if (e9(r8.next(), r0) == false) goto L11;
        r2 = true;
    L12:
        if (r2 == false) goto L7;
        if (r3 == false) goto L7;
        return 3;
    L11:
        r3 = true;
        goto L12
    L16:
        if (r2 == false) goto L25;
        return 1;
    L25:
        return 2;
    }

    @Override // com.bytedance.ee.bear.list.recent.e.a
    public final void k(rf5.d r4) {
        com.bytedance.ee.bear.list.recent.c r0 = (com.bytedance.ee.bear.list.recent.c) getModel();
        qc5.a.i(this.x);
        Disposable r5 = r0.b7(r4).delay(5, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new x(this), new y());
        this.t.add(r5);
    }

    public final void l9(String r6) {
        if (this.M == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.E) == true) goto L17;
        this.M = true;
        long r2 = 0;
        if (this.G <= 0) goto L10;
        r2 = SystemClock.uptimeMillis() - this.G;
    L10:
        StringBuilder r0 = new StringBuilder("office_space_click_to_first_content_draw enter_trace_id=");
        r0.append(this.E);
        r0.append(" cost_ms=");
        r0.append(r2);
        r0.append(" preload_hit=");
        r0.append(this.K);
        r0.append(" miss_reason=");
        if (this.K == false) goto L13;
        String r1 = "";
    L14:
        r0.append(r1);
        r0.append(" data_source=");
        r0.append(r6);
        tt5.a.h("RecentDocumentPresenter", r0.toString());
        return;
    L13:
        r1 = this.L;
        goto L14
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.f.a
    public final void u8(Document r14) {
        super.u8(r14);
        String r6 = r14.d;
        int r7 = r14.getType();
        String r8 = r14.F;
        Boolean r9 = Boolean.valueOf(O8());
        if (O8() == false) goto L5;
        String r15 = "middle";
    L6:
        lc5.f.j(new lc5.p("home", "recent", "share", "ccm_permission_share_view", "recent", r6, r7, r8, r9, r15, "ccm_space_home_page_click"));
        return;
    L5:
        r15 = "suspend_create";
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.b, dd5.l1
    public final void x2(OfflineDoc r2) {
        super.x2(r2);
        tt5.a.h("RecentDocumentPresenter", "onOfflineDocSynced()...need refresh");
        this.D = true;
    }

    @Override // dd5.h1
    public final void X2(String r1, String r2) {
        onRefresh();
    }

    public final boolean e9(Document r5, String r6) {
        boolean r0 = false;
        if (TextUtils.equals(r5.e, r6) == true) goto L5;
        return false;
    L5:
        i r7 = this.z;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        if (com.bytedance.ee.bear.list.t0.u(r5, r7.a) == true) goto L24;
        if (TextUtils.equals(r7.a.b.b, r5.e) == false) goto L24;
        if (((a4) org.koin.java.a.c(a4.class, null, null, 6)).c(r5.d) == true) goto L24;
        if (r7.a(r5) == false) goto L16;
        return true;
    L16:
        if (r5.getType() == sbb.e.n.b) goto L24;
        DocVersion.a r8 = DocVersion.Companion;
        int r9 = r5.L1;
        r8.getClass();
        if (r9 != 5) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == true) goto L24;
        r0 = true;
        goto L24
    L20:
        r10 = false;
    L24:
        return r0;
    }

    public final String h9(boolean r5, int r6) {
        Resources r0 = this.a.getResources();
        if (r5 == false) goto L5;
        int r7 = 2131755036;
    L7:
        return r0.getQuantityString(r7, r6, new Object[]{Integer.valueOf(r6)});
    L5:
        r7 = 2131755037;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.e.a
    public final void s8(int r2, boolean r3) {
        super.s8(r2, r3);
        final ArrayList r4 = (ArrayList) ((d) getView()).G();
        Flowable.just("").observeOn(fo5.d.b()).subscribe(new kd5.a(r4), new kd5.b());
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void h3(Document r30, int r31, boolean r32) {
        tt5.a.h("RecentDocumentPresenter", "onItemClick()...doc = " + r30.toString());
        FragmentActivity r8 = this.b.getActivity();
        boolean r9 = Q8();
        Context r2 = this.a;
        List<Document> r14 = I8();
        Context r3 = new com.bytedance.ee.bear.contract.e0(r2, r30, "home", r14, "recent", "").getContext();
        if (r30.getType() != sbb.e.f.b) goto L6;
        sd5.e r1 = new sd5.c(r3, "home", 1, "");
    L12:
        RouteBean r5 = r1.a(r30);
        Bundle r4 = new Bundle();
        r4.putString("wiki_version", r30.a());
        r4.putBoolean("single_top_in_forseti", true);
        r5.n = r4;
        r5.a(this.b);
        com.bytedance.ee.bear.list.t0.r(new com.bytedance.ee.bear.list.v0(r8, r30, r9, r5, "home", "recent", K8(), r31, r32, 0), this.x);
        lc5.q r6 = new lc5.q("ccm_space_home_page_click", "home", "recent", "recent", "", r30.d, r30.getType(), r30.F, FolderVersion.isShareFolder(r30.L1, r30.P1), false, 0, com.bytedance.ee.bear.list.t0.m(r30), "", "");
        ce5.a r7 = this.x;
        lc5.f.a r10 = lc5.f.a;
        lc5.f.a.K(r6, r7);
        return;
    L6:
        if (r30.getType() != sbb.e.l.b) goto L9;
        r1 = new sd5.b(new com.bytedance.ee.bear.contract.e0(r3, r30, "home", r14, "recent", ""), "");
        goto L12
    L9:
        if (r30.getType() != sbb.e.n.b) goto L11;
        r1 = new sd5.g();
        goto L12
    L11:
        r1 = new sd5.a(r3);
        goto L12
    }

    public j0(d r1, v r2, Context r3, Fragment r4, ce5.a r5, boolean r6, String r7, String r8, long r9, String r11, String r12) {
        super(r1, r2, r3, r4, r5);
        this.y = new dd5.x0();
        this.J = new com.bytedance.ee.bear.list.office.preload.f();
        this.L = "NO_REQUEST";
        this.z = new i(r5);
        this.A = r6;
        this.E = r7;
        this.F = r8;
        this.G = r9;
        this.H = r11;
        if (TextUtils.isEmpty(r12) == false) goto L5;
        r12 = "RECENT";
    L5:
        this.I = r12;
    }
}
