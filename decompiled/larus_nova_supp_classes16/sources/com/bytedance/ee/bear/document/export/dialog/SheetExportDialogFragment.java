package com.bytedance.ee.bear.document.export.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.document.export.more.ExportMoreItemV2;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel;
import com.bytedance.ee.bear.document.export.viewmodel.SheetExportViewModel;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import i15.g;
import rw4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SheetExportDialogFragment extends BaseExportDialogFragment<SheetExportViewModel> implements View.OnClickListener, p {
    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final String ba0() {
        return "LARK-PSDA-ccm_docs_sheet_shareexport";
    }

    @Override // com.bytedance.ee.bear.document.orientation.p
    public final boolean shouldDisableLandscape() {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        ((SheetExportViewModel) this.h).onOrientationSupportPanelDismiss(this);
        super.onDestroy();
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final BaseExportViewModel ea0() {
        return (SheetExportViewModel) ViewModelProviders.of(getActivity()).get(SheetExportViewModel.class);
    }

    public SheetExportDialogFragment() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        int r3 = r2.getId();
        if (r3 != 2131371954) goto L6;
        aa0(n.g, null);
        return;
    L6:
        if (r3 != 2131371959) goto L18;
        dismissAllowingStateLoss();     // Catch: Exception -> L9
    L13:
        ((SheetExportViewModel) this.h).onClickSheetLongImage();
        return;
    L9:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L13;
        d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        ((SheetExportViewModel) this.h).onOrientationSupportPanelShowing(this);
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final void da0(LayoutInflater r3, ViewGroup r4) {
        View r5 = r3.inflate(2131560121, r4);
        int r0 = 0;
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        ((ImageView) r5.findViewById(2131371955)).setImageResource(g.a(2131254443));
        ((ImageView) r5.findViewById(2131371960)).setImageResource(g.a(2131254464));
    L11:
        r5.findViewById(2131371954).setOnClickListener(this);
        View r7 = r5.findViewById(2131371959);
        r7.setOnClickListener(this);
        if (((SheetExportViewModel) this.h).shouldShowLongImage() == false) goto L19;
        Bundle r8 = getArguments();
        if (r8 == null) goto L16;
        boolean r9 = r8.getBoolean(ExportMoreItemV2.HAS_PERCEIVE_CONTRAL);
    L17:
        if (r9 == true) goto L19;
    L20:
        r7.setVisibility(r0);
        return;
    L16:
        r9 = false;
    L19:
        r0 = 8;
        goto L20
    L5:
        if (kac.a.a() == true) goto L8;
        r6 = false;
        goto L9
    }
}
