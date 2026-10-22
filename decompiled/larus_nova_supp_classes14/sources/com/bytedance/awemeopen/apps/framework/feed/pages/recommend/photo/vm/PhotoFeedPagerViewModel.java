package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vm;

import androidx.lifecycle.LiveData;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/vm/PhotoFeedPagerViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "()V", "_cancelLoop", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "", "_currentPhotoPosition", "", "_previewSelectedPhotoPosition", "cancelLoop", "Landroidx/lifecycle/LiveData;", "getCancelLoop", "()Landroidx/lifecycle/LiveData;", "currentPhotoPosition", "getCurrentPhotoPosition", "isInPhotoPreview", "previewSelectedPhotoPosition", "getPreviewSelectedPhotoPosition", "", "reset", "setInPhotoPreView", "inPhotoPreView", "updateCurrentPosition", "position", "updatePreviewPhotoPosition", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoFeedPagerViewModel extends AosViewModel {
    private DiscardFirstValueLiveData<Boolean> _cancelLoop;
    private DiscardFirstValueLiveData<Integer> _currentPhotoPosition;
    private DiscardFirstValueLiveData<Integer> _previewSelectedPhotoPosition;
    private final LiveData<Boolean> cancelLoop;
    private final LiveData<Integer> currentPhotoPosition;
    private boolean isInPhotoPreview;
    private final LiveData<Integer> previewSelectedPhotoPosition;

    public final void reset() {
        this._cancelLoop.setValue(Boolean.FALSE);
        this._previewSelectedPhotoPosition.setValue(0);
    }

    public PhotoFeedPagerViewModel() {
        DiscardFirstValueLiveData<Boolean> r0 = new DiscardFirstValueLiveData();
        this._cancelLoop = r0;
        this.cancelLoop = r0;
        DiscardFirstValueLiveData<Integer> r1 = new DiscardFirstValueLiveData();
        this._previewSelectedPhotoPosition = r1;
        this.previewSelectedPhotoPosition = r1;
        DiscardFirstValueLiveData<Integer> r2 = new DiscardFirstValueLiveData();
        this._currentPhotoPosition = r2;
        this.currentPhotoPosition = r2;
    }

    public final LiveData<Boolean> getCancelLoop() {
        return this.cancelLoop;
    }

    public final LiveData<Integer> getCurrentPhotoPosition() {
        return this.currentPhotoPosition;
    }

    public final LiveData<Integer> getPreviewSelectedPhotoPosition() {
        return this.previewSelectedPhotoPosition;
    }

    public final boolean isInPhotoPreview() {
        return this.isInPhotoPreview;
    }

    public final void cancelLoop(boolean r2) {
        this._cancelLoop.setValue(Boolean.valueOf(r2));
    }

    public final void setInPhotoPreView(boolean r1) {
        this.isInPhotoPreview = r1;
    }

    public final void updateCurrentPosition(int r2) {
        this._currentPhotoPosition.setValue(Integer.valueOf(r2));
    }

    public final void updatePreviewPhotoPosition(int r2) {
        this._previewSelectedPhotoPosition.setValue(Integer.valueOf(r2));
    }
}
