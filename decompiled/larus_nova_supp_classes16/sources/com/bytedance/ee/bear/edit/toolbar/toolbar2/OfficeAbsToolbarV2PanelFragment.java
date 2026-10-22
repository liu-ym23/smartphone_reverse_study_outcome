package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.core.toolbar.BaseSubToolbarFragment;
import com.bytedance.ee.bear.core.toolbar.selectcolor.impl.SelectColorV2CompatFragment;
import com.bytedance.ee.bear.core.widget.KeyboardPlaceholderView;
import com.bytedance.ee.bear.document.knowledgeai.DocsKnowledgeAIType;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.ss.android.lark.utils.LarkContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\b&\u0018\u0000 O2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002OPB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0014J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u001a\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\u0018\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010)H\u0014J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020\u0017H\u0014J\b\u0010.\u001a\u00020\u0017H\u0014J\u0010\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0014J\u0010\u00102\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0017\u00105\u001a\u0004\u0018\u00010,2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u00108\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u001c\u00109\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010;\u0018\u00010:2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010<\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010=\u0018\u00010:H&J \u0010>\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010=\u0018\u00010:2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020&H\u0014J\u0010\u0010A\u001a\u00020\u00172\u0006\u0010@\u001a\u00020&H\u0016J\u0010\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\nH\u0014J\"\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020,2\b\u0010%\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020\u0017H\u0016J\u001d\u0010I\u001a\u00020\u00172\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010KH\u0002¢\u0006\u0002\u0010LJ\u0012\u0010M\u001a\u00020\u00172\b\u0010N\u001a\u0004\u0018\u00010&H\u0014R\u0012\u0010\u0005\u001a\u00020\u0006X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/OfficeAbsToolbarV2PanelFragment;", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/OfficeBaseToolbarV2PanelFragment;", "Lcom/bytedance/ee/bear/document/model/toolbar/DocToolbarV2;", "<init>", "()V", "docToolbarV2Compat", "Lcom/bytedance/ee/bear/edit/component/toolbar2/IDocToolbarV2Compat;", "getDocToolbarV2Compat", "()Lcom/bytedance/ee/bear/edit/component/toolbar2/IDocToolbarV2Compat;", "firstKeyboard", "", "enableExternalSelect", "editPanelsManager", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/EditPanelsManager;", "toolbarContext", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/OfficeAbsToolbarV2PanelFragment$ToolbarContextImpl;", "getToolbarContext", "()Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/OfficeAbsToolbarV2PanelFragment$ToolbarContextImpl;", "toolbarCallback", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/ToolbarCallback;", "isInForseti", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setToolbarCallback", "callback", "onToolbarItemClick", "id", "Lcom/bytedance/ee/bear/document/model/toolbar/ItemIdV2;", "value", "", "onCreateItemView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "data", "Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "onBindItemView", "itemView", "Lcom/bytedance/ee/bear/api/registry/ToolbarContext;", "onKeyboardChanged", "keyboardHeight", "", "onKeyboardToolbarItemClick", "onToolbarChanged", "needHideFunctionPanelWhenUpdate", "fragment", "Landroidx/fragment/app/Fragment;", "getToolbarIcon", "getToolbarDrawable", "Landroid/graphics/drawable/Drawable;", "getToolbarTint", "(Lcom/bytedance/ee/bear/document/model/toolbar/ItemIdV2;)Ljava/lang/Integer;", "getToolBarSelectorBackgroundRes", "getToolBarPressedBackgroundRes", "getFunctionPanelFragmentClass", "Ljava/lang/Class;", "Lcom/bytedance/ee/bear/core/toolbar/BaseSubToolbarFragment;", "getSubToolbarFragmentClass", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseSubToolbarV2Fragment;", "getSubToolbarV2FragmentClass", "showSubToolbarV2", "itemV2", "showFunctionPanel", "dismissAllFunctionPanel", "destroy", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onDestroyView", "destroyItemFactory", "items", "", "([Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;)V", "updateSubToolbar", "expandedSubToolbar", "Companion", "ToolbarContextImpl", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class OfficeAbsToolbarV2PanelFragment extends OfficeBaseToolbarV2PanelFragment<DocToolbarV2> {
    public boolean B;
    public EditPanelsManager C;
    public final b D;
    public WeakReference<u> E;

    public static final class a {
    }

    public final class b implements an4.b {
        public final /* synthetic */ OfficeAbsToolbarV2PanelFragment a;

        public final ViewGroup b() {
            return this.a.j;
        }

        public final ViewGroup c() {
            return this.a.k;
        }

        public final void d() {
            EditPanelsManager r0 = this.a.C;
            if (r0 == null) goto L6;
            r0.forceCloseToolbarV2();
            return;
        }

        public final KeyboardPlaceholderView e() {
            return this.a.q;
        }

        public FragmentActivity getActivity() {
            return this.a.requireActivity();
        }

        public final FragmentManager getFragmentManager() {
            return this.a.getChildFragmentManager();
        }

        public final PluginHost getPluginHost() {
            return PluginHost.fromFragment(this.a);
        }

        public final OfficeAbsToolbarV2PanelFragment getFragment() {
            return this.a;
        }

        public b(OfficeAbsToolbarV2PanelFragment r1) {
            this.a = r1;
        }

        public final void a(ItemIdV2 r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "itemId");
            WeakReference<u> r0 = this.a.E;
            if (r0 == null) goto L8;
            u r1 = r0.get();
            if (r1 == null) goto L9;
            r1.a(r2, r3);
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final Class<? extends BaseSubToolbarFragment> V90(ItemIdV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return null;
    }

    public abstract a0 wa0();

    public abstract Class<? extends BaseSubToolbarV2Fragment<?>> xa0();

    public OfficeAbsToolbarV2PanelFragment() {
        this.B = true;
        this.D = new b(this);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final void ka0() {
        if (wa0().onKeyboardToolbarItemClick() == true) goto L6;
        super.ka0();
        return;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final void la0() {
        wa0().onToolbarChanged();
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public void onDestroyView() {
        super.onDestroyView();
        DocToolbarV2 r0 = (DocToolbarV2) ea0().getToolbar().getValue();
        if (r0 == null) goto L5;
        ItemV2[] r1 = r0.getItems();
    L6:
        va0(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final an4.b aa0() {
        return this.D;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final void U90(boolean r4) {
        super.U90(r4);
        an4.a r5 = Z90();
        if (r5 == null) goto L16;
        Set r6 = r5.getItemFactorySet();
        if (r6 == null) goto L23;
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        Object r1 = r7.next();
        if ((r1 instanceof an4.f) == false) goto L8;
        r0.add(r1);
        goto L8
    L12:
        Iterator r8 = r0.iterator();
    L14:
        if (r8.hasNext() == false) goto L24;
        an4.f r2 = (an4.f) r8.next();
        r2.dismissPanel(this.D, r2.getItemId().name());
        goto L14
    L24:
        return;
    L23:
        return;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final Class<? extends BaseSubToolbarV2Fragment<?>> W90(ItemIdV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        if (r2 == ToolbarPrimaryItemId.blockTransform) goto L14;
        if (r2 == ToolbarPrimaryItemId.textTransform) goto L14;
        if (r2 == ToolbarPrimaryItemId.alignTransform) goto L14;
        if (r2 == ToolbarPrimaryItemId.listTransform) goto L14;
        return null;
    L14:
        return xa0();
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final int X90(ItemIdV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        an4.a r0 = Z90();
        if (r0 == null) goto L10;
        an4.e r3 = an4.h.a(r0, r2);
        if (r3 == null) goto L10;
        an4.d r4 = r3.getToolbarIconDecoration();
        if (r4 == null) goto L10;
        Integer r5 = r4.c;
        if (r5 == null) goto L10;
    L16:
        if (r5 != null) goto L18;
        return 2131233698;
    L18:
        return r5.intValue();
    L10:
        an4.a r6 = Z90();
        if (r6 == null) goto L15;
        an4.d r7 = r6.getGlobalDecoration();
        if (r7 == null) goto L15;
        r5 = r7.c;
    L15:
        r5 = null;
        goto L16
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final int Y90(ItemIdV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        an4.a r0 = Z90();
        if (r0 == null) goto L10;
        an4.e r3 = an4.h.a(r0, r2);
        if (r3 == null) goto L10;
        an4.d r4 = r3.getToolbarIconDecoration();
        if (r4 == null) goto L10;
        Integer r5 = r4.b;
        if (r5 == null) goto L10;
    L16:
        if (r5 != null) goto L18;
        return 2131233700;
    L18:
        return r5.intValue();
    L10:
        an4.a r6 = Z90();
        if (r6 == null) goto L15;
        an4.d r7 = r6.getGlobalDecoration();
        if (r7 == null) goto L15;
        r5 = r7.b;
    L15:
        r5 = null;
        goto L16
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final Drawable ba0(ItemIdV2 r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        if ((r5 instanceof ToolbarPrimaryItemId) == false) goto L21;
        Context r0 = getContext();
        if (gx4.d.a[((ToolbarPrimaryItemId) r5).ordinal()] != 17) goto L25;
        if (r0 == null) goto L26;
        com.bytedance.ee.bear.document.knowledgeai.a r6 = (com.bytedance.ee.bear.document.knowledgeai.a) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.document.knowledgeai.a.class);     // Catch: Throwable -> L16
        if (r6 != null) goto L12;
        return null;
    L12:
        if (r6.d() != DocsKnowledgeAIType.FLOW_AI) goto L23;
        return r6.b(r0, com.bytedance.ee.util.ui.n.e(r0, 20.0f));
    L23:
        return null;
    L16:
        th = move-exception;
        tt5.a.d("ToolbarIcons", "resolve aiRewrite drawable fail: " + th.getMessage());
        return null;
    L26:
        return null;
    L25:
        return null;
    L21:
        return null;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final int ca0(ItemIdV2 r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        an4.a r0 = Z90();
        if (r0 == null) goto L11;
        an4.e r1 = an4.h.a(r0, r3);
        if (r1 == null) goto L11;
        Integer r2 = r1.getIconRes();
        if (r2 == null) goto L11;
        return r2.intValue();
    L11:
        if ((r3 instanceof ToolbarPrimaryItemId) == true) goto L13;
        return 0;
    L13:
        switch(gx4.d.a[((ToolbarPrimaryItemId) r3).ordinal()]) {
            case 1: goto L31;
            case 2: goto L47;
            case 3: goto L46;
            case 4: goto L45;
            case 5: goto L44;
            case 6: goto L43;
            case 7: goto L43;
            case 8: goto L42;
            case 9: goto L41;
            case 10: goto L40;
            case 11: goto L39;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L48;
            case 18: goto L33;
            default: goto L48;
        };
    L48:
        return 0;
    L33:
        return 2131255192;
    L34:
        return 2131254078;
    L35:
        return 2131254912;
    L36:
        return 2131255523;
    L37:
        return 2131255522;
    L38:
        return 2131256063;
    L39:
        return 2131253870;
    L40:
        return 2131253681;
    L41:
        return 2131254899;
    L42:
        return 2131253990;
    L43:
        return 2131256017;
    L44:
        return 2131254229;
    L45:
        return 2131256057;
    L46:
        return 2131255990;
    L47:
        return 2131255989;
    L31:
        return 2131255142;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final Integer da0(ItemIdV2 r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Integer r1 = null;
        if (ToolbarPrimaryItemId.inlineAI != r3) goto L5;
    L27:
        return null;
    L5:
        if (ToolbarPrimaryItemId.aiRewrite == r3) goto L27;
        an4.a r0 = Z90();
        if (r0 == null) goto L17;
        an4.e r2 = an4.h.a(r0, r3);
        if (r2 == null) goto L17;
        an4.d r4 = r2.getToolbarIconDecoration();
        if (r4 == null) goto L17;
        Integer r5 = r4.a;
        if (r5 == null) goto L17;
        r1 = r5;
    L22:
        if (r1 == null) goto L26;
        return Integer.valueOf(r1.intValue());
    L26:
        return super.da0(r3);
    L17:
        an4.a r6 = Z90();
        if (r6 == null) goto L22;
        an4.d r7 = r6.getGlobalDecoration();
        if (r7 == null) goto L22;
        r1 = r7.a;
        goto L22
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final boolean ga0(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return !(r2 instanceof SelectColorV2CompatFragment);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final void ja0(int r2) {
        if (this.B == true) goto L12;
        if (r2 > 0) goto L12;
        if (rcb.b.a(getActivity()) == true) goto L12;
        if (wa0().hasShowingPanel() == true) goto L12;
        if (this.e.hasFunctionPanel() == true) goto L12;
        tt5.a.h("ToolbarV2Fragment", "onUpdateToolbar null");
        this.e.hideToolbar();
    L12:
        this.B = false;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        if (getActivity() == null) goto L5;
        FragmentActivity r4 = getActivity();
        Intrinsics.checkNotNull(r4);
        this.C = (EditPanelsManager) ViewModelProviders.of(r4).get(EditPanelsManager.class);
    L5:
        Bundle r5 = getArguments();
        if (r5 == null) goto L9;
        r5.getBoolean("EnableExternalSelect", true);
        r5.getBoolean("isInForseti", false);
        return;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final void qa0(ItemV2 r7) {
        Intrinsics.checkNotNullParameter(r7, "itemV2");
        this.q.a();
        Bundle r0 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("key_is_function_panel", Boolean.TRUE)});
        an4.a r1 = Z90();
        if (r1 == null) goto L21;
        ItemIdV2 r2 = r7.id();
        Set r3 = r1.getItemFactorySet();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r6 = r5.next();
        if ((r6 instanceof an4.f) == false) goto L6;
        r4.add(r6);
        goto L6
    L10:
        Iterator r8 = r4.iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((an4.e) r9).getItemId().name(), r2.name()) == false) goto L12;
    L17:
        an4.f r10 = (an4.e) r9;
        if (r10 == null) goto L21;
        if (r10.showPanel(this.D, r7, r7.id().name(), r0) == null) goto L21;
        return;
    L16:
        r9 = null;
    L21:
        super.qa0(r7);
        Unit r11 = Unit.INSTANCE;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final void ra0(ItemV2 r7) {
        Intrinsics.checkNotNullParameter(r7, "itemV2");
        Bundle r0 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("key_is_sub_toolbar", Boolean.TRUE)});
        an4.a r1 = Z90();
        if (r1 == null) goto L21;
        ItemIdV2 r2 = r7.id();
        Set r3 = r1.getItemFactorySet();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r6 = r5.next();
        if ((r6 instanceof an4.f) == false) goto L6;
        r4.add(r6);
        goto L6
    L10:
        Iterator r8 = r4.iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((an4.e) r9).getItemId().name(), r2.name()) == false) goto L12;
    L17:
        an4.f r10 = (an4.e) r9;
        if (r10 == null) goto L21;
        if (r10.showPanel(this.D, r7, r7.id().name(), r0) == null) goto L21;
        return;
    L16:
        r9 = null;
    L21:
        super.ra0(r7);
        Unit r11 = Unit.INSTANCE;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final void sa0(ItemV2 r1) {
        super.sa0(r1);
    }

    public final void va0(ItemV2[] r7) {
        if (r7 == null) goto L25;
        int r0 = r7.length;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L29;
        ItemV2 r3 = r7[r2];
        an4.a r4 = Z90();
        if (r4 == null) goto L10;
        an4.e r5 = an4.h.a(r4, r3.id());
        if (r5 == null) goto L10;
        r5.onHostDestroy(this.D);
    L10:
        ItemV2.Children r6 = r3.getChildren();
        if (r6 == null) goto L21;
        ItemV2[] r8 = r6.getItems();
        if (r8 == null) goto L21;
        boolean r9 = true;
        if (r8.length != 0) goto L17;
        boolean r10 = true;
    L19:
        if ((!r10) != true) goto L21;
    L22:
        if (r9 == false) goto L24;
        va0(r3.getChildren().getItems());
    L24:
        r2 = r2 + 1;
        goto L4
    L17:
        r10 = false;
    L21:
        r9 = false;
        goto L22
    L29:
        return;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final void ha0(View r6, ItemV2 r7) {
        Intrinsics.checkNotNullParameter(r6, "itemView");
        Intrinsics.checkNotNullParameter(r7, "data");
        an4.a r0 = Z90();
        if (r0 == null) goto L29;
        ItemIdV2 r1 = r7.id();
        Set r2 = r0.getItemFactorySet();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r5 = r4.next();
        if ((r5 instanceof an4.g) == false) goto L6;
        r3.add(r5);
        goto L6
    L10:
        Iterator r8 = r3.iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((an4.e) r9).getItemId().name(), r1.name()) == false) goto L12;
    L17:
        an4.g r10 = (an4.e) r9;
        if (r10 == null) goto L30;
        r10.a(this.D, r6, r7);
        return;
    L30:
        return;
    L16:
        r9 = null;
        goto L17
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public final View ia0(ViewGroup r6, ItemV2 r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "data");
        an4.a r0 = Z90();
        if (r0 == null) goto L29;
        ItemIdV2 r8 = r7.id();
        Set r1 = r0.getItemFactorySet();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if ((r4 instanceof an4.g) == false) goto L6;
        r2.add(r4);
        goto L6
    L10:
        Iterator r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Object r9 = r5.next();
        if (Intrinsics.areEqual(((an4.e) r9).getItemId().name(), r8.name()) == false) goto L12;
    L17:
        an4.g r10 = (an4.e) r9;
        if (r10 != null) goto L20;
        return null;
    L20:
        return r10.b(this.D, r6);
    L16:
        r9 = null;
        goto L17
    L29:
        return null;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment
    public void ma0(ItemIdV2 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "value");
        super.ma0(r2, r3);
        wa0().onToolbarItemClick(r2.name());
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        tt5.a.h("ToolbarV2Fragment", "xcxc onActivityResult, requestCode: " + r2 + ", resultCode: " + r3);
    }
}
