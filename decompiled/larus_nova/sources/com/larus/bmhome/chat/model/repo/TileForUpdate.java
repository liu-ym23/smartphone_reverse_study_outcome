package com.larus.bmhome.chat.model.repo;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/TileForUpdate;", "", "id", "", "type", "", "noticeEnabledValue", "", "noticePermissionValue", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNoticeEnabledValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNoticePermissionValue", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/model/repo/TileForUpdate;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TileForUpdate {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f307757id;

    @SerializedName("notice_enabled_value")
    private final Boolean noticeEnabledValue;

    @SerializedName("notice_permission_value")
    private final Boolean noticePermissionValue;

    @SerializedName("type")
    private final Integer type;

    public TileForUpdate() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TileForUpdate copy$default(TileForUpdate r100, String r101, Integer r102, Boolean r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f307757id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.noticeEnabledValue;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.noticePermissionValue;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f307757id;
    }

    public final Integer component2() {
        return this.type;
    }

    public final Boolean component3() {
        return this.noticeEnabledValue;
    }

    public final Boolean component4() {
        return this.noticePermissionValue;
    }

    public final TileForUpdate copy(String r100, Integer r101, Boolean r102, Boolean r103) {
        return new TileForUpdate(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TileForUpdate) == true) goto L8;
        return false;
    L8:
        TileForUpdate r101 = (TileForUpdate) r100;
        if (Intrinsics.areEqual(this.f307757id, r101.f307757id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.noticeEnabledValue, r101.noticeEnabledValue) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.noticePermissionValue, r101.noticePermissionValue) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.f307757id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.type;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.noticeEnabledValue;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.noticePermissionValue;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "TileForUpdate(id=" + this.f307757id + ", type=" + this.type + ", noticeEnabledValue=" + this.noticeEnabledValue + ", noticePermissionValue=" + this.noticePermissionValue + ')';
    }

    public final String getId() {
        return this.f307757id;
    }

    public final Boolean getNoticeEnabledValue() {
        return this.noticeEnabledValue;
    }

    public final Boolean getNoticePermissionValue() {
        return this.noticePermissionValue;
    }

    public final Integer getType() {
        return this.type;
    }

    public TileForUpdate(String r100, Integer r101, Boolean r102, Boolean r103) {
        this.f307757id = r100;
        this.type = r101;
        this.noticeEnabledValue = r102;
        this.noticePermissionValue = r103;
    }

    public /* synthetic */ TileForUpdate(String r100, Integer r101, Boolean r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
