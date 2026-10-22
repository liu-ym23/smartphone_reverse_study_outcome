package com.bytedance.ee.bear.edit.component.document;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import com.bytedance.ee.util.io.NonProguard;
import g45.a;
import g45.d;
import kotlin.Lazy;
import rcb.c;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseEditPanelViewModel extends ViewModel implements a, ocb.a {
    private static final String TAG = "BaseEditPanelViewModel";
    protected MutableLiveData<Boolean> active;
    protected EditPanelsManager editPanelsManager;
    private MutableLiveData<Integer> keyboardHeightLiveData;
    private k webService;

    public abstract /* synthetic */ int getPanelHeight(Context r1);

    public abstract /* synthetic */ String getPanelName();

    public /* bridge */ /* synthetic */ void onBecomeActive(d r1, a r2) {
    }

    public /* bridge */ /* synthetic */ void onBecomeInactive(d r1, a r2) {
    }

    public void onDetachFromUI() {
        this.webService = null;
        this.editPanelsManager = null;
    }

    @Override // g45.a
    public LiveData<Boolean> getActive() {
        if (this.active != null) goto L6;
        this.active = new MutableLiveData();
    L6:
        return this.active;
    }

    public LiveData<Integer> keyboardHeightLiveData() {
        if (this.keyboardHeightLiveData != null) goto L6;
        this.keyboardHeightLiveData = new MutableLiveData();
    L6:
        return this.keyboardHeightLiveData;
    }

    public int getKeyboardHeight() {
        Integer r0 = (Integer) keyboardHeightLiveData().getValue();
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    public boolean isKeyboardShowing() {
        if (getKeyboardHeight() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public BaseEditPanelViewModel() {
    }

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public k getWebService() {
        return this.webService;
    }

    public EditPanelsManager panelsViewModel() {
        return this.editPanelsManager;
    }

    public void onKeyboardStateChanged(int r2) {
        keyboardHeightLiveData().setValue(Integer.valueOf(r2));
    }

    public void requestNotFocus(Context r1) {
        c.c(r1);
    }

    public void setActive(boolean r3) {
        MutableLiveData r0 = getActive();
        if (r0.getValue() != null) goto L5;
    L6:
        r0.setValue(Boolean.valueOf(r3));
        return;
    L5:
        if (((Boolean) r0.getValue()).booleanValue() != r3) goto L6;
    }

    public void execJS(String r3, JSONObject r4) {
        k r0 = this.webService;
        if (r0 == null) goto L5;
        r0.j(r3, r4);
        return;
    L5:
        tt5.a.e(TAG, "", new IllegalStateException("execJS while web null!"), false);
    }

    public void onAttachToUI(PluginHost r2, k r3) {
        if (r2.getHostFragment() == null) goto L9;
        Lazy r0 = FGDowngradeHelper.a;
        if (FGDowngradeHelper.b() == true) goto L9;
        this.webService = r3;
        this.editPanelsManager = (EditPanelsManager) ViewModelProviders.of(r2.getActivity()).get(EditPanelsManager.class);
        return;
    L9:
        onAttachToUI(r2.getActivity(), r3);
    }

    public void execJS(String r3, NonProguard r4) {
        k r0 = this.webService;
        if (r0 == null) goto L5;
        r0.u(r3, r4);
        return;
    L5:
        tt5.a.e(TAG, "", new IllegalStateException("execJS while web null!"), false);
    }

    public void onAttachToUI(FragmentActivity r1, k r2) {
        this.webService = r2;
        this.editPanelsManager = (EditPanelsManager) ViewModelProviders.of(r1).get(EditPanelsManager.class);
    }

    public void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        onKeyboardStateChanged(r2);
    }
}
