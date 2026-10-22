package com.bytedance.ee.bear.document.restore;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.document.restore.api.RestoreFileResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ DocDeletedCtrlView a;

    public c(DocDeletedCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        cu5.b.a r12 = (cu5.b) r11;
        DocDeletedView r0 = this.a.c;
        if (r0 == null) goto L5;
        r0.setIsRestoring(false);
    L5:
        boolean r2 = true;
        if ((r12 instanceof cu5.b.b) == false) goto L11;
        DocDeletedView r13 = this.a.c;
        if (r13 == null) goto L53;
        r13.setIsRestoring(true);
        return;
    L53:
        return;
    L11:
        if ((r12 instanceof cu5.b.c) == false) goto L20;
        Toast.showSuccessText(this.a.getContext(), 2131887523);
        com.bytedance.ee.bear.b.a r14 = this.a.d;
        if (r14 == null) goto L15;
        r14.a();
    L15:
        int r16 = d.a;
        HashMap<String, Object> r17 = this.a.e;
        if (r17 == null) goto L56;
        HashMap r1 = new HashMap();
        r1.putAll(r17);
        r1.put("if_success", String.valueOf(true));
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_recover_result_view", r1);
        return;
    L56:
        return;
    L20:
        if ((r12 instanceof cu5.b.a) == false) goto L49;
        RestoreFileResult r18 = (RestoreFileResult) r12.b;
        if (r18 == null) goto L24;
        RestoreFileResult.FailDataNoPermInfo r19 = (RestoreFileResult.FailDataNoPermInfo) r18.getFailDataOrNull(RestoreFileResult.FailDataNoPermInfo.class);
    L25:
        StringBuilder r3 = new StringBuilder("restore fail. failData?=");
        if (r19 == null) goto L29;
        r2 = false;
    L29:
        r3.append(r2);
        tt5.a.h("DocDeletedCtrlView", r3.toString());
        if (r19 == null) goto L42;
        int r4 = DocDeletedRestoreFailDialog.l;
        FragmentActivity r5 = this.a.getContext();
        Intrinsics.checkNotNullParameter(r19, "noPermInfo");
        if ((r5 instanceof FragmentActivity) == false) goto L34;
        FragmentActivity r6 = r5;
    L35:
        if (r6 == null) goto L43;
        tt5.a.h("DocRestoreFailDialog", "DocRestoreFailDialog.show");
        final DocDeletedRestoreFailDialog.ParamsViewModel r7 = (DocDeletedRestoreFailDialog.ParamsViewModel) new ViewModelProvider(r6).get(DocDeletedRestoreFailDialog.ParamsViewModel.class);
        r7.setNoPermInfo(r19);
        final DocDeletedRestoreFailDialog r110 = new DocDeletedRestoreFailDialog();
        r110.getLifecycle().addObserver(new DocDeletedRestoreFailDialog$Companion$show$1(r7, r110));
        FragmentManager r8 = r6.getSupportFragmentManager();
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r110, "DocRestoreFailDialog", r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r110, r9) == true) goto L43;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
    L41:
        r110.show(r8, "DocRestoreFailDialog");
    L43:
        int r111 = d.a;
        HashMap<String, Object> r112 = this.a.e;
        if (r112 == null) goto L57;
        HashMap r10 = new HashMap();
        r10.putAll(r112);
        r10.put("if_success", String.valueOf(false));
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_recover_result_view", r10);
        return;
    L57:
        return;
    L34:
        r6 = null;
        goto L35
    L42:
        Toast.showFailureText(this.a.getContext(), 2131887464);
        goto L43
    L24:
        r19 = null;
        goto L25
    L49:
        throw new NoWhenBranchMatchedException();
    }
}
