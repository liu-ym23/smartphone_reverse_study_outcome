package com.bytedance.ee.bear.atfinder;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ln4.j;

/* JADX INFO: loaded from: classes15.dex */
public class AtCheckBoxViewModel extends ViewModel {
    private boolean isCheckboxSelected;
    private final MutableLiveData<j> usePanelCheckBoxData;

    public AtCheckBoxViewModel() {
        this.usePanelCheckBoxData = new MutableLiveData();
    }

    public MutableLiveData<j> getUserPanelCheckBoxData() {
        return this.usePanelCheckBoxData;
    }

    public boolean isCheckboxSelected() {
        return this.isCheckboxSelected;
    }

    public void setCheckboxSelected(boolean r100) {
        this.isCheckboxSelected = r100;
    }
}
