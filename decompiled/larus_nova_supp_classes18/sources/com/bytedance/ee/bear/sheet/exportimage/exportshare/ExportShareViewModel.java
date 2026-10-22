package com.bytedance.ee.bear.sheet.exportimage.exportshare;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel;
import tm5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ExportShareViewModel extends BaseExportViewModel<b> {
    private MutableLiveData<Boolean> active;
    private b exportShareDelegate;
    private MutableLiveData<String[]> shareItems;

    public void onCancel() {
        b r0 = this.exportShareDelegate;
        if (r0 == null) goto L5;
        r0.i("close");
    L5:
        setActiveValue(false);
    }

    public ExportShareViewModel() {
        this.active = new MutableLiveData();
        this.shareItems = new MutableLiveData();
    }

    public LiveData<Boolean> getActive() {
        return this.active;
    }

    public MutableLiveData<String[]> getShareItems() {
        return this.shareItems;
    }

    public void onClickItem(String r2) {
        b r0 = this.exportShareDelegate;
        if (r0 == null) goto L5;
        r0.i(r2);
    L5:
        setActiveValue(false);
    }

    public void setActiveValue(boolean r2) {
        this.active.setValue(Boolean.valueOf(r2));
    }

    public void setExportShareDelegate(b r1) {
        this.exportShareDelegate = r1;
    }

    public void setShareItems(String[] r2) {
        this.shareItems.setValue(r2);
    }
}
