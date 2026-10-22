package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure;

import android.R;
import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.FullBottomSheetFragment;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFCtrlViewModel;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import h18.e;
import sa5.d;
import sa5.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OutlineStructureFragment extends FullBottomSheetFragment implements w, d {
    public static final /* synthetic */ int k = 0;
    public da5.d<Structure> j;

    public class a extends CommonActionPanelLayout.b {
        public final /* synthetic */ OutlineStructureFragment a;

        public final void b() {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public a(OutlineStructureFragment r1) {
            this.a = r1;
        }
    }

    public class b extends RecyclerView.Adapter<c> {
        public Structure a;
        public LayoutInflater b;
        public final /* synthetic */ OutlineStructureFragment c;

        public final int getItemCount() {
            Structure r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getParagraphCount();
        }

        public b(OutlineStructureFragment r1) {
            this.c = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
            c r10 = (c) r8;
            final Structure.Paragraph r11 = this.a.getParagraph(r9);
            View r0 = r10.a;
            View r1 = r10.b;
            ImageView r2 = r10.c;
            TextView r12 = r10.d;
            int r4 = 0;
            if (r11.showCollapse == false) goto L5;
            int r3 = 0;
        L6:
            r2.setVisibility(r3);
            if (r11.collapse == false) goto L9;
            int r5 = 2131233864;
        L10:
            r2.setImageResource(r5);
            l.c(r2, 2131102420);
            r12.setText(r11.title);
            r12.setSelected(false);
            r1.setSelected(false);
            if (r11.level != 1) goto L13;
            int r6 = e.a;
            Typeface r7 = e.b(this.c.getContext(), 1);
        L14:
            r12.setTypeface(r7);
            boolean r13 = this.c.j.getActive().equals(r11.getHash());
            r12.setSelected(r13);
            r1.setSelected(r13);
            OutlineStructureFragment r14 = this.c;
            if (r13 == false) goto L17;
            int r16 = 2131105548;
        L18:
            r14.getClass();
            if (r16 != 0) goto L21;
            ColorStateList r17 = null;
        L22:
            r2.setImageTintList(r17);
            zz7.a.d(r12, LarkFont.BODY0);
            LinearLayout.LayoutParams r18 = (LinearLayout.LayoutParams) r0.getLayoutParams();
            if (r2.getVisibility() != 0) goto L25;
            r4 = n.d(24);
        L25:
            r18.width = (n.d(12) + ((r11.level - 1) * n.d(20))) + r4;
            r0.setLayoutParams(r18);
            r12.setOnClickListener(new da5.b(this, r11));
            r0.setOnClickListener(new da5.c(this, r11));
            return;
        L21:
            r17 = r14.getResources().getColorStateList(r16);
            goto L22
        L17:
            r16 = 0;
            goto L18
        L13:
            int r19 = e.a;
            r7 = e.b(this.c.getContext(), 0);
            goto L14
        L9:
            r5 = 2131233865;
            goto L10
        L5:
            r3 = 8;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            if (this.b != null) goto L6;
            this.b = LayoutInflater.from(r3.getContext());
        L6:
            return new c(this.b.inflate(2131564156, r3, false));
        }
    }

    public static class c extends RecyclerView.ViewHolder {
        public final View a;
        public final View b;
        public final ImageView c;
        public final TextView d;

        public c(View r2) {
            super(r2);
            this.a = r2.findViewById(2131381918);
            this.c = (ImageView) r2.findViewById(2131381917);
            this.d = (TextView) r2.findViewById(2131381919);
            this.b = r2.findViewById(2131387479);
        }
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return true;
    L12:
        return true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.FullBottomSheetFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        BottomSheetBehavior<FrameLayout> r0 = this.i;
        if (r0 == null) goto L5;
        r0.setBottomSheetCallback(new com.bytedance.ee.bear.bizwidget.dialogfragment.c(this));
    L5:
        Dialog r1 = getDialog();
        if (r1 == null) goto L8;
        Window r2 = r1.getWindow();
    L9:
        if (r2 == null) goto L12;
        WindowManager.LayoutParams r3 = r2.getAttributes();
        r3.width = -1;
        r3.height = n.t();
        r3.gravity = 80;
        r3.softInputMode = 1;
        r3.flags = (r3.flags | 264) & (-3);
        r2.setAttributes(r3);
        r2.setBackgroundDrawableResource(R.color.transparent);
        return;
    L12:
        return;
    L8:
        r2 = null;
        goto L9
    }

    static {
    }

    public OutlineStructureFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        getActivity();
        this.j = new ViewModelProvider(getParentFragment()).get(PDFCtrlViewModel.class);
    }

    @Override // sa5.w
    public final boolean u70(MotionEvent r3) {
        float r4 = r3.getRawY();
        View r0 = getView();
        if (r0 == null) goto L13;
        int[] r1 = new int[2];
        r0.getLocationOnScreen(r1);
        if (r4 >= r1[1]) goto L17;
        dismissAllowingStateLoss();     // Catch: Exception -> L8
    L12:
        return true;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L12;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    L17:
        return false;
    L13:
        return false;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        CommonActionPanelLayout r7 = r5.findViewById(2131388881);
        r7.setTitle(getString(2131887673));
        r7.setOnActionListener(new a(this));
        final View r8 = r5.findViewById(2131378771);
        final RecyclerView r9 = r5.findViewById(2131384070);
        int r3 = 0;
        r9.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r9.setNestedScrollingEnabled(false);
        final b r0 = new b(this);
        r9.setAdapter(r0);
        aa0((Structure) this.j.getContent().getValue(), r9, r8);
        this.j.getContent().observe(this, new da5.a(this, r9, r8, r0));
        String r10 = this.j.getActive();
        if (TextUtils.isEmpty(r10) == true) goto L14;
        Structure r1 = (Structure) this.j.getContent().getValue();
        if (r1 == null) goto L14;
        int r2 = r1.getParagraphCount();
    L9:
        if (r3 >= r2) goto L14;
        if (r1.getParagraph(r3).getHash().equals(r10) == true) goto L15;
        r3 = r3 + 1;
    L15:
        if (r3 < 0) goto L17;
        r9.scrollToPosition(r3);
    L17:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).d(getDialog());
        return;
    L14:
        r3 = -1;
        goto L15
    }

    public static void aa0(Structure r3, RecyclerView r4, View r5) {
        int r0 = 0;
        if (r3 == null) goto L9;
        Structure.Paragraph[] r6 = r3.paragraphs;
        if (r6 == null) goto L9;
        if (r6.length <= 0) goto L9;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L13;
        int r2 = 8;
    L14:
        r5.setVisibility(r2);
        if (r7 == true) goto L18;
        r0 = 8;
    L18:
        r4.setVisibility(r0);
        return;
    L13:
        r2 = 0;
    L9:
        r7 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564155, r3, false);
    }
}
