package rc5;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.offline.OfflineRenameData;
import com.bytedance.ee.bear.list.delete.DeleteExecutor;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.ListDocs;
import com.bytedance.ee.bear.list.dto.SpaceMakeCopyToSpaceResult;
import com.bytedance.ee.bear.list.folder.complaint.FolderComplaintActivity;
import com.bytedance.ee.bear.list.offlinecache.ManualOfflineConfig;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z2 implements a {
    public com.bytedance.ee.bear.list.u0 a;

    public z2() {
    }

    @Override // rc5.a
    public final void a() {
    }

    @Override // rc5.a
    public final void H() {
        Flowable.just("").map(new n2()).map(new y2()).subscribe(new e(), new f());
    }

    @Override // rc5.a
    public final DeleteExecutor R() {
        return new DeleteExecutor();
    }

    @Override // rc5.a
    public final void V() {
        Flowable.just("").map(new d()).map(new o()).subscribe(new z(), new k0());
    }

    @Override // rc5.a
    public final Flowable<ListDocs> m() {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new e2());
    }

    @Override // rc5.a
    public final ListDocs o() {
        ListDocs r0 = new ListDocs();
        r0.a = ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.a(com.bytedance.ee.bear.contract.c0.class)).o();
        return r0;
    }

    @Override // rc5.a
    public final boolean B() {
        qc5.a.j();
        return true;
    }

    @Override // rc5.a
    public final boolean x() {
        return com.bytedance.ee.bear.list.t0.s();
    }

    @Override // rc5.a
    public final com.bytedance.ee.bear.list.u0 C() {
        return this.a;
    }

    @Override // rc5.a
    public final void A(final Document r3) {
        Flowable.just("").map(new e0()).map(new f0(r3)).subscribe(new g0(r3), new h0());
    }

    @Override // rc5.a
    public final void D(Context r4) {
        int r0 = com.bytedance.ee.bear.list.create.e.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        tt5.a.h("CreateErrorDialogUtils", "showCreateExceedCapacityDialog()");
        Intrinsics.checkNotNullParameter(r4, "context");
        UDDialogBuilder r1 = new UDDialogBuilder(r4);
        r1.autoDismiss(true);
        r1.title(2131887989);
        r1.message(2131887988);
        r1.messageGravity(8388611);
        BearUDDialogBuilder.ActionBottomOrientation r2 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
        Intrinsics.checkNotNullParameter(r2, "value");
        if (r2 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L5;
        UDBaseDialogBuilder.ActionBottomOrientation r3 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L6:
        r1.actionButtonOrientation(r3);
        r1.addActionButton(2131391777, 2131887788, new com.bytedance.ee.bear.list.create.f(r4));
        r1.addActionButton(2131391778, 2131887716, null);
        UDDialog r5 = r1.build();
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        return;
    L5:
        r3 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L6
    }

    @Override // rc5.a
    public final String E(String r2) {
        return ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.a(com.bytedance.ee.bear.contract.c0.class)).F(r2);
    }

    @Override // rc5.a
    public final Flowable<Boolean> G(final String r3) {
        return Flowable.just("").map(new y1()).map(new z1(r3));
    }

    @Override // rc5.a
    public final Flowable<OfflineDoc> I(final String r3) {
        return Flowable.just("").map(new q2()).flatMap(new r2(r3));
    }

    @Override // rc5.a
    public final Flowable<Boolean> L(final String r3) {
        return Flowable.just("").map(new n1()).flatMap(new o1(r3));
    }

    @Override // rc5.a
    public final Flowable<Boolean> N(final long r3) {
        return Flowable.just("").map(new u2()).flatMap(new v2(r3));
    }

    @Override // rc5.a
    public final Flowable<Boolean> O(final String r3) {
        return Flowable.just("").map(new w2()).map(new x2(r3));
    }

    @Override // rc5.a
    public final Flowable<Boolean> S(final String r3) {
        return Flowable.just("").map(new g()).flatMap(new h(r3));
    }

    @Override // rc5.a
    public final void U(final com.bytedance.ee.bear.contract.j0 r3) {
        Flowable.just("").map(new a0()).map(new b0(r3)).subscribe(new c0(), new d0());
    }

    @Override // rc5.a
    public final void W(final String r3) {
        Flowable.just("").map(new a1()).map(new b1(r3)).subscribe(new c1(), new d1());
    }

    @Override // rc5.a
    public final void X(final com.bytedance.ee.bear.contract.f0 r3) {
        Flowable.just("").map(new r()).map(new s(r3)).subscribe(new t(r3), new u());
    }

    @Override // rc5.a
    public final void Y(final OfflineRenameData r3) {
        Flowable.just("").map(new i0()).map(new j0(r3)).subscribe(new l0(), new m0());
    }

    @Override // rc5.a
    public final Flowable<Integer> c(final List<String> r3) {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new k()).map(new l(r3));
    }

    @Override // rc5.a
    public final void d(final List<String> r3) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new u1()).map(new v1(r3)).subscribe(new w1(), new x1());
    }

    @Override // rc5.a
    public final Flowable<SpaceMakeCopyToSpaceResult> h(com.bytedance.ee.bear.contract.d0 r11) {
        int r0 = hd5.c.a;
        Intrinsics.checkNotNullParameter(r11, "bean");
        Context r1 = r11.getContext();
        if (r1 == null) goto L5;
        String r2 = r1.getString(2131887720);
    L6:
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        String r4 = r11.f;
        String r5 = "";
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r3.element = r4;
        String r6 = r11.d;
        if (r6 == null) goto L12;
        int r7 = r6.length();
    L14:
        if (r11.getType() == sbb.e.l.b) goto L16;
    L20:
        String r8 = ((String) r3.element) + ' ' + r2;
    L21:
        r3.element = r8;
        NetService r9 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        if (r11.i == false) goto L24;
        NetService.c r10 = new hd5.c.C0239c();
    L25:
        NetService.d r12 = r9.Vc(r10);
        String r13 = (String) r3.element;
        if (r11.i == false) goto L28;
        String r14 = "/space/api/explorer/v2/clone/";
    L29:
        NetService.f r15 = new NetService.f(r14);
        ((NetService.e) r15).c = 1;
        HashMap r16 = new HashMap();
        String r17 = r11.b;
        if (r17 != null) goto L32;
        r17 = "";
    L32:
        r16.put(ResourceData.KEY_OBJ_TOKEN, r17);
        r16.put("obj_type", String.valueOf(r11.getType()));
        String r18 = r11.e;
        if (r18 == null) goto L36;
        r5 = r18;
    L36:
        r16.put("parent_token", r5);
        r16.put("title", r13);
        r16.put("time_zone", zu5.b.c());
        if (TextUtils.equals(r11.g, "lark_workspace_bitable_landing") == false) goto L39;
        String r19 = "45";
    L40:
        r16.put("copy_source", r19);
        if (r11.getType() == sbb.e.h.b) goto L43;
    L45:
        r15.d(r16);
        return r12.a(r15).doOnNext(new hd5.a(r3, r11)).doOnError(new hd5.b(r11));
    L43:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.sheet.async_make_copy", false) == false) goto L45;
        r16.put("async", "true");
        goto L45
    L39:
        r19 = "7";
        goto L40
    L28:
        r14 = "/space/api/explorer/clone/";
        goto L29
    L24:
        r10 = new hd5.c.b();
        goto L25
    L16:
        if (TextUtils.isEmpty(r11.d) == true) goto L20;
        if (((((String) r3.element).length() - r7) - 1) < 0) goto L20;
        String r20 = (String) r3.element;
        r8 = r20.substring(0, (r20.length() - r7) - 1) + ' ' + r2 + '.' + r11.d;
        goto L21
    L12:
        r7 = 0;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    @Override // rc5.a
    public final void handleSyncedDoc(final OfflineDoc r3) {
        Flowable.just("").map(new e1()).map(new f1(r3)).subscribe(new h1(r3), new i1());
    }

    @Override // rc5.a
    public final String i(String r2) {
        return ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.a(com.bytedance.ee.bear.contract.c0.class)).i(r2);
    }

    @Override // rc5.a
    public final void j(final String r3) {
        Flowable.just("").map(new v0()).map(new g1(r3)).subscribe(new r1(), new c2());
    }

    @Override // rc5.a
    public final Flowable<Integer> l(final List<String> r3) {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new s2()).map(new t2(r3));
    }

    @Override // rc5.a
    public final void p(com.bytedance.ee.bear.list.u0 r1) {
        this.a = r1;
    }

    @Override // rc5.a
    public final Disposable q(final com.bytedance.ee.bear.contract.q0 r3) {
        return Flowable.just("").map(new m()).map(new n(r3)).subscribe(new p(), new q());
    }

    @Override // rc5.a
    public final void r(com.bytedance.ee.bear.route.h r1) {
        com.bytedance.ee.bear.list.t0.K(r1);
    }

    @Override // rc5.a
    public final String s(String r2) {
        mc5.b r3 = mc5.m.a(this).P9(r2);
        if (r3 == null) goto L7;
        String r4 = r3.c0;
        if (r4 == null) goto L9;
        return r4;
    L9:
        return "";
    L7:
        return "";
    }

    @Override // rc5.a
    public final Flowable<DocumentCreateInfo> t(final com.bytedance.ee.bear.contract.k r3) {
        return Flowable.just("").map(new a2()).flatMap(new b2(r3)).observeOn(fo5.d.d()).doOnError(new d2(r3));
    }

    @Override // rc5.a
    public final void u(com.bytedance.ee.bear.contract.g0 r5) {
        new fd5.e(r5, com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.docs_diy_icon", false)).a(null);
    }

    @Override // rc5.a
    public final void v(String r3) {
        Iterator<WeakReference<dd5.r1>> r4 = dd5.s1.a.a.j.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        WeakReference<dd5.r1> r0 = r4.next();
        if (r0 == null) goto L4;
        if (r0.get() == null) goto L4;
        r0.get().Y3();
        goto L4
    }

    @Override // rc5.a
    public final Disposable w(final com.bytedance.ee.bear.contract.q0 r3) {
        return Flowable.just("").map(new n0()).map(new o0(r3)).subscribe(new p0(), new q0());
    }

    @Override // rc5.a
    public final boolean z(int r1) {
        return ManualOfflineConfig.isEnable(r1);
    }

    @Override // rc5.a
    public final void K(final String r3, final com.bytedance.ee.bear.contract.c0.a r4) {
        Flowable.just("").map(new l2()).map(new m2(r3, r4)).subscribe(new o2(), new p2());
    }

    @Override // rc5.a
    public final void T(final String r3, final String r4) {
        Flowable.just("").map(new j1()).map(new k1(r3, r4)).subscribe(new l1(), new m1());
    }

    @Override // rc5.a
    public final void b(Document r4, FragmentActivity r5) {
        String[] r0 = com.bytedance.ee.bear.list.t0.a;
        Intent r1 = new Intent(r5, FolderComplaintActivity.class);
        r1.putExtra(ResourceData.KEY_TOKEN, r4.d);
        r1.putExtra(ResourceData.KEY_TYPE, r4.getType());
        r1.putExtra("title", r4.a);
        r1.putExtra("desc", r4.S1);
        r1.putExtra("desc", false);
        r1.putExtra(DocumentType.FILE_NAME, true);
        r5.startActivityForResult(r1, 1);
    }

    @Override // rc5.a
    public final Flowable<DocVersion> f(String r2, int r3) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        int r0 = md5.e.a;
        Intrinsics.checkNotNullParameter(r2, "objToken");
        return md5.e.a(r2, r3).map(md5.a.a).onErrorReturn(md5.b.a);
    }

    @Override // rc5.a
    public final Flowable<DocVersion> g(String r2, int r3) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        int r0 = md5.e.a;
        Intrinsics.checkNotNullParameter(r2, "objToken");
        return md5.e.a(r2, r3).map(md5.c.a);
    }

    @Override // rc5.a
    public final String getDocumentDefaultName(Context r1, int r2) {
        return com.bytedance.ee.bear.list.t0.e(r1, r2);
    }

    @Override // rc5.a
    public final void k(final String r3, final int r4) {
        Flowable.just("").map(new v()).map(new w(r3, r4)).subscribe(new x(), new y());
    }

    @Override // rc5.a
    public final Flowable J(final int r3, final String r4, final boolean r5) {
        return Flowable.just("").map(new f2()).flatMap(new g2(r3, r4, r5));
    }

    @Override // rc5.a
    public final void M(final String r3, final int r4, final boolean r5) {
        Flowable.just("").map(new p1()).map(new q1(r3, r4, r5)).subscribe(new s1(r4, r5), new t1());
    }

    @Override // rc5.a
    public final void Q(final String r3, final String r4, final int r5) {
        Flowable.just(Boolean.TRUE).map(new w0()).map(new x0(r3, r4, r5)).subscribe(new y0(r4, r5), new z0());
    }

    @Override // rc5.a
    public final String e(Context r1, int r2, String r3) {
        return com.bytedance.ee.bear.list.t0.f(r1, r2, r3);
    }

    @Override // rc5.a
    public final Flowable<Boolean> y(final String r3, final int r4, final boolean r5) {
        return Flowable.just("").map(new i()).flatMap(new j(r3, r4, r5));
    }

    @Override // rc5.a
    public final void P(final Context r3, final String r4, final int r5, final boolean r6) {
        Flowable.just("").map(new r0()).map(new s0(r3, r4, r5, r6)).subscribe(new t0(r5, r6), new u0());
    }

    @Override // rc5.a
    public final void n(final String r3, final int r4, final int r5, final com.bytedance.ee.bear.contract.c0.a r6) {
        Flowable.just("").map(new h2()).map(new i2(r3, r4, r5, r6)).subscribe(new j2(r4), new k2());
    }
}
