package com.larus.bmhome.creative.messagecard.bean;

import com.facebook.common.util.UriUtil;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.im.bean.message.CreationTaskType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B`\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000f\b\u0002\u0010\n\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0017\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u000bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rHÆ\u0003Jg\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\u000f\b\u0002\u0010\n\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\n\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u000b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "Ljava/io/Serializable;", "id", "", "status", "", "loadingInfo", "Lcom/larus/bmhome/creative/messagecard/bean/LoadingInfo;", "index", "taskType", "loadingAssetType", "Lcom/larus/bmhome/creative/messagecard/bean/CreationAssetType;", UriUtil.LOCAL_ASSET_SCHEME, "Lcom/larus/bmhome/creative/messagecard/bean/CreationAsset;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/creative/messagecard/bean/LoadingInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/creative/messagecard/bean/CreationAsset;)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/creative/messagecard/bean/LoadingInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/creative/messagecard/bean/CreationAsset;)Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationTask implements Serializable {

    @SerializedName(UriUtil.LOCAL_ASSET_SCHEME)
    public final CreationAsset asset;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public final String f310760id;

    @SerializedName("index")
    public final Integer index;

    @SerializedName("asset_type")
    public final Integer loadingAssetType;

    @SerializedName("loading_info")
    public final LoadingInfo loadingInfo;

    @SerializedName("status")
    public final Integer status;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    public final Integer taskType;

    public CreationTask() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ CreationTask copy$default(CreationTask r100, String r101, Integer r102, LoadingInfo r103, Integer r104, Integer r110, Integer r111, CreationAsset r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.f310760id;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.status;
    L8:
        Integer r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.loadingInfo;
    L11:
        LoadingInfo r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.index;
    L14:
        Integer r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.taskType;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.loadingAssetType;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.asset;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.f310760id;
    }

    public final Integer component2() {
        return this.status;
    }

    public final LoadingInfo component3() {
        return this.loadingInfo;
    }

    public final Integer component4() {
        return this.index;
    }

    public final Integer component5() {
        return this.taskType;
    }

    public final Integer component6() {
        return this.loadingAssetType;
    }

    public final CreationAsset component7() {
        return this.asset;
    }

    public final CreationTask copy(String r110, @CreationTaskStatus Integer r111, LoadingInfo r112, Integer r113, @CreationTaskType Integer r114, Integer r115, CreationAsset r116) {
        return new CreationTask(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationTask) == true) goto L8;
        return false;
    L8:
        CreationTask r101 = (CreationTask) r100;
        if (Intrinsics.areEqual(this.f310760id, r101.f310760id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.loadingInfo, r101.loadingInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.taskType, r101.taskType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.loadingAssetType, r101.loadingAssetType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.asset, r101.asset) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.f310760id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.status;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        LoadingInfo r107 = this.loadingInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.index;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.taskType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.loadingAssetType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        CreationAsset r119 = this.asset;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationTask(id=" + this.f310760id + ", status=" + this.status + ", loadingInfo=" + this.loadingInfo + ", index=" + this.index + ", taskType=" + this.taskType + ", loadingAssetType=" + this.loadingAssetType + ", asset=" + this.asset + ')';
    }

    public CreationTask(String r100, @CreationTaskStatus Integer r101, LoadingInfo r102, Integer r103, @CreationTaskType Integer r104, Integer r105, CreationAsset r106) {
        this.f310760id = r100;
        this.status = r101;
        this.loadingInfo = r102;
        this.index = r103;
        this.taskType = r104;
        this.loadingAssetType = r105;
        this.asset = r106;
    }

    public /* synthetic */ CreationTask(String r100, Integer r101, LoadingInfo r102, Integer r110, Integer r111, Integer r112, CreationAsset r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Integer r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        LoadingInfo r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Integer r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        CreationAsset r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
