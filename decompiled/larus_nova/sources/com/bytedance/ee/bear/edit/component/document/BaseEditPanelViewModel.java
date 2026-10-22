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

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseEditPanelViewModel extends ViewModel implements a, ocb.a {
    private static final String TAG = "BaseEditPanelViewModel";
    protected MutableLiveData<Boolean> active;
    protected EditPanelsManager editPanelsManager;
    private MutableLiveData<Integer> keyboardHeightLiveData;
    private k webService;

    public abstract /* synthetic */ int getPanelHeight(Context r100);

    public abstract /* synthetic */ String getPanelName();

    public /* bridge */ /* synthetic */ void onBecomeActive(d r100, a r101) {
    }

    public /* bridge */ /* synthetic */ void onBecomeInactive(d r100, a r101) {
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
        Integer r100 = keyboardHeightLiveData().getValue();
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.intValue();
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

    public void onKeyboardStateChanged(int r100) {
        ((MutableLiveData) keyboardHeightLiveData()).setValue(Integer.valueOf(r100));
    }

    public void requestNotFocus(Context r100) {
        c.c(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setActive(boolean r100) {
        MutableLiveData r101 = (MutableLiveData) getActive();
        if (r101.getValue() != 0) goto L5;
    L6:
        r101.setValue(Boolean.valueOf(r100));
        return;
    L5:
        if (((Boolean) r101.getValue()).booleanValue() != r100) goto L6;
    }

    public void execJS(String r100, JSONObject r101) {
        k r102 = this.webService;
        if (r102 == null) goto L5;
        r102.j(r100, r101);
        return;
    L5:
        tt5.a.e(TAG, "", new IllegalStateException("execJS while web null!"), false);
    }

    public void onAttachToUI(PluginHost r100, k r101) {
        if (r100.getHostFragment() == null) goto L9;
        Lazy r102 = FGDowngradeHelper.f216485a;
        if (FGDowngradeHelper.b() == true) goto L9;
        this.webService = r101;
        this.editPanelsManager = (EditPanelsManager) ViewModelProviders.of(r100.getActivity()).get(EditPanelsManager.class);
        return;
    L9:
        onAttachToUI(r100.getActivity(), r101);
    }

    public void execJS(String r100, NonProguard r101) {
        k r102 = this.webService;
        if (r102 == null) goto L5;
        r102.u(r100, r101);
        return;
    L5:
        tt5.a.e(TAG, "", new IllegalStateException("execJS while web null!"), false);
    }

    public void onAttachToUI(FragmentActivity r100, k r101) {
        this.webService = r101;
        this.editPanelsManager = (EditPanelsManager) ViewModelProviders.of(r100).get(EditPanelsManager.class);
    }

    @Override // ocb.a
    public void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        onKeyboardStateChanged(r101);
    }
}
