package com.larus.camera.impl.starter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larus.camera.api.params.CameraOutputContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0018R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/camera/impl/starter/StarterViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "resultLiveEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/camera/api/params/CameraOutputContext;", "getResultLiveEvent", "()Landroidx/lifecycle/MutableLiveData;", "sendCompletedLiveEvent", "", "getSendCompletedLiveEvent", "lastConsumedResult", "sendCompletedGeneration", "lastConsumedSendCompletedGeneration", "markResultConsumed", "", "outputContext", "markResultConsumed$impl_mainlandRelease", "publishSendCompleted", "", "publishSendCompleted$impl_mainlandRelease", "markSendCompletedConsumed", "generation", "markSendCompletedConsumed$impl_mainlandRelease", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StarterViewModel extends ViewModel {
    private CameraOutputContext lastConsumedResult;
    private int lastConsumedSendCompletedGeneration;
    private final MutableLiveData<CameraOutputContext> resultLiveEvent;
    private int sendCompletedGeneration;
    private final MutableLiveData<Integer> sendCompletedLiveEvent;

    public final void publishSendCompleted$impl_mainlandRelease() {
        int r100 = this.sendCompletedGeneration + 1;
        this.sendCompletedGeneration = r100;
        this.sendCompletedLiveEvent.setValue(Integer.valueOf(r100));
    }

    public StarterViewModel() {
        this.resultLiveEvent = new MutableLiveData();
        this.sendCompletedLiveEvent = new MutableLiveData();
    }

    public final MutableLiveData<CameraOutputContext> getResultLiveEvent() {
        return this.resultLiveEvent;
    }

    public final MutableLiveData<Integer> getSendCompletedLiveEvent() {
        return this.sendCompletedLiveEvent;
    }

    public final boolean markResultConsumed$impl_mainlandRelease(CameraOutputContext r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (this.lastConsumedResult != r100) goto L9;
        return false;
    L9:
        this.lastConsumedResult = r100;
        return true;
    }

    public final boolean markSendCompletedConsumed$impl_mainlandRelease(int r100) {
        if (r100 > this.lastConsumedSendCompletedGeneration) goto L6;
        return false;
    L6:
        this.lastConsumedSendCompletedGeneration = r100;
        return true;
    }
}
