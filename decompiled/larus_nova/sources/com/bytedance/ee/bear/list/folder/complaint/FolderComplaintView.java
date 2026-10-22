package com.bytedance.ee.bear.list.folder.complaint;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.list.t0;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class FolderComplaintView extends com.larksuite.framework.mvp.a<j.a> implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f228078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f228079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f228080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f228081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f228082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDButton f228083g;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f228084a = null;

        static {
            f228084a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            t0.K((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6));
        }
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ((TextView) this.f228078b.findViewById(R.id.list_folder_name)).setText(this.f228079c);
        TextView r100 = (TextView) this.f228078b.findViewById(R.id.list_folder_desc);
        TextView r101 = (TextView) this.f228078b.findViewById(R.id.list_folder_desc_title);
        TextView r102 = (TextView) this.f228078b.findViewById(R.id.list_appealing_line_two);
        if (this.f228081e == false) goto L5;
        r100.setVisibility(0);
        r100.setText(this.f228080d);
        r101.setVisibility(0);
        r102.setText(R.string.CreationMobile_appealing_folder_line2);
    L7:
        if (this.f228082f == false) goto L9;
        TextView r103 = (TextView) this.f228078b.findViewById(R.id.list_complaint_tips);
        TextView r104 = (TextView) this.f228078b.findViewById(R.id.list_appealing_line_one);
        TextView r105 = (TextView) this.f228078b.findViewById(R.id.list_appealing_line_two);
        TextView r106 = (TextView) this.f228078b.findViewById(R.id.list_appealing_line_three);
        r103.setText(R.string.LarkCCM_Appeal_SubmitToFS_SubTheDoc_Descrip);
        r104.setText(R.string.LarkCCM_Appeal_SubmitToFS_Doc_Note1_Mob);
        r105.setText(R.string.LarkCCM_Appeal_SubmitToFS_Doc_Note2_Mob);
        r106.setText(R.string.LarkCCM_Appeal_SubmitToFS_Doc_Note3_Mob);
    L9:
        UDButton r107 = (UDButton) this.f228078b.findViewById(R.id.list_btn_send_complaint);
        this.f228083g = r107;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mBtnSend");
        r107 = null;
    L12:
        r107.setOnClickListener(new h(this));
        return;
    L5:
        r100.setVisibility(8);
        r101.setVisibility(8);
        r102.setText(R.string.CreationMobile_appealing_Wiki_folder_line2);
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.folder.complaint.j
    public final void i1() {
        UDButton r100 = this.f228083g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBtnSend");
        r100 = null;
    L5:
        com.larksuite.component.universe_design.button.e.c(r100, R.string.appealing_submit);
    }

    @Override // com.bytedance.ee.bear.list.folder.complaint.j
    public final void x4() {
        UDButton r100 = this.f228083g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBtnSend");
        r100 = null;
    L5:
        com.larksuite.component.universe_design.button.e.h(r100, new FolderComplaintView$showComplaintLoading$1(this));
    }

    @Override // com.bytedance.ee.bear.list.folder.complaint.j
    public final void J6(int r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r102 = new UDDialogBuilder(r101);
        r102.autoDismiss(true);
        r102.message(r100);
        r102.addActionButton(R.id.ud_dialog_btn_secondary, R.string.LarkCCM_Appeal_SubmitToFS_OverLimit_GotIt_Button, null);
        r102.addActionButton(R.id.ud_dialog_btn_primary, R.string.LarkCCM_Appeal_SubmitToFS_OverLimit_FindStaff_Button, a.f228084a);
        r102.cancelOnTouchOutside(false);
        UDDialog r103 = r102.build();
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
    }

    public FolderComplaintView(View r100, String r101, String r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "mRootView");
        Intrinsics.checkNotNullParameter(r101, "mName");
        this.f228078b = r100;
        this.f228079c = r101;
        this.f228080d = r102;
        this.f228081e = r103;
        this.f228082f = r104;
    }
}
