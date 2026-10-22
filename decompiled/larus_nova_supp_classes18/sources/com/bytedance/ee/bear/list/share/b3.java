package com.bytedance.ee.bear.list.share;

import android.app.Dialog;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class b3 extends com.bytedance.ee.bear.list.list.b<m0, n0, n0.a> implements dd5.n1, n0.a {

    public static class a implements com.bytedance.ee.bear.list.s.a {
        public final WeakReference<b3> a;

        public a(b3 r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.list.s.a
        public final void onFail(Throwable r4) {
            if (this.a.get() != null) goto L5;
            return;
        L5:
            tt5.a.h("ShareFolderPresenter", "RemoveItemCallback onFail()... throwable = " + r4);
            b3 r0 = this.a.get();
            ((n0) r0.getView()).s6(false);
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
        public final void onSuccess(String r4) {
            if (this.a.get() != null) goto L5;
            return;
        L5:
            tt5.a.h("ShareFolderPresenter", "RemoveItemCallback onSuccess()...");
            b3 r0 = this.a.get();
            ((m0) r0.getModel()).c(r4);
            ((n0) r0.getView()).s6(false);
            Context r5 = r0.a;
            Toast.showSuccessText(r5, r5.getResources().getString(2131887812), 0);
        }
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public String J8() {
        return "shared";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String L8() {
        return "shared_folder";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public String M8() {
        return "ShareFolderPresenter";
    }

    public String d9() {
        return "ccm_space_folder_click";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String K8() {
        return AnalyticConstant.OpenType.SHARED_SHARED_FOLDER.getType();
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public void create() {
        super.create();
        tt5.a.h("ShareFolderPresenter", "create()...");
    }

    @Override // com.bytedance.ee.bear.list.share.n0.a
    public final void D(Document r4) {
        tt5.a.h(M8(), "onStarClick()...");
        com.bytedance.ee.bear.list.t0.z(this.b.getActivity(), r4, "shared_folder", getSource());
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void a9(final Document r8) {
        tt5.a.h(M8(), "responseDeleteClick()...");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L5;
        int r0 = 60;
    L6:
        String r1 = String.valueOf(r0);
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r8.L1)) == false) goto L9;
        String r2 = this.a.getString(2131889585);
    L10:
        fp5.a r3 = new fp5.a(this.a);
        Context r4 = this.a;
        fp5.a r5 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) r3.title(xo5.a.c(r4, 2131887252, "doc_name", com.bytedance.ee.bear.list.t0.g(r4, r8)))).titleSize(16)).titleGravity(8388611)).message(xo5.a.c(this.a, 2131887253, "num", r1))).messageGravity(8388611);
        r5.b(r2);
        r5.e = false;
        Dialog r9 = ((fp5.a) ((fp5.a) r5.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093).text(2131887736).onClickListener(new a3(this, r8)))).addActionButton(2131391778, 2131887716, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(r9);
    L15:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r9);
        return;
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L14:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L15
    L9:
        r2 = "";
        goto L10
    L5:
        r0 = 30;
        goto L6
    }

    @Override // dd5.n1
    public void b5(String r1) {
        onRefresh();
    }

    public void e9(Document r4) {
        tt5.a.h(M8(), "removeItem()...");
        ((n0) getView()).s6(true);
        String r5 = r4.c;
        a r0 = new a(this);
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_TOKEN, r5);
        com.bytedance.ee.bear.list.s.c("/api/explorer/remove/", r5, r1, r0);
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
        lc5.p r12 = new lc5.p("ccm_space_folder_click", r3, "shared_folder", "share", "ccm_permission_share_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r20.L1, r20.P1), false, 0, Boolean.valueOf(O8()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r20));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void h3(Document r20, int r21, boolean r22) {
        tt5.a.h(M8(), "onItemClick()...doc = " + r20.toString());
        int r1 = r20.getType();
        sbb.e r8 = sbb.e.f;
        if (r1 == r8.b) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L20;
        FragmentActivity r10 = this.b.getActivity();
        boolean r11 = Q8();
        Context r3 = this.a;
        String r15 = J8();
        List<Document> r16 = I8();
        com.bytedance.ee.bear.contract.e0 r14 = new com.bytedance.ee.bear.contract.e0(r3, r20, r15, r16, "shared_folder", "");
        String r7 = r20.d;
        Context r4 = r14.getContext();
        if (r20.getType() != r8.b) goto L13;
        sd5.e r5 = new sd5.c(r4, r15, 0, r7);
    L19:
        RouteBean r6 = r5.a(r20);
        r6.a(this.b);
        com.bytedance.ee.bear.list.t0.r(new com.bytedance.ee.bear.list.v0(r10, r20, r11, r6, J8(), "shared_folder", K8(), r21, r22, 0), this.x);
        goto L20
    L13:
        if (r20.getType() != sbb.e.l.b) goto L16;
        r5 = new sd5.b(new com.bytedance.ee.bear.contract.e0(r4, r20, r15, r16, "shared_folder", ""), r7);
        goto L19
    L16:
        if (r20.getType() != sbb.e.n.b) goto L18;
        r5 = new sd5.g();
        goto L19
    L18:
        r5 = new sd5.a(r4);
    L20:
        ((m0) getModel()).K1(r20.d);
        lc5.q r9 = new lc5.q(d9(), J8(), "shared_folder", "", r20.d, r20.getType(), r20.F, FolderVersion.isShareFolder(r20.L1, r20.P1), false, 0, com.bytedance.ee.bear.list.t0.m(r20));
        ce5.a r12 = this.x;
        lc5.f.a r13 = lc5.f.a;
        lc5.f.a.K(r9, r12);
        return;
    L5:
        if (uc5.d1.b(this.b) == false) goto L7;
        r2 = uc5.d1.c(this.b, r20, J8());
        tt5.a.h(M8(), "onItemClick()...open shared folder by office host = " + r2);
        goto L8
    }

    public b3(n0 r1, m0 r2, Context r3, LifeCycleFragment r4, ce5.a r5) {
        super(r1, r2, r3, r4, r5);
    }
}
