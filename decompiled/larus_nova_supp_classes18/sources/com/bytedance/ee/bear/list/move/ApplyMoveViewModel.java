package com.bytedance.ee.bear.list.move;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ApplyMoveViewModel extends ViewModel {
    public static final int STATE_APPLY_FAILED = 2;
    public static final int STATE_APPLY_SUCCESS = 1;
    private final MutableLiveData<b> applyState;

    public ApplyMoveViewModel() {
        this.applyState = new MutableLiveData();
    }

    public LiveData<b> getApplyState() {
        return this.applyState;
    }

    public void setState(b r2) {
        this.applyState.setValue(r2);
    }
}
