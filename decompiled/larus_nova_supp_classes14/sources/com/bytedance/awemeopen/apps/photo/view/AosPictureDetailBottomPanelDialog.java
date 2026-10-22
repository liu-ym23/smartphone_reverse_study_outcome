package com.bytedance.awemeopen.apps.photo.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBSDialogInfoManager;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.apps.photo.presenter.y;
import com.bytedance.awemeopen.servicesapi.ui.host.ext.AoUIComponentExtensionService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/view/AosPictureDetailBottomPanelDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/LiveBottomSheetDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/b0;", "Landroid/app/Activity;", "getActivity", "a", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class AosPictureDetailBottomPanelDialog extends LiveBottomSheetDialog implements b0 {
    public static final /* synthetic */ int l = 0;
    public final Activity e;
    public View f;
    public View g;
    public View h;
    public FrameLayout i;
    public a j;
    public final AosBSDialogInfoManager k;

    public interface a {
        void a();

        void b();

        void c();

        void onExit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public final Dialog getDialog() {
        return this;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void show() {
        if (this.e.isFinishing() == false) goto L6;
        return;
    L6:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public final int getBottomSheetHeight() {
        d0.c(getContext());
        return -1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public Activity getActivity() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        boolean r7 = true;
        setCanceledOnTouchOutside(true);
        View r0 = View.inflate(getContext(), 2131558685, null);
        View r1 = AosBSDialogInfoManager.d(this.k, this, r0, new ViewGroup.LayoutParams(-1, -2));
        if (r1 == null) goto L6;
        r0 = r1;
    L6:
        setContentView(r0);
        Window r2 = getWindow();
        if (r2 == null) goto L9;
        r2.setLayout(-1, -1);
    L9:
        Window r3 = getWindow();
        if (r3 == null) goto L12;
        r3.setGravity(80);
    L12:
        LinearLayout r4 = (LinearLayout) findViewById(2131378784);
        this.f = findViewById(2131381005);
        this.g = findViewById(2131384375);
        this.h = findViewById(2131367151);
        View r5 = this.f;
        if (r5 == null) goto L15;
        r5.setOnClickListener(new b(this));
    L15:
        View r8 = this.g;
        if (r8 == null) goto L18;
        r8.setOnClickListener(new c(this));
    L18:
        z44.a r9 = AosExtConfig.b.b0();
        if (r9 != null) goto L21;
    L23:
        r7 = false;
    L24:
        if (r7 == false) goto L32;
        View r10 = this.h;
        if (r10 == null) goto L28;
        r10.setOnClickListener(new d(this));
    L28:
        View r11 = this.h;
        if (r11 == null) goto L36;
        r11.setVisibility(0);
    L36:
        this.i = (FrameLayout) findViewById(2131371985);
        LinearLayout r12 = (LinearLayout) findViewById(2131378627);
        FrameLayout r13 = this.i;
        if (r13 == null) goto L39;
        x54.b.a(r13);
    L39:
        setOnDismissListener(new com.bytedance.awemeopen.apps.photo.view.a(this));
        return;
    L32:
        View r14 = this.h;
        if (r14 == null) goto L36;
        r14.setVisibility(8);
        goto L36
    L21:
        if (r9.a != true) goto L23;
        goto L23
    }

    public AosPictureDetailBottomPanelDialog(Activity r2, a14.a r3, y r4) {
        Intrinsics.checkNotNullParameter(r2, "hostActivity");
        Intrinsics.checkNotNullParameter(r3, "pgParameters");
        super(r2);
        this.e = r2;
        AoUIComponentExtensionService r5 = j64.a.a(AoUIComponentExtensionService.class);
        if (r5 == null) goto L5;
        r5.T0();
    L5:
        AosBSDialogInfoManager r6 = new AosBSDialogInfoManager();
        this.k = r6;
        r6.d = r4;
    }
}
