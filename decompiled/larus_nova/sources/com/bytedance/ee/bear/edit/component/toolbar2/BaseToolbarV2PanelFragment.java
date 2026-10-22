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
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseToolbarV2PanelFragment<Toolbar extends ToolbarV2> extends BaseFragment {
    public static final int A = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f226071x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f226072y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f226073z = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseToolbarV2PanelViewModel<Toolbar> f226074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f226075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f226076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f226077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f226078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f226079j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f226080k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f226081l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f226082m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ObjectAnimator f226083n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public pcb.a f226084o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HorizontalOverScrollView f226085p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f226086q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public KeyboardPlaceholderView f226087r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public r f226088s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b0 f226089t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.bytedance.ee.bear.edit.toolbar.toolbar2.v f226090u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f226091v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public o f226092w;

    public class a implements Observer<g45.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g45.a f226093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseToolbarV2PanelFragment f226094b;

        public a(BaseToolbarV2PanelFragment r100) {
            this.f226094b = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(g45.a r100) {
            g45.a r101 = r100;
            if ((r101 instanceof AtPanelViewModel) == false) goto L5;
            BaseToolbarV2PanelFragment.U90(this.f226094b, false);
        L10:
            this.f226093a = r101;
            return;
        L5:
            BaseToolbarV2PanelFragment r102 = this.f226094b;
            if (r102.f226074e != r101) goto L10;
            if ((this.f226093a instanceof AtPanelViewModel) == false) goto L10;
            BaseToolbarV2PanelFragment.U90(r102, true);
            goto L10
        }
    }

    public abstract Class<? extends BaseSubToolbarFragment> W90(ItemIdV2 r100);

    public abstract Class<? extends BaseSubToolbarV2Fragment> X90(ItemIdV2 r100);

    public abstract int Y90(ItemIdV2 r100);

    public abstract BaseToolbarV2PanelViewModel Z90();

    public abstract boolean ba0(Fragment r100);

    public void ca0(int r100) {
    }

    public void ea0() {
    }

    public void ja0(FragmentActivity r100, Fragment r101) {
    }

    static {
        f226071x = com.bytedance.ee.util.ui.n.c(0.5f);
        f226072y = com.bytedance.ee.util.ui.n.d(24);
        f226073z = com.bytedance.ee.util.ui.n.d(44);
        A = com.bytedance.ee.util.ui.n.d(3);
    }

    public void da0() {
        boolean r100 = this.f226074e.clearSubToolbar();
        if (r100 == true) goto L21;
        FragmentActivity r101 = getActivity();
        Iterator<Fragment> r102 = r101.getSupportFragmentManager().getFragments().iterator();
    L6:
        if (r102.hasNext() == false) goto L21;
        Fragment r103 = r102.next();
        if ((r103 instanceof BaseSubToolbarFragment) == true) goto L25;
        if ((r103 instanceof SelectColorV2Fragment) == true) goto L25;
        ja0(r101, r103);
    L25:
        ((DialogFragment) r103).dismissAllowingStateLoss();     // Catch: Exception -> L16
    L20:
        r100 = true;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L20;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L21:
        if (r100 == true) goto L23;
        rcb.c.c(getContext());
        return;
    L23:
        rcb.c.g(getContext());
    }

    public final void ma0() {
        ToolbarV2 r100 = (ToolbarV2) this.f226074e.getToolbar().getValue();
        this.f226074e.getKeyboardHeight();
        ga0(r100);
        ItemV2 r101 = this.f226074e.getExpandedSubToolbar().getValue();
        boolean r102 = this.f226084o.isKeyboardShowing();
        boolean r103 = true;
        if (rcb.b.a(getActivity()) == false) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        this.f226077h.setSelected(false);
        return;
    L11:
        View r105 = this.f226077h;
        if (r102 == false) goto L18;
        if (r101 != null) goto L15;
    L17:
        r103 = false;
        goto L18
    L15:
        if (r101.id().displayMode() != ItemIdV2.DisplayMode.FunctionPanel) goto L17;
    L18:
        r105.setSelected(r103);
        return;
    L5:
        if (rcb.b.b(getActivity()) == true) goto L8;
        r104 = false;
        goto L9
    }

    public BaseToolbarV2PanelFragment() {
        this.f226089t = new b0();
        this.f226090u = new com.bytedance.ee.bear.edit.toolbar.toolbar2.v();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        HorizontalOverScrollView r100 = this.f226085p;
        r r101 = this.f226088s;
        ((ArrayList) r100.f226104a).remove(r101);
        boolean r102 = true;
        V90(true);
        if (this.f226091v == true) goto L5;
    L7:
        r102 = false;
    L8:
        if (r102 == false) goto L11;
        this.f226074e.keyboardHeightLiveData().removeObserver(this.f226092w);
        return;
    L11:
        return;
    L5:
        if (((Boolean) FGDowngradeHelper.f216489e.getValue()).booleanValue() == true) goto L7;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (this.f226091v == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L11;
        this.f226074e.keyboardHeightLiveData().observeForever(this.f226092w);
        return;
    L11:
        return;
    L5:
        if (((Boolean) FGDowngradeHelper.f216489e.getValue()).booleanValue() == true) goto L7;
        r100 = true;
        goto L8
    }

    public final void V90(boolean r100) {
        FragmentActivity r101 = getActivity();
        List<Fragment> r102 = r101.getSupportFragmentManager().getFragments();
        if (r102 != null) goto L28;
        return;
    L28:
        Iterator<Fragment> r103 = r102.iterator();     // Catch: Exception -> L23
    L6:
        if (r103.hasNext() == false) goto L36;
        Fragment r104 = r103.next();     // Catch: Exception -> L23
        if ((r104 instanceof BaseSubToolbarFragment) == false) goto L11;
    L12:
        if (r100 == true) goto L26;
        aa0(r104);     // Catch: Exception -> L23
    L21:
        ja0(r101, r104);     // Catch: Exception -> L23
        goto L6
    L26:
        ((DialogFragment) r104).dismissAllowingStateLoss();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L23
        Throwable r105 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L23
        if (r105 == null) goto L21;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L23
        goto L21
    L11:
        if ((r104 instanceof SelectColorV2Fragment) == false) goto L21;
    L36:
        return;
    L23:
        e = move-exception;
        tt5.a.e("ToolbarV2", "dismissAllFunctionPanel err: ", e, false);
    }

    public final void aa0(Fragment r100) {
        Dialog r101 = ((DialogFragment) r100).getDialog();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isShowing() == false) goto L27;
        tt5.a.h("ToolbarV2", "dismiss " + r100.getTag());
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r103 == null) goto L20;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        goto L20
    L9:
        if (Looper.myLooper() == r102.getLooper()) goto L11;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    }

    public void ga0(ToolbarV2 r100) {
        if (r100 != null) goto L4;
    L8:
        this.f226079j.setVisibility(8);
        tt5.a.h("ToolbarV2", "hide toolbar items length = 0");
        return;
    L4:
        if (r100.getItems().length == 0) goto L8;
        this.f226079j.setVisibility(0);
        na0(r100);
    }

    public final void ia0(ViewGroup r100) {
        FragmentManager r101 = getChildFragmentManager();
        if (r100.getChildCount() <= 0) goto L11;
        int r102 = 0;
    L6:
        if (r102 >= r100.getChildCount()) goto L15;
        View r103 = r100.getChildAt(r102);
        if (r103.getTag() == null) goto L10;
        tt5.a.b("ToolbarV2", "remove fragment " + r103.getTag());
        ha0(r101, r101.findFragmentByTag((String) r103.getTag()));
    L10:
        r102 = r102 + 1;
        goto L6
    L15:
        return;
    }

    public final void ka0(Fragment r100) {
        Dialog r101 = ((DialogFragment) r100).getDialog();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isShowing() == false) goto L7;
        return;
    L7:
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
    }

    public void la0(ItemV2 r100) {
        this.f226087r.a();
        FragmentActivity r101 = getActivity();
        FragmentManager r102 = r101.getSupportFragmentManager();
        String r103 = r100.id().name();
        Fragment r104 = r102.findFragmentByTag(r103);
        if ((r104 instanceof BaseSubToolbarFragment) == true) goto L20;
        Class<? extends BaseSubToolbarFragment> r105 = W90(r100.id());
        if (r105 != null) goto L8;
        return;
    L8:
        if (getArguments() != null) goto L10;
        Bundle r106 = new Bundle();
    L11:
        BaseSubToolbarFragment r107 = (BaseSubToolbarFragment) Fragment.instantiate(r101, r105.getName(), r106);
        if ((r107 instanceof Fragment) == false) goto L14;
        BaseSubToolbarFragment r108 = r107;
    L15:
        LandscapeRestrictionOperation r109 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r108, r103, r109);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r102, r108, r109) == true) goto L26;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L19:
        r107.show(r102, r103);
        return;
    L26:
        return;
    L14:
        r108 = null;
        goto L15
    L10:
        r106 = getArguments();
        goto L11
    L20:
        ka0(r104);
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
    public final void na0(Toolbar r110) {
        ItemV2[] r100 = r110.getItems();
        int r101 = this.f226082m.getChildCount();
        if (r100.length <= r101) goto L9;
        LayoutInflater r102 = LayoutInflater.from(getContext());
        int r103 = 0;
    L6:
        if (r103 >= (r100.length - r101)) goto L14;
        r102.inflate(R.layout.toolbar_v2_top_level_item, this.f226082m);
        r103 = r103 + 1;
    L14:
        int r104 = 0;
    L15:
        int r105 = r100.length;
        int r106 = R.string.LarkCCM_Docs_Doubao_Rewrite_Button;
        if (r104 >= r105) goto L98;
        ItemV2 r107 = r100[r104];
        View r108 = this.f226082m.getChildAt(r104);
        String r109 = r110.getShowingItemId();
        final AppCompatImageView r111 = (AppCompatImageView) r108.findViewById(R.id.toolbarItemImg);
        TextView r112 = (TextView) r108.findViewById(R.id.toolbarItemText);
        View r113 = r108.findViewById(R.id.separator);
        r108.setTag(r107.id().name());
        if (ItemIdV2.ConstId.separator.name().equals(r107.id().name()) == false) goto L22;
        r111.setVisibility(8);
        r113.setVisibility(0);
        ItemIdV2 r114 = r107.id();
        if (r114 == r111.getTag()) goto L97;
        r111.setTag(r114);
    L97:
        r104 = r104 + 1;
        goto L15
    L22:
        if (r112 == null) goto L33;
        ItemIdV2 r115 = r107.id();
        if ((r115 instanceof ToolbarPrimaryItemId) == true) goto L27;
    L29:
        r106 = 0;
    L30:
        if (r106 == 0) goto L32;
        r112.setVisibility(0);
        r112.setText(r106);
        goto L33
    L32:
        r112.setVisibility(8);
        goto L33
    L27:
        if (ToolbarPrimaryItemId.aiRewrite != ((ToolbarPrimaryItemId) r115)) goto L29;
    L33:
        r111.setVisibility(0);
        r113.setVisibility(8);
        ItemIdV2 r116 = r107.id();
        CharSequence r117 = null;
        if (r116 == r111.getTag()) goto L54;
        int r118 = Y90(r107.id());
        Context r119 = getContext();
        if (r107.id().equals(ToolbarPrimaryItemId.aiRewrite) == false) goto L48;
        if (r119 == null) goto L48;
        com.bytedance.ee.bear.document.knowledgeai.a r120 = (com.bytedance.ee.bear.document.knowledgeai.a) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.document.knowledgeai.a.class);     // Catch: Throwable -> L46
        if (r120 == null) goto L48;
        if (r120.d() != DocsKnowledgeAIType.FLOW_AI) goto L48;
        Drawable r121 = r120.b(r119, com.bytedance.ee.util.ui.n.e(r119, 20.0f));     // Catch: Throwable -> L46
    L49:
        if (r121 == null) goto L51;
        r111.setTag(r116);
        r111.setImageDrawable(r121);
        goto L54
    L51:
        if (r118 == 0) goto L54;
        r111.setTag(r116);
        r111.setImageResource(r118);
    L46:
        th = move-exception;
        tt5.a.d("ToolbarIcons", "resolve aiRewrite drawable fail: " + th.getMessage());
    L48:
        r121 = null;
    L54:
        if (r107.getIconKey() == null) goto L57;
        r111.setImageResource(com.bytedance.ee.util.ui.n.n(getContext(), r107.getIconKey()));
    L57:
        if (r107.isAdminLimit() == false) goto L59;
    L62:
        boolean r122 = true;
    L63:
        r111.setEnabled(r122);
        float r123 = 0.5f;
        if (r107.isAdminLimit() == false) goto L66;
        float r124 = 0.5f;
    L67:
        r111.setAlpha(r124);
        r111.setSelected(r107.isSelected());
        if (ToolbarPrimaryItemId.inlineAI.equals(r107.id()) == false) goto L70;
    L73:
        r111.setImageTintList(null);
    L74:
        r108.setTag(r116.name());
        if (r107.isAdminLimit() == false) goto L77;
    L80:
        boolean r125 = true;
    L81:
        r108.setEnabled(r125);
        if (r107.isAdminLimit() == true) goto L85;
        r123 = 1.0f;
    L85:
        r108.setAlpha(r123);
        r108.setSelected(r107.isSelected());
        b0 r126 = this.f226089t;
        String r127 = r116.name();
        r126.getClass();
        if (TextUtils.isEmpty(r127) == true) goto L90;
        Map<CharSequence, CharSequence> r128 = r126.f226112a;
        Intrinsics.checkNotNull(r127);
        r117 = (CharSequence) ((LinkedHashMap) r128).get(r127);
    L90:
        if (TextUtils.isEmpty(r117) == true) goto L92;
        r108.setContentDescription(r117);
    L92:
        boolean r129 = this.f226074e.isExpanded(r107);
        if (r107.id().name().equals(r109) == false) goto L95;
        r111.setBackgroundResource(R.drawable.doc_toolbar_v2_subitem_all_pressed);
        r111.post(new p(this, r111));
    L96:
        r108.setOnClickListener(new s(this, r129, r116));
        goto L97
    L95:
        r111.setBackgroundResource(R.drawable.doc_toolbar_v2_subitem_all_selector);
        goto L96
    L77:
        if (r107.isEnable() == true) goto L80;
        r125 = false;
        goto L81
    L70:
        if (ToolbarPrimaryItemId.aiRewrite.equals(r107.id()) == true) goto L73;
        r111.setImageTintList(AppCompatResources.getColorStateList(getContext(), R.color.toolbar_item_tint));
        goto L74
    L66:
        r124 = 1.0f;
        goto L67
    L59:
        if (r107.isEnable() == true) goto L62;
        r122 = false;
        goto L63
    L98:
        int r130 = r100.length;
        int r131 = 0;
        int r132 = 0;
    L99:
        if (r131 >= r130) goto L104;
        if (r100[r131].id().name().equals(ItemIdV2.ConstId.separator.name()) == false) goto L103;
        r132 = r132 + 1;
    L103:
        r131 = r131 + 1;
        goto L99
    L104:
        this.f226086q = r100.length - r132;
        final ?? r133 = new q(this);
        if (this.f226085p.isLaidOut() == false) goto L107;
        r133.run();
    L109:
        if (this.f226088s != null) goto L112;
        ?? r134 = new r(r133);
        this.f226088s = r134;
        ((ArrayList) this.f226085p.f226104a).add(r134);
    L112:
        if (getView() == null) goto L114;
        int r135 = getView().getWidth();
    L116:
        if (this.f226091v == false) goto L119;
        if (r135 <= 0) goto L119;
    L120:
        int r136 = Math.min(7, this.f226086q);
        int r137 = Math.min(r135 / 8, f226073z) + A;
        int r138 = 10;
        int r139 = Math.min(10, r100.length + 1);
        if (r100.length < 7) goto L124;
        r138 = r139;
    L124:
        int r140 = f226072y;
        int r141 = ((r135 - (r136 * r140)) - r137) / r138;
        if (r100.length >= 6) goto L127;
        r141 = ((r135 - (r140 * 7)) - r137) / r138;
    L127:
        int r142 = r140 + r141;
        int r143 = r141 / 2;
        this.f226082m.setPadding(r143, 0, r143, 0);
        this.f226082m.setClipToPadding(false);
        View r144 = this.f226077h;
        ViewGroup.LayoutParams r145 = r144.getLayoutParams();
        if (r145.width == r137) goto L130;
        r145.width = r137;
        r144.requestLayout();
    L130:
        int r146 = 0;
    L132:
        if (r146 >= this.f226082m.getChildCount()) goto L155;
        View r147 = this.f226082m.getChildAt(r146);
        if (r100[r146].id().name().equals(ItemIdV2.ConstId.separator.name()) == false) goto L138;
        int r148 = f226071x + r141;
        ViewGroup.LayoutParams r149 = r147.getLayoutParams();
        if (r149.width == r148) goto L154;
        r149.width = r148;
        r147.requestLayout();
    L154:
        r146 = r146 + 1;
        goto L132
    L138:
        ItemV2 r150 = r100[r146];
        ItemIdV2 r151 = r150.id();
        if ((r151 instanceof ToolbarPrimaryItemId) == true) goto L141;
    L143:
        char r152 = 0;
    L144:
        if (r152 == 0) goto L149;
        View r153 = r147.findViewById(R.id.toolbarItemContent);
        if (r153 != null) goto L150;
        tt5.a.k("ToolbarV2", "getItemWidth content is null, item=" + r150.id().name());
        goto L149
    L150:
        r153.measure(0, 0);
        int r154 = Math.max(r142, r153.getMeasuredWidth() + Math.max(0, r141));
    L151:
        ViewGroup.LayoutParams r155 = r147.getLayoutParams();
        if (r155.width == r154) goto L154;
        r155.width = r154;
        r147.requestLayout();
    L149:
        r154 = r142;
        goto L151
    L141:
        if (ToolbarPrimaryItemId.aiRewrite != ((ToolbarPrimaryItemId) r151)) goto L143;
        r152 = 2967;
        goto L144
    L155:
        return;
    L119:
        r135 = com.bytedance.ee.util.ui.n.v();
        goto L120
    L114:
        r135 = 0;
        goto L116
    L107:
        this.f226085p.post(r133);
        goto L109
    L9:
        if (r100.length >= r101) goto L14;
        int r156 = 0;
    L12:
        if (r156 >= (r101 - r100.length)) goto L14;
        ViewGroup r157 = this.f226082m;
        r157.removeViewAt(r157.getChildCount() - 1);
        r156 = r156 + 1;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.ee.bear.edit.component.toolbar2.o] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentActivity r101 = getActivity();
        this.f226074e = Z90();
        this.f226084o = pcb.a.AbstractC7181a.b(r101);
        this.f226091v = ForsetiHelper.s(this);
        this.f226092w = new o(this);
    }

    public static void U90(BaseToolbarV2PanelFragment r100, boolean r101) {
        ObjectAnimator r102 = r100.f226083n;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        View r103 = r100.getView();
        if (r101 == false) goto L8;
        int r104 = -r103.getWidth();
        int r105 = 0;
    L9:
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r104, r105}).setDuration(200);
        r100.f226083n = r106;
        r106.addListener(new t(r103));
        r100.f226083n.start();
        return;
    L8:
        r105 = -r103.getWidth();
        r104 = 0;
        goto L9
    }

    public void fa0(ItemIdV2 r100, String r101) {
        if (r100 == ItemIdV2.ConstId.keyboard) goto L5;
        int r102 = 0;
        if (r100 != ToolbarPrimaryItemId.insertImage) goto L25;
        if (getActivity() != null) goto L16;
    L29:
        this.f226074e.processToolbarItemClick(r100, r101);
        return;
    L16:
        if (rcb.b.a(getActivity()) == false) goto L18;
    L19:
        int r103 = pcb.a.AbstractC7181a.b(getActivity()).keyBoardRawHeight();
        if ("true".equals(r101) == false) goto L22;
        V90(true);
    L23:
        this.f226087r.c(r102);
        goto L29
    L22:
        r102 = r103;
        goto L23
    L18:
        if (rcb.f.b() == false) goto L29;
    L25:
        if (getActivity() == null) goto L29;
        if (rcb.b.a(getActivity()) == false) goto L29;
        this.f226087r.c(0);
        goto L29
    L5:
        if (rcb.b.a(getActivity()) == false) goto L7;
    L10:
        rcb.c.c(getContext());
        this.f226074e.hideToolbar();
        return;
    L7:
        if (rcb.b.b(getActivity()) == true) goto L10;
        this.f226074e.processToolbarItemClick(r100, r101);
        da0();
    }

    public final void ha0(FragmentManager r100, Fragment r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        r100.beginTransaction().setCustomAnimations(R.anim.subtoolbar_in_from_bottom, R.anim.subtoolbar_out_to_bottom, R.anim.subtoolbar_in_from_bottom, R.anim.subtoolbar_out_to_bottom).remove(r101).commitAllowingStateLoss();
        return;
    L7:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f226085p = (HorizontalOverScrollView) r100.findViewById(R.id.scroll_view);
        this.f226076g = r100.findViewById(R.id.mark);
        this.f226077h = r100.findViewById(R.id.keyboardSwitchIconParent);
        ImageView r102 = (ImageView) r100.findViewById(R.id.keyboardSwitchIcon);
        this.f226078i = r102;
        r102.setContentDescription("keyboardSwitch");
        com.bytedance.ee.util.ui.l.c(this.f226078i, R.color.icon_n1);
        this.f226075f = r100.findViewById(R.id.keyboardSwitch);
        this.f226078i.setOnClickListener(new i(this));
        this.f226087r = (KeyboardPlaceholderView) r100.findViewById(R.id.keyboardPlaceholder);
        this.f226079j = r100.findViewById(R.id.toolbarLayout);
        this.f226082m = (ViewGroup) r100.findViewById(R.id.topLevelItems);
        this.f226080k = (ViewGroup) r100.findViewById(R.id.container_1);
        this.f226081l = (ViewGroup) r100.findViewById(R.id.container_2);
        if (this.f226091v == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        this.f226074e.keyboardHeightLiveData().observe(getViewLifecycleOwner(), new j(this));
    L10:
        this.f226074e.getToolbar().observe(getViewLifecycleOwner(), new k(this));
        this.f226074e.getExpandedSubToolbar().observe(getViewLifecycleOwner(), new l(this));
        this.f226074e.observeActivePanel(this, new a(this));
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L14;
        this.f226090u.b(r104, new m(this));
    L14:
        if (this.f226091v == false) goto L17;
        r100.addOnLayoutChangeListener(new n(this));
        return;
    L17:
        return;
    L5:
        if (((Boolean) FGDowngradeHelper.f216489e.getValue()).booleanValue() == true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.toolbar_v2_fragment, r101, false);
    }
}
