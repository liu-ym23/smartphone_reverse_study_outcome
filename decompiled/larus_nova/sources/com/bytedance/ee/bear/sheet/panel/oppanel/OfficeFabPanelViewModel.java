package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: classes18.dex */
public class OfficeFabPanelViewModel extends BaseCellPanelViewModel<SheetItem> implements VcKeyboardChangeEventProducer {
    private static final String PANEL_NAME = "oppanel";
    private b mFabPanelDelegate;
    private a mFabPanelDelegate2;
    private ew4.f0 sheetFabPanelConfig;
    private MutableLiveData<Boolean> showKeyboardFab;

    public interface a {
    }

    public interface b {
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public String getPanelName() {
        return PANEL_NAME;
    }

    public void removerFabPanel() {
        a r100 = this.mFabPanelDelegate2;
        if (r100 == null) goto L6;
        OfficeFabPanelPlugin.a r101 = (OfficeFabPanelPlugin.a) r100;
        OfficeFabPanelPlugin.access$100(r101.f238183a).d(r101.f238183a);
        return;
    }

    public OfficeFabPanelViewModel() {
        this.showKeyboardFab = new MutableLiveData();
    }

    public ew4.f0 getFabPanelConfig() {
        return this.sheetFabPanelConfig;
    }

    public a getFabPanelDelegate2() {
        return this.mFabPanelDelegate2;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    public MutableLiveData<Boolean> showKeyboardFab() {
        return this.showKeyboardFab;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel, com.bytedance.ee.bear.edit.component.document.BaseEditPanelViewModel, g45.a
    public int getPanelHeight(Context r100) {
        a r101 = this.mFabPanelDelegate2;
        if (r101 == null) goto L5;
        int r102 = OfficeFabPanelPlugin.access$200(((OfficeFabPanelPlugin.a) r101).f238183a);
        if (r102 <= 0) goto L10;
        return r102;
    L10:
        return r100.getResources().getDimensionPixelSize(R.dimen.sheet_panel_height);
    L5:
        return r100.getResources().getDimensionPixelSize(R.dimen.sheet_panel_height);
    }

    public void openChildFragment(Class<?> r100) {
        b r101 = this.mFabPanelDelegate;
        if (r101 == null) goto L6;
        OfficeFabPanelFragment.a r102 = (OfficeFabPanelFragment.a) r101;
        r102.a(r100, new Bundle());
        return;
    }

    public void setFabPanelConfig(ew4.f0 r100) {
        this.sheetFabPanelConfig = r100;
    }

    public void setFabPanelDelegate2(a r100) {
        this.mFabPanelDelegate2 = r100;
    }

    public void setToolkitDelegate(b r100) {
        this.mFabPanelDelegate = r100;
    }

    public void openChildFragment(Class<?> r100, Bundle r101) {
        b r102 = this.mFabPanelDelegate;
        if (r102 == null) goto L6;
        ((OfficeFabPanelFragment.a) r102).a(r100, r101);
        return;
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [com.bytedance.ee.bear.sheet.panel.oppanel.r] */
    public void openSelectImageFragment(Bundle r110, ew4.j0 r111, int r112) {
        b r100 = this.mFabPanelDelegate;
        if (r100 == null) goto L24;
        final OfficeFabPanelFragment.a r101 = (OfficeFabPanelFragment.a) r100;
        r101.f238176a.f238167j.setDragUpEnable(false);
        FragmentManager r102 = r101.f238176a.getChildFragmentManager();
        Fragment r103 = r102.findFragmentByTag("sheet_select_image");
        if (r103 != null) goto L16;
        PluginHost.writePluginHostToBundle(r101.f238176a, r110);
        ew4.f0 r104 = r101.f238176a.f238163f.getFabPanelConfig();
        if (r104 == null) goto L16;
        s r105 = new s(r101);
        SheetDragView r106 = r101.f238176a.f238167j;
        if (r106 != null) goto L11;
    L10:
        int r113 = 0;
    L15:
        r103 = r104.v1(r105, new ew4.k0(r110, r112, r113, r111, new r(r101)));
        goto L16
    L11:
        View r107 = r106.findViewById(R.id.oppanel_container);
        if (r107 == null) goto L10;
        r113 = r107.getHeight();
    L16:
        if (r103 != null) goto L18;
        tt5.a.k("OfficeFabPanelFragment", "createSelectImageFragment return null");
        return;
    L18:
        FragmentTransaction r108 = r102.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r108, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "sheet_select_image", R.id.oppanel_container) == true) goto L22;
        r108 = r108.replace(R.id.oppanel_container, r103, "sheet_select_image");
    L22:
        r108.commitAllowingStateLoss();
        return;
    }
}
