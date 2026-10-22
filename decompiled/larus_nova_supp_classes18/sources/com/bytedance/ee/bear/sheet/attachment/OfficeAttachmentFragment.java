package com.bytedance.ee.bear.sheet.attachment;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.sheet.fab.FabItemEnum;
import com.bytedance.ee.bear.sheet.fab.FabViewModel;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeAttachmentFragment extends BaseAntiScreenshotsDialogFragment implements sa5.d, View.OnClickListener {
    public static final /* synthetic */ int l = 0;
    public AttachmentViewModel h;
    public sa5.b i;
    public SheetDragView j;
    public float k;

    public final boolean onBackPressed() {
        this.h.closeAttachmentPanel();
        return true;
    }

    public OfficeAttachmentFragment() {
        this.k = 0.0f;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.h.closeAttachmentPanel();
        sa5.b r0 = this.i;
        if (r0 == null) goto L6;
        r0.d(this);
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        Window r1 = r0.getWindow();
        if (r1 == null) goto L5;
        r1.setLayout(-1, -1);
        WindowManager.LayoutParams r3 = r1.getAttributes();
        r3.dimAmount = 0.0f;
        r3.gravity = 80;
        r3.flags |= 8;
        r3.y = com.bytedance.ee.util.ui.k.e(getContext());
        r1.setAttributes(r3);
        r1.setBackgroundDrawable(new ColorDrawable(0));
    L5:
        setCancelable(false);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).d(r0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        FabViewModel r0 = (FabViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabViewModel.class);
        if (r5.getId() != 2131386185) goto L6;
        this.h.closeAttachmentPanel();
        r0.clickItem(FabItemEnum.operation.name(), null);
        return;
    L6:
        if (r5.getId() != 2131386174) goto L10;
        this.h.closeAttachmentPanel();
        r0.clickItem(FabItemEnum.input.name(), null);
        return;
    }

    public final void onConfigurationChanged(Configuration r1) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r1);
        this.h.closeAttachmentPanel();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(2, 0);
        this.h = (AttachmentViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, AttachmentViewModel.class);
    }

    public final void onViewCreated(final View r5, Bundle r6) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r5, r6);
        r5.findViewById(2131363350).setOnClickListener(new j(this));
        r5.findViewById(2131386185).setOnClickListener(new q(this));
        r5.findViewById(2131386174).setOnClickListener(new q(this));
        final FabViewModel r7 = (FabViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabViewModel.class);
        r7.getTopItems().observe(getViewLifecycleOwner(), new k(r5, r7));
        final RecyclerView r8 = r5.findViewById(2131363346);
        final AttachmentListAdapter r0 = new AttachmentListAdapter();
        r0.b = new l(this);
        r8.setLayoutManager(new LinearLayoutManager(getActivity()));
        r8.setAdapter(r0);
        this.j = (SheetDragView) r5.findViewById(2131363349);
        float r9 = com.bytedance.ee.util.ui.n.t();
        if (this.h.isVCFollow() == false) goto L5;
        float r1 = 0.6f;
    L6:
        this.k = r9 * r1;
        SheetDragView r10 = this.j;
        float r2 = com.bytedance.ee.util.ui.n.t() * 0.4f;
        float r3 = this.k;
        r10.y = 0.0f;
        r10.z = r2;
        r10.A = r3;
        r10.x.m(0.0f, r2, r3);
        this.j.addOnLayoutChangeListener(new m(this, r8));
        this.j.setOnCloseListener(new n(this));
        this.h.getAttachmentList().observe(getViewLifecycleOwner(), new o(this, r0, r8));
        return;
    L5:
        r1 = 0.75f;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        sa5.b r5 = (sa5.b) sa5.m.a.a(getActivity(), sa5.b.class);
        this.i = r5;
        if (r5 == null) goto L6;
        r5.e(this);
    L6:
        return r2.inflate(2131564522, r3, false);
    }
}
