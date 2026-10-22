package com.larus.bmhome.creative.messagecard.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001b\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016JZ\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/creative/messagecard/bean/CreationInfo;", "Ljava/io/Serializable;", "layoutType", "", "taskGroupId", "", "taskInfo", "", "Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "supportVersion", "needRefreshCreationContent", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "()Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/creative/messagecard/bean/CreationInfo;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationInfo implements Serializable {

    @SerializedName("layout_type")
    public final Integer layoutType;

    @SerializedName("need_refresh_creation_content")
    public final Boolean needRefreshCreationContent;

    @SerializedName("support_version")
    public final String supportVersion;

    @SerializedName("task_group_id")
    public final String taskGroupId;

    @SerializedName("task_info")
    public final Map<String, CreationTask> taskInfo;

    public CreationInfo() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationInfo copy$default(CreationInfo r100, Integer r101, String r102, Map r103, String r104, Boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.layoutType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.taskGroupId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.taskInfo;
    L11:
        Map r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.supportVersion;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.needRefreshCreationContent;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.layoutType;
    }

    public final String component2() {
        return this.taskGroupId;
    }

    public final Map<String, CreationTask> component3() {
        return this.taskInfo;
    }

    public final String component4() {
        return this.supportVersion;
    }

    public final Boolean component5() {
        return this.needRefreshCreationContent;
    }

    public final CreationInfo copy(@CreationMsgLayoutType Integer r100, String r101, Map<String, CreationTask> r110, String r111, Boolean r112) {
        return new CreationInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationInfo) == true) goto L8;
        return false;
    L8:
        CreationInfo r101 = (CreationInfo) r100;
        if (Intrinsics.areEqual(this.layoutType, r101.layoutType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskGroupId, r101.taskGroupId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskInfo, r101.taskInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.supportVersion, r101.supportVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.needRefreshCreationContent, r101.needRefreshCreationContent) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.layoutType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.taskGroupId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, CreationTask> r107 = this.taskInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.supportVersion;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.needRefreshCreationContent;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "CreationInfo(layoutType=" + this.layoutType + ", taskGroupId=" + this.taskGroupId + ", taskInfo=" + this.taskInfo + ", supportVersion=" + this.supportVersion + ", needRefreshCreationContent=" + this.needRefreshCreationContent + ')';
    }

    public CreationInfo(@CreationMsgLayoutType Integer r100, String r101, Map<String, CreationTask> r102, String r103, Boolean r104) {
        this.layoutType = r100;
        this.taskGroupId = r101;
        this.taskInfo = r102;
        this.supportVersion = r103;
        this.needRefreshCreationContent = r104;
    }

    public /* synthetic */ CreationInfo(Integer r100, String r101, Map r102, String r103, Boolean r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = -1;
    L5:
        Boolean r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        Map r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        String r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
