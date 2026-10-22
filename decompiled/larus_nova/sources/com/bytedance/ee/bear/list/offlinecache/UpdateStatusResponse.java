package com.bytedance.ee.bear.list.offlinecache;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003JE\u0010\u0010\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/list/offlinecache/UpdateStatusResponse;", "Ljava/io/Serializable;", "processedObjList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/list/offlinecache/UpdateStatusRequest;", "Lkotlin/collections/ArrayList;", "failedObjList", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getProcessedObjList", "()Ljava/util/ArrayList;", "getFailedObjList", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateStatusResponse implements Serializable {

    @SerializedName("failed_obj_list")
    private final ArrayList<UpdateStatusRequest> failedObjList;

    @SerializedName("processed_obj_list")
    private final ArrayList<UpdateStatusRequest> processedObjList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateStatusResponse copy$default(UpdateStatusResponse r100, ArrayList r101, ArrayList r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.processedObjList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.failedObjList;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<UpdateStatusRequest> component1() {
        return this.processedObjList;
    }

    public final ArrayList<UpdateStatusRequest> component2() {
        return this.failedObjList;
    }

    public final UpdateStatusResponse copy(ArrayList<UpdateStatusRequest> r100, ArrayList<UpdateStatusRequest> r101) {
        return new UpdateStatusResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateStatusResponse) == true) goto L8;
        return false;
    L8:
        UpdateStatusResponse r101 = (UpdateStatusResponse) r100;
        if (Intrinsics.areEqual(this.processedObjList, r101.processedObjList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.failedObjList, r101.failedObjList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ArrayList<UpdateStatusRequest> r100 = this.processedObjList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ArrayList<UpdateStatusRequest> r104 = this.failedObjList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UpdateStatusResponse(processedObjList=" + this.processedObjList + ", failedObjList=" + this.failedObjList + ')';
    }

    public final ArrayList<UpdateStatusRequest> getFailedObjList() {
        return this.failedObjList;
    }

    public final ArrayList<UpdateStatusRequest> getProcessedObjList() {
        return this.processedObjList;
    }

    public UpdateStatusResponse(ArrayList<UpdateStatusRequest> r100, ArrayList<UpdateStatusRequest> r101) {
        this.processedObjList = r100;
        this.failedObjList = r101;
    }
}
