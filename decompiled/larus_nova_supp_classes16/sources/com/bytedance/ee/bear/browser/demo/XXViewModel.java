package com.bytedance.ee.bear.browser.demo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class XXViewModel extends ViewModel {
    private MutableLiveData<WebData> webData;

    public XXViewModel() {
        this.webData = new MutableLiveData();
    }

    public LiveData<WebData> getWebData() {
        return this.webData;
    }

    public void updateWebData(WebData r2) {
        this.webData.setValue(r2);
    }
}
