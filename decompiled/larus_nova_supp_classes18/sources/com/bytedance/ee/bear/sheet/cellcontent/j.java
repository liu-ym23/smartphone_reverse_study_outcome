package com.bytedance.ee.bear.sheet.cellcontent;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.suite.lark.emm.impl.SCClipboardProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements ActionMode.Callback {
    public final /* synthetic */ SheetCellContentPanelFragment a;

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r1, Menu r2) {
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r1) {
    }

    public j(SheetCellContentPanelFragment r1) {
        this.a = r1;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r5, MenuItem r6) {
        if (r6.getItemId() == 16908321) goto L5;
    L8:
        return false;
    L5:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).u(this.a.f, new Token("LARK-PSDA-ccm_android_sheet_cell_content_panel_copy_select")) == false) goto L8;
        FragmentActivity r7 = this.a.getActivity();
        Intrinsics.checkNotNullParameter(r7, "context");
        FlowToast.a r8 = FlowToast.a(r7);
        r8.c(17, 0, 0);
        r8.e(2131887392);
        r8.d = 1000;
        r8.a().show();
        r5.finish();
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r1, Menu r2) {
        int r3 = com.suite.lark.emm.impl.a.a;
        com.suite.lark.emm.impl.a.a.a().getClass();
        SCClipboardProvider.a().S0(r2);
        return true;
    }
}
