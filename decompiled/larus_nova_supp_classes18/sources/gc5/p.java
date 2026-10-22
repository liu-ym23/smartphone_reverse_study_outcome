package gc5;

import android.app.Dialog;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.e0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.ainote.AINoteListModel;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.v0;
import com.bytedance.ee.bear.route.RouteBean;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
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
import uc5.g2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p extends com.bytedance.ee.bear.list.list.b<g2, com.bytedance.ee.bear.list.folder.d, com.bytedance.ee.bear.list.folder.d.a> implements i1, h1, r1, k1, com.bytedance.ee.bear.list.folder.d.a {
    public final String y;

    public static class a implements c0.a {
        public final WeakReference<p> a;

        public final void a() {
            tt5.a.h("AINoteListPresenter", "onPostExecuteSuccess()...");
            if (this.a.get() != null) goto L5;
            return;
        L5:
            com.bytedance.ee.util.ui.m.a(new l(this));
        }

        public final void c() {
            tt5.a.h("AINoteListPresenter", "onPreExecute()...");
            if (this.a.get() != null) goto L5;
            return;
        L5:
            com.bytedance.ee.util.ui.m.a(new n(this));
        }

        public a(p r2) {
            this.a = new WeakReference(r2);
        }

        public final void b(boolean r3) {
            tt5.a.h("AINoteListPresenter", "onOfflinePostExecute()...success = " + r3);
            if (this.a.get() != null) goto L5;
            return;
        L5:
            com.bytedance.ee.util.ui.m.a(new o(this));
        }

        public final void d(final int r8, final Throwable r9, final String r10, final int r11) {
            tt5.a.h("AINoteListPresenter", "onPostExecuteFail()...");
            if (this.a.get() != null) goto L5;
            return;
        L5:
            com.bytedance.ee.util.ui.m.a(new m(this, r9, r10, r11, r8));
        }
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String J8() {
        return "ai_notes";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "AINoteListPresenter";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String K8() {
        return AnalyticConstant.OpenType.SPACE_AI_NOTES.getType();
    }

    @Override // dd5.i1
    public final void m4() {
        tt5.a.h("AINoteListPresenter", "onMakeCopy()...");
        onRefresh();
    }

    @Override // dd5.r1
    public final void Y3() {
        onRefresh();
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void create() {
        super.create();
    }

    @Override // dd5.k1
    public final void F3(final OfflineDoc r3) {
        tt5.a.h("AINoteListPresenter", "onOfflineDocCreated()...");
        Disposable r4 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new f(this, r3), new g());
        this.t.add(r4);
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void a9(final Document r10) {
        tt5.a.h("AINoteListPresenter", "responseDeleteClick()...");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L5;
        int r0 = 60;
    L6:
        String r1 = String.valueOf(r0);
        int r2 = r10.getType();
        sbb.e r3 = sbb.e.f;
        if (r2 == r3.b) goto L9;
    L11:
        String r4 = "";
    L13:
        if (NodeType.isShortcut(r10.M1) == false) goto L15;
        String r5 = xo5.a.c(this.a, 2131887254, "doc_name", r10.a);
        String r6 = xo5.a.c(this.a, 2131889588, "num", r1);
    L22:
        fp5.a r7 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(r5)).titleSize(16)).titleGravity(8388611)).message(r6)).messageTextSize(14)).messageGravity(8388611);
        r7.b(r4);
        r7.e = false;
        Dialog r11 = ((fp5.a) ((fp5.a) r7.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093).text(2131887736).onClickListener(new h(this, r10)))).addActionButton(2131391778, 2131887716, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L30;
        DialogLancet.handleBlockedDialogShow(r11);
    L27:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r11);
        return;
    L30:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L26:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L27
    L15:
        Context r8 = this.a;
        String r9 = xo5.a.c(r8, 2131887252, "doc_name", t0.g(r8, r10));
        if (r10.getType() == r3.b) goto L18;
    L20:
        r6 = xo5.a.c(this.a, 2131889588, "num", r1);
    L21:
        r5 = r9;
        goto L22
    L18:
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r10.L1)) == false) goto L20;
        r6 = xo5.a.c(this.a, 2131887253, "num", r1);
        goto L21
    L9:
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r10.L1)) == false) goto L11;
        r4 = this.a.getString(2131889585);
        goto L13
    L5:
        r0 = 30;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.folder.d.a
    public final void k(rf5.d r4) {
        g2 r0 = (g2) getModel();
        qc5.a.i(this.x);
        Disposable r5 = r0.b7(r4).delay(5, TimeUnit.SECONDS).observeOn(fo5.d.d()).subscribe(new j(this), new k());
        this.t.add(r5);
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.f.a
    public final void u8(Document r20) {
        super.u8(r20);
        String r7 = r20.d;
        int r8 = r20.getType();
        String r9 = r20.F;
        if (r20.getType() != sbb.e.f.b) goto L5;
        boolean r18 = true;
    L6:
        boolean r11 = r18;
        lc5.p r12 = new lc5.p("ccm_space_ai_notes_click", "ai_notes", "none", "share", "ccm_permission_share_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r20.L1, r20.P1), false, 0, Boolean.valueOf(O8()), "suspend_create", t0.m(r20));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.b, dd5.l1
    public final void x2(final OfflineDoc r3) {
        super.x2(r3);
        tt5.a.h("AINoteListPresenter", "onOfflineDocSynced()...");
        Disposable r4 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new i(this, r3));
        this.t.add(r4);
    }

    @Override // dd5.h1
    public final void X2(String r1, String r2) {
        ((g2) getModel()).c(r1);
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.e.a
    public final void s8(int r3, boolean r4) {
        tt5.a.h("AINoteListPresenter", "onRefreshSuccess()...hasMore = " + r4 + ", size = " + r3);
        ((com.bytedance.ee.bear.list.folder.d) getView()).k1(r3, r4);
        this.i = true;
        if (hu5.a.d(((com.bytedance.ee.bear.list.folder.d) getView()).G()) == false) goto L5;
        ((com.bytedance.ee.bear.list.folder.d) getView()).W3(r3);
    L5:
        X8();
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void h3(Document r32, int r33, boolean r34) {
        tt5.a.h("AINoteListPresenter", "onItemClick()...doc = " + r32.toString());
        FragmentActivity r8 = this.b.getActivity();
        boolean r9 = Q8();
        Context r2 = this.a;
        List<Document> r14 = I8();
        Context r3 = new e0(r2, r32, "ai_notes", r14, "none", "ai_note_owned_by_me").getContext();
        if (r32.getType() != sbb.e.f.b) goto L6;
        sd5.e r1 = new sd5.c(r3, "ai_notes", 1, "");
    L12:
        RouteBean r5 = r1.a(r32);
        r5.a(this.b);
        t0.r(new v0(r8, r32, r9, r5, "ai_notes", "none", K8(), r33, r34, 0), this.x);
        lc5.f.a.l(new lc5.p("ccm_space_ai_notes_click", "ai_notes", "none", "list_item", "", r32.d, r32.getType(), r32.F, "", false, false, false, 0, null, "", null), null, null, this.y);
        return;
    L6:
        if (r32.getType() != sbb.e.l.b) goto L9;
        r1 = new sd5.b(new e0(r3, r32, "ai_notes", r14, "none", "ai_note_owned_by_me"), "");
        goto L12
    L9:
        if (r32.getType() != sbb.e.n.b) goto L11;
        r1 = new sd5.g();
        goto L12
    L11:
        r1 = new sd5.a(r3);
        goto L12
    }

    public p(com.bytedance.ee.bear.list.folder.d r1, AINoteListModel r2, Context r3, LifeCycleFragment r4, ce5.a r5, String r6) {
        super(r1, r2, r3, r4, r5);
        this.x = r5;
        this.y = r6;
    }
}
