package com.ss.android.lark.chameleonv2.lkapi.storage;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$GetItemsResponse;", "Lcom/bytedance/ee/util/io/NonProguard;", "pairs", "", "Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$KeyValue;", "storageResult", "Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageResult;", "<init>", "(Ljava/util/List;Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageResult;)V", "getPairs", "()Ljava/util/List;", "getStorageResult", "()Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IStorage$Internal$GetItemsResponse implements NonProguard {
    private final List<IStorage$Internal$KeyValue> pairs;
    private final IStorage$Internal$StorageResult storageResult;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IStorage$Internal$GetItemsResponse copy$default(IStorage$Internal$GetItemsResponse r100, List r101, IStorage$Internal$StorageResult r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.pairs;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.storageResult;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<IStorage$Internal$KeyValue> component1() {
        return this.pairs;
    }

    public final IStorage$Internal$StorageResult component2() {
        return this.storageResult;
    }

    public final IStorage$Internal$GetItemsResponse copy(List<IStorage$Internal$KeyValue> r100, IStorage$Internal$StorageResult r101) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        Intrinsics.checkNotNullParameter(r101, "storageResult");
        return new IStorage$Internal$GetItemsResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IStorage$Internal$GetItemsResponse) == true) goto L8;
        return false;
    L8:
        IStorage$Internal$GetItemsResponse r101 = (IStorage$Internal$GetItemsResponse) r100;
        if (Intrinsics.areEqual(this.pairs, r101.pairs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.storageResult, r101.storageResult) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.pairs.hashCode() * 31) + this.storageResult.hashCode();
    }

    public String toString() {
        return "GetItemsResponse(pairs=" + this.pairs + ", storageResult=" + this.storageResult + ')';
    }

    public final List<IStorage$Internal$KeyValue> getPairs() {
        return this.pairs;
    }

    public final IStorage$Internal$StorageResult getStorageResult() {
        return this.storageResult;
    }

    public IStorage$Internal$GetItemsResponse(List<IStorage$Internal$KeyValue> r100, IStorage$Internal$StorageResult r101) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        Intrinsics.checkNotNullParameter(r101, "storageResult");
        this.pairs = r100;
        this.storageResult = r101;
    }
}
