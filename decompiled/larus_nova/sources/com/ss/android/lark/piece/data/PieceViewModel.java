package com.ss.android.lark.piece.data;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015J\u001e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015J\b\u0010\u001b\u001a\u00020\u0017H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00150\u00140\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/piece/data/PieceViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "sharedData", "Lcom/ss/android/lark/piece/data/SharedData;", "getSharedData", "()Lcom/ss/android/lark/piece/data/SharedData;", "setSharedData", "(Lcom/ss/android/lark/piece/data/SharedData;)V", "pieceContext", "Lcom/ss/android/lark/piece/core/PieceContext;", "getPieceContext", "()Lcom/ss/android/lark/piece/core/PieceContext;", "setPieceContext", "(Lcom/ss/android/lark/piece/core/PieceContext;)V", "dataObserverMap", "Lkotlin/Lazy;", "", "", "", "Lcom/ss/android/lark/piece/data/DataObserver;", "observeSharedData", "", "key", "observer", "unObserveSharedData", "onCleared", "piece_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PieceViewModel extends ViewModel {
    private final Lazy<Map<Object, List<a<? extends Object>>>> dataObserverMap;
    private com.ss.android.lark.piece.core.a pieceContext;
    public b sharedData;

    public final void setSharedData(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
    }

    public final b getSharedData() {
        Intrinsics.throwUninitializedPropertyAccessException("sharedData");
        return null;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        if (this.dataObserverMap.isInitialized() == false) goto L13;
        Iterator<Map.Entry<Object, List<a<? extends Object>>>> r100 = this.dataObserverMap.getValue().entrySet().iterator();
    L6:
        if (r100.hasNext() == false) goto L12;
        Map.Entry<Object, List<a<? extends Object>>> r101 = r100.next();
        r101.getKey();
        Iterator<a<? extends Object>> r102 = r101.getValue().iterator();
        if (r102.hasNext() == false) goto L6;
        a<? extends Object> r103 = r102.next();
        getSharedData();
        throw null;
    L12:
        this.dataObserverMap.getValue().clear();
    L13:
        super.onCleared();
    }

    public PieceViewModel() {
        this.dataObserverMap = LazyKt.lazy(PieceViewModel$dataObserverMap$1.INSTANCE);
    }

    public final com.ss.android.lark.piece.core.a getPieceContext() {
        return this.pieceContext;
    }

    public final void setPieceContext(com.ss.android.lark.piece.core.a r100) {
        this.pieceContext = r100;
    }

    public final void observeSharedData(Object r100, a<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "observer");
        List<a<? extends Object>> r102 = this.dataObserverMap.getValue().get(r100);
        if (r102 != null) goto L5;
    L7:
        if (r102 != null) goto L9;
        r102 = new ArrayList();
        this.dataObserverMap.getValue().put(r100, r102);
    L9:
        r102.add(r101);
        getSharedData();
        throw null;
    L5:
        if (r102.contains(r101) == false) goto L7;
    }

    public final void unObserveSharedData(Object r100, a<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "observer");
        getSharedData();
        throw null;
    }
}
