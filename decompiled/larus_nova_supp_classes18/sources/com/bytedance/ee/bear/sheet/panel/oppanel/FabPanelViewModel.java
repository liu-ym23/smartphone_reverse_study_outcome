package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.bear.fileselector.FileSelectFragment;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FabPanelViewModel extends BaseCellPanelViewModel<SheetItem> implements VcKeyboardChangeEventProducer {
    private b mFabPanelDelegate;
    private a mFabPanelDelegate2;
    private MutableLiveData<Boolean> showKeyboardFab;

    public interface a {
    }

    public interface b {
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel
    public String getPanelName() {
        return "oppanel";
    }

    public void removerFabPanel() {
        a r0 = this.mFabPanelDelegate2;
        if (r0 == null) goto L6;
        FabPanelPlugin.a r1 = (FabPanelPlugin.a) r0;
        FabPanelPlugin.access$100(r1.a).d(r1.a);
        return;
    }

    public FabPanelViewModel() {
        this.showKeyboardFab = new MutableLiveData();
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
        int r1 = FabPanelPlugin.access$200(((FabPanelPlugin.a) r0).a);
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
        FabPanelFragment.a r1 = (FabPanelFragment.a) r0;
        r1.a(r3, new Bundle());
        return;
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
        ((FabPanelFragment.a) r0).a(r2, r3);
        return;
    }

    public void openSelectImageFragment(Bundle r7, bb5.e r8, int r9) {
        b r0 = this.mFabPanelDelegate;
        if (r0 == null) goto L18;
        final FabPanelFragment.a r1 = (FabPanelFragment.a) r0;
        r1.a.j.setDragUpEnable(false);
        FragmentManager r2 = r1.a.getChildFragmentManager();
        FileSelectFragment r3 = r2.findFragmentByTag(FileSelectFragment.class.getName());
        if (r3 != null) goto L10;
        PluginHost.writePluginHostToBundle(r1.a, r7);
        FabPanelFragment r4 = r1.a;
        FileSelectConfig.e r5 = r4.s.getDefaultBuilder(r4.getActivity());
        FileSelectConfig r6 = ((FileSelectConfig.c) r5).a;
        r6.canDragView = true;
        r6.heightChangeListener = r8;
        r6.ccmPickViewHeight = r9;
        r6.maxSelectImageNum = 1;
        r6.actionType = 1;
        r6.onDismissListener = new h(r1);
        r6.showGif = false;
        if (r7.getBoolean("is_from_sheet_insert_panel", false) == false) goto L9;
        ((FileSelectConfig.c) r5).a.showVideo = false;
    L9:
        Context r10 = r1.a.getContext();
        FileSelectConfig r11 = r5.a();
        String r12 = FileSelectFragment.class.getName();
        int r13 = com.bytedance.ee.bear.fileselector.d.a;
        r3 = com.bytedance.ee.bear.fileselector.d.a.c(r10, r2, r11, r12);
    L10:
        if (r3 != null) goto L12;
        tt5.a.k("FabPanelFragment", "get FileSelectFragment is null");
        return;
    L12:
        FragmentTransaction r14 = r2.beginTransaction();
        String r15 = r3.getClass().getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r14, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r15, 2131381566) == true) goto L16;
        r14 = r14.replace(2131381566, r3, r15);
    L16:
        r14.commitAllowingStateLoss();
        return;
    }
}
