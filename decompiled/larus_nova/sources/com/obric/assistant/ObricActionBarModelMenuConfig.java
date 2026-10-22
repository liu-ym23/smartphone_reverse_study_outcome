package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J:\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/ObricActionBarModelMenuConfig;", "", "enable", "", "blockedItemIds", "", "", "defaultStatus", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBlockedItemIds", "()Ljava/util/List;", "getDefaultStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;)Lcom/obric/assistant/ObricActionBarModelMenuConfig;", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarModelMenuConfig {

    @SerializedName("blocked_item_ids")
    private final List<Integer> blockedItemIds;

    @SerializedName("default_status")
    private final Integer defaultStatus;

    @SerializedName("enable")
    private final Boolean enable;

    public ObricActionBarModelMenuConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricActionBarModelMenuConfig copy$default(ObricActionBarModelMenuConfig r100, Boolean r101, List r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.blockedItemIds;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.defaultStatus;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final List<Integer> component2() {
        return this.blockedItemIds;
    }

    public final Integer component3() {
        return this.defaultStatus;
    }

    public final ObricActionBarModelMenuConfig copy(Boolean r100, List<Integer> r101, Integer r102) {
        return new ObricActionBarModelMenuConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricActionBarModelMenuConfig) == true) goto L8;
        return false;
    L8:
        ObricActionBarModelMenuConfig r101 = (ObricActionBarModelMenuConfig) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockedItemIds, r101.blockedItemIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultStatus, r101.defaultStatus) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.blockedItemIds;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.defaultStatus;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricActionBarModelMenuConfig(enable=" + this.enable + ", blockedItemIds=" + this.blockedItemIds + ", defaultStatus=" + this.defaultStatus + ')';
    }

    public final List<Integer> getBlockedItemIds() {
        return this.blockedItemIds;
    }

    public final Integer getDefaultStatus() {
        return this.defaultStatus;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public ObricActionBarModelMenuConfig(Boolean r100, List<Integer> r101, Integer r102) {
        this.enable = r100;
        this.blockedItemIds = r101;
        this.defaultStatus = r102;
    }

    public /* synthetic */ ObricActionBarModelMenuConfig(Boolean r100, List r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
