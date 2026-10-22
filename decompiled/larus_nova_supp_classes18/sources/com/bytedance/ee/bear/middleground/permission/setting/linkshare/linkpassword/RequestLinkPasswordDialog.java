package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.k;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RequestLinkPasswordDialog extends BaseAntiScreenshotsDialogFragment implements g.a {
    public static final /* synthetic */ int n = 0;
    public String h;
    public int i;
    public Runnable j;
    public g k;
    public View l;
    public boolean m;

    public final void onDestroyView() {
        g r0 = this.k;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.g.a
    public final void RN() {
        Z90(this);
        Runnable r0 = this.j;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.g.a
    public final void c8() {
        if (getActivity() == null) goto L6;
        getActivity().finish();
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
        Window r1 = null;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (getContext() == null) goto L12;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -1;
        r2.y = k.e(getContext());
        r1.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131100545)));
        r1.setAttributes(r2);
        return;
    L12:
        return;
    L5:
        r1 = r0.getWindow();
        goto L6
    }

    public RequestLinkPasswordDialog() {
    }

    public static void Z90(RequestLinkPasswordDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 == null) goto L6;
        Z90(this);
        tt5.a.d("RequestLinkPasswordDialog", "onCreate savedInstanceState is not null");
        return;
    L6:
        Bundle r3 = getArguments();
        if (r3 == null) goto L10;
        this.h = r3.getString(ResourceData.KEY_OBJ_TOKEN);
        this.i = r3.getInt(ResourceData.KEY_TYPE);
        this.m = r3.getBoolean("is_share_folder_v2");
        setStyle(0, 2131953378);
        return;
    L10:
        tt5.a.d("RequestLinkPasswordDialog", "getArguments is null");
        Z90(this);
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super/*androidx.fragment.app.DialogFragment*/.onCreateDialog(r3);
        if (r4.getWindow() == null) goto L5;
        r4.getWindow().setSoftInputMode(16);
        r4.setOnKeyListener(new ii5.e(this));
    L5:
        return r4;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r8, r9);
        FragmentActivity r1 = getActivity();
        d r2 = new d(this.h, this.i);
        FragmentActivity r10 = getActivity();
        View r0 = this.l;
        ii5.b r3 = (ii5.b) org.koin.java.a.a(ii5.b.class);     // Catch: Throwable -> L5
    L7:
        g r11 = new g(r1, r2, r3.c(r10, r0, true), this, this.m);
        this.k = r11;
        r11.create();
        return;
    L5:
        th = move-exception;
        tt5.a.e("RequestLinkPasswordDialog", "get request password page factory failed, fallback default", th, false);
        r3 = ii5.a.a;
        goto L7
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        ii5.b r0 = (ii5.b) org.koin.java.a.a(ii5.b.class);     // Catch: Throwable -> L5
    L7:
        View r7 = r4.inflate(r0.a(), r5, false);
        this.l = r7;
        return r7;
    L5:
        th = move-exception;
        tt5.a.e("RequestLinkPasswordDialog", "get request password page factory failed, fallback default", th, false);
        r0 = ii5.a.a;
        goto L7
    }
}
