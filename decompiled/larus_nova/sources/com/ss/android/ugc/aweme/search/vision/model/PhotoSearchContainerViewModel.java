package com.ss.android.ugc.aweme.search.vision.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\bR\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/PhotoSearchContainerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_pageState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/ugc/aweme/search/vision/model/PageState;", "kotlin.jvm.PlatformType", "_slideOffset", "", "pageState", "Landroidx/lifecycle/LiveData;", "getPageState", "()Landroidx/lifecycle/LiveData;", "slideOffset", "getSlideOffset", "isDefault", "", "setPageState", "", "state", "updateOffset", "offset", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchContainerViewModel extends ViewModel {
    private final MutableLiveData<PageState> _pageState;
    private final MutableLiveData<Float> _slideOffset;
    private final LiveData<PageState> pageState;
    private final LiveData<Float> slideOffset;

    public final boolean isDefault() {
        if (this._pageState.getValue() != PageState.DEFAULT) goto L5;
        return true;
    L5:
        return false;
    }

    public PhotoSearchContainerViewModel() {
        MutableLiveData<PageState> r100 = new MutableLiveData(PageState.DEFAULT);
        this._pageState = r100;
        this.pageState = r100;
        MutableLiveData<Float> r101 = new MutableLiveData();
        this._slideOffset = r101;
        this.slideOffset = r101;
    }

    public final LiveData<PageState> getPageState() {
        return this.pageState;
    }

    public final LiveData<Float> getSlideOffset() {
        return this.slideOffset;
    }

    public final void setPageState(PageState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this._pageState.setValue(r100);
    }

    public final void updateOffset(float r100) {
        this._slideOffset.setValue(Float.valueOf(r100));
    }
}
