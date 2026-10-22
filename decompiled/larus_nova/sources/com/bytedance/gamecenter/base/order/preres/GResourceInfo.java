package com.bytedance.gamecenter.base.order.preres;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003Jb\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0(J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u000bHÖ\u0001R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019¨\u0006+"}, d2 = {"Lcom/bytedance/gamecenter/base/order/preres/GResourceInfo;", "", "resourceStatus", "", "resourceType", "resourceOnlineTime", "", "downloadList", "", "Lcom/bytedance/gamecenter/base/order/preres/GResourceDownloadInfo;", "path", "", "otherPathList", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getDownloadList", "()Ljava/util/List;", "getOtherPathList", "getPath", "()Ljava/lang/String;", "getResourceOnlineTime", "()Ljava/lang/Long;", "setResourceOnlineTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getResourceStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResourceType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Lcom/bytedance/gamecenter/base/order/preres/GResourceInfo;", "equals", "", "other", "getMd5List", "", "hashCode", "toString", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final class GResourceInfo {

    @SerializedName("download_list")
    private final List<GResourceDownloadInfo> downloadList;

    @SerializedName("other_path_list")
    private final List<String> otherPathList;

    @SerializedName("path")
    private final String path;

    @SerializedName("resource_online_time")
    private Long resourceOnlineTime;

    @SerializedName("resource_status")
    private final Integer resourceStatus;

    @SerializedName("resource_type")
    private final Integer resourceType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GResourceInfo copy$default(GResourceInfo r100, Integer r101, Integer r102, Long r103, List r104, String r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.resourceStatus;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.resourceType;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.resourceOnlineTime;
    L11:
        Long r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.downloadList;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.path;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.otherPathList;
    L20:
        Integer r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Integer component1() {
        return this.resourceStatus;
    }

    public final Integer component2() {
        return this.resourceType;
    }

    public final Long component3() {
        return this.resourceOnlineTime;
    }

    public final List<GResourceDownloadInfo> component4() {
        return this.downloadList;
    }

    public final String component5() {
        return this.path;
    }

    public final List<String> component6() {
        return this.otherPathList;
    }

    public final GResourceInfo copy(Integer r100, Integer r110, Long r111, List<GResourceDownloadInfo> r112, String r113, List<String> r114) {
        return new GResourceInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GResourceInfo) == false) goto L18;
        GResourceInfo r101 = (GResourceInfo) r100;
        if (Intrinsics.areEqual(this.resourceStatus, r101.resourceStatus) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.resourceType, r101.resourceType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.resourceOnlineTime, r101.resourceOnlineTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downloadList, r101.downloadList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.otherPathList, r101.otherPathList) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.resourceStatus;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.resourceType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.resourceOnlineTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<GResourceDownloadInfo> r110 = this.downloadList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.path;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.otherPathList;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "GResourceInfo(resourceStatus=" + this.resourceStatus + ", resourceType=" + this.resourceType + ", resourceOnlineTime=" + this.resourceOnlineTime + ", downloadList=" + this.downloadList + ", path=" + this.path + ", otherPathList=" + this.otherPathList + ")";
    }

    public final List<String> getMd5List() {
        ArrayList r100 = new ArrayList();
        List<GResourceDownloadInfo> r101 = this.downloadList;
        if (r101 == null) goto L16;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        GResourceDownloadInfo r103 = (GResourceDownloadInfo) r102.next();
        String r104 = r103.getMd5();
        if (r104 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L6;
        r100.add(r103.getMd5());
        goto L6
    L10:
        if (r104.length() == 0) goto L13;
        r105 = false;
    L16:
        return r100;
    }

    public final List<GResourceDownloadInfo> getDownloadList() {
        return this.downloadList;
    }

    public final List<String> getOtherPathList() {
        return this.otherPathList;
    }

    public final String getPath() {
        return this.path;
    }

    public final Long getResourceOnlineTime() {
        return this.resourceOnlineTime;
    }

    public final Integer getResourceStatus() {
        return this.resourceStatus;
    }

    public final Integer getResourceType() {
        return this.resourceType;
    }

    public final void setResourceOnlineTime(Long r100) {
        this.resourceOnlineTime = r100;
    }

    public GResourceInfo(Integer r100, Integer r101, Long r102, List<GResourceDownloadInfo> r103, String r104, List<String> r105) {
        this.resourceStatus = r100;
        this.resourceType = r101;
        this.resourceOnlineTime = r102;
        this.downloadList = r103;
        this.path = r104;
        this.otherPathList = r105;
    }
}
