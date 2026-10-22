package com.bytedance.ee.bear.list.share;

import android.app.Dialog;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c2 extends com.bytedance.ee.bear.list.list.b<j0, k0, com.bytedance.ee.bear.list.list.f.a> {
    public SortAndFilterViewModel y;
    public Disposable z;

    public static class a implements com.bytedance.ee.bear.list.s.a {
        public final WeakReference<c2> a;

        public a(c2 r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.list.s.a
        public final void onFail(Throwable r4) {
            WeakReference<c2> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L17;
            tt5.a.h("ShareDocumentPresenter", "RemoveItemCallback onFail()...throwable = " + r4);
            c2 r1 = this.a.get();
            ((k0) r1.getView()).s6(false);
            if (com.bytedance.ee.bear.contract.k0.c(r4) == false) goto L11;
            return;
        L11:
            if (ax4.d.b(r4, 4202) == false) goto L13;
            Toast.showFailureText(r1.a, 2131887146);
            return;
        L13:
            Context r5 = r1.a;
            Toast.showFailureText(r5, r5.getResources().getString(2131887810), 0);
            return;
        }

        @Override // com.bytedance.ee.bear.list.s.a
        public final void onSuccess(String r4) {
            WeakReference<c2> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L10;
            tt5.a.h("ShareDocumentPresenter", "RemoveItemCallback onSuccess()...");
            c2 r1 = this.a.get();
            ((j0) r1.getModel()).c(r4);
            ((k0) r1.getView()).s6(false);
            Context r5 = r1.a;
            Toast.showSuccessText(r5, r5.getResources().getString(2131887812), 0);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String J8() {
        return "shared";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String L8() {
        return "sharetome";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "ShareDocumentPresenter";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final boolean P8() {
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String K8() {
        return AnalyticConstant.OpenType.SHARED_SHARE_TOME.getType();
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void create() {
        super.create();
        if (this.b.getActivity() != null) goto L6;
        tt5.a.d("ShareDocumentPresenter", "observeSortAndFilter()...activity is null");
    L9:
        tt5.a.h("ShareDocumentPresenter", "create()...");
        return;
    L6:
        if (this.y != null) goto L8;
        this.y = (SortAndFilterViewModel) ViewModelProviders.of(this.b.getActivity()).get(SortAndFilterViewModel.class);
    L8:
        this.y.getSortStrategyLiveData().observe(this.b, new z1(this));
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void a9(final Document r4) {
        tt5.a.h("ShareDocumentPresenter", "responseDeleteClick()...");
        fp5.a r0 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(2131887967)).titleSize(16)).titleGravity(8388611)).message(2131887968)).messageTextSize(14)).messageGravity(8388611);
        r0.e = false;
        Dialog r5 = ((fp5.a) ((fp5.a) r0.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093).text(2131887736).onClickListener(new y1(this, r4)))).addActionButton(2131391778, 2131887716, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r5);
    L7:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r5);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L7
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
        lc5.p r12 = new lc5.p("ccm_space_shared_page_click", "shared", "sharetome", "share", "ccm_permission_share_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r20.L1, r20.P1), false, 0, Boolean.valueOf(O8()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r20));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void h3(Document r27, int r28, boolean r29) {
        tt5.a.h("ShareDocumentPresenter", "onItemClick()...doc = " + r27.toString());
        FragmentActivity r8 = this.b.getActivity();
        boolean r9 = Q8();
        Context r2 = this.a;
        List<Document> r14 = I8();
        Context r3 = new com.bytedance.ee.bear.contract.e0(r2, r27, "shared", r14, "sharetome", "home").getContext();
        if (r27.getType() != sbb.e.f.b) goto L6;
        sd5.e r1 = new sd5.c(r3, "shared", 1, "");
    L12:
        com.bytedance.ee.bear.list.t0.r(new com.bytedance.ee.bear.list.v0(r8, r27, r9, r1.a(r27), "shared", "sharetome", K8(), r28, r29, 0), this.x);
        lc5.q r4 = new lc5.q("ccm_space_shared_page_click", "shared", "sharetome", "", r27.d, r27.getType(), r27.F, FolderVersion.isShareFolder(r27.L1, r27.P1), false, 0, com.bytedance.ee.bear.list.t0.m(r27));
        ce5.a r5 = this.x;
        lc5.f.a r6 = lc5.f.a;
        lc5.f.a.K(r4, r5);
        return;
    L6:
        if (r27.getType() != sbb.e.l.b) goto L9;
        r1 = new sd5.b(new com.bytedance.ee.bear.contract.e0(r3, r27, "shared", r14, "sharetome", "home"), "");
        goto L12
    L9:
        if (r27.getType() != sbb.e.n.b) goto L11;
        r1 = new sd5.g();
        goto L12
    L11:
        r1 = new sd5.a(r3);
        goto L12
    }

    public c2(k0 r1, x1 r2, Context r3, LifeCycleFragment r4, ce5.a r5) {
        super(r1, r2, r3, r4, r5);
    }
}
