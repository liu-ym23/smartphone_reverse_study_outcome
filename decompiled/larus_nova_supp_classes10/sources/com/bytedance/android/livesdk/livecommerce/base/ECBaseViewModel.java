package com.bytedance.android.livesdk.livecommerce.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.livecommerce.network.ECLoadingStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECBaseViewModel extends ViewModel {
    private boolean isOnClear;
    private MutableLiveData<ECLoadingStatus> mCurrentTabLoadingData;
    private MutableLiveData<String> mFailedIconToast;
    private MutableLiveData<Void> mFinishActivity;
    private MutableLiveData<Void> mLoadingData;
    private MutableLiveData<Void> mLoadingErrorData;
    private MutableLiveData<Void> mLoadingFinishData;
    private MutableLiveData<String> mPermissionDeniedData;
    private MutableLiveData<String> mSuccessIconToast;
    private MutableLiveData<Integer> mToastInt;
    private MutableLiveData<String> mToastString;

    public final Integer[] params(Integer... r1) {
        return r1;
    }

    public final Object[] params(Object... r1) {
        return r1;
    }

    public final String[] params(String... r1) {
        return r1;
    }

    public final MutableLiveData<ECLoadingStatus> getCurrentTabLoadingData() {
        if (this.mCurrentTabLoadingData != null) goto L6;
        this.mCurrentTabLoadingData = new MutableLiveData();
    L6:
        return this.mCurrentTabLoadingData;
    }

    public final MutableLiveData<String> getFailedIconToast() {
        if (this.mFailedIconToast != null) goto L6;
        this.mFailedIconToast = new MutableLiveData();
    L6:
        return this.mFailedIconToast;
    }

    public final MutableLiveData<Void> getFinishActivity() {
        if (this.mFinishActivity != null) goto L6;
        this.mFinishActivity = new MutableLiveData();
    L6:
        return this.mFinishActivity;
    }

    public final MutableLiveData<Void> getLoadingData() {
        if (this.mLoadingData != null) goto L6;
        this.mLoadingData = new MutableLiveData();
    L6:
        return this.mLoadingData;
    }

    public final MutableLiveData<Void> getLoadingErrorData() {
        if (this.mLoadingErrorData != null) goto L6;
        this.mLoadingErrorData = new MutableLiveData();
    L6:
        return this.mLoadingErrorData;
    }

    public final MutableLiveData<Void> getLoadingFinishData() {
        if (this.mLoadingFinishData != null) goto L6;
        this.mLoadingFinishData = new MutableLiveData();
    L6:
        return this.mLoadingFinishData;
    }

    public final MutableLiveData<String> getPermissionDeniedData() {
        if (this.mPermissionDeniedData != null) goto L6;
        this.mPermissionDeniedData = new MutableLiveData();
    L6:
        return this.mPermissionDeniedData;
    }

    public final MutableLiveData<String> getSuccessIconToast() {
        if (this.mSuccessIconToast != null) goto L6;
        this.mSuccessIconToast = new MutableLiveData();
    L6:
        return this.mSuccessIconToast;
    }

    public final MutableLiveData<Integer> getToastInt() {
        if (this.mToastInt != null) goto L6;
        this.mToastInt = new MutableLiveData();
    L6:
        return this.mToastInt;
    }

    public final MutableLiveData<String> getToastString() {
        if (this.mToastString != null) goto L6;
        this.mToastString = new MutableLiveData();
    L6:
        return this.mToastString;
    }

    public ECBaseViewModel() {
        this.isOnClear = false;
    }

    public final void finishActivity() {
        getFinishActivity().postValue(null);
    }

    public void onCleared() {
        super.onCleared();
        this.isOnClear = true;
    }

    public boolean isOnClear() {
        return this.isOnClear;
    }

    public final void toast(int r2) {
        getToastInt().postValue(Integer.valueOf(r2));
    }

    public final void toast(String r2) {
        getToastString().postValue(r2);
    }
}
