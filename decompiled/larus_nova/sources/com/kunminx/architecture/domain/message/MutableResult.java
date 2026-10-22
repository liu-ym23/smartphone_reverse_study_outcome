package com.kunminx.architecture.domain.message;

/* JADX INFO: loaded from: classes23.dex */
public class MutableResult<T> extends Result<T> {
    public MutableResult() {
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
