package com.bytedance.ee.bear.sheet.celldropdown;

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
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.Objects;
import pm5.c;
import pm5.e;
import sa5.d;
import sa5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DropdownPopupFragment extends BaseAntiScreenshotsDialogFragment implements d {
    public static final /* synthetic */ int m = 0;
    public DropdownViewModel h;
    public DropdownItemAdapter i;
    public CommonActionPanelLayout j;
    public RecyclerView k;
    public sa5.b l;

    public class a extends CommonActionPanelLayout.b {
        public final /* synthetic */ DropdownPopupFragment a;

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void b() {
            this.a.h.cancelDropdown();
        }

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void e() {
            this.a.h.switchToKeyboard();
        }

        public a(DropdownPopupFragment r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Configuration a;
        public final /* synthetic */ DropdownPopupFragment b;

        @Override // java.lang.Runnable
        public final void run() {
            DropdownPopupFragment r0 = this.b;     // Catch: Throwable -> L4
            int r1 = this.a.orientation;     // Catch: Throwable -> L4
            int r2 = DropdownPopupFragment.m;     // Catch: Throwable -> L4
            r0.Z90(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(DropdownPopupFragment r1, Configuration r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final boolean onBackPressed() {
        this.h.cancelDropdown();
        return true;
    }

    public final void aa0() {
        if (2 == getResources().getConfiguration().orientation) goto L5;
    L7:
        int r0 = (int) (n.t() * 0.4f);
    L8:
        this.j.measure(0, View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE));
        int r1 = Math.min(this.j.getMeasuredHeight(), r0);
        ViewGroup.LayoutParams r2 = this.j.getLayoutParams();
        r2.height = r1;
        this.j.setLayoutParams(r2);
        return;
    L5:
        if (n.D(getActivity()) == true) goto L7;
        r0 = getResources().getDimensionPixelOffset(2131168320);
        goto L8
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.h.setActive(Boolean.FALSE);
        this.h.setPanelHeightDelegate(null);
        sa5.b r0 = this.l;
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
        r3.y = k.e(getContext());
        r1.setAttributes(r3);
        r1.setBackgroundDrawable(new ColorDrawable(0));
    L5:
        setCancelable(false);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).d(r0);
    }

    public DropdownPopupFragment() {
    }

    public final void Z90(int r3) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        CommonActionPanelLayout r0 = this.j;
        if (2 == r3) goto L8;
    L11:
        boolean r4 = true;
    L12:
        r0.setTitleBarVisible(r4);
        aa0();
        return;
    L8:
        if (n.D(getActivity()) == true) goto L11;
        r4 = false;
        goto L12
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        j.c(new b(this, r2));
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(2, 0);
        this.h = (DropdownViewModel) q.a(this, DropdownViewModel.class);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r3, r4);
        DropdownItemAdapter r5 = new DropdownItemAdapter();
        this.i = r5;
        DropdownViewModel r0 = this.h;
        Objects.requireNonNull(r0);
        r5.b = new pm5.a(r0);
        r3.findViewById(2131384705).setOnClickListener(new pm5.b(this));
        CommonActionPanelLayout r6 = (CommonActionPanelLayout) r3.findViewById(2131381847);
        this.j = r6;
        r6.setOnActionListener(new a(this));
        this.k = r3.findViewById(2131385008);
        LinearLayoutManager r7 = new LinearLayoutManager(getActivity());
        r7.setOrientation(1);
        this.k.setLayoutManager(r7);
        this.k.setAdapter(this.i);
        this.h.getData().observe(this, new c(this));
        this.h.setPanelHeightDelegate(new pm5.d(this));
        this.j.addOnLayoutChangeListener(new e(this));
        Window r8 = getDialog().getWindow();
        if (r8 == null) goto L5;
        r8.getAttributes().windowAnimations = 2131952071;
    L5:
        Z90(getResources().getConfiguration().orientation);
        this.h.setActive(Boolean.TRUE);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        sa5.b r5 = (sa5.b) m.a.a(getActivity(), sa5.b.class);
        this.l = r5;
        if (r5 == null) goto L6;
        r5.e(this);
    L6:
        return r2.inflate(2131564532, r3, false);
    }
}
