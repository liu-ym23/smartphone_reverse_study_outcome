package com.ss.android.lark.chameleonv2.lkapi.storage;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$ItemsRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "keys", "", "", "storageId", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getKeys", "()Ljava/util/List;", "getStorageId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IStorage$Internal$ItemsRequest implements NonProguard {
    private final List<String> keys;
    private final String storageId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IStorage$Internal$ItemsRequest copy$default(IStorage$Internal$ItemsRequest r100, List r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.keys;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.storageId;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.keys;
    }

    public final String component2() {
        return this.storageId;
    }

    public final IStorage$Internal$ItemsRequest copy(List<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Intrinsics.checkNotNullParameter(r101, "storageId");
        return new IStorage$Internal$ItemsRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IStorage$Internal$ItemsRequest) == true) goto L8;
        return false;
    L8:
        IStorage$Internal$ItemsRequest r101 = (IStorage$Internal$ItemsRequest) r100;
        if (Intrinsics.areEqual(this.keys, r101.keys) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.storageId, r101.storageId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.keys.hashCode() * 31) + this.storageId.hashCode();
    }

    public String toString() {
        return "ItemsRequest(keys=" + this.keys + ", storageId=" + this.storageId + ')';
    }

    public final List<String> getKeys() {
        return this.keys;
    }

    public final String getStorageId() {
        return this.storageId;
    }

    public IStorage$Internal$ItemsRequest(List<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Intrinsics.checkNotNullParameter(r101, "storageId");
        this.keys = r100;
        this.storageId = r101;
    }
}
