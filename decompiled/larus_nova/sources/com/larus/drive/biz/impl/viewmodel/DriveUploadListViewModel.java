package com.larus.drive.biz.impl.viewmodel;

import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapController;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/larus/drive/biz/impl/viewmodel/DriveUploadListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "removeUploadItem", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/drive/biz/api/model/DriveUploadItem;", "retryUploadItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveUploadListViewModel extends ViewModel {
    public DriveUploadListViewModel() {
    }

    public final void removeUploadItem(com.larus.drive.biz.api.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Lazy r101 = com.larus.drive.biz.impl.file.t.f341214a;
        com.larus.drive.biz.impl.file.t.k(r100, true);
    }

    public final void retryUploadItem(com.larus.drive.biz.api.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Lazy r101 = com.larus.drive.biz.impl.file.t.f341214a;
        com.larus.drive.biz.impl.file.t.j(r100, false);
    }
}
