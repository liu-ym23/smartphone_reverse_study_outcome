package com.bytedance.ee.bear.sheet_core.toolbar2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginInfoExtractException;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.core.toolbar.BaseSubToolbarFragment;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeBaseToolbarV2PanelFragment;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockPrimaryItemId;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockToolbarV2;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.util.ui.n;
import ew4.g0;
import rn5.j;
import rn5.k;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockToolbarV2PanelFragment extends OfficeBaseToolbarV2PanelFragment<SheetBlockToolbarV2> {
    public static final int H = 0;
    public y3 B;
    public SheetBlockToolbarV2PanelViewModel C;
    public SheetEditorLayout D;
    public xu5.b.a E;
    public PluginHost F;
    public vz4.b.a G;

    public class a implements wm5.b {
        public final /* synthetic */ SheetBlockToolbarV2PanelFragment a;

        @Override // wm5.b
        public final void a() {
            SheetBlockToolbarV2PanelFragment.va0(this.a, false);
            SheetBlockToolbarV2PanelFragment r0 = this.a;
            vz4.b.a r2 = r0.G;
            if (r2 == null) goto L6;
            r2.close();
            r0.G = null;
        L6:
            ((OfficeBaseToolbarV2PanelFragment) this.a).j.setVisibility(0);
            this.a.xa0(SheetBlockToolbarV2PanelFragment.H);
        }

        @Override // wm5.b
        public final void b() {
            SheetBlockToolbarV2PanelFragment.va0(this.a, true);
            SheetBlockToolbarV2PanelFragment r0 = this.a;
            if (r0.G != null) goto L11;
            PluginHost r1 = r0.F;
            if (r1 == null) goto L8;
            vz4.b r2 = (vz4.b) r1.getHostAbilityOrNull(vz4.b.class);
        L9:
            if (r2 == null) goto L11;
            r0.G = r2.qh("SheetBlockToolbarV2PanelFragment");
            goto L11
        L8:
            r2 = null;
        L11:
            ((OfficeBaseToolbarV2PanelFragment) this.a).j.setVisibility(8);
            this.a.xa0(0);
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

    public final Class<? extends BaseSubToolbarFragment> V90(ItemIdV2 r1) {
        return null;
    }

    public final an4.a Z90() {
        return null;
    }

    static {
        H = -n.f(eu5.b.a, 44);
    }

    public final BaseToolbarV2PanelViewModel ea0() {
        return q.a(this, SheetBlockToolbarV2PanelViewModel.class);
    }

    public final boolean wa0() {
        PluginHost r0 = this.F;
        if (r0 != null) goto L6;
        tt5.a.k("SheetBlockToolbarV2PanelFragment", "getIsMentionDetectEnabled, pluginHost is null");
        return true;
    L6:
        g0 r1 = (g0) r0.getUserComponent().a(g0.class);
        if (r1 != null) goto L10;
        tt5.a.k("SheetBlockToolbarV2PanelFragment", "getIsMentionDetectEnabled is null");
        return true;
    L10:
        y3 r2 = this.B;
        if (r2 == null) goto L13;
        int r3 = r2.getDocumentTypeValue();
    L15:
        return r1.O(r3);
    L13:
        r3 = e.g.b;
        goto L15
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.onDestroy();
        this.D.k();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        vz4.b.a r0 = this.G;
        if (r0 == null) goto L7;
        r0.close();
        this.G = null;
        return;
    }

    public SheetBlockToolbarV2PanelFragment() {
    }

    public final Class<? extends BaseSubToolbarV2Fragment> W90(ItemIdV2 r2) {
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

    public final int ca0(ItemIdV2 r2) {
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

    public final boolean ga0(Fragment r2) {
        if ((r2 instanceof SheetBlockSelectColorFragment) == false) goto L5;
        return false;
    L5:
        if ((r2 instanceof SheetBlockSelectBorderFragment) == true) goto L11;
        return true;
    L11:
        return false;
    }

    public final void na0(ToolbarV2 r7) {
        SheetBlockToolbarV2 r8 = (SheetBlockToolbarV2) r7;
        if (r8 != null) goto L5;
    L10:
        ((OfficeBaseToolbarV2PanelFragment) this).j.setVisibility(8);
    L11:
        if (r8 != null) goto L13;
        SheetBlockToolbarV2.Input r2 = null;
    L15:
        if (r8 != null) goto L17;
    L20:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L31;
        ea0().clearSubToolbar();
        U90(true);
        tt5.a.b("SheetBlockToolbarV2PanelFragment", "showSheetEditor");
        this.D.setCellStyle(r2.style);
        if (this.B.getUrl() == null) goto L26;
        int r10 = AtUtils.h(e.e(p.a().Z(this.B.getUrl()).a));
    L28:
        if (r2.getObjType() <= 0) goto L30;
        r10 = r2.getObjType();
    L30:
        this.D.s(r2.getSegments(), r2.getToken(), r10, wa0());
        this.D.setCellInfo(r2.getCellInfo());
        this.C.setShowingInput(true);
        return;
    L26:
        r10 = e.g.b;
        goto L28
    L31:
        tt5.a.b("SheetBlockToolbarV2PanelFragment", "closeSheetEditor");
        SheetEditorLayout r11 = this.D;
        if (r11.getVisibility() == 8) goto L34;
        r11.setVisibility(8);
        r11.i.setVisibility(8);
        r11.p();
        r11.B = false;
    L34:
        this.C.setShowingInput(false);
        return;
    L17:
        if (TextUtils.isEmpty(r8.getShowingItemId()) == false) goto L20;
        if (r2 == null) goto L20;
        r9 = true;
        goto L22
    L13:
        r2 = r8.getInput();
        goto L15
    L5:
        if (r8.getItems() == null) goto L10;
        if (r8.getItems().length == 0) goto L10;
        ((OfficeBaseToolbarV2PanelFragment) this).j.setVisibility(0);
        ua0(r8);
        goto L11
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.F = PluginHost.fromFragment(this);     // Catch: PluginInfoExtractException -> L5
    L7:
        this.C = q.a(this, SheetBlockToolbarV2PanelViewModel.class);
        this.B = PluginHost.fromFragment(this).getHostAbility(e4.class).getDocumentMetadata();     // Catch: PluginInfoExtractException -> L10
    L12:
        this.E = xu5.b.a(getActivity());
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        tt5.a.e("SheetBlockToolbarV2PanelFragment", "onCreate, get PluginHost failed, error: ", e, false);
        goto L7
    }

    public final void xa0(int r3) {
        ViewGroup.LayoutParams r0 = this.D.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.bottomMargin = r3;
        this.D.setLayoutParams(r1);
        return;
    }

    public static void va0(SheetBlockToolbarV2PanelFragment r1, boolean r2) {
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

    public final void ma0(ItemIdV2 r2, String r3) {
        if (r2 != ItemIdV2.ConstId.keyboard) goto L6;
        r3 = String.valueOf(pcb.a.a.b(getActivity()).isKeyboardShowing());
    L12:
        super.ma0(r2, r3);
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
        ((OfficeBaseToolbarV2PanelFragment) this).i.setImageResource(2131233679);
        SheetEditorLayout r4 = (SheetEditorLayout) r2.findViewById(2131386153);
        this.D = r4;
        r4.setPermDelegate((DocViewModel) q.a(this, DocViewModel.class));
        if (wa0() == true) goto L5;
        this.D.setAtIconVisibility(8);
    L5:
        this.D.setDocumentUrl(this.B.getBearUrl());
        this.D.setEditDelegate((wm5.a) ((OfficeBaseToolbarV2PanelFragment) this).e);
        this.D.setShowInputResultCallBack(new j(this));
        this.D.setHeightChangeListener(new k(this));
        this.D.setFullScreenCallback(new a(this));
        xa0(H);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564542, r3, false);
    }
}
