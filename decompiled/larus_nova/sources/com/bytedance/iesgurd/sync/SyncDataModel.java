package com.bytedance.iesgurd.sync;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncDataModel;", "", "checkUpdateInfo", "Lcom/bytedance/iesgurd/sync/SyncUpdateModel;", "cleanInfo", "", "", "Lcom/bytedance/iesgurd/sync/SyncCleanModel;", "(Lcom/bytedance/iesgurd/sync/SyncUpdateModel;Ljava/util/Map;)V", "getCheckUpdateInfo", "()Lcom/bytedance/iesgurd/sync/SyncUpdateModel;", "getCleanInfo", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class SyncDataModel {

    @SerializedName("check_update_info")
    private final SyncUpdateModel checkUpdateInfo;

    @SerializedName("clean_info")
    private final Map<String, SyncCleanModel> cleanInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncDataModel copy$default(SyncDataModel r100, SyncUpdateModel r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.checkUpdateInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.cleanInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final SyncUpdateModel component1() {
        return this.checkUpdateInfo;
    }

    public final Map<String, SyncCleanModel> component2() {
        return this.cleanInfo;
    }

    public final SyncDataModel copy(SyncUpdateModel r100, Map<String, SyncCleanModel> r101) {
        return new SyncDataModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SyncDataModel) == false) goto L10;
        SyncDataModel r101 = (SyncDataModel) r100;
        if (Intrinsics.areEqual(this.checkUpdateInfo, r101.checkUpdateInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cleanInfo, r101.cleanInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        SyncUpdateModel r100 = this.checkUpdateInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, SyncCleanModel> r104 = this.cleanInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SyncDataModel(checkUpdateInfo=" + this.checkUpdateInfo + ", cleanInfo=" + this.cleanInfo + ")";
    }

    public final SyncUpdateModel getCheckUpdateInfo() {
        return this.checkUpdateInfo;
    }

    public final Map<String, SyncCleanModel> getCleanInfo() {
        return this.cleanInfo;
    }

    public SyncDataModel(SyncUpdateModel r100, Map<String, SyncCleanModel> r101) {
        this.checkUpdateInfo = r100;
        this.cleanInfo = r101;
    }
}
