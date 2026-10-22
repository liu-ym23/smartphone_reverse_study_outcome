package com.bytedance.ee.bear.document.synced.block.references.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/main/SyncedSourceRefVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveItemClick", "Landroidx/lifecycle/MutableLiveData;", "", "getLiveItemClick", "()Landroidx/lifecycle/MutableLiveData;", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncedSourceRefVM extends ViewModel {
    private final MutableLiveData<String> liveItemClick;

    public SyncedSourceRefVM() {
        this.liveItemClick = new MutableLiveData();
    }

    public final MutableLiveData<String> getLiveItemClick() {
        return this.liveItemClick;
    }
}
