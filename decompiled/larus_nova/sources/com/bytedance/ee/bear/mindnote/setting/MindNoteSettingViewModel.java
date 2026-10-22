package com.bytedance.ee.bear.mindnote.setting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: classes18.dex */
public class MindNoteSettingViewModel extends ViewModel {
    private MutableLiveData<MindNoteSettingData> mData;
    private a mDelegate;

    public interface a {
    }

    public MindNoteSettingViewModel() {
        this.mData = new MutableLiveData();
    }

    public LiveData<MindNoteSettingData> getData() {
        return this.mData;
    }

    public void setData(MindNoteSettingData r100) {
        this.mData.setValue(r100);
    }

    public void setDelegate(a r100) {
        this.mDelegate = r100;
    }

    public void processOnClick(String r100, String r101) {
        a r102 = this.mDelegate;
        if (r102 == null) goto L6;
        MindNoteSettingPlugin.c(((c) r102).f234465a, r100, r101);
        return;
    }
}
