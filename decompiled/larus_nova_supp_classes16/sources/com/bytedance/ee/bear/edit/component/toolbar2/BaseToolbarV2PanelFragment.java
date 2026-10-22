package com.bytedance.ee.bear.edit.component.toolbar2;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
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
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.document.knowledgeai.DocsKnowledgeAIType;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment;
import com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorV2Fragment;
import com.bytedance.ee.bear.document.widget.KeyboardPlaceholderView;
import com.bytedance.ee.bear.edit.component.document.at.AtPanelViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseToolbarV2PanelFragment<Toolbar extends ToolbarV2> extends BaseFragment {
    public static final int A = 0;
    public static final int x = 0;
    public static final int y = 0;
    public static final int z = 0;
    public BaseToolbarV2PanelViewModel<Toolbar> e;
    public View f;
    public View g;
    public View h;
    public ImageView i;
    public View j;
    public ViewGroup k;
    public ViewGroup l;
    public ViewGroup m;
    public ObjectAnimator n;
    public pcb.a o;
    public HorizontalOverScrollView p;
    public int q;
    public KeyboardPlaceholderView r;
    public r s;
    public final b0 t;
    public final com.bytedance.ee.bear.edit.toolbar.toolbar2.v u;
    public boolean v;
    public o w;

    public class a implements Observer<g45.a> {
        public g45.a a;
        public final /* synthetic */ BaseToolbarV2PanelFragment b;

        public a(BaseToolbarV2PanelFragment r1) {
            this.b = r1;
        }

        public final void onChanged(Object r3) {
            g45.a r4 = (g45.a) r3;
            if ((r4 instanceof AtPanelViewModel) == false) goto L5;
            BaseToolbarV2PanelFragment.U90(this.b, false);
        L10:
            this.a = r4;
            return;
        L5:
            BaseToolbarV2PanelFragment r0 = this.b;
            if (r0.e != r4) goto L10;
            if ((this.a instanceof AtPanelViewModel) == false) goto L10;
            BaseToolbarV2PanelFragment.U90(r0, true);
            goto L10
        }
    }

    public abstract Class<? extends BaseSubToolbarFragment> W90(ItemIdV2 r1);

    public abstract Class<? extends BaseSubToolbarV2Fragment> X90(ItemIdV2 r1);

    public abstract int Y90(ItemIdV2 r1);

    public abstract BaseToolbarV2PanelViewModel Z90();

    public abstract boolean ba0(Fragment r1);

    public void ca0(int r1) {
    }

    public void ea0() {
    }

    public void ja0(FragmentActivity r1, Fragment r2) {
    }

    static {
        x = com.bytedance.ee.util.ui.n.c(0.5f);
        y = com.bytedance.ee.util.ui.n.d(24);
        z = com.bytedance.ee.util.ui.n.d(44);
        A = com.bytedance.ee.util.ui.n.d(3);
    }

    public void da0() {
        boolean r0 = this.e.clearSubToolbar();
        if (r0 == true) goto L21;
        FragmentActivity r1 = getActivity();
        Iterator r2 = r1.getSupportFragmentManager().getFragments().iterator();
    L6:
        if (r2.hasNext() == false) goto L21;
        DialogFragment r3 = (Fragment) r2.next();
        if ((r3 instanceof BaseSubToolbarFragment) == true) goto L25;
        if ((r3 instanceof SelectColorV2Fragment) == true) goto L25;
        ja0(r1, r3);
    L25:
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L16
    L20:
        r0 = true;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L20;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L21:
        if (r0 == true) goto L23;
        rcb.c.c(getContext());
        return;
    L23:
        rcb.c.g(getContext());
    }

    public final void ma0() {
        ToolbarV2 r0 = (ToolbarV2) this.e.getToolbar().getValue();
        this.e.getKeyboardHeight();
        ga0(r0);
        ItemV2 r1 = (ItemV2) this.e.getExpandedSubToolbar().getValue();
        boolean r2 = this.o.isKeyboardShowing();
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

    public BaseToolbarV2PanelFragment() {
        this.t = new b0();
        this.u = new com.bytedance.ee.bear.edit.toolbar.toolbar2.v();
    }

    public void onDestroyView() {
        super.onDestroyView();
        HorizontalOverScrollView r0 = this.p;
        r r1 = this.s;
        ((ArrayList) r0.a).remove(r1);
        boolean r2 = true;
        V90(true);
        if (this.v == true) goto L5;
    L7:
        r2 = false;
    L8:
        if (r2 == false) goto L11;
        this.e.keyboardHeightLiveData().removeObserver(this.w);
        return;
    L11:
        return;
    L5:
        if (((Boolean) FGDowngradeHelper.e.getValue()).booleanValue() == true) goto L7;
        goto L7
    }

    public final void onStart() {
        super.onStart();
        if (this.v == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        this.e.keyboardHeightLiveData().observeForever(this.w);
        return;
    L11:
        return;
    L5:
        if (((Boolean) FGDowngradeHelper.e.getValue()).booleanValue() == true) goto L7;
        r0 = true;
        goto L8
    }

    public final void V90(boolean r6) {
        FragmentActivity r0 = getActivity();
        List r1 = r0.getSupportFragmentManager().getFragments();
        if (r1 != null) goto L28;
        return;
    L28:
        Iterator r2 = r1.iterator();     // Catch: Exception -> L23
    L6:
        if (r2.hasNext() == false) goto L36;
        DialogFragment r3 = (Fragment) r2.next();     // Catch: Exception -> L23
        if ((r3 instanceof BaseSubToolbarFragment) == false) goto L11;
    L12:
        if (r6 == true) goto L26;
        aa0(r3);     // Catch: Exception -> L23
    L21:
        ja0(r0, r3);     // Catch: Exception -> L23
        goto L6
    L26:
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L23
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L23
        if (r4 == null) goto L21;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L23
        goto L21
    L11:
        if ((r3 instanceof SelectColorV2Fragment) == false) goto L21;
    L36:
        return;
    L23:
        e = move-exception;
        tt5.a.e("ToolbarV2", "dismissAllFunctionPanel err: ", e, false);
    }

    public final void aa0(Fragment r4) {
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

    public void ga0(ToolbarV2 r3) {
        if (r3 != null) goto L4;
    L8:
        this.j.setVisibility(8);
        tt5.a.h("ToolbarV2", "hide toolbar items length = 0");
        return;
    L4:
        if (r3.getItems().length == 0) goto L8;
        this.j.setVisibility(0);
        na0(r3);
    }

    public final void ia0(ViewGroup r6) {
        FragmentManager r0 = getChildFragmentManager();
        if (r6.getChildCount() <= 0) goto L11;
        int r1 = 0;
    L6:
        if (r1 >= r6.getChildCount()) goto L15;
        View r2 = r6.getChildAt(r1);
        if (r2.getTag() == null) goto L10;
        tt5.a.b("ToolbarV2", "remove fragment " + r2.getTag());
        ha0(r0, r0.findFragmentByTag((String) r2.getTag()));
    L10:
        r1 = r1 + 1;
        goto L6
    L15:
        return;
    }

    public final void ka0(Fragment r2) {
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

    public void la0(ItemV2 r6) {
        this.r.a();
        FragmentActivity r0 = getActivity();
        FragmentManager r1 = r0.getSupportFragmentManager();
        String r2 = r6.id().name();
        Fragment r3 = r1.findFragmentByTag(r2);
        if ((r3 instanceof BaseSubToolbarFragment) == true) goto L20;
        Class<? extends BaseSubToolbarFragment> r7 = W90(r6.id());
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
        ka0(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ee.bear.edit.component.toolbar2.q, java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r3v23, types: [com.bytedance.ee.bear.edit.component.toolbar2.r, java.lang.Object] */
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
    public final void na0(Toolbar r17) {
        ItemV2[] r2 = r17.getItems();
        int r0 = this.m.getChildCount();
        if (r2.length <= r0) goto L9;
        LayoutInflater r3 = LayoutInflater.from(getContext());
        int r6 = 0;
    L6:
        if (r6 >= (r2.length - r0)) goto L14;
        r3.inflate(2131565073, this.m);
        r6 = r6 + 1;
    L14:
        int r4 = 0;
    L15:
        int r7 = 2131889047;
        if (r4 >= r2.length) goto L98;
        ItemV2 r8 = r2[r4];
        View r9 = this.m.getChildAt(r4);
        String r10 = r17.getShowingItemId();
        final AppCompatImageView r11 = r9.findViewById(2131389061);
        TextView r1 = (TextView) r9.findViewById(2131389062);
        View r12 = r9.findViewById(2131385938);
        r9.setTag(r8.id().name());
        if (ItemIdV2.ConstId.separator.name().equals(r8.id().name()) == false) goto L22;
        r11.setVisibility(8);
        r12.setVisibility(0);
        ItemIdV2 r5 = r8.id();
        if (r5 == r11.getTag()) goto L97;
        r11.setTag(r5);
    L97:
        r4 = r4 + 1;
        goto L15
    L22:
        if (r1 == null) goto L33;
        ItemIdV2 r13 = r8.id();
        if ((r13 instanceof ToolbarPrimaryItemId) == true) goto L27;
    L29:
        r7 = 0;
    L30:
        if (r7 == 0) goto L32;
        r1.setVisibility(0);
        r1.setText(r7);
        goto L33
    L32:
        r1.setVisibility(8);
        goto L33
    L27:
        if (ToolbarPrimaryItemId.aiRewrite != ((ToolbarPrimaryItemId) r13)) goto L29;
    L33:
        r11.setVisibility(0);
        r12.setVisibility(8);
        ItemIdV2 r14 = r8.id();
        CharSequence r16 = null;
        if (r14 == r11.getTag()) goto L54;
        int r18 = Y90(r8.id());
        Context r19 = getContext();
        if (r8.id().equals(ToolbarPrimaryItemId.aiRewrite) == false) goto L48;
        if (r19 == null) goto L48;
        com.bytedance.ee.bear.document.knowledgeai.a r110 = (com.bytedance.ee.bear.document.knowledgeai.a) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.document.knowledgeai.a.class);     // Catch: Throwable -> L46
        if (r110 == null) goto L48;
        if (r110.d() != DocsKnowledgeAIType.FLOW_AI) goto L48;
        Drawable r20 = r110.b(r19, com.bytedance.ee.util.ui.n.e(r19, 20.0f));     // Catch: Throwable -> L46
    L49:
        if (r20 == null) goto L51;
        r11.setTag(r14);
        r11.setImageDrawable(r20);
        goto L54
    L51:
        if (r18 == 0) goto L54;
        r11.setTag(r14);
        r11.setImageResource(r18);
    L46:
        th = move-exception;
        tt5.a.d("ToolbarIcons", "resolve aiRewrite drawable fail: " + th.getMessage());
    L48:
        r20 = null;
    L54:
        if (r8.getIconKey() == null) goto L57;
        r11.setImageResource(com.bytedance.ee.util.ui.n.n(getContext(), r8.getIconKey()));
    L57:
        if (r8.isAdminLimit() == false) goto L59;
    L62:
        boolean r21 = true;
    L63:
        r11.setEnabled(r21);
        float r111 = 0.5f;
        if (r8.isAdminLimit() == false) goto L66;
        float r22 = 0.5f;
    L67:
        r11.setAlpha(r22);
        r11.setSelected(r8.isSelected());
        if (ToolbarPrimaryItemId.inlineAI.equals(r8.id()) == false) goto L70;
    L73:
        r11.setImageTintList(null);
    L74:
        r9.setTag(r14.name());
        if (r8.isAdminLimit() == false) goto L77;
    L80:
        boolean r23 = true;
    L81:
        r9.setEnabled(r23);
        if (r8.isAdminLimit() == true) goto L85;
        r111 = 1.0f;
    L85:
        r9.setAlpha(r111);
        r9.setSelected(r8.isSelected());
        b0 r24 = this.t;
        String r112 = r14.name();
        r24.getClass();
        if (TextUtils.isEmpty(r112) == true) goto L90;
        Map<CharSequence, CharSequence> r26 = r24.a;
        Intrinsics.checkNotNull(r112);
        r16 = (CharSequence) ((LinkedHashMap) r26).get(r112);
    L90:
        if (TextUtils.isEmpty(r16) == true) goto L92;
        r9.setContentDescription(r16);
    L92:
        boolean r27 = this.e.isExpanded(r8);
        if (r8.id().name().equals(r10) == false) goto L95;
        r11.setBackgroundResource(2131233896);
        r11.post(new p(this, r11));
    L96:
        r9.setOnClickListener(new s(this, r27, r14));
        goto L97
    L95:
        r11.setBackgroundResource(2131233898);
        goto L96
    L77:
        if (r8.isEnable() == true) goto L80;
        r23 = false;
        goto L81
    L70:
        if (ToolbarPrimaryItemId.aiRewrite.equals(r8.id()) == true) goto L73;
        r11.setImageTintList(AppCompatResources.getColorStateList(getContext(), 2131106629));
        goto L74
    L66:
        r22 = 1.0f;
        goto L67
    L59:
        if (r8.isEnable() == true) goto L62;
        r21 = false;
        goto L63
    L98:
        int r28 = r2.length;
        int r29 = 0;
        int r30 = 0;
    L99:
        if (r29 >= r28) goto L104;
        if (r2[r29].id().name().equals(ItemIdV2.ConstId.separator.name()) == false) goto L103;
        r30 = r30 + 1;
    L103:
        r29 = r29 + 1;
        goto L99
    L104:
        this.q = r2.length - r30;
        final ?? r31 = new q(this);
        if (this.p.isLaidOut() == false) goto L107;
        r31.run();
    L109:
        if (this.s != null) goto L112;
        ?? r32 = new r(r31);
        this.s = r32;
        ((ArrayList) this.p.a).add(r32);
    L112:
        if (getView() == null) goto L114;
        int r33 = getView().getWidth();
    L116:
        if (this.v == false) goto L119;
        if (r33 <= 0) goto L119;
    L120:
        int r34 = Math.min(7, this.q);
        int r36 = Math.min(r33 / 8, z) + A;
        int r37 = 10;
        int r38 = Math.min(10, r2.length + 1);
        if (r2.length < 7) goto L124;
        r37 = r38;
    L124:
        int r39 = y;
        int r40 = ((r33 - (r34 * r39)) - r36) / r37;
        if (r2.length >= 6) goto L127;
        r40 = ((r33 - (r39 * 7)) - r36) / r37;
    L127:
        int r41 = r39 + r40;
        int r42 = r40 / 2;
        this.m.setPadding(r42, 0, r42, 0);
        this.m.setClipToPadding(false);
        View r43 = this.h;
        ViewGroup.LayoutParams r44 = r43.getLayoutParams();
        if (r44.width == r36) goto L130;
        r44.width = r36;
        r43.requestLayout();
    L130:
        int r46 = 0;
    L132:
        if (r46 >= this.m.getChildCount()) goto L155;
        View r47 = this.m.getChildAt(r46);
        if (r2[r46].id().name().equals(ItemIdV2.ConstId.separator.name()) == false) goto L138;
        int r48 = x + r40;
        ViewGroup.LayoutParams r49 = r47.getLayoutParams();
        if (r49.width == r48) goto L154;
        r49.width = r48;
        r47.requestLayout();
    L154:
        r46 = r46 + 1;
        goto L132
    L138:
        ItemV2 r50 = r2[r46];
        ItemIdV2 r51 = r50.id();
        if ((r51 instanceof ToolbarPrimaryItemId) == true) goto L141;
    L143:
        char r52 = 0;
    L144:
        if (r52 == 0) goto L149;
        View r53 = r47.findViewById(2131389060);
        if (r53 != null) goto L150;
        tt5.a.k("ToolbarV2", "getItemWidth content is null, item=" + r50.id().name());
        goto L149
    L150:
        r53.measure(0, 0);
        int r54 = Math.max(r41, r53.getMeasuredWidth() + Math.max(0, r40));
    L151:
        ViewGroup.LayoutParams r56 = r47.getLayoutParams();
        if (r56.width == r54) goto L154;
        r56.width = r54;
        r47.requestLayout();
    L149:
        r54 = r41;
        goto L151
    L141:
        if (ToolbarPrimaryItemId.aiRewrite != ((ToolbarPrimaryItemId) r51)) goto L143;
        r52 = 2967;
        goto L144
    L155:
        return;
    L119:
        r33 = com.bytedance.ee.util.ui.n.v();
        goto L120
    L114:
        r33 = 0;
        goto L116
    L107:
        this.p.post(r31);
        goto L109
    L9:
        if (r2.length >= r0) goto L14;
        int r57 = 0;
    L12:
        if (r57 >= (r0 - r2.length)) goto L14;
        ViewGroup r58 = this.m;
        r58.removeViewAt(r58.getChildCount() - 1);
        r57 = r57 + 1;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.ee.bear.edit.component.toolbar2.o] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        FragmentActivity r3 = getActivity();
        this.e = Z90();
        this.o = pcb.a.a.b(r3);
        this.v = ForsetiHelper.s(this);
        this.w = new o(this);
    }

    public static void U90(BaseToolbarV2PanelFragment r4, boolean r5) {
        ObjectAnimator r0 = r4.n;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        View r1 = r4.getView();
        if (r5 == false) goto L8;
        int r6 = -r1.getWidth();
        int r2 = 0;
    L9:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r1, "translationX", new float[]{r6, r2}).setDuration(200);
        r4.n = r7;
        r7.addListener(new t(r1));
        r4.n.start();
        return;
    L8:
        r2 = -r1.getWidth();
        r6 = 0;
        goto L9
    }

    public void fa0(ItemIdV2 r4, String r5) {
        if (r4 == ItemIdV2.ConstId.keyboard) goto L5;
        int r1 = 0;
        if (r4 != ToolbarPrimaryItemId.insertImage) goto L25;
        if (getActivity() != null) goto L16;
    L29:
        this.e.processToolbarItemClick(r4, r5);
        return;
    L16:
        if (rcb.b.a(getActivity()) == false) goto L18;
    L19:
        int r0 = pcb.a.a.b(getActivity()).keyBoardRawHeight();
        if ("true".equals(r5) == false) goto L22;
        V90(true);
    L23:
        this.r.c(r1);
        goto L29
    L22:
        r1 = r0;
        goto L23
    L18:
        if (rcb.f.b() == false) goto L29;
    L25:
        if (getActivity() == null) goto L29;
        if (rcb.b.a(getActivity()) == false) goto L29;
        this.r.c(0);
        goto L29
    L5:
        if (rcb.b.a(getActivity()) == false) goto L7;
    L10:
        rcb.c.c(getContext());
        this.e.hideToolbar();
        return;
    L7:
        if (rcb.b.b(getActivity()) == true) goto L10;
        this.e.processToolbarItemClick(r4, r5);
        da0();
    }

    public final void ha0(FragmentManager r3, Fragment r4) {
        if (r3 == null) goto L6;
        if (r4 == null) goto L7;
        r3.beginTransaction().setCustomAnimations(2130772650, 2130772651, 2130772650, 2130772651).remove(r4).commitAllowingStateLoss();
        return;
    L7:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.p = (HorizontalOverScrollView) r3.findViewById(2131385238);
        this.g = r3.findViewById(2131379535);
        this.h = r3.findViewById(2131376826);
        ImageView r5 = (ImageView) r3.findViewById(2131376825);
        this.i = r5;
        r5.setContentDescription("keyboardSwitch");
        com.bytedance.ee.util.ui.l.c(this.i, 2131102418);
        this.f = r3.findViewById(2131376824);
        this.i.setOnClickListener(new i(this));
        this.r = (KeyboardPlaceholderView) r3.findViewById(2131376823);
        this.j = r3.findViewById(2131389063);
        this.m = (ViewGroup) r3.findViewById(2131389103);
        this.k = (ViewGroup) r3.findViewById(2131367739);
        this.l = (ViewGroup) r3.findViewById(2131367740);
        if (this.v == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
        this.e.keyboardHeightLiveData().observe(getViewLifecycleOwner(), new j(this));
    L10:
        this.e.getToolbar().observe(getViewLifecycleOwner(), new k(this));
        this.e.getExpandedSubToolbar().observe(getViewLifecycleOwner(), new l(this));
        this.e.observeActivePanel(this, new a(this));
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L14;
        this.u.b(r7, new m(this));
    L14:
        if (this.v == false) goto L17;
        r3.addOnLayoutChangeListener(new n(this));
        return;
    L17:
        return;
    L5:
        if (((Boolean) FGDowngradeHelper.e.getValue()).booleanValue() == true) goto L7;
        r6 = true;
        goto L8
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131565072, r3, false);
    }
}
