package com.bytedance.ee.bear.doc.structure;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.PageType;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import sa5.m;
import sa5.v;
import sa5.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FixedStructureFragment extends BaseAntiScreenshotsDialogFragment implements w, sa5.d {
    public static final int p = 0;
    public static final int q = 0;
    public static final int r = 0;
    public static final int s = 0;
    public mz4.w h;
    public StructureViewModel i;
    public v j;
    public b k;
    public boolean l;
    public View m;
    public LinearLayout n;
    public BaseTitleBar o;

    public class a implements View.OnClickListener {
        public final /* synthetic */ FixedStructureFragment a;

        public a(FixedStructureFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public class b implements g45.a, VcKeyboardChangeEventProducer {
        public MutableLiveData<Boolean> a;
        public final /* synthetic */ FixedStructureFragment b;

        @Override // g45.a
        public final String getPanelName() {
            return "catalog";
        }

        @Override // g45.a
        public final void requestNotFocus(Context r1) {
        }

        @Override // g45.a
        public final LiveData<Boolean> getActive() {
            if (this.a != null) goto L6;
            this.a = new MutableLiveData();
        L6:
            return this.a;
        }

        @Override // g45.a
        public final KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
            return KeyboardShowingStatusMode.ALWAYS_SHOW;
        }

        @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
        public final VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
            return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
        }

        @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
        public final VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
            return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
        }

        public b(FixedStructureFragment r1) {
            this.b = r1;
        }

        public final void a(boolean r3) {
            MutableLiveData r0 = getActive();
            if (r0.getValue() != null) goto L5;
        L6:
            r0.setValue(Boolean.valueOf(r3));
            return;
        L5:
            if (((Boolean) r0.getValue()).booleanValue() != r3) goto L6;
        }

        @Override // g45.a
        public final int getPanelHeight(Context r2) {
            FixedStructureFragment r3 = this.b;
            int r0 = FixedStructureFragment.p;
            return r3.aa0();
        }

        @Override // g45.a
        public final void onBecomeActive(g45.d r1, g45.a r2) {
            r1.requestUpdateWebContentHeight();
        }

        @Override // g45.a
        public final void onBecomeInactive(g45.d r1, g45.a r2) {
            r1.requestUpdateWebContentHeight();
        }
    }

    public class c extends RecyclerView.Adapter<d> {
        public Structure a;
        public LayoutInflater b;
        public final /* synthetic */ FixedStructureFragment c;

        public final int getItemCount() {
            Structure r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getParagraphCount();
        }

        public c(FixedStructureFragment r1) {
            this.c = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
            d r10 = (d) r8;
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
            Typeface r6 = Typeface.defaultFromStyle(1);
        L14:
            r12.setTypeface(r6);
            boolean r7 = this.c.i.getActive().equals(r11.getHash());
            r12.setSelected(r7);
            r1.setSelected(r7);
            FixedStructureFragment r13 = this.c;
            if (r7 == false) goto L17;
            int r14 = 2131105548;
        L18:
            r13.getClass();
            if (r14 != 0) goto L21;
            ColorStateList r16 = null;
        L22:
            r2.setImageTintList(r16);
            if (this.c.l == true) goto L25;
        L28:
            LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r0.getLayoutParams();
            if (r2.getVisibility() != 0) goto L31;
            r4 = FixedStructureFragment.s;
        L31:
            r17.width = (FixedStructureFragment.p + ((r11.level - 1) * FixedStructureFragment.r)) + r4;
            r0.setLayoutParams(r17);
            r12.setOnClickListener(new mz4.c(this, r11));
            r0.setOnClickListener(new mz4.d(this, r11));
            return;
        L25:
            if (r11.level != 1) goto L27;
            zz7.a.d(r12, LarkFont.BODY1);
            goto L28
        L27:
            zz7.a.d(r12, LarkFont.BODY2);
            goto L28
        L21:
            r16 = r13.getResources().getColorStateList(r14);
            goto L22
        L17:
            r14 = 0;
            goto L18
        L13:
            r6 = Typeface.defaultFromStyle(0);
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
            return new d(this.b.inflate(2131561114, r3, false));
        }
    }

    public static class d extends RecyclerView.ViewHolder {
        public final View a;
        public final View b;
        public final ImageView c;
        public final TextView d;

        public d(View r2) {
            super(r2);
            this.a = r2.findViewById(2131381918);
            this.c = (ImageView) r2.findViewById(2131381917);
            this.d = (TextView) r2.findViewById(2131381919);
            this.b = r2.findViewById(2131387479);
        }
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.a
    public final boolean Cl() {
        return true;
    }

    static {
        p = n.d(12);
        q = n.d(16);
        r = n.d(20);
        s = n.d(24);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void Y90() {
        tt5.a.h("FixedStructureFragment", "onFloatDismiss");
        this.k.a(false);
    }

    public final int aa0() {
        if (ku5.c.k(getContext()) == true) goto L9;
        if (n.C(getActivity()) == false) goto L9;
        return (int) (n.p(getActivity()) * 0.75f);
    L9:
        return Math.max((int) (((double) n.p(getActivity())) * 0.63d), pcb.a.a.b(getActivity()).keyBoardRawHeight());
    }

    public final int ba0() {
        if (ku5.c.k(getContext()) == false) goto L5;
        return -1;
    L5:
        if (n.C(getActivity()) == true) goto L7;
        return -1;
    L7:
        return (int) (n.q(getActivity()) * 0.7f);
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        Z90(this);
        return true;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        v r0 = this.j;
        if (r0 == null) goto L5;
        r0.b(this);
        this.j = null;
    L5:
        this.k.a(false);
        this.i.setFixMode(false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
        Window r1 = null;
    L6:
        if (r1 == null) goto L8;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = ba0();
        r2.height = aa0();
        r2.gravity = 80;
        r2.softInputMode = 1;
        r2.flags = (r2.flags | 264) & (-3);
        r1.setAttributes(r2);
        r1.setWindowAnimations(2131951688);
        r1.setBackgroundDrawableResource(R.color.transparent);
    L15:
        da0(getActivity().getResources().getConfiguration());
        if (ForsetiHelper.s(this) == false) goto L19;
        rcb.c.c(getContext());
        return;
    L19:
        return;
    L8:
        View r3 = this.m;
        if (r3 == null) goto L15;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 != null) goto L13;
        r4 = new ViewGroup.LayoutParams(ba0(), aa0());
    L14:
        this.m.setLayoutParams(r4);
        goto L15
    L13:
        r4.width = ba0();
        r4.height = aa0();
        goto L14
    L5:
        r1 = r0.getWindow();
        goto L6
    }

    public FixedStructureFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final PageType V90() {
        return PageType.BOTTOM_SHEET;
    }

    public static void Z90(FixedStructureFragment r1) {
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

    public final void da0(Configuration r5) {
        LinearLayout r0 = this.n;
        if (r0 == null) goto L14;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0.getLayoutParams();
        if (ku5.c.k(getContext()) == true) goto L10;
        if (r5.orientation != 2) goto L10;
        int r6 = q;
        r1.setMargins(r6, r6, r6, 0);
    L12:
        this.n.setLayoutParams(r1);
        return;
    L10:
        if (r5.orientation != 1) goto L12;
        r1.setMargins(0, q, 0, 0);
        goto L12
    }

    public final void onConfigurationChanged(Configuration r4) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r4);
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = ba0();
        r2.height = aa0();
        r1.setAttributes(r2);
    L14:
        da0(r4);
        return;
    L7:
        View r3 = this.m;
        if (r3 == null) goto L14;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (r5 != null) goto L12;
        r5 = new ViewGroup.LayoutParams(ba0(), aa0());
    L13:
        this.m.setLayoutParams(r5);
        goto L14
    L12:
        r5.width = ba0();
        r5.height = aa0();
        goto L13
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FragmentActivity r4 = getActivity();
        StructureViewModel r0 = (StructureViewModel) q.a(this, StructureViewModel.class);
        this.i = r0;
        this.h = r0.getStructureAnalytic();
        EditPanelsManager r1 = (EditPanelsManager) ViewModelProviders.of(r4).get(EditPanelsManager.class);
        b r2 = new b(this);
        this.k = r2;
        r1.registerEditPanel(this, r2);
        pcb.a.a.b(r4).c(r1);
        Bundle r5 = getArguments();
        if (r5 == null) goto L6;
        this.l = r5.getBoolean(StructurePlugin.ENABLE_FONT_SCALE);
    L6:
        if (ForsetiHelper.s(this) == false) goto L9;
        FragmentBackPressedHelperKt.a(this, new mz4.b(this));
        return;
    }

    public final void onDismiss(DialogInterface r2) {
        super.onDismiss(r2);     // Catch: Throwable -> L5
        this.k.a(false);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // sa5.w
    public final boolean u70(MotionEvent r3) {
        float r4 = r3.getRawY();
        View r0 = getView();
        if (r0 == null) goto L8;
        int[] r1 = new int[2];
        r0.getLocationOnScreen(r1);
        if (r4 >= r1[1]) goto L10;
        Z90(this);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View X90(LayoutInflater r3, ViewGroup r4) {
        View r5 = r3.inflate(2131561113, r4, false);
        this.m = r5;
        return r5;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r7, Bundle r8) {
        super.onViewCreated(r7, r8);
        this.n = (LinearLayout) r7.findViewById(2131367833);
        BaseTitleBar r9 = r7.findViewById(2131388807);
        this.o = r9;
        r9.setTitle(getString(2131887673));
        this.o.setTitle(getString(2131887673));
        this.o.setLeftClickListener(new a(this));
        final View r10 = r7.findViewById(2131378771);
        final RecyclerView r11 = r7.findViewById(2131384070);
        boolean r3 = false;
        r11.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        final c r0 = new c(this);
        r11.setAdapter(r0);
        ca0((Structure) this.i.getContent().getValue(), r11, r10);
        this.i.getContent().observe(this, new mz4.a(this, r11, r10, r0));
        String r12 = this.i.getActive();
        if (TextUtils.isEmpty(r12) == true) goto L14;
        Structure r1 = (Structure) this.i.getContent().getValue();
        if (r1 == null) goto L14;
        int r2 = r1.getParagraphCount();
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L14;
        if (r1.getParagraph(r4).getHash().equals(r12) == true) goto L15;
        r4 = r4 + 1;
    L15:
        if (r4 < 0) goto L17;
        r11.scrollToPosition(r4);
    L17:
        v r13 = (v) m.a.a(getActivity(), v.class);
        this.j = r13;
        if (r13 == null) goto L20;
    L25:
        v r14 = this.j;
        if (r14 == null) goto L28;
        r14.c(this);
    L29:
        this.k.a(true);
        this.i.setFixMode(true);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).d(getDialog());
        return;
    L28:
        tt5.a.k("FixedStructureFragment", "register touchMonitor failed, touchMonitor is null");
        goto L29
    L20:
        if (DowngradeSettingUtil.a("downgradeTouchExtension") == true) goto L25;
        this.j = (v) m.a.b(this, v.class);
        StringBuilder r16 = new StringBuilder("find touchMonitor from fragment extension:");
        if (this.j == null) goto L24;
        r3 = true;
    L24:
        r16.append(r3);
        tt5.a.h("FixedStructureFragment", r16.toString());
    L14:
        r4 = -1;
        goto L15
    }

    public static void ca0(Structure r3, RecyclerView r4, View r5) {
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
}
