package com.bytedance.ee.bear.drive.view.preview.wps;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WpsViewModel extends ViewModel {
    private MutableLiveData<String> editLimitOverLiveData;
    private MutableLiveData<String> errorLiveData;
    private MutableLiveData<String> preloadLoadEndLiveData;
    private MutableLiveData<String> preloadStartLiveData;
    private MutableLiveData<String> successLiveData;
    private MutableLiveData<Boolean> wpsApplicationReadyLiveData;

    public WpsViewModel() {
        this.errorLiveData = new MutableLiveData();
        this.successLiveData = new MutableLiveData();
        this.wpsApplicationReadyLiveData = new MutableLiveData();
        this.preloadLoadEndLiveData = new MutableLiveData();
        this.preloadStartLiveData = new MutableLiveData();
        this.editLimitOverLiveData = new MutableLiveData();
    }

    public MutableLiveData<String> getEditLimitOverLiveData() {
        return this.editLimitOverLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return this.errorLiveData;
    }

    public MutableLiveData<String> getPreloadLoadEndLiveData() {
        return this.preloadLoadEndLiveData;
    }

    public MutableLiveData<String> getPreloadStartLiveData() {
        return this.preloadStartLiveData;
    }

    public MutableLiveData<String> getSuccessLiveData() {
        return this.successLiveData;
    }

    public MutableLiveData<Boolean> getWpsApplicationReadyLiveData() {
        return this.wpsApplicationReadyLiveData;
    }
}
