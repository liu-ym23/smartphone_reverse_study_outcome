package com.bytedance.ee.bear.document.export.dialog;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.document.export.more.ExportMoreItemV2;
import com.bytedance.ee.bear.document.export.view.FileExportTypeItemView;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel;
import com.bytedance.ee.bear.document.export.viewmodel.DocExportViewModel;
import com.bytedance.ee.bear.document.quota.ShowQuotaBannerPlugin;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import i15.g;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocExportChooseDialogFragment extends BaseExportDialogFragment<DocExportViewModel> implements View.OnClickListener {
    public static final /* synthetic */ int z = 0;
    public final int p;
    public final int q;
    public View r;
    public FileExportTypeItemView s;
    public FileExportTypeItemView t;
    public FileExportTypeItemView u;
    public FileExportTypeItemView v;
    public FileExportTypeItemView w;
    public View x;
    public int y;

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final String ba0() {
        return "LARK-PSDA-ccm_docs_doc_shareexport";
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final int ca0() {
        return 2131887700;
    }

    public final void ka0() {
        FileExportTypeItemView r0 = this.s;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.t != null) goto L7;
        return;
    L7:
        if (this.u != null) goto L9;
        return;
    L9:
        if (this.v != null) goto L11;
        return;
    L11:
        if (this.w == null) goto L38;
        boolean r2 = false;
        if (this.y != 1) goto L16;
        boolean r1 = true;
    L17:
        r0.setSelected(r1);
        FileExportTypeItemView r3 = this.t;
        if (this.y != 2) goto L20;
        boolean r4 = true;
    L21:
        r3.setSelected(r4);
        FileExportTypeItemView r5 = this.u;
        if (this.y != 3) goto L24;
        boolean r6 = true;
    L25:
        r5.setSelected(r6);
        FileExportTypeItemView r7 = this.v;
        if (this.y != 4) goto L28;
        boolean r8 = true;
    L29:
        r7.setSelected(r8);
        FileExportTypeItemView r9 = this.w;
        if (this.y != 5) goto L32;
        r2 = true;
    L32:
        r9.setSelected(r2);
        return;
    L28:
        r8 = false;
        goto L29
    L24:
        r6 = false;
        goto L25
    L20:
        r4 = false;
        goto L21
    L16:
        r1 = false;
        goto L17
    }

    public DocExportChooseDialogFragment() {
        this.p = n.d(224);
        this.q = n.d(160);
        this.y = 1;
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final BaseExportViewModel ea0() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        return (DocExportViewModel) ViewModelProviders.of(r0).get(DocExportViewModel.class);
    L7:
        throw new IllegalStateException("Activity is null when creating DocExportViewModel");
    }

    public final String ja0() {
        Bundle r0 = getArguments();
        String r1 = null;
        if (r0 != null) goto L5;
        String r2 = null;
    L7:
        if ("summary".equals(r2) == false) goto L10;
        r1 = "vc_summary_tab";
    L10:
        if ("transcript".equals(r2) == false) goto L13;
        r1 = "vc_transcript_tab";
    L13:
        if (r1 != null) goto L20;
        return "";
    L20:
        return new JSONObject().put("tab_type", r1).put("time_zone_offset", (-TimeZone.getDefault().getOffset(System.currentTimeMillis())) / ShowQuotaBannerPlugin.NEED_SHOW_CREATE_TIME_INTERVAL).toString();
    L17:
        e = move-exception;
        tt5.a.e("DocExportChooseDialog", "build passback json fail, tabType=".concat(r1), e, false);
        return "";
    L5:
        r2 = r0.getString("arg_audio_minutes_export_target");
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final void ga0(Configuration r3) {
        View r0 = this.r;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = -2;
        this.r.setLayoutParams(r1);
        View r2 = this.r;
        if (r3.orientation != 2) goto L8;
        int r4 = this.q;
    L9:
        r2.setMinimumHeight(r4);
        return;
    L8:
        r4 = this.p;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r9 = r8.getId();
        boolean r1 = true;
        if (r9 != 2131371971) goto L7;
        this.y = 1;
        ka0();
        return;
    L7:
        if (r9 != 2131371963) goto L11;
        this.y = 2;
        ka0();
        return;
    L11:
        if (r9 != 2131371957) goto L15;
        this.y = 3;
        ka0();
        return;
    L15:
        if (r9 != 2131371961) goto L19;
        this.y = 4;
        ka0();
        return;
    L19:
        if (r9 != 2131371969) goto L23;
        this.y = 5;
        ka0();
        return;
    L23:
        if (r9 != 2131371946) goto L103;
        int r10 = this.y;
        String r6 = null;
        if (r10 != 1) goto L36;
        rw4.n r11 = rw4.n.c;
        Bundle r2 = getArguments();
        if (r2 != null) goto L29;
        String r3 = null;
    L30:
        if (r3 != null) goto L33;
        r1 = false;
    L33:
        if (r1 == false) goto L35;
        r6 = ja0();
    L35:
        aa0(r11, r6);
        return;
    L29:
        r3 = r2.getString("arg_audio_minutes_export_target");
        goto L30
    L36:
        if (r10 != 2) goto L47;
        rw4.n r12 = rw4.n.d;
        Bundle r4 = getArguments();
        if (r4 != null) goto L40;
        String r5 = null;
    L41:
        if (r5 != null) goto L44;
        r1 = false;
    L44:
        if (r1 == false) goto L46;
        r6 = ja0();
    L46:
        aa0(r12, r6);
        return;
    L40:
        r5 = r4.getString("arg_audio_minutes_export_target");
        goto L41
    L47:
        if (r10 != 4) goto L58;
        rw4.n r13 = rw4.n.j;
        Bundle r7 = getArguments();
        if (r7 != null) goto L51;
        String r14 = null;
    L52:
        if (r14 != null) goto L55;
        r1 = false;
    L55:
        if (r1 == false) goto L57;
        r6 = ja0();
    L57:
        aa0(r13, r6);
        return;
    L51:
        r14 = r7.getString("arg_audio_minutes_export_target");
        goto L52
    L58:
        if (r10 != 5) goto L101;
        rw4.n r16 = rw4.n.i;
        Bundle r17 = getArguments();
        if (r17 != null) goto L62;
        String r18 = null;
    L63:
        if (r18 != null) goto L66;
        r1 = false;
    L66:
        if (r1 == false) goto L68;
        r6 = ja0();
    L68:
        aa0(r16, r6);
        return;
    L62:
        r18 = r17.getString("arg_audio_minutes_export_target");
        goto L63
    L101:
        dismissAllowingStateLoss();     // Catch: Exception -> L71
    L75:
        DocExportViewModel.a r19 = ((DocExportViewModel) this.h).getDelegate();
        if (r19 == null) goto L108;
        Bundle r0 = getArguments();
        if (r0 != null) goto L80;
        String r20 = null;
    L82:
        if (r20 == null) goto L88;
        StringBuilder r21 = new StringBuilder("getDocShotExportType return=");
        r21.append(r20);
        r21.append(", exportScene=");
        Bundle r22 = getArguments();
        if (r22 == null) goto L87;
        r6 = r22.getString("arg_export_scene");
    L87:
        r21.append(r6);
        tt5.a.h("DocExportChooseDialog", r21.toString());
        r6 = r20;
    L99:
        r19.c(r6);
        return;
    L88:
        Bundle r23 = getArguments();
        if (r23 != null) goto L91;
        String r24 = null;
    L93:
        if ("vc_summary_tab".equals(r24) == false) goto L96;
        r6 = "summary";
        goto L99
    L96:
        if ("vc_transcript_tab".equals(r24) == false) goto L98;
        r6 = "transcript";
        goto L99
    L98:
        tt5.a.h("DocExportChooseDialog", "getDocShotExportType return=null, exportScene=" + r24);
        goto L99
    L91:
        r24 = r23.getString("arg_export_scene");
        goto L93
    L80:
        r20 = r0.getString("arg_audio_minutes_export_target");
        goto L82
    L108:
        return;
    L71:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r26 = DialogFragmentLancet.sLastShowStack;
        if (r26 == null) goto L75;
        d.d(r26, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L75
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final void da0(LayoutInflater r11, ViewGroup r12) {
        View r13 = r11.inflate(2131560119, r12);
        this.r = r13.findViewById(2131369389);
        this.s = (FileExportTypeItemView) r13.findViewById(2131371971);
        this.t = (FileExportTypeItemView) r13.findViewById(2131371963);
        this.u = (FileExportTypeItemView) r13.findViewById(2131371957);
        this.v = (FileExportTypeItemView) r13.findViewById(2131371961);
        this.w = (FileExportTypeItemView) r13.findViewById(2131371969);
        this.x = r13.findViewById(2131371946);
        List r14 = en4.a.g();
        this.s.a(g.a(2131254746), 2131887708);
        this.t.a(g.a(2131254594), 2131887707);
        this.u.a(g.a(2131254464), 2131887704);
        FileExportTypeItemView r16 = this.v;
        int r0 = g.a(2131254554);
        r16.a.setImageResource(r0);
        r16.b.setText("Markdown");
        FileExportTypeItemView r17 = this.w;
        int r1 = g.a(2131254717);
        r17.a.setImageResource(r1);
        r17.b.setText("TXT");
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        FileExportTypeItemView r18 = this.s;
        int r2 = 8;
        if (r14.contains("docx") == false) goto L5;
        int r3 = 0;
    L6:
        r18.setVisibility(r3);
        FileExportTypeItemView r19 = this.t;
        if (r14.contains("pdf") == false) goto L9;
        int r4 = 0;
    L10:
        r19.setVisibility(r4);
        if (r14.contains("image") == true) goto L13;
    L22:
        boolean r110 = false;
    L23:
        FileExportTypeItemView r5 = this.u;
        if (r110 == false) goto L26;
        int r6 = 0;
    L27:
        r5.setVisibility(r6);
        FileExportTypeItemView r7 = this.v;
        if (r14.contains("markdown") == false) goto L30;
        int r8 = 0;
    L31:
        r7.setVisibility(r8);
        FileExportTypeItemView r9 = this.w;
        if (r14.contains("txt") == false) goto L34;
        r2 = 0;
    L34:
        r9.setVisibility(r2);
        if (r110 == true) goto L40;
        if (this.y != 3) goto L40;
        this.y = 1;
    L40:
        if (this.y != 1) goto L45;
        if (r14.contains("docx") == false) goto L45;
    L77:
        ka0();
        return;
    L45:
        if (this.y == 2) goto L47;
    L49:
        int r10 = this.y;
        if (r10 != 3) goto L54;
        if (r110 == true) goto L77;
    L54:
        if (r10 != 4) goto L59;
        if (r14.contains("markdown") == true) goto L77;
    L59:
        if (this.y != 5) goto L64;
        if (r14.contains("txt") == true) goto L77;
    L64:
        if (r14.contains("docx") == false) goto L67;
        this.y = 1;
        goto L77
    L67:
        if (r14.contains("pdf") == false) goto L69;
        this.y = 2;
        goto L77
    L69:
        if (r110 == false) goto L72;
        this.y = 3;
        goto L77
    L72:
        if (r14.contains("markdown") == false) goto L75;
        this.y = 4;
        goto L77
    L75:
        if (r14.contains("txt") == false) goto L77;
        this.y = 5;
        goto L77
    L47:
        if (r14.contains("pdf") == false) goto L49;
    L30:
        r8 = 8;
        goto L31
    L26:
        r6 = 8;
        goto L27
    L13:
        if (((DocExportViewModel) this.h).shouldShowDocShot() == false) goto L22;
        Bundle r111 = getArguments();
        if (r111 != null) goto L17;
    L19:
        boolean r112 = false;
    L20:
        if (r112 == true) goto L22;
        r110 = true;
        goto L23
    L17:
        if (r111.getBoolean(ExportMoreItemV2.HAS_PERCEIVE_CONTRAL) == false) goto L19;
        r112 = true;
        goto L20
    L9:
        r4 = 8;
        goto L10
    L5:
        r3 = 8;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        CommonActionPanelLayout r3 = r1.findViewById(2131381877);
        r3.setPanelBackgroundColor(2131100558);
        r3.setDividerVisible(false);
    }
}
