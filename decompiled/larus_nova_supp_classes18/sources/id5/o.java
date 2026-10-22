package id5;

import android.app.Dialog;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.e0;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.v0;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.route.RouteBean;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o extends com.bytedance.ee.bear.list.list.b<com.bytedance.ee.bear.list.list.e, e, com.bytedance.ee.bear.list.list.f.a> {
    @Override // com.bytedance.ee.bear.list.list.b
    public final String J8() {
        return OperationName.OPERATION_OFFLINE_AVAILABLE;
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "ManualOfflineDocumentPresenter";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String K8() {
        return AnalyticConstant.OpenType.OFFLINE.getType();
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void a9(final Document r5) {
        tt5.a.h("ManualOfflineDocumentPresenter", "responseDeleteClick()...");
        String r0 = this.a.getString(2131887947);
        String r1 = this.a.getString(2131887946);
        fp5.a r2 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(r0)).titleSize(16)).titleGravity(8388611)).message(r1)).messageTextSize(14)).messageGravity(8388611);
        r2.e = false;
        Dialog r6 = ((fp5.a) ((fp5.a) r2.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093).text(2131888026).onClickListener(new n(this, r5)))).addActionButton(2131391778, 2131887716, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r6);
    L7:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r6);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
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
        lc5.p r12 = new lc5.p("ccm_space_offline_page_click", OperationName.OPERATION_OFFLINE_AVAILABLE, "none", "share", "ccm_permission_share_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r20.L1, r20.P1), false, 0, Boolean.valueOf(O8()), "suspend_create", t0.m(r20));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.e.a
    public final void s8(int r3, boolean r4) {
        tt5.a.h("ManualOfflineDocumentPresenter", "onRefreshSuccess()...hasMore = " + r4 + ", size = " + r3);
        ((e) getView()).k1(r3, r4);
        this.i = true;
        if (hu5.a.d(((e) getView()).G()) == false) goto L6;
        ((e) getView()).W3(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void h3(Document r27, int r28, boolean r29) {
        tt5.a.h("ManualOfflineDocumentPresenter", "onItemClick()...doc = " + r27.toString());
        FragmentActivity r8 = this.b.getActivity();
        boolean r9 = Q8();
        Context r2 = this.a;
        List<Document> r14 = I8();
        Context r3 = new e0(r2, r27, OperationName.OPERATION_OFFLINE_AVAILABLE, r14, "none", "home").getContext();
        if (r27.getType() != sbb.e.f.b) goto L6;
        sd5.e r1 = new sd5.c(r3, OperationName.OPERATION_OFFLINE_AVAILABLE, 1, "");
    L12:
        RouteBean r5 = r1.a(r27);
        r5.a(this.b);
        t0.r(new v0(r8, r27, r9, r5, OperationName.OPERATION_OFFLINE_AVAILABLE, "none", K8(), r28, r29, 0), this.x);
        lc5.q r4 = new lc5.q("ccm_space_offline_page_click", OperationName.OPERATION_OFFLINE_AVAILABLE, "none", "", r27.d, r27.getType(), r27.F, FolderVersion.isShareFolder(r27.L1, r27.P1), false, 0, t0.m(r27));
        ce5.a r6 = this.x;
        lc5.f.a r7 = lc5.f.a;
        lc5.f.a.K(r4, r6);
        return;
    L6:
        if (r27.getType() != sbb.e.l.b) goto L9;
        r1 = new sd5.b(new e0(r3, r27, OperationName.OPERATION_OFFLINE_AVAILABLE, r14, "none", "home"), "");
        goto L12
    L9:
        if (r27.getType() != sbb.e.n.b) goto L11;
        r1 = new sd5.g();
        goto L12
    L11:
        r1 = new sd5.a(r3);
        goto L12
    }

    public o(e r1, m r2, Context r3, LifeCycleFragment r4, ce5.a r5) {
        super(r1, r2, r3, r4, r5);
    }
}
