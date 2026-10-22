package androidx.camera.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ForwardingLiveData<T> extends MediatorLiveData<T> {
    private LiveData<T> mLiveDataSource;

    public T getValue() {
        LiveData<T> r0 = this.mLiveDataSource;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (T) r0.getValue();
    }

    public ForwardingLiveData() {
    }

    public void setSource(LiveData<T> r2) {
        LiveData<T> r0 = this.mLiveDataSource;
        if (r0 == null) goto L5;
        super.removeSource(r0);
    L5:
        this.mLiveDataSource = r2;
        super.addSource(r2, new j(this));
    }
}
