package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.core.toolbar.BaseSubToolbarFragment;
import com.bytedance.ee.bear.core.toolbar.selectcolor.impl.SelectColorV2Fragment;
import com.bytedance.ee.bear.core.widget.KeyboardPlaceholderView;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class OfficeBaseToolbarV2PanelFragment<Toolbar extends ToolbarV2> extends BaseFragment {
    public static final ItemV2[] A = null;
    public static final int w = 0;
    public static final int x = 0;
    public static final int y = 0;
    public static final int z = 0;
    public BaseToolbarV2PanelViewModel<Toolbar> e;
    public View f;
    public View g;
    public View h;
    public ImageView i;
    public ViewGroup j;
    public ViewGroup k;
    public ViewGroup l;
    public ViewGroup m;
    public pcb.a n;
    public HorizontalOverScrollView o;
    public int p;
    public KeyboardPlaceholderView q;
    public r r;
    public final w s;
    public final v t;
    public boolean u;
    public j v;

    public class a implements Observer<g45.a> {
        public g45.a a;

        public a() {
        }

        public final void onChanged(Object r1) {
            this.a = (g45.a) r1;
        }
    }

    public abstract Class<? extends BaseSubToolbarFragment> V90(ItemIdV2 r1);

    public abstract Class<? extends BaseSubToolbarV2Fragment> W90(ItemIdV2 r1);

    public int X90(ItemIdV2 r1) {
        return 2131233698;
    }

    public int Y90(ItemIdV2 r1) {
        return 2131233700;
    }

    public abstract an4.a Z90();

    public an4.b aa0() {
        return null;
    }

    public Drawable ba0(ItemIdV2 r1) {
        return null;
    }

    public abstract int ca0(ItemIdV2 r1);

    public abstract BaseToolbarV2PanelViewModel<Toolbar> ea0();

    public abstract boolean ga0(Fragment r1);

    public void ha0(View r1, ItemV2 r2) {
    }

    public View ia0(ViewGroup r1, ItemV2 r2) {
        return null;
    }

    public void ja0(int r1) {
    }

    public void la0() {
    }

    static {
        w = com.bytedance.ee.util.ui.n.c(0.5f);
        x = com.bytedance.ee.util.ui.n.d(24);
        y = com.bytedance.ee.util.ui.n.d(44);
        z = com.bytedance.ee.util.ui.n.d(3);
        A = new ItemV2[0];
    }

    public void ka0() {
        boolean r0 = this.e.clearSubToolbar();
        if (r0 == true) goto L5;
        U90(true);
    L5:
        if (r0 == true) goto L7;
        rcb.c.c(getContext());
        return;
    L7:
        rcb.c.g(getContext());
    }

    public final void ta0() {
        ToolbarV2 r0 = (ToolbarV2) this.e.getToolbar().getValue();
        this.e.getKeyboardHeight();
        na0(r0);
        ItemV2 r1 = (ItemV2) this.e.getExpandedSubToolbar().getValue();
        boolean r2 = this.n.isKeyboardShowing();
        boolean r3 = true;
        if (rcb.b.a(getActivity()) == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        this.h.setSelected(false);
        return;
    L11:
        View r5 = this.h;
        if (r2 == false) goto L18;
        if (r1 != null) goto L15;
    L17:
        r3 = false;
        goto L18
    L15:
        if (r1.id().displayMode() != ItemIdV2.DisplayMode.FunctionPanel) goto L17;
    L18:
        r5.setSelected(r3);
        return;
    L5:
        if (rcb.b.b(getActivity()) == true) goto L8;
        r4 = false;
        goto L9
    }

    public OfficeBaseToolbarV2PanelFragment() {
        this.s = new w();
        this.t = new v();
    }

    public void onDestroyView() {
        super.onDestroyView();
        HorizontalOverScrollView r0 = this.o;
        r r1 = this.r;
        ((ArrayList) r0.a).remove(r1);
        boolean r2 = true;
        U90(true);
        if (this.u == true) goto L5;
    L7:
        r2 = false;
    L8:
        if (r2 == false) goto L11;
        this.e.keyboardHeightLiveData().removeObserver(this.v);
        return;
    L11:
        return;
    L5:
        if (((Boolean) FGDowngradeHelper.e.getValue()).booleanValue() == true) goto L7;
        goto L7
    }

    public final void onStart() {
        super.onStart();
        if (this.u == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        this.e.keyboardHeightLiveData().observeForever(this.v);
        return;
    L11:
        return;
    L5:
        if (((Boolean) FGDowngradeHelper.e.getValue()).booleanValue() == true) goto L7;
        r0 = true;
        goto L8
    }

    public void U90(boolean r4) {
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
        fa0(r2);     // Catch: Exception -> L20
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
        tt5.a.e("ToolbarV2", "dismissAllFunctionPanel err: ", e, false);
    }

    public Integer da0(ItemIdV2 r2) {
        if (ToolbarPrimaryItemId.inlineAI.equals(r2) == false) goto L5;
        return null;
    L5:
        if (ToolbarPrimaryItemId.aiRewrite.equals(r2) == false) goto L8;
        return null;
    L8:
        return 2131101286;
    }

    public final void fa0(Fragment r4) {
        Dialog r0 = ((DialogFragment) r4).getDialog();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L27;
        tt5.a.h("ToolbarV2", "dismiss " + r4.getTag());
        Handler r5 = DialogLancet.resolveDialogHandler(r0);
        if (r5 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r6 == null) goto L20;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        goto L20
    L9:
        if (Looper.myLooper() == r5.getLooper()) goto L11;
        r5.post(DialogLancet.createDismissRunnable(r0));
        return;
    }

    public void na0(ToolbarV2 r3) {
        if (r3 != null) goto L4;
    L10:
        this.j.setVisibility(8);
        tt5.a.h("ToolbarV2", "hide toolbar items length = 0");
        return;
    L4:
        if (r3.getItems() == null) goto L10;
        if (r3.getItems().length == 0) goto L10;
        this.j.setVisibility(0);
        ua0(r3);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.ee.bear.edit.toolbar.toolbar2.j] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        FragmentActivity r3 = getActivity();
        this.e = ea0();
        this.n = pcb.a.a.b(r3);
        this.u = ForsetiHelper.s(this);
        this.v = new j(this);
    }

    public final void pa0(Fragment r2) {
        Dialog r3 = ((DialogFragment) r2).getDialog();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isShowing() == false) goto L7;
        return;
    L7:
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
    }

    public void qa0(ItemV2 r6) {
        this.q.a();
        FragmentActivity r0 = getActivity();
        FragmentManager r1 = r0.getSupportFragmentManager();
        String r2 = r6.id().name();
        Fragment r3 = r1.findFragmentByTag(r2);
        if ((r3 instanceof BaseSubToolbarFragment) == true) goto L20;
        Class<? extends BaseSubToolbarFragment> r7 = V90(r6.id());
        if (r7 != null) goto L8;
        return;
    L8:
        if (getArguments() != null) goto L10;
        Bundle r4 = new Bundle();
    L11:
        Fragment r8 = (BaseSubToolbarFragment) Fragment.instantiate(r0, r7.getName(), r4);
        if ((r8 instanceof Fragment) == false) goto L14;
        Fragment r5 = r8;
    L15:
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, r2, r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r5, r9) == true) goto L26;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L19:
        r8.show(r1, r2);
        return;
    L26:
        return;
    L14:
        r5 = null;
        goto L15
    L10:
        r4 = getArguments();
        goto L11
    L20:
        pa0(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ra0(ItemV2 r12) {
        FragmentActivity r0 = getActivity();
        FragmentManager r1 = getChildFragmentManager();
        String r2 = r12.id().name();
        if ((r1.findFragmentByTag(r2) instanceof BaseSubToolbarV2Fragment) == true) goto L27;
        Class<? extends BaseSubToolbarV2Fragment> r3 = W90(r12.id());
        if (r3 != null) goto L8;
        return;
    L8:
        if (this.k.getChildCount() <= 0) goto L18;
        ViewGroup r5 = this.k;
        FragmentManager r6 = getChildFragmentManager();
        if (r5.getChildCount() <= 0) goto L18;
        int r7 = 0;
    L13:
        if (r7 >= r5.getChildCount()) goto L18;
        View r8 = r5.getChildAt(r7);
        if (r8.getTag() == null) goto L17;
        tt5.a.b("ToolbarV2", "remove fragment " + r8.getTag());
        oa0(r6, r6.findFragmentByTag((String) r8.getTag()));
    L17:
        r7 = r7 + 1;
    L18:
        ViewGroup r4 = this.k;
        if (getArguments() != null) goto L21;
        Bundle r9 = new Bundle();
    L22:
        r9.putSerializable(ItemV2.class.getName(), r12);
        BaseSubToolbarV2Fragment r13 = (BaseSubToolbarV2Fragment) Fragment.instantiate(r0, r3.getName(), r9);
        r13.s = Z90();
        r13.t = aa0();
        FragmentTransaction r10 = r1.beginTransaction().setCustomAnimations(2130772186, 2130772187, 2130772186, 2130772187);
        int r11 = r4.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r2, r11) == true) goto L26;
        r10 = r10.replace(r11, r13, r2);
    L26:
        r10.commitAllowingStateLoss();
        ea0().requestUpdateContentHeight();
        return;
    L21:
        r9 = getArguments();
        goto L22
    L27:
        tt5.a.h("ToolbarV2", "showSubToolbarV2 already show");
    }

    public void sa0(ItemV2 r12) {
        boolean r1 = false;
        if (r12 != null) goto L12;
        U90(false);
        tt5.a.h("ToolbarV2", "removeAllSubToolBarV2 ");
        List r13 = getChildFragmentManager().getFragments();
        if (r13 == null) goto L116;
        Iterator r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L120;
        Fragment r0 = (Fragment) r14.next();
        if ((r0 instanceof BaseSubToolbarV2Fragment) == false) goto L8;
        oa0(getChildFragmentManager(), r0);
        goto L8
    L120:
        return;
    L116:
        return;
    L12:
        List r2 = getActivity().getSupportFragmentManager().getFragments();
        if (r2 == null) goto L57;
        Iterator r4 = r2.iterator();
    L17:
        if (r4.hasNext() == false) goto L43;
        Fragment r5 = (Fragment) r4.next();
        if ((r5 instanceof BaseSubToolbarFragment) == true) goto L21;
        String r6 = r5.getTag();
        an4.a r7 = Z90();
        an4.e r8 = null;
        if (r7 == null) goto L28;
        Set r9 = r7.getItemFactorySet();
    L29:
        if (r9 == null) goto L36;
        Iterator r10 = r9.iterator();
    L32:
        if (r10.hasNext() == false) goto L36;
        an4.e r11 = (an4.e) r10.next();
        if (TextUtils.equals(r11.getItemId().name(), r6) == false) goto L32;
        r8 = r11;
    L36:
        tt5.a.h("ToolbarV2", "findToolbarItemFactoryByName, toolbarItemFactory: " + r8 + ", name is " + r5.getTag());
        if ((r8 instanceof an4.f) == false) goto L17;
        if (aa0() == null) goto L17;
        if (r5.getTag() == null) goto L17;
        ((an4.f) r8).dismissPanel(aa0(), r5.getTag());
        goto L17
    L28:
        r9 = null;
        goto L29
    L21:
        if (r12.id().name().equals(r5.getTag()) == true) goto L17;
        if (ga0(r5) == false) goto L17;
        fa0(r5);
        goto L17
    L43:
        ItemIdV2 r16 = r12.id();
        Iterator r3 = r2.iterator();
    L45:
        if (r3.hasNext() == false) goto L52;
        Fragment r17 = (Fragment) r3.next();
        if (r16.name().equals(r17.getTag()) == false) goto L45;
        if ((r17 instanceof BaseSubToolbarFragment) == false) goto L51;
        pa0(r17);
    L51:
        boolean r18 = true;
    L53:
        if (r18 == true) goto L57;
        if (r16.displayMode() != ItemIdV2.DisplayMode.FunctionPanel) goto L57;
        qa0(r12);
        goto L57
    L52:
        r18 = false;
    L57:
        List r19 = getChildFragmentManager().getFragments();
        if (r19 == null) goto L119;
        Iterator r20 = r19.iterator();
    L62:
        if (r20.hasNext() == false) goto L68;
        Fragment r21 = (Fragment) r20.next();
        if ((r21 instanceof BaseSubToolbarV2Fragment) == false) goto L62;
        if (r12.id().name().equals(r21.getTag()) == true) goto L62;
        tt5.a.h("ToolbarV2", "remove fragment " + r21.getTag());
        oa0(getChildFragmentManager(), r21);
        ea0().requestUpdateContentHeight();
        goto L62
    L68:
        ItemIdV2 r22 = r12.id();
        Iterator r23 = r19.iterator();
    L70:
        if (r23.hasNext() == false) goto L74;
        if (r22.name().equals(((Fragment) r23.next()).getTag()) == false) goto L70;
        r1 = true;
    L74:
        if (r1 == false) goto L76;
        return;
    L76:
        if (r22.displayMode() != ItemIdV2.DisplayMode.SubToolBarV2) goto L118;
        ra0(r12);
        return;
    L118:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.ee.bear.edit.toolbar.toolbar2.q, java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r3v22, types: [com.bytedance.ee.bear.edit.toolbar.toolbar2.r, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void ua0(Toolbar r19) {
        ItemV2[] r1 = r19.getItems();
        if (r1 != null) goto L5;
        r1 = A;
    L5:
        int r2 = this.m.getChildCount();
        if (r1.length <= r2) goto L12;
        LayoutInflater r3 = LayoutInflater.from(getContext());
        int r6 = 0;
    L9:
        if (r6 >= (r1.length - r2)) goto L17;
        r3.inflate(2131559960, this.m);
        r6 = r6 + 1;
    L17:
        int r4 = 0;
    L19:
        if (r4 >= r1.length) goto L101;
        ItemV2 r5 = r1[r4];
        View r9 = this.m.getChildAt(r4);
        String r10 = r19.getShowingItemId();
        if (ItemIdV2.ConstId.separator.name().equals(r5.id().name()) == false) goto L28;
        View r7 = r9.findViewById(2131389060);
        AppCompatImageView r8 = r9.findViewById(2131389061);
        View r11 = r9.findViewById(2131385938);
        r9.setTag(r5.id().name());
        if (r7 == null) goto L25;
        r7.setVisibility(8);
    L25:
        r8.setVisibility(8);
        r11.setVisibility(0);
        ItemIdV2 r12 = r5.id();
        if (r12 == r8.getTag()) goto L100;
        r8.setTag(r12);
    L100:
        r4 = r4 + 1;
        goto L19
    L28:
        boolean r13 = this.e.isExpanded(r5);
        boolean r14 = r5.id().name().equals(r10);
        r9.setOnClickListener(new t(this, r13, r5));
        r9.setTag(r5.id().name());
        if (r5.isAdminLimit() == false) goto L31;
    L34:
        boolean r16 = true;
    L35:
        r9.setEnabled(r16);
        if (r5.isAdminLimit() == false) goto L38;
        float r17 = 0.5f;
    L39:
        r9.setAlpha(r17);
        r9.setSelected(r5.isSelected());
        w r18 = this.s;
        String r20 = r5.id().name();
        r18.getClass();
        if (TextUtils.isEmpty(r20) == false) goto L42;
        CharSequence r21 = null;
    L44:
        if (TextUtils.isEmpty(r21) == true) goto L47;
        r9.setContentDescription(r21);
    L47:
        if ((r9 instanceof ViewGroup) == false) goto L56;
        ViewGroup r22 = (ViewGroup) r9;
        View r110 = ia0(r22, r5);
        if (r110 != null) goto L51;
    L53:
        ha0(r9, r5);
        if (r110 == null) goto L56;
    L51:
        if (r110.getParent() == r22) goto L53;
        r22.removeAllViews();
        r22.addView(r110);
    L56:
        View r23 = r9.findViewById(2131389060);
        final AppCompatImageView r24 = r9.findViewById(2131389061);
        TextView r26 = (TextView) r9.findViewById(2131389062);
        View r27 = r9.findViewById(2131385938);
        if (r23 == null) goto L59;
        r23.setVisibility(0);
    L59:
        r24.setVisibility(0);
        r27.setVisibility(8);
        if (r26 == null) goto L72;
        ItemIdV2 r28 = r5.id();
        if ((r28 instanceof ToolbarPrimaryItemId) == true) goto L65;
    L68:
        int r29 = 0;
    L69:
        if (r29 == 0) goto L71;
        r26.setVisibility(0);
        r26.setText(r29);
        goto L72
    L71:
        r26.setVisibility(8);
        goto L72
    L65:
        if (gx4.d.a[((ToolbarPrimaryItemId) r28).ordinal()] != 17) goto L68;
        r29 = 2131889047;
    L72:
        ItemIdV2 r30 = r5.id();
        if (r30 == r24.getTag()) goto L80;
        int r31 = ca0(r5.id());
        Drawable r32 = ba0(r5.id());
        if (r32 == null) goto L77;
        r24.setTag(r30);
        r24.setImageDrawable(r32);
        goto L80
    L77:
        if (r31 == 0) goto L80;
        r24.setTag(r30);
        r24.setImageResource(r31);
    L80:
        if (r5.getIconKey() == null) goto L83;
        r24.setImageResource(com.bytedance.ee.util.ui.n.n(getContext(), r5.getIconKey()));
    L83:
        if (r5.isAdminLimit() == false) goto L85;
    L88:
        boolean r33 = true;
    L89:
        r24.setEnabled(r33);
        if (r5.isAdminLimit() == false) goto L92;
        float r34 = 0.5f;
    L93:
        r24.setAlpha(r34);
        Integer r36 = da0(r5.id());
        if (r36 == null) goto L96;
        r24.setImageTintList(AppCompatResources.getColorStateList(requireContext(), r36.intValue()));
    L97:
        if (r14 == false) goto L99;
        r24.setBackgroundResource(X90(r5.id()));
        r24.post(new s(this, r24));
        goto L100
    L99:
        r24.setBackgroundResource(Y90(r5.id()));
        goto L100
    L96:
        r24.setImageTintList(null);
        goto L97
    L92:
        r34 = 1.0f;
        goto L93
    L85:
        if (r5.isEnable() == true) goto L88;
        r33 = false;
        goto L89
    L42:
        Map<CharSequence, CharSequence> r111 = r18.a;
        Intrinsics.checkNotNull(r20);
        r21 = (CharSequence) ((LinkedHashMap) r111).get(r20);
        goto L44
    L38:
        r17 = 1.0f;
        goto L39
    L31:
        if (r5.isEnable() == true) goto L34;
        r16 = false;
        goto L35
    L101:
        int r37 = r1.length;
        int r38 = 0;
        int r39 = 0;
    L102:
        if (r38 >= r37) goto L107;
        if (r1[r38].id().name().equals(ItemIdV2.ConstId.separator.name()) == false) goto L106;
        r39 = r39 + 1;
    L106:
        r38 = r38 + 1;
        goto L102
    L107:
        this.p = r1.length - r39;
        final ?? r40 = new q(this);
        if (this.o.isLaidOut() == false) goto L110;
        r40.run();
    L112:
        if (this.r != null) goto L115;
        ?? r41 = new r(r40);
        this.r = r41;
        ((ArrayList) this.o.a).add(r41);
    L115:
        if (getView() == null) goto L117;
        int r42 = getView().getWidth();
    L119:
        if (this.u == false) goto L122;
        if (r42 <= 0) goto L122;
    L123:
        int r43 = Math.min(7, this.p);
        int r44 = Math.min(r42 / 8, y) + z;
        int r112 = 10;
        int r46 = Math.min(10, r1.length + 1);
        if (r1.length < 7) goto L127;
        r112 = r46;
    L127:
        int r47 = x;
        int r48 = ((r42 - (r43 * r47)) - r44) / r112;
        if (r1.length >= 6) goto L130;
        r48 = ((r42 - (r47 * 7)) - r44) / r112;
    L130:
        int r49 = r47 + r48;
        int r50 = r48 / 2;
        this.m.setPadding(r50, 0, r50, 0);
        this.m.setClipToPadding(false);
        View r51 = this.h;
        ViewGroup.LayoutParams r52 = r51.getLayoutParams();
        if (r52.width == r44) goto L133;
        r52.width = r44;
        r51.requestLayout();
    L133:
        int r53 = 0;
    L135:
        if (r53 >= this.m.getChildCount()) goto L158;
        View r54 = this.m.getChildAt(r53);
        if (r1[r53].id().name().equals(ItemIdV2.ConstId.separator.name()) == false) goto L141;
        int r56 = w + r48;
        ViewGroup.LayoutParams r113 = r54.getLayoutParams();
        if (r113.width == r56) goto L157;
        r113.width = r56;
        r54.requestLayout();
    L157:
        r53 = r53 + 1;
        goto L135
    L141:
        ItemIdV2 r57 = r1[r53].id();
        if ((r57 instanceof ToolbarPrimaryItemId) == true) goto L144;
    L147:
        char r58 = 0;
    L148:
        if (r58 == 0) goto L152;
        View r59 = r54.findViewById(2131389060);
        if (r59 == null) goto L152;
        r59.measure(0, 0);
        int r60 = Math.max(r49, r59.getMeasuredWidth() + Math.max(0, r48));
    L154:
        ViewGroup.LayoutParams r114 = r54.getLayoutParams();
        if (r114.width == r60) goto L157;
        r114.width = r60;
        r54.requestLayout();
    L152:
        r60 = r49;
        goto L154
    L144:
        if (gx4.d.a[((ToolbarPrimaryItemId) r57).ordinal()] != 17) goto L147;
        r58 = 2967;
        goto L148
    L158:
        return;
    L122:
        r42 = com.bytedance.ee.util.ui.n.v();
        goto L123
    L117:
        r42 = 0;
        goto L119
    L110:
        this.o.post(r40);
        goto L112
    L12:
        if (r1.length >= r2) goto L17;
        int r61 = 0;
    L15:
        if (r61 >= (r2 - r1.length)) goto L17;
        ViewGroup r62 = this.m;
        r62.removeViewAt(r62.getChildCount() - 1);
        r61 = r61 + 1;
        goto L15
    }

    public void ma0(ItemIdV2 r4, String r5) {
        if (r4 == ItemIdV2.ConstId.keyboard) goto L5;
        int r1 = 0;
        if (r4 != ToolbarPrimaryItemId.insertImage) goto L25;
        if (getActivity() != null) goto L16;
    L29:
        this.e.processToolbarItemClick(r4, r5);
    L31:
        if (Z90() != null) goto L33;
        return;
    L33:
        if (Z90().getOnToolbarItemClickCallBack() == null) goto L37;
        Z90().getOnToolbarItemClickCallBack().invoke(r4.name());
        return;
    L37:
        return;
    L16:
        if (rcb.b.a(getActivity()) == false) goto L18;
    L19:
        int r0 = pcb.a.a.b(getActivity()).keyBoardRawHeight();
        if ("true".equals(r5) == false) goto L22;
        U90(true);
    L23:
        this.q.b(r1);
        goto L29
    L22:
        r1 = r0;
        goto L23
    L18:
        if (rcb.f.b() == false) goto L29;
    L25:
        if (getActivity() == null) goto L29;
        if (rcb.b.a(getActivity()) == false) goto L29;
        this.q.b(0);
        goto L29
    L5:
        if (rcb.b.a(getActivity()) == false) goto L7;
    L10:
        rcb.c.c(getContext());
        this.e.hideToolbar();
        goto L31
    L7:
        if (rcb.b.b(getActivity()) == true) goto L10;
        this.e.processToolbarItemClick(r4, r5);
        ka0();
        goto L31
    }

    public final void oa0(FragmentManager r3, Fragment r4) {
        if (r3 == null) goto L6;
        if (r4 == null) goto L7;
        r3.beginTransaction().setCustomAnimations(2130772186, 2130772187, 2130772186, 2130772187).remove(r4).commitAllowingStateLoss();
        return;
    L7:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.o = (HorizontalOverScrollView) r3.findViewById(2131385238);
        this.g = r3.findViewById(2131379535);
        this.h = r3.findViewById(2131376826);
        ImageView r5 = (ImageView) r3.findViewById(2131376825);
        this.i = r5;
        r5.setContentDescription("keyboardSwitch");
        com.bytedance.ee.util.ui.l.c(this.i, 2131102418);
        this.f = r3.findViewById(2131376824);
        this.i.setOnClickListener(new k(this));
        this.q = (KeyboardPlaceholderView) r3.findViewById(2131376823);
        this.j = (ViewGroup) r3.findViewById(2131389063);
        this.m = (ViewGroup) r3.findViewById(2131389103);
        this.k = (ViewGroup) r3.findViewById(2131367739);
        this.l = (ViewGroup) r3.findViewById(2131367740);
        if (this.u == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
        this.e.keyboardHeightLiveData().observe(getViewLifecycleOwner(), new l(this));
    L10:
        this.e.getToolbar().observe(getViewLifecycleOwner(), new m(this));
        this.e.getExpandedSubToolbar().observe(getViewLifecycleOwner(), new n(this));
        this.e.observeActivePanel(this, new a());
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L14;
        this.t.b(r7, new o(this));
    L14:
        if (this.u == false) goto L17;
        r3.addOnLayoutChangeListener(new p(this));
        return;
    L17:
        return;
    L5:
        if (((Boolean) FGDowngradeHelper.e.getValue()).booleanValue() == true) goto L7;
        r6 = true;
        goto L8
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131559959, r3, false);
    }
}
