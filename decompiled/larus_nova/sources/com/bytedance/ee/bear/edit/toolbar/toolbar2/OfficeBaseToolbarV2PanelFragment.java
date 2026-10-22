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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
public abstract class OfficeBaseToolbarV2PanelFragment<Toolbar extends ToolbarV2> extends BaseFragment {
    public static final ItemV2[] A = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f226241w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f226242x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f226243y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f226244z = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseToolbarV2PanelViewModel<Toolbar> f226245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f226246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f226247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f226248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f226249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f226250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f226251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f226252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f226253m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public pcb.a f226254n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HorizontalOverScrollView f226255o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f226256p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public KeyboardPlaceholderView f226257q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public r f226258r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final w f226259s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final v f226260t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f226261u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public j f226262v;

    public class a implements Observer<g45.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g45.a f226263a;

        public a() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(g45.a r100) {
            this.f226263a = r100;
        }
    }

    public abstract Class<? extends BaseSubToolbarFragment> V90(ItemIdV2 r100);

    public abstract Class<? extends BaseSubToolbarV2Fragment> W90(ItemIdV2 r100);

    public int X90(ItemIdV2 r100) {
        return R.drawable.core_doc_toolbar_v2_subitem_all_pressed;
    }

    public int Y90(ItemIdV2 r100) {
        return R.drawable.core_doc_toolbar_v2_subitem_all_selector;
    }

    public abstract an4.a Z90();

    public an4.b aa0() {
        return null;
    }

    public Drawable ba0(ItemIdV2 r100) {
        return null;
    }

    public abstract int ca0(ItemIdV2 r100);

    public abstract BaseToolbarV2PanelViewModel<Toolbar> ea0();

    public abstract boolean ga0(Fragment r100);

    public void ha0(View r100, ItemV2 r101) {
    }

    public View ia0(ViewGroup r100, ItemV2 r101) {
        return null;
    }

    public void ja0(int r100) {
    }

    public void la0() {
    }

    static {
        f226241w = com.bytedance.ee.util.ui.n.c(0.5f);
        f226242x = com.bytedance.ee.util.ui.n.d(24);
        f226243y = com.bytedance.ee.util.ui.n.d(44);
        f226244z = com.bytedance.ee.util.ui.n.d(3);
        A = new ItemV2[0];
    }

    public void ka0() {
        boolean r100 = this.f226245e.clearSubToolbar();
        if (r100 == true) goto L5;
        U90(true);
    L5:
        if (r100 == true) goto L7;
        rcb.c.c(getContext());
        return;
    L7:
        rcb.c.g(getContext());
    }

    public final void ta0() {
        ToolbarV2 r100 = (ToolbarV2) this.f226245e.getToolbar().getValue();
        this.f226245e.getKeyboardHeight();
        na0(r100);
        ItemV2 r101 = this.f226245e.getExpandedSubToolbar().getValue();
        boolean r102 = this.f226254n.isKeyboardShowing();
        boolean r103 = true;
        if (rcb.b.a(getActivity()) == false) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        this.f226248h.setSelected(false);
        return;
    L11:
        View r105 = this.f226248h;
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

    public OfficeBaseToolbarV2PanelFragment() {
        this.f226259s = new w();
        this.f226260t = new v();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        HorizontalOverScrollView r100 = this.f226255o;
        r r101 = this.f226258r;
        ((ArrayList) r100.f226239a).remove(r101);
        boolean r102 = true;
        U90(true);
        if (this.f226261u == true) goto L5;
    L7:
        r102 = false;
    L8:
        if (r102 == false) goto L11;
        this.f226245e.keyboardHeightLiveData().removeObserver(this.f226262v);
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
        if (this.f226261u == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L11;
        this.f226245e.keyboardHeightLiveData().observeForever(this.f226262v);
        return;
    L11:
        return;
    L5:
        if (((Boolean) FGDowngradeHelper.f216489e.getValue()).booleanValue() == true) goto L7;
        r100 = true;
        goto L8
    }

    public void U90(boolean r100) {
        List<Fragment> r101 = getActivity().getSupportFragmentManager().getFragments();
        if (r101 != null) goto L28;
        return;
    L28:
        Iterator<Fragment> r102 = r101.iterator();     // Catch: Exception -> L20
    L6:
        if (r102.hasNext() == false) goto L42;
        Fragment r103 = r102.next();     // Catch: Exception -> L20
        if ((r103 instanceof BaseSubToolbarFragment) == true) goto L12;
        if ((r103 instanceof SelectColorV2Fragment) == false) goto L6;
    L12:
        if (r100 == true) goto L26;
        fa0(r103);     // Catch: Exception -> L20
        goto L6
    L26:
        ((DialogFragment) r103).dismissAllowingStateLoss();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L20
        Throwable r104 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L20
        if (r104 == null) goto L6;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L20
        goto L6
    L42:
        return;
    L20:
        e = move-exception;
        tt5.a.e("ToolbarV2", "dismissAllFunctionPanel err: ", e, false);
    }

    public Integer da0(ItemIdV2 r100) {
        if (ToolbarPrimaryItemId.inlineAI.equals(r100) == false) goto L5;
        return null;
    L5:
        if (ToolbarPrimaryItemId.aiRewrite.equals(r100) == false) goto L8;
        return null;
    L8:
        return Integer.valueOf(R.color.core_toolbar_item_tint);
    }

    public final void fa0(Fragment r100) {
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

    public void na0(ToolbarV2 r100) {
        if (r100 != null) goto L4;
    L10:
        this.f226250j.setVisibility(8);
        tt5.a.h("ToolbarV2", "hide toolbar items length = 0");
        return;
    L4:
        if (r100.getItems() == null) goto L10;
        if (r100.getItems().length == 0) goto L10;
        this.f226250j.setVisibility(0);
        ua0(r100);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.ee.bear.edit.toolbar.toolbar2.j] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentActivity r101 = getActivity();
        this.f226245e = ea0();
        this.f226254n = pcb.a.AbstractC7181a.b(r101);
        this.f226261u = ForsetiHelper.s(this);
        this.f226262v = new j(this);
    }

    public final void pa0(Fragment r100) {
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

    public void qa0(ItemV2 r100) {
        this.f226257q.a();
        FragmentActivity r101 = getActivity();
        FragmentManager r102 = r101.getSupportFragmentManager();
        String r103 = r100.id().name();
        Fragment r104 = r102.findFragmentByTag(r103);
        if ((r104 instanceof BaseSubToolbarFragment) == true) goto L20;
        Class<? extends BaseSubToolbarFragment> r105 = V90(r100.id());
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
        pa0(r104);
    }

    public void ra0(ItemV2 r110) {
        FragmentActivity r100 = getActivity();
        FragmentManager r101 = getChildFragmentManager();
        String r102 = r110.id().name();
        if ((r101.findFragmentByTag(r102) instanceof BaseSubToolbarV2Fragment) == true) goto L27;
        Class<? extends BaseSubToolbarV2Fragment> r103 = W90(r110.id());
        if (r103 != null) goto L8;
        return;
    L8:
        if (this.f226251k.getChildCount() <= 0) goto L18;
        ViewGroup r104 = this.f226251k;
        FragmentManager r105 = getChildFragmentManager();
        if (r104.getChildCount() <= 0) goto L18;
        int r106 = 0;
    L13:
        if (r106 >= r104.getChildCount()) goto L18;
        View r107 = r104.getChildAt(r106);
        if (r107.getTag() == null) goto L17;
        tt5.a.b("ToolbarV2", "remove fragment " + r107.getTag());
        oa0(r105, r105.findFragmentByTag((String) r107.getTag()));
    L17:
        r106 = r106 + 1;
    L18:
        ViewGroup r108 = this.f226251k;
        if (getArguments() != null) goto L21;
        Bundle r109 = new Bundle();
    L22:
        r109.putSerializable(ItemV2.class.getName(), r110);
        BaseSubToolbarV2Fragment r111 = (BaseSubToolbarV2Fragment) Fragment.instantiate(r100, r103.getName(), r109);
        r111.f226230s = Z90();
        r111.f226231t = aa0();
        FragmentTransaction r112 = r101.beginTransaction().setCustomAnimations(R.anim.core_subtoolbar_in_from_bottom, R.anim.core_subtoolbar_out_to_bottom, R.anim.core_subtoolbar_in_from_bottom, R.anim.core_subtoolbar_out_to_bottom);
        int r113 = r108.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r112, r111, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r102, r113) == true) goto L26;
        r112 = r112.replace(r113, r111, r102);
    L26:
        r112.commitAllowingStateLoss();
        ea0().requestUpdateContentHeight();
        return;
    L21:
        r109 = getArguments();
        goto L22
    L27:
        tt5.a.h("ToolbarV2", "showSubToolbarV2 already show");
    }

    public void sa0(ItemV2 r110) {
        boolean r100 = false;
        if (r110 != null) goto L12;
        U90(false);
        tt5.a.h("ToolbarV2", "removeAllSubToolBarV2 ");
        List<Fragment> r111 = getChildFragmentManager().getFragments();
        if (r111 == null) goto L116;
        Iterator<Fragment> r112 = r111.iterator();
    L8:
        if (r112.hasNext() == false) goto L120;
        Fragment r101 = r112.next();
        if ((r101 instanceof BaseSubToolbarV2Fragment) == false) goto L8;
        oa0(getChildFragmentManager(), r101);
        goto L8
    L120:
        return;
    L116:
        return;
    L12:
        List<Fragment> r102 = getActivity().getSupportFragmentManager().getFragments();
        if (r102 == null) goto L57;
        Iterator<Fragment> r103 = r102.iterator();
    L17:
        if (r103.hasNext() == false) goto L43;
        Fragment r104 = r103.next();
        if ((r104 instanceof BaseSubToolbarFragment) == true) goto L21;
        String r105 = r104.getTag();
        an4.a r106 = Z90();
        an4.e r107 = null;
        if (r106 == null) goto L28;
        Set<an4.e> r108 = r106.getItemFactorySet();
    L29:
        if (r108 == null) goto L36;
        Iterator<an4.e> r109 = r108.iterator();
    L32:
        if (r109.hasNext() == false) goto L36;
        an4.e r113 = r109.next();
        if (TextUtils.equals(r113.getItemId().name(), r105) == false) goto L32;
        r107 = r113;
    L36:
        tt5.a.h("ToolbarV2", "findToolbarItemFactoryByName, toolbarItemFactory: " + r107 + ", name is " + r104.getTag());
        if ((r107 instanceof an4.f) == false) goto L17;
        if (aa0() == null) goto L17;
        if (r104.getTag() == null) goto L17;
        ((an4.f) r107).dismissPanel(aa0(), r104.getTag());
        goto L17
    L28:
        r108 = null;
        goto L29
    L21:
        if (r110.id().name().equals(r104.getTag()) == true) goto L17;
        if (ga0(r104) == false) goto L17;
        fa0(r104);
        goto L17
    L43:
        ItemIdV2 r114 = r110.id();
        Iterator<Fragment> r115 = r102.iterator();
    L45:
        if (r115.hasNext() == false) goto L52;
        Fragment r116 = r115.next();
        if (r114.name().equals(r116.getTag()) == false) goto L45;
        if ((r116 instanceof BaseSubToolbarFragment) == false) goto L51;
        pa0(r116);
    L51:
        boolean r117 = true;
    L53:
        if (r117 == true) goto L57;
        if (r114.displayMode() != ItemIdV2.DisplayMode.FunctionPanel) goto L57;
        qa0(r110);
        goto L57
    L52:
        r117 = false;
    L57:
        List<Fragment> r118 = getChildFragmentManager().getFragments();
        if (r118 == null) goto L119;
        Iterator<Fragment> r119 = r118.iterator();
    L62:
        if (r119.hasNext() == false) goto L68;
        Fragment r120 = r119.next();
        if ((r120 instanceof BaseSubToolbarV2Fragment) == false) goto L62;
        if (r110.id().name().equals(r120.getTag()) == true) goto L62;
        tt5.a.h("ToolbarV2", "remove fragment " + r120.getTag());
        oa0(getChildFragmentManager(), r120);
        ea0().requestUpdateContentHeight();
        goto L62
    L68:
        ItemIdV2 r121 = r110.id();
        Iterator<Fragment> r122 = r118.iterator();
    L70:
        if (r122.hasNext() == false) goto L74;
        if (r121.name().equals(r122.next().getTag()) == false) goto L70;
        r100 = true;
    L74:
        if (r100 == false) goto L76;
        return;
    L76:
        if (r121.displayMode() != ItemIdV2.DisplayMode.SubToolBarV2) goto L118;
        ra0(r110);
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
    public final void ua0(Toolbar r110) {
        ItemV2[] r100 = r110.getItems();
        if (r100 != null) goto L5;
        r100 = A;
    L5:
        int r101 = this.f226253m.getChildCount();
        if (r100.length <= r101) goto L12;
        LayoutInflater r102 = LayoutInflater.from(getContext());
        int r103 = 0;
    L9:
        if (r103 >= (r100.length - r101)) goto L17;
        r102.inflate(R.layout.core_toolbar_v2_top_level_item, this.f226253m);
        r103 = r103 + 1;
    L17:
        int r104 = 0;
    L19:
        if (r104 >= r100.length) goto L101;
        ItemV2 r105 = r100[r104];
        View r106 = this.f226253m.getChildAt(r104);
        String r111 = r110.getShowingItemId();
        if (ItemIdV2.ConstId.separator.name().equals(r105.id().name()) == false) goto L28;
        View r107 = r106.findViewById(R.id.toolbarItemContent);
        AppCompatImageView r108 = (AppCompatImageView) r106.findViewById(R.id.toolbarItemImg);
        View r109 = r106.findViewById(R.id.separator);
        r106.setTag(r105.id().name());
        if (r107 == null) goto L25;
        r107.setVisibility(8);
    L25:
        r108.setVisibility(8);
        r109.setVisibility(0);
        ItemIdV2 r112 = r105.id();
        if (r112 == r108.getTag()) goto L100;
        r108.setTag(r112);
    L100:
        r104 = r104 + 1;
        goto L19
    L28:
        boolean r113 = this.f226245e.isExpanded(r105);
        boolean r114 = r105.id().name().equals(r111);
        r106.setOnClickListener(new t(this, r113, r105));
        r106.setTag(r105.id().name());
        if (r105.isAdminLimit() == false) goto L31;
    L34:
        boolean r115 = true;
    L35:
        r106.setEnabled(r115);
        if (r105.isAdminLimit() == false) goto L38;
        float r116 = 0.5f;
    L39:
        r106.setAlpha(r116);
        r106.setSelected(r105.isSelected());
        w r117 = this.f226259s;
        String r118 = r105.id().name();
        r117.getClass();
        if (TextUtils.isEmpty(r118) == false) goto L42;
        CharSequence r119 = null;
    L44:
        if (TextUtils.isEmpty(r119) == true) goto L47;
        r106.setContentDescription(r119);
    L47:
        if ((r106 instanceof ViewGroup) == false) goto L56;
        ViewGroup r120 = (ViewGroup) r106;
        View r121 = ia0(r120, r105);
        if (r121 != null) goto L51;
    L53:
        ha0(r106, r105);
        if (r121 == null) goto L56;
    L51:
        if (r121.getParent() == r120) goto L53;
        r120.removeAllViews();
        r120.addView(r121);
    L56:
        View r122 = r106.findViewById(R.id.toolbarItemContent);
        final AppCompatImageView r123 = (AppCompatImageView) r106.findViewById(R.id.toolbarItemImg);
        TextView r124 = (TextView) r106.findViewById(R.id.toolbarItemText);
        View r125 = r106.findViewById(R.id.separator);
        if (r122 == null) goto L59;
        r122.setVisibility(0);
    L59:
        r123.setVisibility(0);
        r125.setVisibility(8);
        if (r124 == null) goto L72;
        ItemIdV2 r126 = r105.id();
        if ((r126 instanceof ToolbarPrimaryItemId) == true) goto L65;
    L68:
        int r127 = 0;
    L69:
        if (r127 == 0) goto L71;
        r124.setVisibility(0);
        r124.setText(r127);
        goto L72
    L71:
        r124.setVisibility(8);
        goto L72
    L65:
        if (gx4.d.f483117a[((ToolbarPrimaryItemId) r126).ordinal()] != 17) goto L68;
        r127 = R.string.LarkCCM_Docs_Doubao_Rewrite_Button;
    L72:
        ItemIdV2 r128 = r105.id();
        if (r128 == r123.getTag()) goto L80;
        int r129 = ca0(r105.id());
        Drawable r130 = ba0(r105.id());
        if (r130 == null) goto L77;
        r123.setTag(r128);
        r123.setImageDrawable(r130);
        goto L80
    L77:
        if (r129 == 0) goto L80;
        r123.setTag(r128);
        r123.setImageResource(r129);
    L80:
        if (r105.getIconKey() == null) goto L83;
        r123.setImageResource(com.bytedance.ee.util.ui.n.n(getContext(), r105.getIconKey()));
    L83:
        if (r105.isAdminLimit() == false) goto L85;
    L88:
        boolean r131 = true;
    L89:
        r123.setEnabled(r131);
        if (r105.isAdminLimit() == false) goto L92;
        float r132 = 0.5f;
    L93:
        r123.setAlpha(r132);
        Integer r133 = da0(r105.id());
        if (r133 == null) goto L96;
        r123.setImageTintList(AppCompatResources.getColorStateList(requireContext(), r133.intValue()));
    L97:
        if (r114 == false) goto L99;
        r123.setBackgroundResource(X90(r105.id()));
        r123.post(new s(this, r123));
        goto L100
    L99:
        r123.setBackgroundResource(Y90(r105.id()));
        goto L100
    L96:
        r123.setImageTintList(null);
        goto L97
    L92:
        r132 = 1.0f;
        goto L93
    L85:
        if (r105.isEnable() == true) goto L88;
        r131 = false;
        goto L89
    L42:
        Map<CharSequence, CharSequence> r134 = r117.f226358a;
        Intrinsics.checkNotNull(r118);
        r119 = (CharSequence) ((LinkedHashMap) r134).get(r118);
        goto L44
    L38:
        r116 = 1.0f;
        goto L39
    L31:
        if (r105.isEnable() == true) goto L34;
        r115 = false;
        goto L35
    L101:
        int r135 = r100.length;
        int r136 = 0;
        int r137 = 0;
    L102:
        if (r136 >= r135) goto L107;
        if (r100[r136].id().name().equals(ItemIdV2.ConstId.separator.name()) == false) goto L106;
        r137 = r137 + 1;
    L106:
        r136 = r136 + 1;
        goto L102
    L107:
        this.f226256p = r100.length - r137;
        final ?? r138 = new q(this);
        if (this.f226255o.isLaidOut() == false) goto L110;
        r138.run();
    L112:
        if (this.f226258r != null) goto L115;
        ?? r139 = new r(r138);
        this.f226258r = r139;
        ((ArrayList) this.f226255o.f226239a).add(r139);
    L115:
        if (getView() == null) goto L117;
        int r140 = getView().getWidth();
    L119:
        if (this.f226261u == false) goto L122;
        if (r140 <= 0) goto L122;
    L123:
        int r141 = Math.min(7, this.f226256p);
        int r142 = Math.min(r140 / 8, f226243y) + f226244z;
        int r143 = 10;
        int r144 = Math.min(10, r100.length + 1);
        if (r100.length < 7) goto L127;
        r143 = r144;
    L127:
        int r145 = f226242x;
        int r146 = ((r140 - (r141 * r145)) - r142) / r143;
        if (r100.length >= 6) goto L130;
        r146 = ((r140 - (r145 * 7)) - r142) / r143;
    L130:
        int r147 = r145 + r146;
        int r148 = r146 / 2;
        this.f226253m.setPadding(r148, 0, r148, 0);
        this.f226253m.setClipToPadding(false);
        View r149 = this.f226248h;
        ViewGroup.LayoutParams r150 = r149.getLayoutParams();
        if (r150.width == r142) goto L133;
        r150.width = r142;
        r149.requestLayout();
    L133:
        int r151 = 0;
    L135:
        if (r151 >= this.f226253m.getChildCount()) goto L158;
        View r152 = this.f226253m.getChildAt(r151);
        if (r100[r151].id().name().equals(ItemIdV2.ConstId.separator.name()) == false) goto L141;
        int r153 = f226241w + r146;
        ViewGroup.LayoutParams r154 = r152.getLayoutParams();
        if (r154.width == r153) goto L157;
        r154.width = r153;
        r152.requestLayout();
    L157:
        r151 = r151 + 1;
        goto L135
    L141:
        ItemIdV2 r155 = r100[r151].id();
        if ((r155 instanceof ToolbarPrimaryItemId) == true) goto L144;
    L147:
        char r156 = 0;
    L148:
        if (r156 == 0) goto L152;
        View r157 = r152.findViewById(R.id.toolbarItemContent);
        if (r157 == null) goto L152;
        r157.measure(0, 0);
        int r158 = Math.max(r147, r157.getMeasuredWidth() + Math.max(0, r146));
    L154:
        ViewGroup.LayoutParams r159 = r152.getLayoutParams();
        if (r159.width == r158) goto L157;
        r159.width = r158;
        r152.requestLayout();
    L152:
        r158 = r147;
        goto L154
    L144:
        if (gx4.d.f483117a[((ToolbarPrimaryItemId) r155).ordinal()] != 17) goto L147;
        r156 = 2967;
        goto L148
    L158:
        return;
    L122:
        r140 = com.bytedance.ee.util.ui.n.v();
        goto L123
    L117:
        r140 = 0;
        goto L119
    L110:
        this.f226255o.post(r138);
        goto L112
    L12:
        if (r100.length >= r101) goto L17;
        int r160 = 0;
    L15:
        if (r160 >= (r101 - r100.length)) goto L17;
        ViewGroup r161 = this.f226253m;
        r161.removeViewAt(r161.getChildCount() - 1);
        r160 = r160 + 1;
        goto L15
    }

    public void ma0(ItemIdV2 r100, String r101) {
        if (r100 == ItemIdV2.ConstId.keyboard) goto L5;
        int r102 = 0;
        if (r100 != ToolbarPrimaryItemId.insertImage) goto L25;
        if (getActivity() != null) goto L16;
    L29:
        this.f226245e.processToolbarItemClick(r100, r101);
    L31:
        if (Z90() != null) goto L33;
        return;
    L33:
        if (Z90().getOnToolbarItemClickCallBack() == null) goto L37;
        Z90().getOnToolbarItemClickCallBack().invoke(r100.name());
        return;
    L37:
        return;
    L16:
        if (rcb.b.a(getActivity()) == false) goto L18;
    L19:
        int r103 = pcb.a.AbstractC7181a.b(getActivity()).keyBoardRawHeight();
        if ("true".equals(r101) == false) goto L22;
        U90(true);
    L23:
        this.f226257q.b(r102);
        goto L29
    L22:
        r102 = r103;
        goto L23
    L18:
        if (rcb.f.b() == false) goto L29;
    L25:
        if (getActivity() == null) goto L29;
        if (rcb.b.a(getActivity()) == false) goto L29;
        this.f226257q.b(0);
        goto L29
    L5:
        if (rcb.b.a(getActivity()) == false) goto L7;
    L10:
        rcb.c.c(getContext());
        this.f226245e.hideToolbar();
        goto L31
    L7:
        if (rcb.b.b(getActivity()) == true) goto L10;
        this.f226245e.processToolbarItemClick(r100, r101);
        ka0();
        goto L31
    }

    public final void oa0(FragmentManager r100, Fragment r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        r100.beginTransaction().setCustomAnimations(R.anim.core_subtoolbar_in_from_bottom, R.anim.core_subtoolbar_out_to_bottom, R.anim.core_subtoolbar_in_from_bottom, R.anim.core_subtoolbar_out_to_bottom).remove(r101).commitAllowingStateLoss();
        return;
    L7:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f226255o = (HorizontalOverScrollView) r100.findViewById(R.id.scroll_view);
        this.f226247g = r100.findViewById(R.id.mark);
        this.f226248h = r100.findViewById(R.id.keyboardSwitchIconParent);
        ImageView r102 = (ImageView) r100.findViewById(R.id.keyboardSwitchIcon);
        this.f226249i = r102;
        r102.setContentDescription("keyboardSwitch");
        com.bytedance.ee.util.ui.l.c(this.f226249i, R.color.icon_n1);
        this.f226246f = r100.findViewById(R.id.keyboardSwitch);
        this.f226249i.setOnClickListener(new k(this));
        this.f226257q = (KeyboardPlaceholderView) r100.findViewById(R.id.keyboardPlaceholder);
        this.f226250j = (ViewGroup) r100.findViewById(R.id.toolbarLayout);
        this.f226253m = (ViewGroup) r100.findViewById(R.id.topLevelItems);
        this.f226251k = (ViewGroup) r100.findViewById(R.id.container_1);
        this.f226252l = (ViewGroup) r100.findViewById(R.id.container_2);
        if (this.f226261u == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        this.f226245e.keyboardHeightLiveData().observe(getViewLifecycleOwner(), new l(this));
    L10:
        this.f226245e.getToolbar().observe(getViewLifecycleOwner(), new m(this));
        this.f226245e.getExpandedSubToolbar().observe(getViewLifecycleOwner(), new n(this));
        this.f226245e.observeActivePanel(this, new a());
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L14;
        this.f226260t.b(r104, new o(this));
    L14:
        if (this.f226261u == false) goto L17;
        r100.addOnLayoutChangeListener(new p(this));
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
        return r100.inflate(R.layout.core_toolbar_v2_fragment, r101, false);
    }
}
