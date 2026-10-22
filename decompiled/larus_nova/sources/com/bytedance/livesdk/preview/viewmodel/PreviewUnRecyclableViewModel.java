package com.bytedance.livesdk.preview.viewmodel;

import android.util.SparseArray;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/livesdk/preview/viewmodel/PreviewUnRecyclableViewModel;", "Landroidx/lifecycle/ViewModel;", "", "hashCode", "Lcom/bytedance/livesdk/preview/viewmodel/c;", "previewUnRecyclableData", "initPreviewData", "Landroid/util/SparseArray;", "dataCache", "Landroid/util/SparseArray;", "getDataCache", "()Landroid/util/SparseArray;", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewUnRecyclableViewModel extends ViewModel {
    private final SparseArray<c> dataCache;

    public PreviewUnRecyclableViewModel() {
        this.dataCache = new SparseArray();
    }

    public final SparseArray<c> getDataCache() {
        return this.dataCache;
    }

    public final c initPreviewData(int r100, c r101) {
        Intrinsics.checkNotNullParameter(r101, "previewUnRecyclableData");
        if (this.dataCache.get(r100) != null) goto L5;
        this.dataCache.put(r100, r101);
        return r101;
    L5:
        return this.dataCache.get(r100);
    }
}
