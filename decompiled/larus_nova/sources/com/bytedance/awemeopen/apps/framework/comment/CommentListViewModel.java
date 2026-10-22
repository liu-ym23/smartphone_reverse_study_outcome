package com.bytedance.awemeopen.apps.framework.comment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBottomSheetViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/CommentListViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/AosBottomSheetViewModel;", "()V", "_pageParam", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;", "pageParam", "Landroidx/lifecycle/LiveData;", "getPageParam", "()Landroidx/lifecycle/LiveData;", "setPageParam", "(Landroidx/lifecycle/LiveData;)V", "updatePageParam", "", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommentListViewModel extends AosBottomSheetViewModel {
    private MutableLiveData<CommentPageParam> _pageParam;
    private LiveData<CommentPageParam> pageParam;

    public CommentListViewModel() {
        MutableLiveData<CommentPageParam> r100 = new MutableLiveData();
        this._pageParam = r100;
        this.pageParam = r100;
    }

    public final LiveData<CommentPageParam> getPageParam() {
        return this.pageParam;
    }

    public final void setPageParam(LiveData<CommentPageParam> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageParam = r100;
    }

    public final void updatePageParam(CommentPageParam r100) {
        Intrinsics.checkNotNullParameter(r100, "pageParam");
        this._pageParam.setValue(r100);
    }
}
