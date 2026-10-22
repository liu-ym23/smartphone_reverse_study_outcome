package com.ss.android.ugc.aweme.search.common.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.search.common.base.ECSearchBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/viewmodel/ECSearchNonFullViewModel;", "Lcom/ss/android/ugc/aweme/search/common/base/ECSearchBaseViewModel;", "()V", "fullStatus", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/ugc/aweme/search/common/viewmodel/Status;", "kotlin.jvm.PlatformType", "getStatus", "updateStatus", "", "status", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchNonFullViewModel extends ECSearchBaseViewModel {
    private MutableLiveData<Status> fullStatus;

    public ECSearchNonFullViewModel() {
        super(null, 1, null);
        this.fullStatus = new MutableLiveData(Status.COLLAPSED);
    }

    public final Status getStatus() {
        return this.fullStatus.getValue();
    }

    public final void updateStatus(Status r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        this.fullStatus.setValue(r100);
    }
}
