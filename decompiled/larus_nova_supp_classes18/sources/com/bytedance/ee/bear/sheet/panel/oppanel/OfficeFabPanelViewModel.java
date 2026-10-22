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
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel
    public String getPanelName() {
        return PANEL_NAME;
    }

    public void removerFabPanel() {
        a r0 = this.mFabPanelDelegate2;
        if (r0 == null) goto L6;
        OfficeFabPanelPlugin.a r1 = (OfficeFabPanelPlugin.a) r0;
        OfficeFabPanelPlugin.access$100(r1.a).d(r1.a);
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

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    public MutableLiveData<Boolean> showKeyboardFab() {
        return this.showKeyboardFab;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel
    public int getPanelHeight(Context r3) {
        a r0 = this.mFabPanelDelegate2;
        if (r0 == null) goto L5;
        int r1 = OfficeFabPanelPlugin.access$200(((OfficeFabPanelPlugin.a) r0).a);
        if (r1 <= 0) goto L10;
        return r1;
    L10:
        return r3.getResources().getDimensionPixelSize(2131168161);
    L5:
        return r3.getResources().getDimensionPixelSize(2131168161);
    }

    public void openChildFragment(Class<?> r3) {
        b r0 = this.mFabPanelDelegate;
        if (r0 == null) goto L6;
        OfficeFabPanelFragment.a r1 = (OfficeFabPanelFragment.a) r0;
        r1.a(r3, new Bundle());
        return;
    }

    public void setFabPanelConfig(ew4.f0 r1) {
        this.sheetFabPanelConfig = r1;
    }

    public void setFabPanelDelegate2(a r1) {
        this.mFabPanelDelegate2 = r1;
    }

    public void setToolkitDelegate(b r1) {
        this.mFabPanelDelegate = r1;
    }

    public void openChildFragment(Class<?> r2, Bundle r3) {
        b r0 = this.mFabPanelDelegate;
        if (r0 == null) goto L6;
        ((OfficeFabPanelFragment.a) r0).a(r2, r3);
        return;
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [com.bytedance.ee.bear.sheet.panel.oppanel.r] */
    public void openSelectImageFragment(Bundle r16, ew4.j0 r17, int r18) {
        b r1 = this.mFabPanelDelegate;
        if (r1 == null) goto L24;
        final OfficeFabPanelFragment.a r2 = (OfficeFabPanelFragment.a) r1;
        r2.a.j.setDragUpEnable(false);
        FragmentManager r3 = r2.a.getChildFragmentManager();
        Fragment r5 = r3.findFragmentByTag("sheet_select_image");
        if (r5 != null) goto L16;
        PluginHost.writePluginHostToBundle(r2.a, r16);
        ew4.f0 r7 = r2.a.f.getFabPanelConfig();
        if (r7 == null) goto L16;
        s r6 = new s(r2);
        SheetDragView r8 = r2.a.j;
        if (r8 != null) goto L11;
    L10:
        int r11 = 0;
    L15:
        r5 = r7.v1(r6, new ew4.k0(r16, r18, r11, r17, new r(r2)));
        goto L16
    L11:
        View r9 = r8.findViewById(2131381566);
        if (r9 == null) goto L10;
        r11 = r9.getHeight();
    L16:
        if (r5 != null) goto L18;
        tt5.a.k("OfficeFabPanelFragment", "createSelectImageFragment return null");
        return;
    L18:
        FragmentTransaction r4 = r3.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "sheet_select_image", 2131381566) == true) goto L22;
        r4 = r4.replace(2131381566, r5, "sheet_select_image");
    L22:
        r4.commitAllowingStateLoss();
        return;
    }
}
