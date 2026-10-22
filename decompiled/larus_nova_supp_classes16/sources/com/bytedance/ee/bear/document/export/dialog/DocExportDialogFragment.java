package com.bytedance.ee.bear.document.export.dialog;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.export.DocumentExportType;
import com.bytedance.ee.bear.document.export.more.ExportMoreItemV2;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel;
import com.bytedance.ee.bear.document.export.viewmodel.DocExportViewModel;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.LarkContext;
import g15.w;
import i15.g;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import rw4.b;
import rw4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocExportDialogFragment extends BaseExportDialogFragment<DocExportViewModel> implements View.OnClickListener {
    public static final /* synthetic */ int s = 0;
    public final int p;
    public final int q;
    public View r;

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final String ba0() {
        return "LARK-PSDA-ccm_docs_doc_shareexport";
    }

    public DocExportDialogFragment() {
        this.p = n.d(168);
        this.q = n.d(110);
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final BaseExportViewModel ea0() {
        return (DocExportViewModel) ViewModelProviders.of(getActivity()).get(DocExportViewModel.class);
    }

    public static void ka0(DocumentExportType r3) {
        b r0 = new b(r3);
        int r4 = w.a;
        Intrinsics.checkNotNullParameter(r0, "params");
        ((d) LarkContext.spiByDwarf(d.class)).j1(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("DocumentExportResultDispatcher", "dispatch export click failed", th, false);
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final void ga0(Configuration r3) {
        View r0 = this.r;
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        int r4 = r3.orientation;
        if (r4 != 2) goto L8;
        r1.height = this.q;
    L10:
        this.r.setLayoutParams(r1);
        return;
    L8:
        if (r4 != 1) goto L10;
        r1.height = this.p;
        goto L10
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        String r2 = null;
        if (r6.getId() != 2131371971) goto L6;
        ka0(DocumentExportType.WORD);
        aa0(rw4.n.c, null);
        return;
    L6:
        if (r6.getId() != 2131371963) goto L9;
        ka0(DocumentExportType.PDF);
        aa0(rw4.n.d, null);
        return;
    L9:
        if (r6.getId() != 2131371961) goto L12;
        ka0(DocumentExportType.MARKDOWN);
        aa0(rw4.n.j, null);
        return;
    L12:
        if (r6.getId() != 2131371969) goto L15;
        ka0(DocumentExportType.TXT);
        aa0(rw4.n.i, null);
        return;
    L15:
        if (r6.getId() != 2131371957) goto L43;
        ka0(DocumentExportType.IMAGE);
        dismissAllowingStateLoss();     // Catch: Exception -> L19
    L23:
        DocExportViewModel.a r7 = ((DocExportViewModel) this.h).getDelegate();
        if (r7 == null) goto L44;
        Bundle r0 = getArguments();
        if (r0 != null) goto L28;
        tt5.a.h("DocExportDialogFragment", "getDocShotExportType return=null, exportScene=null");
    L35:
        r7.c(r2);
        return;
    L28:
        String r1 = r0.getString("arg_export_scene");
        if ("vc_summary_tab".equals(r1) == false) goto L32;
        r2 = "summary";
    L34:
        tt5.a.h("DocExportDialogFragment", "getDocShotExportType return=" + r2 + ", exportScene=" + r1);
        goto L35
    L32:
        if ("vc_transcript_tab".equals(r1) == false) goto L34;
        r2 = "transcript";
        goto L34
    L44:
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L23;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final void da0(LayoutInflater r8, ViewGroup r9) {
        View r10 = r8.inflate(2131560120, r9);
        List r11 = en4.a.g();
        if (r11 != null) goto L5;
        r11 = Collections.emptyList();
    L5:
        this.r = r10.findViewById(2131369390);
        if (r11.contains("image") == true) goto L8;
    L15:
        boolean r0 = false;
    L16:
        ja0(r10, 2131371971, 2131371972, 2131254746, r11.contains("docx"));
        ja0(r10, 2131371963, 2131371964, 2131254594, r11.contains("pdf"));
        ja0(r10, 2131371957, 2131371958, 2131254464, r0);
        ja0(r10, 2131371961, 2131371962, 2131254554, r11.contains("markdown"));
        ja0(r10, 2131371969, 2131371970, 2131254717, r11.contains("txt"));
        return;
    L8:
        if (((DocExportViewModel) this.h).shouldShowDocShot() == false) goto L15;
        Bundle r1 = getArguments();
        if (r1 == null) goto L12;
        boolean r2 = r1.getBoolean(ExportMoreItemV2.HAS_PERCEIVE_CONTRAL);
    L13:
        if (r2 == true) goto L15;
        r0 = true;
        goto L16
    L12:
        r2 = false;
        goto L13
    }

    public final void ja0(View r1, int r2, int r3, int r4, boolean r5) {
        View r6 = r1.findViewById(r2);
        if (r6 != null) goto L5;
        return;
    L5:
        ImageView r7 = (ImageView) r1.findViewById(r3);
        DocExportDialogFragment r8 = null;
        if (r7 == null) goto L9;
        r7.setImageTintList(null);
        r7.setImageResource(g.a(r4));
    L9:
        if (r5 == false) goto L11;
        int r9 = 0;
    L12:
        r6.setVisibility(r9);
        if (r5 == false) goto L15;
        r8 = this;
    L15:
        r6.setOnClickListener(r8);
        return;
    L11:
        r9 = 8;
        goto L12
    }
}
