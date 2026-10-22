package com.bytedance.ee.bear.list.offlinecache;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003JE\u0010\u0010\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/list/offlinecache/UpdateStatusResponse;", "Ljava/io/Serializable;", "processedObjList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/list/offlinecache/UpdateStatusRequest;", "Lkotlin/collections/ArrayList;", "failedObjList", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getProcessedObjList", "()Ljava/util/ArrayList;", "getFailedObjList", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateStatusResponse implements Serializable {

    @SerializedName("failed_obj_list")
    private final ArrayList<UpdateStatusRequest> failedObjList;

    @SerializedName("processed_obj_list")
    private final ArrayList<UpdateStatusRequest> processedObjList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateStatusResponse copy$default(UpdateStatusResponse r0, ArrayList r1, ArrayList r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.processedObjList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.failedObjList;
    L9:
        return r0.copy(r1, r2);
    }

    public final ArrayList<UpdateStatusRequest> component1() {
        return this.processedObjList;
    }

    public final ArrayList<UpdateStatusRequest> component2() {
        return this.failedObjList;
    }

    public final UpdateStatusResponse copy(ArrayList<UpdateStatusRequest> r2, ArrayList<UpdateStatusRequest> r3) {
        return new UpdateStatusResponse(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UpdateStatusResponse) == true) goto L8;
        return false;
    L8:
        UpdateStatusResponse r6 = (UpdateStatusResponse) r5;
        if (Intrinsics.areEqual(this.processedObjList, r6.processedObjList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.failedObjList, r6.failedObjList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ArrayList<UpdateStatusRequest> r0 = this.processedObjList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ArrayList<UpdateStatusRequest> r4 = this.failedObjList;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
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

    public UpdateStatusResponse(ArrayList<UpdateStatusRequest> r1, ArrayList<UpdateStatusRequest> r2) {
        this.processedObjList = r1;
        this.failedObjList = r2;
    }
}
