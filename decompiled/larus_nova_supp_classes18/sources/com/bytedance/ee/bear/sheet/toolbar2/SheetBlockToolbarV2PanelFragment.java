package com.bytedance.ee.bear.sheet.toolbar2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginInfoExtractException;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelFragment;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.util.ui.n;
import nn5.j;
import nn5.k;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockToolbarV2PanelFragment extends BaseToolbarV2PanelFragment<SheetBlockToolbarV2> {
    public static final int F = 0;
    public y3 B;
    public SheetBlockToolbarV2PanelViewModel C;
    public SheetEditorLayout D;
    public xu5.b.a E;

    public class a implements wm5.b {
        public final /* synthetic */ SheetBlockToolbarV2PanelFragment a;

        @Override // wm5.b
        public final void a() {
            SheetBlockToolbarV2PanelFragment.oa0(this.a, false);
            ((BaseToolbarV2PanelFragment) this.a).j.setVisibility(0);
            this.a.pa0(SheetBlockToolbarV2PanelFragment.F);
        }

        @Override // wm5.b
        public final void b() {
            SheetBlockToolbarV2PanelFragment.oa0(this.a, true);
            ((BaseToolbarV2PanelFragment) this.a).j.setVisibility(8);
            this.a.pa0(0);
        }

        public a(SheetBlockToolbarV2PanelFragment r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SheetBlockPrimaryItemId.values().length];
            a = r0;
            r0[SheetBlockPrimaryItemId.addNewBlock.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            a[SheetBlockPrimaryItemId.cellAttribute.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            a[SheetBlockPrimaryItemId.alignTransform.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            a[SheetBlockPrimaryItemId.textTransform.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            a[SheetBlockPrimaryItemId.checkbox.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            a[SheetBlockPrimaryItemId.reminder.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            a[SheetBlockPrimaryItemId.insertImage.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            a[SheetBlockPrimaryItemId.mention.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public final Class<? extends BaseSubToolbarFragment> W90(ItemIdV2 r1) {
        return null;
    }

    static {
        F = -n.f(eu5.b.a, 44);
    }

    public final BaseToolbarV2PanelViewModel Z90() {
        return q.a(this, SheetBlockToolbarV2PanelViewModel.class);
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.onDestroy();
        this.D.k();
    }

    public SheetBlockToolbarV2PanelFragment() {
    }

    public final Class<? extends BaseSubToolbarV2Fragment> X90(ItemIdV2 r2) {
        if (r2 != SheetBlockPrimaryItemId.cellAttribute) goto L7;
        return SheetBlockCellAttrFragment.class;
    L7:
        if (r2 != SheetBlockPrimaryItemId.textTransform) goto L11;
        return SheetBlockTextAttrFragment.class;
    L11:
        if (r2 != SheetBlockPrimaryItemId.alignTransform) goto L14;
        return SheetBlockAlignAttrFragment.class;
    L14:
        return null;
    }

    public final int Y90(ItemIdV2 r2) {
        if ((r2 instanceof SheetBlockPrimaryItemId) == true) goto L5;
    L15:
        return 0;
    L5:
        switch(b.a[((SheetBlockPrimaryItemId) r2).ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L15;
        };
    L7:
        return 2131253681;
    L8:
        return 2131254899;
    L9:
        return 2131253990;
    L10:
        return 2131256017;
    L11:
        return 2131255990;
    L12:
        return 2131256057;
    L13:
        return 2131247799;
    L14:
        return 2131255142;
    }

    public final boolean ba0(Fragment r2) {
        if ((r2 instanceof SheetBlockSelectColorFragment) == false) goto L5;
        return false;
    L5:
        if ((r2 instanceof SheetBlockSelectBorderFragment) == true) goto L11;
        return true;
    L11:
        return false;
    }

    public final void ga0(ToolbarV2 r6) {
        SheetBlockToolbarV2 r7 = (SheetBlockToolbarV2) r6;
        if (r7 != null) goto L5;
    L17:
        ((BaseToolbarV2PanelFragment) this).j.setVisibility(8);
    L18:
        if (r7 != null) goto L20;
        SheetBlockToolbarV2.Input r3 = null;
    L21:
        if (r7 != null) goto L23;
    L26:
        boolean r8 = false;
    L28:
        if (r8 == false) goto L37;
        Z90().clearSubToolbar();
        V90(true);
        tt5.a.b("SheetBlockToolbarV2PanelFragment", "showSheetEditor");
        this.D.setCellStyle(r3.style);
        if (this.B.getUrl() == null) goto L32;
        int r9 = AtUtils.h(e.e(p.a().Z(this.B.getUrl()).a));
    L34:
        if (r3.getObjType() <= 0) goto L36;
        r9 = r3.getObjType();
    L36:
        this.D.s(r3.getSegments(), r3.getToken(), r9);
        this.D.setCellInfo(r3.getCellInfo());
        this.C.setShowingInput(true);
        return;
    L32:
        r9 = e.g.b;
        goto L34
    L37:
        tt5.a.b("SheetBlockToolbarV2PanelFragment", "closeSheetEditor");
        SheetEditorLayout r10 = this.D;
        if (r10.getVisibility() == 8) goto L40;
        r10.setVisibility(8);
        r10.i.setVisibility(8);
        r10.p();
        r10.E = false;
    L40:
        this.C.setShowingInput(false);
        return;
    L23:
        if (TextUtils.isEmpty(r7.getShowingItemId()) == false) goto L26;
        if (r3 == null) goto L26;
        r8 = true;
        goto L28
    L20:
        r3 = r7.getInput();
        goto L21
    L5:
        if (r7.getItems() == null) goto L17;
        if (r7.getItems().length == 0) goto L17;
        View r4 = ((BaseToolbarV2PanelFragment) this).j;
        if (this.D.i.getVisibility() != 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        int r11 = 8;
    L16:
        r4.setVisibility(r11);
        na0(r7);
        goto L18
    L15:
        r11 = 0;
        goto L16
    L12:
        r5 = false;
        goto L13
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.C = q.a(this, SheetBlockToolbarV2PanelViewModel.class);
        this.B = PluginHost.fromFragment(this).getHostAbility(e4.class).getDocumentMetadata();     // Catch: PluginInfoExtractException -> L5
    L7:
        this.E = xu5.b.a(getActivity());
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void pa0(int r3) {
        ViewGroup.LayoutParams r0 = this.D.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.bottomMargin = r3;
        this.D.setLayoutParams(r1);
        return;
    }

    public static void oa0(SheetBlockToolbarV2PanelFragment r1, boolean r2) {
        r1.getActivity();
        if (r2 == false) goto L7;
        xu5.b.a r3 = r1.E;
        if (r3 == null) goto L11;
        r3.saveState();
        r1.E.d(2131103454, true);
        return;
    L11:
        return;
    L7:
        xu5.b.a r4 = r1.E;
        if (r4 == null) goto L13;
        r4.resetState();
        return;
    }

    public final void fa0(ItemIdV2 r2, String r3) {
        if (r2 != ItemIdV2.ConstId.keyboard) goto L6;
        r3 = String.valueOf(pcb.a.a.b(getActivity()).isKeyboardShowing());
    L12:
        super.fa0(r2, r3);
        this.D.k();
        return;
    L6:
        if (r2 != SheetBlockPrimaryItemId.alignTransform) goto L8;
    L11:
        rcb.c.c(getContext());
        goto L12
    L8:
        if (r2 == SheetBlockPrimaryItemId.cellAttribute) goto L11;
        if (r2 != SheetBlockPrimaryItemId.textTransform) goto L12;
        goto L11
    }

    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        r2.setFitsSystemWindows(!ForsetiHelper.s(this));
        ((BaseToolbarV2PanelFragment) this).i.setImageResource(2131233876);
        SheetEditorLayout r4 = (SheetEditorLayout) r2.findViewById(2131386153);
        this.D = r4;
        r4.setPermDelegate((DocViewModel) q.a(this, DocViewModel.class));
        this.D.setDocumentUrl(this.B.getBearUrl());
        this.D.setEditDelegate((wm5.a) ((BaseToolbarV2PanelFragment) this).e);
        this.D.setShowInputResultCallBack(new j(this));
        this.D.setHeightChangeListener(new k(this));
        this.D.setFullScreenCallback(new a(this));
        pa0(F);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564590, r3, false);
    }
}
