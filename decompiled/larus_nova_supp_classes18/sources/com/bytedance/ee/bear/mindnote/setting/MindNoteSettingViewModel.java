package com.bytedance.ee.bear.mindnote.setting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setData(MindNoteSettingData r2) {
        this.mData.setValue(r2);
    }

    public void setDelegate(a r1) {
        this.mDelegate = r1;
    }

    public void processOnClick(String r2, String r3) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        MindNoteSettingPlugin.c(((c) r0).a, r2, r3);
        return;
    }
}
