package com.bytedance.ee.bear.document.toolbar;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.doc.toolbar.DocItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorV2Fragment;
import com.bytedance.ee.bear.document.widget.KeyboardPlaceholderView;
import com.bytedance.ee.bear.edit.component.document.at.AtPanelViewModel;
import com.bytedance.ee.bear.edit.component.toolbar2.b0;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.v;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseToolbarPanelFragment<Toolbar extends Toolbar> extends BaseFragment {
    public static int q;
    public BaseToolbarPanelViewModel<Toolbar> e;
    public EditPanelsManager f;
    public View g;
    public View h;
    public View i;
    public ViewGroup j;
    public ObjectAnimator k;
    public KeyboardPlaceholderView l;
    public pcb.a m;
    public final b0 n;
    public final v o;
    public final com.bytedance.ee.bear.document.toolbar.b p;

    public class a implements Observer<g45.a> {
        public g45.a a;
        public final /* synthetic */ BaseToolbarPanelFragment b;

        public a(BaseToolbarPanelFragment r1) {
            this.b = r1;
        }

        public final void onChanged(Object r3) {
            g45.a r4 = (g45.a) r3;
            if ((r4 instanceof AtPanelViewModel) == false) goto L5;
            BaseToolbarPanelFragment.U90(this.b, false);
        L10:
            this.a = r4;
            return;
        L5:
            BaseToolbarPanelFragment r0 = this.b;
            if (r0.e != r4) goto L10;
            if ((this.a instanceof AtPanelViewModel) == false) goto L10;
            BaseToolbarPanelFragment.U90(r0, true);
            goto L10
        }
    }

    public class b extends t {
        public final /* synthetic */ View c;
        public final /* synthetic */ ItemId d;
        public final /* synthetic */ BaseToolbarPanelFragment e;

        public final void a(View r3) {
            String r4 = String.valueOf(this.c.isSelected());
            this.e.ca0(this.d, r4);
        }

        public b(BaseToolbarPanelFragment r1, View r2, ItemId r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public abstract Class<? extends DialogFragment> Y90(ItemId r1);

    public abstract int Z90(ItemId r1);

    public abstract BaseToolbarPanelViewModel aa0(FragmentActivity r1);

    static {
        q = 0;
    }

    public void X90() {
        KeyboardPlaceholderView r0 = this.l;
        tt5.a.b(r0.a, "fallIfKeyboardNotShow");
        r0.b(0);
    }

    public final void ga0() {
        Toolbar r0 = (Toolbar) this.e.getToolbar().getValue();
        int r1 = this.e.getKeyboardHeight();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L40:
        this.i.setVisibility(8);
    L41:
        boolean r3 = this.e.hasExpandedSubToolbar();
        boolean r4 = this.m.isKeyboardShowing();
        if (rcb.b.a(getActivity()) == true) goto L46;
        if (r4 == false) goto L45;
        if (r3 == false) goto L46;
    L45:
        r2 = true;
    L46:
        this.h.setSelected(r2);
        return;
    L5:
        if (r0.getChildren().length == 0) goto L40;
        if (r1 <= 0) goto L9;
    L13:
        this.i.setVisibility(0);
        Item[] r5 = r0.getChildren();
        int r6 = this.j.getChildCount();
        if (r5.length <= r6) goto L20;
        LayoutInflater r7 = LayoutInflater.from(getContext());
        int r8 = 0;
    L17:
        if (r8 >= (r5.length - r6)) goto L25;
        r7.inflate(2131565071, this.j);
        r8 = r8 + 1;
    L25:
        int r9 = 0;
    L27:
        if (r9 >= r5.length) goto L29;
        fa0(r5[r9], this.j.getChildAt(r9));
        r9 = r9 + 1;
        goto L27
    L29:
        int r10 = r5.length + 1;
        int r11 = com.bytedance.ee.util.ui.n.w(getContext());
        if (r10 != 7) goto L32;
        int r12 = Math.round(r11 / 7);
    L33:
        V90(r12);
        int r13 = 0;
    L35:
        if (r13 >= this.j.getChildCount()) goto L41;
        View r14 = this.j.getChildAt(r13);
        ViewGroup.LayoutParams r16 = r14.getLayoutParams();
        if (r16.width == r12) goto L39;
        r16.width = r12;
        r14.requestLayout();
    L39:
        r13 = r13 + 1;
        goto L35
    L32:
        r12 = q;
        goto L33
    L20:
        if (r5.length >= r6) goto L25;
        int r17 = 0;
    L23:
        if (r17 >= (r6 - r5.length)) goto L25;
        ViewGroup r18 = this.j;
        r18.removeViewAt(r18.getChildCount() - 1);
        r17 = r17 + 1;
        goto L23
    L9:
        if (this.e.hasExpandedSubToolbar() == true) goto L13;
        if (rcb.b.a(getActivity()) == true) goto L13;
        this.i.setVisibility(8);
        goto L41
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.document.toolbar.b] */
    public BaseToolbarPanelFragment() {
        this.n = new b0();
        this.o = new v();
        this.p = new com.bytedance.ee.bear.document.toolbar.b(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        W90(true);
        if (getView() == null) goto L6;
        getView().getViewTreeObserver().removeOnWindowFocusChangeListener(this.p);
        return;
    }

    public void V90(int r4) {
        View r0 = this.g;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1.width == r4) goto L6;
        r1.width = r4;
        r0.requestLayout();
        return;
    }

    public void W90(boolean r4) {
        List r0 = getActivity().getSupportFragmentManager().getFragments();
        if (r0 != null) goto L28;
        return;
    L28:
        Iterator r1 = r0.iterator();     // Catch: Exception -> L20
    L6:
        if (r1.hasNext() == false) goto L42;
        DialogFragment r2 = (Fragment) r1.next();     // Catch: Exception -> L20
        if ((r2 instanceof BaseSubToolbarFragment) == true) goto L12;
        if ((r2 instanceof SelectColorV2Fragment) == false) goto L6;
    L12:
        if (r4 == true) goto L26;
        ba0(r2);     // Catch: Exception -> L20
        goto L6
    L26:
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L20
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L20
        if (r3 == null) goto L6;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L20
        goto L6
    L42:
        return;
    L20:
        e = move-exception;
        tt5.a.e("BaseToolbarPanelFragment", "dismissAllSubToolbar err : ", e, false);
    }

    public final void ba0(Fragment r4) {
        Dialog r5 = ((DialogFragment) r4).getDialog();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isShowing() == false) goto L27;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r1 == null) goto L20;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L9:
        if (Looper.myLooper() == r0.getLooper()) goto L11;
        r0.post(DialogLancet.createDismissRunnable(r5));
        return;
    }

    public final void da0(Fragment r2) {
        Dialog r3 = ((DialogFragment) r2).getDialog();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isShowing() == false) goto L7;
        return;
    L7:
        if (getActivity() != null) goto L9;
        return;
    L9:
        if (getActivity().isFinishing() == false) goto L11;
        return;
    L11:
        if (getActivity().isDestroyed() == false) goto L13;
        return;
    L13:
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L16:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
    }

    public void ea0(ItemId r6) {
        KeyboardPlaceholderView r0 = this.l;
        tt5.a.b(r0.a, "ariseIfKeyboardNotShow");
        r0.b(1);
        FragmentActivity r1 = getActivity();
        FragmentManager r2 = r1.getSupportFragmentManager();
        String r3 = r6.name();
        Fragment r4 = r2.findFragmentByTag(r3);
        if ((r4 instanceof DialogFragment) == true) goto L17;
        Class<? extends DialogFragment> r7 = Y90(r6);
        if (getArguments() != null) goto L7;
        Bundle r5 = new Bundle();
    L8:
        Fragment r8 = (DialogFragment) Fragment.instantiate(r1, r7.getName(), r5);
        if ((r8 instanceof Fragment) == false) goto L11;
        Fragment r9 = r8;
    L12:
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, r3, r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r9, r10) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L16:
        r8.show(r2, r3);
        return;
    L23:
        return;
    L11:
        r9 = null;
        goto L12
    L7:
        r5 = getArguments();
        goto L8
    L17:
        da0(r4);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FragmentActivity r4 = getActivity();
        this.e = aa0(r4);
        this.f = (EditPanelsManager) ViewModelProviders.of(r4).get(EditPanelsManager.class);
        this.m = pcb.a.a.b(r4);
    }

    public static void U90(BaseToolbarPanelFragment r5, boolean r6) {
        ObjectAnimator r0 = r5.k;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        View r1 = r5.getView();
        int r2 = r1.getResources().getInteger(2131427332);
        if (r6 == false) goto L8;
        int r7 = -r1.getWidth();
        int r3 = 0;
    L9:
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r1, "translationX", new float[]{r7, r3}).setDuration(r2);
        r5.k = r8;
        r8.addListener(new h(r1));
        r5.k.start();
        return;
    L8:
        r3 = -r1.getWidth();
        r7 = 0;
        goto L9
    }

    public final void ca0(ItemId r4, String r5) {
        this.e.processToolbarItemClick(r4, r5);
        BaseToolbarPanelViewModel<Toolbar> r0 = this.e;
        r0.setLastItemId(r0.getCurrItemId());
        this.e.setCurrItemId(r4);
        int r1 = 0;
        if (r4 != ItemId.ConstId.keyboard) goto L14;
        if (this.e.clearSubToolbars() == true) goto L7;
        rcb.c.c(getContext());
    L9:
        if (getActivity() == null) goto L14;
        if (rcb.b.a(getActivity()) == false) goto L14;
        this.l.c(0);
        this.e.updateToolbar(null);
        this.e.setActive(false);
        goto L14
    L7:
        rcb.c.g(getContext());
    L14:
        if (r4.name().equals(DocItemId.insertImage.name()) == true) goto L16;
        return;
    L16:
        if (getActivity() != null) goto L18;
        return;
    L18:
        if (rcb.b.a(getActivity()) == false) goto L20;
    L21:
        int r6 = getActivity().getResources().getConfiguration().orientation;
        int r7 = pcb.a.a.b(getActivity()).keyBoardRawHeightWithOrientation(r6);
        if ("true".equals(r5) == false) goto L24;
    L27:
        this.l.c(r1);
        return;
    L24:
        if (this.e.hasExpandedSubToolbar() == false) goto L27;
        r1 = r7;
        goto L27
    L20:
        if (rcb.f.b() == true) goto L21;
    }

    public void fa0(Item r9, View r10) {
        AppCompatImageView r0 = r10.findViewById(2131389061);
        ItemId r1 = r9.id();
        if (r1 == r0.getTag()) goto L5;
        r0.setTag(r1);
        r0.setImageResource(Z90(r9.id()));
    L5:
        boolean r3 = true;
        if (r9.isAdminLimit() == false) goto L8;
    L11:
        boolean r2 = true;
    L12:
        r0.setEnabled(r2);
        float r5 = 1.0f;
        if (r9.isAdminLimit() == false) goto L15;
        float r4 = 0.5f;
    L16:
        r0.setAlpha(r4);
        r0.setSelected(r9.isSelected());
        r0.setActivated(this.e.isExpanded(r9));
        Stack r6 = (Stack) this.e.getExpandedSubToolbars().getValue();
        r10.setTag(r1.name());
        b0 r7 = this.n;
        String r8 = r1.name();
        r7.getClass();
        if (TextUtils.isEmpty(r8) == false) goto L19;
        CharSequence r11 = null;
    L20:
        r10.setContentDescription(r11);
        if (r9.isAdminLimit() == false) goto L23;
    L26:
        r10.setEnabled(r3);
        if (r9.isAdminLimit() == false) goto L29;
        r5 = 0.5f;
    L29:
        r10.setAlpha(r5);
        r10.setSelected(r9.isSelected());
        r10.setOnClickListener(new b(this, r10, r1));
        return;
    L23:
        if (r9.isEnable() == true) goto L26;
        r3 = false;
        goto L26
    L19:
        Map<CharSequence, CharSequence> r12 = r7.a;
        Intrinsics.checkNotNull(r8);
        r11 = (CharSequence) ((LinkedHashMap) r12).get(r8);
        goto L20
    L15:
        r4 = 1.0f;
        goto L16
    L8:
        if (r9.isEnable() == true) goto L11;
        r2 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        q = getContext().getResources().getDimensionPixelSize(2131168471);
        View r4 = r2.findViewById(2131376824);
        this.g = r4;
        r4.setOnClickListener(new c(this));
        View r5 = r2.findViewById(2131376825);
        this.h = r5;
        r5.setContentDescription("keyboardSwitch");
        this.l = (KeyboardPlaceholderView) r2.findViewById(2131376823);
        this.i = r2.findViewById(2131389063);
        this.j = (ViewGroup) r2.findViewById(2131389103);
        this.e.keyboardHeightLiveData().observe(this, new d(this));
        this.e.getToolbar().observe(this, new e(this));
        this.e.getExpandedSubToolbars().observe(this, new f(this));
        this.f.getActiveEditPanel().observe(this, new a(this));
        r2.getViewTreeObserver().addOnWindowFocusChangeListener(this.p);
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L6;
        this.o.b(r6, new g(this));
        return;
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131565070, r3, false);
    }
}
