package com.kunminx.architecture.ui.callback;

/* JADX INFO: loaded from: classes23.dex */
public class UnPeekLiveData<T> extends ProtectedUnPeekLiveData<T> {
    public UnPeekLiveData() {
    }

    @Override // androidx.lifecycle.LiveData
    public final void postValue(T r100) {
        super.postValue(r100);
    }

    @Override // com.kunminx.architecture.ui.callback.ProtectedUnPeekLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        super.setValue(r100);
    }
}
