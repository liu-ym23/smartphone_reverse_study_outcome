package com.bytedance.ee.bear.sheet.exportimage.exportshare;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel;
import tm5.b;

/* JADX INFO: loaded from: classes18.dex */
public class ExportShareViewModel extends BaseExportViewModel<b> {
    private MutableLiveData<Boolean> active;
    private b exportShareDelegate;
    private MutableLiveData<String[]> shareItems;

    public void onCancel() {
        b r100 = this.exportShareDelegate;
        if (r100 == null) goto L5;
        r100.i("close");
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

    public void onClickItem(String r100) {
        b r101 = this.exportShareDelegate;
        if (r101 == null) goto L5;
        r101.i(r100);
    L5:
        setActiveValue(false);
    }

    public void setActiveValue(boolean r100) {
        this.active.setValue(Boolean.valueOf(r100));
    }

    public void setExportShareDelegate(b r100) {
        this.exportShareDelegate = r100;
    }

    public void setShareItems(String[] r100) {
        this.shareItems.setValue(r100);
    }
}
