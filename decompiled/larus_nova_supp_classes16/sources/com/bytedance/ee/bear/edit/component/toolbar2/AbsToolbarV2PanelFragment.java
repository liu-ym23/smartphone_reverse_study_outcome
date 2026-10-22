package com.bytedance.ee.bear.edit.component.toolbar2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.toolbar.media.impl.InsertMediaV2Fragment;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectMediaViewModel;
import com.bytedance.ee.bear.document.toolbar.selectcolor.impl.SelectColorCompatFragment;
import com.bytedance.ee.bear.facade.common.BaseCommonActivity;
import com.bytedance.ee.bear.fileselector.FileSelectFragment;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsToolbarV2PanelFragment extends BaseToolbarV2PanelFragment<DocToolbarV2> {
    public a0 B;
    public boolean C;
    public SelectMediaViewModel D;
    public j45.c E;
    public EditPanelsManager F;
    public final a G;
    public boolean H;

    public class a implements SelectMediaViewModel.c {
        public final /* synthetic */ AbsToolbarV2PanelFragment a;

        @Override // com.bytedance.ee.bear.document.toolbar.media.impl.SelectMediaViewModel.c
        public final void a() {
            if (this.a.F == null) goto L6;
            tt5.a.h("ToolbarV2Fragment", "select media overflow");
            this.a.F.forceCloseToolbarV2();
            return;
        }

        public a(AbsToolbarV2PanelFragment r1) {
            this.a = r1;
        }
    }

    public abstract Class<? extends BaseSubToolbarV2Fragment> oa0();

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final void da0() {
        if (this.B.onKeyboardToolbarItemClick() == true) goto L6;
        super.da0();
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final void ea0() {
        this.B.onToolbarChanged();
    }

    public AbsToolbarV2PanelFragment() {
        this.C = true;
        this.G = new a(this);
        this.H = false;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public void onDestroyView() {
        super.onDestroyView();
        SelectMediaViewModel r0 = this.D;
        if (r0 == null) goto L6;
        r0.clearSelectMediaListener(this.G);
        return;
    }

    static {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final Class<? extends BaseSubToolbarFragment> W90(ItemIdV2 r2) {
        if (r2 != ToolbarPrimaryItemId.insertImage) goto L6;
        return InsertMediaV2Fragment.class;
    L6:
        return null;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final Class<? extends BaseSubToolbarV2Fragment> X90(ItemIdV2 r2) {
        if (r2 == ToolbarPrimaryItemId.blockTransform) goto L12;
        if (r2 == ToolbarPrimaryItemId.textTransform) goto L12;
        if (r2 == ToolbarPrimaryItemId.alignTransform) goto L12;
        return null;
    L12:
        return oa0();
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final int Y90(ItemIdV2 r3) {
        if ((r3 instanceof ToolbarPrimaryItemId) == true) goto L5;
        return 0;
    L5:
        switch(com.bytedance.ee.bear.document.toolbar.o.a.b[((ToolbarPrimaryItemId) r3).ordinal()]) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            case 16: goto L7;
            default: goto L38;
        };
    L7:
        return 2131255192;
    L8:
        return 2131254078;
    L9:
        return 2131254912;
    L10:
        return 2131255523;
    L11:
        return 2131255522;
    L12:
        return 2131256063;
    L13:
        return 2131253870;
    L14:
        return 2131253681;
    L15:
        return 2131254899;
    L16:
        return 2131253990;
    L17:
        return 2131256017;
    L18:
        return 2131256057;
    L19:
        return 2131255990;
    L20:
        return 2131255989;
    L21:
        return 2131255142;
    L38:
        return 0;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final boolean ba0(Fragment r1) {
        return !(r1 instanceof SelectColorCompatFragment);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final void ca0(int r2) {
        if (this.C == true) goto L12;
        if (r2 > 0) goto L12;
        if (rcb.b.a(getActivity()) == true) goto L12;
        if (this.B.hasShowingPanel() == true) goto L12;
        if (this.e.hasFunctionPanel() == true) goto L12;
        tt5.a.h("ToolbarV2Fragment", "onUpdateToolbar null");
        this.e.hideToolbar();
    L12:
        this.C = false;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final void la0(ItemV2 r5) {
        this.r.a();
        final FragmentActivity r0 = getActivity();
        if ((r0.getSupportFragmentManager().findFragmentByTag(r5.id().name()) instanceof BaseSubToolbarFragment) == false) goto L5;
        return;
    L5:
        if (r5.id() != ToolbarPrimaryItemId.insertImage) goto L15;
        FileSelectConfig.e r6 = this.D.getDefaultBuilder(r0);
        if (this.H == false) goto L9;
        r6.a.container = this.r;
    L9:
        final j45.c r1 = this.E;
        r1.getClass();
        r6.a.onDismissListener = new j45.a(r1, r0);
        FragmentManager r2 = r0.getSupportFragmentManager();
        FileSelectConfig r7 = r6.a();
        int r3 = com.bytedance.ee.bear.fileselector.d.a;
        r1.a = com.bytedance.ee.bear.fileselector.d.a.c(r0, r2, r7, "ToolbarV2Fragment");
        j45.c r8 = this.E;
        BaseCommonActivity r4 = getActivity();
        r8.getClass();
        if ((r4 instanceof BaseCommonActivity) == false) goto L16;
        j45.b r9 = new j45.b(r8, r4);
        r8.b = r9;
        r4.Xi(r9);
        return;
    L16:
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.B = DocToolbarV2Compat.of(getActivity());
        if (getActivity() == null) goto L6;
        this.D = (SelectMediaViewModel) ViewModelProviders.of(getActivity()).get(SelectMediaViewModel.class);
        this.F = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
    L6:
        if (getArguments() == null) goto L8;
        getArguments().getBoolean("EnableExternalSelect", true);
        this.H = getArguments().getBoolean("isInForseti", false);
    L8:
        this.E = new j45.c();
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public void fa0(ItemIdV2 r1, String r2) {
        super.fa0(r1, r2);
        this.B.onToolbarItemClick(r1.name());
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final void ja0(FragmentActivity r1, Fragment r2) {
        if ((r2 instanceof FileSelectFragment) == false) goto L6;
        FragmentManager r3 = r1.getSupportFragmentManager();
        int r4 = com.bytedance.ee.bear.fileselector.d.a;
        com.bytedance.ee.bear.fileselector.d.a.a(r3, "ToolbarV2Fragment");
        return;
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        tt5.a.h("ToolbarV2Fragment", "xcxc onActivityResult, requestCode: " + r2 + ", resultCode: " + r3);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        SelectMediaViewModel r5 = this.D;
        if (r5 == null) goto L6;
        r5.setSelectMediaListener(this.G);
    L6:
        return r2.inflate(2131565072, r3, false);
    }
}
