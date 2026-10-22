package jd5;

import android.app.Dialog;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.v0;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import dd5.i1;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q0 extends com.bytedance.ee.bear.list.list.b<j, k, com.bytedance.ee.bear.list.list.f.a> implements i1 {
    public SortAndFilterViewModel y;
    public Disposable z;

    public static class a implements com.bytedance.ee.bear.contract.c0.a {
        public final WeakReference<q0> a;

        public final void a() {
            tt5.a.h("MyDocumentPresenter", "onPostExecuteSuccess()...");
            WeakReference<q0> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L10;
            com.bytedance.ee.util.ui.m.a(new n0(this));
            return;
        }

        public final void c() {
            tt5.a.h("MyDocumentPresenter", "onPreExecute()...");
            WeakReference<q0> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L10;
            com.bytedance.ee.util.ui.m.a(new o0(this));
            return;
        }

        public a(q0 r2) {
            this.a = new WeakReference(r2);
        }

        public final void b(boolean r3) {
            tt5.a.h("MyDocumentPresenter", "onOfflinePostExecute()...success = " + r3);
            WeakReference<q0> r4 = this.a;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.get() == null) goto L10;
            com.bytedance.ee.util.ui.m.a(new p0(this));
            return;
        }

        public final void d(final int r1, Throwable r2, String r3, int r4) {
            tt5.a.h("MyDocumentPresenter", "onPostExecuteFail()...");
            WeakReference<q0> r5 = this.a;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.get() == null) goto L10;
            com.bytedance.ee.util.ui.m.a(new m0(this, r1));
            return;
        }
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String J8() {
        return WikiSpaceType.PERSONAL;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String L8() {
        return "belongtome";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "MyDocumentPresenter";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String K8() {
        return AnalyticConstant.OpenType.PERSONAL_OWN.getType();
    }

    @Override // dd5.i1
    public final void m4() {
        tt5.a.h("MyDocumentPresenter", "onMakeCopy()...");
        onRefresh();
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void create() {
        super.create();
        Fragment r0 = this.b;
        if (r0 != null) goto L5;
    L10:
        tt5.a.h("MyDocumentPresenter", "create()...");
        return;
    L5:
        if (r0.getActivity() == null) goto L10;
        if (this.y != null) goto L9;
        this.y = (SortAndFilterViewModel) ViewModelProviders.of(this.b.getActivity()).get(SortAndFilterViewModel.class);
    L9:
        this.y.getSortStrategyLiveData().observe(this.b, new e0(this));
        goto L10
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void destroy() {
        super.destroy();
        Disposable r0 = this.z;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        this.z.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void a9(final Document r7) {
        tt5.a.h("MyDocumentPresenter", "responseDeleteClick()...");
        HashMap r0 = new HashMap();
        r0.put("filename", t0.g(this.a, r7));
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L5;
        int r1 = 60;
    L6:
        String r2 = String.valueOf(r1);
        boolean r3 = AppInfoUtils.f().booleanValue();
        if (r3 == false) goto L9;
        String r4 = this.a.getString(2131889453);
    L10:
        if (r3 == false) goto L12;
        String r5 = this.a.getString(2131889414);
    L13:
        if (r3 == false) goto L15;
        int r6 = 2131889413;
    L16:
        if (r3 == false) goto L18;
        int r8 = 2131888904;
    L19:
        fp5.a r9 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(r4)).titleSize(16)).titleGravity(8388611)).message(r5)).messageTextSize(14)).messageGravity(8388611);
        r9.e = false;
        Dialog r10 = ((fp5.a) ((fp5.a) r9.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093).text(r6).onClickListener(new f0(this, r7)))).addActionButton(2131391778, r8, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r10);
    L24:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r10);
        return;
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L23:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        goto L24
    L18:
        r8 = 2131887716;
        goto L19
    L15:
        r6 = 2131887736;
        goto L16
    L12:
        r5 = xo5.a.c(this.a, 2131889588, "num", r2);
        goto L13
    L9:
        r4 = xo5.a.d(this.a, 2131889584, r0);
        goto L10
    L5:
        r1 = 30;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.f.a
    public final void u8(Document r20) {
        super.u8(r20);
        String r6 = r20.d;
        int r7 = r20.getType();
        String r8 = r20.F;
        if (r20.getType() != sbb.e.f.b) goto L5;
        boolean r10 = true;
    L6:
        boolean r11 = FolderVersion.isShareFolder(r20.L1, r20.P1);
        Boolean r14 = Boolean.valueOf(O8());
        if (O8() == false) goto L9;
        String r0 = "middle";
    L10:
        lc5.p r15 = new lc5.p("ccm_space_personal_page_click", WikiSpaceType.PERSONAL, "belongtome", "share", "ccm_permission_share_view", r6, r7, r8, "", r10, r11, false, 0, r14, r0, null);
        lc5.f.a.I(r15);
        return;
    L9:
        r0 = "suspend_create";
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void h3(Document r27, int r28, boolean r29) {
        tt5.a.h("MyDocumentPresenter", "onItemClick()...doc = " + r27.toString());
        FragmentActivity r8 = this.b.getActivity();
        boolean r9 = Q8();
        Context r2 = this.a;
        List<Document> r14 = I8();
        Context r3 = new com.bytedance.ee.bear.contract.e0(r2, r27, WikiSpaceType.PERSONAL, r14, "belongtome", "home").getContext();
        if (r27.getType() != sbb.e.f.b) goto L6;
        sd5.e r1 = new sd5.c(r3, WikiSpaceType.PERSONAL, 1, "");
    L12:
        t0.r(new v0(r8, r27, r9, r1.a(r27), WikiSpaceType.PERSONAL, "belongtome", K8(), r28, r29, 0), this.x);
        lc5.q r4 = new lc5.q("ccm_space_personal_page_click", WikiSpaceType.PERSONAL, "belongtome", "", r27.d, r27.getType(), r27.F, FolderVersion.isShareFolder(r27.L1, r27.P1), false, 0, t0.m(r27));
        ce5.a r5 = this.x;
        lc5.f.a r6 = lc5.f.a;
        lc5.f.a.K(r4, r5);
        return;
    L6:
        if (r27.getType() != sbb.e.l.b) goto L9;
        r1 = new sd5.b(new com.bytedance.ee.bear.contract.e0(r3, r27, WikiSpaceType.PERSONAL, r14, "belongtome", "home"), "");
        goto L12
    L9:
        if (r27.getType() != sbb.e.n.b) goto L11;
        r1 = new sd5.g();
        goto L12
    L11:
        r1 = new sd5.a(r3);
        goto L12
    }

    public q0(k r1, d0 r2, Context r3, LifeCycleFragment r4, ce5.a r5) {
        super(r1, r2, r3, r4, r5);
    }
}
